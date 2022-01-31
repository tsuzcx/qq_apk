package com.tencent.mm.cc;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class f
{
  private static boolean yjA;
  private static ArrayList<Integer> yjB;
  private static final List<String> yjt;
  private static f yju;
  private static g yjv;
  private static c yjw;
  private static e yjx;
  private static String yjy;
  private static boolean yjz;
  
  static
  {
    AppMethodBeat.i(105933);
    yjt = Arrays.asList(new String[] { "zh_CN", "en" });
    yjy = "";
    yjz = false;
    yjA = true;
    yjB = new ArrayList();
    AppMethodBeat.o(105933);
  }
  
  private static int a(DataInputStream paramDataInputStream, SparseArray<c.a> paramSparseArray, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105931);
    try
    {
      int m = paramDataInputStream.readByte();
      if (m < 0)
      {
        AppMethodBeat.o(105931);
        return 0;
      }
      int[] arrayOfInt1 = new int[m];
      int[] arrayOfInt2 = new int[m];
      int j = 0;
      int k = 0;
      int i = paramInt2;
      paramInt2 = k;
      while (paramInt2 < m)
      {
        arrayOfInt1[paramInt2] = paramDataInputStream.readByte();
        arrayOfInt2[paramInt2] = i;
        k = paramDataInputStream.readShort();
        j += k;
        i += k;
        paramInt2 += 1;
      }
      paramSparseArray.append(paramInt1, new c.a(paramInt1, arrayOfInt1, arrayOfInt2));
      AppMethodBeat.o(105931);
      return j;
    }
    catch (IOException paramDataInputStream)
    {
      ab.e("MicroMsg.language.StringResouces", "exception:%s", new Object[] { bo.l(paramDataInputStream) });
      AppMethodBeat.o(105931);
    }
    return 0;
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager)
  {
    // Byte code:
    //   0: ldc 112
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 94
    //   7: ldc 114
    //   9: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 61	com/tencent/mm/cc/f:yjB	Ljava/util/ArrayList;
    //   15: ifnonnull +13 -> 28
    //   18: new 56	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 59	java/util/ArrayList:<init>	()V
    //   25: putstatic 61	com/tencent/mm/cc/f:yjB	Ljava/util/ArrayList;
    //   28: getstatic 61	com/tencent/mm/cc/f:yjB	Ljava/util/ArrayList;
    //   31: invokevirtual 120	java/util/ArrayList:clear	()V
    //   34: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   37: lstore_2
    //   38: aload_0
    //   39: ldc 128
    //   41: invokevirtual 134	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_0
    //   45: new 73	java/io/DataInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 137	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore 4
    //   55: aload 4
    //   57: astore 6
    //   59: aload_0
    //   60: astore 5
    //   62: aload 4
    //   64: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   67: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: astore 7
    //   72: aload 4
    //   74: astore 6
    //   76: aload_0
    //   77: astore 5
    //   79: ldc 94
    //   81: ldc 149
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload 7
    //   91: aastore
    //   92: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: iconst_0
    //   96: istore_1
    //   97: aload 4
    //   99: astore 6
    //   101: aload_0
    //   102: astore 5
    //   104: iload_1
    //   105: aload 7
    //   107: invokevirtual 155	java/lang/Integer:intValue	()I
    //   110: if_icmpge +66 -> 176
    //   113: aload 4
    //   115: astore 6
    //   117: aload_0
    //   118: astore 5
    //   120: aload 4
    //   122: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   125: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: astore 8
    //   130: aload 4
    //   132: astore 6
    //   134: aload_0
    //   135: astore 5
    //   137: getstatic 61	com/tencent/mm/cc/f:yjB	Ljava/util/ArrayList;
    //   140: aload 8
    //   142: invokevirtual 159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: aload 4
    //   148: astore 6
    //   150: aload_0
    //   151: astore 5
    //   153: ldc 94
    //   155: ldc 161
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload 8
    //   165: aastore
    //   166: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -76 -> 97
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 166	java/io/InputStream:close	()V
    //   184: aload 4
    //   186: invokevirtual 167	java/io/DataInputStream:close	()V
    //   189: ldc 94
    //   191: new 169	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 171
    //   197: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   203: lload_2
    //   204: lsub
    //   205: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc 112
    //   216: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: return
    //   220: astore_0
    //   221: ldc 94
    //   223: ldc 96
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_0
    //   232: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: goto -55 -> 184
    //   242: astore_0
    //   243: ldc 94
    //   245: ldc 96
    //   247: iconst_1
    //   248: anewarray 4	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: aload_0
    //   254: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   257: aastore
    //   258: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: goto -72 -> 189
    //   264: astore_0
    //   265: aconst_null
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_0
    //   270: aload 4
    //   272: astore 6
    //   274: aload_0
    //   275: astore 5
    //   277: ldc 94
    //   279: ldc 183
    //   281: invokestatic 186	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 166	java/io/InputStream:close	()V
    //   292: aload 4
    //   294: ifnull -105 -> 189
    //   297: aload 4
    //   299: invokevirtual 167	java/io/DataInputStream:close	()V
    //   302: goto -113 -> 189
    //   305: astore_0
    //   306: ldc 94
    //   308: ldc 96
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_0
    //   317: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -135 -> 189
    //   327: astore_0
    //   328: ldc 94
    //   330: ldc 96
    //   332: iconst_1
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   342: aastore
    //   343: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: goto -54 -> 292
    //   349: astore_0
    //   350: aconst_null
    //   351: astore 4
    //   353: aconst_null
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull +8 -> 366
    //   361: aload 5
    //   363: invokevirtual 166	java/io/InputStream:close	()V
    //   366: aload 4
    //   368: ifnull +8 -> 376
    //   371: aload 4
    //   373: invokevirtual 167	java/io/DataInputStream:close	()V
    //   376: ldc 112
    //   378: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_0
    //   382: athrow
    //   383: astore 5
    //   385: ldc 94
    //   387: ldc 96
    //   389: iconst_1
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload 5
    //   397: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: goto -38 -> 366
    //   407: astore 4
    //   409: ldc 94
    //   411: ldc 96
    //   413: iconst_1
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload 4
    //   421: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   424: aastore
    //   425: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: goto -52 -> 376
    //   431: astore 4
    //   433: aconst_null
    //   434: astore 6
    //   436: aload_0
    //   437: astore 5
    //   439: aload 4
    //   441: astore_0
    //   442: aload 6
    //   444: astore 4
    //   446: goto -90 -> 356
    //   449: astore_0
    //   450: aload 6
    //   452: astore 4
    //   454: goto -98 -> 356
    //   457: astore 4
    //   459: aconst_null
    //   460: astore 4
    //   462: goto -192 -> 270
    //   465: astore 5
    //   467: goto -197 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramAssetManager	AssetManager
    //   96	77	1	i	int
    //   37	167	2	l	long
    //   53	319	4	localDataInputStream1	DataInputStream
    //   407	13	4	localIOException1	IOException
    //   431	9	4	localObject1	Object
    //   444	9	4	localObject2	Object
    //   457	1	4	localIOException2	IOException
    //   460	1	4	localObject3	Object
    //   60	302	5	localAssetManager1	AssetManager
    //   383	13	5	localIOException3	IOException
    //   437	1	5	localAssetManager2	AssetManager
    //   465	1	5	localIOException4	IOException
    //   57	394	6	localDataInputStream2	DataInputStream
    //   70	36	7	localInteger1	Integer
    //   128	36	8	localInteger2	Integer
    // Exception table:
    //   from	to	target	type
    //   180	184	220	java/io/IOException
    //   184	189	242	java/io/IOException
    //   38	45	264	java/io/IOException
    //   297	302	305	java/io/IOException
    //   288	292	327	java/io/IOException
    //   38	45	349	finally
    //   361	366	383	java/io/IOException
    //   371	376	407	java/io/IOException
    //   45	55	431	finally
    //   62	72	449	finally
    //   79	95	449	finally
    //   104	113	449	finally
    //   120	130	449	finally
    //   137	146	449	finally
    //   153	169	449	finally
    //   277	284	449	finally
    //   45	55	457	java/io/IOException
    //   62	72	465	java/io/IOException
    //   79	95	465	java/io/IOException
    //   104	113	465	java/io/IOException
    //   120	130	465	java/io/IOException
    //   137	146	465	java/io/IOException
    //   153	169	465	java/io/IOException
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: ldc 188
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 192	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +16 -> 25
    //   12: ldc 94
    //   14: ldc 194
    //   16: invokestatic 186	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 188
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_1
    //   26: getstatic 50	com/tencent/mm/cc/f:yjy	Ljava/lang/String;
    //   29: invokevirtual 197	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +24 -> 56
    //   35: ldc 94
    //   37: ldc 199
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 188
    //   52: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: aload_1
    //   57: ldc 203
    //   59: invokevirtual 207	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   62: istore_2
    //   63: aload_1
    //   64: astore 12
    //   66: iload_2
    //   67: ifle +48 -> 115
    //   70: aload_1
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 211	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: astore 10
    //   78: aload_1
    //   79: astore 12
    //   81: aload 10
    //   83: ldc 213
    //   85: invokevirtual 216	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   88: ifne +27 -> 115
    //   91: ldc 94
    //   93: ldc 218
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload 10
    //   107: aastore
    //   108: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload 10
    //   113: astore 12
    //   115: invokestatic 221	com/tencent/mm/cc/f:clean	()V
    //   118: aload 12
    //   120: putstatic 50	com/tencent/mm/cc/f:yjy	Ljava/lang/String;
    //   123: ldc 94
    //   125: ldc 223
    //   127: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   133: lstore 8
    //   135: aconst_null
    //   136: astore 10
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_0
    //   141: new 169	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 225
    //   147: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 12
    //   152: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 230
    //   157: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 134	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   166: astore_0
    //   167: aload_0
    //   168: astore_1
    //   169: aload_0
    //   170: astore 10
    //   172: new 73	java/io/DataInputStream
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 137	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore 11
    //   182: aload 11
    //   184: astore 10
    //   186: aload_0
    //   187: astore_1
    //   188: aload 11
    //   190: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   193: pop
    //   194: aload 11
    //   196: astore 10
    //   198: aload_0
    //   199: astore_1
    //   200: aload 11
    //   202: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   205: pop
    //   206: aload 11
    //   208: astore 10
    //   210: aload_0
    //   211: astore_1
    //   212: aload 11
    //   214: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   217: istore 5
    //   219: aload 11
    //   221: astore 10
    //   223: aload_0
    //   224: astore_1
    //   225: ldc 94
    //   227: ldc 232
    //   229: iload 5
    //   231: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 11
    //   242: astore 10
    //   244: aload_0
    //   245: astore_1
    //   246: new 241	android/util/SparseIntArray
    //   249: dup
    //   250: iload 5
    //   252: invokespecial 243	android/util/SparseIntArray:<init>	(I)V
    //   255: astore 13
    //   257: aload 11
    //   259: astore 10
    //   261: aload_0
    //   262: astore_1
    //   263: aload 11
    //   265: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   268: istore 4
    //   270: iconst_0
    //   271: istore_2
    //   272: iconst_0
    //   273: istore_3
    //   274: iload_2
    //   275: iload 5
    //   277: if_icmpge +54 -> 331
    //   280: aload 11
    //   282: astore 10
    //   284: aload_0
    //   285: astore_1
    //   286: iload 4
    //   288: aload 11
    //   290: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   293: iadd
    //   294: istore 4
    //   296: aload 11
    //   298: astore 10
    //   300: aload_0
    //   301: astore_1
    //   302: aload 13
    //   304: iload 4
    //   306: iload_3
    //   307: invokevirtual 246	android/util/SparseIntArray:append	(II)V
    //   310: aload 11
    //   312: astore 10
    //   314: aload_0
    //   315: astore_1
    //   316: iload_3
    //   317: aload 11
    //   319: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   322: iadd
    //   323: istore_3
    //   324: iload_2
    //   325: iconst_1
    //   326: iadd
    //   327: istore_2
    //   328: goto -54 -> 274
    //   331: aload 11
    //   333: astore 10
    //   335: aload_0
    //   336: astore_1
    //   337: aload 13
    //   339: aload 11
    //   341: iload_3
    //   342: invokestatic 251	com/tencent/mm/cc/g:a	(Landroid/util/SparseIntArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/g;
    //   345: putstatic 253	com/tencent/mm/cc/f:yjv	Lcom/tencent/mm/cc/g;
    //   348: iconst_0
    //   349: istore_2
    //   350: aload 11
    //   352: astore 10
    //   354: aload_0
    //   355: astore_1
    //   356: aload 11
    //   358: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   361: istore 5
    //   363: aload 11
    //   365: astore 10
    //   367: aload_0
    //   368: astore_1
    //   369: ldc 94
    //   371: ldc 255
    //   373: iconst_1
    //   374: anewarray 4	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: iload 5
    //   381: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: iload 5
    //   390: ifle +100 -> 490
    //   393: aload 11
    //   395: astore 10
    //   397: aload_0
    //   398: astore_1
    //   399: new 88	android/util/SparseArray
    //   402: dup
    //   403: iload 5
    //   405: invokespecial 256	android/util/SparseArray:<init>	(I)V
    //   408: astore 13
    //   410: aload 11
    //   412: astore 10
    //   414: aload_0
    //   415: astore_1
    //   416: aload 11
    //   418: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   421: istore 4
    //   423: iconst_0
    //   424: istore_3
    //   425: iload_2
    //   426: iload 5
    //   428: if_icmpge +45 -> 473
    //   431: aload 11
    //   433: astore 10
    //   435: aload_0
    //   436: astore_1
    //   437: iload 4
    //   439: aload 11
    //   441: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   444: iadd
    //   445: istore 4
    //   447: aload 11
    //   449: astore 10
    //   451: aload_0
    //   452: astore_1
    //   453: iload_3
    //   454: aload 11
    //   456: aload 13
    //   458: iload 4
    //   460: iload_3
    //   461: invokestatic 258	com/tencent/mm/cc/f:a	(Ljava/io/DataInputStream;Landroid/util/SparseArray;II)I
    //   464: iadd
    //   465: istore_3
    //   466: iload_2
    //   467: iconst_1
    //   468: iadd
    //   469: istore_2
    //   470: goto -45 -> 425
    //   473: aload 11
    //   475: astore 10
    //   477: aload_0
    //   478: astore_1
    //   479: aload 13
    //   481: aload 11
    //   483: iload_3
    //   484: invokestatic 263	com/tencent/mm/cc/c:a	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/c;
    //   487: putstatic 265	com/tencent/mm/cc/f:yjw	Lcom/tencent/mm/cc/c;
    //   490: aload 11
    //   492: astore 10
    //   494: aload_0
    //   495: astore_1
    //   496: aload 11
    //   498: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   501: istore 6
    //   503: aload 11
    //   505: astore 10
    //   507: aload_0
    //   508: astore_1
    //   509: aload 11
    //   511: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   514: istore 4
    //   516: aload 11
    //   518: astore 10
    //   520: aload_0
    //   521: astore_1
    //   522: ldc 94
    //   524: ldc_w 267
    //   527: iconst_1
    //   528: anewarray 4	java/lang/Object
    //   531: dup
    //   532: iconst_0
    //   533: iload 6
    //   535: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: iload 6
    //   544: ifle +162 -> 706
    //   547: aload 11
    //   549: astore 10
    //   551: aload_0
    //   552: astore_1
    //   553: new 88	android/util/SparseArray
    //   556: dup
    //   557: iload 6
    //   559: invokespecial 256	android/util/SparseArray:<init>	(I)V
    //   562: astore 13
    //   564: iconst_0
    //   565: istore_3
    //   566: iconst_0
    //   567: istore_2
    //   568: iload_2
    //   569: iload 6
    //   571: if_icmpge +118 -> 689
    //   574: aload 11
    //   576: astore 10
    //   578: aload_0
    //   579: astore_1
    //   580: aload 11
    //   582: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   585: iload 4
    //   587: iadd
    //   588: istore 5
    //   590: aload 11
    //   592: astore 10
    //   594: aload_0
    //   595: astore_1
    //   596: aload 11
    //   598: invokevirtual 141	java/io/DataInputStream:readInt	()I
    //   601: istore 7
    //   603: aload 11
    //   605: astore 10
    //   607: aload_0
    //   608: astore_1
    //   609: iload 7
    //   611: newarray int
    //   613: astore 14
    //   615: iconst_0
    //   616: istore 4
    //   618: iload 4
    //   620: iload 7
    //   622: if_icmpge +32 -> 654
    //   625: aload 14
    //   627: iload 4
    //   629: iload_3
    //   630: iastore
    //   631: aload 11
    //   633: astore 10
    //   635: aload_0
    //   636: astore_1
    //   637: iload_3
    //   638: aload 11
    //   640: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   643: iadd
    //   644: istore_3
    //   645: iload 4
    //   647: iconst_1
    //   648: iadd
    //   649: istore 4
    //   651: goto -33 -> 618
    //   654: aload 11
    //   656: astore 10
    //   658: aload_0
    //   659: astore_1
    //   660: aload 13
    //   662: iload 5
    //   664: new 269	com/tencent/mm/cc/e$a
    //   667: dup
    //   668: iload 5
    //   670: aload 14
    //   672: invokespecial 272	com/tencent/mm/cc/e$a:<init>	(I[I)V
    //   675: invokevirtual 92	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   678: iload_2
    //   679: iconst_1
    //   680: iadd
    //   681: istore_2
    //   682: iload 5
    //   684: istore 4
    //   686: goto -118 -> 568
    //   689: aload 11
    //   691: astore 10
    //   693: aload_0
    //   694: astore_1
    //   695: aload 13
    //   697: aload 11
    //   699: iload_3
    //   700: invokestatic 278	com/tencent/mm/cc/e:b	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/e;
    //   703: putstatic 280	com/tencent/mm/cc/f:yjx	Lcom/tencent/mm/cc/e;
    //   706: aload_0
    //   707: ifnull +7 -> 714
    //   710: aload_0
    //   711: invokevirtual 166	java/io/InputStream:close	()V
    //   714: aload 11
    //   716: invokevirtual 167	java/io/DataInputStream:close	()V
    //   719: ldc 94
    //   721: new 169	java/lang/StringBuilder
    //   724: dup
    //   725: ldc_w 282
    //   728: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   731: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   734: lload 8
    //   736: lsub
    //   737: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   740: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: ldc 188
    //   748: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   751: return
    //   752: astore_0
    //   753: ldc 94
    //   755: ldc 96
    //   757: iconst_1
    //   758: anewarray 4	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload_0
    //   764: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   767: aastore
    //   768: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   771: goto -57 -> 714
    //   774: astore_0
    //   775: ldc 94
    //   777: ldc 96
    //   779: iconst_1
    //   780: anewarray 4	java/lang/Object
    //   783: dup
    //   784: iconst_0
    //   785: aload_0
    //   786: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   789: aastore
    //   790: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   793: goto -74 -> 719
    //   796: astore 13
    //   798: aconst_null
    //   799: astore 11
    //   801: aload_1
    //   802: astore_0
    //   803: aload 11
    //   805: astore 10
    //   807: aload_0
    //   808: astore_1
    //   809: ldc 94
    //   811: aload 13
    //   813: ldc_w 284
    //   816: iconst_1
    //   817: anewarray 4	java/lang/Object
    //   820: dup
    //   821: iconst_0
    //   822: aload 12
    //   824: aastore
    //   825: invokestatic 288	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   828: aload_0
    //   829: ifnull +7 -> 836
    //   832: aload_0
    //   833: invokevirtual 166	java/io/InputStream:close	()V
    //   836: aload 11
    //   838: ifnull -119 -> 719
    //   841: aload 11
    //   843: invokevirtual 167	java/io/DataInputStream:close	()V
    //   846: goto -127 -> 719
    //   849: astore_0
    //   850: ldc 94
    //   852: ldc 96
    //   854: iconst_1
    //   855: anewarray 4	java/lang/Object
    //   858: dup
    //   859: iconst_0
    //   860: aload_0
    //   861: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   864: aastore
    //   865: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: goto -149 -> 719
    //   871: astore_0
    //   872: ldc 94
    //   874: ldc 96
    //   876: iconst_1
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: aload_0
    //   883: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   886: aastore
    //   887: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: goto -54 -> 836
    //   893: astore_0
    //   894: aconst_null
    //   895: astore 11
    //   897: aload 10
    //   899: astore_1
    //   900: aload 11
    //   902: astore 10
    //   904: aload_1
    //   905: ifnull +7 -> 912
    //   908: aload_1
    //   909: invokevirtual 166	java/io/InputStream:close	()V
    //   912: aload 10
    //   914: ifnull +8 -> 922
    //   917: aload 10
    //   919: invokevirtual 167	java/io/DataInputStream:close	()V
    //   922: ldc 188
    //   924: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   927: aload_0
    //   928: athrow
    //   929: astore_1
    //   930: ldc 94
    //   932: ldc 96
    //   934: iconst_1
    //   935: anewarray 4	java/lang/Object
    //   938: dup
    //   939: iconst_0
    //   940: aload_1
    //   941: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   944: aastore
    //   945: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   948: goto -36 -> 912
    //   951: astore_1
    //   952: ldc 94
    //   954: ldc 96
    //   956: iconst_1
    //   957: anewarray 4	java/lang/Object
    //   960: dup
    //   961: iconst_0
    //   962: aload_1
    //   963: invokestatic 102	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   966: aastore
    //   967: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: goto -48 -> 922
    //   973: astore_0
    //   974: goto -70 -> 904
    //   977: astore 13
    //   979: goto -176 -> 803
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	982	0	paramAssetManager	AssetManager
    //   0	982	1	paramString	String
    //   62	620	2	i	int
    //   273	427	3	j	int
    //   268	417	4	k	int
    //   217	466	5	m	int
    //   501	71	6	n	int
    //   601	22	7	i1	int
    //   133	602	8	l	long
    //   76	842	10	localObject1	Object
    //   180	721	11	localDataInputStream	DataInputStream
    //   64	759	12	localObject2	Object
    //   255	441	13	localObject3	Object
    //   796	16	13	localIOException1	IOException
    //   977	1	13	localIOException2	IOException
    //   613	58	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   710	714	752	java/io/IOException
    //   714	719	774	java/io/IOException
    //   140	167	796	java/io/IOException
    //   172	182	796	java/io/IOException
    //   841	846	849	java/io/IOException
    //   832	836	871	java/io/IOException
    //   140	167	893	finally
    //   172	182	893	finally
    //   908	912	929	java/io/IOException
    //   917	922	951	java/io/IOException
    //   188	194	973	finally
    //   200	206	973	finally
    //   212	219	973	finally
    //   225	240	973	finally
    //   246	257	973	finally
    //   263	270	973	finally
    //   286	296	973	finally
    //   302	310	973	finally
    //   316	324	973	finally
    //   337	348	973	finally
    //   356	363	973	finally
    //   369	388	973	finally
    //   399	410	973	finally
    //   416	423	973	finally
    //   437	447	973	finally
    //   453	466	973	finally
    //   479	490	973	finally
    //   496	503	973	finally
    //   509	516	973	finally
    //   522	542	973	finally
    //   553	564	973	finally
    //   580	590	973	finally
    //   596	603	973	finally
    //   609	615	973	finally
    //   637	645	973	finally
    //   660	678	973	finally
    //   695	706	973	finally
    //   809	828	973	finally
    //   188	194	977	java/io/IOException
    //   200	206	977	java/io/IOException
    //   212	219	977	java/io/IOException
    //   225	240	977	java/io/IOException
    //   246	257	977	java/io/IOException
    //   263	270	977	java/io/IOException
    //   286	296	977	java/io/IOException
    //   302	310	977	java/io/IOException
    //   316	324	977	java/io/IOException
    //   337	348	977	java/io/IOException
    //   356	363	977	java/io/IOException
    //   369	388	977	java/io/IOException
    //   399	410	977	java/io/IOException
    //   416	423	977	java/io/IOException
    //   437	447	977	java/io/IOException
    //   453	466	977	java/io/IOException
    //   479	490	977	java/io/IOException
    //   496	503	977	java/io/IOException
    //   509	516	977	java/io/IOException
    //   522	542	977	java/io/IOException
    //   553	564	977	java/io/IOException
    //   580	590	977	java/io/IOException
    //   596	603	977	java/io/IOException
    //   609	615	977	java/io/IOException
    //   637	645	977	java/io/IOException
    //   660	678	977	java/io/IOException
    //   695	706	977	java/io/IOException
  }
  
  private static boolean aoH(String paramString)
  {
    AppMethodBeat.i(105920);
    if (yjt.contains(paramString))
    {
      AppMethodBeat.o(105920);
      return false;
    }
    AppMethodBeat.o(105920);
    return true;
  }
  
  public static f bF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(105923);
    if (paramContext.getResources() == null)
    {
      ab.e("MicroMsg.language.StringResouces", "the resource is null! why?");
      AppMethodBeat.o(105923);
      return null;
    }
    AssetManager localAssetManager = paramContext.getAssets();
    if (localAssetManager != null)
    {
      drk();
      a(localAssetManager);
    }
    if (localAssetManager != null)
    {
      drk();
      if (yjA) {}
    }
    else
    {
      AppMethodBeat.o(105923);
      return null;
    }
    if ((bo.isNullOrNil(paramString)) || (paramString.equalsIgnoreCase("language_default")))
    {
      paramString = Locale.getDefault();
      aa.a(paramContext, paramString);
    }
    for (paramContext = paramString;; paramContext = aa.apg(paramString))
    {
      paramContext = paramContext.toString();
      drk();
      boolean bool = aoH(paramContext);
      yjz = bool;
      if (!bool) {
        break;
      }
      drk();
      a(localAssetManager, paramContext);
      paramContext = drk();
      AppMethodBeat.o(105923);
      return paramContext;
    }
    clean();
    yjy = paramContext;
    AppMethodBeat.o(105923);
    return null;
  }
  
  private static void clean()
  {
    AppMethodBeat.i(105921);
    Object localObject;
    if (yjv != null)
    {
      localObject = yjv;
      if (((g)localObject).yjC != null) {
        ((g)localObject).yjC.clear();
      }
      if (((g)localObject).yjD != null) {
        ((g)localObject).yjD = null;
      }
    }
    if (yjw != null)
    {
      localObject = yjw;
      if (((c)localObject).yjm != null) {
        ((c)localObject).yjm.clear();
      }
      if (((c)localObject).mData != null) {
        ((c)localObject).mData = null;
      }
    }
    if (yjx != null)
    {
      localObject = yjx;
      if (((e)localObject).yjr != null) {
        ((e)localObject).yjr.clear();
      }
      if (((e)localObject).mData != null) {
        ((e)localObject).mData = null;
      }
    }
    AppMethodBeat.o(105921);
  }
  
  public static CharSequence d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105932);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(105932);
      return paramCharSequence;
    }
    if ((yjB == null) || (yjB.isEmpty()))
    {
      AppMethodBeat.o(105932);
      return paramCharSequence;
    }
    if (yjB.contains(Integer.valueOf(paramInt)))
    {
      paramCharSequence = a.B(paramCharSequence.toString(), com.tencent.mm.a.g.w("lucky".getBytes()).substring(0, 16));
      AppMethodBeat.o(105932);
      return paramCharSequence;
    }
    AppMethodBeat.o(105932);
    return paramCharSequence;
  }
  
  public static boolean drj()
  {
    return yjA;
  }
  
  public static f drk()
  {
    AppMethodBeat.i(105919);
    try
    {
      if (yju == null) {
        yju = new f();
      }
      f localf = yju;
      return localf;
    }
    finally
    {
      AppMethodBeat.o(105919);
    }
  }
  
  public static boolean drl()
  {
    AppMethodBeat.i(105926);
    if ((!yjA) || (!yjz)) {
      if ((yjB == null) || (yjB.isEmpty())) {
        break label47;
      }
    }
    label47:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105926);
      return true;
    }
    AppMethodBeat.o(105926);
    return false;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105928);
    if (yjw == null)
    {
      AppMethodBeat.o(105928);
      return null;
    }
    String str = yjw.getQuantityString(paramInt1, paramInt2, new Object[0]);
    AppMethodBeat.o(105928);
    return str;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(105929);
    if (yjw == null)
    {
      AppMethodBeat.o(105929);
      return null;
    }
    paramVarArgs = yjw.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(105929);
    return paramVarArgs;
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(105927);
    if (yjv == null)
    {
      AppMethodBeat.o(105927);
      return null;
    }
    String str = yjv.getString(paramInt);
    AppMethodBeat.o(105927);
    return str;
  }
  
  public static String[] getStringArray(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(105930);
    if (yjx == null)
    {
      AppMethodBeat.o(105930);
      return null;
    }
    e locale = yjx;
    int j = locale.yjr.indexOfKey(paramInt);
    if (j < 0)
    {
      AppMethodBeat.o(105930);
      return null;
    }
    e.a locala;
    String[] arrayOfString;
    if (j < locale.yjr.size() - 1)
    {
      paramInt = ((e.a)locale.yjr.valueAt(j + 1)).yjs[0];
      locala = (e.a)locale.yjr.valueAt(j);
      j = locala.yjs.length;
      if (j <= 0) {
        break label223;
      }
      arrayOfString = new String[j];
      label113:
      if (i >= j) {
        break label215;
      }
      if (i >= j - 1) {
        break label181;
      }
      arrayOfString[i] = new String(locale.mData, locala.yjs[i], locala.yjs[(i + 1)] - locala.yjs[i]);
    }
    for (;;)
    {
      i += 1;
      break label113;
      paramInt = locale.mData.length;
      break;
      label181:
      arrayOfString[i] = new String(locale.mData, locala.yjs[i], paramInt - locala.yjs[i]);
    }
    for (;;)
    {
      label215:
      AppMethodBeat.o(105930);
      return arrayOfString;
      label223:
      arrayOfString = null;
    }
  }
  
  public static f gy(Context paramContext)
  {
    AppMethodBeat.i(105922);
    paramContext = bF(paramContext, aa.f(paramContext.getSharedPreferences(ah.dsP(), 0)));
    AppMethodBeat.o(105922);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.f
 * JD-Core Version:    0.7.0.1
 */