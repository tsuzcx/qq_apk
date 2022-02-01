package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Ljava/util/LinkedList;", "plugin-finder_release"})
public final class h
{
  private static final com.tencent.mm.b.h<String, String> rEQ;
  
  static
  {
    AppMethodBeat.i(167065);
    rEQ = new com.tencent.mm.b.h(200);
    AppMethodBeat.o(167065);
  }
  
  private static bqs a(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    k.h(paramFinderMedia, "$this$toLocal");
    bqs localbqs = new bqs();
    localbqs.url = paramFinderMedia.url;
    localbqs.mediaType = paramFinderMedia.mediaType;
    localbqs.thumbUrl = paramFinderMedia.thumbUrl;
    localbqs.videoDuration = paramFinderMedia.videoDuration;
    v.f localf = new v.f();
    for (;;)
    {
      y localy;
      synchronized (rEQ)
      {
        localf.KUQ = ((String)rEQ.get(paramFinderMedia.url));
        localy = y.KTp;
        if ((String)localf.KUQ == null)
        {
          if (paramFinderMedia.url != null) {
            break label260;
          }
          ??? = "";
          localf.KUQ = ???;
        }
      }
      synchronized (rEQ)
      {
        rEQ.o(paramFinderMedia.url, (String)localf.KUQ);
        localy = y.KTp;
        localbqs.mediaId = ((String)localf.KUQ);
        localbqs.width = paramFinderMedia.width;
        localbqs.height = paramFinderMedia.height;
        localbqs.md5sum = paramFinderMedia.md5sum;
        localbqs.fileSize = paramFinderMedia.fileSize;
        localbqs.bitrate = paramFinderMedia.bitrate;
        localbqs.spec = paramFinderMedia.spec;
        localbqs.coverUrl = paramFinderMedia.coverUrl;
        localbqs.decodeKey = paramFinderMedia.decodeKey;
        localbqs.url_token = paramFinderMedia.url_token;
        localbqs.thumb_url_token = paramFinderMedia.thumb_url_token;
        localbqs.cover_url_token = paramFinderMedia.cover_url_token;
        AppMethodBeat.o(167064);
        return localbqs;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label260:
        ??? = ah.dg(bs.bG(paramFinderMedia.url, ""));
      }
    }
  }
  
  public static final LinkedList<bqs> ah(LinkedList<FinderMedia> paramLinkedList)
  {
    AppMethodBeat.i(167063);
    k.h(paramLinkedList, "$this$toLocal");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      if (i < 0) {
        j.fOc();
      }
      localLinkedList.add(a((FinderMedia)localObject));
      i += 1;
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */