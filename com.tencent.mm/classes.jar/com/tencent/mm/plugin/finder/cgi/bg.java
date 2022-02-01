package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.view.convert.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiUtil;", "", "()V", "collectCgiInfo", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "collectRVFeedInfo", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "debugDesc", "debugMediaId", "debugType", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
{
  public static final bg ABl;
  
  static
  {
    AppMethodBeat.i(165182);
    ABl = new bg();
    AppMethodBeat.o(165182);
  }
  
  public static String c(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(336493);
    s.u(paramFinderObject, "<this>");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336493);
      return "";
    }
    paramFinderObject = paramFinderObject.media;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336493);
      return "";
    }
    paramFinderObject = (FinderMedia)p.ae((List)paramFinderObject, 0);
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336493);
      return "";
    }
    paramFinderObject = paramFinderObject.url;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336493);
      return "";
    }
    paramFinderObject = MD5Util.getMD5String(paramFinderObject);
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336493);
      return "";
    }
    AppMethodBeat.o(336493);
    return paramFinderObject;
  }
  
  private static String d(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(336498);
    s.u(paramFinderObject, "<this>");
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336498);
      return "";
    }
    paramFinderObject = paramFinderObject.description;
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336498);
      return "";
    }
    paramFinderObject = paramFinderObject.substring(0, Math.min(paramFinderObject.length(), 7));
    s.s(paramFinderObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(336498);
      return "";
    }
    AppMethodBeat.o(336498);
    return paramFinderObject;
  }
  
  private static String e(FinderObject paramFinderObject)
  {
    int i = -1;
    AppMethodBeat.i(336503);
    s.u(paramFinderObject, "<this>");
    Object localObject = paramFinderObject.objectDesc;
    int j;
    int k;
    if (localObject == null)
    {
      j = -1;
      localObject = paramFinderObject.objectDesc;
      if (localObject != null) {
        break label101;
      }
      k = i;
      label39:
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null) {
        break label145;
      }
      i = 0;
    }
    for (;;)
    {
      paramFinderObject = "t:" + j + ',' + k + ";s:" + i;
      AppMethodBeat.o(336503);
      return paramFinderObject;
      j = ((FinderObjectDesc)localObject).mediaType;
      break;
      label101:
      localObject = ((FinderObjectDesc)localObject).media;
      k = i;
      if (localObject == null) {
        break label39;
      }
      localObject = (FinderMedia)p.ae((List)localObject, 0);
      k = i;
      if (localObject == null) {
        break label39;
      }
      k = ((FinderMedia)localObject).mediaType;
      break label39;
      label145:
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject == null) {
        i = 0;
      } else {
        i = paramFinderObject.size();
      }
    }
  }
  
  public static String fU(List<? extends cc> paramList)
  {
    AppMethodBeat.i(336510);
    if (paramList == null)
    {
      AppMethodBeat.o(336510);
      return "null";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("count:" + paramList.size() + " \n");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = (cc)localIterator.next();
      if ((paramList instanceof BaseFinderFeed))
      {
        paramList = (BaseFinderFeed)paramList;
        StringBuilder localStringBuilder = new StringBuilder("id:").append(d.hF(paramList.feedObject.getId())).append(" nick:").append(paramList.feedObject.getNickName()).append(" livestate:");
        paramList = paramList.feedObject.getLiveInfo();
        if (paramList == null) {}
        for (paramList = null;; paramList = Integer.valueOf(paramList.liveStatus))
        {
          localStringBuffer.append(paramList + " \n");
          break;
        }
      }
      localStringBuffer.append(paramList + '\n');
    }
    paramList = localStringBuffer.toString();
    s.s(paramList, "stringBuffer.toString()");
    AppMethodBeat.o(336510);
    return paramList;
  }
  
  public static String fV(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(165181);
    if (paramList == null)
    {
      AppMethodBeat.o(165181);
      return "null";
    }
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append(s.X("onCgiBack: count:", Integer.valueOf(paramList.size())));
    StringBuffer localStringBuffer2 = new StringBuffer();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject1 = (FinderObject)localObject1;
      Object localObject2 = c((FinderObject)localObject1);
      Object localObject3 = d((FinderObject)localObject1);
      String str1 = e((FinderObject)localObject1);
      axn localaxn = ((FinderObject)localObject1).foldedLayout;
      if (localaxn != null)
      {
        if (localaxn.ZIQ.size() > 0)
        {
          localStringBuffer2.append(s.X("PARENT_ID:id:", d.hF(((FinderObject)localObject1).id)));
          localStringBuffer2.append("FL>>>");
        }
        Object localObject4 = localaxn.ZIQ;
        if (localObject4 != null)
        {
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject4).next();
            s.s(localFinderObject, "foldedObj");
            String str2 = c(localFinderObject);
            String str3 = d(localFinderObject);
            String str4 = e(localFinderObject);
            localStringBuffer2.append("#[id:" + d.hF(localFinderObject.id) + ",md:" + str2 + ",d:" + str3 + "] " + str4);
          }
        }
        if (localaxn.ZIQ.size() > 0) {
          localStringBuffer2.append("<<FL\n");
        }
      }
      localObject2 = new StringBuilder(";[*").append(i).append(" id:").append(d.hF(((FinderObject)localObject1).id)).append(",md:").append((String)localObject2).append(",d:").append((String)localObject3).append("] ").append(str1).append(',');
      localObject3 = a.DUC;
      localStringBuffer1.append(a.c(((FinderObject)localObject1).liveInfo));
      i += 1;
    }
    if (((CharSequence)localStringBuffer2).length() > 0) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuffer1.append(s.X("\n", localStringBuffer2));
      }
      paramList = localStringBuffer1.toString();
      s.s(paramList, "buf.toString()");
      AppMethodBeat.o(165181);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bg
 * JD-Core Version:    0.7.0.1
 */