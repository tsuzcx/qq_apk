package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.cpw;

public abstract interface aa
{
  public abstract void a(b paramb);
  
  public abstract void a(e parame);
  
  public abstract void a(QualitySession paramQualitySession);
  
  public abstract void prepareAsync();
  
  public static final class a
  {
    static aa a(String paramString1, String paramString2, int paramInt1, int paramInt2, b paramb)
    {
      AppMethodBeat.i(186831);
      if (j.a.rq(paramInt1))
      {
        paramString1 = new ap(paramString1, paramString2, paramInt2, paramb);
        AppMethodBeat.o(186831);
        return paramString1;
      }
      paramString1 = new aq(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(186831);
      return paramString1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(WxaPkgLoadProgress paramWxaPkgLoadProgress);
  }
  
  public static final class c
  {
    static aa a(u paramu)
    {
      AppMethodBeat.i(174937);
      if (j.a.rq(paramu.lke.Een))
      {
        paramu = new an(paramu);
        AppMethodBeat.o(174937);
        return paramu;
      }
      paramu = new ao(paramu);
      AppMethodBeat.o(174937);
      return paramu;
    }
  }
  
  public static final class d
  {
    static aa c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(47169);
      if (j.a.rq(paramInt1))
      {
        paramString1 = new ap(paramString1, paramString2, paramInt2, paramInt3);
        AppMethodBeat.o(47169);
        return paramString1;
      }
      paramString1 = new aq(paramString1, paramString2, paramInt1, paramInt3);
      AppMethodBeat.o(47169);
      return paramString1;
    }
  }
  
  public static abstract class e
  {
    public void b(c.a<bhi> parama) {}
    
    void bnw() {}
    
    void bnx() {}
    
    void bny() {}
    
    public void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
    
    void d(WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aa
 * JD-Core Version:    0.7.0.1
 */