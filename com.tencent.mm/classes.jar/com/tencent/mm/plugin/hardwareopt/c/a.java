package com.tencent.mm.plugin.hardwareopt.c;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements com.tencent.mm.vending.c.a<czg, Context>
{
  private Context mContext = null;
  
  private static String aIi(String paramString)
  {
    AppMethodBeat.i(55558);
    Object localObject2 = null;
    String str2 = null;
    String str1 = str2;
    Object localObject1 = localObject2;
    try
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        str1 = str2;
        localObject1 = localObject2;
        paramString = aa.u(paramString, true);
        str1 = paramString;
        localObject1 = paramString;
        str2 = paramString.getName();
        if (paramString != null) {}
        try
        {
          paramString.release();
          AppMethodBeat.o(55558);
          return str2;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", paramString, "codec release exception", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(55558);
      return "too low version";
    }
    catch (Exception paramString)
    {
      localObject1 = str1;
      Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", paramString, "hy: error in handle media codec", new Object[0]);
      if (str1 != null) {}
      try
      {
        str1.release();
        AppMethodBeat.o(55558);
        return "undefined";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", paramString, "codec release exception", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
    try
    {
      ((aa)localObject1).release();
      AppMethodBeat.o(55558);
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", localException, "codec release exception", new Object[0]);
      }
    }
  }
  
  private static LinkedList<doq> fKk()
  {
    AppMethodBeat.i(55559);
    int k = MediaCodecList.getCodecCount();
    LinkedList localLinkedList = new LinkedList();
    Object localObject3 = new HashMap();
    int i = 0;
    Object localObject4;
    Object localObject2;
    while (i < k)
    {
      localObject4 = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject4).isEncoder())
      {
        String[] arrayOfString = ((MediaCodecInfo)localObject4).getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          String str = arrayOfString[j];
          localObject2 = (Set)((Map)localObject3).get(str.toLowerCase());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new HashSet();
          }
          ((Set)localObject1).add(((MediaCodecInfo)localObject4).getName());
          ((Map)localObject3).put(str.toLowerCase(), localObject1);
          j += 1;
        }
      }
      i += 1;
    }
    Log.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[] { localObject3 });
    Object localObject1 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new doq();
      ((doq)localObject3).cBw = ((String)((Map.Entry)localObject2).getKey());
      localObject4 = new LinkedList();
      if (((Map.Entry)localObject2).getValue() != null) {
        ((LinkedList)localObject4).addAll((Collection)((Map.Entry)localObject2).getValue());
      }
      ((doq)localObject3).aaVD = ((LinkedList)localObject4);
      localLinkedList.add(localObject3);
    }
    AppMethodBeat.o(55559);
    return localLinkedList;
  }
  
  /* Error */
  private czg hZ(Context paramContext)
  {
    // Byte code:
    //   0: ldc 174
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   10: invokestatic 180	java/lang/System:nanoTime	()J
    //   13: lstore 4
    //   15: new 182	com/tencent/mm/protocal/protobuf/jx
    //   18: dup
    //   19: invokespecial 183	com/tencent/mm/protocal/protobuf/jx:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: iconst_0
    //   25: invokestatic 189	com/tencent/mm/compatible/deviceinfo/q:eD	(Z)Ljava/lang/String;
    //   28: putfield 192	com/tencent/mm/protocal/protobuf/jx:imei	Ljava/lang/String;
    //   31: aload_1
    //   32: getstatic 197	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   35: putfield 200	com/tencent/mm/protocal/protobuf/jx:YMj	Ljava/lang/String;
    //   38: aload_1
    //   39: invokestatic 203	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   42: putfield 206	com/tencent/mm/protocal/protobuf/jx:modelName	Ljava/lang/String;
    //   45: aload_1
    //   46: getstatic 209	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   49: putfield 212	com/tencent/mm/protocal/protobuf/jx:YMk	Ljava/lang/String;
    //   52: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   55: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   58: aload_1
    //   59: putfield 228	com/tencent/mm/protocal/protobuf/czg:aaEg	Lcom/tencent/mm/protocal/protobuf/jx;
    //   62: ldc 51
    //   64: ldc 230
    //   66: iconst_4
    //   67: anewarray 5	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: getfield 192	com/tencent/mm/protocal/protobuf/jx:imei	Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_1
    //   80: getfield 200	com/tencent/mm/protocal/protobuf/jx:YMj	Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: aload_1
    //   87: getfield 206	com/tencent/mm/protocal/protobuf/jx:modelName	Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_3
    //   93: aload_1
    //   94: getfield 212	com/tencent/mm/protocal/protobuf/jx:YMk	Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: new 235	com/tencent/mm/protocal/protobuf/uy
    //   104: dup
    //   105: invokespecial 236	com/tencent/mm/protocal/protobuf/uy:<init>	()V
    //   108: astore 9
    //   110: aload 9
    //   112: getstatic 239	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   115: putfield 242	com/tencent/mm/protocal/protobuf/uy:ZaV	Ljava/lang/String;
    //   118: invokestatic 248	com/tencent/mm/compatible/deviceinfo/n:aOO	()Ljava/util/Map;
    //   121: astore_1
    //   122: aload 9
    //   124: aload_1
    //   125: ldc 250
    //   127: invokeinterface 105 2 0
    //   132: checkcast 96	java/lang/String
    //   135: ldc 252
    //   137: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 261	com/tencent/mm/protocal/protobuf/uy:ZaT	Ljava/lang/String;
    //   143: aload 9
    //   145: aload_1
    //   146: ldc_w 263
    //   149: invokeinterface 105 2 0
    //   154: checkcast 96	java/lang/String
    //   157: putfield 264	com/tencent/mm/protocal/protobuf/uy:modelName	Ljava/lang/String;
    //   160: aload 9
    //   162: aload_1
    //   163: ldc_w 266
    //   166: invokeinterface 105 2 0
    //   171: checkcast 96	java/lang/String
    //   174: putfield 269	com/tencent/mm/protocal/protobuf/uy:ZaW	Ljava/lang/String;
    //   177: aconst_null
    //   178: astore 7
    //   180: aconst_null
    //   181: astore_1
    //   182: ldc_w 271
    //   185: iconst_0
    //   186: invokestatic 277	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   189: astore 8
    //   191: aload 8
    //   193: astore_1
    //   194: aload 8
    //   196: astore 7
    //   198: aload 9
    //   200: aload 8
    //   202: invokevirtual 282	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   205: iconst_m1
    //   206: invokestatic 286	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   209: sipush 1000
    //   212: idiv
    //   213: putfield 289	com/tencent/mm/protocal/protobuf/uy:ZaU	I
    //   216: aload 8
    //   218: ifnull +8 -> 226
    //   221: aload 8
    //   223: invokevirtual 292	java/io/RandomAccessFile:close	()V
    //   226: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   229: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   232: aload 9
    //   234: putfield 296	com/tencent/mm/protocal/protobuf/czg:aaEh	Lcom/tencent/mm/protocal/protobuf/uy;
    //   237: ldc 51
    //   239: ldc_w 298
    //   242: iconst_5
    //   243: anewarray 5	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 9
    //   250: getfield 242	com/tencent/mm/protocal/protobuf/uy:ZaV	Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: aload 9
    //   258: getfield 261	com/tencent/mm/protocal/protobuf/uy:ZaT	Ljava/lang/String;
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: aload 9
    //   266: getfield 289	com/tencent/mm/protocal/protobuf/uy:ZaU	I
    //   269: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_3
    //   275: aload 9
    //   277: getfield 264	com/tencent/mm/protocal/protobuf/uy:modelName	Ljava/lang/String;
    //   280: aastore
    //   281: dup
    //   282: iconst_4
    //   283: aload 9
    //   285: getfield 269	com/tencent/mm/protocal/protobuf/uy:ZaW	Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   296: ldc_w 306
    //   299: invokevirtual 312	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   302: checkcast 314	android/app/ActivityManager
    //   305: astore 7
    //   307: new 316	android/app/ActivityManager$MemoryInfo
    //   310: dup
    //   311: invokespecial 317	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   314: astore_1
    //   315: aload 7
    //   317: aload_1
    //   318: invokevirtual 321	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   321: new 323	com/tencent/mm/protocal/protobuf/dog
    //   324: dup
    //   325: invokespecial 324	com/tencent/mm/protocal/protobuf/dog:<init>	()V
    //   328: astore 7
    //   330: aload 7
    //   332: aload_1
    //   333: getfield 328	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   336: ldc2_w 329
    //   339: ldiv
    //   340: ldc2_w 329
    //   343: ldiv
    //   344: l2i
    //   345: putfield 333	com/tencent/mm/protocal/protobuf/dog:aaVj	I
    //   348: aload 7
    //   350: aload_1
    //   351: getfield 336	android/app/ActivityManager$MemoryInfo:threshold	J
    //   354: ldc2_w 329
    //   357: ldiv
    //   358: ldc2_w 329
    //   361: ldiv
    //   362: l2i
    //   363: putfield 339	com/tencent/mm/protocal/protobuf/dog:aaVk	I
    //   366: aload 7
    //   368: aload_0
    //   369: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   372: ldc_w 306
    //   375: invokevirtual 312	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   378: checkcast 314	android/app/ActivityManager
    //   381: invokevirtual 342	android/app/ActivityManager:getLargeMemoryClass	()I
    //   384: putfield 345	com/tencent/mm/protocal/protobuf/dog:aaVl	I
    //   387: aload 7
    //   389: aload_0
    //   390: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   393: ldc_w 306
    //   396: invokevirtual 312	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   399: checkcast 314	android/app/ActivityManager
    //   402: invokevirtual 348	android/app/ActivityManager:getMemoryClass	()I
    //   405: putfield 351	com/tencent/mm/protocal/protobuf/dog:MNT	I
    //   408: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   411: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   414: aload 7
    //   416: putfield 355	com/tencent/mm/protocal/protobuf/czg:aaEi	Lcom/tencent/mm/protocal/protobuf/dog;
    //   419: ldc 51
    //   421: ldc_w 357
    //   424: iconst_4
    //   425: anewarray 5	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload 7
    //   432: getfield 333	com/tencent/mm/protocal/protobuf/dog:aaVj	I
    //   435: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: aload 7
    //   443: getfield 339	com/tencent/mm/protocal/protobuf/dog:aaVk	I
    //   446: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: aastore
    //   450: dup
    //   451: iconst_2
    //   452: aload 7
    //   454: getfield 345	com/tencent/mm/protocal/protobuf/dog:aaVl	I
    //   457: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: iconst_3
    //   463: aload 7
    //   465: getfield 351	com/tencent/mm/protocal/protobuf/dog:MNT	I
    //   468: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: new 359	android/os/StatFs
    //   478: dup
    //   479: invokestatic 364	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   482: invokespecial 367	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   485: astore_1
    //   486: new 369	com/tencent/mm/protocal/protobuf/fhy
    //   489: dup
    //   490: invokespecial 370	com/tencent/mm/protocal/protobuf/fhy:<init>	()V
    //   493: astore 7
    //   495: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   498: bipush 18
    //   500: if_icmplt +1295 -> 1795
    //   503: aload 7
    //   505: aload_1
    //   506: invokevirtual 373	android/os/StatFs:getTotalBytes	()J
    //   509: ldc2_w 329
    //   512: ldiv
    //   513: ldc2_w 329
    //   516: ldiv
    //   517: l2i
    //   518: putfield 376	com/tencent/mm/protocal/protobuf/fhy:abIM	I
    //   521: aload 7
    //   523: invokestatic 381	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   526: ldc_w 383
    //   529: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   532: putfield 390	com/tencent/mm/protocal/protobuf/fhy:abIN	Z
    //   535: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   538: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   541: aload 7
    //   543: putfield 394	com/tencent/mm/protocal/protobuf/czg:aaEj	Lcom/tencent/mm/protocal/protobuf/fhy;
    //   546: ldc 51
    //   548: ldc_w 396
    //   551: iconst_2
    //   552: anewarray 5	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: aload 7
    //   559: getfield 376	com/tencent/mm/protocal/protobuf/fhy:abIM	I
    //   562: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: dup
    //   567: iconst_1
    //   568: aload 7
    //   570: getfield 390	com/tencent/mm/protocal/protobuf/fhy:abIN	Z
    //   573: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   576: aastore
    //   577: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: aload_0
    //   581: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   584: ldc_w 306
    //   587: invokevirtual 312	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   590: checkcast 314	android/app/ActivityManager
    //   593: invokevirtual 405	android/app/ActivityManager:getDeviceConfigurationInfo	()Landroid/content/pm/ConfigurationInfo;
    //   596: astore_1
    //   597: new 407	com/tencent/mm/protocal/protobuf/cax
    //   600: dup
    //   601: invokespecial 408	com/tencent/mm/protocal/protobuf/cax:<init>	()V
    //   604: astore 7
    //   606: aload_1
    //   607: getfield 413	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   610: ldc_w 414
    //   613: if_icmplt +1310 -> 1923
    //   616: iconst_1
    //   617: istore 6
    //   619: aload 7
    //   621: iload 6
    //   623: putfield 417	com/tencent/mm/protocal/protobuf/cax:aajY	Z
    //   626: aload_1
    //   627: getfield 413	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   630: ldc_w 418
    //   633: if_icmplt +1296 -> 1929
    //   636: iconst_1
    //   637: istore 6
    //   639: aload 7
    //   641: iload 6
    //   643: putfield 421	com/tencent/mm/protocal/protobuf/cax:aajZ	Z
    //   646: aload 7
    //   648: ldc_w 423
    //   651: invokestatic 429	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   654: checkcast 423	com/tencent/mm/plugin/appbrand/service/r
    //   657: invokeinterface 432 1 0
    //   662: putfield 435	com/tencent/mm/protocal/protobuf/cax:aaka	Z
    //   665: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   668: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   671: aload 7
    //   673: putfield 439	com/tencent/mm/protocal/protobuf/czg:aaEn	Lcom/tencent/mm/protocal/protobuf/cax;
    //   676: ldc 51
    //   678: ldc_w 441
    //   681: iconst_4
    //   682: anewarray 5	java/lang/Object
    //   685: dup
    //   686: iconst_0
    //   687: aload 7
    //   689: getfield 417	com/tencent/mm/protocal/protobuf/cax:aajY	Z
    //   692: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload 7
    //   700: getfield 421	com/tencent/mm/protocal/protobuf/cax:aajZ	Z
    //   703: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   706: aastore
    //   707: dup
    //   708: iconst_2
    //   709: aload_1
    //   710: getfield 413	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   713: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   716: aastore
    //   717: dup
    //   718: iconst_3
    //   719: aload 7
    //   721: getfield 435	com/tencent/mm/protocal/protobuf/cax:aaka	Z
    //   724: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   727: aastore
    //   728: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: aload_0
    //   732: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   735: ldc_w 443
    //   738: invokevirtual 312	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   741: checkcast 445	android/view/WindowManager
    //   744: invokeinterface 449 1 0
    //   749: astore_1
    //   750: new 451	android/graphics/Point
    //   753: dup
    //   754: invokespecial 452	android/graphics/Point:<init>	()V
    //   757: astore 7
    //   759: aload_1
    //   760: aload 7
    //   762: invokevirtual 458	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   765: aload 7
    //   767: getfield 461	android/graphics/Point:x	I
    //   770: istore_2
    //   771: aload 7
    //   773: getfield 464	android/graphics/Point:y	I
    //   776: istore_3
    //   777: new 466	com/tencent/mm/protocal/protobuf/eur
    //   780: dup
    //   781: invokespecial 467	com/tencent/mm/protocal/protobuf/eur:<init>	()V
    //   784: astore_1
    //   785: aload_1
    //   786: new 469	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 470	java/lang/StringBuilder:<init>	()V
    //   793: iload_2
    //   794: invokestatic 473	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   797: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: ldc_w 478
    //   803: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: iload_3
    //   807: invokevirtual 481	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: putfield 487	com/tencent/mm/protocal/protobuf/eur:resolution	Ljava/lang/String;
    //   816: aload_1
    //   817: aload_0
    //   818: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   821: invokevirtual 491	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   824: invokevirtual 497	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   827: getfield 503	android/util/DisplayMetrics:density	F
    //   830: f2i
    //   831: putfield 506	com/tencent/mm/protocal/protobuf/eur:oKu	I
    //   834: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   837: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   840: aload_1
    //   841: putfield 510	com/tencent/mm/protocal/protobuf/czg:aaEk	Lcom/tencent/mm/protocal/protobuf/eur;
    //   844: ldc 51
    //   846: ldc_w 512
    //   849: iconst_2
    //   850: anewarray 5	java/lang/Object
    //   853: dup
    //   854: iconst_0
    //   855: aload_1
    //   856: getfield 487	com/tencent/mm/protocal/protobuf/eur:resolution	Ljava/lang/String;
    //   859: aastore
    //   860: dup
    //   861: iconst_1
    //   862: aload_1
    //   863: getfield 506	com/tencent/mm/protocal/protobuf/eur:oKu	I
    //   866: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: aastore
    //   870: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   873: new 514	com/tencent/mm/protocal/protobuf/ady
    //   876: dup
    //   877: invokespecial 515	com/tencent/mm/protocal/protobuf/ady:<init>	()V
    //   880: astore_1
    //   881: aload_1
    //   882: ldc_w 517
    //   885: invokestatic 519	com/tencent/mm/plugin/hardwareopt/c/a:aIi	(Ljava/lang/String;)Ljava/lang/String;
    //   888: putfield 522	com/tencent/mm/protocal/protobuf/ady:Zme	Ljava/lang/String;
    //   891: aload_1
    //   892: ldc_w 524
    //   895: invokestatic 519	com/tencent/mm/plugin/hardwareopt/c/a:aIi	(Ljava/lang/String;)Ljava/lang/String;
    //   898: putfield 527	com/tencent/mm/protocal/protobuf/ady:Zmf	Ljava/lang/String;
    //   901: aload_1
    //   902: invokestatic 529	com/tencent/mm/plugin/hardwareopt/c/a:fKk	()Ljava/util/LinkedList;
    //   905: putfield 532	com/tencent/mm/protocal/protobuf/ady:Zmg	Ljava/util/LinkedList;
    //   908: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   911: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   914: aload_1
    //   915: putfield 536	com/tencent/mm/protocal/protobuf/czg:aaEl	Lcom/tencent/mm/protocal/protobuf/ady;
    //   918: aload_1
    //   919: getfield 522	com/tencent/mm/protocal/protobuf/ady:Zme	Ljava/lang/String;
    //   922: astore 7
    //   924: aload_1
    //   925: getfield 527	com/tencent/mm/protocal/protobuf/ady:Zmf	Ljava/lang/String;
    //   928: astore 8
    //   930: aload_1
    //   931: getfield 532	com/tencent/mm/protocal/protobuf/ady:Zmg	Ljava/util/LinkedList;
    //   934: ifnull +1001 -> 1935
    //   937: aload_1
    //   938: getfield 532	com/tencent/mm/protocal/protobuf/ady:Zmg	Ljava/util/LinkedList;
    //   941: invokevirtual 539	java/util/LinkedList:size	()I
    //   944: istore_2
    //   945: ldc 51
    //   947: ldc_w 541
    //   950: iconst_3
    //   951: anewarray 5	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload 7
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: aload 8
    //   963: aastore
    //   964: dup
    //   965: iconst_2
    //   966: iload_2
    //   967: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   970: aastore
    //   971: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   974: new 543	com/tencent/mm/protocal/protobuf/asn
    //   977: dup
    //   978: invokespecial 544	com/tencent/mm/protocal/protobuf/asn:<init>	()V
    //   981: astore_1
    //   982: aload_1
    //   983: aload_0
    //   984: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   987: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   990: ldc_w 550
    //   993: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   996: putfield 559	com/tencent/mm/protocal/protobuf/asn:ZCv	Z
    //   999: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1002: bipush 18
    //   1004: if_icmplt +844 -> 1848
    //   1007: aload_1
    //   1008: aload_0
    //   1009: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1012: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1015: ldc_w 561
    //   1018: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1021: putfield 564	com/tencent/mm/protocal/protobuf/asn:ZCw	Z
    //   1024: aload_1
    //   1025: aload_0
    //   1026: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1029: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1032: ldc_w 566
    //   1035: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1038: putfield 569	com/tencent/mm/protocal/protobuf/asn:ZCx	Z
    //   1041: aload_1
    //   1042: aload_0
    //   1043: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1046: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1049: ldc_w 571
    //   1052: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1055: putfield 574	com/tencent/mm/protocal/protobuf/asn:ZCy	Z
    //   1058: aload_1
    //   1059: aload_0
    //   1060: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1063: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1066: ldc_w 576
    //   1069: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1072: putfield 579	com/tencent/mm/protocal/protobuf/asn:ZCz	Z
    //   1075: aload_1
    //   1076: aload_0
    //   1077: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1080: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1083: ldc_w 581
    //   1086: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1089: putfield 584	com/tencent/mm/protocal/protobuf/asn:ZCA	Z
    //   1092: aload_1
    //   1093: aload_0
    //   1094: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1097: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1100: ldc_w 586
    //   1103: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1106: putfield 589	com/tencent/mm/protocal/protobuf/asn:ZCB	Z
    //   1109: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1112: bipush 19
    //   1114: if_icmplt +742 -> 1856
    //   1117: aload_1
    //   1118: aload_0
    //   1119: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1122: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1125: ldc_w 591
    //   1128: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1131: putfield 594	com/tencent/mm/protocal/protobuf/asn:ZCM	Z
    //   1134: aload_1
    //   1135: aload_0
    //   1136: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1139: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1142: ldc_w 586
    //   1145: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1148: putfield 597	com/tencent/mm/protocal/protobuf/asn:ZCC	Z
    //   1151: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1154: bipush 23
    //   1156: if_icmplt +708 -> 1864
    //   1159: aload_1
    //   1160: aload_0
    //   1161: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1164: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1167: ldc_w 599
    //   1170: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1173: putfield 602	com/tencent/mm/protocal/protobuf/asn:ZCD	Z
    //   1176: aload_1
    //   1177: aload_0
    //   1178: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1181: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1184: ldc_w 604
    //   1187: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1190: putfield 607	com/tencent/mm/protocal/protobuf/asn:ZCE	Z
    //   1193: aload_1
    //   1194: aload_0
    //   1195: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1198: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1201: ldc_w 609
    //   1204: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1207: putfield 612	com/tencent/mm/protocal/protobuf/asn:ZCF	Z
    //   1210: aload_1
    //   1211: aload_0
    //   1212: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1215: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1218: ldc_w 614
    //   1221: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1224: putfield 617	com/tencent/mm/protocal/protobuf/asn:ZCG	Z
    //   1227: aload_1
    //   1228: aload_0
    //   1229: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1232: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1235: ldc_w 619
    //   1238: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1241: putfield 622	com/tencent/mm/protocal/protobuf/asn:ZCH	Z
    //   1244: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1247: bipush 19
    //   1249: if_icmplt +641 -> 1890
    //   1252: aload_1
    //   1253: aload_0
    //   1254: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1257: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1260: ldc_w 624
    //   1263: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1266: putfield 627	com/tencent/mm/protocal/protobuf/asn:ZCI	Z
    //   1269: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1272: bipush 19
    //   1274: if_icmplt +624 -> 1898
    //   1277: aload_1
    //   1278: aload_0
    //   1279: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1282: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1285: ldc_w 629
    //   1288: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1291: putfield 632	com/tencent/mm/protocal/protobuf/asn:ZCJ	Z
    //   1294: aload_1
    //   1295: aload_0
    //   1296: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1299: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1302: ldc_w 634
    //   1305: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1308: putfield 637	com/tencent/mm/protocal/protobuf/asn:ZCK	Z
    //   1311: aload_1
    //   1312: aload_0
    //   1313: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1316: invokevirtual 548	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1319: ldc_w 639
    //   1322: invokevirtual 556	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1325: putfield 642	com/tencent/mm/protocal/protobuf/asn:ZCL	Z
    //   1328: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1331: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   1334: aload_1
    //   1335: putfield 646	com/tencent/mm/protocal/protobuf/czg:aaEm	Lcom/tencent/mm/protocal/protobuf/asn;
    //   1338: ldc 51
    //   1340: ldc_w 648
    //   1343: bipush 18
    //   1345: anewarray 5	java/lang/Object
    //   1348: dup
    //   1349: iconst_0
    //   1350: aload_1
    //   1351: getfield 559	com/tencent/mm/protocal/protobuf/asn:ZCv	Z
    //   1354: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1357: aastore
    //   1358: dup
    //   1359: iconst_1
    //   1360: aload_1
    //   1361: getfield 564	com/tencent/mm/protocal/protobuf/asn:ZCw	Z
    //   1364: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1367: aastore
    //   1368: dup
    //   1369: iconst_2
    //   1370: aload_1
    //   1371: getfield 569	com/tencent/mm/protocal/protobuf/asn:ZCx	Z
    //   1374: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1377: aastore
    //   1378: dup
    //   1379: iconst_3
    //   1380: aload_1
    //   1381: getfield 574	com/tencent/mm/protocal/protobuf/asn:ZCy	Z
    //   1384: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_4
    //   1390: aload_1
    //   1391: getfield 579	com/tencent/mm/protocal/protobuf/asn:ZCz	Z
    //   1394: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_5
    //   1400: aload_1
    //   1401: getfield 584	com/tencent/mm/protocal/protobuf/asn:ZCA	Z
    //   1404: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1407: aastore
    //   1408: dup
    //   1409: bipush 6
    //   1411: aload_1
    //   1412: getfield 589	com/tencent/mm/protocal/protobuf/asn:ZCB	Z
    //   1415: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1418: aastore
    //   1419: dup
    //   1420: bipush 7
    //   1422: aload_1
    //   1423: getfield 594	com/tencent/mm/protocal/protobuf/asn:ZCM	Z
    //   1426: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1429: aastore
    //   1430: dup
    //   1431: bipush 8
    //   1433: aload_1
    //   1434: getfield 597	com/tencent/mm/protocal/protobuf/asn:ZCC	Z
    //   1437: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1440: aastore
    //   1441: dup
    //   1442: bipush 9
    //   1444: aload_1
    //   1445: getfield 602	com/tencent/mm/protocal/protobuf/asn:ZCD	Z
    //   1448: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1451: aastore
    //   1452: dup
    //   1453: bipush 10
    //   1455: aload_1
    //   1456: getfield 607	com/tencent/mm/protocal/protobuf/asn:ZCE	Z
    //   1459: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1462: aastore
    //   1463: dup
    //   1464: bipush 11
    //   1466: aload_1
    //   1467: getfield 612	com/tencent/mm/protocal/protobuf/asn:ZCF	Z
    //   1470: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1473: aastore
    //   1474: dup
    //   1475: bipush 12
    //   1477: aload_1
    //   1478: getfield 617	com/tencent/mm/protocal/protobuf/asn:ZCG	Z
    //   1481: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1484: aastore
    //   1485: dup
    //   1486: bipush 13
    //   1488: aload_1
    //   1489: getfield 622	com/tencent/mm/protocal/protobuf/asn:ZCH	Z
    //   1492: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1495: aastore
    //   1496: dup
    //   1497: bipush 14
    //   1499: aload_1
    //   1500: getfield 627	com/tencent/mm/protocal/protobuf/asn:ZCI	Z
    //   1503: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1506: aastore
    //   1507: dup
    //   1508: bipush 15
    //   1510: aload_1
    //   1511: getfield 632	com/tencent/mm/protocal/protobuf/asn:ZCJ	Z
    //   1514: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1517: aastore
    //   1518: dup
    //   1519: bipush 16
    //   1521: aload_1
    //   1522: getfield 637	com/tencent/mm/protocal/protobuf/asn:ZCK	Z
    //   1525: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1528: aastore
    //   1529: dup
    //   1530: bipush 17
    //   1532: aload_1
    //   1533: getfield 642	com/tencent/mm/protocal/protobuf/asn:ZCL	Z
    //   1536: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1539: aastore
    //   1540: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1543: ldc 51
    //   1545: ldc_w 650
    //   1548: iconst_1
    //   1549: anewarray 5	java/lang/Object
    //   1552: dup
    //   1553: iconst_0
    //   1554: invokestatic 180	java/lang/System:nanoTime	()J
    //   1557: lload 4
    //   1559: lsub
    //   1560: ldc2_w 651
    //   1563: ldiv
    //   1564: ldc2_w 651
    //   1567: ldiv
    //   1568: invokestatic 657	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1571: aastore
    //   1572: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1575: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1578: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   1581: astore_1
    //   1582: aload_1
    //   1583: ifnull +61 -> 1644
    //   1586: aload_1
    //   1587: getfield 296	com/tencent/mm/protocal/protobuf/czg:aaEh	Lcom/tencent/mm/protocal/protobuf/uy;
    //   1590: ifnull +25 -> 1615
    //   1593: invokestatic 661	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1596: invokevirtual 667	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1599: getstatic 673	com/tencent/mm/storage/at$a:acVQ	Lcom/tencent/mm/storage/at$a;
    //   1602: aload_1
    //   1603: getfield 296	com/tencent/mm/protocal/protobuf/czg:aaEh	Lcom/tencent/mm/protocal/protobuf/uy;
    //   1606: getfield 289	com/tencent/mm/protocal/protobuf/uy:ZaU	I
    //   1609: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1612: invokevirtual 679	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   1615: aload_1
    //   1616: getfield 355	com/tencent/mm/protocal/protobuf/czg:aaEi	Lcom/tencent/mm/protocal/protobuf/dog;
    //   1619: ifnull +25 -> 1644
    //   1622: invokestatic 661	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1625: invokevirtual 667	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1628: getstatic 682	com/tencent/mm/storage/at$a:acVR	Lcom/tencent/mm/storage/at$a;
    //   1631: aload_1
    //   1632: getfield 355	com/tencent/mm/protocal/protobuf/czg:aaEi	Lcom/tencent/mm/protocal/protobuf/dog;
    //   1635: getfield 333	com/tencent/mm/protocal/protobuf/dog:aaVj	I
    //   1638: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1641: invokevirtual 679	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   1644: invokestatic 218	com/tencent/mm/plugin/hardwareopt/b/a:fKi	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1647: invokevirtual 222	com/tencent/mm/plugin/hardwareopt/b/a:fKj	()Lcom/tencent/mm/protocal/protobuf/czg;
    //   1650: astore_1
    //   1651: ldc 174
    //   1653: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1656: aload_1
    //   1657: areturn
    //   1658: astore_1
    //   1659: ldc 51
    //   1661: aload_1
    //   1662: ldc_w 684
    //   1665: iconst_0
    //   1666: anewarray 5	java/lang/Object
    //   1669: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1672: goto -1446 -> 226
    //   1675: astore_1
    //   1676: ldc 51
    //   1678: aload_1
    //   1679: ldc_w 686
    //   1682: iconst_0
    //   1683: anewarray 5	java/lang/Object
    //   1686: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1689: invokestatic 692	com/tencent/mm/vending/g/g:jJV	()Lcom/tencent/mm/vending/g/b;
    //   1692: astore_1
    //   1693: aload_1
    //   1694: ifnull +10 -> 1704
    //   1697: aload_1
    //   1698: aconst_null
    //   1699: invokeinterface 698 2 0
    //   1704: ldc 174
    //   1706: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1709: aconst_null
    //   1710: areturn
    //   1711: astore 8
    //   1713: aload_1
    //   1714: astore 7
    //   1716: ldc 51
    //   1718: aload 8
    //   1720: ldc_w 700
    //   1723: iconst_0
    //   1724: anewarray 5	java/lang/Object
    //   1727: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1730: aload_1
    //   1731: ifnull -1505 -> 226
    //   1734: aload_1
    //   1735: invokevirtual 292	java/io/RandomAccessFile:close	()V
    //   1738: goto -1512 -> 226
    //   1741: astore_1
    //   1742: ldc 51
    //   1744: aload_1
    //   1745: ldc_w 684
    //   1748: iconst_0
    //   1749: anewarray 5	java/lang/Object
    //   1752: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1755: goto -1529 -> 226
    //   1758: astore_1
    //   1759: aload 7
    //   1761: ifnull +8 -> 1769
    //   1764: aload 7
    //   1766: invokevirtual 292	java/io/RandomAccessFile:close	()V
    //   1769: ldc 174
    //   1771: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1774: aload_1
    //   1775: athrow
    //   1776: astore 7
    //   1778: ldc 51
    //   1780: aload 7
    //   1782: ldc_w 684
    //   1785: iconst_0
    //   1786: anewarray 5	java/lang/Object
    //   1789: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1792: goto -23 -> 1769
    //   1795: aload 7
    //   1797: aload_1
    //   1798: invokevirtual 703	android/os/StatFs:getBlockSize	()I
    //   1801: i2l
    //   1802: aload_1
    //   1803: invokevirtual 706	android/os/StatFs:getAvailableBlocks	()I
    //   1806: i2l
    //   1807: lmul
    //   1808: ldc2_w 329
    //   1811: ldiv
    //   1812: ldc2_w 329
    //   1815: ldiv
    //   1816: l2i
    //   1817: putfield 376	com/tencent/mm/protocal/protobuf/fhy:abIM	I
    //   1820: goto -1299 -> 521
    //   1823: astore 8
    //   1825: ldc 51
    //   1827: aload 8
    //   1829: ldc_w 708
    //   1832: iconst_0
    //   1833: anewarray 5	java/lang/Object
    //   1836: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1839: aload 7
    //   1841: iconst_0
    //   1842: putfield 435	com/tencent/mm/protocal/protobuf/cax:aaka	Z
    //   1845: goto -1180 -> 665
    //   1848: aload_1
    //   1849: iconst_0
    //   1850: putfield 564	com/tencent/mm/protocal/protobuf/asn:ZCw	Z
    //   1853: goto -829 -> 1024
    //   1856: aload_1
    //   1857: iconst_0
    //   1858: putfield 594	com/tencent/mm/protocal/protobuf/asn:ZCM	Z
    //   1861: goto -727 -> 1134
    //   1864: getstatic 714	com/tencent/mm/compatible/deviceinfo/af:lYc	Lcom/tencent/mm/compatible/deviceinfo/t;
    //   1867: getfield 719	com/tencent/mm/compatible/deviceinfo/t:lWo	I
    //   1870: iconst_1
    //   1871: if_icmpne +11 -> 1882
    //   1874: aload_1
    //   1875: iconst_1
    //   1876: putfield 602	com/tencent/mm/protocal/protobuf/asn:ZCD	Z
    //   1879: goto -703 -> 1176
    //   1882: aload_1
    //   1883: iconst_0
    //   1884: putfield 602	com/tencent/mm/protocal/protobuf/asn:ZCD	Z
    //   1887: goto -711 -> 1176
    //   1890: aload_1
    //   1891: iconst_0
    //   1892: putfield 627	com/tencent/mm/protocal/protobuf/asn:ZCI	Z
    //   1895: goto -626 -> 1269
    //   1898: aload_1
    //   1899: iconst_0
    //   1900: putfield 632	com/tencent/mm/protocal/protobuf/asn:ZCJ	Z
    //   1903: goto -609 -> 1294
    //   1906: astore_1
    //   1907: ldc 51
    //   1909: aload_1
    //   1910: ldc_w 721
    //   1913: iconst_0
    //   1914: anewarray 5	java/lang/Object
    //   1917: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1920: goto -276 -> 1644
    //   1923: iconst_0
    //   1924: istore 6
    //   1926: goto -1307 -> 619
    //   1929: iconst_0
    //   1930: istore 6
    //   1932: goto -1293 -> 639
    //   1935: iconst_0
    //   1936: istore_2
    //   1937: goto -992 -> 945
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1940	0	this	a
    //   0	1940	1	paramContext	Context
    //   770	1167	2	i	int
    //   776	31	3	j	int
    //   13	1545	4	l	long
    //   617	1314	6	bool	boolean
    //   178	1587	7	localObject1	Object
    //   1776	64	7	localIOException1	java.io.IOException
    //   189	773	8	localObject2	Object
    //   1711	8	8	localIOException2	java.io.IOException
    //   1823	5	8	localThrowable	java.lang.Throwable
    //   108	176	9	localuy	com.tencent.mm.protocal.protobuf.uy
    // Exception table:
    //   from	to	target	type
    //   221	226	1658	java/io/IOException
    //   15	177	1675	java/lang/Exception
    //   221	226	1675	java/lang/Exception
    //   226	521	1675	java/lang/Exception
    //   521	616	1675	java/lang/Exception
    //   619	636	1675	java/lang/Exception
    //   639	646	1675	java/lang/Exception
    //   665	945	1675	java/lang/Exception
    //   945	1024	1675	java/lang/Exception
    //   1024	1134	1675	java/lang/Exception
    //   1134	1176	1675	java/lang/Exception
    //   1176	1269	1675	java/lang/Exception
    //   1269	1294	1675	java/lang/Exception
    //   1294	1575	1675	java/lang/Exception
    //   1644	1651	1675	java/lang/Exception
    //   1659	1672	1675	java/lang/Exception
    //   1734	1738	1675	java/lang/Exception
    //   1742	1755	1675	java/lang/Exception
    //   1764	1769	1675	java/lang/Exception
    //   1769	1776	1675	java/lang/Exception
    //   1778	1792	1675	java/lang/Exception
    //   1795	1820	1675	java/lang/Exception
    //   1825	1845	1675	java/lang/Exception
    //   1848	1853	1675	java/lang/Exception
    //   1856	1861	1675	java/lang/Exception
    //   1864	1879	1675	java/lang/Exception
    //   1882	1887	1675	java/lang/Exception
    //   1890	1895	1675	java/lang/Exception
    //   1898	1903	1675	java/lang/Exception
    //   1907	1920	1675	java/lang/Exception
    //   182	191	1711	java/io/IOException
    //   198	216	1711	java/io/IOException
    //   1734	1738	1741	java/io/IOException
    //   182	191	1758	finally
    //   198	216	1758	finally
    //   1716	1730	1758	finally
    //   1764	1769	1776	java/io/IOException
    //   646	665	1823	finally
    //   1575	1582	1906	java/lang/Exception
    //   1586	1615	1906	java/lang/Exception
    //   1615	1644	1906	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.a
 * JD-Core Version:    0.7.0.1
 */