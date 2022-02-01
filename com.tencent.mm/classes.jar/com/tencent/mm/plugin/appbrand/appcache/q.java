package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;
import java.util.List;

public abstract interface q
{
  public abstract WxaPkg DO(String paramString);
  
  public abstract InputStream DP(String paramString);
  
  public abstract q.a DQ(String paramString);
  
  public abstract boolean DR(String paramString);
  
  public abstract List<String> aPA();
  
  public abstract List<WxaPkg.Info> aPx();
  
  public abstract void aPy();
  
  public abstract List<ModulePkgInfo> aPz();
  
  public abstract void close();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */