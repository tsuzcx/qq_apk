package com.tencent.matrix.a.c;

public final class f
{
  static long cUi;
  
  /* Error */
  public static a bg(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 19	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmpge +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: lload_2
    //   17: getstatic 27	com/tencent/matrix/a/c/f:cUi	J
    //   20: lsub
    //   21: ldc2_w 28
    //   24: lcmp
    //   25: ifge +20 -> 45
    //   28: iload_1
    //   29: ifeq +25 -> 54
    //   32: ldc 31
    //   34: ldc 33
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 39	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: areturn
    //   45: lload_2
    //   46: putstatic 27	com/tencent/matrix/a/c/f:cUi	J
    //   49: iconst_0
    //   50: istore_1
    //   51: goto -23 -> 28
    //   54: aload_0
    //   55: ldc 41
    //   57: invokevirtual 47	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   60: checkcast 49	android/app/usage/NetworkStatsManager
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull -57 -> 10
    //   70: new 6	com/tencent/matrix/a/c/f$a
    //   73: dup
    //   74: invokespecial 53	com/tencent/matrix/a/c/f$a:<init>	()V
    //   77: astore_0
    //   78: aload 4
    //   80: iconst_1
    //   81: aconst_null
    //   82: lconst_0
    //   83: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 57	android/app/usage/NetworkStatsManager:querySummary	(ILjava/lang/String;JJ)Landroid/app/usage/NetworkStats;
    //   89: astore 5
    //   91: aload 5
    //   93: invokevirtual 63	android/app/usage/NetworkStats:hasNextBucket	()Z
    //   96: ifeq +120 -> 216
    //   99: new 65	android/app/usage/NetworkStats$Bucket
    //   102: dup
    //   103: invokespecial 66	android/app/usage/NetworkStats$Bucket:<init>	()V
    //   106: astore 6
    //   108: aload 5
    //   110: aload 6
    //   112: invokevirtual 70	android/app/usage/NetworkStats:getNextBucket	(Landroid/app/usage/NetworkStats$Bucket;)Z
    //   115: ifeq -24 -> 91
    //   118: aload 6
    //   120: invokevirtual 74	android/app/usage/NetworkStats$Bucket:getUid	()I
    //   123: invokestatic 79	android/os/Process:myUid	()I
    //   126: if_icmpne -35 -> 91
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 82	com/tencent/matrix/a/c/f$a:cUj	J
    //   134: aload 6
    //   136: invokevirtual 85	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   139: ladd
    //   140: putfield 82	com/tencent/matrix/a/c/f$a:cUj	J
    //   143: aload_0
    //   144: getfield 88	com/tencent/matrix/a/c/f$a:cUk	J
    //   147: lstore_2
    //   148: aload_0
    //   149: aload 6
    //   151: invokevirtual 91	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   154: lload_2
    //   155: ladd
    //   156: putfield 88	com/tencent/matrix/a/c/f$a:cUk	J
    //   159: goto -68 -> 91
    //   162: astore 4
    //   164: aload 4
    //   166: athrow
    //   167: astore_0
    //   168: aload 5
    //   170: ifnull +13 -> 183
    //   173: aload 4
    //   175: ifnull +168 -> 343
    //   178: aload 5
    //   180: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: ldc 31
    //   188: new 96	java/lang/StringBuilder
    //   191: dup
    //   192: ldc 98
    //   194: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: invokevirtual 105	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 115	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aconst_null
    //   215: areturn
    //   216: aload 5
    //   218: ifnull +8 -> 226
    //   221: aload 5
    //   223: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   226: aload 4
    //   228: iconst_0
    //   229: aconst_null
    //   230: lconst_0
    //   231: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   234: invokevirtual 57	android/app/usage/NetworkStatsManager:querySummary	(ILjava/lang/String;JJ)Landroid/app/usage/NetworkStats;
    //   237: astore 5
    //   239: aload 5
    //   241: invokevirtual 63	android/app/usage/NetworkStats:hasNextBucket	()Z
    //   244: ifeq +107 -> 351
    //   247: new 65	android/app/usage/NetworkStats$Bucket
    //   250: dup
    //   251: invokespecial 66	android/app/usage/NetworkStats$Bucket:<init>	()V
    //   254: astore 4
    //   256: aload 5
    //   258: aload 4
    //   260: invokevirtual 70	android/app/usage/NetworkStats:getNextBucket	(Landroid/app/usage/NetworkStats$Bucket;)Z
    //   263: ifeq -24 -> 239
    //   266: aload 4
    //   268: invokevirtual 74	android/app/usage/NetworkStats$Bucket:getUid	()I
    //   271: invokestatic 79	android/os/Process:myUid	()I
    //   274: if_icmpne -35 -> 239
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 118	com/tencent/matrix/a/c/f$a:cUl	J
    //   282: aload 4
    //   284: invokevirtual 85	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   287: ladd
    //   288: putfield 118	com/tencent/matrix/a/c/f$a:cUl	J
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 121	com/tencent/matrix/a/c/f$a:cUm	J
    //   296: aload 4
    //   298: invokevirtual 91	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   301: ladd
    //   302: putfield 121	com/tencent/matrix/a/c/f$a:cUm	J
    //   305: goto -66 -> 239
    //   308: astore 4
    //   310: aload 4
    //   312: athrow
    //   313: astore_0
    //   314: aload 5
    //   316: ifnull +13 -> 329
    //   319: aload 4
    //   321: ifnull +55 -> 376
    //   324: aload 5
    //   326: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   329: aload_0
    //   330: athrow
    //   331: astore 5
    //   333: aload 4
    //   335: aload 5
    //   337: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   340: goto -157 -> 183
    //   343: aload 5
    //   345: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   348: goto -165 -> 183
    //   351: aload 5
    //   353: ifnull +45 -> 398
    //   356: aload 5
    //   358: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   361: goto +37 -> 398
    //   364: astore 5
    //   366: aload 4
    //   368: aload 5
    //   370: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   373: goto -44 -> 329
    //   376: aload 5
    //   378: invokevirtual 94	android/app/usage/NetworkStats:close	()V
    //   381: goto -52 -> 329
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 4
    //   388: goto -74 -> 314
    //   391: astore_0
    //   392: aconst_null
    //   393: astore 4
    //   395: goto -227 -> 168
    //   398: aload_0
    //   399: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramContext	android.content.Context
    //   1	50	1	i	int
    //   15	140	2	l	long
    //   63	16	4	localNetworkStatsManager	android.app.usage.NetworkStatsManager
    //   162	65	4	localThrowable1	java.lang.Throwable
    //   254	43	4	localBucket1	android.app.usage.NetworkStats.Bucket
    //   308	59	4	localThrowable2	java.lang.Throwable
    //   386	8	4	localObject	Object
    //   89	236	5	localNetworkStats	android.app.usage.NetworkStats
    //   331	26	5	localThrowable3	java.lang.Throwable
    //   364	13	5	localThrowable4	java.lang.Throwable
    //   106	44	6	localBucket2	android.app.usage.NetworkStats.Bucket
    // Exception table:
    //   from	to	target	type
    //   91	159	162	java/lang/Throwable
    //   164	167	167	finally
    //   54	65	185	java/lang/Throwable
    //   70	91	185	java/lang/Throwable
    //   183	185	185	java/lang/Throwable
    //   221	226	185	java/lang/Throwable
    //   226	239	185	java/lang/Throwable
    //   329	331	185	java/lang/Throwable
    //   333	340	185	java/lang/Throwable
    //   343	348	185	java/lang/Throwable
    //   356	361	185	java/lang/Throwable
    //   366	373	185	java/lang/Throwable
    //   376	381	185	java/lang/Throwable
    //   239	305	308	java/lang/Throwable
    //   310	313	313	finally
    //   178	183	331	java/lang/Throwable
    //   324	329	364	java/lang/Throwable
    //   239	305	384	finally
    //   91	159	391	finally
  }
  
  public static final class a
  {
    public long cUj;
    public long cUk;
    public long cUl;
    public long cUm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.c.f
 * JD-Core Version:    0.7.0.1
 */