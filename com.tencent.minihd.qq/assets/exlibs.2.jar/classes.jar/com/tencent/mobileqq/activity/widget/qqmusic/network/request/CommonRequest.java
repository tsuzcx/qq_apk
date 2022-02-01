package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.ResponseProcessResult;

public abstract class CommonRequest
{
  public static final int a = 0;
  public static final String a = "cgiextra";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 9;
  protected String b;
  protected boolean b;
  protected int f = 1;
  protected int g = 0;
  
  public CommonRequest()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public CommonResponse a(ResponseProcessResult paramResponseProcessResult)
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  protected void a(CommonResponse paramCommonResponse) {}
  
  public int b()
  {
    return this.g;
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest
 * JD-Core Version:    0.7.0.1
 */