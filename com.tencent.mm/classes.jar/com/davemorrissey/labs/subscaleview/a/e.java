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
import com.tencent.mm.sdk.platformtools.bk;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e
  implements d
{
  private final Bitmap.Config aow;
  private BitmapRegionDecoder aoy;
  private final ReadWriteLock aoz = new ReentrantReadWriteLock(true);
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    Bitmap.Config localConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
    if (localConfig != null)
    {
      this.aow = localConfig;
      return;
    }
    this.aow = Bitmap.Config.RGB_565;
  }
  
  private Lock js()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return this.aoz.writeLock();
    }
    return this.aoz.readLock();
  }
  
  public final Bitmap b(Rect paramRect, int paramInt)
  {
    js().lock();
    try
    {
      if ((this.aoy == null) || (this.aoy.isRecycled())) {
        break label94;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = paramInt;
      localOptions.inPreferredConfig = this.aow;
      paramRect = this.aoy.decodeRegion(paramRect, localOptions);
      if (paramRect == null) {
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
      }
    }
    finally
    {
      js().unlock();
    }
    js().unlock();
    return paramRect;
    label94:
    throw new IllegalStateException("Cannot decode region after decoder has been recycled");
  }
  
  public final Point c(Context paramContext, Uri paramUri)
  {
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
          break label147;
        }
        i = ((Resources)localObject).getIdentifier((String)paramUri.get(1), "drawable", str);
        label95:
        this.aoy = BitmapRegionDecoder.newInstance(paramContext.getResources().openRawResource(i), false);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return new Point(this.aoy.getWidth(), this.aoy.getHeight());
        localObject = paramContext.getPackageManager().getResourcesForApplication(str);
        break;
        label147:
        if ((i == 1) && (TextUtils.isDigitsOnly((CharSequence)paramUri.get(0)))) {
          try
          {
            i = bk.getInt((String)paramUri.get(0), 0);
          }
          catch (NumberFormatException paramUri) {}
        }
      }
      i = 0;
      break label95;
      if (((String)localObject).startsWith("file:///android_asset/"))
      {
        paramUri = ((String)localObject).substring(22);
        this.aoy = BitmapRegionDecoder.newInstance(paramContext.getAssets().open(paramUri, 1), false);
      }
      else if (((String)localObject).startsWith("file://"))
      {
        this.aoy = BitmapRegionDecoder.newInstance(((String)localObject).substring(7), false);
      }
      else
      {
        localObject = null;
        try
        {
          paramContext = paramContext.getContentResolver().openInputStream(paramUri);
          localObject = paramContext;
          this.aoy = BitmapRegionDecoder.newInstance(paramContext, false);
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
      label308:
      throw paramContext;
    }
    catch (Exception paramUri)
    {
      break label308;
    }
  }
  
  /* Error */
  public final boolean isReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/davemorrissey/labs/subscaleview/a/e:aoy	Landroid/graphics/BitmapRegionDecoder;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 67	com/davemorrissey/labs/subscaleview/a/e:aoy	Landroid/graphics/BitmapRegionDecoder;
    //   13: invokevirtual 73	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	e
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  /* Error */
  public final void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/davemorrissey/labs/subscaleview/a/e:aoz	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 53 1 0
    //   11: invokeinterface 65 1 0
    //   16: aload_0
    //   17: getfield 67	com/davemorrissey/labs/subscaleview/a/e:aoy	Landroid/graphics/BitmapRegionDecoder;
    //   20: invokevirtual 242	android/graphics/BitmapRegionDecoder:recycle	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 67	com/davemorrissey/labs/subscaleview/a/e:aoy	Landroid/graphics/BitmapRegionDecoder;
    //   28: aload_0
    //   29: getfield 27	com/davemorrissey/labs/subscaleview/a/e:aoz	Ljava/util/concurrent/locks/ReadWriteLock;
    //   32: invokeinterface 53 1 0
    //   37: invokeinterface 96 1 0
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 27	com/davemorrissey/labs/subscaleview/a/e:aoz	Ljava/util/concurrent/locks/ReadWriteLock;
    //   50: invokeinterface 53 1 0
    //   55: invokeinterface 96 1 0
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	e
    //   45	16	1	localObject1	Object
    //   62	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	28	45	finally
    //   2	16	62	finally
    //   28	42	62	finally
    //   46	62	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.e
 * JD-Core Version:    0.7.0.1
 */