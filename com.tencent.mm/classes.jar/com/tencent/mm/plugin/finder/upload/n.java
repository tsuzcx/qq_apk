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
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "isRemoteUpload", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class n
  extends j
{
  private static final String TAG = "Finder.LogPost.FinderUploadTask";
  private static boolean vTs;
  public static final a vTt;
  private List<String> pQE;
  private long startTime;
  FinderItem vRO;
  private boolean vTi;
  private final cjm vTj;
  private final Map<String, Float> vTk;
  private final ConcurrentLinkedQueue<String> vTl;
  private boolean vTm;
  private List<cjl> vTn;
  private boolean vTo;
  private final List<g> vTp;
  private final c vTq;
  private final b vTr;
  
  static
  {
    AppMethodBeat.i(167797);
    vTt = new a((byte)0);
    TAG = "Finder.LogPost.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public n(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.vRO = paramFinderItem;
    this.vTj = this.vRO.field_postinfo;
    this.vTk = ((Map)new LinkedHashMap());
    this.vTl = new ConcurrentLinkedQueue();
    this.vTn = ((List)new ArrayList());
    this.pQE = ((List)new ArrayList());
    this.vTp = ((List)new ArrayList());
    this.vTq = new c(this);
    this.vTr = new b(this);
    AppMethodBeat.o(167796);
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
    AppMethodBeat.i(253125);
    e(paramcjl);
    FinderMediaReportObject localFinderMediaReportObject = paramcjl.MoZ;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    paramcjl = paramcjl.MoZ;
    if (paramcjl != null)
    {
      paramcjl.cdnControl = paramInt;
      AppMethodBeat.o(253125);
      return;
    }
    AppMethodBeat.o(253125);
  }
  
  private final void aE(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(253127);
    int i;
    Object localObject2;
    try
    {
      this.vTj.Mpa = 0;
      Object localObject1 = this.vRO;
      localObject3 = this.vTj;
      p.g(localObject3, "postinfo");
      ((FinderItem)localObject1).setPostInfo((cjm)localObject3);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      c.a.r(this.vRO);
      this.vTp.clear();
      if ((vTs) && (Log.getLogLevel() <= 1))
      {
        Log.i(TAG, "debugDeleteFileWhenUpload");
        localObject1 = al.waC;
        s.dy(al.dEH(), true);
      }
      localObject1 = this.vRO.getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 != null)
        {
          localObject1 = this.vRO.getFeedObject().objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
            if ((localObject1 != null) && (((azr)localObject1).LJw == 1))
            {
              localObject1 = this.vRO.getFeedObject().objectDesc;
              if (localObject1 == null) {
                break label677;
              }
              localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
              if (localObject1 == null) {
                break label677;
              }
              localObject1 = ((azr)localObject1).musicInfo;
              if (localObject1 != null)
              {
                localObject1 = this.vRO.getFeedObject().objectDesc;
                if (localObject1 == null) {
                  break label683;
                }
                localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
                if (localObject1 == null) {
                  break label683;
                }
                localObject1 = ((azr)localObject1).musicInfo;
                if (localObject1 == null) {
                  break label683;
                }
                localObject1 = ((azk)localObject1).wWb;
                localObject1 = (CharSequence)localObject1;
                if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                  break label689;
                }
                i = 1;
                if (i != 0)
                {
                  localObject1 = this.vRO.getFeedObject().objectDesc;
                  if (localObject1 != null)
                  {
                    localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
                    if (localObject1 != null)
                    {
                      localObject1 = ((azr)localObject1).musicInfo;
                      if (localObject1 != null)
                      {
                        localObject3 = ((azk)localObject1).LJi;
                        if (localObject3 != null)
                        {
                          p.g(localObject3, "it");
                          if (!kotlin.n.n.J((String)localObject3, "http", true))
                          {
                            if (s.YS((String)localObject3)) {
                              break label694;
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
        localObject1 = this.vRO.getPostInfo().Mph;
        if (localObject1 == null) {
          break label868;
        }
        localObject1 = ((dmr)localObject1).tsW;
        if (Util.isNullOrNil((String)localObject1)) {
          break label874;
        }
        i = 1;
        if (i != 0) {
          break label2133;
        }
        paramLinkedList = paramLinkedList.iterator();
        do
        {
          if (!paramLinkedList.hasNext()) {
            break label2182;
          }
          localObject1 = (cjl)paramLinkedList.next();
          if (Util.isNullOrNil(((cjl)localObject1).url)) {
            break label2040;
          }
          localObject3 = ((cjl)localObject1).mediaId;
          Log.i(TAG, "uploading media " + (String)localObject3 + ", " + ((cjl)localObject1).url + " size:" + Util.getSizeKB(s.boW(((cjl)localObject1).url)) + " thumb: " + ((cjl)localObject1).thumbUrl + " size:" + Util.getSizeKB(s.boW(((cjl)localObject1).thumbUrl)));
          p.g(localObject1, "media");
          if (s.YS(((cjl)localObject1).url)) {
            break;
          }
          Log.i(TAG, "mediaObject.url " + ((cjl)localObject1).url + " is not file");
          i = 1;
        } while (i == 0);
        Lu(i);
        oG(false);
        d(com.tencent.mm.loader.g.j.ibx);
        AppMethodBeat.o(253127);
      }
    }
    catch (Exception localException)
    {
      label677:
      label683:
      label689:
      label694:
      label868:
      label874:
      label2040:
      do
      {
        Object localObject3;
        Object localObject4;
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
          localObject2 = new g();
          ((g)localObject2).gqy = ((g.a)this.vTr);
          localObject4 = MD5Util.getMD5String((String)localObject3);
          p.g(localObject4, "MD5Util.getMD5String(path)");
          ((g)localObject2).field_mediaId = awa((String)localObject4);
          ((g)localObject2).field_fullpath = ((String)localObject3);
          ((g)localObject2).field_needStorage = true;
          ((g)localObject2).field_fileType = 20302;
          ((g)localObject2).field_appType = 251;
          ((g)localObject2).gqP = 8;
          ((g)localObject2).field_bzScene = 2;
          ((g)localObject2).gqC = 60;
          ((g)localObject2).gqD = 600;
          ((g)localObject2).field_priority = com.tencent.mm.i.a.gpM;
          this.vTl.add(((g)localObject2).field_mediaId);
          localObject3 = this.vTk;
          localObject4 = ((g)localObject2).field_mediaId;
          p.g(localObject4, "info.field_mediaId");
          ((Map)localObject3).put(localObject4, Float.valueOf(0.0F));
          this.vTp.add(localObject2);
          continue;
          localObject2 = null;
          continue;
          i = 0;
        }
        if ((!Util.isNullOrNil(((cjl)localObject2).MoM)) && (!Util.isNullOrNil(((cjl)localObject2).MoN))) {
          Log.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject3 = new g();
          ((g)localObject3).taskName = "task_FinderUploadTask_1";
          ((g)localObject3).gqy = ((g.a)this.vTr);
          localObject4 = MD5Util.getMD5String(((cjl)localObject2).url);
          p.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
          ((g)localObject3).field_mediaId = awa((String)localObject4);
          ((g)localObject3).field_fullpath = ((cjl)localObject2).url;
          ((g)localObject3).field_thumbpath = ((cjl)localObject2).thumbUrl;
          ((g)localObject3).field_talker = "";
          ((g)localObject3).field_needStorage = true;
          Log.i(TAG, "upload file length " + s.boW(((cjl)localObject2).url) + " mediaId: " + ((g)localObject3).field_mediaId + " localId:" + this.vRO.getLocalId());
          Object localObject5;
          switch (((cjl)localObject2).mediaType)
          {
          case 3: 
          case 5: 
          case 6: 
          default: 
            Log.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(((cjl)localObject2).mediaType) });
            break;
          case 2: 
          case 7: 
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
            int j = f((cjl)localObject2);
            i = j;
            if (j != 0) {
              break;
            }
            if (!Util.isNullOrNil(((cjl)localObject2).MoR)) {
              if (!s.YS(((cjl)localObject2).MoR))
              {
                Log.w(TAG, "upload failed, fullThumbUrl not exist, " + ((cjl)localObject2).MoR);
                i = 6;
              }
            }
            break;
          case 4: 
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
            ((g)localObject3).gqC = 600;
            ((g)localObject3).gqD = 1200;
            localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            l = com.tencent.mm.plugin.finder.storage.c.dqI();
            localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            StringBuilder localStringBuilder;
            if ((l > com.tencent.mm.plugin.finder.storage.c.dqM()) || (g((cjl)localObject2)))
            {
              l = s.boW(((g)localObject3).field_fullpath);
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
                ((g)localObject3).gqC = 600;
                ((g)localObject3).gqD = 1200;
                break;
                bool = false;
                break label1620;
                localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dtH() == 1)
                {
                  localObject4 = j((g)localObject3);
                  localObject5 = TAG;
                  localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
                  if (localObject4 != null) {
                    break label1805;
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
              break label1672;
              break;
            }
            localObject3 = new g();
            ((g)localObject3).taskName = "task_FinderUploadTask_2";
            ((g)localObject3).gqy = ((g.a)this.vTr);
            localObject4 = MD5Util.getMD5String(((cjl)localObject2).MoR);
            p.g(localObject4, "MD5Util.getMD5String(mediaObject.fullThumbUrl)");
            ((g)localObject3).field_mediaId = awa((String)localObject4);
            ((g)localObject3).field_fullpath = ((cjl)localObject2).MoR;
            ((g)localObject3).field_thumbpath = ((cjl)localObject2).MoR;
            ((g)localObject3).field_talker = "";
            ((g)localObject3).field_needStorage = true;
            Log.i(TAG, "upload fullthumb file length " + s.boW(((cjl)localObject2).MoR));
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
        }
      } while ((((cjl)localObject2).mediaType != 2) && (((cjl)localObject2).mediaType != 7) && (((cjl)localObject2).mediaType != 4));
      label1620:
      Log.i(TAG, "uploadFinderContent media.url invalid, url:" + ((cjl)localObject2).url + ", type:" + ((cjl)localObject2).mediaType);
      label1672:
      label1805:
      Lu(2);
      oG(false);
      d(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253127);
      return;
    }
    label2133:
    paramLinkedList = (cjl)kotlin.a.j.kt((List)paramLinkedList);
    if (paramLinkedList != null)
    {
      i = f(paramLinkedList);
      if (i != 0)
      {
        Lu(i);
        oG(false);
        d(com.tencent.mm.loader.g.j.ibx);
        AppMethodBeat.o(253127);
        return;
      }
    }
    label2182:
    Log.i(TAG, "upload info count:" + this.vTp.size());
    long l = 0L;
    paramLinkedList = ((Iterable)this.vTp).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject2 = (g)paramLinkedList.next();
      com.tencent.mm.an.f.baQ().f((g)localObject2);
      l = s.boW(((g)localObject2).field_fullpath) + l;
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
      AppMethodBeat.o(253127);
      return;
    }
    paramLinkedList = r.d.vhx;
    r.d.og(this.vRO.isLongVideo());
    AppMethodBeat.o(253127);
  }
  
  private static String awa(String paramString)
  {
    AppMethodBeat.i(253124);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(253124);
    return paramString;
  }
  
  private final void d(com.tencent.mm.loader.g.j paramj)
  {
    AppMethodBeat.i(167793);
    this.vTq.dead();
    if (this.vTi)
    {
      Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.vTi);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramj);
    AppMethodBeat.o(167793);
  }
  
  private final void e(cjl paramcjl)
  {
    AppMethodBeat.i(253126);
    FinderMediaReportObject localFinderMediaReportObject = paramcjl.MoZ;
    if (localFinderMediaReportObject != null)
    {
      localFinderMediaReportObject.mediaType = paramcjl.mediaType;
      localFinderMediaReportObject.mediaId = paramcjl.mediaId;
      localFinderMediaReportObject.cdnUploadTime = ((int)(cl.aWA() - this.startTime));
      AppMethodBeat.o(253126);
      return;
    }
    Object localObject = (n)this;
    localFinderMediaReportObject = new FinderMediaReportObject();
    localFinderMediaReportObject.mediaType = paramcjl.mediaType;
    localFinderMediaReportObject.mediaId = paramcjl.mediaId;
    localFinderMediaReportObject.cdnUploadTime = ((int)(cl.aWA() - ((n)localObject).startTime));
    localObject = new FinderMediaReportInfo();
    ((FinderMediaReportInfo)localObject).width = ((int)paramcjl.width);
    ((FinderMediaReportInfo)localObject).height = ((int)paramcjl.height);
    ((FinderMediaReportInfo)localObject).fileSize = ((int)s.boW(paramcjl.url));
    ((FinderMediaReportInfo)localObject).videoDuration = paramcjl.videoDuration;
    ((FinderMediaReportInfo)localObject).videoBitrate = paramcjl.bitrate;
    localFinderMediaReportObject.videoFinalSize = ((FinderMediaReportInfo)localObject).fileSize;
    localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject);
    paramcjl.MoZ = localFinderMediaReportObject;
    AppMethodBeat.o(253126);
  }
  
  private final int f(cjl paramcjl)
  {
    AppMethodBeat.i(253128);
    if ((paramcjl.mediaType == 4) && (!Util.isNullOrNil(paramcjl.coverUrl)))
    {
      if (!s.YS(paramcjl.coverUrl))
      {
        Log.w(TAG, "upload failed, coverUrl not exist, " + paramcjl.coverUrl);
        AppMethodBeat.o(253128);
        return 5;
      }
      g localg = new g();
      localg.taskName = "task_FinderUploadTask_2";
      localg.gqy = ((g.a)this.vTr);
      String str = MD5Util.getMD5String(paramcjl.coverUrl);
      p.g(str, "MD5Util.getMD5String(mediaObject.coverUrl)");
      localg.field_mediaId = awa(str);
      localg.field_fullpath = paramcjl.coverUrl;
      localg.field_thumbpath = paramcjl.coverUrl;
      localg.field_talker = "";
      localg.field_needStorage = true;
      Log.i(TAG, "upload cover file length " + s.boW(paramcjl.coverUrl));
      localg.field_fileType = 20304;
      localg.field_appType = 251;
      localg.field_bzScene = 2;
      localg.gqC = 120;
      localg.gqD = 300;
      localg.field_priority = com.tencent.mm.i.a.gpM;
      this.vTl.add(localg.field_mediaId);
      paramcjl = this.vTk;
      str = localg.field_mediaId;
      p.g(str, "info.field_mediaId");
      paramcjl.put(str, Float.valueOf(0.0F));
      this.vTp.add(localg);
    }
    AppMethodBeat.o(253128);
    return 0;
  }
  
  private final boolean g(cjl paramcjl)
  {
    AppMethodBeat.i(253130);
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
      AppMethodBeat.o(253130);
      return true;
      i += 1;
      break;
      i = -1;
    }
    label73:
    AppMethodBeat.o(253130);
    return false;
  }
  
  private static com.tencent.mm.plugin.sight.base.a j(g paramg)
  {
    AppMethodBeat.i(253129);
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
      AppMethodBeat.o(253129);
      return locala;
    }
  }
  
  private final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
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
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(this.vRO);
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
  
  public final String auK()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.vRO.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void start()
  {
    AppMethodBeat.i(253123);
    this.vTq.alive();
    this.vRO.trackPost("upload");
    Object localObject = this.vRO.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).postStage = 3;
    }
    this.startTime = cl.aWA();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((((Number)com.tencent.mm.plugin.finder.storage.c.dtZ().value()).intValue() > 0) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.c.dtZ().value()).longValue() * 1000L);
    }
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dra().value()).intValue() == 2)
    {
      d(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253123);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).addAll((Collection)this.vRO.getHalfVideoMediaExtList());
    ((LinkedList)localObject).addAll((Collection)this.vRO.getMediaList());
    ((LinkedList)localObject).addAll((Collection)this.vRO.getLongVideoMediaExtList());
    this.vTn.addAll((Collection)this.vRO.getLongVideoMediaExtList());
    aE((LinkedList)localObject);
    AppMethodBeat.o(253123);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167791);
      Object localObject1 = n.vTt;
      Object localObject3 = n.access$getTAG$cp();
      Object localObject4 = "on cdn callback someOneFailed:" + n.c(this.vTu) + ", mediaId = %s, startRet = %d, sceneResult %s";
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
      if ((n.a(this.vTu)) || (n.c(this.vTu)))
      {
        AppMethodBeat.o(167791);
        return 0;
      }
      n.a(this.vTu, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = n.vTt;
        Log.e(n.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramd = n.e(this.vTu);
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
        n.d(this.vTu);
        paramd = ((Iterable)this.vTu.vRO.getHalfVideoMediaExtList()).iterator();
        while (paramd.hasNext())
        {
          paramc = paramd.next();
          if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
          {
            paramc = (cjl)paramc;
            if (paramc != null)
            {
              n.a(this.vTu, paramInt, paramc);
              paramc = x.SXb;
            }
            paramd = ((Iterable)this.vTu.vRO.getMediaList()).iterator();
            while (paramd.hasNext())
            {
              paramc = paramd.next();
              if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
              {
                paramc = (cjl)paramc;
                if (paramc != null)
                {
                  n.a(this.vTu, paramInt, paramc);
                  paramc = x.SXb;
                }
                paramd = ((Iterable)this.vTu.vRO.getLongVideoMediaExtList()).iterator();
                do
                {
                  if (!paramd.hasNext()) {
                    break;
                  }
                  paramc = paramd.next();
                } while (!p.j(((cjl)paramc).mediaId, n.awc(paramString)));
              }
            }
          }
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (cjl)paramString;
          if (paramString != null)
          {
            n.a(this.vTu, paramInt, paramString);
            paramString = x.SXb;
          }
          n.a(this.vTu, false);
          n.a(this.vTu, com.tencent.mm.loader.g.j.ibx);
          AppMethodBeat.o(167791);
          return 0;
          paramc = null;
          break;
          paramc = null;
          break label334;
        }
        if ((!Util.isNullOrNil(paramString)) && (paramd != null))
        {
          paramc = n.vTt;
          Log.i(n.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
          if (paramd.field_retCode != 0)
          {
            localObject1 = n.e(this.vTu);
            if (paramString != null) {
              break label2033;
            }
          }
        }
        for (paramc = "";; paramc = paramString)
        {
          ((List)localObject1).add(paramc);
          n.d(this.vTu);
          localObject1 = ((Iterable)this.vTu.vRO.getHalfVideoMediaExtList()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramc = ((Iterator)localObject1).next();
            if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
            {
              paramc = (cjl)paramc;
              if (paramc != null)
              {
                n.a(this.vTu, paramd.field_retCode, paramc);
                paramc = x.SXb;
              }
              localObject1 = ((Iterable)this.vTu.vRO.getMediaList()).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                paramc = ((Iterator)localObject1).next();
                if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
                {
                  paramc = (cjl)paramc;
                  if (paramc != null)
                  {
                    n.a(this.vTu, paramd.field_retCode, paramc);
                    paramc = x.SXb;
                  }
                  localObject1 = ((Iterable)this.vTu.vRO.getLongVideoMediaExtList()).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    paramc = ((Iterator)localObject1).next();
                    if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
                    {
                      paramc = (cjl)paramc;
                      if (paramc != null)
                      {
                        n.a(this.vTu, paramd.field_retCode, paramc);
                        paramc = x.SXb;
                      }
                      paramc = this.vTu.vRO.getFeedObject().objectDesc;
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
            if ((paramc != null) && (p.j(MD5Util.getMD5String(paramc.LJi), n.awc(paramString)))) {
              h.CyF.n(1530L, 3L, 1L);
            }
            n.a(this.vTu, false);
            n.a(this.vTu, com.tencent.mm.loader.g.j.ibx);
            AppMethodBeat.o(167791);
            return 0;
            paramc = null;
            break;
            paramc = null;
            break label706;
            paramc = null;
            break label787;
          }
          n.f(this.vTu).remove(paramString);
          localObject3 = this.vTu.vRO.getMediaList();
          localObject2 = this.vTu.vRO.getLongVideoMediaExtList();
          localObject4 = this.vTu.vRO.getHalfVideoMediaExtList();
          paramInt = n.f(this.vTu).size();
          paramc = n.vTt;
          Log.i(n.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.vTu.vRO.getLocalId(), new Object[] { Long.valueOf(this.vTu.vRO.getLocalId()), Integer.valueOf(paramInt) });
          boolean bool1 = false;
          boolean bool2 = false;
          if (localObject3 != null)
          {
            localObject1 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramc = ((Iterator)localObject1).next();
              if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
              {
                paramc = (cjl)paramc;
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
                  } while (!p.j(((cjl)paramc).mediaId, n.awc(paramString)));
                  localObject1 = (cjl)paramc;
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
                  if (p.j(((cjl)paramc).mediaId, n.awc(paramString)))
                  {
                    paramc = (cjl)paramc;
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
              localObject1 = n.vTt;
              Log.i(n.access$getTAG$cp(), "hitMedia, isLongVideo:" + bool1 + ", isHalf:" + paramBoolean);
              paramc.mediaId = MD5Util.getMD5String(paramc.url);
              paramc.MoM = paramd.field_fileUrl;
              paramc.MoN = paramd.field_thumbUrl;
              paramc.md5sum = paramd.field_filemd5;
              if (!bool1)
              {
                if (!paramBoolean) {
                  this.vTu.vRO.setMediaList((LinkedList)localObject3);
                }
                n.a(this.vTu, 0, paramc);
                localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.r(this.vTu.vRO);
              }
            }
            else if (paramc == null)
            {
              paramc = this.vTu.vRO.getFeedObject().objectDesc;
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
              localObject1 = paramc.LJi;
              paramc = (com.tencent.mm.i.c)localObject1;
              if (localObject1 == null) {
                paramc = "";
              }
              if (!p.j(MD5Util.getMD5String(paramc), n.awc(paramString))) {
                break label1765;
              }
              paramString = this.vTu.vRO.getFeedObject().objectDesc;
              if (paramString != null)
              {
                paramString = paramString.feedBgmInfo;
                if (paramString != null)
                {
                  paramString = paramString.musicInfo;
                  if (paramString != null) {
                    paramString.LJi = paramd.field_fileUrl;
                  }
                }
              }
              paramString = this.vTu.vRO.getFeedObject().objectDesc;
              if (paramString != null)
              {
                paramString = paramString.feedBgmInfo;
                if (paramString != null)
                {
                  paramString = paramString.musicInfo;
                  if (paramString != null) {
                    paramString.wWb = "";
                  }
                }
              }
              paramString = this.vTu.vRO.getFeedObject().objectDesc;
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
              paramString = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
              c.a.r(this.vTu.vRO);
              if (paramInt == 0)
              {
                n.a(this.vTu, true);
                n.a(this.vTu, com.tencent.mm.loader.g.j.ibw);
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
              localObject1 = this.vTu.vRO.getFeedObject().attachmentList;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((aoq)localObject1).LAM;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((aop)localObject1).LAL;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((bei)localObject1).LIA;
              if (localObject1 == null) {
                break label1354;
              }
              localObject1 = ((cng)localObject1).MtG;
              if (localObject1 == null) {
                break label1354;
              }
              ((cnl)localObject1).media = o.aC((LinkedList)localObject2);
              break label1354;
            }
            localObject4 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject1 = ((Iterator)localObject4).next();
              localObject2 = ((cjl)localObject1).coverUrl;
              paramc = (com.tencent.mm.i.c)localObject2;
              if (localObject2 == null) {
                paramc = "";
              }
              if (p.j(MD5Util.getMD5String(paramc), n.awc(paramString)))
              {
                paramc = (com.tencent.mm.i.c)localObject1;
                paramc = (cjl)paramc;
                if (paramc != null)
                {
                  localObject1 = n.vTt;
                  Log.i(n.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
                  paramc.MoP = paramd.field_fileUrl;
                  paramc = x.SXb;
                }
                localObject3 = ((Iterable)localObject3).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = ((Iterator)localObject3).next();
                  localObject2 = ((cjl)localObject1).MoR;
                  paramc = (com.tencent.mm.i.c)localObject2;
                  if (localObject2 == null) {
                    paramc = "";
                  }
                } while (!p.j(MD5Util.getMD5String(paramc), n.awc(paramString)));
              }
            }
            for (paramString = (String)localObject1;; paramString = null)
            {
              paramString = (cjl)paramString;
              if (paramString == null) {
                break;
              }
              paramc = n.vTt;
              Log.i(n.access$getTAG$cp(), "upload fullThumb ok, url:" + paramd.field_fileUrl);
              paramString.MoT = paramd.field_fileUrl;
              paramString = x.SXb;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hg>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.c paramc, hg paramhg)
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
    d(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.n
 * JD-Core Version:    0.7.0.1
 */