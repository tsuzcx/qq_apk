package com.tencent.mm.plugin.freewifi.model;

public final class f
{
  private f.b koz;
  
  /* Error */
  public final boolean a(android.net.wifi.WifiInfo paramWifiInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +24 -> 29
    //   8: aload_1
    //   9: invokevirtual 25	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   12: ifnull +17 -> 29
    //   15: aload_1
    //   16: invokevirtual 28	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   19: ifnull +10 -> 29
    //   22: aload_1
    //   23: invokevirtual 31	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   26: ifnonnull +14 -> 40
    //   29: ldc 33
    //   31: ldc 35
    //   33: invokestatic 41	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   44: ifnull +173 -> 217
    //   47: ldc 33
    //   49: ldc 45
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   61: getfield 49	com/tencent/mm/plugin/freewifi/model/f$b:koB	Ljava/lang/String;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_0
    //   68: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   71: getfield 52	com/tencent/mm/plugin/freewifi/model/f$b:koC	Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_1
    //   79: invokevirtual 25	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   82: invokestatic 61	com/tencent/mm/plugin/freewifi/m:Dm	(Ljava/lang/String;)Ljava/lang/String;
    //   85: aload_0
    //   86: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   89: getfield 49	com/tencent/mm/plugin/freewifi/model/f$b:koB	Ljava/lang/String;
    //   92: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +20 -> 115
    //   98: aload_1
    //   99: invokevirtual 28	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   102: aload_0
    //   103: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   106: getfield 52	com/tencent/mm/plugin/freewifi/model/f$b:koC	Ljava/lang/String;
    //   109: invokevirtual 71	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   112: ifne -76 -> 36
    //   115: aload_1
    //   116: invokevirtual 31	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   119: astore 4
    //   121: aload 4
    //   123: astore_3
    //   124: getstatic 77	android/os/Build$VERSION:SDK_INT	I
    //   127: bipush 22
    //   129: if_icmple +25 -> 154
    //   132: aload 4
    //   134: ifnull +16 -> 150
    //   137: aload 4
    //   139: astore_3
    //   140: aload 4
    //   142: ldc 79
    //   144: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifeq +7 -> 154
    //   150: invokestatic 82	com/tencent/mm/plugin/freewifi/m:aTC	()Ljava/lang/String;
    //   153: astore_3
    //   154: aload_0
    //   155: new 9	com/tencent/mm/plugin/freewifi/model/f$b
    //   158: dup
    //   159: aload_1
    //   160: invokevirtual 25	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   163: invokestatic 61	com/tencent/mm/plugin/freewifi/m:Dm	(Ljava/lang/String;)Ljava/lang/String;
    //   166: aload_1
    //   167: invokevirtual 28	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   170: aload_3
    //   171: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   174: iconst_0
    //   175: invokespecial 91	com/tencent/mm/plugin/freewifi/model/f$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JB)V
    //   178: putfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   181: ldc 33
    //   183: ldc 93
    //   185: iconst_2
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   195: getfield 49	com/tencent/mm/plugin/freewifi/model/f$b:koB	Ljava/lang/String;
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: aload_0
    //   202: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   205: getfield 52	com/tencent/mm/plugin/freewifi/model/f$b:koC	Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: iconst_1
    //   213: istore_2
    //   214: goto -178 -> 36
    //   217: ldc 33
    //   219: ldc 95
    //   221: invokestatic 41	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -109 -> 115
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	f
    //   0	232	1	paramWifiInfo	android.net.wifi.WifiInfo
    //   1	213	2	bool	boolean
    //   123	48	3	str1	java.lang.String
    //   119	22	4	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   8	29	227	finally
    //   29	36	227	finally
    //   40	98	227	finally
    //   98	115	227	finally
    //   115	121	227	finally
    //   124	132	227	finally
    //   140	150	227	finally
    //   150	154	227	finally
    //   154	212	227	finally
    //   217	224	227	finally
  }
  
  /* Error */
  public final void aUb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   6: ifnull +49 -> 55
    //   9: ldc 33
    //   11: ldc 45
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   23: getfield 49	com/tencent/mm/plugin/freewifi/model/f$b:koB	Ljava/lang/String;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: aload_0
    //   30: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   33: getfield 52	com/tencent/mm/plugin/freewifi/model/f$b:koC	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   45: ldc 33
    //   47: ldc 98
    //   49: invokestatic 41	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: ldc 33
    //   57: ldc 95
    //   59: invokestatic 41	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -22 -> 40
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	f
    //   65	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	65	finally
    //   40	52	65	finally
    //   55	62	65	finally
  }
  
  public final f.b aUc()
  {
    try
    {
      f.b localb = this.koz;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void aUd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   13: astore_1
    //   14: aload_1
    //   15: getfield 105	com/tencent/mm/plugin/freewifi/model/f$b:koE	Z
    //   18: ifeq +11 -> 29
    //   21: aload_0
    //   22: aload_1
    //   23: putfield 43	com/tencent/mm/plugin/freewifi/model/f:koz	Lcom/tencent/mm/plugin/freewifi/model/f$b;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: new 9	com/tencent/mm/plugin/freewifi/model/f$b
    //   32: dup
    //   33: aload_1
    //   34: getfield 49	com/tencent/mm/plugin/freewifi/model/f$b:koB	Ljava/lang/String;
    //   37: aload_1
    //   38: getfield 52	com/tencent/mm/plugin/freewifi/model/f$b:koC	Ljava/lang/String;
    //   41: aload_1
    //   42: getfield 108	com/tencent/mm/plugin/freewifi/model/f$b:koD	Ljava/lang/String;
    //   45: aload_1
    //   46: getfield 112	com/tencent/mm/plugin/freewifi/model/f$b:kor	J
    //   49: invokespecial 115	com/tencent/mm/plugin/freewifi/model/f$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   52: astore_1
    //   53: aload_1
    //   54: iconst_1
    //   55: putfield 105	com/tencent/mm/plugin/freewifi/model/f$b:koE	Z
    //   58: goto -37 -> 21
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	f
    //   13	41	1	localb	f.b
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	61	finally
    //   21	26	61	finally
    //   29	58	61	finally
  }
  
  private static final class a
  {
    private static f koA = new f((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.f
 * JD-Core Version:    0.7.0.1
 */