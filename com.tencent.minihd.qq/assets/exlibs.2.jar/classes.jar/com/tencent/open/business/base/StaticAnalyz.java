package com.tencent.open.business.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.OpenSdkStatic;

public class StaticAnalyz
{
  public static final String A = "ANDROIDQQ.INVITE.FS";
  public static final String B = "ANDROIDQQ.REQUEST.FS";
  public static final String C = "ANDROIDQQ.FREEGIFT.FS";
  public static final String D = "ANDROIDQQ.SENDSTORY.FS";
  public static final String E = "ANDROIDQQ.REACTIVE.FS";
  public static final String F = "ANDROIDQQ.BRAG.FS";
  public static final String G = "ANDROIDQQ.PK.FS";
  public static final String H = "ANDROIDQQ.PCPUSH";
  public static final String I = "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
  public static final String J = "ANDROIDQQ.PCPUSH.MUTIDETAIL";
  public static final String K = "ANDROIDQQ.PCPUSH.UNREADPOP";
  public static final String L = "ANDROIDQQ.WIFIDLYYB.STORE";
  public static final String M = "ANDROIDQQ.WIFIDLYYB.STORE.APPDETAIL";
  public static final String N = "100";
  public static final String O = "200";
  public static final String P = "202";
  public static final String Q = "300";
  public static final String R = "400";
  public static final String S = "900";
  public static final String T = "2000";
  public static final String U = "305";
  public static final String V = "310";
  public static final String W = "311";
  public static final String X = "312";
  public static final String Y = "710";
  public static final String Z = "720";
  public static final String a = "ANDROIDQQ.PCPUSH.AUTO";
  public static final String aa = "201";
  public static final String ab = "500";
  protected static String ac = "";
  public static final String ad = "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG";
  public static final String ae = "yyb_via_info.txt";
  public static final String b = "ANDROIDQQ.INSTALL.FEED";
  public static final String c = "ANDROIDQQ.SENDSTORY.FEED1";
  public static final String d = "ANDROIDQQ.SENDSTORY.FEED2";
  public static final String e = "ANDROIDQQ.UNDOWNLOAD.APPDETAIL";
  public static final String f = "ANDROIDQQ.UNINSTALL.APPDETAIL";
  public static final String g = "ANDROIDQQ.INSTALLED.APPDETAIL";
  public static final String h = "ANDROIDQQ.PCPUSH";
  public static final String i = "ANDROIDQQ.PCPUSH.TIMELINE.NEW";
  public static final String j = "ANDROIDQQ.PCPUSH.MSGPUSH";
  public static final String k = "ANDROIDQQ.PCPUSH.AIOMSG";
  public static final String l = "ANDROIDQQ.INVITE.APPAIO";
  public static final String m = "ANDROIDQQ.REQUEST.APPAIO";
  public static final String n = "ANDROIDQQ.FREEGIFT.APPAIO";
  public static final String o = "ANDROIDQQ.PK.APPAIO";
  public static final String p = "ANDROIDQQ.BRAG.APPAIO";
  public static final String q = "ANDROIDQQ.PCPUSH.AUTO.NEWTIPS";
  public static final String r = "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADED";
  public static final String s = "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADING";
  public static final String t = "ANDROIDQQ.INVITE.ASSISTANT";
  public static final String u = "ANDROIDQQ.REQUEST.ASSISTANT";
  public static final String v = "ANDROIDQQ.FREEGIFT.ASSISTANT";
  public static final String w = "ANDROIDQQ.SENDSTORY.FEED1";
  public static final String x = "ANDROIDQQ.REACTIVE.ASSISTANT";
  public static final String y = "ANDROIDQQ.BRAG.ASSISTANT";
  public static final String z = "ANDROIDQQ.PK.ASSISTANT";
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "ANDROIDQQ.FREEGIFT.APPAIO";
    case 50: 
      return "ANDROIDQQ.REQUEST.APPAIO";
    case 100: 
      return "ANDROIDQQ.INVITE.APPAIO";
    case 52: 
      return "ANDROIDQQ.BRAG.APPAIO";
    }
    return "ANDROIDQQ.PK.APPAIO";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "ANDROIDQQ.INSTALL.FEED";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "ANDROIDQQ.SENDSTORY.FEED1";
      }
      if (paramInt3 == 1) {
        return "ANDROIDQQ.SENDSTORY.FEED2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        int i1 = paramString1.indexOf("ANDROIDQQ");
        if (i1 != -1)
        {
          i1 += "ANDROIDQQ".length();
          paramString1 = new StringBuilder(paramString1);
          paramString1.insert(i1, ".");
          paramString1.insert(i1 + 1, paramString2);
          return paramString1.toString();
        }
        LogUtility.c("VIA", "jointYybVia via dont contain ANDROIDQQ");
        return "";
      }
    }
    catch (Exception paramString1)
    {
      LogUtility.c("VIA", "jointYybVia>>>", paramString1);
    }
    return "";
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 205	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 244	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 99
    //   22: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: new 258	java/io/BufferedReader
    //   33: dup
    //   34: new 260	java/io/FileReader
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 261	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 264	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 267	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 267	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 6
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 267	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore 7
    //   71: aload_3
    //   72: astore_2
    //   73: aload 5
    //   75: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +120 -> 198
    //   81: aload_3
    //   82: astore_2
    //   83: aload 6
    //   85: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +110 -> 198
    //   91: aload_3
    //   92: astore_2
    //   93: aload 7
    //   95: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +100 -> 198
    //   101: aload_3
    //   102: astore_2
    //   103: ldc 220
    //   105: new 205	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 269
    //   115: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 5
    //   120: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 271
    //   126: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 6
    //   131: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 273
    //   137: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 7
    //   142: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 227	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_3
    //   152: astore_2
    //   153: aload 5
    //   155: aload 6
    //   157: aload_1
    //   158: aload 7
    //   160: invokestatic 276	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: astore_2
    //   165: new 250	java/io/File
    //   168: dup
    //   169: aload 4
    //   171: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 281	java/io/File:exists	()Z
    //   177: ifeq +12 -> 189
    //   180: aload_3
    //   181: astore_2
    //   182: aload_0
    //   183: ldc 99
    //   185: invokevirtual 285	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   188: pop
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 288	java/io/BufferedReader:close	()V
    //   197: return
    //   198: aload_3
    //   199: astore_2
    //   200: ldc 220
    //   202: new 205	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 290
    //   212: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 5
    //   217: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 271
    //   223: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 273
    //   234: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 7
    //   239: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 292	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: goto -59 -> 189
    //   251: astore_0
    //   252: aload_3
    //   253: astore_2
    //   254: aload_0
    //   255: invokevirtual 295	java/io/FileNotFoundException:printStackTrace	()V
    //   258: aload_3
    //   259: ifnull -62 -> 197
    //   262: aload_3
    //   263: invokevirtual 288	java/io/BufferedReader:close	()V
    //   266: return
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   272: return
    //   273: astore_0
    //   274: aload_0
    //   275: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   278: return
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_3
    //   282: aload_3
    //   283: astore_2
    //   284: aload_0
    //   285: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   288: aload_3
    //   289: ifnull -92 -> 197
    //   292: aload_3
    //   293: invokevirtual 288	java/io/BufferedReader:close	()V
    //   296: return
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   302: return
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_2
    //   306: aload_2
    //   307: ifnull +7 -> 314
    //   310: aload_2
    //   311: invokevirtual 288	java/io/BufferedReader:close	()V
    //   314: aload_0
    //   315: athrow
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   321: goto -7 -> 314
    //   324: astore_0
    //   325: goto -19 -> 306
    //   328: astore_0
    //   329: goto -47 -> 282
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_3
    //   335: goto -83 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramContext	android.content.Context
    //   0	338	1	paramString	String
    //   48	263	2	localBufferedReader1	java.io.BufferedReader
    //   46	289	3	localBufferedReader2	java.io.BufferedReader
    //   28	142	4	str1	String
    //   53	163	5	str2	String
    //   61	166	6	str3	String
    //   69	169	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   49	55	251	java/io/FileNotFoundException
    //   57	63	251	java/io/FileNotFoundException
    //   65	71	251	java/io/FileNotFoundException
    //   73	81	251	java/io/FileNotFoundException
    //   83	91	251	java/io/FileNotFoundException
    //   93	101	251	java/io/FileNotFoundException
    //   103	151	251	java/io/FileNotFoundException
    //   153	163	251	java/io/FileNotFoundException
    //   165	180	251	java/io/FileNotFoundException
    //   182	189	251	java/io/FileNotFoundException
    //   200	248	251	java/io/FileNotFoundException
    //   262	266	267	java/io/IOException
    //   193	197	273	java/io/IOException
    //   0	47	279	java/io/IOException
    //   292	296	297	java/io/IOException
    //   0	47	303	finally
    //   310	314	316	java/io/IOException
    //   49	55	324	finally
    //   57	63	324	finally
    //   65	71	324	finally
    //   73	81	324	finally
    //   83	91	324	finally
    //   93	101	324	finally
    //   103	151	324	finally
    //   153	163	324	finally
    //   165	180	324	finally
    //   182	189	324	finally
    //   200	248	324	finally
    //   254	258	324	finally
    //   284	288	324	finally
    //   49	55	328	java/io/IOException
    //   57	63	328	java/io/IOException
    //   65	71	328	java/io/IOException
    //   73	81	328	java/io/IOException
    //   83	91	328	java/io/IOException
    //   93	101	328	java/io/IOException
    //   103	151	328	java/io/IOException
    //   153	163	328	java/io/IOException
    //   165	180	328	java/io/IOException
    //   182	189	328	java/io/IOException
    //   200	248	328	java/io/IOException
    //   0	47	332	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_3
    //   15: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +49 -> 67
    //   21: ldc 220
    //   23: new 205	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 299
    //   33: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 271
    //   43: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 273
    //   53: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 292	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: return
    //   67: aconst_null
    //   68: astore 4
    //   70: new 205	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   77: aload_0
    //   78: invokevirtual 244	android/content/Context:getFilesDir	()Ljava/io/File;
    //   81: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: getstatic 253	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 99
    //   92: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 5
    //   100: new 250	java/io/File
    //   103: dup
    //   104: aload 5
    //   106: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: invokevirtual 281	java/io/File:exists	()Z
    //   112: ifeq +10 -> 122
    //   115: aload_0
    //   116: ldc 99
    //   118: invokevirtual 285	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   121: pop
    //   122: new 301	java/io/BufferedWriter
    //   125: dup
    //   126: new 303	java/io/FileWriter
    //   129: dup
    //   130: aload 5
    //   132: invokespecial 304	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   135: invokespecial 307	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   138: astore_0
    //   139: aload_0
    //   140: astore 4
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 310	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: astore 4
    //   150: aload_0
    //   151: invokevirtual 313	java/io/BufferedWriter:newLine	()V
    //   154: aload_0
    //   155: astore 4
    //   157: aload_0
    //   158: aload_2
    //   159: invokevirtual 310	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: astore 4
    //   165: aload_0
    //   166: invokevirtual 313	java/io/BufferedWriter:newLine	()V
    //   169: aload_0
    //   170: astore 4
    //   172: aload_0
    //   173: aload_3
    //   174: invokevirtual 310	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: astore 4
    //   180: aload_0
    //   181: invokevirtual 316	java/io/BufferedWriter:flush	()V
    //   184: aload_0
    //   185: astore 4
    //   187: ldc 220
    //   189: new 205	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 318
    //   199: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 271
    //   209: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 273
    //   219: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_3
    //   223: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 227	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_0
    //   233: ifnull -167 -> 66
    //   236: aload_0
    //   237: invokevirtual 319	java/io/BufferedWriter:close	()V
    //   240: return
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   246: return
    //   247: astore_1
    //   248: aload 4
    //   250: astore_0
    //   251: aload_1
    //   252: invokevirtual 295	java/io/FileNotFoundException:printStackTrace	()V
    //   255: aload_0
    //   256: ifnull -190 -> 66
    //   259: aload_0
    //   260: invokevirtual 319	java/io/BufferedWriter:close	()V
    //   263: return
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   269: return
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: aload_0
    //   274: astore 4
    //   276: aload_1
    //   277: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   280: aload_0
    //   281: ifnull -215 -> 66
    //   284: aload_0
    //   285: invokevirtual 319	java/io/BufferedWriter:close	()V
    //   288: return
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   294: return
    //   295: astore_0
    //   296: aconst_null
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 319	java/io/BufferedWriter:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   316: goto -7 -> 309
    //   319: astore_0
    //   320: goto -21 -> 299
    //   323: astore_1
    //   324: aload_0
    //   325: astore 4
    //   327: aload_1
    //   328: astore_0
    //   329: goto -30 -> 299
    //   332: astore_1
    //   333: goto -60 -> 273
    //   336: astore_1
    //   337: goto -86 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	android.content.Context
    //   0	340	1	paramString1	String
    //   0	340	2	paramString2	String
    //   0	340	3	paramString3	String
    //   68	258	4	localContext	android.content.Context
    //   98	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   236	240	241	java/io/IOException
    //   70	122	247	java/io/FileNotFoundException
    //   122	139	247	java/io/FileNotFoundException
    //   259	263	264	java/io/IOException
    //   70	122	270	java/io/IOException
    //   122	139	270	java/io/IOException
    //   284	288	289	java/io/IOException
    //   70	122	295	finally
    //   122	139	295	finally
    //   304	309	311	java/io/IOException
    //   142	147	319	finally
    //   150	154	319	finally
    //   157	162	319	finally
    //   165	169	319	finally
    //   172	177	319	finally
    //   180	184	319	finally
    //   187	232	319	finally
    //   276	280	319	finally
    //   251	255	323	finally
    //   142	147	332	java/io/IOException
    //   150	154	332	java/io/IOException
    //   157	162	332	java/io/IOException
    //   165	169	332	java/io/IOException
    //   172	177	332	java/io/IOException
    //   180	184	332	java/io/IOException
    //   187	232	332	java/io/IOException
    //   142	147	336	java/io/FileNotFoundException
    //   150	154	336	java/io/FileNotFoundException
    //   157	162	336	java/io/FileNotFoundException
    //   165	169	336	java/io/FileNotFoundException
    //   172	177	336	java/io/FileNotFoundException
    //   180	184	336	java/io/FileNotFoundException
    //   187	232	336	java/io/FileNotFoundException
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    LogUtility.a("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString3);
    OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), paramString3, paramString2, paramString1, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    long l1 = CommonDataAdapter.a().a();
    OpenSdkStatic.a().a(String.valueOf(l1), paramString3, paramString2, paramString1, CommonDataAdapter.a().e(), paramBundle, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString4 == null)) {
      return;
    }
    LogUtility.a("reportForVia", "reportForVia actionType=" + paramString1 + " via=" + paramString2 + ", appid=" + paramString4);
    OpenSdkStatic.a().a(paramString3, paramString4, paramString2, paramString1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.business.base.StaticAnalyz
 * JD-Core Version:    0.7.0.1
 */