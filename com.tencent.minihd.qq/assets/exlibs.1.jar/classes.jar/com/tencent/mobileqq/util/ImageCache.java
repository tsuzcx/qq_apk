package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kps;

public class ImageCache
{
  private static final int jdField_a_of_type_Int = 5;
  private static final String jdField_a_of_type_JavaLangString = "ImageCache";
  private CustomLruCache jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ImageCache(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel()) {
      QLog.d("ImageCache", 2, "Memory cache size = " + paramInt + "MB");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache = new kps(this, paramInt * 1024 * 1024);
  }
  
  public Drawable a(String paramString)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null)
    {
      localObject1 = (Drawable)this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.remove(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Drawable)localObject1).getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.put(paramString, localObject1);
        return localObject1;
      }
    }
    for (;;)
    {
      Object localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject2 != null)
      {
        localObject2 = (Drawable)((WeakReference)localObject2).get();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        return localObject2;
      }
      return localObject1;
      localObject1 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.evictAll();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.remove(paramString);
    }
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.get(paramString) == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.put(paramString, paramDrawable);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new WeakReference(paramDrawable));
    }
  }
  
  public Drawable b(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageCache
 * JD-Core Version:    0.7.0.1
 */