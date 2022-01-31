package com.google.android.gms.analytics;

public class HitBuilders$SocialBuilder
  extends HitBuilders.HitBuilder<SocialBuilder>
{
  public HitBuilders$SocialBuilder()
  {
    set("&t", "social");
  }
  
  public SocialBuilder setAction(String paramString)
  {
    set("&sa", paramString);
    return this;
  }
  
  public SocialBuilder setNetwork(String paramString)
  {
    set("&sn", paramString);
    return this;
  }
  
  public SocialBuilder setTarget(String paramString)
  {
    set("&st", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.SocialBuilder
 * JD-Core Version:    0.7.0.1
 */