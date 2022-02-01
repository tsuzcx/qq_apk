package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.g.b.v.f;
import d.o;
import d.v;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a gJd = new f.a((byte)0);
  private final com.tencent.mm.loader.e.f<T, R> gID;
  private g<?> gIE;
  public final com.tencent.mm.loader.c.e gIF;
  public final com.tencent.mm.loader.f.d<T, R> gIG;
  private com.tencent.mm.loader.f.e gIH;
  public com.tencent.mm.loader.f.c<T> gII;
  public com.tencent.mm.loader.d.b<T> gIJ;
  public com.tencent.mm.loader.b.b.e<T, R> gIK;
  public com.tencent.mm.loader.b.a.d<T, R> gIL;
  private com.tencent.mm.loader.d.c gIM;
  private com.tencent.mm.loader.f.b gIN;
  public com.tencent.mm.loader.d.e gIO;
  public com.tencent.mm.loader.d.d<R> gIP;
  public com.tencent.mm.loader.e.c.a<R> gIQ;
  public com.tencent.mm.loader.e.c.a<R> gIR;
  public com.tencent.mm.loader.f.a gIS;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gIT;
  private com.tencent.mm.loader.d.a<T> gIU;
  public com.tencent.mm.loader.f.f gIV;
  public int gIW;
  private Animation gIX;
  public Drawable gIY;
  public com.tencent.mm.loader.h.a.a<T> gIZ;
  public com.tencent.mm.loader.e.b.d<R> gJa;
  public String gJb;
  private final com.tencent.mm.loader.a.b<T, R> gJc;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.gJc = paramb;
    this.gID = new com.tencent.mm.loader.e.f();
    Object localObject = this.gJc.gIF;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aok();
    }
    this.gIF = paramb;
    localObject = this.gJc.gIG;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.d)this.gID;
    }
    this.gIG = paramb;
    localObject = this.gJc.gIH;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aol();
    }
    this.gIH = paramb;
    this.gII = this.gJc.gII;
    localObject = this.gJc.gIJ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aog();
    }
    this.gIJ = paramb;
    localObject = this.gJc.gIK;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoe();
    }
    this.gIK = paramb;
    localObject = this.gJc.gIL;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aof();
    }
    this.gIL = paramb;
    localObject = this.gJc.gIM;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aom();
    }
    this.gIM = paramb;
    localObject = this.gJc.gIN;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aon();
    }
    this.gIN = paramb;
    localObject = this.gJc.gIO;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoo();
    }
    this.gIO = paramb;
    localObject = this.gJc.gIP;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoh();
    }
    this.gIP = paramb;
    localObject = this.gJc.gIQ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoj();
    }
    this.gIQ = paramb;
    this.gIR = this.gJc.gIR;
    this.gIS = this.gJc.gIS;
    localObject = this.gJc.gIT;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoq();
    }
    this.gIT = paramb;
    this.gIU = paramd.aop();
    localObject = this.gJc.gIV;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aoi();
    }
    this.gIV = paramb;
    this.gIW = this.gIF.gIW;
    this.gIX = this.gIF.gIX;
    paramb = this.gIF;
    paramd = ai.getResources();
    k.g(paramd, "MMApplicationContext.getResources()");
    k.h(paramd, "resources");
    if (paramb.gKk != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.gKk));
    }
    for (;;)
    {
      this.gIY = paramb;
      this.gIZ = this.gJc.gJj;
      this.gJb = "";
      return;
      if (paramb.gIW != 0) {
        paramb = paramd.getDrawable(paramb.gIW);
      } else {
        paramb = paramb.gIY;
      }
    }
  }
  
  private final void anV()
  {
    try
    {
      if (this.gIT == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.gMe;
        this.gIT = com.tencent.mm.loader.g.a.e.aoG();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> anU()
  {
    com.tencent.mm.loader.e.b.d locald = this.gJa;
    if (locald == null) {
      k.aVY("target");
    }
    return locald;
  }
  
  public final void tX()
  {
    this.gIZ = this.gJc.gJj;
    Object localObject2 = this.gJc.gJa;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.gJa = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.gKY;
    localObject1 = e.a.aox();
    localObject2 = this.gJa;
    if (localObject2 == null) {
      k.aVY("target");
    }
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.gIZ;
    k.h(localObject2, "target");
    k.h(localObject3, "data");
    ac.i(com.tencent.mm.loader.e.b.e.TAG, "register " + localObject2 + " and code " + ((com.tencent.mm.loader.e.b.d)localObject2).aov() + " data " + localObject3 + " try get: " + ((com.tencent.mm.loader.e.b.d)localObject2).gKS.get());
    ((com.tencent.mm.loader.e.b.e)localObject1).cfp.put(Integer.valueOf(((com.tencent.mm.loader.e.b.d)localObject2).aov()), new o(localObject3, localObject2));
    localObject1 = this.gIZ;
    int i;
    if (this.gIZ.isLegal())
    {
      if ((this.gIZ.value() instanceof String))
      {
        localObject2 = this.gIZ.value();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type kotlin.String");
        }
        if (!bs.isNullOrNil((String)localObject2)) {}
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
        ac.w(TAG, "uri value is isLegal " + this.gIZ);
        localObject1 = com.tencent.mm.loader.e.b.e.gKY;
        localObject1 = e.a.aox();
        localObject2 = this.gJa;
        if (localObject2 == null) {
          k.aVY("target");
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
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.gIZ, "uri value is isLegal");
        this.gIG.a(this.gIZ, this.gIE, null);
        return;
      }
    }
    localObject2 = new v.f();
    label418:
    final boolean bool;
    if (this.gIF.gKc)
    {
      localObject1 = this.gIK.a(this.gIZ, this.gIQ);
      ((v.f)localObject2).KUQ = localObject1;
      bool = ((Boolean)((d.g.a.a)new c(this, (v.f)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((v.f)localObject2).KUQ;
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
          ac.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.gIZ + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.gIQ;
          if (localObject3 != null)
          {
            locald = this.gJa;
            if (locald == null) {
              k.aVY("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.gKS, this, (com.tencent.mm.loader.h.e)localObject2, b.b.gLp);
          }
          localObject2 = this.gJa;
          if (localObject2 == null) {
            k.aVY("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.gII != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.gMu;
            i = com.tencent.mm.loader.h.c.aoJ();
            localObject2 = com.tencent.mm.loader.h.c.gMu;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.aoM(), localObject1);
          }
          localObject2 = this.gIG;
          localObject3 = this.gIZ;
          com.tencent.mm.loader.e.b.d locald = this.gJa;
          if (locald == null) {
            k.aVY("target");
          }
          ((com.tencent.mm.loader.f.d)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.gKS, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.gIZ;
      localObject2 = this.gJa;
      if (localObject2 == null) {
        k.aVY("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.gKo;
      if (com.tencent.mm.loader.c.e.aor())
      {
        localObject2 = bs.eWi().toString();
        k.g(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).gJb = ((String)localObject2);
        this.gJb = ((String)localObject2);
      }
      ac.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.gIZ });
      localObject2 = this.gJa;
      if (localObject2 == null) {
        k.aVY("target");
      }
      localObject3 = this.gJa;
      if (localObject3 == null) {
        k.aVY("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).gKS, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      anV();
      localObject1 = this.gIT;
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void dW(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.gKY;
        localObject = e.a.aox();
        com.tencent.mm.loader.e.b.d locald = this.gJe.anU();
        if (locald == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.gJe.gIZ, "may be hit cache");
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    c(f paramf, v.f paramf1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */