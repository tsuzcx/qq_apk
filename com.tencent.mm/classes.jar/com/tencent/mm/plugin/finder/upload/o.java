package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.loader.l.a.a;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.csg;>;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/HalfMediaLogic;", "", "()V", "TAG", "", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "fillBack", "", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "fullMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfMediaList", "Ljava/util/LinkedList;", "splitMedia", "rootMedia", "plugin-finder_release"})
public final class o
{
  public static final o AAZ;
  private static final String TAG = "Finder.HalfMediaLogic";
  private static final l.a.a zty;
  
  static
  {
    AppMethodBeat.i(271327);
    AAZ = new o();
    TAG = "Finder.HalfMediaLogic";
    zty = (l.a.a)new a();
    AppMethodBeat.o(271327);
  }
  
  public static void a(FinderMedia paramFinderMedia, csg paramcsg, LinkedList<csg> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(271325);
    p.k(paramFinderMedia, "media");
    p.k(paramcsg, "fullMedia");
    p.k(paramLinkedList, "halfMediaList");
    Log.i(TAG, "fillBack " + paramcsg.TAc);
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramLinkedList = ((Iterator)localObject2).next();
      csg localcsg = (csg)paramLinkedList;
      if (p.h(paramcsg.TAc, localcsg.TAc))
      {
        paramLinkedList = (csg)paramLinkedList;
        if (paramLinkedList != null) {
          break label411;
        }
        paramFinderMedia.url = paramcsg.TzS;
        paramFinderMedia.thumbUrl = paramcsg.TzT;
        paramFinderMedia.md5sum = paramcsg.md5sum;
        paramFinderMedia.width = paramcsg.width;
        paramFinderMedia.height = paramcsg.height;
        paramFinderMedia.fileSize = paramcsg.fileSize;
        paramFinderMedia.bitrate = paramcsg.bitrate;
        paramFinderMedia.full_url = paramcsg.TzS;
        paramFinderMedia.full_thumb_url = paramcsg.TzZ;
        paramFinderMedia.full_md5sum = paramcsg.md5sum;
        paramFinderMedia.full_width = paramcsg.width;
        paramFinderMedia.full_height = paramcsg.height;
        paramFinderMedia.full_file_size = paramcsg.fileSize;
        paramFinderMedia.full_bitrate = paramcsg.bitrate;
        Log.i(TAG, "no half");
        Log.i(TAG, "media.url:" + paramFinderMedia.url);
        Log.i(TAG, "media.thumbUrl:" + paramFinderMedia.thumbUrl);
        Log.i(TAG, "media.full_url:" + paramFinderMedia.full_url);
        Log.i(TAG, "media.full_thumb_url:" + paramFinderMedia.full_thumb_url);
        label330:
        paramFinderMedia.coverUrl = paramcsg.TzV;
        Log.i(TAG, "media.coverUrl:" + paramFinderMedia.coverUrl);
        paramLinkedList = paramcsg.TpG;
        if (paramLinkedList == null) {
          break label634;
        }
        paramLinkedList = paramLinkedList.NkX;
        if (paramLinkedList == null) {
          break label634;
        }
        paramLinkedList = paramLinkedList.SoJ;
        label386:
        if (paramLinkedList != null) {
          break label639;
        }
        paramLinkedList = paramcsg.TAa;
      }
    }
    for (;;)
    {
      paramFinderMedia.half_rect = paramLinkedList;
      AppMethodBeat.o(271325);
      return;
      paramLinkedList = null;
      break;
      label411:
      paramFinderMedia.url = paramLinkedList.TzS;
      paramFinderMedia.thumbUrl = paramLinkedList.TzT;
      paramFinderMedia.md5sum = paramLinkedList.md5sum;
      paramFinderMedia.width = paramLinkedList.width;
      paramFinderMedia.height = paramLinkedList.height;
      paramFinderMedia.fileSize = paramLinkedList.fileSize;
      paramFinderMedia.bitrate = paramLinkedList.bitrate;
      paramFinderMedia.full_url = paramcsg.TzS;
      paramFinderMedia.full_thumb_url = paramcsg.TzZ;
      paramFinderMedia.full_md5sum = paramcsg.md5sum;
      paramFinderMedia.full_width = paramcsg.width;
      paramFinderMedia.full_height = paramcsg.height;
      paramFinderMedia.full_file_size = paramcsg.fileSize;
      paramFinderMedia.full_bitrate = paramcsg.bitrate;
      Log.i(TAG, "half");
      Log.i(TAG, "media.url:" + paramFinderMedia.url);
      Log.i(TAG, "media.thumbUrl:" + paramFinderMedia.thumbUrl);
      Log.i(TAG, "media.full_url:" + paramFinderMedia.full_url);
      Log.i(TAG, "media.full_thumb_url:" + paramFinderMedia.full_thumb_url);
      break label330;
      label634:
      paramLinkedList = null;
      break label386;
      label639:
      localObject2 = paramcsg.TAa;
      paramLinkedList = localObject1;
      if (localObject2 != null)
      {
        paramcsg = paramcsg.TpG;
        if (paramcsg != null)
        {
          paramLinkedList = paramcsg.NkX;
          if (paramLinkedList != null)
          {
            paramcsg = new Rect();
            paramLinkedList = paramLinkedList.SoJ.Sro;
            p.j(paramLinkedList, "outputConfig.fullScreenConfig.cropRect");
            i.a(paramLinkedList, paramcsg);
            float f1 = paramFinderMedia.full_width / paramcsg.width();
            float f2 = paramFinderMedia.full_height / paramcsg.height();
            ((awc)localObject2).left *= f1;
            ((awc)localObject2).top *= f2;
            ((awc)localObject2).right = (f1 * ((awc)localObject2).right);
            ((awc)localObject2).bottom *= f2;
          }
        }
        paramLinkedList = (LinkedList<csg>)localObject2;
      }
    }
  }
  
  public static void a(csg paramcsg, LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(271323);
    p.k(paramcsg, "rootMedia");
    p.k(paramLinkedList, "halfMediaList");
    paramcsg.TAc = ("fillback_" + System.currentTimeMillis());
    cis localcis = paramcsg.TAd;
    if (localcis != null)
    {
      Log.i(TAG, "split " + paramcsg.TAc);
      Object localObject1 = (a)new csg();
      Object localObject3 = paramcsg.toByteArray();
      try
      {
        ((a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (csg)localObject1;
        if (localObject1 != null)
        {
          ((csg)localObject1).thumbUrl = localcis.thumbUrl;
          ((csg)localObject1).width = localcis.width;
          ((csg)localObject1).height = localcis.height;
          ((csg)localObject1).TpG = localcis.TpG;
          localObject3 = (CharSequence)localcis.Crx;
          if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label259;
            }
            ((csg)localObject1).url = localcis.Crx;
            ((csg)localObject1).mediaId = MD5Util.getMD5String(((csg)localObject1).url);
            ((csg)localObject1).coverUrl = "";
            ((csg)localObject1).TzX = "";
            ((csg)localObject1).TAe = true;
            paramLinkedList.add(localObject1);
            AppMethodBeat.o(271323);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
          continue;
          int i = 0;
          continue;
          label259:
          if (paramcsg.mediaType == 2)
          {
            localObject2.url = paramcsg.url;
            localObject2.mediaId = (MD5Util.getMD5String(localObject2.url) + "_split");
            Log.e(TAG, "splitMedia image half null!");
          }
        }
        AppMethodBeat.o(271323);
        return;
      }
    }
    AppMethodBeat.o(271323);
  }
  
  public static l.a.a ecs()
  {
    return zty;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/HalfMediaLogic$onCdnDownloadCallback$1", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "onFinish", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "tmpFilePath", "", "plugin-finder_release"})
  public static final class a
    implements l.a.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.o
 * JD-Core Version:    0.7.0.1
 */