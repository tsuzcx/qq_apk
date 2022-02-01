package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  static a ilh;
  
  public static v Fc(String paramString)
  {
    AppMethodBeat.i(210306);
    paramString = a(paramString, null);
    AppMethodBeat.o(210306);
    return paramString;
  }
  
  public static x Fd(String paramString)
  {
    AppMethodBeat.i(132664);
    b localb = new b(paramString);
    paramString = new x(paramString, localb.ili);
    paramString.imp = localb.ip;
    if (1 == localb.ili)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132664);
    return paramString;
  }
  
  public static y Fe(String paramString)
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
      ac.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bs.m(paramw) });
      AppMethodBeat.o(132665);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132659);
    if ((ilh == null) || (ilh.agm() == null))
    {
      AppMethodBeat.o(132659);
      return -1;
    }
    int i = ilh.agm().a(paramString, paramBoolean, paramList);
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
    ac.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.ili) });
    paramString = new v(localb.url, localb.ili);
    paramString.imi = localb.ip;
    if (1 == localb.ili)
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
    ac.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, bs.eWi() });
    ilh = parama;
    AppMethodBeat.o(132657);
  }
  
  public static int b(boolean paramBoolean, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(132658);
    if (ilh == null)
    {
      AppMethodBeat.o(132658);
      return -1;
    }
    try
    {
      int i = ilh.agm().a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132658);
      return i;
    }
    catch (Exception paramList)
    {
      ac.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bs.m(paramList) });
      AppMethodBeat.o(132658);
    }
    return -1;
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132660);
    if ((ilh != null) && (ilh.agm() != null)) {
      ilh.agm().reportFailIp(paramString);
    }
    AppMethodBeat.o(132660);
  }
  
  public static InputStream u(String paramString, int paramInt1, int paramInt2)
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
    public abstract e agm();
  }
  
  public static final class b
  {
    public String host;
    public int ili;
    private ArrayList<String> ilj;
    public String ilk;
    public boolean ill;
    private boolean ilm;
    public String ip;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(132654);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.ili = 0;
      this.ilj = new ArrayList();
      this.ill = false;
      this.ilm = false;
      this.ilk = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((b.ilh == null) || (b.ilh.agm() == null))
        {
          if (b.ilh == null) {}
          for (paramString = "-1";; paramString = b.ilh.agm())
          {
            ac.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bs.eWi() });
            AppMethodBeat.o(132654);
            return;
          }
        }
        this.ili = b.ilh.agm().getHostByName(this.host, (List)localObject);
        ac.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.ili), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.ili = 0;
          AppMethodBeat.o(132654);
          return;
        }
        int i = this.ili;
        if (1 != i)
        {
          AppMethodBeat.o(132654);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (Ff(str)) {
          localObject = "[" + str + "]";
        }
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        AppMethodBeat.o(132654);
        return;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bs.m(paramString) });
        AppMethodBeat.o(132654);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132655);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.ili = 0;
      this.ilj = new ArrayList();
      this.ill = false;
      this.ilm = false;
      this.ill = paramBoolean;
      this.ilk = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.ilh == null) || (b.ilh.agm() == null))
        {
          if (b.ilh == null) {}
          for (paramString = "-1";; paramString = b.ilh.agm())
          {
            ac.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bs.eWi() });
            AppMethodBeat.o(132655);
            return;
          }
        }
        this.ili = b.ilh.agm().a(this.host, paramBoolean, this.ilj);
        ac.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.ili), this.host, paramString, this.ilj });
        if (this.ilj.size() <= 0)
        {
          this.ili = 0;
          AppMethodBeat.o(132655);
          return;
        }
        int i = this.ili;
        if (1 != i)
        {
          AppMethodBeat.o(132655);
          return;
        }
        this.ip = ((String)this.ilj.remove(0));
        if (Ff(this.ip)) {
          this.ip = ("[" + this.ip + "]");
        }
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        AppMethodBeat.o(132655);
        return;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bs.m(paramString) });
        AppMethodBeat.o(132655);
      }
    }
    
    private static boolean Ff(String paramString)
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
        ac.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bs.m(localException) });
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