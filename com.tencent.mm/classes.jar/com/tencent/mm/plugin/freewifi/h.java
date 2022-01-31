package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class h
{
  private b mIo;
  private String userAgent;
  
  private h()
  {
    AppMethodBeat.i(20583);
    this.mIo = j.bAL();
    AppMethodBeat.o(20583);
  }
  
  private void Oq(String paramString)
  {
    AppMethodBeat.i(20593);
    if (("0".equals(paramString)) || ("1".equals(paramString))) {
      try
      {
        this.mIo.ex(h.a.mIs.key, paramString);
        AppMethodBeat.o(20593);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(20593);
  }
  
  private void Or(String paramString)
  {
    AppMethodBeat.i(20595);
    if (!m.isEmpty(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.mIo.ex(h.a.mIt.key, paramString);
        AppMethodBeat.o(20595);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(20595);
  }
  
  private void Os(String paramString)
  {
    AppMethodBeat.i(20597);
    if (!m.isEmpty(paramString)) {
      try
      {
        Uri.parse(paramString);
        this.mIo.ex(h.a.mIu.key, paramString);
        AppMethodBeat.o(20597);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(20597);
  }
  
  private void bzT()
  {
    try
    {
      AppMethodBeat.i(20585);
      try
      {
        String str = this.mIo.OI(h.a.mIp.key);
        if ((!m.isEmpty(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(h.a.mIp.mIv).intValue()))
        {
          wh(Integer.valueOf(h.a.mIq.mIv).intValue());
          wi(Integer.valueOf(h.a.mIr.mIv).intValue());
          Or(h.a.mIt.mIv);
          Oq(h.a.mIs.mIv);
          Os(h.a.mIu.mIv);
          wg(Integer.valueOf(h.a.mIp.mIv).intValue());
        }
        AppMethodBeat.o(20585);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.f(localException));
          AppMethodBeat.o(20585);
        }
      }
      return;
    }
    finally {}
  }
  
  private void wg(int paramInt)
  {
    try
    {
      AppMethodBeat.i(20587);
      if (paramInt > Integer.valueOf(h.a.mIp.mIv).intValue()) {
        j.bAL().ex(h.a.mIp.key, String.valueOf(paramInt));
      }
      AppMethodBeat.o(20587);
      return;
    }
    finally {}
  }
  
  private static void wh(int paramInt)
  {
    AppMethodBeat.i(20589);
    if (paramInt > 0) {
      j.bAL().ex(h.a.mIq.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(20589);
  }
  
  private void wi(int paramInt)
  {
    AppMethodBeat.i(20591);
    if (paramInt > 0) {
      this.mIo.ex(h.a.mIr.key, String.valueOf(paramInt));
    }
    AppMethodBeat.o(20591);
  }
  
  public final void a(ad paramad)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20584);
        bzT();
        if ((paramad == null) || (paramad.wlr == null))
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          AppMethodBeat.o(20584);
          return;
        }
        this.mIo.bBj();
        if (paramad.wlr.version == -1)
        {
          this.mIo.axH();
          ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.mIo.bBj();
          AppMethodBeat.o(20584);
          continue;
        }
        if (paramad.wlr.version <= bzU()) {
          break label384;
        }
      }
      finally {}
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramad.wlr.version), Integer.valueOf(bzU()) });
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramad.wlr.version);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramad.wlr.wNA);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramad.wlr.wNB);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramad.wlr.coW);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramad.wlr.coV);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramad.wlr.wNC);
      wh(paramad.wlr.wNA);
      wi(paramad.wlr.wNB);
      Or(paramad.wlr.coW);
      Oq(paramad.wlr.coV);
      Os(paramad.wlr.wNC);
      wg(paramad.wlr.version);
      ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.mIo.bBj();
      label384:
      AppMethodBeat.o(20584);
    }
  }
  
  public final int bzU()
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(20586);
        bzT();
      }
      finally {}
      try
      {
        str = this.mIo.OI(h.a.mIp.key);
        if (!m.isEmpty(str)) {
          continue;
        }
        i = Integer.valueOf(h.a.mIp.mIv).intValue();
        AppMethodBeat.o(20586);
      }
      catch (Exception localException)
      {
        i = Integer.valueOf(h.a.mIp.mIv).intValue();
        AppMethodBeat.o(20586);
        continue;
      }
      return i;
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(20586);
    }
  }
  
  public final int bzV()
  {
    AppMethodBeat.i(20588);
    bzT();
    int i;
    try
    {
      String str = this.mIo.OI(h.a.mIq.key);
      if (m.isEmpty(str))
      {
        i = Integer.valueOf(h.a.mIq.mIv).intValue();
        AppMethodBeat.o(20588);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(20588);
      return i;
    }
    catch (Exception localException)
    {
      i = Integer.valueOf(h.a.mIq.mIv).intValue();
      AppMethodBeat.o(20588);
    }
    return i;
  }
  
  public final int bzW()
  {
    AppMethodBeat.i(20590);
    bzT();
    int i;
    try
    {
      String str = this.mIo.OI(h.a.mIr.key);
      if (m.isEmpty(str))
      {
        i = Integer.valueOf(h.a.mIr.mIv).intValue();
        AppMethodBeat.o(20590);
        return i;
      }
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(20590);
      return i;
    }
    catch (Exception localException)
    {
      i = Integer.valueOf(h.a.mIr.mIv).intValue();
      AppMethodBeat.o(20590);
    }
    return i;
  }
  
  public final String bzX()
  {
    AppMethodBeat.i(20592);
    bzT();
    try
    {
      if ("0".equals(this.mIo.OI(h.a.mIs.key)))
      {
        AppMethodBeat.o(20592);
        return "0";
      }
      AppMethodBeat.o(20592);
      return "1";
    }
    catch (Exception localException)
    {
      String str = h.a.mIs.mIv;
      AppMethodBeat.o(20592);
      return str;
    }
  }
  
  public final String bzY()
  {
    AppMethodBeat.i(20594);
    bzT();
    try
    {
      String str1 = this.mIo.OI(h.a.mIt.key);
      if (m.isEmpty(str1))
      {
        str1 = h.a.mIt.mIv;
        AppMethodBeat.o(20594);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(20594);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = h.a.mIt.mIv;
      AppMethodBeat.o(20594);
      return str2;
    }
  }
  
  public final String bzZ()
  {
    AppMethodBeat.i(20596);
    bzT();
    try
    {
      String str1 = this.mIo.OI(h.a.mIu.key);
      if (m.isEmpty(str1))
      {
        str1 = h.a.mIu.mIv;
        AppMethodBeat.o(20596);
        return str1;
      }
      Uri.parse(str1);
      AppMethodBeat.o(20596);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = h.a.mIu.mIv;
      AppMethodBeat.o(20596);
      return str2;
    }
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(20598);
    if (m.isEmpty(this.userAgent)) {
      this.userAgent = u.bD(ah.getContext(), null).toLowerCase();
    }
    String str = this.userAgent;
    AppMethodBeat.o(20598);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */