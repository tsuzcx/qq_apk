package com.tencent.mm.app;

final class e$6
  implements Runnable
{
  private int bXQ = 0;
  
  e$6(e parame) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   9: invokestatic 36	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   12: invokevirtual 41	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   15: aload_0
    //   16: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   19: invokestatic 45	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   22: ifnull +75 -> 97
    //   25: aload_0
    //   26: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   29: invokestatic 45	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   32: invokeinterface 51 1 0
    //   37: ifeq +60 -> 97
    //   40: iconst_1
    //   41: istore_2
    //   42: ldc 53
    //   44: ldc 55
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   56: invokestatic 45	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: iload_2
    //   63: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: invokestatic 66	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: iload_2
    //   71: ifeq +31 -> 102
    //   74: ldc 53
    //   76: ldc 68
    //   78: invokestatic 72	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   85: invokestatic 36	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   91: ldc 26
    //   93: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -57 -> 42
    //   102: aload_0
    //   103: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   106: invokestatic 36	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   109: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   112: ldc 53
    //   114: ldc 80
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: getfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   126: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: getfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   140: iconst_1
    //   141: if_icmpne +42 -> 183
    //   144: ldc 96
    //   146: invokestatic 100	com/tencent/mm/app/e:dv	(Ljava/lang/String;)I
    //   149: istore_1
    //   150: iload_1
    //   151: iconst_m1
    //   152: if_icmpeq +148 -> 300
    //   155: ldc 53
    //   157: ldc 102
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: iload_1
    //   166: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: invokestatic 107	com/tencent/mm/sdk/platformtools/ab:dsI	()V
    //   179: iload_1
    //   180: invokestatic 112	android/os/Process:killProcess	(I)V
    //   183: invokestatic 118	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   186: astore_3
    //   187: new 120	android/content/Intent
    //   190: dup
    //   191: aload_3
    //   192: ldc 122
    //   194: invokespecial 125	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   197: astore 4
    //   199: ldc 53
    //   201: ldc 127
    //   203: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_3
    //   207: aload_0
    //   208: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   211: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   214: invokestatic 138	com/tencent/mm/booter/c:Ii	()Z
    //   217: ifeq +93 -> 310
    //   220: aload_3
    //   221: aload 4
    //   223: aload_0
    //   224: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   227: iconst_1
    //   228: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   231: pop
    //   232: aload_0
    //   233: getfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   236: iconst_1
    //   237: if_icmpne +277 -> 514
    //   240: aload_0
    //   241: iconst_0
    //   242: putfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   245: aload_0
    //   246: ldc2_w 143
    //   249: invokestatic 150	com/tencent/mm/sdk/platformtools/al:p	(Ljava/lang/Runnable;J)V
    //   252: ldc 53
    //   254: ldc 152
    //   256: iconst_1
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_0
    //   263: getfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   266: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   273: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: ldc 26
    //   278: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: astore_3
    //   283: aload_0
    //   284: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   287: invokestatic 36	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   290: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   293: ldc 26
    //   295: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_3
    //   299: athrow
    //   300: ldc 53
    //   302: ldc 154
    //   304: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto -124 -> 183
    //   310: aload_3
    //   311: aload 4
    //   313: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   316: pop
    //   317: aload_3
    //   318: aload 4
    //   320: aload_0
    //   321: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   324: iconst_1
    //   325: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   328: pop
    //   329: aload_3
    //   330: aload 4
    //   332: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   335: pop
    //   336: goto -104 -> 232
    //   339: astore_3
    //   340: ldc 53
    //   342: ldc 164
    //   344: iconst_1
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_3
    //   351: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: aastore
    //   355: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   358: goto -126 -> 232
    //   361: astore 5
    //   363: invokestatic 138	com/tencent/mm/booter/c:Ii	()Z
    //   366: ifeq +40 -> 406
    //   369: aload_3
    //   370: aload 4
    //   372: aload_0
    //   373: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   376: iconst_1
    //   377: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   380: pop
    //   381: goto -149 -> 232
    //   384: astore_3
    //   385: ldc 53
    //   387: ldc 164
    //   389: iconst_1
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload_3
    //   396: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: aastore
    //   400: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: goto -171 -> 232
    //   406: aload_3
    //   407: aload 4
    //   409: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   412: pop
    //   413: aload_3
    //   414: aload 4
    //   416: aload_0
    //   417: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   420: iconst_1
    //   421: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   424: pop
    //   425: aload_3
    //   426: aload 4
    //   428: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   431: pop
    //   432: goto -200 -> 232
    //   435: astore 5
    //   437: invokestatic 138	com/tencent/mm/booter/c:Ii	()Z
    //   440: ifeq +23 -> 463
    //   443: aload_3
    //   444: aload 4
    //   446: aload_0
    //   447: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   450: iconst_1
    //   451: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   454: pop
    //   455: ldc 26
    //   457: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: aload 5
    //   462: athrow
    //   463: aload_3
    //   464: aload 4
    //   466: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   469: pop
    //   470: aload_3
    //   471: aload 4
    //   473: aload_0
    //   474: getfield 16	com/tencent/mm/app/e$6:bXN	Lcom/tencent/mm/app/e;
    //   477: iconst_1
    //   478: invokevirtual 142	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   481: pop
    //   482: aload_3
    //   483: aload 4
    //   485: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   488: pop
    //   489: goto -34 -> 455
    //   492: astore_3
    //   493: ldc 53
    //   495: ldc 164
    //   497: iconst_1
    //   498: anewarray 4	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload_3
    //   504: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   507: aastore
    //   508: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   511: goto -56 -> 455
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   519: iconst_1
    //   520: iadd
    //   521: putfield 21	com/tencent/mm/app/e$6:bXQ	I
    //   524: goto -279 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	6
    //   149	31	1	i	int
    //   41	58	2	bool	boolean
    //   186	35	3	localContext	android.content.Context
    //   282	48	3	localObject1	Object
    //   339	31	3	localException1	java.lang.Exception
    //   384	99	3	localException2	java.lang.Exception
    //   492	12	3	localException3	java.lang.Exception
    //   197	287	4	localIntent	android.content.Intent
    //   361	1	5	localException4	java.lang.Exception
    //   435	26	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	40	282	finally
    //   42	70	282	finally
    //   74	81	282	finally
    //   214	232	339	java/lang/Exception
    //   310	336	339	java/lang/Exception
    //   199	214	361	java/lang/Exception
    //   363	381	384	java/lang/Exception
    //   406	432	384	java/lang/Exception
    //   199	214	435	finally
    //   437	455	492	java/lang/Exception
    //   463	489	492	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.e.6
 * JD-Core Version:    0.7.0.1
 */