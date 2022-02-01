package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public abstract interface e
  extends a
{
  public abstract b R(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract boolean ahB(String paramString);
  
  public abstract String ahC(String paramString);
  
  public abstract boolean ahD(String paramString);
  
  public abstract int ahE(String paramString);
  
  public abstract b ahF(String paramString);
  
  public abstract void ahG(String paramString);
  
  public abstract String ahH(String paramString);
  
  public abstract void cF(String paramString, int paramInt);
  
  public abstract void cu(List<e.a> paramList);
  
  public abstract boolean fd(String paramString1, String paramString2);
  
  public abstract void m(List<e.a> paramList, int paramInt);
  
  public static final class b
  {
    public String appId;
    public int hDa;
    public int pmN;
    public long pmO;
    public String pmP;
    public WebResourceResponse pmQ;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.e
 * JD-Core Version:    0.7.0.1
 */