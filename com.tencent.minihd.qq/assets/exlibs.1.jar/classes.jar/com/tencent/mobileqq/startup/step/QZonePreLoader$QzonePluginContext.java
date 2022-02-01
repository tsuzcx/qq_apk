package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QZonePreLoader$QzonePluginContext
  extends ContextThemeWrapper
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AssetManager jdField_a_of_type_AndroidContentResAssetManager = null;
  private Resources.Theme jdField_a_of_type_AndroidContentResResources$Theme = null;
  private Resources jdField_a_of_type_AndroidContentResResources = null;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public QZonePreLoader$QzonePluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null);
  }
  
  public QZonePreLoader$QzonePluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
    if (paramResources != null) {
      this.jdField_a_of_type_AndroidContentResAssetManager = paramResources.getAssets();
    }
    for (this.jdField_a_of_type_AndroidContentResResources = paramResources;; this.jdField_a_of_type_AndroidContentResResources = a(paramContext, this.jdField_a_of_type_AndroidContentResAssetManager))
    {
      this.jdField_a_of_type_AndroidContentResResources$Theme = a(this.jdField_a_of_type_AndroidContentResResources);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      return;
      this.jdField_a_of_type_AndroidContentResAssetManager = a(paramString);
    }
  }
  
  private int a(String paramString)
  {
    try
    {
      String str1 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      int i = paramString.lastIndexOf(".");
      String str2 = paramString.substring(i + 1, paramString.length());
      paramString = paramString.substring(0, i);
      paramString = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      i = Class.forName(str1 + "$" + paramString).getDeclaredField(str2).getInt(null);
      return i;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private AssetManager a(String paramString)
  {
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
        return localAssetManager;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramString = localThrowable1;
          Object localObject = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
      paramString = null;
    }
    return paramString;
  }
  
  private Resources.Theme a(Resources paramResources)
  {
    paramResources = paramResources.newTheme();
    this.jdField_a_of_type_Int = a("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.jdField_a_of_type_Int, true);
    return paramResources;
  }
  
  private Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
  
  public void a(ClassLoader paramClassLoader)
  {
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
  }
  
  public AssetManager getAssets()
  {
    return this.jdField_a_of_type_AndroidContentResAssetManager;
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {
      return this.jdField_a_of_type_JavaLangClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.jdField_a_of_type_AndroidContentResResources$Theme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QZonePreLoader.QzonePluginContext
 * JD-Core Version:    0.7.0.1
 */