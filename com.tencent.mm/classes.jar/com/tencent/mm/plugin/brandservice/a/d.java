package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface d
  extends a
{
  public abstract boolean XE(String paramString);
  
  public abstract String XF(String paramString);
  
  public abstract boolean XG(String paramString);
  
  public abstract int XH(String paramString);
  
  public abstract b XI(String paramString);
  
  public abstract void XJ(String paramString);
  
  public abstract String XK(String paramString);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract void cf(List<a> paramList);
  
  public abstract void cy(String paramString, int paramInt);
  
  public abstract boolean eL(String paramString1, String paramString2);
  
  public abstract b eM(String paramString1, String paramString2);
  
  public abstract void m(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String dFY;
    public String desc;
    public String extInfo;
    public int obQ = 999;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public int nLC;
    public long obR;
    public String obS;
    public WebResourceResponse obT;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.d
 * JD-Core Version:    0.7.0.1
 */