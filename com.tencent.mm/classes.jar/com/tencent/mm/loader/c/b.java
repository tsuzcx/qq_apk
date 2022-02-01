package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R>
{
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hfs;
  e hgb;
  com.tencent.mm.loader.b.b.e<T, R> hgc;
  com.tencent.mm.loader.b.a.d<T, R> hgd;
  com.tencent.mm.loader.d.b<T> hge;
  g hgf;
  protected com.tencent.mm.loader.d.d<R> hgg;
  com.tencent.mm.loader.e.c.a<R> hgh;
  com.tencent.mm.loader.d.e hgi;
  com.tencent.mm.loader.d.c hgj;
  com.tencent.mm.loader.f.b hgk;
  com.tencent.mm.loader.f.f hgl;
  com.tencent.mm.loader.d.a<T> hgm;
  
  public b()
  {
    e.b localb = e.hgN;
    this.hgb = e.b.arv();
    this.hgc = ((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.c());
    this.hgf = ((g)new com.tencent.mm.loader.e.a());
    this.hgi = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.f());
    this.hgk = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.hgl = ((com.tencent.mm.loader.f.f)new h());
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.a.d<T, R> paramd)
  {
    p.h(paramd, "cache");
    this.hgd = paramd;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> parame)
  {
    p.h(parame, "cache");
    this.hgc = parame;
    return this;
  }
  
  public final b<T, R> a(com.tencent.mm.loader.d.b<T> paramb)
  {
    p.h(paramb, "downloader");
    this.hge = paramb;
    return this;
  }
  
  public final b<T, R> a(g paramg)
  {
    p.h(paramg, "creater");
    this.hgf = paramg;
    return this;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "<set-?>");
    this.hgg = paramd;
  }
  
  protected final com.tencent.mm.loader.d.d<R> are()
  {
    com.tencent.mm.loader.d.d locald = this.hgg;
    if (locald == null) {
      p.bdF("imageProducer");
    }
    return locald;
  }
  
  public final d<T, R> arf()
  {
    return (d)new a(this);
  }
  
  public final b<T, R> b(e parame)
  {
    p.h(parame, "options");
    this.hgb = parame;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.d.d<R> paramd)
  {
    p.h(paramd, "imageProducer");
    this.hgg = paramd;
    return this;
  }
  
  public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> paramb)
  {
    p.h(paramb, "transcoder");
    if (this.hgh == null) {
      this.hgh = new com.tencent.mm.loader.e.c.a(paramb);
    }
    com.tencent.mm.loader.e.c.a locala;
    do
    {
      return this;
      locala = this.hgh;
    } while (locala == null);
    locala.c(paramb);
    return this;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
  public static final class a
    implements d<T, R>
  {
    private com.tencent.mm.loader.b.b.e<T, R> hgn;
    private com.tencent.mm.loader.b.a.d<T, R> hgo;
    private com.tencent.mm.loader.d.b<T> hgp;
    private com.tencent.mm.loader.d.d<R> hgq;
    private g hgr;
    private com.tencent.mm.loader.e.c.a<R> hgs;
    private e hgt;
    private com.tencent.mm.loader.f.f hgu;
    private com.tencent.mm.loader.d.c hgv;
    private com.tencent.mm.loader.f.b hgw;
    private com.tencent.mm.loader.d.e hgx;
    private com.tencent.mm.loader.d.a<T> hgy;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hgz;
    
    a()
    {
      this.hgn = localObject1.hgc;
      Object localObject2 = localObject1.hgd;
      if (localObject2 == null) {
        p.bdF("builder_diskCache");
      }
      this.hgo = ((com.tencent.mm.loader.b.a.d)localObject2);
      localObject2 = localObject1.hge;
      if (localObject2 == null) {
        p.bdF("builder_dataFetcher");
      }
      this.hgp = ((com.tencent.mm.loader.d.b)localObject2);
      this.hgq = localObject1.are();
      this.hgr = localObject1.hgf;
      this.hgs = localObject1.hgh;
      this.hgt = localObject1.hgb;
      this.hgu = localObject1.hgl;
      this.hgv = localObject1.hgj;
      this.hgw = localObject1.hgk;
      this.hgx = localObject1.hgi;
      this.hgy = localObject1.hgm;
      this.hgz = localObject1.hfs;
    }
    
    public final com.tencent.mm.loader.b.b.e<T, R> arg()
    {
      return this.hgn;
    }
    
    public final com.tencent.mm.loader.b.a.d<T, R> arh()
    {
      return this.hgo;
    }
    
    public final com.tencent.mm.loader.d.b<T> ari()
    {
      return this.hgp;
    }
    
    public final com.tencent.mm.loader.d.d<R> arj()
    {
      return this.hgq;
    }
    
    public final g ark()
    {
      return this.hgr;
    }
    
    public final com.tencent.mm.loader.e.c.a<R> arl()
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
    
    public final com.tencent.mm.loader.d.a<T> arr()
    {
      return this.hgy;
    }
    
    public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> ars()
    {
      return this.hgz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */