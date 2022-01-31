package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  private String aRC;
  private b kmC = j.aUj();
  
  private void Di(String paramString)
  {
    if (("0".equals(paramString)) || ("1".equals(paramString))) {}
    try
    {
      this.kmC.dj(a.kmG.key, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void Dj(String paramString)
  {
    if (!m.isEmpty(paramString)) {}
    try
    {
      Uri.parse(paramString);
      this.kmC.dj(a.kmH.key, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void Dk(String paramString)
  {
    if (!m.isEmpty(paramString)) {}
    try
    {
      Uri.parse(paramString);
      this.kmC.dj(a.kmI.key, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void aTo()
  {
    try
    {
      String str = this.kmC.DA(a.kmD.key);
      if ((!m.isEmpty(str)) && (Integer.valueOf(str).intValue() < Integer.valueOf(a.kmD.kmJ).intValue()))
      {
        rn(Integer.valueOf(a.kmE.kmJ).intValue());
        ro(Integer.valueOf(a.kmF.kmJ).intValue());
        Dj(a.kmH.kmJ);
        Di(a.kmG.kmJ);
        Dk(a.kmI.kmJ);
        rm(Integer.valueOf(a.kmD.kmJ).intValue());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.g(localException));
      }
    }
    finally {}
  }
  
  private void rm(int paramInt)
  {
    try
    {
      if (paramInt > Integer.valueOf(a.kmD.kmJ).intValue()) {
        j.aUj().dj(a.kmD.key, String.valueOf(paramInt));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void rn(int paramInt)
  {
    if (paramInt > 0) {
      j.aUj().dj(a.kmE.key, String.valueOf(paramInt));
    }
  }
  
  private void ro(int paramInt)
  {
    if (paramInt > 0) {
      this.kmC.dj(a.kmF.key, String.valueOf(paramInt));
    }
  }
  
  public final void a(ad paramad)
  {
    for (;;)
    {
      try
      {
        aTo();
        if ((paramad == null) || (paramad.ssM == null))
        {
          y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
          return;
        }
        this.kmC.aUJ();
        if (paramad.ssM.version == -1)
        {
          this.kmC.aUK();
          y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
          this.kmC.aUJ();
          continue;
        }
        if (paramad.ssM.version <= aTp()) {
          continue;
        }
      }
      finally {}
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[] { Integer.valueOf(paramad.ssM.version), Integer.valueOf(aTp()) });
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + paramad.ssM.version);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + paramad.ssM.sPj);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + paramad.ssM.sPk);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + paramad.ssM.bHH);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + paramad.ssM.bHG);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + paramad.ssM.sPl);
      rn(paramad.ssM.sPj);
      ro(paramad.ssM.sPk);
      Dj(paramad.ssM.bHH);
      Di(paramad.ssM.bHG);
      Dk(paramad.ssM.sPl);
      rm(paramad.ssM.version);
      y.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
      this.kmC.aUJ();
    }
  }
  
  /* Error */
  public final int aTp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 149	com/tencent/mm/plugin/freewifi/h:aTo	()V
    //   6: aload_0
    //   7: getfield 25	com/tencent/mm/plugin/freewifi/h:kmC	Lcom/tencent/mm/plugin/freewifi/g/b;
    //   10: getstatic 79	com/tencent/mm/plugin/freewifi/h$a:kmD	Lcom/tencent/mm/plugin/freewifi/h$a;
    //   13: getfield 49	com/tencent/mm/plugin/freewifi/h$a:key	Ljava/lang/String;
    //   16: invokevirtual 83	com/tencent/mm/plugin/freewifi/g/b:DA	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 62	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   24: ifeq +20 -> 44
    //   27: getstatic 79	com/tencent/mm/plugin/freewifi/h$a:kmD	Lcom/tencent/mm/plugin/freewifi/h$a;
    //   30: getfield 96	com/tencent/mm/plugin/freewifi/h$a:kmJ	Ljava/lang/String;
    //   33: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   36: invokevirtual 93	java/lang/Integer:intValue	()I
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: aload_2
    //   45: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   48: invokevirtual 93	java/lang/Integer:intValue	()I
    //   51: istore_1
    //   52: goto -12 -> 40
    //   55: astore_2
    //   56: getstatic 79	com/tencent/mm/plugin/freewifi/h$a:kmD	Lcom/tencent/mm/plugin/freewifi/h$a;
    //   59: getfield 96	com/tencent/mm/plugin/freewifi/h$a:kmJ	Ljava/lang/String;
    //   62: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   65: invokevirtual 93	java/lang/Integer:intValue	()I
    //   68: istore_1
    //   69: goto -29 -> 40
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	h
    //   39	30	1	i	int
    //   19	26	2	str	String
    //   55	1	2	localException	Exception
    //   72	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	40	55	java/lang/Exception
    //   44	52	55	java/lang/Exception
    //   2	6	72	finally
    //   6	40	72	finally
    //   44	52	72	finally
    //   56	69	72	finally
  }
  
  public final int aTq()
  {
    aTo();
    try
    {
      String str = this.kmC.DA(a.kmE.key);
      if (m.isEmpty(str)) {
        return Integer.valueOf(a.kmE.kmJ).intValue();
      }
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (Exception localException) {}
    return Integer.valueOf(a.kmE.kmJ).intValue();
  }
  
  public final int aTr()
  {
    aTo();
    try
    {
      String str = this.kmC.DA(a.kmF.key);
      if (m.isEmpty(str)) {
        return Integer.valueOf(a.kmF.kmJ).intValue();
      }
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (Exception localException) {}
    return Integer.valueOf(a.kmF.kmJ).intValue();
  }
  
  public final String aTs()
  {
    aTo();
    try
    {
      if ("0".equals(this.kmC.DA(a.kmG.key))) {
        return "0";
      }
      return "1";
    }
    catch (Exception localException) {}
    return a.kmG.kmJ;
  }
  
  public final String aTt()
  {
    aTo();
    try
    {
      String str = this.kmC.DA(a.kmH.key);
      if (m.isEmpty(str)) {
        return a.kmH.kmJ;
      }
      Uri.parse(str);
      return str;
    }
    catch (Exception localException) {}
    return a.kmH.kmJ;
  }
  
  public final String aTu()
  {
    aTo();
    try
    {
      String str = this.kmC.DA(a.kmI.key);
      if (m.isEmpty(str)) {
        return a.kmI.kmJ;
      }
      Uri.parse(str);
      return str;
    }
    catch (Exception localException) {}
    return a.kmI.kmJ;
  }
  
  public final String getUserAgent()
  {
    if (m.isEmpty(this.aRC)) {
      this.aRC = s.aX(ae.getContext(), null).toLowerCase();
    }
    return this.aRC;
  }
  
  static enum a
  {
    String key;
    String kmJ;
    
    private a(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.kmJ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h
 * JD-Core Version:    0.7.0.1
 */