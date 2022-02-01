package com.tencent.av.opengl.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.av.utils.UITools;

public class ResourceTexture
  extends UploadedTexture
{
  protected final Context mContext;
  protected final int mResId;
  
  public ResourceTexture(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mResId = paramInt;
    setOpaque(false);
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap)
  {
    if (!inFinalizer()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap onGetBitmap()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inScaled = false;
    Object localObject = null;
    int i = UITools.getScreenWidth(this.mContext);
    localOptions.inSampleSize = 1;
    if (i <= 480) {
      localOptions.inSampleSize = 2;
    }
    Resources localResources = this.mContext.getResources();
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeResource(localResources, this.mResId, localOptions);
      localObject = localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      do
      {
        localOptions.inSampleSize *= 2;
      } while (localResources == null);
      try
      {
        localObject = BitmapFactory.decodeResource(localResources, this.mResId, localOptions);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localOptions.inSampleSize *= 2;
        i = this.mResId;
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(localResources, i, localOptions);
          return localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
      }
    }
    return localObject;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.ResourceTexture
 * JD-Core Version:    0.7.0.1
 */