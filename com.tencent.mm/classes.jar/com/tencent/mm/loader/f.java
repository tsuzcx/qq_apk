package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.o;
import d.v;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a hfC = new f.a((byte)0);
  public String hfA;
  private final com.tencent.mm.loader.a.b<T, R> hfB;
  private final com.tencent.mm.loader.e.g<T, R> hfb;
  private com.tencent.mm.loader.e.b.g<?> hfc;
  public final com.tencent.mm.loader.c.e hfd;
  public final com.tencent.mm.loader.f.e<T, R> hfe;
  public final com.tencent.mm.loader.f.d hff;
  private com.tencent.mm.loader.f.f hfg;
  public com.tencent.mm.loader.f.c<T> hfh;
  public com.tencent.mm.loader.d.b<T> hfi;
  public com.tencent.mm.loader.b.b.e<T, R> hfj;
  public com.tencent.mm.loader.b.a.d<T, R> hfk;
  private com.tencent.mm.loader.d.c hfl;
  private com.tencent.mm.loader.f.b hfm;
  public com.tencent.mm.loader.d.e hfn;
  public com.tencent.mm.loader.d.d<R> hfo;
  public com.tencent.mm.loader.e.c.a<R> hfp;
  public com.tencent.mm.loader.e.c.a<R> hfq;
  public com.tencent.mm.loader.f.a hfr;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hfs;
  private com.tencent.mm.loader.d.a<T> hft;
  public com.tencent.mm.loader.f.g hfu;
  public int hfv;
  private Animation hfw;
  public Drawable hfx;
  public com.tencent.mm.loader.h.a.a<T> hfy;
  public com.tencent.mm.loader.e.b.d<R> hfz;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.hfB = paramb;
    this.hfb = new com.tencent.mm.loader.e.g();
    Object localObject = this.hfB.hfd;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arm();
    }
    this.hfd = paramb;
    localObject = this.hfB.hfe;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.e)this.hfb;
    }
    this.hfe = paramb;
    this.hff = this.hfB.hff;
    localObject = this.hfB.hfg;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arn();
    }
    this.hfg = paramb;
    this.hfh = this.hfB.hfh;
    localObject = this.hfB.hfi;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ari();
    }
    this.hfi = paramb;
    localObject = this.hfB.hfj;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arg();
    }
    this.hfj = paramb;
    localObject = this.hfB.hfk;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arh();
    }
    this.hfk = paramb;
    localObject = this.hfB.hfl;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.aro();
    }
    this.hfl = paramb;
    localObject = this.hfB.hfm;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arp();
    }
    this.hfm = paramb;
    localObject = this.hfB.hfn;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arq();
    }
    this.hfn = paramb;
    localObject = this.hfB.hfo;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arj();
    }
    this.hfo = paramb;
    localObject = this.hfB.hfp;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.arl();
    }
    this.hfp = paramb;
    this.hfq = this.hfB.hfq;
    this.hfr = this.hfB.hfr;
    localObject = this.hfB.hfs;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ars();
    }
    this.hfs = paramb;
    this.hft = paramd.arr();
    localObject = this.hfB.hfu;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.ark();
    }
    this.hfu = paramb;
    this.hfv = this.hfd.hfv;
    this.hfw = this.hfd.hfw;
    paramb = this.hfd;
    paramd = ak.getResources();
    p.g(paramd, "MMApplicationContext.getResources()");
    p.h(paramd, "resources");
    if (paramb.hgJ != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.hgJ));
    }
    for (;;)
    {
      this.hfx = paramb;
      this.hfy = this.hfB.hfI;
      this.hfA = "";
      return;
      if (paramb.hfv != 0) {
        paramb = paramd.getDrawable(paramb.hfv);
      } else {
        paramb = paramb.hfx;
      }
    }
  }
  
  private final void aqW()
  {
    try
    {
      if (this.hfs == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.hiP;
        this.hfs = com.tencent.mm.loader.g.a.e.arI();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> aqV()
  {
    com.tencent.mm.loader.e.b.d locald = this.hfz;
    if (locald == null) {
      p.bdF("target");
    }
    return locald;
  }
  
  public final void vw()
  {
    this.hfy = this.hfB.hfI;
    Object localObject2 = this.hfB.hfz;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.hfz = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.hhB;
    localObject1 = e.a.ary();
    localObject2 = this.hfz;
    if (localObject2 == null) {
      p.bdF("target");
    }
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.hfy;
    p.h(localObject2, "target");
    p.h(localObject3, "data");
    ae.i(com.tencent.mm.loader.e.b.e.TAG, "register " + localObject2 + " and code " + ((com.tencent.mm.loader.e.b.d)localObject2).arw() + " data " + localObject3 + " try get: " + ((com.tencent.mm.loader.e.b.d)localObject2).hhv.get());
    ((com.tencent.mm.loader.e.b.e)localObject1).cqi.put(Integer.valueOf(((com.tencent.mm.loader.e.b.d)localObject2).arw()), new o(localObject3, localObject2));
    localObject1 = this.hfy;
    int i;
    if (this.hfy.isLegal())
    {
      if ((this.hfy.value() instanceof String))
      {
        localObject2 = this.hfy.value();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type kotlin.String");
        }
        if (!bu.isNullOrNil((String)localObject2)) {}
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
        ae.w(TAG, "uri value is isLegal " + this.hfy);
        localObject1 = com.tencent.mm.loader.e.b.e.hhB;
        localObject1 = e.a.ary();
        localObject2 = this.hfz;
        if (localObject2 == null) {
          p.bdF("target");
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
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.hfy, "uri value is isLegal");
        this.hfe.a(this.hfy, this.hfc, null);
        localObject1 = this.hff;
        if (localObject1 != null) {
          ((com.tencent.mm.loader.f.d)localObject1).a(this.hfc);
        }
        return;
      }
    }
    localObject2 = new y.f();
    label437:
    final boolean bool;
    if (this.hfd.hgB)
    {
      localObject1 = this.hfj.a(this.hfy, this.hfp);
      ((y.f)localObject2).NiY = localObject1;
      bool = ((Boolean)((d.g.a.a)new c(this, (y.f)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((y.f)localObject2).NiY;
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
          ae.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.hfy + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.hfp;
          if (localObject3 != null)
          {
            locald = this.hfz;
            if (locald == null) {
              p.bdF("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.hhv, this, (com.tencent.mm.loader.h.e)localObject2, b.b.hhS);
          }
          localObject2 = this.hff;
          if (localObject2 != null) {
            ((com.tencent.mm.loader.f.d)localObject2).a(this.hfc);
          }
          localObject2 = this.hfz;
          if (localObject2 == null) {
            p.bdF("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new b(this, bool));
          if (this.hfh != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.hjf;
            i = com.tencent.mm.loader.h.c.arL();
            localObject2 = com.tencent.mm.loader.h.c.hjf;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.arO(), localObject1);
          }
          localObject2 = this.hfe;
          localObject3 = this.hfy;
          com.tencent.mm.loader.e.b.d locald = this.hfz;
          if (locald == null) {
            p.bdF("target");
          }
          ((com.tencent.mm.loader.f.e)localObject2).a((com.tencent.mm.loader.h.a.a)localObject3, locald.hhv, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.hfy;
      localObject2 = this.hfz;
      if (localObject2 == null) {
        p.bdF("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      localObject2 = com.tencent.mm.loader.c.e.hgN;
      if (com.tencent.mm.loader.c.e.access$getDEBUG$cp())
      {
        localObject2 = bu.fpN().toString();
        p.g(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).hfA = ((String)localObject2);
        this.hfA = ((String)localObject2);
      }
      ae.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.hfy });
      localObject2 = this.hfz;
      if (localObject2 == null) {
        p.bdF("target");
      }
      localObject3 = this.hfz;
      if (localObject3 == null) {
        p.bdF("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).hhv, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      aqW();
      localObject1 = this.hfs;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
  public static final class b
    implements com.tencent.mm.loader.e.b.b
  {
    b(f paramf, boolean paramBoolean) {}
    
    public final void ea(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = com.tencent.mm.loader.e.b.e.hhB;
        localObject = e.a.ary();
        com.tencent.mm.loader.e.b.d locald = this.hfD.aqV();
        if (locald == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        ((com.tencent.mm.loader.e.b.e)localObject).a(locald, this.hfD.hfy, "may be hit cache");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "R", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */