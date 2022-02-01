package com.google.android.gms.common.data;

import android.content.Context;

public abstract interface TextFilterable
{
  public static final StringFilter CONTAINS = new zzc();
  public static final StringFilter STARTS_WITH = new zzd();
  public static final StringFilter WORD_STARTS_WITH = new zze();
  
  public abstract void setFilterTerm(Context paramContext, StringFilter paramStringFilter, String paramString);
  
  public abstract void setFilterTerm(Context paramContext, String paramString);
  
  public static abstract interface StringFilter
  {
    public abstract boolean matches(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.TextFilterable
 * JD-Core Version:    0.7.0.1
 */