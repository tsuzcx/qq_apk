package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.elu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.n.d;

public final class j
{
  public com.tencent.mm.plugin.address.d.a qhS;
  public boolean qhT;
  public final HashMap<Integer, RcptItem> qhU;
  public final List<RcptItem> qhV;
  
  public j()
  {
    AppMethodBeat.i(20801);
    this.qhS = new com.tencent.mm.plugin.address.d.a();
    this.qhT = false;
    this.qhU = new HashMap();
    this.qhV = new ArrayList();
    AppMethodBeat.o(20801);
  }
  
  private static String[] TD(String paramString)
  {
    AppMethodBeat.i(267139);
    if (paramString == null)
    {
      AppMethodBeat.o(267139);
      return null;
    }
    int n = paramString.length();
    if (n == 0)
    {
      AppMethodBeat.o(267139);
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
    AppMethodBeat.o(267139);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.address.d.a parama)
  {
    AppMethodBeat.i(267138);
    if (parama != null) {}
    try
    {
      Object localObject = parama.qib;
      if (localObject == null)
      {
        AppMethodBeat.o(267138);
        return;
      }
      Iterator localIterator = parama.qib.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.qih != null)
        {
          localObject = localb.qih;
          parama = (com.tencent.mm.plugin.address.d.a)localObject;
          if (((String)localObject).startsWith(localb.qid)) {
            parama = ((String)localObject).replaceFirst(localb.qid, "");
          }
          localObject = parama;
          if (parama.startsWith(localb.qie)) {
            localObject = parama.replaceFirst(localb.qie, "");
          }
          parama = (com.tencent.mm.plugin.address.d.a)localObject;
          if (((String)localObject).startsWith(localb.qif)) {
            parama = ((String)localObject).replaceFirst(localb.qif, "");
          }
          localObject = parama;
          if (parama.startsWith(localb.qil)) {
            localObject = parama.replaceFirst(localb.qil, "");
          }
          if (!localb.qih.equalsIgnoreCase((String)localObject)) {
            Log.i("MicroMsg.WalletAddrMgr", "clean dirty data, %s, %s", new Object[] { localb.qih, localObject });
          }
          localb.qih = ((String)localObject);
        }
      }
      AppMethodBeat.o(267138);
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace("MicroMsg.WalletAddrMgr", parama, null, new Object[0]);
      AppMethodBeat.o(267138);
      return;
    }
  }
  
  public static RcptItem g(List<RcptItem> paramList, String paramString)
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
  
  public final List<RcptItem> TB(String paramString)
  {
    AppMethodBeat.i(267150);
    if (Util.isNullOrNil(paramString)) {}
    for (int i = 0;; i = paramString.hashCode())
    {
      paramString = yA(i);
      AppMethodBeat.o(267150);
      return paramString;
    }
  }
  
  public final RcptItem TC(String paramString)
  {
    AppMethodBeat.i(20812);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20812);
      return null;
    }
    Iterator localIterator = yA(0).iterator();
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
    if (this.qhS == null) {
      this.qhS = new com.tencent.mm.plugin.address.d.a();
    }
    int i = 0;
    while (i < this.qhS.qib.size())
    {
      if (((b)this.qhS.qib.get(i)).id == paramb.id)
      {
        this.qhS.qib.remove(i);
        AppMethodBeat.o(20804);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(20804);
    return false;
  }
  
  /* Error */
  public final void bZi()
  {
    // Byte code:
    //   0: ldc 200
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 31	com/tencent/mm/plugin/address/model/j:qhT	Z
    //   9: ifne +15 -> 24
    //   12: aload_0
    //   13: getfield 41	com/tencent/mm/plugin/address/model/j:qhV	Ljava/util/List;
    //   16: invokeinterface 148 1 0
    //   21: ifeq +709 -> 730
    //   24: ldc 132
    //   26: ldc 202
    //   28: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 211	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/CheckResUpdateIPCUtils:iJm	()Ljava/lang/String;
    //   34: astore 9
    //   36: new 38	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 39	java/util/ArrayList:<init>	()V
    //   43: astore 14
    //   45: aload 9
    //   47: invokestatic 216	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   50: ifeq +753 -> 803
    //   53: new 218	com/tencent/mm/vfs/ab
    //   56: dup
    //   57: aload 9
    //   59: invokespecial 221	com/tencent/mm/vfs/ab:<init>	(Ljava/lang/String;)V
    //   62: astore 10
    //   64: new 223	java/io/BufferedReader
    //   67: dup
    //   68: aload 10
    //   70: invokespecial 226	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   73: astore 9
    //   75: aload 9
    //   77: astore 12
    //   79: aload 10
    //   81: astore 11
    //   83: aload 14
    //   85: invokeinterface 229 1 0
    //   90: aload 9
    //   92: astore 12
    //   94: aload 10
    //   96: astore 11
    //   98: aload 9
    //   100: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   103: astore 13
    //   105: aload 13
    //   107: ifnull +361 -> 468
    //   110: aload 9
    //   112: astore 12
    //   114: aload 10
    //   116: astore 11
    //   118: aload 14
    //   120: aload 13
    //   122: invokeinterface 68 2 0
    //   127: pop
    //   128: goto -38 -> 90
    //   131: astore 13
    //   133: aload 9
    //   135: astore 12
    //   137: aload 10
    //   139: astore 11
    //   141: ldc 132
    //   143: aload 13
    //   145: ldc 114
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload 10
    //   156: ifnull +8 -> 164
    //   159: aload 10
    //   161: invokevirtual 235	com/tencent/mm/vfs/ab:close	()V
    //   164: aload 9
    //   166: ifnull +8 -> 174
    //   169: aload 9
    //   171: invokevirtual 236	java/io/BufferedReader:close	()V
    //   174: iconst_0
    //   175: istore 4
    //   177: invokestatic 242	java/lang/System:currentTimeMillis	()J
    //   180: lstore 5
    //   182: iload 4
    //   184: ifne +112 -> 296
    //   187: invokestatic 248	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   190: invokevirtual 254	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   193: astore 10
    //   195: aload 14
    //   197: invokeinterface 229 1 0
    //   202: aload 10
    //   204: ldc_w 256
    //   207: invokevirtual 262	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   210: astore 11
    //   212: new 223	java/io/BufferedReader
    //   215: dup
    //   216: new 264	java/io/InputStreamReader
    //   219: dup
    //   220: aload 11
    //   222: ldc_w 266
    //   225: invokespecial 269	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   228: invokespecial 226	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   231: astore 10
    //   233: aload 10
    //   235: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   238: astore 9
    //   240: aload 9
    //   242: ifnull +338 -> 580
    //   245: aload 14
    //   247: aload 9
    //   249: invokeinterface 68 2 0
    //   254: pop
    //   255: goto -22 -> 233
    //   258: astore 12
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: ldc 132
    //   270: aload 10
    //   272: ldc 114
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: aload 9
    //   283: ifnull +8 -> 291
    //   286: aload 9
    //   288: invokevirtual 236	java/io/BufferedReader:close	()V
    //   291: aload 11
    //   293: ifnull +3 -> 296
    //   296: invokestatic 242	java/lang/System:currentTimeMillis	()J
    //   299: lstore 7
    //   301: ldc 132
    //   303: ldc_w 271
    //   306: iload 4
    //   308: invokestatic 275	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   311: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload 14
    //   319: invokeinterface 156 1 0
    //   324: istore_3
    //   325: ldc_w 284
    //   328: invokestatic 290	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   331: pop
    //   332: iconst_0
    //   333: istore_1
    //   334: iload_1
    //   335: iload_3
    //   336: if_icmpge +354 -> 690
    //   339: aload 14
    //   341: iload_1
    //   342: invokeinterface 160 2 0
    //   347: checkcast 50	java/lang/String
    //   350: invokestatic 292	com/tencent/mm/plugin/address/model/j:TD	(Ljava/lang/String;)[Ljava/lang/String;
    //   353: astore 9
    //   355: aload 9
    //   357: arraylength
    //   358: iconst_3
    //   359: if_icmplt +102 -> 461
    //   362: new 162	com/tencent/mm/plugin/address/model/RcptItem
    //   365: dup
    //   366: aload 9
    //   368: iconst_1
    //   369: aaload
    //   370: aload 9
    //   372: iconst_0
    //   373: aaload
    //   374: aload 9
    //   376: iconst_2
    //   377: aaload
    //   378: invokespecial 295	com/tencent/mm/plugin/address/model/RcptItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   381: astore 9
    //   383: aload 9
    //   385: getfield 298	com/tencent/mm/plugin/address/model/RcptItem:type	I
    //   388: getstatic 301	com/tencent/mm/plugin/address/model/RcptItem:qhP	I
    //   391: if_icmpne +294 -> 685
    //   394: iconst_1
    //   395: istore_2
    //   396: iload_2
    //   397: ifeq +31 -> 428
    //   400: aload 9
    //   402: getfield 165	com/tencent/mm/plugin/address/model/RcptItem:name	Ljava/lang/String;
    //   405: ldc_w 303
    //   408: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   411: ifeq +17 -> 428
    //   414: aload 9
    //   416: getfield 309	com/tencent/mm/plugin/address/model/RcptItem:qhL	Ljava/lang/String;
    //   419: ldc_w 311
    //   422: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   425: ifne +36 -> 461
    //   428: aload_0
    //   429: getfield 36	com/tencent/mm/plugin/address/model/j:qhU	Ljava/util/HashMap;
    //   432: aload 9
    //   434: getfield 314	com/tencent/mm/plugin/address/model/RcptItem:code	Ljava/lang/String;
    //   437: invokevirtual 182	java/lang/String:hashCode	()I
    //   440: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: aload 9
    //   445: invokevirtual 323	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: pop
    //   449: aload_0
    //   450: getfield 41	com/tencent/mm/plugin/address/model/j:qhV	Ljava/util/List;
    //   453: aload 9
    //   455: invokeinterface 68 2 0
    //   460: pop
    //   461: iload_1
    //   462: iconst_1
    //   463: iadd
    //   464: istore_1
    //   465: goto -131 -> 334
    //   468: aload 10
    //   470: invokevirtual 235	com/tencent/mm/vfs/ab:close	()V
    //   473: aload 9
    //   475: invokevirtual 236	java/io/BufferedReader:close	()V
    //   478: iconst_1
    //   479: istore 4
    //   481: goto -304 -> 177
    //   484: astore 10
    //   486: ldc 132
    //   488: aload 10
    //   490: ldc 114
    //   492: iconst_0
    //   493: anewarray 4	java/lang/Object
    //   496: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   499: iconst_1
    //   500: istore 4
    //   502: goto -325 -> 177
    //   505: astore 10
    //   507: ldc 132
    //   509: aload 10
    //   511: ldc 114
    //   513: iconst_0
    //   514: anewarray 4	java/lang/Object
    //   517: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: iconst_0
    //   521: istore 4
    //   523: goto -346 -> 177
    //   526: astore 9
    //   528: aconst_null
    //   529: astore 10
    //   531: aconst_null
    //   532: astore 12
    //   534: aload 10
    //   536: ifnull +8 -> 544
    //   539: aload 10
    //   541: invokevirtual 235	com/tencent/mm/vfs/ab:close	()V
    //   544: aload 12
    //   546: ifnull +8 -> 554
    //   549: aload 12
    //   551: invokevirtual 236	java/io/BufferedReader:close	()V
    //   554: ldc 200
    //   556: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload 9
    //   561: athrow
    //   562: astore 10
    //   564: ldc 132
    //   566: aload 10
    //   568: ldc 114
    //   570: iconst_0
    //   571: anewarray 4	java/lang/Object
    //   574: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: goto -23 -> 554
    //   580: aload 10
    //   582: invokevirtual 236	java/io/BufferedReader:close	()V
    //   585: aload 11
    //   587: invokevirtual 326	java/io/InputStream:close	()V
    //   590: aload 10
    //   592: invokevirtual 236	java/io/BufferedReader:close	()V
    //   595: aload 11
    //   597: ifnull -301 -> 296
    //   600: goto -304 -> 296
    //   603: astore 9
    //   605: ldc 132
    //   607: aload 9
    //   609: ldc 114
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto -23 -> 595
    //   621: astore 9
    //   623: ldc 132
    //   625: aload 9
    //   627: ldc 114
    //   629: iconst_0
    //   630: anewarray 4	java/lang/Object
    //   633: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: goto -345 -> 291
    //   639: astore 11
    //   641: aload 9
    //   643: astore 10
    //   645: aload 11
    //   647: astore 9
    //   649: aload 10
    //   651: ifnull +8 -> 659
    //   654: aload 10
    //   656: invokevirtual 236	java/io/BufferedReader:close	()V
    //   659: ldc 200
    //   661: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: aload 9
    //   666: athrow
    //   667: astore 10
    //   669: ldc 132
    //   671: aload 10
    //   673: ldc 114
    //   675: iconst_0
    //   676: anewarray 4	java/lang/Object
    //   679: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   682: goto -23 -> 659
    //   685: iconst_0
    //   686: istore_2
    //   687: goto -291 -> 396
    //   690: ldc 132
    //   692: ldc_w 328
    //   695: iconst_2
    //   696: anewarray 4	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: lload 7
    //   703: lload 5
    //   705: lsub
    //   706: invokestatic 333	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   709: aastore
    //   710: dup
    //   711: iconst_1
    //   712: invokestatic 242	java/lang/System:currentTimeMillis	()J
    //   715: lload 7
    //   717: lsub
    //   718: invokestatic 333	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   721: aastore
    //   722: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: aload_0
    //   726: iconst_0
    //   727: putfield 31	com/tencent/mm/plugin/address/model/j:qhT	Z
    //   730: ldc 200
    //   732: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   735: return
    //   736: astore 9
    //   738: goto -89 -> 649
    //   741: astore 11
    //   743: aload 9
    //   745: astore 10
    //   747: aload 11
    //   749: astore 9
    //   751: goto -102 -> 649
    //   754: astore 10
    //   756: aconst_null
    //   757: astore 11
    //   759: goto -491 -> 268
    //   762: astore 10
    //   764: goto -496 -> 268
    //   767: astore 9
    //   769: aconst_null
    //   770: astore 12
    //   772: goto -238 -> 534
    //   775: astore 9
    //   777: aload 11
    //   779: astore 10
    //   781: goto -247 -> 534
    //   784: astore 13
    //   786: aconst_null
    //   787: astore 10
    //   789: aconst_null
    //   790: astore 9
    //   792: goto -659 -> 133
    //   795: astore 13
    //   797: aconst_null
    //   798: astore 9
    //   800: goto -667 -> 133
    //   803: iconst_0
    //   804: istore 4
    //   806: aconst_null
    //   807: astore 9
    //   809: goto -632 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	j
    //   333	132	1	i	int
    //   395	292	2	j	int
    //   324	13	3	k	int
    //   175	630	4	bool	boolean
    //   180	524	5	l1	long
    //   299	417	7	l2	long
    //   34	440	9	localObject1	Object
    //   526	34	9	localObject2	Object
    //   603	5	9	localIOException1	java.io.IOException
    //   621	21	9	localIOException2	java.io.IOException
    //   647	18	9	localObject3	Object
    //   736	8	9	localObject4	Object
    //   749	1	9	localObject5	Object
    //   767	1	9	localObject6	Object
    //   775	1	9	localObject7	Object
    //   790	18	9	localObject8	Object
    //   62	407	10	localObject9	Object
    //   484	5	10	localException1	Exception
    //   505	5	10	localException2	Exception
    //   529	11	10	localObject10	Object
    //   562	29	10	localException3	Exception
    //   643	12	10	localIOException3	java.io.IOException
    //   667	5	10	localIOException4	java.io.IOException
    //   745	1	10	localObject11	Object
    //   754	1	10	localIOException5	java.io.IOException
    //   762	1	10	localIOException6	java.io.IOException
    //   779	9	10	localObject12	Object
    //   81	515	11	localObject13	Object
    //   639	7	11	localObject14	Object
    //   741	7	11	localObject15	Object
    //   757	21	11	localObject16	Object
    //   77	59	12	localObject17	Object
    //   258	7	12	localIOException7	java.io.IOException
    //   532	239	12	localObject18	Object
    //   103	18	13	str	String
    //   131	13	13	localIOException8	java.io.IOException
    //   784	1	13	localIOException9	java.io.IOException
    //   795	1	13	localIOException10	java.io.IOException
    //   43	297	14	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   83	90	131	java/io/IOException
    //   98	105	131	java/io/IOException
    //   118	128	131	java/io/IOException
    //   233	240	258	java/io/IOException
    //   245	255	258	java/io/IOException
    //   580	590	258	java/io/IOException
    //   468	478	484	java/lang/Exception
    //   159	164	505	java/lang/Exception
    //   169	174	505	java/lang/Exception
    //   53	64	526	finally
    //   539	544	562	java/lang/Exception
    //   549	554	562	java/lang/Exception
    //   590	595	603	java/io/IOException
    //   286	291	621	java/io/IOException
    //   202	212	639	finally
    //   212	233	639	finally
    //   654	659	667	java/io/IOException
    //   233	240	736	finally
    //   245	255	736	finally
    //   580	590	736	finally
    //   268	281	741	finally
    //   202	212	754	java/io/IOException
    //   212	233	762	java/io/IOException
    //   64	75	767	finally
    //   83	90	775	finally
    //   98	105	775	finally
    //   118	128	775	finally
    //   141	154	775	finally
    //   53	64	784	java/io/IOException
    //   64	75	795	java/io/IOException
  }
  
  public final void bZj()
  {
    AppMethodBeat.i(20806);
    try
    {
      byte[] arrayOfByte = this.qhS.toByteArray();
      long l = System.currentTimeMillis();
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.acVz, new String(arrayOfByte, d.ISO_8859_1));
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
  
  public final RcptItem cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20813);
    paramString1 = TB(paramString1);
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
    AppMethodBeat.i(267159);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(267159);
      return null;
    }
    paramString1 = g(yA(0), paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(267159);
      return null;
    }
    paramString1 = g(TB(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(267159);
      return null;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(267159);
      return paramString1;
    }
    paramString2 = g(TB(paramString1.code), paramString3);
    if (paramString2 == null)
    {
      AppMethodBeat.o(267159);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      AppMethodBeat.o(267159);
      return paramString2;
    }
    paramString1 = g(TB(paramString2.code), paramString4);
    if (paramString1 == null)
    {
      AppMethodBeat.o(267159);
      return paramString2;
    }
    AppMethodBeat.o(267159);
    return paramString1;
  }
  
  public final boolean x(LinkedList<elu> paramLinkedList)
  {
    AppMethodBeat.i(20805);
    this.qhS.qib.clear();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (elu)paramLinkedList.next();
      b localb = new b();
      localb.id = ((elu)localObject).id;
      localb.qik = ((elu)localObject).abqu.abwM;
      localb.qie = ((elu)localObject).abqo.abwM;
      localb.qih = ((elu)localObject).abqr.abwM;
      localb.qif = ((elu)localObject).abqp.abwM;
      localb.qii = ((elu)localObject).abqs.abwM;
      localb.qij = ((elu)localObject).abqt.abwM;
      localb.qid = ((elu)localObject).abqn.abwM;
      localb.qig = ((elu)localObject).abqq.abwM;
      localb.qil = ((elu)localObject).abqv.abwM;
      localObject = g(localb.qid, localb.qie, localb.qif, localb.qil);
      if (((localObject != null) && (!((RcptItem)localObject).bZh())) || ((localb.qif != null) && (localb.qif.equals(localb.qil))) || ("undefined".equalsIgnoreCase(localb.qil)) || ("null".equalsIgnoreCase(localb.qil))) {
        localb.qil = "";
      }
      this.qhS.qib.add(localb);
    }
    a(this.qhS);
    AppMethodBeat.o(20805);
    return true;
  }
  
  public final List<RcptItem> yA(int paramInt)
  {
    AppMethodBeat.i(267153);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qhV.iterator();
    while (localIterator.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)localIterator.next();
      if (localRcptItem.qhR == paramInt) {
        localArrayList.add(localRcptItem);
      }
    }
    AppMethodBeat.o(267153);
    return localArrayList;
  }
  
  public final RcptItem yB(int paramInt)
  {
    AppMethodBeat.i(267154);
    RcptItem localRcptItem = (RcptItem)this.qhU.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(267154);
    return localRcptItem;
  }
  
  public final b yz(int paramInt)
  {
    AppMethodBeat.i(20803);
    int i = 0;
    while (i < this.qhS.qib.size())
    {
      b localb = (b)this.qhS.qib.get(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.j
 * JD-Core Version:    0.7.0.1
 */