package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kpt;
import kpv;
import kpw;
import kpx;
import kpy;

public class ImageWorker
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "ImageWorker";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final int d = 200;
  private Context jdField_a_of_type_AndroidContentContext;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageCache jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  private Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  protected int b;
  private boolean b;
  protected int c;
  private boolean c;
  
  public ImageWorker(Context paramContext)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageCache = new ImageCache(ReflectionUtil.a(paramContext) / 8);
  }
  
  public ImageWorker(Context paramContext, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageCache = new ImageCache(ReflectionUtil.a(paramContext) / 8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilImageCache = null;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      if (m > k) {}
      for (int i = Math.round(k / paramInt2);; i = Math.round(m / paramInt1))
      {
        float f1 = k * m;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
      }
    }
    return j;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = paramInt1;
      if (paramInt1 <= 0) {
        i = localOptions.outWidth;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localOptions.outHeight;
      }
      localOptions.inSampleSize = a(localOptions, i, paramInt1);
      localOptions.inJustDecodeBounds = false;
      paramString = BitmapManager.a(paramString, localOptions);
      return paramString;
    }
    finally {}
  }
  
  private kpw a(View paramView)
  {
    if (paramView != null)
    {
      kpy localkpy = (kpy)this.jdField_a_of_type_JavaUtilMap.get(paramView);
      if (localkpy != null) {
        paramView = localkpy.jdField_a_of_type_Kpv;
      }
      while ((paramView instanceof kpv))
      {
        return ((kpv)paramView).a();
        if ((paramView instanceof ImageView)) {
          paramView = ((ImageView)paramView).getDrawable();
        } else {
          paramView = paramView.getBackground();
        }
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, kpy paramkpy)
  {
    Object localObject = paramDrawable;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = paramDrawable;
      if (paramBoolean)
      {
        localObject = paramDrawable;
        if (!(paramDrawable instanceof AnimationDrawable))
        {
          localObject = paramDrawable;
          if (paramDrawable != null)
          {
            localObject = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
            ((TransitionDrawable)localObject).startTransition(200);
          }
        }
      }
    }
    paramDrawable = null;
    if (paramkpy != null) {
      paramDrawable = paramkpy.jdField_a_of_type_ComTencentMobileqqUtilImageLoader;
    }
    if (paramDrawable != null)
    {
      paramDrawable.a(paramView, (Drawable)localObject);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
      return;
    }
    paramView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public final Drawable a(String paramString)
  {
    BitmapDrawable localBitmapDrawable = null;
    if ((this.jdField_b_of_type_Int > 0) || (this.jdField_c_of_type_Int > 0)) {}
    for (paramString = a(paramString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);; paramString = BitmapManager.a(paramString))
    {
      if (paramString != null) {
        localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
      }
      return localBitmapDrawable;
    }
  }
  
  public ImageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, String paramString, View paramView, ImageLoader paramImageLoader, ImageCreator paramImageCreator)
  {
    a(paramInt, paramString, paramView, paramImageLoader, paramImageCreator, false);
  }
  
  public void a(int paramInt, String paramString, View paramView, ImageLoader paramImageLoader, ImageCreator paramImageCreator, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramInt == 2130838406) {
      localObject1 = ImageUtil.a();
    }
    for (;;)
    {
      a((Bitmap)localObject1, paramString, paramView, paramImageLoader, paramImageCreator, paramBoolean);
      return;
      try
      {
        localObject1 = SkinUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt));
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ImageWorker", 2, "loadImage oom", localOutOfMemoryError);
          localObject1 = localObject3;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void a(int paramInt, String paramString, ImageView paramImageView)
  {
    a(paramInt, paramString, paramImageView, null, null);
  }
  
  public void a(Bitmap paramBitmap, String paramString, View paramView, ImageLoader paramImageLoader, ImageCreator paramImageCreator, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilImageCache != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilImageCache.a(paramString);
    }
    if (localObject != null) {
      if (paramImageLoader != null) {
        paramImageLoader.a(paramView, (Drawable)localObject);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramView instanceof ImageView))
        {
          ((ImageView)paramView).setImageDrawable((Drawable)localObject);
          return;
        }
        paramView.setBackgroundDrawable((Drawable)localObject);
        return;
      } while (!a(paramString, paramView));
      localObject = new kpw(this, paramView);
      kpv localkpv = new kpv(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap, (kpw)localObject);
      paramBitmap = paramImageCreator;
      if (paramImageCreator == null) {
        paramBitmap = new kpx(this, paramString);
      }
      if (paramImageLoader != null)
      {
        paramImageLoader.a(paramView, localkpv);
        this.jdField_a_of_type_JavaUtilMap.put(paramView, new kpy(paramBitmap, paramImageLoader, localkpv));
      }
      while (paramBoolean)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
        }
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new kpt(this, (kpw)localObject, paramString, paramBitmap));
        return;
        if ((paramView instanceof ImageView)) {
          ((ImageView)paramView).setImageDrawable(localkpv);
        } else {
          paramView.setBackgroundDrawable(localkpv);
        }
      }
      paramBitmap = ((kpw)localObject).a(new Object[] { paramString, paramBitmap, Boolean.valueOf(false) });
    } while (paramBitmap == null);
    ((kpw)localObject).a(paramBitmap);
  }
  
  public void a(View paramView)
  {
    paramView = a(paramView);
    if (paramView != null) {
      paramView.cancel(true);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilImageCache.a(paramString, this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  public boolean a(Object paramObject, View paramView)
  {
    paramView = a(paramView);
    if (paramView != null)
    {
      Object localObject = kpw.a(paramView);
      if ((localObject == null) || (!localObject.equals(paramObject))) {
        paramView.cancel(true);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */