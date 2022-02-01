package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  private b tvJ;
  private String userAgent;
  
  private h()
  {
    AppMethodBeat.i(24660);
    this.tvJ = j.cUf();
    AppMethodBeat.o(24660);
  }
  
  private void Ha(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24664);
      if (paramInt > bu.getInt(a.tvK.tvQ, 0)) {
        j.cUf().gP(a.tvK.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(24664);
      return;
    }
    finally {}
  }
  
  private static void Hb(int paramInt)
  {
    AppMethodBeat.i(24666);
    if (paramInt > 0) {
      j.cUf().gP(a.tvL.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24666);
  }
  
  private void Hc(int paramInt)
  {
    AppMethodBeat.i(24668);
    if (paramInt > 0) {
      this.tvJ.gP(a.tvM.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24668);
  }
  
  private void akC(String paramString)
  {
    AppMethodBeat.i(24670);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.tvJ.gP(a.tvN.key, paramString);
        AppMethodBeat.o(24670);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24670);
  }
  
  private void akD(String paramString)
  {
    AppMethodBeat.i(24672);
    if (!m.ef(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.tvJ.gP(a.tvO.key, paramString);
        AppMethodBeat.o(24672);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24672);
  }
  
  private void akE(String paramString)
  {
    AppMethodBeat.i(24674);
    if (!m.ef(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.tvJ.gP(a.tvP.key, paramString);
        AppMethodBeat.o(24674);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24674);
  }
  
  private void cTo()
  {
    try
    {
      AppMethodBeat.i(24662);
      try
      {
        String str = this.tvJ.akU(a.tvK.key);
        if ((!m.ef(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.tvK.tvQ).intValue()))
        {
          Hb(Integer.valueOf(a.tvL.tvQ).intValue());
          Hc(Integer.valueOf(a.tvM.tvQ).intValue());
          akD(a.tvO.tvQ);
          akC(a.tvN.tvQ);
          akE(a.tvP.tvQ);
          Ha(Integer.valueOf(a.tvK.tvQ).intValue());
        }
        AppMethodBeat.o(24662);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.m(localException));
          AppMethodBeat.o(24662);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(af paramaf)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(24661);
        cTo();
        if ((paramaf == null) || (paramaf.FJz == null))
        {
          ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(24661);
          return;
        }
        this.tvJ.cUD();
        if (paramaf.FJz.version == -1)
        {
          this.tvJ.bdi();
          ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.tvJ.cUD();
          AppMethodBeat.o(24661);
          continue;
        }
        if (paramaf.FJz.version <= cTp()) {
          break label384;
        }
      }
      finally {}
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramaf.FJz.version), Integer.valueOf(cTp()) });
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramaf.FJz.version);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramaf.FJz.GsX);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramaf.FJz.GsY);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramaf.FJz.dnN);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramaf.FJz.dnM);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramaf.FJz.GsZ);
      Hb(paramaf.FJz.GsX);
      Hc(paramaf.FJz.GsY);
      akD(paramaf.FJz.dnN);
      akC(paramaf.FJz.dnM);
      akE(paramaf.FJz.GsZ);
      Ha(paramaf.FJz.version);
      ae.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.tvJ.cUD();
      label384:
      AppMethodBeat.o(24661);
    }
  }
  
  public final int cTp()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(24663);
        cTo();
      }
      finally {}
      try
      {
        str = this.tvJ.akU(a.tvK.key);
        if (!m.ef(str)) {
          continue;
        }
        i = Integer.valueOf(a.tvK.tvQ).intValue();
        AppMethodBeat.o(24663);
      }
      catch (Exception localException)
      {
        i = bu.getInt(a.tvK.tvQ, 0);
        AppMethodBeat.o(24663);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24663);
    }
  }
  
  public final int cTq()
  {
    AppMethodBeat.i(24665);
    cTo();
    int i;
    try
    {
      String str = this.tvJ.akU(a.tvL.key);
      if (m.ef(str))
      {
        i = Integer.valueOf(a.tvL.tvQ).intValue();
        AppMethodBeat.o(24665);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24665);
      return i;
    }
    catch (Exception localException)
    {
      i = bu.getInt(a.tvL.tvQ, 0);
      AppMethodBeat.o(24665);
    }
    return i;
  }
  
  public final int cTr()
  {
    AppMethodBeat.i(24667);
    cTo();
    int i;
    try
    {
      String str = this.tvJ.akU(a.tvM.key);
      if (m.ef(str))
      {
        i = Integer.valueOf(a.tvM.tvQ).intValue();
        AppMethodBeat.o(24667);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24667);
      return i;
    }
    catch (Exception localException)
    {
      i = bu.getInt(a.tvM.tvQ, 0);
      AppMethodBeat.o(24667);
    }
    return i;
  }
  
  public final String cTs()
  {
    AppMethodBeat.i(24669);
    cTo();
    try
    {
      if ("0".equals(this.tvJ.akU(a.tvN.key)))
      {
        AppMethodBeat.o(24669);
        return "0";
      }
      AppMethodBeat.o(24669);
      return "1";
    }
    catch (Exception localException)
    {
      String str = a.tvN.tvQ;
      AppMethodBeat.o(24669);
      return str;
    }
  }
  
  public final String cTt()
  {
    AppMethodBeat.i(24673);
    cTo();
    try
    {
      String str1 = this.tvJ.akU(a.tvP.key);
      if (m.ef(str1))
      {
        str1 = a.tvP.tvQ;
        AppMethodBeat.o(24673);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24673);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.tvP.tvQ;
      AppMethodBeat.o(24673);
      return str2;
    }
  }
  
  public final String getPingUrl()
  {
    AppMethodBeat.i(24671);
    cTo();
    try
    {
      String str1 = this.tvJ.akU(a.tvO.key);
      if (m.ef(str1))
      {
        str1 = a.tvO.tvQ;
        AppMethodBeat.o(24671);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24671);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.tvO.tvQ;
      AppMethodBeat.o(24671);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(24675);
    if (m.ef(this.userAgent)) {
      this.userAgent = x.bX(ak.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(24675);
    return str;
  }
  
  static enum a
  {
    String key;
    String tvQ;
    
    static
    {
      AppMethodBeat.i(24658);
      tvK = new a("version", 0, "version", "2");
      tvL = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
      tvM = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
      tvN = new a("pingEnabled", 3, "pingEnabled", "1");
      tvO = new a("pingUrl", 4, "pingUrl", "http://o2o.gtimg.com/wifi/echo");
      tvP = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
      tvR = new a[] { tvK, tvL, tvM, tvN, tvO, tvP };
      AppMethodBeat.o(24658);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.tvQ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */