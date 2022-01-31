package com.tencent.mm.m;

import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static final String dAj = ac.dOP + "configlist/";
  public SparseArray<d> dAi = new SparseArray();
  
  public static int Am()
  {
    String str = ((a)g.r(a.class)).AA().getValue("VoiceVOIPSwitch");
    y.d("MicroMsg.ConfigListDecoder", "voip is " + str);
    try
    {
      i = bk.getInt(str, 0);
      y.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is " + i);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bk.j(localException) });
        int i = 0;
      }
    }
  }
  
  public static String gI(int paramInt)
  {
    return dAj + "config_" + paramInt + ".xml";
  }
  
  /* Error */
  private void load(int paramInt)
  {
    // Byte code:
    //   0: new 110	java/io/File
    //   3: dup
    //   4: iload_1
    //   5: invokestatic 112	com/tencent/mm/m/c:gI	(I)Ljava/lang/String;
    //   8: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 117	java/io/File:exists	()Z
    //   16: ifeq +230 -> 246
    //   19: new 119	java/io/FileInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: new 124	java/io/InputStreamReader
    //   33: dup
    //   34: aload_3
    //   35: ldc 126
    //   37: invokespecial 129	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload_3
    //   43: astore_2
    //   44: new 131	java/io/BufferedReader
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore 5
    //   55: aload_3
    //   56: astore_2
    //   57: new 136	java/lang/StringBuffer
    //   60: dup
    //   61: invokespecial 137	java/lang/StringBuffer:<init>	()V
    //   64: astore 6
    //   66: aload_3
    //   67: astore_2
    //   68: aload 5
    //   70: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 7
    //   75: aload 7
    //   77: ifnull +48 -> 125
    //   80: aload_3
    //   81: astore_2
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 143	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: goto -24 -> 66
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: ldc 66
    //   99: ldc 90
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload 4
    //   109: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 148	java/io/InputStream:close	()V
    //   124: return
    //   125: aload_3
    //   126: astore_2
    //   127: aload_0
    //   128: iload_1
    //   129: aload 6
    //   131: invokevirtual 149	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   134: invokevirtual 153	com/tencent/mm/m/c:m	(ILjava/lang/String;)V
    //   137: aload_3
    //   138: astore_2
    //   139: aload 4
    //   141: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   144: aload_3
    //   145: astore_2
    //   146: aload 5
    //   148: invokevirtual 155	java/io/BufferedReader:close	()V
    //   151: aload_3
    //   152: ifnull -28 -> 124
    //   155: aload_3
    //   156: invokevirtual 148	java/io/InputStream:close	()V
    //   159: return
    //   160: astore_2
    //   161: ldc 66
    //   163: ldc 90
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_2
    //   172: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   175: aastore
    //   176: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: return
    //   180: astore_2
    //   181: ldc 66
    //   183: ldc 90
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_2
    //   192: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: return
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 148	java/io/InputStream:close	()V
    //   211: aload_3
    //   212: athrow
    //   213: astore_2
    //   214: ldc 66
    //   216: ldc 90
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_2
    //   225: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -21 -> 211
    //   235: astore_3
    //   236: goto -33 -> 203
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_3
    //   243: goto -148 -> 95
    //   246: aconst_null
    //   247: astore_3
    //   248: goto -97 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	c
    //   0	251	1	paramInt	int
    //   11	135	2	localObject1	Object
    //   160	12	2	localIOException1	java.io.IOException
    //   180	12	2	localIOException2	java.io.IOException
    //   202	6	2	localObject2	Object
    //   213	12	2	localIOException3	java.io.IOException
    //   27	129	3	localFileInputStream	java.io.FileInputStream
    //   200	12	3	localObject3	Object
    //   235	1	3	localObject4	Object
    //   242	6	3	localObject5	Object
    //   40	9	4	localInputStreamReader	java.io.InputStreamReader
    //   93	47	4	localException1	Exception
    //   239	1	4	localException2	Exception
    //   53	94	5	localBufferedReader	java.io.BufferedReader
    //   64	66	6	localStringBuffer	java.lang.StringBuffer
    //   73	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	42	93	java/lang/Exception
    //   44	55	93	java/lang/Exception
    //   57	66	93	java/lang/Exception
    //   68	75	93	java/lang/Exception
    //   82	90	93	java/lang/Exception
    //   127	137	93	java/lang/Exception
    //   139	144	93	java/lang/Exception
    //   146	151	93	java/lang/Exception
    //   155	159	160	java/io/IOException
    //   120	124	180	java/io/IOException
    //   0	28	200	finally
    //   207	211	213	java/io/IOException
    //   30	42	235	finally
    //   44	55	235	finally
    //   57	66	235	finally
    //   68	75	235	finally
    //   82	90	235	finally
    //   97	116	235	finally
    //   127	137	235	finally
    //   139	144	235	finally
    //   146	151	235	finally
    //   0	28	239	java/lang/Exception
  }
  
  public final d Al()
  {
    if (this.dAi.get(1) == null) {
      load(1);
    }
    return (d)this.dAi.get(1);
  }
  
  public final boolean An()
  {
    boolean bool = true;
    if (bk.getInt(H("WebViewConfig", "disableWePkg"), 0) == 1) {}
    for (;;)
    {
      y.d("MicroMsg.ConfigListDecoder", "disableWePkg : " + bool);
      return bool;
      bool = false;
    }
  }
  
  public final String Ao()
  {
    String str = H("FreeWiFiConfig", "CheckURL");
    y.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", new Object[] { str });
    return str;
  }
  
  public final boolean Ap()
  {
    boolean bool = true;
    if (bk.getInt(H("ShowConfig", "showRecvTmpMsgBtn"), 0) == 1) {}
    for (;;)
    {
      y.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : " + bool);
      return bool;
      bool = false;
    }
  }
  
  public final List<String> Aq()
  {
    Object localObject1 = null;
    Object localObject3 = H("IBeacon", "Content");
    if (!bk.bl((String)localObject3))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localObject3 = new JSONObject(((String)localObject3).replace(",}", "}")).keys();
        for (;;)
        {
          localObject1 = localArrayList;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject3).next();
          if (localObject1 != null) {
            localArrayList.add(localObject1.toString());
          }
        }
        Object localObject2;
        return localObject2;
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + localJSONException.getMessage());
        localObject2 = localArrayList;
      }
    }
  }
  
  public final String Ar()
  {
    return H("MailApp", "MailAppRedirectUrAndroid");
  }
  
  public final String H(String paramString1, String paramString2)
  {
    d locald = Al();
    if (locald == null) {}
    while (!locald.dAl.containsKey(paramString1)) {
      return null;
    }
    return (String)((HashMap)locald.dAl.get(paramString1)).get(paramString2);
  }
  
  /* Error */
  public final boolean d(java.io.File paramFile1, java.io.File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload 5
    //   5: istore 4
    //   7: aload_1
    //   8: invokevirtual 117	java/io/File:exists	()Z
    //   11: ifeq +87 -> 98
    //   14: aload_1
    //   15: invokevirtual 275	java/io/File:isDirectory	()Z
    //   18: ifeq +83 -> 101
    //   21: aload_2
    //   22: invokevirtual 117	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 278	java/io/File:mkdir	()Z
    //   32: pop
    //   33: aload_1
    //   34: invokevirtual 282	java/io/File:listFiles	()[Ljava/io/File;
    //   37: astore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iconst_0
    //   42: istore 4
    //   44: iload_3
    //   45: aload 6
    //   47: arraylength
    //   48: if_icmpge +50 -> 98
    //   51: aload 6
    //   53: iload_3
    //   54: aaload
    //   55: astore 7
    //   57: aload_0
    //   58: aload 7
    //   60: new 110	java/io/File
    //   63: dup
    //   64: aload_2
    //   65: invokevirtual 285	java/io/File:getPath	()Ljava/lang/String;
    //   68: aload 7
    //   70: invokevirtual 288	java/io/File:getName	()Ljava/lang/String;
    //   73: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: invokevirtual 292	com/tencent/mm/m/c:d	(Ljava/io/File;Ljava/io/File;)Z
    //   79: istore 4
    //   81: iload 4
    //   83: ifeq +8 -> 91
    //   86: aload_1
    //   87: invokevirtual 295	java/io/File:delete	()Z
    //   90: pop
    //   91: iload_3
    //   92: iconst_1
    //   93: iadd
    //   94: istore_3
    //   95: goto -51 -> 44
    //   98: iload 4
    //   100: ireturn
    //   101: new 119	java/io/FileInputStream
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore 6
    //   111: new 297	java/io/FileOutputStream
    //   114: dup
    //   115: aload_2
    //   116: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   119: astore 8
    //   121: aload 8
    //   123: astore 7
    //   125: aload 6
    //   127: astore_2
    //   128: sipush 1024
    //   131: newarray byte
    //   133: astore 9
    //   135: aload 8
    //   137: astore 7
    //   139: aload 6
    //   141: astore_2
    //   142: aload 6
    //   144: aload 9
    //   146: invokevirtual 302	java/io/InputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: iconst_m1
    //   152: if_icmpeq +99 -> 251
    //   155: aload 8
    //   157: astore 7
    //   159: aload 6
    //   161: astore_2
    //   162: aload 8
    //   164: aload 9
    //   166: iconst_0
    //   167: iload_3
    //   168: invokevirtual 308	java/io/OutputStream:write	([BII)V
    //   171: goto -36 -> 135
    //   174: astore_2
    //   175: aload 8
    //   177: astore_1
    //   178: aload_2
    //   179: astore 8
    //   181: aload_1
    //   182: astore 7
    //   184: aload 6
    //   186: astore_2
    //   187: ldc 66
    //   189: ldc 90
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload 8
    //   199: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 6
    //   208: ifnull +8 -> 216
    //   211: aload 6
    //   213: invokevirtual 148	java/io/InputStream:close	()V
    //   216: iload 5
    //   218: istore 4
    //   220: aload_1
    //   221: ifnull -123 -> 98
    //   224: aload_1
    //   225: invokevirtual 309	java/io/OutputStream:close	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_1
    //   231: ldc 66
    //   233: ldc 90
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   245: aastore
    //   246: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: iconst_0
    //   250: ireturn
    //   251: aload 8
    //   253: astore 7
    //   255: aload 6
    //   257: astore_2
    //   258: aload 8
    //   260: invokevirtual 312	java/io/OutputStream:flush	()V
    //   263: aload 8
    //   265: astore 7
    //   267: aload 6
    //   269: astore_2
    //   270: aload_1
    //   271: invokevirtual 295	java/io/File:delete	()Z
    //   274: pop
    //   275: aload 6
    //   277: invokevirtual 148	java/io/InputStream:close	()V
    //   280: aload 8
    //   282: invokevirtual 309	java/io/OutputStream:close	()V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore_1
    //   288: ldc 66
    //   290: ldc 90
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_1
    //   299: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: goto -26 -> 280
    //   309: astore_1
    //   310: ldc 66
    //   312: ldc 90
    //   314: iconst_1
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_1
    //   321: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   324: aastore
    //   325: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: goto -43 -> 285
    //   331: astore_2
    //   332: ldc 66
    //   334: ldc 90
    //   336: iconst_1
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_2
    //   343: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   346: aastore
    //   347: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: goto -134 -> 216
    //   353: astore_1
    //   354: aconst_null
    //   355: astore 7
    //   357: aconst_null
    //   358: astore_2
    //   359: aload_2
    //   360: ifnull +7 -> 367
    //   363: aload_2
    //   364: invokevirtual 148	java/io/InputStream:close	()V
    //   367: aload 7
    //   369: ifnull +8 -> 377
    //   372: aload 7
    //   374: invokevirtual 309	java/io/OutputStream:close	()V
    //   377: aload_1
    //   378: athrow
    //   379: astore_2
    //   380: ldc 66
    //   382: ldc 90
    //   384: iconst_1
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: aload_2
    //   391: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   394: aastore
    //   395: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: goto -31 -> 367
    //   401: astore_2
    //   402: ldc 66
    //   404: ldc 90
    //   406: iconst_1
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_2
    //   413: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   416: aastore
    //   417: invokestatic 98	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -43 -> 377
    //   423: astore_1
    //   424: aconst_null
    //   425: astore 7
    //   427: aload 6
    //   429: astore_2
    //   430: goto -71 -> 359
    //   433: astore_1
    //   434: goto -75 -> 359
    //   437: astore 8
    //   439: aconst_null
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 6
    //   444: goto -263 -> 181
    //   447: astore 8
    //   449: aconst_null
    //   450: astore_1
    //   451: goto -270 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	c
    //   0	454	1	paramFile1	java.io.File
    //   0	454	2	paramFile2	java.io.File
    //   40	128	3	i	int
    //   5	214	4	bool1	boolean
    //   1	216	5	bool2	boolean
    //   37	406	6	localObject1	Object
    //   55	371	7	localObject2	Object
    //   119	162	8	localObject3	Object
    //   437	1	8	localException1	Exception
    //   447	1	8	localException2	Exception
    //   133	32	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   128	135	174	java/lang/Exception
    //   142	150	174	java/lang/Exception
    //   162	171	174	java/lang/Exception
    //   258	263	174	java/lang/Exception
    //   270	275	174	java/lang/Exception
    //   224	228	230	java/io/IOException
    //   275	280	287	java/io/IOException
    //   280	285	309	java/io/IOException
    //   211	216	331	java/io/IOException
    //   101	111	353	finally
    //   363	367	379	java/io/IOException
    //   372	377	401	java/io/IOException
    //   111	121	423	finally
    //   128	135	433	finally
    //   142	150	433	finally
    //   162	171	433	finally
    //   187	206	433	finally
    //   258	263	433	finally
    //   270	275	433	finally
    //   101	111	437	java/lang/Exception
    //   111	121	447	java/lang/Exception
  }
  
  public final String getMailAppEnterUlAndroid()
  {
    return H("MailApp", "MailAppEnterMailAppUrlAndroid");
  }
  
  public final void init()
  {
    int i = 0;
    while (i < d.dAk.length)
    {
      load(d.dAk[i]);
      i += 1;
    }
  }
  
  public final void m(int paramInt, String paramString)
  {
    d locald = new d(paramInt);
    locald.dAm = bn.s(paramString, "ConfigList");
    if (locald.dAm.containsKey(".ConfigList.$version")) {
      locald.version = Integer.valueOf((String)locald.dAm.get(".ConfigList.$version")).intValue();
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = new StringBuilder(".ConfigList.Config");
      String str;
      int j;
      label182:
      Object localObject2;
      label211:
      Object localObject3;
      label251:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject1 = paramString;
        if (locald.dAm.get((String)localObject1 + ".$name") == null) {
          break;
        }
        str = (String)locald.dAm.get((String)localObject1 + ".$name");
        if (str.equalsIgnoreCase("JDWebViewMenu")) {
          break label529;
        }
        j = 0;
        localObject2 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label502;
        }
        paramString = "";
        localObject2 = paramString;
        localObject3 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label511;
        }
        paramString = "";
        localObject3 = paramString + ".$key";
        localStringBuilder = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label520;
        }
      }
      label520:
      for (paramString = "";; paramString = Integer.valueOf(j))
      {
        paramString = paramString + ".$lang";
        if (!locald.dAm.containsKey(localObject2)) {
          break label529;
        }
        localObject3 = (String)locald.dAm.get(localObject3);
        localObject2 = (String)locald.dAm.get(localObject2);
        paramString = (String)locald.dAm.get(paramString);
        y.d("MicroMsg.ConfigListInfo", "itemKey " + (String)localObject3 + " itemValue " + (String)localObject2 + " itemLang " + paramString);
        if ((paramString == null) || (d.fh(paramString)))
        {
          if (!locald.dAl.containsKey(str)) {
            locald.dAl.put(str, new HashMap());
          }
          ((HashMap)locald.dAl.get(str)).put(localObject3, localObject2);
        }
        j += 1;
        break label182;
        paramString = Integer.valueOf(i);
        break;
        label502:
        paramString = Integer.valueOf(j);
        break label211;
        label511:
        paramString = Integer.valueOf(j);
        break label251;
      }
      label529:
      i += 1;
    }
    this.dAi.put(Integer.valueOf(paramInt).intValue(), locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.c
 * JD-Core Version:    0.7.0.1
 */