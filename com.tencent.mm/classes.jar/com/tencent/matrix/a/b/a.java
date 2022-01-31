package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.matrix.d.b;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a
  extends com.tencent.matrix.c.c
{
  private final f bmF;
  final b bmG;
  List<a> bmH;
  private long bmI;
  private final int bmx;
  private final int bmy;
  
  /* Error */
  public a(com.tencent.matrix.c.c.a parama, com.tencent.matrix.a.a.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 43	com/tencent/matrix/c/c:<init>	(Lcom/tencent/matrix/c/c$a;)V
    //   5: aload_0
    //   6: aload_2
    //   7: getfield 47	com/tencent/matrix/a/a/a:bmx	I
    //   10: putfield 48	com/tencent/matrix/a/b/a:bmx	I
    //   13: aload_0
    //   14: aload_2
    //   15: getfield 50	com/tencent/matrix/a/a/a:bmy	I
    //   18: putfield 51	com/tencent/matrix/a/b/a:bmy	I
    //   21: aload_0
    //   22: new 21	com/tencent/matrix/a/b/a$f
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 54	com/tencent/matrix/a/b/a$f:<init>	(Lcom/tencent/matrix/a/b/a;)V
    //   30: putfield 56	com/tencent/matrix/a/b/a:bmF	Lcom/tencent/matrix/a/b/a$f;
    //   33: aload_0
    //   34: getfield 56	com/tencent/matrix/a/b/a:bmF	Lcom/tencent/matrix/a/b/a$f;
    //   37: astore 5
    //   39: new 58	java/io/File
    //   42: dup
    //   43: aload 5
    //   45: getfield 62	com/tencent/matrix/a/b/a$f:bmW	Ljava/lang/String;
    //   48: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 69	java/io/File:exists	()Z
    //   56: ifne +50 -> 106
    //   59: aload 5
    //   61: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   64: new 75	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 78	java/util/ArrayList:<init>	()V
    //   71: putfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   74: aload 5
    //   76: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   79: ldc2_w 81
    //   82: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   85: aload_2
    //   86: bipush 8
    //   88: invokevirtual 88	com/tencent/matrix/a/a/a:ed	(I)Z
    //   91: ifeq +327 -> 418
    //   94: aload_0
    //   95: new 9	com/tencent/matrix/a/b/a$b
    //   98: dup
    //   99: invokespecial 89	com/tencent/matrix/a/b/a$b:<init>	()V
    //   102: putfield 91	com/tencent/matrix/a/b/a:bmG	Lcom/tencent/matrix/a/b/a$b;
    //   105: return
    //   106: new 93	java/io/ObjectInputStream
    //   109: dup
    //   110: new 95	java/io/BufferedInputStream
    //   113: dup
    //   114: new 97	java/io/FileInputStream
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: invokespecial 103	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: invokespecial 104	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore_3
    //   129: aload_3
    //   130: astore_1
    //   131: aload_3
    //   132: invokevirtual 108	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   135: checkcast 15	com/tencent/matrix/a/b/a$d
    //   138: astore 4
    //   140: aload 4
    //   142: ifnull +33 -> 175
    //   145: aload_3
    //   146: astore_1
    //   147: aload 5
    //   149: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   152: aload 4
    //   154: invokevirtual 112	com/tencent/matrix/a/b/a$d:qS	()Ljava/util/List;
    //   157: putfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   160: aload_3
    //   161: astore_1
    //   162: aload 5
    //   164: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   167: aload 4
    //   169: invokestatic 115	com/tencent/matrix/a/b/a$d:a	(Lcom/tencent/matrix/a/b/a$d;)J
    //   172: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   175: aload_3
    //   176: invokevirtual 118	java/io/ObjectInputStream:close	()V
    //   179: aload 5
    //   181: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   184: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   187: ifnonnull +29 -> 216
    //   190: aload 5
    //   192: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   195: new 75	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 78	java/util/ArrayList:<init>	()V
    //   202: putfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   205: aload 5
    //   207: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   210: ldc2_w 81
    //   213: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   216: ldc 120
    //   218: ldc 122
    //   220: iconst_2
    //   221: anewarray 124	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload 5
    //   228: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   231: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   234: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: aload 5
    //   242: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   245: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   248: invokeinterface 136 1 0
    //   253: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aastore
    //   257: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -175 -> 85
    //   263: astore_1
    //   264: ldc 120
    //   266: ldc 149
    //   268: iconst_1
    //   269: anewarray 124	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: aload_1
    //   275: aastore
    //   276: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -100 -> 179
    //   282: astore 4
    //   284: aconst_null
    //   285: astore_3
    //   286: aload_3
    //   287: astore_1
    //   288: ldc 120
    //   290: ldc 154
    //   292: iconst_1
    //   293: anewarray 124	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload 4
    //   300: aastore
    //   301: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload_3
    //   305: ifnull -126 -> 179
    //   308: aload_3
    //   309: invokevirtual 118	java/io/ObjectInputStream:close	()V
    //   312: goto -133 -> 179
    //   315: astore_1
    //   316: ldc 120
    //   318: ldc 149
    //   320: iconst_1
    //   321: anewarray 124	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload_1
    //   327: aastore
    //   328: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: goto -152 -> 179
    //   334: astore 4
    //   336: aconst_null
    //   337: astore_3
    //   338: aload_3
    //   339: astore_1
    //   340: ldc 120
    //   342: ldc 154
    //   344: iconst_1
    //   345: anewarray 124	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload 4
    //   352: aastore
    //   353: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: aload_3
    //   357: ifnull -178 -> 179
    //   360: aload_3
    //   361: invokevirtual 118	java/io/ObjectInputStream:close	()V
    //   364: goto -185 -> 179
    //   367: astore_1
    //   368: ldc 120
    //   370: ldc 149
    //   372: iconst_1
    //   373: anewarray 124	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: aload_1
    //   379: aastore
    //   380: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: goto -204 -> 179
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_1
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokevirtual 118	java/io/ObjectInputStream:close	()V
    //   397: aload_2
    //   398: athrow
    //   399: astore_1
    //   400: ldc 120
    //   402: ldc 149
    //   404: iconst_1
    //   405: anewarray 124	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload_1
    //   411: aastore
    //   412: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: goto -18 -> 397
    //   418: aload_0
    //   419: aconst_null
    //   420: putfield 91	com/tencent/matrix/a/b/a:bmG	Lcom/tencent/matrix/a/b/a$b;
    //   423: return
    //   424: astore_2
    //   425: goto -36 -> 389
    //   428: astore 4
    //   430: goto -92 -> 338
    //   433: astore 4
    //   435: goto -149 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	a
    //   0	438	1	parama	com.tencent.matrix.c.c.a
    //   0	438	2	parama1	com.tencent.matrix.a.a.a
    //   128	233	3	localObjectInputStream	java.io.ObjectInputStream
    //   138	30	4	locald	d
    //   282	17	4	localIOException1	java.io.IOException
    //   334	17	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   428	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   433	1	4	localIOException2	java.io.IOException
    //   37	204	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   175	179	263	java/io/IOException
    //   106	129	282	java/io/IOException
    //   308	312	315	java/io/IOException
    //   106	129	334	java/lang/ClassNotFoundException
    //   360	364	367	java/io/IOException
    //   106	129	386	finally
    //   393	397	399	java/io/IOException
    //   131	140	424	finally
    //   147	160	424	finally
    //   162	175	424	finally
    //   288	304	424	finally
    //   340	356	424	finally
    //   131	140	428	java/lang/ClassNotFoundException
    //   147	160	428	java/lang/ClassNotFoundException
    //   162	175	428	java/lang/ClassNotFoundException
    //   131	140	433	java/io/IOException
    //   147	160	433	java/io/IOException
    //   162	175	433	java/io/IOException
  }
  
  final void a(AlarmManager.OnAlarmListener paramOnAlarmListener, e parame)
  {
    int j = 0;
    if (j < this.bmH.size())
    {
      a locala = (a)this.bmH.get(j);
      if ((locala.bmM != null) && (locala.bmM.equals(paramOnAlarmListener))) {
        locala.qR();
      }
      for (;;)
      {
        j += 1;
        break;
        if (locala.bmL != null)
        {
          e locale = locala.bmL;
          int i;
          if ((locale.bmU != null) && (locale.bmU.equals(parame.bmU))) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label197;
            }
            locala.qR();
            break;
            if (locale.bmP == parame.bmP) {
              i = 1;
            } else if ((locale.bmV != null) && (locale.bmV.filterEquals(parame.bmV))) {
              i = 1;
            } else if ((locale.bmR != null) && (locale.bmR.equals(parame.bmR))) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        label197:
        if ((locala.bmL == null) && (locala.bmM == null)) {
          locala.qR();
        }
      }
    }
  }
  
  /* Error */
  final void qQ()
  {
    // Byte code:
    //   0: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: ldc 120
    //   7: ldc 250
    //   9: iconst_2
    //   10: anewarray 124	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: lload 11
    //   17: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   27: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   30: aastore
    //   31: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   38: lconst_0
    //   39: lcmp
    //   40: ifgt +9 -> 49
    //   43: aload_0
    //   44: lload 11
    //   46: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   49: lload 11
    //   51: aload_0
    //   52: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   55: lsub
    //   56: ldc2_w 251
    //   59: lcmp
    //   60: iflt +73 -> 133
    //   63: aload_0
    //   64: lload 11
    //   66: ldc2_w 253
    //   69: lsub
    //   70: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   73: aload_0
    //   74: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   77: ldc2_w 255
    //   80: ladd
    //   81: lload 11
    //   83: lcmp
    //   84: ifgt +649 -> 733
    //   87: aload_0
    //   88: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   98: invokeinterface 259 1 0
    //   103: ifeq +59 -> 162
    //   106: ldc 120
    //   108: ldc_w 261
    //   111: iconst_0
    //   112: anewarray 124	java/lang/Object
    //   115: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   123: ldc2_w 255
    //   126: ladd
    //   127: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   130: goto -57 -> 73
    //   133: lload 11
    //   135: aload_0
    //   136: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   139: lsub
    //   140: ldc2_w 253
    //   143: lcmp
    //   144: iflt -71 -> 73
    //   147: aload_0
    //   148: aload_0
    //   149: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   152: ldc2_w 253
    //   155: ladd
    //   156: putfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   159: goto -86 -> 73
    //   162: new 263	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   169: astore 14
    //   171: new 263	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   178: astore 15
    //   180: iconst_0
    //   181: istore_2
    //   182: aload_0
    //   183: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   186: ldc2_w 255
    //   189: ladd
    //   190: lstore 9
    //   192: aload_0
    //   193: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   196: invokeinterface 268 1 0
    //   201: astore 13
    //   203: iconst_0
    //   204: istore_1
    //   205: aload 13
    //   207: invokeinterface 273 1 0
    //   212: ifeq +317 -> 529
    //   215: aload 13
    //   217: invokeinterface 276 1 0
    //   222: checkcast 6	com/tencent/matrix/a/b/a$a
    //   225: astore 16
    //   227: aload 16
    //   229: getfield 279	com/tencent/matrix/a/b/a$a:type	I
    //   232: iconst_1
    //   233: if_icmpeq +11 -> 244
    //   236: aload 16
    //   238: getfield 279	com/tencent/matrix/a/b/a$a:type	I
    //   241: ifne +40 -> 281
    //   244: aload 16
    //   246: getfield 282	com/tencent/matrix/a/b/a$a:bmJ	J
    //   249: lstore 5
    //   251: lload 5
    //   253: aload_0
    //   254: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   257: lcmp
    //   258: ifge +41 -> 299
    //   261: aload 16
    //   263: getfield 285	com/tencent/matrix/a/b/a$a:bmK	J
    //   266: lconst_0
    //   267: lcmp
    //   268: ifgt +31 -> 299
    //   271: aload 13
    //   273: invokeinterface 288 1 0
    //   278: goto -73 -> 205
    //   281: aload 16
    //   283: getfield 282	com/tencent/matrix/a/b/a$a:bmJ	J
    //   286: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   289: ladd
    //   290: invokestatic 293	android/os/SystemClock:elapsedRealtime	()J
    //   293: lsub
    //   294: lstore 5
    //   296: goto -45 -> 251
    //   299: aload 16
    //   301: getfield 296	com/tencent/matrix/a/b/a$a:bmN	J
    //   304: aload_0
    //   305: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   308: lcmp
    //   309: iflt +14 -> 323
    //   312: aload 16
    //   314: getfield 296	com/tencent/matrix/a/b/a$a:bmN	J
    //   317: lload 5
    //   319: lcmp
    //   320: ifgt +13 -> 333
    //   323: aload 13
    //   325: invokeinterface 288 1 0
    //   330: goto -125 -> 205
    //   333: lload 5
    //   335: lload 9
    //   337: lcmp
    //   338: ifge -133 -> 205
    //   341: aload 16
    //   343: getfield 285	com/tencent/matrix/a/b/a$a:bmK	J
    //   346: lconst_0
    //   347: lcmp
    //   348: ifle +170 -> 518
    //   351: aload 16
    //   353: getfield 296	com/tencent/matrix/a/b/a$a:bmN	J
    //   356: lload 9
    //   358: lcmp
    //   359: ifge +118 -> 477
    //   362: aload 16
    //   364: getfield 296	com/tencent/matrix/a/b/a$a:bmN	J
    //   367: lstore 7
    //   369: aload_0
    //   370: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   373: lload 5
    //   375: lcmp
    //   376: ifgt +108 -> 484
    //   379: lload 7
    //   381: lload 5
    //   383: lsub
    //   384: lconst_1
    //   385: lsub
    //   386: aload 16
    //   388: getfield 285	com/tencent/matrix/a/b/a$a:bmK	J
    //   391: ldiv
    //   392: lconst_1
    //   393: ladd
    //   394: lstore 5
    //   396: iload_2
    //   397: i2l
    //   398: lload 5
    //   400: ladd
    //   401: l2i
    //   402: istore 4
    //   404: aload 14
    //   406: aload 16
    //   408: getfield 299	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   411: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 305
    //   417: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 16
    //   423: getfield 279	com/tencent/matrix/a/b/a$a:type	I
    //   426: ifeq +12 -> 438
    //   429: aload 16
    //   431: getfield 279	com/tencent/matrix/a/b/a$a:type	I
    //   434: iconst_2
    //   435: if_icmpne +89 -> 524
    //   438: iconst_1
    //   439: istore_3
    //   440: iload 4
    //   442: istore_2
    //   443: iload_3
    //   444: ifeq -239 -> 205
    //   447: lload 5
    //   449: iload_1
    //   450: i2l
    //   451: ladd
    //   452: l2i
    //   453: istore_1
    //   454: aload 15
    //   456: aload 16
    //   458: getfield 299	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   461: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 305
    //   467: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: iload 4
    //   473: istore_2
    //   474: goto -269 -> 205
    //   477: lload 9
    //   479: lstore 7
    //   481: goto -112 -> 369
    //   484: lload 7
    //   486: aload_0
    //   487: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   490: aload_0
    //   491: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   494: lload 5
    //   496: lsub
    //   497: aload 16
    //   499: getfield 285	com/tencent/matrix/a/b/a$a:bmK	J
    //   502: lrem
    //   503: lsub
    //   504: lsub
    //   505: lconst_1
    //   506: lsub
    //   507: aload 16
    //   509: getfield 285	com/tencent/matrix/a/b/a$a:bmK	J
    //   512: ldiv
    //   513: lstore 5
    //   515: goto -119 -> 396
    //   518: lconst_1
    //   519: lstore 5
    //   521: goto -125 -> 396
    //   524: iconst_0
    //   525: istore_3
    //   526: goto -86 -> 440
    //   529: iconst_m1
    //   530: istore_3
    //   531: aconst_null
    //   532: astore 13
    //   534: iload_2
    //   535: aload_0
    //   536: getfield 48	com/tencent/matrix/a/b/a:bmx	I
    //   539: if_icmplt +67 -> 606
    //   542: aload 14
    //   544: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: astore 13
    //   549: iconst_4
    //   550: istore_1
    //   551: iload_1
    //   552: ifle -434 -> 118
    //   555: ldc_w 311
    //   558: iconst_2
    //   559: anewarray 124	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: iload_1
    //   565: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: aload 13
    //   573: aastore
    //   574: invokestatic 315	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   577: invokestatic 321	com/tencent/matrix/d/c:bB	(Ljava/lang/String;)Ljava/lang/String;
    //   580: astore 14
    //   582: aload_0
    //   583: aload 14
    //   585: invokevirtual 325	com/tencent/matrix/a/b/a:by	(Ljava/lang/String;)Z
    //   588: ifeq +42 -> 630
    //   591: ldc 120
    //   593: ldc_w 327
    //   596: iconst_0
    //   597: anewarray 124	java/lang/Object
    //   600: invokestatic 330	com/tencent/matrix/d/b:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: goto -485 -> 118
    //   606: iload_1
    //   607: aload_0
    //   608: getfield 51	com/tencent/matrix/a/b/a:bmy	I
    //   611: if_icmplt +409 -> 1020
    //   614: iconst_5
    //   615: istore_3
    //   616: aload 15
    //   618: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: astore 13
    //   623: iload_1
    //   624: istore_2
    //   625: iload_3
    //   626: istore_1
    //   627: goto -76 -> 551
    //   630: new 332	org/json/JSONObject
    //   633: dup
    //   634: invokespecial 333	org/json/JSONObject:<init>	()V
    //   637: astore 15
    //   639: aload 15
    //   641: ldc_w 335
    //   644: aload 13
    //   646: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   649: pop
    //   650: aload 15
    //   652: ldc_w 341
    //   655: iload_2
    //   656: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   659: pop
    //   660: aload 15
    //   662: ldc_w 346
    //   665: ldc_w 348
    //   668: invokevirtual 339	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   671: pop
    //   672: new 350	com/tencent/matrix/c/b
    //   675: dup
    //   676: iload_1
    //   677: invokespecial 352	com/tencent/matrix/c/b:<init>	(I)V
    //   680: astore 13
    //   682: aload 13
    //   684: aload 14
    //   686: putfield 355	com/tencent/matrix/c/b:key	Ljava/lang/String;
    //   689: aload 13
    //   691: aload 15
    //   693: putfield 359	com/tencent/matrix/c/b:boK	Lorg/json/JSONObject;
    //   696: aload_0
    //   697: aload 13
    //   699: invokevirtual 362	com/tencent/matrix/a/b/a:c	(Lcom/tencent/matrix/c/b;)V
    //   702: aload_0
    //   703: aload 14
    //   705: invokevirtual 365	com/tencent/matrix/a/b/a:bx	(Ljava/lang/String;)V
    //   708: goto -590 -> 118
    //   711: astore 13
    //   713: ldc 120
    //   715: ldc_w 367
    //   718: iconst_1
    //   719: anewarray 124	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: aload 13
    //   726: aastore
    //   727: invokestatic 369	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   730: goto -58 -> 672
    //   733: aload_0
    //   734: getfield 56	com/tencent/matrix/a/b/a:bmF	Lcom/tencent/matrix/a/b/a$f;
    //   737: astore 15
    //   739: new 58	java/io/File
    //   742: dup
    //   743: aload 15
    //   745: getfield 62	com/tencent/matrix/a/b/a$f:bmW	Ljava/lang/String;
    //   748: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   751: astore 13
    //   753: aload 13
    //   755: invokevirtual 373	java/io/File:getParentFile	()Ljava/io/File;
    //   758: invokevirtual 69	java/io/File:exists	()Z
    //   761: ifne +12 -> 773
    //   764: aload 13
    //   766: invokevirtual 373	java/io/File:getParentFile	()Ljava/io/File;
    //   769: invokevirtual 376	java/io/File:mkdirs	()Z
    //   772: pop
    //   773: new 378	java/io/ObjectOutputStream
    //   776: dup
    //   777: new 380	java/io/BufferedOutputStream
    //   780: dup
    //   781: new 382	java/io/FileOutputStream
    //   784: dup
    //   785: aload 13
    //   787: invokespecial 383	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   790: invokespecial 386	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   793: invokespecial 387	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   796: astore 14
    //   798: aload 14
    //   800: astore 13
    //   802: aload 14
    //   804: new 15	com/tencent/matrix/a/b/a$d
    //   807: dup
    //   808: aload 15
    //   810: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   813: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   816: aload 15
    //   818: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   821: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   824: invokespecial 390	com/tencent/matrix/a/b/a$d:<init>	(Ljava/util/List;J)V
    //   827: invokevirtual 394	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   830: aload 14
    //   832: astore 13
    //   834: aload 14
    //   836: invokevirtual 397	java/io/ObjectOutputStream:flush	()V
    //   839: aload 14
    //   841: astore 13
    //   843: ldc 120
    //   845: ldc_w 399
    //   848: iconst_2
    //   849: anewarray 124	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload 15
    //   856: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   859: getfield 84	com/tencent/matrix/a/b/a:bmI	J
    //   862: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   865: aastore
    //   866: dup
    //   867: iconst_1
    //   868: aload 15
    //   870: getfield 73	com/tencent/matrix/a/b/a$f:bmX	Lcom/tencent/matrix/a/b/a;
    //   873: getfield 80	com/tencent/matrix/a/b/a:bmH	Ljava/util/List;
    //   876: invokeinterface 136 1 0
    //   881: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   884: aastore
    //   885: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   888: aload 14
    //   890: invokevirtual 400	java/io/ObjectOutputStream:close	()V
    //   893: return
    //   894: astore 13
    //   896: ldc 120
    //   898: ldc_w 402
    //   901: iconst_1
    //   902: anewarray 124	java/lang/Object
    //   905: dup
    //   906: iconst_0
    //   907: aload 13
    //   909: aastore
    //   910: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: return
    //   914: astore 15
    //   916: aconst_null
    //   917: astore 14
    //   919: aload 14
    //   921: astore 13
    //   923: ldc 120
    //   925: ldc 149
    //   927: iconst_1
    //   928: anewarray 124	java/lang/Object
    //   931: dup
    //   932: iconst_0
    //   933: aload 15
    //   935: aastore
    //   936: invokestatic 152	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   939: aload 14
    //   941: ifnull -48 -> 893
    //   944: aload 14
    //   946: invokevirtual 400	java/io/ObjectOutputStream:close	()V
    //   949: return
    //   950: astore 13
    //   952: ldc 120
    //   954: ldc_w 402
    //   957: iconst_1
    //   958: anewarray 124	java/lang/Object
    //   961: dup
    //   962: iconst_0
    //   963: aload 13
    //   965: aastore
    //   966: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   969: return
    //   970: astore 14
    //   972: aconst_null
    //   973: astore 13
    //   975: aload 13
    //   977: ifnull +8 -> 985
    //   980: aload 13
    //   982: invokevirtual 400	java/io/ObjectOutputStream:close	()V
    //   985: aload 14
    //   987: athrow
    //   988: astore 13
    //   990: ldc 120
    //   992: ldc_w 402
    //   995: iconst_1
    //   996: anewarray 124	java/lang/Object
    //   999: dup
    //   1000: iconst_0
    //   1001: aload 13
    //   1003: aastore
    //   1004: invokestatic 147	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: goto -22 -> 985
    //   1010: astore 14
    //   1012: goto -37 -> 975
    //   1015: astore 15
    //   1017: goto -98 -> 919
    //   1020: iconst_0
    //   1021: istore_2
    //   1022: iload_3
    //   1023: istore_1
    //   1024: goto -473 -> 551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	this	a
    //   204	820	1	i	int
    //   181	841	2	j	int
    //   439	584	3	k	int
    //   402	70	4	m	int
    //   249	271	5	l1	long
    //   367	118	7	l2	long
    //   190	288	9	l3	long
    //   3	131	11	l4	long
    //   201	497	13	localObject1	Object
    //   711	14	13	localJSONException	org.json.JSONException
    //   751	91	13	localObject2	Object
    //   894	14	13	localIOException1	java.io.IOException
    //   921	1	13	localObject3	Object
    //   950	14	13	localIOException2	java.io.IOException
    //   973	8	13	localObject4	Object
    //   988	14	13	localIOException3	java.io.IOException
    //   169	776	14	localObject5	Object
    //   970	16	14	localObject6	Object
    //   1010	1	14	localObject7	Object
    //   178	691	15	localObject8	Object
    //   914	20	15	localIOException4	java.io.IOException
    //   1015	1	15	localIOException5	java.io.IOException
    //   225	283	16	locala	a
    // Exception table:
    //   from	to	target	type
    //   639	672	711	org/json/JSONException
    //   888	893	894	java/io/IOException
    //   773	798	914	java/io/IOException
    //   944	949	950	java/io/IOException
    //   773	798	970	finally
    //   980	985	988	java/io/IOException
    //   802	830	1010	finally
    //   834	839	1010	finally
    //   843	888	1010	finally
    //   923	939	1010	finally
    //   802	830	1015	java/io/IOException
    //   834	839	1015	java/io/IOException
    //   843	888	1015	java/io/IOException
  }
  
  private static final class a
  {
    final long bmJ;
    final long bmK;
    final a.e bmL;
    final AlarmManager.OnAlarmListener bmM;
    long bmN;
    final String stackTrace;
    final int type;
    
    a(int paramInt, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener, String paramString)
    {
      this.type = paramInt;
      if ((paramInt == 2) || (paramInt == 3)) {}
      for (long l1 = SystemClock.elapsedRealtime();; l1 = System.currentTimeMillis())
      {
        long l2 = l1 + 5000L;
        l1 = paramLong1;
        if (paramLong1 < l2) {
          l1 = l2;
        }
        this.bmJ = l1;
        paramLong1 = paramLong2;
        if (paramLong2 > 0L)
        {
          paramLong1 = paramLong2;
          if (paramLong2 < 60000L) {
            paramLong1 = 60000L;
          }
        }
        this.bmK = paramLong1;
        this.bmL = new a.e(paramPendingIntent);
        this.bmM = paramOnAlarmListener;
        this.stackTrace = paramString;
        this.bmN = 9223372036854775807L;
        return;
      }
    }
    
    a(int paramInt, long paramLong1, long paramLong2, a.e parame, String paramString, long paramLong3)
    {
      this.type = paramInt;
      this.bmJ = paramLong1;
      this.bmK = paramLong2;
      this.bmL = parame;
      this.bmM = null;
      this.stackTrace = paramString;
      this.bmN = paramLong3;
    }
    
    public final void qR()
    {
      if (this.bmN != 9223372036854775807L) {
        return;
      }
      this.bmN = System.currentTimeMillis();
    }
  }
  
  private static final class b
  {
    private final String bmO;
    
    b()
    {
      String str = com.tencent.matrix.d.c.g("yyyy-MM-dd", System.currentTimeMillis());
      this.bmO = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), str });
      b.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", new Object[] { this.bmO });
    }
    
    /* Error */
    final void bu(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore 4
      //   8: aload_3
      //   9: astore_2
      //   10: new 37	java/io/File
      //   13: dup
      //   14: aload_0
      //   15: getfield 54	com/tencent/matrix/a/b/a$b:bmO	Ljava/lang/String;
      //   18: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
      //   21: astore 6
      //   23: aload_3
      //   24: astore_2
      //   25: aload 6
      //   27: invokevirtual 76	java/io/File:getParentFile	()Ljava/io/File;
      //   30: invokevirtual 80	java/io/File:mkdirs	()Z
      //   33: ifne +30 -> 63
      //   36: aload_3
      //   37: astore_2
      //   38: aload 6
      //   40: invokevirtual 76	java/io/File:getParentFile	()Ljava/io/File;
      //   43: invokevirtual 83	java/io/File:exists	()Z
      //   46: ifne +17 -> 63
      //   49: aload_3
      //   50: astore_2
      //   51: ldc 56
      //   53: ldc 85
      //   55: iconst_0
      //   56: anewarray 4	java/lang/Object
      //   59: invokestatic 88	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   62: return
      //   63: aload_3
      //   64: astore_2
      //   65: new 90	java/io/BufferedWriter
      //   68: dup
      //   69: new 92	java/io/OutputStreamWriter
      //   72: dup
      //   73: new 94	java/io/FileOutputStream
      //   76: dup
      //   77: aload 6
      //   79: iconst_1
      //   80: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   83: invokespecial 100	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   86: invokespecial 103	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   89: astore_3
      //   90: aload_3
      //   91: aload_1
      //   92: iconst_0
      //   93: aload_1
      //   94: invokevirtual 107	java/lang/String:length	()I
      //   97: invokevirtual 111	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
      //   100: aload_3
      //   101: invokevirtual 114	java/io/BufferedWriter:flush	()V
      //   104: aload_3
      //   105: invokevirtual 117	java/io/BufferedWriter:close	()V
      //   108: return
      //   109: astore_1
      //   110: return
      //   111: astore_3
      //   112: aload 4
      //   114: astore_1
      //   115: aload_1
      //   116: astore_2
      //   117: ldc 56
      //   119: ldc 119
      //   121: iconst_1
      //   122: anewarray 4	java/lang/Object
      //   125: dup
      //   126: iconst_0
      //   127: aload_3
      //   128: invokevirtual 122	java/io/FileNotFoundException:getLocalizedMessage	()Ljava/lang/String;
      //   131: aastore
      //   132: invokestatic 125	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   135: aload_1
      //   136: ifnull +82 -> 218
      //   139: aload_1
      //   140: invokevirtual 117	java/io/BufferedWriter:close	()V
      //   143: return
      //   144: astore_1
      //   145: return
      //   146: astore_3
      //   147: aload 5
      //   149: astore_1
      //   150: aload_1
      //   151: astore_2
      //   152: ldc 56
      //   154: ldc 119
      //   156: iconst_1
      //   157: anewarray 4	java/lang/Object
      //   160: dup
      //   161: iconst_0
      //   162: aload_3
      //   163: invokevirtual 126	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
      //   166: aastore
      //   167: invokestatic 125	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   170: aload_1
      //   171: ifnull +47 -> 218
      //   174: aload_1
      //   175: invokevirtual 117	java/io/BufferedWriter:close	()V
      //   178: return
      //   179: astore_1
      //   180: return
      //   181: astore_1
      //   182: aload_2
      //   183: ifnull +7 -> 190
      //   186: aload_2
      //   187: invokevirtual 117	java/io/BufferedWriter:close	()V
      //   190: aload_1
      //   191: athrow
      //   192: astore_2
      //   193: goto -3 -> 190
      //   196: astore_1
      //   197: aload_3
      //   198: astore_2
      //   199: goto -17 -> 182
      //   202: astore_2
      //   203: aload_3
      //   204: astore_1
      //   205: aload_2
      //   206: astore_3
      //   207: goto -57 -> 150
      //   210: astore_2
      //   211: aload_3
      //   212: astore_1
      //   213: aload_2
      //   214: astore_3
      //   215: goto -100 -> 115
      //   218: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	219	0	this	b
      //   0	219	1	paramString	String
      //   9	178	2	localObject1	Object
      //   192	1	2	localIOException1	java.io.IOException
      //   198	1	2	localIOException2	java.io.IOException
      //   202	4	2	localIOException3	java.io.IOException
      //   210	4	2	localFileNotFoundException1	java.io.FileNotFoundException
      //   4	101	3	localBufferedWriter	java.io.BufferedWriter
      //   111	17	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   146	58	3	localIOException4	java.io.IOException
      //   206	9	3	localObject2	Object
      //   6	107	4	localObject3	Object
      //   1	147	5	localObject4	Object
      //   21	57	6	localFile	File
      // Exception table:
      //   from	to	target	type
      //   104	108	109	java/io/IOException
      //   10	23	111	java/io/FileNotFoundException
      //   25	36	111	java/io/FileNotFoundException
      //   38	49	111	java/io/FileNotFoundException
      //   51	62	111	java/io/FileNotFoundException
      //   65	90	111	java/io/FileNotFoundException
      //   139	143	144	java/io/IOException
      //   10	23	146	java/io/IOException
      //   25	36	146	java/io/IOException
      //   38	49	146	java/io/IOException
      //   51	62	146	java/io/IOException
      //   65	90	146	java/io/IOException
      //   174	178	179	java/io/IOException
      //   10	23	181	finally
      //   25	36	181	finally
      //   38	49	181	finally
      //   51	62	181	finally
      //   65	90	181	finally
      //   117	135	181	finally
      //   152	170	181	finally
      //   186	190	192	java/io/IOException
      //   90	104	196	finally
      //   90	104	202	java/io/IOException
      //   90	104	210	java/io/FileNotFoundException
    }
  }
  
  private static final class c
    implements Serializable
  {
    final long bmJ;
    final long bmK;
    long bmN;
    final int bmP;
    final byte[] bmQ;
    final String bmR;
    final String stackTrace;
    final int type;
    
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    c(a.a parama)
    {
      assert (parama != null);
      this.type = parama.type;
      this.bmJ = parama.bmJ;
      this.bmK = parama.bmK;
      this.bmP = parama.bmL.bmP;
      this.bmQ = a.c(parama.bmL.bmV);
      this.bmR = parama.bmL.bmR;
      this.stackTrace = parama.stackTrace;
      this.bmN = parama.bmN;
    }
  }
  
  private static final class d
    implements Serializable
  {
    private final List<a.c> bmH = new ArrayList();
    private final long bmI;
    
    d(List<a.a> paramList, long paramLong)
    {
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          this.bmH.add(new a.c((a.a)paramList.get(i)));
          i += 1;
        }
      }
      this.bmI = paramLong;
    }
    
    public final List<a.a> qS()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.bmH.size())
      {
        a.c localc = (a.c)this.bmH.get(i);
        a.e locale = new a.e(localc.bmP, a.m(localc.bmQ), localc.bmR);
        localArrayList.add(new a.a(localc.type, localc.bmJ, localc.bmK, locale, localc.stackTrace, localc.bmN));
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private static final class e
  {
    private static Method bmS;
    private static Method bmT;
    final int bmP;
    final String bmR;
    final PendingIntent bmU;
    final Intent bmV;
    
    e(int paramInt, Intent paramIntent, String paramString)
    {
      this.bmU = null;
      this.bmP = paramInt;
      this.bmV = paramIntent;
      this.bmR = paramString;
    }
    
    e(PendingIntent paramPendingIntent)
    {
      this.bmU = paramPendingIntent;
      if (this.bmU != null)
      {
        this.bmP = paramPendingIntent.hashCode();
        this.bmV = a(paramPendingIntent);
        this.bmR = b(paramPendingIntent);
        return;
      }
      this.bmP = -1;
      this.bmV = null;
      this.bmR = null;
    }
    
    /* Error */
    private static Intent a(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 57	com/tencent/matrix/a/b/a$e:bmS	Ljava/lang/reflect/Method;
      //   9: ifnonnull +24 -> 33
      //   12: ldc 35
      //   14: ldc 59
      //   16: iconst_0
      //   17: anewarray 61	java/lang/Class
      //   20: invokevirtual 65	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   23: astore_2
      //   24: aload_2
      //   25: putstatic 57	com/tencent/matrix/a/b/a$e:bmS	Ljava/lang/reflect/Method;
      //   28: aload_2
      //   29: iconst_1
      //   30: invokevirtual 71	java/lang/reflect/Method:setAccessible	(Z)V
      //   33: getstatic 57	com/tencent/matrix/a/b/a$e:bmS	Ljava/lang/reflect/Method;
      //   36: aload_0
      //   37: iconst_0
      //   38: anewarray 4	java/lang/Object
      //   41: invokevirtual 75	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   44: astore_0
      //   45: aload_0
      //   46: instanceof 77
      //   49: istore_1
      //   50: iload_1
      //   51: ifne +23 -> 74
      //   54: aconst_null
      //   55: areturn
      //   56: astore_0
      //   57: ldc 79
      //   59: ldc 81
      //   61: iconst_1
      //   62: anewarray 4	java/lang/Object
      //   65: dup
      //   66: iconst_0
      //   67: aload_0
      //   68: aastore
      //   69: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: aconst_null
      //   73: areturn
      //   74: aload_0
      //   75: checkcast 77	android/content/Intent
      //   78: astore_0
      //   79: aload_0
      //   80: areturn
      //   81: astore_0
      //   82: ldc 79
      //   84: ldc 81
      //   86: iconst_1
      //   87: anewarray 4	java/lang/Object
      //   90: dup
      //   91: iconst_0
      //   92: aload_0
      //   93: aastore
      //   94: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: aconst_null
      //   98: areturn
      //   99: astore_0
      //   100: ldc 79
      //   102: ldc 89
      //   104: iconst_2
      //   105: anewarray 4	java/lang/Object
      //   108: dup
      //   109: iconst_0
      //   110: aload_0
      //   111: aastore
      //   112: dup
      //   113: iconst_1
      //   114: aload_0
      //   115: invokevirtual 93	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
      //   118: aastore
      //   119: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   122: goto -25 -> 97
      //   125: astore_0
      //   126: ldc 79
      //   128: ldc 81
      //   130: iconst_1
      //   131: anewarray 4	java/lang/Object
      //   134: dup
      //   135: iconst_0
      //   136: aload_0
      //   137: aastore
      //   138: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   141: goto -44 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	paramPendingIntent	PendingIntent
      //   49	2	1	bool	boolean
      //   23	6	2	localMethod	Method
      // Exception table:
      //   from	to	target	type
      //   12	33	56	java/lang/NoSuchMethodException
      //   33	50	81	java/lang/IllegalAccessException
      //   74	79	81	java/lang/IllegalAccessException
      //   33	50	99	java/lang/reflect/InvocationTargetException
      //   74	79	99	java/lang/reflect/InvocationTargetException
      //   33	50	125	java/lang/SecurityException
      //   74	79	125	java/lang/SecurityException
    }
    
    /* Error */
    private static String b(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 95	com/tencent/matrix/a/b/a$e:bmT	Ljava/lang/reflect/Method;
      //   9: ifnonnull +29 -> 38
      //   12: ldc 35
      //   14: ldc 97
      //   16: iconst_1
      //   17: anewarray 61	java/lang/Class
      //   20: dup
      //   21: iconst_0
      //   22: ldc 99
      //   24: aastore
      //   25: invokevirtual 65	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   28: astore_2
      //   29: aload_2
      //   30: putstatic 95	com/tencent/matrix/a/b/a$e:bmT	Ljava/lang/reflect/Method;
      //   33: aload_2
      //   34: iconst_1
      //   35: invokevirtual 71	java/lang/reflect/Method:setAccessible	(Z)V
      //   38: getstatic 95	com/tencent/matrix/a/b/a$e:bmT	Ljava/lang/reflect/Method;
      //   41: aload_0
      //   42: iconst_1
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: ldc 101
      //   50: aastore
      //   51: invokevirtual 75	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   54: astore_0
      //   55: aload_0
      //   56: instanceof 99
      //   59: istore_1
      //   60: iload_1
      //   61: ifne +23 -> 84
      //   64: aconst_null
      //   65: areturn
      //   66: astore_0
      //   67: ldc 79
      //   69: ldc 103
      //   71: iconst_1
      //   72: anewarray 4	java/lang/Object
      //   75: dup
      //   76: iconst_0
      //   77: aload_0
      //   78: aastore
      //   79: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   82: aconst_null
      //   83: areturn
      //   84: aload_0
      //   85: checkcast 99	java/lang/String
      //   88: astore_0
      //   89: aload_0
      //   90: areturn
      //   91: astore_0
      //   92: ldc 79
      //   94: ldc 103
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_0
      //   103: aastore
      //   104: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: aconst_null
      //   108: areturn
      //   109: astore_0
      //   110: ldc 79
      //   112: ldc 103
      //   114: iconst_1
      //   115: anewarray 4	java/lang/Object
      //   118: dup
      //   119: iconst_0
      //   120: aload_0
      //   121: aastore
      //   122: invokestatic 87	com/tencent/matrix/d/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   125: goto -18 -> 107
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	128	0	paramPendingIntent	PendingIntent
      //   59	2	1	bool	boolean
      //   28	6	2	localMethod	Method
      // Exception table:
      //   from	to	target	type
      //   12	38	66	java/lang/NoSuchMethodException
      //   38	60	91	java/lang/IllegalAccessException
      //   84	89	91	java/lang/IllegalAccessException
      //   38	60	109	java/lang/reflect/InvocationTargetException
      //   84	89	109	java/lang/reflect/InvocationTargetException
    }
  }
  
  private final class f
  {
    final String bmW = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), com.tencent.matrix.a.c.a.getProcessName() });
    
    f()
    {
      b.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", new Object[] { this.bmW });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */