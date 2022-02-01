package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> kMQ;
  e kNC;
  com.tencent.mm.loader.b.b.e<T, R> kND;
  com.tencent.mm.loader.b.a.d<T, R> kNE;
  com.tencent.mm.loader.d.b<T> kNF;
  g kNG;
  protected com.tencent.mm.loader.d.d<R> kNH;
  com.tencent.mm.loader.e.c.a<R> kNI;
  com.tencent.mm.loader.d.e kNJ;
  com.tencent.mm.loader.d.c kNK;
  com.tencent.mm.loader.f.b kNL;
  com.tencent.mm.loader.f.f kNM;
  com.tencent.mm.loader.d.a<T> kNN;
  
  public b()
  {
    e.b localb = e.kOn;
    this.kNC = e.b.aRU();
    this.kND = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.kNG = ((g)new com.tencent.mm.loader.e.a());
    this.kNJ = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
    this.kNL = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.kNM = ((com.tencent.mm.loader.f.f)new h());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    p.k(paramd, "cache");
    this.kNE = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    p.k(parame, "cache");
    this.kND = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    p.k(paramb, "downloader");
    this.kNF = paramb;
    return this;
  }
  
  public final b<T, R> a(g paramg)
  {
    p.k(paramg, "creater");
    this.kNG = paramg;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.k(paramd, "<set-?>");
    this.kNH = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> aRD()
  {
    com.tencent.mm.loader.d.d locald = this.kNH;
    if (locald == null) {
      p.bGy("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> aRE()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    p.k(parame, "options");
    this.kNC = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.k(paramd, "imageProducer");
    this.kNH = paramd;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    p.k(paramb, "transcoder");
    if (this.kNI == null) {
      this.kNI = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.kNI;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.b.e<T, R> kNO;
    private com.tencent.mm.loader.b.a.d<T, R> kNP;
    private com.tencent.mm.loader.d.b<T> kNQ;
    private com.tencent.mm.loader.d.d<R> kNR;
    private g kNS;
    private com.tencent.mm.loader.e.c.a<R> kNT;
    private e kNU;
    private com.tencent.mm.loader.f.f kNV;
    private com.tencent.mm.loader.d.c kNW;
    private com.tencent.mm.loader.f.b kNX;
    private com.tencent.mm.loader.d.e kNY;
    private com.tencent.mm.loader.d.a<T> kNZ;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> kOa;
    
    a()
    {
      this.kNO = localObject1.kND;
      Object localObject2 = localObject1.kNE;
      if (localObject2 == null) {
        p.bGy("builder_diskCache");
      }
      this.kNP = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.kNF;
      if (localObject2 == null) {
        p.bGy("builder_dataFetcher");
      }
      this.kNQ = ((com.tencent.mm.loader.d.b)localObject2);
      this.kNR = localObject1.aRD();
      this.kNS = localObject1.kNG;
      this.kNT = localObject1.kNI;
      this.kNU = localObject1.kNC;
      this.kNV = localObject1.kNM;
      this.kNW = localObject1.kNK;
      this.kNX = localObject1.kNL;
      this.kNY = localObject1.kNJ;
      this.kNZ = localObject1.kNN;
      this.kOa = localObject1.kMQ;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> aRF()
    {
      return this.kNO;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> aRG()
    {
      return this.kNP;
    }
    
    public final com.tencent.mm.loader.d.b<T> aRH()
    {
      return this.kNQ;
    }
    
    public final com.tencent.mm.loader.d.d<R> aRI()
    {
      return this.kNR;
    }
    
    public final g aRJ()
    {
      return this.kNS;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> aRK()
    {
      return this.kNT;
    }
    
    public final e aRL()
    {
      return this.kNU;
    }
    
    public final com.tencent.mm.loader.f.f aRM()
    {
      return this.kNV;
    }
    
    public final com.tencent.mm.loader.d.c aRN()
    {
      return this.kNW;
    }
    
    public final com.tencent.mm.loader.f.b aRO()
    {
      return this.kNX;
    }
    
    public final com.tencent.mm.loader.d.e aRP()
    {
      return this.kNY;
    }
    
    public final com.tencent.mm.loader.d.a<T> aRQ()
    {
      return this.kNZ;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aRR()
    {
      return this.kOa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */