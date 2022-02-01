package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig
{
  public static final String TAG = "TbsBaseConfig";
  Map<String, String> a;
  private Context b;
  
  private static File a(Context paramContext, String paramString)
  {
    p.a();
    paramContext = p.t(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void clear()
  {
    this.a.clear();
    commit();
  }
  
  public void commit()
  {
    try
    {
      writeTbsDownloadInfo();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract String getConfigFileName();
  
  public void init(Context paramContext)
  {
    this.a = new HashMap();
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    refreshSyncMap(paramContext);
  }
  
  /* Error */
  public void refreshSyncMap(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   6: aload_0
    //   7: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   10: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +31 -> 46
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 86	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   38: goto -8 -> 30
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: aload_0
    //   47: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   50: invokeinterface 52 1 0
    //   55: new 90	java/io/BufferedInputStream
    //   58: dup
    //   59: new 92	java/io/FileInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: new 100	java/util/Properties
    //   76: dup
    //   77: invokespecial 101	java/util/Properties:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual 104	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 108	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   94: invokeinterface 114 1 0
    //   99: astore 4
    //   101: aload_2
    //   102: astore_1
    //   103: aload 4
    //   105: invokeinterface 119 1 0
    //   110: ifeq +66 -> 176
    //   113: aload_2
    //   114: astore_1
    //   115: aload 4
    //   117: invokeinterface 123 1 0
    //   122: checkcast 125	java/lang/String
    //   125: astore 5
    //   127: aload_2
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   133: aload 5
    //   135: aload_3
    //   136: aload 5
    //   138: invokevirtual 129	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokeinterface 133 3 0
    //   146: pop
    //   147: goto -46 -> 101
    //   150: astore_3
    //   151: aload_2
    //   152: astore_1
    //   153: aload_3
    //   154: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   157: aload_2
    //   158: ifnull -128 -> 30
    //   161: aload_2
    //   162: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   165: goto -135 -> 30
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   173: goto -143 -> 30
    //   176: aload_2
    //   177: ifnull -147 -> 30
    //   180: aload_2
    //   181: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   184: goto -154 -> 30
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   192: goto -162 -> 30
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   213: goto -7 -> 206
    //   216: astore_2
    //   217: goto -19 -> 198
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -72 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	TbsBaseConfig
    //   0	226	1	paramContext	Context
    //   70	111	2	localBufferedInputStream	java.io.BufferedInputStream
    //   195	12	2	localObject1	Object
    //   216	1	2	localObject2	Object
    //   222	1	2	localObject3	Object
    //   80	56	3	localProperties	java.util.Properties
    //   150	4	3	localThrowable1	java.lang.Throwable
    //   220	1	3	localThrowable2	java.lang.Throwable
    //   99	17	4	localIterator	java.util.Iterator
    //   125	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   22	30	33	java/lang/Exception
    //   22	30	41	finally
    //   34	38	41	finally
    //   161	165	41	finally
    //   169	173	41	finally
    //   180	184	41	finally
    //   188	192	41	finally
    //   202	206	41	finally
    //   206	208	41	finally
    //   209	213	41	finally
    //   73	81	150	java/lang/Throwable
    //   83	88	150	java/lang/Throwable
    //   90	101	150	java/lang/Throwable
    //   103	113	150	java/lang/Throwable
    //   115	127	150	java/lang/Throwable
    //   129	147	150	java/lang/Throwable
    //   161	165	168	java/lang/Exception
    //   180	184	187	java/lang/Exception
    //   2	14	195	finally
    //   46	71	195	finally
    //   202	206	208	java/lang/Exception
    //   73	81	216	finally
    //   83	88	216	finally
    //   90	101	216	finally
    //   103	113	216	finally
    //   115	127	216	finally
    //   129	147	216	finally
    //   153	157	216	finally
    //   2	14	220	java/lang/Throwable
    //   46	71	220	java/lang/Throwable
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: ldc 8
    //   9: ldc 139
    //   11: invokestatic 145	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   18: aload_0
    //   19: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   22: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +51 -> 80
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 86	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 86	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   77: goto -21 -> 56
    //   80: new 90	java/io/BufferedInputStream
    //   83: dup
    //   84: new 92	java/io/FileInputStream
    //   87: dup
    //   88: aload 6
    //   90: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore_2
    //   97: new 100	java/util/Properties
    //   100: dup
    //   101: invokespecial 101	java/util/Properties:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_2
    //   109: invokevirtual 104	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: aload 5
    //   114: invokevirtual 146	java/util/Properties:clear	()V
    //   117: aload_0
    //   118: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   121: invokeinterface 149 1 0
    //   126: invokeinterface 114 1 0
    //   131: astore 7
    //   133: aload 7
    //   135: invokeinterface 119 1 0
    //   140: ifeq +128 -> 268
    //   143: aload 7
    //   145: invokeinterface 123 1 0
    //   150: checkcast 125	java/lang/String
    //   153: astore 8
    //   155: aload_0
    //   156: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   159: aload 8
    //   161: invokeinterface 153 2 0
    //   166: astore_1
    //   167: aload 5
    //   169: aload 8
    //   171: new 155	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   178: ldc 158
    //   180: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 172	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   193: pop
    //   194: ldc 8
    //   196: new 155	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   203: ldc 174
    //   205: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 8
    //   210: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 176
    //   215: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 145	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -95 -> 133
    //   231: astore_3
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: astore_2
    //   237: aload_3
    //   238: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   249: aload_2
    //   250: ifnull -194 -> 56
    //   253: aload_2
    //   254: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   257: goto -201 -> 56
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   265: goto -209 -> 56
    //   268: aload_0
    //   269: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   272: invokeinterface 52 1 0
    //   277: new 178	java/io/BufferedOutputStream
    //   280: dup
    //   281: new 181	java/io/FileOutputStream
    //   284: dup
    //   285: aload 6
    //   287: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   290: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   293: astore_1
    //   294: aload 5
    //   296: aload_1
    //   297: aconst_null
    //   298: invokevirtual 189	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   309: aload_1
    //   310: ifnull -254 -> 56
    //   313: aload_1
    //   314: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   317: goto -261 -> 56
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   325: goto -269 -> 56
    //   328: astore_2
    //   329: aload_2
    //   330: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   333: goto -24 -> 309
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   341: goto -92 -> 249
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_2
    //   348: ifnull +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   363: aload_1
    //   364: athrow
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   370: goto -15 -> 355
    //   373: astore_2
    //   374: aload_2
    //   375: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   378: goto -15 -> 363
    //   381: astore_1
    //   382: goto -35 -> 347
    //   385: astore 4
    //   387: aload_1
    //   388: astore_3
    //   389: aload 4
    //   391: astore_1
    //   392: goto -45 -> 347
    //   395: astore_3
    //   396: aload_1
    //   397: astore 4
    //   399: aload_3
    //   400: astore_1
    //   401: aload_2
    //   402: astore_3
    //   403: aload 4
    //   405: astore_2
    //   406: goto -59 -> 347
    //   409: astore_3
    //   410: aconst_null
    //   411: astore_1
    //   412: aload 4
    //   414: astore_2
    //   415: goto -178 -> 237
    //   418: astore_3
    //   419: aload_2
    //   420: astore 4
    //   422: aload_1
    //   423: astore_2
    //   424: aload 4
    //   426: astore_1
    //   427: goto -190 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	TbsBaseConfig
    //   59	2	1	localException1	java.lang.Exception
    //   67	4	1	localObject1	Object
    //   72	2	1	localException2	java.lang.Exception
    //   166	80	1	localObject2	Object
    //   260	2	1	localException3	java.lang.Exception
    //   293	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   320	2	1	localException4	java.lang.Exception
    //   336	2	1	localException5	java.lang.Exception
    //   344	20	1	localObject3	Object
    //   381	7	1	localObject4	Object
    //   391	36	1	localObject5	Object
    //   96	210	2	localObject6	Object
    //   328	2	2	localException6	java.lang.Exception
    //   346	6	2	localObject7	Object
    //   365	2	2	localException7	java.lang.Exception
    //   373	29	2	localException8	java.lang.Exception
    //   405	19	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   231	129	3	localThrowable1	java.lang.Throwable
    //   388	1	3	localObject10	Object
    //   395	5	3	localObject11	Object
    //   402	1	3	localObject12	Object
    //   409	1	3	localThrowable2	java.lang.Throwable
    //   418	1	3	localThrowable3	java.lang.Throwable
    //   3	232	4	localObject13	Object
    //   385	5	4	localObject14	Object
    //   397	28	4	localObject15	Object
    //   104	191	5	localProperties	java.util.Properties
    //   25	261	6	localFile	File
    //   131	13	7	localIterator	java.util.Iterator
    //   153	56	8	str	String
    // Exception table:
    //   from	to	target	type
    //   36	44	59	java/lang/Exception
    //   7	14	67	finally
    //   36	44	67	finally
    //   48	56	67	finally
    //   60	64	67	finally
    //   73	77	67	finally
    //   245	249	67	finally
    //   253	257	67	finally
    //   261	265	67	finally
    //   305	309	67	finally
    //   313	317	67	finally
    //   321	325	67	finally
    //   329	333	67	finally
    //   337	341	67	finally
    //   351	355	67	finally
    //   359	363	67	finally
    //   363	365	67	finally
    //   366	370	67	finally
    //   374	378	67	finally
    //   48	56	72	java/lang/Exception
    //   97	133	231	java/lang/Throwable
    //   133	228	231	java/lang/Throwable
    //   268	294	231	java/lang/Throwable
    //   253	257	260	java/lang/Exception
    //   313	317	320	java/lang/Exception
    //   305	309	328	java/lang/Exception
    //   245	249	336	java/lang/Exception
    //   14	27	344	finally
    //   80	97	344	finally
    //   351	355	365	java/lang/Exception
    //   359	363	373	java/lang/Exception
    //   97	133	381	finally
    //   133	228	381	finally
    //   268	294	381	finally
    //   294	301	385	finally
    //   237	241	395	finally
    //   14	27	409	java/lang/Throwable
    //   80	97	409	java/lang/Throwable
    //   294	301	418	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */