package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aj;

public final class ah
{
  public static final String hMM;
  private static long hMN;
  private static long lastUpdateTime;
  
  static
  {
    AppMethodBeat.i(132942);
    hMM = b.aib() + "/tencent/noop.dat";
    lastUpdateTime = 0L;
    Object localObject = aj.getContext().getSharedPreferences("noop_prefs", 0);
    int i = ((SharedPreferences)localObject).getInt("noop_strategy", 1);
    if (1 == i)
    {
      hMN = 270L;
      new StringBuilder("getNoopIntervalInMs use hard code noop:").append(hMN);
      l = hMN * 1000L;
    }
    for (;;)
    {
      hMN = l / 1000L;
      AppMethodBeat.o(132942);
      return;
      if (3 != i) {
        break;
      }
      l = ((SharedPreferences)localObject).getLong("noop_min_interval", 270L);
      if ((l >= 180L) && (l <= 3600L))
      {
        hMN = l;
        l *= 1000L;
      }
      else
      {
        hMN = 270L;
        new StringBuilder("getNoopIntervalInMs use wx noop:").append(hMN);
        l = hMN * 1000L;
      }
    }
    long l = System.currentTimeMillis() / 1000L;
    if (l - lastUpdateTime > 3600L)
    {
      localObject = aFs();
      if ((localObject[0] < 180L) || (localObject[0] > 3600L)) {
        break label262;
      }
    }
    label262:
    for (hMN = localObject[0];; hMN = 270L)
    {
      lastUpdateTime = l;
      new StringBuilder("getNoopIntervalInMs use sync noop:").append(hMN);
      l = hMN * 1000L;
      break;
    }
  }
  
  /* Error */
  public static void C(long paramLong1, long paramLong2)
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
    //   20: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   40: invokestatic 48	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
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
    //   90: invokestatic 48	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
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
    //   147: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: lload_2
    //   151: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 111
    //   157: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: invokestatic 48	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
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
    //   229: new 139	com/tencent/mm/vfs/e
    //   232: dup
    //   233: getstatic 40	com/tencent/mm/network/ah:hMM	Ljava/lang/String;
    //   236: invokespecial 140	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   239: astore 8
    //   241: aload 8
    //   243: invokevirtual 143	com/tencent/mm/vfs/e:exists	()Z
    //   246: ifeq +36 -> 282
    //   249: invokestatic 103	com/tencent/mm/network/ah:aFs	()[J
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
    //   284: invokevirtual 146	com/tencent/mm/vfs/e:createNewFile	()Z
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
    //   310: new 139	com/tencent/mm/vfs/e
    //   313: dup
    //   314: getstatic 40	com/tencent/mm/network/ah:hMM	Ljava/lang/String;
    //   317: invokespecial 140	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   320: astore 11
    //   322: aload 9
    //   324: astore 8
    //   326: aload 11
    //   328: invokevirtual 143	com/tencent/mm/vfs/e:exists	()Z
    //   331: ifne +51 -> 382
    //   334: aload 9
    //   336: astore 8
    //   338: aload 11
    //   340: invokevirtual 146	com/tencent/mm/vfs/e:createNewFile	()Z
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
    //   390: aload 11
    //   392: invokestatic 163	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   395: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   398: astore 9
    //   400: lload_0
    //   401: l2i
    //   402: istore 4
    //   404: aload 9
    //   406: iload 4
    //   408: invokevirtual 169	java/io/DataOutputStream:writeInt	(I)V
    //   411: aload 9
    //   413: lload_2
    //   414: l2i
    //   415: invokevirtual 169	java/io/DataOutputStream:writeInt	(I)V
    //   418: aload 9
    //   420: invokevirtual 172	java/io/DataOutputStream:flush	()V
    //   423: aload 9
    //   425: invokevirtual 175	java/io/DataOutputStream:close	()V
    //   428: aload 9
    //   430: invokevirtual 175	java/io/DataOutputStream:close	()V
    //   433: ldc 111
    //   435: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: return
    //   439: astore 8
    //   441: ldc 111
    //   443: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: return
    //   447: astore 8
    //   449: aload 10
    //   451: astore 9
    //   453: aload 8
    //   455: astore 10
    //   457: aload 9
    //   459: astore 8
    //   461: new 20	java/lang/StringBuilder
    //   464: dup
    //   465: ldc 177
    //   467: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload 10
    //   472: invokevirtual 152	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   475: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 9
    //   481: ifnull +8 -> 489
    //   484: aload 9
    //   486: invokevirtual 175	java/io/DataOutputStream:close	()V
    //   489: ldc 111
    //   491: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   494: return
    //   495: astore 8
    //   497: ldc 111
    //   499: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   502: return
    //   503: astore 10
    //   505: aload 8
    //   507: astore 9
    //   509: aload 10
    //   511: astore 8
    //   513: aload 9
    //   515: ifnull +8 -> 523
    //   518: aload 9
    //   520: invokevirtual 175	java/io/DataOutputStream:close	()V
    //   523: ldc 111
    //   525: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload 8
    //   530: athrow
    //   531: astore 9
    //   533: goto -10 -> 523
    //   536: astore 8
    //   538: goto -25 -> 513
    //   541: astore 10
    //   543: goto -86 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	paramLong1	long
    //   0	546	2	paramLong2	long
    //   402	5	4	i	int
    //   267	3	5	l	long
    //   287	59	7	bool	boolean
    //   239	98	8	localObject1	Object
    //   356	12	8	localException1	java.lang.Exception
    //   384	1	8	localObject2	Object
    //   439	1	8	localException2	java.lang.Exception
    //   447	7	8	localException3	java.lang.Exception
    //   459	1	8	localObject3	Object
    //   495	11	8	localException4	java.lang.Exception
    //   511	18	8	localObject4	Object
    //   536	1	8	localObject5	Object
    //   301	218	9	localObject6	Object
    //   531	1	9	localException5	java.lang.Exception
    //   304	167	10	localException6	java.lang.Exception
    //   503	7	10	localObject7	Object
    //   541	1	10	localException7	java.lang.Exception
    //   320	71	11	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   229	254	356	java/lang/Exception
    //   282	289	356	java/lang/Exception
    //   350	355	356	java/lang/Exception
    //   433	438	356	java/lang/Exception
    //   441	446	356	java/lang/Exception
    //   489	494	356	java/lang/Exception
    //   497	502	356	java/lang/Exception
    //   523	531	356	java/lang/Exception
    //   428	433	439	java/lang/Exception
    //   310	322	447	java/lang/Exception
    //   326	334	447	java/lang/Exception
    //   338	345	447	java/lang/Exception
    //   386	400	447	java/lang/Exception
    //   484	489	495	java/lang/Exception
    //   310	322	503	finally
    //   326	334	503	finally
    //   338	345	503	finally
    //   386	400	503	finally
    //   461	479	503	finally
    //   518	523	531	java/lang/Exception
    //   404	428	536	finally
    //   404	428	541	java/lang/Exception
  }
  
  /* Error */
  private static long[] aFs()
  {
    // Byte code:
    //   0: ldc 178
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
    //   21: new 139	com/tencent/mm/vfs/e
    //   24: dup
    //   25: getstatic 40	com/tencent/mm/network/ah:hMM	Ljava/lang/String;
    //   28: invokespecial 140	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 143	com/tencent/mm/vfs/e:exists	()Z
    //   36: ifne +11 -> 47
    //   39: ldc 178
    //   41: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload 6
    //   46: areturn
    //   47: new 180	java/io/DataInputStream
    //   50: dup
    //   51: aload_3
    //   52: invokestatic 184	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   55: invokespecial 187	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore 4
    //   60: aload 4
    //   62: astore_3
    //   63: aload 4
    //   65: invokevirtual 191	java/io/DataInputStream:readInt	()I
    //   68: istore_0
    //   69: iload_0
    //   70: i2l
    //   71: ldc2_w 88
    //   74: lcmp
    //   75: iflt +12 -> 87
    //   78: iload_0
    //   79: i2l
    //   80: ldc2_w 90
    //   83: lcmp
    //   84: ifle +24 -> 108
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: invokevirtual 192	java/io/DataInputStream:close	()V
    //   95: aload 4
    //   97: invokevirtual 192	java/io/DataInputStream:close	()V
    //   100: ldc 178
    //   102: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload 6
    //   107: areturn
    //   108: iload_0
    //   109: i2l
    //   110: lstore_1
    //   111: aload 6
    //   113: iconst_0
    //   114: lload_1
    //   115: lastore
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 191	java/io/DataInputStream:readInt	()I
    //   124: istore_0
    //   125: aload 4
    //   127: astore_3
    //   128: iload_0
    //   129: i2l
    //   130: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   133: ldc2_w 77
    //   136: ldiv
    //   137: lcmp
    //   138: ifle +24 -> 162
    //   141: aload 4
    //   143: astore_3
    //   144: aload 4
    //   146: invokevirtual 192	java/io/DataInputStream:close	()V
    //   149: aload 4
    //   151: invokevirtual 192	java/io/DataInputStream:close	()V
    //   154: ldc 178
    //   156: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 6
    //   161: areturn
    //   162: iload_0
    //   163: i2l
    //   164: lstore_1
    //   165: aload 6
    //   167: iconst_1
    //   168: lload_1
    //   169: lastore
    //   170: aload 4
    //   172: astore_3
    //   173: aload 4
    //   175: invokevirtual 192	java/io/DataInputStream:close	()V
    //   178: aload 4
    //   180: invokevirtual 192	java/io/DataInputStream:close	()V
    //   183: ldc 178
    //   185: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload 6
    //   190: areturn
    //   191: astore 5
    //   193: aconst_null
    //   194: astore 4
    //   196: aload 4
    //   198: astore_3
    //   199: new 20	java/lang/StringBuilder
    //   202: dup
    //   203: ldc 194
    //   205: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 5
    //   210: invokevirtual 152	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   213: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 4
    //   219: ifnull +8 -> 227
    //   222: aload 4
    //   224: invokevirtual 192	java/io/DataInputStream:close	()V
    //   227: ldc 178
    //   229: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload 6
    //   234: areturn
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull +7 -> 247
    //   243: aload_3
    //   244: invokevirtual 192	java/io/DataInputStream:close	()V
    //   247: ldc 178
    //   249: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 4
    //   254: athrow
    //   255: astore_3
    //   256: goto -156 -> 100
    //   259: astore_3
    //   260: goto -106 -> 154
    //   263: astore_3
    //   264: goto -81 -> 183
    //   267: astore_3
    //   268: goto -41 -> 227
    //   271: astore_3
    //   272: goto -25 -> 247
    //   275: astore 4
    //   277: goto -38 -> 239
    //   280: astore 5
    //   282: goto -86 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	95	0	i	int
    //   110	59	1	l	long
    //   31	213	3	localObject1	Object
    //   255	1	3	localException1	java.lang.Exception
    //   259	1	3	localException2	java.lang.Exception
    //   263	1	3	localException3	java.lang.Exception
    //   267	1	3	localException4	java.lang.Exception
    //   271	1	3	localException5	java.lang.Exception
    //   58	165	4	localDataInputStream	java.io.DataInputStream
    //   235	18	4	localObject2	Object
    //   275	1	4	localObject3	Object
    //   191	18	5	localException6	java.lang.Exception
    //   280	1	5	localException7	java.lang.Exception
    //   8	225	6	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   47	60	191	java/lang/Exception
    //   47	60	235	finally
    //   95	100	255	java/lang/Exception
    //   149	154	259	java/lang/Exception
    //   178	183	263	java/lang/Exception
    //   222	227	267	java/lang/Exception
    //   243	247	271	java/lang/Exception
    //   63	69	275	finally
    //   90	95	275	finally
    //   119	125	275	finally
    //   128	141	275	finally
    //   144	149	275	finally
    //   173	178	275	finally
    //   199	217	275	finally
    //   63	69	280	java/lang/Exception
    //   90	95	280	java/lang/Exception
    //   119	125	280	java/lang/Exception
    //   128	141	280	java/lang/Exception
    //   144	149	280	java/lang/Exception
    //   173	178	280	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ah
 * JD-Core Version:    0.7.0.1
 */