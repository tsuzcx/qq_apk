package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class ae
{
  public static final String geR;
  private static long geS;
  private static long lastUpdateTime;
  
  static
  {
    AppMethodBeat.i(58692);
    geR = e.eQx + "/tencent/noop.dat";
    lastUpdateTime = 0L;
    Object localObject = ah.getContext().getSharedPreferences("noop_prefs", 0);
    int i = ((SharedPreferences)localObject).getInt("noop_strategy", 1);
    if (1 == i)
    {
      geS = 270L;
      new StringBuilder("getNoopIntervalInMs use hard code noop:").append(geS);
      l = geS * 1000L;
    }
    for (;;)
    {
      geS = l / 1000L;
      AppMethodBeat.o(58692);
      return;
      if (3 != i) {
        break;
      }
      l = ((SharedPreferences)localObject).getLong("noop_min_interval", 270L);
      if ((l >= 180L) && (l <= 3600L))
      {
        geS = l;
        l *= 1000L;
      }
      else
      {
        geS = 270L;
        new StringBuilder("getNoopIntervalInMs use wx noop:").append(geS);
        l = geS * 1000L;
      }
    }
    long l = System.currentTimeMillis() / 1000L;
    if (l - lastUpdateTime > 3600L)
    {
      localObject = anK();
      if ((localObject[0] < 180L) || (localObject[0] > 3600L)) {
        break label262;
      }
    }
    label262:
    for (geS = localObject[0];; geS = 270L)
    {
      lastUpdateTime = l;
      new StringBuilder("getNoopIntervalInMs use sync noop:").append(geS);
      l = geS * 1000L;
      break;
    }
  }
  
  /* Error */
  public static void A(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 113
    //   11: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: lload_0
    //   15: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: ldc 115
    //   20: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_2
    //   24: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: lload_2
    //   29: lconst_0
    //   30: lcmp
    //   31: ifgt +130 -> 161
    //   34: lload_0
    //   35: lconst_0
    //   36: lcmp
    //   37: ifgt +37 -> 74
    //   40: invokestatic 48	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   43: ldc 50
    //   45: iconst_0
    //   46: invokevirtual 56	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   49: invokeinterface 119 1 0
    //   54: ldc 58
    //   56: iconst_1
    //   57: invokeinterface 125 3 0
    //   62: invokeinterface 129 1 0
    //   67: pop
    //   68: ldc 111
    //   70: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    //   74: lload_0
    //   75: ldc2_w 88
    //   78: lcmp
    //   79: iflt +53 -> 132
    //   82: lload_0
    //   83: ldc2_w 90
    //   86: lcmp
    //   87: ifgt +45 -> 132
    //   90: invokestatic 48	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   93: ldc 50
    //   95: iconst_0
    //   96: invokevirtual 56	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   99: invokeinterface 119 1 0
    //   104: ldc 58
    //   106: iconst_3
    //   107: invokeinterface 125 3 0
    //   112: ldc 83
    //   114: lload_0
    //   115: invokeinterface 133 4 0
    //   120: invokeinterface 129 1 0
    //   125: pop
    //   126: ldc 111
    //   128: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: new 20	java/lang/StringBuilder
    //   135: dup
    //   136: ldc 135
    //   138: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: lload_0
    //   142: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: ldc 137
    //   147: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: lload_2
    //   151: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 111
    //   157: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: invokestatic 48	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   164: ldc 50
    //   166: iconst_0
    //   167: invokevirtual 56	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   170: invokeinterface 119 1 0
    //   175: ldc 58
    //   177: iconst_2
    //   178: invokeinterface 125 3 0
    //   183: invokeinterface 129 1 0
    //   188: pop
    //   189: lload_0
    //   190: ldc2_w 88
    //   193: lcmp
    //   194: iflt +11 -> 205
    //   197: lload_0
    //   198: ldc2_w 90
    //   201: lcmp
    //   202: ifle +9 -> 211
    //   205: ldc 111
    //   207: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: return
    //   211: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   214: ldc2_w 77
    //   217: ldiv
    //   218: lload_2
    //   219: lcmp
    //   220: ifge +9 -> 229
    //   223: ldc 111
    //   225: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: new 139	java/io/File
    //   232: dup
    //   233: getstatic 40	com/tencent/mm/network/ae:geR	Ljava/lang/String;
    //   236: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore 8
    //   241: aload 8
    //   243: invokevirtual 143	java/io/File:exists	()Z
    //   246: ifeq +36 -> 282
    //   249: invokestatic 103	com/tencent/mm/network/ae:anK	()[J
    //   252: astore 8
    //   254: aload 8
    //   256: iconst_1
    //   257: laload
    //   258: lconst_0
    //   259: lcmp
    //   260: ifle +40 -> 300
    //   263: aload 8
    //   265: iconst_1
    //   266: laload
    //   267: lstore 5
    //   269: lload 5
    //   271: lload_2
    //   272: lcmp
    //   273: iflt +27 -> 300
    //   276: ldc 111
    //   278: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: aload 8
    //   284: invokevirtual 146	java/io/File:createNewFile	()Z
    //   287: istore 7
    //   289: iload 7
    //   291: ifne +9 -> 300
    //   294: ldc 111
    //   296: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: return
    //   300: aconst_null
    //   301: astore 9
    //   303: aconst_null
    //   304: astore 10
    //   306: aload 9
    //   308: astore 8
    //   310: new 139	java/io/File
    //   313: dup
    //   314: getstatic 40	com/tencent/mm/network/ae:geR	Ljava/lang/String;
    //   317: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: astore 11
    //   322: aload 9
    //   324: astore 8
    //   326: aload 11
    //   328: invokevirtual 143	java/io/File:exists	()Z
    //   331: ifne +51 -> 382
    //   334: aload 9
    //   336: astore 8
    //   338: aload 11
    //   340: invokevirtual 146	java/io/File:createNewFile	()Z
    //   343: istore 7
    //   345: iload 7
    //   347: ifne +35 -> 382
    //   350: ldc 111
    //   352: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: return
    //   356: astore 8
    //   358: new 20	java/lang/StringBuilder
    //   361: dup
    //   362: ldc 148
    //   364: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   367: aload 8
    //   369: invokevirtual 152	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   372: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 111
    //   378: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: return
    //   382: aload 9
    //   384: astore 8
    //   386: new 157	java/io/DataOutputStream
    //   389: dup
    //   390: new 159	java/io/FileOutputStream
    //   393: dup
    //   394: aload 11
    //   396: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   399: invokespecial 165	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   402: astore 9
    //   404: lload_0
    //   405: l2i
    //   406: istore 4
    //   408: aload 9
    //   410: iload 4
    //   412: invokevirtual 168	java/io/DataOutputStream:writeInt	(I)V
    //   415: aload 9
    //   417: lload_2
    //   418: l2i
    //   419: invokevirtual 168	java/io/DataOutputStream:writeInt	(I)V
    //   422: aload 9
    //   424: invokevirtual 171	java/io/DataOutputStream:flush	()V
    //   427: aload 9
    //   429: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   432: aload 9
    //   434: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   437: ldc 111
    //   439: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: return
    //   443: astore 8
    //   445: ldc 111
    //   447: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   450: return
    //   451: astore 8
    //   453: aload 10
    //   455: astore 9
    //   457: aload 8
    //   459: astore 10
    //   461: aload 9
    //   463: astore 8
    //   465: new 20	java/lang/StringBuilder
    //   468: dup
    //   469: ldc 176
    //   471: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: aload 10
    //   476: invokevirtual 152	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   479: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 9
    //   485: ifnull +8 -> 493
    //   488: aload 9
    //   490: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   493: ldc 111
    //   495: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: return
    //   499: astore 8
    //   501: ldc 111
    //   503: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: return
    //   507: astore 10
    //   509: aload 8
    //   511: astore 9
    //   513: aload 10
    //   515: astore 8
    //   517: aload 9
    //   519: ifnull +8 -> 527
    //   522: aload 9
    //   524: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   527: ldc 111
    //   529: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: aload 8
    //   534: athrow
    //   535: astore 9
    //   537: goto -10 -> 527
    //   540: astore 8
    //   542: goto -25 -> 517
    //   545: astore 10
    //   547: goto -86 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramLong1	long
    //   0	550	2	paramLong2	long
    //   406	5	4	i	int
    //   267	3	5	l	long
    //   287	59	7	bool	boolean
    //   239	98	8	localObject1	Object
    //   356	12	8	localException1	java.lang.Exception
    //   384	1	8	localObject2	Object
    //   443	1	8	localException2	java.lang.Exception
    //   451	7	8	localException3	java.lang.Exception
    //   463	1	8	localObject3	Object
    //   499	11	8	localException4	java.lang.Exception
    //   515	18	8	localObject4	Object
    //   540	1	8	localObject5	Object
    //   301	222	9	localObject6	Object
    //   535	1	9	localException5	java.lang.Exception
    //   304	171	10	localException6	java.lang.Exception
    //   507	7	10	localObject7	Object
    //   545	1	10	localException7	java.lang.Exception
    //   320	75	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   229	254	356	java/lang/Exception
    //   282	289	356	java/lang/Exception
    //   350	355	356	java/lang/Exception
    //   437	442	356	java/lang/Exception
    //   445	450	356	java/lang/Exception
    //   493	498	356	java/lang/Exception
    //   501	506	356	java/lang/Exception
    //   527	535	356	java/lang/Exception
    //   432	437	443	java/lang/Exception
    //   310	322	451	java/lang/Exception
    //   326	334	451	java/lang/Exception
    //   338	345	451	java/lang/Exception
    //   386	404	451	java/lang/Exception
    //   488	493	499	java/lang/Exception
    //   310	322	507	finally
    //   326	334	507	finally
    //   338	345	507	finally
    //   386	404	507	finally
    //   465	483	507	finally
    //   522	527	535	java/lang/Exception
    //   408	432	540	finally
    //   408	432	545	java/lang/Exception
  }
  
  /* Error */
  private static long[] anK()
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: newarray long
    //   8: astore 6
    //   10: aload 6
    //   12: dup
    //   13: iconst_0
    //   14: lconst_0
    //   15: lastore
    //   16: dup
    //   17: iconst_1
    //   18: lconst_0
    //   19: lastore
    //   20: pop
    //   21: new 139	java/io/File
    //   24: dup
    //   25: getstatic 40	com/tencent/mm/network/ae:geR	Ljava/lang/String;
    //   28: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 143	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: ldc 177
    //   41: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload 6
    //   46: areturn
    //   47: new 179	java/io/DataInputStream
    //   50: dup
    //   51: new 181	java/io/FileInputStream
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 185	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore 4
    //   64: aload 4
    //   66: astore_3
    //   67: aload 4
    //   69: invokevirtual 189	java/io/DataInputStream:readInt	()I
    //   72: istore_0
    //   73: iload_0
    //   74: i2l
    //   75: ldc2_w 88
    //   78: lcmp
    //   79: iflt +12 -> 91
    //   82: iload_0
    //   83: i2l
    //   84: ldc2_w 90
    //   87: lcmp
    //   88: ifle +24 -> 112
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: invokevirtual 190	java/io/DataInputStream:close	()V
    //   99: aload 4
    //   101: invokevirtual 190	java/io/DataInputStream:close	()V
    //   104: ldc 177
    //   106: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload 6
    //   111: areturn
    //   112: iload_0
    //   113: i2l
    //   114: lstore_1
    //   115: aload 6
    //   117: iconst_0
    //   118: lload_1
    //   119: lastore
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokevirtual 189	java/io/DataInputStream:readInt	()I
    //   128: istore_0
    //   129: aload 4
    //   131: astore_3
    //   132: iload_0
    //   133: i2l
    //   134: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   137: ldc2_w 77
    //   140: ldiv
    //   141: lcmp
    //   142: ifle +24 -> 166
    //   145: aload 4
    //   147: astore_3
    //   148: aload 4
    //   150: invokevirtual 190	java/io/DataInputStream:close	()V
    //   153: aload 4
    //   155: invokevirtual 190	java/io/DataInputStream:close	()V
    //   158: ldc 177
    //   160: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 6
    //   165: areturn
    //   166: iload_0
    //   167: i2l
    //   168: lstore_1
    //   169: aload 6
    //   171: iconst_1
    //   172: lload_1
    //   173: lastore
    //   174: aload 4
    //   176: astore_3
    //   177: aload 4
    //   179: invokevirtual 190	java/io/DataInputStream:close	()V
    //   182: aload 4
    //   184: invokevirtual 190	java/io/DataInputStream:close	()V
    //   187: ldc 177
    //   189: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload 6
    //   194: areturn
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 4
    //   202: astore_3
    //   203: new 20	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 192
    //   209: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload 5
    //   214: invokevirtual 152	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   217: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 190	java/io/DataInputStream:close	()V
    //   231: ldc 177
    //   233: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload 6
    //   238: areturn
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 190	java/io/DataInputStream:close	()V
    //   251: ldc 177
    //   253: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload 4
    //   258: athrow
    //   259: astore_3
    //   260: goto -156 -> 104
    //   263: astore_3
    //   264: goto -106 -> 158
    //   267: astore_3
    //   268: goto -81 -> 187
    //   271: astore_3
    //   272: goto -41 -> 231
    //   275: astore_3
    //   276: goto -25 -> 251
    //   279: astore 4
    //   281: goto -38 -> 243
    //   284: astore 5
    //   286: goto -86 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	95	0	i	int
    //   114	59	1	l	long
    //   31	217	3	localObject1	Object
    //   259	1	3	localException1	java.lang.Exception
    //   263	1	3	localException2	java.lang.Exception
    //   267	1	3	localException3	java.lang.Exception
    //   271	1	3	localException4	java.lang.Exception
    //   275	1	3	localException5	java.lang.Exception
    //   62	165	4	localDataInputStream	java.io.DataInputStream
    //   239	18	4	localObject2	Object
    //   279	1	4	localObject3	Object
    //   195	18	5	localException6	java.lang.Exception
    //   284	1	5	localException7	java.lang.Exception
    //   8	229	6	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   47	64	195	java/lang/Exception
    //   47	64	239	finally
    //   99	104	259	java/lang/Exception
    //   153	158	263	java/lang/Exception
    //   182	187	267	java/lang/Exception
    //   226	231	271	java/lang/Exception
    //   247	251	275	java/lang/Exception
    //   67	73	279	finally
    //   94	99	279	finally
    //   123	129	279	finally
    //   132	145	279	finally
    //   148	153	279	finally
    //   177	182	279	finally
    //   203	221	279	finally
    //   67	73	284	java/lang/Exception
    //   94	99	284	java/lang/Exception
    //   123	129	284	java/lang/Exception
    //   132	145	284	java/lang/Exception
    //   148	153	284	java/lang/Exception
    //   177	182	284	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */