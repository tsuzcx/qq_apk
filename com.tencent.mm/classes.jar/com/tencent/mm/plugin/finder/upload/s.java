package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.finder.report.v.c;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "saveToDb", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class s
  extends j
{
  private static boolean AAV = false;
  public static final a ABq;
  private static final String TAG = "Finder.LogPost.MusicMvFinderUploadTask";
  private boolean AAL;
  private final csh AAM;
  private final Map<String, Float> AAN;
  private final ConcurrentLinkedQueue<String> AAO;
  private boolean AAP;
  private List<csg> AAQ;
  private boolean AAR;
  private final List<com.tencent.mm.i.g> AAS;
  private final c ABo;
  private final b ABp;
  final FinderItem Azr;
  private long startTime;
  private List<String> tmE;
  
  static
  {
    AppMethodBeat.i(287937);
    ABq = new a((byte)0);
    TAG = "Finder.LogPost.MusicMvFinderUploadTask";
    AppMethodBeat.o(287937);
  }
  
  public s(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(287936);
    this.Azr = paramFinderItem;
    this.AAM = this.Azr.field_postinfo;
    this.AAN = ((Map)new LinkedHashMap());
    this.AAO = new ConcurrentLinkedQueue();
    this.AAQ = ((List)new ArrayList());
    this.tmE = ((List)new ArrayList());
    this.AAS = ((List)new ArrayList());
    this.ABo = new c(this);
    this.ABp = new b(this);
    AppMethodBeat.o(287936);
  }
  
  private final void QD(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.Azr.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  private final void a(int paramInt, csg paramcsg)
  {
    AppMethodBeat.i(287927);
    d(paramcsg);
    FinderMediaReportObject localFinderMediaReportObject = paramcsg.TAf;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramcsg = paramcsg.TAf;
    if (paramcsg != null)
    {
      paramcsg.cdnControl = paramInt;
      AppMethodBeat.o(287927);
      return;
    }
    AppMethodBeat.o(287927);
  }
  
  private static String aFt(String paramString)
  {
    AppMethodBeat.i(287925);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(287925);
    return paramString;
  }
  
  private final void aV(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(287932);
    label360:
    Object localObject2;
    try
    {
      this.AAM.TAg = 0;
      Object localObject1 = this.Azr;
      localObject3 = this.AAM;
      p.j(localObject3, "postinfo");
      ((FinderItem)localObject1).setPostInfo((csh)localObject3);
      ecm();
      this.AAS.clear();
      if ((AAV) && (Log.getLogLevel() <= 1))
      {
        Log.i(TAG, "debugDeleteFileWhenUpload");
        localObject1 = av.AJz;
        u.dK(av.egu(), true);
      }
      paramLinkedList = paramLinkedList.iterator();
      for (;;)
      {
        if (paramLinkedList.hasNext())
        {
          localObject1 = (csg)paramLinkedList.next();
          if (!Util.isNullOrNil(((csg)localObject1).url))
          {
            localObject3 = ((csg)localObject1).mediaId;
            Log.i(TAG, "uploading media " + (String)localObject3 + ", " + ((csg)localObject1).url + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject1).url)) + " thumb: " + ((csg)localObject1).thumbUrl + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject1).thumbUrl)));
            p.j(localObject1, "media");
            if (!u.agG(((csg)localObject1).url))
            {
              Log.i(TAG, "mediaObject.url " + ((csg)localObject1).url + " is not file");
              i = 1;
              if (i == 0) {
                continue;
              }
              QD(i);
              qT(false);
              d(com.tencent.mm.loader.g.j.kQe);
              AppMethodBeat.o(287932);
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      label1162:
      label1214:
      label1347:
      do
      {
        Object localObject3;
        int i;
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
        if ((!Util.isNullOrNil(localException.TzS)) && (!Util.isNullOrNil(localException.TzT))) {
          Log.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject3 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject3).taskName = "task_FinderUploadTask_1";
          ((com.tencent.mm.i.g)localObject3).iUG = ((g.a)this.ABp);
          Object localObject4 = MD5Util.getMD5String(localException.url);
          p.j(localObject4, "MD5Util.getMD5String(mediaObject.url)");
          ((com.tencent.mm.i.g)localObject3).field_mediaId = aFt((String)localObject4);
          ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.url;
          ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.thumbUrl;
          ((com.tencent.mm.i.g)localObject3).field_talker = "";
          ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
          Log.i(TAG, "upload file length " + u.bBQ(localException.url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.Azr.getLocalId());
          String str;
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
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.url;
            ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
            ((com.tencent.mm.i.g)localObject3).field_appType = 251;
            ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
            ((com.tencent.mm.i.g)localObject3).iUK = 300;
            ((com.tencent.mm.i.g)localObject3).iUL = 300;
            ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.iTU;
            this.AAO.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
            Log.i(TAG, "add uploadingFeed " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " size:" + this.AAO.size());
            localObject4 = this.AAN;
            str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
            p.j(str, "info.field_mediaId");
            ((Map)localObject4).put(str, Float.valueOf(0.0F));
            com.tencent.mm.aq.f.bkg().Vy(((com.tencent.mm.i.g)localObject3).field_mediaId);
            this.AAS.add(localObject3);
            if ((localException.mediaType == 4) && (!Util.isNullOrNil(localException.coverUrl))) {
              if (!u.agG(localException.coverUrl)) {
                Log.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
              }
            }
          case 4: 
            for (int j = 5;; j = 0)
            {
              i = j;
              if (j != 0) {
                break;
              }
              if (Util.isNullOrNil(localException.TzX)) {
                break label360;
              }
              if (u.agG(localException.TzX)) {
                break label1584;
              }
              Log.w(TAG, "upload failed, fullThumbUrl not exist, " + localException.TzX);
              i = 6;
              break;
              boolean bool1 = SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
              localObject4 = aj.AGc;
              localObject4 = ((com.tencent.mm.i.g)localObject3).field_fullpath;
              p.j(localObject4, "info.field_fullpath");
              boolean bool2 = aj.aFO((String)localObject4);
              Log.i(TAG, aBG() + " optimize result: " + bool1 + ", isOptimize:" + bool2);
              if (!bool1)
              {
                f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "optimizeMP4VFS_fail", bool2, false, (kotlin.g.a.a)new d(this), 12);
                if (!bool2)
                {
                  i = 4;
                  break;
                }
              }
              f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "opt_moov_fail", bool2, false, (kotlin.g.a.a)new e(this), 12);
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).iUX = 8;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).iUK = 1200;
              ((com.tencent.mm.i.g)localObject3).iUL = 1200;
              localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
              l = com.tencent.mm.plugin.finder.storage.d.dRV();
              localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
              StringBuilder localStringBuilder;
              if ((l > com.tencent.mm.plugin.finder.storage.d.dRZ()) || (f(localException)))
              {
                l = u.bBQ(((com.tencent.mm.i.g)localObject3).field_fullpath);
                localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (l > com.tencent.mm.plugin.finder.storage.d.dRZ())
                {
                  localObject4 = j((com.tencent.mm.i.g)localObject3);
                  str = TAG;
                  localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable1, mediaInfo null?");
                  if (localObject4 == null)
                  {
                    bool1 = true;
                    Log.i(str, bool1 + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                    a(0, localException);
                    localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                    localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                    com.tencent.mm.plugin.finder.utils.g.a(com.tencent.mm.plugin.finder.utils.g.ecO());
                  }
                }
              }
              for (;;)
              {
                if (f(localException))
                {
                  ((com.tencent.mm.i.g)localObject3).iUK = 1200;
                  ((com.tencent.mm.i.g)localObject3).iUL = 1200;
                  break;
                  bool1 = false;
                  break label1162;
                  localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
                  if (com.tencent.mm.plugin.finder.storage.d.dUQ() == 1)
                  {
                    localObject4 = j((com.tencent.mm.i.g)localObject3);
                    str = TAG;
                    localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                    if (localObject4 != null) {
                      break label1347;
                    }
                  }
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                Log.i(str, bool1 + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                a(1, localException);
                localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                com.tencent.mm.plugin.finder.utils.g.a(com.tencent.mm.plugin.finder.utils.g.ecO());
                break label1214;
                break;
              }
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).taskName = "task_FinderUploadTask_2";
              ((com.tencent.mm.i.g)localObject3).iUG = ((g.a)this.ABp);
              localObject4 = MD5Util.getMD5String(localException.coverUrl);
              p.j(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((com.tencent.mm.i.g)localObject3).field_mediaId = aFt((String)localObject4);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
              Log.i(TAG, "upload cover file length " + u.bBQ(localException.coverUrl));
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).iUK = 120;
              ((com.tencent.mm.i.g)localObject3).iUL = 300;
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.iTU;
              this.AAO.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
              localObject4 = this.AAN;
              str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
              p.j(str, "info.field_mediaId");
              ((Map)localObject4).put(str, Float.valueOf(0.0F));
              this.AAS.add(localObject3);
            }
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).taskName = "task_FinderUploadTask_2";
            ((com.tencent.mm.i.g)localObject3).iUG = ((g.a)this.ABp);
            localObject4 = MD5Util.getMD5String(localException.TzX);
            p.j(localObject4, "MD5Util.getMD5String(mediaObject.fullThumbUrl)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = aFt((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.TzX;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.TzX;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            Log.i(TAG, "upload fullthumb file length " + u.bBQ(localException.TzX));
            ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
            ((com.tencent.mm.i.g)localObject3).field_appType = 251;
            ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
            ((com.tencent.mm.i.g)localObject3).iUK = 120;
            ((com.tencent.mm.i.g)localObject3).iUL = 300;
            ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.iTU;
            this.AAO.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
            localObject2 = this.AAN;
            localObject4 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
            p.j(localObject4, "info.field_mediaId");
            ((Map)localObject2).put(localObject4, Float.valueOf(0.0F));
            this.AAS.add(localObject3);
          }
        }
      } while ((((csg)localObject2).mediaType != 2) && (((csg)localObject2).mediaType != 7) && (((csg)localObject2).mediaType != 4));
      label1584:
      Log.i(TAG, "uploadFinderContent media.url invalid, url:" + ((csg)localObject2).url + ", type:" + ((csg)localObject2).mediaType);
      QD(2);
      qT(false);
      d(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(287932);
      return;
    }
    Log.i(TAG, "upload info count:" + this.AAS.size());
    long l = 0L;
    paramLinkedList = ((Iterable)this.AAS).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject2 = (com.tencent.mm.i.g)paramLinkedList.next();
      com.tencent.mm.aq.f.bkg().f((com.tencent.mm.i.g)localObject2);
      l = u.bBQ(((com.tencent.mm.i.g)localObject2).field_fullpath) + l;
    }
    paramLinkedList = this.Azr.field_reportObject;
    if (paramLinkedList != null) {
      paramLinkedList.uploadMediaTotalSize = l;
    }
    paramLinkedList = this.Azr.field_reportObject;
    if (paramLinkedList != null)
    {
      localObject2 = i.AAy;
      i.a(paramLinkedList, "beginUpload");
    }
    if (this.AAO.size() == 0)
    {
      qT(true);
      d(com.tencent.mm.loader.g.j.kQd);
      AppMethodBeat.o(287932);
      return;
    }
    paramLinkedList = v.d.zYG;
    v.d.qr(this.Azr.isLongVideo());
    AppMethodBeat.o(287932);
  }
  
  private final void d(com.tencent.mm.loader.g.j paramj)
  {
    AppMethodBeat.i(287926);
    this.ABo.dead();
    if (this.AAL)
    {
      Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.AAL);
      AppMethodBeat.o(287926);
      return;
    }
    a(paramj);
    AppMethodBeat.o(287926);
  }
  
  private final void d(csg paramcsg)
  {
    AppMethodBeat.i(287928);
    FinderMediaReportObject localFinderMediaReportObject = paramcsg.TAf;
    if (localFinderMediaReportObject != null)
    {
      localFinderMediaReportObject.mediaType = paramcsg.mediaType;
      localFinderMediaReportObject.mediaId = paramcsg.mediaId;
      localFinderMediaReportObject.cdnUploadTime = ((int)(cm.bfE() - this.startTime));
      AppMethodBeat.o(287928);
      return;
    }
    Object localObject = (s)this;
    localFinderMediaReportObject = new FinderMediaReportObject();
    localFinderMediaReportObject.mediaType = paramcsg.mediaType;
    localFinderMediaReportObject.mediaId = paramcsg.mediaId;
    localFinderMediaReportObject.cdnUploadTime = ((int)(cm.bfE() - ((s)localObject).startTime));
    localObject = new FinderMediaReportInfo();
    ((FinderMediaReportInfo)localObject).width = ((int)paramcsg.width);
    ((FinderMediaReportInfo)localObject).height = ((int)paramcsg.height);
    ((FinderMediaReportInfo)localObject).fileSize = ((int)u.bBQ(paramcsg.url));
    ((FinderMediaReportInfo)localObject).videoDuration = paramcsg.videoDuration;
    ((FinderMediaReportInfo)localObject).videoBitrate = paramcsg.bitrate;
    localFinderMediaReportObject.videoFinalSize = ((FinderMediaReportInfo)localObject).fileSize;
    localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject);
    paramcsg.TAf = localFinderMediaReportObject;
    AppMethodBeat.o(287928);
  }
  
  private final void ecm()
  {
    AppMethodBeat.i(287930);
    c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    c.a.r(this.Azr);
    AppMethodBeat.o(287930);
  }
  
  private final boolean f(csg paramcsg)
  {
    AppMethodBeat.i(287935);
    Iterator localIterator = this.AAQ.iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (!p.h(((csg)localIterator.next()).mediaId, paramcsg.mediaId)) {}
    }
    for (;;)
    {
      if (i < 0) {
        break label73;
      }
      AppMethodBeat.o(287935);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(287935);
    return false;
  }
  
  private static com.tencent.mm.plugin.sight.base.b j(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(287933);
    paramg.snsVersion = 1;
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aYg(paramg.field_fullpath);
    int j;
    if (localb != null)
    {
      j = localb.videoBitrate;
      if (!v.isH265Video(paramg.field_fullpath)) {
        break label108;
      }
    }
    label108:
    for (int i = 174;; i = 28)
    {
      String str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
      Log.i(TAG, "customHeader ".concat(String.valueOf(str)));
      paramg.customHeader = str;
      AppMethodBeat.o(287933);
      return localb;
    }
  }
  
  private final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(287929);
    if (!paramBoolean) {}
    try
    {
      this.AAL = false;
      if (!paramBoolean) {}
      for (this.AAM.TAg = 2;; this.AAM.TAg = 1)
      {
        this.AAM.jPg = (cm.bfC() - this.startTime);
        Object localObject = this.Azr;
        csh localcsh = this.AAM;
        p.j(localcsh, "postinfo");
        ((FinderItem)localObject).setPostInfo(localcsh);
        localObject = v.c.zYk;
        v.c.z(this.AAM.jPg, this.Azr.isLongVideo());
        ecm();
        AppMethodBeat.o(287929);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(287929);
    }
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(287934);
    String str = "upload_" + this.Azr.getLocalId();
    AppMethodBeat.o(287934);
    return str;
  }
  
  public final void start()
  {
    AppMethodBeat.i(287924);
    this.ABo.alive();
    this.Azr.trackPost("upload");
    Object localObject1 = this.Azr.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 3;
    }
    this.startTime = cm.bfE();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dVi().aSr()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.d.dVi().aSr()).longValue() * 1000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() == 2)
    {
      d(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(287924);
      return;
    }
    localObject1 = this.Azr.getFeedObject().objectDesc;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo; localObject1 == null; localObject1 = null)
    {
      d(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(287924);
      return;
    }
    Object localObject2 = new LinkedList();
    Object localObject3;
    Object localObject4;
    int i;
    if (((bdp)localObject1).SOF == 1)
    {
      localObject1 = ((bdp)localObject1).SOE;
      p.j(localObject1, "mvInfo.ordered_track_list_flex_clip");
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label292:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((bdt)localObject4).refObjectId == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label292;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      ((LinkedList)localObject2).addAll((Collection)localObject1);
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll((Collection)this.Azr.getMediaList());
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      label343:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject4 = (bdt)localObject1;
        Iterator localIterator = ((Iterable)this.Azr.getClipListExt()).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = localIterator.next();
        } while (!p.h(((FinderItem)localObject1).getObjectNonceId(), ((bdt)localObject4).SOS));
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
        break label343;
        localObject1 = ((bdp)localObject1).SOB;
        p.j(localObject1, "mvInfo.orderedTrackList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label545:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((bdt)localObject4).refObjectId == 0L) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label545;
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
    aV((LinkedList)localObject3);
    AppMethodBeat.o(287924);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(269082);
      Object localObject1 = s.ABq;
      Object localObject3 = s.access$getTAG$cp();
      String str = "on cdn callback someOneFailed:" + s.c(this.ABr) + ", mediaId = %s, startRet = %d, sceneResult %s";
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
      if ((s.a(this.ABr)) || (s.c(this.ABr)))
      {
        AppMethodBeat.o(269082);
        return 0;
      }
      s.a(this.ABr, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = s.ABq;
        Log.e(s.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramd = s.e(this.ABr);
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
        s.d(this.ABr);
        paramd = ((Iterable)this.ABr.Azr.getMediaList()).iterator();
        while (paramd.hasNext())
        {
          paramc = paramd.next();
          if (p.h(((csg)paramc).mediaId, s.aFx(paramString)))
          {
            paramc = (csg)paramc;
            if (paramc != null) {
              s.a(this.ABr, paramInt, paramc);
            }
            paramd = ((Iterable)this.ABr.Azr.getClipListExt()).iterator();
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
            } while (!p.h(((csg)paramc).mediaId, s.aFx(paramString)));
          }
        }
        for (;;)
        {
          paramc = (csg)paramc;
          if (paramc == null) {
            break label295;
          }
          s.a(this.ABr, paramInt, paramc);
          break label295;
          paramc = null;
          break;
          paramc = null;
        }
        s.a(this.ABr, false);
        s.a(this.ABr, com.tencent.mm.loader.g.j.kQe);
        AppMethodBeat.o(269082);
        return 0;
        if ((!Util.isNullOrNil(paramString)) && (paramd != null))
        {
          paramc = s.ABq;
          Log.i(s.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
          if (paramd.field_retCode != 0)
          {
            localObject1 = s.e(this.ABr);
            if (paramString != null) {
              break label1158;
            }
          }
        }
        for (paramc = "";; paramc = paramString)
        {
          ((List)localObject1).add(paramc);
          s.d(this.ABr);
          localObject1 = ((Iterable)this.ABr.Azr.getMediaList()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.h(((csg)paramc).mediaId, s.aFx(paramString)))
            {
              paramc = (csg)paramc;
              if (paramc != null) {
                s.a(this.ABr, paramd.field_retCode, paramc);
              }
              localObject1 = ((Iterable)this.ABr.Azr.getClipListExt()).iterator();
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
              } while (!p.h(((csg)paramc).mediaId, s.aFx(paramString)));
            }
          }
          for (;;)
          {
            paramc = (csg)paramc;
            if (paramc == null) {
              break label611;
            }
            s.a(this.ABr, paramd.field_retCode, paramc);
            break label611;
            paramc = null;
            break;
            paramc = null;
          }
          label714:
          s.a(this.ABr, false);
          s.a(this.ABr, com.tencent.mm.loader.g.j.kQe);
          AppMethodBeat.o(269082);
          return 0;
          s.f(this.ABr).remove(paramString);
          localObject2 = this.ABr.Azr.getMediaList();
          localObject3 = new LinkedList();
          paramc = ((Iterable)this.ABr.Azr.getClipListExt()).iterator();
          while (paramc.hasNext()) {
            ((LinkedList)localObject3).addAll((Collection)((FinderItem)paramc.next()).getMediaList());
          }
          paramInt = s.f(this.ABr).size();
          paramc = s.ABq;
          Log.i(s.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.ABr.Azr.getLocalId(), new Object[] { Long.valueOf(this.ABr.Azr.getLocalId()), Integer.valueOf(paramInt) });
          localObject1 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.h(((csg)paramc).mediaId, s.aFx(paramString)))
            {
              localObject1 = (csg)paramc;
              paramc = (com.tencent.mm.i.c)localObject1;
              if (localObject1 != null) {
                break label1150;
              }
              localObject1 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                paramc = ((Iterator)localObject1).next();
                if (p.h(((csg)paramc).mediaId, s.aFx(paramString)))
                {
                  paramString = paramc;
                  label1007:
                  paramString = (csg)paramString;
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
              paramc = s.ABq;
              Log.i(s.access$getTAG$cp(), "hitMedia, isClip:".concat(String.valueOf(paramBoolean)));
              paramString.mediaId = MD5Util.getMD5String(paramString.url);
              paramString.TzS = paramd.field_fileUrl;
              paramString.TzT = paramd.field_thumbUrl;
              paramString.md5sum = paramd.field_filemd5;
              this.ABr.Azr.setMediaList((LinkedList)localObject2);
              s.a(this.ABr, 0, paramString);
              s.g(this.ABr);
            }
            if (paramInt == 0)
            {
              s.a(this.ABr, true);
              s.a(this.ABr, com.tencent.mm.loader.g.j.kQd);
            }
            AppMethodBeat.o(269082);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hn>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(s.c paramc, hn paramhn)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(s params)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.s
 * JD-Core Version:    0.7.0.1
 */