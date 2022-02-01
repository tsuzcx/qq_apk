package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.o;
import d.v;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a hcO = new f.a((byte)0);
  public com.tencent.mm.loader.d.d<R> hcA;
  public com.tencent.mm.loader.e.c.a<R> hcB;
  public com.tencent.mm.loader.e.c.a<R> hcC;
  public com.tencent.mm.loader.f.a hcD;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hcE;
  private com.tencent.mm.loader.d.a<T> hcF;
  public com.tencent.mm.loader.f.g hcG;
  public int hcH;
  private Animation hcI;
  public Drawable hcJ;
  public com.tencent.mm.loader.h.a.a<T> hcK;
  public com.tencent.mm.loader.e.b.d<R> hcL;
  public String hcM;
  private final com.tencent.mm.loader.a.b<T, R> hcN;
  private final com.tencent.mm.loader.e.g<T, R> hcn;
  private com.tencent.mm.loader.e.b.g<?> hco;
  public final com.tencent.mm.loader.c.e hcp;
  public final com.tencent.mm.loader.f.e<T, R> hcq;
  public final com.tencent.mm.loader.f.d hcr;
  private com.tencent.mm.loader.f.f hcs;
  public com.tencent.mm.loader.f.c<T> hct;
  public com.tencent.mm.loader.d.b<T> hcu;
  public com.tencent.mm.loader.b.b.e<T, R> hcv;
  public com.tencent.mm.loader.b.a.d<T, R> hcw;
  private com.tencent.mm.loader.d.c hcx;
  private com.tencent.mm.loader.f.b hcy;
  public com.tencent.mm.loader.d.e hcz;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.hcN = paramb;
    this.hcn = new com.tencent.mm.loader.e.g();
    Object localObject = this.hcN.hcp;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqX();
    }
    this.hcp = paramb;
    localObject = this.hcN.hcq;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.e)this.hcn;
    }
    this.hcq = paramb;
    this.hcr = this.hcN.hcr;
    localObject = this.hcN.hcs;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqY();
    }
    this.hcs = paramb;
    this.hct = this.hcN.hct;
    localObject = this.hcN.hcu;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqT();
    }
    this.hcu = paramb;
    localObject = this.hcN.hcv;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqR();
    }
    this.hcv = paramb;
    localObject = this.hcN.hcw;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqS();
    }
    this.hcw = paramb;
    localObject = this.hcN.hcx;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqZ();
    }
    this.hcx = paramb;
    localObject = this.hcN.hcy;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ara();
    }
    this.hcy = paramb;
    localObject = this.hcN.hcz;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arb();
    }
    this.hcz = paramb;
    localObject = this.hcN.hcA;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqU();
    }
    this.hcA = paramb;
    localObject = this.hcN.hcB;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqW();
    }
    this.hcB = paramb;
    this.hcC = this.hcN.hcC;
    this.hcD = this.hcN.hcD;
    localObject = this.hcN.hcE;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ard();
    }
    this.hcE = paramb;
    this.hcF = paramd.arc();
    localObject = this.hcN.hcG;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aqV();
    }
    this.hcG = paramb;
    this.hcH = this.hcp.hcH;
    this.hcI = this.hcp.hcI;
    paramb = this.hcp;
    paramd = aj.getResources();
    p.g(paramd, "MMApplicationContext.getResources()");
    p.h(paramd, "resources");
    if (paramb.hdV != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.hdV));
    }
    for (;;)
    {
      this.hcJ = paramb;
      this.hcK = this.hcN.hcU;
      this.hcM = "";
      return;
      if (paramb.hcH != 0) {
        paramb = paramd.getDrawable(paramb.hcH);
      } else {
        paramb = paramb.hcJ;
      }
    }
  }
  
  private final void aqH()
  {
    try
    {
      if (this.hcE == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.hgb;
        this.hcE = com.tencent.mm.loader.g.a.e.art();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> aqG()
  {
    com.tencent.mm.loader.e.b.d locald = this.hcL;
    if (locald == null) {
      p.bcb("target");
    }
    return locald;
  }
  
  public final void vw()
  {
    this.hcK = this.hcN.hcU;
    Object localObject2 = this.hcN.hcL;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.hcL = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.heN;
    localObject1 = e.a.arj();
    localObject2 = this.hcL;
    if (localObject2 == null) {
      p.bcb("target");
    }
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.hcK;
    p.h(localObject2, "target");
    p.h(localObject3, "data");
    ad.i(com.tencent.mm.loader.e.b.e.TAG, "register " + localObject2 + " and code " + ((com.tencent.mm.loader.e.b.d)localObject2).arh() + " data " + localObject3 + " try get: " + ((com.tencent.mm.loader.e.b.d)localObject2).heH.get());
    ((com.tencent.mm.loader.e.b.e)localObject1).cpF.put(Integer.valueOf(((com.tencent.mm.loader.e.b.d)localObject2).arh()), new o(localObject3, localObject2));
    localObject1 = this.hcK;
    int i;
    if (this.hcK.isLegal())
    {
      if ((this.hcK.value() instanceof String))
      {
        localObject2 = this.hcK.value();
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
        ad.w(TAG, "uri value is isLegal " + this.hcK);
        localObject1 = com.tencent.mm.loader.e.b.e.heN;
        localObject1 = e.a.arj();
        localObject2 = this.hcL;
        if (localObject2 == null) {
          p.bcb("target");
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
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.hcK, "uri value is isLegal");
        this.hcq.a(this.hcK, this.hco, null);
        localObject1 = this.hcr;
        if (localObject1 != null) {
          ((com.tencent.mm.loader.f.d)localObject1).b(this.hco);
        }
        return;
      }
    }
    localObject2 = new y.f();
    label437:
    final boolean bool;
    if (this.hcp.hdN)
    {
      localObject1 = this.hcv.a(this.hcK, this.hcB);
      ((y.f)localObject2).MLV = localObject1;
      bool = ((Boolean)((d.g.a.a)new c(this, (y.f)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((y.f)localObject2).MLV;
      if (localObject1 != null) {
        if (!((com.tencent.mm.loader.h.e)localObject1).isValid()) {
          break label917;
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
          ad.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.hcK + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.hcB;
          if (localObject3 != null)
          {
            locald = this.hcL;
            if (locald == null) {
              p.bcb("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.heH, this, (com.tencent.mm.loader.h.e)localObject2, b.b.hfe);
          }
          localObject2 = this.hcr;
          if (localObject2 != null) {
            ((com.tencent.mm.loader.f.d)localObject2).b(this.hco);
          }
          localObject2 = this.hcL;
          if (localObject2 == null) {
            p.bcb("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.hct != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.hgr;
            i = com.tencent.mm.loader.h.c.arw();
            localObject2 = com.tencent.mm.loader.h.c.hgr;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.arz(), localObject1);
          }
          localObject2 = this.hcq;
          localObject3 = this.hcK;
          com.tencent.mm.loader.e.b.d locald = this.hcL;
          if (locald == null) {
            p.bcb("target");
          }
          ((com.tencent.mm.loader.f.e)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.heH, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.hcK;
      localObject2 = this.hcL;
      if (localObject2 == null) {
        p.bcb("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.hdZ;
      if (com.tencent.mm.loader.c.e.access$getDEBUG$cp())
      {
        localObject2 = bt.flS().toString();
        p.g(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).hcM = ((String)localObject2);
        this.hcM = ((String)localObject2);
      }
      ad.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.hcK });
      localObject2 = this.hcL;
      if (localObject2 == null) {
        p.bcb("target");
      }
      localObject3 = this.hcL;
      if (localObject3 == null) {
        p.bcb("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).heH, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      aqH();
      localObject1 = this.hcE;
      if (localObject1 == null) {
        break;
      }
      localObject2 = (com.tencent.mm.loader.g.c)localObject2;
      p.h(localObject2, "t");
      ((com.tencent.mm.loader.g.d)localObject1).a((com.tencent.mm.loader.g.c)localObject2, null, true);
      return;
      localObject1 = null;
      break label437;
      label917:
      localObject1 = null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void dY(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.heN;
        localObject = e.a.arj();
        com.tencent.mm.loader.e.b.d locald = this.hcP.aqG();
        if (locald == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.hcP.hcK, "may be hit cache");
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "R", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Boolean>
  {
    c(f paramf, y.f paramf1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */