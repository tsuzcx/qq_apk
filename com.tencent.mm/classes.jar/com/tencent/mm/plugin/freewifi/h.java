package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
{
  private b soo;
  private String userAgent;
  
  private h()
  {
    AppMethodBeat.i(24660);
    this.soo = j.cJl();
    AppMethodBeat.o(24660);
  }
  
  private void Fo(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24664);
      if (paramInt > bs.getInt(a.sop.sov, 0)) {
        j.cJl().gz(a.sop.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(24664);
      return;
    }
    finally {}
  }
  
  private static void Fp(int paramInt)
  {
    AppMethodBeat.i(24666);
    if (paramInt > 0) {
      j.cJl().gz(a.soq.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24666);
  }
  
  private void Fq(int paramInt)
  {
    AppMethodBeat.i(24668);
    if (paramInt > 0) {
      this.soo.gz(a.sor.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(24668);
  }
  
  private void afg(String paramString)
  {
    AppMethodBeat.i(24670);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.soo.gz(a.sos.key, paramString);
        AppMethodBeat.o(24670);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24670);
  }
  
  private void afh(String paramString)
  {
    AppMethodBeat.i(24672);
    if (!m.cX(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.soo.gz(a.sot.key, paramString);
        AppMethodBeat.o(24672);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24672);
  }
  
  private void afi(String paramString)
  {
    AppMethodBeat.i(24674);
    if (!m.cX(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.soo.gz(a.sou.key, paramString);
        AppMethodBeat.o(24674);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(24674);
  }
  
  private void cIu()
  {
    try
    {
      AppMethodBeat.i(24662);
      try
      {
        String str = this.soo.afy(a.sop.key);
        if ((!m.cX(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.sop.sov).intValue()))
        {
          Fp(Integer.valueOf(a.soq.sov).intValue());
          Fq(Integer.valueOf(a.sor.sov).intValue());
          afh(a.sot.sov);
          afg(a.sos.sov);
          afi(a.sou.sov);
          Fo(Integer.valueOf(a.sop.sov).intValue());
        }
        AppMethodBeat.o(24662);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.m(localException));
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
        cIu();
        if ((paramaf == null) || (paramaf.DLW == null))
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(24661);
          return;
        }
        this.soo.cJJ();
        if (paramaf.DLW.version == -1)
        {
          this.soo.aZf();
          ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.soo.cJJ();
          AppMethodBeat.o(24661);
          continue;
        }
        if (paramaf.DLW.version <= cIv()) {
          break label384;
        }
      }
      finally {}
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramaf.DLW.version), Integer.valueOf(cIv()) });
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramaf.DLW.version);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramaf.DLW.EsZ);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramaf.DLW.Eta);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramaf.DLW.dbp);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramaf.DLW.dbo);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramaf.DLW.Etb);
      Fp(paramaf.DLW.EsZ);
      Fq(paramaf.DLW.Eta);
      afh(paramaf.DLW.dbp);
      afg(paramaf.DLW.dbo);
      afi(paramaf.DLW.Etb);
      Fo(paramaf.DLW.version);
      ac.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.soo.cJJ();
      label384:
      AppMethodBeat.o(24661);
    }
  }
  
  public final int cIv()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(24663);
        cIu();
      }
      finally {}
      try
      {
        str = this.soo.afy(a.sop.key);
        if (!m.cX(str)) {
          continue;
        }
        i = Integer.valueOf(a.sop.sov).intValue();
        AppMethodBeat.o(24663);
      }
      catch (Exception localException)
      {
        i = bs.getInt(a.sop.sov, 0);
        AppMethodBeat.o(24663);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24663);
    }
  }
  
  public final int cIw()
  {
    AppMethodBeat.i(24665);
    cIu();
    int i;
    try
    {
      String str = this.soo.afy(a.soq.key);
      if (m.cX(str))
      {
        i = Integer.valueOf(a.soq.sov).intValue();
        AppMethodBeat.o(24665);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24665);
      return i;
    }
    catch (Exception localException)
    {
      i = bs.getInt(a.soq.sov, 0);
      AppMethodBeat.o(24665);
    }
    return i;
  }
  
  public final int cIx()
  {
    AppMethodBeat.i(24667);
    cIu();
    int i;
    try
    {
      String str = this.soo.afy(a.sor.key);
      if (m.cX(str))
      {
        i = Integer.valueOf(a.sor.sov).intValue();
        AppMethodBeat.o(24667);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(24667);
      return i;
    }
    catch (Exception localException)
    {
      i = bs.getInt(a.sor.sov, 0);
      AppMethodBeat.o(24667);
    }
    return i;
  }
  
  public final String cIy()
  {
    AppMethodBeat.i(24669);
    cIu();
    try
    {
      if ("0".equals(this.soo.afy(a.sos.key)))
      {
        AppMethodBeat.o(24669);
        return "0";
      }
      AppMethodBeat.o(24669);
      return "1";
    }
    catch (Exception localException)
    {
      String str = a.sos.sov;
      AppMethodBeat.o(24669);
      return str;
    }
  }
  
  public final String cIz()
  {
    AppMethodBeat.i(24673);
    cIu();
    try
    {
      String str1 = this.soo.afy(a.sou.key);
      if (m.cX(str1))
      {
        str1 = a.sou.sov;
        AppMethodBeat.o(24673);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24673);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.sou.sov;
      AppMethodBeat.o(24673);
      return str2;
    }
  }
  
  public final String getPingUrl()
  {
    AppMethodBeat.i(24671);
    cIu();
    try
    {
      String str1 = this.soo.afy(a.sot.key);
      if (m.cX(str1))
      {
        str1 = a.sot.sov;
        AppMethodBeat.o(24671);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(24671);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = a.sot.sov;
      AppMethodBeat.o(24671);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(24675);
    if (m.cX(this.userAgent)) {
      this.userAgent = x.bS(ai.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(24675);
    return str;
  }
  
  static enum a
  {
    String key;
    String sov;
    
    static
    {
      AppMethodBeat.i(24658);
      sop = new a("version", 0, "version", "2");
      soq = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
      sor = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
      sos = new a("pingEnabled", 3, "pingEnabled", "1");
      sot = new a("pingUrl", 4, "pingUrl", "http://o2o.gtimg.com/wifi/echo");
      sou = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
      sow = new a[] { sop, soq, sor, sos, sot, sou };
      AppMethodBeat.o(24658);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.sov = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */