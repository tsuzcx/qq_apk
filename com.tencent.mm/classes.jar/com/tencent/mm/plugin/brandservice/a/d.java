package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface d
  extends a
{
  public abstract boolean Pc(String paramString);
  
  public abstract boolean Pd(String paramString);
  
  public abstract int Pe(String paramString);
  
  public abstract b Pf(String paramString);
  
  public abstract void Pg(String paramString);
  
  public abstract String Ph(String paramString);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract void cm(String paramString, int paramInt);
  
  public abstract boolean en(String paramString1, String paramString2);
  
  public abstract b eo(String paramString1, String paramString2);
  
  public abstract void l(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String desc;
    public String dvh;
    public int mSu = 999;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public long mSv;
    public String mSw;
    public WebResourceResponse mSx;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.d
 * JD-Core Version:    0.7.0.1
 */