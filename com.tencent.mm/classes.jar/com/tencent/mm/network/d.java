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
  static a pnH;
  
  public static InputStream A(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132661);
    paramString = a(paramString, null);
    if (paramString == null)
    {
      AppMethodBeat.o(132661);
      return null;
    }
    paramString.xx(paramInt1);
    paramString.xy(paramInt2);
    paramString.Rx("GET");
    if (a(paramString) != 0)
    {
      AppMethodBeat.o(132661);
      return null;
    }
    paramString = paramString.getInputStream();
    AppMethodBeat.o(132661);
    return paramString;
  }
  
  public static aa Rt(String paramString)
  {
    AppMethodBeat.i(132664);
    b localb = new b(paramString);
    paramString = new aa(paramString, localb.pnI);
    paramString.ppf = localb.ip;
    if (1 == localb.pnI)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    AppMethodBeat.o(132664);
    return paramString;
  }
  
  public static ab Ru(String paramString)
  {
    AppMethodBeat.i(132666);
    paramString = new ab(paramString);
    AppMethodBeat.o(132666);
    return paramString;
  }
  
  public static int a(z paramz)
  {
    AppMethodBeat.i(132665);
    try
    {
      int i = paramz.getResponseCode();
      if (i != 200)
      {
        AppMethodBeat.o(132665);
        return -1;
      }
      AppMethodBeat.o(132665);
      return 0;
    }
    catch (Exception paramz)
    {
      Log.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { Util.stackTraceToString(paramz) });
      AppMethodBeat.o(132665);
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132659);
    if ((pnH == null) || (pnH.baa() == null))
    {
      AppMethodBeat.o(132659);
      return -1;
    }
    int i = pnH.baa().a(paramString, paramBoolean, paramList);
    AppMethodBeat.o(132659);
    return i;
  }
  
  public static y a(String paramString, b paramb)
  {
    AppMethodBeat.i(132663);
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    Log.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.pnI) });
    paramString = new y(localb.url, localb.pnI);
    paramString.poY = localb.ip;
    if (1 == localb.pnI)
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
    Log.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.FALSE, Util.getStack() });
    pnH = parama;
    AppMethodBeat.o(132657);
  }
  
  public static void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132660);
    if ((pnH != null) && (pnH.baa() != null)) {
      pnH.baa().reportFailIp(paramString);
    }
    AppMethodBeat.o(132660);
  }
  
  public static abstract interface a
  {
    public abstract g baa();
  }
  
  public static final class b
  {
    public String host;
    public String ip;
    public int pnI;
    private ArrayList<String> pnJ;
    public String pnK;
    public boolean pnL;
    private boolean pnM;
    public URL url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(132654);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.pnI = 0;
      this.pnJ = new ArrayList();
      this.pnL = false;
      this.pnM = false;
      this.pnK = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((d.pnH == null) || (d.pnH.baa() == null))
        {
          if (d.pnH == null) {}
          for (paramString = "-1";; paramString = d.pnH.baa())
          {
            Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, Util.getStack() });
            AppMethodBeat.o(132654);
            return;
          }
        }
        this.pnI = d.pnH.baa().getHostByName(this.host, (List)localObject);
        Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.pnI), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.pnI = 0;
          AppMethodBeat.o(132654);
          return;
        }
        int i = this.pnI;
        if (1 != i)
        {
          AppMethodBeat.o(132654);
          return;
        }
        String str = (String)((ArrayList)localObject).remove(0);
        this.ip = str;
        localObject = str;
        if (Rv(str)) {
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
      this.pnI = 0;
      this.pnJ = new ArrayList();
      this.pnL = false;
      this.pnM = false;
      this.pnL = paramBoolean;
      this.pnK = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((d.pnH == null) || (d.pnH.baa() == null))
        {
          if (d.pnH == null) {}
          for (paramString = "-1";; paramString = d.pnH.baa())
          {
            Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, Util.getStack() });
            AppMethodBeat.o(132655);
            return;
          }
        }
        this.pnI = d.pnH.baa().a(this.host, paramBoolean, this.pnJ);
        Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.pnI), this.host, paramString, this.pnJ });
        if (this.pnJ.size() <= 0)
        {
          this.pnI = 0;
          AppMethodBeat.o(132655);
          return;
        }
        int i = this.pnI;
        if (1 != i)
        {
          AppMethodBeat.o(132655);
          return;
        }
        this.ip = ((String)this.pnJ.remove(0));
        if (Rv(this.ip)) {
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
    
    private static boolean Rv(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.d
 * JD-Core Version:    0.7.0.1
 */