package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.e.b;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isMarkFail", "", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "", "getItemProgress", "()Ljava/util/Map;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "uniqueId", "updatePostInfo", "isOk", "updatePostReportMediaInfo", "retCode", "", "updateMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadLocalMedia", "mediaObject", "Companion", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.FinderUploadTask";
  private static boolean qRA;
  public static final a qRB;
  FinderItem qQF;
  private boolean qRv;
  private final bme qRw;
  private final Map<String, Float> qRx;
  private final ConcurrentLinkedQueue<String> qRy;
  private final b qRz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(167797);
    qRB = new a((byte)0);
    TAG = "Finder.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public j(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.qQF = paramFinderItem;
    this.qRw = this.qQF.field_postinfo;
    this.qRx = ((Map)new LinkedHashMap());
    this.qRy = new ConcurrentLinkedQueue();
    this.qRz = new b(this);
    AppMethodBeat.o(167796);
  }
  
  private static String aVG(String paramString)
  {
    AppMethodBeat.i(199535);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(199535);
    return paramString;
  }
  
  private final void d(h paramh)
  {
    AppMethodBeat.i(167793);
    if (this.qRv)
    {
      ad.i(TAG, "invoke_CallbackFun isMarkFail " + this.qRv);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramh);
    AppMethodBeat.o(167793);
  }
  
  private final void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
    if (!paramBoolean) {}
    try
    {
      this.qRv = false;
      if (!paramBoolean) {}
      for (this.qRw.DJF = 2;; this.qRw.DJF = 1)
      {
        this.qRw.fSx = (ce.asQ() - this.startTime);
        Object localObject = this.qQF;
        bme localbme = this.qRw;
        d.g.b.k.g(localbme, "postinfo");
        ((FinderItem)localObject).setPostInfo(localbme);
        localObject = e.b.qFJ;
        e.b.qs(this.qRw.fSx);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.qQF.getLocalId(), this.qQF);
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
  
  public final String abi()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.qQF.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167792);
    this.qQF.trackPost("upload");
    this.startTime = ce.asS();
    Object localObject1 = this.qQF.getMediaList();
    if (localObject1 != null)
    {
      try
      {
        this.qRw.DJF = 0;
        Object localObject2 = this.qQF;
        localObject3 = this.qRw;
        d.g.b.k.g(localObject3, "postinfo");
        ((FinderItem)localObject2).setPostInfo((bme)localObject3);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.qQF.getLocalId(), this.qQF);
        if ((qRA) && (ad.getLogLevel() <= 1))
        {
          ad.i(TAG, "debugDeleteFileWhenUpload");
          localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
          i.cO(com.tencent.mm.plugin.finder.utils.k.csd(), true);
        }
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bmd)((Iterator)localObject1).next();
            if (!bt.isNullOrNil(((bmd)localObject2).url))
            {
              localObject3 = ((bmd)localObject2).mediaId;
              ad.i(TAG, "uploading media " + (String)localObject3 + ", " + ((bmd)localObject2).url + " size:" + bt.mK(i.aMN(((bmd)localObject2).url)) + " thumb: " + ((bmd)localObject2).thumbUrl + " size:" + bt.mK(i.aMN(((bmd)localObject2).thumbUrl)));
              d.g.b.k.g(localObject2, "media");
              if (!i.eK(((bmd)localObject2).url))
              {
                ad.i(TAG, "mediaObject.url " + ((bmd)localObject2).url + " is not file");
                i = 0;
                if (i != 0) {
                  continue;
                }
                lh(false);
                d(h.glb);
                AppMethodBeat.o(167792);
                return;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        label403:
        label922:
        Map localMap;
        label1044:
        label1050:
        do
        {
          Object localObject3;
          int i;
          for (;;)
          {
            ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          }
          if ((!bt.isNullOrNil(localException.DJB)) && (!bt.isNullOrNil(localException.DJC))) {
            ad.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).fnH = ((g.a)this.qRz);
            Object localObject4 = ai.du(localException.url);
            d.g.b.k.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = aVG((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.url;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.thumbUrl;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            ad.i(TAG, "upload file length " + i.aMN(localException.url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.qQF.getLocalId());
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
              ((com.tencent.mm.i.g)localObject3).fnL = 60;
              ((com.tencent.mm.i.g)localObject3).fnM = 300;
            case 4: 
              String str;
              long l;
              do
              {
                do
                {
                  ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fmV;
                  this.qRy.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
                  localObject4 = this.qRx;
                  str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
                  d.g.b.k.g(str, "info.field_mediaId");
                  ((Map)localObject4).put(str, Float.valueOf(0.0F));
                  f.awL().e((com.tencent.mm.i.g)localObject3);
                  if ((localException.mediaType != 4) || (bt.isNullOrNil(localException.coverUrl))) {
                    break label403;
                  }
                  if (i.eK(localException.coverUrl)) {
                    break label1050;
                  }
                  ad.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
                  i = 0;
                  break;
                  SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
                  ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
                  ((com.tencent.mm.i.g)localObject3).field_appType = 251;
                  ((com.tencent.mm.i.g)localObject3).fnX = 8;
                  ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
                  ((com.tencent.mm.i.g)localObject3).fnL = 60;
                  ((com.tencent.mm.i.g)localObject3).fnM = 600;
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.qJA;
                  i = com.tencent.mm.plugin.finder.storage.b.coF();
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.qJA;
                } while (i <= com.tencent.mm.plugin.finder.storage.b.fUa());
                l = i.aMN(((com.tencent.mm.i.g)localObject3).field_fullpath);
                localObject4 = com.tencent.mm.plugin.finder.storage.b.qJA;
              } while (l <= com.tencent.mm.plugin.finder.storage.b.fUa());
              ((com.tencent.mm.i.g)localObject3).snsVersion = 1;
              localObject4 = com.tencent.mm.plugin.sight.base.e.ano(((com.tencent.mm.i.g)localObject3).field_fullpath);
              StringBuilder localStringBuilder;
              if (localObject4 != null)
              {
                int j = ((com.tencent.mm.plugin.sight.base.a)localObject4).videoBitrate;
                if (r.isH265Video(((com.tencent.mm.i.g)localObject3).field_fullpath))
                {
                  i = 174;
                  str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
                  ad.i(TAG, "customHeader ".concat(String.valueOf(str)));
                  ((com.tencent.mm.i.g)localObject3).customHeader = str;
                }
              }
              else
              {
                str = TAG;
                localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable, mediaInfo null?");
                if (localObject4 != null) {
                  break label1044;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                ad.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                break;
                i = 28;
                break label922;
              }
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).fnH = ((g.a)this.qRz);
              localObject4 = ai.du(localException.coverUrl);
              d.g.b.k.g(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((com.tencent.mm.i.g)localObject3).field_mediaId = aVG((String)localObject4);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
              ad.i(TAG, "upload cover file length " + i.aMN(localException.coverUrl));
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).fnL = 60;
              ((com.tencent.mm.i.g)localObject3).fnM = 300;
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fmV;
              this.qRy.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
              localMap = this.qRx;
              localObject4 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
              d.g.b.k.g(localObject4, "info.field_mediaId");
              localMap.put(localObject4, Float.valueOf(0.0F));
              f.awL().e((com.tencent.mm.i.g)localObject3);
            }
          }
        } while ((localMap.mediaType != 2) && (localMap.mediaType != 7) && (localMap.mediaType != 4));
        ad.i(TAG, "uploadFinderContent media.url invalid, url:" + localMap.url + ", type:" + localMap.mediaType);
        lh(false);
        d(h.glb);
        AppMethodBeat.o(167792);
        return;
      }
      if (this.qRy.size() == 0)
      {
        lh(true);
        d(h.gla);
        AppMethodBeat.o(167792);
        return;
      }
      localObject1 = e.c.qFV;
      e.c.cnN();
      AppMethodBeat.o(167792);
      return;
    }
    AppMethodBeat.o(167792);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167791);
      Object localObject1 = j.qRB;
      String str = j.access$getTAG$cp();
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
      j.a(this.qRC, paramString, paramc);
      if (paramInt != 0)
      {
        paramc = j.qRB;
        ad.e(j.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          paramc = this.qRC.qQF.getMediaList();
          if (paramc != null)
          {
            paramd = ((Iterable)paramc).iterator();
            do
            {
              if (!paramd.hasNext()) {
                break;
              }
              paramc = paramd.next();
            } while (!d.g.b.k.g(((bmd)paramc).mediaId, j.ZK(paramString)));
          }
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (bmd)paramString;
          if (paramString != null) {
            j.a(this.qRC, paramInt, paramString);
          }
          j.a(this.qRC, false);
          j.a(this.qRC, h.glb);
          AppMethodBeat.o(167791);
          return 0;
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        paramc = j.qRB;
        ad.i(j.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          paramc = this.qRC.qQF.getMediaList();
          if (paramc != null)
          {
            localObject1 = ((Iterable)paramc).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramc = ((Iterator)localObject1).next();
            } while (!d.g.b.k.g(((bmd)paramc).mediaId, j.ZK(paramString)));
          }
          for (paramString = paramc;; paramString = null)
          {
            paramString = (bmd)paramString;
            if (paramString != null) {
              j.a(this.qRC, paramd.field_retCode, paramString);
            }
            j.a(this.qRC, false);
            j.a(this.qRC, h.glb);
            AppMethodBeat.o(167791);
            return 0;
          }
        }
        j.a(this.qRC).remove(paramString);
        localObject1 = this.qRC.qQF.getMediaList();
        paramInt = j.a(this.qRC).size();
        paramc = j.qRB;
        ad.i(j.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.qRC.qQF.getLocalId(), new Object[] { Long.valueOf(this.qRC.qQF.getLocalId()), Integer.valueOf(paramInt) });
        if (localObject1 == null) {
          break label822;
        }
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            paramc = ((Iterator)localObject2).next();
            if (d.g.b.k.g(((bmd)paramc).mediaId, j.ZK(paramString)))
            {
              paramc = (bmd)paramc;
              label557:
              if (paramc != null)
              {
                paramc.mediaId = ai.du(paramc.url);
                paramc.DJB = paramd.field_fileUrl;
                paramc.DJC = paramd.field_thumbUrl;
                paramc.md5sum = paramd.field_filemd5;
                this.qRC.qQF.setMediaList((LinkedList)localObject1);
                j.a(this.qRC, 0, paramc);
                ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.qRC.qQF.getLocalId(), this.qRC.qQF);
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
                } while (!d.g.b.k.g(ai.du(((bmd)paramc).coverUrl), j.ZK(paramString)));
              }
            }
          }
        }
      }
      for (paramString = paramc;; paramString = null)
      {
        paramString = (bmd)paramString;
        if (paramString != null)
        {
          paramc = j.qRB;
          ad.i(j.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
          paramString.LzM = paramd.field_fileUrl;
        }
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.qRC.qQF.getLocalId(), this.qRC.qQF);
        if (paramInt == 0)
        {
          j.a(this.qRC, true);
          j.a(this.qRC, h.gla);
        }
        AppMethodBeat.o(167791);
        return 0;
        paramc = null;
        break;
        label822:
        paramc = null;
        break label557;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.j
 * JD-Core Version:    0.7.0.1
 */