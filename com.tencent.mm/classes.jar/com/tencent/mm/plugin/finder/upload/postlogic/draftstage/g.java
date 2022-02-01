package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.epm;
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
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "cancel", "", "cdnCallback", "com/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "setDraftItem", "draftModifyListener", "com/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage$draftModifyListener$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage$draftModifyListener$1;", "failedList", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "getStageType", "", "isLongVideo", "media", "isRemoteUpload", "onFailed", "nextStage", "onSuccess", "onWait", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "setResult", "stage", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullCoverImage", "uploadFullThumbImage", "uploadLocalMedia", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  com.tencent.mm.plugin.finder.storage.i ABX;
  private List<dji> GeA;
  boolean GeB;
  private final List<com.tencent.mm.g.g> GeC;
  private final FinderDraftUploadStage.draftModifyListener.1 GeD;
  private final a GeE;
  final FinderItem Ged;
  private com.tencent.mm.plugin.finder.upload.postlogic.base.e Gev;
  private boolean Gew;
  private final djj Gex;
  final Map<String, Float> Gey;
  final ConcurrentLinkedQueue<String> Gez;
  final String TAG;
  boolean cancel;
  private long startTime;
  List<String> wre;
  private CountDownLatch yuW;
  
  public g(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343053);
    this.ABX = parami;
    this.TAG = "LogPost.FinderDraftUploadStage";
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
    this.GeD = new FinderDraftUploadStage.draftModifyListener.1(this, com.tencent.mm.app.f.hfK);
    this.GeE = new a(this);
    AppMethodBeat.o(343053);
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
    AppMethodBeat.i(343142);
    g(paramdji);
    FinderMediaReportObject localFinderMediaReportObject = paramdji.aaPt;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramdji = paramdji.aaPt;
    if (paramdji != null) {
      paramdji.cdnControl = paramInt;
    }
    AppMethodBeat.o(343142);
  }
  
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.e bg(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(343086);
    int i;
    int j;
    Object localObject2;
    try
    {
      this.Gex.aaPu = 0;
      this.Ged.setPostInfo(this.Gex);
      Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
      com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
      this.GeC.clear();
      localObject1 = com.tencent.mm.plugin.finder.upload.n.Gcm;
      if ((com.tencent.mm.plugin.finder.upload.n.fdY()) && (Log.getLogLevel() <= 1))
      {
        Log.i(this.TAG, "debugDeleteFileWhenUpload");
        localObject1 = bm.GlZ;
        com.tencent.mm.vfs.y.ew(bm.fiu(), true);
      }
      localObject1 = this.Ged.getFeedObject().objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = this.Ged.getFeedObject().objectDesc;
          if (localObject1 == null) {
            break label643;
          }
          localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
          if ((localObject1 == null) || (((bqz)localObject1).ZZa != 1)) {
            break label643;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = this.Ged.getFeedObject().objectDesc;
            if (localObject1 != null) {
              break label648;
            }
            localObject1 = null;
            if (localObject1 != null)
            {
              localObject1 = this.Ged.getFeedObject().objectDesc;
              if (localObject1 != null) {
                break label676;
              }
              localObject1 = null;
              localObject1 = (CharSequence)localObject1;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label722;
              }
              i = 1;
              if (i != 0)
              {
                localObject1 = this.Ged.getFeedObject().objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
                  if (localObject1 != null)
                  {
                    localObject1 = ((bqz)localObject1).musicInfo;
                    if (localObject1 != null)
                    {
                      localObject3 = ((bqj)localObject1).ZYp;
                      if ((localObject3 != null) && (!kotlin.n.n.U((String)localObject3, "http", true)))
                      {
                        if (com.tencent.mm.vfs.y.ZC((String)localObject3)) {
                          break label727;
                        }
                        Log.i(this.TAG, "audio track " + (String)localObject3 + " is not file");
                      }
                    }
                  }
                }
              }
            }
          }
        }
        localObject1 = this.Ged.getPostInfo().aaPB;
        if (localObject1 != null) {
          break label904;
        }
        localObject1 = null;
        if (Util.isNullOrNil((String)localObject1)) {
          break label914;
        }
        i = 1;
        if (i != 0) {
          break label2012;
        }
        paramLinkedList = paramLinkedList.iterator();
        do
        {
          if (!paramLinkedList.hasNext()) {
            break label2133;
          }
          localObject1 = (dji)paramLinkedList.next();
          if (Util.isNullOrNil(((dji)localObject1).url)) {
            break label1899;
          }
          localObject3 = ((dji)localObject1).mediaId;
          Log.i(this.TAG, "uploading media " + localObject3 + ", " + ((dji)localObject1).url + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).url)) + " thumb: " + ((dji)localObject1).thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).thumbUrl)));
          s.s(localObject1, "media");
          if ((Util.isNullOrNil(((dji)localObject1).aaPd)) || (Util.isNullOrNil(((dji)localObject1).aaPe))) {
            break label938;
          }
          Log.i(this.TAG, "mediaObject svr_url and svr_thumbUrl exist");
          i = e((dji)localObject1);
          j = d((dji)localObject1);
          if (i == 0) {
            break;
          }
        } while (i == 0);
        TO(i);
        ut(false);
        paramLinkedList = this.ABX;
        localObject1 = c.GdZ;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
        AppMethodBeat.o(343086);
        return paramLinkedList;
      }
    }
    catch (Exception localException)
    {
      label643:
      label648:
      label676:
      label722:
      label727:
      label1883:
      label1899:
      do
      {
        for (;;)
        {
          Object localObject3;
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
          continue;
          localObject2 = localException.feedBgmInfo;
          continue;
          i = 0;
          continue;
          localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
          if (localObject2 == null)
          {
            localObject2 = null;
          }
          else
          {
            localObject2 = ((bqz)localObject2).musicInfo;
            continue;
            localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
            if (localObject2 == null)
            {
              localObject2 = null;
            }
            else
            {
              localObject2 = ((bqz)localObject2).musicInfo;
              if (localObject2 == null)
              {
                localObject2 = null;
              }
              else
              {
                localObject2 = ((bqj)localObject2).HsD;
                continue;
                i = 0;
                continue;
                localObject2 = new com.tencent.mm.g.g();
                ((com.tencent.mm.g.g)localObject2).lwL = ((com.tencent.mm.g.g.a)this.GeE);
                Object localObject4 = MD5Util.getMD5String((String)localObject3);
                s.s(localObject4, "getMD5String(path)");
                ((com.tencent.mm.g.g)localObject2).field_mediaId = s.X("uploaddraft_", localObject4);
                ((com.tencent.mm.g.g)localObject2).field_fullpath = ((String)localObject3);
                ((com.tencent.mm.g.g)localObject2).field_needStorage = true;
                ((com.tencent.mm.g.g)localObject2).field_fileType = 20302;
                ((com.tencent.mm.g.g)localObject2).field_appType = 251;
                ((com.tencent.mm.g.g)localObject2).lxc = 8;
                ((com.tencent.mm.g.g)localObject2).field_bzScene = 2;
                ((com.tencent.mm.g.g)localObject2).lwP = 60;
                ((com.tencent.mm.g.g)localObject2).lwQ = 600;
                ((com.tencent.mm.g.g)localObject2).field_priority = com.tencent.mm.g.a.lvZ;
                this.Gez.add(((com.tencent.mm.g.g)localObject2).field_mediaId);
                localObject3 = this.Gey;
                localObject4 = ((com.tencent.mm.g.g)localObject2).field_mediaId;
                s.s(localObject4, "info.field_mediaId");
                ((Map)localObject3).put(localObject4, Float.valueOf(0.0F));
                this.GeC.add(localObject2);
                continue;
                localObject2 = ((epm)localObject2).AyS;
                continue;
                i = 0;
                continue;
                if (j != 0)
                {
                  i = j;
                }
                else
                {
                  i = f((dji)localObject2);
                  continue;
                  if (!com.tencent.mm.vfs.y.ZC(((dji)localObject2).url))
                  {
                    Log.i(this.TAG, "mediaObject.url " + ((dji)localObject2).url + " is not file");
                    i = 1;
                  }
                  else
                  {
                    localObject3 = new com.tencent.mm.g.g();
                    ((com.tencent.mm.g.g)localObject3).taskName = "task_FinderUploadTask_1";
                    ((com.tencent.mm.g.g)localObject3).lwL = ((com.tencent.mm.g.g.a)this.GeE);
                    localObject4 = MD5Util.getMD5String(((dji)localObject2).url);
                    s.s(localObject4, "getMD5String(mediaObject.url)");
                    ((com.tencent.mm.g.g)localObject3).field_mediaId = s.X("uploaddraft_", localObject4);
                    ((com.tencent.mm.g.g)localObject3).field_fullpath = ((dji)localObject2).url;
                    ((com.tencent.mm.g.g)localObject3).field_thumbpath = ((dji)localObject2).thumbUrl;
                    ((com.tencent.mm.g.g)localObject3).field_talker = "";
                    ((com.tencent.mm.g.g)localObject3).field_needStorage = true;
                    Log.i(this.TAG, "upload file length " + com.tencent.mm.vfs.y.bEl(((dji)localObject2).url) + " mediaId: " + ((com.tencent.mm.g.g)localObject3).field_mediaId + " localId:" + this.ABX.field_localId);
                    String str;
                    switch (((dji)localObject2).mediaType)
                    {
                    case 3: 
                    case 5: 
                    case 6: 
                    default: 
                      Log.e(this.TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(((dji)localObject2).mediaType) });
                      i = 0;
                      break;
                    case 2: 
                    case 7: 
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
                      s.s(str, "info.field_mediaId");
                      ((Map)localObject4).put(str, Float.valueOf(0.0F));
                      com.tencent.mm.modelcdntran.k.bHW().Ny(((com.tencent.mm.g.g)localObject3).field_mediaId);
                      this.GeC.add(localObject3);
                      j = e((dji)localObject2);
                      int k = d((dji)localObject2);
                      i = j;
                      if (j == 0) {
                        if (k != 0) {
                          i = k;
                        }
                      }
                      break;
                    case 4: 
                      boolean bool1 = SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.g.g)localObject3).field_fullpath);
                      localObject4 = av.GiL;
                      localObject4 = ((com.tencent.mm.g.g)localObject3).field_fullpath;
                      s.s(localObject4, "info.field_fullpath");
                      boolean bool2 = av.aBO((String)localObject4);
                      Log.i(this.TAG, aUE() + " optimize result: " + bool1 + ", isOptimize:" + bool2);
                      if (!bool1) {
                        e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "optimizeMP4VFS_fail", bool2, null, false, (kotlin.g.a.a)new b(this), 28);
                      }
                      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "opt_moov_fail", bool2, null, false, (kotlin.g.a.a)new c(this), 28);
                      ((com.tencent.mm.g.g)localObject3).field_fileType = 20302;
                      ((com.tencent.mm.g.g)localObject3).field_appType = 251;
                      ((com.tencent.mm.g.g)localObject3).lxc = 8;
                      ((com.tencent.mm.g.g)localObject3).field_bzScene = 2;
                      ((com.tencent.mm.g.g)localObject3).lwP = 600;
                      ((com.tencent.mm.g.g)localObject3).lwQ = 1200;
                      localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
                      l = com.tencent.mm.plugin.finder.storage.d.eQi();
                      localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
                      StringBuilder localStringBuilder;
                      if ((l > com.tencent.mm.plugin.finder.storage.d.eQm()) || (h((dji)localObject2)))
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
                            a(0, (dji)localObject2);
                            localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
                            localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
                            com.tencent.mm.plugin.finder.utils.k.a(com.tencent.mm.plugin.finder.utils.k.feM());
                          }
                        }
                      }
                      for (;;)
                      {
                        if (h((dji)localObject2))
                        {
                          ((com.tencent.mm.g.g)localObject3).lwP = 600;
                          ((com.tencent.mm.g.g)localObject3).lwQ = 1200;
                          break;
                          bool1 = false;
                          break label1696;
                          localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
                          if (com.tencent.mm.plugin.finder.storage.d.eTp() == 1)
                          {
                            localObject4 = k((com.tencent.mm.g.g)localObject3);
                            str = this.TAG;
                            localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                            if (localObject4 != null) {
                              break label1883;
                            }
                          }
                        }
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        Log.i(str, bool1 + ", path:" + ((com.tencent.mm.g.g)localObject3).field_fullpath);
                        a(1, (dji)localObject2);
                        localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
                        localObject4 = com.tencent.mm.plugin.finder.utils.k.Ggi;
                        com.tencent.mm.plugin.finder.utils.k.a(com.tencent.mm.plugin.finder.utils.k.feM());
                        break label1748;
                        break;
                      }
                      i = f((dji)localObject2);
                    }
                  }
                }
              }
            }
          }
        }
      } while ((((dji)localObject2).mediaType != 2) && (((dji)localObject2).mediaType != 7) && (((dji)localObject2).mediaType != 4));
      label904:
      label914:
      label938:
      label1748:
      Log.i(this.TAG, "uploadFinderContent media.url invalid, url:" + ((dji)localObject2).url + ", type:" + ((dji)localObject2).mediaType);
      label1696:
      TO(2);
      ut(false);
      paramLinkedList = this.ABX;
      localObject2 = c.GdZ;
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
      AppMethodBeat.o(343086);
      return paramLinkedList;
    }
    label2012:
    paramLinkedList = (dji)p.oL((List)paramLinkedList);
    if (paramLinkedList != null)
    {
      i = e(paramLinkedList);
      j = d(paramLinkedList);
      if (i != 0)
      {
        TO(i);
        ut(false);
        paramLinkedList = this.ABX;
        localObject2 = c.GdZ;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
        AppMethodBeat.o(343086);
        return paramLinkedList;
      }
      if (j != 0)
      {
        TO(j);
        ut(false);
        paramLinkedList = this.ABX;
        localObject2 = c.GdZ;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramLinkedList, c.fev());
        AppMethodBeat.o(343086);
        return paramLinkedList;
      }
    }
    label2133:
    Log.i(this.TAG, s.X("upload info count:", Integer.valueOf(this.GeC.size())));
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
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new e(this.ABX);
      AppMethodBeat.o(343086);
      return paramLinkedList;
    }
    paramLinkedList = i.c.FoQ;
    i.c.tG(this.Ged.isLongVideo());
    this.yuW.await();
    paramLinkedList = this.Gev;
    AppMethodBeat.o(343086);
    return paramLinkedList;
  }
  
  private final int d(dji paramdji)
  {
    AppMethodBeat.i(343108);
    if ((paramdji.mediaType == 4) && (!Util.isNullOrNil(paramdji.HaI)))
    {
      if (!Util.isNullOrNil(paramdji.aaPq))
      {
        Log.i(this.TAG, "mediaObject svr_fullCoverUrl exist");
        AppMethodBeat.o(343108);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.HaI))
      {
        Log.w(this.TAG, s.X("upload failed, fullCoverUrl not exist, ", paramdji.HaI));
        AppMethodBeat.o(343108);
        return 0;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((com.tencent.mm.g.g.a)this.GeE);
      String str = MD5Util.getMD5String(paramdji.HaI);
      s.s(str, "getMD5String(mediaObject.fullCoverUrl)");
      localg.field_mediaId = s.X("uploaddraft_", str);
      localg.field_fullpath = paramdji.HaI;
      localg.field_thumbpath = paramdji.HaI;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(this.TAG, s.X("upload fullCover file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(paramdji.HaI))));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.lwP = 120;
      localg.lwQ = 300;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      this.Gez.add(localg.field_mediaId);
      paramdji = this.Gey;
      str = localg.field_mediaId;
      s.s(str, "info.field_mediaId");
      paramdji.put(str, Float.valueOf(0.0F));
      this.GeC.add(localg);
    }
    AppMethodBeat.o(343108);
    return 0;
  }
  
  private final int e(dji paramdji)
  {
    AppMethodBeat.i(343115);
    if ((paramdji.mediaType == 4) && (!Util.isNullOrNil(paramdji.coverUrl)))
    {
      if (!Util.isNullOrNil(paramdji.aaPg))
      {
        Log.i(this.TAG, "mediaObject svr_coverUrl exist");
        AppMethodBeat.o(343115);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.coverUrl))
      {
        Log.w(this.TAG, s.X("upload failed, coverUrl not exist, ", paramdji.coverUrl));
        AppMethodBeat.o(343115);
        return 5;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((com.tencent.mm.g.g.a)this.GeE);
      String str = MD5Util.getMD5String(paramdji.coverUrl);
      s.s(str, "getMD5String(mediaObject.coverUrl)");
      localg.field_mediaId = s.X("uploaddraft_", str);
      localg.field_fullpath = paramdji.coverUrl;
      localg.field_thumbpath = paramdji.coverUrl;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(this.TAG, s.X("upload cover file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(paramdji.coverUrl))));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.lwP = 120;
      localg.lwQ = 300;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      this.Gez.add(localg.field_mediaId);
      paramdji = this.Gey;
      str = localg.field_mediaId;
      s.s(str, "info.field_mediaId");
      paramdji.put(str, Float.valueOf(0.0F));
      this.GeC.add(localg);
    }
    AppMethodBeat.o(343115);
    return 0;
  }
  
  private final int f(dji paramdji)
  {
    AppMethodBeat.i(343129);
    if (!Util.isNullOrNil(paramdji.aaPi))
    {
      if (!Util.isNullOrNil(paramdji.aaPk))
      {
        Log.i(this.TAG, "mediaObject svr_fullThumbUrl exist");
        AppMethodBeat.o(343129);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.aaPi))
      {
        Log.w(this.TAG, s.X("upload failed, fullThumbUrl not exist, ", paramdji.aaPi));
        AppMethodBeat.o(343129);
        return 6;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((com.tencent.mm.g.g.a)this.GeE);
      String str = MD5Util.getMD5String(paramdji.aaPi);
      s.s(str, "getMD5String(mediaObject.fullThumbUrl)");
      localg.field_mediaId = s.X("uploaddraft_", str);
      localg.field_fullpath = paramdji.aaPi;
      localg.field_thumbpath = paramdji.aaPi;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(this.TAG, s.X("upload fullthumb file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(paramdji.aaPi))));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.lwP = 120;
      localg.lwQ = 300;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      this.Gez.add(localg.field_mediaId);
      paramdji = this.Gey;
      str = localg.field_mediaId;
      s.s(str, "info.field_mediaId");
      paramdji.put(str, Float.valueOf(0.0F));
      this.GeC.add(localg);
    }
    AppMethodBeat.o(343129);
    return 0;
  }
  
  private final void g(dji paramdji)
  {
    AppMethodBeat.i(343148);
    Object localObject1 = paramdji.aaPt;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null)
      {
        Object localObject2 = (g)this;
        localObject1 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
        ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
        ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - ((g)localObject2).startTime));
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
      AppMethodBeat.o(343148);
      return;
      ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
      ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
      ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - this.startTime));
    }
  }
  
  private final boolean h(dji paramdji)
  {
    AppMethodBeat.i(343152);
    Iterator localIterator = this.GeA.iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (!s.p(((dji)localIterator.next()).mediaId, paramdji.mediaId)) {}
    }
    for (;;)
    {
      if (i < 0) {
        break label73;
      }
      AppMethodBeat.o(343152);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(343152);
    return false;
  }
  
  private final com.tencent.mm.plugin.sight.base.b k(com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(343094);
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
      Log.i(this.TAG, s.X("customHeader ", str));
      paramg.customHeader = str;
      AppMethodBeat.o(343094);
      return localb;
    }
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343202);
    String str = s.X("uploaddraft_", Long.valueOf(this.ABX.field_localId));
    AppMethodBeat.o(343202);
    return str;
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343207);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343207);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343210);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343210);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343214);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343214);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343186);
    this.GeD.alive();
    this.Ged.trackDraftPost("upload");
    Object localObject = this.Ged.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).postStage = 3;
    }
    this.startTime = cn.bDw();
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eTE().bmg()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.d.eTE().bmg()).longValue() * 1000L);
    }
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 2)
    {
      localObject = this.ABX;
      c.a locala = c.GdZ;
      localObject = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject, c.fev());
      AppMethodBeat.o(343186);
      return localObject;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).addAll((Collection)this.Ged.getHalfVideoMediaExtList());
    ((LinkedList)localObject).addAll((Collection)this.Ged.getMediaList());
    if (this.Ged.getLongVideoMediaExtList().size() > 0) {
      ((LinkedList)localObject).clear();
    }
    ((LinkedList)localObject).addAll((Collection)this.Ged.getLongVideoMediaExtList());
    this.GeA.addAll((Collection)this.Ged.getLongVideoMediaExtList());
    localObject = bg((LinkedList)localObject);
    AppMethodBeat.o(343186);
    return localObject;
  }
  
  public final int fer()
  {
    return 3;
  }
  
  final void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(343193);
    if (!paramBoolean) {}
    try
    {
      this.Gew = false;
      if (!paramBoolean) {
        this.Gex.aaPu = 2;
      }
      this.Gex.mnY = (cn.bDu() - this.startTime);
      this.Ged.setPostInfo(this.Gex);
      Object localObject = i.b.Fox;
      i.b.E(this.Gex.mnY, this.Ged.isLongVideo());
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
      com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
      AppMethodBeat.o(343193);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(343193);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftUploadStage$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.g.g.a
  {
    a(g paramg) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(343047);
      Object localObject3 = this.GeF.TAG;
      Object localObject4 = "on cdn callback someOneFailed:" + this.GeF.GeB + ", mediaId = %s, startRet = %d, sceneResult %s";
      if (paramd == null) {
        localObject1 = "null";
      }
      Object localObject2;
      for (;;)
      {
        Log.i((String)localObject3, (String)localObject4, new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
        if ((!this.GeF.cancel) && (!this.GeF.GeB)) {
          break;
        }
        AppMethodBeat.o(343047);
        return 0;
        localObject2 = paramd.toString();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      Object localObject1 = this.GeF;
      if (!Util.isNullOrNil(paramString))
      {
        localObject2 = ((g)localObject1).Gey;
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
          AppMethodBeat.o(343047);
          throw paramString;
        }
        if ((((Map)localObject2).containsKey(paramString)) && (paramc != null)) {}
      }
      else
      {
        if (paramInt == 0) {
          break label890;
        }
        Log.e(this.GeF.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramd = this.GeF.wre;
          if (paramString != null) {
            break label870;
          }
          paramc = "";
          label240:
          paramd.add(paramc);
          this.GeF.GeB = true;
          paramd = ((Iterable)this.GeF.Ged.getHalfVideoMediaExtList()).iterator();
          while (paramd.hasNext())
          {
            paramc = paramd.next();
            if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
            {
              label312:
              paramc = (dji)paramc;
              if (paramc != null)
              {
                g.a(this.GeF, paramInt, paramc);
                paramc = ah.aiuX;
                paramc = ah.aiuX;
              }
              paramd = ((Iterable)this.GeF.Ged.getMediaList()).iterator();
              while (paramd.hasNext())
              {
                paramc = paramd.next();
                if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
                {
                  label393:
                  paramc = (dji)paramc;
                  if (paramc != null)
                  {
                    g.a(this.GeF, paramInt, paramc);
                    paramc = ah.aiuX;
                    paramc = ah.aiuX;
                  }
                  paramd = ((Iterable)this.GeF.Ged.getLongVideoMediaExtList()).iterator();
                  do
                  {
                    if (!paramd.hasNext()) {
                      break;
                    }
                    paramc = paramd.next();
                  } while (!s.p(((dji)paramc).mediaId, g.aBr(paramString)));
                }
              }
            }
          }
        }
      }
      for (paramString = paramc;; paramString = null)
      {
        paramString = (dji)paramString;
        if (paramString != null)
        {
          g.a(this.GeF, paramInt, paramString);
          paramString = ah.aiuX;
          paramString = ah.aiuX;
        }
        this.GeF.ut(false);
        paramString = this.GeF;
        paramc = this.GeF.ABX;
        paramd = c.GdZ;
        g.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramc, c.fev()));
        AppMethodBeat.o(343047);
        return 0;
        float f = 1.0F * (float)paramc.field_finishedLength / (float)paramc.field_toltalLength;
        Log.d(((g)localObject1).TAG, "finished " + paramc.field_finishedLength + ", total " + paramc.field_toltalLength + ", progress " + f);
        paramc = ((g)localObject1).Gey.get(paramString);
        s.checkNotNull(paramc);
        if (f > ((Number)paramc).floatValue())
        {
          paramc = ((g)localObject1).Gey;
          s.checkNotNull(paramString);
          paramc.put(paramString, Float.valueOf(f));
        }
        f = p.E((Iterable)((g)localObject1).Gey.values()) / ((g)localObject1).Gey.size();
        paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
        int i = com.tencent.mm.plugin.finder.storage.d.eQG();
        paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
        i += (int)(com.tencent.mm.plugin.finder.storage.d.eQG() * f);
        Log.i(((g)localObject1).TAG, "feed " + ((g)localObject1).ABX.field_localId + " updateProgress  " + f + ", " + i);
        if (((g)localObject1).Ged.getPostInfo().aaPw < i)
        {
          ((g)localObject1).Ged.getPostInfo().aaPw = i;
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
          com.tencent.mm.plugin.finder.storage.logic.c.g(((g)localObject1).ABX);
        }
        paramc = new ic();
        paramc.hJy.localId = ((g)localObject1).ABX.field_localId;
        paramc.hJy.progress = ((g)localObject1).Ged.getPostInfo().aaPw;
        paramc.publish();
        break;
        label870:
        paramc = paramString;
        break label240;
        paramc = null;
        break label312;
        paramc = null;
        break label393;
      }
      label890:
      boolean bool1;
      label1042:
      label1127:
      boolean bool2;
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.GeF.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          localObject1 = this.GeF.wre;
          if (paramString == null)
          {
            paramc = "";
            ((List)localObject1).add(paramc);
            this.GeF.GeB = true;
            localObject1 = ((Iterable)this.GeF.Ged.getHalfVideoMediaExtList()).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
              {
                paramc = (dji)paramc;
                if (paramc != null)
                {
                  g.a(this.GeF, paramd.field_retCode, paramc);
                  paramc = ah.aiuX;
                  paramc = ah.aiuX;
                }
                localObject1 = ((Iterable)this.GeF.Ged.getMediaList()).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  paramc = ((Iterator)localObject1).next();
                  if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
                  {
                    paramc = (dji)paramc;
                    if (paramc != null)
                    {
                      g.a(this.GeF, paramd.field_retCode, paramc);
                      paramc = ah.aiuX;
                      paramc = ah.aiuX;
                    }
                    localObject1 = ((Iterable)this.GeF.Ged.getLongVideoMediaExtList()).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      paramc = ((Iterator)localObject1).next();
                      if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
                      {
                        label1212:
                        paramc = (dji)paramc;
                        if (paramc != null)
                        {
                          g.a(this.GeF, paramd.field_retCode, paramc);
                          paramc = ah.aiuX;
                          paramc = ah.aiuX;
                        }
                        paramc = this.GeF.Ged.getFeedObject().objectDesc;
                        if (paramc != null) {
                          break label1367;
                        }
                        paramc = null;
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            if ((paramc != null) && (s.p(MD5Util.getMD5String(paramc.ZYp), g.aBr(paramString)))) {
              h.OAn.p(1530L, 3L, 1L);
            }
            this.GeF.ut(false);
            paramString = this.GeF;
            paramc = this.GeF.ABX;
            paramd = c.GdZ;
            g.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramc, c.fev()));
            AppMethodBeat.o(343047);
            return 0;
            paramc = paramString;
            break;
            paramc = null;
            break label1042;
            paramc = null;
            break label1127;
            paramc = null;
            break label1212;
            label1367:
            paramc = paramc.feedBgmInfo;
            if (paramc == null) {
              paramc = null;
            } else {
              paramc = paramc.musicInfo;
            }
          }
        }
        this.GeF.Gez.remove(paramString);
        localObject3 = this.GeF.Ged.getMediaList();
        localObject4 = this.GeF.Ged.getLongVideoMediaExtList();
        localObject2 = this.GeF.Ged.getHalfVideoMediaExtList();
        paramInt = this.GeF.Gez.size();
        Log.i(this.GeF.TAG, s.X("%s waitToUpload %d media localId:", Long.valueOf(this.GeF.ABX.field_localId)), new Object[] { Long.valueOf(this.GeF.ABX.field_localId), Integer.valueOf(paramInt) });
        bool1 = false;
        bool2 = false;
        if (localObject3 != null) {
          break label1943;
        }
        paramc = null;
        localObject1 = paramc;
        if (paramc == null)
        {
          if (localObject4 != null) {
            break label2003;
          }
          localObject1 = null;
          if (localObject1 == null) {
            break label2064;
          }
          paramBoolean = true;
          label1540:
          bool1 = paramBoolean;
        }
        if (localObject1 != null) {
          break label2796;
        }
        localObject1 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramc = ((Iterator)localObject1).next();
          if (s.p(((dji)paramc).mediaId, g.aBr(paramString)))
          {
            label1596:
            localObject1 = (dji)paramc;
            if (localObject1 == null) {
              break label2075;
            }
            paramBoolean = true;
          }
        }
      }
      for (;;)
      {
        label1610:
        if (localObject1 != null)
        {
          localObject2 = this.GeF;
          Log.i(((g)localObject2).TAG, "hitMedia, isLongVideo:" + bool1 + ", isHalf:" + paramBoolean);
          ((dji)localObject1).mediaId = MD5Util.getMD5String(((dji)localObject1).url);
          ((dji)localObject1).aaPd = paramd.field_fileUrl;
          ((dji)localObject1).aaPe = paramd.field_thumbUrl;
          ((dji)localObject1).md5sum = paramd.field_filemd5;
          if (bool1) {
            break label2102;
          }
          if (paramBoolean)
          {
            g.a((g)localObject2, 0, (dji)localObject1);
            paramc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
            com.tencent.mm.plugin.finder.storage.logic.c.g(((g)localObject2).ABX);
          }
        }
        else if (localObject1 == null)
        {
          paramc = this.GeF.Ged.getFeedObject().objectDesc;
          if (paramc != null) {
            break label2292;
          }
          paramc = null;
          label1757:
          if (paramc == null) {
            break label2380;
          }
          localObject1 = paramc.ZYp;
          paramc = (com.tencent.mm.g.c)localObject1;
          if (localObject1 == null) {
            paramc = "";
          }
          if (!s.p(MD5Util.getMD5String(paramc), g.aBr(paramString))) {
            break label2380;
          }
          paramString = this.GeF.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2314;
          }
          paramString = null;
          if (paramString != null) {
            paramString.ZYp = paramd.field_fileUrl;
          }
          paramString = this.GeF.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2336;
          }
          paramString = null;
          if (paramString != null) {
            paramString.HsD = "";
          }
          paramString = this.GeF.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2358;
          }
          paramString = null;
        }
        for (;;)
        {
          label1719:
          if (paramString != null) {
            paramString.name = "";
          }
          label1812:
          label1845:
          paramString = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
          com.tencent.mm.plugin.finder.storage.logic.c.g(this.GeF.ABX);
          if (paramInt == 0)
          {
            this.GeF.ut(true);
            g.a(this.GeF, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new e(this.GeF.ABX));
          }
          AppMethodBeat.o(343047);
          return 0;
          label1943:
          localObject1 = ((Iterable)localObject3).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramc = ((Iterator)localObject1).next();
          } while (!s.p(((dji)paramc).mediaId, g.aBr(paramString)));
          for (;;)
          {
            paramc = (dji)paramc;
            break;
            paramc = null;
          }
          label2003:
          localObject1 = ((Iterable)localObject4).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramc = ((Iterator)localObject1).next();
          } while (!s.p(((dji)paramc).mediaId, g.aBr(paramString)));
          for (;;)
          {
            localObject1 = (dji)paramc;
            break;
            paramc = null;
          }
          label2064:
          paramBoolean = false;
          break label1540;
          paramc = null;
          break label1596;
          label2075:
          paramBoolean = false;
          break label1610;
          ((g)localObject2).Ged.setMediaList((LinkedList)localObject3);
          g.a((g)localObject2, 0, (dji)localObject1);
          break label1719;
          label2102:
          paramc = ((g)localObject2).Ged.getFeedObject().attachmentList;
          if (paramc == null) {
            paramc = null;
          }
          for (;;)
          {
            if (paramc != null) {
              paramc.media = com.tencent.mm.plugin.finder.storage.data.n.ba((LinkedList)localObject4);
            }
            ((LinkedList)localObject3).clear();
            ((LinkedList)localObject3).add(localObject1);
            ((g)localObject2).Ged.setMediaList((LinkedList)localObject3);
            g.a((g)localObject2, 0, (dji)localObject1);
            break;
            paramc = paramc.ZEi;
            if (paramc == null)
            {
              paramc = null;
            }
            else
            {
              localIterator = ((Iterable)paramc).iterator();
              atq localatq;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                paramc = localIterator.next();
                localatq = (atq)paramc;
                av localav = av.GiL;
                s.s(localatq, "it");
              } while (!av.a(localatq));
              for (;;)
              {
                paramc = (atq)paramc;
                if (paramc != null) {
                  break label2256;
                }
                paramc = null;
                break;
                paramc = null;
              }
              label2256:
              paramc = paramc.ZEf;
              if (paramc == null)
              {
                paramc = null;
              }
              else
              {
                paramc = paramc.ZXx;
                if (paramc == null) {
                  paramc = null;
                } else {
                  paramc = paramc.aaUt;
                }
              }
            }
          }
          label2292:
          paramc = paramc.feedBgmInfo;
          if (paramc == null)
          {
            paramc = null;
            break label1757;
          }
          paramc = paramc.musicInfo;
          break label1757;
          label2314:
          paramString = paramString.feedBgmInfo;
          if (paramString == null)
          {
            paramString = null;
            break label1812;
          }
          paramString = paramString.musicInfo;
          break label1812;
          label2336:
          paramString = paramString.feedBgmInfo;
          if (paramString == null)
          {
            paramString = null;
            break label1845;
          }
          paramString = paramString.musicInfo;
          break label1845;
          label2358:
          paramString = paramString.feedBgmInfo;
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.musicInfo;
          }
        }
        label2380:
        Iterator localIterator = ((Iterable)localObject3).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          localObject2 = ((dji)localObject1).HaI;
          paramc = (com.tencent.mm.g.c)localObject2;
          if (localObject2 == null) {
            paramc = "";
          }
          if (s.p(MD5Util.getMD5String(paramc), g.aBr(paramString)))
          {
            paramc = (com.tencent.mm.g.c)localObject1;
            label2449:
            paramc = (dji)paramc;
            if (paramc != null)
            {
              Log.i(this.GeF.TAG, s.X("upload fullCover ok, url:", paramd.field_fileUrl));
              paramc.aaPq = paramd.field_fileUrl;
              paramc = (dji)p.oL((List)localObject4);
              if (paramc != null) {
                paramc.aaPq = paramd.field_fileUrl;
              }
              paramc = ah.aiuX;
              paramc = ah.aiuX;
            }
            localIterator = ((Iterable)localObject3).iterator();
            while (localIterator.hasNext())
            {
              localObject1 = localIterator.next();
              localObject2 = ((dji)localObject1).coverUrl;
              paramc = (com.tencent.mm.g.c)localObject2;
              if (localObject2 == null) {
                paramc = "";
              }
              if (s.p(MD5Util.getMD5String(paramc), g.aBr(paramString)))
              {
                paramc = (com.tencent.mm.g.c)localObject1;
                label2590:
                paramc = (dji)paramc;
                if (paramc != null)
                {
                  Log.i(this.GeF.TAG, s.X("upload cover ok, url:", paramd.field_fileUrl));
                  paramc.aaPg = paramd.field_fileUrl;
                  paramc = (dji)p.oL((List)localObject4);
                  if (paramc != null) {
                    paramc.aaPg = paramd.field_fileUrl;
                  }
                  paramc = ah.aiuX;
                  paramc = ah.aiuX;
                }
                localObject3 = ((Iterable)localObject3).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = ((Iterator)localObject3).next();
                  localObject2 = ((dji)localObject1).aaPi;
                  paramc = (com.tencent.mm.g.c)localObject2;
                  if (localObject2 == null) {
                    paramc = "";
                  }
                } while (!s.p(MD5Util.getMD5String(paramc), g.aBr(paramString)));
              }
            }
          }
        }
        for (paramString = (String)localObject1;; paramString = null)
        {
          paramString = (dji)paramString;
          if (paramString == null) {
            break;
          }
          Log.i(this.GeF.TAG, s.X("upload fullThumb ok, url:", paramd.field_fileUrl));
          paramString.aaPk = paramd.field_fileUrl;
          paramString = ah.aiuX;
          paramString = ah.aiuX;
          break;
          paramc = null;
          break label2449;
          paramc = null;
          break label2590;
        }
        label2796:
        paramBoolean = bool2;
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
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.g
 * JD-Core Version:    0.7.0.1
 */