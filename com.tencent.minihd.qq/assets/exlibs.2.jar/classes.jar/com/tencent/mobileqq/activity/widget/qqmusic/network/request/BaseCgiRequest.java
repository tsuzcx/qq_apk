package com.tencent.mobileqq.activity.widget.qqmusic.network.request;

import com.tencent.mobileqq.activity.widget.qqmusic.data.BaseInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.ResponseProcessResult;
import java.util.HashMap;

public abstract class BaseCgiRequest
  extends CommonRequest
{
  protected long a;
  protected HashMap a;
  protected boolean a;
  protected byte[] a;
  protected HashMap b = new HashMap();
  
  public BaseCgiRequest()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.g = 0;
    a();
  }
  
  public BaseCgiRequest(HashMap paramHashMap)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.g = 0;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected abstract BaseInfo a(byte[] paramArrayOfByte);
  
  public CommonResponse a(ResponseProcessResult paramResponseProcessResult)
  {
    CommonResponse localCommonResponse = new CommonResponse();
    if (paramResponseProcessResult == null)
    {
      localCommonResponse.a(1000006);
      return localCommonResponse;
    }
    paramResponseProcessResult = paramResponseProcessResult.jdField_a_of_type_ArrayOfByte;
    if ((paramResponseProcessResult == null) || (paramResponseProcessResult.length == 0))
    {
      localCommonResponse.a(1100014);
      return localCommonResponse;
    }
    try
    {
      localCommonResponse.a(a(paramResponseProcessResult));
      return localCommonResponse;
    }
    catch (Exception paramResponseProcessResult)
    {
      localCommonResponse.a(1);
      localCommonResponse.b(1100012);
    }
    return localCommonResponse;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected abstract void a();
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ArrayOfByte = paramString.getBytes();
  }
  
  public void a(HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[0];
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
    return arrayOfByte;
  }
  
  public HashMap b()
  {
    return this.b;
  }
  
  public void b(HashMap paramHashMap)
  {
    this.b = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.BaseCgiRequest
 * JD-Core Version:    0.7.0.1
 */