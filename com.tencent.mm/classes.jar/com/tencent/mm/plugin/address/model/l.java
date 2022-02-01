package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.n.d;

public final class l
{
  public com.tencent.mm.plugin.address.d.a nkJ;
  public boolean nkK;
  public final HashMap<Integer, RcptItem> nkL;
  public final List<RcptItem> nkM;
  
  public l()
  {
    AppMethodBeat.i(20801);
    this.nkJ = new com.tencent.mm.plugin.address.d.a();
    this.nkK = false;
    this.nkL = new HashMap();
    this.nkM = new ArrayList();
    AppMethodBeat.o(20801);
  }
  
  private static String[] abm(String paramString)
  {
    AppMethodBeat.i(241950);
    if (paramString == null)
    {
      AppMethodBeat.o(241950);
      return null;
    }
    int n = paramString.length();
    if (n == 0)
    {
      AppMethodBeat.o(241950);
      return new String[0];
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < n) {
      if ((paramString.charAt(i) == ' ') || (paramString.charAt(i) == '\t'))
      {
        int m = j;
        if (j != 0)
        {
          localArrayList.add(paramString.substring(k, i));
          m = 0;
        }
        i += 1;
        k = i;
        j = m;
      }
      else
      {
        j = 1;
        i += 1;
      }
    }
    if (j != 0) {
      localArrayList.add(paramString.substring(k, i));
    }
    paramString = (String[])localArrayList.toArray(new String[0]);
    AppMethodBeat.o(241950);
    return paramString;
  }
  
