package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.finder.report.r.c;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.event.IListener;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "saveToDb", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class s
  extends j
{
  private static final String TAG = "Finder.LogPost.MusicMvFinderUploadTask";
  public static final a vTN;
  private static boolean vTs;
  private List<String> pQE;
  private long startTime;
  final FinderItem vRO;
  private final c vTL;
  private final b vTM;
  private boolean vTi;
  private final cjm vTj;
  private final Map<String, Float> vTk;
  private final ConcurrentLinkedQueue<String> vTl;
  private boolean vTm;
  private List<cjl> vTn;
  private boolean vTo;
  private final List<g> vTp;
  
  static
  {
    AppMethodBeat.i(253165);
    vTN = new a((byte)0);
    TAG = "Finder.LogPost.MusicMvFinderUploadTask";
    AppMethodBeat.o(253165);
  }
  
  public s(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253164);
    this.vRO = paramFinderItem;
    this.vTj = this.vRO.field_postinfo;
    this.vTk = ((Map)new LinkedHashMap());
    this.vTl = new ConcurrentLinkedQueue();
    this.vTn = ((List)new ArrayList());
    this.pQE = ((List)new ArrayList());
    this.vTp = ((List)new ArrayList());
    this.vTL = new c(this);
    this.vTM = new b(this);
    AppMethodBeat.o(253164);
  }
  
  private final void Lu(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.vRO.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  private final void a(int paramInt, cjl paramcjl)
  {
    AppMethodBeat.i(253156);
    e(paramcjl);
    FinderMediaReportObject localFinderMediaReportObject = paramcjl.MoZ;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramcjl = paramcjl.MoZ;
    if (paramcjl != null)
    {
      paramcjl.cdnControl = paramInt;
      AppMethodBeat.o(253156);
      return;
    }
    AppMethodBeat.o(253156);
  }
  
  private final void aE(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(253160);
    label278:
    Object localObject2;
    try
    {
      this.vTj.Mpa = 0;
      Object localObject1 = this.vRO;
      localObject3 = this.vTj;
      p.g(localObject3, "postinfo");
      ((FinderItem)localObject1).setPostInfo((cjm)localObject3);
      dBc();
      this.vTp.clear();
      if ((vTs) && (Log.getLogLevel() <= 1))
      {
        Log.i(TAG, "debugDeleteFileWhenUpload");
        localObject1 = al.waC;
        com.tencent.mm.vfs.s.dy(al.dEH(), true);
      }
      paramLinkedList = paramLinkedList.iterator();
      for (;;)
      {
        if (paramLinkedList.hasNext())
        {
          localObject1 = (cjl)paramLinkedList.next();
          if (!Util.isNullOrNil(((cjl)localObject1).url))
          {
            localObject3 = ((cjl)localObject1).mediaId;
            Log.i(TAG, "uploading media " + (String)localObject3 + ", " + ((cjl)localObject1).url + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(((cjl)localObject1).url)) + " thumb: " + ((cjl)localObject1).thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(((cjl)localObject1).thumbUrl)));
            p.g(localObject1, "media");
            if (!com.tencent.mm.vfs.s.YS(((cjl)localObject1).url))
            {
              Log.i(TAG, "mediaObject.url " + ((cjl)localObject1).url + " is not file");
              i = 1;
              if (i == 0) {
                continue;
              }
              Lu(i);
              oG(false);
              d(com.tencent.mm.loader.g.j.ibx);
              AppMethodBeat.o(253160);
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      label1079:
      label1131:
      label1264:
      do
      {
        Object localObject3;
        int i;
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
        if ((!Util.isNullOrNil(localException.MoM)) && (!Util.isNullOrNil(localException.MoN))) {
          Log.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject3 = new g();
          ((g)localObject3).taskName = "task_FinderUploadTask_1";
          ((g)localObject3).gqy = ((g.a)this.vTM);
          Object localObject4 = MD5Util.getMD5String(localException.url);
          p.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
          ((g)localObject3).field_mediaId = awa((String)localObject4);
          ((g)localObject3).field_fullpath = localException.url;
          ((g)localObject3).field_thumbpath = localException.thumbUrl;
          ((g)localObject3).field_talker = "";
          ((g)localObject3).field_needStorage = true;
          Log.i(TAG, "upload file length " + com.tencent.mm.vfs.s.boW(localException.url) + " mediaId: " + ((g)localObject3).field_mediaId + " localId:" + this.vRO.getLocalId());
          Object localObject5;
          switch (localException.mediaType)
          {
          case 3: 
          case 5: 
          case 6: 
          default: 
            Log.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(localException.mediaType) });
            break;
          case 2: 
          case 7: 
            ((g)localObject3).field_thumbpath = localException.url;
            ((g)localObject3).field_fileType = 20304;
            ((g)localObject3).field_appType = 251;
            ((g)localObject3).field_bzScene = 2;
            ((g)localObject3).gqC = 300;
            ((g)localObject3).gqD = 300;
            ((g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
            this.vTl.add(((g)localObject3).field_mediaId);
            Log.i(TAG, "add uploadingFeed " + ((g)localObject3).field_mediaId + " size:" + this.vTl.size());
            localObject4 = this.vTk;
            localObject5 = ((g)localObject3).field_mediaId;
            p.g(localObject5, "info.field_mediaId");
            ((Map)localObject4).put(localObject5, Float.valueOf(0.0F));
            com.tencent.mm.an.f.baQ().Ob(((g)localObject3).field_mediaId);
            this.vTp.add(localObject3);
            if ((localException.mediaType == 4) && (!Util.isNullOrNil(localException.coverUrl))) {
              if (!com.tencent.mm.vfs.s.YS(localException.coverUrl)) {
                Log.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
              }
            }
          case 4: 
            for (i = 5;; i = 0)
            {
              if (i == 0) {
                break label1501;
              }
              i = 5;
              break;
              if (!SightVideoJNI.optimizeMP4VFS(((g)localObject3).field_fullpath))
              {
                localObject2 = com.tencent.mm.plugin.finder.utils.c.vVc;
                localObject4 = y.vXH;
                localObject3 = ((g)localObject3).field_fullpath;
                p.g(localObject3, "info.field_fullpath");
                f.a.a((com.tencent.mm.ac.f)localObject2, "optimizeMP4VFS_fail", y.aws((String)localObject3), false, (kotlin.g.a.a)new d(this), 12);
                i = 4;
                break;
              }
              localObject4 = com.tencent.mm.plugin.finder.utils.c.vVc;
              localObject5 = y.vXH;
              localObject5 = ((g)localObject3).field_fullpath;
              p.g(localObject5, "info.field_fullpath");
              f.a.a((com.tencent.mm.ac.f)localObject4, "opt_moov_fail", y.aws((String)localObject5), false, (kotlin.g.a.a)new e(this), 12);
              ((g)localObject3).field_fileType = 20302;
              ((g)localObject3).field_appType = 251;
              ((g)localObject3).gqP = 8;
              ((g)localObject3).field_bzScene = 2;
              ((g)localObject3).gqC = 1200;
              ((g)localObject3).gqD = 1200;
              localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
              l = com.tencent.mm.plugin.finder.storage.c.dqI();
              localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
              StringBuilder localStringBuilder;
              if ((l > com.tencent.mm.plugin.finder.storage.c.dqM()) || (g((cjl)localObject2)))
              {
                l = com.tencent.mm.vfs.s.boW(((g)localObject3).field_fullpath);
                localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (l > com.tencent.mm.plugin.finder.storage.c.dqM())
                {
                  localObject4 = j((g)localObject3);
                  localObject5 = TAG;
                  localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable1, mediaInfo null?");
                  if (localObject4 == null)
                  {
                    bool = true;
                    Log.i((String)localObject5, bool + ", path:" + ((g)localObject3).field_fullpath);
                    a(0, (cjl)localObject2);
                    localObject4 = com.tencent.mm.plugin.finder.utils.f.vVo;
                    localObject4 = com.tencent.mm.plugin.finder.utils.f.vVo;
                    com.tencent.mm.plugin.finder.utils.f.a(com.tencent.mm.plugin.finder.utils.f.dBB());
                  }
                }
              }
              for (;;)
              {
                if (g((cjl)localObject2))
                {
                  ((g)localObject3).gqC = 1200;
                  ((g)localObject3).gqD = 1200;
                  break;
                  bool = false;
                  break label1079;
                  localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                  if (com.tencent.mm.plugin.finder.storage.c.dtH() == 1)
                  {
                    localObject4 = j((g)localObject3);
                    localObject5 = TAG;
                    localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                    if (localObject4 != null) {
                      break label1264;
                    }
                  }
                }
              }
              for (boolean bool = true;; bool = false)
              {
                Log.i((String)localObject5, bool + ", path:" + ((g)localObject3).field_fullpath);
                a(1, (cjl)localObject2);
                localObject4 = com.tencent.mm.plugin.finder.utils.f.vVo;
                localObject4 = com.tencent.mm.plugin.finder.utils.f.vVo;
                com.tencent.mm.plugin.finder.utils.f.a(com.tencent.mm.plugin.finder.utils.f.dBB());
                break label1131;
                break;
              }
              localObject3 = new g();
              ((g)localObject3).taskName = "task_FinderUploadTask_2";
              ((g)localObject3).gqy = ((g.a)this.vTM);
              localObject4 = MD5Util.getMD5String(((cjl)localObject2).coverUrl);
              p.g(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((g)localObject3).field_mediaId = awa((String)localObject4);
              ((g)localObject3).field_fullpath = ((cjl)localObject2).coverUrl;
              ((g)localObject3).field_thumbpath = ((cjl)localObject2).coverUrl;
              ((g)localObject3).field_talker = "";
              ((g)localObject3).field_needStorage = true;
              Log.i(TAG, "upload cover file length " + com.tencent.mm.vfs.s.boW(((cjl)localObject2).coverUrl));
              ((g)localObject3).field_fileType = 20304;
              ((g)localObject3).field_appType = 251;
              ((g)localObject3).field_bzScene = 2;
              ((g)localObject3).gqC = 120;
              ((g)localObject3).gqD = 300;
              ((g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
              this.vTl.add(((g)localObject3).field_mediaId);
              localObject4 = this.vTk;
              localObject5 = ((g)localObject3).field_mediaId;
              p.g(localObject5, "info.field_mediaId");
              ((Map)localObject4).put(localObject5, Float.valueOf(0.0F));
              this.vTp.add(localObject3);
            }
            if (!Util.isNullOrNil(((cjl)localObject2).MoR))
            {
              if (!com.tencent.mm.vfs.s.YS(((cjl)localObject2).MoR))
              {
                Log.w(TAG, "upload failed, fullThumbUrl not exist, " + ((cjl)localObject2).MoR);
                i = 6;
                break label278;
              }
              localObject3 = new g();
              ((g)localObject3).taskName = "task_FinderUploadTask_2";
              ((g)localObject3).gqy = ((g.a)this.vTM);
              localObject4 = MD5Util.getMD5String(((cjl)localObject2).MoR);
              p.g(localObject4, "MD5Util.getMD5String(mediaObject.fullThumbUrl)");
              ((g)localObject3).field_mediaId = awa((String)localObject4);
              ((g)localObject3).field_fullpath = ((cjl)localObject2).MoR;
              ((g)localObject3).field_thumbpath = ((cjl)localObject2).MoR;
              ((g)localObject3).field_talker = "";
              ((g)localObject3).field_needStorage = true;
              Log.i(TAG, "upload fullthumb file length " + com.tencent.mm.vfs.s.boW(((cjl)localObject2).MoR));
              ((g)localObject3).field_fileType = 20304;
              ((g)localObject3).field_appType = 251;
              ((g)localObject3).field_bzScene = 2;
              ((g)localObject3).gqC = 120;
              ((g)localObject3).gqD = 300;
              ((g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
              this.vTl.add(((g)localObject3).field_mediaId);
              localObject2 = this.vTk;
              localObject4 = ((g)localObject3).field_mediaId;
              p.g(localObject4, "info.field_mediaId");
              ((Map)localObject2).put(localObject4, Float.valueOf(0.0F));
              this.vTp.add(localObject3);
            }
            break;
          }
        }
      } while ((((cjl)localObject2).mediaType != 2) && (((cjl)localObject2).mediaType != 7) && (((cjl)localObject2).mediaType != 4));
      label1501:
      Log.i(TAG, "uploadFinderContent media.url invalid, url:" + ((cjl)localObject2).url + ", type:" + ((cjl)localObject2).mediaType);
      Lu(2);
      oG(false);
      d(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253160);
      return;
    }
    Log.i(TAG, "upload info count:" + this.vTp.size());
    long l = 0L;
    paramLinkedList = ((Iterable)this.vTp).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject2 = (g)paramLinkedList.next();
      com.tencent.mm.an.f.baQ().f((g)localObject2);
      l = com.tencent.mm.vfs.s.boW(((g)localObject2).field_fullpath) + l;
    }
    paramLinkedList = this.vRO.field_reportObject;
    if (paramLinkedList != null) {
      paramLinkedList.uploadMediaTotalSize = l;
    }
    paramLinkedList = this.vRO.field_reportObject;
    if (paramLinkedList != null)
    {
      localObject2 = i.vSX;
      i.a(paramLinkedList, "beginUpload");
    }
    if (this.vTl.size() == 0)
    {
      oG(true);
      d(com.tencent.mm.loader.g.j.ibw);
      AppMethodBeat.o(253160);
      return;
    }
    paramLinkedList = r.d.vhx;
    r.d.og(this.vRO.isLongVideo());
    AppMethodBeat.o(253160);
  }
  
  private static String awa(String paramString)
  {
    AppMethodBeat.i(253154);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(253154);
    return paramString;
  }
  
  private final void d(com.tencent.mm.loader.g.j paramj)
  {
    AppMethodBeat.i(253155);
    this.vTL.dead();
    if (this.vTi)
    {
      Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.vTi);
      AppMethodBeat.o(253155);
      return;
    }
    a(paramj);
    AppMethodBeat.o(253155);
  }
  
  private final void dBc()
  {
    AppMethodBeat.i(253159);
    c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    c.a.q(this.vRO);
    AppMethodBeat.o(253159);
  }
  
  private final void e(cjl paramcjl)
  {
    AppMethodBeat.i(253157);
    FinderMediaReportObject localFinderMediaReportObject = paramcjl.MoZ;
    if (localFinderMediaReportObject != null)
    {
      localFinderMediaReportObject.mediaType = paramcjl.mediaType;
      localFinderMediaReportObject.mediaId = paramcjl.mediaId;
      localFinderMediaReportObject.cdnUploadTime = ((int)(cl.aWA() - this.startTime));
      AppMethodBeat.o(253157);
      return;
    }
    Object localObject = (s)this;
    localFinderMediaReportObject = new FinderMediaReportObject();
    localFinderMediaReportObject.mediaType = paramcjl.mediaType;
    localFinderMediaReportObject.mediaId = paramcjl.mediaId;
    localFinderMediaReportObject.cdnUploadTime = ((int)(cl.aWA() - ((s)localObject).startTime));
    localObject = new FinderMediaReportInfo();
    ((FinderMediaReportInfo)localObject).width = ((int)paramcjl.width);
    ((FinderMediaReportInfo)localObject).height = ((int)paramcjl.height);
    ((FinderMediaReportInfo)localObject).fileSize = ((int)com.tencent.mm.vfs.s.boW(paramcjl.url));
    ((FinderMediaReportInfo)localObject).videoDuration = paramcjl.videoDuration;
    ((FinderMediaReportInfo)localObject).videoBitrate = paramcjl.bitrate;
    localFinderMediaReportObject.videoFinalSize = ((FinderMediaReportInfo)localObject).fileSize;
    localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject);
    paramcjl.MoZ = localFinderMediaReportObject;
    AppMethodBeat.o(253157);
  }
  
  private final boolean g(cjl paramcjl)
  {
    AppMethodBeat.i(253163);
    Iterator localIterator = this.vTn.iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (!p.j(((cjl)localIterator.next()).mediaId, paramcjl.mediaId)) {}
    }
    for (;;)
    {
      if (i < 0) {
        break label73;
      }
      AppMethodBeat.o(253163);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(253163);
    return false;
  }
  
  private static com.tencent.mm.plugin.sight.base.a j(g paramg)
  {
    AppMethodBeat.i(253161);
    paramg.snsVersion = 1;
    com.tencent.mm.plugin.sight.base.a locala = e.aNx(paramg.field_fullpath);
    int j;
    if (locala != null)
    {
      j = locala.videoBitrate;
      if (!r.isH265Video(paramg.field_fullpath)) {
        break label108;
      }
    }
    label108:
    for (int i = 174;; i = 28)
    {
      String str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
      Log.i(TAG, "customHeader ".concat(String.valueOf(str)));
      paramg.customHeader = str;
      AppMethodBeat.o(253161);
      return locala;
    }
  }
  
  private final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(253158);
    if (!paramBoolean) {}
    try
    {
      this.vTi = false;
      if (!paramBoolean) {}
      for (this.vTj.Mpa = 2;; this.vTj.Mpa = 1)
      {
        this.vTj.hdA = (cl.aWy() - this.startTime);
        Object localObject = this.vRO;
        cjm localcjm = this.vTj;
        p.g(localcjm, "postinfo");
        ((FinderItem)localObject).setPostInfo(localcjm);
        localObject = r.c.vhb;
        r.c.z(this.vTj.hdA, this.vRO.isLongVideo());
        dBc();
        AppMethodBeat.o(253158);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(253158);
    }
  }
  
  public final String auK()
  {
    AppMethodBeat.i(253162);
    String str = "upload_" + this.vRO.getLocalId();
    AppMethodBeat.o(253162);
    return str;
  }
  
  public final void start()
  {
    AppMethodBeat.i(253153);
    this.vTL.alive();
    this.vRO.trackPost("upload");
    Object localObject1 = this.vRO.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 3;
    }
    this.startTime = cl.aWA();
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((((Number)com.tencent.mm.plugin.finder.storage.c.dtZ().value()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.c.dtZ().value()).longValue() * 1000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dra().value()).intValue() == 2)
    {
      d(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253153);
      return;
    }
    localObject1 = this.vRO.getFeedObject().objectDesc;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo; localObject1 == null; localObject1 = null)
    {
      d(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253153);
      return;
    }
    Object localObject3 = new LinkedList();
    localObject1 = ((axw)localObject1).LId;
    p.g(localObject1, "mvInfo.orderedTrackList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    label280:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if (((axz)localObject4).refObjectId == 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label280;
        }
        ((Collection)localObject1).add(localObject4);
        break;
      }
    }
    ((LinkedList)localObject3).addAll((Collection)localObject1);
    localObject2 = new LinkedList();
    ((LinkedList)localObject2).addAll((Collection)this.vRO.getMediaList());
    localObject3 = ((Iterable)localObject3).iterator();
    int i = 0;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject4 = (axz)localObject1;
      Iterator localIterator = ((Iterable)this.vRO.getClipListExt()).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localIterator.next();
      } while (!p.j(((FinderItem)localObject1).getObjectNonceId(), ((axz)localObject4).LIm));
      for (;;)
      {
        localObject1 = (FinderItem)localObject1;
        if (localObject1 != null) {
          ((LinkedList)localObject2).addAll((Collection)((FinderItem)localObject1).getMediaList());
        }
        i += 1;
        break;
        localObject1 = null;
      }
    }
    aE((LinkedList)localObject2);
    AppMethodBeat.o(253153);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(253148);
      Object localObject1 = s.vTN;
      Object localObject3 = s.access$getTAG$cp();
      String str = "on cdn callback someOneFailed:" + s.c(this.vTO) + ", mediaId = %s, startRet = %d, sceneResult %s";
      Object localObject2;
      if (paramd != null)
      {
        localObject2 = paramd.toString();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "null";
      }
      Log.i((String)localObject3, str, new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
      if ((s.a(this.vTO)) || (s.c(this.vTO)))
      {
        AppMethodBeat.o(253148);
        return 0;
      }
      s.a(this.vTO, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = s.vTN;
        Log.e(s.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramd = s.e(this.vTO);
          if (paramString != null) {
            break label1163;
          }
        }
      }
      label394:
      label1163:
      for (paramc = "";; paramc = paramString)
      {
        paramd.add(paramc);
        s.d(this.vTO);
        paramd = ((Iterable)this.vTO.vRO.getMediaList()).iterator();
        while (paramd.hasNext())
        {
          paramc = paramd.next();
          if (p.j(((cjl)paramc).mediaId, s.awe(paramString)))
          {
            paramc = (cjl)paramc;
            if (paramc != null) {
              s.a(this.vTO, paramInt, paramc);
            }
            paramd = ((Iterable)this.vTO.vRO.getClipListExt()).iterator();
            label295:
            if (!paramd.hasNext()) {
              break label394;
            }
            localObject1 = ((Iterable)((FinderItem)paramd.next()).getMediaList()).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramc = ((Iterator)localObject1).next();
            } while (!p.j(((cjl)paramc).mediaId, s.awe(paramString)));
          }
        }
        for (;;)
        {
          paramc = (cjl)paramc;
          if (paramc == null) {
            break label295;
          }
          s.a(this.vTO, paramInt, paramc);
          break label295;
          paramc = null;
          break;
          paramc = null;
        }
        s.a(this.vTO, false);
        s.a(this.vTO, com.tencent.mm.loader.g.j.ibx);
        AppMethodBeat.o(253148);
        return 0;
        if ((!Util.isNullOrNil(paramString)) && (paramd != null))
        {
          paramc = s.vTN;
          Log.i(s.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
          if (paramd.field_retCode != 0)
          {
            localObject1 = s.e(this.vTO);
            if (paramString != null) {
              break label1158;
            }
          }
        }
        for (paramc = "";; paramc = paramString)
        {
          ((List)localObject1).add(paramc);
          s.d(this.vTO);
          localObject1 = ((Iterable)this.vTO.vRO.getMediaList()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.j(((cjl)paramc).mediaId, s.awe(paramString)))
            {
              paramc = (cjl)paramc;
              if (paramc != null) {
                s.a(this.vTO, paramd.field_retCode, paramc);
              }
              localObject1 = ((Iterable)this.vTO.vRO.getClipListExt()).iterator();
              label611:
              if (!((Iterator)localObject1).hasNext()) {
                break label714;
              }
              localObject2 = ((Iterable)((FinderItem)((Iterator)localObject1).next()).getMediaList()).iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramc = ((Iterator)localObject2).next();
              } while (!p.j(((cjl)paramc).mediaId, s.awe(paramString)));
            }
          }
          for (;;)
          {
            paramc = (cjl)paramc;
            if (paramc == null) {
              break label611;
            }
            s.a(this.vTO, paramd.field_retCode, paramc);
            break label611;
            paramc = null;
            break;
            paramc = null;
          }
          label714:
          s.a(this.vTO, false);
          s.a(this.vTO, com.tencent.mm.loader.g.j.ibx);
          AppMethodBeat.o(253148);
          return 0;
          s.f(this.vTO).remove(paramString);
          localObject2 = this.vTO.vRO.getMediaList();
          localObject3 = new LinkedList();
          paramc = ((Iterable)this.vTO.vRO.getClipListExt()).iterator();
          while (paramc.hasNext()) {
            ((LinkedList)localObject3).addAll((Collection)((FinderItem)paramc.next()).getMediaList());
          }
          paramInt = s.f(this.vTO).size();
          paramc = s.vTN;
          Log.i(s.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.vTO.vRO.getLocalId(), new Object[] { Long.valueOf(this.vTO.vRO.getLocalId()), Integer.valueOf(paramInt) });
          localObject1 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.j(((cjl)paramc).mediaId, s.awe(paramString)))
            {
              localObject1 = (cjl)paramc;
              paramc = (com.tencent.mm.i.c)localObject1;
              if (localObject1 != null) {
                break label1150;
              }
              localObject1 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                paramc = ((Iterator)localObject1).next();
                if (p.j(((cjl)paramc).mediaId, s.awe(paramString)))
                {
                  paramString = paramc;
                  label1007:
                  paramString = (cjl)paramString;
                  paramc = paramString;
                  if (paramString == null) {
                    break label1150;
                  }
                  paramBoolean = true;
                }
              }
            }
          }
          for (;;)
          {
            if (paramString != null)
            {
              paramc = s.vTN;
              Log.i(s.access$getTAG$cp(), "hitMedia, isClip:".concat(String.valueOf(paramBoolean)));
              paramString.mediaId = MD5Util.getMD5String(paramString.url);
              paramString.MoM = paramd.field_fileUrl;
              paramString.MoN = paramd.field_thumbUrl;
              paramString.md5sum = paramd.field_filemd5;
              this.vTO.vRO.setMediaList((LinkedList)localObject2);
              s.a(this.vTO, 0, paramString);
              s.g(this.vTO);
            }
            if (paramInt == 0)
            {
              s.a(this.vTO, true);
              s.a(this.vTO, com.tencent.mm.loader.g.j.ibw);
            }
            AppMethodBeat.o(253148);
            return 0;
            paramc = null;
            break;
            paramString = null;
            break label1007;
            label1150:
            paramBoolean = false;
            paramString = paramc;
          }
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hg>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(s.c paramc, hg paramhg)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(s params)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<String>
  {
    e(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.s
 * JD-Core Version:    0.7.0.1
 */