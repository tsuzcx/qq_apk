package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface f
  extends a
{
  public abstract b P(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract boolean apm(String paramString);
  
  public abstract String apn(String paramString);
  
  public abstract boolean apo(String paramString);
  
  public abstract int app(String paramString);
  
  public abstract b apq(String paramString);
  
  public abstract void apr(String paramString);
  
  public abstract String aps(String paramString);
  
  public abstract void cq(List<a> paramList);
  
  public abstract void cr(List<a> paramList);
  
  public abstract void da(String paramString, int paramInt);
  
  public abstract boolean fr(String paramString1, String paramString2);
  
  public abstract void m(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String desc;
    public String extInfo;
    public String from;
    public int svv = 999;
    public int svw;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public String appId;
    public int kqZ;
    public int svw;
    public long svx;
    public String svy;
    public WebResourceResponse svz;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.f
 * JD-Core Version:    0.7.0.1
 */