package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  private f.b mKm;
  
  public final boolean T(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20722);
        if (bo.Q(new String[] { paramString1, paramString2, paramString3 }))
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
          AppMethodBeat.o(20722);
          return bool;
        }
        if (this.mKm != null)
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[] { this.mKm.mKo, this.mKm.mKp });
          if ((m.Ou(paramString1).equals(this.mKm.mKo)) && (paramString2.equalsIgnoreCase(this.mKm.mKp))) {
            AppMethodBeat.o(20722);
          }
        }
        else
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
      }
      finally {}
      this.mKm = new f.b(m.Ou(paramString1), paramString2, paramString3, System.currentTimeMillis(), (byte)0);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[] { this.mKm.mKo, this.mKm.mKp });
      AppMethodBeat.o(20722);
      bool = true;
    }
  }
  
  /* Error */
  public final void bAD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20721
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   12: ifnull +55 -> 67
    //   15: ldc 36
    //   17: ldc 50
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   29: getfield 54	com/tencent/mm/plugin/freewifi/model/f$b:mKo	Ljava/lang/String;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_0
    //   36: getfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   39: getfield 57	com/tencent/mm/plugin/freewifi/model/f$b:mKp	Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 60	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   51: ldc 36
    //   53: ldc 90
    //   55: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: sipush 20721
    //   61: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: ldc 36
    //   69: ldc 76
    //   71: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final f.b bAE()
  {
    try
    {
      f.b localb = this.mKm;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void bAF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20723
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   12: ifnull +20 -> 32
    //   15: aload_0
    //   16: getfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   19: astore_1
    //   20: aload_1
    //   21: getfield 97	com/tencent/mm/plugin/freewifi/model/f$b:mKr	Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 48	com/tencent/mm/plugin/freewifi/model/f:mKm	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   32: sipush 20723
    //   35: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 9	com/tencent/mm/plugin/freewifi/model/f$b
    //   44: dup
    //   45: aload_1
    //   46: getfield 54	com/tencent/mm/plugin/freewifi/model/f$b:mKo	Ljava/lang/String;
    //   49: aload_1
    //   50: getfield 57	com/tencent/mm/plugin/freewifi/model/f$b:mKp	Ljava/lang/String;
    //   53: aload_1
    //   54: getfield 100	com/tencent/mm/plugin/freewifi/model/f$b:mKq	Ljava/lang/String;
    //   57: aload_1
    //   58: getfield 104	com/tencent/mm/plugin/freewifi/model/f$b:mKe	J
    //   61: invokespecial 107	com/tencent/mm/plugin/freewifi/model/f$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   64: astore_1
    //   65: aload_1
    //   66: iconst_1
    //   67: putfield 97	com/tencent/mm/plugin/freewifi/model/f$b:mKr	Z
    //   70: goto -43 -> 27
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	f
    //   19	47	1	localb	f.b
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
    private static f mKn;
    
    static
    {
      AppMethodBeat.i(20719);
      mKn = new f((byte)0);
      AppMethodBeat.o(20719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.f
 * JD-Core Version:    0.7.0.1
 */