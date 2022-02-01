package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface d
  extends a
{
  public abstract boolean Tm(String paramString);
  
  public abstract boolean Tn(String paramString);
  
  public abstract int To(String paramString);
  
  public abstract b Tp(String paramString);
  
  public abstract void Tq(String paramString);
  
  public abstract String Tr(String paramString);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract void cc(List<a> paramList);
  
  public abstract void cr(String paramString, int paramInt);
  
  public abstract b eA(String paramString1, String paramString2);
  
  public abstract boolean ez(String paramString1, String paramString2);
  
  public abstract void l(List<a> paramList, int paramInt);
  
  public static final class a
  {
    public String appId;
    public String desc;
    public String dsT;
    public String extInfo;
    public int nuJ = 999;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public long nuK;
    public String nuL;
    public WebResourceResponse nuM;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.d
 * JD-Core Version:    0.7.0.1
 */