package com.tencent.maas;

public class MJMaasCore$WarmupParams
{
  private final String camFunDirectory;
  private final String instaMovieDirectory;
  private final boolean overwriteExisting;
  
  public MJMaasCore$WarmupParams(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.instaMovieDirectory = paramString1;
    this.camFunDirectory = paramString2;
    this.overwriteExisting = paramBoolean;
  }
  
  public String getCamFunDirectory()
  {
    return this.camFunDirectory;
  }
  
  public String getInstaMovieDirectory()
  {
    return this.instaMovieDirectory;
  }
  
  public boolean overwriteExisting()
  {
    return this.overwriteExisting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.MJMaasCore.WarmupParams
 * JD-Core Version:    0.7.0.1
 */