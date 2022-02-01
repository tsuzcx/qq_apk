package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class h
{
  private String userAgent;
  private b wMN;
  
  private h()
  {
    AppMethodBeat.i(24660);
    this.wMN = j.dNo();
    AppMethodBeat.o(24660);
  }
  
  private void MZ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24664);
      if (paramInt > Util.getInt(a.wMO.wMU, 0)) {
        j.dNo().hv(a.wMO.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(24664);
      return;
    }
    finally {}
  }
  
  private static void Na(int paramInt)
  {
    AppMethodBeat.i(24666);
    if (paramInt > 0) {
      j.dNo().hv(a.wMP.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24666);
  }
  
  private void Nb(int paramInt)
  {
    AppMethodBeat.i(24668);
    if (paramInt > 0) {
      this.wMN.hv(a.wMQ.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24668);
  }
  
  private void axH(String paramString)
  {
    AppMethodBeat.i(24670);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.wMN.hv(a.wMR.key, paramString);
        AppMethodBeat.o(24670);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24670);
  }
  
  private void axI(String paramString)
  {
    AppMethodBeat.i(24672);
    if (!m.eP(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.wMN.hv(a.wMS.key, paramString);
        AppMethodBeat.o(24672);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24672);
  }
  
  private void axJ(String paramString)
  {
    AppMethodBeat.i(24674);
    if (!m.eP(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.wMN.hv(a.wMT.key, paramString);
        AppMethodBeat.o(24674);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24674);
  }
  
  private void dMx()
  {
    try
    {
      AppMethodBeat.i(24662);
      try
      {
        String str = this.wMN.axY(a.wMO.key);
        if ((!m.eP(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.wMO.wMU).intValue()))
        {
          Na(Integer.valueOf(a.wMP.wMU).intValue());
          Nb(Integer.valueOf(a.wMQ.wMU).intValue());
          axI(a.wMS.wMU);
          axH(a.wMR.wMU);
          axJ(a.wMT.wMU);
          MZ(Integer.valueOf(a.wMO.wMU).intValue());
        }
        AppMethodBeat.o(24662);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.m(localException));
          AppMethodBeat.o(24662);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(ah paramah)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(24661);
        dMx();
        if ((paramah == null) || (paramah.KCR == null))
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(24661);
          return;
        }
        this.wMN.dNM();
        if (paramah.KCR.version == -1)
        {
          this.wMN.byC();
          Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.wMN.dNM();
          AppMethodBeat.o(24661);
          continue;
        }
        if (paramah.KCR.version <= dMy()) {
          break label384;
        }
      }
      finally {}
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramah.KCR.version), Integer.valueOf(dMy()) });
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramah.KCR.version);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramah.KCR.Loq);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramah.KCR.Lor);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramah.KCR.dFc);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramah.KCR.dFb);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramah.KCR.Los);
      Na(paramah.KCR.Loq);
      Nb(paramah.KCR.Lor);
      axI(paramah.KCR.dFc);
      axH(paramah.KCR.dFb);
      axJ(paramah.KCR.Los);
      MZ(paramah.KCR.version);
      Log.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.wMN.dNM();
      label384:
      AppMethodBeat.o(24661);
    }
  }
  
  public final int dMA()
  {
    AppMethodBeat.i(24667);
    dMx();
    int i;
    try
    {
      String str = this.wMN.axY(a.wMQ.key);
      if (m.eP(str))
      {
        i = Integer.valueOf(a.wMQ.wMU).intValue();
        AppMethodBeat.o(24667);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24667);
      return i;
    }
    catch (Exception localException)
    {
      i = Util.getInt(a.wMQ.wMU, 0);
      AppMethodBeat.o(24667);
    }
    return i;
  }
  
  public final String dMB()
  {
    AppMethodBeat.i(24669);
    dMx();
    try
    {
      if ("0".equals(this.wMN.axY(a.wMR.key)))
      {
        AppMethodBeat.o(24669);
        return "0";
      }
      AppMethodBeat.o(24669);
      return "1";
    }
    catch (Exception localException)
    {
      String str = a.wMR.wMU;
      AppMethodBeat.o(24669);
      return str;
    }
  }
  
  public final String dMC()
  {
    AppMethodBeat.i(24673);
    dMx();
    try
    {
      String str1 = this.wMN.axY(a.wMT.key);
      if (m.eP(str1))
      {
        str1 = a.wMT.wMU;
        AppMethodBeat.o(24673);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24673);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.wMT.wMU;
      AppMethodBeat.o(24673);
      return str2;
    }
  }
  
  public final int dMy()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(24663);
        dMx();
      }
      finally {}
      try
      {
        str = this.wMN.axY(a.wMO.key);
        if (!m.eP(str)) {
          continue;
        }
        i = Integer.valueOf(a.wMO.wMU).intValue();
        AppMethodBeat.o(24663);
      }
      catch (Exception localException)
      {
        i = Util.getInt(a.wMO.wMU, 0);
        AppMethodBeat.o(24663);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24663);
    }
  }
  
  public final int dMz()
  {
    AppMethodBeat.i(24665);
    dMx();
    int i;
    try
    {
      String str = this.wMN.axY(a.wMP.key);
      if (m.eP(str))
      {
        i = Integer.valueOf(a.wMP.wMU).intValue();
        AppMethodBeat.o(24665);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24665);
      return i;
    }
    catch (Exception localException)
    {
      i = Util.getInt(a.wMP.wMU, 0);
      AppMethodBeat.o(24665);
    }
    return i;
  }
  
  public final String getPingUrl()
  {
    AppMethodBeat.i(24671);
    dMx();
    try
    {
      String str1 = this.wMN.axY(a.wMS.key);
      if (m.eP(str1))
      {
        str1 = a.wMS.wMU;
        AppMethodBeat.o(24671);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24671);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.wMS.wMU;
      AppMethodBeat.o(24671);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(24675);
    if (m.eP(this.userAgent)) {
      this.userAgent = z.cr(MMApplicationContext.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(24675);
    return str;
  }
  
  static enum a
  {
    String key;
    String wMU;
    
    static
    {
      AppMethodBeat.i(24658);
      wMO = new a("version", 0, "version", "2");
      wMP = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
      wMQ = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
      wMR = new a("pingEnabled", 3, "pingEnabled", "1");
      wMS = new a("pingUrl", 4, "pingUrl", "http://" + WeChatHosts.domainString(2131761727) + "/wifi/echo");
      wMT = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://" + WeChatHosts.domainString(2131761727) + "/wifi/echo.html");
      wMV = new a[] { wMO, wMP, wMQ, wMR, wMS, wMT };
      AppMethodBeat.o(24658);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.wMU = paramString2;
    }
  }
  
  public static final class b
  {
    private static h wMW;
    
    static
    {
      AppMethodBeat.i(24659);
      wMW = new h((byte)0);
      AppMethodBeat.o(24659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */