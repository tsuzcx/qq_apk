package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.o.b;
import com.tencent.mm.plugin.finder.report.o.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "", "getItemProgress", "()Ljava/util/Map;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "call", "", "checkReportObj", "updateMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadLocalMedia", "mediaObject", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.LogPost.FinderUploadTask";
  private static boolean sUS;
  public static final a sUT;
  FinderItem sTR;
  private boolean sUL;
  private final bwa sUM;
  private final Map<String, Float> sUN;
  private final ConcurrentLinkedQueue<String> sUO;
  private boolean sUP;
  private final c sUQ;
  private final b sUR;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(167797);
    sUT = new a((byte)0);
    TAG = "Finder.LogPost.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.sTR = paramFinderItem;
    this.sUM = this.sTR.field_postinfo;
    this.sUN = ((Map)new LinkedHashMap());
    this.sUO = new ConcurrentLinkedQueue();
    this.sUQ = new c(this);
    this.sUR = new b(this);
    AppMethodBeat.o(167796);
  }
  
  private final void Gd(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.sTR.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  private final void a(int paramInt, bvz parambvz)
  {
    AppMethodBeat.i(204966);
    c(parambvz);
    FinderMediaReportObject localFinderMediaReportObject = parambvz.HiY;
    if (localFinderMediaReportObject != null) {
      localFinderMediaReportObject.isBigFile = 1;
    }
    parambvz = parambvz.HiY;
    if (parambvz != null)
    {
      parambvz.cdnControl = paramInt;
      AppMethodBeat.o(204966);
      return;
    }
    AppMethodBeat.o(204966);
  }
  
  private static String ajN(String paramString)
  {
    AppMethodBeat.i(204965);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(204965);
    return paramString;
  }
  
  private final void c(bvz parambvz)
  {
    AppMethodBeat.i(204967);
    FinderMediaReportObject localFinderMediaReportObject = parambvz.HiY;
    if (localFinderMediaReportObject != null)
    {
      localFinderMediaReportObject.mediaType = parambvz.mediaType;
      localFinderMediaReportObject.mediaId = parambvz.mediaId;
      localFinderMediaReportObject.cdnUploadTime = ((int)(ch.aDc() - this.startTime));
      AppMethodBeat.o(204967);
      return;
    }
    Object localObject = (k)this;
    localFinderMediaReportObject = new FinderMediaReportObject();
    localFinderMediaReportObject.mediaType = parambvz.mediaType;
    localFinderMediaReportObject.mediaId = parambvz.mediaId;
    localFinderMediaReportObject.cdnUploadTime = ((int)(ch.aDc() - ((k)localObject).startTime));
    localObject = new FinderMediaReportInfo();
    ((FinderMediaReportInfo)localObject).width = ((int)parambvz.width);
    ((FinderMediaReportInfo)localObject).height = ((int)parambvz.height);
    ((FinderMediaReportInfo)localObject).fileSize = ((int)o.aZR(parambvz.url));
    ((FinderMediaReportInfo)localObject).videoDuration = parambvz.videoDuration;
    ((FinderMediaReportInfo)localObject).videoBitrate = parambvz.bitrate;
    localFinderMediaReportObject.videoFinalSize = ((FinderMediaReportInfo)localObject).fileSize;
    localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject);
    parambvz.HiY = localFinderMediaReportObject;
    AppMethodBeat.o(204967);
  }
  
  private final void d(com.tencent.mm.loader.g.j paramj)
  {
    AppMethodBeat.i(167793);
    this.sUQ.dead();
    if (this.sUL)
    {
      ae.i(TAG, "invoke_CallbackFun isMarkFail " + this.sUL);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramj);
    AppMethodBeat.o(167793);
  }
  
  private static com.tencent.mm.plugin.sight.base.a j(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(204968);
    paramg.snsVersion = 1;
    com.tencent.mm.plugin.sight.base.a locala = e.ayN(paramg.field_fullpath);
    int j;
    if (locala != null)
    {
      j = locala.videoBitrate;
      if (!com.tencent.mm.modelvideo.r.isH265Video(paramg.field_fullpath)) {
        break label108;
      }
    }
    label108:
    for (int i = 174;; i = 28)
    {
      String str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
      ae.i(TAG, "customHeader ".concat(String.valueOf(str)));
      paramg.customHeader = str;
      AppMethodBeat.o(204968);
      return locala;
    }
  }
  
  private final void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
    if (!paramBoolean) {}
    try
    {
      this.sUL = false;
      if (!paramBoolean) {}
      for (this.sUM.HiZ = 2;; this.sUM.HiZ = 1)
      {
        this.sUM.gsq = (ch.aDa() - this.startTime);
        Object localObject = this.sTR;
        bwa localbwa = this.sUM;
        p.g(localbwa, "postinfo");
        ((FinderItem)localObject).setPostInfo(localbwa);
        localObject = o.b.sAp;
        o.b.wV(this.sUM.gsq);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sTR.getLocalId(), this.sTR);
        AppMethodBeat.o(167794);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(167794);
    }
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.sTR.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167792);
    this.sUQ.alive();
    this.sTR.trackPost("upload");
    Object localObject1 = this.sTR.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 3;
    }
    this.startTime = ch.aDc();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKi().value()).intValue() > 0) && ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.b.cKi().value()).longValue() * 1000L);
    }
    localObject1 = this.sTR.getMediaList();
    if (localObject1 != null)
    {
      try
      {
        this.sUM.HiZ = 0;
        Object localObject2 = this.sTR;
        localObject3 = this.sUM;
        p.g(localObject3, "postinfo");
        ((FinderItem)localObject2).setPostInfo((bwa)localObject3);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sTR.getLocalId(), this.sTR);
        if ((sUS) && (ae.getLogLevel() <= 1))
        {
          ae.i(TAG, "debugDeleteFileWhenUpload");
          localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
          o.dd(com.tencent.mm.plugin.finder.utils.r.cOy(), true);
        }
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bvz)((Iterator)localObject1).next();
            if (!bu.isNullOrNil(((bvz)localObject2).url))
            {
              localObject3 = ((bvz)localObject2).mediaId;
              ae.i(TAG, "uploading media " + (String)localObject3 + ", " + ((bvz)localObject2).url + " size:" + bu.sL(o.aZR(((bvz)localObject2).url)) + " thumb: " + ((bvz)localObject2).thumbUrl + " size:" + bu.sL(o.aZR(((bvz)localObject2).thumbUrl)));
              p.g(localObject2, "media");
              if (!o.fB(((bvz)localObject2).url))
              {
                ae.i(TAG, "mediaObject.url " + ((bvz)localObject2).url + " is not file");
                i = 0;
                if (i != 0) {
                  continue;
                }
                mk(false);
                Gd(1);
                d(com.tencent.mm.loader.g.j.hiz);
                AppMethodBeat.o(167792);
                return;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        label499:
        Map localMap;
        label1186:
        do
        {
          Object localObject3;
          int i;
          for (;;)
          {
            ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          }
          if ((!bu.isNullOrNil(localException.HiT)) && (!bu.isNullOrNil(localException.HiU))) {
            ae.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).fLl = "task_FinderUploadTask_1";
            ((com.tencent.mm.i.g)localObject3).fLm = ((g.a)this.sUR);
            Object localObject4 = aj.ej(localException.url);
            p.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = ajN((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.url;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.thumbUrl;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            ae.i(TAG, "upload file length " + o.aZR(localException.url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.sTR.getLocalId());
            switch (localException.mediaType)
            {
            case 3: 
            case 5: 
            case 6: 
            default: 
              ae.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(localException.mediaType) });
              break;
            case 2: 
            case 7: 
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).fLq = 60;
              ((com.tencent.mm.i.g)localObject3).fLr = 300;
            case 4: 
              do
              {
                ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fKA;
                this.sUO.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
                localObject4 = this.sUN;
                str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
                p.g(str, "info.field_mediaId");
                ((Map)localObject4).put(str, Float.valueOf(0.0F));
                f.aGZ().f((com.tencent.mm.i.g)localObject3);
                if ((localException.mediaType != 4) || (bu.isNullOrNil(localException.coverUrl))) {
                  break label499;
                }
                if (o.fB(localException.coverUrl)) {
                  break label1186;
                }
                ae.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
                i = 0;
                break;
                SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
                ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
                ((com.tencent.mm.i.g)localObject3).field_appType = 251;
                ((com.tencent.mm.i.g)localObject3).fLD = 8;
                ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
                ((com.tencent.mm.i.g)localObject3).fLq = 60;
                ((com.tencent.mm.i.g)localObject3).fLr = 600;
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
                i = com.tencent.mm.plugin.finder.storage.b.cHb();
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
                if (i > com.tencent.mm.plugin.finder.storage.b.cHc())
                {
                  long l = o.aZR(((com.tencent.mm.i.g)localObject3).field_fullpath);
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
                  if (l > com.tencent.mm.plugin.finder.storage.b.cHc())
                  {
                    localObject4 = j((com.tencent.mm.i.g)localObject3);
                    str = TAG;
                    localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable1, mediaInfo null?");
                    if (localObject4 == null) {}
                    for (bool = true;; bool = false)
                    {
                      ae.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                      a(0, localException);
                      localObject4 = com.tencent.mm.plugin.finder.utils.c.sWg;
                      localObject4 = com.tencent.mm.plugin.finder.utils.c.sWg;
                      com.tencent.mm.plugin.finder.utils.c.a(com.tencent.mm.plugin.finder.utils.c.cNE());
                      break;
                    }
                  }
                }
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
              } while (com.tencent.mm.plugin.finder.storage.b.cJQ() != 1);
              localObject4 = j((com.tencent.mm.i.g)localObject3);
              String str = TAG;
              StringBuilder localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
              if (localObject4 == null) {}
              for (boolean bool = true;; bool = false)
              {
                ae.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                a(1, localException);
                localObject4 = com.tencent.mm.plugin.finder.utils.c.sWg;
                localObject4 = com.tencent.mm.plugin.finder.utils.c.sWg;
                com.tencent.mm.plugin.finder.utils.c.a(com.tencent.mm.plugin.finder.utils.c.cNE());
                break;
              }
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).fLl = "task_FinderUploadTask_2";
              ((com.tencent.mm.i.g)localObject3).fLm = ((g.a)this.sUR);
              localObject4 = aj.ej(localException.coverUrl);
              p.g(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((com.tencent.mm.i.g)localObject3).field_mediaId = ajN((String)localObject4);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
              ae.i(TAG, "upload cover file length " + o.aZR(localException.coverUrl));
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).fLq = 60;
              ((com.tencent.mm.i.g)localObject3).fLr = 300;
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fKA;
              this.sUO.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
              localMap = this.sUN;
              localObject4 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
              p.g(localObject4, "info.field_mediaId");
              localMap.put(localObject4, Float.valueOf(0.0F));
              f.aGZ().f((com.tencent.mm.i.g)localObject3);
            }
          }
        } while ((localMap.mediaType != 2) && (localMap.mediaType != 7) && (localMap.mediaType != 4));
        ae.i(TAG, "uploadFinderContent media.url invalid, url:" + localMap.url + ", type:" + localMap.mediaType);
        mk(false);
        Gd(2);
        d(com.tencent.mm.loader.g.j.hiz);
        AppMethodBeat.o(167792);
        return;
      }
      if (this.sUO.size() == 0)
      {
        mk(true);
        d(com.tencent.mm.loader.g.j.hiy);
        AppMethodBeat.o(167792);
        return;
      }
      localObject1 = o.c.sAI;
      o.c.cFO();
      AppMethodBeat.o(167792);
      return;
    }
    AppMethodBeat.o(167792);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167791);
      Object localObject1 = k.sUT;
      String str = k.access$getTAG$cp();
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
      ae.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
      if (k.a(this.sUU))
      {
        AppMethodBeat.o(167791);
        return 0;
      }
      k.a(this.sUU, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = k.sUT;
        ae.e(k.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramc = this.sUU.sTR.getMediaList();
          if (paramc != null)
          {
            paramd = ((Iterable)paramc).iterator();
            do
            {
              if (!paramd.hasNext()) {
                break;
              }
              paramc = paramd.next();
            } while (!p.i(((bvz)paramc).mediaId, k.ajO(paramString)));
          }
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (bvz)paramString;
          if (paramString != null) {
            k.a(this.sUU, paramInt, paramString);
          }
          k.a(this.sUU, false);
          k.a(this.sUU, com.tencent.mm.loader.g.j.hiz);
          AppMethodBeat.o(167791);
          return 0;
        }
      }
      if ((!bu.isNullOrNil(paramString)) && (paramd != null))
      {
        paramc = k.sUT;
        ae.i(k.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          paramc = this.sUU.sTR.getMediaList();
          if (paramc != null)
          {
            localObject1 = ((Iterable)paramc).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramc = ((Iterator)localObject1).next();
            } while (!p.i(((bvz)paramc).mediaId, k.ajO(paramString)));
          }
          for (paramString = paramc;; paramString = null)
          {
            paramString = (bvz)paramString;
            if (paramString != null) {
              k.a(this.sUU, paramd.field_retCode, paramString);
            }
            k.a(this.sUU, false);
            k.a(this.sUU, com.tencent.mm.loader.g.j.hiz);
            AppMethodBeat.o(167791);
            return 0;
          }
        }
        k.c(this.sUU).remove(paramString);
        localObject1 = this.sUU.sTR.getMediaList();
        paramInt = k.c(this.sUU).size();
        paramc = k.sUT;
        ae.i(k.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.sUU.sTR.getLocalId(), new Object[] { Long.valueOf(this.sUU.sTR.getLocalId()), Integer.valueOf(paramInt) });
        if (localObject1 == null) {
          break label839;
        }
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            paramc = ((Iterator)localObject2).next();
            if (p.i(((bvz)paramc).mediaId, k.ajO(paramString)))
            {
              paramc = (bvz)paramc;
              label574:
              if (paramc != null)
              {
                paramc.mediaId = aj.ej(paramc.url);
                paramc.HiT = paramd.field_fileUrl;
                paramc.HiU = paramd.field_thumbUrl;
                paramc.md5sum = paramd.field_filemd5;
                this.sUU.sTR.setMediaList((LinkedList)localObject1);
                k.a(this.sUU, 0, paramc);
                ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sUU.sTR.getLocalId(), this.sUU.sTR);
              }
              if (paramc == null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  paramc = ((Iterator)localObject1).next();
                } while (!p.i(aj.ej(((bvz)paramc).coverUrl), k.ajO(paramString)));
              }
            }
          }
        }
      }
      for (paramString = paramc;; paramString = null)
      {
        paramString = (bvz)paramString;
        if (paramString != null)
        {
          paramc = k.sUT;
          ae.i(k.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
          paramString.HiX = paramd.field_fileUrl;
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sUU.sTR.getLocalId(), this.sUU.sTR);
        if (paramInt == 0)
        {
          k.a(this.sUU, true);
          k.a(this.sUU, com.tencent.mm.loader.g.j.hiy);
        }
        AppMethodBeat.o(167791);
        return 0;
        paramc = null;
        break;
        label839:
        paramc = null;
        break label574;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hc>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(k.c paramc, hc paramhc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.k
 * JD-Core Version:    0.7.0.1
 */