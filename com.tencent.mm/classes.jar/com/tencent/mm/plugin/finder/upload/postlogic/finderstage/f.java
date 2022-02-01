package com.tencent.mm.plugin.finder.upload.postlogic.finderstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.ah.c;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.i;
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
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.protocal.protobuf.ewu;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "cdnCallback", "com/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "failedList", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "cdnErrorCheckTemplateHandle", "mediaId", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "getStageType", "", "handleTemplateScyThumb", "serverUrl", "isLongVideo", "media", "isRemoteUpload", "onFailed", "nextStage", "onSuccess", "onWait", "packageTemplateScyImgToLocalFinderMedia", "Ljava/util/LinkedList;", "prefixMediaId", "resetUploadInfo", "revertMediaId", "setResult", "stage", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "uploadFullCoverImage", "uploadFullThumbImage", "uploadLocalMedia", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  private List<dji> GeA;
  boolean GeB;
  private final List<com.tencent.mm.g.g> GeC;
  boolean GeX;
  private final FinderUploadStage.feedDeleteListener.1 GeY;
  private final a GeZ;
  public FinderItem Ged;
  private com.tencent.mm.plugin.finder.upload.postlogic.base.e Gev;
  private boolean Gew;
  private final djj Gex;
  final Map<String, Float> Gey;
  final ConcurrentLinkedQueue<String> Gez;
  final String TAG;
  private long startTime;
  List<String> wre;
  private CountDownLatch yuW;
  
  public f(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343196);
    this.Ged = paramFinderItem;
    this.TAG = "LogPost.FinderUploadStage";
    this.Gex = this.Ged.field_postinfo;
    this.Gey = ((Map)new LinkedHashMap());
    this.Gez = new ConcurrentLinkedQueue();
    this.GeA = ((List)new ArrayList());
    this.wre = ((List)new ArrayList());
    this.GeC = ((List)new ArrayList());
    paramFinderItem = this.Ged;
    g.a locala = g.Gfb;
    this.Gev = ((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramFinderItem, g.fev()));
    this.yuW = new CountDownLatch(1);
    this.GeY = new FinderUploadStage.feedDeleteListener.1(this, com.tencent.mm.app.f.hfK);
    this.GeZ = new a(this);
    AppMethodBeat.o(343196);
  }
  
  private final LinkedList<dji> A(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(343205);
    paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
    if (paramFinderItem == null) {
      paramFinderItem = null;
    }
    while ((paramFinderItem == null) || (paramFinderItem.abyV.size() == 0))
    {
      AppMethodBeat.o(343205);
      return null;
      paramFinderItem = paramFinderItem.video_tmpl_info;
      if (paramFinderItem == null) {
        paramFinderItem = null;
      } else {
        paramFinderItem = paramFinderItem.aaia;
      }
    }
    LinkedList localLinkedList = new LinkedList();
    paramFinderItem = paramFinderItem.abyV;
    s.s(paramFinderItem, "templateScyList.frame_urls");
    paramFinderItem = ((Iterable)paramFinderItem).iterator();
    while (paramFinderItem.hasNext())
    {
      String str = (String)paramFinderItem.next();
      if (com.tencent.mm.vfs.y.ZC(str))
      {
        dji localdji = new dji();
        localdji.mediaType = 2;
        localdji.url = str;
        s.s(str, "it");
        if (kotlin.n.n.i((CharSequence)str, (CharSequence)"http")) {
          localdji.aaPd = str;
        }
        localLinkedList.add(localdji);
        Log.i(this.TAG, s.X("add TemplateScy media:", str));
      }
      else
      {
        Log.e(this.TAG, s.X("TemplateScyImgToLocalFinderMedia error,for file not exist:", str));
      }
    }
    AppMethodBeat.o(343205);
    return localLinkedList;
  }
  
  private final void a(int paramInt, dji paramdji)
  {
    AppMethodBeat.i(343266);
    g(paramdji);
    FinderMediaReportObject localFinderMediaReportObject = paramdji.aaPt;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramdji = paramdji.aaPt;
    if (paramdji != null) {
      paramdji.cdnControl = paramInt;
    }
    AppMethodBeat.o(343266);
  }
  
  static String aBt(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(343263);
    if ((paramString != null) && (kotlin.n.n.U(paramString, "upload_", false) == true)) {}
    while (i != 0) {
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(343263);
        throw paramString;
        i = 0;
      }
      else
      {
        paramString = paramString.substring(7);
        s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        AppMethodBeat.o(343263);
        return paramString;
      }
    }
    if (paramString == null)
    {
      AppMethodBeat.o(343263);
      return "";
    }
    AppMethodBeat.o(343263);
    return paramString;
  }
  
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.e bg(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(343233);
    int i;
    Object localObject2;
    label643:
    label648:
    label676:
    label722:
    label727:
    int j;
    try
    {
      this.Gex.aaPu = 0;
      Object localObject1 = this.Ged;
      localObject3 = this.Gex;
      s.s(localObject3, "postinfo");
      ((FinderItem)localObject1).setPostInfo((djj)localObject3);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      d.a.v(this.Ged);
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
          break label2284;
        }
        paramLinkedList = paramLinkedList.iterator();
        do
        {
          if (!paramLinkedList.hasNext()) {
            break label2405;
          }
          localObject1 = (dji)paramLinkedList.next();
          if (Util.isNullOrNil(((dji)localObject1).url)) {
            break label2171;
          }
          localObject3 = ((dji)localObject1).mediaId;
          Log.i(this.TAG, "uploading media " + localObject3 + ", " + ((dji)localObject1).url + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).url)) + " thumb: " + ((dji)localObject1).thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(((dji)localObject1).thumbUrl)));
          s.s(localObject1, "media");
          if ((Util.isNullOrNil(((dji)localObject1).aaPd)) || (Util.isNullOrNil(((dji)localObject1).aaPe))) {
            break;
          }
          Log.i(this.TAG, "mediaObject svr_url and svr_thumbUrl exist");
          i = 0;
        } while (i == 0);
        TO(i);
        ut(false);
        paramLinkedList = this.Ged;
        localObject1 = g.Gfb;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramLinkedList, g.fev());
        AppMethodBeat.o(343233);
        return paramLinkedList;
      }
    }
    catch (Exception localException)
    {
      label904:
      label914:
      label1734:
      label1869:
      label2171:
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
                ((com.tencent.mm.g.g)localObject2).lwL = ((com.tencent.mm.g.g.a)this.GeZ);
                Object localObject4 = MD5Util.getMD5String((String)localObject3);
                s.s(localObject4, "getMD5String(path)");
                ((com.tencent.mm.g.g)localObject2).field_mediaId = s.X("upload_", localObject4);
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
                if (!com.tencent.mm.vfs.y.ZC(((dji)localObject2).url))
                {
                  Log.i(this.TAG, "mediaObject.url " + ((dji)localObject2).url + " is not file");
                  this.Ged.setPostFailedAndNotRetry(0);
                  i = 1;
                }
                else
                {
                  localObject3 = new com.tencent.mm.g.g();
                  ((com.tencent.mm.g.g)localObject3).taskName = "task_FinderUploadTask_1";
                  ((com.tencent.mm.g.g)localObject3).lwL = ((com.tencent.mm.g.g.a)this.GeZ);
                  localObject4 = MD5Util.getMD5String(((dji)localObject2).url);
                  s.s(localObject4, "getMD5String(mediaObject.url)");
                  ((com.tencent.mm.g.g)localObject3).field_mediaId = s.X("upload_", localObject4);
                  ((com.tencent.mm.g.g)localObject3).field_fullpath = ((dji)localObject2).url;
                  ((com.tencent.mm.g.g)localObject3).field_thumbpath = ((dji)localObject2).thumbUrl;
                  ((com.tencent.mm.g.g)localObject3).field_talker = "";
                  ((com.tencent.mm.g.g)localObject3).field_needStorage = true;
                  Log.i(this.TAG, "upload file length " + com.tencent.mm.vfs.y.bEl(((dji)localObject2).url) + " mediaId: " + ((com.tencent.mm.g.g)localObject3).field_mediaId + " localId:" + this.Ged.getLocalId());
                  String str;
                  switch (((dji)localObject2).mediaType)
                  {
                  case 3: 
                  case 5: 
                  case 6: 
                  default: 
                    Log.e(this.TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(((dji)localObject2).mediaType) });
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
                        break label1682;
                        localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
                        if (com.tencent.mm.plugin.finder.storage.d.eTp() == 1)
                        {
                          localObject4 = k((com.tencent.mm.g.g)localObject3);
                          str = this.TAG;
                          localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                          if (localObject4 != null) {
                            break label1869;
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
                      break label1734;
                      break;
                    }
                    if (!Util.isNullOrNil(((dji)localObject2).aaPi)) {
                      if (!Util.isNullOrNil(((dji)localObject2).aaPk))
                      {
                        Log.i(this.TAG, "mediaObject svr_fullThumbUrl exist");
                      }
                      else if (!com.tencent.mm.vfs.y.ZC(((dji)localObject2).aaPi))
                      {
                        Log.w(this.TAG, s.X("upload failed, fullThumbUrl not exist, ", ((dji)localObject2).aaPi));
                        i = 6;
                      }
                      else
                      {
                        localObject3 = new com.tencent.mm.g.g();
                        ((com.tencent.mm.g.g)localObject3).taskName = "task_FinderUploadTask_2";
                        ((com.tencent.mm.g.g)localObject3).lwL = ((com.tencent.mm.g.g.a)this.GeZ);
                        localObject4 = MD5Util.getMD5String(((dji)localObject2).aaPi);
                        s.s(localObject4, "getMD5String(mediaObject.fullThumbUrl)");
                        ((com.tencent.mm.g.g)localObject3).field_mediaId = s.X("upload_", localObject4);
                        ((com.tencent.mm.g.g)localObject3).field_fullpath = ((dji)localObject2).aaPi;
                        ((com.tencent.mm.g.g)localObject3).field_thumbpath = ((dji)localObject2).aaPi;
                        ((com.tencent.mm.g.g)localObject3).field_talker = "";
                        ((com.tencent.mm.g.g)localObject3).field_needStorage = true;
                        Log.i(this.TAG, s.X("upload fullthumb file length ", Long.valueOf(com.tencent.mm.vfs.y.bEl(((dji)localObject2).aaPi))));
                        ((com.tencent.mm.g.g)localObject3).field_fileType = 20304;
                        ((com.tencent.mm.g.g)localObject3).field_appType = 251;
                        ((com.tencent.mm.g.g)localObject3).field_bzScene = 2;
                        ((com.tencent.mm.g.g)localObject3).lwP = 120;
                        ((com.tencent.mm.g.g)localObject3).lwQ = 300;
                        ((com.tencent.mm.g.g)localObject3).field_priority = com.tencent.mm.g.a.lvZ;
                        this.Gez.add(((com.tencent.mm.g.g)localObject3).field_mediaId);
                        localObject2 = this.Gey;
                        localObject4 = ((com.tencent.mm.g.g)localObject3).field_mediaId;
                        s.s(localObject4, "info.field_mediaId");
                        ((Map)localObject2).put(localObject4, Float.valueOf(0.0F));
                        this.GeC.add(localObject3);
                      }
                    }
                    break;
                  }
                }
              }
            }
          }
        }
      } while ((((dji)localObject2).mediaType != 2) && (((dji)localObject2).mediaType != 7) && (((dji)localObject2).mediaType != 4));
      label1682:
      Log.i(this.TAG, "uploadFinderContent media.url invalid, url:" + ((dji)localObject2).url + ", type:" + ((dji)localObject2).mediaType);
      TO(2);
      ut(false);
      paramLinkedList = this.Ged;
      localObject2 = g.Gfb;
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramLinkedList, g.fev());
      AppMethodBeat.o(343233);
      return paramLinkedList;
    }
    label2284:
    paramLinkedList = (dji)p.oL((List)paramLinkedList);
    if (paramLinkedList != null)
    {
      i = e(paramLinkedList);
      j = d(paramLinkedList);
      if (i != 0)
      {
        TO(i);
        ut(false);
        paramLinkedList = this.Ged;
        localObject2 = g.Gfb;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramLinkedList, g.fev());
        AppMethodBeat.o(343233);
        return paramLinkedList;
      }
      if (j != 0)
      {
        TO(j);
        ut(false);
        paramLinkedList = this.Ged;
        localObject2 = g.Gfb;
        paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramLinkedList, g.fev());
        AppMethodBeat.o(343233);
        return paramLinkedList;
      }
    }
    label2405:
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
      localObject2 = i.Gcb;
      i.a(paramLinkedList, "beginUpload");
    }
    if (this.Gez.size() == 0)
    {
      ut(true);
      paramLinkedList = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(this.Ged);
      AppMethodBeat.o(343233);
      return paramLinkedList;
    }
    paramLinkedList = ah.d.Ftw;
    ah.d.tG(this.Ged.isLongVideo());
    this.yuW.await();
    paramLinkedList = this.Gev;
    AppMethodBeat.o(343233);
    return paramLinkedList;
  }
  
  private final int d(dji paramdji)
  {
    AppMethodBeat.i(343254);
    if ((paramdji.mediaType == 4) && (!Util.isNullOrNil(paramdji.HaI)))
    {
      if (!Util.isNullOrNil(paramdji.aaPq))
      {
        Log.i(this.TAG, "mediaObject svr_fullCoverUrl exist");
        AppMethodBeat.o(343254);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.HaI))
      {
        Log.w(this.TAG, s.X("upload failed, fullCoverUrl not exist, ", paramdji.HaI));
        AppMethodBeat.o(343254);
        return 0;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((com.tencent.mm.g.g.a)this.GeZ);
      String str = MD5Util.getMD5String(paramdji.HaI);
      s.s(str, "getMD5String(mediaObject.fullCoverUrl)");
      localg.field_mediaId = s.X("upload_", str);
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
    AppMethodBeat.o(343254);
    return 0;
  }
  
  private final int e(dji paramdji)
  {
    AppMethodBeat.i(343260);
    if ((paramdji.mediaType == 4) && (!Util.isNullOrNil(paramdji.coverUrl)))
    {
      if (!Util.isNullOrNil(paramdji.aaPg))
      {
        Log.i(this.TAG, "mediaObject svr_coverUrl exist");
        AppMethodBeat.o(343260);
        return 0;
      }
      if (!com.tencent.mm.vfs.y.ZC(paramdji.coverUrl))
      {
        Log.w(this.TAG, s.X("upload failed, coverUrl not exist, ", paramdji.coverUrl));
        AppMethodBeat.o(343260);
        return 5;
      }
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.lwL = ((com.tencent.mm.g.g.a)this.GeZ);
      String str = MD5Util.getMD5String(paramdji.coverUrl);
      s.s(str, "getMD5String(mediaObject.coverUrl)");
      localg.field_mediaId = s.X("upload_", str);
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
    AppMethodBeat.o(343260);
    return 0;
  }
  
  private final void g(dji paramdji)
  {
    AppMethodBeat.i(343269);
    Object localObject1 = paramdji.aaPt;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null)
      {
        Object localObject2 = (f)this;
        localObject1 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
        ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
        ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - ((f)localObject2).startTime));
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
      AppMethodBeat.o(343269);
      return;
      ((FinderMediaReportObject)localObject1).mediaType = paramdji.mediaType;
      ((FinderMediaReportObject)localObject1).mediaId = paramdji.mediaId;
      ((FinderMediaReportObject)localObject1).cdnUploadTime = ((int)(cn.bDw() - this.startTime));
    }
  }
  
  private final boolean h(dji paramdji)
  {
    AppMethodBeat.i(343275);
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
      AppMethodBeat.o(343275);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(343275);
    return false;
  }
  
  private final com.tencent.mm.plugin.sight.base.b k(com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(343239);
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
      AppMethodBeat.o(343239);
      return localb;
    }
  }
  
  final void TO(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.Ged.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343334);
    String str = s.X("upload_", Long.valueOf(this.Ged.getLocalId()));
    AppMethodBeat.o(343334);
    return str;
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343339);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343339);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343348);
    s.u(parame, "nextStage");
    parame = ah.d.Ftw;
    ah.d.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343348);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343357);
    s.u(parame, "nextStage");
    parame = ah.d.Ftw;
    ah.d.tH(this.Ged.isLongVideo());
    AppMethodBeat.o(343357);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343315);
    this.GeY.alive();
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
      localObject1 = this.Ged;
      localObject2 = g.Gfb;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g((FinderItem)localObject1, g.fev());
      AppMethodBeat.o(343315);
      return localObject1;
    }
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).addAll((Collection)this.Ged.getHalfVideoMediaExtList());
    ((LinkedList)localObject1).addAll((Collection)this.Ged.getMediaList());
    if (this.Ged.getLongVideoMediaExtList().size() > 0) {
      ((LinkedList)localObject1).clear();
    }
    ((LinkedList)localObject1).addAll((Collection)this.Ged.getLongVideoMediaExtList());
    Object localObject2 = A(this.Ged);
    if (localObject2 != null) {
      ((LinkedList)localObject1).addAll((Collection)localObject2);
    }
    this.GeA.addAll((Collection)this.Ged.getLongVideoMediaExtList());
    localObject1 = bg((LinkedList)localObject1);
    AppMethodBeat.o(343315);
    return localObject1;
  }
  
  public final int fer()
  {
    return 3;
  }
  
  final void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(343326);
    if (!paramBoolean) {}
    try
    {
      this.Gew = false;
      if (!paramBoolean) {}
      for (this.Gex.aaPu = 2;; this.Gex.aaPu = 1)
      {
        this.Gex.mnY = (cn.bDu() - this.startTime);
        Object localObject = this.Ged;
        djj localdjj = this.Gex;
        s.s(localdjj, "postinfo");
        ((FinderItem)localObject).setPostInfo(localdjj);
        localObject = ah.c.Ftv;
        ah.c.E(this.Gex.mnY, this.Ged.isLongVideo());
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.v(this.Ged);
        AppMethodBeat.o(343326);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(343326);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderUploadStage$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.g.g.a
  {
    a(f paramf) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(343181);
      Object localObject3 = this.Gfa.TAG;
      Object localObject4 = "on cdn callback someOneFailed:" + this.Gfa.GeB + ", mediaId = %s, startRet = %d, sceneResult %s";
      if (paramd == null) {
        localObject1 = "null";
      }
      Object localObject2;
      for (;;)
      {
        Log.i((String)localObject3, (String)localObject4, new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
        if ((!this.Gfa.GeX) && (!this.Gfa.GeB)) {
          break;
        }
        AppMethodBeat.o(343181);
        return 0;
        localObject2 = paramd.toString();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      Object localObject1 = this.Gfa;
      if (!Util.isNullOrNil(paramString))
      {
        localObject2 = ((f)localObject1).Gey;
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
          AppMethodBeat.o(343181);
          throw paramString;
        }
        if ((((Map)localObject2).containsKey(paramString)) && (paramc != null)) {
          break label242;
        }
      }
      while (paramInt != 0)
      {
        Log.e(this.Gfa.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          if (f.a(this.Gfa, paramString))
          {
            AppMethodBeat.o(343181);
            return 0;
            label242:
            float f = 1.0F * (float)paramc.field_finishedLength / (float)paramc.field_toltalLength;
            Log.d(((f)localObject1).TAG, "finished " + paramc.field_finishedLength + ", total " + paramc.field_toltalLength + ", progress " + f);
            paramc = ((f)localObject1).Gey.get(paramString);
            s.checkNotNull(paramc);
            if (f > ((Number)paramc).floatValue())
            {
              paramc = ((f)localObject1).Gey;
              s.checkNotNull(paramString);
              paramc.put(paramString, Float.valueOf(f));
            }
            f = p.E((Iterable)((f)localObject1).Gey.values()) / ((f)localObject1).Gey.size();
            paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
            int i = com.tencent.mm.plugin.finder.storage.d.eQG();
            paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
            i += (int)(com.tencent.mm.plugin.finder.storage.d.eQG() * f);
            Log.i(((f)localObject1).TAG, "feed " + ((f)localObject1).Ged.getLocalId() + " updateProgress  " + f + ", " + i);
            if (((f)localObject1).Ged.getPostInfo().aaPw < i)
            {
              ((f)localObject1).Ged.getPostInfo().aaPw = i;
              paramc = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              d.a.v(((f)localObject1).Ged);
            }
            paramc = new ic();
            paramc.hJy.localId = ((f)localObject1).Ged.getLocalId();
            paramc.hJy.progress = ((f)localObject1).Ged.getPostInfo().aaPw;
            paramc.publish();
            continue;
          }
          paramd = this.Gfa.wre;
          if (paramString != null) {
            break label886;
          }
          paramc = "";
          paramd.add(paramc);
          this.Gfa.GeB = true;
          paramd = ((Iterable)this.Gfa.Ged.getHalfVideoMediaExtList()).iterator();
          while (paramd.hasNext())
          {
            paramc = paramd.next();
            if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
            {
              label645:
              paramc = (dji)paramc;
              if (paramc != null)
              {
                f.a(this.Gfa, paramInt, paramc);
                paramc = ah.aiuX;
                paramc = ah.aiuX;
              }
              paramd = ((Iterable)this.Gfa.Ged.getMediaList()).iterator();
              while (paramd.hasNext())
              {
                paramc = paramd.next();
                if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
                {
                  label726:
                  paramc = (dji)paramc;
                  if (paramc != null)
                  {
                    f.a(this.Gfa, paramInt, paramc);
                    paramc = ah.aiuX;
                    paramc = ah.aiuX;
                  }
                  paramd = ((Iterable)this.Gfa.Ged.getLongVideoMediaExtList()).iterator();
                  do
                  {
                    if (!paramd.hasNext()) {
                      break;
                    }
                    paramc = paramd.next();
                  } while (!s.p(((dji)paramc).mediaId, f.aBt(paramString)));
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
            f.a(this.Gfa, paramInt, paramString);
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
          this.Gfa.ut(false);
          paramString = this.Gfa;
          paramc = this.Gfa.Ged;
          paramd = g.Gfb;
          f.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramc, g.fev()));
          AppMethodBeat.o(343181);
          return 0;
          label886:
          paramc = paramString;
          break;
          paramc = null;
          break label645;
          paramc = null;
          break label726;
        }
      }
      label1077:
      label1247:
      label1402:
      boolean bool1;
      label1162:
      boolean bool2;
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.Gfa.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          if (f.a(this.Gfa, paramString))
          {
            AppMethodBeat.o(343181);
            return 0;
          }
          localObject1 = this.Gfa.wre;
          if (paramString == null)
          {
            paramc = "";
            ((List)localObject1).add(paramc);
            this.Gfa.GeB = true;
            localObject1 = ((Iterable)this.Gfa.Ged.getHalfVideoMediaExtList()).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
              {
                paramc = (dji)paramc;
                if (paramc != null)
                {
                  f.a(this.Gfa, paramd.field_retCode, paramc);
                  paramc = ah.aiuX;
                  paramc = ah.aiuX;
                }
                localObject1 = ((Iterable)this.Gfa.Ged.getMediaList()).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  paramc = ((Iterator)localObject1).next();
                  if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
                  {
                    paramc = (dji)paramc;
                    if (paramc != null)
                    {
                      f.a(this.Gfa, paramd.field_retCode, paramc);
                      paramc = ah.aiuX;
                      paramc = ah.aiuX;
                    }
                    localObject1 = ((Iterable)this.Gfa.Ged.getLongVideoMediaExtList()).iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      paramc = ((Iterator)localObject1).next();
                      if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
                      {
                        paramc = (dji)paramc;
                        if (paramc != null)
                        {
                          f.a(this.Gfa, paramd.field_retCode, paramc);
                          paramc = ah.aiuX;
                          paramc = ah.aiuX;
                        }
                        paramc = this.Gfa.Ged.getFeedObject().objectDesc;
                        if (paramc != null) {
                          break label1402;
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
            if ((paramc != null) && (s.p(MD5Util.getMD5String(paramc.ZYp), f.aBt(paramString)))) {
              h.OAn.p(1530L, 3L, 1L);
            }
            this.Gfa.ut(false);
            paramString = this.Gfa;
            paramc = this.Gfa.Ged;
            paramd = g.Gfb;
            f.a(paramString, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramc, g.fev()));
            AppMethodBeat.o(343181);
            return 0;
            paramc = paramString;
            break;
            paramc = null;
            break label1077;
            paramc = null;
            break label1162;
            paramc = null;
            break label1247;
            paramc = paramc.feedBgmInfo;
            if (paramc == null) {
              paramc = null;
            } else {
              paramc = paramc.musicInfo;
            }
          }
        }
        this.Gfa.Gez.remove(paramString);
        localObject3 = this.Gfa.Ged.getMediaList();
        localObject4 = this.Gfa.Ged.getLongVideoMediaExtList();
        localObject2 = this.Gfa.Ged.getHalfVideoMediaExtList();
        paramInt = this.Gfa.Gez.size();
        Log.i(this.Gfa.TAG, s.X("%s waitToUpload %d media localId:", Long.valueOf(this.Gfa.Ged.getLocalId())), new Object[] { Long.valueOf(this.Gfa.Ged.getLocalId()), Integer.valueOf(paramInt) });
        bool1 = false;
        bool2 = false;
        if (localObject3 != null) {
          break label1981;
        }
        paramc = null;
        localObject1 = paramc;
        if (paramc == null)
        {
          if (localObject4 != null) {
            break label2041;
          }
          localObject1 = null;
          if (localObject1 == null) {
            break label2102;
          }
          paramBoolean = true;
          label1575:
          bool1 = paramBoolean;
        }
        if (localObject1 != null) {
          break label2850;
        }
        localObject1 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramc = ((Iterator)localObject1).next();
          if (s.p(((dji)paramc).mediaId, f.aBt(paramString)))
          {
            label1631:
            localObject1 = (dji)paramc;
            if (localObject1 == null) {
              break label2113;
            }
            paramBoolean = true;
          }
        }
      }
      for (;;)
      {
        label1645:
        if (localObject1 != null)
        {
          localObject2 = this.Gfa;
          Log.i(((f)localObject2).TAG, "hitMedia, isLongVideo:" + bool1 + ", isHalf:" + paramBoolean);
          ((dji)localObject1).mediaId = MD5Util.getMD5String(((dji)localObject1).url);
          ((dji)localObject1).aaPd = paramd.field_fileUrl;
          ((dji)localObject1).aaPe = paramd.field_thumbUrl;
          ((dji)localObject1).md5sum = paramd.field_filemd5;
          if (bool1) {
            break label2140;
          }
          if (paramBoolean)
          {
            f.a((f)localObject2, 0, (dji)localObject1);
            paramc = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            d.a.v(((f)localObject2).Ged);
          }
        }
        else if (localObject1 == null)
        {
          paramc = this.Gfa.Ged.getFeedObject().objectDesc;
          if (paramc != null) {
            break label2330;
          }
          paramc = null;
          if (paramc == null) {
            break label2418;
          }
          localObject1 = paramc.ZYp;
          paramc = (com.tencent.mm.g.c)localObject1;
          if (localObject1 == null) {
            paramc = "";
          }
          if (!s.p(MD5Util.getMD5String(paramc), f.aBt(paramString))) {
            break label2418;
          }
          paramString = this.Gfa.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2352;
          }
          paramString = null;
          if (paramString != null) {
            paramString.ZYp = paramd.field_fileUrl;
          }
          paramString = this.Gfa.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2374;
          }
          paramString = null;
          if (paramString != null) {
            paramString.HsD = "";
          }
          paramString = this.Gfa.Ged.getFeedObject().objectDesc;
          if (paramString != null) {
            break label2396;
          }
          paramString = null;
        }
        for (;;)
        {
          label1754:
          if (paramString != null) {
            paramString.name = "";
          }
          label1792:
          label1848:
          label1881:
          paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          d.a.v(this.Gfa.Ged);
          if (paramInt == 0)
          {
            this.Gfa.ut(true);
            f.a(this.Gfa, (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(this.Gfa.Ged));
          }
          AppMethodBeat.o(343181);
          return 0;
          label1981:
          localObject1 = ((Iterable)localObject3).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramc = ((Iterator)localObject1).next();
          } while (!s.p(((dji)paramc).mediaId, f.aBt(paramString)));
          for (;;)
          {
            paramc = (dji)paramc;
            break;
            paramc = null;
          }
          label2041:
          localObject1 = ((Iterable)localObject4).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramc = ((Iterator)localObject1).next();
          } while (!s.p(((dji)paramc).mediaId, f.aBt(paramString)));
          for (;;)
          {
            localObject1 = (dji)paramc;
            break;
            paramc = null;
          }
          label2102:
          paramBoolean = false;
          break label1575;
          paramc = null;
          break label1631;
          label2113:
          paramBoolean = false;
          break label1645;
          ((f)localObject2).Ged.setMediaList((LinkedList)localObject3);
          f.a((f)localObject2, 0, (dji)localObject1);
          break label1754;
          label2140:
          paramc = ((f)localObject2).Ged.getFeedObject().attachmentList;
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
            ((f)localObject2).Ged.setMediaList((LinkedList)localObject3);
            f.a((f)localObject2, 0, (dji)localObject1);
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
                  break label2294;
                }
                paramc = null;
                break;
                paramc = null;
              }
              label2294:
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
          label2330:
          paramc = paramc.feedBgmInfo;
          if (paramc == null)
          {
            paramc = null;
            break label1792;
          }
          paramc = paramc.musicInfo;
          break label1792;
          label2352:
          paramString = paramString.feedBgmInfo;
          if (paramString == null)
          {
            paramString = null;
            break label1848;
          }
          paramString = paramString.musicInfo;
          break label1848;
          label2374:
          paramString = paramString.feedBgmInfo;
          if (paramString == null)
          {
            paramString = null;
            break label1881;
          }
          paramString = paramString.musicInfo;
          break label1881;
          label2396:
          paramString = paramString.feedBgmInfo;
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.musicInfo;
          }
        }
        label2418:
        Iterator localIterator = ((Iterable)localObject3).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          localObject2 = ((dji)localObject1).HaI;
          paramc = (com.tencent.mm.g.c)localObject2;
          if (localObject2 == null) {
            paramc = "";
          }
          if (s.p(MD5Util.getMD5String(paramc), f.aBt(paramString)))
          {
            paramc = (com.tencent.mm.g.c)localObject1;
            label2488:
            paramc = (dji)paramc;
            if (paramc != null)
            {
              Log.i(this.Gfa.TAG, s.X("upload fullCover ok, url:", paramd.field_fileUrl));
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
              if (s.p(MD5Util.getMD5String(paramc), f.aBt(paramString)))
              {
                paramc = (com.tencent.mm.g.c)localObject1;
                label2630:
                paramc = (dji)paramc;
                if (paramc != null)
                {
                  Log.i(this.Gfa.TAG, s.X("upload cover ok, url:", paramd.field_fileUrl));
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
                } while (!s.p(MD5Util.getMD5String(paramc), f.aBt(paramString)));
              }
            }
          }
        }
        for (paramc = (com.tencent.mm.g.c)localObject1;; paramc = null)
        {
          paramc = (dji)paramc;
          if (paramc != null)
          {
            Log.i(this.Gfa.TAG, s.X("upload fullThumb ok, url:", paramd.field_fileUrl));
            paramc.aaPk = paramd.field_fileUrl;
            paramc = ah.aiuX;
            paramc = ah.aiuX;
          }
          f.a(this.Gfa, paramString, paramd.field_fileUrl);
          break;
          paramc = null;
          break label2488;
          paramc = null;
          break label2630;
        }
        label2850:
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
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f
 * JD-Core Version:    0.7.0.1
 */