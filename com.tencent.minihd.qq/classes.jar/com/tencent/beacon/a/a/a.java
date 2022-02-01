package com.tencent.beacon.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private long a = -1L;
  private int b = -1;
  private int c = -1;
  private long d = -1L;
  private byte[] e = null;
  private long f = 0L;
  
  public a() {}
  
  public a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 38
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnonnull +14 -> 27
    //   16: ldc 45
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iconst_m1
    //   26: ireturn
    //   27: lload_2
    //   28: lload 4
    //   30: lcmp
    //   31: ifle +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: new 49	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 51
    //   42: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: lload_2
    //   46: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: ldc 60
    //   51: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 65
    //   56: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload 4
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 9
    //   69: aload_1
    //   70: ifnull +359 -> 429
    //   73: aload_1
    //   74: arraylength
    //   75: ifle +354 -> 429
    //   78: ldc 71
    //   80: astore 7
    //   82: iconst_0
    //   83: istore 6
    //   85: iload 6
    //   87: aload_1
    //   88: arraylength
    //   89: if_icmpge +41 -> 130
    //   92: new 49	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   99: aload 7
    //   101: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 74
    //   106: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: iload 6
    //   112: iaload
    //   113: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 7
    //   121: iload 6
    //   123: iconst_1
    //   124: iadd
    //   125: istore 6
    //   127: goto -42 -> 85
    //   130: aload 7
    //   132: iconst_4
    //   133: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   136: astore_1
    //   137: new 49	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   144: aload 9
    //   146: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 85
    //   151: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 87
    //   160: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore_1
    //   167: new 49	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 89
    //   173: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: aload_1
    //   177: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload_0
    //   191: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   199: astore 7
    //   201: aload 7
    //   203: ldc 100
    //   205: aload_1
    //   206: aconst_null
    //   207: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   210: istore 6
    //   212: new 49	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 108
    //   218: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: iload 6
    //   223: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload 7
    //   238: ifnull +16 -> 254
    //   241: aload 7
    //   243: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   246: ifeq +8 -> 254
    //   249: aload 7
    //   251: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   262: ldc 118
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: iload 6
    //   273: ireturn
    //   274: astore 7
    //   276: aconst_null
    //   277: astore_0
    //   278: aload 8
    //   280: astore_1
    //   281: aload 7
    //   283: astore 8
    //   285: aload 8
    //   287: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: aload_0
    //   298: ifnull +14 -> 312
    //   301: aload_0
    //   302: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   305: ifeq +7 -> 312
    //   308: aload_0
    //   309: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   320: ldc 118
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: iconst_m1
    //   330: istore 6
    //   332: goto -61 -> 271
    //   335: astore_1
    //   336: aconst_null
    //   337: astore 7
    //   339: aconst_null
    //   340: astore_0
    //   341: aload 7
    //   343: ifnull +16 -> 359
    //   346: aload 7
    //   348: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   351: ifeq +8 -> 359
    //   354: aload 7
    //   356: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   359: aload_0
    //   360: ifnull +7 -> 367
    //   363: aload_0
    //   364: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   367: ldc 118
    //   369: iconst_0
    //   370: anewarray 4	java/lang/Object
    //   373: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: aload_1
    //   377: athrow
    //   378: astore_1
    //   379: aconst_null
    //   380: astore 7
    //   382: goto -41 -> 341
    //   385: astore_1
    //   386: goto -45 -> 341
    //   389: astore 7
    //   391: aload_1
    //   392: astore 8
    //   394: aload 7
    //   396: astore_1
    //   397: aload_0
    //   398: astore 7
    //   400: aload 8
    //   402: astore_0
    //   403: goto -62 -> 341
    //   406: astore 8
    //   408: aconst_null
    //   409: astore 7
    //   411: aload_0
    //   412: astore_1
    //   413: aload 7
    //   415: astore_0
    //   416: goto -131 -> 285
    //   419: astore 8
    //   421: aload_0
    //   422: astore_1
    //   423: aload 7
    //   425: astore_0
    //   426: goto -141 -> 285
    //   429: aload 9
    //   431: astore_1
    //   432: goto -265 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramContext	Context
    //   0	435	1	paramArrayOfInt	int[]
    //   0	435	2	paramLong1	long
    //   0	435	4	paramLong2	long
    //   83	248	6	i	int
    //   80	170	7	localObject1	Object
    //   274	8	7	localThrowable1	Throwable
    //   337	44	7	localObject2	Object
    //   389	6	7	localObject3	Object
    //   398	26	7	localContext	Context
    //   1	400	8	localObject4	Object
    //   406	1	8	localThrowable2	Throwable
    //   419	1	8	localThrowable3	Throwable
    //   67	363	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   190	195	274	java/lang/Throwable
    //   190	195	335	finally
    //   195	201	378	finally
    //   201	236	385	finally
    //   285	297	389	finally
    //   195	201	406	java/lang/Throwable
    //   201	236	419	java/lang/Throwable
  }
  
  /* Error */
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: ldc 124
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_0
    //   10: ifnonnull +14 -> 24
    //   13: ldc 126
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: iconst_m1
    //   23: ireturn
    //   24: aload_1
    //   25: ifnull +8 -> 33
    //   28: aload_1
    //   29: arraylength
    //   30: ifgt +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 8
    //   48: aload 8
    //   50: astore 10
    //   52: aload 7
    //   54: astore 9
    //   56: new 130	java/lang/StringBuffer
    //   59: dup
    //   60: invokespecial 131	java/lang/StringBuffer:<init>	()V
    //   63: astore_0
    //   64: iconst_0
    //   65: istore 4
    //   67: iconst_0
    //   68: istore_2
    //   69: aload 8
    //   71: astore 10
    //   73: aload 7
    //   75: astore 9
    //   77: iload_2
    //   78: istore_3
    //   79: iload 4
    //   81: aload_1
    //   82: arraylength
    //   83: if_icmpge +184 -> 267
    //   86: aload 8
    //   88: astore 10
    //   90: aload 7
    //   92: astore 9
    //   94: iload_2
    //   95: istore_3
    //   96: aload_1
    //   97: iload 4
    //   99: aaload
    //   100: invokevirtual 137	java/lang/Long:longValue	()J
    //   103: lstore 5
    //   105: aload 8
    //   107: astore 10
    //   109: aload 7
    //   111: astore 9
    //   113: iload_2
    //   114: istore_3
    //   115: aload_0
    //   116: new 49	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 139
    //   122: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: lload 5
    //   127: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 142	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: iload_2
    //   138: istore_3
    //   139: iload 4
    //   141: ifle +423 -> 564
    //   144: iload_2
    //   145: istore_3
    //   146: iload 4
    //   148: bipush 25
    //   150: irem
    //   151: ifne +413 -> 564
    //   154: aload 8
    //   156: astore 10
    //   158: aload 7
    //   160: astore 9
    //   162: iload_2
    //   163: istore_3
    //   164: new 49	java/lang/StringBuilder
    //   167: dup
    //   168: ldc 144
    //   170: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: iload 4
    //   175: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 8
    //   190: astore 10
    //   192: aload 7
    //   194: astore 9
    //   196: iload_2
    //   197: istore_3
    //   198: iload_2
    //   199: aload 8
    //   201: ldc 100
    //   203: aload_0
    //   204: iconst_4
    //   205: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   208: aconst_null
    //   209: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   212: iadd
    //   213: istore_2
    //   214: aload 8
    //   216: astore 10
    //   218: aload 7
    //   220: astore 9
    //   222: iload_2
    //   223: istore_3
    //   224: aload_0
    //   225: iconst_0
    //   226: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   229: aload 8
    //   231: astore 10
    //   233: aload 7
    //   235: astore 9
    //   237: iload_2
    //   238: istore_3
    //   239: new 49	java/lang/StringBuilder
    //   242: dup
    //   243: ldc 151
    //   245: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   248: iload_2
    //   249: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: iload_2
    //   263: istore_3
    //   264: goto +300 -> 564
    //   267: iload_2
    //   268: istore 4
    //   270: aload 8
    //   272: astore 10
    //   274: aload 7
    //   276: astore 9
    //   278: iload_2
    //   279: istore_3
    //   280: aload_0
    //   281: invokevirtual 155	java/lang/StringBuffer:length	()I
    //   284: ifle +49 -> 333
    //   287: aload 8
    //   289: astore 10
    //   291: aload 7
    //   293: astore 9
    //   295: iload_2
    //   296: istore_3
    //   297: aload 8
    //   299: ldc 100
    //   301: aload_0
    //   302: iconst_4
    //   303: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   306: aconst_null
    //   307: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   310: istore 4
    //   312: iload 4
    //   314: iload_2
    //   315: iadd
    //   316: istore_2
    //   317: aload 8
    //   319: astore 10
    //   321: aload 7
    //   323: astore 9
    //   325: aload_0
    //   326: iconst_0
    //   327: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   330: iload_2
    //   331: istore 4
    //   333: aload 8
    //   335: astore 10
    //   337: aload 7
    //   339: astore 9
    //   341: iload 4
    //   343: istore_3
    //   344: new 49	java/lang/StringBuilder
    //   347: dup
    //   348: ldc 157
    //   350: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: iload 4
    //   355: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 8
    //   370: ifnull +16 -> 386
    //   373: aload 8
    //   375: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   378: ifeq +8 -> 386
    //   381: aload 8
    //   383: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   386: aload 7
    //   388: ifnull +8 -> 396
    //   391: aload 7
    //   393: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   396: ldc 159
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: iload 4
    //   407: ireturn
    //   408: astore_0
    //   409: aconst_null
    //   410: astore_1
    //   411: aconst_null
    //   412: astore 7
    //   414: iconst_0
    //   415: istore_2
    //   416: aload_1
    //   417: astore 10
    //   419: aload 7
    //   421: astore 9
    //   423: aload_0
    //   424: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   427: iconst_0
    //   428: anewarray 4	java/lang/Object
    //   431: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: aload_1
    //   435: ifnull +14 -> 449
    //   438: aload_1
    //   439: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   442: ifeq +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   449: aload 7
    //   451: ifnull +8 -> 459
    //   454: aload 7
    //   456: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   459: ldc 159
    //   461: iconst_0
    //   462: anewarray 4	java/lang/Object
    //   465: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   468: iload_2
    //   469: ireturn
    //   470: astore_0
    //   471: aconst_null
    //   472: astore 10
    //   474: aconst_null
    //   475: astore 7
    //   477: aload 10
    //   479: ifnull +16 -> 495
    //   482: aload 10
    //   484: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   487: ifeq +8 -> 495
    //   490: aload 10
    //   492: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   495: aload 7
    //   497: ifnull +8 -> 505
    //   500: aload 7
    //   502: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   505: ldc 159
    //   507: iconst_0
    //   508: anewarray 4	java/lang/Object
    //   511: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: aload_0
    //   515: athrow
    //   516: astore_0
    //   517: aconst_null
    //   518: astore 10
    //   520: goto -43 -> 477
    //   523: astore_0
    //   524: aload 9
    //   526: astore 7
    //   528: goto -51 -> 477
    //   531: astore_0
    //   532: aconst_null
    //   533: astore_1
    //   534: iconst_0
    //   535: istore_2
    //   536: goto -120 -> 416
    //   539: astore_0
    //   540: iconst_0
    //   541: istore_2
    //   542: aload 8
    //   544: astore_1
    //   545: goto -129 -> 416
    //   548: astore_0
    //   549: iload_3
    //   550: istore_2
    //   551: aload 8
    //   553: astore_1
    //   554: goto -138 -> 416
    //   557: astore_0
    //   558: aload 8
    //   560: astore_1
    //   561: goto -145 -> 416
    //   564: iload 4
    //   566: iconst_1
    //   567: iadd
    //   568: istore 4
    //   570: iload_3
    //   571: istore_2
    //   572: goto -503 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	paramContext	Context
    //   0	575	1	paramArrayOfLong	Long[]
    //   68	504	2	i	int
    //   78	493	3	j	int
    //   65	504	4	k	int
    //   103	23	5	l	long
    //   39	488	7	localObject1	Object
    //   46	513	8	localSQLiteDatabase	SQLiteDatabase
    //   54	471	9	localObject2	Object
    //   50	469	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	408	java/lang/Throwable
    //   35	41	470	finally
    //   41	48	516	finally
    //   56	64	523	finally
    //   79	86	523	finally
    //   96	105	523	finally
    //   115	137	523	finally
    //   164	188	523	finally
    //   198	214	523	finally
    //   224	229	523	finally
    //   239	262	523	finally
    //   280	287	523	finally
    //   297	312	523	finally
    //   325	330	523	finally
    //   344	368	523	finally
    //   423	434	523	finally
    //   41	48	531	java/lang/Throwable
    //   56	64	539	java/lang/Throwable
    //   79	86	548	java/lang/Throwable
    //   96	105	548	java/lang/Throwable
    //   115	137	548	java/lang/Throwable
    //   164	188	548	java/lang/Throwable
    //   198	214	548	java/lang/Throwable
    //   224	229	548	java/lang/Throwable
    //   239	262	548	java/lang/Throwable
    //   280	287	548	java/lang/Throwable
    //   297	312	548	java/lang/Throwable
    //   344	368	548	java/lang/Throwable
    //   325	330	557	java/lang/Throwable
  }
  
  public static ContentValues a(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    if (parama.a > 0L) {
      localContentValues.put("_id", Long.valueOf(parama.a));
    }
    localContentValues.put("_prority", Integer.valueOf(parama.c));
    localContentValues.put("_time", Long.valueOf(parama.d));
    localContentValues.put("_type", Integer.valueOf(parama.b));
    localContentValues.put("_datas", parama.e);
    localContentValues.put("_length", Long.valueOf(parama.f));
    return localContentValues;
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 199
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnonnull +14 -> 28
    //   17: ldc 201
    //   19: iconst_0
    //   20: anewarray 4	java/lang/Object
    //   23: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore_1
    //   38: aload_1
    //   39: ldc 203
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: ldc 205
    //   48: ldc 207
    //   50: invokevirtual 211	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore 4
    //   55: aload 4
    //   57: invokeinterface 216 1 0
    //   62: ifeq +313 -> 375
    //   65: new 218	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 219	java/util/ArrayList:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: astore_2
    //   75: aload_3
    //   76: aload 4
    //   78: aload 4
    //   80: ldc 165
    //   82: invokeinterface 223 2 0
    //   87: invokeinterface 227 2 0
    //   92: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: invokeinterface 233 2 0
    //   100: pop
    //   101: aload_3
    //   102: astore_2
    //   103: aload_3
    //   104: aload 4
    //   106: aload 4
    //   108: ldc 235
    //   110: invokeinterface 223 2 0
    //   115: invokeinterface 238 2 0
    //   120: invokeinterface 233 2 0
    //   125: pop
    //   126: aload_3
    //   127: astore_2
    //   128: aload_3
    //   129: aload 4
    //   131: aload 4
    //   133: ldc 185
    //   135: invokeinterface 223 2 0
    //   140: invokeinterface 242 2 0
    //   145: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: invokeinterface 233 2 0
    //   153: pop
    //   154: aload_3
    //   155: astore_2
    //   156: aload_3
    //   157: aload 4
    //   159: aload 4
    //   161: ldc 189
    //   163: invokeinterface 223 2 0
    //   168: invokeinterface 246 2 0
    //   173: invokeinterface 233 2 0
    //   178: pop
    //   179: aload_3
    //   180: ifnull +33 -> 213
    //   183: aload_3
    //   184: astore_2
    //   185: new 49	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 248
    //   191: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_3
    //   195: invokeinterface 251 1 0
    //   200: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_1
    //   214: ifnull +14 -> 228
    //   217: aload_1
    //   218: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   221: ifeq +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   236: ldc 253
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload_3
    //   246: areturn
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_2
    //   253: ifnull +14 -> 267
    //   256: aload_2
    //   257: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   260: ifeq +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   275: ldc 253
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: aload_0
    //   285: areturn
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_0
    //   289: aload_3
    //   290: astore_2
    //   291: aload_2
    //   292: ifnull +14 -> 306
    //   295: aload_2
    //   296: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   299: ifeq +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   314: ldc 253
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload_1
    //   324: athrow
    //   325: astore_1
    //   326: aload_3
    //   327: astore_2
    //   328: goto -37 -> 291
    //   331: astore_3
    //   332: aload_1
    //   333: astore_2
    //   334: aload_3
    //   335: astore_1
    //   336: goto -45 -> 291
    //   339: astore_1
    //   340: aconst_null
    //   341: astore_3
    //   342: aload_0
    //   343: astore_1
    //   344: aload_3
    //   345: astore_0
    //   346: goto -94 -> 252
    //   349: astore_2
    //   350: aload_0
    //   351: astore_2
    //   352: aconst_null
    //   353: astore_0
    //   354: aload_1
    //   355: astore_3
    //   356: aload_2
    //   357: astore_1
    //   358: aload_3
    //   359: astore_2
    //   360: goto -108 -> 252
    //   363: astore_3
    //   364: aload_1
    //   365: astore_3
    //   366: aload_0
    //   367: astore_1
    //   368: aload_2
    //   369: astore_0
    //   370: aload_3
    //   371: astore_2
    //   372: goto -120 -> 252
    //   375: aconst_null
    //   376: astore_3
    //   377: goto -198 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	Context
    //   37	235	1	localSQLiteDatabase	SQLiteDatabase
    //   286	38	1	localObject1	Object
    //   325	8	1	localObject2	Object
    //   335	1	1	localObject3	Object
    //   339	1	1	localException1	java.lang.Exception
    //   343	25	1	localObject4	Object
    //   3	331	2	localObject5	Object
    //   349	1	2	localException2	java.lang.Exception
    //   351	21	2	localObject6	Object
    //   1	326	3	localArrayList	ArrayList
    //   331	4	3	localObject7	Object
    //   341	18	3	localObject8	Object
    //   363	1	3	localException3	java.lang.Exception
    //   365	12	3	localObject9	Object
    //   53	107	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   28	33	247	java/lang/Exception
    //   28	33	286	finally
    //   33	38	325	finally
    //   38	73	331	finally
    //   75	101	331	finally
    //   103	126	331	finally
    //   128	154	331	finally
    //   156	179	331	finally
    //   185	213	331	finally
    //   33	38	339	java/lang/Exception
    //   38	73	349	java/lang/Exception
    //   75	101	363	java/lang/Exception
    //   103	126	363	java/lang/Exception
    //   128	154	363	java/lang/Exception
    //   156	179	363	java/lang/Exception
    //   185	213	363	java/lang/Exception
  }
  
  /* Error */
  public static List<a> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +42 -> 53
    //   14: lload 11
    //   16: lconst_0
    //   17: lcmp
    //   18: ifle +11 -> 29
    //   21: lload 9
    //   23: lload 11
    //   25: lcmp
    //   26: ifgt +27 -> 53
    //   29: iload 6
    //   31: ifle +10 -> 41
    //   34: iload 5
    //   36: iload 6
    //   38: if_icmpgt +15 -> 53
    //   41: iload 8
    //   43: ifle +22 -> 65
    //   46: iload 7
    //   48: iload 8
    //   50: if_icmple +15 -> 65
    //   53: ldc_w 258
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_1
    //   66: ifnull +863 -> 929
    //   69: aload_1
    //   70: arraylength
    //   71: ifle +858 -> 929
    //   74: ldc 71
    //   76: astore 13
    //   78: iconst_0
    //   79: istore 5
    //   81: iload 5
    //   83: aload_1
    //   84: arraylength
    //   85: if_icmpge +41 -> 126
    //   88: new 49	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   95: aload 13
    //   97: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 74
    //   102: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: iload 5
    //   108: iaload
    //   109: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 13
    //   117: iload 5
    //   119: iconst_1
    //   120: iadd
    //   121: istore 5
    //   123: goto -42 -> 81
    //   126: new 49	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   133: ldc 71
    //   135: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 13
    //   140: iconst_4
    //   141: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 259	java/lang/String:length	()I
    //   155: ifle +316 -> 471
    //   158: new 49	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 261
    //   165: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 263
    //   175: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore 13
    //   183: aload 13
    //   185: astore_1
    //   186: lload 9
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt +55 -> 245
    //   193: new 49	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   200: aload 13
    //   202: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: astore 14
    //   207: aload 13
    //   209: invokevirtual 259	java/lang/String:length	()I
    //   212: ifle +266 -> 478
    //   215: ldc_w 265
    //   218: astore_1
    //   219: aload 14
    //   221: aload_1
    //   222: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 51
    //   227: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: lload 9
    //   232: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc_w 267
    //   238: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore_1
    //   245: aload_1
    //   246: astore 13
    //   248: lload 11
    //   250: lconst_0
    //   251: lcmp
    //   252: iflt +55 -> 307
    //   255: new 49	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   262: aload_1
    //   263: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: astore 13
    //   268: aload_1
    //   269: invokevirtual 259	java/lang/String:length	()I
    //   272: ifle +212 -> 484
    //   275: ldc_w 265
    //   278: astore_1
    //   279: aload 13
    //   281: aload_1
    //   282: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 269
    //   288: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: lload 11
    //   293: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc_w 267
    //   299: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore 13
    //   307: ldc 71
    //   309: astore_1
    //   310: iload_2
    //   311: tableswitch	default:+21 -> 332, 1:+179->490, 2:+204->515
    //   333: tableswitch	default:+23 -> 356, 1:+207->540, 2:+231->564
    //   357: ldc_w 271
    //   360: invokevirtual 275	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   363: ifeq +560 -> 923
    //   366: aload_1
    //   367: iconst_0
    //   368: aload_1
    //   369: invokevirtual 259	java/lang/String:length	()I
    //   372: iconst_3
    //   373: isub
    //   374: invokevirtual 278	java/lang/String:substring	(II)Ljava/lang/String;
    //   377: astore 14
    //   379: ldc_w 280
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 13
    //   390: aastore
    //   391: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload_0
    //   395: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   398: astore_0
    //   399: aload_0
    //   400: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   403: astore_1
    //   404: iload 4
    //   406: iflt +181 -> 587
    //   409: new 49	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   416: iload 4
    //   418: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: astore 15
    //   426: aload_1
    //   427: ldc 100
    //   429: aconst_null
    //   430: aload 13
    //   432: aconst_null
    //   433: aconst_null
    //   434: aconst_null
    //   435: aload 14
    //   437: aload 15
    //   439: invokevirtual 211	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   442: astore 14
    //   444: aconst_null
    //   445: astore 13
    //   447: aload 14
    //   449: invokeinterface 216 1 0
    //   454: ifeq +139 -> 593
    //   457: aload 14
    //   459: invokestatic 283	com/tencent/beacon/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   462: astore 15
    //   464: aload 15
    //   466: astore 13
    //   468: goto -21 -> 447
    //   471: ldc 71
    //   473: astore 13
    //   475: goto -292 -> 183
    //   478: ldc 71
    //   480: astore_1
    //   481: goto -262 -> 219
    //   484: ldc 71
    //   486: astore_1
    //   487: goto -208 -> 279
    //   490: new 49	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   497: ldc 71
    //   499: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 285
    //   505: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: astore_1
    //   512: goto -180 -> 332
    //   515: new 49	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   522: ldc 71
    //   524: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 287
    //   530: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore_1
    //   537: goto -205 -> 332
    //   540: new 49	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   547: aload_1
    //   548: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w 289
    //   554: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: astore_1
    //   561: goto -205 -> 356
    //   564: new 49	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   571: aload_1
    //   572: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: ldc 205
    //   577: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: astore_1
    //   584: goto -228 -> 356
    //   587: aconst_null
    //   588: astore 15
    //   590: goto -164 -> 426
    //   593: aload 13
    //   595: ifnull +32 -> 627
    //   598: new 49	java/lang/StringBuilder
    //   601: dup
    //   602: ldc 248
    //   604: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: aload 13
    //   609: invokeinterface 251 1 0
    //   614: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: iconst_0
    //   621: anewarray 4	java/lang/Object
    //   624: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   627: aload 14
    //   629: ifnull +20 -> 649
    //   632: aload 14
    //   634: invokeinterface 292 1 0
    //   639: ifne +10 -> 649
    //   642: aload 14
    //   644: invokeinterface 293 1 0
    //   649: aload_1
    //   650: ifnull +14 -> 664
    //   653: aload_1
    //   654: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   657: ifeq +7 -> 664
    //   660: aload_1
    //   661: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   664: aload_0
    //   665: ifnull +7 -> 672
    //   668: aload_0
    //   669: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   672: ldc_w 295
    //   675: iconst_0
    //   676: anewarray 4	java/lang/Object
    //   679: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   682: aload 13
    //   684: areturn
    //   685: astore 15
    //   687: aconst_null
    //   688: astore_1
    //   689: aconst_null
    //   690: astore 14
    //   692: aconst_null
    //   693: astore_0
    //   694: aconst_null
    //   695: astore 13
    //   697: aload 15
    //   699: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   702: iconst_0
    //   703: anewarray 4	java/lang/Object
    //   706: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: aload_1
    //   710: ifnull +18 -> 728
    //   713: aload_1
    //   714: invokeinterface 292 1 0
    //   719: ifne +9 -> 728
    //   722: aload_1
    //   723: invokeinterface 293 1 0
    //   728: aload 14
    //   730: ifnull +16 -> 746
    //   733: aload 14
    //   735: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   738: ifeq +8 -> 746
    //   741: aload 14
    //   743: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   746: aload_0
    //   747: ifnull +7 -> 754
    //   750: aload_0
    //   751: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   754: ldc_w 295
    //   757: iconst_0
    //   758: anewarray 4	java/lang/Object
    //   761: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   764: aload 13
    //   766: areturn
    //   767: astore 13
    //   769: aconst_null
    //   770: astore_0
    //   771: aconst_null
    //   772: astore_1
    //   773: aconst_null
    //   774: astore 14
    //   776: aload_1
    //   777: ifnull +18 -> 795
    //   780: aload_1
    //   781: invokeinterface 292 1 0
    //   786: ifne +9 -> 795
    //   789: aload_1
    //   790: invokeinterface 293 1 0
    //   795: aload 14
    //   797: ifnull +16 -> 813
    //   800: aload 14
    //   802: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   805: ifeq +8 -> 813
    //   808: aload 14
    //   810: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   813: aload_0
    //   814: ifnull +7 -> 821
    //   817: aload_0
    //   818: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   821: ldc_w 295
    //   824: iconst_0
    //   825: anewarray 4	java/lang/Object
    //   828: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   831: aload 13
    //   833: athrow
    //   834: astore 13
    //   836: aconst_null
    //   837: astore_1
    //   838: aconst_null
    //   839: astore 14
    //   841: goto -65 -> 776
    //   844: astore 13
    //   846: aconst_null
    //   847: astore 15
    //   849: aload_1
    //   850: astore 14
    //   852: aload 15
    //   854: astore_1
    //   855: goto -79 -> 776
    //   858: astore 13
    //   860: aload_1
    //   861: astore 15
    //   863: aload 14
    //   865: astore_1
    //   866: aload 15
    //   868: astore 14
    //   870: goto -94 -> 776
    //   873: astore 13
    //   875: goto -99 -> 776
    //   878: astore 15
    //   880: aconst_null
    //   881: astore_1
    //   882: aconst_null
    //   883: astore 14
    //   885: aconst_null
    //   886: astore 13
    //   888: goto -191 -> 697
    //   891: astore 15
    //   893: aconst_null
    //   894: astore 16
    //   896: aload_1
    //   897: astore 14
    //   899: aconst_null
    //   900: astore 13
    //   902: aload 16
    //   904: astore_1
    //   905: goto -208 -> 697
    //   908: astore 15
    //   910: aload_1
    //   911: astore 16
    //   913: aload 14
    //   915: astore_1
    //   916: aload 16
    //   918: astore 14
    //   920: goto -223 -> 697
    //   923: aload_1
    //   924: astore 14
    //   926: goto -547 -> 379
    //   929: ldc 71
    //   931: astore_1
    //   932: goto -781 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	935	0	paramContext	Context
    //   0	935	1	paramArrayOfInt	int[]
    //   0	935	2	paramInt1	int
    //   0	935	3	paramInt2	int
    //   0	935	4	paramInt3	int
    //   0	935	5	paramInt4	int
    //   0	935	6	paramInt5	int
    //   0	935	7	paramInt6	int
    //   0	935	8	paramInt7	int
    //   0	935	9	paramLong1	long
    //   0	935	11	paramLong2	long
    //   76	689	13	localObject1	Object
    //   767	65	13	localObject2	Object
    //   834	1	13	localObject3	Object
    //   844	1	13	localObject4	Object
    //   858	1	13	localObject5	Object
    //   873	1	13	localObject6	Object
    //   886	15	13	localObject7	Object
    //   205	720	14	localObject8	Object
    //   424	165	15	localObject9	Object
    //   685	13	15	localThrowable1	Throwable
    //   847	20	15	arrayOfInt1	int[]
    //   878	1	15	localThrowable2	Throwable
    //   891	1	15	localThrowable3	Throwable
    //   908	1	15	localThrowable4	Throwable
    //   894	23	16	arrayOfInt2	int[]
    // Exception table:
    //   from	to	target	type
    //   394	399	685	java/lang/Throwable
    //   394	399	767	finally
    //   399	404	834	finally
    //   409	426	844	finally
    //   426	444	844	finally
    //   447	464	858	finally
    //   598	627	858	finally
    //   697	709	873	finally
    //   399	404	878	java/lang/Throwable
    //   409	426	891	java/lang/Throwable
    //   426	444	891	java/lang/Throwable
    //   447	464	908	java/lang/Throwable
    //   598	627	908	java/lang/Throwable
  }
  
  protected static List<a> a(Cursor paramCursor)
  {
    com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    while (paramCursor.moveToNext())
    {
      a locala = new a();
      locala.a = paramCursor.getLong(i);
      locala.e = paramCursor.getBlob(n);
      locala.c = paramCursor.getInt(j);
      locala.d = paramCursor.getLong(k);
      locala.b = paramCursor.getInt(m);
      locala.f = paramCursor.getLong(i1);
      localArrayList.add(locala);
    }
    com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: ldc_w 306
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: ifnonnull +14 -> 39
    //   28: ldc 45
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: ifnull -3 -> 37
    //   43: aload_1
    //   44: invokevirtual 309	java/lang/String:trim	()Ljava/lang/String;
    //   47: ldc 71
    //   49: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne -15 -> 37
    //   55: new 49	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 314
    //   62: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 316
    //   72: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 8
    //   80: new 49	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 89
    //   86: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 8
    //   91: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   108: astore_0
    //   109: aload_0
    //   110: astore 4
    //   112: aload 7
    //   114: astore_0
    //   115: aload 4
    //   117: astore_1
    //   118: aload 6
    //   120: astore 5
    //   122: aload 4
    //   124: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: astore 6
    //   129: aload 6
    //   131: astore_0
    //   132: aload 4
    //   134: astore_1
    //   135: aload 6
    //   137: astore 5
    //   139: aload 6
    //   141: ldc 203
    //   143: aload 8
    //   145: aconst_null
    //   146: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   149: istore_2
    //   150: aload 6
    //   152: astore_0
    //   153: aload 4
    //   155: astore_1
    //   156: aload 6
    //   158: astore 5
    //   160: new 49	java/lang/StringBuilder
    //   163: dup
    //   164: ldc 108
    //   166: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: iload_2
    //   170: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: iload_2
    //   184: iconst_1
    //   185: if_icmpne +166 -> 351
    //   188: aload 6
    //   190: ifnull +16 -> 206
    //   193: aload 6
    //   195: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   198: ifeq +8 -> 206
    //   201: aload 6
    //   203: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   216: ldc_w 318
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: iload_3
    //   227: ireturn
    //   228: astore 6
    //   230: aconst_null
    //   231: astore 4
    //   233: aload 5
    //   235: astore_0
    //   236: aload 4
    //   238: astore_1
    //   239: aload 6
    //   241: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload 5
    //   253: ifnull +16 -> 269
    //   256: aload 5
    //   258: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   261: ifeq +8 -> 269
    //   264: aload 5
    //   266: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   279: ldc_w 318
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: iconst_0
    //   290: istore_3
    //   291: goto -65 -> 226
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_1
    //   298: aload 4
    //   300: astore_0
    //   301: aload 5
    //   303: astore 4
    //   305: aload_0
    //   306: ifnull +14 -> 320
    //   309: aload_0
    //   310: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   313: ifeq +7 -> 320
    //   316: aload_0
    //   317: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   320: aload_1
    //   321: ifnull +7 -> 328
    //   324: aload_1
    //   325: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   328: ldc_w 318
    //   331: iconst_0
    //   332: anewarray 4	java/lang/Object
    //   335: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload 4
    //   340: athrow
    //   341: astore 4
    //   343: goto -38 -> 305
    //   346: astore 6
    //   348: goto -115 -> 233
    //   351: iconst_0
    //   352: istore_3
    //   353: goto -165 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString	java.lang.String
    //   149	37	2	i	int
    //   1	352	3	bool	boolean
    //   3	336	4	localObject1	Object
    //   341	1	4	localObject2	Object
    //   12	253	5	localSQLiteDatabase1	SQLiteDatabase
    //   294	8	5	localObject3	Object
    //   9	193	6	localSQLiteDatabase2	SQLiteDatabase
    //   228	12	6	localThrowable1	Throwable
    //   346	1	6	localThrowable2	Throwable
    //   6	107	7	localObject4	Object
    //   78	66	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   104	109	228	java/lang/Throwable
    //   104	109	294	finally
    //   122	129	341	finally
    //   139	150	341	finally
    //   160	183	341	finally
    //   239	251	341	finally
    //   122	129	346	java/lang/Throwable
    //   139	150	346	java/lang/Throwable
    //   160	183	346	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, List<a> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 321
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnull +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +15 -> 33
    //   21: ldc_w 323
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_1
    //   34: invokeinterface 251 1 0
    //   39: ifgt +15 -> 54
    //   42: ldc_w 325
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: aload_0
    //   55: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   63: astore 7
    //   65: aload 7
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 328	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   74: iconst_0
    //   75: istore_2
    //   76: iload_2
    //   77: aload_1
    //   78: invokeinterface 251 1 0
    //   83: if_icmpge +59 -> 142
    //   86: aload_1
    //   87: iload_2
    //   88: invokeinterface 332 2 0
    //   93: checkcast 2	com/tencent/beacon/a/a/a
    //   96: astore 7
    //   98: aload 6
    //   100: ldc 100
    //   102: ldc 165
    //   104: aload 7
    //   106: invokestatic 334	com/tencent/beacon/a/a/a:a	(Lcom/tencent/beacon/a/a/a;)Landroid/content/ContentValues;
    //   109: invokevirtual 338	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   112: lstore_3
    //   113: lload_3
    //   114: lconst_0
    //   115: lcmp
    //   116: ifge +13 -> 129
    //   119: ldc_w 340
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 7
    //   131: lload_3
    //   132: putfield 21	com/tencent/beacon/a/a/a:a	J
    //   135: iload_2
    //   136: iconst_1
    //   137: iadd
    //   138: istore_2
    //   139: goto -63 -> 76
    //   142: aload 6
    //   144: invokevirtual 343	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   147: aload 6
    //   149: ifnull +21 -> 170
    //   152: aload 6
    //   154: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   157: ifeq +13 -> 170
    //   160: aload 6
    //   162: invokevirtual 346	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   165: aload 6
    //   167: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   178: ldc_w 348
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: iconst_1
    //   189: istore 5
    //   191: iload 5
    //   193: ireturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: aload 6
    //   199: astore_1
    //   200: ldc_w 350
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_1
    //   211: ifnull +18 -> 229
    //   214: aload_1
    //   215: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   218: ifeq +11 -> 229
    //   221: aload_1
    //   222: invokevirtual 346	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   225: aload_1
    //   226: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   237: ldc_w 348
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: iconst_0
    //   248: istore 5
    //   250: goto -59 -> 191
    //   253: astore_1
    //   254: aconst_null
    //   255: astore 6
    //   257: aconst_null
    //   258: astore_0
    //   259: aload 6
    //   261: ifnull +21 -> 282
    //   264: aload 6
    //   266: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   269: ifeq +13 -> 282
    //   272: aload 6
    //   274: invokevirtual 346	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   277: aload 6
    //   279: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   282: aload_0
    //   283: ifnull +7 -> 290
    //   286: aload_0
    //   287: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   290: ldc_w 348
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload_1
    //   301: athrow
    //   302: astore_1
    //   303: aconst_null
    //   304: astore 6
    //   306: goto -47 -> 259
    //   309: astore_1
    //   310: goto -51 -> 259
    //   313: astore 6
    //   315: aload_1
    //   316: astore 7
    //   318: aload 6
    //   320: astore_1
    //   321: aload 7
    //   323: astore 6
    //   325: goto -66 -> 259
    //   328: astore_1
    //   329: aload 6
    //   331: astore_1
    //   332: goto -132 -> 200
    //   335: astore_1
    //   336: aload 6
    //   338: astore_1
    //   339: goto -139 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	Context
    //   0	342	1	paramList	List<a>
    //   75	64	2	i	int
    //   112	20	3	l	long
    //   189	60	5	bool	boolean
    //   1	304	6	localObject1	Object
    //   313	6	6	localObject2	Object
    //   323	14	6	localObject3	Object
    //   63	259	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	194	java/lang/Throwable
    //   54	59	253	finally
    //   59	65	302	finally
    //   69	74	309	finally
    //   76	113	309	finally
    //   119	129	309	finally
    //   129	135	309	finally
    //   142	147	309	finally
    //   200	210	313	finally
    //   59	65	328	java/lang/Throwable
    //   69	74	335	java/lang/Throwable
    //   76	113	335	java/lang/Throwable
    //   119	129	335	java/lang/Throwable
    //   129	135	335	java/lang/Throwable
    //   142	147	335	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, byte[] paramArrayOfByte, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 354
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnull +11 -> 25
    //   17: aload_1
    //   18: ifnull +7 -> 25
    //   21: aload_2
    //   22: ifnonnull +15 -> 37
    //   25: ldc_w 356
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 5
    //   48: aload 5
    //   50: astore 4
    //   52: new 162	android/content/ContentValues
    //   55: dup
    //   56: invokespecial 163	android/content/ContentValues:<init>	()V
    //   59: astore 5
    //   61: aload 5
    //   63: ldc 235
    //   65: aload_2
    //   66: invokevirtual 359	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 5
    //   71: ldc 185
    //   73: new 361	java/util/Date
    //   76: dup
    //   77: invokespecial 362	java/util/Date:<init>	()V
    //   80: invokevirtual 365	java/util/Date:getTime	()J
    //   83: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: invokevirtual 173	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   89: aload 5
    //   91: ldc 189
    //   93: aload_1
    //   94: invokevirtual 192	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   97: aload 4
    //   99: ldc 203
    //   101: aconst_null
    //   102: aload 5
    //   104: invokevirtual 338	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   107: lconst_0
    //   108: lcmp
    //   109: ifge +53 -> 162
    //   112: ldc_w 367
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iconst_0
    //   123: istore_3
    //   124: aload 4
    //   126: ifnull +16 -> 142
    //   129: aload 4
    //   131: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   134: ifeq +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   150: ldc_w 369
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: iload_3
    //   161: ireturn
    //   162: iconst_1
    //   163: istore_3
    //   164: goto -40 -> 124
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_0
    //   170: aload 4
    //   172: astore_1
    //   173: ldc_w 371
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_1
    //   184: ifnull +14 -> 198
    //   187: aload_1
    //   188: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   191: ifeq +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   206: ldc_w 369
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: aconst_null
    //   222: astore_2
    //   223: aload_2
    //   224: ifnull +14 -> 238
    //   227: aload_2
    //   228: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   231: ifeq +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   238: aload_0
    //   239: ifnull +7 -> 246
    //   242: aload_0
    //   243: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   246: ldc_w 369
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_2
    //   261: goto -38 -> 223
    //   264: astore_1
    //   265: aload 4
    //   267: astore_2
    //   268: goto -45 -> 223
    //   271: astore 4
    //   273: aload_1
    //   274: astore_2
    //   275: aload 4
    //   277: astore_1
    //   278: goto -55 -> 223
    //   281: astore_1
    //   282: aload 4
    //   284: astore_1
    //   285: goto -112 -> 173
    //   288: astore_1
    //   289: aload 4
    //   291: astore_1
    //   292: goto -119 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramContext	Context
    //   0	295	1	paramArrayOfByte	byte[]
    //   0	295	2	paramString	java.lang.String
    //   123	41	3	bool	boolean
    //   1	265	4	localObject1	Object
    //   271	19	4	localObject2	Object
    //   46	57	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	167	java/lang/Throwable
    //   37	42	218	finally
    //   42	48	258	finally
    //   52	122	264	finally
    //   173	183	271	finally
    //   42	48	281	java/lang/Throwable
    //   52	122	288	java/lang/Throwable
  }
  
  /* Error */
  public static int b(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 373
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 375
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: ldc2_w 18
    //   29: ldc2_w 376
    //   32: lcmp
    //   33: ifle +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: new 49	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 51
    //   44: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: ldc2_w 18
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc 60
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 379
    //   61: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 8
    //   69: aload 8
    //   71: astore 7
    //   73: aload_1
    //   74: ifnull +102 -> 176
    //   77: aload 8
    //   79: astore 7
    //   81: aload_1
    //   82: arraylength
    //   83: ifle +93 -> 176
    //   86: ldc 71
    //   88: astore 7
    //   90: iconst_0
    //   91: istore 6
    //   93: iload 6
    //   95: aload_1
    //   96: arraylength
    //   97: if_icmpge +41 -> 138
    //   100: new 49	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   107: aload 7
    //   109: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 74
    //   114: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: iload 6
    //   120: iaload
    //   121: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore 7
    //   129: iload 6
    //   131: iconst_1
    //   132: iadd
    //   133: istore 6
    //   135: goto -42 -> 93
    //   138: aload 7
    //   140: iconst_4
    //   141: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: astore_1
    //   145: new 49	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   152: aload 8
    //   154: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 85
    //   159: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 87
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 7
    //   176: new 49	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 381
    //   183: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aconst_null
    //   202: astore 10
    //   204: aconst_null
    //   205: astore 8
    //   207: aconst_null
    //   208: astore 9
    //   210: aload_0
    //   211: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   219: astore_1
    //   220: aload_1
    //   221: ldc 100
    //   223: iconst_1
    //   224: anewarray 79	java/lang/String
    //   227: dup
    //   228: iconst_0
    //   229: ldc_w 383
    //   232: aastore
    //   233: aload 7
    //   235: aconst_null
    //   236: aconst_null
    //   237: aconst_null
    //   238: aconst_null
    //   239: invokevirtual 386	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   242: astore 7
    //   244: aload 7
    //   246: invokeinterface 216 1 0
    //   251: pop
    //   252: aload 7
    //   254: aload 7
    //   256: ldc_w 388
    //   259: invokeinterface 223 2 0
    //   264: invokeinterface 227 2 0
    //   269: istore 6
    //   271: new 49	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 390
    //   278: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: iload 6
    //   283: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: aload 7
    //   298: ifnull +20 -> 318
    //   301: aload 7
    //   303: invokeinterface 292 1 0
    //   308: ifne +10 -> 318
    //   311: aload 7
    //   313: invokeinterface 293 1 0
    //   318: aload_1
    //   319: ifnull +14 -> 333
    //   322: aload_1
    //   323: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   326: ifeq +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: aload_0
    //   334: ifnull +7 -> 341
    //   337: aload_0
    //   338: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   341: ldc_w 392
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iload 6
    //   353: ireturn
    //   354: astore 8
    //   356: aconst_null
    //   357: astore_1
    //   358: aload 10
    //   360: astore_0
    //   361: aload 9
    //   363: astore 7
    //   365: aload 8
    //   367: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_1
    //   378: ifnull +18 -> 396
    //   381: aload_1
    //   382: invokeinterface 292 1 0
    //   387: ifne +9 -> 396
    //   390: aload_1
    //   391: invokeinterface 293 1 0
    //   396: aload 7
    //   398: ifnull +16 -> 414
    //   401: aload 7
    //   403: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   406: ifeq +8 -> 414
    //   409: aload 7
    //   411: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   414: aload_0
    //   415: ifnull +7 -> 422
    //   418: aload_0
    //   419: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   422: ldc_w 392
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: iconst_m1
    //   433: ireturn
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_0
    //   437: aconst_null
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +20 -> 462
    //   445: aload 7
    //   447: invokeinterface 292 1 0
    //   452: ifne +10 -> 462
    //   455: aload 7
    //   457: invokeinterface 293 1 0
    //   462: aload 8
    //   464: ifnull +16 -> 480
    //   467: aload 8
    //   469: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   472: ifeq +8 -> 480
    //   475: aload 8
    //   477: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   480: aload_0
    //   481: ifnull +7 -> 488
    //   484: aload_0
    //   485: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   488: ldc_w 392
    //   491: iconst_0
    //   492: anewarray 4	java/lang/Object
    //   495: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: aload_1
    //   499: athrow
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 7
    //   504: goto -64 -> 440
    //   507: astore 7
    //   509: aconst_null
    //   510: astore 9
    //   512: aload_1
    //   513: astore 8
    //   515: aload 7
    //   517: astore_1
    //   518: aload 9
    //   520: astore 7
    //   522: goto -82 -> 440
    //   525: astore 9
    //   527: aload_1
    //   528: astore 8
    //   530: aload 9
    //   532: astore_1
    //   533: goto -93 -> 440
    //   536: astore 8
    //   538: aload_1
    //   539: astore 9
    //   541: aload 8
    //   543: astore_1
    //   544: aload 7
    //   546: astore 8
    //   548: aload 9
    //   550: astore 7
    //   552: goto -112 -> 440
    //   555: astore 8
    //   557: aconst_null
    //   558: astore_1
    //   559: aload 9
    //   561: astore 7
    //   563: goto -198 -> 365
    //   566: astore 8
    //   568: aconst_null
    //   569: astore 9
    //   571: aload_1
    //   572: astore 7
    //   574: aload 9
    //   576: astore_1
    //   577: goto -212 -> 365
    //   580: astore 8
    //   582: aload 7
    //   584: astore 9
    //   586: aload_1
    //   587: astore 7
    //   589: aload 9
    //   591: astore_1
    //   592: goto -227 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	paramContext	Context
    //   0	595	1	paramArrayOfInt	int[]
    //   0	595	2	paramLong1	long
    //   0	595	4	paramLong2	long
    //   91	261	6	i	int
    //   71	432	7	localObject1	Object
    //   507	9	7	localObject2	Object
    //   520	68	7	localObject3	Object
    //   67	139	8	str	java.lang.String
    //   354	122	8	localThrowable1	Throwable
    //   513	16	8	arrayOfInt	int[]
    //   536	6	8	localObject4	Object
    //   546	1	8	localObject5	Object
    //   555	1	8	localThrowable2	Throwable
    //   566	1	8	localThrowable3	Throwable
    //   580	1	8	localThrowable4	Throwable
    //   208	311	9	localObject6	Object
    //   525	6	9	localObject7	Object
    //   539	51	9	localObject8	Object
    //   202	157	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   210	215	354	java/lang/Throwable
    //   210	215	434	finally
    //   215	220	500	finally
    //   220	244	507	finally
    //   244	296	525	finally
    //   365	377	536	finally
    //   215	220	555	java/lang/Throwable
    //   220	244	566	java/lang/Throwable
    //   244	296	580	java/lang/Throwable
  }
  
  public static boolean b(Context paramContext, List<a> paramList)
  {
    com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans start!", new Object[0]);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      com.tencent.beacon.d.a.d(" context == null || list == null|| list.size() <= 0 ? pls check!", new Object[0]);
      return false;
    }
    localObject = null;
    localContext = null;
    boolean bool3 = true;
    bool1 = true;
    bool2 = bool3;
    for (;;)
    {
      try
      {
        paramContext = c.a(paramContext).getWritableDatabase();
        bool2 = bool3;
        localContext = paramContext;
        localObject = paramContext;
        paramList = paramList.iterator();
      }
      catch (Throwable paramContext)
      {
        a locala;
        ContentValues localContentValues;
        long l;
        localObject = localContext;
        paramContext.printStackTrace();
        if ((localContext == null) || (!localContext.isOpen())) {
          continue;
        }
        localContext.close();
        com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
        return bool2;
        bool1 = false;
        continue;
        if ((paramContext == null) || (!paramContext.isOpen())) {
          continue;
        }
        paramContext.close();
        com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
        return bool1;
      }
      finally
      {
        if ((localObject == null) || (!((SQLiteDatabase)localObject).isOpen())) {
          continue;
        }
        ((SQLiteDatabase)localObject).close();
        com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
      }
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      if (!paramList.hasNext()) {
        continue;
      }
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      locala = (a)paramList.next();
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      localContentValues = a(locala);
      if (localContentValues == null) {
        continue;
      }
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      l = paramContext.replace("t_event", "_id", localContentValues);
      if (l <= 0L) {
        continue;
      }
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      com.tencent.beacon.d.a.b(" result id:" + l, new Object[0]);
      bool2 = bool1;
      localContext = paramContext;
      localObject = paramContext;
      locala.a = l;
    }
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final a a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public final byte[] b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.a
 * JD-Core Version:    0.7.0.1
 */