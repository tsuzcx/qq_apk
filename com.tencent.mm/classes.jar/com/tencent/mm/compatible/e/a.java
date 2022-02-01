package com.tencent.mm.compatible.e;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import java.util.Locale;

public final class a
{
  public static Boolean lYA;
  
  public static boolean a(String paramString1, String paramString2, PInt paramPInt, PBool paramPBool)
  {
    AppMethodBeat.i(155846);
    if (paramString1 == null)
    {
      paramPBool.value = false;
      AppMethodBeat.o(155846);
      return false;
    }
    if (paramString2 == null)
    {
      paramPBool.value = true;
      AppMethodBeat.o(155846);
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      paramPInt.value += 1;
      paramPBool.value = true;
      AppMethodBeat.o(155846);
      return true;
    }
    paramPBool.value = false;
    AppMethodBeat.o(155846);
    return false;
  }
  
  /* Error */
  public static void b(String paramString, java.util.List<b> paramList, java.util.List<a> paramList1)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 53	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   9: ifne +16 -> 25
    //   12: ldc 55
    //   14: ldc 57
    //   16: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 47
    //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: invokestatic 68	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 70
    //   32: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +116 -> 151
    //   38: ldc 70
    //   40: astore 4
    //   42: new 72	java/io/BufferedReader
    //   45: dup
    //   46: new 74	com/tencent/mm/vfs/ab
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 78	com/tencent/mm/vfs/ab:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 81	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_0
    //   60: aload_3
    //   61: invokevirtual 84	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +678 -> 746
    //   71: aload_3
    //   72: astore_0
    //   73: aload 5
    //   75: invokevirtual 87	java/lang/String:trim	()Ljava/lang/String;
    //   78: astore 6
    //   80: aload_3
    //   81: astore_0
    //   82: aload 6
    //   84: invokevirtual 91	java/lang/String:length	()I
    //   87: ifeq -29 -> 58
    //   90: aload_3
    //   91: astore_0
    //   92: aload 6
    //   94: ldc 93
    //   96: aconst_null
    //   97: invokestatic 99	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   100: astore 5
    //   102: aload 5
    //   104: ifnonnull +115 -> 219
    //   107: aload_3
    //   108: astore_0
    //   109: ldc 55
    //   111: ldc 101
    //   113: aload 6
    //   115: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: goto -66 -> 58
    //   127: astore_0
    //   128: aload_3
    //   129: astore_0
    //   130: ldc 55
    //   132: ldc 114
    //   134: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: ifnull +626 -> 764
    //   141: aload_0
    //   142: invokevirtual 118	java/io/BufferedReader:close	()V
    //   145: ldc 47
    //   147: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: aload_3
    //   152: ldc 120
    //   154: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +12 -> 169
    //   160: aload_3
    //   161: ldc 122
    //   163: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +28 -> 194
    //   169: new 124	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   176: ldc 128
    //   178: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 120
    //   183: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore 4
    //   191: goto -149 -> 42
    //   194: new 124	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   201: ldc 128
    //   203: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 137
    //   208: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 4
    //   216: goto -174 -> 42
    //   219: aload_3
    //   220: astore_0
    //   221: aload 5
    //   223: ldc 139
    //   225: invokeinterface 145 2 0
    //   230: checkcast 31	java/lang/String
    //   233: astore 7
    //   235: aload 7
    //   237: ifnonnull +47 -> 284
    //   240: aload_3
    //   241: astore_0
    //   242: ldc 55
    //   244: ldc 147
    //   246: aload 6
    //   248: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   251: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -199 -> 58
    //   260: astore_0
    //   261: aload_3
    //   262: astore_0
    //   263: ldc 55
    //   265: ldc 149
    //   267: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_3
    //   271: ifnull +506 -> 777
    //   274: aload_3
    //   275: invokevirtual 118	java/io/BufferedReader:close	()V
    //   278: ldc 47
    //   280: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: return
    //   284: aload_3
    //   285: astore_0
    //   286: aload 7
    //   288: ldc 151
    //   290: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +229 -> 522
    //   296: aload_3
    //   297: astore_0
    //   298: new 9	com/tencent/mm/compatible/e/a$b
    //   301: dup
    //   302: iconst_0
    //   303: invokespecial 154	com/tencent/mm/compatible/e/a$b:<init>	(B)V
    //   306: astore 6
    //   308: aload_3
    //   309: astore_0
    //   310: aload 6
    //   312: new 156	android/util/SparseArray
    //   315: dup
    //   316: invokespecial 157	android/util/SparseArray:<init>	()V
    //   319: putfield 161	com/tencent/mm/compatible/e/a$b:lYE	Landroid/util/SparseArray;
    //   322: aload_3
    //   323: astore_0
    //   324: aload 6
    //   326: aload 5
    //   328: ldc 163
    //   330: invokeinterface 145 2 0
    //   335: checkcast 31	java/lang/String
    //   338: putfield 167	com/tencent/mm/compatible/e/a$b:lYF	Ljava/lang/String;
    //   341: aload_3
    //   342: astore_0
    //   343: aload 6
    //   345: aload 5
    //   347: ldc 169
    //   349: invokeinterface 145 2 0
    //   354: checkcast 31	java/lang/String
    //   357: putfield 172	com/tencent/mm/compatible/e/a$b:model	Ljava/lang/String;
    //   360: aload_3
    //   361: astore_0
    //   362: aload 6
    //   364: aload 5
    //   366: ldc 174
    //   368: invokeinterface 145 2 0
    //   373: checkcast 31	java/lang/String
    //   376: putfield 177	com/tencent/mm/compatible/e/a$b:version	Ljava/lang/String;
    //   379: aload_3
    //   380: astore_0
    //   381: aload 6
    //   383: getfield 161	com/tencent/mm/compatible/e/a$b:lYE	Landroid/util/SparseArray;
    //   386: iconst_1
    //   387: aload 5
    //   389: new 124	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   396: ldc 179
    //   398: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 4
    //   403: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokeinterface 145 2 0
    //   414: checkcast 31	java/lang/String
    //   417: invokevirtual 182	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   420: aload_3
    //   421: astore_0
    //   422: aload 6
    //   424: getfield 161	com/tencent/mm/compatible/e/a$b:lYE	Landroid/util/SparseArray;
    //   427: iconst_2
    //   428: aload 5
    //   430: new 124	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   437: ldc 179
    //   439: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 184
    //   444: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 4
    //   449: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokeinterface 145 2 0
    //   460: checkcast 31	java/lang/String
    //   463: invokevirtual 182	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   466: aload_3
    //   467: astore_0
    //   468: aload 6
    //   470: aload 5
    //   472: ldc 186
    //   474: invokeinterface 145 2 0
    //   479: checkcast 31	java/lang/String
    //   482: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   485: putfield 195	com/tencent/mm/compatible/e/a$b:lYD	I
    //   488: aload_3
    //   489: astore_0
    //   490: aload_1
    //   491: aload 6
    //   493: invokeinterface 200 2 0
    //   498: pop
    //   499: goto -441 -> 58
    //   502: astore_2
    //   503: aload_0
    //   504: astore_1
    //   505: aload_2
    //   506: astore_0
    //   507: aload_1
    //   508: ifnull +7 -> 515
    //   511: aload_1
    //   512: invokevirtual 118	java/io/BufferedReader:close	()V
    //   515: ldc 47
    //   517: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: aload_0
    //   521: athrow
    //   522: aload_3
    //   523: astore_0
    //   524: aload 7
    //   526: ldc 202
    //   528: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq -473 -> 58
    //   534: aload_3
    //   535: astore_0
    //   536: new 6	com/tencent/mm/compatible/e/a$a
    //   539: dup
    //   540: iconst_0
    //   541: invokespecial 203	com/tencent/mm/compatible/e/a$a:<init>	(B)V
    //   544: astore 6
    //   546: aload_3
    //   547: astore_0
    //   548: aload 6
    //   550: new 156	android/util/SparseArray
    //   553: dup
    //   554: invokespecial 157	android/util/SparseArray:<init>	()V
    //   557: putfield 204	com/tencent/mm/compatible/e/a$a:lYE	Landroid/util/SparseArray;
    //   560: aload_3
    //   561: astore_0
    //   562: aload 6
    //   564: aload 5
    //   566: ldc 206
    //   568: invokeinterface 145 2 0
    //   573: checkcast 31	java/lang/String
    //   576: putfield 209	com/tencent/mm/compatible/e/a$a:pkgName	Ljava/lang/String;
    //   579: aload_3
    //   580: astore_0
    //   581: aload 6
    //   583: aload 5
    //   585: ldc 211
    //   587: invokeinterface 145 2 0
    //   592: checkcast 31	java/lang/String
    //   595: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   598: putfield 214	com/tencent/mm/compatible/e/a$a:lYB	I
    //   601: aload_3
    //   602: astore_0
    //   603: aload 6
    //   605: aload 5
    //   607: ldc 216
    //   609: invokeinterface 145 2 0
    //   614: checkcast 31	java/lang/String
    //   617: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   620: putfield 219	com/tencent/mm/compatible/e/a$a:lYC	I
    //   623: aload_3
    //   624: astore_0
    //   625: aload 6
    //   627: getfield 204	com/tencent/mm/compatible/e/a$a:lYE	Landroid/util/SparseArray;
    //   630: iconst_1
    //   631: aload 5
    //   633: new 124	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   640: ldc 179
    //   642: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 4
    //   647: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokeinterface 145 2 0
    //   658: checkcast 31	java/lang/String
    //   661: invokevirtual 182	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   664: aload_3
    //   665: astore_0
    //   666: aload 6
    //   668: getfield 204	com/tencent/mm/compatible/e/a$a:lYE	Landroid/util/SparseArray;
    //   671: iconst_2
    //   672: aload 5
    //   674: new 124	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   681: ldc 179
    //   683: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc 184
    //   688: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 4
    //   693: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokeinterface 145 2 0
    //   704: checkcast 31	java/lang/String
    //   707: invokevirtual 182	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   710: aload_3
    //   711: astore_0
    //   712: aload 6
    //   714: aload 5
    //   716: ldc 186
    //   718: invokeinterface 145 2 0
    //   723: checkcast 31	java/lang/String
    //   726: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   729: putfield 220	com/tencent/mm/compatible/e/a$a:lYD	I
    //   732: aload_3
    //   733: astore_0
    //   734: aload_2
    //   735: aload 6
    //   737: invokeinterface 200 2 0
    //   742: pop
    //   743: goto -685 -> 58
    //   746: aload_3
    //   747: invokevirtual 118	java/io/BufferedReader:close	()V
    //   750: ldc 47
    //   752: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   755: return
    //   756: astore_0
    //   757: ldc 47
    //   759: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   762: return
    //   763: astore_0
    //   764: ldc 47
    //   766: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   769: return
    //   770: astore_0
    //   771: ldc 47
    //   773: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   776: return
    //   777: ldc 47
    //   779: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   782: return
    //   783: astore_1
    //   784: goto -269 -> 515
    //   787: astore_0
    //   788: aconst_null
    //   789: astore_1
    //   790: goto -283 -> 507
    //   793: astore_2
    //   794: aload_0
    //   795: astore_1
    //   796: aload_2
    //   797: astore_0
    //   798: goto -291 -> 507
    //   801: astore_0
    //   802: aconst_null
    //   803: astore_3
    //   804: goto -543 -> 261
    //   807: astore_0
    //   808: aconst_null
    //   809: astore_0
    //   810: goto -680 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	paramString	String
    //   0	813	1	paramList	java.util.List<b>
    //   0	813	2	paramList1	java.util.List<a>
    //   28	776	3	localObject1	Object
    //   40	652	4	str1	String
    //   64	651	5	localObject2	Object
    //   78	658	6	localObject3	Object
    //   233	292	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   60	66	127	java/io/FileNotFoundException
    //   73	80	127	java/io/FileNotFoundException
    //   82	90	127	java/io/FileNotFoundException
    //   92	102	127	java/io/FileNotFoundException
    //   109	124	127	java/io/FileNotFoundException
    //   221	235	127	java/io/FileNotFoundException
    //   242	257	127	java/io/FileNotFoundException
    //   286	296	127	java/io/FileNotFoundException
    //   298	308	127	java/io/FileNotFoundException
    //   310	322	127	java/io/FileNotFoundException
    //   324	341	127	java/io/FileNotFoundException
    //   343	360	127	java/io/FileNotFoundException
    //   362	379	127	java/io/FileNotFoundException
    //   381	420	127	java/io/FileNotFoundException
    //   422	466	127	java/io/FileNotFoundException
    //   468	488	127	java/io/FileNotFoundException
    //   490	499	127	java/io/FileNotFoundException
    //   524	534	127	java/io/FileNotFoundException
    //   536	546	127	java/io/FileNotFoundException
    //   548	560	127	java/io/FileNotFoundException
    //   562	579	127	java/io/FileNotFoundException
    //   581	601	127	java/io/FileNotFoundException
    //   603	623	127	java/io/FileNotFoundException
    //   625	664	127	java/io/FileNotFoundException
    //   666	710	127	java/io/FileNotFoundException
    //   712	732	127	java/io/FileNotFoundException
    //   734	743	127	java/io/FileNotFoundException
    //   60	66	260	java/io/IOException
    //   73	80	260	java/io/IOException
    //   82	90	260	java/io/IOException
    //   92	102	260	java/io/IOException
    //   109	124	260	java/io/IOException
    //   221	235	260	java/io/IOException
    //   242	257	260	java/io/IOException
    //   286	296	260	java/io/IOException
    //   298	308	260	java/io/IOException
    //   310	322	260	java/io/IOException
    //   324	341	260	java/io/IOException
    //   343	360	260	java/io/IOException
    //   362	379	260	java/io/IOException
    //   381	420	260	java/io/IOException
    //   422	466	260	java/io/IOException
    //   468	488	260	java/io/IOException
    //   490	499	260	java/io/IOException
    //   524	534	260	java/io/IOException
    //   536	546	260	java/io/IOException
    //   548	560	260	java/io/IOException
    //   562	579	260	java/io/IOException
    //   581	601	260	java/io/IOException
    //   603	623	260	java/io/IOException
    //   625	664	260	java/io/IOException
    //   666	710	260	java/io/IOException
    //   712	732	260	java/io/IOException
    //   734	743	260	java/io/IOException
    //   60	66	502	finally
    //   73	80	502	finally
    //   82	90	502	finally
    //   92	102	502	finally
    //   109	124	502	finally
    //   221	235	502	finally
    //   242	257	502	finally
    //   263	270	502	finally
    //   286	296	502	finally
    //   298	308	502	finally
    //   310	322	502	finally
    //   324	341	502	finally
    //   343	360	502	finally
    //   362	379	502	finally
    //   381	420	502	finally
    //   422	466	502	finally
    //   468	488	502	finally
    //   490	499	502	finally
    //   524	534	502	finally
    //   536	546	502	finally
    //   548	560	502	finally
    //   562	579	502	finally
    //   581	601	502	finally
    //   603	623	502	finally
    //   625	664	502	finally
    //   666	710	502	finally
    //   712	732	502	finally
    //   734	743	502	finally
    //   746	750	756	java/io/IOException
    //   141	145	763	java/io/IOException
    //   274	278	770	java/io/IOException
    //   511	515	783	java/io/IOException
    //   42	58	787	finally
    //   130	137	793	finally
    //   42	58	801	java/io/IOException
    //   42	58	807	java/io/FileNotFoundException
  }
  
  static final class a
  {
    int lYB;
    int lYC;
    int lYD;
    SparseArray<String> lYE;
    String pkgName;
    
    public final String toString()
    {
      AppMethodBeat.i(155844);
      String str = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[] { this.pkgName, Integer.valueOf(this.lYB), Integer.valueOf(this.lYC), this.lYE, Integer.valueOf(this.lYD) });
      AppMethodBeat.o(155844);
      return str;
    }
  }
  
  public static final class b
  {
    public int lYD;
    SparseArray<String> lYE;
    public String lYF;
    public String model;
    public String version;
    
    public final String toString()
    {
      AppMethodBeat.i(155845);
      String str = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[] { this.lYF, this.model, this.version, this.lYE, Integer.valueOf(this.lYD) });
      AppMethodBeat.o(155845);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.e.a
 * JD-Core Version:    0.7.0.1
 */