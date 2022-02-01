package c.t.m.g;

import android.text.TextUtils;

public final class t
{
  private static t b;
  public u a = v.a();
  private s c;
  
  private t()
  {
    b();
  }
  
  public static t a()
  {
    try
    {
      if (b == null) {
        b = new t();
      }
      t localt = b;
      return localt;
    }
    finally {}
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        String str1 = aw.a();
        ax.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:" + str1);
        if ((TextUtils.isEmpty(str1)) || (str1.equals("unknown")))
        {
          ax.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:" + str1);
          return;
        }
        if ((this.c != null) && (this.c.a.equals(str1))) {
          break label162;
        }
        this.c = this.a.a(str1);
        if (this.c != null)
        {
          ax.a("AccessSchedulerStorageManager", "cache succ for current apn:" + str1);
          continue;
        }
        ax.c("AccessSchedulerStorageManager", "cache failed for apn:" + str2);
      }
      finally {}
      continue;
      label162:
      ax.b("AccessSchedulerStorageManager", "same apn. no need update.");
    }
  }
  
  /* Error */
  public final s.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 23	c/t/m/g/t:b	()V
    //   6: aload_0
    //   7: getfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   10: ifnull +40 -> 50
    //   13: aload_0
    //   14: getfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   17: getfield 79	c/t/m/g/s:a	Ljava/lang/String;
    //   20: invokestatic 33	c/t/m/g/aw:a	()Ljava/lang/String;
    //   23: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +24 -> 50
    //   29: aload_0
    //   30: getfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   33: getfield 96	c/t/m/g/s:b	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 102 2 0
    //   42: checkcast 104	c/t/m/g/s$a
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -6 -> 46
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	t
    //   0	60	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	46	55	finally
  }
  
  /* Error */
  public final void a(s params)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: ldc 107
    //   6: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnonnull +13 -> 23
    //   13: ldc 35
    //   15: ldc 109
    //   17: invokestatic 72	c/t/m/g/ax:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   28: aload_0
    //   29: getfield 21	c/t/m/g/t:a	Lc/t/m/g/u;
    //   32: aload_1
    //   33: invokeinterface 111 2 0
    //   38: goto -18 -> 20
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	t
    //   0	46	1	params	s
    // Exception table:
    //   from	to	target	type
    //   2	9	41	finally
    //   13	20	41	finally
    //   23	38	41	finally
  }
  
  /* Error */
  public final boolean a(java.util.Set paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: ldc 114
    //   6: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 23	c/t/m/g/t:b	()V
    //   13: aload_0
    //   14: getfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   17: ifnonnull +16 -> 33
    //   20: ldc 35
    //   22: ldc 116
    //   24: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: iconst_1
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 74	c/t/m/g/t:c	Lc/t/m/g/s;
    //   37: getfield 96	c/t/m/g/s:b	Ljava/util/Map;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnonnull +15 -> 57
    //   45: ldc 35
    //   47: ldc 118
    //   49: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_1
    //   53: istore_2
    //   54: goto -25 -> 29
    //   57: aload_3
    //   58: invokeinterface 122 1 0
    //   63: aload_1
    //   64: invokeinterface 125 1 0
    //   69: if_icmpge +34 -> 103
    //   72: ldc 35
    //   74: new 37	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 127
    //   80: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_3
    //   84: invokeinterface 122 1 0
    //   89: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iconst_1
    //   99: istore_2
    //   100: goto -71 -> 29
    //   103: aload_1
    //   104: invokeinterface 134 1 0
    //   109: astore_1
    //   110: aload_1
    //   111: invokeinterface 140 1 0
    //   116: ifeq +72 -> 188
    //   119: aload_1
    //   120: invokeinterface 144 1 0
    //   125: checkcast 64	java/lang/String
    //   128: astore 4
    //   130: aload_3
    //   131: aload 4
    //   133: invokeinterface 102 2 0
    //   138: checkcast 104	c/t/m/g/s$a
    //   141: astore 5
    //   143: aload 5
    //   145: ifnull +11 -> 156
    //   148: aload 5
    //   150: invokevirtual 146	c/t/m/g/s$a:b	()Z
    //   153: ifeq -43 -> 110
    //   156: ldc 35
    //   158: new 37	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 148
    //   164: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 150
    //   174: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 92	c/t/m/g/ax:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iconst_1
    //   184: istore_2
    //   185: goto -156 -> 29
    //   188: iconst_0
    //   189: istore_2
    //   190: goto -161 -> 29
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	t
    //   0	198	1	paramSet	java.util.Set
    //   28	162	2	bool	boolean
    //   40	91	3	localMap	java.util.Map
    //   128	40	4	str	String
    //   141	8	5	locala	s.a
    // Exception table:
    //   from	to	target	type
    //   2	27	193	finally
    //   33	41	193	finally
    //   45	52	193	finally
    //   57	98	193	finally
    //   103	110	193	finally
    //   110	143	193	finally
    //   148	156	193	finally
    //   156	183	193	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.t
 * JD-Core Version:    0.7.0.1
 */