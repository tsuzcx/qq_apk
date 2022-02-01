package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  static a iHr;
  
  public static v IS(String paramString)
  {
    AppMethodBeat.i(224422);
    paramString = a(paramString, null);
    AppMethodBeat.o(224422);
    return paramString;
  }
  
  public static x IT(String paramString)
  {
    AppMethodBeat.i(132664);
    b localb = new b(paramString);
    paramString = new x(paramString, localb.iHs);
    paramString.iIz = localb.ip;
    if (1 == localb.iHs)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132664);
    return paramString;
  }
  
  public static y IU(String paramString)
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
      ae.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bu.o(paramw) });
      AppMethodBeat.o(132665);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132659);
    if ((iHr == null) || (iHr.ajn() == null))
    {
      AppMethodBeat.o(132659);
      return -1;
    }
    int i = iHr.ajn().a(paramString, paramBoolean, paramList);
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
    ae.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.iHs) });
    paramString = new v(localb.url, localb.iHs);
    paramString.iIs = localb.ip;
    if (1 == localb.iHs)
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
    ae.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, bu.fpN() });
    iHr = parama;
    AppMethodBeat.o(132657);
  }
  
  public static int b(boolean paramBoolean, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(132658);
    if (iHr == null)
    {
      AppMethodBeat.o(132658);
      return -1;
    }
    try
    {
      int i = iHr.ajn().a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132658);
      return i;
    }
    catch (Exception paramList)
    {
      ae.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bu.o(paramList) });
      AppMethodBeat.o(132658);
    }
    return -1;
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132660);
    if ((iHr != null) && (iHr.ajn() != null)) {
      iHr.ajn().reportFailIp(paramString);
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
    public abstract e ajn();
  }
  
  public static final class b
  {
    public String host;
    public int iHs;
    private ArrayList<String> iHt;
    public String iHu;
    public boolean iHv;
    private boolean iHw;
    public String ip;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(132654);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.iHs = 0;
      this.iHt = new ArrayList();
      this.iHv = false;
      this.iHw = false;
      this.iHu = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((b.iHr == null) || (b.iHr.ajn() == null))
        {
          if (b.iHr == null) {}
          for (paramString = "-1";; paramString = b.iHr.ajn())
          {
            ae.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bu.fpN() });
            AppMethodBeat.o(132654);
            return;
          }
        }
        this.iHs = b.iHr.ajn().getHostByName(this.host, (List)localObject);
        ae.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.iHs), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.iHs = 0;
          AppMethodBeat.o(132654);
          return;
        }
        int i = this.iHs;
        if (1 != i)
        {
          AppMethodBeat.o(132654);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (IV(str)) {
          localObject = "[" + str + "]";
        }
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        AppMethodBeat.o(132654);
        return;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bu.o(paramString) });
        AppMethodBeat.o(132654);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132655);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.iHs = 0;
      this.iHt = new ArrayList();
      this.iHv = false;
      this.iHw = false;
      this.iHv = paramBoolean;
      this.iHu = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.iHr == null) || (b.iHr.ajn() == null))
        {
          if (b.iHr == null) {}
          for (paramString = "-1";; paramString = b.iHr.ajn())
          {
            ae.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bu.fpN() });
            AppMethodBeat.o(132655);
            return;
          }
        }
        this.iHs = b.iHr.ajn().a(this.host, paramBoolean, this.iHt);
        ae.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.iHs), this.host, paramString, this.iHt });
        if (this.iHt.size() <= 0)
        {
          this.iHs = 0;
          AppMethodBeat.o(132655);
          return;
        }
        int i = this.iHs;
        if (1 != i)
        {
          AppMethodBeat.o(132655);
          return;
        }
        this.ip = ((String)this.iHt.remove(0));
        if (IV(this.ip)) {
          this.ip = ("[" + this.ip + "]");
        }
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        AppMethodBeat.o(132655);
        return;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bu.o(paramString) });
        AppMethodBeat.o(132655);
      }
    }
    
    private static boolean IV(String paramString)
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
        ae.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bu.o(localException) });
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