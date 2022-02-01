package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gIT;
  e gJC;
  com.tencent.mm.loader.b.b.e<T, R> gJD;
  com.tencent.mm.loader.b.a.d<T, R> gJE;
  com.tencent.mm.loader.d.b<T> gJF;
  f gJG;
  protected com.tencent.mm.loader.d.d<R> gJH;
  com.tencent.mm.loader.e.c.a<R> gJI;
  com.tencent.mm.loader.d.e gJJ;
  com.tencent.mm.loader.d.c gJK;
  com.tencent.mm.loader.f.b gJL;
  com.tencent.mm.loader.f.e gJM;
  com.tencent.mm.loader.d.a<T> gJN;
  
  public b()
  {
    e.b localb = e.gKo;
    this.gJC = e.b.aou();
    this.gJD = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.gJG = ((f)new com.tencent.mm.loader.e.a());
    this.gJJ = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e());
    this.gJL = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.gJM = ((com.tencent.mm.loader.f.e)new g());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    k.h(paramd, "cache");
    this.gJE = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    k.h(parame, "cache");
    this.gJD = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    k.h(paramb, "downloader");
    this.gJF = paramb;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    k.h(paramb, "transcoder");
    if (this.gJI == null) {
      this.gJI = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.gJI;
    } while (locala == null);
    locala.b(paramb);
    return this;
  }
  
  public final b<T, R> a(f paramf)
  {
    k.h(paramf, "creater");
    this.gJG = paramf;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    k.h(paramd, "<set-?>");
    this.gJH = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> aoc()
  {
    com.tencent.mm.loader.d.d locald = this.gJH;
    if (locald == null) {
      k.aVY("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> aod()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    k.h(parame, "options");
    this.gJC = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    k.h(paramd, "imageProducer");
    this.gJH = paramd;
    return this;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.b.e<T, R> gJO;
    private com.tencent.mm.loader.b.a.d<T, R> gJP;
    private com.tencent.mm.loader.d.b<T> gJQ;
    private com.tencent.mm.loader.d.d<R> gJR;
    private f gJS;
    private com.tencent.mm.loader.e.c.a<R> gJT;
    private e gJU;
    private com.tencent.mm.loader.f.e gJV;
    private com.tencent.mm.loader.d.c gJW;
    private com.tencent.mm.loader.f.b gJX;
    private com.tencent.mm.loader.d.e gJY;
    private com.tencent.mm.loader.d.a<T> gJZ;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gKa;
    
    a()
    {
      this.gJO = localObject1.gJD;
      Object localObject2 = localObject1.gJE;
      if (localObject2 == null) {
        k.aVY("builder_diskCache");
      }
      this.gJP = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.gJF;
      if (localObject2 == null) {
        k.aVY("builder_dataFetcher");
      }
      this.gJQ = ((com.tencent.mm.loader.d.b)localObject2);
      this.gJR = localObject1.aoc();
      this.gJS = localObject1.gJG;
      this.gJT = localObject1.gJI;
      this.gJU = localObject1.gJC;
      this.gJV = localObject1.gJM;
      this.gJW = localObject1.gJK;
      this.gJX = localObject1.gJL;
      this.gJY = localObject1.gJJ;
      this.gJZ = localObject1.gJN;
      this.gKa = localObject1.gIT;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> aoe()
    {
      return this.gJO;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> aof()
    {
      return this.gJP;
    }
    
    public final com.tencent.mm.loader.d.b<T> aog()
    {
      return this.gJQ;
    }
    
    public final com.tencent.mm.loader.d.d<R> aoh()
    {
      return this.gJR;
    }
    
    public final f aoi()
    {
      return this.gJS;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> aoj()
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
    
    public final com.tencent.mm.loader.d.a<T> aop()
    {
      return this.gJZ;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aoq()
    {
      return this.gKa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */