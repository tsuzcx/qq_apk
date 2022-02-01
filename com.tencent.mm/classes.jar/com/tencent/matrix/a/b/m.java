package com.tencent.matrix.a.b;

public final class m
{
  static long eUf;
  
  /* Error */
  public static a cg(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 17	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmpge +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: invokestatic 23	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: lload_2
    //   17: getstatic 25	com/tencent/matrix/a/b/m:eUf	J
    //   20: lsub
    //   21: ldc2_w 26
    //   24: lcmp
    //   25: ifge +20 -> 45
    //   28: iload_1
    //   29: ifeq +25 -> 54
    //   32: ldc 29
    //   34: ldc 31
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 37	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: areturn
    //   45: lload_2
    //   46: putstatic 25	com/tencent/matrix/a/b/m:eUf	J
    //   49: iconst_0
    //   50: istore_1
    //   51: goto -23 -> 28
    //   54: aload_0
    //   55: ldc 39
    //   57: invokevirtual 45	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   60: checkcast 47	android/app/usage/NetworkStatsManager
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull -57 -> 10
    //   70: new 6	com/tencent/matrix/a/b/m$a
    //   73: dup
    //   74: invokespecial 51	com/tencent/matrix/a/b/m$a:<init>	()V
    //   77: astore_0
    //   78: aload 5
    //   80: iconst_1
    //   81: aconst_null
    //   82: lconst_0
    //   83: invokestatic 23	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 55	android/app/usage/NetworkStatsManager:querySummary	(ILjava/lang/String;JJ)Landroid/app/usage/NetworkStats;
    //   89: astore 4
    //   91: aload 4
    //   93: invokevirtual 61	android/app/usage/NetworkStats:hasNextBucket	()Z
    //   96: ifeq +117 -> 213
    //   99: new 63	android/app/usage/NetworkStats$Bucket
    //   102: dup
    //   103: invokespecial 64	android/app/usage/NetworkStats$Bucket:<init>	()V
    //   106: astore 6
    //   108: aload 4
    //   110: aload 6
    //   112: invokevirtual 68	android/app/usage/NetworkStats:getNextBucket	(Landroid/app/usage/NetworkStats$Bucket;)Z
    //   115: ifeq -24 -> 91
    //   118: aload 6
    //   120: invokevirtual 72	android/app/usage/NetworkStats$Bucket:getUid	()I
    //   123: invokestatic 77	android/os/Process:myUid	()I
    //   126: if_icmpne -35 -> 91
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 80	com/tencent/matrix/a/b/m$a:eUg	J
    //   134: aload 6
    //   136: invokevirtual 83	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   139: ladd
    //   140: putfield 80	com/tencent/matrix/a/b/m$a:eUg	J
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 86	com/tencent/matrix/a/b/m$a:eUh	J
    //   148: aload 6
    //   150: invokevirtual 89	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   153: ladd
    //   154: putfield 86	com/tencent/matrix/a/b/m$a:eUh	J
    //   157: goto -66 -> 91
    //   160: astore_0
    //   161: aload_0
    //   162: athrow
    //   163: astore 5
    //   165: aload 4
    //   167: ifnull +12 -> 179
    //   170: aload_0
    //   171: ifnull +167 -> 338
    //   174: aload 4
    //   176: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   179: aload 5
    //   181: athrow
    //   182: astore_0
    //   183: ldc 29
    //   185: new 94	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 96
    //   191: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 105	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 115	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aconst_null
    //   212: areturn
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   223: aload 5
    //   225: iconst_0
    //   226: aconst_null
    //   227: lconst_0
    //   228: invokestatic 23	java/lang/System:currentTimeMillis	()J
    //   231: invokevirtual 55	android/app/usage/NetworkStatsManager:querySummary	(ILjava/lang/String;JJ)Landroid/app/usage/NetworkStats;
    //   234: astore 4
    //   236: aload 4
    //   238: invokevirtual 61	android/app/usage/NetworkStats:hasNextBucket	()Z
    //   241: ifeq +105 -> 346
    //   244: new 63	android/app/usage/NetworkStats$Bucket
    //   247: dup
    //   248: invokespecial 64	android/app/usage/NetworkStats$Bucket:<init>	()V
    //   251: astore 5
    //   253: aload 4
    //   255: aload 5
    //   257: invokevirtual 68	android/app/usage/NetworkStats:getNextBucket	(Landroid/app/usage/NetworkStats$Bucket;)Z
    //   260: ifeq -24 -> 236
    //   263: aload 5
    //   265: invokevirtual 72	android/app/usage/NetworkStats$Bucket:getUid	()I
    //   268: invokestatic 77	android/os/Process:myUid	()I
    //   271: if_icmpne -35 -> 236
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 118	com/tencent/matrix/a/b/m$a:eUi	J
    //   279: aload 5
    //   281: invokevirtual 83	android/app/usage/NetworkStats$Bucket:getRxBytes	()J
    //   284: ladd
    //   285: putfield 118	com/tencent/matrix/a/b/m$a:eUi	J
    //   288: aload_0
    //   289: aload_0
    //   290: getfield 121	com/tencent/matrix/a/b/m$a:eUj	J
    //   293: aload 5
    //   295: invokevirtual 89	android/app/usage/NetworkStats$Bucket:getTxBytes	()J
    //   298: ladd
    //   299: putfield 121	com/tencent/matrix/a/b/m$a:eUj	J
    //   302: goto -66 -> 236
    //   305: astore_0
    //   306: aload_0
    //   307: athrow
    //   308: astore 5
    //   310: aload 4
    //   312: ifnull +12 -> 324
    //   315: aload_0
    //   316: ifnull +54 -> 370
    //   319: aload 4
    //   321: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   324: aload 5
    //   326: athrow
    //   327: astore 4
    //   329: aload_0
    //   330: aload 4
    //   332: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   335: goto -156 -> 179
    //   338: aload 4
    //   340: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   343: goto -164 -> 179
    //   346: aload 4
    //   348: ifnull +30 -> 378
    //   351: aload 4
    //   353: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   356: goto +22 -> 378
    //   359: astore 4
    //   361: aload_0
    //   362: aload 4
    //   364: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   367: goto -43 -> 324
    //   370: aload 4
    //   372: invokevirtual 92	android/app/usage/NetworkStats:close	()V
    //   375: goto -51 -> 324
    //   378: aload_0
    //   379: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	android.content.Context
    //   1	50	1	i	int
    //   15	31	2	l	long
    //   89	231	4	localNetworkStats	android.app.usage.NetworkStats
    //   327	25	4	localThrowable1	java.lang.Throwable
    //   359	12	4	localThrowable2	java.lang.Throwable
    //   63	16	5	localNetworkStatsManager	android.app.usage.NetworkStatsManager
    //   163	61	5	localObject1	Object
    //   251	43	5	localBucket1	android.app.usage.NetworkStats.Bucket
    //   308	17	5	localObject2	Object
    //   106	43	6	localBucket2	android.app.usage.NetworkStats.Bucket
    // Exception table:
    //   from	to	target	type
    //   91	157	160	finally
    //   161	163	163	finally
    //   54	65	182	finally
    //   70	91	182	finally
    //   179	182	182	finally
    //   218	223	182	finally
    //   223	236	182	finally
    //   324	327	182	finally
    //   329	335	182	finally
    //   338	343	182	finally
    //   351	356	182	finally
    //   361	367	182	finally
    //   370	375	182	finally
    //   236	302	305	finally
    //   306	308	308	finally
    //   174	179	327	finally
    //   319	324	359	finally
  }
  
  public static final class a
  {
    public long eUg;
    public long eUh;
    public long eUi;
    public long eUj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.m
 * JD-Core Version:    0.7.0.1
 */