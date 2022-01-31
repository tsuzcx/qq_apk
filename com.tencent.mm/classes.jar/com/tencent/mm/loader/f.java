package com.tencent.mm.loader;

import a.f.b.j;
import a.f.b.u.d;
import a.l;
import a.o;
import a.v;
import android.graphics.drawable.Drawable;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "checkCleanTmpFile", "download", "load", "request", "Companion", "libimageloader_release"})
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a eNd = new f.a((byte)0);
  private final com.tencent.mm.loader.e.f<T, R> eMF;
  public final com.tencent.mm.loader.c.e eMG;
  private final com.tencent.mm.loader.f.d<T, R> eMH;
  private com.tencent.mm.loader.f.e eMI;
  public com.tencent.mm.loader.f.c<T> eMJ;
  public com.tencent.mm.loader.d.b<T> eMK;
  public com.tencent.mm.loader.b.b.d<T, R> eML;
  public com.tencent.mm.loader.b.a.d<T, R> eMM;
  public com.tencent.mm.loader.d.c eMN;
  private com.tencent.mm.loader.f.b eMO;
  public com.tencent.mm.loader.d.e eMP;
  public com.tencent.mm.loader.d.d<R> eMQ;
  public com.tencent.mm.loader.e.c.a<R> eMR;
  public com.tencent.mm.loader.e.c.a<R> eMS;
  public com.tencent.mm.loader.f.a eMT;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> eMU;
  private com.tencent.mm.loader.d.a<T> eMV;
  public com.tencent.mm.loader.f.f eMW;
  public int eMX;
  public Drawable eMY;
  public com.tencent.mm.loader.h.a.a<T> eMZ;
  public com.tencent.mm.loader.e.b.d<R> eNa;
  public String eNb;
  private final com.tencent.mm.loader.a.b<T, R> eNc;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.eNc = paramb;
    this.eMF = new com.tencent.mm.loader.e.f();
    Object localObject = this.eNc.eMG;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Ti();
    }
    this.eMG = paramb;
    localObject = this.eNc.eMH;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.f.d)this.eMF;
    }
    this.eMH = paramb;
    localObject = this.eNc.eMI;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tj();
    }
    this.eMI = paramb;
    this.eMJ = this.eNc.eMJ;
    localObject = this.eNc.eMK;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Te();
    }
    this.eMK = paramb;
    localObject = this.eNc.eML;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tc();
    }
    this.eML = paramb;
    localObject = this.eNc.eMM;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Td();
    }
    this.eMM = paramb;
    localObject = this.eNc.eMN;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tk();
    }
    this.eMN = paramb;
    localObject = this.eNc.eMO;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tl();
    }
    this.eMO = paramb;
    localObject = this.eNc.eMP;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tm();
    }
    this.eMP = paramb;
    localObject = this.eNc.eMQ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tf();
    }
    this.eMQ = paramb;
    localObject = this.eNc.eMR;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Th();
    }
    this.eMR = paramb;
    this.eMS = this.eNc.eMS;
    this.eMT = this.eNc.eMT;
    this.eMU = this.eNc.eMU;
    this.eMV = paramd.Tn();
    localObject = this.eNc.eMW;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.Tg();
    }
    this.eMW = paramb;
    this.eMX = this.eMG.Tz();
    this.eMY = this.eMG.f(ah.getResources());
    this.eMZ = this.eNc.eNh;
    this.eNb = "";
  }
  
  private final void SZ()
  {
    try
    {
      if (this.eMU == null)
      {
        com.tencent.mm.loader.g.a.e locale = com.tencent.mm.loader.g.a.e.ePM;
        this.eMU = com.tencent.mm.loader.g.a.e.TT();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.e.b.d<R> SY()
  {
    com.tencent.mm.loader.e.b.d locald = this.eNa;
    if (locald == null) {
      j.ays("target");
    }
    return locald;
  }
  
  public final void ph()
  {
    this.eMZ = this.eNc.eNh;
    Object localObject2 = this.eNc.eNa;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a();
    }
    this.eNa = ((com.tencent.mm.loader.e.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.e.b.e.eOI;
    localObject1 = e.a.TL();
    localObject2 = this.eNa;
    if (localObject2 == null) {
      j.ays("target");
    }
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    Object localObject3 = this.eMZ;
    j.q(localObject2, "target");
    j.q(localObject3, "data");
    ab.i(com.tencent.mm.loader.e.b.e.TAG, "register " + localObject2 + " and code " + ((com.tencent.mm.loader.e.b.d)localObject2).TJ() + " data " + localObject3);
    ((com.tencent.mm.loader.e.b.e)localObject1).map.put(Integer.valueOf(((com.tencent.mm.loader.e.b.d)localObject2).TJ()), new o(localObject3, localObject2));
    localObject1 = this.eMZ;
    int i;
    if (this.eMZ.Ue())
    {
      if ((this.eMZ.value() instanceof String))
      {
        localObject2 = this.eMZ.value();
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type kotlin.String");
        }
        if (!bo.isNullOrNil((String)localObject2)) {}
      }
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label329;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ab.w(TAG, "uri value is isLegal " + this.eMZ);
        localObject1 = com.tencent.mm.loader.e.b.e.eOI;
        localObject1 = e.a.TL();
        localObject2 = this.eNa;
        if (localObject2 == null) {
          j.ays("target");
        }
        if (localObject2 == null)
        {
          throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
          i = 0;
          break;
          label329:
          localObject1 = null;
          continue;
        }
        ((com.tencent.mm.loader.e.b.e)localObject1).a((com.tencent.mm.loader.e.b.d)localObject2, this.eMZ, "uri value is isLegal");
        localObject1 = this.eMG;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.loader.c.e)localObject1).TD();; localObject1 = null)
        {
          Arrays.copyOf((Object[])localObject1, localObject1.length);
          return;
        }
      }
    }
    localObject2 = new u.d();
    label409:
    boolean bool;
    if (this.eMG.Tp())
    {
      localObject1 = this.eML.a(this.eMZ, this.eMR);
      ((u.d)localObject2).BNq = localObject1;
      bool = ((Boolean)((a.f.a.a)new f.c(this, (u.d)localObject2)).invoke()).booleanValue();
      localObject1 = (com.tencent.mm.loader.h.e)((u.d)localObject2).BNq;
      if (localObject1 != null) {
        if (!((com.tencent.mm.loader.h.e)localObject1).isValid()) {
          break label839;
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
          ab.d(TAG, "[ImageLoader] load from cache. no need from url: %s", new Object[] { this.eMZ });
          localObject2 = new com.tencent.mm.loader.h.e(localObject1);
          localObject3 = this.eMR;
          if (localObject3 != null)
          {
            com.tencent.mm.loader.e.b.d locald = this.eNa;
            if (locald == null) {
              j.ays("target");
            }
            ((com.tencent.mm.loader.e.c.a)localObject3).a(locald.eOC, this, (com.tencent.mm.loader.h.e)localObject2, b.b.eOZ);
          }
          localObject2 = this.eNa;
          if (localObject2 == null) {
            j.ays("target");
          }
          ((com.tencent.mm.loader.e.b.d)localObject2).a(localObject1, (com.tencent.mm.loader.e.b.b)new f.b(this, bool));
          if (this.eMJ != null)
          {
            localObject2 = com.tencent.mm.loader.h.c.eQe;
            i = com.tencent.mm.loader.h.c.TW();
            localObject2 = com.tencent.mm.loader.h.c.eQe;
            new com.tencent.mm.loader.h.c(i, com.tencent.mm.loader.h.c.TZ(), localObject1);
          }
          if (this.eNa == null) {
            j.ays("target");
          }
          this.eMG.TD();
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = this.eMZ;
      localObject2 = this.eNa;
      if (localObject2 == null) {
        j.ays("target");
      }
      localObject1 = new com.tencent.mm.loader.k.a((com.tencent.mm.loader.h.a.a)localObject1, (com.tencent.mm.loader.e.b.d)localObject2, this);
      if (com.tencent.mm.loader.c.e.DEBUG)
      {
        localObject2 = bo.dtY().toString();
        j.p(localObject2, "Util.getStack().toString()");
        ((com.tencent.mm.loader.k.b)localObject1).eNb = ((String)localObject2);
        this.eNb = ((String)localObject2);
      }
      ab.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.eMZ });
      localObject2 = this.eNa;
      if (localObject2 == null) {
        j.ays("target");
      }
      localObject3 = this.eNa;
      if (localObject3 == null) {
        j.ays("target");
      }
      ((com.tencent.mm.loader.e.b.d)localObject2).a(((com.tencent.mm.loader.e.b.d)localObject3).eOC, this);
      localObject2 = (com.tencent.mm.loader.k.b)localObject1;
      bool = this.eMG.Tr();
      SZ();
      localObject1 = this.eMU;
      if (localObject1 != null)
      {
        localObject2 = (com.tencent.mm.loader.g.c)localObject2;
        j.q(localObject2, "t");
        ((com.tencent.mm.loader.g.d)localObject1).a((com.tencent.mm.loader.g.c)localObject2, null, true);
      }
      if (!bool) {
        break;
      }
      com.tencent.mm.loader.l.b.Ur();
      return;
      localObject1 = null;
      break label409;
      label839:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */