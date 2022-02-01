package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.loader.f.a.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.cjl;>;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/HalfMediaLogic;", "", "()V", "TAG", "", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "fillBack", "", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "fullMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "halfMediaList", "Ljava/util/LinkedList;", "splitMedia", "rootMedia", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "Finder.HalfMediaLogic";
  private static final f.a.a uIo;
  public static final o vTw;
  
  static
  {
    AppMethodBeat.i(253134);
    vTw = new o();
    TAG = "Finder.HalfMediaLogic";
    uIo = (f.a.a)new a();
    AppMethodBeat.o(253134);
  }
  
  public static void a(FinderMedia paramFinderMedia, cjl paramcjl, LinkedList<cjl> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(253133);
    p.h(paramFinderMedia, "media");
    p.h(paramcjl, "fullMedia");
    p.h(paramLinkedList, "halfMediaList");
    Log.i(TAG, "fillBack " + paramcjl.MoW);
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramLinkedList = ((Iterator)localObject2).next();
      cjl localcjl = (cjl)paramLinkedList;
      if (p.j(paramcjl.MoW, localcjl.MoW))
      {
        paramLinkedList = (cjl)paramLinkedList;
        if (paramLinkedList != null) {
          break label487;
        }
        paramFinderMedia.url = paramcjl.MoM;
        paramFinderMedia.thumbUrl = paramcjl.MoN;
        paramFinderMedia.md5sum = paramcjl.md5sum;
        paramFinderMedia.width = paramcjl.width;
        paramFinderMedia.height = paramcjl.height;
        paramFinderMedia.fileSize = paramcjl.fileSize;
        paramFinderMedia.bitrate = paramcjl.bitrate;
        paramFinderMedia.full_url = paramcjl.MoM;
        paramFinderMedia.full_thumb_url = paramcjl.MoT;
        paramFinderMedia.full_md5sum = paramcjl.md5sum;
        paramFinderMedia.full_width = paramcjl.width;
        paramFinderMedia.full_height = paramcjl.height;
        paramFinderMedia.full_file_size = paramcjl.fileSize;
        paramFinderMedia.full_bitrate = paramcjl.bitrate;
        Log.i(TAG, "no half");
        Log.i(TAG, "media.url:" + paramFinderMedia.url);
        Log.i(TAG, "media.thumbUrl:" + paramFinderMedia.thumbUrl);
        Log.i(TAG, "media.full_url:" + paramFinderMedia.full_url);
        Log.i(TAG, "media.full_thumb_url:" + paramFinderMedia.full_thumb_url);
      }
    }
    for (;;)
    {
      paramFinderMedia.coverUrl = paramcjl.MoP;
      Log.i(TAG, "media.coverUrl:" + paramFinderMedia.coverUrl);
      localObject2 = paramcjl.MoU;
      paramLinkedList = localObject1;
      if (localObject2 != null)
      {
        paramcjl = paramcjl.MfU;
        if (paramcjl != null)
        {
          paramcjl = paramcjl.Gxw;
          if (paramcjl != null)
          {
            float f1 = paramFinderMedia.full_width / paramcjl.xlg;
            float f2 = paramFinderMedia.full_height / paramcjl.xlh;
            ((aty)localObject2).left *= f1;
            ((aty)localObject2).top *= f2;
            ((aty)localObject2).right = (f1 * ((aty)localObject2).right);
            ((aty)localObject2).bottom = (f2 * ((aty)localObject2).bottom);
          }
        }
        paramLinkedList = (LinkedList<cjl>)localObject2;
      }
      paramFinderMedia.half_rect = paramLinkedList;
      AppMethodBeat.o(253133);
      return;
      paramLinkedList = null;
      break;
      label487:
      paramFinderMedia.url = paramLinkedList.MoM;
      paramFinderMedia.thumbUrl = paramLinkedList.MoN;
      paramFinderMedia.md5sum = paramLinkedList.md5sum;
      paramFinderMedia.width = paramLinkedList.width;
      paramFinderMedia.height = paramLinkedList.height;
      paramFinderMedia.fileSize = paramLinkedList.fileSize;
      paramFinderMedia.bitrate = paramLinkedList.bitrate;
      paramFinderMedia.full_url = paramcjl.MoM;
      paramFinderMedia.full_thumb_url = paramcjl.MoT;
      paramFinderMedia.full_md5sum = paramcjl.md5sum;
      paramFinderMedia.full_width = paramcjl.width;
      paramFinderMedia.full_height = paramcjl.height;
      paramFinderMedia.full_file_size = paramcjl.fileSize;
      paramFinderMedia.full_bitrate = paramcjl.bitrate;
      Log.i(TAG, "half");
      Log.i(TAG, "media.url:" + paramFinderMedia.url);
      Log.i(TAG, "media.thumbUrl:" + paramFinderMedia.thumbUrl);
      Log.i(TAG, "media.full_url:" + paramFinderMedia.full_url);
      Log.i(TAG, "media.full_thumb_url:" + paramFinderMedia.full_thumb_url);
    }
  }
  
  public static void a(cjl paramcjl, LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(253132);
    p.h(paramcjl, "rootMedia");
    p.h(paramLinkedList, "halfMediaList");
    paramcjl.MoW = ("fillback_" + System.currentTimeMillis());
    car localcar = paramcjl.MoX;
    if (localcar != null)
    {
      Log.i(TAG, "split " + paramcjl.MoW);
      Object localObject1 = (a)new cjl();
      Object localObject3 = paramcjl.toByteArray();
      try
      {
        ((a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cjl)localObject1;
        if (localObject1 != null)
        {
          ((cjl)localObject1).thumbUrl = localcar.thumbUrl;
          ((cjl)localObject1).width = localcar.width;
          ((cjl)localObject1).height = localcar.height;
          ((cjl)localObject1).MfU = localcar.MfU;
          localObject3 = (CharSequence)localcar.xve;
          if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label255;
            }
            ((cjl)localObject1).url = localcar.xve;
            ((cjl)localObject1).mediaId = MD5Util.getMD5String(((cjl)localObject1).url);
            ((cjl)localObject1).coverUrl = "";
            ((cjl)localObject1).MoR = "";
            ((cjl)localObject1).MoY = true;
            paramLinkedList.add(localObject1);
            AppMethodBeat.o(253132);
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
          label255:
          if (paramcjl.mediaType == 2)
          {
            localObject2.url = paramcjl.url;
            localObject2.mediaId = (MD5Util.getMD5String(localObject2.url) + "_split");
            Log.e(TAG, "splitMedia image half null!");
          }
        }
        AppMethodBeat.o(253132);
        return;
      }
    }
    AppMethodBeat.o(253132);
  }
  
  public static f.a.a dBk()
  {
    return uIo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/HalfMediaLogic$onCdnDownloadCallback$1", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "onFinish", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "tmpFilePath", "", "plugin-finder_release"})
  public static final class a
    implements f.a.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.o
 * JD-Core Version:    0.7.0.1
 */