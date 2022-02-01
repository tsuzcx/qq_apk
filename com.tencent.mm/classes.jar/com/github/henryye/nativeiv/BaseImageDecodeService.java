package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.Keep;
import android.util.Base64;
import com.github.henryye.nativeiv.a.c.a;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Keep
public class BaseImageDecodeService
  implements IImageDecodeService
{
  private static final String TAG = "BaseImageDecodeService";
  private IImageDecodeService.b mCompactDecodeEventListener;
  private List<IImageDecodeService.b> mDecodeEventListeners;
  private IImageDecodeService.a mDecodeSlave;
  private com.github.henryye.nativeiv.b.b mFallbackImageStreamFetcher;
  private com.github.henryye.nativeiv.b.a mHttpImageStreamFetcher;
  private LinkedList<com.github.henryye.nativeiv.b.b> mImageStreamFetcherList;
  private boolean mIsTrackInitImages;
  
  public BaseImageDecodeService()
  {
    AppMethodBeat.i(127304);
    this.mIsTrackInitImages = false;
    this.mDecodeSlave = null;
    this.mDecodeEventListeners = new LinkedList();
    this.mCompactDecodeEventListener = new a((byte)0);
    this.mHttpImageStreamFetcher = new com.github.henryye.nativeiv.b.a();
    this.mImageStreamFetcherList = new LinkedList();
    addImageStreamFetcher(this.mHttpImageStreamFetcher, false);
    setBitmapDecodeSlave(new a());
    AppMethodBeat.o(127304);
  }
  
  private Bitmap.CompressFormat ensureCompressFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Bitmap.CompressFormat.PNG;
    case 1: 
      return Bitmap.CompressFormat.WEBP;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  private Bitmap.CompressFormat ensureCompressFormat(String paramString)
  {
    AppMethodBeat.i(127307);
    if ("image/webp".equals(paramString))
    {
      paramString = Bitmap.CompressFormat.WEBP;
      AppMethodBeat.o(127307);
      return paramString;
    }
    if (("image/jpeg".equals(paramString)) || ("image/jpg".equals(paramString)))
    {
      paramString = Bitmap.CompressFormat.JPEG;
      AppMethodBeat.o(127307);
      return paramString;
    }
    paramString = Bitmap.CompressFormat.PNG;
    AppMethodBeat.o(127307);
    return paramString;
  }
  
  private int ensureQuality(float paramFloat)
  {
    float f;
    if (paramFloat >= 0.0F)
    {
      f = paramFloat;
      if (paramFloat <= 1.0F) {}
    }
    else
    {
      f = 0.92F;
    }
    return (int)(100.0F * f);
  }
  
  private void runInThreadPool(Object paramObject, Runnable paramRunnable)
  {
    AppMethodBeat.i(127317);
    if (this.mHttpImageStreamFetcher.accept(paramObject))
    {
      d.baC.baE.execute(paramRunnable);
      AppMethodBeat.o(127317);
      return;
    }
    d.baC.baF.execute(paramRunnable);
    AppMethodBeat.o(127317);
  }
  
  public void addDecodeEventListener(IImageDecodeService.b paramb)
  {
    AppMethodBeat.i(127321);
    this.mDecodeEventListeners.add(paramb);
    AppMethodBeat.o(127321);
  }
  
  public void addImageStreamFetcher(com.github.henryye.nativeiv.b.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(127318);
    com.github.henryye.nativeiv.a.b.i("BaseImageDecodeService", "hy: %d adding stream fetcher: %s %b", new Object[] { Integer.valueOf(hashCode()), paramb.getClass().getSimpleName(), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.mImageStreamFetcherList.push(paramb);
      AppMethodBeat.o(127318);
      return;
    }
    this.mFallbackImageStreamFetcher = paramb;
    AppMethodBeat.o(127318);
  }
  
  public String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(127308);
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(127308);
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = ensureCompressFormat(paramInt);
    paramInt = ensureQuality(paramFloat);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.close();
      if ((!bool) || (localByteArrayOutputStream.size() <= 0))
      {
        com.github.henryye.nativeiv.a.b.e("BaseImageDecodeService", "base64_encode Bitmap compress error.", new Object[0]);
        AppMethodBeat.o(127308);
        return null;
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        com.github.henryye.nativeiv.a.b.e("BaseImageDecodeService", "base64_encode IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      paramBitmap = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      AppMethodBeat.o(127308);
    }
    return paramBitmap;
  }
  
  public byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(127309);
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(127309);
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = ensureCompressFormat(paramInt);
    paramInt = ensureQuality(paramFloat);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.close();
      if ((!bool) || (localByteArrayOutputStream.size() <= 0))
      {
        com.github.henryye.nativeiv.a.b.e("BaseImageDecodeService", "encodeToBuffer Bitmap compress error.", new Object[0]);
        AppMethodBeat.o(127309);
        return null;
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        com.github.henryye.nativeiv.a.b.e("BaseImageDecodeService", "encodeToBuffer IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      paramBitmap = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(127309);
    }
    return paramBitmap;
  }
  
  public void forceSetUseType(BitmapType paramBitmapType)
  {
    AppMethodBeat.i(127325);
    this.mDecodeSlave.forceSetUseType(paramBitmapType);
    AppMethodBeat.o(127325);
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127306);
    Bitmap localBitmap = e.sR().baK.aX(paramInt1, paramInt2);
    AppMethodBeat.o(127306);
    return localBitmap;
  }
  
  public void init() {}
  
  public void loadBitmapAsync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127316);
    ImageDecodeConfig localImageDecodeConfig = paramImageDecodeConfig;
    if (paramImageDecodeConfig == null) {
      localImageDecodeConfig = new ImageDecodeConfig();
    }
    runInThreadPool(paramObject, new c(this, paramObject, localImageDecodeConfig));
    AppMethodBeat.o(127316);
  }
  
  public void loadBitmapAsync(String paramString)
  {
    AppMethodBeat.i(127314);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(127314);
      return;
    }
    loadBitmapAsync(paramString, new ImageDecodeConfig());
    AppMethodBeat.o(127314);
  }
  
  public void loadBitmapAsync(String paramString, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127315);
    loadBitmapAsync(paramString, paramImageDecodeConfig);
    AppMethodBeat.o(127315);
  }
  
  public IBitmap loadBitmapSync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127311);
    ImageDecodeConfig localImageDecodeConfig = paramImageDecodeConfig;
    if (paramImageDecodeConfig == null) {
      localImageDecodeConfig = new ImageDecodeConfig();
    }
    Object localObject = this.mImageStreamFetcherList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramImageDecodeConfig = (com.github.henryye.nativeiv.b.b)((Iterator)localObject).next();
    } while (!paramImageDecodeConfig.accept(paramObject));
    for (;;)
    {
      localObject = paramImageDecodeConfig;
      if (paramImageDecodeConfig == null) {
        localObject = this.mFallbackImageStreamFetcher;
      }
      if (localObject == null)
      {
        com.github.henryye.nativeiv.a.b.e("BaseImageDecodeService", "No fit image stream fetcher found for %s", new Object[] { paramObject.toString() });
        AppMethodBeat.o(127311);
        return null;
      }
      paramImageDecodeConfig = this.mDecodeSlave;
      if ((paramImageDecodeConfig == null) || (paramImageDecodeConfig.isDestroyed()))
      {
        com.github.henryye.nativeiv.a.b.w("BaseImageDecodeService", "BitmapDecodeSlave destroyed", new Object[0]);
        AppMethodBeat.o(127311);
        return null;
      }
      paramObject = paramImageDecodeConfig.a(paramObject.toString(), paramObject, (com.github.henryye.nativeiv.b.b)localObject, localImageDecodeConfig);
      AppMethodBeat.o(127311);
      return paramObject;
      paramImageDecodeConfig = null;
    }
  }
  
  public IBitmap loadBitmapSync(String paramString)
  {
    AppMethodBeat.i(127312);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(127312);
      return null;
    }
    paramString = loadBitmapSync(paramString, new ImageDecodeConfig());
    AppMethodBeat.o(127312);
    return paramString;
  }
  
  public IBitmap loadBitmapSync(String paramString, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127313);
    paramString = loadBitmapSync(paramString, paramImageDecodeConfig);
    AppMethodBeat.o(127313);
    return paramString;
  }
  
  public void release()
  {
    AppMethodBeat.i(127305);
    if (this.mDecodeSlave != null)
    {
      this.mDecodeSlave.destroy();
      this.mDecodeSlave = null;
    }
    AppMethodBeat.o(127305);
  }
  
  public void releaseBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(127310);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(127310);
      return;
    }
    com.github.henryye.nativeiv.a.b.i("BaseImageDecodeService", "recycle because releaseBitmap", new Object[0]);
    paramBitmap.recycle();
    AppMethodBeat.o(127310);
  }
  
  public void removeDecodeEventListener(IImageDecodeService.b paramb)
  {
    AppMethodBeat.i(127322);
    this.mDecodeEventListeners.remove(paramb);
    AppMethodBeat.o(127322);
  }
  
  public void removeImageStreamFetcher(com.github.henryye.nativeiv.b.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(127319);
    com.github.henryye.nativeiv.a.b.i("BaseImageDecodeService", "hy: %d removing stream fetcher: %s %b", new Object[] { Integer.valueOf(hashCode()), paramb.getClass().getSimpleName(), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.mImageStreamFetcherList.remove(paramb);
      AppMethodBeat.o(127319);
      return;
    }
    this.mFallbackImageStreamFetcher = null;
    AppMethodBeat.o(127319);
  }
  
  public void setBitmapDecodeSlave(IImageDecodeService.a parama)
  {
    AppMethodBeat.i(127320);
    this.mDecodeSlave = parama;
    this.mDecodeSlave.a(this.mCompactDecodeEventListener);
    AppMethodBeat.o(127320);
  }
  
  public void setIdKeyReportDelegate(c.a parama) {}
  
  public void setKvReportDelegate(c.b paramb) {}
  
  public void setMaxDecodeDimension(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127323);
    this.mDecodeSlave.aW(paramInt1, paramInt2);
    AppMethodBeat.o(127323);
  }
  
  public void setNetworkTimeout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127324);
    com.github.henryye.nativeiv.b.a locala = this.mHttpImageStreamFetcher;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(127324);
      return;
    }
    locala.bbs = paramInt1;
    locala.bbt = paramInt2;
    com.github.henryye.nativeiv.a.b.i("NativeImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(127324);
  }
  
  final class a
    implements IImageDecodeService.b
  {
    private a() {}
    
    public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
    {
      AppMethodBeat.i(127299);
      Iterator localIterator = BaseImageDecodeService.this.mDecodeEventListeners.iterator();
      while (localIterator.hasNext()) {
        ((IImageDecodeService.b)localIterator.next()).a(paramString, parama, parama1);
      }
      AppMethodBeat.o(127299);
    }
    
    public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(127300);
      Iterator localIterator = BaseImageDecodeService.this.mDecodeEventListeners.iterator();
      while (localIterator.hasNext()) {
        ((IImageDecodeService.b)localIterator.next()).a(paramString, paramObject, paramc, paramImageDecodeConfig);
      }
      AppMethodBeat.o(127300);
    }
  }
  
  public static final class b
    implements IImageDecodeService.c
  {
    public final void ad(Object paramObject)
    {
      AppMethodBeat.i(127301);
      if (paramObject != null) {
        ((IBitmap)paramObject).recycle();
      }
      AppMethodBeat.o(127301);
    }
  }
  
  static final class c
    implements Runnable
  {
    private Object bam;
    private ImageDecodeConfig ban;
    private WeakReference<BaseImageDecodeService> bao;
    private final BaseImageDecodeService.b bap;
    private volatile boolean ue;
    
    c(BaseImageDecodeService paramBaseImageDecodeService, Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
    {
      AppMethodBeat.i(127302);
      this.ue = false;
      this.bap = new BaseImageDecodeService.b();
      this.bam = paramObject;
      this.ban = paramImageDecodeConfig;
      this.bao = new WeakReference(paramBaseImageDecodeService);
      AppMethodBeat.o(127302);
    }
    
    public final void run()
    {
      AppMethodBeat.i(127303);
      if (this.ue)
      {
        AppMethodBeat.o(127303);
        return;
      }
      if (this.bao.get() == null)
      {
        AppMethodBeat.o(127303);
        return;
      }
      IBitmap localIBitmap = ((BaseImageDecodeService)this.bao.get()).loadBitmapSync(this.bam, this.ban);
      if (this.ue)
      {
        if (localIBitmap != null) {
          localIBitmap.recycle();
        }
        AppMethodBeat.o(127303);
        return;
      }
      ((BaseImageDecodeService)this.bao.get()).mCompactDecodeEventListener.a(this.bam.toString(), localIBitmap, this.bap, this.ban);
      AppMethodBeat.o(127303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService
 * JD-Core Version:    0.7.0.1
 */