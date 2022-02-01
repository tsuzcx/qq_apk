package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import hvl;
import hvm;
import hvn;
import hvo;

public class VipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private hvo jdField_a_of_type_Hvo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public VipBubbleDrawable(Resources paramResources, hvo paramhvo)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_Hvo = paramhvo;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null) {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    }
    this.jdField_b_of_type_Int = AIOUtils.a(65.0F, paramResources);
    this.jdField_c_of_type_Int = AIOUtils.a(57.0F, paramResources);
  }
  
  public VipBubbleDrawable(Resources paramResources, String paramString1, String paramString2)
  {
    this(paramResources, new hvo(paramString1, paramString2));
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    String str;
    Object localObject;
    do
    {
      return;
      int j = 0;
      str = "bubblebg://" + "0_local_default_" + this.jdField_b_of_type_Boolean;
      i = j;
      if (BaseApplicationImpl.a != null)
      {
        localObject = (NinePatch)BaseApplicationImpl.a.get(str);
        i = j;
        if (localObject != null)
        {
          i = 1;
          ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    } while (i != 0);
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2130841710;; i = 2130841748) {
      for (;;)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inDensity = 320;
        ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
        try
        {
          localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, i, (BitmapFactory.Options)localObject);
          if (localObject == null) {
            break;
          }
          byte[] arrayOfByte = ((Bitmap)localObject).getNinePatchChunk();
          if (arrayOfByte == null) {
            break;
          }
          localObject = new NinePatch((Bitmap)localObject, arrayOfByte, null);
          if (localObject == null) {
            break;
          }
          ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
          if (BaseApplicationImpl.a == null) {
            break;
          }
          BaseApplicationImpl.a.put(str, localObject);
          return;
        }
        catch (OutOfMemoryError paramCanvas)
        {
          return;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new hvn(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    if (!this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_Hvo.a != null)
      {
        if (this.jdField_b_of_type_Boolean) {
          paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
        }
        this.jdField_a_of_type_Hvo.a.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      a(paramCanvas);
      ThreadManager.b(new hvl(this));
      continue;
      if (this.jdField_a_of_type_Hvo.b == null) {
        break;
      }
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      this.jdField_a_of_type_Hvo.b.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_Hvo.a != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      this.jdField_a_of_type_Hvo.a.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      ThreadManager.b(new hvm(this));
      break;
      a(paramCanvas);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Hvo;
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    if (this.jdField_a_of_type_Hvo.a != null) {
      if (!this.jdField_a_of_type_Hvo.a.hasAlpha()) {}
    }
    while ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255))
    {
      return -3;
      return -1;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = StateSet.stateSetMatches(jdField_a_of_type_ArrayOfInt, paramArrayOfInt);
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramArrayOfInt = jdField_a_of_type_AndroidGraphicsColorFilter;; paramArrayOfInt = null)
      {
        localPaint.setColorFilter(paramArrayOfInt);
        invalidateSelf();
        return true;
      }
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.VipBubbleDrawable
 * JD-Core Version:    0.7.0.1
 */