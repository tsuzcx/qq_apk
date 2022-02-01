package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.n.b;
import com.tencent.mm.plugin.finder.report.n.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "", "getItemProgress", "()Ljava/util/Map;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "call", "", "checkReportObj", "updateMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadLocalMedia", "mediaObject", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.LogPost.FinderUploadTask";
  private static boolean sJF;
  public static final a sJG;
  FinderItem sIF;
  private final Map<String, Float> sJA;
  private final ConcurrentLinkedQueue<String> sJB;
  private boolean sJC;
  private final c sJD;
  private final b sJE;
  private boolean sJy;
  private final bvg sJz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(167797);
    sJG = new a((byte)0);
    TAG = "Finder.LogPost.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.sIF = paramFinderItem;
    this.sJz = this.sIF.field_postinfo;
    this.sJA = ((Map)new LinkedHashMap());
    this.sJB = new ConcurrentLinkedQueue();
    this.sJD = new c(this);
    this.sJE = new b(this);
    AppMethodBeat.o(167796);
  }
  
  private final void FF(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = this.sIF.field_reportObject;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.uploadLogicError = paramInt;
    }
  }
  
  private final void a(int paramInt, bvf parambvf)
  {
    AppMethodBeat.i(204348);
    c(parambvf);
    parambvf.GPw.isBigFile = 1;
    parambvf.GPw.cdnControl = paramInt;
    AppMethodBeat.o(204348);
  }
  
  private static String aiQ(String paramString)
  {
    AppMethodBeat.i(204347);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(204347);
    return paramString;
  }
  
  private final void c(bvf parambvf)
  {
    AppMethodBeat.i(204349);
    Object localObject = parambvf.GPw;
    if (localObject != null)
    {
      ((FinderMediaReportObject)localObject).mediaType = parambvf.mediaType;
      ((FinderMediaReportObject)localObject).mediaId = parambvf.mediaId;
      ((FinderMediaReportObject)localObject).cdnUploadTime = ((int)(cf.aCM() - this.startTime));
      AppMethodBeat.o(204349);
      return;
    }
    localObject = (k)this;
    parambvf.GPw = new FinderMediaReportObject();
    parambvf.GPw.mediaType = parambvf.mediaType;
    parambvf.GPw.mediaId = parambvf.mediaId;
    parambvf.GPw.cdnUploadTime = ((int)(cf.aCM() - ((k)localObject).startTime));
    parambvf.GPw.target = new FinderMediaReportInfo();
    parambvf.GPw.target.width = ((int)parambvf.width);
    parambvf.GPw.target.height = ((int)parambvf.height);
    parambvf.GPw.target.fileSize = ((int)com.tencent.mm.vfs.i.aYo(parambvf.url));
    parambvf.GPw.target.videoDuration = parambvf.videoDuration;
    parambvf.GPw.target.videoBitrate = parambvf.bitrate;
    parambvf.GPw.videoFinalSize = parambvf.GPw.target.fileSize;
    AppMethodBeat.o(204349);
  }
  
  private final void d(j paramj)
  {
    AppMethodBeat.i(167793);
    this.sJD.dead();
    if (this.sJy)
    {
      ad.i(TAG, "invoke_CallbackFun isMarkFail " + this.sJy);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramj);
    AppMethodBeat.o(167793);
  }
  
  private static com.tencent.mm.plugin.sight.base.a j(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(204350);
    paramg.snsVersion = 1;
    com.tencent.mm.plugin.sight.base.a locala = e.axx(paramg.field_fullpath);
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
      ad.i(TAG, "customHeader ".concat(String.valueOf(str)));
      paramg.customHeader = str;
      AppMethodBeat.o(204350);
      return locala;
    }
  }
  
  private final void mf(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
    if (!paramBoolean) {}
    try
    {
      this.sJy = false;
      if (!paramBoolean) {}
      for (this.sJz.GPx = 2;; this.sJz.GPx = 1)
      {
        this.sJz.gpV = (cf.aCK() - this.startTime);
        Object localObject = this.sIF;
        bvg localbvg = this.sJz;
        p.g(localbvg, "postinfo");
        ((FinderItem)localObject).setPostInfo(localbvg);
        localObject = n.b.sqe;
        n.b.wE(this.sJz.gpV);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sIF.getLocalId(), this.sIF);
        AppMethodBeat.o(167794);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(167794);
    }
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.sIF.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167792);
    this.sJD.alive();
    this.sIF.trackPost("upload");
    Object localObject1 = this.sIF.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 3;
    }
    this.startTime = cf.aCM();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cIl().value()).intValue() > 0) && ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      Thread.sleep(((Number)com.tencent.mm.plugin.finder.storage.b.cIl().value()).longValue() * 1000L);
    }
    localObject1 = this.sIF.getMediaList();
    if (localObject1 != null)
    {
      try
      {
        this.sJz.GPx = 0;
        Object localObject2 = this.sIF;
        localObject3 = this.sJz;
        p.g(localObject3, "postinfo");
        ((FinderItem)localObject2).setPostInfo((bvg)localObject3);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sIF.getLocalId(), this.sIF);
        if ((sJF) && (ad.getLogLevel() <= 1))
        {
          ad.i(TAG, "debugDeleteFileWhenUpload");
          localObject2 = com.tencent.mm.plugin.finder.utils.r.sNc;
          com.tencent.mm.vfs.i.cZ(com.tencent.mm.plugin.finder.utils.r.cLQ(), true);
        }
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bvf)((Iterator)localObject1).next();
            if (!bt.isNullOrNil(((bvf)localObject2).url))
            {
              localObject3 = ((bvf)localObject2).mediaId;
              ad.i(TAG, "uploading media " + (String)localObject3 + ", " + ((bvf)localObject2).url + " size:" + bt.sy(com.tencent.mm.vfs.i.aYo(((bvf)localObject2).url)) + " thumb: " + ((bvf)localObject2).thumbUrl + " size:" + bt.sy(com.tencent.mm.vfs.i.aYo(((bvf)localObject2).thumbUrl)));
              p.g(localObject2, "media");
              if (!com.tencent.mm.vfs.i.fv(((bvf)localObject2).url))
              {
                ad.i(TAG, "mediaObject.url " + ((bvf)localObject2).url + " is not file");
                i = 0;
                if (i != 0) {
                  continue;
                }
                mf(false);
                FF(1);
                d(j.hfL);
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
            ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          }
          if ((!bt.isNullOrNil(localException.GPr)) && (!bt.isNullOrNil(localException.GPs))) {
            ad.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).fJi = "task_FinderUploadTask_1";
            ((com.tencent.mm.i.g)localObject3).fJj = ((g.a)this.sJE);
            Object localObject4 = ai.ee(localException.url);
            p.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = aiQ((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.url;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.thumbUrl;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            ad.i(TAG, "upload file length " + com.tencent.mm.vfs.i.aYo(localException.url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.sIF.getLocalId());
            switch (localException.mediaType)
            {
            case 3: 
            case 5: 
            case 6: 
            default: 
              ad.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(localException.mediaType) });
              break;
            case 2: 
            case 7: 
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).fJn = 60;
              ((com.tencent.mm.i.g)localObject3).fJo = 300;
            case 4: 
              do
              {
                ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fIw;
                this.sJB.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
                localObject4 = this.sJA;
                str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
                p.g(str, "info.field_mediaId");
                ((Map)localObject4).put(str, Float.valueOf(0.0F));
                f.aGI().f((com.tencent.mm.i.g)localObject3);
                if ((localException.mediaType != 4) || (bt.isNullOrNil(localException.coverUrl))) {
                  break label499;
                }
                if (com.tencent.mm.vfs.i.fv(localException.coverUrl)) {
                  break label1186;
                }
                ad.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
                i = 0;
                break;
                SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
                ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
                ((com.tencent.mm.i.g)localObject3).field_appType = 251;
                ((com.tencent.mm.i.g)localObject3).fJA = 8;
                ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
                ((com.tencent.mm.i.g)localObject3).fJn = 60;
                ((com.tencent.mm.i.g)localObject3).fJo = 600;
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
                i = com.tencent.mm.plugin.finder.storage.b.cFe();
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
                if (i > com.tencent.mm.plugin.finder.storage.b.cFf())
                {
                  long l = com.tencent.mm.vfs.i.aYo(((com.tencent.mm.i.g)localObject3).field_fullpath);
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
                  if (l > com.tencent.mm.plugin.finder.storage.b.cFf())
                  {
                    localObject4 = j((com.tencent.mm.i.g)localObject3);
                    str = TAG;
                    localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable1, mediaInfo null?");
                    if (localObject4 == null) {}
                    for (bool = true;; bool = false)
                    {
                      ad.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                      a(0, localException);
                      localObject4 = com.tencent.mm.plugin.finder.utils.c.sKU;
                      localObject4 = com.tencent.mm.plugin.finder.utils.c.sKU;
                      com.tencent.mm.plugin.finder.utils.c.a(com.tencent.mm.plugin.finder.utils.c.cLa());
                      break;
                    }
                  }
                }
                localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
              } while (com.tencent.mm.plugin.finder.storage.b.cHU() != 1);
              localObject4 = j((com.tencent.mm.i.g)localObject3);
              String str = TAG;
              StringBuilder localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable2, mediaInfo null?");
              if (localObject4 == null) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                a(1, localException);
                localObject4 = com.tencent.mm.plugin.finder.utils.c.sKU;
                localObject4 = com.tencent.mm.plugin.finder.utils.c.sKU;
                com.tencent.mm.plugin.finder.utils.c.a(com.tencent.mm.plugin.finder.utils.c.cLa());
                break;
              }
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).fJi = "task_FinderUploadTask_2";
              ((com.tencent.mm.i.g)localObject3).fJj = ((g.a)this.sJE);
              localObject4 = ai.ee(localException.coverUrl);
              p.g(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((com.tencent.mm.i.g)localObject3).field_mediaId = aiQ((String)localObject4);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
              ad.i(TAG, "upload cover file length " + com.tencent.mm.vfs.i.aYo(localException.coverUrl));
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).fJn = 60;
              ((com.tencent.mm.i.g)localObject3).fJo = 300;
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fIw;
              this.sJB.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
              localMap = this.sJA;
              localObject4 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
              p.g(localObject4, "info.field_mediaId");
              localMap.put(localObject4, Float.valueOf(0.0F));
              f.aGI().f((com.tencent.mm.i.g)localObject3);
            }
          }
        } while ((localMap.mediaType != 2) && (localMap.mediaType != 7) && (localMap.mediaType != 4));
        ad.i(TAG, "uploadFinderContent media.url invalid, url:" + localMap.url + ", type:" + localMap.mediaType);
        mf(false);
        FF(2);
        d(j.hfL);
        AppMethodBeat.o(167792);
        return;
      }
      if (this.sJB.size() == 0)
      {
        mf(true);
        d(j.hfK);
        AppMethodBeat.o(167792);
        return;
      }
      localObject1 = n.c.sqy;
      n.c.cDS();
      AppMethodBeat.o(167792);
      return;
    }
    AppMethodBeat.o(167792);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167791);
      Object localObject1 = k.sJG;
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
      ad.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
      if (k.a(this.sJH))
      {
        AppMethodBeat.o(167791);
        return 0;
      }
      k.a(this.sJH, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = k.sJG;
        ad.e(k.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramc = this.sJH.sIF.getMediaList();
          if (paramc != null)
          {
            paramd = ((Iterable)paramc).iterator();
            do
            {
              if (!paramd.hasNext()) {
                break;
              }
              paramc = paramd.next();
            } while (!p.i(((bvf)paramc).mediaId, k.aiR(paramString)));
          }
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (bvf)paramString;
          if (paramString != null) {
            k.a(this.sJH, paramInt, paramString);
          }
          k.a(this.sJH, false);
          k.a(this.sJH, j.hfL);
          AppMethodBeat.o(167791);
          return 0;
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        paramc = k.sJG;
        ad.i(k.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          paramc = this.sJH.sIF.getMediaList();
          if (paramc != null)
          {
            localObject1 = ((Iterable)paramc).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramc = ((Iterator)localObject1).next();
            } while (!p.i(((bvf)paramc).mediaId, k.aiR(paramString)));
          }
          for (paramString = paramc;; paramString = null)
          {
            paramString = (bvf)paramString;
            if (paramString != null) {
              k.a(this.sJH, paramd.field_retCode, paramString);
            }
            k.a(this.sJH, false);
            k.a(this.sJH, j.hfL);
            AppMethodBeat.o(167791);
            return 0;
          }
        }
        k.c(this.sJH).remove(paramString);
        localObject1 = this.sJH.sIF.getMediaList();
        paramInt = k.c(this.sJH).size();
        paramc = k.sJG;
        ad.i(k.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.sJH.sIF.getLocalId(), new Object[] { Long.valueOf(this.sJH.sIF.getLocalId()), Integer.valueOf(paramInt) });
        if (localObject1 == null) {
          break label839;
        }
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            paramc = ((Iterator)localObject2).next();
            if (p.i(((bvf)paramc).mediaId, k.aiR(paramString)))
            {
              paramc = (bvf)paramc;
              label574:
              if (paramc != null)
              {
                paramc.mediaId = ai.ee(paramc.url);
                paramc.GPr = paramd.field_fileUrl;
                paramc.GPs = paramd.field_thumbUrl;
                paramc.md5sum = paramd.field_filemd5;
                this.sJH.sIF.setMediaList((LinkedList)localObject1);
                k.a(this.sJH, 0, paramc);
                ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sJH.sIF.getLocalId(), this.sJH.sIF);
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
                } while (!p.i(ai.ee(((bvf)paramc).coverUrl), k.aiR(paramString)));
              }
            }
          }
        }
      }
      for (paramString = paramc;; paramString = null)
      {
        paramString = (bvf)paramString;
        if (paramString != null)
        {
          paramc = k.sJG;
          ad.i(k.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
          paramString.GPv = paramd.field_fileUrl;
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().b(this.sJH.sIF.getLocalId(), this.sJH.sIF);
        if (paramInt == 0)
        {
          k.a(this.sJH, true);
          k.a(this.sJH, j.hfK);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hb>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(k.c paramc, hb paramhb)
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