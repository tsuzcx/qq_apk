package com.tencent.mm.plugin.hardwareopt.c;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cxl;
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
  implements com.tencent.mm.vending.c.a<cjd, Context>
{
  private Context mContext = null;
  
  private static String aLr(String paramString)
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
        paramString = aa.t(paramString, true);
        str1 = paramString;
        localObject1 = paramString;
        str2 = paramString.getName();
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
  
  private static LinkedList<cxl> eCj()
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
      localObject3 = new cxl();
      ((cxl)localObject3).aFM = ((String)((Map.Entry)localObject2).getKey());
      localObject4 = new LinkedList();
      if (((Map.Entry)localObject2).getValue() != null) {
        ((LinkedList)localObject4).addAll((Collection)((Map.Entry)localObject2).getValue());
      }
      ((cxl)localObject3).TFX = ((LinkedList)localObject4);
      localLinkedList.add(localObject3);
    }
    AppMethodBeat.o(55559);
    return localLinkedList;
  }
  
  /* Error */
  private cjd gG(Context paramContext)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   10: invokestatic 182	java/lang/System:nanoTime	()J
    //   13: lstore 4
    //   15: new 184	com/tencent/mm/protocal/protobuf/jb
    //   18: dup
    //   19: invokespecial 185	com/tencent/mm/protocal/protobuf/jb:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: iconst_0
    //   25: invokestatic 191	com/tencent/mm/compatible/deviceinfo/q:dR	(Z)Ljava/lang/String;
    //   28: putfield 194	com/tencent/mm/protocal/protobuf/jb:imei	Ljava/lang/String;
    //   31: aload_1
    //   32: getstatic 199	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   35: putfield 202	com/tencent/mm/protocal/protobuf/jb:ROV	Ljava/lang/String;
    //   38: aload_1
    //   39: getstatic 205	android/os/Build:MODEL	Ljava/lang/String;
    //   42: putfield 208	com/tencent/mm/protocal/protobuf/jb:nqp	Ljava/lang/String;
    //   45: aload_1
    //   46: getstatic 211	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   49: putfield 214	com/tencent/mm/protocal/protobuf/jb:ROX	Ljava/lang/String;
    //   52: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   55: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   58: aload_1
    //   59: putfield 230	com/tencent/mm/protocal/protobuf/cjd:Tqe	Lcom/tencent/mm/protocal/protobuf/jb;
    //   62: ldc 51
    //   64: ldc 232
    //   66: iconst_4
    //   67: anewarray 5	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: getfield 194	com/tencent/mm/protocal/protobuf/jb:imei	Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_1
    //   80: getfield 202	com/tencent/mm/protocal/protobuf/jb:ROV	Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: aload_1
    //   87: getfield 208	com/tencent/mm/protocal/protobuf/jb:nqp	Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_3
    //   93: aload_1
    //   94: getfield 214	com/tencent/mm/protocal/protobuf/jb:ROX	Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: new 237	com/tencent/mm/protocal/protobuf/ti
    //   104: dup
    //   105: invokespecial 238	com/tencent/mm/protocal/protobuf/ti:<init>	()V
    //   108: astore 9
    //   110: aload 9
    //   112: getstatic 241	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   115: putfield 244	com/tencent/mm/protocal/protobuf/ti:Sdd	Ljava/lang/String;
    //   118: invokestatic 250	com/tencent/mm/compatible/deviceinfo/n:auv	()Ljava/util/Map;
    //   121: astore_1
    //   122: aload 9
    //   124: aload_1
    //   125: ldc 252
    //   127: invokeinterface 105 2 0
    //   132: checkcast 96	java/lang/String
    //   135: ldc 254
    //   137: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 263	com/tencent/mm/protocal/protobuf/ti:Sdb	Ljava/lang/String;
    //   143: aload 9
    //   145: aload_1
    //   146: ldc_w 265
    //   149: invokeinterface 105 2 0
    //   154: checkcast 96	java/lang/String
    //   157: putfield 266	com/tencent/mm/protocal/protobuf/ti:nqp	Ljava/lang/String;
    //   160: aload 9
    //   162: aload_1
    //   163: ldc_w 268
    //   166: invokeinterface 105 2 0
    //   171: checkcast 96	java/lang/String
    //   174: putfield 271	com/tencent/mm/protocal/protobuf/ti:Sde	Ljava/lang/String;
    //   177: aconst_null
    //   178: astore 7
    //   180: aconst_null
    //   181: astore_1
    //   182: ldc_w 273
    //   185: iconst_0
    //   186: invokestatic 279	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   189: astore 8
    //   191: aload 8
    //   193: astore_1
    //   194: aload 8
    //   196: astore 7
    //   198: aload 9
    //   200: aload 8
    //   202: invokevirtual 284	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   205: iconst_m1
    //   206: invokestatic 288	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   209: sipush 1000
    //   212: idiv
    //   213: putfield 291	com/tencent/mm/protocal/protobuf/ti:Sdc	I
    //   216: aload 8
    //   218: ifnull +8 -> 226
    //   221: aload 8
    //   223: invokevirtual 294	java/io/RandomAccessFile:close	()V
    //   226: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   229: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   232: aload 9
    //   234: putfield 298	com/tencent/mm/protocal/protobuf/cjd:Tqf	Lcom/tencent/mm/protocal/protobuf/ti;
    //   237: ldc 51
    //   239: ldc_w 300
    //   242: iconst_5
    //   243: anewarray 5	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 9
    //   250: getfield 244	com/tencent/mm/protocal/protobuf/ti:Sdd	Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: aload 9
    //   258: getfield 263	com/tencent/mm/protocal/protobuf/ti:Sdb	Ljava/lang/String;
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: aload 9
    //   266: getfield 291	com/tencent/mm/protocal/protobuf/ti:Sdc	I
    //   269: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_3
    //   275: aload 9
    //   277: getfield 266	com/tencent/mm/protocal/protobuf/ti:nqp	Ljava/lang/String;
    //   280: aastore
    //   281: dup
    //   282: iconst_4
    //   283: aload 9
    //   285: getfield 271	com/tencent/mm/protocal/protobuf/ti:Sde	Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   296: ldc_w 308
    //   299: invokevirtual 314	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   302: checkcast 316	android/app/ActivityManager
    //   305: astore 7
    //   307: new 318	android/app/ActivityManager$MemoryInfo
    //   310: dup
    //   311: invokespecial 319	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   314: astore_1
    //   315: aload 7
    //   317: aload_1
    //   318: invokevirtual 323	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   321: new 325	com/tencent/mm/protocal/protobuf/cxb
    //   324: dup
    //   325: invokespecial 326	com/tencent/mm/protocal/protobuf/cxb:<init>	()V
    //   328: astore 7
    //   330: aload 7
    //   332: aload_1
    //   333: getfield 330	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   336: ldc2_w 331
    //   339: ldiv
    //   340: ldc2_w 331
    //   343: ldiv
    //   344: l2i
    //   345: putfield 335	com/tencent/mm/protocal/protobuf/cxb:TFC	I
    //   348: aload 7
    //   350: aload_1
    //   351: getfield 338	android/app/ActivityManager$MemoryInfo:threshold	J
    //   354: ldc2_w 331
    //   357: ldiv
    //   358: ldc2_w 331
    //   361: ldiv
    //   362: l2i
    //   363: putfield 341	com/tencent/mm/protocal/protobuf/cxb:TFD	I
    //   366: aload 7
    //   368: aload_0
    //   369: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   372: ldc_w 308
    //   375: invokevirtual 314	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   378: checkcast 316	android/app/ActivityManager
    //   381: invokevirtual 344	android/app/ActivityManager:getLargeMemoryClass	()I
    //   384: putfield 347	com/tencent/mm/protocal/protobuf/cxb:TFE	I
    //   387: aload 7
    //   389: aload_0
    //   390: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   393: ldc_w 308
    //   396: invokevirtual 314	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   399: checkcast 316	android/app/ActivityManager
    //   402: invokevirtual 350	android/app/ActivityManager:getMemoryClass	()I
    //   405: putfield 353	com/tencent/mm/protocal/protobuf/cxb:GQB	I
    //   408: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   411: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   414: aload 7
    //   416: putfield 357	com/tencent/mm/protocal/protobuf/cjd:Tqg	Lcom/tencent/mm/protocal/protobuf/cxb;
    //   419: ldc 51
    //   421: ldc_w 359
    //   424: iconst_4
    //   425: anewarray 5	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload 7
    //   432: getfield 335	com/tencent/mm/protocal/protobuf/cxb:TFC	I
    //   435: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: aload 7
    //   443: getfield 341	com/tencent/mm/protocal/protobuf/cxb:TFD	I
    //   446: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: aastore
    //   450: dup
    //   451: iconst_2
    //   452: aload 7
    //   454: getfield 347	com/tencent/mm/protocal/protobuf/cxb:TFE	I
    //   457: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: iconst_3
    //   463: aload 7
    //   465: getfield 353	com/tencent/mm/protocal/protobuf/cxb:GQB	I
    //   468: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: new 361	android/os/StatFs
    //   478: dup
    //   479: invokestatic 366	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   482: invokespecial 369	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   485: astore_1
    //   486: new 371	com/tencent/mm/protocal/protobuf/ena
    //   489: dup
    //   490: invokespecial 372	com/tencent/mm/protocal/protobuf/ena:<init>	()V
    //   493: astore 7
    //   495: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   498: bipush 18
    //   500: if_icmplt +1289 -> 1789
    //   503: aload 7
    //   505: aload_1
    //   506: invokevirtual 375	android/os/StatFs:getTotalBytes	()J
    //   509: ldc2_w 331
    //   512: ldiv
    //   513: ldc2_w 331
    //   516: ldiv
    //   517: l2i
    //   518: putfield 378	com/tencent/mm/protocal/protobuf/ena:UpN	I
    //   521: aload 7
    //   523: invokestatic 383	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   526: ldc_w 385
    //   529: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   532: putfield 392	com/tencent/mm/protocal/protobuf/ena:UpO	Z
    //   535: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   538: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   541: aload 7
    //   543: putfield 396	com/tencent/mm/protocal/protobuf/cjd:Tqh	Lcom/tencent/mm/protocal/protobuf/ena;
    //   546: ldc 51
    //   548: ldc_w 398
    //   551: iconst_2
    //   552: anewarray 5	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: aload 7
    //   559: getfield 378	com/tencent/mm/protocal/protobuf/ena:UpN	I
    //   562: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: dup
    //   567: iconst_1
    //   568: aload 7
    //   570: getfield 392	com/tencent/mm/protocal/protobuf/ena:UpO	Z
    //   573: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   576: aastore
    //   577: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: aload_0
    //   581: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   584: ldc_w 308
    //   587: invokevirtual 314	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   590: checkcast 316	android/app/ActivityManager
    //   593: invokevirtual 407	android/app/ActivityManager:getDeviceConfigurationInfo	()Landroid/content/pm/ConfigurationInfo;
    //   596: astore_1
    //   597: new 409	com/tencent/mm/protocal/protobuf/bnd
    //   600: dup
    //   601: invokespecial 410	com/tencent/mm/protocal/protobuf/bnd:<init>	()V
    //   604: astore 7
    //   606: aload_1
    //   607: getfield 415	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   610: ldc_w 416
    //   613: if_icmplt +1304 -> 1917
    //   616: iconst_1
    //   617: istore 6
    //   619: aload 7
    //   621: iload 6
    //   623: putfield 419	com/tencent/mm/protocal/protobuf/bnd:SYc	Z
    //   626: aload_1
    //   627: getfield 415	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   630: ldc_w 420
    //   633: if_icmplt +1290 -> 1923
    //   636: iconst_1
    //   637: istore 6
    //   639: aload 7
    //   641: iload 6
    //   643: putfield 423	com/tencent/mm/protocal/protobuf/bnd:SYd	Z
    //   646: ldc_w 425
    //   649: invokestatic 431	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   652: pop
    //   653: aload 7
    //   655: iconst_0
    //   656: putfield 434	com/tencent/mm/protocal/protobuf/bnd:SYe	Z
    //   659: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   662: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   665: aload 7
    //   667: putfield 438	com/tencent/mm/protocal/protobuf/cjd:Tql	Lcom/tencent/mm/protocal/protobuf/bnd;
    //   670: ldc 51
    //   672: ldc_w 440
    //   675: iconst_4
    //   676: anewarray 5	java/lang/Object
    //   679: dup
    //   680: iconst_0
    //   681: aload 7
    //   683: getfield 419	com/tencent/mm/protocal/protobuf/bnd:SYc	Z
    //   686: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   689: aastore
    //   690: dup
    //   691: iconst_1
    //   692: aload 7
    //   694: getfield 423	com/tencent/mm/protocal/protobuf/bnd:SYd	Z
    //   697: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   700: aastore
    //   701: dup
    //   702: iconst_2
    //   703: aload_1
    //   704: getfield 415	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   707: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   710: aastore
    //   711: dup
    //   712: iconst_3
    //   713: aload 7
    //   715: getfield 434	com/tencent/mm/protocal/protobuf/bnd:SYe	Z
    //   718: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   721: aastore
    //   722: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: aload_0
    //   726: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   729: ldc_w 442
    //   732: invokevirtual 314	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   735: checkcast 444	android/view/WindowManager
    //   738: invokeinterface 448 1 0
    //   743: astore_1
    //   744: new 450	android/graphics/Point
    //   747: dup
    //   748: invokespecial 451	android/graphics/Point:<init>	()V
    //   751: astore 7
    //   753: aload_1
    //   754: aload 7
    //   756: invokevirtual 457	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   759: aload 7
    //   761: getfield 460	android/graphics/Point:x	I
    //   764: istore_2
    //   765: aload 7
    //   767: getfield 463	android/graphics/Point:y	I
    //   770: istore_3
    //   771: new 465	com/tencent/mm/protocal/protobuf/ebc
    //   774: dup
    //   775: invokespecial 466	com/tencent/mm/protocal/protobuf/ebc:<init>	()V
    //   778: astore_1
    //   779: aload_1
    //   780: new 468	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   787: iload_2
    //   788: invokestatic 472	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   791: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc_w 477
    //   797: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: iload_3
    //   801: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   804: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: putfield 486	com/tencent/mm/protocal/protobuf/ebc:resolution	Ljava/lang/String;
    //   810: aload_1
    //   811: aload_0
    //   812: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   815: invokevirtual 490	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   818: invokevirtual 496	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   821: getfield 502	android/util/DisplayMetrics:density	F
    //   824: f2i
    //   825: putfield 505	com/tencent/mm/protocal/protobuf/ebc:lRI	I
    //   828: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   831: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   834: aload_1
    //   835: putfield 509	com/tencent/mm/protocal/protobuf/cjd:Tqi	Lcom/tencent/mm/protocal/protobuf/ebc;
    //   838: ldc 51
    //   840: ldc_w 511
    //   843: iconst_2
    //   844: anewarray 5	java/lang/Object
    //   847: dup
    //   848: iconst_0
    //   849: aload_1
    //   850: getfield 486	com/tencent/mm/protocal/protobuf/ebc:resolution	Ljava/lang/String;
    //   853: aastore
    //   854: dup
    //   855: iconst_1
    //   856: aload_1
    //   857: getfield 505	com/tencent/mm/protocal/protobuf/ebc:lRI	I
    //   860: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   863: aastore
    //   864: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   867: new 513	com/tencent/mm/protocal/protobuf/abw
    //   870: dup
    //   871: invokespecial 514	com/tencent/mm/protocal/protobuf/abw:<init>	()V
    //   874: astore_1
    //   875: aload_1
    //   876: ldc_w 516
    //   879: invokestatic 518	com/tencent/mm/plugin/hardwareopt/c/a:aLr	(Ljava/lang/String;)Ljava/lang/String;
    //   882: putfield 521	com/tencent/mm/protocal/protobuf/abw:SnI	Ljava/lang/String;
    //   885: aload_1
    //   886: ldc_w 523
    //   889: invokestatic 518	com/tencent/mm/plugin/hardwareopt/c/a:aLr	(Ljava/lang/String;)Ljava/lang/String;
    //   892: putfield 526	com/tencent/mm/protocal/protobuf/abw:SnJ	Ljava/lang/String;
    //   895: aload_1
    //   896: invokestatic 528	com/tencent/mm/plugin/hardwareopt/c/a:eCj	()Ljava/util/LinkedList;
    //   899: putfield 531	com/tencent/mm/protocal/protobuf/abw:SnK	Ljava/util/LinkedList;
    //   902: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   905: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   908: aload_1
    //   909: putfield 535	com/tencent/mm/protocal/protobuf/cjd:Tqj	Lcom/tencent/mm/protocal/protobuf/abw;
    //   912: aload_1
    //   913: getfield 521	com/tencent/mm/protocal/protobuf/abw:SnI	Ljava/lang/String;
    //   916: astore 7
    //   918: aload_1
    //   919: getfield 526	com/tencent/mm/protocal/protobuf/abw:SnJ	Ljava/lang/String;
    //   922: astore 8
    //   924: aload_1
    //   925: getfield 531	com/tencent/mm/protocal/protobuf/abw:SnK	Ljava/util/LinkedList;
    //   928: ifnull +1001 -> 1929
    //   931: aload_1
    //   932: getfield 531	com/tencent/mm/protocal/protobuf/abw:SnK	Ljava/util/LinkedList;
    //   935: invokevirtual 538	java/util/LinkedList:size	()I
    //   938: istore_2
    //   939: ldc 51
    //   941: ldc_w 540
    //   944: iconst_3
    //   945: anewarray 5	java/lang/Object
    //   948: dup
    //   949: iconst_0
    //   950: aload 7
    //   952: aastore
    //   953: dup
    //   954: iconst_1
    //   955: aload 8
    //   957: aastore
    //   958: dup
    //   959: iconst_2
    //   960: iload_2
    //   961: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   964: aastore
    //   965: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   968: new 542	com/tencent/mm/protocal/protobuf/aou
    //   971: dup
    //   972: invokespecial 543	com/tencent/mm/protocal/protobuf/aou:<init>	()V
    //   975: astore_1
    //   976: aload_1
    //   977: aload_0
    //   978: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   981: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   984: ldc_w 549
    //   987: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   990: putfield 558	com/tencent/mm/protocal/protobuf/aou:SBD	Z
    //   993: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   996: bipush 18
    //   998: if_icmplt +844 -> 1842
    //   1001: aload_1
    //   1002: aload_0
    //   1003: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1006: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1009: ldc_w 560
    //   1012: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1015: putfield 563	com/tencent/mm/protocal/protobuf/aou:SBE	Z
    //   1018: aload_1
    //   1019: aload_0
    //   1020: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1023: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1026: ldc_w 565
    //   1029: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1032: putfield 568	com/tencent/mm/protocal/protobuf/aou:SBF	Z
    //   1035: aload_1
    //   1036: aload_0
    //   1037: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1040: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1043: ldc_w 570
    //   1046: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1049: putfield 573	com/tencent/mm/protocal/protobuf/aou:SBG	Z
    //   1052: aload_1
    //   1053: aload_0
    //   1054: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1057: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1060: ldc_w 575
    //   1063: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1066: putfield 578	com/tencent/mm/protocal/protobuf/aou:SBH	Z
    //   1069: aload_1
    //   1070: aload_0
    //   1071: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1074: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1077: ldc_w 580
    //   1080: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1083: putfield 583	com/tencent/mm/protocal/protobuf/aou:SBI	Z
    //   1086: aload_1
    //   1087: aload_0
    //   1088: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1091: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1094: ldc_w 585
    //   1097: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1100: putfield 588	com/tencent/mm/protocal/protobuf/aou:SBJ	Z
    //   1103: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1106: bipush 19
    //   1108: if_icmplt +742 -> 1850
    //   1111: aload_1
    //   1112: aload_0
    //   1113: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1116: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1119: ldc_w 590
    //   1122: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1125: putfield 593	com/tencent/mm/protocal/protobuf/aou:SBU	Z
    //   1128: aload_1
    //   1129: aload_0
    //   1130: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1133: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1136: ldc_w 585
    //   1139: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1142: putfield 596	com/tencent/mm/protocal/protobuf/aou:SBK	Z
    //   1145: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1148: bipush 23
    //   1150: if_icmplt +708 -> 1858
    //   1153: aload_1
    //   1154: aload_0
    //   1155: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1158: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1161: ldc_w 598
    //   1164: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1167: putfield 601	com/tencent/mm/protocal/protobuf/aou:SBL	Z
    //   1170: aload_1
    //   1171: aload_0
    //   1172: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1175: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1178: ldc_w 603
    //   1181: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1184: putfield 606	com/tencent/mm/protocal/protobuf/aou:SBM	Z
    //   1187: aload_1
    //   1188: aload_0
    //   1189: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1192: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1195: ldc_w 608
    //   1198: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1201: putfield 611	com/tencent/mm/protocal/protobuf/aou:SBN	Z
    //   1204: aload_1
    //   1205: aload_0
    //   1206: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1209: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1212: ldc_w 613
    //   1215: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1218: putfield 616	com/tencent/mm/protocal/protobuf/aou:SBO	Z
    //   1221: aload_1
    //   1222: aload_0
    //   1223: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1226: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1229: ldc_w 618
    //   1232: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1235: putfield 621	com/tencent/mm/protocal/protobuf/aou:SBP	Z
    //   1238: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1241: bipush 19
    //   1243: if_icmplt +641 -> 1884
    //   1246: aload_1
    //   1247: aload_0
    //   1248: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1251: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1254: ldc_w 623
    //   1257: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1260: putfield 626	com/tencent/mm/protocal/protobuf/aou:SBQ	Z
    //   1263: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   1266: bipush 19
    //   1268: if_icmplt +624 -> 1892
    //   1271: aload_1
    //   1272: aload_0
    //   1273: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1276: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1279: ldc_w 628
    //   1282: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1285: putfield 631	com/tencent/mm/protocal/protobuf/aou:SBR	Z
    //   1288: aload_1
    //   1289: aload_0
    //   1290: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1293: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1296: ldc_w 633
    //   1299: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1302: putfield 636	com/tencent/mm/protocal/protobuf/aou:SBS	Z
    //   1305: aload_1
    //   1306: aload_0
    //   1307: getfield 15	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1310: invokevirtual 547	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1313: ldc_w 638
    //   1316: invokevirtual 555	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1319: putfield 641	com/tencent/mm/protocal/protobuf/aou:SBT	Z
    //   1322: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1325: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   1328: aload_1
    //   1329: putfield 645	com/tencent/mm/protocal/protobuf/cjd:Tqk	Lcom/tencent/mm/protocal/protobuf/aou;
    //   1332: ldc 51
    //   1334: ldc_w 647
    //   1337: bipush 18
    //   1339: anewarray 5	java/lang/Object
    //   1342: dup
    //   1343: iconst_0
    //   1344: aload_1
    //   1345: getfield 558	com/tencent/mm/protocal/protobuf/aou:SBD	Z
    //   1348: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1351: aastore
    //   1352: dup
    //   1353: iconst_1
    //   1354: aload_1
    //   1355: getfield 563	com/tencent/mm/protocal/protobuf/aou:SBE	Z
    //   1358: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1361: aastore
    //   1362: dup
    //   1363: iconst_2
    //   1364: aload_1
    //   1365: getfield 568	com/tencent/mm/protocal/protobuf/aou:SBF	Z
    //   1368: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1371: aastore
    //   1372: dup
    //   1373: iconst_3
    //   1374: aload_1
    //   1375: getfield 573	com/tencent/mm/protocal/protobuf/aou:SBG	Z
    //   1378: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1381: aastore
    //   1382: dup
    //   1383: iconst_4
    //   1384: aload_1
    //   1385: getfield 578	com/tencent/mm/protocal/protobuf/aou:SBH	Z
    //   1388: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_5
    //   1394: aload_1
    //   1395: getfield 583	com/tencent/mm/protocal/protobuf/aou:SBI	Z
    //   1398: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1401: aastore
    //   1402: dup
    //   1403: bipush 6
    //   1405: aload_1
    //   1406: getfield 588	com/tencent/mm/protocal/protobuf/aou:SBJ	Z
    //   1409: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1412: aastore
    //   1413: dup
    //   1414: bipush 7
    //   1416: aload_1
    //   1417: getfield 593	com/tencent/mm/protocal/protobuf/aou:SBU	Z
    //   1420: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1423: aastore
    //   1424: dup
    //   1425: bipush 8
    //   1427: aload_1
    //   1428: getfield 596	com/tencent/mm/protocal/protobuf/aou:SBK	Z
    //   1431: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1434: aastore
    //   1435: dup
    //   1436: bipush 9
    //   1438: aload_1
    //   1439: getfield 601	com/tencent/mm/protocal/protobuf/aou:SBL	Z
    //   1442: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1445: aastore
    //   1446: dup
    //   1447: bipush 10
    //   1449: aload_1
    //   1450: getfield 606	com/tencent/mm/protocal/protobuf/aou:SBM	Z
    //   1453: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1456: aastore
    //   1457: dup
    //   1458: bipush 11
    //   1460: aload_1
    //   1461: getfield 611	com/tencent/mm/protocal/protobuf/aou:SBN	Z
    //   1464: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1467: aastore
    //   1468: dup
    //   1469: bipush 12
    //   1471: aload_1
    //   1472: getfield 616	com/tencent/mm/protocal/protobuf/aou:SBO	Z
    //   1475: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1478: aastore
    //   1479: dup
    //   1480: bipush 13
    //   1482: aload_1
    //   1483: getfield 621	com/tencent/mm/protocal/protobuf/aou:SBP	Z
    //   1486: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1489: aastore
    //   1490: dup
    //   1491: bipush 14
    //   1493: aload_1
    //   1494: getfield 626	com/tencent/mm/protocal/protobuf/aou:SBQ	Z
    //   1497: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1500: aastore
    //   1501: dup
    //   1502: bipush 15
    //   1504: aload_1
    //   1505: getfield 631	com/tencent/mm/protocal/protobuf/aou:SBR	Z
    //   1508: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1511: aastore
    //   1512: dup
    //   1513: bipush 16
    //   1515: aload_1
    //   1516: getfield 636	com/tencent/mm/protocal/protobuf/aou:SBS	Z
    //   1519: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1522: aastore
    //   1523: dup
    //   1524: bipush 17
    //   1526: aload_1
    //   1527: getfield 641	com/tencent/mm/protocal/protobuf/aou:SBT	Z
    //   1530: invokestatic 403	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1533: aastore
    //   1534: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1537: ldc 51
    //   1539: ldc_w 649
    //   1542: iconst_1
    //   1543: anewarray 5	java/lang/Object
    //   1546: dup
    //   1547: iconst_0
    //   1548: invokestatic 182	java/lang/System:nanoTime	()J
    //   1551: lload 4
    //   1553: lsub
    //   1554: ldc2_w 650
    //   1557: ldiv
    //   1558: ldc2_w 650
    //   1561: ldiv
    //   1562: invokestatic 656	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1565: aastore
    //   1566: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1569: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1572: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   1575: astore_1
    //   1576: aload_1
    //   1577: ifnull +61 -> 1638
    //   1580: aload_1
    //   1581: getfield 298	com/tencent/mm/protocal/protobuf/cjd:Tqf	Lcom/tencent/mm/protocal/protobuf/ti;
    //   1584: ifnull +25 -> 1609
    //   1587: invokestatic 660	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1590: invokevirtual 666	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1593: getstatic 672	com/tencent/mm/storage/ar$a:Vuh	Lcom/tencent/mm/storage/ar$a;
    //   1596: aload_1
    //   1597: getfield 298	com/tencent/mm/protocal/protobuf/cjd:Tqf	Lcom/tencent/mm/protocal/protobuf/ti;
    //   1600: getfield 291	com/tencent/mm/protocal/protobuf/ti:Sdc	I
    //   1603: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1606: invokevirtual 678	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1609: aload_1
    //   1610: getfield 357	com/tencent/mm/protocal/protobuf/cjd:Tqg	Lcom/tencent/mm/protocal/protobuf/cxb;
    //   1613: ifnull +25 -> 1638
    //   1616: invokestatic 660	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1619: invokevirtual 666	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1622: getstatic 681	com/tencent/mm/storage/ar$a:Vui	Lcom/tencent/mm/storage/ar$a;
    //   1625: aload_1
    //   1626: getfield 357	com/tencent/mm/protocal/protobuf/cjd:Tqg	Lcom/tencent/mm/protocal/protobuf/cxb;
    //   1629: getfield 335	com/tencent/mm/protocal/protobuf/cxb:TFC	I
    //   1632: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1635: invokevirtual 678	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1638: invokestatic 220	com/tencent/mm/plugin/hardwareopt/b/a:eCh	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1641: invokevirtual 224	com/tencent/mm/plugin/hardwareopt/b/a:eCi	()Lcom/tencent/mm/protocal/protobuf/cjd;
    //   1644: astore_1
    //   1645: ldc 176
    //   1647: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1650: aload_1
    //   1651: areturn
    //   1652: astore_1
    //   1653: ldc 51
    //   1655: aload_1
    //   1656: ldc_w 683
    //   1659: iconst_0
    //   1660: anewarray 5	java/lang/Object
    //   1663: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1666: goto -1440 -> 226
    //   1669: astore_1
    //   1670: ldc 51
    //   1672: aload_1
    //   1673: ldc_w 685
    //   1676: iconst_0
    //   1677: anewarray 5	java/lang/Object
    //   1680: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1683: invokestatic 691	com/tencent/mm/vending/g/g:ieO	()Lcom/tencent/mm/vending/g/b;
    //   1686: astore_1
    //   1687: aload_1
    //   1688: ifnull +10 -> 1698
    //   1691: aload_1
    //   1692: aconst_null
    //   1693: invokeinterface 697 2 0
    //   1698: ldc 176
    //   1700: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1703: aconst_null
    //   1704: areturn
    //   1705: astore 8
    //   1707: aload_1
    //   1708: astore 7
    //   1710: ldc 51
    //   1712: aload 8
    //   1714: ldc_w 699
    //   1717: iconst_0
    //   1718: anewarray 5	java/lang/Object
    //   1721: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1724: aload_1
    //   1725: ifnull -1499 -> 226
    //   1728: aload_1
    //   1729: invokevirtual 294	java/io/RandomAccessFile:close	()V
    //   1732: goto -1506 -> 226
    //   1735: astore_1
    //   1736: ldc 51
    //   1738: aload_1
    //   1739: ldc_w 683
    //   1742: iconst_0
    //   1743: anewarray 5	java/lang/Object
    //   1746: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1749: goto -1523 -> 226
    //   1752: astore_1
    //   1753: aload 7
    //   1755: ifnull +8 -> 1763
    //   1758: aload 7
    //   1760: invokevirtual 294	java/io/RandomAccessFile:close	()V
    //   1763: ldc 176
    //   1765: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1768: aload_1
    //   1769: athrow
    //   1770: astore 7
    //   1772: ldc 51
    //   1774: aload 7
    //   1776: ldc_w 683
    //   1779: iconst_0
    //   1780: anewarray 5	java/lang/Object
    //   1783: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1786: goto -23 -> 1763
    //   1789: aload 7
    //   1791: aload_1
    //   1792: invokevirtual 702	android/os/StatFs:getBlockSize	()I
    //   1795: i2l
    //   1796: aload_1
    //   1797: invokevirtual 705	android/os/StatFs:getAvailableBlocks	()I
    //   1800: i2l
    //   1801: lmul
    //   1802: ldc2_w 331
    //   1805: ldiv
    //   1806: ldc2_w 331
    //   1809: ldiv
    //   1810: l2i
    //   1811: putfield 378	com/tencent/mm/protocal/protobuf/ena:UpN	I
    //   1814: goto -1293 -> 521
    //   1817: astore 8
    //   1819: ldc 51
    //   1821: aload 8
    //   1823: ldc_w 707
    //   1826: iconst_0
    //   1827: anewarray 5	java/lang/Object
    //   1830: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1833: aload 7
    //   1835: iconst_0
    //   1836: putfield 434	com/tencent/mm/protocal/protobuf/bnd:SYe	Z
    //   1839: goto -1180 -> 659
    //   1842: aload_1
    //   1843: iconst_0
    //   1844: putfield 563	com/tencent/mm/protocal/protobuf/aou:SBE	Z
    //   1847: goto -829 -> 1018
    //   1850: aload_1
    //   1851: iconst_0
    //   1852: putfield 593	com/tencent/mm/protocal/protobuf/aou:SBU	Z
    //   1855: goto -727 -> 1128
    //   1858: getstatic 713	com/tencent/mm/compatible/deviceinfo/af:juL	Lcom/tencent/mm/compatible/deviceinfo/t;
    //   1861: getfield 718	com/tencent/mm/compatible/deviceinfo/t:jsW	I
    //   1864: iconst_1
    //   1865: if_icmpne +11 -> 1876
    //   1868: aload_1
    //   1869: iconst_1
    //   1870: putfield 601	com/tencent/mm/protocal/protobuf/aou:SBL	Z
    //   1873: goto -703 -> 1170
    //   1876: aload_1
    //   1877: iconst_0
    //   1878: putfield 601	com/tencent/mm/protocal/protobuf/aou:SBL	Z
    //   1881: goto -711 -> 1170
    //   1884: aload_1
    //   1885: iconst_0
    //   1886: putfield 626	com/tencent/mm/protocal/protobuf/aou:SBQ	Z
    //   1889: goto -626 -> 1263
    //   1892: aload_1
    //   1893: iconst_0
    //   1894: putfield 631	com/tencent/mm/protocal/protobuf/aou:SBR	Z
    //   1897: goto -609 -> 1288
    //   1900: astore_1
    //   1901: ldc 51
    //   1903: aload_1
    //   1904: ldc_w 720
    //   1907: iconst_0
    //   1908: anewarray 5	java/lang/Object
    //   1911: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1914: goto -276 -> 1638
    //   1917: iconst_0
    //   1918: istore 6
    //   1920: goto -1301 -> 619
    //   1923: iconst_0
    //   1924: istore 6
    //   1926: goto -1287 -> 639
    //   1929: iconst_0
    //   1930: istore_2
    //   1931: goto -992 -> 939
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1934	0	this	a
    //   0	1934	1	paramContext	Context
    //   764	1167	2	i	int
    //   770	31	3	j	int
    //   13	1539	4	l	long
    //   617	1308	6	bool	boolean
    //   178	1581	7	localObject1	Object
    //   1770	64	7	localIOException1	java.io.IOException
    //   189	767	8	localObject2	Object
    //   1705	8	8	localIOException2	java.io.IOException
    //   1817	5	8	localThrowable	java.lang.Throwable
    //   108	176	9	localti	com.tencent.mm.protocal.protobuf.ti
    // Exception table:
    //   from	to	target	type
    //   221	226	1652	java/io/IOException
    //   15	177	1669	java/lang/Exception
    //   221	226	1669	java/lang/Exception
    //   226	521	1669	java/lang/Exception
    //   521	616	1669	java/lang/Exception
    //   619	636	1669	java/lang/Exception
    //   639	646	1669	java/lang/Exception
    //   646	659	1669	java/lang/Exception
    //   659	939	1669	java/lang/Exception
    //   939	1018	1669	java/lang/Exception
    //   1018	1128	1669	java/lang/Exception
    //   1128	1170	1669	java/lang/Exception
    //   1170	1263	1669	java/lang/Exception
    //   1263	1288	1669	java/lang/Exception
    //   1288	1569	1669	java/lang/Exception
    //   1638	1645	1669	java/lang/Exception
    //   1653	1666	1669	java/lang/Exception
    //   1728	1732	1669	java/lang/Exception
    //   1736	1749	1669	java/lang/Exception
    //   1758	1763	1669	java/lang/Exception
    //   1763	1770	1669	java/lang/Exception
    //   1772	1786	1669	java/lang/Exception
    //   1789	1814	1669	java/lang/Exception
    //   1819	1839	1669	java/lang/Exception
    //   1842	1847	1669	java/lang/Exception
    //   1850	1855	1669	java/lang/Exception
    //   1858	1873	1669	java/lang/Exception
    //   1876	1881	1669	java/lang/Exception
    //   1884	1889	1669	java/lang/Exception
    //   1892	1897	1669	java/lang/Exception
    //   1901	1914	1669	java/lang/Exception
    //   182	191	1705	java/io/IOException
    //   198	216	1705	java/io/IOException
    //   1728	1732	1735	java/io/IOException
    //   182	191	1752	finally
    //   198	216	1752	finally
    //   1710	1724	1752	finally
    //   1758	1763	1770	java/io/IOException
    //   646	659	1817	java/lang/Throwable
    //   1569	1576	1900	java/lang/Exception
    //   1580	1609	1900	java/lang/Exception
    //   1609	1638	1900	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.a
 * JD-Core Version:    0.7.0.1
 */