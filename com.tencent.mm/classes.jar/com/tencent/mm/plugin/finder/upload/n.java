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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.dwi;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "isRemoteUpload", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class n
  extends j
{
  private static boolean AAV = false;
  public static final a AAW;
  private static final String TAG = "Finder.LogPost.FinderUploadTask";
  private boolean AAL;
  private final csh AAM;
  private final Map<String, Float> AAN;
  private final ConcurrentLinkedQueue<String> AAO;
  private boolean AAP;
  private List<csg> AAQ;
  private boolean AAR;
  private final List<com.tencent.mm.i.g> AAS;
  private final c AAT;
  private final b AAU;
  FinderItem Azr;
  private long startTime;
  private List<String> tmE;
  
  static
  {
    AppMethodBeat.i(167797);
    AAW = new a((byte)0);
    TAG = "Finder.LogPost.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public n(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.Azr = paramFinderItem;
    this.AAM = this.Azr.field_postinfo;
    this.AAN = ((Map)new LinkedHashMap());
    this.AAO = new ConcurrentLinkedQueue();
    this.AAQ = ((List)new ArrayList());
    this.tmE = ((List)new ArrayList());
    this.AAS = ((List)new ArrayList());
    this.AAT = new c(this);
    this.AAU = new b(this);
    AppMethodBeat.o(167796);
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
    AppMethodBeat.i(290682);
    d(paramcsg);
    FinderMediaReportObject localFinderMediaReportObject = paramcsg.TAf;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramcsg = paramcsg.TAf;
    if (paramcsg != null)
    {
      paramcsg.cdnControl = paramInt;
      AppMethodBeat.o(290682);
      return;
    }
    AppMethodBeat.o(290682);
  }
  
  private static String aFt(String paramString)
  {
    AppMethodBeat.i(290681);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(290681);
    return paramString;
  }
  
  private final void aV(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(290684);
    int i;
    Object localObject2;
    try
    {
      this.AAM.TAg = 0;
      Object localObject1 = this.Azr;
      localObject3 = this.AAM;
      p.j(localObject3, "postinfo");
      ((FinderItem)localObject1).setPostInfo((csh)localObject3);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      c.a.s(this.Azr);
      this.AAS.clear();
      if ((AAV) && (Log.getLogLevel() <= 1))
      {
        Log.i(TAG, "debugDeleteFileWhenUpload");
        localObject1 = av.AJz;
        u.dK(av.egu(), true);
      }
      localObject1 = this.Azr.getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 != null)
        {
          localObject1 = this.Azr.getFeedObject().objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
            if ((localObject1 != null) && (((bfs)localObject1).SQv == 1))
            {
              localObject1 = this.Azr.getFeedObject().objectDesc;
              if (localObject1 == null) {
                break label664;
              }
              localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
              if (localObject1 == null) {
                break label664;
              }
              localObject1 = ((bfs)localObject1).musicInfo;
              if (localObject1 != null)
              {
                localObject1 = this.Azr.getFeedObject().objectDesc;
                if (localObject1 == null) {
                  break label670;
                }
                localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
                if (localObject1 == null) {
                  break label670;
                }
                localObject1 = ((bfs)localObject1).musicInfo;
                if (localObject1 == null) {
                  break label670;
                }
                localObject1 = ((bfg)localObject1).BHW;
                localObject1 = (CharSequence)localObject1;
                if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                  break label676;
                }
                i = 1;
                if (i != 0)
                {
                  localObject1 = this.Azr.getFeedObject().objectDesc;
                  if (localObject1 != null)
                  {
                    localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
                    if (localObject1 != null)
                    {
                      localObject1 = ((bfs)localObject1).musicInfo;
                      if (localObject1 != null)
                      {
                        localObject3 = ((bfg)localObject1).SPV;
                        if (localObject3 != null)
                        {
                          p.j(localObject3, "it");
                          if (!kotlin.n.n.M((String)localObject3, "http", true))
                          {
                            if (u.agG((String)localObject3)) {
                              break label681;
                            }
                            Log.i(TAG, "audio track " + (String)localObject3 + " is not file");
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        localObject1 = this.Azr.getPostInfo().TAn;
        if (localObject1 == null) {
          break label855;
        }
        localObject1 = ((dwi)localObject1).xaL;
        if (Util.isNullOrNil((String)localObject1)) {
          break label861;
        }
        i = 1;
        if (i != 0) {
          break label2182;
        }
        paramLinkedList = paramLinkedList.iterator();
        do
        {
          if (!paramLinkedList.hasNext()) {
            break label2231;
          }
          localObject1 = (csg)paramLinkedList.next();
          if (Util.isNullOrNil(((csg)localObject1).url)) {
            break label2089;
          }
          localObject3 = ((csg)localObject1).mediaId;
          Log.i(TAG, "uploading media " + (String)localObject3 + ", " + ((csg)localObject1).url + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject1).url)) + " thumb: " + ((csg)localObject1).thumbUrl + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject1).thumbUrl)));
          p.j(localObject1, "media");
          if ((Util.isNullOrNil(((csg)localObject1).TzS)) || (Util.isNullOrNil(((csg)localObject1).TzT))) {
            break;
          }
          Log.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
          i = 0;
        } while (i == 0);
        QD(i);
        qT(false);
        d(com.tencent.mm.loader.g.j.kQe);
        AppMethodBeat.o(290684);
      }
    }
    catch (Exception localException)
    {
      label664:
      label670:
      label676:
      label681:
      label855:
      label861:
      do
      {
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          i = 0;
          continue;
          localObject2 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject2).iUG = ((g.a)this.AAU);
          Object localObject4 = MD5Util.getMD5String((String)localObject3);
          p.j(localObject4, "MD5Util.getMD5String(path)");
          ((com.tencent.mm.i.g)localObject2).field_mediaId = aFt((String)localObject4);
          ((com.tencent.mm.i.g)localObject2).field_fullpath = ((String)localObject3);
          ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
          ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
          ((com.tencent.mm.i.g)localObject2).field_appType = 251;
          ((com.tencent.mm.i.g)localObject2).iUX = 8;
          ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
          ((com.tencent.mm.i.g)localObject2).iUK = 60;
          ((com.tencent.mm.i.g)localObject2).iUL = 600;
          ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.iTU;
          this.AAO.add(((com.tencent.mm.i.g)localObject2).field_mediaId);
          Object localObject3 = this.AAN;
          localObject4 = ((com.tencent.mm.i.g)localObject2).field_mediaId;
          p.j(localObject4, "info.field_mediaId");
          ((Map)localObject3).put(localObject4, Float.valueOf(0.0F));
          this.AAS.add(localObject2);
          continue;
          localObject2 = null;
          continue;
          i = 0;
          continue;
          if (u.agG(((csg)localObject2).url))
          {
            localObject3 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() != 4) {}
          }
          else
          {
            Log.i(TAG, "mediaObject.url " + ((csg)localObject2).url + " is not file");
            this.Azr.setPostFailedAndNotRetry(0);
            i = 1;
            continue;
          }
          localObject3 = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject3).taskName = "task_FinderUploadTask_1";
          ((com.tencent.mm.i.g)localObject3).iUG = ((g.a)this.AAU);
          localObject4 = MD5Util.getMD5String(((csg)localObject2).url);
          p.j(localObject4, "MD5Util.getMD5String(mediaObject.url)");
          ((com.tencent.mm.i.g)localObject3).field_mediaId = aFt((String)localObject4);
          ((com.tencent.mm.i.g)localObject3).field_fullpath = ((csg)localObject2).url;
          ((com.tencent.mm.i.g)localObject3).field_thumbpath = ((csg)localObject2).thumbUrl;
          ((com.tencent.mm.i.g)localObject3).field_talker = "";
          ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
          Log.i(TAG, "upload file length " + u.bBQ(((csg)localObject2).url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.Azr.getLocalId());
          String str;
          switch (((csg)localObject2).mediaType)
          {
          case 3: 
          case 5: 
          case 6: 
          default: 
            Log.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(((csg)localObject2).mediaType) });
            break;
          case 2: 
          case 7: 
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
            int j = e((csg)localObject2);
            i = j;
            if (j == 0) {
              if (!Util.isNullOrNil(((csg)localObject2).TzX)) {
                if (!u.agG(((csg)localObject2).TzX))
                {
                  Log.w(TAG, "upload failed, fullThumbUrl not exist, " + ((csg)localObject2).TzX);
                  i = 6;
                }
              }
            }
            break;
          case 4: 
            boolean bool1 = SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
            localObject4 = aj.AGc;
            localObject4 = ((com.tencent.mm.i.g)localObject3).field_fullpath;
            p.j(localObject4, "info.field_fullpath");
            boolean bool2 = aj.aFO((String)localObject4);
            Log.i(TAG, aBG() + " optimize result: " + bool1 + ", isOptimize:" + bool2);
            if (!bool1) {
              f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "optimizeMP4VFS_fail", bool2, false, (kotlin.g.a.a)new d(this), 12);
            }
            f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "opt_moov_fail", bool2, false, (kotlin.g.a.a)new e(this), 12);
            ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
            ((com.tencent.mm.i.g)localObject3).field_appType = 251;
            ((com.tencent.mm.i.g)localObject3).iUX = 8;
            ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
            ((com.tencent.mm.i.g)localObject3).iUK = 600;
            ((com.tencent.mm.i.g)localObject3).iUL = 1200;
            localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
            l = com.tencent.mm.plugin.finder.storage.d.dRV();
            localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
            StringBuilder localStringBuilder;
            if ((l > com.tencent.mm.plugin.finder.storage.d.dRZ()) || (f((csg)localObject2)))
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
                  a(0, (csg)localObject2);
                  localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                  localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
                  com.tencent.mm.plugin.finder.utils.g.a(com.tencent.mm.plugin.finder.utils.g.ecO());
                }
              }
            }
            for (;;)
            {
              if (f((csg)localObject2))
              {
                ((com.tencent.mm.i.g)localObject3).iUK = 600;
                ((com.tencent.mm.i.g)localObject3).iUL = 1200;
                break;
                bool1 = false;
                break label1669;
                localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
                if (com.tencent.mm.plugin.finder.storage.d.dUQ() == 1)
                {
                  localObject4 = j((com.tencent.mm.i.g)localObject3);
                  str = TAG;
                  localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                  if (localObject4 != null) {
                    break label1854;
                  }
                }
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              Log.i(str, bool1 + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
              a(1, (csg)localObject2);
              localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
              localObject4 = com.tencent.mm.plugin.finder.utils.g.ADd;
              com.tencent.mm.plugin.finder.utils.g.a(com.tencent.mm.plugin.finder.utils.g.ecO());
              break label1721;
              break;
            }
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).taskName = "task_FinderUploadTask_2";
            ((com.tencent.mm.i.g)localObject3).iUG = ((g.a)this.AAU);
            localObject4 = MD5Util.getMD5String(((csg)localObject2).TzX);
            p.j(localObject4, "MD5Util.getMD5String(mediaObject.fullThumbUrl)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = aFt((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = ((csg)localObject2).TzX;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = ((csg)localObject2).TzX;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            Log.i(TAG, "upload fullthumb file length " + u.bBQ(((csg)localObject2).TzX));
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
      label1669:
      label1721:
      label1854:
      Log.i(TAG, "uploadFinderContent media.url invalid, url:" + ((csg)localObject2).url + ", type:" + ((csg)localObject2).mediaType);
      label2089:
      QD(2);
      qT(false);
      d(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(290684);
      return;
    }
    label2182:
    paramLinkedList = (csg)kotlin.a.j.lp((List)paramLinkedList);
    if (paramLinkedList != null)
    {
      i = e(paramLinkedList);
      if (i != 0)
      {
        QD(i);
        qT(false);
        d(com.tencent.mm.loader.g.j.kQe);
        AppMethodBeat.o(290684);
        return;
      }
    }
    label2231:
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
      AppMethodBeat.o(290684);
      return;
    }
    paramLinkedList = v.d.zYG;
    v.d.qr(this.Azr.isLongVideo());
    AppMethodBeat.o(290684);
  }
  
  private final void d(com.tencent.mm.loader.g.j paramj)
  {
    AppMethodBeat.i(167793);
    this.AAT.dead();
    if (this.AAL)
    {
      Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.AAL);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramj);
    AppMethodBeat.o(167793);
  }
  
  private final void d(csg paramcsg)
  {
    AppMethodBeat.i(290683);
    FinderMediaReportObject localFinderMediaReportObject = paramcsg.TAf;
    if (localFinderMediaReportObject != null)
    {
      localFinderMediaReportObject.mediaType = paramcsg.mediaType;
      localFinderMediaReportObject.mediaId = paramcsg.mediaId;
      localFinderMediaReportObject.cdnUploadTime = ((int)(cm.bfE() - this.startTime));
      AppMethodBeat.o(290683);
      return;
    }
    Object localObject = (n)this;
    localFinderMediaReportObject = new FinderMediaReportObject();
    localFinderMediaReportObject.mediaType = paramcsg.mediaType;
    localFinderMediaReportObject.mediaId = paramcsg.mediaId;
    localFinderMediaReportObject.cdnUploadTime = ((int)(cm.bfE() - ((n)localObject).startTime));
    localObject = new FinderMediaReportInfo();
    ((FinderMediaReportInfo)localObject).width = ((int)paramcsg.width);
    ((FinderMediaReportInfo)localObject).height = ((int)paramcsg.height);
    ((FinderMediaReportInfo)localObject).fileSize = ((int)u.bBQ(paramcsg.url));
    ((FinderMediaReportInfo)localObject).videoDuration = paramcsg.videoDuration;
    ((FinderMediaReportInfo)localObject).videoBitrate = paramcsg.bitrate;
    localFinderMediaReportObject.videoFinalSize = ((FinderMediaReportInfo)localObject).fileSize;
    localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject);
    paramcsg.TAf = localFinderMediaReportObject;
    AppMethodBeat.o(290683);
  }
  
  private final int e(csg paramcsg)
  {
    AppMethodBeat.i(290685);
    if ((paramcsg.mediaType == 4) && (!Util.isNullOrNil(paramcsg.coverUrl)))
    {
      if (!u.agG(paramcsg.coverUrl))
      {
        Log.w(TAG, "upload failed, coverUrl not exist, " + paramcsg.coverUrl);
        AppMethodBeat.o(290685);
        return 5;
      }
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.iUG = ((g.a)this.AAU);
      String str = MD5Util.getMD5String(paramcsg.coverUrl);
      p.j(str, "MD5Util.getMD5String(mediaObject.coverUrl)");
      localg.field_mediaId = aFt(str);
      localg.field_fullpath = paramcsg.coverUrl;
      localg.field_thumbpath = paramcsg.coverUrl;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(TAG, "upload cover file length " + u.bBQ(paramcsg.coverUrl));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.iUK = 120;
      localg.iUL = 300;
      localg.field_priority = com.tencent.mm.i.a.iTU;
      this.AAO.add(localg.field_mediaId);
      paramcsg = this.AAN;
      str = localg.field_mediaId;
      p.j(str, "info.field_mediaId");
      paramcsg.put(str, Float.valueOf(0.0F));
      this.AAS.add(localg);
    }
    AppMethodBeat.o(290685);
    return 0;
  }
  
  private final boolean f(csg paramcsg)
  {
    AppMethodBeat.i(290687);
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
      AppMethodBeat.o(290687);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(290687);
    return false;
  }
  
  private static com.tencent.mm.plugin.sight.base.b j(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(290686);
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
      AppMethodBeat.o(290686);
      return localb;
    }
  }
  
  private final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
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
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.s(this.Azr);
        AppMethodBeat.o(167794);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(167794);
    }
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.Azr.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void start()
  {
    AppMethodBeat.i(290680);
    this.AAT.alive();
    this.Azr.trackPost("upload");
    Object localObject = this.Azr.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).postStage = 3;
    }
    this.startTime = cm.bfE();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dVi().aSr()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.d.dVi().aSr()).longValue() * 1000L);
    }
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() == 2)
    {
      d(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(290680);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).addAll((Collection)this.Azr.getHalfVideoMediaExtList());
    ((LinkedList)localObject).addAll((Collection)this.Azr.getMediaList());
    ((LinkedList)localObject).addAll((Collection)this.Azr.getLongVideoMediaExtList());
    this.AAQ.addAll((Collection)this.Azr.getLongVideoMediaExtList());
    aV((LinkedList)localObject);
    AppMethodBeat.o(290680);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167791);
      Object localObject1 = n.AAW;
      Object localObject3 = n.access$getTAG$cp();
      Object localObject4 = "on cdn callback someOneFailed:" + n.c(this.AAX) + ", mediaId = %s, startRet = %d, sceneResult %s";
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
      Log.i((String)localObject3, (String)localObject4, new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
      if ((n.a(this.AAX)) || (n.c(this.AAX)))
      {
        AppMethodBeat.o(167791);
        return 0;
      }
      n.a(this.AAX, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = n.AAW;
        Log.e(n.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramd = n.e(this.AAX);
          if (paramString != null) {
            break label2038;
          }
        }
      }
      label334:
      label1109:
      label1238:
      label1250:
      label1638:
      label1644:
      label2033:
      label2038:
      for (paramc = "";; paramc = paramString)
      {
        paramd.add(paramc);
        n.d(this.AAX);
        paramd = ((Iterable)this.AAX.Azr.getHalfVideoMediaExtList()).iterator();
        while (paramd.hasNext())
        {
          paramc = paramd.next();
          if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
          {
            paramc = (csg)paramc;
            if (paramc != null)
            {
              n.a(this.AAX, paramInt, paramc);
              paramc = x.aazN;
            }
            paramd = ((Iterable)this.AAX.Azr.getMediaList()).iterator();
            while (paramd.hasNext())
            {
              paramc = paramd.next();
              if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
              {
                paramc = (csg)paramc;
                if (paramc != null)
                {
                  n.a(this.AAX, paramInt, paramc);
                  paramc = x.aazN;
                }
                paramd = ((Iterable)this.AAX.Azr.getLongVideoMediaExtList()).iterator();
                do
                {
                  if (!paramd.hasNext()) {
                    break;
                  }
                  paramc = paramd.next();
                } while (!p.h(((csg)paramc).mediaId, n.aFv(paramString)));
              }
            }
          }
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (csg)paramString;
          if (paramString != null)
          {
            n.a(this.AAX, paramInt, paramString);
            paramString = x.aazN;
          }
          n.a(this.AAX, false);
          n.a(this.AAX, com.tencent.mm.loader.g.j.kQe);
          AppMethodBeat.o(167791);
          return 0;
          paramc = null;
          break;
          paramc = null;
          break label334;
        }
        if ((!Util.isNullOrNil(paramString)) && (paramd != null))
        {
          paramc = n.AAW;
          Log.i(n.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
          if (paramd.field_retCode != 0)
          {
            localObject1 = n.e(this.AAX);
            if (paramString != null) {
              break label2033;
            }
          }
        }
        for (paramc = "";; paramc = paramString)
        {
          ((List)localObject1).add(paramc);
          n.d(this.AAX);
          localObject1 = ((Iterable)this.AAX.Azr.getHalfVideoMediaExtList()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
            {
              paramc = (csg)paramc;
              if (paramc != null)
              {
                n.a(this.AAX, paramd.field_retCode, paramc);
                paramc = x.aazN;
              }
              localObject1 = ((Iterable)this.AAX.Azr.getMediaList()).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                paramc = ((Iterator)localObject1).next();
                if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
                {
                  paramc = (csg)paramc;
                  if (paramc != null)
                  {
                    n.a(this.AAX, paramd.field_retCode, paramc);
                    paramc = x.aazN;
                  }
                  localObject1 = ((Iterable)this.AAX.Azr.getLongVideoMediaExtList()).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    paramc = ((Iterator)localObject1).next();
                    if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
                    {
                      paramc = (csg)paramc;
                      if (paramc != null)
                      {
                        n.a(this.AAX, paramd.field_retCode, paramc);
                        paramc = x.aazN;
                      }
                      paramc = this.AAX.Azr.getFeedObject().objectDesc;
                      if (paramc == null) {
                        break label919;
                      }
                      paramc = paramc.feedBgmInfo;
                      if (paramc == null) {
                        break label919;
                      }
                    }
                  }
                }
              }
            }
          }
          for (paramc = paramc.musicInfo;; paramc = null)
          {
            if ((paramc != null) && (p.h(MD5Util.getMD5String(paramc.SPV), n.aFv(paramString)))) {
              h.IzE.p(1530L, 3L, 1L);
            }
            n.a(this.AAX, false);
            n.a(this.AAX, com.tencent.mm.loader.g.j.kQe);
            AppMethodBeat.o(167791);
            return 0;
            paramc = null;
            break;
            paramc = null;
            break label706;
            paramc = null;
            break label787;
          }
          n.f(this.AAX).remove(paramString);
          localObject3 = this.AAX.Azr.getMediaList();
          localObject2 = this.AAX.Azr.getLongVideoMediaExtList();
          localObject4 = this.AAX.Azr.getHalfVideoMediaExtList();
          paramInt = n.f(this.AAX).size();
          paramc = n.AAW;
          Log.i(n.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.AAX.Azr.getLocalId(), new Object[] { Long.valueOf(this.AAX.Azr.getLocalId()), Integer.valueOf(paramInt) });
          boolean bool1 = false;
          boolean bool2 = false;
          if (localObject3 != null)
          {
            localObject1 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
              {
                paramc = (csg)paramc;
                localObject1 = paramc;
                if (paramc == null)
                {
                  if (localObject2 == null) {
                    break label1638;
                  }
                  localObject1 = ((Iterable)localObject2).iterator();
                  do
                  {
                    if (!((Iterator)localObject1).hasNext()) {
                      break;
                    }
                    paramc = ((Iterator)localObject1).next();
                  } while (!p.h(((csg)paramc).mediaId, n.aFv(paramString)));
                  localObject1 = (csg)paramc;
                  if (localObject1 == null) {
                    break label1644;
                  }
                  paramBoolean = true;
                  bool1 = paramBoolean;
                }
                if (localObject1 != null) {
                  break label2023;
                }
                localObject1 = ((Iterable)localObject4).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  paramc = ((Iterator)localObject1).next();
                  if (p.h(((csg)paramc).mediaId, n.aFv(paramString)))
                  {
                    paramc = (csg)paramc;
                    if (paramc == null) {
                      break label1655;
                    }
                    paramBoolean = true;
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (paramc != null)
            {
              localObject1 = n.AAW;
              Log.i(n.access$getTAG$cp(), "hitMedia, isLongVideo:" + bool1 + ", isHalf:" + paramBoolean);
              paramc.mediaId = MD5Util.getMD5String(paramc.url);
              paramc.TzS = paramd.field_fileUrl;
              paramc.TzT = paramd.field_thumbUrl;
              paramc.md5sum = paramd.field_filemd5;
              if (!bool1)
              {
                if (!paramBoolean) {
                  this.AAX.Azr.setMediaList((LinkedList)localObject3);
                }
                n.a(this.AAX, 0, paramc);
                localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
                c.a.s(this.AAX.Azr);
              }
            }
            else if (paramc == null)
            {
              paramc = this.AAX.Azr.getFeedObject().objectDesc;
              if (paramc == null) {
                break label1760;
              }
              paramc = paramc.feedBgmInfo;
              if (paramc == null) {
                break label1760;
              }
            }
            for (paramc = paramc.musicInfo;; paramc = null)
            {
              if (paramc == null) {
                break label1765;
              }
              localObject1 = paramc.SPV;
              paramc = (com.tencent.mm.i.c)localObject1;
              if (localObject1 == null) {
                paramc = "";
              }
              if (!p.h(MD5Util.getMD5String(paramc), n.aFv(paramString))) {
                break label1765;
              }
              paramString = this.AAX.Azr.getFeedObject().objectDesc;
              if (paramString != null)
              {
                paramString = paramString.feedBgmInfo;
                if (paramString != null)
                {
                  paramString = paramString.musicInfo;
                  if (paramString != null) {
                    paramString.SPV = paramd.field_fileUrl;
                  }
                }
              }
              paramString = this.AAX.Azr.getFeedObject().objectDesc;
              if (paramString != null)
              {
                paramString = paramString.feedBgmInfo;
                if (paramString != null)
                {
                  paramString = paramString.musicInfo;
                  if (paramString != null) {
                    paramString.BHW = "";
                  }
                }
              }
              paramString = this.AAX.Azr.getFeedObject().objectDesc;
              if (paramString != null)
              {
                paramString = paramString.feedBgmInfo;
                if (paramString != null)
                {
                  paramString = paramString.musicInfo;
                  if (paramString != null) {
                    paramString.name = "";
                  }
                }
              }
              paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
              c.a.s(this.AAX.Azr);
              if (paramInt == 0)
              {
                n.a(this.AAX, true);
                n.a(this.AAX, com.tencent.mm.loader.g.j.kQd);
              }
              AppMethodBeat.o(167791);
              return 0;
              paramc = null;
              break;
              paramc = null;
              break label1109;
              paramc = null;
              break label1168;
              localObject1 = null;
              break label1174;
              paramBoolean = false;
              break label1182;
              paramc = null;
              break label1238;
              label1655:
              paramBoolean = false;
              break label1250;
              localObject1 = this.AAX.Azr.getFeedObject().attachmentList;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((apx)localObject1).SDm;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = (apw)kotlin.a.j.lp((List)localObject1);
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((apw)localObject1).SDl;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((blj)localObject1).SPm;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((cvy)localObject1).TEM;
              if (localObject1 == null) {
                break label1354;
              }
              ((cwc)localObject1).media = com.tencent.mm.plugin.finder.storage.data.n.aT((LinkedList)localObject2);
              break label1354;
            }
            localObject4 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject1 = ((Iterator)localObject4).next();
              localObject2 = ((csg)localObject1).coverUrl;
              paramc = (com.tencent.mm.i.c)localObject2;
              if (localObject2 == null) {
                paramc = "";
              }
              if (p.h(MD5Util.getMD5String(paramc), n.aFv(paramString)))
              {
                paramc = (com.tencent.mm.i.c)localObject1;
                paramc = (csg)paramc;
                if (paramc != null)
                {
                  localObject1 = n.AAW;
                  Log.i(n.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
                  paramc.TzV = paramd.field_fileUrl;
                  paramc = x.aazN;
                }
                localObject3 = ((Iterable)localObject3).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = ((Iterator)localObject3).next();
                  localObject2 = ((csg)localObject1).TzX;
                  paramc = (com.tencent.mm.i.c)localObject2;
                  if (localObject2 == null) {
                    paramc = "";
                  }
                } while (!p.h(MD5Util.getMD5String(paramc), n.aFv(paramString)));
              }
            }
            for (paramString = (String)localObject1;; paramString = null)
            {
              paramString = (csg)paramString;
              if (paramString == null) {
                break;
              }
              paramc = n.AAW;
              Log.i(n.access$getTAG$cp(), "upload fullThumb ok, url:" + paramd.field_fileUrl);
              paramString.TzZ = paramd.field_fileUrl;
              paramString = x.aazN;
              break;
              paramc = null;
              break label1834;
            }
            paramc = (com.tencent.mm.i.c)localObject1;
            paramBoolean = bool2;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hn>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.c paramc, hn paramhn)
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
    d(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<String>
  {
    e(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.n
 * JD-Core Version:    0.7.0.1
 */