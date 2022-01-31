package com.google.android.gms.analytics;

public class HitBuilders$EventBuilder
  extends HitBuilders.HitBuilder<EventBuilder>
{
  public HitBuilders$EventBuilder()
  {
    set("&t", "event");
  }
  
  public HitBuilders$EventBuilder(String paramString1, String paramString2)
  {
    this();
    setCategory(paramString1);
    setAction(paramString2);
  }
  
  public EventBuilder setAction(String paramString)
  {
    set("&ea", paramString);
    return this;
  }
  
  public EventBuilder setCategory(String paramString)
  {
    set("&ec", paramString);
    return this;
  }
  
  public EventBuilder setLabel(String paramString)
  {
    set("&el", paramString);
    return this;
  }
  
  public EventBuilder setValue(long paramLong)
  {
    set("&ev", Long.toString(paramLong));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.EventBuilder
 * JD-Core Version:    0.7.0.1
 */