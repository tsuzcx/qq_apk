package com.google.android.gms.common.internal.safeparcel;

import java.lang.annotation.Annotation;

public @interface SafeParcelable$VersionField
{
  String getter() default "SAFE_PARCELABLE_NULL_STRING";
  
  int id();
  
  String type() default "SAFE_PARCELABLE_NULL_STRING";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField
 * JD-Core Version:    0.7.0.1
 */