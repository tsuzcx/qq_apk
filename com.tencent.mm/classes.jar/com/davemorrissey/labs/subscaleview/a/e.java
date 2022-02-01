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
  private final Bitmap.Config aFT;
  private BitmapRegionDecoder aFU;
  private final ReadWriteLock aFV;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    AppMethodBeat.i(157343);
    this.aFV = new ReentrantReadWriteLock(true);
    Bitmap.Config localConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
    if (localConfig != null)
    {
      this.aFT = localConfig;
      AppMethodBeat.o(157343);
      return;
    }
    this.aFT = Bitmap.Config.RGB_565;
    AppMethodBeat.o(157343);
  }
  
  private Lock pv()
  {
    AppMethodBeat.i(157348);
    if (Build.VERSION.SDK_INT < 21)
    {
      localLock = this.aFV.writeLock();
      AppMethodBeat.o(157348);
      return localLock;
    }
    Lock localLock = this.aFV.readLock();
    AppMethodBeat.o(157348);
    return localLock;
  }
  
  public final Bitmap a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(157345);
    pv().lock();
    try
    {
      if ((this.aFU == null) || (this.aFU.isRecycled())) {
        break label116;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      localOptions.inPreferredConfig = this.aFT;
      paramRect = this.aFU.decodeRegion(paramRect, localOptions);
      if (paramRect == null)
      {
        paramRect = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        AppMethodBeat.o(157345);
        throw paramRect;
      }
    }
    finally
    {
      pv().unlock();
      AppMethodBeat.o(157345);
    }
    pv().unlock();
    AppMethodBeat.o(157345);
    return paramRect;
    label116:
    paramRect = new IllegalStateException("Cannot decode region after decoder has been recycled");
    AppMethodBeat.o(157345);
    throw paramRect;
  }
  
  /* Error */
  public final android.graphics.Point b(android.content.Context paramContext, android.net.Uri paramUri)
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
    //   109: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   112: new 182	android/graphics/Point
    //   115: dup
    //   116: aload_0
    //   117: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   120: invokevirtual 185	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   123: aload_0
    //   124: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
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
    //   187: invokestatic 215	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   190: istore_3
    //   191: goto -95 -> 96
    //   194: astore_2
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -101 -> 96
    //   200: aload_2
    //   201: invokestatic 221	com/tencent/mm/vfs/u:q	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_2
    //   208: aload_0
    //   209: aload 4
    //   211: iconst_0
    //   212: invokestatic 180	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   215: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   218: aload 4
    //   220: ifnull -108 -> 112
    //   223: aload 4
    //   225: invokevirtual 226	java/io/InputStream:close	()V
    //   228: goto -116 -> 112
    //   231: astore_2
    //   232: ldc 120
    //   234: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_2
    //   238: athrow
    //   239: astore_1
    //   240: aload 4
    //   242: ifnull +12 -> 254
    //   245: aload_2
    //   246: ifnull +26 -> 272
    //   249: aload 4
    //   251: invokevirtual 226	java/io/InputStream:close	()V
    //   254: ldc 120
    //   256: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: astore 4
    //   263: aload_2
    //   264: aload 4
    //   266: invokevirtual 230	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   269: goto -15 -> 254
    //   272: aload 4
    //   274: invokevirtual 226	java/io/InputStream:close	()V
    //   277: goto -23 -> 254
    //   280: astore_1
    //   281: goto -41 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	e
    //   0	284	1	paramContext	android.content.Context
    //   0	284	2	paramUri	android.net.Uri
    //   52	145	3	i	int
    //   39	211	4	localObject	Object
    //   261	12	4	localThrowable	java.lang.Throwable
    //   21	125	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   176	191	194	java/lang/NumberFormatException
    //   208	218	231	java/lang/Throwable
    //   232	239	239	finally
    //   249	254	261	java/lang/Throwable
    //   208	218	280	finally
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
    //   8: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
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
    //   8: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aFV	Ljava/util/concurrent/locks/ReadWriteLock;
    //   11: invokeinterface 64 1 0
    //   16: invokeinterface 77 1 0
    //   21: aload_0
    //   22: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   25: invokevirtual 236	android/graphics/BitmapRegionDecoder:recycle	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aFU	Landroid/graphics/BitmapRegionDecoder;
    //   33: aload_0
    //   34: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aFV	Ljava/util/concurrent/locks/ReadWriteLock;
    //   37: invokeinterface 64 1 0
    //   42: invokeinterface 108 1 0
    //   47: ldc 234
    //   49: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aFV	Ljava/util/concurrent/locks/ReadWriteLock;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.e
 * JD-Core Version:    0.7.0.1
 */