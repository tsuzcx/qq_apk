package com.tencent.mm.plugin.brandservice.api;

import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface h
  extends a
{
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract String aiJ(String paramString);
  
  public abstract boolean aiK(String paramString);
  
  public abstract int aiL(String paramString);
  
  public abstract void aiM(String paramString);
  
  public abstract String aiN(String paramString);
  
  public abstract void dC(String paramString, int paramInt);
  
  public abstract void ei(List<a> paramList);
  
  public abstract void ej(List<a> paramList);
  
  public abstract boolean fI(String paramString1, String paramString2);
  
  public abstract boolean fJ(String paramString1, String paramString2);
  
  public abstract b fK(String paramString1, String paramString2);
  
  public abstract b n(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void z(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String desc;
    public String extInfo;
    public String from;
    public String title;
    public String url;
    public String vAY;
    public int vAZ = 999;
    public int vBa;
  }
  
  public static final class b
  {
    public String appId;
    public int mUU;
    public String url;
    public int vBa;
    public long vBb;
    public String vBc;
    public h.c vBd;
    public b vBe;
    public String vBf;
    public boolean vBg;
    public String vBh;
  }
  
  public static final class c
  {
    public int pkgVersion = -1;
    public WebResourceResponse vBi;
    public String vBj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.api.h
 * JD-Core Version:    0.7.0.1
 */