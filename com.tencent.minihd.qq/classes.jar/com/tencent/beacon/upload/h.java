package com.tencent.beacon.upload;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.c.a.b;
import com.tencent.beacon.c.a.c;
import com.tencent.beacon.e.d;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements g
{
  private static h a = null;
  private SparseArray<f> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private e d;
  private Context e = null;
  private boolean f = true;
  private int g = 0;
  private boolean h = true;
  
  private h(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null) {}
    for (this.e = localContext;; this.e = paramContext)
    {
      this.f = paramBoolean;
      this.d = e.a(this.e);
      return;
    }
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = com.tencent.beacon.a.g.b(2, paramArrayOfByte);
        paramArrayOfByte = new d();
        paramArrayOfByte.a((byte[])localObject);
        localObject = new c();
        com.tencent.beacon.d.a.b(" covert to ResponsePackage ", new Object[0]);
        paramArrayOfByte = (c)paramArrayOfByte.b("detail", localObject);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext, true);
        com.tencent.beacon.d.a.h(" create uphandler up:true", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static h a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext, paramBoolean);
        com.tencent.beacon.d.a.h(" create uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.b() != paramBoolean)
      {
        a.b(paramBoolean);
        com.tencent.beacon.d.a.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = d();
    if (arrayOfUploadHandleListener != null)
    {
      int j = arrayOfUploadHandleListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUploadHandleListener[i].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private boolean a(SparseArray<f> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (f)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        com.tencent.beacon.d.a.c(" no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      try
      {
        com.tencent.beacon.d.a.a(" process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
        paramSparseArray = new com.tencent.beacon.e.a(paramArrayOfByte);
        paramArrayOfByte = new com.tencent.beacon.c.c.a();
        paramArrayOfByte.a(paramSparseArray);
        if (paramArrayOfByte.a != null)
        {
          com.tencent.beacon.b.a.a(this.e).a(paramArrayOfByte.a);
          com.tencent.beacon.a.a.a(this.e, "QIMEI_DENGTA", paramArrayOfByte.a);
        }
        com.tencent.beacon.d.a.h(" Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s ", new Object[] { paramArrayOfByte.a, paramArrayOfByte.b, paramArrayOfByte.d, paramArrayOfByte.e, paramArrayOfByte.c });
      }
      catch (Throwable paramSparseArray)
      {
        for (;;)
        {
          paramSparseArray.printStackTrace();
        }
      }
      return true;
    }
    try
    {
      com.tencent.beacon.d.a.b(" key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      paramSparseArray.printStackTrace();
      com.tencent.beacon.d.a.d(" handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject = parama.a();
        if (localObject != null)
        {
          com.tencent.beacon.d.a.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((b)localObject).b, ((b)localObject).d, ((b)localObject).c, Integer.valueOf(((b)localObject).f) });
          d locald = new d();
          locald.a(1);
          locald.b("test");
          locald.a("test");
          locald.a("detail", localObject);
          localObject = com.tencent.beacon.a.g.a(2, locald.a());
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   13: invokeinterface 247 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 127	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 251 2 0
    //   34: checkcast 253	[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	h
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private e e()
  {
    try
    {
      e locale = this.d;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<f> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   13: invokevirtual 256	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 258	com/tencent/beacon/d/c
    //   22: dup
    //   23: invokespecial 259	com/tencent/beacon/d/c:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   31: invokestatic 262	com/tencent/beacon/d/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	h
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  public final int a()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 116	com/tencent/beacon/upload/h:b	()Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 268	com/tencent/beacon/upload/h:c	()Z
    //   11: ifne +64 -> 75
    //   14: aload_1
    //   15: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   18: iconst_2
    //   19: if_icmpne +18 -> 37
    //   22: ldc_w 272
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   37: aload_1
    //   38: getfield 275	com/tencent/beacon/upload/a:b	I
    //   41: ifeq +24 -> 65
    //   44: ldc_w 277
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   57: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: return
    //   65: ldc_w 279
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_0
    //   76: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   79: invokestatic 284	com/tencent/beacon/d/b:b	(Landroid/content/Context;)Z
    //   82: ifne +27 -> 109
    //   85: ldc_w 286
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   99: iconst_2
    //   100: if_icmpne -36 -> 64
    //   103: aload_1
    //   104: iconst_0
    //   105: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   108: return
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   114: invokestatic 291	com/tencent/beacon/a/h:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/h;
    //   117: invokevirtual 294	com/tencent/beacon/upload/h:a	(Lcom/tencent/beacon/upload/UploadHandleListener;)Z
    //   120: pop
    //   121: aload_1
    //   122: ifnonnull +14 -> 136
    //   125: ldc_w 296
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: return
    //   136: aload_1
    //   137: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   140: istore 5
    //   142: lconst_0
    //   143: lstore 14
    //   145: lconst_0
    //   146: lstore 12
    //   148: iconst_0
    //   149: istore 20
    //   151: iconst_0
    //   152: istore 16
    //   154: iconst_0
    //   155: istore 19
    //   157: iconst_m1
    //   158: istore 4
    //   160: aload_1
    //   161: invokevirtual 298	com/tencent/beacon/upload/a:e	()Ljava/lang/String;
    //   164: astore 22
    //   166: aload 22
    //   168: ifnull +17 -> 185
    //   171: ldc_w 300
    //   174: aload 22
    //   176: invokevirtual 305	java/lang/String:trim	()Ljava/lang/String;
    //   179: invokevirtual 309	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifeq +40 -> 222
    //   185: ldc_w 311
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   199: iconst_2
    //   200: if_icmpne +8 -> 208
    //   203: aload_1
    //   204: iconst_0
    //   205: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   208: aload_0
    //   209: iload 5
    //   211: iconst_m1
    //   212: lconst_0
    //   213: lconst_0
    //   214: iconst_0
    //   215: ldc_w 313
    //   218: invokespecial 315	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   221: return
    //   222: aload_1
    //   223: invokestatic 317	com/tencent/beacon/upload/h:b	(Lcom/tencent/beacon/upload/a;)[B
    //   226: astore 24
    //   228: aload_1
    //   229: invokevirtual 319	com/tencent/beacon/upload/a:d	()Ljava/lang/String;
    //   232: astore 23
    //   234: aload 22
    //   236: astore 21
    //   238: aload 23
    //   240: ifnull +31 -> 271
    //   243: new 321	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   250: aload 22
    //   252: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 328
    //   258: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 23
    //   263: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore 21
    //   271: ldc_w 331
    //   274: iconst_3
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: iload 5
    //   282: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: aload 21
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: aload_1
    //   294: invokevirtual 194	java/lang/Object:getClass	()Ljava/lang/Class;
    //   297: invokevirtual 200	java/lang/Class:toString	()Ljava/lang/String;
    //   300: aastore
    //   301: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload 24
    //   306: ifnonnull +27 -> 333
    //   309: ldc_w 333
    //   312: iconst_0
    //   313: anewarray 4	java/lang/Object
    //   316: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   319: aload_0
    //   320: iload 5
    //   322: iconst_m1
    //   323: lconst_0
    //   324: lconst_0
    //   325: iconst_0
    //   326: ldc_w 335
    //   329: invokespecial 315	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   332: return
    //   333: aload_0
    //   334: invokespecial 337	com/tencent/beacon/upload/h:e	()Lcom/tencent/beacon/upload/e;
    //   337: astore 25
    //   339: aload 25
    //   341: ifnonnull +27 -> 368
    //   344: ldc_w 339
    //   347: iconst_0
    //   348: anewarray 4	java/lang/Object
    //   351: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: aload_0
    //   355: iload 5
    //   357: iconst_m1
    //   358: lconst_0
    //   359: lconst_0
    //   360: iconst_0
    //   361: ldc_w 341
    //   364: invokespecial 315	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   367: return
    //   368: iload 4
    //   370: istore_2
    //   371: lload 14
    //   373: lstore 8
    //   375: lload 12
    //   377: lstore 10
    //   379: iload 19
    //   381: istore 17
    //   383: iload 20
    //   385: istore 18
    //   387: new 343	com/tencent/beacon/upload/d
    //   390: dup
    //   391: invokespecial 344	com/tencent/beacon/upload/d:<init>	()V
    //   394: astore 23
    //   396: iload 4
    //   398: istore_2
    //   399: lload 14
    //   401: lstore 8
    //   403: lload 12
    //   405: lstore 10
    //   407: iload 19
    //   409: istore 17
    //   411: iload 20
    //   413: istore 18
    //   415: aload 25
    //   417: aload 21
    //   419: aload 24
    //   421: aload 23
    //   423: aload_1
    //   424: invokevirtual 347	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;Lcom/tencent/beacon/upload/a;)[B
    //   427: astore 22
    //   429: aload 22
    //   431: ifnonnull +335 -> 766
    //   434: iload 5
    //   436: bipush 100
    //   438: if_icmpne +1680 -> 2118
    //   441: iload 4
    //   443: istore_2
    //   444: lload 14
    //   446: lstore 8
    //   448: lload 12
    //   450: lstore 10
    //   452: iload 19
    //   454: istore 17
    //   456: iload 20
    //   458: istore 18
    //   460: ldc_w 349
    //   463: aload 21
    //   465: invokevirtual 309	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifne +1650 -> 2118
    //   471: iload 4
    //   473: istore_2
    //   474: lload 14
    //   476: lstore 8
    //   478: lload 12
    //   480: lstore 10
    //   482: iload 19
    //   484: istore 17
    //   486: iload 20
    //   488: istore 18
    //   490: aload 25
    //   492: ldc_w 349
    //   495: aload 24
    //   497: aload 23
    //   499: aload_1
    //   500: invokevirtual 347	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;Lcom/tencent/beacon/upload/a;)[B
    //   503: astore 21
    //   505: iload 4
    //   507: istore_2
    //   508: lload 14
    //   510: lstore 8
    //   512: lload 12
    //   514: lstore 10
    //   516: iload 19
    //   518: istore 17
    //   520: iload 20
    //   522: istore 18
    //   524: aload_0
    //   525: aload_0
    //   526: invokevirtual 351	com/tencent/beacon/upload/h:a	()I
    //   529: iconst_1
    //   530: iadd
    //   531: invokevirtual 352	com/tencent/beacon/upload/h:a	(I)V
    //   534: iload 4
    //   536: istore_2
    //   537: lload 14
    //   539: lstore 8
    //   541: lload 12
    //   543: lstore 10
    //   545: iload 19
    //   547: istore 17
    //   549: iload 20
    //   551: istore 18
    //   553: aload 23
    //   555: invokevirtual 355	com/tencent/beacon/upload/d:a	()J
    //   558: lstore 14
    //   560: iload 4
    //   562: istore_2
    //   563: lload 14
    //   565: lstore 8
    //   567: lload 12
    //   569: lstore 10
    //   571: iload 19
    //   573: istore 17
    //   575: iload 20
    //   577: istore 18
    //   579: aload 23
    //   581: invokevirtual 357	com/tencent/beacon/upload/d:b	()J
    //   584: lstore 12
    //   586: iload 4
    //   588: istore_2
    //   589: lload 14
    //   591: lstore 8
    //   593: lload 12
    //   595: lstore 10
    //   597: iload 19
    //   599: istore 17
    //   601: iload 20
    //   603: istore 18
    //   605: aload 21
    //   607: invokestatic 359	com/tencent/beacon/upload/h:a	([B)Lcom/tencent/beacon/c/a/c;
    //   610: astore 21
    //   612: iload 4
    //   614: istore_3
    //   615: aload 21
    //   617: ifnull +1508 -> 2125
    //   620: iload 4
    //   622: istore_2
    //   623: lload 14
    //   625: lstore 8
    //   627: lload 12
    //   629: lstore 10
    //   631: iload 19
    //   633: istore 17
    //   635: iload 20
    //   637: istore 18
    //   639: aload 21
    //   641: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   644: istore_3
    //   645: iload_3
    //   646: istore_2
    //   647: lload 14
    //   649: lstore 8
    //   651: lload 12
    //   653: lstore 10
    //   655: iload 19
    //   657: istore 17
    //   659: iload 20
    //   661: istore 18
    //   663: aload 21
    //   665: getfield 363	com/tencent/beacon/c/a/c:a	B
    //   668: ifne +1469 -> 2137
    //   671: iconst_1
    //   672: istore 16
    //   674: iload_3
    //   675: istore_2
    //   676: lload 14
    //   678: lstore 8
    //   680: lload 12
    //   682: lstore 10
    //   684: iload 16
    //   686: istore 17
    //   688: iload 16
    //   690: istore 18
    //   692: ldc_w 365
    //   695: iconst_2
    //   696: anewarray 4	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: aload 21
    //   703: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   706: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: aastore
    //   710: dup
    //   711: iconst_1
    //   712: aload 21
    //   714: getfield 363	com/tencent/beacon/c/a/c:a	B
    //   717: invokestatic 370	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   720: aastore
    //   721: invokestatic 89	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   724: goto +1401 -> 2125
    //   727: iload_3
    //   728: istore_2
    //   729: lload 14
    //   731: lstore 8
    //   733: lload 12
    //   735: lstore 10
    //   737: iload 16
    //   739: istore 17
    //   741: iload 16
    //   743: istore 18
    //   745: aload_0
    //   746: iload 5
    //   748: iload_3
    //   749: lload 14
    //   751: lload 12
    //   753: iload 16
    //   755: aconst_null
    //   756: invokespecial 315	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   759: aload_1
    //   760: iload 16
    //   762: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   765: return
    //   766: iload 4
    //   768: istore_2
    //   769: lload 14
    //   771: lstore 8
    //   773: lload 12
    //   775: lstore 10
    //   777: iload 19
    //   779: istore 17
    //   781: iload 20
    //   783: istore 18
    //   785: aload_0
    //   786: iconst_0
    //   787: invokevirtual 352	com/tencent/beacon/upload/h:a	(I)V
    //   790: aload 22
    //   792: astore 21
    //   794: goto -260 -> 534
    //   797: iload_3
    //   798: istore_2
    //   799: lload 14
    //   801: lstore 8
    //   803: lload 12
    //   805: lstore 10
    //   807: iload 16
    //   809: istore 17
    //   811: iload 16
    //   813: istore 18
    //   815: invokestatic 376	com/tencent/beacon/a/e:m	()Lcom/tencent/beacon/a/e;
    //   818: astore 22
    //   820: aload 22
    //   822: ifnull +168 -> 990
    //   825: iload_3
    //   826: istore_2
    //   827: lload 14
    //   829: lstore 8
    //   831: lload 12
    //   833: lstore 10
    //   835: iload 16
    //   837: istore 17
    //   839: iload 16
    //   841: istore 18
    //   843: aload 21
    //   845: getfield 377	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   848: ifnull +34 -> 882
    //   851: iload_3
    //   852: istore_2
    //   853: lload 14
    //   855: lstore 8
    //   857: lload 12
    //   859: lstore 10
    //   861: iload 16
    //   863: istore 17
    //   865: iload 16
    //   867: istore 18
    //   869: aload 22
    //   871: aload 21
    //   873: getfield 377	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   876: invokevirtual 305	java/lang/String:trim	()Ljava/lang/String;
    //   879: invokevirtual 378	com/tencent/beacon/a/e:a	(Ljava/lang/String;)V
    //   882: iload_3
    //   883: istore_2
    //   884: lload 14
    //   886: lstore 8
    //   888: lload 12
    //   890: lstore 10
    //   892: iload 16
    //   894: istore 17
    //   896: iload 16
    //   898: istore 18
    //   900: new 380	java/util/Date
    //   903: dup
    //   904: invokespecial 381	java/util/Date:<init>	()V
    //   907: astore 23
    //   909: iload_3
    //   910: istore_2
    //   911: lload 14
    //   913: lstore 8
    //   915: lload 12
    //   917: lstore 10
    //   919: iload 16
    //   921: istore 17
    //   923: iload 16
    //   925: istore 18
    //   927: aload 22
    //   929: aload 21
    //   931: getfield 384	com/tencent/beacon/c/a/c:g	J
    //   934: aload 23
    //   936: invokevirtual 387	java/util/Date:getTime	()J
    //   939: lsub
    //   940: invokevirtual 390	com/tencent/beacon/a/e:a	(J)V
    //   943: iload_3
    //   944: istore_2
    //   945: lload 14
    //   947: lstore 8
    //   949: lload 12
    //   951: lstore 10
    //   953: iload 16
    //   955: istore 17
    //   957: iload 16
    //   959: istore 18
    //   961: ldc_w 392
    //   964: iconst_2
    //   965: anewarray 4	java/lang/Object
    //   968: dup
    //   969: iconst_0
    //   970: aload 22
    //   972: invokevirtual 394	com/tencent/beacon/a/e:g	()Ljava/lang/String;
    //   975: aastore
    //   976: dup
    //   977: iconst_1
    //   978: aload 22
    //   980: invokevirtual 396	com/tencent/beacon/a/e:h	()J
    //   983: invokestatic 401	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   986: aastore
    //   987: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   990: iload_3
    //   991: istore_2
    //   992: lload 14
    //   994: lstore 8
    //   996: lload 12
    //   998: lstore 10
    //   1000: iload 16
    //   1002: istore 17
    //   1004: iload 16
    //   1006: istore 18
    //   1008: aload 21
    //   1010: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   1013: bipush 101
    //   1015: if_icmpeq +59 -> 1074
    //   1018: iload_3
    //   1019: istore_2
    //   1020: lload 14
    //   1022: lstore 8
    //   1024: lload 12
    //   1026: lstore 10
    //   1028: iload 16
    //   1030: istore 17
    //   1032: iload 16
    //   1034: istore 18
    //   1036: aload 21
    //   1038: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   1041: bipush 103
    //   1043: if_icmpeq +31 -> 1074
    //   1046: iload_3
    //   1047: istore_2
    //   1048: lload 14
    //   1050: lstore 8
    //   1052: lload 12
    //   1054: lstore 10
    //   1056: iload 16
    //   1058: istore 17
    //   1060: iload 16
    //   1062: istore 18
    //   1064: aload 21
    //   1066: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   1069: bipush 105
    //   1071: if_icmpne +270 -> 1341
    //   1074: iload_3
    //   1075: istore_2
    //   1076: lload 14
    //   1078: lstore 8
    //   1080: lload 12
    //   1082: lstore 10
    //   1084: iload 16
    //   1086: istore 17
    //   1088: iload 16
    //   1090: istore 18
    //   1092: aload_0
    //   1093: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1096: invokestatic 406	com/tencent/beacon/a/b/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/c;
    //   1099: invokevirtual 409	com/tencent/beacon/a/b/c:b	()Lcom/tencent/beacon/a/b/e;
    //   1102: astore 22
    //   1104: aload 22
    //   1106: ifnull +235 -> 1341
    //   1109: iload_3
    //   1110: istore_2
    //   1111: lload 14
    //   1113: lstore 8
    //   1115: lload 12
    //   1117: lstore 10
    //   1119: iload 16
    //   1121: istore 17
    //   1123: iload 16
    //   1125: istore 18
    //   1127: aload 22
    //   1129: invokevirtual 415	com/tencent/beacon/a/b/e:j	()B
    //   1132: aload 21
    //   1134: getfield 417	com/tencent/beacon/c/a/c:f	B
    //   1137: if_icmpeq +31 -> 1168
    //   1140: iload_3
    //   1141: istore_2
    //   1142: lload 14
    //   1144: lstore 8
    //   1146: lload 12
    //   1148: lstore 10
    //   1150: iload 16
    //   1152: istore 17
    //   1154: iload 16
    //   1156: istore 18
    //   1158: aload 22
    //   1160: aload 21
    //   1162: getfield 417	com/tencent/beacon/c/a/c:f	B
    //   1165: invokevirtual 420	com/tencent/beacon/a/b/e:b	(B)V
    //   1168: iload_3
    //   1169: istore_2
    //   1170: lload 14
    //   1172: lstore 8
    //   1174: lload 12
    //   1176: lstore 10
    //   1178: iload 16
    //   1180: istore 17
    //   1182: iload 16
    //   1184: istore 18
    //   1186: aload 22
    //   1188: invokevirtual 423	com/tencent/beacon/a/b/e:i	()B
    //   1191: aload 21
    //   1193: getfield 425	com/tencent/beacon/c/a/c:e	B
    //   1196: if_icmpeq +31 -> 1227
    //   1199: iload_3
    //   1200: istore_2
    //   1201: lload 14
    //   1203: lstore 8
    //   1205: lload 12
    //   1207: lstore 10
    //   1209: iload 16
    //   1211: istore 17
    //   1213: iload 16
    //   1215: istore 18
    //   1217: aload 22
    //   1219: aload 21
    //   1221: getfield 425	com/tencent/beacon/c/a/c:e	B
    //   1224: invokevirtual 427	com/tencent/beacon/a/b/e:a	(B)V
    //   1227: iload_3
    //   1228: istore_2
    //   1229: lload 14
    //   1231: lstore 8
    //   1233: lload 12
    //   1235: lstore 10
    //   1237: iload 16
    //   1239: istore 17
    //   1241: iload 16
    //   1243: istore 18
    //   1245: aload 22
    //   1247: invokevirtual 430	com/tencent/beacon/a/b/e:k	()Ljava/lang/String;
    //   1250: ifnull +63 -> 1313
    //   1253: iload_3
    //   1254: istore_2
    //   1255: lload 14
    //   1257: lstore 8
    //   1259: lload 12
    //   1261: lstore 10
    //   1263: iload 16
    //   1265: istore 17
    //   1267: iload 16
    //   1269: istore 18
    //   1271: aload 21
    //   1273: getfield 432	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1276: ifnull +65 -> 1341
    //   1279: iload_3
    //   1280: istore_2
    //   1281: lload 14
    //   1283: lstore 8
    //   1285: lload 12
    //   1287: lstore 10
    //   1289: iload 16
    //   1291: istore 17
    //   1293: iload 16
    //   1295: istore 18
    //   1297: aload 22
    //   1299: invokevirtual 430	com/tencent/beacon/a/b/e:k	()Ljava/lang/String;
    //   1302: aload 21
    //   1304: getfield 432	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1307: invokevirtual 309	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1310: ifne +31 -> 1341
    //   1313: iload_3
    //   1314: istore_2
    //   1315: lload 14
    //   1317: lstore 8
    //   1319: lload 12
    //   1321: lstore 10
    //   1323: iload 16
    //   1325: istore 17
    //   1327: iload 16
    //   1329: istore 18
    //   1331: aload 22
    //   1333: aload 21
    //   1335: getfield 432	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1338: invokevirtual 433	com/tencent/beacon/a/b/e:b	(Ljava/lang/String;)V
    //   1341: iload_3
    //   1342: istore_2
    //   1343: lload 14
    //   1345: lstore 8
    //   1347: lload 12
    //   1349: lstore 10
    //   1351: iload 16
    //   1353: istore 17
    //   1355: iload 16
    //   1357: istore 18
    //   1359: aload 21
    //   1361: getfield 436	com/tencent/beacon/c/a/c:c	[B
    //   1364: astore 22
    //   1366: aload 22
    //   1368: ifnonnull +83 -> 1451
    //   1371: iload_3
    //   1372: istore_2
    //   1373: lload 14
    //   1375: lstore 8
    //   1377: lload 12
    //   1379: lstore 10
    //   1381: iload 16
    //   1383: istore 17
    //   1385: iload 16
    //   1387: istore 18
    //   1389: ldc_w 438
    //   1392: iconst_0
    //   1393: anewarray 4	java/lang/Object
    //   1396: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1399: goto -672 -> 727
    //   1402: astore 21
    //   1404: aload 21
    //   1406: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   1409: aload_0
    //   1410: iload 5
    //   1412: iload_2
    //   1413: lload 8
    //   1415: lload 10
    //   1417: iconst_0
    //   1418: aload 21
    //   1420: invokevirtual 439	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1423: invokespecial 315	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   1426: ldc_w 441
    //   1429: iconst_1
    //   1430: anewarray 4	java/lang/Object
    //   1433: dup
    //   1434: iconst_0
    //   1435: aload 21
    //   1437: invokevirtual 439	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1440: aastore
    //   1441: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1444: aload_1
    //   1445: iload 17
    //   1447: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   1450: return
    //   1451: iload_3
    //   1452: istore_2
    //   1453: lload 14
    //   1455: lstore 8
    //   1457: lload 12
    //   1459: lstore 10
    //   1461: iload 16
    //   1463: istore 17
    //   1465: iload 16
    //   1467: istore 18
    //   1469: aload 22
    //   1471: aload 21
    //   1473: getfield 417	com/tencent/beacon/c/a/c:f	B
    //   1476: aload 21
    //   1478: getfield 425	com/tencent/beacon/c/a/c:e	B
    //   1481: aload 21
    //   1483: getfield 443	com/tencent/beacon/c/a/c:i	Ljava/lang/String;
    //   1486: invokestatic 446	com/tencent/beacon/b/a:b	([BIILjava/lang/String;)[B
    //   1489: astore 22
    //   1491: iload_3
    //   1492: istore_2
    //   1493: lload 14
    //   1495: lstore 8
    //   1497: lload 12
    //   1499: lstore 10
    //   1501: iload 16
    //   1503: istore 17
    //   1505: iload 16
    //   1507: istore 18
    //   1509: aload_0
    //   1510: invokespecial 448	com/tencent/beacon/upload/h:f	()Landroid/util/SparseArray;
    //   1513: astore 23
    //   1515: aload 23
    //   1517: ifnull +29 -> 1546
    //   1520: iload_3
    //   1521: istore_2
    //   1522: lload 14
    //   1524: lstore 8
    //   1526: lload 12
    //   1528: lstore 10
    //   1530: iload 16
    //   1532: istore 17
    //   1534: iload 16
    //   1536: istore 18
    //   1538: aload 23
    //   1540: invokevirtual 256	android/util/SparseArray:size	()I
    //   1543: ifgt +45 -> 1588
    //   1546: iload_3
    //   1547: istore_2
    //   1548: lload 14
    //   1550: lstore 8
    //   1552: lload 12
    //   1554: lstore 10
    //   1556: iload 16
    //   1558: istore 17
    //   1560: iload 16
    //   1562: istore 18
    //   1564: ldc_w 450
    //   1567: iconst_0
    //   1568: anewarray 4	java/lang/Object
    //   1571: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1574: goto -847 -> 727
    //   1577: astore 21
    //   1579: aload_1
    //   1580: iload 18
    //   1582: invokevirtual 273	com/tencent/beacon/upload/a:b	(Z)V
    //   1585: aload 21
    //   1587: athrow
    //   1588: iload_3
    //   1589: istore_2
    //   1590: lload 14
    //   1592: lstore 8
    //   1594: lload 12
    //   1596: lstore 10
    //   1598: iload 16
    //   1600: istore 17
    //   1602: iload 16
    //   1604: istore 18
    //   1606: aload_1
    //   1607: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   1610: istore 4
    //   1612: iload_3
    //   1613: istore_2
    //   1614: lload 14
    //   1616: lstore 8
    //   1618: lload 12
    //   1620: lstore 10
    //   1622: iload 16
    //   1624: istore 17
    //   1626: iload 16
    //   1628: istore 18
    //   1630: aload 21
    //   1632: getfield 360	com/tencent/beacon/c/a/c:b	I
    //   1635: istore 6
    //   1637: iload_3
    //   1638: istore_2
    //   1639: lload 14
    //   1641: lstore 8
    //   1643: lload 12
    //   1645: lstore 10
    //   1647: iload 16
    //   1649: istore 17
    //   1651: iload 16
    //   1653: istore 18
    //   1655: aload 21
    //   1657: getfield 363	com/tencent/beacon/c/a/c:a	B
    //   1660: istore 7
    //   1662: iload 7
    //   1664: ifne +171 -> 1835
    //   1667: iload 4
    //   1669: ifle +166 -> 1835
    //   1672: iload 4
    //   1674: iconst_5
    //   1675: if_icmpgt +160 -> 1835
    //   1678: iload_3
    //   1679: istore_2
    //   1680: lload 14
    //   1682: lstore 8
    //   1684: lload 12
    //   1686: lstore 10
    //   1688: iload 16
    //   1690: istore 17
    //   1692: iload 16
    //   1694: istore 18
    //   1696: ldc_w 300
    //   1699: aload_0
    //   1700: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1703: ldc 173
    //   1705: ldc_w 300
    //   1708: invokestatic 453	com/tencent/beacon/a/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1711: invokevirtual 309	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1714: ifeq +121 -> 1835
    //   1717: iload_3
    //   1718: istore_2
    //   1719: lload 14
    //   1721: lstore 8
    //   1723: lload 12
    //   1725: lstore 10
    //   1727: iload 16
    //   1729: istore 17
    //   1731: iload 16
    //   1733: istore 18
    //   1735: invokestatic 455	com/tencent/beacon/a/b/e:a	()Lcom/tencent/beacon/a/b/e;
    //   1738: invokevirtual 457	com/tencent/beacon/a/b/e:h	()Z
    //   1741: ifne +94 -> 1835
    //   1744: iload_3
    //   1745: istore_2
    //   1746: lload 14
    //   1748: lstore 8
    //   1750: lload 12
    //   1752: lstore 10
    //   1754: iload 16
    //   1756: istore 17
    //   1758: iload 16
    //   1760: istore 18
    //   1762: new 459	com/tencent/beacon/upload/c
    //   1765: dup
    //   1766: aload_0
    //   1767: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1770: invokespecial 462	com/tencent/beacon/upload/c:<init>	(Landroid/content/Context;)V
    //   1773: astore 21
    //   1775: iload_3
    //   1776: istore_2
    //   1777: lload 14
    //   1779: lstore 8
    //   1781: lload 12
    //   1783: lstore 10
    //   1785: iload 16
    //   1787: istore 17
    //   1789: iload 16
    //   1791: istore 18
    //   1793: invokestatic 465	com/tencent/beacon/a/b/c:a	()Lcom/tencent/beacon/upload/g;
    //   1796: aload 21
    //   1798: invokeinterface 467 2 0
    //   1803: iload_3
    //   1804: istore_2
    //   1805: lload 14
    //   1807: lstore 8
    //   1809: lload 12
    //   1811: lstore 10
    //   1813: iload 16
    //   1815: istore 17
    //   1817: iload 16
    //   1819: istore 18
    //   1821: aload_0
    //   1822: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1825: ldc_w 469
    //   1828: invokestatic 470	com/tencent/beacon/b/a:g	()Ljava/lang/String;
    //   1831: invokestatic 178	com/tencent/beacon/a/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1834: pop
    //   1835: iload 6
    //   1837: ifne +306 -> 2143
    //   1840: iload_3
    //   1841: istore_2
    //   1842: lload 14
    //   1844: lstore 8
    //   1846: lload 12
    //   1848: lstore 10
    //   1850: iload 16
    //   1852: istore 17
    //   1854: iload 16
    //   1856: istore 18
    //   1858: ldc_w 472
    //   1861: iconst_0
    //   1862: anewarray 4	java/lang/Object
    //   1865: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1868: goto -1141 -> 727
    //   1871: iload_3
    //   1872: istore_2
    //   1873: lload 14
    //   1875: lstore 8
    //   1877: lload 12
    //   1879: lstore 10
    //   1881: iload 16
    //   1883: istore 17
    //   1885: iload 16
    //   1887: istore 18
    //   1889: ldc_w 474
    //   1892: iconst_1
    //   1893: anewarray 4	java/lang/Object
    //   1896: dup
    //   1897: iconst_0
    //   1898: iload 4
    //   1900: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1903: aastore
    //   1904: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1907: goto -1180 -> 727
    //   1910: iload 6
    //   1912: bipush 101
    //   1914: if_icmpeq +158 -> 2072
    //   1917: iload_3
    //   1918: istore_2
    //   1919: lload 14
    //   1921: lstore 8
    //   1923: lload 12
    //   1925: lstore 10
    //   1927: iload 16
    //   1929: istore 17
    //   1931: iload 16
    //   1933: istore 18
    //   1935: ldc_w 476
    //   1938: iconst_2
    //   1939: anewarray 4	java/lang/Object
    //   1942: dup
    //   1943: iconst_0
    //   1944: iload 4
    //   1946: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1949: aastore
    //   1950: dup
    //   1951: iconst_1
    //   1952: iload 6
    //   1954: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1957: aastore
    //   1958: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1961: goto -1234 -> 727
    //   1964: iload 6
    //   1966: bipush 105
    //   1968: if_icmpeq +104 -> 2072
    //   1971: iload_3
    //   1972: istore_2
    //   1973: lload 14
    //   1975: lstore 8
    //   1977: lload 12
    //   1979: lstore 10
    //   1981: iload 16
    //   1983: istore 17
    //   1985: iload 16
    //   1987: istore 18
    //   1989: ldc_w 476
    //   1992: iconst_2
    //   1993: anewarray 4	java/lang/Object
    //   1996: dup
    //   1997: iconst_0
    //   1998: iload 4
    //   2000: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2003: aastore
    //   2004: dup
    //   2005: iconst_1
    //   2006: iload 6
    //   2008: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2011: aastore
    //   2012: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2015: goto -1288 -> 727
    //   2018: iload 6
    //   2020: bipush 103
    //   2022: if_icmpeq +50 -> 2072
    //   2025: iload_3
    //   2026: istore_2
    //   2027: lload 14
    //   2029: lstore 8
    //   2031: lload 12
    //   2033: lstore 10
    //   2035: iload 16
    //   2037: istore 17
    //   2039: iload 16
    //   2041: istore 18
    //   2043: ldc_w 478
    //   2046: iconst_2
    //   2047: anewarray 4	java/lang/Object
    //   2050: dup
    //   2051: iconst_0
    //   2052: iload 4
    //   2054: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2057: aastore
    //   2058: dup
    //   2059: iconst_1
    //   2060: iload 6
    //   2062: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2065: aastore
    //   2066: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2069: goto -1342 -> 727
    //   2072: iload_3
    //   2073: istore_2
    //   2074: lload 14
    //   2076: lstore 8
    //   2078: lload 12
    //   2080: lstore 10
    //   2082: iload 16
    //   2084: istore 17
    //   2086: iload 16
    //   2088: istore 18
    //   2090: aload_0
    //   2091: aload 23
    //   2093: iload 6
    //   2095: aload 22
    //   2097: invokespecial 480	com/tencent/beacon/upload/h:a	(Landroid/util/SparseArray;I[B)Z
    //   2100: pop
    //   2101: goto -1374 -> 727
    //   2104: astore 21
    //   2106: iload 17
    //   2108: istore 18
    //   2110: goto -531 -> 1579
    //   2113: astore 21
    //   2115: goto -280 -> 1835
    //   2118: aload 22
    //   2120: astore 21
    //   2122: goto -1617 -> 505
    //   2125: aload_1
    //   2126: ifnull -1399 -> 727
    //   2129: aload 21
    //   2131: ifnonnull -1334 -> 797
    //   2134: goto -1407 -> 727
    //   2137: iconst_0
    //   2138: istore 16
    //   2140: goto -1466 -> 674
    //   2143: iload 4
    //   2145: lookupswitch	default:+35->2180, 4:+-181->1964, 100:+-235->1910, 102:+-127->2018
    //   2181: impdep1
    //   2182: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2183	0	this	h
    //   0	2183	1	parama	a
    //   370	1704	2	i	int
    //   614	1459	3	j	int
    //   158	1986	4	k	int
    //   140	1271	5	m	int
    //   1635	459	6	n	int
    //   1660	3	7	i1	int
    //   373	1704	8	l1	long
    //   377	1704	10	l2	long
    //   146	1933	12	l3	long
    //   143	1932	14	l4	long
    //   152	1987	16	bool1	boolean
    //   381	1726	17	bool2	boolean
    //   385	1724	18	bool3	boolean
    //   155	623	19	bool4	boolean
    //   149	633	20	bool5	boolean
    //   236	1124	21	localObject1	Object
    //   1402	80	21	localThrowable	Throwable
    //   1577	79	21	localObject2	Object
    //   1773	24	21	localc	c
    //   2104	1	21	localObject3	Object
    //   2113	1	21	localException	java.lang.Exception
    //   2120	10	21	localObject4	Object
    //   164	1955	22	localObject5	Object
    //   232	1860	23	localObject6	Object
    //   226	270	24	arrayOfByte	byte[]
    //   337	154	25	locale	e
    // Exception table:
    //   from	to	target	type
    //   387	396	1402	java/lang/Throwable
    //   415	429	1402	java/lang/Throwable
    //   460	471	1402	java/lang/Throwable
    //   490	505	1402	java/lang/Throwable
    //   524	534	1402	java/lang/Throwable
    //   553	560	1402	java/lang/Throwable
    //   579	586	1402	java/lang/Throwable
    //   605	612	1402	java/lang/Throwable
    //   639	645	1402	java/lang/Throwable
    //   663	671	1402	java/lang/Throwable
    //   692	724	1402	java/lang/Throwable
    //   745	759	1402	java/lang/Throwable
    //   785	790	1402	java/lang/Throwable
    //   815	820	1402	java/lang/Throwable
    //   843	851	1402	java/lang/Throwable
    //   869	882	1402	java/lang/Throwable
    //   900	909	1402	java/lang/Throwable
    //   927	943	1402	java/lang/Throwable
    //   961	990	1402	java/lang/Throwable
    //   1008	1018	1402	java/lang/Throwable
    //   1036	1046	1402	java/lang/Throwable
    //   1064	1074	1402	java/lang/Throwable
    //   1092	1104	1402	java/lang/Throwable
    //   1127	1140	1402	java/lang/Throwable
    //   1158	1168	1402	java/lang/Throwable
    //   1186	1199	1402	java/lang/Throwable
    //   1217	1227	1402	java/lang/Throwable
    //   1245	1253	1402	java/lang/Throwable
    //   1271	1279	1402	java/lang/Throwable
    //   1297	1313	1402	java/lang/Throwable
    //   1331	1341	1402	java/lang/Throwable
    //   1359	1366	1402	java/lang/Throwable
    //   1389	1399	1402	java/lang/Throwable
    //   1469	1491	1402	java/lang/Throwable
    //   1509	1515	1402	java/lang/Throwable
    //   1538	1546	1402	java/lang/Throwable
    //   1564	1574	1402	java/lang/Throwable
    //   1606	1612	1402	java/lang/Throwable
    //   1630	1637	1402	java/lang/Throwable
    //   1655	1662	1402	java/lang/Throwable
    //   1696	1717	1402	java/lang/Throwable
    //   1735	1744	1402	java/lang/Throwable
    //   1762	1775	1402	java/lang/Throwable
    //   1793	1803	1402	java/lang/Throwable
    //   1821	1835	1402	java/lang/Throwable
    //   1858	1868	1402	java/lang/Throwable
    //   1889	1907	1402	java/lang/Throwable
    //   1935	1961	1402	java/lang/Throwable
    //   1989	2015	1402	java/lang/Throwable
    //   2043	2069	1402	java/lang/Throwable
    //   2090	2101	1402	java/lang/Throwable
    //   387	396	1577	finally
    //   415	429	1577	finally
    //   460	471	1577	finally
    //   490	505	1577	finally
    //   524	534	1577	finally
    //   553	560	1577	finally
    //   579	586	1577	finally
    //   605	612	1577	finally
    //   639	645	1577	finally
    //   663	671	1577	finally
    //   692	724	1577	finally
    //   745	759	1577	finally
    //   785	790	1577	finally
    //   815	820	1577	finally
    //   843	851	1577	finally
    //   869	882	1577	finally
    //   900	909	1577	finally
    //   927	943	1577	finally
    //   961	990	1577	finally
    //   1008	1018	1577	finally
    //   1036	1046	1577	finally
    //   1064	1074	1577	finally
    //   1092	1104	1577	finally
    //   1127	1140	1577	finally
    //   1158	1168	1577	finally
    //   1186	1199	1577	finally
    //   1217	1227	1577	finally
    //   1245	1253	1577	finally
    //   1271	1279	1577	finally
    //   1297	1313	1577	finally
    //   1331	1341	1577	finally
    //   1359	1366	1577	finally
    //   1389	1399	1577	finally
    //   1469	1491	1577	finally
    //   1509	1515	1577	finally
    //   1538	1546	1577	finally
    //   1564	1574	1577	finally
    //   1606	1612	1577	finally
    //   1630	1637	1577	finally
    //   1655	1662	1577	finally
    //   1696	1717	1577	finally
    //   1735	1744	1577	finally
    //   1762	1775	1577	finally
    //   1793	1803	1577	finally
    //   1821	1835	1577	finally
    //   1858	1868	1577	finally
    //   1889	1907	1577	finally
    //   1935	1961	1577	finally
    //   1989	2015	1577	finally
    //   2043	2069	1577	finally
    //   2090	2101	1577	finally
    //   1404	1444	2104	finally
    //   1696	1717	2113	java/lang/Exception
    //   1735	1744	2113	java/lang/Exception
    //   1762	1775	2113	java/lang/Exception
    //   1793	1803	2113	java/lang/Exception
    //   1821	1835	2113	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(paramInt, paramf);
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   6: invokestatic 492	com/tencent/beacon/d/b:a	(Landroid/content/Context;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 52	com/tencent/beacon/upload/h:h	Z
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	h
    //   9	16	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   20	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.h
 * JD-Core Version:    0.7.0.1
 */