package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b
{
  static a eNy;
  
  public static int a(u paramu)
  {
    int i = 0;
    try
    {
      int j = paramu.getResponseCode();
      if (j != 200) {
        i = -1;
      }
      return i;
    }
    catch (Exception paramu)
    {
      y.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bk.j(paramu) });
    }
    return -3;
  }
  
  public static int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    if ((eNy == null) || (eNy.Do() == null)) {
      return -1;
    }
    return eNy.Do().a(paramString, paramBoolean, paramList);
  }
  
  public static int a(boolean paramBoolean, List<String> paramList, String paramString)
  {
    if (eNy == null) {
      return -1;
    }
    try
    {
      int i = eNy.Do().a(paramString, paramBoolean, paramList);
      return i;
    }
    catch (Exception paramList)
    {
      y.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bk.j(paramList) });
    }
    return -1;
  }
  
  public static u a(String paramString, b paramb)
  {
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    y.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.eNz) });
    paramString = new u(localb.url, localb.eNz);
    paramString.eOw = localb.ip;
    if (1 == localb.eNz)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    return paramString;
  }
  
  public static void a(a parama)
  {
    y.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.valueOf(false), bk.csb() });
    eNy = parama;
  }
  
  public static InputStream n(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString, null);
    paramString.setConnectTimeout(paramInt1);
    paramString.setReadTimeout(paramInt2);
    paramString.setRequestMethod("GET");
    if (a(paramString) != 0) {
      return null;
    }
    return paramString.getInputStream();
  }
  
  public static v oL(String paramString)
  {
    return new v(paramString);
  }
  
  public static void reportFailIp(String paramString)
  {
    if ((eNy != null) && (eNy.Do() != null)) {
      eNy.Do().reportFailIp(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract e Do();
  }
  
  public static final class b
  {
    private ArrayList<String> eNA = new ArrayList();
    public String eNB;
    public boolean eNC = false;
    private boolean eND = false;
    public int eNz = 0;
    public String host = null;
    public String ip = "";
    public URL url = null;
    
    public b(String paramString)
    {
      this.eNB = paramString;
      Object localObject;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        localObject = new ArrayList();
        if ((b.eNy == null) || (b.eNy.Do() == null))
        {
          if (b.eNy == null) {}
          for (paramString = "-1";; paramString = b.eNy.Do())
          {
            y.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bk.csb() });
            return;
          }
        }
        this.eNz = b.eNy.Do().getHostByName(this.host, (List)localObject);
        y.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.eNz), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.eNz = 0;
          return;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bk.j(paramString) });
        return;
      }
      if (1 == this.eNz)
      {
        localObject = (String)((ArrayList)localObject).get((int)(bk.UY() % ((ArrayList)localObject).size()));
        this.ip = ((String)localObject);
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      this.eNC = paramBoolean;
      this.eNB = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.eNy == null) || (b.eNy.Do() == null))
        {
          if (b.eNy == null) {}
          for (paramString = "-1";; paramString = b.eNy.Do())
          {
            y.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bk.csb() });
            return;
          }
        }
        this.eNz = b.eNy.Do().a(this.host, paramBoolean, this.eNA);
        Random localRandom = new Random();
        localRandom.setSeed(bk.UY());
        Collections.shuffle(this.eNA, localRandom);
        y.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.eNz), this.host, paramString, this.eNA });
        if (this.eNA.size() <= 0)
        {
          this.eNz = 0;
          return;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bk.j(paramString) });
        return;
      }
      if (1 == this.eNz)
      {
        this.ip = ((String)this.eNA.remove(0));
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */