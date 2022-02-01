package com.tencent.mm.loader.b;

import android.graphics.Bitmap;
import com.tencent.mm.loader.d.h;
import com.tencent.mm.loader.e.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  implements d<String, Bitmap>
{
  private com.tencent.mm.loader.cache.memory.d<String, Bitmap> npC = (com.tencent.mm.loader.cache.memory.d)new com.tencent.mm.loader.cache.memory.a();
  private com.tencent.mm.loader.cache.a.d<String, Bitmap> npD = (com.tencent.mm.loader.cache.a.d)new com.tencent.mm.loader.cache.a.b();
  private com.tencent.mm.loader.c.b<String> npE = (com.tencent.mm.loader.c.b)new com.tencent.mm.loader.d.b();
  private com.tencent.mm.loader.c.d<Bitmap> npF = (com.tencent.mm.loader.c.d)new com.tencent.mm.loader.d.a.a();
  private g npG = (g)new com.tencent.mm.loader.d.a();
  private com.tencent.mm.loader.d.c.a<Bitmap> npH;
  private e npI;
  private com.tencent.mm.loader.e.f npJ;
  private com.tencent.mm.loader.c.c npK;
  private com.tencent.mm.loader.e.b npL;
  private com.tencent.mm.loader.c.e npM;
  private com.tencent.mm.loader.c.a<String> npN;
  private com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> npO;
  
  public c()
  {
    e.b localb = e.npQ;
    this.npI = e.b.blJ();
    this.npJ = ((com.tencent.mm.loader.e.f)new h());
    this.npL = ((com.tencent.mm.loader.e.b)new com.tencent.mm.loader.d.c());
    this.npM = ((com.tencent.mm.loader.c.e)new com.tencent.mm.loader.d.f());
  }
  
  public final e blA()
  {
    return this.npI;
  }
  
  public final com.tencent.mm.loader.e.f blB()
  {
    return this.npJ;
  }
  
  public final com.tencent.mm.loader.c.c blC()
  {
    return this.npK;
  }
  
  public final com.tencent.mm.loader.e.b blD()
  {
    return this.npL;
  }
  
  public final com.tencent.mm.loader.c.e blE()
  {
    return this.npM;
  }
  
  public final com.tencent.mm.loader.c.a<String> blF()
  {
    return this.npN;
  }
  
  public final com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> blG()
  {
    return this.npO;
  }
  
  public final com.tencent.mm.loader.cache.memory.d<String, Bitmap> blu()
  {
    return this.npC;
  }
  
  public final com.tencent.mm.loader.cache.a.d<String, Bitmap> blv()
  {
    return this.npD;
  }
  
  public final com.tencent.mm.loader.c.b<String> blw()
  {
    return this.npE;
  }
  
  public final com.tencent.mm.loader.c.d<Bitmap> blx()
  {
    return this.npF;
  }
  
  public final g bly()
  {
    return this.npG;
  }
  
  public com.tencent.mm.loader.d.c.a<Bitmap> blz()
  {
    return this.npH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.c
 * JD-Core Version:    0.7.0.1
 */