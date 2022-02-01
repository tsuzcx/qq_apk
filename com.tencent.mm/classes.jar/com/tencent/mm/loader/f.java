package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a hYx = new f.a((byte)0);
  private final com.tencent.mm.loader.e.g<T, R> hXV;
  private com.tencent.mm.loader.e.b.g<?> hXW;
  public final com.tencent.mm.loader.c.e hXX;
  public final com.tencent.mm.loader.f.e<T, R> hXY;
  public final com.tencent.mm.loader.f.d hXZ;
  private com.tencent.mm.loader.f.f hYa;
  public com.tencent.mm.loader.f.c<T> hYb;
  public com.tencent.mm.loader.d.b<T> hYc;
  public com.tencent.mm.loader.b.b.e<T, R> hYd;
  public com.tencent.mm.loader.b.a.d<T, R> hYe;
  private com.tencent.mm.loader.d.c hYf;
  private com.tencent.mm.loader.f.b hYg;
  public com.tencent.mm.loader.d.e hYh;
  public com.tencent.mm.loader.d.d<R> hYi;
  public com.tencent.mm.loader.e.c.a<R> hYj;
  public com.tencent.mm.loader.e.c.a<R> hYk;
  public com.tencent.mm.loader.f.a hYl;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hYm;
  private com.tencent.mm.loader.d.a<T> hYn;
  public com.tencent.mm.loader.f.g hYo;
  public int hYp;
  private Animation hYq;
  public Drawable hYr;
  public com.tencent.mm.loader.h.a.a<T> hYs;
  public com.tencent.mm.loader.e.b.d<R> hYt;
  public String hYu;
  public boolean hYv;
  public final com.tencent.mm.loader.a.b<T, R> hYw;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.hYw = paramb;
    this.hXV = new com.tencent.mm.loader.e.g();
    Object localObject = this.hYw.hXX;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJL();
    }
    this.hXX = paramb;
    localObject = this.hYw.hXY;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.e)this.hXV;
    }
    this.hXY = paramb;
    this.hXZ = this.hYw.hXZ;
    localObject = this.hYw.hYa;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJM();
    }
    this.hYa = paramb;
    this.hYb = this.hYw.hYb;
    localObject = this.hYw.hYc;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJH();
    }
    this.hYc = paramb;
    localObject = this.hYw.hYd;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJF();
    }
    this.hYd = paramb;
    localObject = this.hYw.hYe;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJG();
    }
    this.hYe = paramb;
    localObject = this.hYw.hYf;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJN();
    }
    this.hYf = paramb;
    localObject = this.hYw.hYg;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJO();
    }
    this.hYg = paramb;
    localObject = this.hYw.hYh;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJP();
    }
    this.hYh = paramb;
    localObject = this.hYw.hYi;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJI();
    }
    this.hYi = paramb;
    localObject = this.hYw.hYj;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJK();
    }
    this.hYj = paramb;
    this.hYk = this.hYw.hYk;
    this.hYl = this.hYw.hYl;
    localObject = this.hYw.hYm;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJR();
    }
    this.hYm = paramb;
    this.hYn = paramd.aJQ();
    localObject = this.hYw.hYo;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aJJ();
    }
    this.hYo = paramb;
    this.hYp = this.hXX.hYp;
    this.hYq = this.hXX.hYq;
    paramb = this.hXX;
    paramd = MMApplicationContext.getResources();
    p.g(paramd, "MMApplicationContext.getResources()");
    p.h(paramd, "resources");
    if (paramb.hZD != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.hZD));
    }
    for (;;)
    {
      this.hYr = paramb;
      this.hYs = this.hYw.hYD;
      this.hYu = "";
      return;
      if (paramb.hYp != 0) {
        paramb = paramd.getDrawable(paramb.hYp);
      } else {
        paramb = paramb.hYr;
      }
    }
  }
  
  private final void a(com.tencent.mm.loader.k.b<?, ?> paramb)
  {
    aJv();
    com.tencent.mm.loader.g.d locald = this.hYm;
    if (locald != null) {
      locald.b((com.tencent.mm.loader.g.c)paramb);
    }
  }
  
  private final void aJv()
  {
    try
    {
      if (this.hYm == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.ibM;
        this.hYm = com.tencent.mm.loader.g.a.e.aKh();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> aJt()
  {
    com.tencent.mm.loader.e.b.d locald = this.hYt;
    if (locald == null) {
      p.btv("target");
    }
    return locald;
  }
  
  public final void aJu()
  {
    Object localObject2 = this.hYw.hYt;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.hYt = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.iay;
    localObject1 = e.a.aJX();
    localObject2 = this.hYt;
    if (localObject2 == null) {
      p.btv("target");
    }
    if (localObject2 == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.hYs);
    localObject1 = this.hYs;
    int i;
    if (this.hYs.isLegal())
    {
      if ((this.hYs.value() instanceof String))
      {
        localObject2 = this.hYs.value();
        if (localObject2 == null) {
          throw new t("null cannot be cast to non-null type kotlin.String");
        }
        if (!Util.isNullOrNil((String)localObject2)) {}
      }
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label230;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        Log.w(TAG, "uri value is isLegal " + this.hYs);
        localObject1 = com.tencent.mm.loader.e.b.e.iay;
        localObject1 = e.a.aJX();
        localObject2 = this.hYt;
        if (localObject2 == null) {
          p.btv("target");
        }
        if (localObject2 == null)
        {
          throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
          i = 0;
          break;
          label230:
          localObject1 = null;
          continue;
        }
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.hYs, "uri value is isLegal");
        this.hXY.a(this.hYs, this.hXW, null);
        localObject1 = this.hXZ;
        if (localObject1 != null) {
          ((com.tencent.mm.loader.f.d)localObject1).a(this.hXW);
        }
        return;
      }
    }
    localObject2 = new z.f();
    label321:
    final boolean bool;
    if (this.hXX.hZw)
    {
      localObject1 = this.hYd.a(this.hYs, this.hYj);
      ((z.f)localObject2).SYG = localObject1;
      bool = ((Boolean)((kotlin.g.a.a)new f.c(this, (z.f)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((z.f)localObject2).SYG;
      if (localObject1 != null) {
        if (!((com.tencent.mm.loader.h.e)localObject1).isValid()) {
          break label767;
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
          Log.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.hYs + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.hYj;
          if (localObject3 != null)
          {
            locald = this.hYt;
            if (locald == null) {
              p.btv("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.ias, this, (com.tencent.mm.loader.h.e)localObject2, b.b.iaP);
          }
          localObject2 = this.hXZ;
          if (localObject2 != null) {
            ((com.tencent.mm.loader.f.d)localObject2).a(this.hXW);
          }
          localObject2 = this.hYt;
          if (localObject2 == null) {
            p.btv("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.hYb != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.icc;
            i = com.tencent.mm.loader.h.c.aKk();
            localObject2 = com.tencent.mm.loader.h.c.icc;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.aKn(), localObject1);
          }
          localObject2 = this.hXY;
          localObject3 = this.hYs;
          com.tencent.mm.loader.e.b.d locald = this.hYt;
          if (locald == null) {
            p.btv("target");
          }
          ((com.tencent.mm.loader.f.e)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.ias, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.hYs;
      localObject2 = this.hYt;
      if (localObject2 == null) {
        p.btv("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.hZH;
      if (com.tencent.mm.loader.c.e.access$getDEBUG$cp())
      {
        localObject2 = Util.getStack().toString();
        p.g(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).hYu = ((String)localObject2);
        this.hYu = ((String)localObject2);
      }
      Log.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.hYs });
      localObject2 = this.hYt;
      if (localObject2 == null) {
        p.btv("target");
      }
      Object localObject3 = this.hYt;
      if (localObject3 == null) {
        p.btv("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).ias, this);
      a((com.tencent.mm.loader.k.b)localObject1);
      return;
      localObject1 = null;
      break label321;
      label767:
      localObject1 = null;
    }
  }
  
  public final void vC()
  {
    this.hYs = this.hYw.hYD;
    aJu();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void eR(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.iay;
        localObject = e.a.aJX();
        com.tencent.mm.loader.e.b.d locald = this.hYy.aJt();
        if (locald == null) {
          throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.hYy.hYs, "may be hit cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */