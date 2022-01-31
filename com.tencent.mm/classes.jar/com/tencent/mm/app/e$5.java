package com.tencent.mm.app;

final class e$5
  implements Runnable
{
  private int bwl = 0;
  
  e$5(e parame) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   4: invokestatic 29	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   7: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: aload_0
    //   11: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   14: invokestatic 38	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   17: ifnull +70 -> 87
    //   20: aload_0
    //   21: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   24: invokestatic 38	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   27: invokeinterface 44 1 0
    //   32: ifeq +55 -> 87
    //   35: iconst_1
    //   36: istore_2
    //   37: ldc 46
    //   39: ldc 48
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   51: invokestatic 38	com/tencent/mm/app/e:c	(Lcom/tencent/mm/app/e;)Landroid/os/IBinder;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: iload_2
    //   58: invokestatic 54	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   61: aastore
    //   62: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: iload_2
    //   66: ifeq +26 -> 92
    //   69: ldc 46
    //   71: ldc 62
    //   73: invokestatic 66	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   80: invokestatic 29	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   83: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   86: return
    //   87: iconst_0
    //   88: istore_2
    //   89: goto -52 -> 37
    //   92: aload_0
    //   93: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   96: invokestatic 29	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: ldc 46
    //   104: ldc 71
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: getfield 21	com/tencent/mm/app/e$5:bwl	I
    //   116: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokestatic 85	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield 21	com/tencent/mm/app/e$5:bwl	I
    //   130: iconst_1
    //   131: if_icmpne +42 -> 173
    //   134: ldc 87
    //   136: invokestatic 91	com/tencent/mm/app/e:ck	(Ljava/lang/String;)I
    //   139: istore_1
    //   140: iload_1
    //   141: iconst_m1
    //   142: if_icmpeq +146 -> 288
    //   145: ldc 46
    //   147: ldc 93
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iload_1
    //   156: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: invokestatic 98	com/tencent/mm/sdk/platformtools/y:cqL	()V
    //   169: iload_1
    //   170: invokestatic 104	android/os/Process:killProcess	(I)V
    //   173: invokestatic 110	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   176: astore_3
    //   177: new 112	android/content/Intent
    //   180: dup
    //   181: aload_3
    //   182: ldc 114
    //   184: invokespecial 117	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   187: astore 4
    //   189: ldc 46
    //   191: ldc 119
    //   193: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_3
    //   197: aload_0
    //   198: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   201: invokevirtual 125	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   204: aload_3
    //   205: aload 4
    //   207: invokevirtual 129	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   210: pop
    //   211: aload_3
    //   212: aload 4
    //   214: aload_0
    //   215: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   218: iconst_1
    //   219: invokevirtual 133	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   222: pop
    //   223: aload_3
    //   224: aload 4
    //   226: invokevirtual 137	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   229: pop
    //   230: aload_0
    //   231: getfield 21	com/tencent/mm/app/e$5:bwl	I
    //   234: iconst_1
    //   235: if_icmpne +125 -> 360
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 21	com/tencent/mm/app/e$5:bwl	I
    //   243: aload_0
    //   244: ldc2_w 138
    //   247: invokestatic 145	com/tencent/mm/sdk/platformtools/ai:l	(Ljava/lang/Runnable;J)V
    //   250: ldc 46
    //   252: ldc 147
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_0
    //   261: getfield 21	com/tencent/mm/app/e$5:bwl	I
    //   264: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: return
    //   275: astore_3
    //   276: aload_0
    //   277: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   280: invokestatic 29	com/tencent/mm/app/e:b	(Lcom/tencent/mm/app/e;)Ljava/util/concurrent/locks/ReentrantLock;
    //   283: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   286: aload_3
    //   287: athrow
    //   288: ldc 46
    //   290: ldc 149
    //   292: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: goto -122 -> 173
    //   298: astore 5
    //   300: aload_3
    //   301: aload 4
    //   303: invokevirtual 129	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   306: pop
    //   307: aload_3
    //   308: aload 4
    //   310: aload_0
    //   311: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   314: iconst_1
    //   315: invokevirtual 133	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   318: pop
    //   319: aload_3
    //   320: aload 4
    //   322: invokevirtual 137	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   325: pop
    //   326: goto -96 -> 230
    //   329: astore 5
    //   331: aload_3
    //   332: aload 4
    //   334: invokevirtual 129	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   337: pop
    //   338: aload_3
    //   339: aload 4
    //   341: aload_0
    //   342: getfield 16	com/tencent/mm/app/e$5:bwi	Lcom/tencent/mm/app/e;
    //   345: iconst_1
    //   346: invokevirtual 133	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   349: pop
    //   350: aload_3
    //   351: aload 4
    //   353: invokevirtual 137	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   356: pop
    //   357: aload 5
    //   359: athrow
    //   360: aload_0
    //   361: aload_0
    //   362: getfield 21	com/tencent/mm/app/e$5:bwl	I
    //   365: iconst_1
    //   366: iadd
    //   367: putfield 21	com/tencent/mm/app/e$5:bwl	I
    //   370: goto -127 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	5
    //   139	31	1	i	int
    //   36	53	2	bool	boolean
    //   176	48	3	localContext	android.content.Context
    //   275	76	3	localObject1	Object
    //   187	165	4	localIntent	android.content.Intent
    //   298	1	5	localException	java.lang.Exception
    //   329	29	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	35	275	finally
    //   37	65	275	finally
    //   69	76	275	finally
    //   189	204	298	java/lang/Exception
    //   189	204	329	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.e.5
 * JD-Core Version:    0.7.0.1
 */