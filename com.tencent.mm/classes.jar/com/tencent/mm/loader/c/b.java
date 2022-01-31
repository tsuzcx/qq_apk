package com.tencent.mm.loader.c;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", "listener", "libimageloader_release"})
public class b<T, R>
{
  public f eNA;
  protected com.tencent.mm.loader.d.d<R> eNB;
  com.tencent.mm.loader.e.c.a<R> eNC;
  com.tencent.mm.loader.d.e eND;
  com.tencent.mm.loader.d.c eNE;
  com.tencent.mm.loader.f.b eNF;
  com.tencent.mm.loader.f.e eNG;
  com.tencent.mm.loader.d.a<T> eNH;
  public e eNw;
  public com.tencent.mm.loader.b.b.d<T, R> eNx;
  public com.tencent.mm.loader.b.a.d<T, R> eNy;
  public com.tencent.mm.loader.d.b<T> eNz;
  
  public b()
  {
    e locale = e.To();
    j.p(locale, "ImageLoaderOptions.createSimpleOption()");
    this.eNw = locale;
    this.eNx = ((com.tencent.mm.loader.b.b.d)new com.tencent.mm.loader.b.b.c());
    this.eNA = ((f)new com.tencent.mm.loader.e.a());
    this.eND = ((com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e());
    this.eNF = ((com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c());
    this.eNG = ((com.tencent.mm.loader.f.e)new g());
  }
  
  protected final com.tencent.mm.loader.d.d<R> Tb()
  {
    com.tencent.mm.loader.d.d locald = this.eNB;
    if (locald == null) {
      j.ays("imageProducer");
    }
    return locald;
  }
  
  protected final void a(com.tencent.mm.loader.d.d<R> paramd)
  {
    j.q(paramd, "<set-?>");
    this.eNB = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */