package com.davemorrissey.labs.subscaleview.legacy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.model.IBitmapLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.ILoadable;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class LegacyBitmapLoaderFactory
  implements IBitmapLoaderFactory
{
  public final ILoadable newInstance(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory, Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(157355);
    paramSubsamplingScaleImageView = new BitmapLoaderWrapper(paramSubsamplingScaleImageView, paramContext, paramDecoderFactory, paramUri, paramBoolean);
    AppMethodBeat.o(157355);
    return paramSubsamplingScaleImageView;
  }
  
  static final class BitmapLoaderWrapper
    extends AsyncTask<Void, Void, Integer>
    implements ILoadable
  {
    private Bitmap bitmap;
    private final WeakReference<Context> contextRef;
    private ImageDecodeResult decodeResult;
    private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
    private Exception exception;
    private Rect mRect;
    private long mStartLoadTime;
    private final boolean preview;
    private final Uri source;
    private final WeakReference<SubsamplingScaleImageView> viewRef;
    
    /* Error */
    BitmapLoaderWrapper(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory, Uri paramUri, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	android/os/AsyncTask:<init>	()V
      //   4: ldc 39
      //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: ldc2_w 46
      //   13: putfield 49	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:mStartLoadTime	J
      //   16: aload_0
      //   17: new 51	java/lang/ref/WeakReference
      //   20: dup
      //   21: aload_1
      //   22: invokespecial 54	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   25: putfield 56	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:viewRef	Ljava/lang/ref/WeakReference;
      //   28: aload_0
      //   29: new 51	java/lang/ref/WeakReference
      //   32: dup
      //   33: aload_2
      //   34: invokespecial 54	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   37: putfield 58	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:contextRef	Ljava/lang/ref/WeakReference;
      //   40: aload_0
      //   41: new 51	java/lang/ref/WeakReference
      //   44: dup
      //   45: aload_3
      //   46: invokespecial 54	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   49: putfield 60	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:decoderFactoryRef	Ljava/lang/ref/WeakReference;
      //   52: aload_0
      //   53: aload 4
      //   55: putfield 62	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:source	Landroid/net/Uri;
      //   58: aload_0
      //   59: iload 5
      //   61: putfield 64	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:preview	Z
      //   64: new 66	android/graphics/BitmapFactory$Options
      //   67: dup
      //   68: invokespecial 67	android/graphics/BitmapFactory$Options:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: iconst_1
      //   74: putfield 70	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   77: aload 4
      //   79: aconst_null
      //   80: invokestatic 76	com/tencent/mm/vfs/y:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/k$f;)Ljava/io/InputStream;
      //   83: astore_3
      //   84: aload_3
      //   85: aconst_null
      //   86: aload_1
      //   87: invokestatic 82	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   90: pop
      //   91: aload_3
      //   92: ifnull +7 -> 99
      //   95: aload_3
      //   96: invokevirtual 87	java/io/InputStream:close	()V
      //   99: aload_0
      //   100: new 89	android/graphics/Rect
      //   103: dup
      //   104: iconst_0
      //   105: iconst_0
      //   106: aload_1
      //   107: getfield 93	android/graphics/BitmapFactory$Options:outWidth	I
      //   110: aload_1
      //   111: getfield 96	android/graphics/BitmapFactory$Options:outHeight	I
      //   114: invokespecial 99	android/graphics/Rect:<init>	(IIII)V
      //   117: putfield 101	com/davemorrissey/labs/subscaleview/legacy/LegacyBitmapLoaderFactory$BitmapLoaderWrapper:mRect	Landroid/graphics/Rect;
      //   120: ldc 39
      //   122: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: return
      //   126: astore_2
      //   127: aload_3
      //   128: ifnull +7 -> 135
      //   131: aload_3
      //   132: invokevirtual 87	java/io/InputStream:close	()V
      //   135: ldc 39
      //   137: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   140: aload_2
      //   141: athrow
      //   142: astore_2
      //   143: ldc 106
      //   145: aload_2
      //   146: ldc 108
      //   148: iconst_1
      //   149: anewarray 110	java/lang/Object
      //   152: dup
      //   153: iconst_0
      //   154: aload 4
      //   156: invokevirtual 116	android/net/Uri:toString	()Ljava/lang/String;
      //   159: aastore
      //   160: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   163: goto -64 -> 99
      //   166: astore_3
      //   167: aload_2
      //   168: aload_3
      //   169: invokevirtual 128	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   172: goto -37 -> 135
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	175	0	this	BitmapLoaderWrapper
      //   0	175	1	paramSubsamplingScaleImageView	SubsamplingScaleImageView
      //   0	175	2	paramContext	Context
      //   0	175	3	paramDecoderFactory	DecoderFactory<? extends ImageRegionDecoder>
      //   0	175	4	paramUri	Uri
      //   0	175	5	paramBoolean	boolean
      // Exception table:
      //   from	to	target	type
      //   84	91	126	finally
      //   77	84	142	java/io/IOException
      //   95	99	142	java/io/IOException
      //   135	142	142	java/io/IOException
      //   167	172	142	java/io/IOException
      //   131	135	166	finally
    }
    
    private Integer duc()
    {
      AppMethodBeat.i(157350);
      Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
      if (this.preview) {
        this.mStartLoadTime = System.currentTimeMillis();
      }
      try
      {
        Context localContext = (Context)this.contextRef.get();
        Object localObject = (DecoderFactory)this.decoderFactoryRef.get();
        SubsamplingScaleImageView localSubsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
        if ((localContext != null) && (localObject != null) && (localSubsamplingScaleImageView != null))
        {
          localSubsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
          localObject = (ImageRegionDecoder)((DecoderFactory)localObject).make();
          ((ImageRegionDecoder)localObject).init(localContext, this.source);
          this.bitmap = ((ImageRegionDecoder)localObject).decodeRegion(this.mRect, 1);
          int i = localSubsamplingScaleImageView.getExifOrientation(localContext, this.source);
          ((ImageRegionDecoder)localObject).recycle();
          onEnd(localSubsamplingScaleImageView);
          AppMethodBeat.o(157350);
          return Integer.valueOf(i);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localFileNotFoundException, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
        this.exception = localFileNotFoundException;
        this.decodeResult = new ImageDecodeResult(1, "tile init file not found");
        onEnd((SubsamplingScaleImageView)this.viewRef.get());
        AppMethodBeat.o(157350);
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localException, "Failed to load bitmap", new Object[0]);
          this.exception = localException;
          this.decodeResult = new ImageDecodeResult(2, "bitmap decode failed");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", localOutOfMemoryError, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
          this.exception = new RuntimeException(localOutOfMemoryError);
          this.decodeResult = new ImageDecodeResult(3, "bitmap decode OutOfMemoryError");
          SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
        }
      }
    }
    
    private void onEnd(SubsamplingScaleImageView paramSubsamplingScaleImageView)
    {
      AppMethodBeat.i(157351);
      if ((paramSubsamplingScaleImageView != null) && (this.preview) && (this.mStartLoadTime != -1L))
      {
        Log.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        paramSubsamplingScaleImageView.addPreviewLoadedTime((int)(System.currentTimeMillis() - this.mStartLoadTime));
      }
      AppMethodBeat.o(157351);
    }
    
    public final void cancel() {}
    
    public final void startLoad()
    {
      AppMethodBeat.i(157352);
      executeOnExecutor(((SubsamplingScaleImageView)this.viewRef.get()).executor, new Void[0]);
      AppMethodBeat.o(157352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.legacy.LegacyBitmapLoaderFactory
 * JD-Core Version:    0.7.0.1
 */