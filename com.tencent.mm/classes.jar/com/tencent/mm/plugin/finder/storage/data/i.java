package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Ljava/util/LinkedList;", "plugin-finder_release"})
public final class i
{
  private static final h<String, String> sKV;
  
  static
  {
    AppMethodBeat.i(167065);
    sKV = new h(200);
    AppMethodBeat.o(167065);
  }
  
  public static final bvz a(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    p.h(paramFinderMedia, "$this$toLocal");
    bvz localbvz = new bvz();
    localbvz.url = paramFinderMedia.url;
    localbvz.mediaType = paramFinderMedia.mediaType;
    localbvz.thumbUrl = paramFinderMedia.thumbUrl;
    localbvz.videoDuration = paramFinderMedia.videoDuration;
    y.f localf = new y.f();
    for (;;)
    {
      z localz;
      synchronized (sKV)
      {
        localf.NiY = ((String)sKV.get(paramFinderMedia.url));
        localz = z.Nhr;
        if ((String)localf.NiY == null)
        {
          if (paramFinderMedia.url != null) {
            break label268;
          }
          ??? = "";
          localf.NiY = ???;
        }
      }
      synchronized (sKV)
      {
        sKV.q(paramFinderMedia.url, (String)localf.NiY);
        localz = z.Nhr;
        localbvz.mediaId = ((String)localf.NiY);
        localbvz.width = paramFinderMedia.width;
        localbvz.height = paramFinderMedia.height;
        localbvz.md5sum = paramFinderMedia.md5sum;
        localbvz.fileSize = paramFinderMedia.fileSize;
        localbvz.bitrate = paramFinderMedia.bitrate;
        localbvz.spec = paramFinderMedia.spec;
        localbvz.coverUrl = paramFinderMedia.coverUrl;
        localbvz.decodeKey = paramFinderMedia.decodeKey;
        localbvz.url_token = paramFinderMedia.url_token;
        localbvz.thumb_url_token = paramFinderMedia.thumb_url_token;
        localbvz.cover_url_token = paramFinderMedia.cover_url_token;
        localbvz.codec_info = paramFinderMedia.codec_info;
        AppMethodBeat.o(167064);
        return localbvz;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label268:
        ??? = aj.ej(bu.bI(paramFinderMedia.url, ""));
      }
    }
  }
  
  public static final LinkedList<bvz> aj(LinkedList<FinderMedia> paramLinkedList)
  {
    AppMethodBeat.i(167063);
    p.h(paramLinkedList, "$this$toLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      if (i < 0) {
        j.gkd();
      }
      localLinkedList.add(a((FinderMedia)localObject));
      i += 1;
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */