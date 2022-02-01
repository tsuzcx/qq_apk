package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isMarkFail", "", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "", "getItemProgress", "()Ljava/util/Map;", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "uniqueId", "updatePostInfo", "isOk", "updatePostReportMediaInfo", "retCode", "", "updateMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadLocalMedia", "mediaObject", "Companion", "plugin-finder_release"})
public final class j
  extends c
{
  private static final String TAG = "Finder.FinderUploadTask";
  private static boolean rNB;
  public static final a rNC;
  FinderItem rMD;
  private final j.b rNA;
  private boolean rNw;
  private final bqt rNx;
  private final Map<String, Float> rNy;
  private final ConcurrentLinkedQueue<String> rNz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(167797);
    rNC = new a((byte)0);
    TAG = "Finder.FinderUploadTask";
    AppMethodBeat.o(167797);
  }
  
  public j(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167796);
    this.rMD = paramFinderItem;
    this.rNx = this.rMD.field_postinfo;
    this.rNy = ((Map)new LinkedHashMap());
    this.rNz = new ConcurrentLinkedQueue();
    this.rNA = new j.b(this);
    AppMethodBeat.o(167796);
  }
  
  private static String aew(String paramString)
  {
    AppMethodBeat.i(203511);
    paramString = "upload_".concat(String.valueOf(paramString));
    AppMethodBeat.o(203511);
    return paramString;
  }
  
  private final void d(h paramh)
  {
    AppMethodBeat.i(167793);
    if (this.rNw)
    {
      ac.i(TAG, "invoke_CallbackFun isMarkFail " + this.rNw);
      AppMethodBeat.o(167793);
      return;
    }
    a(paramh);
    AppMethodBeat.o(167793);
  }
  
  private final void lP(boolean paramBoolean)
  {
    AppMethodBeat.i(167794);
    if (!paramBoolean) {}
    try
    {
      this.rNw = false;
      if (!paramBoolean) {}
      for (this.rNx.FfT = 2;; this.rNx.FfT = 1)
      {
        this.rNx.fWs = (ce.azH() - this.startTime);
        Object localObject = this.rMD;
        bqt localbqt = this.rNx;
        k.g(localbqt, "postinfo");
        ((FinderItem)localObject).setPostInfo(localbqt);
        localObject = i.b.ryD;
        i.b.uD(this.rNx.fWs);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.rMD.getLocalId(), this.rMD);
        AppMethodBeat.o(167794);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(167794);
    }
  }
  
  public final String acg()
  {
    AppMethodBeat.i(167795);
    String str = "upload_" + this.rMD.getLocalId();
    AppMethodBeat.o(167795);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167792);
    this.rMD.trackPost("upload");
    this.startTime = ce.azJ();
    Object localObject1 = this.rMD.getMediaList();
    if (localObject1 != null)
    {
      try
      {
        this.rNx.FfT = 0;
        Object localObject2 = this.rMD;
        localObject3 = this.rNx;
        k.g(localObject3, "postinfo");
        ((FinderItem)localObject2).setPostInfo((bqt)localObject3);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().a(this.rMD.getLocalId(), this.rMD);
        if ((rNB) && (ac.getLogLevel() <= 1))
        {
          ac.i(TAG, "debugDeleteFileWhenUpload");
          localObject2 = p.rQw;
          i.cU(p.cDw(), true);
        }
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bqs)((Iterator)localObject1).next();
            if (!bs.isNullOrNil(((bqs)localObject2).url))
            {
              localObject3 = ((bqs)localObject2).mediaId;
              ac.i(TAG, "uploading media " + (String)localObject3 + ", " + ((bqs)localObject2).url + " size:" + bs.qz(i.aSp(((bqs)localObject2).url)) + " thumb: " + ((bqs)localObject2).thumbUrl + " size:" + bs.qz(i.aSp(((bqs)localObject2).thumbUrl)));
              k.g(localObject2, "media");
              if (!i.eA(((bqs)localObject2).url))
              {
                ac.i(TAG, "mediaObject.url " + ((bqs)localObject2).url + " is not file");
                i = 0;
                if (i != 0) {
                  continue;
                }
                lP(false);
                d(h.gLO);
                AppMethodBeat.o(167792);
                return;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        label404:
        label926:
        Map localMap;
        label1048:
        label1054:
        do
        {
          Object localObject3;
          int i;
          for (;;)
          {
            ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
          }
          if ((!bs.isNullOrNil(localException.FfN)) && (!bs.isNullOrNil(localException.FfO))) {
            ac.i(TAG, "mediaObject svr_url and svr_thumbUrl exist");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject3 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject3).frb = ((g.a)this.rNA);
            Object localObject4 = ah.dg(localException.url);
            k.g(localObject4, "MD5Util.getMD5String(mediaObject.url)");
            ((com.tencent.mm.i.g)localObject3).field_mediaId = aew((String)localObject4);
            ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.url;
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.thumbUrl;
            ((com.tencent.mm.i.g)localObject3).field_talker = "";
            ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
            ac.i(TAG, "upload file length " + i.aSp(localException.url) + " mediaId: " + ((com.tencent.mm.i.g)localObject3).field_mediaId + " localId:" + this.rMD.getLocalId());
            switch (localException.mediaType)
            {
            case 3: 
            case 5: 
            case 6: 
            default: 
              ac.e(TAG, "unknown media type %d, quit upload", new Object[] { Integer.valueOf(localException.mediaType) });
              break;
            case 2: 
            case 7: 
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).frf = 60;
              ((com.tencent.mm.i.g)localObject3).frg = 300;
            case 4: 
              String str;
              long l;
              do
              {
                do
                {
                  ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fqp;
                  this.rNz.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
                  localObject4 = this.rNy;
                  str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
                  k.g(str, "info.field_mediaId");
                  ((Map)localObject4).put(str, Float.valueOf(0.0F));
                  com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject3);
                  if ((localException.mediaType != 4) || (bs.isNullOrNil(localException.coverUrl))) {
                    break label404;
                  }
                  if (i.eA(localException.coverUrl)) {
                    break label1054;
                  }
                  ac.w(TAG, "upload failed, coverUrl not exist, " + localException.coverUrl);
                  i = 0;
                  break;
                  SightVideoJNI.optimizeMP4VFS(((com.tencent.mm.i.g)localObject3).field_fullpath);
                  ((com.tencent.mm.i.g)localObject3).field_fileType = 20302;
                  ((com.tencent.mm.i.g)localObject3).field_appType = 251;
                  ((com.tencent.mm.i.g)localObject3).frr = 8;
                  ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
                  ((com.tencent.mm.i.g)localObject3).frf = 60;
                  ((com.tencent.mm.i.g)localObject3).frg = 600;
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.rCU;
                  i = com.tencent.mm.plugin.finder.storage.b.cyc();
                  localObject4 = com.tencent.mm.plugin.finder.storage.b.rCU;
                } while (i <= com.tencent.mm.plugin.finder.storage.b.cyd());
                l = i.aSp(((com.tencent.mm.i.g)localObject3).field_fullpath);
                localObject4 = com.tencent.mm.plugin.finder.storage.b.rCU;
              } while (l <= com.tencent.mm.plugin.finder.storage.b.cyd());
              ((com.tencent.mm.i.g)localObject3).snsVersion = 1;
              localObject4 = e.asx(((com.tencent.mm.i.g)localObject3).field_fullpath);
              StringBuilder localStringBuilder;
              if (localObject4 != null)
              {
                int j = ((com.tencent.mm.plugin.sight.base.a)localObject4).videoBitrate;
                if (r.isH265Video(((com.tencent.mm.i.g)localObject3).field_fullpath))
                {
                  i = 174;
                  str = "videobitrate:" + j + "\r\nvideoformat:" + i + "\r\n";
                  ac.i(TAG, "customHeader ".concat(String.valueOf(str)));
                  ((com.tencent.mm.i.g)localObject3).customHeader = str;
                }
              }
              else
              {
                str = TAG;
                localStringBuilder = new StringBuilder("MultiBitrate_Video_Enable, mediaInfo null?");
                if (localObject4 != null) {
                  break label1048;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                ac.i(str, bool + ", path:" + ((com.tencent.mm.i.g)localObject3).field_fullpath);
                break;
                i = 28;
                break label926;
              }
              localObject3 = new com.tencent.mm.i.g();
              ((com.tencent.mm.i.g)localObject3).frb = ((g.a)this.rNA);
              localObject4 = ah.dg(localException.coverUrl);
              k.g(localObject4, "MD5Util.getMD5String(mediaObject.coverUrl)");
              ((com.tencent.mm.i.g)localObject3).field_mediaId = aew((String)localObject4);
              ((com.tencent.mm.i.g)localObject3).field_fullpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_thumbpath = localException.coverUrl;
              ((com.tencent.mm.i.g)localObject3).field_talker = "";
              ((com.tencent.mm.i.g)localObject3).field_needStorage = true;
              ac.i(TAG, "upload cover file length " + i.aSp(localException.coverUrl));
              ((com.tencent.mm.i.g)localObject3).field_fileType = 20304;
              ((com.tencent.mm.i.g)localObject3).field_appType = 251;
              ((com.tencent.mm.i.g)localObject3).field_bzScene = 2;
              ((com.tencent.mm.i.g)localObject3).frf = 60;
              ((com.tencent.mm.i.g)localObject3).frg = 300;
              ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fqp;
              this.rNz.add(((com.tencent.mm.i.g)localObject3).field_mediaId);
              localMap = this.rNy;
              localObject4 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
              k.g(localObject4, "info.field_mediaId");
              localMap.put(localObject4, Float.valueOf(0.0F));
              com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject3);
            }
          }
        } while ((localMap.mediaType != 2) && (localMap.mediaType != 7) && (localMap.mediaType != 4));
        ac.i(TAG, "uploadFinderContent media.url invalid, url:" + localMap.url + ", type:" + localMap.mediaType);
        lP(false);
        d(h.gLO);
        AppMethodBeat.o(167792);
        return;
      }
      if (this.rNz.size() == 0)
      {
        lP(true);
        d(h.gLN);
        AppMethodBeat.o(167792);
        return;
      }
      localObject1 = i.c.ryP;
      i.c.cxj();
      AppMethodBeat.o(167792);
      return;
    }
    AppMethodBeat.o(167792);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.j
 * JD-Core Version:    0.7.0.1
 */