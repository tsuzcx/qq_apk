package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiUtil;", "", "()V", "collectCgiInfo", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "collectRVFeedInfo", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "debugDesc", "debugMediaId", "debugType", "plugin-finder-base_release"})
public final class am
{
  public static final am xch;
  
  static
  {
    AppMethodBeat.i(165182);
    xch = new am();
    AppMethodBeat.o(165182);
  }
  
  public static String a(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(262716);
    p.k(paramFinderObject, "$this$debugMediaId");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = (FinderMedia)j.M((List)paramFinderObject, 0);
        if (paramFinderObject != null)
        {
          paramFinderObject = paramFinderObject.url;
          if (paramFinderObject != null)
          {
            String str = MD5Util.getMD5String(paramFinderObject);
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
    AppMethodBeat.o(262716);
    return paramFinderObject;
  }
  
  private static String b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(262721);
    p.k(paramFinderObject, "$this$debugDesc");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.description;
      if (paramFinderObject != null)
      {
        p.j(paramFinderObject, "it");
        int i = Math.min(paramFinderObject.length(), 7);
        if (paramFinderObject == null)
        {
          paramFinderObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(262721);
          throw paramFinderObject;
        }
        String str = paramFinderObject.substring(0, i);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramFinderObject = str;
        if (str != null) {
          break label88;
        }
      }
    }
    paramFinderObject = "";
    label88:
    AppMethodBeat.o(262721);
    return paramFinderObject;
  }
  
  private static String c(FinderObject paramFinderObject)
  {
    int k = -1;
    AppMethodBeat.i(262724);
    p.k(paramFinderObject, "$this$debugType");
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
          localObject = (FinderMedia)j.M((List)localObject, 0);
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
      AppMethodBeat.o(262724);
      return paramFinderObject;
      i = -1;
      break;
    }
  }
  
  public static String dX(List<? extends bu> paramList)
  {
    AppMethodBeat.i(262729);
    if (paramList == null)
    {
      AppMethodBeat.o(262729);
      return "null";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("count:" + paramList.size() + " \n");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = (bu)localIterator.next();
      if ((paramList instanceof BaseFinderFeed))
      {
        paramList = (BaseFinderFeed)paramList;
        StringBuilder localStringBuilder = new StringBuilder("id:").append(paramList.feedObject.getId()).append(" nick:").append(paramList.feedObject.getNickName()).append(" livestate:");
        paramList = paramList.feedObject.getLiveInfo();
        if (paramList != null) {}
        for (paramList = Integer.valueOf(paramList.liveStatus);; paramList = null)
        {
          localStringBuffer.append(paramList + " \n");
          break;
        }
      }
      localStringBuffer.append(paramList.toString() + "\n");
    }
    paramList = localStringBuffer.toString();
    p.j(paramList, "stringBuffer.toString()");
    AppMethodBeat.o(262729);
    return paramList;
  }
  
  public static String dY(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(165181);
    if (paramList == null)
    {
      AppMethodBeat.o(165181);
      return "null";
    }
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("onCgiBack: count:" + paramList.size());
    StringBuffer localStringBuffer2 = new StringBuffer();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (FinderObject)localObject1;
      String str1 = a((FinderObject)localObject1);
      String str2 = b((FinderObject)localObject1);
      String str3 = c((FinderObject)localObject1);
      asz localasz = ((FinderObject)localObject1).foldedLayout;
      if (localasz != null)
      {
        if (localasz.SGi.size() > 0)
        {
          localStringBuffer2.append("PARENT_ID:id:" + d.Fw(((FinderObject)localObject1).id));
          localStringBuffer2.append("FL>>>");
        }
        Object localObject2 = localasz.SGi;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject2).next();
            p.j(localFinderObject, "foldedObj");
            String str4 = a(localFinderObject);
            String str5 = b(localFinderObject);
            String str6 = c(localFinderObject);
            localStringBuffer2.append("#[id:" + d.Fw(localFinderObject.id) + ",md:" + str4 + ",d:" + str5 + "] " + str6);
          }
        }
        if (localasz.SGi.size() > 0) {
          localStringBuffer2.append("<<FL\n");
        }
      }
      localStringBuffer1.append(";[*" + i + " id:" + d.Fw(((FinderObject)localObject1).id) + ",md:" + str1 + ",d:" + str2 + "] " + str3);
      i += 1;
    }
    if (((CharSequence)localStringBuffer2).length() > 0) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuffer1.append("\n" + localStringBuffer2);
      }
      paramList = localStringBuffer1.toString();
      p.j(paramList, "buf.toString()");
      AppMethodBeat.o(165181);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */