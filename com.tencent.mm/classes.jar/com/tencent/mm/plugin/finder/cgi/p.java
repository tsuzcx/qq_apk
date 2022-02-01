package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.ah;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiUtil;", "", "()V", "collectCgiInfo", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "debugDesc", "debugMediaId", "debugType", "plugin-finder_release"})
public final class p
{
  public static final p qXG;
  
  static
  {
    AppMethodBeat.i(165182);
    qXG = new p();
    AppMethodBeat.o(165182);
  }
  
  public static String a(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201148);
    k.h(paramFinderObject, "$this$debugMediaId");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = (FinderMedia)j.C((List)paramFinderObject, 0);
        if (paramFinderObject != null)
        {
          paramFinderObject = paramFinderObject.url;
          if (paramFinderObject != null)
          {
            String str = ah.dg(paramFinderObject);
            paramFinderObject = str;
            if (str != null) {
              break label68;
            }
          }
        }
      }
    }
    paramFinderObject = "";
    label68:
    AppMethodBeat.o(201148);
    return paramFinderObject;
  }
  
  private static String b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201149);
    k.h(paramFinderObject, "$this$debugDesc");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.description;
      if (paramFinderObject != null)
      {
        int i = Math.min(paramFinderObject.length(), 3);
        if (paramFinderObject == null)
        {
          paramFinderObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(201149);
          throw paramFinderObject;
        }
        String str = paramFinderObject.substring(0, i);
        k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramFinderObject = str;
        if (str != null) {
          break label81;
        }
      }
    }
    paramFinderObject = "";
    label81:
    AppMethodBeat.o(201149);
    return paramFinderObject;
  }
  
  private static String c(FinderObject paramFinderObject)
  {
    int k = -1;
    AppMethodBeat.i(201150);
    k.h(paramFinderObject, "$this$debugType");
    Object localObject = paramFinderObject.objectDesc;
    int i;
    int j;
    if (localObject != null)
    {
      i = ((FinderObjectDesc)localObject).mediaType;
      localObject = paramFinderObject.objectDesc;
      j = k;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        j = k;
        if (localObject != null)
        {
          localObject = (FinderMedia)j.C((List)localObject, 0);
          j = k;
          if (localObject != null) {
            j = ((FinderMedia)localObject).mediaType;
          }
        }
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject == null) {
        break label154;
      }
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject == null) {
        break label154;
      }
    }
    label154:
    for (k = paramFinderObject.size();; k = 0)
    {
      paramFinderObject = "t:" + i + ',' + j + ";s:" + k;
      AppMethodBeat.o(201150);
      return paramFinderObject;
      i = -1;
      break;
    }
  }
  
  public static String dw(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(165181);
    k.h(paramList, "list");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("onCgiBack: count:" + paramList.size());
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      FinderObject localFinderObject1 = (FinderObject)paramList.next();
      String str1 = a(localFinderObject1);
      String str2 = b(localFinderObject1);
      String str3 = c(localFinderObject1);
      ajz localajz = localFinderObject1.foldedLayout;
      if (localajz != null)
      {
        if (localajz.EEw.size() > 0) {
          localStringBuffer.append("FL>>>");
        }
        Object localObject = localajz.EEw;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FinderObject localFinderObject2 = (FinderObject)((Iterator)localObject).next();
            k.g(localFinderObject2, "foldedObj");
            String str4 = a(localFinderObject2);
            String str5 = b(localFinderObject2);
            String str6 = c(localFinderObject2);
            localStringBuffer.append("#[id:" + c.pb(localFinderObject2.id) + ",md:" + str4 + ",d:" + str5 + "] " + str6);
          }
        }
        if (localajz.EEw.size() > 0) {
          localStringBuffer.append("<<FL");
        }
      }
      localStringBuffer.append(";[id:" + c.pb(localFinderObject1.id) + ",md:" + str1 + ",d:" + str2 + "] " + str3);
    }
    paramList = localStringBuffer.toString();
    k.g(paramList, "buf.toString()");
    AppMethodBeat.o(165181);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.p
 * JD-Core Version:    0.7.0.1
 */