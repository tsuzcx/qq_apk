package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import d.n.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l
{
  private static final Pattern juN;
  public com.tencent.mm.plugin.address.d.a juI;
  public boolean juJ;
  public final List<RcptItem> juK;
  public final HashMap<String, List<RcptItem>> juL;
  public final HashMap<String, List<RcptItem>> juM;
  public String path;
  
  static
  {
    AppMethodBeat.i(20818);
    juN = Pattern.compile("(-|\\s)+");
    AppMethodBeat.o(20818);
  }
  
  public l()
  {
    AppMethodBeat.i(20801);
    this.juI = new com.tencent.mm.plugin.address.d.a();
    this.juJ = false;
    this.juK = new ArrayList();
    this.juL = new HashMap();
    this.juM = new HashMap();
    AppMethodBeat.o(20801);
  }
  
  private static boolean bV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20814);
    if (paramString1.substring(6).startsWith(paramString2))
    {
      AppMethodBeat.o(20814);
      return true;
    }
    AppMethodBeat.o(20814);
    return false;
  }
  
  private static RcptItem f(List<RcptItem> paramList, String paramString)
  {
    AppMethodBeat.i(20816);
    if ((paramList == null) || (paramList.isEmpty()) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(20816);
      return null;
    }
    int i = 0;
    RcptItem localRcptItem;
    if (i < paramList.size())
    {
      localRcptItem = (RcptItem)paramList.get(i);
      if ((localRcptItem == null) || (!paramString.equals(localRcptItem.name))) {}
    }
    for (paramList = localRcptItem;; paramList = null)
    {
      AppMethodBeat.o(20816);
      return paramList;
      i += 1;
      break;
    }
  }
  
  public final List<RcptItem> KC(String paramString)
  {
    AppMethodBeat.i(20810);
    if (this.juL.containsKey(paramString))
    {
      paramString = (List)this.juL.get(paramString);
      AppMethodBeat.o(20810);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(20810);
    return paramString;
  }
  
  public final List<RcptItem> KD(String paramString)
  {
    AppMethodBeat.i(20811);
    if (this.juM.containsKey(paramString))
    {
      paramString = (List)this.juM.get(paramString);
      AppMethodBeat.o(20811);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(20811);
    return paramString;
  }
  
  public final RcptItem KE(String paramString)
  {
    AppMethodBeat.i(20812);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20812);
      return null;
    }
    Iterator localIterator = this.juK.iterator();
    while (localIterator.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)localIterator.next();
      if (localRcptItem.name.startsWith(paramString))
      {
        AppMethodBeat.o(20812);
        return localRcptItem;
      }
    }
    AppMethodBeat.o(20812);
    return null;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(20804);
    if (this.juI == null) {
      this.juI = new com.tencent.mm.plugin.address.d.a();
    }
    int i = 0;
    while (i < this.juI.juR.size())
    {
      if (((b)this.juI.juR.get(i)).id == paramb.id)
      {
        this.juI.juR.remove(i);
        AppMethodBeat.o(20804);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(20804);
    return false;
  }
  
  /* Error */
  public final void aVt()
  {
    // Byte code:
    //   0: sipush 20802
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 167	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: ldc 169
    //   12: ldc 171
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: invokestatic 177	com/tencent/mm/model/c:getAccPath	()Ljava/lang/String;
    //   23: aastore
    //   24: invokestatic 182	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 51	com/tencent/mm/plugin/address/model/l:juJ	Z
    //   31: ifne +35 -> 66
    //   34: aload_0
    //   35: getfield 63	com/tencent/mm/plugin/address/model/l:juM	Ljava/util/HashMap;
    //   38: invokevirtual 183	java/util/HashMap:isEmpty	()Z
    //   41: ifne +25 -> 66
    //   44: aload_0
    //   45: getfield 56	com/tencent/mm/plugin/address/model/l:juK	Ljava/util/List;
    //   48: invokeinterface 83 1 0
    //   53: ifne +13 -> 66
    //   56: aload_0
    //   57: getfield 61	com/tencent/mm/plugin/address/model/l:juL	Ljava/util/HashMap;
    //   60: invokevirtual 183	java/util/HashMap:isEmpty	()Z
    //   63: ifeq +990 -> 1053
    //   66: ldc 169
    //   68: ldc 185
    //   70: invokestatic 188	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: invokestatic 194	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   76: getfield 199	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   79: astore 5
    //   81: ldc 169
    //   83: ldc 201
    //   85: invokestatic 204	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: invokestatic 210	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   91: invokevirtual 216	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   94: astore 11
    //   96: aconst_null
    //   97: astore 7
    //   99: aconst_null
    //   100: astore 4
    //   102: aconst_null
    //   103: astore 9
    //   105: new 53	java/util/ArrayList
    //   108: dup
    //   109: invokespecial 54	java/util/ArrayList:<init>	()V
    //   112: astore 10
    //   114: iconst_0
    //   115: istore_3
    //   116: new 218	com/tencent/mm/vfs/q
    //   119: dup
    //   120: new 220	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   127: aload 5
    //   129: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 227
    //   134: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 233	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   143: astore 5
    //   145: aload 5
    //   147: astore 6
    //   149: aload 4
    //   151: astore 7
    //   153: new 235	java/io/BufferedReader
    //   156: dup
    //   157: aload 5
    //   159: invokespecial 238	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   162: astore 4
    //   164: aload 10
    //   166: invokeinterface 241 1 0
    //   171: aload 4
    //   173: invokevirtual 244	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull +410 -> 590
    //   183: aload 10
    //   185: aload 6
    //   187: invokeinterface 247 2 0
    //   192: pop
    //   193: goto -22 -> 171
    //   196: astore 8
    //   198: aload 5
    //   200: astore 6
    //   202: aload 4
    //   204: astore 7
    //   206: ldc 169
    //   208: aload 8
    //   210: ldc 249
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload 5
    //   221: ifnull +8 -> 229
    //   224: aload 5
    //   226: invokevirtual 256	com/tencent/mm/vfs/q:close	()V
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 257	java/io/BufferedReader:close	()V
    //   239: iload_3
    //   240: ifne +115 -> 355
    //   243: aload 10
    //   245: invokeinterface 241 1 0
    //   250: aload 11
    //   252: ldc 227
    //   254: invokevirtual 263	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   257: astore 7
    //   259: new 235	java/io/BufferedReader
    //   262: dup
    //   263: new 265	java/io/InputStreamReader
    //   266: dup
    //   267: aload 7
    //   269: ldc_w 267
    //   272: invokespecial 270	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   275: invokespecial 238	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   278: astore 6
    //   280: aload 6
    //   282: astore 5
    //   284: aload 6
    //   286: invokevirtual 244	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   289: astore 4
    //   291: aload 4
    //   293: ifnull +402 -> 695
    //   296: aload 6
    //   298: astore 5
    //   300: aload 10
    //   302: aload 4
    //   304: invokeinterface 247 2 0
    //   309: pop
    //   310: goto -30 -> 280
    //   313: astore 5
    //   315: aload 6
    //   317: astore 4
    //   319: aload 5
    //   321: astore 6
    //   323: aload 4
    //   325: astore 5
    //   327: ldc 169
    //   329: aload 6
    //   331: ldc 249
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload 4
    //   342: ifnull +8 -> 350
    //   345: aload 4
    //   347: invokevirtual 257	java/io/BufferedReader:close	()V
    //   350: aload 7
    //   352: ifnull +3 -> 355
    //   355: ldc 169
    //   357: ldc_w 272
    //   360: iload_3
    //   361: invokestatic 276	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   364: invokevirtual 280	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokestatic 204	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload 10
    //   372: invokeinterface 92 1 0
    //   377: istore_2
    //   378: ldc 249
    //   380: astore 4
    //   382: ldc 249
    //   384: astore 6
    //   386: iconst_0
    //   387: istore_1
    //   388: iload_1
    //   389: iload_2
    //   390: if_icmpge +658 -> 1048
    //   393: aload 10
    //   395: iload_1
    //   396: invokeinterface 96 2 0
    //   401: checkcast 67	java/lang/String
    //   404: astore 7
    //   406: iload_1
    //   407: iconst_1
    //   408: iadd
    //   409: iload_2
    //   410: if_icmpge +399 -> 809
    //   413: aload 10
    //   415: iload_1
    //   416: iconst_1
    //   417: iadd
    //   418: invokeinterface 96 2 0
    //   423: checkcast 67	java/lang/String
    //   426: astore 5
    //   428: aload 7
    //   430: ldc_w 282
    //   433: ldc_w 284
    //   436: invokevirtual 288	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   439: ldc_w 290
    //   442: ldc_w 284
    //   445: invokevirtual 288	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   448: astore 8
    //   450: aload 5
    //   452: ldc_w 282
    //   455: ldc_w 284
    //   458: invokevirtual 288	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   461: ldc_w 290
    //   464: ldc_w 284
    //   467: invokevirtual 288	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   470: astore 11
    //   472: ldc 249
    //   474: astore 5
    //   476: aload 8
    //   478: invokevirtual 293	java/lang/String:length	()I
    //   481: bipush 7
    //   483: if_icmplt +726 -> 1209
    //   486: aload 8
    //   488: iconst_0
    //   489: bipush 6
    //   491: invokevirtual 296	java/lang/String:substring	(II)Ljava/lang/String;
    //   494: astore 9
    //   496: aload 8
    //   498: bipush 6
    //   500: invokevirtual 71	java/lang/String:substring	(I)Ljava/lang/String;
    //   503: astore 8
    //   505: ldc_w 284
    //   508: aload 8
    //   510: invokestatic 299	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   513: invokevirtual 280	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   516: astore 5
    //   518: getstatic 37	com/tencent/mm/plugin/address/model/l:juN	Ljava/util/regex/Pattern;
    //   521: aload 5
    //   523: invokevirtual 303	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   526: astore 5
    //   528: aload 5
    //   530: arraylength
    //   531: iconst_3
    //   532: if_icmpne +284 -> 816
    //   535: new 98	com/tencent/mm/plugin/address/model/RcptItem
    //   538: dup
    //   539: aload 5
    //   541: iconst_1
    //   542: aaload
    //   543: aload 9
    //   545: aload 5
    //   547: iconst_2
    //   548: aaload
    //   549: invokespecial 306	com/tencent/mm/plugin/address/model/RcptItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   552: astore 5
    //   554: aload 5
    //   556: astore 7
    //   558: aload 9
    //   560: astore 5
    //   562: aload 7
    //   564: ifnonnull +258 -> 822
    //   567: ldc 169
    //   569: ldc_w 308
    //   572: aload 8
    //   574: invokestatic 299	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   577: invokevirtual 280	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   580: invokestatic 311	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: iload_1
    //   584: iconst_1
    //   585: iadd
    //   586: istore_1
    //   587: goto -199 -> 388
    //   590: aload 5
    //   592: invokevirtual 256	com/tencent/mm/vfs/q:close	()V
    //   595: aload 4
    //   597: invokevirtual 257	java/io/BufferedReader:close	()V
    //   600: iconst_1
    //   601: istore_3
    //   602: goto -363 -> 239
    //   605: astore 5
    //   607: ldc 169
    //   609: aload 5
    //   611: ldc 249
    //   613: iconst_0
    //   614: anewarray 4	java/lang/Object
    //   617: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: iconst_1
    //   621: istore_3
    //   622: goto -383 -> 239
    //   625: astore 5
    //   627: ldc 169
    //   629: aload 5
    //   631: ldc 249
    //   633: iconst_0
    //   634: anewarray 4	java/lang/Object
    //   637: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: goto -401 -> 239
    //   643: astore 4
    //   645: aconst_null
    //   646: astore 5
    //   648: aload 5
    //   650: ifnull +8 -> 658
    //   653: aload 5
    //   655: invokevirtual 256	com/tencent/mm/vfs/q:close	()V
    //   658: aload 7
    //   660: ifnull +8 -> 668
    //   663: aload 7
    //   665: invokevirtual 257	java/io/BufferedReader:close	()V
    //   668: sipush 20802
    //   671: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: aload 4
    //   676: athrow
    //   677: astore 5
    //   679: ldc 169
    //   681: aload 5
    //   683: ldc 249
    //   685: iconst_0
    //   686: anewarray 4	java/lang/Object
    //   689: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: goto -24 -> 668
    //   695: aload 6
    //   697: astore 5
    //   699: aload 6
    //   701: invokevirtual 257	java/io/BufferedReader:close	()V
    //   704: aload 6
    //   706: astore 5
    //   708: aload 7
    //   710: invokevirtual 314	java/io/InputStream:close	()V
    //   713: aload 6
    //   715: invokevirtual 257	java/io/BufferedReader:close	()V
    //   718: aload 7
    //   720: ifnull -365 -> 355
    //   723: goto -368 -> 355
    //   726: astore 4
    //   728: ldc 169
    //   730: aload 4
    //   732: ldc 249
    //   734: iconst_0
    //   735: anewarray 4	java/lang/Object
    //   738: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   741: goto -23 -> 718
    //   744: astore 4
    //   746: ldc 169
    //   748: aload 4
    //   750: ldc 249
    //   752: iconst_0
    //   753: anewarray 4	java/lang/Object
    //   756: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: goto -409 -> 350
    //   762: astore 6
    //   764: aload 4
    //   766: astore 5
    //   768: aload 6
    //   770: astore 4
    //   772: aload 5
    //   774: ifnull +8 -> 782
    //   777: aload 5
    //   779: invokevirtual 257	java/io/BufferedReader:close	()V
    //   782: sipush 20802
    //   785: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   788: aload 4
    //   790: athrow
    //   791: astore 5
    //   793: ldc 169
    //   795: aload 5
    //   797: ldc 249
    //   799: iconst_0
    //   800: anewarray 4	java/lang/Object
    //   803: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: goto -24 -> 782
    //   809: ldc 249
    //   811: astore 5
    //   813: goto -385 -> 428
    //   816: aconst_null
    //   817: astore 5
    //   819: goto -265 -> 554
    //   822: aload 8
    //   824: ldc_w 316
    //   827: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   830: ifeq +71 -> 901
    //   833: aload_0
    //   834: getfield 63	com/tencent/mm/plugin/address/model/l:juM	Ljava/util/HashMap;
    //   837: aload 4
    //   839: invokevirtual 112	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   842: ifne +20 -> 862
    //   845: aload_0
    //   846: getfield 63	com/tencent/mm/plugin/address/model/l:juM	Ljava/util/HashMap;
    //   849: aload 4
    //   851: new 53	java/util/ArrayList
    //   854: dup
    //   855: invokespecial 54	java/util/ArrayList:<init>	()V
    //   858: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   861: pop
    //   862: aload_0
    //   863: getfield 63	com/tencent/mm/plugin/address/model/l:juM	Ljava/util/HashMap;
    //   866: aload 4
    //   868: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   871: checkcast 79	java/util/List
    //   874: astore 5
    //   876: aload 5
    //   878: aload 7
    //   880: invokeinterface 247 2 0
    //   885: pop
    //   886: aload_0
    //   887: getfield 63	com/tencent/mm/plugin/address/model/l:juM	Ljava/util/HashMap;
    //   890: aload 4
    //   892: aload 5
    //   894: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   897: pop
    //   898: goto -315 -> 583
    //   901: aload 8
    //   903: ldc_w 322
    //   906: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   909: ifeq +92 -> 1001
    //   912: aload_0
    //   913: getfield 61	com/tencent/mm/plugin/address/model/l:juL	Ljava/util/HashMap;
    //   916: aload 6
    //   918: invokevirtual 112	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   921: ifne +20 -> 941
    //   924: aload_0
    //   925: getfield 61	com/tencent/mm/plugin/address/model/l:juL	Ljava/util/HashMap;
    //   928: aload 6
    //   930: new 53	java/util/ArrayList
    //   933: dup
    //   934: invokespecial 54	java/util/ArrayList:<init>	()V
    //   937: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   940: pop
    //   941: aload_0
    //   942: getfield 61	com/tencent/mm/plugin/address/model/l:juL	Ljava/util/HashMap;
    //   945: aload 6
    //   947: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   950: checkcast 79	java/util/List
    //   953: astore 4
    //   955: aload 11
    //   957: ldc_w 316
    //   960: invokestatic 324	com/tencent/mm/plugin/address/model/l:bV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   963: ifeq +9 -> 972
    //   966: aload 7
    //   968: iconst_1
    //   969: putfield 327	com/tencent/mm/plugin/address/model/RcptItem:juH	Z
    //   972: aload 4
    //   974: aload 7
    //   976: invokeinterface 247 2 0
    //   981: pop
    //   982: aload_0
    //   983: getfield 61	com/tencent/mm/plugin/address/model/l:juL	Ljava/util/HashMap;
    //   986: aload 6
    //   988: aload 4
    //   990: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   993: pop
    //   994: aload 5
    //   996: astore 4
    //   998: goto -415 -> 583
    //   1001: aload 8
    //   1003: ldc_w 284
    //   1006: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1009: ifeq +197 -> 1206
    //   1012: aload 11
    //   1014: ldc_w 322
    //   1017: invokestatic 324	com/tencent/mm/plugin/address/model/l:bV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1020: ifeq +9 -> 1029
    //   1023: aload 7
    //   1025: iconst_1
    //   1026: putfield 327	com/tencent/mm/plugin/address/model/RcptItem:juH	Z
    //   1029: aload_0
    //   1030: getfield 56	com/tencent/mm/plugin/address/model/l:juK	Ljava/util/List;
    //   1033: aload 7
    //   1035: invokeinterface 247 2 0
    //   1040: pop
    //   1041: aload 5
    //   1043: astore 6
    //   1045: goto -462 -> 583
    //   1048: aload_0
    //   1049: iconst_0
    //   1050: putfield 51	com/tencent/mm/plugin/address/model/l:juJ	Z
    //   1053: ldc_w 329
    //   1056: invokestatic 333	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1059: checkcast 329	com/tencent/mm/plugin/wxpay/a/a
    //   1062: invokeinterface 337 1 0
    //   1067: getstatic 343	com/tencent/mm/storage/am$a:IXn	Lcom/tencent/mm/storage/am$a;
    //   1070: aconst_null
    //   1071: invokevirtual 348	com/tencent/mm/wallet_core/c/aa:get	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1074: checkcast 67	java/lang/String
    //   1077: astore 4
    //   1079: aload 4
    //   1081: invokestatic 124	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   1084: ifne +32 -> 1116
    //   1087: aload 4
    //   1089: getstatic 354	d/n/d:ISO_8859_1	Ljava/nio/charset/Charset;
    //   1092: invokevirtual 358	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   1095: astore 4
    //   1097: aload_0
    //   1098: new 46	com/tencent/mm/plugin/address/d/a
    //   1101: dup
    //   1102: invokespecial 47	com/tencent/mm/plugin/address/d/a:<init>	()V
    //   1105: aload 4
    //   1107: invokevirtual 362	com/tencent/mm/plugin/address/d/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   1110: checkcast 46	com/tencent/mm/plugin/address/d/a
    //   1113: putfield 49	com/tencent/mm/plugin/address/model/l:juI	Lcom/tencent/mm/plugin/address/d/a;
    //   1116: sipush 20802
    //   1119: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: return
    //   1123: astore 4
    //   1125: ldc 169
    //   1127: aload 4
    //   1129: ldc 249
    //   1131: iconst_0
    //   1132: anewarray 4	java/lang/Object
    //   1135: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1138: sipush 20802
    //   1141: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: return
    //   1145: astore 4
    //   1147: goto -375 -> 772
    //   1150: astore 6
    //   1152: aconst_null
    //   1153: astore 7
    //   1155: goto -832 -> 323
    //   1158: astore 6
    //   1160: goto -837 -> 323
    //   1163: astore 4
    //   1165: aload 6
    //   1167: astore 5
    //   1169: goto -521 -> 648
    //   1172: astore 6
    //   1174: aload 4
    //   1176: astore 7
    //   1178: aload 6
    //   1180: astore 4
    //   1182: goto -534 -> 648
    //   1185: astore 8
    //   1187: aconst_null
    //   1188: astore 5
    //   1190: aload 9
    //   1192: astore 4
    //   1194: goto -996 -> 198
    //   1197: astore 8
    //   1199: aload 9
    //   1201: astore 4
    //   1203: goto -1005 -> 198
    //   1206: goto -623 -> 583
    //   1209: aconst_null
    //   1210: astore 7
    //   1212: goto -650 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	this	l
    //   387	200	1	i	int
    //   377	34	2	j	int
    //   115	507	3	bool	boolean
    //   100	496	4	localObject1	Object
    //   643	32	4	localObject2	Object
    //   726	5	4	localIOException1	java.io.IOException
    //   744	21	4	localIOException2	java.io.IOException
    //   770	336	4	localObject3	Object
    //   1123	5	4	localException1	Exception
    //   1145	1	4	localObject4	Object
    //   1163	12	4	localObject5	Object
    //   1180	22	4	localObject6	Object
    //   79	220	5	localObject7	Object
    //   313	7	5	localIOException3	java.io.IOException
    //   325	266	5	localObject8	Object
    //   605	5	5	localException2	Exception
    //   625	5	5	localException3	Exception
    //   646	8	5	localObject9	Object
    //   677	5	5	localException4	Exception
    //   697	81	5	localObject10	Object
    //   791	5	5	localIOException4	java.io.IOException
    //   811	378	5	localObject11	Object
    //   147	567	6	localObject12	Object
    //   762	225	6	localObject13	Object
    //   1043	1	6	localObject14	Object
    //   1150	1	6	localIOException5	java.io.IOException
    //   1158	8	6	localIOException6	java.io.IOException
    //   1172	7	6	localObject15	Object
    //   97	1114	7	localObject16	Object
    //   196	13	8	localIOException7	java.io.IOException
    //   448	554	8	str1	String
    //   1185	1	8	localIOException8	java.io.IOException
    //   1197	1	8	localIOException9	java.io.IOException
    //   103	1097	9	str2	String
    //   112	302	10	localArrayList	ArrayList
    //   94	919	11	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   164	171	196	java/io/IOException
    //   171	178	196	java/io/IOException
    //   183	193	196	java/io/IOException
    //   284	291	313	java/io/IOException
    //   300	310	313	java/io/IOException
    //   699	704	313	java/io/IOException
    //   708	713	313	java/io/IOException
    //   590	600	605	java/lang/Exception
    //   224	229	625	java/lang/Exception
    //   234	239	625	java/lang/Exception
    //   116	145	643	finally
    //   653	658	677	java/lang/Exception
    //   663	668	677	java/lang/Exception
    //   713	718	726	java/io/IOException
    //   345	350	744	java/io/IOException
    //   243	259	762	finally
    //   259	280	762	finally
    //   777	782	791	java/io/IOException
    //   1053	1116	1123	java/lang/Exception
    //   284	291	1145	finally
    //   300	310	1145	finally
    //   327	340	1145	finally
    //   699	704	1145	finally
    //   708	713	1145	finally
    //   243	259	1150	java/io/IOException
    //   259	280	1158	java/io/IOException
    //   153	164	1163	finally
    //   206	219	1163	finally
    //   164	171	1172	finally
    //   171	178	1172	finally
    //   183	193	1172	finally
    //   116	145	1185	java/io/IOException
    //   153	164	1197	java/io/IOException
  }
  
  public final void aVu()
  {
    AppMethodBeat.i(20806);
    try
    {
      byte[] arrayOfByte = this.juI.toByteArray();
      long l = System.currentTimeMillis();
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXn, new String(arrayOfByte, d.ISO_8859_1));
      ae.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20806);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WalletAddrMgr", localException, "", new Object[0]);
      AppMethodBeat.o(20806);
    }
  }
  
  public final RcptItem bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20813);
    paramString1 = KC(paramString1);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(20813);
      return null;
    }
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)paramString1.next();
      if (localRcptItem.name.startsWith(paramString2))
      {
        AppMethodBeat.o(20813);
        return localRcptItem;
      }
    }
    AppMethodBeat.o(20813);
    return null;
  }
  
  public final b rz(int paramInt)
  {
    AppMethodBeat.i(20803);
    int i = 0;
    while (i < this.juI.juR.size())
    {
      b localb = (b)this.juI.juR.get(i);
      if (localb.id == paramInt)
      {
        AppMethodBeat.o(20803);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(20803);
    return null;
  }
  
  public final boolean t(LinkedList<crl> paramLinkedList)
  {
    AppMethodBeat.i(20805);
    this.juI.juR.clear();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      crl localcrl = (crl)paramLinkedList.next();
      b localb = new b();
      localb.id = localcrl.id;
      localb.jva = localcrl.HCQ.HId;
      localb.juU = localcrl.HCK.HId;
      localb.juX = localcrl.HCN.HId;
      localb.juV = localcrl.HCL.HId;
      localb.juY = localcrl.HCO.HId;
      localb.juZ = localcrl.HCP.HId;
      localb.juT = localcrl.HCJ.HId;
      localb.juW = localcrl.HCM.HId;
      this.juI.juR.add(localb);
    }
    AppMethodBeat.o(20805);
    return true;
  }
  
  public final RcptItem x(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20815);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(20815);
      return null;
    }
    paramString1 = f(this.juK, paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(20815);
      return null;
    }
    paramString1 = f(KC(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(20815);
      return null;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(20815);
      return paramString1;
    }
    paramString2 = f(KD(paramString1.code), paramString3);
    if (paramString2 == null)
    {
      AppMethodBeat.o(20815);
      return paramString1;
    }
    AppMethodBeat.o(20815);
    return paramString2;
  }
  
  public final boolean y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20817);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(20817);
      return false;
    }
    paramString1 = f(this.juK, paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(20817);
      return false;
    }
    paramString1 = f(KC(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(20817);
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(20817);
      return true;
    }
    if (f(KD(paramString1.code), paramString3) == null)
    {
      AppMethodBeat.o(20817);
      return false;
    }
    AppMethodBeat.o(20817);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.l
 * JD-Core Version:    0.7.0.1
 */