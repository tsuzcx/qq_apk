package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  static a iEy;
  
  public static v Iq(String paramString)
  {
    AppMethodBeat.i(221713);
    paramString = a(paramString, null);
    AppMethodBeat.o(221713);
    return paramString;
  }
  
  public static x Ir(String paramString)
  {
    AppMethodBeat.i(132664);
    b localb = new b(paramString);
    paramString = new x(paramString, localb.iEz);
    paramString.iFG = localb.ip;
    if (1 == localb.iEz)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132664);
    return paramString;
  }
  
  public static y Is(String paramString)
  {
    AppMethodBeat.i(132666);
    paramString = new y(paramString);
    AppMethodBeat.o(132666);
    return paramString;
  }
  
  public static int a(w paramw)
  {
    AppMethodBeat.i(132665);
    try
    {
      int i = paramw.getResponseCode();
      if (i != 200)
      {
        AppMethodBeat.o(132665);
        return -1;
      }
      AppMethodBeat.o(132665);
      return 0;
    }
    catch (Exception paramw)
    {
      ad.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bt.n(paramw) });
      AppMethodBeat.o(132665);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132659);
    if ((iEy == null) || (iEy.aiY() == null))
    {
      AppMethodBeat.o(132659);
      return -1;
    }
    int i = iEy.aiY().a(paramString, paramBoolean, paramList);
    AppMethodBeat.o(132659);
    return i;
  }
  
  public static v a(String paramString, b paramb)
  {
    AppMethodBeat.i(132663);
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    ad.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.iEz) });
    paramString = new v(localb.url, localb.iEz);
    paramString.iFz = localb.ip;
    if (1 == localb.iEz)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132663);
    return paramString;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(132657);
    ad.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, bt.flS() });
    iEy = parama;
    AppMethodBeat.o(132657);
  }
  
  public static int b(boolean paramBoolean, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(132658);
    if (iEy == null)
    {
      AppMethodBeat.o(132658);
      return -1;
    }
    try
    {
      int i = iEy.aiY().a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132658);
      return i;
    }
    catch (Exception paramList)
    {
      ad.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bt.n(paramList) });
      AppMethodBeat.o(132658);
    }
    return -1;
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132660);
    if ((iEy != null) && (iEy.aiY() != null)) {
      iEy.aiY().reportFailIp(paramString);
    }
    AppMethodBeat.o(132660);
  }
  
  public static InputStream w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132661);
    paramString = a(paramString, null);
    paramString.setConnectTimeout(paramInt1);
    paramString.setReadTimeout(paramInt2);
    paramString.setRequestMethod("GET");
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
    public abstract e aiY();
  }
  
  public static final class b
  {
    public String host;
    private ArrayList<String> iEA;
    public String iEB;
    public boolean iEC;
    private boolean iED;
    public int iEz;
    public String ip;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(132654);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.iEz = 0;
      this.iEA = new ArrayList();
      this.iEC = false;
      this.iED = false;
      this.iEB = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((b.iEy == null) || (b.iEy.aiY() == null))
        {
          if (b.iEy == null) {}
          for (paramString = "-1";; paramString = b.iEy.aiY())
          {
            ad.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bt.flS() });
            AppMethodBeat.o(132654);
            return;
          }
        }
        this.iEz = b.iEy.aiY().getHostByName(this.host, (List)localObject);
        ad.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.iEz), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.iEz = 0;
          AppMethodBeat.o(132654);
          return;
        }
        int i = this.iEz;
        if (1 != i)
        {
          AppMethodBeat.o(132654);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (It(str)) {
          localObject = "[" + str + "]";
        }
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        AppMethodBeat.o(132654);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bt.n(paramString) });
        AppMethodBeat.o(132654);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132655);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.iEz = 0;
      this.iEA = new ArrayList();
      this.iEC = false;
      this.iED = false;
      this.iEC = paramBoolean;
      this.iEB = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.iEy == null) || (b.iEy.aiY() == null))
        {
          if (b.iEy == null) {}
          for (paramString = "-1";; paramString = b.iEy.aiY())
          {
            ad.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bt.flS() });
            AppMethodBeat.o(132655);
            return;
          }
        }
        this.iEz = b.iEy.aiY().a(this.host, paramBoolean, this.iEA);
        ad.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.iEz), this.host, paramString, this.iEA });
        if (this.iEA.size() <= 0)
        {
          this.iEz = 0;
          AppMethodBeat.o(132655);
          return;
        }
        int i = this.iEz;
        if (1 != i)
        {
          AppMethodBeat.o(132655);
          return;
        }
        this.ip = ((String)this.iEA.remove(0));
        if (It(this.ip)) {
          this.ip = ("[" + this.ip + "]");
        }
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        AppMethodBeat.o(132655);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bt.n(paramString) });
        AppMethodBeat.o(132655);
      }
    }
    
    private static boolean It(String paramString)
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
        ad.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bt.n(localException) });
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
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */