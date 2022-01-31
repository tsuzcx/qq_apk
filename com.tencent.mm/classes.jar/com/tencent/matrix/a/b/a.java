package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.g.d;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a
  extends com.tencent.matrix.e.c
{
  private final int bMd;
  private final int bMe;
  private final f bMf;
  final b bMg;
  List<a> bMh;
  private long bMi;
  
  /* Error */
  public a(com.tencent.matrix.e.c.a parama, com.tencent.matrix.a.a.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 45	com/tencent/matrix/e/c:<init>	(Lcom/tencent/matrix/e/c$a;)V
    //   5: aload_0
    //   6: aload_2
    //   7: getfield 51	com/tencent/matrix/a/a/a:bMc	Lcom/tencent/mrs/b/a;
    //   10: getstatic 57	com/tencent/mrs/b/a$a:BaO	Lcom/tencent/mrs/b/a$a;
    //   13: invokevirtual 61	com/tencent/mrs/b/a$a:name	()Ljava/lang/String;
    //   16: bipush 20
    //   18: invokeinterface 67 3 0
    //   23: putfield 69	com/tencent/matrix/a/b/a:bMd	I
    //   26: aload_0
    //   27: aload_2
    //   28: getfield 51	com/tencent/matrix/a/a/a:bMc	Lcom/tencent/mrs/b/a;
    //   31: getstatic 72	com/tencent/mrs/b/a$a:BaP	Lcom/tencent/mrs/b/a$a;
    //   34: invokevirtual 61	com/tencent/mrs/b/a$a:name	()Ljava/lang/String;
    //   37: bipush 12
    //   39: invokeinterface 67 3 0
    //   44: putfield 74	com/tencent/matrix/a/b/a:bMe	I
    //   47: aload_0
    //   48: new 21	com/tencent/matrix/a/b/a$f
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 77	com/tencent/matrix/a/b/a$f:<init>	(Lcom/tencent/matrix/a/b/a;)V
    //   56: putfield 79	com/tencent/matrix/a/b/a:bMf	Lcom/tencent/matrix/a/b/a$f;
    //   59: aload_0
    //   60: getfield 79	com/tencent/matrix/a/b/a:bMf	Lcom/tencent/matrix/a/b/a$f;
    //   63: astore 5
    //   65: new 81	java/io/File
    //   68: dup
    //   69: aload 5
    //   71: getfield 85	com/tencent/matrix/a/b/a$f:bMw	Ljava/lang/String;
    //   74: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 92	java/io/File:exists	()Z
    //   82: ifne +48 -> 130
    //   85: aload 5
    //   87: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   90: new 98	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 101	java/util/ArrayList:<init>	()V
    //   97: putfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   100: aload 5
    //   102: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   105: ldc2_w 104
    //   108: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   111: aload_2
    //   112: invokevirtual 110	com/tencent/matrix/a/a/a:yH	()Z
    //   115: ifeq +379 -> 494
    //   118: aload_0
    //   119: new 9	com/tencent/matrix/a/b/a$b
    //   122: dup
    //   123: invokespecial 111	com/tencent/matrix/a/b/a$b:<init>	()V
    //   126: putfield 113	com/tencent/matrix/a/b/a:bMg	Lcom/tencent/matrix/a/b/a$b;
    //   129: return
    //   130: new 115	java/io/ObjectInputStream
    //   133: dup
    //   134: new 117	java/io/BufferedInputStream
    //   137: dup
    //   138: new 119	java/io/FileInputStream
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: invokespecial 125	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   149: invokespecial 126	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore_3
    //   153: aload_3
    //   154: astore_1
    //   155: aload_3
    //   156: invokevirtual 130	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   159: checkcast 15	com/tencent/matrix/a/b/a$d
    //   162: astore 4
    //   164: aload 4
    //   166: ifnull +33 -> 199
    //   169: aload_3
    //   170: astore_1
    //   171: aload 5
    //   173: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   176: aload 4
    //   178: invokevirtual 134	com/tencent/matrix/a/b/a$d:yK	()Ljava/util/List;
    //   181: putfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   184: aload_3
    //   185: astore_1
    //   186: aload 5
    //   188: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   191: aload 4
    //   193: invokestatic 137	com/tencent/matrix/a/b/a$d:a	(Lcom/tencent/matrix/a/b/a$d;)J
    //   196: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   199: aload_3
    //   200: invokevirtual 140	java/io/ObjectInputStream:close	()V
    //   203: aload 5
    //   205: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   208: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   211: ifnonnull +29 -> 240
    //   214: aload 5
    //   216: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   219: new 98	java/util/ArrayList
    //   222: dup
    //   223: invokespecial 101	java/util/ArrayList:<init>	()V
    //   226: putfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   229: aload 5
    //   231: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   234: ldc2_w 104
    //   237: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   240: ldc 142
    //   242: ldc 144
    //   244: iconst_2
    //   245: anewarray 146	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload 5
    //   252: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   255: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   258: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload 5
    //   266: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   269: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   272: invokeinterface 158 1 0
    //   277: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -173 -> 111
    //   287: astore_1
    //   288: ldc 142
    //   290: ldc 171
    //   292: iconst_1
    //   293: anewarray 146	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_1
    //   299: aastore
    //   300: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: goto -100 -> 203
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: aload_3
    //   311: astore_1
    //   312: ldc 142
    //   314: ldc 176
    //   316: iconst_1
    //   317: anewarray 146	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload 4
    //   324: aastore
    //   325: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: aload_3
    //   329: ifnull -126 -> 203
    //   332: aload_3
    //   333: invokevirtual 140	java/io/ObjectInputStream:close	()V
    //   336: goto -133 -> 203
    //   339: astore_1
    //   340: ldc 142
    //   342: ldc 171
    //   344: iconst_1
    //   345: anewarray 146	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_1
    //   351: aastore
    //   352: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: goto -152 -> 203
    //   358: astore 4
    //   360: aconst_null
    //   361: astore_3
    //   362: aload_3
    //   363: astore_1
    //   364: ldc 142
    //   366: ldc 176
    //   368: iconst_1
    //   369: anewarray 146	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: aload 4
    //   376: aastore
    //   377: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: aload_3
    //   381: ifnull -178 -> 203
    //   384: aload_3
    //   385: invokevirtual 140	java/io/ObjectInputStream:close	()V
    //   388: goto -185 -> 203
    //   391: astore_1
    //   392: ldc 142
    //   394: ldc 171
    //   396: iconst_1
    //   397: anewarray 146	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload_1
    //   403: aastore
    //   404: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: goto -204 -> 203
    //   410: astore 4
    //   412: aconst_null
    //   413: astore_3
    //   414: aload_3
    //   415: astore_1
    //   416: ldc 142
    //   418: ldc 178
    //   420: iconst_1
    //   421: anewarray 146	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload 4
    //   428: aastore
    //   429: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aload_3
    //   433: ifnull -230 -> 203
    //   436: aload_3
    //   437: invokevirtual 140	java/io/ObjectInputStream:close	()V
    //   440: goto -237 -> 203
    //   443: astore_1
    //   444: ldc 142
    //   446: ldc 171
    //   448: iconst_1
    //   449: anewarray 146	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: aload_1
    //   455: aastore
    //   456: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: goto -256 -> 203
    //   462: astore_2
    //   463: aconst_null
    //   464: astore_1
    //   465: aload_1
    //   466: ifnull +7 -> 473
    //   469: aload_1
    //   470: invokevirtual 140	java/io/ObjectInputStream:close	()V
    //   473: aload_2
    //   474: athrow
    //   475: astore_1
    //   476: ldc 142
    //   478: ldc 171
    //   480: iconst_1
    //   481: anewarray 146	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload_1
    //   487: aastore
    //   488: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: goto -18 -> 473
    //   494: aload_0
    //   495: aconst_null
    //   496: putfield 113	com/tencent/matrix/a/b/a:bMg	Lcom/tencent/matrix/a/b/a$b;
    //   499: return
    //   500: astore_2
    //   501: goto -36 -> 465
    //   504: astore 4
    //   506: goto -92 -> 414
    //   509: astore 4
    //   511: goto -149 -> 362
    //   514: astore 4
    //   516: goto -206 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	a
    //   0	519	1	parama	com.tencent.matrix.e.c.a
    //   0	519	2	parama1	com.tencent.matrix.a.a.a
    //   152	285	3	localObjectInputStream	java.io.ObjectInputStream
    //   162	30	4	locald	d
    //   306	17	4	localIOException1	java.io.IOException
    //   358	17	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   410	17	4	localException1	java.lang.Exception
    //   504	1	4	localException2	java.lang.Exception
    //   509	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   514	1	4	localIOException2	java.io.IOException
    //   63	202	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   199	203	287	java/io/IOException
    //   130	153	306	java/io/IOException
    //   332	336	339	java/io/IOException
    //   130	153	358	java/lang/ClassNotFoundException
    //   384	388	391	java/io/IOException
    //   130	153	410	java/lang/Exception
    //   436	440	443	java/io/IOException
    //   130	153	462	finally
    //   469	473	475	java/io/IOException
    //   155	164	500	finally
    //   171	184	500	finally
    //   186	199	500	finally
    //   312	328	500	finally
    //   364	380	500	finally
    //   416	432	500	finally
    //   155	164	504	java/lang/Exception
    //   171	184	504	java/lang/Exception
    //   186	199	504	java/lang/Exception
    //   155	164	509	java/lang/ClassNotFoundException
    //   171	184	509	java/lang/ClassNotFoundException
    //   186	199	509	java/lang/ClassNotFoundException
    //   155	164	514	java/io/IOException
    //   171	184	514	java/io/IOException
    //   186	199	514	java/io/IOException
  }
  
  private static Intent t(byte[] paramArrayOfByte)
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
      com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", "[bytesToIntent] %s", new Object[] { paramArrayOfByte });
    }
    return null;
  }
  
  final void a(AlarmManager.OnAlarmListener paramOnAlarmListener, e parame)
  {
    int j = 0;
    if (j < this.bMh.size())
    {
      a locala = (a)this.bMh.get(j);
      if ((locala.bMm != null) && (locala.bMm.equals(paramOnAlarmListener))) {
        locala.yJ();
      }
      for (;;)
      {
        j += 1;
        break;
        if (locala.bMl != null)
        {
          e locale = locala.bMl;
          int i;
          if ((locale.bMu != null) && (locale.bMu.equals(parame.bMu))) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label197;
            }
            locala.yJ();
            break;
            if (locale.bMp == parame.bMp) {
              i = 1;
            } else if ((locale.bMv != null) && (locale.bMv.filterEquals(parame.bMv))) {
              i = 1;
            } else if ((locale.bMr != null) && (locale.bMr.equals(parame.bMr))) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        label197:
        if ((locala.bMl == null) && (locala.bMm == null)) {
          locala.yJ();
        }
      }
    }
  }
  
  /* Error */
  final void yI()
  {
    // Byte code:
    //   0: invokestatic 281	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: ldc 142
    //   7: ldc_w 283
    //   10: iconst_2
    //   11: anewarray 146	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: lload 11
    //   18: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_0
    //   25: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   28: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: aastore
    //   32: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifgt +9 -> 50
    //   44: aload_0
    //   45: lload 11
    //   47: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   50: lload 11
    //   52: aload_0
    //   53: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   56: lsub
    //   57: ldc2_w 284
    //   60: lcmp
    //   61: iflt +73 -> 134
    //   64: aload_0
    //   65: lload 11
    //   67: ldc2_w 286
    //   70: lsub
    //   71: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   74: aload_0
    //   75: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   78: ldc2_w 288
    //   81: ladd
    //   82: lload 11
    //   84: lcmp
    //   85: ifgt +649 -> 734
    //   88: aload_0
    //   89: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   92: ifnull +15 -> 107
    //   95: aload_0
    //   96: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   99: invokeinterface 292 1 0
    //   104: ifeq +59 -> 163
    //   107: ldc 142
    //   109: ldc_w 294
    //   112: iconst_0
    //   113: anewarray 146	java/lang/Object
    //   116: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   124: ldc2_w 288
    //   127: ladd
    //   128: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   131: goto -57 -> 74
    //   134: lload 11
    //   136: aload_0
    //   137: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   140: lsub
    //   141: ldc2_w 286
    //   144: lcmp
    //   145: iflt -71 -> 74
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   153: ldc2_w 286
    //   156: ladd
    //   157: putfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   160: goto -86 -> 74
    //   163: new 296	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   170: astore 14
    //   172: new 296	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   179: astore 15
    //   181: iconst_0
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   187: ldc2_w 288
    //   190: ladd
    //   191: lstore 9
    //   193: aload_0
    //   194: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   197: invokeinterface 301 1 0
    //   202: astore 13
    //   204: iconst_0
    //   205: istore_1
    //   206: aload 13
    //   208: invokeinterface 306 1 0
    //   213: ifeq +317 -> 530
    //   216: aload 13
    //   218: invokeinterface 309 1 0
    //   223: checkcast 6	com/tencent/matrix/a/b/a$a
    //   226: astore 16
    //   228: aload 16
    //   230: getfield 312	com/tencent/matrix/a/b/a$a:type	I
    //   233: iconst_1
    //   234: if_icmpeq +11 -> 245
    //   237: aload 16
    //   239: getfield 312	com/tencent/matrix/a/b/a$a:type	I
    //   242: ifne +40 -> 282
    //   245: aload 16
    //   247: getfield 315	com/tencent/matrix/a/b/a$a:bMj	J
    //   250: lstore 5
    //   252: lload 5
    //   254: aload_0
    //   255: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   258: lcmp
    //   259: ifge +41 -> 300
    //   262: aload 16
    //   264: getfield 318	com/tencent/matrix/a/b/a$a:bMk	J
    //   267: lconst_0
    //   268: lcmp
    //   269: ifgt +31 -> 300
    //   272: aload 13
    //   274: invokeinterface 321 1 0
    //   279: goto -73 -> 206
    //   282: aload 16
    //   284: getfield 315	com/tencent/matrix/a/b/a$a:bMj	J
    //   287: invokestatic 281	java/lang/System:currentTimeMillis	()J
    //   290: ladd
    //   291: invokestatic 326	android/os/SystemClock:elapsedRealtime	()J
    //   294: lsub
    //   295: lstore 5
    //   297: goto -45 -> 252
    //   300: aload 16
    //   302: getfield 329	com/tencent/matrix/a/b/a$a:bMn	J
    //   305: aload_0
    //   306: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   309: lcmp
    //   310: iflt +14 -> 324
    //   313: aload 16
    //   315: getfield 329	com/tencent/matrix/a/b/a$a:bMn	J
    //   318: lload 5
    //   320: lcmp
    //   321: ifgt +13 -> 334
    //   324: aload 13
    //   326: invokeinterface 321 1 0
    //   331: goto -125 -> 206
    //   334: lload 5
    //   336: lload 9
    //   338: lcmp
    //   339: ifge -133 -> 206
    //   342: aload 16
    //   344: getfield 318	com/tencent/matrix/a/b/a$a:bMk	J
    //   347: lconst_0
    //   348: lcmp
    //   349: ifle +170 -> 519
    //   352: aload 16
    //   354: getfield 329	com/tencent/matrix/a/b/a$a:bMn	J
    //   357: lload 9
    //   359: lcmp
    //   360: ifge +118 -> 478
    //   363: aload 16
    //   365: getfield 329	com/tencent/matrix/a/b/a$a:bMn	J
    //   368: lstore 7
    //   370: aload_0
    //   371: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   374: lload 5
    //   376: lcmp
    //   377: ifgt +108 -> 485
    //   380: lload 7
    //   382: lload 5
    //   384: lsub
    //   385: lconst_1
    //   386: lsub
    //   387: aload 16
    //   389: getfield 318	com/tencent/matrix/a/b/a$a:bMk	J
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
    //   405: aload 14
    //   407: aload 16
    //   409: getfield 332	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   412: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 338
    //   418: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 16
    //   424: getfield 312	com/tencent/matrix/a/b/a$a:type	I
    //   427: ifeq +12 -> 439
    //   430: aload 16
    //   432: getfield 312	com/tencent/matrix/a/b/a$a:type	I
    //   435: iconst_2
    //   436: if_icmpne +89 -> 525
    //   439: iconst_1
    //   440: istore_3
    //   441: iload 4
    //   443: istore_2
    //   444: iload_3
    //   445: ifeq -239 -> 206
    //   448: lload 5
    //   450: iload_1
    //   451: i2l
    //   452: ladd
    //   453: l2i
    //   454: istore_1
    //   455: aload 15
    //   457: aload 16
    //   459: getfield 332	com/tencent/matrix/a/b/a$a:stackTrace	Ljava/lang/String;
    //   462: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc_w 338
    //   468: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: iload 4
    //   474: istore_2
    //   475: goto -269 -> 206
    //   478: lload 9
    //   480: lstore 7
    //   482: goto -112 -> 370
    //   485: lload 7
    //   487: aload_0
    //   488: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   491: aload_0
    //   492: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   495: lload 5
    //   497: lsub
    //   498: aload 16
    //   500: getfield 318	com/tencent/matrix/a/b/a$a:bMk	J
    //   503: lrem
    //   504: lsub
    //   505: lsub
    //   506: lconst_1
    //   507: lsub
    //   508: aload 16
    //   510: getfield 318	com/tencent/matrix/a/b/a$a:bMk	J
    //   513: ldiv
    //   514: lstore 5
    //   516: goto -119 -> 397
    //   519: lconst_1
    //   520: lstore 5
    //   522: goto -125 -> 397
    //   525: iconst_0
    //   526: istore_3
    //   527: goto -86 -> 441
    //   530: iconst_m1
    //   531: istore_3
    //   532: aconst_null
    //   533: astore 13
    //   535: iload_2
    //   536: aload_0
    //   537: getfield 69	com/tencent/matrix/a/b/a:bMd	I
    //   540: if_icmplt +67 -> 607
    //   543: aload 14
    //   545: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore 13
    //   550: iconst_4
    //   551: istore_1
    //   552: iload_1
    //   553: ifle -434 -> 119
    //   556: ldc_w 343
    //   559: iconst_2
    //   560: anewarray 146	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: iload_1
    //   566: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload 13
    //   574: aastore
    //   575: invokestatic 347	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   578: invokestatic 353	com/tencent/matrix/g/d:cE	(Ljava/lang/String;)Ljava/lang/String;
    //   581: astore 14
    //   583: aload_0
    //   584: aload 14
    //   586: invokevirtual 357	com/tencent/matrix/a/b/a:cA	(Ljava/lang/String;)Z
    //   589: ifeq +42 -> 631
    //   592: ldc 142
    //   594: ldc_w 359
    //   597: iconst_0
    //   598: anewarray 146	java/lang/Object
    //   601: invokestatic 362	com/tencent/matrix/g/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   604: goto -485 -> 119
    //   607: iload_1
    //   608: aload_0
    //   609: getfield 74	com/tencent/matrix/a/b/a:bMe	I
    //   612: if_icmplt +409 -> 1021
    //   615: iconst_5
    //   616: istore_3
    //   617: aload 15
    //   619: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: astore 13
    //   624: iload_1
    //   625: istore_2
    //   626: iload_3
    //   627: istore_1
    //   628: goto -76 -> 552
    //   631: new 364	org/json/JSONObject
    //   634: dup
    //   635: invokespecial 365	org/json/JSONObject:<init>	()V
    //   638: astore 15
    //   640: aload 15
    //   642: ldc_w 367
    //   645: aload 13
    //   647: invokevirtual 371	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   650: pop
    //   651: aload 15
    //   653: ldc_w 373
    //   656: iload_2
    //   657: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   660: pop
    //   661: aload 15
    //   663: ldc_w 378
    //   666: ldc_w 380
    //   669: invokevirtual 371	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: new 382	com/tencent/matrix/e/b
    //   676: dup
    //   677: iload_1
    //   678: invokespecial 384	com/tencent/matrix/e/b:<init>	(I)V
    //   681: astore 13
    //   683: aload 13
    //   685: aload 14
    //   687: putfield 387	com/tencent/matrix/e/b:key	Ljava/lang/String;
    //   690: aload 13
    //   692: aload 15
    //   694: putfield 391	com/tencent/matrix/e/b:bOx	Lorg/json/JSONObject;
    //   697: aload_0
    //   698: aload 13
    //   700: invokevirtual 394	com/tencent/matrix/a/b/a:b	(Lcom/tencent/matrix/e/b;)V
    //   703: aload_0
    //   704: aload 14
    //   706: invokevirtual 397	com/tencent/matrix/a/b/a:cz	(Ljava/lang/String;)V
    //   709: goto -590 -> 119
    //   712: astore 13
    //   714: ldc 142
    //   716: ldc_w 399
    //   719: iconst_1
    //   720: anewarray 146	java/lang/Object
    //   723: dup
    //   724: iconst_0
    //   725: aload 13
    //   727: aastore
    //   728: invokestatic 226	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: goto -58 -> 673
    //   734: aload_0
    //   735: getfield 79	com/tencent/matrix/a/b/a:bMf	Lcom/tencent/matrix/a/b/a$f;
    //   738: astore 15
    //   740: new 81	java/io/File
    //   743: dup
    //   744: aload 15
    //   746: getfield 85	com/tencent/matrix/a/b/a$f:bMw	Ljava/lang/String;
    //   749: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   752: astore 13
    //   754: aload 13
    //   756: invokevirtual 403	java/io/File:getParentFile	()Ljava/io/File;
    //   759: invokevirtual 92	java/io/File:exists	()Z
    //   762: ifne +12 -> 774
    //   765: aload 13
    //   767: invokevirtual 403	java/io/File:getParentFile	()Ljava/io/File;
    //   770: invokevirtual 406	java/io/File:mkdirs	()Z
    //   773: pop
    //   774: new 408	java/io/ObjectOutputStream
    //   777: dup
    //   778: new 410	java/io/BufferedOutputStream
    //   781: dup
    //   782: new 412	java/io/FileOutputStream
    //   785: dup
    //   786: aload 13
    //   788: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   791: invokespecial 416	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   794: invokespecial 417	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   797: astore 14
    //   799: aload 14
    //   801: astore 13
    //   803: aload 14
    //   805: new 15	com/tencent/matrix/a/b/a$d
    //   808: dup
    //   809: aload 15
    //   811: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   814: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   817: aload 15
    //   819: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   822: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   825: invokespecial 420	com/tencent/matrix/a/b/a$d:<init>	(Ljava/util/List;J)V
    //   828: invokevirtual 424	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   831: aload 14
    //   833: astore 13
    //   835: aload 14
    //   837: invokevirtual 427	java/io/ObjectOutputStream:flush	()V
    //   840: aload 14
    //   842: astore 13
    //   844: ldc 142
    //   846: ldc_w 429
    //   849: iconst_2
    //   850: anewarray 146	java/lang/Object
    //   853: dup
    //   854: iconst_0
    //   855: aload 15
    //   857: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   860: getfield 107	com/tencent/matrix/a/b/a:bMi	J
    //   863: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   866: aastore
    //   867: dup
    //   868: iconst_1
    //   869: aload 15
    //   871: getfield 96	com/tencent/matrix/a/b/a$f:bMx	Lcom/tencent/matrix/a/b/a;
    //   874: getfield 103	com/tencent/matrix/a/b/a:bMh	Ljava/util/List;
    //   877: invokeinterface 158 1 0
    //   882: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   885: aastore
    //   886: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   889: aload 14
    //   891: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   894: return
    //   895: astore 13
    //   897: ldc 142
    //   899: ldc_w 432
    //   902: iconst_1
    //   903: anewarray 146	java/lang/Object
    //   906: dup
    //   907: iconst_0
    //   908: aload 13
    //   910: aastore
    //   911: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   914: return
    //   915: astore 15
    //   917: aconst_null
    //   918: astore 14
    //   920: aload 14
    //   922: astore 13
    //   924: ldc 142
    //   926: ldc 171
    //   928: iconst_1
    //   929: anewarray 146	java/lang/Object
    //   932: dup
    //   933: iconst_0
    //   934: aload 15
    //   936: aastore
    //   937: invokestatic 174	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   940: aload 14
    //   942: ifnull -48 -> 894
    //   945: aload 14
    //   947: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   950: return
    //   951: astore 13
    //   953: ldc 142
    //   955: ldc_w 432
    //   958: iconst_1
    //   959: anewarray 146	java/lang/Object
    //   962: dup
    //   963: iconst_0
    //   964: aload 13
    //   966: aastore
    //   967: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: return
    //   971: astore 14
    //   973: aconst_null
    //   974: astore 13
    //   976: aload 13
    //   978: ifnull +8 -> 986
    //   981: aload 13
    //   983: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   986: aload 14
    //   988: athrow
    //   989: astore 13
    //   991: ldc 142
    //   993: ldc_w 432
    //   996: iconst_1
    //   997: anewarray 146	java/lang/Object
    //   1000: dup
    //   1001: iconst_0
    //   1002: aload 13
    //   1004: aastore
    //   1005: invokestatic 169	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1008: goto -22 -> 986
    //   1011: astore 14
    //   1013: goto -37 -> 976
    //   1016: astore 15
    //   1018: goto -98 -> 920
    //   1021: iconst_0
    //   1022: istore_2
    //   1023: iload_3
    //   1024: istore_1
    //   1025: goto -473 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1028	0	this	a
    //   205	820	1	i	int
    //   182	841	2	j	int
    //   440	584	3	k	int
    //   403	70	4	m	int
    //   250	271	5	l1	long
    //   368	118	7	l2	long
    //   191	288	9	l3	long
    //   3	132	11	l4	long
    //   202	497	13	localObject1	Object
    //   712	14	13	localJSONException	org.json.JSONException
    //   752	91	13	localObject2	Object
    //   895	14	13	localIOException1	java.io.IOException
    //   922	1	13	localObject3	Object
    //   951	14	13	localIOException2	java.io.IOException
    //   974	8	13	localObject4	Object
    //   989	14	13	localIOException3	java.io.IOException
    //   170	776	14	localObject5	Object
    //   971	16	14	localObject6	Object
    //   1011	1	14	localObject7	Object
    //   179	691	15	localObject8	Object
    //   915	20	15	localIOException4	java.io.IOException
    //   1016	1	15	localIOException5	java.io.IOException
    //   226	283	16	locala	a
    // Exception table:
    //   from	to	target	type
    //   640	673	712	org/json/JSONException
    //   889	894	895	java/io/IOException
    //   774	799	915	java/io/IOException
    //   945	950	951	java/io/IOException
    //   774	799	971	finally
    //   981	986	989	java/io/IOException
    //   803	831	1011	finally
    //   835	840	1011	finally
    //   844	889	1011	finally
    //   924	940	1011	finally
    //   803	831	1016	java/io/IOException
    //   835	840	1016	java/io/IOException
    //   844	889	1016	java/io/IOException
  }
  
  static final class a
  {
    final long bMj;
    final long bMk;
    final a.e bMl;
    final AlarmManager.OnAlarmListener bMm;
    long bMn;
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
        this.bMj = l1;
        paramLong1 = paramLong2;
        if (paramLong2 > 0L)
        {
          paramLong1 = paramLong2;
          if (paramLong2 < 60000L) {
            paramLong1 = 60000L;
          }
        }
        this.bMk = paramLong1;
        this.bMl = new a.e(paramPendingIntent);
        this.bMm = paramOnAlarmListener;
        this.stackTrace = paramString;
        this.bMn = 9223372036854775807L;
        return;
      }
    }
    
    a(int paramInt, long paramLong1, long paramLong2, a.e parame, String paramString, long paramLong3)
    {
      this.type = paramInt;
      this.bMj = paramLong1;
      this.bMk = paramLong2;
      this.bMl = parame;
      this.bMm = null;
      this.stackTrace = paramString;
      this.bMn = paramLong3;
    }
    
    public final void yJ()
    {
      if (this.bMn != 9223372036854775807L) {
        return;
      }
      this.bMn = System.currentTimeMillis();
    }
  }
  
  static final class b
  {
    private final String bMo;
    
    b()
    {
      String str = d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
      this.bMo = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), str });
      com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", new Object[] { this.bMo });
    }
    
    /* Error */
    final void cx(String paramString)
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
      //   15: getfield 54	com/tencent/matrix/a/b/a$b:bMo	Ljava/lang/String;
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
    final long bMj;
    final long bMk;
    long bMn;
    final int bMp;
    final byte[] bMq;
    final String bMr;
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
      this.bMj = parama.bMj;
      this.bMk = parama.bMk;
      this.bMp = parama.bMl.bMp;
      this.bMq = a.k(parama.bMl.bMv);
      this.bMr = parama.bMl.bMr;
      this.stackTrace = parama.stackTrace;
      this.bMn = parama.bMn;
    }
  }
  
  static final class d
    implements Serializable
  {
    private final List<a.c> bMh = new ArrayList();
    private final long bMi;
    
    d(List<a.a> paramList, long paramLong)
    {
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          this.bMh.add(new a.c((a.a)paramList.get(i)));
          i += 1;
        }
      }
      this.bMi = paramLong;
    }
    
    public final List<a.a> yK()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < this.bMh.size())
      {
        a.c localc = (a.c)this.bMh.get(i);
        Object localObject = a.u(localc.bMq);
        if (localObject == null) {
          com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", "bytesToIntent is null,  alarmInfoSet maybe invalid object", new Object[0]);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = new a.e(localc.bMp, (Intent)localObject, localc.bMr);
          localArrayList.add(new a.a(localc.type, localc.bMj, localc.bMk, (a.e)localObject, localc.stackTrace, localc.bMn));
        }
      }
      return localArrayList;
    }
  }
  
  static final class e
  {
    private static Method bMs;
    private static Method bMt;
    final int bMp;
    final String bMr;
    final PendingIntent bMu;
    final Intent bMv;
    
    e(int paramInt, Intent paramIntent, String paramString)
    {
      this.bMu = null;
      this.bMp = paramInt;
      this.bMv = paramIntent;
      this.bMr = paramString;
    }
    
    e(PendingIntent paramPendingIntent)
    {
      this.bMu = paramPendingIntent;
      if (this.bMu != null)
      {
        this.bMp = paramPendingIntent.hashCode();
        this.bMv = c(paramPendingIntent);
        this.bMr = d(paramPendingIntent);
        return;
      }
      this.bMp = -1;
      this.bMv = null;
      this.bMr = null;
    }
    
    /* Error */
    private static Intent c(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 57	com/tencent/matrix/a/b/a$e:bMs	Ljava/lang/reflect/Method;
      //   9: ifnonnull +24 -> 33
      //   12: ldc 35
      //   14: ldc 59
      //   16: iconst_0
      //   17: anewarray 61	java/lang/Class
      //   20: invokevirtual 65	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   23: astore_2
      //   24: aload_2
      //   25: putstatic 57	com/tencent/matrix/a/b/a$e:bMs	Ljava/lang/reflect/Method;
      //   28: aload_2
      //   29: iconst_1
      //   30: invokevirtual 71	java/lang/reflect/Method:setAccessible	(Z)V
      //   33: getstatic 57	com/tencent/matrix/a/b/a$e:bMs	Ljava/lang/reflect/Method;
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
      //   69: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   94: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: aconst_null
      //   98: areturn
      //   99: astore_0
      //   100: ldc 79
      //   102: ldc 81
      //   104: iconst_1
      //   105: anewarray 4	java/lang/Object
      //   108: dup
      //   109: iconst_0
      //   110: aload_0
      //   111: aastore
      //   112: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    private static String d(PendingIntent paramPendingIntent)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: getstatic 89	com/tencent/matrix/a/b/a$e:bMt	Ljava/lang/reflect/Method;
      //   9: ifnonnull +29 -> 38
      //   12: ldc 35
      //   14: ldc 91
      //   16: iconst_1
      //   17: anewarray 61	java/lang/Class
      //   20: dup
      //   21: iconst_0
      //   22: ldc 93
      //   24: aastore
      //   25: invokevirtual 65	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   28: astore_2
      //   29: aload_2
      //   30: putstatic 89	com/tencent/matrix/a/b/a$e:bMt	Ljava/lang/reflect/Method;
      //   33: aload_2
      //   34: iconst_1
      //   35: invokevirtual 71	java/lang/reflect/Method:setAccessible	(Z)V
      //   38: getstatic 89	com/tencent/matrix/a/b/a$e:bMt	Ljava/lang/reflect/Method;
      //   41: aload_0
      //   42: iconst_1
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: ldc 95
      //   50: aastore
      //   51: invokevirtual 75	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   54: astore_0
      //   55: aload_0
      //   56: instanceof 93
      //   59: istore_1
      //   60: iload_1
      //   61: ifne +23 -> 84
      //   64: aconst_null
      //   65: areturn
      //   66: astore_0
      //   67: ldc 79
      //   69: ldc 97
      //   71: iconst_1
      //   72: anewarray 4	java/lang/Object
      //   75: dup
      //   76: iconst_0
      //   77: aload_0
      //   78: aastore
      //   79: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   82: aconst_null
      //   83: areturn
      //   84: aload_0
      //   85: checkcast 93	java/lang/String
      //   88: astore_0
      //   89: aload_0
      //   90: areturn
      //   91: astore_0
      //   92: ldc 79
      //   94: ldc 97
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_0
      //   103: aastore
      //   104: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: aconst_null
      //   108: areturn
      //   109: astore_0
      //   110: ldc 79
      //   112: ldc 97
      //   114: iconst_1
      //   115: anewarray 4	java/lang/Object
      //   118: dup
      //   119: iconst_0
      //   120: aload_0
      //   121: aastore
      //   122: invokestatic 87	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    final String bMw = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[] { Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), com.tencent.matrix.a.c.a.getProcessName() });
    
    f()
    {
      com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", new Object[] { this.bMw });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */