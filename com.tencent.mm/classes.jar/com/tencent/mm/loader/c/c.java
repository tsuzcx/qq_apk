package com.tencent.mm.loader.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
public class c
  implements d<String, Bitmap>
{
  private com.tencent.mm.loader.b.b.e<String, Bitmap> gJO = (com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.b();
  private com.tencent.mm.loader.b.a.d<String, Bitmap> gJP = (com.tencent.mm.loader.b.a.d)new com.tencent.mm.loader.b.a.b();
  private com.tencent.mm.loader.d.b<String> gJQ = (com.tencent.mm.loader.d.b)new com.tencent.mm.loader.e.b();
  private com.tencent.mm.loader.d.d<Bitmap> gJR = (com.tencent.mm.loader.d.d)new com.tencent.mm.loader.e.a.a();
  private f gJS = (f)new com.tencent.mm.loader.e.a();
  private com.tencent.mm.loader.e.c.a<Bitmap> gJT;
  private e gJU;
  private com.tencent.mm.loader.f.e gJV;
  private com.tencent.mm.loader.d.c gJW;
  private com.tencent.mm.loader.f.b gJX;
  private com.tencent.mm.loader.d.e gJY;
  private com.tencent.mm.loader.d.a<String> gJZ;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gKa;
  
  public c()
  {
    e.b localb = e.gKo;
    this.gJU = e.b.aou();
    this.gJV = ((com.tencent.mm.loader.f.e)new g());
    this.gJX = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.gJY = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e());
  }
  
  public final com.tencent.mm.loader.b.b.e<String, Bitmap> aoe()
  {
    return this.gJO;
  }
  
  public final com.tencent.mm.loader.b.a.d<String, Bitmap> aof()
  {
    return this.gJP;
  }
  
  public final com.tencent.mm.loader.d.b<String> aog()
  {
    return this.gJQ;
  }
  
  public final com.tencent.mm.loader.d.d<Bitmap> aoh()
  {
    return this.gJR;
  }
  
  public final f aoi()
  {
    return this.gJS;
  }
  
  public com.tencent.mm.loader.e.c.a<Bitmap> aoj()
  {
    return this.gJT;
  }
  
  public final e aok()
  {
    return this.gJU;
  }
  
  public final com.tencent.mm.loader.f.e aol()
  {
    return this.gJV;
  }
  
  public final com.tencent.mm.loader.d.c aom()
  {
    return this.gJW;
  }
  
  public final com.tencent.mm.loader.f.b aon()
  {
    return this.gJX;
  }
  
  public final com.tencent.mm.loader.d.e aoo()
  {
    return this.gJY;
  }
  
  public final com.tencent.mm.loader.d.a<String> aop()
  {
    return this.gJZ;
  }
  
  public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aoq()
  {
    return this.gKa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.c
 * JD-Core Version:    0.7.0.1
 */