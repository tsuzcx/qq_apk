package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "VipPngPlayAnimationDrawable";
  static final int b = 50;
  public static final int c = 101;
  public static final int d = 102;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public Resources a;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  public VipPngPlayAnimationDrawable.DecodeNextFrameTask a;
  public Object a;
  public boolean a;
  public Bitmap b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public int h = -1;
  public int i = -1;
  public int j = 50;
  public int k = 0;
  private int l = -1;
  private int m = 0;
  private int n;
  private int o;
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.m - 1)
    {
      this.k -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  @TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramInt1, localOptions);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/")) {
      paramObject = paramObject.substring("file:///android_assets/".length());
    }
    for (paramObject = this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramObject);; paramObject = new FileInputStream(paramObject)) {
      return BitmapFactory.decodeStream(paramObject, null, localOptions);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask = null;
    }
    this.h = -1;
    this.jdField_a_of_type_Boolean = true;
    this.i = -1;
    this.j = 50;
    this.k = -1;
    this.d = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.k = paramInt2;
    this.d = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    a(paramArrayOfString, paramInt, true);
  }
  
  public void a(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    if ((this.h == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      try
      {
        a();
        this.h = 0;
        this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        String str = paramArrayOfString[0];
        if (str.startsWith("file:///android_assets/bubbles/"))
        {
          str = str.substring("file:///android_assets/".length());
          BitmapFactory.decodeStream(this.jdField_a_of_type_AndroidContentResResources.getAssets().open(str), null, localOptions);
          if (paramBoolean)
          {
            this.n = Utils.a(localOptions.outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
            this.o = Utils.a(localOptions.outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
          }
          this.m = paramArrayOfString.length;
          this.j = paramInt;
          this.d = false;
          return;
        }
      }
      catch (IOException paramArrayOfString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("VipPngPlayAnimationDrawable", 4, "", paramArrayOfString);
        }
        a();
        return;
      }
      BitmapFactory.decodeFile(paramArrayOfString[0], localOptions);
    }
  }
  
  public boolean a()
  {
    return (!this.d) && (this.i >= 0);
  }
  
  protected void b()
  {
    if ((this.h == 1) && (this.i >= 0)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.j);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.j;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask = new VipPngPlayAnimationDrawable.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.i), Long.valueOf(this.h) });
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.h == -1) {
      return;
    }
    if (this.i != -1)
    {
      Rect localRect = super.getBounds();
      int i1 = 0;
      if (this.c)
      {
        i1 = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      if (this.h != 1) {
        break label100;
      }
      if (this.c) {
        paramCanvas.restoreToCount(i1);
      }
    }
    if (this.k == 0)
    {
      if (102 == this.l) {}
      for (;;)
      {
        super.invalidateSelf();
        this.d = true;
        return;
        label100:
        if (((this.h != 0) && (this.h != 2)) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null)) {
          break;
        }
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, super.getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
        a();
      }
    }
    b();
  }
  
  public int getIntrinsicHeight()
  {
    return this.o;
  }
  
  public int getIntrinsicWidth()
  {
    return this.n;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      this.i = a(this.i);
    } while ((this.h == -1) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == this.jdField_b_of_type_AndroidGraphicsBitmap));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    super.invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */