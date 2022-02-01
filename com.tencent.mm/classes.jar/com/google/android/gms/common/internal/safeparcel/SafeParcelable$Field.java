package com.google.android.gms.common.internal.safeparcel;

import java.lang.annotation.Annotation;

public @interface SafeParcelable$Field
{
  String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
  
  String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
  
  String getter() default "SAFE_PARCELABLE_NULL_STRING";
  
  int id();
  
  String type() default "SAFE_PARCELABLE_NULL_STRING";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
 * JD-Core Version:    0.7.0.1
 */