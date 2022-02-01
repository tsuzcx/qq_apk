package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e
  implements d
{
  private final Bitmap.Config aEF;
  private BitmapRegionDecoder aWL;
  private final ReadWriteLock aWM;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    AppMethodBeat.i(157343);
    this.aWM = new ReentrantReadWriteLock(true);
    Bitmap.Config localConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
    if (localConfig != null)
    {
      this.aEF = localConfig;
      AppMethodBeat.o(157343);
      return;
    }
    this.aEF = Bitmap.Config.RGB_565;
    AppMethodBeat.o(157343);
  }
  
  private Lock rE()
  {
    AppMethodBeat.i(157348);
    if (Build.VERSION.SDK_INT < 21)
    {
      localLock = this.aWM.writeLock();
      AppMethodBeat.o(157348);
      return localLock;
    }
    Lock localLock = this.aWM.readLock();
    AppMethodBeat.o(157348);
    return localLock;
  }
  
  public final Bitmap a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(157345);
    rE().lock();
    try
    {
      if ((this.aWL == null) || (this.aWL.isRecycled())) {
        break label116;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      localOptions.inPreferredConfig = this.aEF;
      paramRect = this.aWL.decodeRegion(paramRect, localOptions);
      if (paramRect == null)
      {
        paramRect = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        AppMethodBeat.o(157345);
        throw paramRect;
      }
    }
    finally
    {
      rE().unlock();
      AppMethodBeat.o(157345);
    }
    rE().unlock();
    AppMethodBeat.o(157345);
    return paramRect;
    label116:
    paramRect = new IllegalStateException("Cannot decode region after decoder has been recycled");
    AppMethodBeat.o(157345);
    throw paramRect;
  }
  
  /* Error */
  public final android.graphics.Point c(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 120
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokevirtual 126	android/net/Uri:toString	()Ljava/lang/String;
    //   9: ldc 128
    //   11: invokevirtual 134	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +186 -> 200
    //   17: aload_2
    //   18: invokevirtual 137	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   21: astore 5
    //   23: aload_1
    //   24: invokevirtual 142	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: aload 5
    //   29: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +109 -> 141
    //   35: aload_1
    //   36: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: astore 4
    //   41: aload_2
    //   42: invokevirtual 154	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface 160 1 0
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_2
    //   55: if_icmpne +100 -> 155
    //   58: aload_2
    //   59: iconst_0
    //   60: invokeinterface 164 2 0
    //   65: checkcast 130	java/lang/String
    //   68: ldc 166
    //   70: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +82 -> 155
    //   76: aload 4
    //   78: aload_2
    //   79: iconst_1
    //   80: invokeinterface 164 2 0
    //   85: checkcast 130	java/lang/String
    //   88: ldc 166
    //   90: aload 5
    //   92: invokevirtual 172	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   95: istore_3
    //   96: aload_0
    //   97: aload_1
    //   98: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   101: iload_3
    //   102: invokevirtual 176	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   105: iconst_0
    //   106: invokestatic 180	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   109: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   112: new 182	android/graphics/Point
    //   115: dup
    //   116: aload_0
    //   117: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   120: invokevirtual 185	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   123: aload_0
    //   124: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   127: invokevirtual 188	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   130: invokespecial 191	android/graphics/Point:<init>	(II)V
    //   133: astore_1
    //   134: ldc 120
    //   136: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: areturn
    //   141: aload_1
    //   142: invokevirtual 195	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   145: aload 5
    //   147: invokevirtual 201	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   150: astore 4
    //   152: goto -111 -> 41
    //   155: iload_3
    //   156: iconst_1
    //   157: if_icmpne +38 -> 195
    //   160: aload_2
    //   161: iconst_0
    //   162: invokeinterface 164 2 0
    //   167: checkcast 203	java/lang/CharSequence
    //   170: invokestatic 209	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +22 -> 195
    //   176: aload_2
    //   177: iconst_0
    //   178: invokeinterface 164 2 0
    //   183: checkcast 130	java/lang/String
    //   186: iconst_0
    //   187: invokestatic 215	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   190: istore_3
    //   191: goto -95 -> 96
    //   194: astore_2
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -101 -> 96
    //   200: aload_2
    //   201: aconst_null
    //   202: invokestatic 221	com/tencent/mm/vfs/i:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/a$e;)Ljava/io/InputStream;
    //   205: astore 4
    //   207: aload_0
    //   208: aload 4
    //   210: iconst_0
    //   211: invokestatic 180	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   214: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   217: aload 4
    //   219: ifnull -107 -> 112
    //   222: aload 4
    //   224: invokevirtual 226	java/io/InputStream:close	()V
    //   227: goto -115 -> 112
    //   230: astore_2
    //   231: ldc 120
    //   233: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_2
    //   237: athrow
    //   238: astore_1
    //   239: aload 4
    //   241: ifnull +12 -> 253
    //   244: aload_2
    //   245: ifnull +26 -> 271
    //   248: aload 4
    //   250: invokevirtual 226	java/io/InputStream:close	()V
    //   253: ldc 120
    //   255: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_1
    //   259: athrow
    //   260: astore 4
    //   262: aload_2
    //   263: aload 4
    //   265: invokevirtual 230	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   268: goto -15 -> 253
    //   271: aload 4
    //   273: invokevirtual 226	java/io/InputStream:close	()V
    //   276: goto -23 -> 253
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -43 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	e
    //   0	285	1	paramContext	android.content.Context
    //   0	285	2	paramUri	android.net.Uri
    //   52	145	3	i	int
    //   39	210	4	localObject	Object
    //   260	12	4	localThrowable	java.lang.Throwable
    //   21	125	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   176	191	194	java/lang/NumberFormatException
    //   207	217	230	java/lang/Throwable
    //   231	238	238	finally
    //   248	253	260	java/lang/Throwable
    //   207	217	279	finally
  }
  
  /* Error */
  public final boolean isReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   18: invokevirtual 85	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   21: ifne +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 232
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 232
    //   39: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	e
    //   25	12	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	45	finally
    //   26	31	45	finally
    //   37	42	45	finally
  }
  
  /* Error */
  public final void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 234
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aWM	Ljava/util/concurrent/locks/ReadWriteLock;
    //   11: invokeinterface 64 1 0
    //   16: invokeinterface 77 1 0
    //   21: aload_0
    //   22: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   25: invokevirtual 236	android/graphics/BitmapRegionDecoder:recycle	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aWL	Landroid/graphics/BitmapRegionDecoder;
    //   33: aload_0
    //   34: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aWM	Ljava/util/concurrent/locks/ReadWriteLock;
    //   37: invokeinterface 64 1 0
    //   42: invokeinterface 108 1 0
    //   47: ldc 234
    //   49: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aWM	Ljava/util/concurrent/locks/ReadWriteLock;
    //   60: invokeinterface 64 1 0
    //   65: invokeinterface 108 1 0
    //   70: ldc 234
    //   72: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	e
    //   55	21	1	localObject1	Object
    //   77	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	33	55	finally
    //   2	21	77	finally
    //   33	52	77	finally
    //   56	77	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.e
 * JD-Core Version:    0.7.0.1
 */