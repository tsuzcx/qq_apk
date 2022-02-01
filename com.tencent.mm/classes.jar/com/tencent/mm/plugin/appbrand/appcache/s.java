package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;
import java.util.List;

public abstract interface s
{
  public abstract WxaPkg Vc(String paramString);
  
  public abstract InputStream Vd(String paramString);
  
  public abstract a Ve(String paramString);
  
  public abstract boolean Vf(String paramString);
  
  public abstract boolean an(String paramString, boolean paramBoolean);
  
  public abstract void cge();
  
  public abstract List<ModulePkgInfo> cgf();
  
  public abstract List<String> cgg();
  
  public abstract void close();
  
  public static class a
  {
    public int appVersion;
    public String fileName;
    public String qEr;
    public String qEs;
    public WxaPkg qEt;
    public String qEu;
    public int qEv;
    public int qEw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */