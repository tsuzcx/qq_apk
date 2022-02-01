package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface d
  extends a
{
  public abstract boolean WS(String paramString);
  
  public abstract String WT(String paramString);
  
  public abstract boolean WU(String paramString);
  
  public abstract int WV(String paramString);
  
  public abstract b WW(String paramString);
  
  public abstract void WX(String paramString);
  
  public abstract String WY(String paramString);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract void cd(List<a> paramList);
  
  public abstract void cu(String paramString, int paramInt);
  
  public abstract boolean eI(String paramString1, String paramString2);
  
  public abstract b eJ(String paramString1, String paramString2);
  
  public abstract void m(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String dET;
    public String desc;
    public String extInfo;
    public int nWh = 999;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public long nWi;
    public String nWj;
    public WebResourceResponse nWk;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.d
 * JD-Core Version:    0.7.0.1
 */