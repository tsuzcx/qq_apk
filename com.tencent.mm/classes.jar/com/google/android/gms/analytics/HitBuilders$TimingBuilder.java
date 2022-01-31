package com.google.android.gms.analytics;

public class HitBuilders$TimingBuilder
  extends HitBuilders.HitBuilder<TimingBuilder>
{
  public HitBuilders$TimingBuilder()
  {
    set("&t", "timing");
  }
  
  public HitBuilders$TimingBuilder(String paramString1, String paramString2, long paramLong)
  {
    this();
    setVariable(paramString2);
    setValue(paramLong);
    setCategory(paramString1);
  }
  
  public TimingBuilder setCategory(String paramString)
  {
    set("&utc", paramString);
    return this;
  }
  
  public TimingBuilder setLabel(String paramString)
  {
    set("&utl", paramString);
    return this;
  }
  
  public TimingBuilder setValue(long paramLong)
  {
    set("&utt", Long.toString(paramLong));
    return this;
  }
  
  public TimingBuilder setVariable(String paramString)
  {
    set("&utv", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.TimingBuilder
 * JD-Core Version:    0.7.0.1
 */