package com.tencent.mm.loader.a;

import com.tencent.mm.loader.e.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/builder/RequestBuilder;", "T", "R", "Lcom/tencent/mm/loader/IRequestBuilder;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask$libimageloader_release", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask$libimageloader_release", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "<set-?>", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mDynamicTranscoder", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "mHeadTranscoder", "getMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "setMImageLoaderAnimation", "(Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;)V", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "setMImageLoaderListener", "(Lcom/tencent/mm/loader/listener/IImageLoaderListener;)V", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setMImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "getReqValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setReqValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "download", "", "fromCache", "()Ljava/lang/Object;", "into", "load", "_drawable", "_resId", "setFileNameCreator", "setImageFileBrokenCallback", "imageFileBrokenCallback", "setImageLoadListener", "imageLoadListener", "setImageLoaderAnimation", "animation", "setImageLoaderListener", "imageLoaderListener", "setImageLoaderReportListener", "imageloaderReportListener", "setLoaderWorkTask", "task", "setOptions", "options", "setResourceTranscoder", "_transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setShowTarget", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<T, R>
  implements com.tencent.mm.loader.b<T, R>
{
  public static final b.a noV = new b.a((byte)0);
  public com.tencent.mm.loader.cache.memory.d<T, R> noA;
  public com.tencent.mm.loader.cache.a.d<T, R> noB;
  public com.tencent.mm.loader.c.c noC;
  public com.tencent.mm.loader.e.b noD;
  public com.tencent.mm.loader.c.e noE;
  public com.tencent.mm.loader.c.d<R> noF;
  public com.tencent.mm.loader.d.c.a<R> noG;
  public com.tencent.mm.loader.d.c.a<R> noH;
  public com.tencent.mm.loader.e.a noI;
  public com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> noJ;
  public g noL;
  public com.tencent.mm.loader.d.b.d<R> noQ;
  public com.tencent.mm.loader.g.a.a<T> noW;
  private com.tencent.mm.loader.b.d<T, R> noX;
  public com.tencent.mm.loader.b.e nou;
  public com.tencent.mm.loader.e.e<T, R> nov;
  public com.tencent.mm.loader.e.d now;
  public com.tencent.mm.loader.e.f nox;
  public com.tencent.mm.loader.e.c<T> noy;
  public com.tencent.mm.loader.c.b<T> noz;
  
  public b(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.d<T, R> paramd)
  {
    this.noW = parama;
    this.noX = paramd;
  }
  
  public final void Td()
  {
    com.tencent.mm.loader.f localf = new com.tencent.mm.loader.f(this, this.noX);
    localf.noP = localf.nor.noW;
    localf.blj();
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.b.e parame)
  {
    s.u(parame, "options");
    this.nou = parame;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.d.c.b<R> paramb)
  {
    s.u(paramb, "_transcoder");
    if (this.noG == null) {
      this.noG = new com.tencent.mm.loader.d.c.a(paramb);
    }
    for (;;)
    {
      return (com.tencent.mm.loader.b)this;
      com.tencent.mm.loader.d.c.a locala = this.noG;
      if (locala != null) {
        locala.c(paramb);
      }
    }
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.e.a parama)
  {
    s.u(parama, "imageDownloadListener");
    this.noI = parama;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.e.b paramb)
  {
    s.u(paramb, "imageFileBrokenCallback");
    this.noD = paramb;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.e.d paramd)
  {
    this.now = paramd;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final com.tencent.mm.loader.b<T, R> a(com.tencent.mm.loader.e.e<T, R> parame)
  {
    s.u(parame, "imageLoaderListener");
    this.nov = parame;
    return (com.tencent.mm.loader.b)this;
  }
  
  public final void blf()
  {
    this.noQ = ((com.tencent.mm.loader.d.b.d)new com.tencent.mm.loader.d.b.a());
    com.tencent.mm.loader.f localf = new com.tencent.mm.loader.f(this, this.noX);
    localf.noS = true;
    localf.noP = localf.nor.noW;
    localf.blj();
  }
  
  public void blg()
  {
    this.noQ = ((com.tencent.mm.loader.d.b.d)new com.tencent.mm.loader.d.b.a());
    Td();
  }
  
  public final R bll()
  {
    if (this.nou == null) {
      this.noX.blA();
    }
    Object localObject2 = this.noA;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.noX.blu();
    }
    com.tencent.mm.loader.g.a.a locala1 = this.noW;
    com.tencent.mm.loader.d.c.a locala = this.noG;
    localObject2 = locala;
    if (locala == null) {
      localObject2 = this.noX.blz();
    }
    localObject1 = ((com.tencent.mm.loader.cache.memory.d)localObject1).a(locala1, (com.tencent.mm.loader.d.c.a)localObject2);
    if (localObject1 == null) {
      return null;
    }
    return ((com.tencent.mm.loader.g.e)localObject1).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.a.b
 * JD-Core Version:    0.7.0.1
 */