  private static RcptItem e(List<RcptItem> paramList, String paramString)
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
      if ((localRcptItem == null) || (!paramString.startsWith(localRcptItem.name))) {}
    }
    for (paramList = localRcptItem;; paramList = null)
    {
      AppMethodBeat.o(20816);
      return paramList;
      i += 1;
      break;
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(20804);
    if (this.nkJ == null) {
      this.nkJ = new com.tencent.mm.plugin.address.d.a();
    }
    int i = 0;
    while (i < this.nkJ.nkS.size())
    {
      if (((b)this.nkJ.nkS.get(i)).id == paramb.id)
      {
        this.nkJ.nkS.remove(i);
        AppMethodBeat.o(20804);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(20804);
    return false;
  }
  
  public final RcptItem abl(String paramString)
  {
    AppMethodBeat.i(20812);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20812);
      return null;
    }
    Iterator localIterator = kc(0).iterator();
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
  
  /* Error */
  public final void bAr()
  {
    // Byte code:
    //   0: ldc 153
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 159	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: ldc 161
    //   11: ldc 163
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: invokestatic 169	com/tencent/mm/model/c:getAccPath	()Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 31	com/tencent/mm/plugin/address/model/l:nkK	Z
    //   30: ifne +15 -> 45
    //   33: aload_0
    //   34: getfield 41	com/tencent/mm/plugin/address/model/l:nkM	Ljava/util/List;
    //   37: invokeinterface 80 1 0
    //   42: ifeq +713 -> 755
    //   45: ldc 161
    //   47: ldc 176
    //   49: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokestatic 185	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   55: pop
    //   56: bipush 89
    //   58: iconst_1
    //   59: invokestatic 188	com/tencent/mm/pluginsdk/k/a/a/b:lV	(II)Ljava/lang/String;
    //   62: astore 9
    //   64: new 38	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 39	java/util/ArrayList:<init>	()V
    //   71: astore 14
    //   73: aload 9
    //   75: invokestatic 193	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   78: ifeq +750 -> 828
    //   81: new 195	com/tencent/mm/vfs/x
    //   84: dup
    //   85: aload 9
    //   87: invokespecial 198	com/tencent/mm/vfs/x:<init>	(Ljava/lang/String;)V
    //   90: astore 10
    //   92: new 200	java/io/BufferedReader
    //   95: dup
    //   96: aload 10
    //   98: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   101: astore 9
    //   103: aload 9
    //   105: astore 12
    //   107: aload 10
    //   109: astore 11
    //   111: aload 14
    //   113: invokeinterface 206 1 0
    //   118: aload 9
    //   120: astore 12
    //   122: aload 10
    //   124: astore 11
    //   126: aload 9
    //   128: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore 13
    //   133: aload 13
    //   135: ifnull +358 -> 493
    //   138: aload 9
    //   140: astore 12
    //   142: aload 10
    //   144: astore 11
    //   146: aload 14
    //   148: aload 13
    //   150: invokeinterface 68 2 0
    //   155: pop
    //   156: goto -38 -> 118
    //   159: astore 13
    //   161: aload 9
    //   163: astore 12
    //   165: aload 10
    //   167: astore 11
    //   169: ldc 161
    //   171: aload 13
    //   173: ldc 211
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload 10
    //   184: ifnull +8 -> 192
    //   187: aload 10
    //   189: invokevirtual 218	com/tencent/mm/vfs/x:close	()V
    //   192: aload 9
    //   194: ifnull +8 -> 202
    //   197: aload 9
    //   199: invokevirtual 219	java/io/BufferedReader:close	()V
    //   202: iconst_0
    //   203: istore 4
    //   205: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   208: lstore 5
    //   210: iload 4
    //   212: ifne +110 -> 322
    //   215: invokestatic 231	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   218: invokevirtual 237	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   221: astore 10
    //   223: aload 14
    //   225: invokeinterface 206 1 0
    //   230: aload 10
    //   232: ldc 239
    //   234: invokevirtual 245	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   237: astore 11
    //   239: new 200	java/io/BufferedReader
    //   242: dup
    //   243: new 247	java/io/InputStreamReader
    //   246: dup
    //   247: aload 11
    //   249: ldc 249
    //   251: invokespecial 252	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   257: astore 10
    //   259: aload 10
    //   261: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +337 -> 605
    //   271: aload 14
    //   273: aload 9
    //   275: invokeinterface 68 2 0
    //   280: pop
    //   281: goto -22 -> 259
    //   284: astore 12
    //   286: aload 10
    //   288: astore 9
    //   290: aload 12
    //   292: astore 10
    //   294: ldc 161
    //   296: aload 10
    //   298: ldc 211
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload 9
    //   309: ifnull +8 -> 317
    //   312: aload 9
    //   314: invokevirtual 219	java/io/BufferedReader:close	()V
    //   317: aload 11
    //   319: ifnull +3 -> 322
    //   322: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   325: lstore 7
    //   327: ldc 161
    //   329: ldc 254
    //   331: iload 4
    //   333: invokestatic 258	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   336: invokevirtual 262	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload 14
    //   344: invokeinterface 88 1 0
    //   349: istore_3
    //   350: ldc_w 267
    //   353: invokestatic 273	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   356: pop
    //   357: iconst_0
    //   358: istore_1
    //   359: iload_1
    //   360: iload_3
    //   361: if_icmpge +354 -> 715
    //   364: aload 14
    //   366: iload_1
    //   367: invokeinterface 92 2 0
    //   372: checkcast 50	java/lang/String
    //   375: invokestatic 275	com/tencent/mm/plugin/address/model/l:abm	(Ljava/lang/String;)[Ljava/lang/String;
    //   378: astore 9
    //   380: aload 9
    //   382: arraylength
    //   383: iconst_3
    //   384: if_icmplt +102 -> 486
    //   387: new 94	com/tencent/mm/plugin/address/model/RcptItem
    //   390: dup
    //   391: aload 9
    //   393: iconst_1
    //   394: aaload
    //   395: aload 9
    //   397: iconst_0
    //   398: aaload
    //   399: aload 9
    //   401: iconst_2
    //   402: aaload
    //   403: invokespecial 278	com/tencent/mm/plugin/address/model/RcptItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   406: astore 9
    //   408: aload 9
    //   410: getfield 281	com/tencent/mm/plugin/address/model/RcptItem:type	I
    //   413: getstatic 284	com/tencent/mm/plugin/address/model/RcptItem:nkG	I
    //   416: if_icmpne +294 -> 710
    //   419: iconst_1
    //   420: istore_2
    //   421: iload_2
    //   422: ifeq +31 -> 453
    //   425: aload 9
    //   427: getfield 98	com/tencent/mm/plugin/address/model/RcptItem:name	Ljava/lang/String;
    //   430: ldc_w 286
    //   433: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +17 -> 453
    //   439: aload 9
    //   441: getfield 292	com/tencent/mm/plugin/address/model/RcptItem:nkC	Ljava/lang/String;
    //   444: ldc_w 294
    //   447: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifne +36 -> 486
    //   453: aload_0
    //   454: getfield 36	com/tencent/mm/plugin/address/model/l:nkL	Ljava/util/HashMap;
    //   457: aload 9
    //   459: getfield 297	com/tencent/mm/plugin/address/model/RcptItem:code	Ljava/lang/String;
    //   462: invokevirtual 300	java/lang/String:hashCode	()I
    //   465: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aload 9
    //   470: invokevirtual 309	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: pop
    //   474: aload_0
    //   475: getfield 41	com/tencent/mm/plugin/address/model/l:nkM	Ljava/util/List;
    //   478: aload 9
    //   480: invokeinterface 68 2 0
    //   485: pop
    //   486: iload_1
    //   487: iconst_1
    //   488: iadd
    //   489: istore_1
    //   490: goto -131 -> 359
    //   493: aload 10
    //   495: invokevirtual 218	com/tencent/mm/vfs/x:close	()V
    //   498: aload 9
    //   500: invokevirtual 219	java/io/BufferedReader:close	()V
    //   503: iconst_1
    //   504: istore 4
    //   506: goto -301 -> 205
    //   509: astore 10
    //   511: ldc 161
    //   513: aload 10
    //   515: ldc 211
    //   517: iconst_0
    //   518: anewarray 4	java/lang/Object
    //   521: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: iconst_1
    //   525: istore 4
    //   527: goto -322 -> 205
    //   530: astore 10
    //   532: ldc 161
    //   534: aload 10
    //   536: ldc 211
    //   538: iconst_0
    //   539: anewarray 4	java/lang/Object
    //   542: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: iconst_0
    //   546: istore 4
    //   548: goto -343 -> 205
    //   551: astore 9
    //   553: aconst_null
    //   554: astore 10
    //   556: aconst_null
    //   557: astore 12
    //   559: aload 10
    //   561: ifnull +8 -> 569
    //   564: aload 10
    //   566: invokevirtual 218	com/tencent/mm/vfs/x:close	()V
    //   569: aload 12
    //   571: ifnull +8 -> 579
    //   574: aload 12
    //   576: invokevirtual 219	java/io/BufferedReader:close	()V
    //   579: ldc 153
    //   581: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   584: aload 9
    //   586: athrow
    //   587: astore 10
    //   589: ldc 161
    //   591: aload 10
    //   593: ldc 211
    //   595: iconst_0
    //   596: anewarray 4	java/lang/Object
    //   599: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   602: goto -23 -> 579
    //   605: aload 10
    //   607: invokevirtual 219	java/io/BufferedReader:close	()V
    //   610: aload 11
    //   612: invokevirtual 312	java/io/InputStream:close	()V
    //   615: aload 10
    //   617: invokevirtual 219	java/io/BufferedReader:close	()V
    //   620: aload 11
    //   622: ifnull -300 -> 322
    //   625: goto -303 -> 322
    //   628: astore 9
    //   630: ldc 161
    //   632: aload 9
    //   634: ldc 211
    //   636: iconst_0
    //   637: anewarray 4	java/lang/Object
    //   640: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: goto -23 -> 620
    //   646: astore 9
    //   648: ldc 161
    //   650: aload 9
    //   652: ldc 211
    //   654: iconst_0
    //   655: anewarray 4	java/lang/Object
    //   658: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   661: goto -344 -> 317
    //   664: astore 11
    //   666: aload 9
    //   668: astore 10
    //   670: aload 11
    //   672: astore 9
    //   674: aload 10
    //   676: ifnull +8 -> 684
    //   679: aload 10
    //   681: invokevirtual 219	java/io/BufferedReader:close	()V
    //   684: ldc 153
    //   686: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   689: aload 9
    //   691: athrow
    //   692: astore 10
    //   694: ldc 161
    //   696: aload 10
    //   698: ldc 211
    //   700: iconst_0
    //   701: anewarray 4	java/lang/Object
    //   704: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   707: goto -23 -> 684
    //   710: iconst_0
    //   711: istore_2
    //   712: goto -291 -> 421
    //   715: ldc 161
    //   717: ldc_w 314
    //   720: iconst_2
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: lload 7
    //   728: lload 5
    //   730: lsub
    //   731: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   740: lload 7
    //   742: lsub
    //   743: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   746: aastore
    //   747: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   750: aload_0
    //   751: iconst_0
    //   752: putfield 31	com/tencent/mm/plugin/address/model/l:nkK	Z
    //   755: ldc 153
    //   757: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   760: return
    //   761: astore 9
    //   763: goto -89 -> 674
    //   766: astore 11
    //   768: aload 9
    //   770: astore 10
    //   772: aload 11
    //   774: astore 9
    //   776: goto -102 -> 674
    //   779: astore 10
    //   781: aconst_null
    //   782: astore 11
    //   784: goto -490 -> 294
    //   787: astore 10
    //   789: goto -495 -> 294
    //   792: astore 9
    //   794: aconst_null
    //   795: astore 12
    //   797: goto -238 -> 559
    //   800: astore 9
    //   802: aload 11
    //   804: astore 10
    //   806: goto -247 -> 559
    //   809: astore 13
    //   811: aconst_null
    //   812: astore 10
    //   814: aconst_null
    //   815: astore 9
    //   817: goto -656 -> 161
    //   820: astore 13
    //   822: aconst_null
    //   823: astore 9
    //   825: goto -664 -> 161
    //   828: iconst_0
    //   829: istore 4
    //   831: aconst_null
    //   832: astore 9
    //   834: goto -629 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	l
    //   358	132	1	i	int
    //   420	292	2	j	int
    //   349	13	3	k	int
    //   203	627	4	bool	boolean
    //   208	521	5	l1	long
    //   325	416	7	l2	long
    //   62	437	9	localObject1	Object
    //   551	34	9	localObject2	Object
    //   628	5	9	localIOException1	java.io.IOException
    //   646	21	9	localIOException2	java.io.IOException
    //   672	18	9	localObject3	Object
    //   761	8	9	localObject4	Object
    //   774	1	9	localObject5	Object
    //   792	1	9	localObject6	Object
    //   800	1	9	localObject7	Object
    //   815	18	9	localObject8	Object
    //   90	404	10	localObject9	Object
    //   509	5	10	localException1	Exception
    //   530	5	10	localException2	Exception
    //   554	11	10	localObject10	Object
    //   587	29	10	localException3	Exception
    //   668	12	10	localIOException3	java.io.IOException
    //   692	5	10	localIOException4	java.io.IOException
    //   770	1	10	localObject11	Object
    //   779	1	10	localIOException5	java.io.IOException
    //   787	1	10	localIOException6	java.io.IOException
    //   804	9	10	localObject12	Object
    //   109	512	11	localObject13	Object
    //   664	7	11	localObject14	Object
    //   766	7	11	localObject15	Object
    //   782	21	11	localObject16	Object
    //   105	59	12	localObject17	Object
    //   284	7	12	localIOException7	java.io.IOException
    //   557	239	12	localObject18	Object
    //   131	18	13	str	String
    //   159	13	13	localIOException8	java.io.IOException
    //   809	1	13	localIOException9	java.io.IOException
    //   820	1	13	localIOException10	java.io.IOException
    //   71	294	14	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   111	118	159	java/io/IOException
    //   126	133	159	java/io/IOException
    //   146	156	159	java/io/IOException
    //   259	266	284	java/io/IOException
    //   271	281	284	java/io/IOException
    //   605	615	284	java/io/IOException
    //   493	503	509	java/lang/Exception
    //   187	192	530	java/lang/Exception
    //   197	202	530	java/lang/Exception
    //   81	92	551	finally
    //   564	569	587	java/lang/Exception
    //   574	579	587	java/lang/Exception
    //   615	620	628	java/io/IOException
    //   312	317	646	java/io/IOException
    //   230	239	664	finally
    //   239	259	664	finally
    //   679	684	692	java/io/IOException
    //   259	266	761	finally
    //   271	281	761	finally
    //   605	615	761	finally
    //   294	307	766	finally
    //   230	239	779	java/io/IOException
    //   239	259	787	java/io/IOException
    //   92	103	792	finally
    //   111	118	800	finally
    //   126	133	800	finally
    //   146	156	800	finally
    //   169	182	800	finally
    //   81	92	809	java/io/IOException
    //   92	103	820	java/io/IOException
  }
  
  public final void bAs()
  {
    AppMethodBeat.i(20806);
    try
    {
      byte[] arrayOfByte = this.nkJ.toByteArray();
      long l = System.currentTimeMillis();
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VtU, new String(arrayOfByte, d.ISO_8859_1));
      Log.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20806);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WalletAddrMgr", localException, "", new Object[0]);
      AppMethodBeat.o(20806);
    }
  }
  
  public final List<RcptItem> bkE(String paramString)
  {
    AppMethodBeat.i(292999);
    if (Util.isNullOrNil(paramString)) {}
    for (int i = 0;; i = paramString.hashCode())
    {
      paramString = kc(i);
      AppMethodBeat.o(292999);
      return paramString;
    }
  }
  
  public final RcptItem cj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20813);
    paramString1 = bkE(paramString1);
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
  
  public final RcptItem g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(293002);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(293002);
      return null;
    }
    paramString1 = e(kc(0), paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(293002);
      return null;
    }
    paramString1 = e(bkE(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(293002);
      return null;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(293002);
      return paramString1;
    }
    paramString2 = e(bkE(paramString1.code), paramString3);
    if (paramString2 == null)
    {
      AppMethodBeat.o(293002);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      AppMethodBeat.o(293002);
      return paramString2;
    }
    paramString1 = e(bkE(paramString2.code), paramString4);
    if (paramString1 == null)
    {
      AppMethodBeat.o(293002);
      return paramString2;
    }
    AppMethodBeat.o(293002);
    return paramString1;
  }
  
  public final List<RcptItem> kc(int paramInt)
  {
    AppMethodBeat.i(293000);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.nkM.iterator();
    while (localIterator.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)localIterator.next();
      if (localRcptItem.nkI == paramInt) {
        localArrayList.add(localRcptItem);
      }
    }
    AppMethodBeat.o(293000);
    return localArrayList;
  }
  
  public final boolean u(LinkedList<dsz> paramLinkedList)
  {
    AppMethodBeat.i(20805);
    this.nkJ.nkS.clear();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (dsz)paramLinkedList.next();
      b localb = new b();
      localb.id = ((dsz)localObject).id;
      localb.nlb = ((dsz)localObject).TZx.Ufy;
      localb.nkV = ((dsz)localObject).TZr.Ufy;
      localb.nkY = ((dsz)localObject).TZu.Ufy;
      localb.nkW = ((dsz)localObject).TZs.Ufy;
      localb.nkZ = ((dsz)localObject).TZv.Ufy;
      localb.nla = ((dsz)localObject).TZw.Ufy;
      localb.nkU = ((dsz)localObject).TZq.Ufy;
      localb.nkX = ((dsz)localObject).TZt.Ufy;
      localb.nlc = ((dsz)localObject).TZy.Ufy;
      localObject = g(localb.nkU, localb.nkV, localb.nkW, localb.nlc);
      if (((localObject != null) && (!((RcptItem)localObject).bAq())) || ((localb.nkW != null) && (localb.nkW.equals(localb.nlc))) || ("undefined".equalsIgnoreCase(localb.nlc)) || ("null".equalsIgnoreCase(localb.nlc))) {
        localb.nlc = "";
      }
      this.nkJ.nkS.add(localb);
    }
    AppMethodBeat.o(20805);
    return true;
  }
  
  public final RcptItem vw(int paramInt)
  {
    AppMethodBeat.i(293001);
    RcptItem localRcptItem = (RcptItem)this.nkL.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(293001);
    return localRcptItem;
  }
  
  public final b yt(int paramInt)
  {
    AppMethodBeat.i(20803);
    int i = 0;
    while (i < this.nkJ.nkS.size())
    {
      b localb = (b)this.nkJ.nkS.get(i);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.l
 * JD-Core Version:    0.7.0.1
 */