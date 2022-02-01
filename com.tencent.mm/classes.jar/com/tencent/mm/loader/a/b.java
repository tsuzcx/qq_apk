package com.tencent.mm.loader.a;

import com.tencent.mm.loader.f.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/builder/RequestBuilder;", "T", "R", "Lcom/tencent/mm/loader/IRequestBuilder;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask$libimageloader_release", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask$libimageloader_release", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "<set-?>", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mDynamicTranscoder", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mHeadTranscoder", "getMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "setMImageLoaderAnimation", "(Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "setMImageLoaderListener", "(Lcom/tencent/mm/loader/listener/IImageLoaderListener;)V", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setMImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "getReqValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setReqValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "download", "", "fromCache", "()Ljava/lang/Object;", "into", "load", "_drawable", "_resId", "setFileNameCreator", "setImageFileBrokenCallback", "imageFileBrokenCallback", "setImageLoadListener", "imageLoadListener", "setImageLoaderAnimation", "animation", "setImageLoaderListener", "imageLoaderListener", "setImageLoaderReportListener", "imageloaderReportListener", "setLoaderWorkTask", "task", "setOptions", "options", "setResourceTranscoder", "_transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setShowTarget", "Companion", "libimageloader_release"})
public abstract class b<T, R>
  implements com.tencent.mm.loader.b<T, R>
{
  public static final b.a hcW = new b.a((byte)0);
  public com.tencent.mm.loader.d.d<R> hcA;
  public com.tencent.mm.loader.e.c.a<R> hcB;
  public com.tencent.mm.loader.e.c.a<R> hcC;
  public com.tencent.mm.loader.f.a hcD;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hcE;
  public g hcG;
  public com.tencent.mm.loader.e.b.d<R> hcL;
  public com.tencent.mm.loader.h.a.a<T> hcU;
  private com.tencent.mm.loader.c.d<T, R> hcV;
  public com.tencent.mm.loader.c.e hcp;
  public com.tencent.mm.loader.f.e<T, R> hcq;
  public com.tencent.mm.loader.f.d hcr;
  public com.tencent.mm.loader.f.f hcs;
  public com.tencent.mm.loader.f.c<T> hct;
  public com.tencent.mm.loader.d.b<T> hcu;
  public com.tencent.mm.loader.b.b.e<T, R> hcv;
  public com.tencent.mm.loader.b.a.d<T, R> hcw;
  public com.tencent.mm.loader.d.c hcx;
  public com.tencent.mm.loader.f.b hcy;
  public com.tencent.mm.loader.d.e hcz;
  
  public b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.hcU = parama;
    this.hcV = paramd;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.c.e parame)
  {
    p.h(parame, "options");
    this.hcp = parame;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    p.h(paramb, "_transcoder");
    if (this.hcB == null) {
      this.hcB = new com.tencent.mm.loader.e.c.a(paramb);
    }
    for (;;)
    {
      return (com.tencent.mm.loader.b)this;
      com.tencent.mm.loader.e.c.a locala = this.hcB;
      if (locala != null) {
        locala.c(paramb);
      }
    }
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.f.d paramd)
  {
    this.hcr = paramd;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.f.e<T, R> parame)
  {
    p.h(parame, "imageLoaderListener");
    this.hcq = parame;
    return (com.tencent.mm.loader.b)this;
  }
  
  public void aqI()
  {
    this.hcL = ((com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a());
    vw();
  }
  
  public final R aqJ()
  {
    Object localObject2 = this.hcv;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.hcV.aqR();
    }
    com.tencent.mm.loader.h.a.a locala1 = this.hcU;
    com.tencent.mm.loader.e.c.a locala = this.hcB;
    localObject2 = locala;
    if (locala == null) {
      localObject2 = this.hcV.aqW();
    }
    localObject1 = ((com.tencent.mm.loader.b.b.e)localObject1).a(locala1, (com.tencent.mm.loader.e.c.a)localObject2);
    if (localObject1 != null) {
      return ((com.tencent.mm.loader.h.e)localObject1).value();
    }
    return null;
  }
  
  public final void vw()
  {
    new com.tencent.mm.loader.f(this, this.hcV).vw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.a.b
 * JD-Core Version:    0.7.0.1
 */