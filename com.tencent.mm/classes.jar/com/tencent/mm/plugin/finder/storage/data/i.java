package com.tencent.mm.plugin.finder.storage.data;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "mediaSize", "Landroid/util/Size;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isFullscreen", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoteMediaInfo;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Ljava/util/LinkedList;", "toLongVideoLocal", "plugin-finder-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final h<String, String> FNe;
  
  static
  {
    AppMethodBeat.i(167065);
    FNe = new h(200);
    AppMethodBeat.o(167065);
  }
  
  public static final Size a(dji paramdji, boolean paramBoolean)
  {
    AppMethodBeat.i(339370);
    s.u(paramdji, "<this>");
    if (!paramBoolean)
    {
      bbn localbbn = paramdji.aaPl;
      if ((localbbn != null) && (localbbn.right > localbbn.left) && (localbbn.bottom > localbbn.top))
      {
        paramdji = new Size(a.eH(localbbn.right - localbbn.left), a.eH(localbbn.bottom - localbbn.top));
        AppMethodBeat.o(339370);
        return paramdji;
      }
    }
    paramdji = new Size((int)paramdji.width, (int)paramdji.height);
    AppMethodBeat.o(339370);
    return paramdji;
  }
  
  public static final dji a(bue parambue)
  {
    AppMethodBeat.i(339354);
    s.u(parambue, "<this>");
    dji localdji = new dji();
    localdji.url = parambue.mediaUrl;
    localdji.aaPd = parambue.mediaUrl;
    localdji.thumbUrl = parambue.thumbUrl;
    localdji.aaPe = parambue.thumbUrl;
    localdji.coverUrl = parambue.coverUrl;
    localdji.aaPg = parambue.coverUrl;
    localdji.fileSize = parambue.fileSize;
    localdji.bitrate = parambue.bitrate;
    localdji.width = parambue.mediaWidth;
    localdji.height = parambue.mediaHeight;
    localdji.videoDuration = parambue.duration;
    localdji.aaPh = (parambue.duration * 1000L);
    localdji.full_url = parambue.mediaUrl;
    localdji.aaPm = parambue.mediaUrl;
    localdji.aaPi = parambue.thumbUrl;
    localdji.aaPk = parambue.thumbUrl;
    localdji.full_file_size = parambue.fileSize;
    localdji.full_bitrate = parambue.bitrate;
    localdji.full_width = parambue.mediaWidth;
    localdji.full_height = parambue.mediaHeight;
    localdji.mediaId = MD5Util.getMD5String(Util.nullAs(localdji.url, ""));
    localdji.mediaType = 4;
    AppMethodBeat.o(339354);
    return localdji;
  }
  
  public static final dji a(dnv paramdnv)
  {
    AppMethodBeat.i(339359);
    s.u(paramdnv, "<this>");
    dji localdji = new dji();
    localdji.url = paramdnv.url;
    localdji.mediaType = 4;
    localdji.thumbUrl = paramdnv.thumbUrl;
    localdji.videoDuration = paramdnv.aaUX;
    if (paramdnv.aaUY == 0L) {
      localdji.aaPh = (paramdnv.aaUX * 1000L);
    }
    for (;;)
    {
      ah localah;
      synchronized (FNe)
      {
        ??? = FNe.get(paramdnv.url);
        localah = ah.aiuX;
        ??? = ???;
        if (??? == null)
        {
          if (paramdnv.url != null) {
            break label361;
          }
          ??? = "";
        }
      }
      synchronized (FNe)
      {
        FNe.B(paramdnv.url, ???);
        localah = ah.aiuX;
        localdji.aaPc = 3;
        localdji.mediaId = ((String)???);
        localdji.width = paramdnv.width;
        localdji.height = paramdnv.height;
        localdji.md5sum = paramdnv.md5sum;
        localdji.fileSize = paramdnv.fileSize;
        localdji.bitrate = paramdnv.bitrate;
        ??? = paramdnv.aaVb;
        if (??? == null)
        {
          ??? = null;
          ??? = ???;
          if (??? == null) {
            ??? = new LinkedList();
          }
          localdji.spec = ((LinkedList)???);
          localdji.decodeKey = paramdnv.decodeKey;
          localdji.HaI = paramdnv.HaI;
          localdji.coverUrl = paramdnv.coverUrl;
          localdji.url_token = paramdnv.msf;
          localdji.cover_url_token = paramdnv.aaUZ;
          localdji.thumb_url_token = paramdnv.msh;
          localdji.hot_flag = paramdnv.hot_flag;
          ??? = paramdnv.aaVa;
          if (??? != null)
          {
            ??? = ((bbq)???).ZMj;
            if (??? != null) {
              localdji.aaPr.addAll((Collection)???);
            }
          }
          paramdnv = paramdnv.hdr_spec;
          if (paramdnv != null)
          {
            paramdnv = paramdnv.ZMf;
            if (paramdnv != null) {
              localdji.aaPs.addAll((Collection)paramdnv);
            }
          }
          AppMethodBeat.o(339359);
          return localdji;
          localdji.aaPh = paramdnv.aaUY;
          continue;
          paramdnv = finally;
          AppMethodBeat.o(339359);
          throw paramdnv;
          label361:
          ??? = MD5Util.getMD5String(Util.nullAs(paramdnv.url, ""));
        }
      }
    }
  }
  
  public static final LinkedList<dji> aY(LinkedList<FinderMedia> paramLinkedList)
  {
    AppMethodBeat.i(167063);
    s.u(paramLinkedList, "<this>");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(c((FinderMedia)paramLinkedList.next()));
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
  
  public static final LinkedList<dji> aZ(LinkedList<dnv> paramLinkedList)
  {
    AppMethodBeat.i(339363);
    s.u(paramLinkedList, "<this>");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      if (i < 0) {
        p.kkW();
      }
      localLinkedList.add(a((dnv)localObject));
      i += 1;
    }
    AppMethodBeat.o(339363);
    return localLinkedList;
  }
  
  public static final dji c(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    s.u(paramFinderMedia, "<this>");
    dji localdji = new dji();
    localdji.url = paramFinderMedia.url;
    localdji.thumbUrl = paramFinderMedia.thumbUrl;
    localdji.mediaType = paramFinderMedia.mediaType;
    localdji.videoDuration = paramFinderMedia.videoDuration;
    localdji.width = paramFinderMedia.width;
    localdji.height = paramFinderMedia.height;
    localdji.md5sum = paramFinderMedia.md5sum;
    localdji.fileSize = paramFinderMedia.fileSize;
    localdji.bitrate = paramFinderMedia.bitrate;
    Object localObject3;
    synchronized (FNe)
    {
      ??? = FNe.get(paramFinderMedia.url);
      localObject3 = ah.aiuX;
      ??? = ???;
      if (??? == null)
      {
        if (paramFinderMedia.url != null) {
          break label438;
        }
        ??? = "";
      }
    }
    synchronized (FNe)
    {
      FNe.B(paramFinderMedia.url, ???);
      localObject3 = ah.aiuX;
      localdji.mediaId = ((String)???);
      localObject3 = paramFinderMedia.half_rect;
      if (localObject3 != null)
      {
        ??? = new dju();
        ??? = new fyb();
        ((fyb)???).left = ((int)((bbn)localObject3).left);
        ((fyb)???).top = ((int)((bbn)localObject3).top);
        ((fyb)???).right = ((int)((bbn)localObject3).right);
        ((fyb)???).bottom = ((int)((bbn)localObject3).bottom);
        localObject3 = ah.aiuX;
        ((dju)???).aaPJ = ((fyb)???);
        ??? = ah.aiuX;
        localdji.EDC = ((dju)???);
      }
      localdji.aaPh = (paramFinderMedia.videoDuration * 1000L);
      localdji.spec = paramFinderMedia.spec;
      localdji.coverUrl = paramFinderMedia.coverUrl;
      localdji.HaI = paramFinderMedia.full_cover_url;
      localdji.decodeKey = paramFinderMedia.decodeKey;
      localdji.hot_flag = paramFinderMedia.hot_flag;
      localdji.url_token = paramFinderMedia.url_token;
      localdji.thumb_url_token = paramFinderMedia.thumb_url_token;
      localdji.cover_url_token = paramFinderMedia.cover_url_token;
      localdji.codec_info = paramFinderMedia.codec_info;
      localdji.aaPi = paramFinderMedia.full_thumb_url;
      localdji.aaPj = paramFinderMedia.full_thumb_url_token;
      localdji.aaPl = paramFinderMedia.half_rect;
      ??? = paramFinderMedia.hls_spec;
      if (??? != null)
      {
        ??? = ((bbq)???).ZMj;
        if (??? != null) {
          localdji.aaPr.addAll((Collection)???);
        }
      }
      paramFinderMedia = paramFinderMedia.hdr_spec;
      if (paramFinderMedia != null)
      {
        paramFinderMedia = paramFinderMedia.ZMf;
        if (paramFinderMedia != null) {
          localdji.aaPs.addAll((Collection)paramFinderMedia);
        }
      }
      AppMethodBeat.o(167064);
      return localdji;
      paramFinderMedia = finally;
      AppMethodBeat.o(167064);
      throw paramFinderMedia;
      label438:
      ??? = MD5Util.getMD5String(Util.nullAs(paramFinderMedia.url, ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */