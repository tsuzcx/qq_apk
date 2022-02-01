package com.davemorrissey.labs.subscaleview.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e
  implements d
{
  private final Bitmap.Config aCO;
  private BitmapRegionDecoder aMu;
  private final ReadWriteLock aMv;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    AppMethodBeat.i(157343);
    this.aMv = new ReentrantReadWriteLock(true);
    Bitmap.Config localConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
    if (localConfig != null)
    {
      this.aCO = localConfig;
      AppMethodBeat.o(157343);
      return;
    }
    this.aCO = Bitmap.Config.RGB_565;
    AppMethodBeat.o(157343);
  }
  
  private Lock qg()
  {
    AppMethodBeat.i(157348);
    if (Build.VERSION.SDK_INT < 21)
    {
      localLock = this.aMv.writeLock();
      AppMethodBeat.o(157348);
      return localLock;
    }
    Lock localLock = this.aMv.readLock();
    AppMethodBeat.o(157348);
    return localLock;
  }
  
  public final Bitmap a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(157345);
    qg().lock();
    try
    {
      if ((this.aMu == null) || (this.aMu.isRecycled())) {
        break label116;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      localOptions.inPreferredConfig = this.aCO;
      paramRect = this.aMu.decodeRegion(paramRect, localOptions);
      if (paramRect == null)
      {
        paramRect = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        AppMethodBeat.o(157345);
        throw paramRect;
      }
    }
    finally
    {
      qg().unlock();
      AppMethodBeat.o(157345);
    }
    qg().unlock();
    AppMethodBeat.o(157345);
    return paramRect;
    label116:
    paramRect = new IllegalStateException("Cannot decode region after decoder has been recycled");
    AppMethodBeat.o(157345);
    throw paramRect;
  }
  
  public final Point c(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(157344);
    Object localObject = paramUri.toString();
    String str;
    int i;
    if (((String)localObject).startsWith("android.resource://"))
    {
      str = paramUri.getAuthority();
      if (paramContext.getPackageName().equals(str))
      {
        localObject = paramContext.getResources();
        paramUri = paramUri.getPathSegments();
        i = paramUri.size();
        if ((i != 2) || (!((String)paramUri.get(0)).equals("drawable"))) {
          break label159;
        }
        i = ((Resources)localObject).getIdentifier((String)paramUri.get(1), "drawable", str);
        label100:
        this.aMu = BitmapRegionDecoder.newInstance(paramContext.getResources().openRawResource(i), false);
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramContext = new Point(this.aMu.getWidth(), this.aMu.getHeight());
        AppMethodBeat.o(157344);
        return paramContext;
        localObject = paramContext.getPackageManager().getResourcesForApplication(str);
        break;
        label159:
        if ((i == 1) && (TextUtils.isDigitsOnly((CharSequence)paramUri.get(0)))) {
          try
          {
            i = bs.getInt((String)paramUri.get(0), 0);
          }
          catch (NumberFormatException paramUri) {}
        }
      }
      i = 0;
      break label100;
      if (((String)localObject).startsWith("file:///android_asset/"))
      {
        paramUri = ((String)localObject).substring(22);
        this.aMu = BitmapRegionDecoder.newInstance(paramContext.getAssets().open(paramUri, 1), false);
      }
      else if (((String)localObject).startsWith("file://"))
      {
        this.aMu = BitmapRegionDecoder.newInstance(((String)localObject).substring(7), false);
      }
      else
      {
        localObject = null;
        try
        {
          paramContext = paramContext.getContentResolver().openInputStream(paramUri);
          localObject = paramContext;
          this.aMu = BitmapRegionDecoder.newInstance(paramContext, false);
          if (paramContext != null) {
            try
            {
              paramContext.close();
            }
            catch (Exception paramContext) {}
          }
        }
        finally
        {
          if (localObject == null) {}
        }
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label320:
      AppMethodBeat.o(157344);
      throw paramContext;
    }
    catch (Exception paramUri)
    {
      break label320;
    }
  }
  
  /* Error */
  public final boolean isReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 253
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aMu	Landroid/graphics/BitmapRegionDecoder;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aMu	Landroid/graphics/BitmapRegionDecoder;
    //   18: invokevirtual 85	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   21: ifne +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 253
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 253
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
    //   2: ldc 255
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aMv	Ljava/util/concurrent/locks/ReadWriteLock;
    //   11: invokeinterface 64 1 0
    //   16: invokeinterface 77 1 0
    //   21: aload_0
    //   22: getfield 79	com/davemorrissey/labs/subscaleview/a/e:aMu	Landroid/graphics/BitmapRegionDecoder;
    //   25: invokevirtual 257	android/graphics/BitmapRegionDecoder:recycle	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 79	com/davemorrissey/labs/subscaleview/a/e:aMu	Landroid/graphics/BitmapRegionDecoder;
    //   33: aload_0
    //   34: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aMv	Ljava/util/concurrent/locks/ReadWriteLock;
    //   37: invokeinterface 64 1 0
    //   42: invokeinterface 108 1 0
    //   47: ldc 255
    //   49: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 34	com/davemorrissey/labs/subscaleview/a/e:aMv	Ljava/util/concurrent/locks/ReadWriteLock;
    //   60: invokeinterface 64 1 0
    //   65: invokeinterface 108 1 0
    //   70: ldc 255
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