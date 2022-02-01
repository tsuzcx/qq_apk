package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  private b wOI;
  
  public final boolean ao(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(24799);
        if (Util.isNullOrNil(new String[] { paramString1, paramString2, paramString3 }))
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
          AppMethodBeat.o(24799);
          return bool;
        }
        if (this.wOI != null)
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[] { this.wOI.wOK, this.wOI.wOL });
          if ((m.removeSsidQuote(paramString1).equals(this.wOI.wOK)) && (paramString2.equalsIgnoreCase(this.wOI.wOL))) {
            AppMethodBeat.o(24799);
          }
        }
        else
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
      }
      finally {}
      this.wOI = new b(m.removeSsidQuote(paramString1), paramString2, paramString3, System.currentTimeMillis(), (byte)0);
      Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[] { this.wOI.wOK, this.wOI.wOL });
      AppMethodBeat.o(24799);
      bool = true;
    }
  }
  
  /* Error */
  public final void dNg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 24798
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   12: ifnull +55 -> 67
    //   15: ldc 37
    //   17: ldc 51
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   29: getfield 55	com/tencent/mm/plugin/freewifi/model/f$b:wOK	Ljava/lang/String;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_0
    //   36: getfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   39: getfield 58	com/tencent/mm/plugin/freewifi/model/f$b:wOL	Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 61	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   51: ldc 37
    //   53: ldc 91
    //   55: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: sipush 24798
    //   61: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: ldc 37
    //   69: ldc 77
    //   71: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: goto -28 -> 46
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	f
    //   77	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	77	finally
    //   46	64	77	finally
    //   67	74	77	finally
  }
  
  public final b dNh()
  {
    try
    {
      b localb = this.wOI;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void dNi()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 24800
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   12: ifnull +20 -> 32
    //   15: aload_0
    //   16: getfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   19: astore_1
    //   20: aload_1
    //   21: getfield 98	com/tencent/mm/plugin/freewifi/model/f$b:wON	Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 49	com/tencent/mm/plugin/freewifi/model/f:wOI	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   32: sipush 24800
    //   35: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 9	com/tencent/mm/plugin/freewifi/model/f$b
    //   44: dup
    //   45: aload_1
    //   46: getfield 55	com/tencent/mm/plugin/freewifi/model/f$b:wOK	Ljava/lang/String;
    //   49: aload_1
    //   50: getfield 58	com/tencent/mm/plugin/freewifi/model/f$b:wOL	Ljava/lang/String;
    //   53: aload_1
    //   54: getfield 101	com/tencent/mm/plugin/freewifi/model/f$b:wOM	Ljava/lang/String;
    //   57: aload_1
    //   58: getfield 105	com/tencent/mm/plugin/freewifi/model/f$b:wOB	J
    //   61: invokespecial 108	com/tencent/mm/plugin/freewifi/model/f$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   64: astore_1
    //   65: aload_1
    //   66: iconst_1
    //   67: putfield 98	com/tencent/mm/plugin/freewifi/model/f$b:wON	Z
    //   70: goto -43 -> 27
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	f
    //   19	47	1	localb	b
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	73	finally
    //   27	32	73	finally
    //   32	38	73	finally
    //   41	70	73	finally
  }
  
  public static final class a
  {
    private static f wOJ;
    
    static
    {
      AppMethodBeat.i(24796);
      wOJ = new f((byte)0);
      AppMethodBeat.o(24796);
    }
  }
  
  public static final class b
  {
    public long wOB;
    public String wOK;
    public String wOL;
    public String wOM;
    public boolean wON;
    
    b(String paramString1, String paramString2, String paramString3, long paramLong)
    {
      AppMethodBeat.i(24797);
      this.wOK = m.removeSsidQuote(paramString1);
      this.wOL = paramString2;
      this.wOM = paramString3;
      this.wOB = paramLong;
      this.wON = false;
      AppMethodBeat.o(24797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.f
 * JD-Core Version:    0.7.0.1
 */