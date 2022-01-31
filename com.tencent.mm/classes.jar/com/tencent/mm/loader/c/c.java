package com.tencent.mm.loader.c;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "imageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "imageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "imageFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "libimageloader_release"})
public final class c
  implements d<String, Bitmap>
{
  public final com.tencent.mm.loader.b.b.d<String, Bitmap> Tc()
  {
    return (com.tencent.mm.loader.b.b.d)new com.tencent.mm.loader.b.b.b();
  }
  
  public final com.tencent.mm.loader.b.a.d<String, Bitmap> Td()
  {
    return (com.tencent.mm.loader.b.a.d)new com.tencent.mm.loader.b.a.b();
  }
  
  public final com.tencent.mm.loader.d.b<String> Te()
  {
    return (com.tencent.mm.loader.d.b)new com.tencent.mm.loader.e.b();
  }
  
  public final com.tencent.mm.loader.d.d<Bitmap> Tf()
  {
    return (com.tencent.mm.loader.d.d)new com.tencent.mm.loader.e.a.a();
  }
  
  public final f Tg()
  {
    return (f)new com.tencent.mm.loader.e.a();
  }
  
  public final com.tencent.mm.loader.e.c.a<Bitmap> Th()
  {
    return null;
  }
  
  public final e Ti()
  {
    e locale = e.To();
    j.p(locale, "ImageLoaderOptions.createSimpleOption()");
    return locale;
  }
  
  public final com.tencent.mm.loader.f.e Tj()
  {
    return (com.tencent.mm.loader.f.e)new g();
  }
  
  public final com.tencent.mm.loader.d.c Tk()
  {
    return null;
  }
  
  public final com.tencent.mm.loader.f.b Tl()
  {
    return (com.tencent.mm.loader.f.b)new com.tencent.mm.loader.e.c();
  }
  
  public final com.tencent.mm.loader.d.e Tm()
  {
    return (com.tencent.mm.loader.d.e)new com.tencent.mm.loader.e.e();
  }
  
  public final com.tencent.mm.loader.d.a<String> Tn()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.c.c
 * JD-Core Version:    0.7.0.1
 */