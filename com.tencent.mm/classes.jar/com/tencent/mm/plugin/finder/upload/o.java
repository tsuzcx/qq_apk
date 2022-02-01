package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.h.a.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/HalfMediaLogic;", "", "()V", "TAG", "", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "fillBack", "", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "fullMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfMediaList", "Ljava/util/LinkedList;", "splitMedia", "rootMedia", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final h.a.a Exr;
  public static final o Gco;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(342965);
    Gco = new o();
    TAG = "Finder.HalfMediaLogic";
    Exr = (h.a.a)new a();
    AppMethodBeat.o(342965);
  }
  
  public static void a(FinderMedia paramFinderMedia, dji paramdji, LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(342961);
    s.u(paramFinderMedia, "media");
    s.u(paramdji, "fullMedia");
    s.u(paramLinkedList, "halfMediaList");
    Log.i(TAG, s.X("fillBack ", paramdji.aaPn));
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      paramLinkedList = localIterator.next();
      dji localdji = (dji)paramLinkedList;
      if (s.p(paramdji.aaPn, localdji.aaPn))
      {
        paramLinkedList = (dji)paramLinkedList;
        if (paramLinkedList != null) {
          break label339;
        }
        paramFinderMedia.url = paramdji.aaPd;
        paramFinderMedia.thumbUrl = paramdji.aaPe;
        paramFinderMedia.md5sum = paramdji.md5sum;
        paramFinderMedia.width = paramdji.width;
        paramFinderMedia.height = paramdji.height;
        paramFinderMedia.fileSize = paramdji.fileSize;
        paramFinderMedia.bitrate = paramdji.bitrate;
        paramFinderMedia.full_url = paramdji.aaPd;
        paramFinderMedia.full_thumb_url = paramdji.aaPk;
        paramFinderMedia.full_md5sum = paramdji.md5sum;
        paramFinderMedia.full_width = paramdji.width;
        paramFinderMedia.full_height = paramdji.height;
        paramFinderMedia.full_file_size = paramdji.fileSize;
        paramFinderMedia.full_bitrate = paramdji.bitrate;
        Log.i(TAG, "no half");
        Log.i(TAG, s.X("media.url:", paramFinderMedia.url));
        Log.i(TAG, s.X("media.thumbUrl:", paramFinderMedia.thumbUrl));
        Log.i(TAG, s.X("media.full_url:", paramFinderMedia.full_url));
        Log.i(TAG, s.X("media.full_thumb_url:", paramFinderMedia.full_thumb_url));
      }
    }
    for (;;)
    {
      paramFinderMedia.coverUrl = paramdji.aaPg;
      paramFinderMedia.full_cover_url = paramdji.aaPq;
      Log.i(TAG, s.X("media.coverUrl:", paramFinderMedia.coverUrl));
      Log.i(TAG, s.X("media.fullCover:", paramFinderMedia.full_cover_url));
      paramFinderMedia.half_rect = paramdji.aaPl;
      AppMethodBeat.o(342961);
      return;
      paramLinkedList = null;
      break;
      label339:
      paramFinderMedia.url = paramLinkedList.aaPd;
      paramFinderMedia.thumbUrl = paramLinkedList.aaPe;
      paramFinderMedia.md5sum = paramLinkedList.md5sum;
      paramFinderMedia.width = paramLinkedList.width;
      paramFinderMedia.height = paramLinkedList.height;
      paramFinderMedia.fileSize = paramLinkedList.fileSize;
      paramFinderMedia.bitrate = paramLinkedList.bitrate;
      paramFinderMedia.full_url = paramdji.aaPd;
      paramFinderMedia.full_thumb_url = paramdji.aaPk;
      paramFinderMedia.full_md5sum = paramdji.md5sum;
      paramFinderMedia.full_width = paramdji.width;
      paramFinderMedia.full_height = paramdji.height;
      paramFinderMedia.full_file_size = paramdji.fileSize;
      paramFinderMedia.full_bitrate = paramdji.bitrate;
      Log.i(TAG, "half");
      Log.i(TAG, s.X("media.url:", paramFinderMedia.url));
      Log.i(TAG, s.X("media.thumbUrl:", paramFinderMedia.thumbUrl));
      Log.i(TAG, s.X("media.full_url:", paramFinderMedia.full_url));
      Log.i(TAG, s.X("media.full_thumb_url:", paramFinderMedia.full_thumb_url));
    }
  }
  
  public static h.a.a fdZ()
  {
    return Exr;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/HalfMediaLogic$onCdnDownloadCallback$1", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "onFinish", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "tmpFilePath", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h.a.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.o
 * JD-Core Version:    0.7.0.1
 */