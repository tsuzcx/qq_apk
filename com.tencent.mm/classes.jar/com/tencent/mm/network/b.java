package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  static a gdm;
  
  public static int a(v paramv)
  {
    AppMethodBeat.i(58458);
    try
    {
      int i = paramv.getResponseCode();
      if (i != 200)
      {
        AppMethodBeat.o(58458);
        return -1;
      }
      AppMethodBeat.o(58458);
      return 0;
    }
    catch (Exception paramv)
    {
      ab.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bo.l(paramv) });
      AppMethodBeat.o(58458);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(58454);
    if ((gdm == null) || (gdm.Rg() == null))
    {
      AppMethodBeat.o(58454);
      return -1;
    }
    int i = gdm.Rg().a(paramString, paramBoolean, paramList);
    AppMethodBeat.o(58454);
    return i;
  }
  
  public static int a(boolean paramBoolean, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(58453);
    if (gdm == null)
    {
      AppMethodBeat.o(58453);
      return -1;
    }
    try
    {
      int i = gdm.Rg().a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(58453);
      return i;
    }
    catch (Exception paramList)
    {
      ab.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bo.l(paramList) });
      AppMethodBeat.o(58453);
    }
    return -1;
  }
  
  public static v a(String paramString, b paramb)
  {
    AppMethodBeat.i(58457);
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    ab.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.gdn) });
    paramString = new v(localb.url, localb.gdn);
    paramString.gek = localb.ip;
    if (1 == localb.gdn)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(58457);
    return paramString;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(58452);
    ab.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, bo.dtY() });
    gdm = parama;
    AppMethodBeat.o(58452);
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(58455);
    if ((gdm != null) && (gdm.Rg() != null)) {
      gdm.Rg().reportFailIp(paramString);
    }
    AppMethodBeat.o(58455);
  }
  
  public static w wb(String paramString)
  {
    AppMethodBeat.i(58459);
    paramString = new w(paramString);
    AppMethodBeat.o(58459);
    return paramString;
  }
  
  public static InputStream x(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(58456);
    paramString = a(paramString, null);
    paramString.setConnectTimeout(paramInt1);
    paramString.setReadTimeout(paramInt2);
    paramString.setRequestMethod("GET");
    if (a(paramString) != 0)
    {
      AppMethodBeat.o(58456);
      return null;
    }
    paramString = paramString.getInputStream();
    AppMethodBeat.o(58456);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract e Rg();
  }
  
  public static final class b
  {
    public int gdn;
    private ArrayList<String> gdo;
    public String gdp;
    public boolean gdq;
    private boolean gdr;
    public String host;
    public String ip;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(58450);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.gdn = 0;
      this.gdo = new ArrayList();
      this.gdq = false;
      this.gdr = false;
      this.gdp = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((b.gdm == null) || (b.gdm.Rg() == null))
        {
          if (b.gdm == null) {}
          for (paramString = "-1";; paramString = b.gdm.Rg())
          {
            ab.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bo.dtY() });
            AppMethodBeat.o(58450);
            return;
          }
        }
        this.gdn = b.gdm.Rg().getHostByName(this.host, (List)localObject);
        ab.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.gdn), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.gdn = 0;
          AppMethodBeat.o(58450);
          return;
        }
        int i = this.gdn;
        if (1 != i)
        {
          AppMethodBeat.o(58450);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (wc(str)) {
          localObject = "[" + str + "]";
        }
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        AppMethodBeat.o(58450);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(58450);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(58451);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.gdn = 0;
      this.gdo = new ArrayList();
      this.gdq = false;
      this.gdr = false;
      this.gdq = paramBoolean;
      this.gdp = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.gdm == null) || (b.gdm.Rg() == null))
        {
          if (b.gdm == null) {}
          for (paramString = "-1";; paramString = b.gdm.Rg())
          {
            ab.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bo.dtY() });
            AppMethodBeat.o(58451);
            return;
          }
        }
        this.gdn = b.gdm.Rg().a(this.host, paramBoolean, this.gdo);
        ab.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.gdn), this.host, paramString, this.gdo });
        if (this.gdo.size() <= 0)
        {
          this.gdn = 0;
          AppMethodBeat.o(58451);
          return;
        }
        int i = this.gdn;
        if (1 != i)
        {
          AppMethodBeat.o(58451);
          return;
        }
        this.ip = ((String)this.gdo.remove(0));
        if (wc(this.ip)) {
          this.ip = ("[" + this.ip + "]");
        }
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        AppMethodBeat.o(58451);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(58451);
      }
    }
    
    private static boolean wc(String paramString)
    {
      AppMethodBeat.i(146147);
      try
      {
        if (!(InetAddress.getByName(paramString) instanceof Inet4Address))
        {
          AppMethodBeat.o(146147);
          return true;
        }
        AppMethodBeat.o(146147);
        return false;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bo.l(localException) });
        if (!paramString.contains("."))
        {
          AppMethodBeat.o(146147);
          return true;
        }
        AppMethodBeat.o(146147);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */