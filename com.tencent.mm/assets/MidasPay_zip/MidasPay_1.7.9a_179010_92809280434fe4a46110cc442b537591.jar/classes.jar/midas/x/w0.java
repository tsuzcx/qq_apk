package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class w0
{
  public Context a = null;
  public boolean b = false;
  public ArrayList<q0> c = null;
  public ArrayList<q0> d = null;
  public ArrayList<String> e = new ArrayList();
  public ArrayList<String> f = new ArrayList();
  public s0 g = null;
  
  public w0(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public w0(Context paramContext, s0 params0)
  {
    this.a = paramContext;
    this.g = params0;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    d6 locald6 = new d6();
    if (("true".equals(locald6.a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex"))) && (APAppDataInterface.singleton().l()))
    {
      APLog.i("APMidasDownLoad", "processUpdateDex is new process need release");
      APPluginUtils.release();
      APPluginUtils.updateLibExtendNum();
      locald6.a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex", "false");
    }
  }
  
  public final String a(File paramFile, String paramString)
  {
    try
    {
      paramFile = paramFile.listFiles();
      int j = 0;
      int i = 0;
      while (i < paramFile.length)
      {
        String str = paramFile[i].getName();
        if (paramString.equals(str.substring(0, str.length() - 4)))
        {
          str = paramFile[i];
          while (j < this.c.size())
          {
            if ((paramString.equals(((q0)this.c.get(j)).a)) && (new v0(this.a).a(str.getAbsolutePath()).compareToIgnoreCase(((q0)this.c.get(j)).h) == 0))
            {
              paramFile = paramFile[i].getName();
              return paramFile;
            }
            j += 1;
          }
        }
        i += 1;
      }
      return "";
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 166
    //   2: astore 8
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 10
    //   13: invokestatic 173	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: ldc 175
    //   18: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifne +6 -> 27
    //   24: ldc 166
    //   26: areturn
    //   27: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   30: astore_3
    //   31: new 181	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 188
    //   54: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: new 120	java/io/File
    //   61: dup
    //   62: aload 4
    //   64: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 5
    //   72: aload 5
    //   74: invokevirtual 197	java/io/File:exists	()Z
    //   77: ifne +223 -> 300
    //   80: aload_0
    //   81: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   84: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   87: invokevirtual 201	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   90: ldc 166
    //   92: invokevirtual 207	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore 6
    //   97: ldc 166
    //   99: astore_3
    //   100: iconst_0
    //   101: istore_2
    //   102: iload_2
    //   103: aload 6
    //   105: arraylength
    //   106: if_icmpge +42 -> 148
    //   109: aload_3
    //   110: astore 4
    //   112: aload 6
    //   114: iload_2
    //   115: aaload
    //   116: ldc 209
    //   118: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   121: ifeq +788 -> 909
    //   124: aload_3
    //   125: astore 4
    //   127: aload 6
    //   129: iload_2
    //   130: aaload
    //   131: ldc 215
    //   133: invokevirtual 218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   136: ifeq +773 -> 909
    //   139: aload 6
    //   141: iload_2
    //   142: aaload
    //   143: astore 4
    //   145: goto +764 -> 909
    //   148: aload_0
    //   149: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   152: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   155: invokevirtual 201	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   158: aload_3
    //   159: invokevirtual 222	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   162: astore_3
    //   163: new 224	java/io/BufferedInputStream
    //   166: dup
    //   167: aload_3
    //   168: invokespecial 227	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: astore 4
    //   173: new 229	java/io/FileOutputStream
    //   176: dup
    //   177: aload 5
    //   179: invokespecial 232	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   182: astore 5
    //   184: new 234	java/io/BufferedOutputStream
    //   187: dup
    //   188: aload 5
    //   190: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   193: astore 6
    //   195: sipush 1024
    //   198: newarray byte
    //   200: astore 7
    //   202: aload 4
    //   204: aload 7
    //   206: invokevirtual 241	java/io/BufferedInputStream:read	([B)I
    //   209: istore_2
    //   210: iload_2
    //   211: iconst_m1
    //   212: if_icmpeq +15 -> 227
    //   215: aload 6
    //   217: aload 7
    //   219: iconst_0
    //   220: iload_2
    //   221: invokevirtual 245	java/io/BufferedOutputStream:write	([BII)V
    //   224: goto -22 -> 202
    //   227: aload 6
    //   229: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   232: goto +87 -> 319
    //   235: astore_1
    //   236: goto +607 -> 843
    //   239: astore 7
    //   241: goto +160 -> 401
    //   244: astore_1
    //   245: aload 7
    //   247: astore 6
    //   249: goto +594 -> 843
    //   252: astore 6
    //   254: goto +35 -> 289
    //   257: astore_1
    //   258: aconst_null
    //   259: astore 5
    //   261: aload 7
    //   263: astore 6
    //   265: goto +578 -> 843
    //   268: astore 6
    //   270: aconst_null
    //   271: astore 5
    //   273: goto +16 -> 289
    //   276: astore_1
    //   277: goto +96 -> 373
    //   280: astore 6
    //   282: aconst_null
    //   283: astore 4
    //   285: aload 4
    //   287: astore 5
    //   289: aload 6
    //   291: astore 7
    //   293: aload 9
    //   295: astore 6
    //   297: goto +104 -> 401
    //   300: aconst_null
    //   301: astore 6
    //   303: aload 6
    //   305: astore_3
    //   306: aload_3
    //   307: astore 5
    //   309: aload_3
    //   310: astore 4
    //   312: aload 6
    //   314: astore_3
    //   315: aload 10
    //   317: astore 6
    //   319: aload 6
    //   321: ifnull +13 -> 334
    //   324: aload 6
    //   326: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   329: aload 6
    //   331: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   334: aload 5
    //   336: ifnull +13 -> 349
    //   339: aload 5
    //   341: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   344: aload 5
    //   346: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   349: aload 4
    //   351: ifnull +8 -> 359
    //   354: aload 4
    //   356: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   359: aload_3
    //   360: ifnull +104 -> 464
    //   363: aload_3
    //   364: invokevirtual 257	java/io/InputStream:close	()V
    //   367: goto +97 -> 464
    //   370: astore_1
    //   371: aconst_null
    //   372: astore_3
    //   373: aconst_null
    //   374: astore 4
    //   376: aconst_null
    //   377: astore 5
    //   379: aload 7
    //   381: astore 6
    //   383: goto +460 -> 843
    //   386: astore 7
    //   388: aconst_null
    //   389: astore_3
    //   390: aload_3
    //   391: astore 4
    //   393: aload 4
    //   395: astore 5
    //   397: aload 9
    //   399: astore 6
    //   401: aload 7
    //   403: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   406: aload 6
    //   408: ifnull +16 -> 424
    //   411: aload 6
    //   413: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   416: aload 6
    //   418: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   421: goto +3 -> 424
    //   424: aload 5
    //   426: ifnull +13 -> 439
    //   429: aload 5
    //   431: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   434: aload 5
    //   436: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   439: aload 4
    //   441: ifnull +8 -> 449
    //   444: aload 4
    //   446: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   449: aload_3
    //   450: ifnull +14 -> 464
    //   453: aload_3
    //   454: invokevirtual 257	java/io/InputStream:close	()V
    //   457: goto +7 -> 464
    //   460: aload_3
    //   461: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   464: aload 8
    //   466: astore_3
    //   467: aload_1
    //   468: ifnull +372 -> 840
    //   471: new 181	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   478: astore_3
    //   479: aload_3
    //   480: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   483: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   486: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_3
    //   491: ldc_w 263
    //   494: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: new 120	java/io/File
    //   501: dup
    //   502: aload_3
    //   503: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   509: astore 4
    //   511: new 181	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   518: astore_3
    //   519: aload_3
    //   520: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   523: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   526: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_3
    //   531: ldc_w 265
    //   534: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: new 120	java/io/File
    //   541: dup
    //   542: aload_3
    //   543: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   549: astore 5
    //   551: aload 4
    //   553: invokevirtual 197	java/io/File:exists	()Z
    //   556: ifeq +75 -> 631
    //   559: aload 4
    //   561: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   564: ifnull +67 -> 631
    //   567: aload 4
    //   569: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   572: arraylength
    //   573: ifle +58 -> 631
    //   576: aload_0
    //   577: aload 4
    //   579: aload_1
    //   580: invokevirtual 267	midas/x/w0:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   583: astore_1
    //   584: aload 8
    //   586: astore_3
    //   587: aload_1
    //   588: invokevirtual 132	java/lang/String:length	()I
    //   591: ifle +249 -> 840
    //   594: new 181	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   601: astore_3
    //   602: aload_3
    //   603: aload 4
    //   605: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   608: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_3
    //   613: ldc_w 269
    //   616: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_3
    //   621: aload_1
    //   622: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_3
    //   627: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: areturn
    //   631: aload 5
    //   633: invokevirtual 197	java/io/File:exists	()Z
    //   636: ifeq +75 -> 711
    //   639: aload 5
    //   641: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   644: ifnull +67 -> 711
    //   647: aload 5
    //   649: invokevirtual 124	java/io/File:listFiles	()[Ljava/io/File;
    //   652: arraylength
    //   653: ifle +58 -> 711
    //   656: aload_0
    //   657: aload 5
    //   659: aload_1
    //   660: invokevirtual 267	midas/x/w0:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   663: astore_1
    //   664: aload 8
    //   666: astore_3
    //   667: aload_1
    //   668: invokevirtual 132	java/lang/String:length	()I
    //   671: ifle +169 -> 840
    //   674: new 181	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   681: astore_3
    //   682: aload_3
    //   683: aload 5
    //   685: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   688: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_3
    //   693: ldc_w 269
    //   696: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload_3
    //   701: aload_1
    //   702: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_3
    //   707: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: areturn
    //   711: aload 8
    //   713: astore_3
    //   714: aload_0
    //   715: iconst_2
    //   716: invokevirtual 272	midas/x/w0:a	(I)Z
    //   719: ifeq +121 -> 840
    //   722: aload 4
    //   724: invokevirtual 197	java/io/File:exists	()Z
    //   727: ifeq +58 -> 785
    //   730: aload_0
    //   731: aload 4
    //   733: aload_1
    //   734: invokevirtual 267	midas/x/w0:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   737: astore_1
    //   738: aload 8
    //   740: astore_3
    //   741: aload_1
    //   742: invokevirtual 132	java/lang/String:length	()I
    //   745: ifle +95 -> 840
    //   748: new 181	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   755: astore_3
    //   756: aload_3
    //   757: aload 4
    //   759: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   762: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload_3
    //   767: ldc_w 269
    //   770: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload_3
    //   775: aload_1
    //   776: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload_3
    //   781: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: areturn
    //   785: aload_0
    //   786: aload 5
    //   788: aload_1
    //   789: invokevirtual 267	midas/x/w0:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore_1
    //   793: aload 8
    //   795: astore_3
    //   796: aload_1
    //   797: invokevirtual 132	java/lang/String:length	()I
    //   800: ifle +40 -> 840
    //   803: new 181	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   810: astore_3
    //   811: aload_3
    //   812: aload 5
    //   814: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   817: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload_3
    //   822: ldc_w 269
    //   825: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload_3
    //   830: aload_1
    //   831: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload_3
    //   836: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: astore_3
    //   840: aload_3
    //   841: areturn
    //   842: astore_1
    //   843: aload 6
    //   845: ifnull +16 -> 861
    //   848: aload 6
    //   850: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   853: aload 6
    //   855: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   858: goto +3 -> 861
    //   861: aload 5
    //   863: ifnull +13 -> 876
    //   866: aload 5
    //   868: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   871: aload 5
    //   873: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   876: aload 4
    //   878: ifnull +8 -> 886
    //   881: aload 4
    //   883: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   886: aload_3
    //   887: ifnull +14 -> 901
    //   890: aload_3
    //   891: invokevirtual 257	java/io/InputStream:close	()V
    //   894: goto +7 -> 901
    //   897: aload_3
    //   898: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   901: goto +5 -> 906
    //   904: aload_1
    //   905: athrow
    //   906: goto -2 -> 904
    //   909: iload_2
    //   910: iconst_1
    //   911: iadd
    //   912: istore_2
    //   913: aload 4
    //   915: astore_3
    //   916: goto -814 -> 102
    //   919: astore_3
    //   920: goto -460 -> 460
    //   923: astore_3
    //   924: goto -27 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	927	0	this	w0
    //   0	927	1	paramString	String
    //   101	812	2	i	int
    //   30	886	3	localObject1	Object
    //   919	1	3	localIOException1	java.io.IOException
    //   923	1	3	localIOException2	java.io.IOException
    //   38	876	4	localObject2	Object
    //   70	802	5	localObject3	Object
    //   95	153	6	localObject4	Object
    //   252	1	6	localException1	Exception
    //   263	1	6	localException2	Exception
    //   268	1	6	localException3	Exception
    //   280	10	6	localException4	Exception
    //   295	559	6	localObject5	Object
    //   8	210	7	arrayOfByte	byte[]
    //   239	23	7	localException5	Exception
    //   291	89	7	localObject6	Object
    //   386	16	7	localException6	Exception
    //   2	792	8	str	String
    //   5	393	9	localObject7	Object
    //   11	305	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   195	202	235	finally
    //   202	210	235	finally
    //   215	224	235	finally
    //   227	232	235	finally
    //   195	202	239	java/lang/Exception
    //   202	210	239	java/lang/Exception
    //   215	224	239	java/lang/Exception
    //   227	232	239	java/lang/Exception
    //   184	195	244	finally
    //   184	195	252	java/lang/Exception
    //   173	184	257	finally
    //   173	184	268	java/lang/Exception
    //   163	173	276	finally
    //   163	173	280	java/lang/Exception
    //   13	24	370	finally
    //   27	97	370	finally
    //   102	109	370	finally
    //   112	124	370	finally
    //   127	139	370	finally
    //   148	163	370	finally
    //   13	24	386	java/lang/Exception
    //   27	97	386	java/lang/Exception
    //   102	109	386	java/lang/Exception
    //   112	124	386	java/lang/Exception
    //   127	139	386	java/lang/Exception
    //   148	163	386	java/lang/Exception
    //   401	406	842	finally
    //   324	334	919	java/io/IOException
    //   339	349	919	java/io/IOException
    //   354	359	919	java/io/IOException
    //   363	367	919	java/io/IOException
    //   411	421	919	java/io/IOException
    //   429	439	919	java/io/IOException
    //   444	449	919	java/io/IOException
    //   453	457	919	java/io/IOException
    //   848	858	923	java/io/IOException
    //   866	876	923	java/io/IOException
    //   881	886	923	java/io/IOException
    //   890	894	923	java/io/IOException
  }
  
  public void a(Context paramContext)
  {
    new d6().a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex", "true");
    if (a.r().i())
    {
      APLog.i("APMidasDownLoad", "updateDataDex is calling return");
      return;
    }
    if (APAppDataInterface.singleton().l())
    {
      APLog.i("APMidasDownLoad", "updateDataDex is new process ");
      APPluginUtils.release();
      APPluginUtils.updateLibExtendNum();
      return;
    }
    APLog.i("APMidasDownLoad", "updateDataDex is not new process");
    APPluginUtils.unInstallPlugin(paramContext);
    com.tencent.midas.control.APMidasPayHelper.initState = -1;
  }
  
  public final void a(File paramFile)
  {
    label211:
    label212:
    label217:
    label222:
    label233:
    for (;;)
    {
      int k;
      try
      {
        localArrayList = r0.p().b();
        if (localArrayList == null) {
          break label211;
        }
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
          break label211;
        }
        j = 0;
        i = 0;
        if (j >= arrayOfFile.length) {
          break label211;
        }
        String str2 = arrayOfFile[j].getName();
        k = 0;
        if (k >= localArrayList.size()) {
          break label233;
        }
        if (str2.endsWith(".diff"))
        {
          paramFile = str2.split("\\.");
          i = ((q0)localArrayList.get(k)).j;
          if (paramFile.length <= 1) {
            break label212;
          }
          if (!paramFile[1].equals(String.valueOf(i))) {
            break label222;
          }
          break label217;
        }
        String str1 = ((q0)localArrayList.get(k)).a;
        paramFile = str1;
        if (!str1.endsWith(".apk"))
        {
          paramFile = new StringBuilder();
          paramFile.append(str1);
          paramFile.append(".apk");
          paramFile = paramFile.toString();
        }
        if (!str2.equals(paramFile)) {
          break label222;
        }
      }
      catch (Exception paramFile)
      {
        ArrayList localArrayList;
        int j;
        paramFile.printStackTrace();
      }
      if (i == 0)
      {
        a(localArrayList);
        return;
      }
      j += 1;
      continue;
      return;
      int i = 0;
      continue;
      i = 1;
      continue;
      k += 1;
      i = 0;
    }
  }
  
  /* Error */
  public final void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 181	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 325
    //   12: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc_w 327
    //   26: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc_w 332
    //   39: aload_3
    //   40: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 334	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aconst_null
    //   47: astore 8
    //   49: aconst_null
    //   50: astore 7
    //   52: iload_2
    //   53: iconst_1
    //   54: if_icmpne +107 -> 161
    //   57: new 120	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   65: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   68: ldc_w 336
    //   71: iconst_0
    //   72: invokevirtual 340	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   75: aload_1
    //   76: invokespecial 343	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: astore_3
    //   80: new 181	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload 4
    //   91: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   94: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: ldc_w 345
    //   106: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: new 120	java/io/File
    //   113: dup
    //   114: aload 4
    //   116: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: goto +192 -> 316
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_3
    //   131: astore 5
    //   133: aload 5
    //   135: astore 4
    //   137: aload 8
    //   139: astore 6
    //   141: goto +587 -> 728
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: astore 5
    //   150: aload 5
    //   152: astore 4
    //   154: aload 7
    //   156: astore 6
    //   158: goto +503 -> 661
    //   161: iload_2
    //   162: iconst_2
    //   163: if_icmpne +98 -> 261
    //   166: new 181	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   173: astore_3
    //   174: aload_3
    //   175: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   178: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   181: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_3
    //   186: ldc_w 345
    //   189: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore_3
    //   198: new 181	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   205: astore 4
    //   207: aload 4
    //   209: aload_3
    //   210: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 4
    //   216: aload_1
    //   217: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: new 120	java/io/File
    //   224: dup
    //   225: aload 4
    //   227: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore_3
    //   234: aload_0
    //   235: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   238: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   241: pop
    //   242: aload_0
    //   243: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   246: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   249: ldc_w 347
    //   252: iconst_0
    //   253: invokevirtual 340	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   256: astore 4
    //   258: goto +58 -> 316
    //   261: iload_2
    //   262: iconst_3
    //   263: if_icmpne +530 -> 793
    //   266: new 120	java/io/File
    //   269: dup
    //   270: aload_0
    //   271: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   274: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   277: ldc_w 336
    //   280: iconst_0
    //   281: invokevirtual 340	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   284: aload_1
    //   285: invokespecial 343	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   288: astore_3
    //   289: aload_0
    //   290: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   293: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   296: pop
    //   297: aload_0
    //   298: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   301: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   304: ldc_w 347
    //   307: iconst_0
    //   308: invokevirtual 340	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   311: astore 4
    //   313: goto +3 -> 316
    //   316: aload 4
    //   318: ifnull +17 -> 335
    //   321: aload 4
    //   323: invokevirtual 197	java/io/File:exists	()Z
    //   326: ifne +9 -> 335
    //   329: aload 4
    //   331: invokevirtual 350	java/io/File:mkdirs	()Z
    //   334: pop
    //   335: new 352	java/io/FileInputStream
    //   338: dup
    //   339: aload_3
    //   340: invokespecial 353	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   343: astore 5
    //   345: new 224	java/io/BufferedInputStream
    //   348: dup
    //   349: aload 5
    //   351: invokespecial 227	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   354: astore 6
    //   356: new 181	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   363: astore 9
    //   365: aload 9
    //   367: getstatic 356	java/io/File:separator	Ljava/lang/String;
    //   370: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 9
    //   376: aload_1
    //   377: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: new 120	java/io/File
    //   384: dup
    //   385: aload 4
    //   387: aload 9
    //   389: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokespecial 343	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   395: astore_1
    //   396: new 181	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   403: astore 4
    //   405: aload 4
    //   407: ldc_w 358
    //   410: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 4
    //   416: aload_3
    //   417: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: ldc_w 332
    //   424: aload 4
    //   426: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 334	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: new 181	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   439: astore_3
    //   440: aload_3
    //   441: ldc_w 363
    //   444: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_3
    //   449: aload_1
    //   450: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: ldc_w 332
    //   457: aload_3
    //   458: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 334	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: new 229	java/io/FileOutputStream
    //   467: dup
    //   468: aload_1
    //   469: invokespecial 232	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   472: astore_1
    //   473: new 234	java/io/BufferedOutputStream
    //   476: dup
    //   477: aload_1
    //   478: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   481: astore_3
    //   482: sipush 1024
    //   485: newarray byte
    //   487: astore 4
    //   489: aload 6
    //   491: aload 4
    //   493: invokevirtual 241	java/io/BufferedInputStream:read	([B)I
    //   496: istore_2
    //   497: iload_2
    //   498: iconst_m1
    //   499: if_icmpeq +14 -> 513
    //   502: aload_3
    //   503: aload 4
    //   505: iconst_0
    //   506: iload_2
    //   507: invokevirtual 245	java/io/BufferedOutputStream:write	([BII)V
    //   510: goto -21 -> 489
    //   513: aload_3
    //   514: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   517: aload_3
    //   518: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   521: aload_3
    //   522: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   525: aload_1
    //   526: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   529: aload_1
    //   530: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   533: aload 6
    //   535: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   538: aload 5
    //   540: invokevirtual 364	java/io/FileInputStream:close	()V
    //   543: return
    //   544: astore 4
    //   546: aload_3
    //   547: astore 7
    //   549: aload_1
    //   550: astore_3
    //   551: aload 4
    //   553: astore_1
    //   554: aload 6
    //   556: astore 4
    //   558: aload 7
    //   560: astore 6
    //   562: goto +166 -> 728
    //   565: astore 7
    //   567: aload 6
    //   569: astore 4
    //   571: aload_3
    //   572: astore 6
    //   574: aload 7
    //   576: astore_3
    //   577: goto +84 -> 661
    //   580: astore 4
    //   582: aload_1
    //   583: astore_3
    //   584: aload 4
    //   586: astore_1
    //   587: aload 6
    //   589: astore 4
    //   591: aload 8
    //   593: astore 6
    //   595: goto +133 -> 728
    //   598: astore_3
    //   599: aload 6
    //   601: astore 4
    //   603: aload 7
    //   605: astore 6
    //   607: goto +54 -> 661
    //   610: astore_1
    //   611: aconst_null
    //   612: astore_3
    //   613: aload 6
    //   615: astore 4
    //   617: aload 8
    //   619: astore 6
    //   621: goto +107 -> 728
    //   624: astore_3
    //   625: aconst_null
    //   626: astore_1
    //   627: aload 6
    //   629: astore 4
    //   631: aload 7
    //   633: astore 6
    //   635: goto +26 -> 661
    //   638: astore_1
    //   639: aconst_null
    //   640: astore_3
    //   641: aload_3
    //   642: astore 4
    //   644: aload 8
    //   646: astore 6
    //   648: goto +80 -> 728
    //   651: astore_3
    //   652: aconst_null
    //   653: astore_1
    //   654: aload_1
    //   655: astore 4
    //   657: aload 7
    //   659: astore 6
    //   661: aload_3
    //   662: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   665: aload 6
    //   667: ifnull +16 -> 683
    //   670: aload 6
    //   672: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   675: aload 6
    //   677: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   680: goto +3 -> 683
    //   683: aload_1
    //   684: ifnull +11 -> 695
    //   687: aload_1
    //   688: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   691: aload_1
    //   692: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   695: aload 4
    //   697: ifnull +8 -> 705
    //   700: aload 4
    //   702: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   705: aload 5
    //   707: ifnull +13 -> 720
    //   710: aload 5
    //   712: invokevirtual 364	java/io/FileInputStream:close	()V
    //   715: return
    //   716: aload_1
    //   717: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   720: return
    //   721: astore 7
    //   723: aload_1
    //   724: astore_3
    //   725: aload 7
    //   727: astore_1
    //   728: aload 6
    //   730: ifnull +16 -> 746
    //   733: aload 6
    //   735: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   738: aload 6
    //   740: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   743: goto +3 -> 746
    //   746: aload_3
    //   747: ifnull +11 -> 758
    //   750: aload_3
    //   751: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   754: aload_3
    //   755: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   758: aload 4
    //   760: ifnull +8 -> 768
    //   763: aload 4
    //   765: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   768: aload 5
    //   770: ifnull +15 -> 785
    //   773: aload 5
    //   775: invokevirtual 364	java/io/FileInputStream:close	()V
    //   778: goto +7 -> 785
    //   781: aload_3
    //   782: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   785: goto +5 -> 790
    //   788: aload_1
    //   789: athrow
    //   790: goto -2 -> 788
    //   793: aconst_null
    //   794: astore 4
    //   796: aload 4
    //   798: astore_3
    //   799: goto -483 -> 316
    //   802: astore_1
    //   803: goto -87 -> 716
    //   806: astore_3
    //   807: goto -26 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	810	0	this	w0
    //   0	810	1	paramString	String
    //   0	810	2	paramInt	int
    //   7	124	3	localObject1	Object
    //   144	1	3	localException1	Exception
    //   173	411	3	localObject2	Object
    //   598	1	3	localException2	Exception
    //   612	1	3	localObject3	Object
    //   624	1	3	localException3	Exception
    //   640	2	3	localObject4	Object
    //   651	11	3	localException4	Exception
    //   724	75	3	localObject5	Object
    //   806	1	3	localIOException	java.io.IOException
    //   87	417	4	localObject6	Object
    //   544	8	4	localObject7	Object
    //   556	14	4	localObject8	Object
    //   580	5	4	localObject9	Object
    //   589	208	4	localObject10	Object
    //   131	643	5	localObject11	Object
    //   139	600	6	localObject12	Object
    //   50	509	7	localObject13	Object
    //   565	93	7	localException5	Exception
    //   721	5	7	localObject14	Object
    //   47	598	8	localObject15	Object
    //   363	25	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	124	127	finally
    //   166	258	127	finally
    //   266	313	127	finally
    //   321	335	127	finally
    //   335	345	127	finally
    //   57	124	144	java/lang/Exception
    //   166	258	144	java/lang/Exception
    //   266	313	144	java/lang/Exception
    //   321	335	144	java/lang/Exception
    //   335	345	144	java/lang/Exception
    //   482	489	544	finally
    //   489	497	544	finally
    //   502	510	544	finally
    //   513	517	544	finally
    //   482	489	565	java/lang/Exception
    //   489	497	565	java/lang/Exception
    //   502	510	565	java/lang/Exception
    //   513	517	565	java/lang/Exception
    //   473	482	580	finally
    //   473	482	598	java/lang/Exception
    //   356	473	610	finally
    //   356	473	624	java/lang/Exception
    //   345	356	638	finally
    //   345	356	651	java/lang/Exception
    //   661	665	721	finally
    //   517	543	802	java/io/IOException
    //   670	680	802	java/io/IOException
    //   687	695	802	java/io/IOException
    //   700	705	802	java/io/IOException
    //   710	715	802	java/io/IOException
    //   733	743	806	java/io/IOException
    //   750	758	806	java/io/IOException
    //   763	768	806	java/io/IOException
    //   773	778	806	java/io/IOException
  }
  
  public final void a(ArrayList<q0> paramArrayList)
  {
    new v0().d();
    p0 localp0 = new p0(this.a);
    int i = 0;
    while (i < paramArrayList.size())
    {
      localp0.a(((q0)paramArrayList.get(i)).d, 1);
      i += 1;
    }
    localp0.a("filetotalsize", 2);
    localp0.a();
    APLog.i("APMidasDownLoad", "resultData=断点续传时，temp区的文件是无效的");
  }
  
  public void a(ArrayList<q0> paramArrayList, int paramInt)
  {
    this.g.a(paramArrayList, paramInt, new b());
  }
  
  public final boolean a()
  {
    return new v0(this.a).f() > d();
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +68 -> 79
    //   14: new 181	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   27: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   30: invokevirtual 399	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: ldc 188
    //   43: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 28	midas/x/w0:a	Landroid/content/Context;
    //   56: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   59: invokevirtual 399	android/content/Context:getFilesDir	()Ljava/io/File;
    //   62: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: astore 4
    //   67: new 120	java/io/File
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: goto +112 -> 188
    //   79: iload_1
    //   80: iconst_2
    //   81: if_icmpne +101 -> 182
    //   84: new 181	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   91: astore_2
    //   92: aload_2
    //   93: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   96: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: ldc 188
    //   106: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: new 120	java/io/File
    //   113: dup
    //   114: aload_2
    //   115: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore_3
    //   122: new 181	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   134: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_2
    //   142: ldc_w 265
    //   145: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new 120	java/io/File
    //   152: dup
    //   153: aload_2
    //   154: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 197	java/io/File:exists	()Z
    //   165: ifne +8 -> 173
    //   168: aload_2
    //   169: invokevirtual 402	java/io/File:mkdir	()Z
    //   172: pop
    //   173: aload_2
    //   174: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   177: astore 4
    //   179: goto +9 -> 188
    //   182: ldc 166
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +12 -> 201
    //   192: aload_3
    //   193: invokevirtual 197	java/io/File:exists	()Z
    //   196: ifne +5 -> 201
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 7
    //   203: astore_2
    //   204: aload 8
    //   206: astore 5
    //   208: new 404	java/util/zip/ZipFile
    //   211: dup
    //   212: aload_3
    //   213: invokespecial 405	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   216: astore 9
    //   218: aload 7
    //   220: astore_2
    //   221: aload 8
    //   223: astore 5
    //   225: aload 9
    //   227: invokevirtual 409	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   230: astore 7
    //   232: aload 6
    //   234: astore_3
    //   235: aload_3
    //   236: astore_2
    //   237: aload_3
    //   238: astore 5
    //   240: aload 7
    //   242: invokeinterface 414 1 0
    //   247: ifeq +447 -> 694
    //   250: aload_3
    //   251: astore_2
    //   252: aload_3
    //   253: astore 5
    //   255: aload 7
    //   257: invokeinterface 418 1 0
    //   262: checkcast 420	java/util/zip/ZipEntry
    //   265: astore 8
    //   267: aload_3
    //   268: astore_2
    //   269: aload_3
    //   270: astore 5
    //   272: aload 8
    //   274: invokevirtual 421	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   277: astore 10
    //   279: aload_3
    //   280: astore_2
    //   281: aload_3
    //   282: astore 5
    //   284: new 181	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   291: astore 6
    //   293: aload_3
    //   294: astore_2
    //   295: aload_3
    //   296: astore 5
    //   298: aload 6
    //   300: ldc_w 269
    //   303: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: astore_2
    //   309: aload_3
    //   310: astore 5
    //   312: aload 6
    //   314: aload 10
    //   316: iconst_0
    //   317: bipush 8
    //   319: invokevirtual 136	java/lang/String:substring	(II)Ljava/lang/String;
    //   322: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_3
    //   327: astore_2
    //   328: aload_3
    //   329: astore 5
    //   331: aload 6
    //   333: ldc_w 269
    //   336: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: astore_2
    //   342: aload_3
    //   343: astore 5
    //   345: aload 6
    //   347: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 6
    //   352: aload_3
    //   353: astore_2
    //   354: aload_3
    //   355: astore 5
    //   357: aload 10
    //   359: aload 10
    //   361: ldc_w 269
    //   364: invokevirtual 424	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   367: iconst_1
    //   368: iadd
    //   369: aload 10
    //   371: invokevirtual 132	java/lang/String:length	()I
    //   374: invokevirtual 136	java/lang/String:substring	(II)Ljava/lang/String;
    //   377: astore 11
    //   379: aload_3
    //   380: astore_2
    //   381: aload_3
    //   382: astore 5
    //   384: new 181	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   391: astore 12
    //   393: aload_3
    //   394: astore_2
    //   395: aload_3
    //   396: astore 5
    //   398: aload 12
    //   400: aload 4
    //   402: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_3
    //   407: astore_2
    //   408: aload_3
    //   409: astore 5
    //   411: aload 12
    //   413: aload 6
    //   415: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_3
    //   420: astore_2
    //   421: aload_3
    //   422: astore 5
    //   424: aload 12
    //   426: aload 11
    //   428: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_3
    //   433: astore_2
    //   434: aload_3
    //   435: astore 5
    //   437: new 120	java/io/File
    //   440: dup
    //   441: aload 12
    //   443: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   449: astore 6
    //   451: aload_3
    //   452: astore_2
    //   453: aload_3
    //   454: astore 5
    //   456: aload 8
    //   458: invokevirtual 427	java/util/zip/ZipEntry:isDirectory	()Z
    //   461: ifeq +17 -> 478
    //   464: aload_3
    //   465: astore_2
    //   466: aload_3
    //   467: astore 5
    //   469: aload 6
    //   471: invokevirtual 402	java/io/File:mkdir	()Z
    //   474: pop
    //   475: goto -240 -> 235
    //   478: aload_3
    //   479: astore_2
    //   480: aload_3
    //   481: astore 5
    //   483: aload 10
    //   485: ldc_w 269
    //   488: invokevirtual 431	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   491: ifne +105 -> 596
    //   494: aload_3
    //   495: astore_2
    //   496: aload_3
    //   497: astore 5
    //   499: new 181	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   506: astore 6
    //   508: aload_3
    //   509: astore_2
    //   510: aload_3
    //   511: astore 5
    //   513: aload 6
    //   515: aload 4
    //   517: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_3
    //   522: astore_2
    //   523: aload_3
    //   524: astore 5
    //   526: aload 6
    //   528: ldc_w 433
    //   531: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_3
    //   536: astore_2
    //   537: aload_3
    //   538: astore 5
    //   540: new 120	java/io/File
    //   543: dup
    //   544: aload 6
    //   546: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   552: astore 6
    //   554: aload_3
    //   555: astore_2
    //   556: aload_3
    //   557: astore 5
    //   559: aload 6
    //   561: invokevirtual 197	java/io/File:exists	()Z
    //   564: ifne +14 -> 578
    //   567: aload_3
    //   568: astore_2
    //   569: aload_3
    //   570: astore 5
    //   572: aload 6
    //   574: invokevirtual 402	java/io/File:mkdir	()Z
    //   577: pop
    //   578: aload_3
    //   579: astore_2
    //   580: aload_3
    //   581: astore 5
    //   583: new 120	java/io/File
    //   586: dup
    //   587: aload 6
    //   589: aload 10
    //   591: invokespecial 343	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   594: astore 6
    //   596: aload_3
    //   597: astore_2
    //   598: aload_3
    //   599: astore 5
    //   601: new 234	java/io/BufferedOutputStream
    //   604: dup
    //   605: new 229	java/io/FileOutputStream
    //   608: dup
    //   609: aload 6
    //   611: invokespecial 232	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   614: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   617: astore_3
    //   618: sipush 1024
    //   621: newarray byte
    //   623: astore_2
    //   624: aload 9
    //   626: aload 8
    //   628: invokevirtual 437	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   631: astore 5
    //   633: aload 5
    //   635: aload_2
    //   636: invokevirtual 438	java/io/InputStream:read	([B)I
    //   639: istore_1
    //   640: iload_1
    //   641: iconst_m1
    //   642: if_icmpeq +13 -> 655
    //   645: aload_3
    //   646: aload_2
    //   647: iconst_0
    //   648: iload_1
    //   649: invokevirtual 245	java/io/BufferedOutputStream:write	([BII)V
    //   652: goto -19 -> 633
    //   655: aload 5
    //   657: invokevirtual 257	java/io/InputStream:close	()V
    //   660: goto +8 -> 668
    //   663: astore_2
    //   664: aload_2
    //   665: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   668: aload_3
    //   669: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   672: goto -437 -> 235
    //   675: astore 4
    //   677: aload_3
    //   678: astore_2
    //   679: aload 4
    //   681: astore_3
    //   682: goto +60 -> 742
    //   685: astore_2
    //   686: aload_3
    //   687: astore 5
    //   689: aload_2
    //   690: astore_3
    //   691: goto +25 -> 716
    //   694: aload_3
    //   695: ifnull +14 -> 709
    //   698: aload_3
    //   699: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   702: iconst_1
    //   703: ireturn
    //   704: astore_2
    //   705: aload_2
    //   706: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   709: iconst_1
    //   710: ireturn
    //   711: astore_3
    //   712: goto +30 -> 742
    //   715: astore_3
    //   716: aload 5
    //   718: astore_2
    //   719: aload_3
    //   720: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   723: aload 5
    //   725: ifnull +15 -> 740
    //   728: aload 5
    //   730: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   733: iconst_0
    //   734: ireturn
    //   735: astore_2
    //   736: aload_2
    //   737: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   740: iconst_0
    //   741: ireturn
    //   742: aload_2
    //   743: ifnull +15 -> 758
    //   746: aload_2
    //   747: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   750: goto +8 -> 758
    //   753: astore_2
    //   754: aload_2
    //   755: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   758: goto +5 -> 763
    //   761: aload_3
    //   762: athrow
    //   763: goto -2 -> 761
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	w0
    //   0	766	1	paramInt	int
    //   21	626	2	localObject1	Object
    //   663	2	2	localIOException1	java.io.IOException
    //   678	1	2	localObject2	Object
    //   685	5	2	localException1	Exception
    //   704	2	2	localIOException2	java.io.IOException
    //   718	1	2	localObject3	Object
    //   735	12	2	localIOException3	java.io.IOException
    //   753	2	2	localIOException4	java.io.IOException
    //   75	624	3	localObject4	Object
    //   711	1	3	localObject5	Object
    //   715	47	3	localException2	Exception
    //   65	451	4	str1	String
    //   675	5	4	localObject6	Object
    //   206	523	5	localObject7	Object
    //   7	603	6	localObject8	Object
    //   1	255	7	localEnumeration	java.util.Enumeration
    //   4	623	8	localZipEntry	java.util.zip.ZipEntry
    //   216	409	9	localZipFile	java.util.zip.ZipFile
    //   277	313	10	str2	String
    //   377	50	11	str3	String
    //   391	51	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   655	660	663	java/io/IOException
    //   618	633	675	finally
    //   633	640	675	finally
    //   645	652	675	finally
    //   655	660	675	finally
    //   664	668	675	finally
    //   668	672	675	finally
    //   618	633	685	java/lang/Exception
    //   633	640	685	java/lang/Exception
    //   645	652	685	java/lang/Exception
    //   655	660	685	java/lang/Exception
    //   664	668	685	java/lang/Exception
    //   668	672	685	java/lang/Exception
    //   698	702	704	java/io/IOException
    //   208	218	711	finally
    //   225	232	711	finally
    //   240	250	711	finally
    //   255	267	711	finally
    //   272	279	711	finally
    //   284	293	711	finally
    //   298	307	711	finally
    //   312	326	711	finally
    //   331	340	711	finally
    //   345	352	711	finally
    //   357	379	711	finally
    //   384	393	711	finally
    //   398	406	711	finally
    //   411	419	711	finally
    //   424	432	711	finally
    //   437	451	711	finally
    //   456	464	711	finally
    //   469	475	711	finally
    //   483	494	711	finally
    //   499	508	711	finally
    //   513	521	711	finally
    //   526	535	711	finally
    //   540	554	711	finally
    //   559	567	711	finally
    //   572	578	711	finally
    //   583	596	711	finally
    //   601	618	711	finally
    //   719	723	711	finally
    //   208	218	715	java/lang/Exception
    //   225	232	715	java/lang/Exception
    //   240	250	715	java/lang/Exception
    //   255	267	715	java/lang/Exception
    //   272	279	715	java/lang/Exception
    //   284	293	715	java/lang/Exception
    //   298	307	715	java/lang/Exception
    //   312	326	715	java/lang/Exception
    //   331	340	715	java/lang/Exception
    //   345	352	715	java/lang/Exception
    //   357	379	715	java/lang/Exception
    //   384	393	715	java/lang/Exception
    //   398	406	715	java/lang/Exception
    //   411	419	715	java/lang/Exception
    //   424	432	715	java/lang/Exception
    //   437	451	715	java/lang/Exception
    //   456	464	715	java/lang/Exception
    //   469	475	715	java/lang/Exception
    //   483	494	715	java/lang/Exception
    //   499	508	715	java/lang/Exception
    //   513	521	715	java/lang/Exception
    //   526	535	715	java/lang/Exception
    //   540	554	715	java/lang/Exception
    //   559	567	715	java/lang/Exception
    //   572	578	715	java/lang/Exception
    //   583	596	715	java/lang/Exception
    //   601	618	715	java/lang/Exception
    //   728	733	735	java/io/IOException
    //   746	750	753	java/io/IOException
  }
  
  public final int b(String paramString)
  {
    int i = 0;
    int j = 0;
    try
    {
      Object localObject = this.a.getApplicationContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null)
      {
        i = ((PackageInfo)localObject).versionCode;
        try
        {
          localObject = String.format("AppVersionCode %d", new Object[] { Integer.valueOf(i) });
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resultData=");
          localStringBuilder.append(paramString);
          localStringBuilder.append("/");
          localStringBuilder.append((String)localObject);
          APLog.i("APMidasDownLoad", localStringBuilder.toString());
          return i;
        }
        catch (Exception paramString) {}
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      i = j;
    }
    return i;
  }
  
  public final String b(File paramFile, String paramString)
  {
    try
    {
      File[] arrayOfFile = paramFile.listFiles();
      paramFile = "";
      int i = 0;
      while (i < arrayOfFile.length)
      {
        if (paramString.contains(arrayOfFile[i].getName().split("\\_")[0])) {
          paramFile = arrayOfFile[i].getName();
        }
        i += 1;
      }
      return paramFile;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public final void b()
  {
    File localFile = Environment.getExternalStorageDirectory();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    ((StringBuilder)localObject).append("/MidasPay.zip");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    APLog.i("APMIdasDownload", "resultData=临时的文件被删除");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    ((StringBuilder)localObject).append("/MidasTemp/");
    localFile = new File(((StringBuilder)localObject).toString());
    if (localFile.exists())
    {
      localObject = localFile.listFiles();
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].isDirectory())
        {
          File[] arrayOfFile = localObject[i].listFiles();
          int j = 0;
          while (j < arrayOfFile.length)
          {
            arrayOfFile[j].delete();
            j += 1;
          }
          localObject[i].delete();
        }
        else
        {
          localObject[i].delete();
        }
        i += 1;
      }
      localFile.delete();
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append("/MidasTemp/MidasPay/");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject2).append("/MidasTemp/");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject1).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject2).append("/MidasTemp/MidasPay/");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = b((File)localObject1, paramString);
        if ((localObject1 != null) && (((String)localObject1).length() == 0)) {
          return;
        }
        paramString = new StringBuilder();
        paramString.append((String)localObject2);
        paramString.append((String)localObject1);
        paramString = new File(paramString.toString());
      }
      else
      {
        if (!((File)localObject2).exists()) {
          break label504;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject1).append("/MidasTemp/");
        localObject3 = ((StringBuilder)localObject1).toString();
        localObject1 = b((File)localObject2, paramString);
        paramString = new StringBuilder();
        paramString.append((String)localObject3);
        paramString.append((String)localObject1);
        paramString = new File(paramString.toString());
      }
      localObject2 = new FileInputStream(paramString);
      Object localObject3 = new BufferedInputStream((InputStream)localObject2);
      paramString = "";
      if (paramInt == 1)
      {
        paramString = this.a.getApplicationContext().getDir("midaspluginsTemp", 0).getAbsolutePath();
      }
      else if (paramInt == 2)
      {
        paramString = new StringBuilder();
        paramString.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        paramString.append("/Tencent/MidasPay/");
        paramString = paramString.toString();
      }
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append(((String)localObject1).substring(0, ((String)localObject1).length() - 4));
      ((StringBuilder)localObject4).append(".apk");
      paramString = new FileOutputStream(new File(paramString, ((StringBuilder)localObject4).toString()));
      localObject1 = new BufferedOutputStream(paramString);
      localObject4 = new byte[1024];
      for (;;)
      {
        paramInt = ((BufferedInputStream)localObject3).read((byte[])localObject4);
        if (paramInt == -1) {
          break;
        }
        ((BufferedOutputStream)localObject1).write((byte[])localObject4, 0, paramInt);
      }
      ((BufferedOutputStream)localObject1).flush();
      ((BufferedOutputStream)localObject1).close();
      paramString.flush();
      paramString.close();
      ((BufferedInputStream)localObject3).close();
      ((FileInputStream)localObject2).close();
      return;
      label504:
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final int c(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVersion path name = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVersion version = ");
    ((StringBuilder)localObject).append(paramInt);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    localObject = "";
    int i = 0;
    StringBuilder localStringBuilder;
    if (paramInt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append("/Tencent/MidasPay/");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay路径不存在");
        return 0;
      }
      APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay路径存在");
      if ((((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length > 0))
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay dir is not empty!");
        paramString = a((File)localObject, paramString);
        if (paramString.equals("")) {
          return 0;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append(paramString);
        localObject = localStringBuilder.toString();
        paramString = new StringBuilder();
        paramString.append("Got path from sdcard = ");
        paramString.append((String)localObject);
        APLog.d("APMidasDownload", paramString.toString());
      }
      else
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay dir is empty!");
        return 0;
      }
    }
    else if (paramInt == 1)
    {
      localObject = this.a.getApplicationContext().getDir("midasplugins", 0);
      paramString = b((File)localObject, paramString);
      if (paramString.equals("")) {
        return 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localObject = localStringBuilder.toString();
      paramString = new StringBuilder();
      paramString.append("resultData=从data区上取版本号的路径");
      paramString.append((String)localObject);
      APLog.i("APMidasDownLoad", paramString.toString());
    }
    else if (paramInt == 0)
    {
      localObject = a(paramString);
      if (((String)localObject).equals("")) {
        return 0;
      }
      paramString = new StringBuilder();
      paramString.append("resultData=从assets区上取版本号的路径");
      paramString.append((String)localObject);
      APLog.i("APMidasDownLoad", paramString.toString());
    }
    paramString = new StringBuilder();
    paramString.append("About to get version from path = ");
    paramString.append((String)localObject);
    APLog.d("APMidasDownload", paramString.toString());
    try
    {
      paramInt = b((String)localObject);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramInt = i;
    }
    paramString = new StringBuilder();
    paramString.append("About to get version from path = ");
    paramString.append((String)localObject);
    paramString.append(" result = ");
    paramString.append(paramInt);
    APLog.d("APMidasDownload", paramString.toString());
    return paramInt;
  }
  
  public final void c()
  {
    this.c = r0.p().b();
    this.d = new ArrayList();
    try
    {
      new Thread(new a()).start();
      return;
    }
    catch (Exception localException)
    {
      r0.p().b(false);
      localException.printStackTrace();
    }
  }
  
  public final long d()
  {
    Object localObject = this.a.getApplicationContext();
    int i = 0;
    localObject = ((Context)localObject).getDir("midasplugins", 0).listFiles();
    long l = 0L;
    while (i < localObject.length)
    {
      l += localObject[i].length();
      i += 1;
    }
    return l;
  }
  
  public final void d(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateOneByOne path name = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" version = ");
    ((StringBuilder)localObject).append(paramInt);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    for (;;)
    {
      try
      {
        this.b = false;
        int m = c(paramString, 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateOneByOne dataVersion = ");
        ((StringBuilder)localObject).append(m);
        APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
        int i;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          APLog.d("APMidasDownload", "sdcard exist!");
          j = c(paramString, 2);
          i = j;
          if (a())
          {
            int k = c(paramString, 0);
            i = j;
            j = k;
            continue;
          }
        }
        else
        {
          APLog.e("APMidasDownload", "sdcard not exist!");
          i = 0;
        }
        int j = 0;
        if (m == paramInt)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOneByOne dataVersion == version == ");
          ((StringBuilder)localObject).append(m);
          APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
          if (!paramString.endsWith(".apk"))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(".apk");
            localObject = ((StringBuilder)localObject).toString();
            a((String)localObject, 3);
            if (m > i) {
              a(b(this.a.getApplicationContext().getDir("midasplugins", 0), paramString), 1);
            }
            APLog.i("APMIdasDownload", "resultData=data区的文件版本号是最新的");
            this.b = false;
          }
        }
        else
        {
          if ((i > m) && (i == paramInt))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateOneByOne sdcardVersion == version == ");
            ((StringBuilder)localObject).append(i);
            APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
            ((StringBuilder)localObject).append("/Tencent/MidasPay/");
            if (new File(((StringBuilder)localObject).toString()).exists())
            {
              APLog.d("APMidasDownload", "updateOneByOne sdcard midasPay dir exist!");
              if (paramString.endsWith(".apk")) {
                break label576;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(".apk");
              localObject = ((StringBuilder)localObject).toString();
              a((String)localObject, 2);
            }
            this.e.add(paramString);
            return;
          }
          if ((j == paramInt) && (j > m))
          {
            APLog.i("APMIdasDownload", "resultData=aststse区的文件版本号是最新的");
            b(paramString, 1);
            b(paramString, 2);
            this.f.add(paramString);
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resultData=需要开始走网络下载路径");
          ((StringBuilder)localObject).append(paramString);
          APLog.i("APMIdasDownload", ((StringBuilder)localObject).toString());
          this.b = true;
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localObject = paramString;
      continue;
      label576:
      localObject = paramString;
    }
  }
  
  public void e()
  {
    APLog.i("APMidasDownLoad", "updateAndDownLoad 建议更新的入口");
    if (r0.p().j())
    {
      APLog.i("APMidasDownLoad", "updateAndDownLoad IsDownLoading");
      return;
    }
    File localFile = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
    new File(localFile, "MidasSign.ini");
    if (!r0.p().m())
    {
      r0.p().b(true);
      APLog.i("APMidasDownLoad", "resultData=建议更新的入口开始");
      r0.p().d(true);
      a(localFile);
      c();
    }
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      if (w0.a(w0.this) != null)
      {
        int i = 0;
        while (i < w0.a(w0.this).size())
        {
          localObject = ((q0)w0.a(w0.this).get(i)).a;
          int j = ((q0)w0.a(w0.this).get(i)).j;
          if (j != 0)
          {
            w0.a(w0.this, (String)localObject, j);
            if (w0.b(w0.this)) {
              w0.c(w0.this).add(w0.a(w0.this).get(i));
            }
          }
          i += 1;
        }
      }
      w0.d(w0.this);
      if (w0.c(w0.this).size() > 0)
      {
        localObject = w0.this;
        w0.a((w0)localObject, new s0(w0.f((w0)localObject)));
        w0.e(w0.this).b(w0.c(w0.this));
        w0.e(w0.this).a(w0.c(w0.this), 1);
        localObject = w0.this;
        ((w0)localObject).a(w0.c((w0)localObject), 1);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("diffSdcardAndAssetsToData sdcardList size = ");
      ((StringBuilder)localObject).append(w0.g(w0.this));
      APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("diffSdcardAndAssetsToData assetsList size = ");
      ((StringBuilder)localObject).append(w0.h(w0.this));
      APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
      if ((w0.g(w0.this).size() > 0) || (w0.h(w0.this).size() > 0))
      {
        new v0(w0.f(w0.this)).b(0);
        File localFile = w0.f(w0.this).getApplicationContext().getDir("midaspluginsTemp", 0);
        File[] arrayOfFile = localFile.listFiles();
        localObject = "sucessnum=";
        if (arrayOfFile != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sucessnum=");
          ((StringBuilder)localObject).append(localFile.listFiles().length);
          localObject = ((StringBuilder)localObject).toString();
        }
        APDataReportManager.getInstance().a("sdk.update.advise.sdcard.sucess", (String)localObject);
        APLog.i("APMidasDownLoad", "本地非网络更新完成");
        localObject = w0.this;
        ((w0)localObject).a(w0.f((w0)localObject));
      }
    }
  }
  
  public class b
    implements b1
  {
    public b() {}
    
    public void a()
    {
      APLog.i("APMidasDownLoad", "resultData=下载完成");
      Object localObject1 = new o0(w0.f(w0.this));
      if (!((o0)localObject1).b())
      {
        ((o0)localObject1).a(1);
        return;
      }
      v0 localv0 = new v0(w0.f(w0.this));
      Object localObject3;
      if (localv0.a())
      {
        ((o0)localObject1).a();
        z0.a(2, -1);
        localv0.b(0);
        localObject2 = w0.f(w0.this).getApplicationContext().getDir("midaspluginsTemp", 0);
        localObject3 = ((File)localObject2).listFiles();
        localObject1 = "sucessnum=";
        if (localObject3 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sucessnum=");
          ((StringBuilder)localObject1).append(((File)localObject2).listFiles().length);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        APDataReportManager.getInstance().a("sdk.update.advise.wifi.sucess", (String)localObject1);
        APLog.i("APMidasDownLoad", "resultData 2 =后台线程更新完成");
        localObject1 = w0.this;
        ((w0)localObject1).a(w0.f((w0)localObject1));
        APLog.i("APMidasDownLoad", "resultData 3 =后台线程更新完成");
        r0.p().b(false);
        return;
      }
      r0.p().d(false);
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject2 = "";
      localObject1 = localObject2;
      try
      {
        File[] arrayOfFile = w0.f(w0.this).getApplicationContext().getDir("midaspluginsTemp", 0).listFiles();
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("checkfai");
        int i;
        if (arrayOfFile == null)
        {
          i = 0;
        }
        else
        {
          localObject1 = localObject2;
          i = arrayOfFile.length;
        }
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(i);
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject3).toString();
        localObject3 = localObject2;
        long l;
        if (arrayOfFile != null)
        {
          localObject1 = localObject2;
          localObject3 = localObject2;
          if (arrayOfFile.length > 0)
          {
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              localObject3 = localObject2;
              if (i >= arrayOfFile.length) {
                break;
              }
              localObject1 = localObject2;
              if (!arrayOfFile[i].getName().endsWith(".diff"))
              {
                localObject1 = localObject2;
                if (!arrayOfFile[i].getName().endsWith(".ini"))
                {
                  localObject1 = localObject2;
                  localStringBuffer.append(localv0.a(arrayOfFile[i].getAbsolutePath()));
                  localObject1 = localObject2;
                  localObject3 = new FileInputStream(arrayOfFile[i]);
                  localObject1 = localObject2;
                  l = ((FileInputStream)localObject3).available();
                  localObject1 = localObject2;
                  StringBuilder localStringBuilder2 = new StringBuilder();
                  localObject1 = localObject2;
                  localStringBuilder2.append("size");
                  localObject1 = localObject2;
                  localStringBuilder2.append(l);
                  localObject1 = localObject2;
                  localStringBuffer.append(localStringBuilder2.toString());
                  localObject1 = localObject2;
                  ((FileInputStream)localObject3).close();
                }
              }
              i += 1;
            }
          }
        }
        StringBuilder localStringBuilder1;
        return;
      }
      catch (Exception localException)
      {
        r0.p().b(false);
        localException.printStackTrace();
        localObject3 = localObject1;
        l = localv0.e();
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(APAppDataInterface.singleton().g());
        ((StringBuffer)localObject1).append("&md5=");
        ((StringBuffer)localObject1).append(localStringBuffer.toString());
        ((StringBuffer)localObject1).append("&filesnum=");
        ((StringBuffer)localObject1).append((String)localObject3);
        ((StringBuffer)localObject1).append("&datanum=");
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("size");
        localStringBuilder1.append(l);
        ((StringBuffer)localObject1).append(localStringBuilder1.toString());
        localv0.d();
        APDataReportManager.getInstance().a("sdk.update.advise.check.fail", ((StringBuffer)localObject1).toString());
        APLog.i("APMidasDownLoad", "resultData=后台线程更新失败，md5校验失败");
        r0.p().b(false);
      }
    }
    
    public void a(int paramInt) {}
    
    public void b()
    {
      long l = new v0(w0.f(w0.this)).e();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("datanum=");
      localStringBuilder.append(l);
      localAPDataReportManager.a("sdk.update.dasize", localStringBuilder.toString());
    }
    
    public void b(int paramInt)
    {
      r0.p().d(false);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(APAppDataInterface.singleton().g());
      localStringBuffer.append("&");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errone=");
      localStringBuilder.append(r0.p().c());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append("&");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errTwo=");
      localStringBuilder.append(r0.p().e());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append("&");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errThree=");
      localStringBuilder.append(r0.p().d());
      localStringBuffer.append(localStringBuilder.toString());
      APDataReportManager.getInstance().a("sdk.update.advise.wifi.fail", localStringBuffer.toString());
      APLog.i("APMidasDownLoad", "resultData=下载结束时没有完成出现异常");
      r0.p().b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w0
 * JD-Core Version:    0.7.0.1
 */