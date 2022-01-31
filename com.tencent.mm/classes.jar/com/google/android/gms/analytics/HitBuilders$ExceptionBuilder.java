package com.google.android.gms.analytics;

import com.google.android.gms.internal.zztm;

public class HitBuilders$ExceptionBuilder
  extends HitBuilders.HitBuilder<ExceptionBuilder>
{
  public HitBuilders$ExceptionBuilder()
  {
    set("&t", "exception");
  }
  
  public ExceptionBuilder setDescription(String paramString)
  {
    set("&exd", paramString);
    return this;
  }
  
  public ExceptionBuilder setFatal(boolean paramBoolean)
  {
    set("&exf", zztm.zzX(paramBoolean));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.ExceptionBuilder
 * JD-Core Version:    0.7.0.1
 */