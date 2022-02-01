package com.tencent.component.network.utils;

import android.text.TextUtils;

public class NetworkUtils$NetworkProxy
  implements Cloneable
{
  public final int a;
  public final String a;
  
  NetworkUtils$NetworkProxy(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  final NetworkProxy a()
  {
    try
    {
      NetworkProxy localNetworkProxy = (NetworkProxy)clone();
      return localNetworkProxy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof NetworkProxy))) {
        break;
      }
      paramObject = (NetworkProxy)paramObject;
    } while ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int));
    return false;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils.NetworkProxy
 * JD-Core Version:    0.7.0.1
 */