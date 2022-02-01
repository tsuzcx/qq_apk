package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  private b tkR;
  private String userAgent;
  
  private h()
  {
    AppMethodBeat.i(24660);
    this.tkR = j.cRA();
    AppMethodBeat.o(24660);
  }
  
  private void GD(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24664);
      if (paramInt > bt.getInt(a.tkS.tkY, 0)) {
        j.cRA().gK(a.tkS.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(24664);
      return;
    }
    finally {}
  }
  
  private static void GE(int paramInt)
  {
    AppMethodBeat.i(24666);
    if (paramInt > 0) {
      j.cRA().gK(a.tkT.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24666);
  }
  
  private void GF(int paramInt)
  {
    AppMethodBeat.i(24668);
    if (paramInt > 0) {
      this.tkR.gK(a.tkU.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24668);
  }
  
  private void ajE(String paramString)
  {
    AppMethodBeat.i(24670);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.tkR.gK(a.tkV.key, paramString);
        AppMethodBeat.o(24670);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24670);
  }
  
  private void ajF(String paramString)
  {
    AppMethodBeat.i(24672);
    if (!m.ea(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.tkR.gK(a.tkW.key, paramString);
        AppMethodBeat.o(24672);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24672);
  }
  
  private void ajG(String paramString)
  {
    AppMethodBeat.i(24674);
    if (!m.ea(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.tkR.gK(a.tkX.key, paramString);
        AppMethodBeat.o(24674);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24674);
  }
  
  private void cQJ()
  {
    try
    {
      AppMethodBeat.i(24662);
      try
      {
        String str = this.tkR.ajW(a.tkS.key);
        if ((!m.ea(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.tkS.tkY).intValue()))
        {
          GE(Integer.valueOf(a.tkT.tkY).intValue());
          GF(Integer.valueOf(a.tkU.tkY).intValue());
          ajF(a.tkW.tkY);
          ajE(a.tkV.tkY);
          ajG(a.tkX.tkY);
          GD(Integer.valueOf(a.tkS.tkY).intValue());
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
        cQJ();
        if ((paramaf == null) || (paramaf.Frb == null))
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(24661);
          return;
        }
        this.tkR.cRY();
        if (paramaf.Frb.version == -1)
        {
          this.tkR.bcD();
          ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.tkR.cRY();
          AppMethodBeat.o(24661);
          continue;
        }
        if (paramaf.Frb.version <= cQK()) {
          break label384;
        }
      }
      finally {}
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramaf.Frb.version), Integer.valueOf(cQK()) });
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramaf.Frb.version);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramaf.Frb.Gaq);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramaf.Frb.Gar);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramaf.Frb.dmL);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramaf.Frb.dmK);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramaf.Frb.Gas);
      GE(paramaf.Frb.Gaq);
      GF(paramaf.Frb.Gar);
      ajF(paramaf.Frb.dmL);
      ajE(paramaf.Frb.dmK);
      ajG(paramaf.Frb.Gas);
      GD(paramaf.Frb.version);
      ad.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.tkR.cRY();
      label384:
      AppMethodBeat.o(24661);
    }
  }
  
  public final int cQK()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(24663);
        cQJ();
      }
      finally {}
      try
      {
        str = this.tkR.ajW(a.tkS.key);
        if (!m.ea(str)) {
          continue;
        }
        i = Integer.valueOf(a.tkS.tkY).intValue();
        AppMethodBeat.o(24663);
      }
      catch (Exception localException)
      {
        i = bt.getInt(a.tkS.tkY, 0);
        AppMethodBeat.o(24663);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24663);
    }
  }
  
  public final int cQL()
  {
    AppMethodBeat.i(24665);
    cQJ();
    int i;
    try
    {
      String str = this.tkR.ajW(a.tkT.key);
      if (m.ea(str))
      {
        i = Integer.valueOf(a.tkT.tkY).intValue();
        AppMethodBeat.o(24665);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24665);
      return i;
    }
    catch (Exception localException)
    {
      i = bt.getInt(a.tkT.tkY, 0);
      AppMethodBeat.o(24665);
    }
    return i;
  }
  
  public final int cQM()
  {
    AppMethodBeat.i(24667);
    cQJ();
    int i;
    try
    {
      String str = this.tkR.ajW(a.tkU.key);
      if (m.ea(str))
      {
        i = Integer.valueOf(a.tkU.tkY).intValue();
        AppMethodBeat.o(24667);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24667);
      return i;
    }
    catch (Exception localException)
    {
      i = bt.getInt(a.tkU.tkY, 0);
      AppMethodBeat.o(24667);
    }
    return i;
  }
  
  public final String cQN()
  {
    AppMethodBeat.i(24669);
    cQJ();
    try
    {
      if ("0".equals(this.tkR.ajW(a.tkV.key)))
      {
        AppMethodBeat.o(24669);
        return "0";
      }
      AppMethodBeat.o(24669);
      return "1";
    }
    catch (Exception localException)
    {
      String str = a.tkV.tkY;
      AppMethodBeat.o(24669);
      return str;
    }
  }
  
  public final String cQO()
  {
    AppMethodBeat.i(24673);
    cQJ();
    try
    {
      String str1 = this.tkR.ajW(a.tkX.key);
      if (m.ea(str1))
      {
        str1 = a.tkX.tkY;
        AppMethodBeat.o(24673);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24673);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.tkX.tkY;
      AppMethodBeat.o(24673);
      return str2;
    }
  }
  
  public final String getPingUrl()
  {
    AppMethodBeat.i(24671);
    cQJ();
    try
    {
      String str1 = this.tkR.ajW(a.tkW.key);
      if (m.ea(str1))
      {
        str1 = a.tkW.tkY;
        AppMethodBeat.o(24671);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24671);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.tkW.tkY;
      AppMethodBeat.o(24671);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(24675);
    if (m.ea(this.userAgent)) {
      this.userAgent = x.bW(aj.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(24675);
    return str;
  }
  
  static enum a
  {
    String key;
    String tkY;
    
    static
    {
      AppMethodBeat.i(24658);
      tkS = new a("version", 0, "version", "2");
      tkT = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
      tkU = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
      tkV = new a("pingEnabled", 3, "pingEnabled", "1");
      tkW = new a("pingUrl", 4, "pingUrl", "http://o2o.gtimg.com/wifi/echo");
      tkX = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
      tkZ = new a[] { tkS, tkT, tkU, tkV, tkW, tkX };
      AppMethodBeat.o(24658);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.tkY = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */