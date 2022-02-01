package com.tencent.mm.loader.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
public class c
  implements d<String, Bitmap>
{
  private com.tencent.mm.loader.b.b.e<String, Bitmap> hgn = (com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.b();
  private com.tencent.mm.loader.b.a.d<String, Bitmap> hgo = (com.tencent.mm.loader.b.a.d)new com.tencent.mm.loader.b.a.b();
  private com.tencent.mm.loader.d.b<String> hgp = (com.tencent.mm.loader.d.b)new com.tencent.mm.loader.e.b();
  private com.tencent.mm.loader.d.d<Bitmap> hgq = (com.tencent.mm.loader.d.d)new com.tencent.mm.loader.e.a.a();
  private g hgr = (g)new com.tencent.mm.loader.e.a();
  private com.tencent.mm.loader.e.c.a<Bitmap> hgs;
  private e hgt;
  private com.tencent.mm.loader.f.f hgu;
  private com.tencent.mm.loader.d.c hgv;
  private com.tencent.mm.loader.f.b hgw;
  private com.tencent.mm.loader.d.e hgx;
  private com.tencent.mm.loader.d.a<String> hgy;
  private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hgz;
  
  public c()
  {
    e.b localb = e.hgN;
    this.hgt = e.b.arv();
    this.hgu = ((com.tencent.mm.loader.f.f)new h());
    this.hgw = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.hgx = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
  }
  
  public final com.tencent.mm.loader.b.b.e<String, Bitmap> arg()
  {
    return this.hgn;
  }
  
  public final com.tencent.mm.loader.b.a.d<String, Bitmap> arh()
  {
    return this.hgo;
  }
  
  public final com.tencent.mm.loader.d.b<String> ari()
  {
    return this.hgp;
  }
  
  public final com.tencent.mm.loader.d.d<Bitmap> arj()
  {
    return this.hgq;
  }
  
  public final g ark()
  {
    return this.hgr;
  }
  
  public com.tencent.mm.loader.e.c.a<Bitmap> arl()
  {
    return this.hgs;
  }
  
  public final e arm()
  {
    return this.hgt;
  }
  
  public final com.tencent.mm.loader.f.f arn()
  {
    return this.hgu;
  }
  
  public final com.tencent.mm.loader.d.c aro()
  {
    return this.hgv;
  }
  
  public final com.tencent.mm.loader.f.b arp()
  {
    return this.hgw;
  }
  
  public final com.tencent.mm.loader.d.e arq()
  {
    return this.hgx;
  }
  
  public final com.tencent.mm.loader.d.a<String> arr()
  {
    return this.hgy;
  }
  
  public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> ars()
  {
    return this.hgz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.c
 * JD-Core Version:    0.7.0.1
 */