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
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final a kNb = new a((byte)0);
  private com.tencent.mm.loader.e.b.g<?> kMA;
  public final com.tencent.mm.loader.c.e kMB;
  public final com.tencent.mm.loader.f.e<T, R> kMC;
  public final com.tencent.mm.loader.f.d kMD;
  public com.tencent.mm.loader.f.f kME;
  public com.tencent.mm.loader.f.c<T> kMF;
  public com.tencent.mm.loader.d.b<T> kMG;
  public com.tencent.mm.loader.b.b.e<T, R> kMH;
  public com.tencent.mm.loader.b.a.d<T, R> kMI;
  private com.tencent.mm.loader.d.c kMJ;
  private com.tencent.mm.loader.f.b kMK;
  public com.tencent.mm.loader.d.e kML;
  public com.tencent.mm.loader.d.d<R> kMM;
  public com.tencent.mm.loader.e.c.a<R> kMN;
  public com.tencent.mm.loader.e.c.a<R> kMO;
  public com.tencent.mm.loader.f.a kMP;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> kMQ;
  private com.tencent.mm.loader.d.a<T> kMR;
  public com.tencent.mm.loader.f.g kMS;
  public int kMT;
  private Animation kMU;
  public Drawable kMV;
  public com.tencent.mm.loader.h.a.a<T> kMW;
  public com.tencent.mm.loader.e.b.d<R> kMX;
  public String kMY;
  public boolean kMZ;
  private final com.tencent.mm.loader.e.g<T, R> kMz;
  public final com.tencent.mm.loader.a.b<T, R> kNa;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.kNa = paramb;
    this.kMz = new com.tencent.mm.loader.e.g();
    Object localObject = this.kNa.kMB;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRL();
    }
    this.kMB = paramb;
    localObject = this.kNa.kMC;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.e)this.kMz;
    }
    this.kMC = paramb;
    this.kMD = this.kNa.kMD;
    localObject = this.kNa.kME;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRM();
    }
    this.kME = paramb;
    this.kMF = this.kNa.kMF;
    localObject = this.kNa.kMG;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRH();
    }
    this.kMG = paramb;
    localObject = this.kNa.kMH;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRF();
    }
    this.kMH = paramb;
    localObject = this.kNa.kMI;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRG();
    }
    this.kMI = paramb;
    localObject = this.kNa.kMJ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRN();
    }
    this.kMJ = paramb;
    localObject = this.kNa.kMK;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRO();
    }
    this.kMK = paramb;
    localObject = this.kNa.kML;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRP();
    }
    this.kML = paramb;
    localObject = this.kNa.kMM;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRI();
    }
    this.kMM = paramb;
    localObject = this.kNa.kMN;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRK();
    }
    this.kMN = paramb;
    this.kMO = this.kNa.kMO;
    this.kMP = this.kNa.kMP;
    localObject = this.kNa.kMQ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRR();
    }
    this.kMQ = paramb;
    this.kMR = paramd.aRQ();
    localObject = this.kNa.kMS;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aRJ();
    }
    this.kMS = paramb;
    this.kMT = this.kMB.kMT;
    this.kMU = this.kMB.kMU;
    paramb = this.kMB;
    paramd = MMApplicationContext.getResources();
    p.j(paramd, "MMApplicationContext.getResources()");
    p.k(paramd, "resources");
    if (paramb.kOj != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.kOj));
    }
    for (;;)
    {
      this.kMV = paramb;
      this.kMW = this.kNa.kNh;
      this.kMY = "";
      return;
      if (paramb.kMT != 0) {
        paramb = paramd.getDrawable(paramb.kMT);
      } else {
        paramb = paramb.kMV;
      }
    }
  }
  
  private final void aRv()
  {
    try
    {
      if (this.kMQ == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.kQt;
        this.kMQ = com.tencent.mm.loader.g.a.e.aSi();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> aRt()
  {
    com.tencent.mm.loader.e.b.d locald = this.kMX;
    if (locald == null) {
      p.bGy("target");
    }
    return locald;
  }
  
  public final void aRu()
  {
    Object localObject2 = this.kNa.kMX;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.kMX = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.kPe;
    localObject1 = e.a.aRX();
    localObject2 = this.kMX;
    if (localObject2 == null) {
      p.bGy("target");
    }
    if (localObject2 == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.kMW;
    p.k(localObject2, "target");
    p.k(localObject3, "data");
    int i = ((com.tencent.mm.loader.e.b.d)localObject2).aRV();
    Log.i(com.tencent.mm.loader.e.b.e.TAG, "register code " + i + " data " + localObject3);
    ((com.tencent.mm.loader.e.b.e)localObject1).cDe.put(Integer.valueOf(i), new o(localObject3, localObject2));
    localObject1 = this.kMW;
    if (this.kMW.isLegal())
    {
      if ((this.kMW.aSr() instanceof String))
      {
        localObject2 = this.kMW.aSr();
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
        break label305;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        Log.w(TAG, "uri value is isLegal " + this.kMW);
        localObject1 = com.tencent.mm.loader.e.b.e.kPe;
        localObject1 = e.a.aRX();
        localObject2 = this.kMX;
        if (localObject2 == null) {
          p.bGy("target");
        }
        if (localObject2 == null)
        {
          throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
          i = 0;
          break;
          label305:
          localObject1 = null;
          continue;
        }
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.kMW, "uri value is isLegal");
        this.kMC.a(this.kMW, this.kMA, null);
        localObject1 = this.kMD;
        if (localObject1 != null) {
          ((com.tencent.mm.loader.f.d)localObject1).a(this.kMA);
        }
        return;
      }
    }
    localObject2 = new aa.f();
    label396:
    final boolean bool;
    if (this.kMB.kOc)
    {
      localObject1 = this.kMH.a(this.kMW, this.kMN);
      ((aa.f)localObject2).aaBC = localObject1;
      bool = ((Boolean)((kotlin.g.a.a)new c(this, (aa.f)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((aa.f)localObject2).aaBC;
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
          Log.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.kMW + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.kMN;
          if (localObject3 != null)
          {
            locald = this.kMX;
            if (locald == null) {
              p.bGy("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.kOY, this, (com.tencent.mm.loader.h.e)localObject2, b.b.kPv);
          }
          localObject2 = this.kMD;
          if (localObject2 != null) {
            ((com.tencent.mm.loader.f.d)localObject2).a(this.kMA);
          }
          localObject2 = this.kMX;
          if (localObject2 == null) {
            p.bGy("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.kMF != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.kQJ;
            i = com.tencent.mm.loader.h.c.aSl();
            localObject2 = com.tencent.mm.loader.h.c.kQJ;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.aSo(), localObject1);
          }
          localObject2 = this.kMC;
          localObject3 = this.kMW;
          com.tencent.mm.loader.e.b.d locald = this.kMX;
          if (locald == null) {
            p.bGy("target");
          }
          ((com.tencent.mm.loader.f.e)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.kOY, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.kMW;
      localObject2 = this.kMX;
      if (localObject2 == null) {
        p.bGy("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.kOn;
      if (com.tencent.mm.loader.c.e.access$getDEBUG$cp())
      {
        localObject2 = Util.getStack().toString();
        p.j(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).kMY = ((String)localObject2);
        this.kMY = ((String)localObject2);
      }
      Log.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.kMW });
      localObject2 = this.kMX;
      if (localObject2 == null) {
        p.bGy("target");
      }
      localObject3 = this.kMX;
      if (localObject3 == null) {
        p.bGy("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).kOY, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      aRv();
      localObject1 = this.kMQ;
      if (localObject1 == null) {
        break;
      }
      localObject2 = (com.tencent.mm.loader.g.c)localObject2;
      p.k(localObject2, "t");
      ((com.tencent.mm.loader.g.d)localObject1).a((com.tencent.mm.loader.g.c)localObject2, null, true);
      return;
      localObject1 = null;
      break label396;
      label876:
      localObject1 = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/Reaper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void fy(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.kPe;
        localObject = e.a.aRX();
        com.tencent.mm.loader.e.b.d locald = this.kNc.aRt();
        if (locald == null) {
          throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.kNc.kMW, "may be hit cache");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "R", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(f paramf, aa.f paramf1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */