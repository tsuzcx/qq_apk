package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import java.lang.annotation.Annotation;

public abstract interface SafeParcelable
  extends Parcelable
{
  public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
  
  public static @interface Class
  {
    String creator();
    
    boolean validate() default false;
  }
  
  public static @interface Constructor {}
  
  public static @interface Field
  {
    String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
    
    String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
    
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
    
    String type() default "SAFE_PARCELABLE_NULL_STRING";
  }
  
  public static @interface Indicator
  {
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
  }
  
  public static @interface Param
  {
    int id();
  }
  
  public static @interface Reserved
  {
    int[] value();
  }
  
  public static @interface VersionField
  {
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
    
    String type() default "SAFE_PARCELABLE_NULL_STRING";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelable
 * JD-Core Version:    0.7.0.1
 */