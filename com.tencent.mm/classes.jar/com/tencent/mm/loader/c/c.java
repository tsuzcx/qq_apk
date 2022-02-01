package com.tencent.mm.loader.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
public class c
  implements d<String, Bitmap>
{
  private com.tencent.mm.loader.b.a.d<String, Bitmap> hdA = (com.tencent.mm.loader.b.a.d)new com.tencent.mm.loader.b.a.b();
  private com.tencent.mm.loader.d.b<String> hdB = (com.tencent.mm.loader.d.b)new com.tencent.mm.loader.e.b();
  private com.tencent.mm.loader.d.d<Bitmap> hdC = (com.tencent.mm.loader.d.d)new com.tencent.mm.loader.e.a.a();
  private g hdD = (g)new com.tencent.mm.loader.e.a();
  private com.tencent.mm.loader.e.c.a<Bitmap> hdE;
  private e hdF;
  private com.tencent.mm.loader.f.f hdG;
  private com.tencent.mm.loader.d.c hdH;
  private com.tencent.mm.loader.f.b hdI;
  private com.tencent.mm.loader.d.e hdJ;
  private com.tencent.mm.loader.d.a<String> hdK;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hdL;
  private com.tencent.mm.loader.b.b.e<String, Bitmap> hdz = (com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.b();
  
  public c()
  {
    e.b localb = e.hdZ;
    this.hdF = e.b.arg();
    this.hdG = ((com.tencent.mm.loader.f.f)new h());
    this.hdI = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.hdJ = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
  }
  
  public final com.tencent.mm.loader.b.b.e<String, Bitmap> aqR()
  {
    return this.hdz;
  }
  
  public final com.tencent.mm.loader.b.a.d<String, Bitmap> aqS()
  {
    return this.hdA;
  }
  
  public final com.tencent.mm.loader.d.b<String> aqT()
  {
    return this.hdB;
  }
  
  public final com.tencent.mm.loader.d.d<Bitmap> aqU()
  {
    return this.hdC;
  }
  
  public final g aqV()
  {
    return this.hdD;
  }
  
  public com.tencent.mm.loader.e.c.a<Bitmap> aqW()
  {
    return this.hdE;
  }
  
  public final e aqX()
  {
    return this.hdF;
  }
  
  public final com.tencent.mm.loader.f.f aqY()
  {
    return this.hdG;
  }
  
  public final com.tencent.mm.loader.d.c aqZ()
  {
    return this.hdH;
  }
  
  public final com.tencent.mm.loader.f.b ara()
  {
    return this.hdI;
  }
  
  public final com.tencent.mm.loader.d.e arb()
  {
    return this.hdJ;
  }
  
  public final com.tencent.mm.loader.d.a<String> arc()
  {
    return this.hdK;
  }
  
  public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> ard()
  {
    return this.hdL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.c
 * JD-Core Version:    0.7.0.1
 */