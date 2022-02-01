package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"md5Map", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "toLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Ljava/util/LinkedList;", "plugin-finder_release"})
public final class e
{
  private static final h<String, String> qKr;
  
  static
  {
    AppMethodBeat.i(167065);
    qKr = new h(200);
    AppMethodBeat.o(167065);
  }
  
  private static bmd a(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167064);
    k.h(paramFinderMedia, "$this$toLocal");
    bmd localbmd = new bmd();
    localbmd.url = paramFinderMedia.url;
    localbmd.mediaType = paramFinderMedia.mediaType;
    localbmd.thumbUrl = paramFinderMedia.thumbUrl;
    localbmd.videoDuration = paramFinderMedia.videoDuration;
    v.e locale = new v.e();
    for (;;)
    {
      y localy;
      synchronized (qKr)
      {
        locale.Jhw = ((String)qKr.get(paramFinderMedia.url));
        localy = y.JfV;
        if ((String)locale.Jhw == null)
        {
          if (paramFinderMedia.url != null) {
            break label260;
          }
          ??? = "";
          locale.Jhw = ???;
        }
      }
      synchronized (qKr)
      {
        qKr.o(paramFinderMedia.url, (String)locale.Jhw);
        localy = y.JfV;
        localbmd.mediaId = ((String)locale.Jhw);
        localbmd.width = paramFinderMedia.width;
        localbmd.height = paramFinderMedia.height;
        localbmd.md5sum = paramFinderMedia.md5sum;
        localbmd.fileSize = paramFinderMedia.fileSize;
        localbmd.bitrate = paramFinderMedia.bitrate;
        localbmd.spec = paramFinderMedia.spec;
        localbmd.coverUrl = paramFinderMedia.coverUrl;
        localbmd.decodeKey = paramFinderMedia.decodeKey;
        localbmd.url_token = paramFinderMedia.url_token;
        localbmd.thumb_url_token = paramFinderMedia.thumb_url_token;
        localbmd.cover_url_token = paramFinderMedia.cover_url_token;
        AppMethodBeat.o(167064);
        return localbmd;
        paramFinderMedia = finally;
        AppMethodBeat.o(167064);
        throw paramFinderMedia;
        label260:
        ??? = ai.du(bt.by(paramFinderMedia.url, ""));
      }
    }
  }
  
  public static final LinkedList<bmd> ae(LinkedList<FinderMedia> paramLinkedList)
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
        j.fvx();
      }
      localLinkedList.add(a((FinderMedia)localObject));
      i += 1;
    }
    AppMethodBeat.o(167063);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e
 * JD-Core Version:    0.7.0.1
 */