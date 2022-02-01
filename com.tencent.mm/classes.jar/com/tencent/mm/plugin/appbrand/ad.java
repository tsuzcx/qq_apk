package com.tencent.mm.plugin.appbrand;

public abstract interface ad
{
  public abstract int alloc();
  
  public abstract int allocEmpty();
  
  public abstract int create(String paramString);
  
  public abstract void destroy(int paramInt);
  
  public abstract int evaluateScriptFile(int paramInt, String paramString);
  
  public abstract void loadJsFilesWithOptions(int paramInt, String paramString1, String paramString2);
  
  public abstract void loadLibFiles(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad
 * JD-Core Version:    0.7.0.1
 */