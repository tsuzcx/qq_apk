package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  static a mun;
  
  public static x Zp(String paramString)
  {
    AppMethodBeat.i(292907);
    paramString = a(paramString, null);
    AppMethodBeat.o(292907);
    return paramString;
  }
  
  public static z Zq(String paramString)
  {
    AppMethodBeat.i(132664);
    b localb = new b(paramString);
    paramString = new z(paramString, localb.muo);
    paramString.mvG = localb.ip;
    if (1 == localb.muo)
    {
      paramString.bP("Host", localb.host);
      paramString.bP("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132664);
    return paramString;
  }
  
  public static aa Zr(String paramString)
  {
    AppMethodBeat.i(132666);
    paramString = new aa(paramString);
    AppMethodBeat.o(132666);
    return paramString;
  }
  
  public static int a(y paramy)
  {
    AppMethodBeat.i(132665);
    try
    {
      int i = paramy.getResponseCode();
      if (i != 200)
      {
        AppMethodBeat.o(132665);
        return -1;
      }
      AppMethodBeat.o(132665);
      return 0;
    }
    catch (Exception paramy)
    {
      Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(paramy) });
      AppMethodBeat.o(132665);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132659);
    if ((mun == null) || (mun.aHc() == null))
    {
      AppMethodBeat.o(132659);
      return -1;
    }
    int i = mun.aHc().a(paramString, paramBoolean, paramList);
    AppMethodBeat.o(132659);
    return i;
  }
  
  public static x a(String paramString, b paramb)
  {
    AppMethodBeat.i(132663);
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    Log.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.muo) });
    paramString = new x(localb.url, localb.muo);
    paramString.mvz = localb.ip;
    if (1 == localb.muo)
    {
      paramString.bP("Host", localb.host);
      paramString.bP("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132663);
    return paramString;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(132657);
    Log.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, Util.getStack() });
    mun = parama;
    AppMethodBeat.o(132657);
  }
  
  public static int b(boolean paramBoolean, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(132658);
    if (mun == null)
    {
      AppMethodBeat.o(132658);
      return -1;
    }
    try
    {
      int i = mun.aHc().a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132658);
      return i;
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(paramList) });
      AppMethodBeat.o(132658);
    }
    return -1;
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132660);
    if ((mun != null) && (mun.aHc() != null)) {
      mun.aHc().reportFailIp(paramString);
    }
    AppMethodBeat.o(132660);
  }
  
  public static InputStream x(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132661);
    paramString = a(paramString, null);
    paramString.xz(paramInt1);
    paramString.xA(paramInt2);
    paramString.Zu("GET");
    if (a(paramString) != 0)
    {
      AppMethodBeat.o(132661);
      return null;
    }
    paramString = paramString.getInputStream();
    AppMethodBeat.o(132661);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract g aHc();
  }
  
  public static final class b
  {
    public String host;
    public String ip;
    public int muo;
    private ArrayList<String> mup;
    public String muq;
    public boolean mur;
    private boolean mus;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(132654);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.muo = 0;
      this.mup = new ArrayList();
      this.mur = false;
      this.mus = false;
      this.muq = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((d.mun == null) || (d.mun.aHc() == null))
        {
          if (d.mun == null) {}
          for (paramString = "-1";; paramString = d.mun.aHc())
          {
            Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, Util.getStack() });
            AppMethodBeat.o(132654);
            return;
          }
        }
        this.muo = d.mun.aHc().getHostByName(this.host, (List)localObject);
        Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.muo), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.muo = 0;
          AppMethodBeat.o(132654);
          return;
        }
        int i = this.muo;
        if (1 != i)
        {
          AppMethodBeat.o(132654);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (Zs(str)) {
          localObject = "[" + str + "]";
        }
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        AppMethodBeat.o(132654);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(132654);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132655);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.muo = 0;
      this.mup = new ArrayList();
      this.mur = false;
      this.mus = false;
      this.mur = paramBoolean;
      this.muq = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((d.mun == null) || (d.mun.aHc() == null))
        {
          if (d.mun == null) {}
          for (paramString = "-1";; paramString = d.mun.aHc())
          {
            Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, Util.getStack() });
            AppMethodBeat.o(132655);
            return;
          }
        }
        this.muo = d.mun.aHc().a(this.host, paramBoolean, this.mup);
        Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.muo), this.host, paramString, this.mup });
        if (this.mup.size() <= 0)
        {
          this.muo = 0;
          AppMethodBeat.o(132655);
          return;
        }
        int i = this.muo;
        if (1 != i)
        {
          AppMethodBeat.o(132655);
          return;
        }
        this.ip = ((String)this.mup.remove(0));
        if (Zs(this.ip)) {
          this.ip = ("[" + this.ip + "]");
        }
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        AppMethodBeat.o(132655);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(132655);
      }
    }
    
    private static boolean Zs(String paramString)
    {
      AppMethodBeat.i(132656);
      try
      {
        if (!(InetAddress.getByName(paramString) instanceof Inet4Address))
        {
          AppMethodBeat.o(132656);
          return true;
        }
        AppMethodBeat.o(132656);
        return false;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        if (!paramString.contains("."))
        {
          AppMethodBeat.o(132656);
          return true;
        }
        AppMethodBeat.o(132656);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.d
 * JD-Core Version:    0.7.0.1
 */