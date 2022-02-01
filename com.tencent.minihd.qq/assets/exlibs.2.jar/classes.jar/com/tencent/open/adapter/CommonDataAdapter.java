package com.tencent.open.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class CommonDataAdapter
{
  public static final int a = 200;
  protected static CommonDataAdapter a;
  public static final String a = "photo_size_preference";
  public static final String b = "auto";
  public static final String c = "isrequireqauth";
  protected static final String d = "11";
  protected static String e = "androidqq";
  public static final String l = "scheme";
  public static final String m = "source";
  public static final String n = "app";
  protected long a;
  protected Context a;
  protected int b;
  protected long b;
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  
  protected CommonDataAdapter()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public static CommonDataAdapter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter == null) {
        jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter = new CommonDataAdapter();
      }
      CommonDataAdapter localCommonDataAdapter = jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter;
      return localCommonDataAdapter;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    a();
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Long <= 0L)
    {
      localObject = DownloadManager.a().a();
      if (localObject == null) {}
    }
    try
    {
      localObject = (AppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((AppInterface)localObject).a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_Long = Long.valueOf((String)localObject).longValue();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return BaseApplication.getContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    return this.f;
  }
  
  protected void a()
  {
    Object localObject = a().a();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.g = ((PackageInfo)localObject).versionName;
      this.h = this.g.substring(0, this.g.lastIndexOf('.'));
      this.i = this.g.substring(this.g.lastIndexOf('.') + 1, this.g.length());
      this.jdField_b_of_type_Int = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    a();
    return this.h;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    a();
    return this.g;
  }
  
  public String d()
  {
    return "11";
  }
  
  public String e()
  {
    if (!TextUtils.isEmpty(this.j)) {
      return this.j;
    }
    this.j = ("V1_AND_SQ_" + b());
    return this.j;
  }
  
  public String f()
  {
    if (a() == null) {
      return "";
    }
    return a().getPackageName();
  }
  
  public String g()
  {
    return e;
  }
  
  public String h()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.adapter.CommonDataAdapter
 * JD-Core Version:    0.7.0.1
 */