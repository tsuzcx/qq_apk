package com.tencent.mm.plugin.finder.storage.data;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.h.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "mediaSize", "Landroid/util/Size;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isFullscreen", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Ljava/util/LinkedList;", "toLongVideoLocal", "plugin-finder_release"})
public final class j
{
  private static final h<String, String> vGp;
  
  static
  {
    AppMethodBeat.i(167065);
    vGp = new h(200);
    AppMethodBeat.o(167065);
  }
  
  public static final Size a(cjl paramcjl, boolean paramBoolean)
  {
    AppMethodBeat.i(252007);
    p.h(paramcjl, "$this$mediaSize");
    if (!paramBoolean)
    {
      aty localaty = paramcjl.MoU;
      if ((localaty != null) && (localaty.right > localaty.left) && (localaty.bottom > localaty.top))
      {
        paramcjl = new Size(a.cR(localaty.right - localaty.left), a.cR(localaty.bottom - localaty.top));
        AppMethodBeat.o(252007);
        return paramcjl;
      }
    }
    paramcjl = new Size((int)paramcjl.width, (int)paramcjl.height);
    AppMethodBeat.o(252007);
    return paramcjl;
  }
  
  public static final cjl a(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    p.h(paramFinderMedia, "$this$toLocal");
    cjl localcjl = new cjl();
    localcjl.url = paramFinderMedia.url;
    localcjl.thumbUrl = paramFinderMedia.thumbUrl;
    localcjl.mediaType = paramFinderMedia.mediaType;
    localcjl.videoDuration = paramFinderMedia.videoDuration;
    localcjl.width = paramFinderMedia.width;
    localcjl.height = paramFinderMedia.height;
    localcjl.md5sum = paramFinderMedia.md5sum;
    localcjl.fileSize = paramFinderMedia.fileSize;
    localcjl.bitrate = paramFinderMedia.bitrate;
    Object localObject2 = new z.f();
    for (;;)
    {
      Object localObject3;
      synchronized (vGp)
      {
        ((z.f)localObject2).SYG = ((String)vGp.get(paramFinderMedia.url));
        localObject3 = x.SXb;
        if ((String)((z.f)localObject2).SYG == null)
        {
          if (paramFinderMedia.url != null) {
            break label390;
          }
          ??? = "";
          ((z.f)localObject2).SYG = ???;
        }
      }
      synchronized (vGp)
      {
        vGp.x(paramFinderMedia.url, (String)((z.f)localObject2).SYG);
        localObject3 = x.SXb;
        localcjl.mediaId = ((String)((z.f)localObject2).SYG);
        ??? = paramFinderMedia.half_rect;
        if (??? != null)
        {
          localObject2 = new cjx();
          localObject3 = new erf();
          ((erf)localObject3).left = ((int)((aty)???).left);
          ((erf)localObject3).top = ((int)((aty)???).top);
          ((erf)localObject3).right = ((int)((aty)???).right);
          ((erf)localObject3).bottom = ((int)((aty)???).bottom);
          ((cjx)localObject2).Mpq = ((erf)localObject3);
          localcjl.uOR = ((cjx)localObject2);
        }
        localcjl.MoQ = (paramFinderMedia.videoDuration * 1000L);
        localcjl.spec = paramFinderMedia.spec;
        localcjl.coverUrl = paramFinderMedia.coverUrl;
        localcjl.decodeKey = paramFinderMedia.decodeKey;
        localcjl.hot_flag = paramFinderMedia.hot_flag;
        localcjl.url_token = paramFinderMedia.url_token;
        localcjl.thumb_url_token = paramFinderMedia.thumb_url_token;
        localcjl.cover_url_token = paramFinderMedia.cover_url_token;
        localcjl.codec_info = paramFinderMedia.codec_info;
        localcjl.MoR = paramFinderMedia.full_thumb_url;
        localcjl.MoS = paramFinderMedia.full_thumb_url_token;
        localcjl.MoU = paramFinderMedia.half_rect;
        AppMethodBeat.o(167064);
        return localcjl;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label390:
        ??? = MD5Util.getMD5String(Util.nullAs(paramFinderMedia.url, ""));
      }
    }
  }
  
  public static final cjl a(cod paramcod)
  {
    AppMethodBeat.i(252005);
    p.h(paramcod, "$this$toLocal");
    cjl localcjl = new cjl();
    localcjl.url = paramcod.url;
    localcjl.mediaType = 4;
    localcjl.thumbUrl = paramcod.thumbUrl;
    localcjl.videoDuration = paramcod.Mur;
    if (paramcod.Mus == 0L) {
      localcjl.MoQ = (paramcod.Mur * 1000L);
    }
    for (;;)
    {
      Object localObject2 = new z.f();
      x localx;
      synchronized (vGp)
      {
        ((z.f)localObject2).SYG = ((String)vGp.get(paramcod.url));
        localx = x.SXb;
        if ((String)((z.f)localObject2).SYG == null)
        {
          if (paramcod.url != null) {
            break label328;
          }
          ??? = "";
          ((z.f)localObject2).SYG = ???;
        }
      }
      synchronized (vGp)
      {
        vGp.x(paramcod.url, (String)((z.f)localObject2).SYG);
        localx = x.SXb;
        localcjl.MoL = 3;
        localcjl.mediaId = ((String)((z.f)localObject2).SYG);
        localcjl.width = paramcod.width;
        localcjl.height = paramcod.height;
        localcjl.md5sum = paramcod.md5sum;
        localcjl.fileSize = paramcod.fileSize;
        localcjl.bitrate = paramcod.bitrate;
        ??? = paramcod.Muv;
        if (??? != null)
        {
          localObject2 = ((ayi)???).LIz;
          ??? = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          ??? = new LinkedList();
        }
        localcjl.spec = ((LinkedList)???);
        localcjl.decodeKey = paramcod.decodeKey;
        localcjl.coverUrl = paramcod.coverUrl;
        localcjl.url_token = paramcod.viB;
        localcjl.cover_url_token = paramcod.Mut;
        localcjl.thumb_url_token = paramcod.Ghs;
        localcjl.hot_flag = paramcod.hot_flag;
        AppMethodBeat.o(252005);
        return localcjl;
        localcjl.MoQ = paramcod.Mus;
        continue;
        paramcod = finally;
        AppMethodBeat.o(252005);
        throw paramcod;
        label328:
        ??? = MD5Util.getMD5String(Util.nullAs(paramcod.url, ""));
      }
    }
  }
  
  public static final LinkedList<cjl> aA(LinkedList<FinderMedia> paramLinkedList)
  {
    AppMethodBeat.i(167063);
    p.h(paramLinkedList, "$this$toLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(a((FinderMedia)paramLinkedList.next()));
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
  
  public static final LinkedList<cjl> aB(LinkedList<cod> paramLinkedList)
  {
    AppMethodBeat.i(252006);
    p.h(paramLinkedList, "$this$toLongVideoLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localLinkedList.add(a((cod)localObject));
      i += 1;
    }
    AppMethodBeat.o(252006);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */