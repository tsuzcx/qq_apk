package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
  extends com.tencent.matrix.report.d
{
  private final int cqG;
  private final int cqH;
  private final f cqI;
  final b cqJ;
  List<a> cqK;
  private long cqL;
  public boolean cqM;
  
  /* Error */
  public a(com.tencent.matrix.report.d.a parama, com.tencent.matrix.a.a.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 47	com/tencent/matrix/report/d:<init>	(Lcom/tencent/matrix/report/d$a;)V
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 49	com/tencent/matrix/a/b/a:cqM	Z
    //   10: aload_0
    //   11: aload_2
    //   12: getfield 55	com/tencent/matrix/a/a/a:cqF	Lcom/tencent/c/a/a;
    //   15: getstatic 61	com/tencent/c/a/a$a:JJh	Lcom/tencent/c/a/a$a;
    //   18: invokevirtual 65	com/tencent/c/a/a$a:name	()Ljava/lang/String;
    //   21: bipush 20
    //   23: invokeinterface 71 3 0
    //   28: putfield 73	com/tencent/matrix/a/b/a:cqG	I
    //   31: aload_0
    //   32: aload_2
    //   33: getfield 55	com/tencent/matrix/a/a/a:cqF	Lcom/tencent/c/a/a;
    //   36: getstatic 76	com/tencent/c/a/a$a:JJi	Lcom/tencent/c/a/a$a;
    //   39: invokevirtual 65	com/tencent/c/a/a$a:name	()Ljava/lang/String;
    //   42: bipush 20
    //   44: invokeinterface 71 3 0
    //   49: putfield 78	com/tencent/matrix/a/b/a:cqH	I
    //   52: aload_0
    //   53: new 21	com/tencent/matrix/a/b/a$f
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 81	com/tencent/matrix/a/b/a$f:<init>	(Lcom/tencent/matrix/a/b/a;)V
    //   61: putfield 83	com/tencent/matrix/a/b/a:cqI	Lcom/tencent/matrix/a/b/a$f;
    //   64: aload_0
    //   65: getfield 83	com/tencent/matrix/a/b/a:cqI	Lcom/tencent/matrix/a/b/a$f;
    //   68: astore 5
    //   70: new 85	java/io/File
    //   73: dup
    //   74: aload 5
    //   76: getfield 89	com/tencent/matrix/a/b/a$f:cra	Ljava/lang/String;
    //   79: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 96	java/io/File:exists	()Z
    //   87: ifne +48 -> 135
    //   90: aload 5
    //   92: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   95: new 102	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 105	java/util/ArrayList:<init>	()V
    //   102: putfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   105: aload 5
    //   107: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   110: ldc2_w 108
    //   113: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   116: aload_2
    //   117: invokevirtual 114	com/tencent/matrix/a/a/a:GA	()Z
    //   120: ifeq +379 -> 499
    //   123: aload_0
    //   124: new 9	com/tencent/matrix/a/b/a$b
    //   127: dup
    //   128: invokespecial 115	com/tencent/matrix/a/b/a$b:<init>	()V
    //   131: putfield 117	com/tencent/matrix/a/b/a:cqJ	Lcom/tencent/matrix/a/b/a$b;
    //   134: return
    //   135: new 119	java/io/ObjectInputStream
    //   138: dup
    //   139: new 121	java/io/BufferedInputStream
    //   142: dup
    //   143: new 123	java/io/FileInputStream
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 129	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   154: invokespecial 130	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   157: astore_3
    //   158: aload_3
    //   159: astore_1
    //   160: aload_3
    //   161: invokevirtual 134	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   164: checkcast 15	com/tencent/matrix/a/b/a$d
    //   167: astore 4
    //   169: aload 4
    //   171: ifnull +33 -> 204
    //   174: aload_3
    //   175: astore_1
    //   176: aload 5
    //   178: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   181: aload 4
    //   183: invokevirtual 138	com/tencent/matrix/a/b/a$d:GD	()Ljava/util/List;
    //   186: putfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   189: aload_3
    //   190: astore_1
    //   191: aload 5
    //   193: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   196: aload 4
    //   198: invokestatic 141	com/tencent/matrix/a/b/a$d:a	(Lcom/tencent/matrix/a/b/a$d;)J
    //   201: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   204: aload_3
    //   205: invokevirtual 144	java/io/ObjectInputStream:close	()V
    //   208: aload 5
    //   210: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   213: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   216: ifnonnull +29 -> 245
    //   219: aload 5
    //   221: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   224: new 102	java/util/ArrayList
    //   227: dup
    //   228: invokespecial 105	java/util/ArrayList:<init>	()V
    //   231: putfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   234: aload 5
    //   236: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   239: ldc2_w 108
    //   242: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   245: ldc 146
    //   247: ldc 148
    //   249: iconst_2
    //   250: anewarray 150	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 5
    //   257: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   260: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   263: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 5
    //   271: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   274: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   277: invokeinterface 162 1 0
    //   282: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: goto -173 -> 116
    //   292: astore_1
    //   293: ldc 146
    //   295: ldc 175
    //   297: iconst_1
    //   298: anewarray 150	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_1
    //   304: aastore
    //   305: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -100 -> 208
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_3
    //   315: aload_3
    //   316: astore_1
    //   317: ldc 146
    //   319: ldc 180
    //   321: iconst_1
    //   322: anewarray 150	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload 4
    //   329: aastore
    //   330: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload_3
    //   334: ifnull -126 -> 208
    //   337: aload_3
    //   338: invokevirtual 144	java/io/ObjectInputStream:close	()V
    //   341: goto -133 -> 208
    //   344: astore_1
    //   345: ldc 146
    //   347: ldc 175
    //   349: iconst_1
    //   350: anewarray 150	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload_1
    //   356: aastore
    //   357: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -152 -> 208
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_3
    //   367: aload_3
    //   368: astore_1
    //   369: ldc 146
    //   371: ldc 180
    //   373: iconst_1
    //   374: anewarray 150	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: aload 4
    //   381: aastore
    //   382: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload_3
    //   386: ifnull -178 -> 208
    //   389: aload_3
    //   390: invokevirtual 144	java/io/ObjectInputStream:close	()V
    //   393: goto -185 -> 208
    //   396: astore_1
    //   397: ldc 146
    //   399: ldc 175
    //   401: iconst_1
    //   402: anewarray 150	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload_1
    //   408: aastore
    //   409: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: goto -204 -> 208
    //   415: astore 4
    //   417: aconst_null
    //   418: astore_3
    //   419: aload_3
    //   420: astore_1
    //   421: ldc 146
    //   423: ldc 182
    //   425: iconst_1
    //   426: anewarray 150	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload 4
    //   433: aastore
    //   434: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: aload_3
    //   438: ifnull -230 -> 208
    //   441: aload_3
    //   442: invokevirtual 144	java/io/ObjectInputStream:close	()V
    //   445: goto -237 -> 208
    //   448: astore_1
    //   449: ldc 146
    //   451: ldc 175
    //   453: iconst_1
    //   454: anewarray 150	java/lang/Object
    //   457: dup
    //   458: iconst_0
    //   459: aload_1
    //   460: aastore
    //   461: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: goto -256 -> 208
    //   467: astore_2
    //   468: aconst_null
    //   469: astore_1
    //   470: aload_1
    //   471: ifnull +7 -> 478
    //   474: aload_1
    //   475: invokevirtual 144	java/io/ObjectInputStream:close	()V
    //   478: aload_2
    //   479: athrow
    //   480: astore_1
    //   481: ldc 146
    //   483: ldc 175
    //   485: iconst_1
    //   486: anewarray 150	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: aload_1
    //   492: aastore
    //   493: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: goto -18 -> 478
    //   499: aload_0
    //   500: aconst_null
    //   501: putfield 117	com/tencent/matrix/a/b/a:cqJ	Lcom/tencent/matrix/a/b/a$b;
    //   504: return
    //   505: astore_2
    //   506: goto -36 -> 470
    //   509: astore 4
    //   511: goto -92 -> 419
    //   514: astore 4
    //   516: goto -149 -> 367
    //   519: astore 4
    //   521: goto -206 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	a
    //   0	524	1	parama	com.tencent.matrix.report.d.a
    //   0	524	2	parama1	com.tencent.matrix.a.a.a
    //   157	285	3	localObjectInputStream	java.io.ObjectInputStream
    //   167	30	4	locald	d
    //   311	17	4	localIOException1	java.io.IOException
    //   363	17	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   415	17	4	localException1	java.lang.Exception
    //   509	1	4	localException2	java.lang.Exception
    //   514	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   519	1	4	localIOException2	java.io.IOException
    //   68	202	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   204	208	292	java/io/IOException
    //   135	158	311	java/io/IOException
    //   337	341	344	java/io/IOException
    //   135	158	363	java/lang/ClassNotFoundException
    //   389	393	396	java/io/IOException
    //   135	158	415	java/lang/Exception
    //   441	445	448	java/io/IOException
    //   135	158	467	finally
    //   474	478	480	java/io/IOException
    //   160	169	505	finally
    //   176	189	505	finally
    //   191	204	505	finally
    //   317	333	505	finally
    //   369	385	505	finally
    //   421	437	505	finally
    //   160	169	509	java/lang/Exception
    //   176	189	509	java/lang/Exception
    //   191	204	509	java/lang/Exception
    //   160	169	514	java/lang/ClassNotFoundException
    //   176	189	514	java/lang/ClassNotFoundException
    //   191	204	514	java/lang/ClassNotFoundException
    //   160	169	519	java/io/IOException
    //   176	189	519	java/io/IOException
    //   191	204	519	java/io/IOException
  }
  
  private static String a(Set<String> paramSet, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    if (paramSet.hasNext()) {
      localStringBuilder.append((String)paramSet.next());
    }
    while (paramSet.hasNext()) {
      localStringBuilder.append(paramString).append((String)paramSet.next());
    }
    return localStringBuilder.toString();
  }
  
  private static Intent z(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = (Intent)Intent.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      return paramArrayOfByte;
    }
    catch (IllegalStateException paramArrayOfByte)
    {
      c.e("MicroMsg.AlarmDetector", "[bytesToIntent] %s", new Object[] { paramArrayOfByte });
    }
    return null;
  }
  
  /* Error */
  final void GB()
  {
    // Byte code:
    //   0: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: ldc 146
    //   7: ldc_w 273
    //   10: iconst_2
    //   11: anewarray 150	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: lload 11
    //   18: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_0
    //   25: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   28: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: aastore
    //   32: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifgt +9 -> 50
    //   44: aload_0
    //   45: lload 11
    //   47: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   50: lload 11
    //   52: aload_0
    //   53: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   56: lsub
    //   57: ldc2_w 274
    //   60: lcmp
    //   61: iflt +73 -> 134
    //   64: aload_0
    //   65: lload 11
    //   67: ldc2_w 276
    //   70: lsub
    //   71: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   74: aload_0
    //   75: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   78: ldc2_w 278
    //   81: ladd
    //   82: lload 11
    //   84: lcmp
    //   85: ifgt +688 -> 773
    //   88: aload_0
    //   89: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   92: ifnull +15 -> 107
    //   95: aload_0
    //   96: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   99: invokeinterface 282 1 0
    //   104: ifeq +59 -> 163
    //   107: ldc 146
    //   109: ldc_w 284
    //   112: iconst_0
    //   113: anewarray 150	java/lang/Object
    //   116: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   124: ldc2_w 278
    //   127: ladd
    //   128: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   131: goto -57 -> 74
    //   134: lload 11
    //   136: aload_0
    //   137: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   140: lsub
    //   141: ldc2_w 276
    //   144: lcmp
    //   145: iflt -71 -> 74
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   153: ldc2_w 276
    //   156: ladd
    //   157: putfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   160: goto -86 -> 74
    //   163: new 286	java/util/TreeSet
    //   166: dup
    //   167: invokespecial 287	java/util/TreeSet:<init>	()V
    //   170: astore 13
    //   172: new 286	java/util/TreeSet
    //   175: dup
    //   176: invokespecial 287	java/util/TreeSet:<init>	()V
    //   179: astore 14
    //   181: iconst_0
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   187: ldc2_w 278
    //   190: ladd
    //   191: lstore 9
    //   193: aload_0
    //   194: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   197: invokeinterface 288 1 0
    //   202: astore 15
    //   204: iconst_0
    //   205: istore_1
    //   206: aload 15
    //   208: invokeinterface 203 1 0
    //   213: ifeq +305 -> 518
    //   216: aload 15
    //   218: invokeinterface 206 1 0
    //   223: checkcast 6	com/tencent/matrix/a/b/a$a
    //   226: astore 16
    //   228: aload 16
    //   230: getfield 291	com/tencent/matrix/a/b/a$a:type	I
    //   233: iconst_1
    //   234: if_icmpeq +11 -> 245
    //   237: aload 16
    //   239: getfield 291	com/tencent/matrix/a/b/a$a:type	I
    //   242: ifne +40 -> 282
    //   245: aload 16
    //   247: getfield 294	com/tencent/matrix/a/b/a$a:cqN	J
    //   250: lstore 5
    //   252: lload 5
    //   254: aload_0
    //   255: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   258: lcmp
    //   259: ifge +41 -> 300
    //   262: aload 16
    //   264: getfield 297	com/tencent/matrix/a/b/a$a:cqO	J
    //   267: lconst_0
    //   268: lcmp
    //   269: ifgt +31 -> 300
    //   272: aload 15
    //   274: invokeinterface 300 1 0
    //   279: goto -73 -> 206
    //   282: aload 16
    //   284: getfield 294	com/tencent/matrix/a/b/a$a:cqN	J
    //   287: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   290: ladd
    //   291: invokestatic 305	android/os/SystemClock:elapsedRealtime	()J
    //   294: lsub
    //   295: lstore 5
    //   297: goto -45 -> 252
    //   300: aload 16
    //   302: getfield 308	com/tencent/matrix/a/b/a$a:cqR	J
    //   305: aload_0
    //   306: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   309: lcmp
    //   310: iflt +14 -> 324
    //   313: aload 16
    //   315: getfield 308	com/tencent/matrix/a/b/a$a:cqR	J
    //   318: lload 5
    //   320: lcmp
    //   321: ifgt +13 -> 334
    //   324: aload 15
    //   326: invokeinterface 300 1 0
    //   331: goto -125 -> 206
    //   334: lload 5
    //   336: lload 9
    //   338: lcmp
    //   339: ifge -133 -> 206
    //   342: aload 16
    //   344: getfield 297	com/tencent/matrix/a/b/a$a:cqO	J
    //   347: lconst_0
    //   348: lcmp
    //   349: ifle +158 -> 507
    //   352: aload 16
    //   354: getfield 308	com/tencent/matrix/a/b/a$a:cqR	J
    //   357: lload 9
    //   359: lcmp
    //   360: ifge +106 -> 466
    //   363: aload 16
    //   365: getfield 308	com/tencent/matrix/a/b/a$a:cqR	J
    //   368: lstore 7
    //   370: aload_0
    //   371: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   374: lload 5
    //   376: lcmp
    //   377: ifgt +96 -> 473
    //   380: lload 7
    //   382: lload 5
    //   384: lsub
    //   385: lconst_1
    //   386: lsub
    //   387: aload 16
    //   389: getfield 297	com/tencent/matrix/a/b/a$a:cqO	J
    //   392: ldiv
    //   393: lconst_1
    //   394: ladd
    //   395: lstore 5
    //   397: iload_2
    //   398: i2l
    //   399: lload 5
    //   401: ladd
    //   402: l2i
    //   403: istore 4
    //   405: aload 13
    //   407: aload 16
    //   409: getfield 311	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   412: invokevirtual 315	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   415: pop
    //   416: aload 16
    //   418: getfield 291	com/tencent/matrix/a/b/a$a:type	I
    //   421: ifeq +12 -> 433
    //   424: aload 16
    //   426: getfield 291	com/tencent/matrix/a/b/a$a:type	I
    //   429: iconst_2
    //   430: if_icmpne +83 -> 513
    //   433: iconst_1
    //   434: istore_3
    //   435: iload 4
    //   437: istore_2
    //   438: iload_3
    //   439: ifeq -233 -> 206
    //   442: lload 5
    //   444: iload_1
    //   445: i2l
    //   446: ladd
    //   447: l2i
    //   448: istore_1
    //   449: aload 14
    //   451: aload 16
    //   453: getfield 311	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   456: invokevirtual 315	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   459: pop
    //   460: iload 4
    //   462: istore_2
    //   463: goto -257 -> 206
    //   466: lload 9
    //   468: lstore 7
    //   470: goto -100 -> 370
    //   473: lload 7
    //   475: aload_0
    //   476: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   479: aload_0
    //   480: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   483: lload 5
    //   485: lsub
    //   486: aload 16
    //   488: getfield 297	com/tencent/matrix/a/b/a$a:cqO	J
    //   491: lrem
    //   492: lsub
    //   493: lsub
    //   494: lconst_1
    //   495: lsub
    //   496: aload 16
    //   498: getfield 297	com/tencent/matrix/a/b/a$a:cqO	J
    //   501: ldiv
    //   502: lstore 5
    //   504: goto -107 -> 397
    //   507: lconst_1
    //   508: lstore 5
    //   510: goto -113 -> 397
    //   513: iconst_0
    //   514: istore_3
    //   515: goto -80 -> 435
    //   518: ldc 146
    //   520: ldc_w 317
    //   523: iconst_3
    //   524: anewarray 150	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload_0
    //   530: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   533: invokeinterface 162 1 0
    //   538: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: iload_2
    //   545: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: dup
    //   550: iconst_2
    //   551: iload_1
    //   552: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: aload 13
    //   561: ldc_w 319
    //   564: invokestatic 321	com/tencent/matrix/a/b/a:a	(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/String;
    //   567: astore 13
    //   569: aload 14
    //   571: ldc_w 319
    //   574: invokestatic 321	com/tencent/matrix/a/b/a:a	(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/String;
    //   577: astore 14
    //   579: iconst_m1
    //   580: istore 4
    //   582: iconst_0
    //   583: istore_3
    //   584: iload_2
    //   585: aload_0
    //   586: getfield 73	com/tencent/matrix/a/b/a:cqG	I
    //   589: if_icmplt +60 -> 649
    //   592: iconst_4
    //   593: istore_1
    //   594: iload_1
    //   595: ifle -476 -> 119
    //   598: ldc_w 323
    //   601: iconst_2
    //   602: anewarray 150	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: iload_1
    //   608: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: aastore
    //   612: dup
    //   613: iconst_1
    //   614: aload 13
    //   616: aastore
    //   617: invokestatic 327	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   620: invokestatic 333	com/tencent/matrix/g/d:dg	(Ljava/lang/String;)Ljava/lang/String;
    //   623: astore 14
    //   625: aload_0
    //   626: aload 14
    //   628: invokevirtual 337	com/tencent/matrix/a/b/a:cM	(Ljava/lang/String;)Z
    //   631: ifeq +39 -> 670
    //   634: ldc 146
    //   636: ldc_w 339
    //   639: iconst_0
    //   640: anewarray 150	java/lang/Object
    //   643: invokestatic 342	com/tencent/matrix/g/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: goto -527 -> 119
    //   649: iload_1
    //   650: aload_0
    //   651: getfield 78	com/tencent/matrix/a/b/a:cqH	I
    //   654: if_icmplt +406 -> 1060
    //   657: aload 14
    //   659: astore 13
    //   661: iconst_5
    //   662: istore_3
    //   663: iload_1
    //   664: istore_2
    //   665: iload_3
    //   666: istore_1
    //   667: goto -73 -> 594
    //   670: new 344	org/json/JSONObject
    //   673: dup
    //   674: invokespecial 345	org/json/JSONObject:<init>	()V
    //   677: astore 15
    //   679: aload 15
    //   681: ldc_w 347
    //   684: aload 13
    //   686: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   689: pop
    //   690: aload 15
    //   692: ldc_w 353
    //   695: iload_2
    //   696: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload 15
    //   702: ldc_w 358
    //   705: ldc_w 360
    //   708: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   711: pop
    //   712: new 362	com/tencent/matrix/report/c
    //   715: dup
    //   716: iload_1
    //   717: invokespecial 364	com/tencent/matrix/report/c:<init>	(I)V
    //   720: astore 13
    //   722: aload 13
    //   724: aload 14
    //   726: putfield 367	com/tencent/matrix/report/c:key	Ljava/lang/String;
    //   729: aload 13
    //   731: aload 15
    //   733: putfield 371	com/tencent/matrix/report/c:cue	Lorg/json/JSONObject;
    //   736: aload_0
    //   737: aload 13
    //   739: invokevirtual 374	com/tencent/matrix/a/b/a:b	(Lcom/tencent/matrix/report/c;)V
    //   742: aload_0
    //   743: aload 14
    //   745: invokevirtual 377	com/tencent/matrix/a/b/a:cL	(Ljava/lang/String;)V
    //   748: goto -629 -> 119
    //   751: astore 13
    //   753: ldc 146
    //   755: ldc_w 379
    //   758: iconst_1
    //   759: anewarray 150	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: aload 13
    //   766: aastore
    //   767: invokestatic 262	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: goto -58 -> 712
    //   773: aload_0
    //   774: getfield 83	com/tencent/matrix/a/b/a:cqI	Lcom/tencent/matrix/a/b/a$f;
    //   777: astore 15
    //   779: new 85	java/io/File
    //   782: dup
    //   783: aload 15
    //   785: getfield 89	com/tencent/matrix/a/b/a$f:cra	Ljava/lang/String;
    //   788: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   791: astore 13
    //   793: aload 13
    //   795: invokevirtual 383	java/io/File:getParentFile	()Ljava/io/File;
    //   798: invokevirtual 96	java/io/File:exists	()Z
    //   801: ifne +12 -> 813
    //   804: aload 13
    //   806: invokevirtual 383	java/io/File:getParentFile	()Ljava/io/File;
    //   809: invokevirtual 386	java/io/File:mkdirs	()Z
    //   812: pop
    //   813: new 388	java/io/ObjectOutputStream
    //   816: dup
    //   817: new 390	java/io/BufferedOutputStream
    //   820: dup
    //   821: new 392	java/io/FileOutputStream
    //   824: dup
    //   825: aload 13
    //   827: invokespecial 393	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   830: invokespecial 396	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   833: invokespecial 397	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   836: astore 14
    //   838: aload 14
    //   840: astore 13
    //   842: aload 14
    //   844: new 15	com/tencent/matrix/a/b/a$d
    //   847: dup
    //   848: aload 15
    //   850: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   853: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   856: aload 15
    //   858: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   861: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   864: invokespecial 400	com/tencent/matrix/a/b/a$d:<init>	(Ljava/util/List;J)V
    //   867: invokevirtual 404	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   870: aload 14
    //   872: astore 13
    //   874: aload 14
    //   876: invokevirtual 407	java/io/ObjectOutputStream:flush	()V
    //   879: aload 14
    //   881: astore 13
    //   883: ldc 146
    //   885: ldc_w 409
    //   888: iconst_2
    //   889: anewarray 150	java/lang/Object
    //   892: dup
    //   893: iconst_0
    //   894: aload 15
    //   896: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   899: getfield 111	com/tencent/matrix/a/b/a:cqL	J
    //   902: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   905: aastore
    //   906: dup
    //   907: iconst_1
    //   908: aload 15
    //   910: getfield 100	com/tencent/matrix/a/b/a$f:crb	Lcom/tencent/matrix/a/b/a;
    //   913: getfield 107	com/tencent/matrix/a/b/a:cqK	Ljava/util/List;
    //   916: invokeinterface 162 1 0
    //   921: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   928: aload 14
    //   930: invokevirtual 410	java/io/ObjectOutputStream:close	()V
    //   933: return
    //   934: astore 13
    //   936: ldc 146
    //   938: ldc_w 412
    //   941: iconst_1
    //   942: anewarray 150	java/lang/Object
    //   945: dup
    //   946: iconst_0
    //   947: aload 13
    //   949: aastore
    //   950: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: return
    //   954: astore 15
    //   956: aconst_null
    //   957: astore 14
    //   959: aload 14
    //   961: astore 13
    //   963: ldc 146
    //   965: ldc 175
    //   967: iconst_1
    //   968: anewarray 150	java/lang/Object
    //   971: dup
    //   972: iconst_0
    //   973: aload 15
    //   975: aastore
    //   976: invokestatic 178	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   979: aload 14
    //   981: ifnull -48 -> 933
    //   984: aload 14
    //   986: invokevirtual 410	java/io/ObjectOutputStream:close	()V
    //   989: return
    //   990: astore 13
    //   992: ldc 146
    //   994: ldc_w 412
    //   997: iconst_1
    //   998: anewarray 150	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 13
    //   1005: aastore
    //   1006: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1009: return
    //   1010: astore 14
    //   1012: aconst_null
    //   1013: astore 13
    //   1015: aload 13
    //   1017: ifnull +8 -> 1025
    //   1020: aload 13
    //   1022: invokevirtual 410	java/io/ObjectOutputStream:close	()V
    //   1025: aload 14
    //   1027: athrow
    //   1028: astore 13
    //   1030: ldc 146
    //   1032: ldc_w 412
    //   1035: iconst_1
    //   1036: anewarray 150	java/lang/Object
    //   1039: dup
    //   1040: iconst_0
    //   1041: aload 13
    //   1043: aastore
    //   1044: invokestatic 173	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1047: goto -22 -> 1025
    //   1050: astore 14
    //   1052: goto -37 -> 1015
    //   1055: astore 15
    //   1057: goto -98 -> 959
    //   1060: aconst_null
    //   1061: astore 13
    //   1063: iload 4
    //   1065: istore_1
    //   1066: iload_3
    //   1067: istore_2
    //   1068: goto -474 -> 594
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	this	a
    //   205	861	1	i	int
    //   182	886	2	j	int
    //   434	633	3	k	int
    //   403	661	4	m	int
    //   250	259	5	l1	long
    //   368	106	7	l2	long
    //   191	276	9	l3	long
    //   3	132	11	l4	long
    //   170	568	13	localObject1	Object
    //   751	14	13	localJSONException	org.json.JSONException
    //   791	91	13	localObject2	Object
    //   934	14	13	localIOException1	java.io.IOException
    //   961	1	13	localObject3	Object
    //   990	14	13	localIOException2	java.io.IOException
    //   1013	8	13	localObject4	Object
    //   1028	14	13	localIOException3	java.io.IOException
    //   1061	1	13	localObject5	Object
    //   179	806	14	localObject6	Object
    //   1010	16	14	localObject7	Object
    //   1050	1	14	localObject8	Object
    //   202	707	15	localObject9	Object
    //   954	20	15	localIOException4	java.io.IOException
    //   1055	1	15	localIOException5	java.io.IOException
    //   226	271	16	locala	a
    // Exception table:
    //   from	to	target	type
    //   679	712	751	org/json/JSONException
    //   928	933	934	java/io/IOException
    //   813	838	954	java/io/IOException
    //   984	989	990	java/io/IOException
    //   813	838	1010	finally
    //   1020	1025	1028	java/io/IOException
    //   842	870	1050	finally
    //   874	879	1050	finally
    //   883	928	1050	finally
    //   963	979	1050	finally
    //   842	870	1055	java/io/IOException
    //   874	879	1055	java/io/IOException
    //   883	928	1055	java/io/IOException
  }
  
  final void a(AlarmManager.OnAlarmListener paramOnAlarmListener, e parame)
  {
    int j = 0;
    if (j < this.cqK.size())
    {
      a locala = (a)this.cqK.get(j);
      if ((locala.cqQ != null) && (locala.cqQ.equals(paramOnAlarmListener))) {
        locala.GC();
      }
      for (;;)
      {
        j += 1;
        break;
        if (locala.cqP != null)
        {
          e locale = locala.cqP;
          int i;
          if ((locale.cqY != null) && (locale.cqY.equals(parame.cqY))) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label197;
            }
            locala.GC();
            break;
            if (locale.cqT == parame.cqT) {
              i = 1;
            } else if ((locale.cqZ != null) && (locale.cqZ.filterEquals(parame.cqZ))) {
              i = 1;
            } else if ((locale.cqV != null) && (locale.cqV.equals(parame.cqV))) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        label197:
        if ((locala.cqP == null) && (locala.cqQ == null)) {
          locala.GC();
        }
      }
    }
  }
  
  static final class a
  {
    final long cqN;
    final long cqO;
    final a.e cqP;
    final AlarmManager.OnAlarmListener cqQ;
    long cqR;
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
        this.cqN = l1;
        paramLong1 = paramLong2;
        if (paramLong2 > 0L)
        {
          paramLong1 = paramLong2;
          if (paramLong2 < 60000L) {
            paramLong1 = 60000L;
          }
        }
        this.cqO = paramLong1;
        this.cqP = new a.e(paramPendingIntent);
        this.cqQ = paramOnAlarmListener;
        this.stackTrace = paramString;
        this.cqR = 9223372036854775807L;
        return;
      }
    }
    
    a(int paramInt, long paramLong1, long paramLong2, a.e parame, String paramString, long paramLong3)
    {
      this.type = paramInt;
      this.cqN = paramLong1;
      this.cqO = paramLong2;
      this.cqP = parame;
      this.cqQ = null;
      this.stackTrace = paramString;
      this.cqR = paramLong3;
    }
    
    public final void GC()
    {
      if (this.cqR != 9223372036854775807L) {
        return;
      }
      this.cqR = System.currentTimeMillis();
    }
  }
  
  static final class b
  {
    private final String cqS;
    
    b()
    {
      String str = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
      this.cqS = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.d.a.getPackageName(), str });
      c.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", new Object[] { this.cqS });
    }
    
    /* Error */
    final void cI(String paramString)
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
      //   15: getfield 54	com/tencent/matrix/a/b/a$b:cqS	Ljava/lang/String;
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
      //   59: invokestatic 88	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   132: invokestatic 125	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   167: invokestatic 125	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  static final class c
    implements Serializable
  {
    final long cqN;
    final long cqO;
    long cqR;
    final int cqT;
    final byte[] cqU;
    final String cqV;
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
      this.cqN = parama.cqN;
      this.cqO = parama.cqO;
      this.cqT = parama.cqP.cqT;
      this.cqU = a.k(parama.cqP.cqZ);
      this.cqV = parama.cqP.cqV;
      this.stackTrace = parama.stackTrace;
      this.cqR = parama.cqR;
    }
  }
  
  static final class d
    implements Serializable
  {
    private final List<a.c> cqK = new ArrayList();
    private final long cqL;
    
    d(List<a.a> paramList, long paramLong)
    {
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          this.cqK.add(new a.c((a.a)paramList.get(i)));
          i += 1;
        }
      }
      this.cqL = paramLong;
    }
    
    public final List<a.a> GD()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < this.cqK.size())
      {
        a.c localc = (a.c)this.cqK.get(i);
        Object localObject = a.A(localc.cqU);
        if (localObject == null) {
          c.e("MicroMsg.AlarmDetector", "bytesToIntent is null,  alarmInfoSet maybe invalid object", new Object[0]);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = new a.e(localc.cqT, (Intent)localObject, localc.cqV);
          localArrayList.add(new a.a(localc.type, localc.cqN, localc.cqO, (a.e)localObject, localc.stackTrace, localc.cqR));
        }
      }
      return localArrayList;
    }
  }
  
  static final class e
  {
    private static Method cqW;
    private static Method cqX;
    final int cqT;
    final String cqV;
    final PendingIntent cqY;
    final Intent cqZ;
    
    e(int paramInt, Intent paramIntent, String paramString)
    {
      this.cqY = null;
      this.cqT = paramInt;
      this.cqZ = paramIntent;
      this.cqV = paramString;
    }
    
    e(PendingIntent paramPendingIntent)
    {
      this.cqY = paramPendingIntent;
      if (this.cqY != null)
      {
        this.cqT = paramPendingIntent.hashCode();
        this.cqZ = d(paramPendingIntent);
        this.cqV = e(paramPendingIntent);
        return;
      }
      this.cqT = -1;
      this.cqZ = null;
      this.cqV = null;
    }
    
    /* Error */
    private static Intent d(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 56	com/tencent/matrix/a/b/a$e:cqW	Ljava/lang/reflect/Method;
      //   9: ifnonnull +24 -> 33
      //   12: ldc 35
      //   14: ldc 58
      //   16: iconst_0
      //   17: anewarray 60	java/lang/Class
      //   20: invokevirtual 64	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   23: astore_2
      //   24: aload_2
      //   25: putstatic 56	com/tencent/matrix/a/b/a$e:cqW	Ljava/lang/reflect/Method;
      //   28: aload_2
      //   29: iconst_1
      //   30: invokevirtual 70	java/lang/reflect/Method:setAccessible	(Z)V
      //   33: getstatic 56	com/tencent/matrix/a/b/a$e:cqW	Ljava/lang/reflect/Method;
      //   36: aload_0
      //   37: iconst_0
      //   38: anewarray 4	java/lang/Object
      //   41: invokevirtual 74	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   44: astore_0
      //   45: aload_0
      //   46: instanceof 76
      //   49: istore_1
      //   50: iload_1
      //   51: ifne +23 -> 74
      //   54: aconst_null
      //   55: areturn
      //   56: astore_0
      //   57: ldc 78
      //   59: ldc 80
      //   61: iconst_1
      //   62: anewarray 4	java/lang/Object
      //   65: dup
      //   66: iconst_0
      //   67: aload_0
      //   68: aastore
      //   69: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: aconst_null
      //   73: areturn
      //   74: aload_0
      //   75: checkcast 76	android/content/Intent
      //   78: astore_0
      //   79: aload_0
      //   80: areturn
      //   81: astore_0
      //   82: ldc 78
      //   84: ldc 80
      //   86: iconst_1
      //   87: anewarray 4	java/lang/Object
      //   90: dup
      //   91: iconst_0
      //   92: aload_0
      //   93: aastore
      //   94: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: aconst_null
      //   98: areturn
      //   99: astore_0
      //   100: ldc 78
      //   102: ldc 80
      //   104: iconst_1
      //   105: anewarray 4	java/lang/Object
      //   108: dup
      //   109: iconst_0
      //   110: aload_0
      //   111: aastore
      //   112: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   115: goto -18 -> 97
      //   118: astore_0
      //   119: goto -22 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	122	0	paramPendingIntent	PendingIntent
      //   49	2	1	bool	boolean
      //   23	6	2	localMethod	Method
      // Exception table:
      //   from	to	target	type
      //   12	33	56	java/lang/NoSuchMethodException
      //   33	50	81	java/lang/IllegalAccessException
      //   74	79	81	java/lang/IllegalAccessException
      //   33	50	99	java/lang/SecurityException
      //   74	79	99	java/lang/SecurityException
      //   33	50	118	java/lang/reflect/InvocationTargetException
      //   74	79	118	java/lang/reflect/InvocationTargetException
    }
    
    /* Error */
    private static String e(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 88	com/tencent/matrix/a/b/a$e:cqX	Ljava/lang/reflect/Method;
      //   9: ifnonnull +29 -> 38
      //   12: ldc 35
      //   14: ldc 90
      //   16: iconst_1
      //   17: anewarray 60	java/lang/Class
      //   20: dup
      //   21: iconst_0
      //   22: ldc 92
      //   24: aastore
      //   25: invokevirtual 64	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   28: astore_2
      //   29: aload_2
      //   30: putstatic 88	com/tencent/matrix/a/b/a$e:cqX	Ljava/lang/reflect/Method;
      //   33: aload_2
      //   34: iconst_1
      //   35: invokevirtual 70	java/lang/reflect/Method:setAccessible	(Z)V
      //   38: getstatic 88	com/tencent/matrix/a/b/a$e:cqX	Ljava/lang/reflect/Method;
      //   41: aload_0
      //   42: iconst_1
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: ldc 94
      //   50: aastore
      //   51: invokevirtual 74	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   54: astore_0
      //   55: aload_0
      //   56: instanceof 92
      //   59: istore_1
      //   60: iload_1
      //   61: ifne +23 -> 84
      //   64: aconst_null
      //   65: areturn
      //   66: astore_0
      //   67: ldc 78
      //   69: ldc 96
      //   71: iconst_1
      //   72: anewarray 4	java/lang/Object
      //   75: dup
      //   76: iconst_0
      //   77: aload_0
      //   78: aastore
      //   79: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   82: aconst_null
      //   83: areturn
      //   84: aload_0
      //   85: checkcast 92	java/lang/String
      //   88: astore_0
      //   89: aload_0
      //   90: areturn
      //   91: astore_0
      //   92: ldc 78
      //   94: ldc 96
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_0
      //   103: aastore
      //   104: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: aconst_null
      //   108: areturn
      //   109: astore_0
      //   110: ldc 78
      //   112: ldc 96
      //   114: iconst_1
      //   115: anewarray 4	java/lang/Object
      //   118: dup
      //   119: iconst_0
      //   120: aload_0
      //   121: aastore
      //   122: invokestatic 86	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final class f
  {
    final String cra = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.d.a.getPackageName(), com.tencent.matrix.a.d.a.getProcessName() });
    
    f()
    {
      c.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", new Object[] { this.cra });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */