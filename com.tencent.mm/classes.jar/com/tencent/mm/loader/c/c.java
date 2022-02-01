package com.tencent.mm.loader.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
public class c
  implements d<String, Bitmap>
{
  private com.tencent.mm.loader.b.b.e<String, Bitmap> gjd = (com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.b();
  private com.tencent.mm.loader.b.a.d<String, Bitmap> gje = (com.tencent.mm.loader.b.a.d)new com.tencent.mm.loader.b.a.b();
  private com.tencent.mm.loader.d.b<String> gjf = (com.tencent.mm.loader.d.b)new com.tencent.mm.loader.e.b();
  private com.tencent.mm.loader.d.d<Bitmap> gjg = (com.tencent.mm.loader.d.d)new com.tencent.mm.loader.e.a.a();
  private f gjh = (f)new com.tencent.mm.loader.e.a();
  private com.tencent.mm.loader.e.c.a<Bitmap> gji;
  private e gjj;
  private com.tencent.mm.loader.f.e gjk;
  private com.tencent.mm.loader.d.c gjl;
  private com.tencent.mm.loader.f.b gjm;
  private com.tencent.mm.loader.d.e gjn;
  private com.tencent.mm.loader.d.a<String> gjo;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gjp;
  
  public c()
  {
    e.b localb = e.gjC;
    this.gjj = e.b.ahs();
    this.gjk = ((com.tencent.mm.loader.f.e)new g());
    this.gjm = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.gjn = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e());
  }
  
  public final com.tencent.mm.loader.b.b.e<String, Bitmap> ahc()
  {
    return this.gjd;
  }
  
  public final com.tencent.mm.loader.b.a.d<String, Bitmap> ahd()
  {
    return this.gje;
  }
  
  public final com.tencent.mm.loader.d.b<String> ahe()
  {
    return this.gjf;
  }
  
  public final com.tencent.mm.loader.d.d<Bitmap> ahf()
  {
    return this.gjg;
  }
  
  public final f ahg()
  {
    return this.gjh;
  }
  
  public com.tencent.mm.loader.e.c.a<Bitmap> ahh()
  {
    return this.gji;
  }
  
  public final e ahi()
  {
    return this.gjj;
  }
  
  public final com.tencent.mm.loader.f.e ahj()
  {
    return this.gjk;
  }
  
  public final com.tencent.mm.loader.d.c ahk()
  {
    return this.gjl;
  }
  
  public final com.tencent.mm.loader.f.b ahl()
  {
    return this.gjm;
  }
  
  public final com.tencent.mm.loader.d.e ahm()
  {
    return this.gjn;
  }
  
  public final com.tencent.mm.loader.d.a<String> ahn()
  {
    return this.gjo;
  }
  
  public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aho()
  {
    return this.gjp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.c.c
 * JD-Core Version:    0.7.0.1
 */