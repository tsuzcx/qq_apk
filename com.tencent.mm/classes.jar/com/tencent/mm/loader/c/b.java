package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  e hYW;
  com.tencent.mm.loader.b.b.e<T, R> hYX;
  com.tencent.mm.loader.b.a.d<T, R> hYY;
  com.tencent.mm.loader.d.b<T> hYZ;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hYm;
  g hZa;
  protected com.tencent.mm.loader.d.d<R> hZb;
  com.tencent.mm.loader.e.c.a<R> hZc;
  com.tencent.mm.loader.d.e hZd;
  com.tencent.mm.loader.d.c hZe;
  com.tencent.mm.loader.f.b hZf;
  com.tencent.mm.loader.f.f hZg;
  com.tencent.mm.loader.d.a<T> hZh;
  
  public b()
  {
    e.b localb = e.hZH;
    this.hYW = e.b.aJU();
    this.hYX = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.hZa = ((g)new com.tencent.mm.loader.e.a());
    this.hZd = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
    this.hZf = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.hZg = ((com.tencent.mm.loader.f.f)new h());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    p.h(paramd, "cache");
    this.hYY = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    p.h(parame, "cache");
    this.hYX = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    p.h(paramb, "downloader");
    this.hYZ = paramb;
    return this;
  }
  
  public final b<T, R> a(g paramg)
  {
    p.h(paramg, "creater");
    this.hZa = paramg;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "<set-?>");
    this.hZb = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> aJD()
  {
    com.tencent.mm.loader.d.d locald = this.hZb;
    if (locald == null) {
      p.btv("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> aJE()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    p.h(parame, "options");
    this.hYW = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "imageProducer");
    this.hZb = paramd;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    p.h(paramb, "transcoder");
    if (this.hZc == null) {
      this.hZc = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.hZc;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.b.e<T, R> hZi;
    private com.tencent.mm.loader.b.a.d<T, R> hZj;
    private com.tencent.mm.loader.d.b<T> hZk;
    private com.tencent.mm.loader.d.d<R> hZl;
    private g hZm;
    private com.tencent.mm.loader.e.c.a<R> hZn;
    private e hZo;
    private com.tencent.mm.loader.f.f hZp;
    private com.tencent.mm.loader.d.c hZq;
    private com.tencent.mm.loader.f.b hZr;
    private com.tencent.mm.loader.d.e hZs;
    private com.tencent.mm.loader.d.a<T> hZt;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hZu;
    
    a()
    {
      this.hZi = localObject1.hYX;
      Object localObject2 = localObject1.hYY;
      if (localObject2 == null) {
        p.btv("builder_diskCache");
      }
      this.hZj = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.hYZ;
      if (localObject2 == null) {
        p.btv("builder_dataFetcher");
      }
      this.hZk = ((com.tencent.mm.loader.d.b)localObject2);
      this.hZl = localObject1.aJD();
      this.hZm = localObject1.hZa;
      this.hZn = localObject1.hZc;
      this.hZo = localObject1.hYW;
      this.hZp = localObject1.hZg;
      this.hZq = localObject1.hZe;
      this.hZr = localObject1.hZf;
      this.hZs = localObject1.hZd;
      this.hZt = localObject1.hZh;
      this.hZu = localObject1.hYm;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> aJF()
    {
      return this.hZi;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> aJG()
    {
      return this.hZj;
    }
    
    public final com.tencent.mm.loader.d.b<T> aJH()
    {
      return this.hZk;
    }
    
    public final com.tencent.mm.loader.d.d<R> aJI()
    {
      return this.hZl;
    }
    
    public final g aJJ()
    {
      return this.hZm;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> aJK()
    {
      return this.hZn;
    }
    
    public final e aJL()
    {
      return this.hZo;
    }
    
    public final com.tencent.mm.loader.f.f aJM()
    {
      return this.hZp;
    }
    
    public final com.tencent.mm.loader.d.c aJN()
    {
      return this.hZq;
    }
    
    public final com.tencent.mm.loader.f.b aJO()
    {
      return this.hZr;
    }
    
    public final com.tencent.mm.loader.d.e aJP()
    {
      return this.hZs;
    }
    
    public final com.tencent.mm.loader.d.a<T> aJQ()
    {
      return this.hZt;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aJR()
    {
      return this.hZu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */