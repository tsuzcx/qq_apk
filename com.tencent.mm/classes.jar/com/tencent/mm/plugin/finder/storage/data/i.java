package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Ljava/util/LinkedList;", "plugin-finder_release"})
public final class i
{
  private static final h<String, String> szY;
  
  static
  {
    AppMethodBeat.i(167065);
    szY = new h(200);
    AppMethodBeat.o(167065);
  }
  
  public static final bvf a(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    p.h(paramFinderMedia, "$this$toLocal");
    bvf localbvf = new bvf();
    localbvf.url = paramFinderMedia.url;
    localbvf.mediaType = paramFinderMedia.mediaType;
    localbvf.thumbUrl = paramFinderMedia.thumbUrl;
    localbvf.videoDuration = paramFinderMedia.videoDuration;
    y.f localf = new y.f();
    for (;;)
    {
      z localz;
      synchronized (szY)
      {
        localf.MLV = ((String)szY.get(paramFinderMedia.url));
        localz = z.MKo;
        if ((String)localf.MLV == null)
        {
          if (paramFinderMedia.url != null) {
            break label268;
          }
          ??? = "";
          localf.MLV = ???;
        }
      }
      synchronized (szY)
      {
        szY.q(paramFinderMedia.url, (String)localf.MLV);
        localz = z.MKo;
        localbvf.mediaId = ((String)localf.MLV);
        localbvf.width = paramFinderMedia.width;
        localbvf.height = paramFinderMedia.height;
        localbvf.md5sum = paramFinderMedia.md5sum;
        localbvf.fileSize = paramFinderMedia.fileSize;
        localbvf.bitrate = paramFinderMedia.bitrate;
        localbvf.spec = paramFinderMedia.spec;
        localbvf.coverUrl = paramFinderMedia.coverUrl;
        localbvf.decodeKey = paramFinderMedia.decodeKey;
        localbvf.url_token = paramFinderMedia.url_token;
        localbvf.thumb_url_token = paramFinderMedia.thumb_url_token;
        localbvf.cover_url_token = paramFinderMedia.cover_url_token;
        localbvf.codec_info = paramFinderMedia.codec_info;
        AppMethodBeat.o(167064);
        return localbvf;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label268:
        ??? = ai.ee(bt.bI(paramFinderMedia.url, ""));
      }
    }
  }
  
  public static final LinkedList<bvf> aj(LinkedList<FinderMedia> paramLinkedList)
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
        j.gfB();
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