package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiUtil;", "", "()V", "collectCgiInfo", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "debugDesc", "debugMediaId", "debugType", "plugin-finder_release"})
public final class u
{
  public static final u rRa;
  
  static
  {
    AppMethodBeat.i(165182);
    rRa = new u();
    AppMethodBeat.o(165182);
  }
  
  private static String a(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201506);
    p.h(paramFinderObject, "$this$debugMediaId");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = (FinderMedia)j.F((List)paramFinderObject, 0);
        if (paramFinderObject != null)
        {
          paramFinderObject = paramFinderObject.url;
          if (paramFinderObject != null)
          {
            String str = aj.ej(paramFinderObject);
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
    AppMethodBeat.o(201506);
    return paramFinderObject;
  }
  
  private static String b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201507);
    p.h(paramFinderObject, "$this$debugDesc");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.description;
      if (paramFinderObject != null)
      {
        p.g(paramFinderObject, "it");
        int i = Math.min(paramFinderObject.length(), 7);
        if (paramFinderObject == null)
        {
          paramFinderObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(201507);
          throw paramFinderObject;
        }
        String str = paramFinderObject.substring(0, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramFinderObject = str;
        if (str != null) {
          break label88;
        }
      }
    }
    paramFinderObject = "";
    label88:
    AppMethodBeat.o(201507);
    return paramFinderObject;
  }
  
  private static String c(FinderObject paramFinderObject)
  {
    int k = -1;
    AppMethodBeat.i(201508);
    p.h(paramFinderObject, "$this$debugType");
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
          localObject = (FinderMedia)j.F((List)localObject, 0);
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
      AppMethodBeat.o(201508);
      return paramFinderObject;
      i = -1;
      break;
    }
  }
  
  public static String dB(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(165181);
    p.h(paramList, "list");
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("onCgiBack: count:" + paramList.size());
    StringBuffer localStringBuffer2 = new StringBuffer();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        j.gkd();
      }
      localObject1 = (FinderObject)localObject1;
      String str1 = a((FinderObject)localObject1);
      String str2 = b((FinderObject)localObject1);
      String str3 = c((FinderObject)localObject1);
      ank localank = ((FinderObject)localObject1).foldedLayout;
      if (localank != null)
      {
        if (localank.GFu.size() > 0)
        {
          localStringBuffer2.append("PARENT_ID:id:" + c.rp(((FinderObject)localObject1).id));
          localStringBuffer2.append("FL>>>");
        }
        Object localObject2 = localank.GFu;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject2).next();
            p.g(localFinderObject, "foldedObj");
            String str4 = a(localFinderObject);
            String str5 = b(localFinderObject);
            String str6 = c(localFinderObject);
            localStringBuffer2.append("#[id:" + c.rp(localFinderObject.id) + ",md:" + str4 + ",d:" + str5 + "] " + str6);
          }
        }
        if (localank.GFu.size() > 0) {
          localStringBuffer2.append("<<FL\n");
        }
      }
      localStringBuffer1.append(";[*" + i + " id:" + c.rp(((FinderObject)localObject1).id) + ",md:" + str1 + ",d:" + str2 + "] " + str3);
      i += 1;
    }
    if (((CharSequence)localStringBuffer2).length() > 0) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuffer1.append("\n" + localStringBuffer2);
      }
      paramList = localStringBuffer1.toString();
      p.g(paramList, "buf.toString()");
      AppMethodBeat.o(165181);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */