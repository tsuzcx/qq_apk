package com.tencent.mm.plugin.finder.storage.data;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "mediaSize", "Landroid/util/Size;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isFullscreen", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Ljava/util/LinkedList;", "toLongVideoLocal", "plugin-finder-base_release"})
public final class i
{
  private static final h<String, String> Anm;
  
  static
  {
    AppMethodBeat.i(167065);
    Anm = new h(200);
    AppMethodBeat.o(167065);
  }
  
  public static final Size a(csg paramcsg, boolean paramBoolean)
  {
    AppMethodBeat.i(263442);
    p.k(paramcsg, "$this$mediaSize");
    if (!paramBoolean)
    {
      awc localawc = paramcsg.TAa;
      if ((localawc != null) && (localawc.right > localawc.left) && (localawc.bottom > localawc.top))
      {
        paramcsg = new Size(a.dm(localawc.right - localawc.left), a.dm(localawc.bottom - localawc.top));
        AppMethodBeat.o(263442);
        return paramcsg;
      }
    }
    paramcsg = new Size((int)paramcsg.width, (int)paramcsg.height);
    AppMethodBeat.o(263442);
    return paramcsg;
  }
  
  public static final csg a(cwq paramcwq)
  {
    AppMethodBeat.i(263439);
    p.k(paramcwq, "$this$toLocal");
    csg localcsg = new csg();
    localcsg.url = paramcwq.url;
    localcsg.mediaType = 4;
    localcsg.thumbUrl = paramcwq.thumbUrl;
    localcsg.videoDuration = paramcwq.TFq;
    if (paramcwq.TFr == 0L) {
      localcsg.TzW = (paramcwq.TFq * 1000L);
    }
    for (;;)
    {
      Object localObject2 = new aa.f();
      x localx;
      synchronized (Anm)
      {
        ((aa.f)localObject2).aaBC = ((String)Anm.get(paramcwq.url));
        localx = x.aazN;
        if ((String)((aa.f)localObject2).aaBC == null)
        {
          if (paramcwq.url != null) {
            break label328;
          }
          ??? = "";
          ((aa.f)localObject2).aaBC = ???;
        }
      }
      synchronized (Anm)
      {
        Anm.q(paramcwq.url, (String)((aa.f)localObject2).aaBC);
        localx = x.aazN;
        localcsg.TzR = 3;
        localcsg.mediaId = ((String)((aa.f)localObject2).aaBC);
        localcsg.width = paramcwq.width;
        localcsg.height = paramcwq.height;
        localcsg.md5sum = paramcwq.md5sum;
        localcsg.fileSize = paramcwq.fileSize;
        localcsg.bitrate = paramcwq.bitrate;
        ??? = paramcwq.TFu;
        if (??? != null)
        {
          localObject2 = ((bec)???).SPl;
          ??? = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          ??? = new LinkedList();
        }
        localcsg.spec = ((LinkedList)???);
        localcsg.decodeKey = paramcwq.decodeKey;
        localcsg.coverUrl = paramcwq.coverUrl;
        localcsg.url_token = paramcwq.zZu;
        localcsg.cover_url_token = paramcwq.TFs;
        localcsg.thumb_url_token = paramcwq.MSC;
        localcsg.hot_flag = paramcwq.hot_flag;
        AppMethodBeat.o(263439);
        return localcsg;
        localcsg.TzW = paramcwq.TFr;
        continue;
        paramcwq = finally;
        AppMethodBeat.o(263439);
        throw paramcwq;
        label328:
        ??? = MD5Util.getMD5String(Util.nullAs(paramcwq.url, ""));
      }
    }
  }
  
  public static final LinkedList<csg> aR(LinkedList<FinderMedia> paramLinkedList)
  {
    AppMethodBeat.i(167063);
    p.k(paramLinkedList, "$this$toLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(c((FinderMedia)paramLinkedList.next()));
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
  
  public static final LinkedList<csg> aS(LinkedList<cwq> paramLinkedList)
  {
    AppMethodBeat.i(263441);
    p.k(paramLinkedList, "$this$toLongVideoLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      if (i < 0) {
        j.iBO();
      }
      localLinkedList.add(a((cwq)localObject));
      i += 1;
    }
    AppMethodBeat.o(263441);
    return localLinkedList;
  }
  
  public static final csg c(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    p.k(paramFinderMedia, "$this$toLocal");
    csg localcsg = new csg();
    localcsg.url = paramFinderMedia.url;
    localcsg.thumbUrl = paramFinderMedia.thumbUrl;
    localcsg.mediaType = paramFinderMedia.mediaType;
    localcsg.videoDuration = paramFinderMedia.videoDuration;
    localcsg.width = paramFinderMedia.width;
    localcsg.height = paramFinderMedia.height;
    localcsg.md5sum = paramFinderMedia.md5sum;
    localcsg.fileSize = paramFinderMedia.fileSize;
    localcsg.bitrate = paramFinderMedia.bitrate;
    Object localObject2 = new aa.f();
    for (;;)
    {
      Object localObject3;
      synchronized (Anm)
      {
        ((aa.f)localObject2).aaBC = ((String)Anm.get(paramFinderMedia.url));
        localObject3 = x.aazN;
        if ((String)((aa.f)localObject2).aaBC == null)
        {
          if (paramFinderMedia.url != null) {
            break label393;
          }
          ??? = "";
          ((aa.f)localObject2).aaBC = ???;
        }
      }
      synchronized (Anm)
      {
        Anm.q(paramFinderMedia.url, (String)((aa.f)localObject2).aaBC);
        localObject3 = x.aazN;
        localcsg.mediaId = ((String)((aa.f)localObject2).aaBC);
        ??? = paramFinderMedia.half_rect;
        if (??? != null)
        {
          localObject2 = new css();
          localObject3 = new fbq();
          ((fbq)localObject3).left = ((int)((awc)???).left);
          ((fbq)localObject3).top = ((int)((awc)???).top);
          ((fbq)localObject3).right = ((int)((awc)???).right);
          ((fbq)localObject3).bottom = ((int)((awc)???).bottom);
          ((css)localObject2).TAv = ((fbq)localObject3);
          localcsg.zBo = ((css)localObject2);
        }
        localcsg.TzW = (paramFinderMedia.videoDuration * 1000L);
        localcsg.spec = paramFinderMedia.spec;
        localcsg.coverUrl = paramFinderMedia.coverUrl;
        localcsg.decodeKey = paramFinderMedia.decodeKey;
        localcsg.hot_flag = paramFinderMedia.hot_flag;
        localcsg.url_token = paramFinderMedia.url_token;
        localcsg.thumb_url_token = paramFinderMedia.thumb_url_token;
        localcsg.cover_url_token = paramFinderMedia.cover_url_token;
        localcsg.codec_info = paramFinderMedia.codec_info;
        localcsg.TzX = paramFinderMedia.full_thumb_url;
        localcsg.TzY = paramFinderMedia.full_thumb_url_token;
        localcsg.TAa = paramFinderMedia.half_rect;
        AppMethodBeat.o(167064);
        return localcsg;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label393:
        ??? = MD5Util.getMD5String(Util.nullAs(paramFinderMedia.url, ""));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */