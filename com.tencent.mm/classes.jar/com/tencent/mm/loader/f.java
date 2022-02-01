package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.g.b.v.e;
import d.o;
import d.v;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final a giu = new a((byte)0);
  private final com.tencent.mm.loader.e.f<T, R> ghU;
  private g<?> ghV;
  public final com.tencent.mm.loader.c.e ghW;
  public final com.tencent.mm.loader.f.d<T, R> ghX;
  private com.tencent.mm.loader.f.e ghY;
  public com.tencent.mm.loader.f.c<T> ghZ;
  public com.tencent.mm.loader.d.b<T> gia;
  public com.tencent.mm.loader.b.b.e<T, R> gib;
  public com.tencent.mm.loader.b.a.d<T, R> gic;
  private com.tencent.mm.loader.d.c gid;
  private com.tencent.mm.loader.f.b gie;
  public com.tencent.mm.loader.d.e gif;
  public com.tencent.mm.loader.d.d<R> gig;
  public com.tencent.mm.loader.e.c.a<R> gih;
  public com.tencent.mm.loader.e.c.a<R> gii;
  public com.tencent.mm.loader.f.a gij;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gik;
  private com.tencent.mm.loader.d.a<T> gil;
  public com.tencent.mm.loader.f.f gim;
  public int gin;
  private Animation gio;
  public Drawable gip;
  public com.tencent.mm.loader.h.a.a<T> giq;
  public com.tencent.mm.loader.e.b.d<R> gir;
  public String gis;
  private final com.tencent.mm.loader.a.b<T, R> git;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.git = paramb;
    this.ghU = new com.tencent.mm.loader.e.f();
    Object localObject = this.git.ghW;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahi();
    }
    this.ghW = paramb;
    localObject = this.git.ghX;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.d)this.ghU;
    }
    this.ghX = paramb;
    localObject = this.git.ghY;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahj();
    }
    this.ghY = paramb;
    this.ghZ = this.git.ghZ;
    localObject = this.git.gia;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahe();
    }
    this.gia = paramb;
    localObject = this.git.gib;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahc();
    }
    this.gib = paramb;
    localObject = this.git.gic;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahd();
    }
    this.gic = paramb;
    localObject = this.git.gid;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahk();
    }
    this.gid = paramb;
    localObject = this.git.gie;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahl();
    }
    this.gie = paramb;
    localObject = this.git.gif;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahm();
    }
    this.gif = paramb;
    localObject = this.git.gig;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahf();
    }
    this.gig = paramb;
    localObject = this.git.gih;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahh();
    }
    this.gih = paramb;
    this.gii = this.git.gii;
    this.gij = this.git.gij;
    localObject = this.git.gik;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aho();
    }
    this.gik = paramb;
    this.gil = paramd.ahn();
    localObject = this.git.gim;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ahg();
    }
    this.gim = paramb;
    this.gin = this.ghW.gin;
    this.gio = this.ghW.gio;
    paramb = this.ghW;
    paramd = aj.getResources();
    k.g(paramd, "MMApplicationContext.getResources()");
    k.h(paramd, "resources");
    if (paramb.KBD != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.KBD));
    }
    for (;;)
    {
      this.gip = paramb;
      this.giq = this.git.giy;
      this.gis = "";
      return;
      if (paramb.gin != 0) {
        paramb = paramd.getDrawable(paramb.gin);
      } else {
        paramb = paramb.gip;
      }
    }
  }
  
  private final void agU()
  {
    try
    {
      if (this.gik == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.glr;
        this.gik = com.tencent.mm.loader.g.a.e.ahE();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> agT()
  {
    com.tencent.mm.loader.e.b.d locald = this.gir;
    if (locald == null) {
      k.aPZ("target");
    }
    return locald;
  }
  
  public final void tP()
  {
    this.giq = this.git.giy;
    Object localObject2 = this.git.gir;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.gir = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.gkl;
    localObject1 = e.a.ahv();
    localObject2 = this.gir;
    if (localObject2 == null) {
      k.aPZ("target");
    }
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.giq;
    k.h(localObject2, "target");
    k.h(localObject3, "data");
    ad.i(com.tencent.mm.loader.e.b.e.TAG, "register " + localObject2 + " and code " + ((com.tencent.mm.loader.e.b.d)localObject2).aht() + " data " + localObject3 + " try get: " + ((com.tencent.mm.loader.e.b.d)localObject2).gkf.get());
    ((com.tencent.mm.loader.e.b.e)localObject1).cit.put(Integer.valueOf(((com.tencent.mm.loader.e.b.d)localObject2).aht()), new o(localObject3, localObject2));
    localObject1 = this.giq;
    int i;
    if (this.giq.isLegal())
    {
      if ((this.giq.value() instanceof String))
      {
        localObject2 = this.giq.value();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type kotlin.String");
        }
        if (!bt.isNullOrNil((String)localObject2)) {}
      }
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label346;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ad.w(TAG, "uri value is isLegal " + this.giq);
        localObject1 = com.tencent.mm.loader.e.b.e.gkl;
        localObject1 = e.a.ahv();
        localObject2 = this.gir;
        if (localObject2 == null) {
          k.aPZ("target");
        }
        if (localObject2 == null)
        {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
          i = 0;
          break;
          label346:
          localObject1 = null;
          continue;
        }
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.giq, "uri value is isLegal");
        this.ghX.a(this.giq, this.ghV, null);
        return;
      }
    }
    localObject2 = new v.e();
    label418:
    final boolean bool;
    if (this.ghW.gjr)
    {
      localObject1 = this.gib.a(this.giq, this.gih);
      ((v.e)localObject2).Jhw = localObject1;
      bool = ((Boolean)((d.g.a.a)new c(this, (v.e)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((v.e)localObject2).Jhw;
      if (localObject1 != null) {
        if (!((com.tencent.mm.loader.h.e)localObject1).isValid()) {
          break label876;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.loader.h.e)localObject1).getValue();
        if (localObject1 != null)
        {
          ad.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.giq + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.gih;
          if (localObject3 != null)
          {
            locald = this.gir;
            if (locald == null) {
              k.aPZ("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.gkf, this, (com.tencent.mm.loader.h.e)localObject2, b.b.gkC);
          }
          localObject2 = this.gir;
          if (localObject2 == null) {
            k.aPZ("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.ghZ != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.glH;
            i = com.tencent.mm.loader.h.c.ahH();
            localObject2 = com.tencent.mm.loader.h.c.glH;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.ahK(), localObject1);
          }
          localObject2 = this.ghX;
          localObject3 = this.giq;
          com.tencent.mm.loader.e.b.d locald = this.gir;
          if (locald == null) {
            k.aPZ("target");
          }
          ((com.tencent.mm.loader.f.d)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.gkf, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.giq;
      localObject2 = this.gir;
      if (localObject2 == null) {
        k.aPZ("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.gjC;
      if (com.tencent.mm.loader.c.e.ahp())
      {
        localObject2 = bt.eGN().toString();
        k.g(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).gis = ((String)localObject2);
        this.gis = ((String)localObject2);
      }
      ad.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.giq });
      localObject2 = this.gir;
      if (localObject2 == null) {
        k.aPZ("target");
      }
      localObject3 = this.gir;
      if (localObject3 == null) {
        k.aPZ("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).gkf, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      agU();
      localObject1 = this.gik;
      if (localObject1 == null) {
        break;
      }
      localObject2 = (com.tencent.mm.loader.g.c)localObject2;
      k.h(localObject2, "t");
      ((com.tencent.mm.loader.g.d)localObject1).a((com.tencent.mm.loader.g.c)localObject2, null, true);
      return;
      localObject1 = null;
      break label418;
      label876:
      localObject1 = null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/Reaper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void dB(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.gkl;
        localObject = e.a.ahv();
        com.tencent.mm.loader.e.b.d locald = this.giv.agT();
        if (locald == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.giv.giq, "may be hit cache");
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    c(f paramf, v.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */