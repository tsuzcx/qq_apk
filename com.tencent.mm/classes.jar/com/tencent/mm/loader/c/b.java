package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  e giR;
  com.tencent.mm.loader.b.b.e<T, R> giS;
  com.tencent.mm.loader.b.a.d<T, R> giT;
  com.tencent.mm.loader.d.b<T> giU;
  f giV;
  protected com.tencent.mm.loader.d.d<R> giW;
  com.tencent.mm.loader.e.c.a<R> giX;
  com.tencent.mm.loader.d.e giY;
  com.tencent.mm.loader.d.c giZ;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gik;
  com.tencent.mm.loader.f.b gja;
  com.tencent.mm.loader.f.e gjb;
  com.tencent.mm.loader.d.a<T> gjc;
  
  public b()
  {
    e.b localb = e.gjC;
    this.giR = e.b.ahs();
    this.giS = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.giV = ((f)new com.tencent.mm.loader.e.a());
    this.giY = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e());
    this.gja = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.gjb = ((com.tencent.mm.loader.f.e)new g());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    k.h(paramd, "cache");
    this.giT = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    k.h(parame, "cache");
    this.giS = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    k.h(paramb, "downloader");
    this.giU = paramb;
    return this;
  }
  
  public final b<T, R> a(f paramf)
  {
    k.h(paramf, "creater");
    this.giV = paramf;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    k.h(paramd, "<set-?>");
    this.giW = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> aha()
  {
    com.tencent.mm.loader.d.d locald = this.giW;
    if (locald == null) {
      k.aPZ("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> ahb()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    k.h(parame, "options");
    this.giR = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    k.h(paramd, "imageProducer");
    this.giW = paramd;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    k.h(paramb, "transcoder");
    if (this.giX == null) {
      this.giX = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.giX;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.b.e<T, R> gjd;
    private com.tencent.mm.loader.b.a.d<T, R> gje;
    private com.tencent.mm.loader.d.b<T> gjf;
    private com.tencent.mm.loader.d.d<R> gjg;
    private f gjh;
    private com.tencent.mm.loader.e.c.a<R> gji;
    private e gjj;
    private com.tencent.mm.loader.f.e gjk;
    private com.tencent.mm.loader.d.c gjl;
    private com.tencent.mm.loader.f.b gjm;
    private com.tencent.mm.loader.d.e gjn;
    private com.tencent.mm.loader.d.a<T> gjo;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> gjp;
    
    a()
    {
      this.gjd = localObject1.giS;
      Object localObject2 = localObject1.giT;
      if (localObject2 == null) {
        k.aPZ("builder_diskCache");
      }
      this.gje = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.giU;
      if (localObject2 == null) {
        k.aPZ("builder_dataFetcher");
      }
      this.gjf = ((com.tencent.mm.loader.d.b)localObject2);
      this.gjg = localObject1.aha();
      this.gjh = localObject1.giV;
      this.gji = localObject1.giX;
      this.gjj = localObject1.giR;
      this.gjk = localObject1.gjb;
      this.gjl = localObject1.giZ;
      this.gjm = localObject1.gja;
      this.gjn = localObject1.giY;
      this.gjo = localObject1.gjc;
      this.gjp = localObject1.gik;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> ahc()
    {
      return this.gjd;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> ahd()
    {
      return this.gje;
    }
    
    public final com.tencent.mm.loader.d.b<T> ahe()
    {
      return this.gjf;
    }
    
    public final com.tencent.mm.loader.d.d<R> ahf()
    {
      return this.gjg;
    }
    
    public final f ahg()
    {
      return this.gjh;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> ahh()
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
    
    public final com.tencent.mm.loader.d.a<T> ahn()
    {
      return this.gjo;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aho()
    {
      return this.gjp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */