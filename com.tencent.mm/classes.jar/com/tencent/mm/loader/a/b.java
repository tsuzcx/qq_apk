package com.tencent.mm.loader.a;

import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/builder/RequestBuilder;", "T", "R", "Lcom/tencent/mm/loader/IRequestBuilder;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask$libimageloader_release", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask$libimageloader_release", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "<set-?>", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mDynamicTranscoder", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mHeadTranscoder", "getMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "setMImageLoaderListener", "(Lcom/tencent/mm/loader/listener/IImageLoaderListener;)V", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setMImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "getReqValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setReqValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "download", "", "fromCache", "()Ljava/lang/Object;", "into", "load", "_drawable", "_resId", "setFileNameCreator", "setImageFileBrokenCallback", "imageFileBrokenCallback", "setImageLoadListener", "imageLoadListener", "setImageLoaderListener", "imageLoaderListener", "setImageLoaderReportListener", "imageloaderReportListener", "setLoaderWorkTask", "task", "setOptions", "options", "setResourceTranscoder", "_transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setShowTarget", "Companion", "libimageloader_release"})
public abstract class b<T, R>
  implements com.tencent.mm.loader.b<T, R>
{
  public static final b.a gJl = new b.a((byte)0);
  public com.tencent.mm.loader.c.e gIF;
  public com.tencent.mm.loader.f.d<T, R> gIG;
  public com.tencent.mm.loader.f.e gIH;
  public com.tencent.mm.loader.f.c<T> gII;
  public com.tencent.mm.loader.d.b<T> gIJ;
  public com.tencent.mm.loader.b.b.e<T, R> gIK;
  public com.tencent.mm.loader.b.a.d<T, R> gIL;
  public com.tencent.mm.loader.d.c gIM;
  public com.tencent.mm.loader.f.b gIN;
  public com.tencent.mm.loader.d.e gIO;
  public com.tencent.mm.loader.d.d<R> gIP;
  public com.tencent.mm.loader.e.c.a<R> gIQ;
  public com.tencent.mm.loader.e.c.a<R> gIR;
  public com.tencent.mm.loader.f.a gIS;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gIT;
  public com.tencent.mm.loader.f.f gIV;
  public com.tencent.mm.loader.e.b.d<R> gJa;
  public com.tencent.mm.loader.h.a.a<T> gJj;
  private com.tencent.mm.loader.c.d<T, R> gJk;
  
  public b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.d<T, R> paramd)
  {
    this.gJj = parama;
    this.gJk = paramd;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.c.e parame)
  {
    k.h(parame, "options");
    this.gIF = parame;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.f.d<T, R> paramd)
  {
    k.h(paramd, "imageLoaderListener");
    this.gIG = paramd;
    return (com.tencent.mm.loader.b)this;
  }
  
  public void anW()
  {
    this.gJa = ((com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a());
    tX();
  }
  
  public final void tX()
  {
    new com.tencent.mm.loader.f(this, this.gJk).tX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.a.b
 * JD-Core Version:    0.7.0.1
 */