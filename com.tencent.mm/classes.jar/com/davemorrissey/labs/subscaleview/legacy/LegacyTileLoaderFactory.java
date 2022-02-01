package com.davemorrissey.labs.subscaleview.legacy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.model.ILoadable;
import com.davemorrissey.labs.subscaleview.model.ITileLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.Tile;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class LegacyTileLoaderFactory
  implements ITileLoaderFactory
{
  public final ILoadable newInstance(SubsamplingScaleImageView paramSubsamplingScaleImageView, ImageRegionDecoder paramImageRegionDecoder, Tile paramTile)
  {
    AppMethodBeat.i(157370);
    paramSubsamplingScaleImageView = new LegacyTileLoadTaskWrapper(paramSubsamplingScaleImageView, paramImageRegionDecoder, paramTile);
    AppMethodBeat.o(157370);
    return paramSubsamplingScaleImageView;
  }
  
  static final class LegacyTileLoadTaskWrapper
    extends AsyncTask<Void, Void, Bitmap>
    implements ILoadable
  {
    private ImageDecodeResult decodeResult;
    private final WeakReference<ImageRegionDecoder> decoderRef;
    private Exception exception;
    private boolean isCancelled;
    private long mStartTime;
    private final WeakReference<Tile> tileRef;
    private final WeakReference<SubsamplingScaleImageView> viewRef;
    
    LegacyTileLoadTaskWrapper(SubsamplingScaleImageView paramSubsamplingScaleImageView, ImageRegionDecoder paramImageRegionDecoder, Tile paramTile)
    {
      AppMethodBeat.i(157363);
      this.mStartTime = -1L;
      this.isCancelled = false;
      this.viewRef = new WeakReference(paramSubsamplingScaleImageView);
      this.decoderRef = new WeakReference(paramImageRegionDecoder);
      this.tileRef = new WeakReference(paramTile);
      paramTile.loading = true;
      AppMethodBeat.o(157363);
    }
    
    /* Error */
    private Bitmap gUg()
    {
      // Byte code:
      //   0: ldc 70
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 50	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:viewRef	Ljava/lang/ref/WeakReference;
      //   9: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   12: ifnull +49 -> 61
      //   15: aload_0
      //   16: getfield 54	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:tileRef	Ljava/lang/ref/WeakReference;
      //   19: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   22: ifnull +39 -> 61
      //   25: aload_0
      //   26: getfield 50	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:viewRef	Ljava/lang/ref/WeakReference;
      //   29: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   32: checkcast 76	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
      //   35: invokevirtual 80	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getFullImageSampleSize	()I
      //   38: aload_0
      //   39: getfield 54	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:tileRef	Ljava/lang/ref/WeakReference;
      //   42: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   45: checkcast 56	com/davemorrissey/labs/subscaleview/model/Tile
      //   48: getfield 84	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
      //   51: if_icmpne +10 -> 61
      //   54: aload_0
      //   55: invokestatic 90	java/lang/System:currentTimeMillis	()J
      //   58: putfield 41	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:mStartTime	J
      //   61: aload_0
      //   62: getfield 50	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:viewRef	Ljava/lang/ref/WeakReference;
      //   65: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   68: checkcast 76	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
      //   71: astore_1
      //   72: aload_0
      //   73: getfield 52	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:decoderRef	Ljava/lang/ref/WeakReference;
      //   76: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   79: checkcast 92	com/davemorrissey/labs/subscaleview/decoder/ImageRegionDecoder
      //   82: astore_3
      //   83: aload_0
      //   84: getfield 54	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:tileRef	Ljava/lang/ref/WeakReference;
      //   87: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   90: checkcast 56	com/davemorrissey/labs/subscaleview/model/Tile
      //   93: astore_2
      //   94: aload_3
      //   95: ifnull +494 -> 589
      //   98: aload_2
      //   99: ifnull +490 -> 589
      //   102: aload_1
      //   103: ifnull +486 -> 589
      //   106: aload_3
      //   107: invokeinterface 96 1 0
      //   112: ifeq +477 -> 589
      //   115: aload_2
      //   116: getfield 99	com/davemorrissey/labs/subscaleview/model/Tile:visible	Z
      //   119: ifeq +470 -> 589
      //   122: ldc 101
      //   124: ldc 103
      //   126: iconst_2
      //   127: anewarray 105	java/lang/Object
      //   130: dup
      //   131: iconst_0
      //   132: aload_2
      //   133: getfield 109	com/davemorrissey/labs/subscaleview/model/Tile:sRect	Landroid/graphics/Rect;
      //   136: aastore
      //   137: dup
      //   138: iconst_1
      //   139: aload_2
      //   140: getfield 84	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
      //   143: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   146: aastore
      //   147: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: aload_1
      //   151: invokevirtual 125	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
      //   154: invokeinterface 131 1 0
      //   159: invokeinterface 136 1 0
      //   164: aload_3
      //   165: invokeinterface 96 1 0
      //   170: ifeq +348 -> 518
      //   173: aload_2
      //   174: getfield 109	com/davemorrissey/labs/subscaleview/model/Tile:sRect	Landroid/graphics/Rect;
      //   177: astore 4
      //   179: aload_2
      //   180: getfield 139	com/davemorrissey/labs/subscaleview/model/Tile:fileSRect	Landroid/graphics/Rect;
      //   183: astore 5
      //   185: aload_1
      //   186: invokevirtual 142	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
      //   189: ifne +101 -> 290
      //   192: aload 5
      //   194: aload 4
      //   196: invokevirtual 148	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
      //   199: aload_1
      //   200: invokevirtual 152	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
      //   203: ifnull +24 -> 227
      //   206: aload_2
      //   207: getfield 139	com/davemorrissey/labs/subscaleview/model/Tile:fileSRect	Landroid/graphics/Rect;
      //   210: aload_1
      //   211: invokevirtual 152	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
      //   214: getfield 155	android/graphics/Rect:left	I
      //   217: aload_1
      //   218: invokevirtual 152	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
      //   221: getfield 158	android/graphics/Rect:top	I
      //   224: invokevirtual 162	android/graphics/Rect:offset	(II)V
      //   227: ldc 101
      //   229: ldc 164
      //   231: iconst_1
      //   232: anewarray 105	java/lang/Object
      //   235: dup
      //   236: iconst_0
      //   237: aload_2
      //   238: getfield 84	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
      //   241: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   244: aastore
      //   245: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   248: aload_3
      //   249: aload_2
      //   250: getfield 139	com/davemorrissey/labs/subscaleview/model/Tile:fileSRect	Landroid/graphics/Rect;
      //   253: aload_2
      //   254: getfield 84	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
      //   257: invokeinterface 168 3 0
      //   262: astore_3
      //   263: aload_0
      //   264: aload_1
      //   265: aload_2
      //   266: invokespecial 172	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:onEnd	(Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView;Lcom/davemorrissey/labs/subscaleview/model/Tile;)V
      //   269: aload_1
      //   270: invokevirtual 125	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
      //   273: invokeinterface 131 1 0
      //   278: invokeinterface 175 1 0
      //   283: ldc 70
      //   285: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   288: aload_3
      //   289: areturn
      //   290: aload_1
      //   291: invokevirtual 142	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
      //   294: bipush 90
      //   296: if_icmpne +126 -> 422
      //   299: aload 5
      //   301: aload 4
      //   303: getfield 158	android/graphics/Rect:top	I
      //   306: aload_1
      //   307: getfield 178	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sHeight	I
      //   310: aload 4
      //   312: getfield 181	android/graphics/Rect:right	I
      //   315: isub
      //   316: aload 4
      //   318: getfield 184	android/graphics/Rect:bottom	I
      //   321: aload_1
      //   322: getfield 178	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sHeight	I
      //   325: aload 4
      //   327: getfield 155	android/graphics/Rect:left	I
      //   330: isub
      //   331: invokevirtual 187	android/graphics/Rect:set	(IIII)V
      //   334: goto -135 -> 199
      //   337: astore_2
      //   338: aload_1
      //   339: invokevirtual 125	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
      //   342: invokeinterface 131 1 0
      //   347: invokeinterface 175 1 0
      //   352: ldc 70
      //   354: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   357: aload_2
      //   358: athrow
      //   359: astore_1
      //   360: ldc 101
      //   362: aload_1
      //   363: ldc 189
      //   365: iconst_0
      //   366: anewarray 105	java/lang/Object
      //   369: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   372: aload_0
      //   373: aload_1
      //   374: putfield 195	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:exception	Ljava/lang/Exception;
      //   377: aload_0
      //   378: new 197	com/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult
      //   381: dup
      //   382: iconst_5
      //   383: ldc 199
      //   385: invokespecial 202	com/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult:<init>	(ILjava/lang/String;)V
      //   388: putfield 204	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:decodeResult	Lcom/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult;
      //   391: aload_0
      //   392: aload_0
      //   393: getfield 50	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:viewRef	Ljava/lang/ref/WeakReference;
      //   396: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   399: checkcast 76	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
      //   402: aload_0
      //   403: getfield 54	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:tileRef	Ljava/lang/ref/WeakReference;
      //   406: invokevirtual 74	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   409: checkcast 56	com/davemorrissey/labs/subscaleview/model/Tile
      //   412: invokespecial 172	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:onEnd	(Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView;Lcom/davemorrissey/labs/subscaleview/model/Tile;)V
      //   415: ldc 70
      //   417: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   420: aconst_null
      //   421: areturn
      //   422: aload_1
      //   423: invokevirtual 142	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
      //   426: sipush 180
      //   429: if_icmpne +51 -> 480
      //   432: aload 5
      //   434: aload_1
      //   435: getfield 207	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sWidth	I
      //   438: aload 4
      //   440: getfield 181	android/graphics/Rect:right	I
      //   443: isub
      //   444: aload_1
      //   445: getfield 178	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sHeight	I
      //   448: aload 4
      //   450: getfield 184	android/graphics/Rect:bottom	I
      //   453: isub
      //   454: aload_1
      //   455: getfield 207	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sWidth	I
      //   458: aload 4
      //   460: getfield 155	android/graphics/Rect:left	I
      //   463: isub
      //   464: aload_1
      //   465: getfield 178	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sHeight	I
      //   468: aload 4
      //   470: getfield 158	android/graphics/Rect:top	I
      //   473: isub
      //   474: invokevirtual 187	android/graphics/Rect:set	(IIII)V
      //   477: goto -278 -> 199
      //   480: aload 5
      //   482: aload_1
      //   483: getfield 207	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sWidth	I
      //   486: aload 4
      //   488: getfield 184	android/graphics/Rect:bottom	I
      //   491: isub
      //   492: aload 4
      //   494: getfield 155	android/graphics/Rect:left	I
      //   497: aload_1
      //   498: getfield 207	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:sWidth	I
      //   501: aload 4
      //   503: getfield 158	android/graphics/Rect:top	I
      //   506: isub
      //   507: aload 4
      //   509: getfield 181	android/graphics/Rect:right	I
      //   512: invokevirtual 187	android/graphics/Rect:set	(IIII)V
      //   515: goto -316 -> 199
      //   518: aload_2
      //   519: iconst_0
      //   520: putfield 59	com/davemorrissey/labs/subscaleview/model/Tile:loading	Z
      //   523: aload_1
      //   524: invokevirtual 125	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
      //   527: invokeinterface 131 1 0
      //   532: invokeinterface 175 1 0
      //   537: goto -146 -> 391
      //   540: astore_1
      //   541: ldc 101
      //   543: aload_1
      //   544: ldc 209
      //   546: iconst_0
      //   547: anewarray 105	java/lang/Object
      //   550: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   553: aload_0
      //   554: new 211	java/lang/RuntimeException
      //   557: dup
      //   558: aload_1
      //   559: invokespecial 214	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   562: putfield 195	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:exception	Ljava/lang/Exception;
      //   565: aload_0
      //   566: new 197	com/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult
      //   569: dup
      //   570: bipush 6
      //   572: ldc 216
      //   574: invokespecial 202	com/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult:<init>	(ILjava/lang/String;)V
      //   577: putfield 204	com/davemorrissey/labs/subscaleview/legacy/LegacyTileLoaderFactory$LegacyTileLoadTaskWrapper:decodeResult	Lcom/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult;
      //   580: getstatic 222	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   583: invokestatic 226	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:setPreferredBitmapConfig	(Landroid/graphics/Bitmap$Config;)V
      //   586: goto -195 -> 391
      //   589: aload_2
      //   590: ifnull -199 -> 391
      //   593: aload_2
      //   594: iconst_0
      //   595: putfield 59	com/davemorrissey/labs/subscaleview/model/Tile:loading	Z
      //   598: goto -207 -> 391
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	601	0	this	LegacyTileLoadTaskWrapper
      //   71	268	1	localSubsamplingScaleImageView	SubsamplingScaleImageView
      //   359	165	1	localException	Exception
      //   540	19	1	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   93	173	2	localTile	Tile
      //   337	257	2	localObject1	Object
      //   82	207	3	localObject2	Object
      //   177	331	4	localRect1	android.graphics.Rect
      //   183	298	5	localRect2	android.graphics.Rect
      // Exception table:
      //   from	to	target	type
      //   164	199	337	finally
      //   199	227	337	finally
      //   227	269	337	finally
      //   290	334	337	finally
      //   422	477	337	finally
      //   480	515	337	finally
      //   518	523	337	finally
      //   61	94	359	java/lang/Exception
      //   106	164	359	java/lang/Exception
      //   269	283	359	java/lang/Exception
      //   338	359	359	java/lang/Exception
      //   523	537	359	java/lang/Exception
      //   593	598	359	java/lang/Exception
      //   61	94	540	java/lang/OutOfMemoryError
      //   106	164	540	java/lang/OutOfMemoryError
      //   269	283	540	java/lang/OutOfMemoryError
      //   338	359	540	java/lang/OutOfMemoryError
      //   523	537	540	java/lang/OutOfMemoryError
      //   593	598	540	java/lang/OutOfMemoryError
    }
    
    private void onEnd(SubsamplingScaleImageView paramSubsamplingScaleImageView, Tile paramTile)
    {
      AppMethodBeat.i(157365);
      if ((paramSubsamplingScaleImageView != null) && (paramTile != null) && (this.mStartTime != -1L) && (paramSubsamplingScaleImageView.getFullImageSampleSize() == paramTile.sampleSize)) {
        paramSubsamplingScaleImageView.addTileDecodeTime((int)(System.currentTimeMillis() - this.mStartTime));
      }
      AppMethodBeat.o(157365);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(157367);
      try
      {
        cancel(true);
        this.isCancelled = true;
        AppMethodBeat.o(157367);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", localException, "alvinluo TileLoaderTask cancel exception", new Object[0]);
        AppMethodBeat.o(157367);
      }
    }
    
    public final void startLoad()
    {
      AppMethodBeat.i(157366);
      executeOnExecutor(((SubsamplingScaleImageView)this.viewRef.get()).executor, new Void[0]);
      AppMethodBeat.o(157366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.legacy.LegacyTileLoaderFactory
 * JD-Core Version:    0.7.0.1
 */