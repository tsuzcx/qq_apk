package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.utils.ImageUtil;

public class RoundBitmapCreator
  implements BitmapCreator
{
  boolean a;
  
  public RoundBitmapCreator(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i = Math.max(0, Math.max(paramBitmap.getHeight(), paramBitmap.getWidth()));
    if (this.a) {}
    for (float f = 0.0F;; f = AbstractImageDownloader.a(BaseApplicationImpl.a(), i))
    {
      Bitmap localBitmap = ImageUtil.a(paramBitmap, f);
      paramBitmap.recycle();
      return localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.RoundBitmapCreator
 * JD-Core Version:    0.7.0.1
 */