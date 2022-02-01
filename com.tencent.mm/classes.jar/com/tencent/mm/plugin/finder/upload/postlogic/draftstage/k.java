package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "cancel", "", "cdnCallback", "com/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "setDraftItem", "draftModifyListener", "com/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage$draftModifyListener$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage$draftModifyListener$1;", "failedList", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "getStageType", "", "isLongVideo", "media", "onFailed", "nextStage", "onSuccess", "onWait", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "saveToDb", "setResult", "stage", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  com.tencent.mm.plugin.finder.storage.i ABX;
  private List<dji> GeA;
  boolean GeB;
  private final List<com.tencent.mm.g.g> GeC;
  private final MvDraftUploadStage.draftModifyListener.1 GeO;
  private final a GeP;
  final FinderItem Ged;
  private com.tencent.mm.plugin.finder.upload.postlogic.base.e Gev;
  private final djj Gex;
  final Map<String, Float> Gey;
  final ConcurrentLinkedQueue<String> Gez;
  final String TAG;
  boolean cancel;
  private long startTime;
  List<String> wre;
  private CountDownLatch yuW;
  
  public k(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343045);
    this.ABX = parami;
    this.TAG = "LogPost.MvDraftUploadStage";
    this.Ged = this.ABX.eYK();
    this.Gex = this.Ged.getPostInfo();
    this.Gey = ((Map)new LinkedHashMap());
    this.Gez = new ConcurrentLinkedQueue();
    this.GeA = ((List)new ArrayList());
    this.wre = ((List)new ArrayList());
    this.GeC = ((List)new ArrayList());
    parami = this.ABX;
    localObject = c.GdZ;
    this.Gev = ((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(parami, c.fev()));
    this.yuW = new CountDownLatch(1);
    this.GeO = new MvDraftUploadStage.draftModifyListener.1(this, com.tencent.mm.app.f.hfK);
    this.GeP = new a(this);
    AppMethodBeat.o(343045);
  }
  
  private final void TO(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.Ged.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  private final void a(int paramInt, dji paramdji)
  {
    AppMethodBeat.i(343055);
    g(paramdji);
    FinderMediaReportObject localFinderMediaReportObject = paramdji.aaPt;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramdji = paramdji.aaPt;
    if (paramdji != null) {
      paramdji.cdnControl = paramInt;
    }
    AppMethodBeat.o(343055);
  }
  
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.e bg(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(343087);
    label952:
    label1119:
    Object localObject2;
    try
    {
      this.Gex.aaPu = 0;
      this.Ged.setPostInfo(this.Gex);
      feB();
      this.GeC.clear();
      Object localObject1 = com.tencent.mm.plugin.finder.upload.s.GcC;
      if ((com.tencent.mm.plugin.finder.upload.s.fdY()) && (Log.getLogLevel() <= 1))
      {
        Log.i(this.TAG, "debugDeleteFileWhenUpload");
        localObject1 = bm.GlZ;
        com.tencent.mm.vfs.y.ew(bm.fiu(), true);
      }
      paramLinkedList = paramLinkedList.iterator();
      for (;;)
      {
        if (paramLinkedList.hasNext())
        {
          localObject1 = (dji)paramLinkedList.next();
          if (!Util.isNullOrNil(((dji)localObject1).url))
          {
            localObject3 = ((dji)localObject1).mediaId;
            Log.i(this.TAG, "uploading media " + localObject3 + ", " + ((dji)localObject1).url + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).url)) + " thumb: " + ((dji)localObject1).thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).thumbUrl)));
            kotlin.g.b.s.s(localObject1, "media");
            if ((!Util.isNullOrNil(((dji)localObject1).aaPd)) && (!Util.isNullOrNil(((dji)localObject1).aaPe)))
            {
              Log.i(this.TAG, "mediaObject svr_url and svr_thumbUrl exist");
              i = e((dji)localObject1);
              if (i != 0)
              {
                if (i == 0) {
                  continue;
                }
                TO(i);
                ut(false);
                paramLinkedList = this.ABX;
                localObject1 = c.GdZ;
                paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
                AppMethodBeat.o(343087);
                return paramLinkedList;
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      label1171:
      label1306:
      do
      {
        Object localObject3;
        String str;
        boolean bool2;
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
          continue;
          int i = f(localException);
          continue;
          if (!com.tencent.mm.vfs.y.ZC(localException.url))
          {
            Log.i(this.TAG, "mediaObject.url " + localException.url + " is not file");
            i = 1;
          }
          else
          {
            localObject3 = new com.tencent.mm.g.g();
            ((com.tencent.mm.g.g)localObject3).taskName = "task_FinderUploadTask_1";
            ((com.tencent.mm.g.g)localObject3).lwL = ((g.a)this.GeP);
            localObject4 = MD5Util.getMD5String(localException.url);
            kotlin.g.b.s.s(localObject4, "getMD5String(mediaObject.url)");
            ((com.tencent.mm.g.g)localObject3).field_mediaId = kotlin.g.b.s.X("uploaddraft_", localObject4);
            ((com.tencent.mm.g.g)localObject3).field_fullpath = localException.url;
            ((com.tencent.mm.g.g)localObject3).field_thumbpath = localException.thumbUrl;
            ((com.tencent.mm.g.g)localObject3).field_talker = "";
            ((com.tencent.mm.g.g)localObject3).field_needStorage = true;
            Log.i(this.TAG, "upload file length " + com.tencent.mm.vfs.y.bEl(localException.url) + " mediaId: " + ((com.tencent.mm.g.g)localObject3).field_mediaId + " localId:" + this.ABX.field_localId);
            switch (localException.mediaType)
            {
            case 3: 
            case 5: 
            case 6: 
            default: 
              Log.e(this.TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(localException.mediaType) });
              i = 0;
              break;
            case 2: 
            case 7: 
              ((com.tencent.mm.g.g)localObject3).field_thumbpath = localException.url;
              ((com.tencent.mm.g.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.g.g)localObject3).field_appType = 251;
              ((com.tencent.mm.g.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.g.g)localObject3).lwP = 300;
              ((com.tencent.mm.g.g)localObject3).lwQ = 300;
              ((com.tencent.mm.g.g)localObject3).field_priority = com.tencent.mm.g.a.lvZ;
              this.Gez.add(((com.tencent.mm.g.g)localObject3).field_mediaId);
              Log.i(this.TAG, "add uploadingFeed " + ((com.tencent.mm.g.g)localObject3).field_mediaId + " size:" + this.Gez.size());
              localObject4 = this.Gey;
              str = ((com.tencent.mm.g.g)localObject3).field_mediaId;
              kotlin.g.b.s.s(str, "info.field_mediaId");
              ((Map)localObject4).put(str, Float.valueOf(0.0F));
              com.tencent.mm.modelcdntran.k.bHW().Ny(((com.tencent.mm.g.g)localObject3).field_mediaId);
              this.GeC.add(localObject3);
              int j = e(localException);
              i = j;
              if (j == 0) {
                i = f(localException);
              }
              break;
            case 4: 
              bool1 = SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.g.g)localObject3).field_fullpath);
              localObject4 = av.GiL;
              localObject4 = ((com.tencent.mm.g.g)localObject3).field_fullpath;
              kotlin.g.b.s.s(localObject4, "info.field_fullpath");
              bool2 = av.aBO((String)localObject4);
              localObject4 = com.tencent.mm.plugin.finder.upload.s.GcC;
              Log.i(com.tencent.mm.plugin.finder.upload.s.access$getTAG$cp(), aUE() + " optimize result: " + bool1 + ", isOptimize:" + bool2);
              if (bool1) {
                break label952;
              }
              e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "optimizeMP4VFS_fail", bool2, null, false, (kotlin.g.a.a)new b(this), 28);
              if (bool2) {
                break label952;
              }
              i = 4;
            }
          }
        }
        e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "opt_moov_fail", bool2, null, false, (kotlin.g.a.a)new c(this), 28);
        ((com.tencent.mm.g.g)localObject3).field_fileType = 20302;
        ((com.tencent.mm.g.g)localObject3).field_appType = 251;
        ((com.tencent.mm.g.g)localObject3).lxc = 8;
        ((com.tencent.mm.g.g)localObject3).field_bzScene = 2;
        ((com.tencent.mm.g.g)localObject3).lwP = 1200;
        ((com.tencent.mm.g.g)localObject3).lwQ = 1200;
        Object localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        l = com.tencent.mm.plugin.finder.storage.d.eQi();
        localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        StringBuilder localStringBuilder;
        if ((l > com.tencent.mm.plugin.finder.storage.d.eQm()) || (h(localException)))
        {
          l = com.tencent.mm.vfs.y.bEl(((com.tencent.mm.g.g)localObject3).field_fullpath);
          localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (l > com.tencent.mm.plugin.finder.storage.d.eQm())
          {
            localObject4 = k((com.tencent.mm.g.g)localObject3);
            str = this.TAG;
            localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable1, mediaInfo null?");
            if (localObject4 == null)
            {
              bool1 = true;
              Log.i(str, bool1 + ", path:" + ((com.tencent.mm.g.g)localObject3).field_fullpath);
              a(0, localException);
              localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
              localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
              com.tencent.mm.plugin.finder.utils.k.a(com.tencent.mm.plugin.finder.utils.k.feM());
            }
          }
        }
        for (;;)
        {
          if (h(localException))
          {
            ((com.tencent.mm.g.g)localObject3).lwP = 1200;
            ((com.tencent.mm.g.g)localObject3).lwQ = 1200;
            break;
            bool1 = false;
            break label1119;
            localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (com.tencent.mm.plugin.finder.storage.d.eTp() == 1)
            {
              localObject4 = k((com.tencent.mm.g.g)localObject3);
              str = this.TAG;
              localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
              if (localObject4 != null) {
                break label1306;
              }
            }
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.i(str, bool1 + ", path:" + ((com.tencent.mm.g.g)localObject3).field_fullpath);
          a(1, localException);
          localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
          localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
          com.tencent.mm.plugin.finder.utils.k.a(com.tencent.mm.plugin.finder.utils.k.feM());
          break label1171;
          break;
        }
      } while ((localException.mediaType != 2) && (localException.mediaType != 7) && (localException.mediaType != 4));
      Log.i(this.TAG, "uploadFinderContent media.url invalid, url:" + localException.url + ", type:" + localException.mediaType);
      TO(2);
      ut(false);
      paramLinkedList = this.ABX;
      localObject2 = c.GdZ;
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
      AppMethodBeat.o(343087);
      return paramLinkedList;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("upload info count:", Integer.valueOf(this.GeC.size())));
    long l = 0L;
    paramLinkedList = ((Iterable)this.GeC).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject2 = (com.tencent.mm.g.g)paramLinkedList.next();
      com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject2);
      l = com.tencent.mm.vfs.y.bEl(((com.tencent.mm.g.g)localObject2).field_fullpath) + l;
    }
    paramLinkedList = this.Ged.field_reportObject;
    if (paramLinkedList != null) {
      paramLinkedList.uploadMediaTotalSize = l;
    }
    paramLinkedList = this.Ged.field_reportObject;
    if (paramLinkedList != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.upload.i.Gcb;
      com.tencent.mm.plugin.finder.upload.i.a(paramLinkedList, "beginUpload");
    }
    if (this.Gez.size() == 0)
    {
      ut(true);
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new h(this.ABX);
      AppMethodBeat.o(343087);
      return paramLinkedList;
    }
    paramLinkedList = i.c.FoQ;
    i.c.tG(this.Ged.isLongVideo());
    this.yuW.await();
    paramLinkedList = this.Gev;
    AppMethodBeat.o(343087);
    return paramLinkedList;
  }
  
  private final int e(dji paramdji)
  {
    AppMethodBeat.i(343101);
    if ((paramdji.mediaType == 4) && (!Util.isNullOrNil(paramdji.coverUrl)))
    {
      if (!Util.isNullOrNil(paramdji.aaPg))
      {
        Log.i(this.TAG, "mediaObject svr_coverUrl exist");
        AppMethodBeat.o(343101);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.coverUrl))
      {
        Log.w(this.TAG, kotlin.g.b.s.X("upload failed, coverUrl not exist, ", paramdji.coverUrl));
        AppMethodBeat.o(343101);
        return 5;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((g.a)this.GeP);
      String str = MD5Util.getMD5String(paramdji.coverUrl);
      kotlin.g.b.s.s(str, "getMD5String(mediaObject.coverUrl)");
      localg.field_mediaId = kotlin.g.b.s.X("uploaddraft_", str);
      localg.field_fullpath = paramdji.coverUrl;
      localg.field_thumbpath = paramdji.coverUrl;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(this.TAG, kotlin.g.b.s.X("upload cover file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(paramdji.coverUrl))));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.lwP = 120;
      localg.lwQ = 300;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      this.Gez.add(localg.field_mediaId);
      paramdji = this.Gey;
      str = localg.field_mediaId;
      kotlin.g.b.s.s(str, "info.field_mediaId");
      paramdji.put(str, Float.valueOf(0.0F));
      this.GeC.add(localg);
    }
    AppMethodBeat.o(343101);
    return 0;
  }
  
  private final int f(dji paramdji)
  {
    AppMethodBeat.i(343109);
    if (!Util.isNullOrNil(paramdji.aaPi))
    {
      if (!Util.isNullOrNil(paramdji.aaPk))
      {
        Log.i(this.TAG, "mediaObject svr_fullThumbUrl exist");
        AppMethodBeat.o(343109);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.aaPi))
      {
        Log.w(this.TAG, kotlin.g.b.s.X("upload failed, fullThumbUrl not exist, ", paramdji.aaPi));
        AppMethodBeat.o(343109);
        return 6;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((g.a)this.GeP);
      String str = MD5Util.getMD5String(paramdji.aaPi);
      kotlin.g.b.s.s(str, "getMD5String(mediaObject.fullThumbUrl)");
      localg.field_mediaId = kotlin.g.b.s.X("uploaddraft_", str);
      localg.field_fullpath = paramdji.aaPi;
      localg.field_thumbpath = paramdji.aaPi;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(this.TAG, kotlin.g.b.s.X("upload fullthumb file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(paramdji.aaPi))));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.lwP = 120;
      localg.lwQ = 300;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      this.Gez.add(localg.field_mediaId);
      paramdji = this.Gey;
      str = localg.field_mediaId;
      kotlin.g.b.s.s(str, "info.field_mediaId");
      paramdji.put(str, Float.valueOf(0.0F));
      this.GeC.add(localg);
    }
    AppMethodBeat.o(343109);
    return 0;
  }
  
  private final void g(dji paramdji)
  {
    AppMethodBeat.i(343062);
    Object localObject1 = paramdji.aaPt;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null)
      {
        Object localObject2 = (k)this;
        localObject1 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
        ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
        ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - ((k)localObject2).startTime));
        localObject2 = new FinderMediaReportInfo();
        ((FinderMediaReportInfo)localObject2).width = ((int)paramdji.width);
        ((FinderMediaReportInfo)localObject2).height = ((int)paramdji.height);
        ((FinderMediaReportInfo)localObject2).fileSize = ((int)com.tencent.mm.vfs.y.bEl(paramdji.url));
        ((FinderMediaReportInfo)localObject2).videoDuration = paramdji.videoDuration;
        ((FinderMediaReportInfo)localObject2).videoBitrate = paramdji.bitrate;
        ((FinderMediaReportObject)localObject1).videoFinalSize = ((FinderMediaReportInfo)localObject2).fileSize;
        ah localah = ah.aiuX;
        ((FinderMediaReportObject)localObject1).target = ((FinderMediaReportInfo)localObject2);
        localObject2 = ah.aiuX;
        paramdji.aaPt = ((FinderMediaReportObject)localObject1);
      }
      AppMethodBeat.o(343062);
      return;
      ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
      ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
      ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - this.startTime));
    }
  }
  
  private final boolean h(dji paramdji)
  {
    AppMethodBeat.i(343125);
    Iterator localIterator = this.GeA.iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (!kotlin.g.b.s.p(((dji)localIterator.next()).mediaId, paramdji.mediaId)) {}
    }
    for (;;)
    {
      if (i < 0) {
        break label73;
      }
      AppMethodBeat.o(343125);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(343125);
    return false;
  }
  
  private final com.tencent.mm.plugin.sight.base.b k(com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(343117);
    paramg.snsVersion = 1;
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aVX(paramg.field_fullpath);
    int j;
    if (localb != null)
    {
      j = localb.videoBitrate;
      if (!com.tencent.mm.modelvideo.y.isH265Video(paramg.field_fullpath)) {
        break label110;
      }
    }
    label110:
    for (int i = 174;; i = 28)
    {
      String str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
      Log.i(this.TAG, kotlin.g.b.s.X("customHeader ", str));
      paramg.customHeader = str;
      AppMethodBeat.o(343117);
      return localb;
    }
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343176);
    String str = kotlin.g.b.s.X("uploaddraft_", Long.valueOf(this.ABX.field_localId));
    AppMethodBeat.o(343176);
    return str;
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343179);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343179);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343185);
    kotlin.g.b.s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343185);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343192);
    kotlin.g.b.s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343192);
  }
  
  final void feB()
  {
    AppMethodBeat.i(343169);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
    AppMethodBeat.o(343169);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343158);
    this.GeO.alive();
    this.Ged.trackPost("upload");
    Object localObject1 = this.Ged.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 3;
    }
    this.startTime = cn.bDw();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eTE().bmg()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.d.eTE().bmg()).longValue() * 1000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 2)
    {
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
      AppMethodBeat.o(343158);
      return localObject1;
    }
    localObject1 = j.FKc;
    if (!j.pX(this.ABX.field_localId))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("start but not exist: ", Long.valueOf(this.ABX.field_localId)));
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.feu());
      AppMethodBeat.o(343158);
      return localObject1;
    }
    localObject1 = this.Ged.getFeedObject().objectDesc;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((FinderObjectDesc)localObject1).mvInfo)
    {
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
      AppMethodBeat.o(343158);
      return localObject1;
    }
    Object localObject2 = new LinkedList();
    Object localObject3;
    Object localObject4;
    int i;
    if (((bol)localObject1).ZWM == 1)
    {
      localObject1 = ((bol)localObject1).ZWL;
      kotlin.g.b.s.s(localObject1, "mvInfo.ordered_track_list_flex_clip");
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label399:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((boq)localObject4).refObjectId == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label399;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      ((LinkedList)localObject2).addAll((Collection)localObject1);
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll((Collection)this.Ged.getMediaList());
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      label450:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (i < 0) {
          p.kkW();
        }
        localObject4 = (boq)localObject1;
        Iterator localIterator = ((Iterable)this.Ged.getClipListExt()).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = localIterator.next();
        } while (!kotlin.g.b.s.p(((FinderItem)localObject1).getObjectNonceId(), ((boq)localObject4).ZWZ));
      }
    }
    else
    {
      for (;;)
      {
        localObject1 = (FinderItem)localObject1;
        if (localObject1 != null) {
          ((LinkedList)localObject3).addAll((Collection)((FinderItem)localObject1).getMediaList());
        }
        i += 1;
        break label450;
        localObject1 = ((bol)localObject1).ZWI;
        kotlin.g.b.s.s(localObject1, "mvInfo.orderedTrackList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label652:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((boq)localObject4).refObjectId == 0L) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label652;
            }
            ((Collection)localObject1).add(localObject4);
            break;
          }
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        break;
        localObject1 = null;
      }
    }
    localObject1 = bg((LinkedList)localObject3);
    AppMethodBeat.o(343158);
    return localObject1;
  }
  
  public final int fer()
  {
    return 3;
  }
  
  final void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(343162);
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        this.Gex.aaPu = 2;
        this.Gex.mnY = (cn.bDu() - this.startTime);
        this.Ged.setPostInfo(this.Gex);
        i.b localb = i.b.Fox;
        i.b.E(this.Gex.mnY, this.Ged.isLongVideo());
        feB();
        AppMethodBeat.o(343162);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(343162);
      }
      this.Gex.aaPu = 1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftUploadStage$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    a(k paramk) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(343127);
      Object localObject3 = this.GeQ.TAG;
      String str = "on cdn callback someOneFailed:" + this.GeQ.GeB + ", mediaId = %s, startRet = %d, sceneResult %s";
      if (paramd == null) {
        localObject1 = "null";
      }
      Object localObject2;
      for (;;)
      {
        Log.i((String)localObject3, str, new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
        if ((!this.GeQ.cancel) && (!this.GeQ.GeB)) {
          break;
        }
        AppMethodBeat.o(343127);
        return 0;
        localObject2 = paramd.toString();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      Object localObject1 = this.GeQ;
      if (!Util.isNullOrNil(paramString))
      {
        localObject2 = ((k)localObject1).Gey;
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
          AppMethodBeat.o(343127);
          throw paramString;
        }
        if ((((Map)localObject2).containsKey(paramString)) && (paramc != null)) {}
      }
      else
      {
        if (paramInt == 0) {
          break label820;
        }
        Log.e(this.GeQ.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt == -21005) {
          break label813;
        }
        paramd = this.GeQ.wre;
        if (paramString != null) {
          break label754;
        }
        paramc = "";
        label240:
        paramd.add(paramc);
        this.GeQ.GeB = true;
        paramd = ((Iterable)this.GeQ.Ged.getMediaList()).iterator();
        while (paramd.hasNext())
        {
          paramc = paramd.next();
          if (kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)))
          {
            label312:
            paramc = (dji)paramc;
            if (paramc != null) {
              k.a(this.GeQ, paramInt, paramc);
            }
            paramc = (Iterable)this.GeQ.Ged.getClipListExt();
            paramd = this.GeQ;
            localObject1 = paramc.iterator();
            label358:
            if (!((Iterator)localObject1).hasNext()) {
              break label769;
            }
            localObject2 = ((Iterable)((FinderItem)((Iterator)localObject1).next()).getMediaList()).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              paramc = ((Iterator)localObject2).next();
            } while (!kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)));
          }
        }
      }
      for (;;)
      {
        paramc = (dji)paramc;
        if (paramc == null) {
          break label358;
        }
        k.a(paramd, paramInt, paramc);
        break label358;
        float f = 1.0F * (float)paramc.field_finishedLength / (float)paramc.field_toltalLength;
        Log.d(((k)localObject1).TAG, "finished " + paramc.field_finishedLength + ", total " + paramc.field_toltalLength + ", progress " + f);
        paramc = ((k)localObject1).Gey.get(paramString);
        kotlin.g.b.s.checkNotNull(paramc);
        if (f > ((Number)paramc).floatValue())
        {
          paramc = ((k)localObject1).Gey;
          kotlin.g.b.s.checkNotNull(paramString);
          paramc.put(paramString, Float.valueOf(f));
        }
        f = p.E((Iterable)((k)localObject1).Gey.values()) / ((k)localObject1).Gey.size();
        paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
        int i = com.tencent.mm.plugin.finder.storage.d.eQG();
        paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
        i += (int)(com.tencent.mm.plugin.finder.storage.d.eQG() * f);
        Log.i(((k)localObject1).TAG, "feed " + ((k)localObject1).ABX.field_localId + " updateProgress  " + f + ", " + i);
        if (((k)localObject1).Ged.getPostInfo().aaPw < i)
        {
          ((k)localObject1).Ged.getPostInfo().aaPw = i;
          ((k)localObject1).feB();
        }
        paramc = new ic();
        paramc.hJy.localId = ((k)localObject1).ABX.field_localId;
        paramc.hJy.progress = ((k)localObject1).Ged.getPostInfo().aaPw;
        paramc.publish();
        break;
        label754:
        paramc = paramString;
        break label240;
        paramc = null;
        break label312;
        paramc = null;
      }
      label769:
      this.GeQ.ut(false);
      paramString = this.GeQ;
      paramc = this.GeQ.ABX;
      paramd = c.GdZ;
      k.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramc, c.fev()));
      label813:
      AppMethodBeat.o(343127);
      return 0;
      label820:
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.GeQ.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          localObject1 = this.GeQ.wre;
          if (paramString == null)
          {
            paramc = "";
            ((List)localObject1).add(paramc);
            this.GeQ.GeB = true;
            localObject1 = ((Iterable)this.GeQ.Ged.getMediaList()).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)))
              {
                label972:
                paramc = (dji)paramc;
                if (paramc != null) {
                  k.a(this.GeQ, paramd.field_retCode, paramc);
                }
                paramc = (Iterable)this.GeQ.Ged.getClipListExt();
                localObject1 = this.GeQ;
                localObject2 = paramc.iterator();
                label1022:
                if (!((Iterator)localObject2).hasNext()) {
                  break label1128;
                }
                localObject3 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  paramc = ((Iterator)localObject3).next();
                } while (!kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)));
              }
            }
          }
          for (;;)
          {
            paramc = (dji)paramc;
            if (paramc == null) {
              break label1022;
            }
            k.a((k)localObject1, paramd.field_retCode, paramc);
            break label1022;
            paramc = paramString;
            break;
            paramc = null;
            break label972;
            paramc = null;
          }
          label1128:
          this.GeQ.ut(false);
          paramString = this.GeQ;
          paramc = this.GeQ.ABX;
          paramd = c.GdZ;
          k.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramc, c.fev()));
          AppMethodBeat.o(343127);
          return 0;
        }
        this.GeQ.Gez.remove(paramString);
        localObject2 = this.GeQ.Ged.getMediaList();
        localObject3 = new LinkedList();
        paramc = ((Iterable)this.GeQ.Ged.getClipListExt()).iterator();
        while (paramc.hasNext()) {
          ((LinkedList)localObject3).addAll((Collection)((FinderItem)paramc.next()).getMediaList());
        }
        paramInt = this.GeQ.Gez.size();
        Log.i(this.GeQ.TAG, kotlin.g.b.s.X("%s waitToUpload %d media localId:", Long.valueOf(this.GeQ.ABX.field_localId)), new Object[] { Long.valueOf(this.GeQ.ABX.field_localId), Integer.valueOf(paramInt) });
        localObject1 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramc = ((Iterator)localObject1).next();
          if (kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)))
          {
            localObject1 = (dji)paramc;
            paramc = (com.tencent.mm.g.c)localObject1;
            if (localObject1 != null) {
              break label1592;
            }
            localObject1 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (kotlin.g.b.s.p(((dji)paramc).mediaId, k.aBs(paramString)))
              {
                paramString = paramc;
                paramString = (dji)paramString;
                paramc = paramString;
                if (paramString == null) {
                  break label1592;
                }
                paramBoolean = true;
              }
            }
          }
        }
      }
      for (;;)
      {
        label1441:
        if (paramString != null)
        {
          paramc = this.GeQ;
          Log.i(paramc.TAG, kotlin.g.b.s.X("hitMedia, isClip:", Boolean.valueOf(paramBoolean)));
          paramString.mediaId = MD5Util.getMD5String(paramString.url);
          paramString.aaPd = paramd.field_fileUrl;
          paramString.aaPe = paramd.field_thumbUrl;
          paramString.md5sum = paramd.field_filemd5;
          paramc.Ged.setMediaList((LinkedList)localObject2);
          k.a(paramc, 0, paramString);
          paramc.feB();
        }
        if (paramInt == 0)
        {
          this.GeQ.ut(true);
          k.a(this.GeQ, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new h(this.GeQ.ABX));
        }
        AppMethodBeat.o(343127);
        return 0;
        paramc = null;
        break;
        paramString = null;
        break label1441;
        label1592:
        paramBoolean = false;
        paramString = paramc;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.k
 * JD-Core Version:    0.7.0.1
 */