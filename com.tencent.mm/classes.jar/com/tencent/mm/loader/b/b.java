package com.tencent.mm.loader.b;

import com.tencent.mm.loader.d.h;
import com.tencent.mm.loader.e.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T, R>
{
  public com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> noJ;
  com.tencent.mm.loader.e.f npA;
  com.tencent.mm.loader.c.a<T> npB;
  e npq;
  com.tencent.mm.loader.cache.memory.d<T, R> npr;
  com.tencent.mm.loader.cache.a.d<T, R> nps;
  com.tencent.mm.loader.c.b<T> npt;
  g npu;
  protected com.tencent.mm.loader.c.d<R> npv;
  com.tencent.mm.loader.d.c.a<R> npw;
  com.tencent.mm.loader.c.e npx;
  com.tencent.mm.loader.c.c npy;
  com.tencent.mm.loader.e.b npz;
  
  public b()
  {
    e.b localb = e.npQ;
    this.npq = e.b.blJ();
    this.npr = ((com.tencent.mm.loader.cache.memory.d)new com.tencent.mm.loader.cache.memory.b());
    this.npu = ((g)new com.tencent.mm.loader.d.a());
    this.npx = ((com.tencent.mm.loader.c.e)new com.tencent.mm.loader.d.f());
    this.npz = ((com.tencent.mm.loader.e.b)new com.tencent.mm.loader.d.c());
    this.npA = ((com.tencent.mm.loader.e.f)new h());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.c.b<T> paramb)
  {
    s.u(paramb, "downloader");
    this.npt = paramb;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.cache.a.d<T, R> paramd)
  {
    s.u(paramd, "cache");
    this.nps = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.cache.memory.d<T, R> paramd)
  {
    s.u(paramd, "cache");
    this.npr = paramd;
    return this;
  }
  
  public final b<T, R> a(g paramg)
  {
    s.u(paramg, "creater");
    this.npu = paramg;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.c.d<R> paramd)
  {
    s.u(paramd, "<set-?>");
    this.npv = paramd;
  }
  
  public final b<T, R> b(e parame)
  {
    s.u(parame, "options");
    this.npq = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.c.d<R> paramd)
  {
    s.u(paramd, "imageProducer");
    a(paramd);
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.c.b<R> paramb)
  {
    s.u(paramb, "transcoder");
    if (this.npw == null) {
      this.npw = new com.tencent.mm.loader.d.c.a(paramb);
    }
    com.tencent.mm.loader.d.c.a locala;
    do
    {
      return this;
      locala = this.npw;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  protected final com.tencent.mm.loader.c.d<R> bls()
  {
    com.tencent.mm.loader.c.d locald = this.npv;
    if (locald != null) {
      return locald;
    }
    s.bIx("imageProducer");
    return null;
  }
  
  public final d<T, R> blt()
  {
    return (d)new a(this);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.cache.memory.d<T, R> npC = this.npP.npr;
    private com.tencent.mm.loader.cache.a.d<T, R> npD;
    private com.tencent.mm.loader.c.b<T> npE;
    private com.tencent.mm.loader.c.d<R> npF;
    private g npG;
    private com.tencent.mm.loader.d.c.a<R> npH;
    private e npI;
    private com.tencent.mm.loader.e.f npJ;
    private com.tencent.mm.loader.c.c npK;
    private com.tencent.mm.loader.e.b npL;
    private com.tencent.mm.loader.c.e npM;
    private com.tencent.mm.loader.c.a<T> npN;
    private com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> npO;
    
    a(b<T, R> paramb)
    {
      com.tencent.mm.loader.cache.a.d locald = this.npP.nps;
      paramb = locald;
      if (locald == null)
      {
        s.bIx("builder_diskCache");
        paramb = null;
      }
      this.npD = paramb;
      paramb = this.npP.npt;
      if (paramb == null)
      {
        s.bIx("builder_dataFetcher");
        paramb = localObject;
      }
      for (;;)
      {
        this.npE = paramb;
        this.npF = this.npP.bls();
        this.npG = this.npP.npu;
        this.npH = this.npP.npw;
        this.npI = this.npP.npq;
        this.npJ = this.npP.npA;
        this.npK = this.npP.npy;
        this.npL = this.npP.npz;
        this.npM = this.npP.npx;
        this.npN = this.npP.npB;
        this.npO = this.npP.noJ;
        return;
      }
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
    
    public final com.tencent.mm.loader.c.a<T> blF()
    {
      return this.npN;
    }
    
    public final com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> blG()
    {
      return this.npO;
    }
    
    public final com.tencent.mm.loader.cache.memory.d<T, R> blu()
    {
      return this.npC;
    }
    
    public final com.tencent.mm.loader.cache.a.d<T, R> blv()
    {
      return this.npD;
    }
    
    public final com.tencent.mm.loader.c.b<T> blw()
    {
      return this.npE;
    }
    
    public final com.tencent.mm.loader.c.d<R> blx()
    {
      return this.npF;
    }
    
    public final g bly()
    {
      return this.npG;
    }
    
    public final com.tencent.mm.loader.d.c.a<R> blz()
    {
      return this.npH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.b
 * JD-Core Version:    0.7.0.1
 */