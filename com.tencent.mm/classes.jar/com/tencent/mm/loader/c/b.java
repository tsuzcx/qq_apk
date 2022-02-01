package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hcE;
  e hdn;
  com.tencent.mm.loader.b.b.e<T, R> hdo;
  com.tencent.mm.loader.b.a.d<T, R> hdp;
  com.tencent.mm.loader.d.b<T> hdq;
  g hdr;
  protected com.tencent.mm.loader.d.d<R> hds;
  com.tencent.mm.loader.e.c.a<R> hdt;
  com.tencent.mm.loader.d.e hdu;
  com.tencent.mm.loader.d.c hdv;
  com.tencent.mm.loader.f.b hdw;
  com.tencent.mm.loader.f.f hdx;
  com.tencent.mm.loader.d.a<T> hdy;
  
  public b()
  {
    e.b localb = e.hdZ;
    this.hdn = e.b.arg();
    this.hdo = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.hdr = ((g)new com.tencent.mm.loader.e.a());
    this.hdu = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
    this.hdw = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.hdx = ((com.tencent.mm.loader.f.f)new h());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    p.h(paramd, "cache");
    this.hdp = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    p.h(parame, "cache");
    this.hdo = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    p.h(paramb, "downloader");
    this.hdq = paramb;
    return this;
  }
  
  public final b<T, R> a(g paramg)
  {
    p.h(paramg, "creater");
    this.hdr = paramg;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "<set-?>");
    this.hds = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> aqP()
  {
    com.tencent.mm.loader.d.d locald = this.hds;
    if (locald == null) {
      p.bcb("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> aqQ()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    p.h(parame, "options");
    this.hdn = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "imageProducer");
    this.hds = paramd;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    p.h(paramb, "transcoder");
    if (this.hdt == null) {
      this.hdt = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.hdt;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.a.d<T, R> hdA;
    private com.tencent.mm.loader.d.b<T> hdB;
    private com.tencent.mm.loader.d.d<R> hdC;
    private g hdD;
    private com.tencent.mm.loader.e.c.a<R> hdE;
    private e hdF;
    private com.tencent.mm.loader.f.f hdG;
    private com.tencent.mm.loader.d.c hdH;
    private com.tencent.mm.loader.f.b hdI;
    private com.tencent.mm.loader.d.e hdJ;
    private com.tencent.mm.loader.d.a<T> hdK;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hdL;
    private com.tencent.mm.loader.b.b.e<T, R> hdz;
    
    a()
    {
      this.hdz = localObject1.hdo;
      Object localObject2 = localObject1.hdp;
      if (localObject2 == null) {
        p.bcb("builder_diskCache");
      }
      this.hdA = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.hdq;
      if (localObject2 == null) {
        p.bcb("builder_dataFetcher");
      }
      this.hdB = ((com.tencent.mm.loader.d.b)localObject2);
      this.hdC = localObject1.aqP();
      this.hdD = localObject1.hdr;
      this.hdE = localObject1.hdt;
      this.hdF = localObject1.hdn;
      this.hdG = localObject1.hdx;
      this.hdH = localObject1.hdv;
      this.hdI = localObject1.hdw;
      this.hdJ = localObject1.hdu;
      this.hdK = localObject1.hdy;
      this.hdL = localObject1.hcE;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> aqR()
    {
      return this.hdz;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> aqS()
    {
      return this.hdA;
    }
    
    public final com.tencent.mm.loader.d.b<T> aqT()
    {
      return this.hdB;
    }
    
    public final com.tencent.mm.loader.d.d<R> aqU()
    {
      return this.hdC;
    }
    
    public final g aqV()
    {
      return this.hdD;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> aqW()
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
    
    public final com.tencent.mm.loader.d.a<T> arc()
    {
      return this.hdK;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> ard()
    {
      return this.hdL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */