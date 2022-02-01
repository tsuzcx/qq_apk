package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  private b rfw;
  private String userAgent;
  
  private h()
  {
    AppMethodBeat.i(24660);
    this.rfw = j.cvZ();
    AppMethodBeat.o(24660);
  }
  
  private void Ds(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24664);
      if (paramInt > bt.getInt(a.rfx.rfD, 0)) {
        j.cvZ().gi(a.rfx.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(24664);
      return;
    }
    finally {}
  }
  
  private static void Dt(int paramInt)
  {
    AppMethodBeat.i(24666);
    if (paramInt > 0) {
      j.cvZ().gi(a.rfy.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24666);
  }
  
  private void Du(int paramInt)
  {
    AppMethodBeat.i(24668);
    if (paramInt > 0) {
      this.rfw.gi(a.rfz.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24668);
  }
  
  private void aao(String paramString)
  {
    AppMethodBeat.i(24670);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.rfw.gi(a.rfA.key, paramString);
        AppMethodBeat.o(24670);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24670);
  }
  
  private void aap(String paramString)
  {
    AppMethodBeat.i(24672);
    if (!m.dq(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.rfw.gi(a.rfB.key, paramString);
        AppMethodBeat.o(24672);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24672);
  }
  
  private void aaq(String paramString)
  {
    AppMethodBeat.i(24674);
    if (!m.dq(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.rfw.gi(a.rfC.key, paramString);
        AppMethodBeat.o(24674);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24674);
  }
  
  private void cvi()
  {
    try
    {
      AppMethodBeat.i(24662);
      try
      {
        String str = this.rfw.aaG(a.rfx.key);
        if ((!m.dq(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.rfx.rfD).intValue()))
        {
          Dt(Integer.valueOf(a.rfy.rfD).intValue());
          Du(Integer.valueOf(a.rfz.rfD).intValue());
          aap(a.rfB.rfD);
          aao(a.rfA.rfD);
          aaq(a.rfC.rfD);
          Ds(Integer.valueOf(a.rfx.rfD).intValue());
        }
        AppMethodBeat.o(24662);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.m(localException));
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
        cvi();
        if ((paramaf == null) || (paramaf.CtF == null))
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(24661);
          return;
        }
        this.rfw.cwx();
        if (paramaf.CtF.version == -1)
        {
          this.rfw.aSi();
          ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.rfw.cwx();
          AppMethodBeat.o(24661);
          continue;
        }
        if (paramaf.CtF.version <= cvj()) {
          break label384;
        }
      }
      finally {}
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramaf.CtF.version), Integer.valueOf(cvj()) });
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramaf.CtF.version);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramaf.CtF.Dac);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramaf.CtF.Dad);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramaf.CtF.ddT);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramaf.CtF.ddS);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramaf.CtF.Dae);
      Dt(paramaf.CtF.Dac);
      Du(paramaf.CtF.Dad);
      aap(paramaf.CtF.ddT);
      aao(paramaf.CtF.ddS);
      aaq(paramaf.CtF.Dae);
      Ds(paramaf.CtF.version);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.rfw.cwx();
      label384:
      AppMethodBeat.o(24661);
    }
  }
  
  public final int cvj()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(24663);
        cvi();
      }
      finally {}
      try
      {
        str = this.rfw.aaG(a.rfx.key);
        if (!m.dq(str)) {
          continue;
        }
        i = Integer.valueOf(a.rfx.rfD).intValue();
        AppMethodBeat.o(24663);
      }
      catch (Exception localException)
      {
        i = bt.getInt(a.rfx.rfD, 0);
        AppMethodBeat.o(24663);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24663);
    }
  }
  
  public final int cvk()
  {
    AppMethodBeat.i(24665);
    cvi();
    int i;
    try
    {
      String str = this.rfw.aaG(a.rfy.key);
      if (m.dq(str))
      {
        i = Integer.valueOf(a.rfy.rfD).intValue();
        AppMethodBeat.o(24665);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24665);
      return i;
    }
    catch (Exception localException)
    {
      i = bt.getInt(a.rfy.rfD, 0);
      AppMethodBeat.o(24665);
    }
    return i;
  }
  
  public final int cvl()
  {
    AppMethodBeat.i(24667);
    cvi();
    int i;
    try
    {
      String str = this.rfw.aaG(a.rfz.key);
      if (m.dq(str))
      {
        i = Integer.valueOf(a.rfz.rfD).intValue();
        AppMethodBeat.o(24667);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24667);
      return i;
    }
    catch (Exception localException)
    {
      i = bt.getInt(a.rfz.rfD, 0);
      AppMethodBeat.o(24667);
    }
    return i;
  }
  
  public final String cvm()
  {
    AppMethodBeat.i(24669);
    cvi();
    try
    {
      if ("0".equals(this.rfw.aaG(a.rfA.key)))
      {
        AppMethodBeat.o(24669);
        return "0";
      }
      AppMethodBeat.o(24669);
      return "1";
    }
    catch (Exception localException)
    {
      String str = a.rfA.rfD;
      AppMethodBeat.o(24669);
      return str;
    }
  }
  
  public final String cvn()
  {
    AppMethodBeat.i(24673);
    cvi();
    try
    {
      String str1 = this.rfw.aaG(a.rfC.key);
      if (m.dq(str1))
      {
        str1 = a.rfC.rfD;
        AppMethodBeat.o(24673);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24673);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.rfC.rfD;
      AppMethodBeat.o(24673);
      return str2;
    }
  }
  
  public final String getPingUrl()
  {
    AppMethodBeat.i(24671);
    cvi();
    try
    {
      String str1 = this.rfw.aaG(a.rfB.key);
      if (m.dq(str1))
      {
        str1 = a.rfB.rfD;
        AppMethodBeat.o(24671);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24671);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.rfB.rfD;
      AppMethodBeat.o(24671);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(24675);
    if (m.dq(this.userAgent)) {
      this.userAgent = x.bR(aj.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(24675);
    return str;
  }
  
  static enum a
  {
    String key;
    String rfD;
    
    static
    {
      AppMethodBeat.i(24658);
      rfx = new a("version", 0, "version", "2");
      rfy = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
      rfz = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
      rfA = new a("pingEnabled", 3, "pingEnabled", "1");
      rfB = new a("pingUrl", 4, "pingUrl", "http://o2o.gtimg.com/wifi/echo");
      rfC = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
      rfE = new a[] { rfx, rfy, rfz, rfA, rfB, rfC };
      AppMethodBeat.o(24658);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.rfD = paramString2;
    }
  }
  
  public static final class b
  {
    private static h rfF;
    
    static
    {
      AppMethodBeat.i(24659);
      rfF = new h((byte)0);
      AppMethodBeat.o(24659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */