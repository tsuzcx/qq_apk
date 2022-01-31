package com.tencent.mm.plugin.hardwareopt.c;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements com.tencent.mm.vending.c.a<auq, Context>
{
  private Context mContext = null;
  
  private static String QK(String paramString)
  {
    AppMethodBeat.i(59277);
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
        paramString = MediaCodec.createEncoderByType(paramString);
        str1 = paramString;
        localObject1 = paramString;
        str2 = paramString.getName();
        if (paramString != null) {
          paramString.release();
        }
        AppMethodBeat.o(59277);
        return str2;
      }
      AppMethodBeat.o(59277);
      return "too low version";
    }
    catch (Exception paramString)
    {
      localObject1 = str1;
      ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", paramString, "hy: error in handle media codec", new Object[0]);
      if (str1 != null) {
        str1.release();
      }
      AppMethodBeat.o(59277);
      return "undefined";
    }
    finally
    {
      if (localObject1 != null) {
        ((MediaCodec)localObject1).release();
      }
      AppMethodBeat.o(59277);
    }
  }
  
  private static LinkedList<bde> bHR()
  {
    AppMethodBeat.i(59278);
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
    ab.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[] { localObject3 });
    Object localObject1 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new bde();
      ((bde)localObject3).cfP = ((String)((Map.Entry)localObject2).getKey());
      localObject4 = new LinkedList();
      if (((Map.Entry)localObject2).getValue() != null) {
        ((LinkedList)localObject4).addAll((Collection)((Map.Entry)localObject2).getValue());
      }
      ((bde)localObject3).xtg = ((LinkedList)localObject4);
      localLinkedList.add(localObject3);
    }
    AppMethodBeat.o(59278);
    return localLinkedList;
  }
  
  /* Error */
  private auq eo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   10: invokestatic 182	java/lang/System:nanoTime	()J
    //   13: lstore 4
    //   15: new 184	com/tencent/mm/protocal/protobuf/ho
    //   18: dup
    //   19: invokespecial 185	com/tencent/mm/protocal/protobuf/ho:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: iconst_0
    //   25: invokestatic 191	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   28: putfield 194	com/tencent/mm/protocal/protobuf/ho:imei	Ljava/lang/String;
    //   31: aload_1
    //   32: getfield 194	com/tencent/mm/protocal/protobuf/ho:imei	Ljava/lang/String;
    //   35: invokestatic 200	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   38: ifeq +60 -> 98
    //   41: ldc 55
    //   43: ldc 202
    //   45: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 9	com/tencent/mm/plugin/hardwareopt/c/a$a
    //   51: dup
    //   52: invokespecial 207	com/tencent/mm/plugin/hardwareopt/c/a$a:<init>	()V
    //   55: astore_1
    //   56: ldc 176
    //   58: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_1
    //   62: athrow
    //   63: astore_1
    //   64: ldc 55
    //   66: aload_1
    //   67: ldc 209
    //   69: iconst_0
    //   70: anewarray 5	java/lang/Object
    //   73: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: invokestatic 215	com/tencent/mm/vending/g/f:dQs	()Lcom/tencent/mm/vending/g/b;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +10 -> 91
    //   84: aload_1
    //   85: aconst_null
    //   86: invokeinterface 221 2 0
    //   91: ldc 176
    //   93: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aconst_null
    //   97: areturn
    //   98: aload_1
    //   99: getstatic 226	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   102: putfield 229	com/tencent/mm/protocal/protobuf/ho:wul	Ljava/lang/String;
    //   105: aload_1
    //   106: getstatic 232	android/os/Build:MODEL	Ljava/lang/String;
    //   109: putfield 235	com/tencent/mm/protocal/protobuf/ho:wum	Ljava/lang/String;
    //   112: aload_1
    //   113: getstatic 238	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   116: putfield 241	com/tencent/mm/protocal/protobuf/ho:wun	Ljava/lang/String;
    //   119: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   122: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   125: aload_1
    //   126: putfield 257	com/tencent/mm/protocal/protobuf/auq:xjC	Lcom/tencent/mm/protocal/protobuf/ho;
    //   129: ldc 55
    //   131: ldc_w 259
    //   134: iconst_4
    //   135: anewarray 5	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: getfield 194	com/tencent/mm/protocal/protobuf/ho:imei	Ljava/lang/String;
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload_1
    //   148: getfield 229	com/tencent/mm/protocal/protobuf/ho:wul	Ljava/lang/String;
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: aload_1
    //   155: getfield 235	com/tencent/mm/protocal/protobuf/ho:wum	Ljava/lang/String;
    //   158: aastore
    //   159: dup
    //   160: iconst_3
    //   161: aload_1
    //   162: getfield 241	com/tencent/mm/protocal/protobuf/ho:wun	Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: new 264	com/tencent/mm/protocal/protobuf/nv
    //   172: dup
    //   173: invokespecial 265	com/tencent/mm/protocal/protobuf/nv:<init>	()V
    //   176: astore 9
    //   178: aload 9
    //   180: getstatic 268	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   183: putfield 271	com/tencent/mm/protocal/protobuf/nv:wDv	Ljava/lang/String;
    //   186: invokestatic 277	com/tencent/mm/compatible/e/n:Ls	()Ljava/util/Map;
    //   189: astore_1
    //   190: aload 9
    //   192: aload_1
    //   193: ldc_w 279
    //   196: invokeinterface 105 2 0
    //   201: checkcast 96	java/lang/String
    //   204: ldc_w 281
    //   207: invokestatic 285	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 288	com/tencent/mm/protocal/protobuf/nv:wDt	Ljava/lang/String;
    //   213: aload 9
    //   215: aload_1
    //   216: ldc_w 290
    //   219: invokeinterface 105 2 0
    //   224: checkcast 96	java/lang/String
    //   227: putfield 291	com/tencent/mm/protocal/protobuf/nv:wum	Ljava/lang/String;
    //   230: aload 9
    //   232: aload_1
    //   233: ldc_w 293
    //   236: invokeinterface 105 2 0
    //   241: checkcast 96	java/lang/String
    //   244: putfield 296	com/tencent/mm/protocal/protobuf/nv:wDw	Ljava/lang/String;
    //   247: new 298	java/io/RandomAccessFile
    //   250: dup
    //   251: ldc_w 300
    //   254: ldc_w 302
    //   257: invokespecial 304	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: astore 7
    //   262: aload 7
    //   264: astore_1
    //   265: aload 9
    //   267: aload 7
    //   269: invokevirtual 307	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   272: iconst_m1
    //   273: invokestatic 311	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   276: sipush 1000
    //   279: idiv
    //   280: putfield 314	com/tencent/mm/protocal/protobuf/nv:wDu	I
    //   283: aload 7
    //   285: invokevirtual 317	java/io/RandomAccessFile:close	()V
    //   288: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   291: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   294: aload 9
    //   296: putfield 321	com/tencent/mm/protocal/protobuf/auq:xjD	Lcom/tencent/mm/protocal/protobuf/nv;
    //   299: ldc 55
    //   301: ldc_w 323
    //   304: iconst_5
    //   305: anewarray 5	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload 9
    //   312: getfield 271	com/tencent/mm/protocal/protobuf/nv:wDv	Ljava/lang/String;
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: aload 9
    //   320: getfield 288	com/tencent/mm/protocal/protobuf/nv:wDt	Ljava/lang/String;
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: aload 9
    //   328: getfield 314	com/tencent/mm/protocal/protobuf/nv:wDu	I
    //   331: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_3
    //   337: aload 9
    //   339: getfield 291	com/tencent/mm/protocal/protobuf/nv:wum	Ljava/lang/String;
    //   342: aastore
    //   343: dup
    //   344: iconst_4
    //   345: aload 9
    //   347: getfield 296	com/tencent/mm/protocal/protobuf/nv:wDw	Ljava/lang/String;
    //   350: aastore
    //   351: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: aload_0
    //   355: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   358: ldc_w 331
    //   361: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   364: checkcast 339	android/app/ActivityManager
    //   367: astore 7
    //   369: new 341	android/app/ActivityManager$MemoryInfo
    //   372: dup
    //   373: invokespecial 342	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   376: astore_1
    //   377: aload 7
    //   379: aload_1
    //   380: invokevirtual 346	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   383: new 348	com/tencent/mm/protocal/protobuf/bcy
    //   386: dup
    //   387: invokespecial 349	com/tencent/mm/protocal/protobuf/bcy:<init>	()V
    //   390: astore 7
    //   392: aload 7
    //   394: aload_1
    //   395: getfield 353	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   398: ldc2_w 354
    //   401: ldiv
    //   402: ldc2_w 354
    //   405: ldiv
    //   406: l2i
    //   407: putfield 358	com/tencent/mm/protocal/protobuf/bcy:xsW	I
    //   410: aload 7
    //   412: aload_1
    //   413: getfield 361	android/app/ActivityManager$MemoryInfo:threshold	J
    //   416: ldc2_w 354
    //   419: ldiv
    //   420: ldc2_w 354
    //   423: ldiv
    //   424: l2i
    //   425: putfield 364	com/tencent/mm/protocal/protobuf/bcy:xsX	I
    //   428: aload 7
    //   430: aload_0
    //   431: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   434: ldc_w 331
    //   437: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   440: checkcast 339	android/app/ActivityManager
    //   443: invokevirtual 367	android/app/ActivityManager:getLargeMemoryClass	()I
    //   446: putfield 370	com/tencent/mm/protocal/protobuf/bcy:xsY	I
    //   449: aload 7
    //   451: aload_0
    //   452: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   455: ldc_w 331
    //   458: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   461: checkcast 339	android/app/ActivityManager
    //   464: invokevirtual 373	android/app/ActivityManager:getMemoryClass	()I
    //   467: putfield 376	com/tencent/mm/protocal/protobuf/bcy:gim	I
    //   470: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   473: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   476: aload 7
    //   478: putfield 380	com/tencent/mm/protocal/protobuf/auq:xjE	Lcom/tencent/mm/protocal/protobuf/bcy;
    //   481: ldc 55
    //   483: ldc_w 382
    //   486: iconst_4
    //   487: anewarray 5	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload 7
    //   494: getfield 358	com/tencent/mm/protocal/protobuf/bcy:xsW	I
    //   497: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_1
    //   503: aload 7
    //   505: getfield 364	com/tencent/mm/protocal/protobuf/bcy:xsX	I
    //   508: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: aload 7
    //   516: getfield 370	com/tencent/mm/protocal/protobuf/bcy:xsY	I
    //   519: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: dup
    //   524: iconst_3
    //   525: aload 7
    //   527: getfield 376	com/tencent/mm/protocal/protobuf/bcy:gim	I
    //   530: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   537: new 384	android/os/StatFs
    //   540: dup
    //   541: getstatic 389	com/tencent/mm/compatible/util/e:eQx	Ljava/lang/String;
    //   544: invokespecial 392	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   547: astore_1
    //   548: new 394	com/tencent/mm/protocal/protobuf/cgq
    //   551: dup
    //   552: invokespecial 395	com/tencent/mm/protocal/protobuf/cgq:<init>	()V
    //   555: astore 7
    //   557: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   560: bipush 18
    //   562: if_icmplt +1258 -> 1820
    //   565: aload 7
    //   567: aload_1
    //   568: invokevirtual 398	android/os/StatFs:getTotalBytes	()J
    //   571: ldc2_w 354
    //   574: ldiv
    //   575: ldc2_w 354
    //   578: ldiv
    //   579: l2i
    //   580: putfield 401	com/tencent/mm/protocal/protobuf/cgq:xRu	I
    //   583: aload 7
    //   585: invokestatic 406	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   588: ldc_w 408
    //   591: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   594: putfield 415	com/tencent/mm/protocal/protobuf/cgq:xRv	Z
    //   597: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   600: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   603: aload 7
    //   605: putfield 419	com/tencent/mm/protocal/protobuf/auq:xjF	Lcom/tencent/mm/protocal/protobuf/cgq;
    //   608: ldc 55
    //   610: ldc_w 421
    //   613: iconst_2
    //   614: anewarray 5	java/lang/Object
    //   617: dup
    //   618: iconst_0
    //   619: aload 7
    //   621: getfield 401	com/tencent/mm/protocal/protobuf/cgq:xRu	I
    //   624: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   627: aastore
    //   628: dup
    //   629: iconst_1
    //   630: aload 7
    //   632: getfield 415	com/tencent/mm/protocal/protobuf/cgq:xRv	Z
    //   635: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   638: aastore
    //   639: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   642: aload_0
    //   643: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   646: ldc_w 331
    //   649: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   652: checkcast 339	android/app/ActivityManager
    //   655: invokevirtual 430	android/app/ActivityManager:getDeviceConfigurationInfo	()Landroid/content/pm/ConfigurationInfo;
    //   658: astore_1
    //   659: new 432	com/tencent/mm/protocal/protobuf/ael
    //   662: dup
    //   663: invokespecial 433	com/tencent/mm/protocal/protobuf/ael:<init>	()V
    //   666: astore 7
    //   668: aload_1
    //   669: getfield 438	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   672: ldc_w 439
    //   675: if_icmplt +1283 -> 1958
    //   678: iconst_1
    //   679: istore 6
    //   681: aload 7
    //   683: iload 6
    //   685: putfield 442	com/tencent/mm/protocal/protobuf/ael:wXo	Z
    //   688: aload_1
    //   689: getfield 438	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   692: ldc_w 443
    //   695: if_icmplt +1269 -> 1964
    //   698: iconst_1
    //   699: istore 6
    //   701: aload 7
    //   703: iload 6
    //   705: putfield 446	com/tencent/mm/protocal/protobuf/ael:wXp	Z
    //   708: ldc_w 448
    //   711: invokestatic 454	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   714: pop
    //   715: aload 7
    //   717: iconst_0
    //   718: putfield 457	com/tencent/mm/protocal/protobuf/ael:wXq	Z
    //   721: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   724: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   727: aload 7
    //   729: putfield 461	com/tencent/mm/protocal/protobuf/auq:xjJ	Lcom/tencent/mm/protocal/protobuf/ael;
    //   732: ldc 55
    //   734: ldc_w 463
    //   737: iconst_4
    //   738: anewarray 5	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: aload 7
    //   745: getfield 442	com/tencent/mm/protocal/protobuf/ael:wXo	Z
    //   748: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   751: aastore
    //   752: dup
    //   753: iconst_1
    //   754: aload 7
    //   756: getfield 446	com/tencent/mm/protocal/protobuf/ael:wXp	Z
    //   759: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   762: aastore
    //   763: dup
    //   764: iconst_2
    //   765: aload_1
    //   766: getfield 438	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   769: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   772: aastore
    //   773: dup
    //   774: iconst_3
    //   775: aload 7
    //   777: getfield 457	com/tencent/mm/protocal/protobuf/ael:wXq	Z
    //   780: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   783: aastore
    //   784: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: aload_0
    //   788: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   791: ldc_w 465
    //   794: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   797: checkcast 467	android/view/WindowManager
    //   800: invokeinterface 471 1 0
    //   805: astore_1
    //   806: new 473	android/graphics/Point
    //   809: dup
    //   810: invokespecial 474	android/graphics/Point:<init>	()V
    //   813: astore 7
    //   815: aload_1
    //   816: aload 7
    //   818: invokevirtual 480	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   821: aload 7
    //   823: getfield 483	android/graphics/Point:x	I
    //   826: istore_2
    //   827: aload 7
    //   829: getfield 486	android/graphics/Point:y	I
    //   832: istore_3
    //   833: new 488	com/tencent/mm/protocal/protobuf/bww
    //   836: dup
    //   837: invokespecial 489	com/tencent/mm/protocal/protobuf/bww:<init>	()V
    //   840: astore_1
    //   841: aload_1
    //   842: new 491	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 492	java/lang/StringBuilder:<init>	()V
    //   849: iload_2
    //   850: invokestatic 495	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   853: invokevirtual 499	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: ldc_w 500
    //   859: invokevirtual 499	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: iload_3
    //   863: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   866: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: putfield 509	com/tencent/mm/protocal/protobuf/bww:xJZ	Ljava/lang/String;
    //   872: aload_1
    //   873: aload_0
    //   874: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   877: invokevirtual 513	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   880: invokevirtual 519	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   883: getfield 525	android/util/DisplayMetrics:density	F
    //   886: f2i
    //   887: putfield 527	com/tencent/mm/protocal/protobuf/bww:density	I
    //   890: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   893: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   896: aload_1
    //   897: putfield 531	com/tencent/mm/protocal/protobuf/auq:xjG	Lcom/tencent/mm/protocal/protobuf/bww;
    //   900: ldc 55
    //   902: ldc_w 533
    //   905: iconst_2
    //   906: anewarray 5	java/lang/Object
    //   909: dup
    //   910: iconst_0
    //   911: aload_1
    //   912: getfield 509	com/tencent/mm/protocal/protobuf/bww:xJZ	Ljava/lang/String;
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload_1
    //   919: getfield 527	com/tencent/mm/protocal/protobuf/bww:density	I
    //   922: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: aastore
    //   926: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   929: new 535	com/tencent/mm/protocal/protobuf/uf
    //   932: dup
    //   933: invokespecial 536	com/tencent/mm/protocal/protobuf/uf:<init>	()V
    //   936: astore_1
    //   937: aload_1
    //   938: ldc_w 538
    //   941: invokestatic 540	com/tencent/mm/plugin/hardwareopt/c/a:QK	(Ljava/lang/String;)Ljava/lang/String;
    //   944: putfield 543	com/tencent/mm/protocal/protobuf/uf:wME	Ljava/lang/String;
    //   947: aload_1
    //   948: ldc_w 545
    //   951: invokestatic 540	com/tencent/mm/plugin/hardwareopt/c/a:QK	(Ljava/lang/String;)Ljava/lang/String;
    //   954: putfield 548	com/tencent/mm/protocal/protobuf/uf:wMF	Ljava/lang/String;
    //   957: aload_1
    //   958: invokestatic 550	com/tencent/mm/plugin/hardwareopt/c/a:bHR	()Ljava/util/LinkedList;
    //   961: putfield 553	com/tencent/mm/protocal/protobuf/uf:wMG	Ljava/util/LinkedList;
    //   964: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   967: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   970: aload_1
    //   971: putfield 557	com/tencent/mm/protocal/protobuf/auq:xjH	Lcom/tencent/mm/protocal/protobuf/uf;
    //   974: aload_1
    //   975: getfield 543	com/tencent/mm/protocal/protobuf/uf:wME	Ljava/lang/String;
    //   978: astore 7
    //   980: aload_1
    //   981: getfield 548	com/tencent/mm/protocal/protobuf/uf:wMF	Ljava/lang/String;
    //   984: astore 8
    //   986: aload_1
    //   987: getfield 553	com/tencent/mm/protocal/protobuf/uf:wMG	Ljava/util/LinkedList;
    //   990: ifnull +980 -> 1970
    //   993: aload_1
    //   994: getfield 553	com/tencent/mm/protocal/protobuf/uf:wMG	Ljava/util/LinkedList;
    //   997: invokevirtual 560	java/util/LinkedList:size	()I
    //   1000: istore_2
    //   1001: ldc 55
    //   1003: ldc_w 562
    //   1006: iconst_3
    //   1007: anewarray 5	java/lang/Object
    //   1010: dup
    //   1011: iconst_0
    //   1012: aload 7
    //   1014: aastore
    //   1015: dup
    //   1016: iconst_1
    //   1017: aload 8
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_2
    //   1022: iload_2
    //   1023: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1026: aastore
    //   1027: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1030: new 564	com/tencent/mm/protocal/protobuf/adi
    //   1033: dup
    //   1034: invokespecial 565	com/tencent/mm/protocal/protobuf/adi:<init>	()V
    //   1037: astore_1
    //   1038: aload_1
    //   1039: aload_0
    //   1040: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1043: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1046: ldc_w 571
    //   1049: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1052: putfield 579	com/tencent/mm/protocal/protobuf/adi:wWd	Z
    //   1055: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   1058: bipush 18
    //   1060: if_icmplt +813 -> 1873
    //   1063: aload_1
    //   1064: aload_0
    //   1065: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1068: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1071: ldc_w 581
    //   1074: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1077: putfield 584	com/tencent/mm/protocal/protobuf/adi:wWe	Z
    //   1080: aload_1
    //   1081: aload_0
    //   1082: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1085: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1088: ldc_w 586
    //   1091: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1094: putfield 589	com/tencent/mm/protocal/protobuf/adi:wWf	Z
    //   1097: aload_1
    //   1098: aload_0
    //   1099: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1102: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1105: ldc_w 591
    //   1108: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1111: putfield 594	com/tencent/mm/protocal/protobuf/adi:wWg	Z
    //   1114: aload_1
    //   1115: aload_0
    //   1116: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1119: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1122: ldc_w 596
    //   1125: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1128: putfield 599	com/tencent/mm/protocal/protobuf/adi:wWh	Z
    //   1131: aload_1
    //   1132: aload_0
    //   1133: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1136: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1139: ldc_w 601
    //   1142: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1145: putfield 604	com/tencent/mm/protocal/protobuf/adi:wWi	Z
    //   1148: aload_1
    //   1149: aload_0
    //   1150: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1153: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1156: ldc_w 606
    //   1159: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1162: putfield 609	com/tencent/mm/protocal/protobuf/adi:wWj	Z
    //   1165: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   1168: bipush 19
    //   1170: if_icmplt +711 -> 1881
    //   1173: aload_1
    //   1174: aload_0
    //   1175: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1178: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1181: ldc_w 611
    //   1184: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1187: putfield 614	com/tencent/mm/protocal/protobuf/adi:wWu	Z
    //   1190: aload_1
    //   1191: aload_0
    //   1192: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1195: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1198: ldc_w 606
    //   1201: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1204: putfield 617	com/tencent/mm/protocal/protobuf/adi:wWk	Z
    //   1207: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   1210: bipush 23
    //   1212: if_icmplt +677 -> 1889
    //   1215: aload_1
    //   1216: aload_0
    //   1217: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1220: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1223: ldc_w 619
    //   1226: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1229: putfield 622	com/tencent/mm/protocal/protobuf/adi:wWl	Z
    //   1232: aload_1
    //   1233: aload_0
    //   1234: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1237: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1240: ldc_w 624
    //   1243: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1246: putfield 627	com/tencent/mm/protocal/protobuf/adi:wWm	Z
    //   1249: aload_1
    //   1250: aload_0
    //   1251: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1254: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1257: ldc_w 629
    //   1260: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1263: putfield 632	com/tencent/mm/protocal/protobuf/adi:wWn	Z
    //   1266: aload_1
    //   1267: aload_0
    //   1268: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1271: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1274: ldc_w 634
    //   1277: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1280: putfield 637	com/tencent/mm/protocal/protobuf/adi:wWo	Z
    //   1283: aload_1
    //   1284: aload_0
    //   1285: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1288: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1291: ldc_w 639
    //   1294: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1297: putfield 642	com/tencent/mm/protocal/protobuf/adi:wWp	Z
    //   1300: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   1303: bipush 19
    //   1305: if_icmplt +610 -> 1915
    //   1308: aload_1
    //   1309: aload_0
    //   1310: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1313: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1316: ldc_w 644
    //   1319: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1322: putfield 647	com/tencent/mm/protocal/protobuf/adi:wWq	Z
    //   1325: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   1328: bipush 19
    //   1330: if_icmplt +593 -> 1923
    //   1333: aload_1
    //   1334: aload_0
    //   1335: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1338: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1341: ldc_w 649
    //   1344: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1347: putfield 652	com/tencent/mm/protocal/protobuf/adi:wWr	Z
    //   1350: aload_1
    //   1351: aload_0
    //   1352: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1355: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1358: ldc_w 654
    //   1361: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1364: putfield 657	com/tencent/mm/protocal/protobuf/adi:wWs	Z
    //   1367: aload_1
    //   1368: aload_0
    //   1369: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1372: invokevirtual 569	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1375: ldc_w 659
    //   1378: invokevirtual 576	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1381: putfield 662	com/tencent/mm/protocal/protobuf/adi:wWt	Z
    //   1384: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1387: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   1390: aload_1
    //   1391: putfield 666	com/tencent/mm/protocal/protobuf/auq:xjI	Lcom/tencent/mm/protocal/protobuf/adi;
    //   1394: ldc 55
    //   1396: ldc_w 668
    //   1399: bipush 18
    //   1401: anewarray 5	java/lang/Object
    //   1404: dup
    //   1405: iconst_0
    //   1406: aload_1
    //   1407: getfield 579	com/tencent/mm/protocal/protobuf/adi:wWd	Z
    //   1410: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1413: aastore
    //   1414: dup
    //   1415: iconst_1
    //   1416: aload_1
    //   1417: getfield 584	com/tencent/mm/protocal/protobuf/adi:wWe	Z
    //   1420: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1423: aastore
    //   1424: dup
    //   1425: iconst_2
    //   1426: aload_1
    //   1427: getfield 589	com/tencent/mm/protocal/protobuf/adi:wWf	Z
    //   1430: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1433: aastore
    //   1434: dup
    //   1435: iconst_3
    //   1436: aload_1
    //   1437: getfield 594	com/tencent/mm/protocal/protobuf/adi:wWg	Z
    //   1440: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1443: aastore
    //   1444: dup
    //   1445: iconst_4
    //   1446: aload_1
    //   1447: getfield 599	com/tencent/mm/protocal/protobuf/adi:wWh	Z
    //   1450: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_5
    //   1456: aload_1
    //   1457: getfield 604	com/tencent/mm/protocal/protobuf/adi:wWi	Z
    //   1460: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1463: aastore
    //   1464: dup
    //   1465: bipush 6
    //   1467: aload_1
    //   1468: getfield 609	com/tencent/mm/protocal/protobuf/adi:wWj	Z
    //   1471: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1474: aastore
    //   1475: dup
    //   1476: bipush 7
    //   1478: aload_1
    //   1479: getfield 614	com/tencent/mm/protocal/protobuf/adi:wWu	Z
    //   1482: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1485: aastore
    //   1486: dup
    //   1487: bipush 8
    //   1489: aload_1
    //   1490: getfield 617	com/tencent/mm/protocal/protobuf/adi:wWk	Z
    //   1493: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1496: aastore
    //   1497: dup
    //   1498: bipush 9
    //   1500: aload_1
    //   1501: getfield 622	com/tencent/mm/protocal/protobuf/adi:wWl	Z
    //   1504: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1507: aastore
    //   1508: dup
    //   1509: bipush 10
    //   1511: aload_1
    //   1512: getfield 627	com/tencent/mm/protocal/protobuf/adi:wWm	Z
    //   1515: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1518: aastore
    //   1519: dup
    //   1520: bipush 11
    //   1522: aload_1
    //   1523: getfield 632	com/tencent/mm/protocal/protobuf/adi:wWn	Z
    //   1526: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1529: aastore
    //   1530: dup
    //   1531: bipush 12
    //   1533: aload_1
    //   1534: getfield 637	com/tencent/mm/protocal/protobuf/adi:wWo	Z
    //   1537: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1540: aastore
    //   1541: dup
    //   1542: bipush 13
    //   1544: aload_1
    //   1545: getfield 642	com/tencent/mm/protocal/protobuf/adi:wWp	Z
    //   1548: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1551: aastore
    //   1552: dup
    //   1553: bipush 14
    //   1555: aload_1
    //   1556: getfield 647	com/tencent/mm/protocal/protobuf/adi:wWq	Z
    //   1559: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1562: aastore
    //   1563: dup
    //   1564: bipush 15
    //   1566: aload_1
    //   1567: getfield 652	com/tencent/mm/protocal/protobuf/adi:wWr	Z
    //   1570: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1573: aastore
    //   1574: dup
    //   1575: bipush 16
    //   1577: aload_1
    //   1578: getfield 657	com/tencent/mm/protocal/protobuf/adi:wWs	Z
    //   1581: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1584: aastore
    //   1585: dup
    //   1586: bipush 17
    //   1588: aload_1
    //   1589: getfield 662	com/tencent/mm/protocal/protobuf/adi:wWt	Z
    //   1592: invokestatic 426	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1595: aastore
    //   1596: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1599: ldc 55
    //   1601: ldc_w 670
    //   1604: iconst_1
    //   1605: anewarray 5	java/lang/Object
    //   1608: dup
    //   1609: iconst_0
    //   1610: invokestatic 182	java/lang/System:nanoTime	()J
    //   1613: lload 4
    //   1615: lsub
    //   1616: ldc2_w 671
    //   1619: ldiv
    //   1620: ldc2_w 671
    //   1623: ldiv
    //   1624: invokestatic 677	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1627: aastore
    //   1628: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1631: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1634: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   1637: astore_1
    //   1638: aload_1
    //   1639: ifnull +61 -> 1700
    //   1642: aload_1
    //   1643: getfield 321	com/tencent/mm/protocal/protobuf/auq:xjD	Lcom/tencent/mm/protocal/protobuf/nv;
    //   1646: ifnull +25 -> 1671
    //   1649: invokestatic 681	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   1652: invokevirtual 687	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   1655: getstatic 693	com/tencent/mm/storage/ac$a:yJx	Lcom/tencent/mm/storage/ac$a;
    //   1658: aload_1
    //   1659: getfield 321	com/tencent/mm/protocal/protobuf/auq:xjD	Lcom/tencent/mm/protocal/protobuf/nv;
    //   1662: getfield 314	com/tencent/mm/protocal/protobuf/nv:wDu	I
    //   1665: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1668: invokevirtual 699	com/tencent/mm/storage/z:set	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1671: aload_1
    //   1672: getfield 380	com/tencent/mm/protocal/protobuf/auq:xjE	Lcom/tencent/mm/protocal/protobuf/bcy;
    //   1675: ifnull +25 -> 1700
    //   1678: invokestatic 681	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   1681: invokevirtual 687	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   1684: getstatic 702	com/tencent/mm/storage/ac$a:yJy	Lcom/tencent/mm/storage/ac$a;
    //   1687: aload_1
    //   1688: getfield 380	com/tencent/mm/protocal/protobuf/auq:xjE	Lcom/tencent/mm/protocal/protobuf/bcy;
    //   1691: getfield 358	com/tencent/mm/protocal/protobuf/bcy:xsW	I
    //   1694: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1697: invokevirtual 699	com/tencent/mm/storage/z:set	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1700: invokestatic 247	com/tencent/mm/plugin/hardwareopt/b/a:bHP	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1703: invokevirtual 251	com/tencent/mm/plugin/hardwareopt/b/a:bHQ	()Lcom/tencent/mm/protocal/protobuf/auq;
    //   1706: astore_1
    //   1707: ldc 176
    //   1709: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1712: aload_1
    //   1713: areturn
    //   1714: astore_1
    //   1715: ldc 55
    //   1717: aload_1
    //   1718: ldc_w 704
    //   1721: iconst_0
    //   1722: anewarray 5	java/lang/Object
    //   1725: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1728: goto -1440 -> 288
    //   1731: astore 8
    //   1733: aconst_null
    //   1734: astore 7
    //   1736: aload 7
    //   1738: astore_1
    //   1739: ldc 55
    //   1741: aload 8
    //   1743: ldc_w 706
    //   1746: iconst_0
    //   1747: anewarray 5	java/lang/Object
    //   1750: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1753: aload 7
    //   1755: ifnull -1467 -> 288
    //   1758: aload 7
    //   1760: invokevirtual 317	java/io/RandomAccessFile:close	()V
    //   1763: goto -1475 -> 288
    //   1766: astore_1
    //   1767: ldc 55
    //   1769: aload_1
    //   1770: ldc_w 704
    //   1773: iconst_0
    //   1774: anewarray 5	java/lang/Object
    //   1777: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1780: goto -1492 -> 288
    //   1783: astore 7
    //   1785: aconst_null
    //   1786: astore_1
    //   1787: aload_1
    //   1788: ifnull +7 -> 1795
    //   1791: aload_1
    //   1792: invokevirtual 317	java/io/RandomAccessFile:close	()V
    //   1795: ldc 176
    //   1797: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1800: aload 7
    //   1802: athrow
    //   1803: astore_1
    //   1804: ldc 55
    //   1806: aload_1
    //   1807: ldc_w 704
    //   1810: iconst_0
    //   1811: anewarray 5	java/lang/Object
    //   1814: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1817: goto -22 -> 1795
    //   1820: aload 7
    //   1822: aload_1
    //   1823: invokevirtual 709	android/os/StatFs:getBlockSize	()I
    //   1826: i2l
    //   1827: aload_1
    //   1828: invokevirtual 712	android/os/StatFs:getAvailableBlocks	()I
    //   1831: i2l
    //   1832: lmul
    //   1833: ldc2_w 354
    //   1836: ldiv
    //   1837: ldc2_w 354
    //   1840: ldiv
    //   1841: l2i
    //   1842: putfield 401	com/tencent/mm/protocal/protobuf/cgq:xRu	I
    //   1845: goto -1262 -> 583
    //   1848: astore 8
    //   1850: ldc 55
    //   1852: aload 8
    //   1854: ldc_w 714
    //   1857: iconst_0
    //   1858: anewarray 5	java/lang/Object
    //   1861: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1864: aload 7
    //   1866: iconst_0
    //   1867: putfield 457	com/tencent/mm/protocal/protobuf/ael:wXq	Z
    //   1870: goto -1149 -> 721
    //   1873: aload_1
    //   1874: iconst_0
    //   1875: putfield 584	com/tencent/mm/protocal/protobuf/adi:wWe	Z
    //   1878: goto -798 -> 1080
    //   1881: aload_1
    //   1882: iconst_0
    //   1883: putfield 614	com/tencent/mm/protocal/protobuf/adi:wWu	Z
    //   1886: goto -696 -> 1190
    //   1889: getstatic 720	com/tencent/mm/compatible/e/ac:ery	Lcom/tencent/mm/compatible/e/t;
    //   1892: getfield 725	com/tencent/mm/compatible/e/t:eqB	I
    //   1895: iconst_1
    //   1896: if_icmpne +11 -> 1907
    //   1899: aload_1
    //   1900: iconst_1
    //   1901: putfield 622	com/tencent/mm/protocal/protobuf/adi:wWl	Z
    //   1904: goto -672 -> 1232
    //   1907: aload_1
    //   1908: iconst_0
    //   1909: putfield 622	com/tencent/mm/protocal/protobuf/adi:wWl	Z
    //   1912: goto -680 -> 1232
    //   1915: aload_1
    //   1916: iconst_0
    //   1917: putfield 647	com/tencent/mm/protocal/protobuf/adi:wWq	Z
    //   1920: goto -595 -> 1325
    //   1923: aload_1
    //   1924: iconst_0
    //   1925: putfield 652	com/tencent/mm/protocal/protobuf/adi:wWr	Z
    //   1928: goto -578 -> 1350
    //   1931: astore_1
    //   1932: ldc 55
    //   1934: aload_1
    //   1935: ldc_w 727
    //   1938: iconst_0
    //   1939: anewarray 5	java/lang/Object
    //   1942: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1945: goto -245 -> 1700
    //   1948: astore 7
    //   1950: goto -163 -> 1787
    //   1953: astore 8
    //   1955: goto -219 -> 1736
    //   1958: iconst_0
    //   1959: istore 6
    //   1961: goto -1280 -> 681
    //   1964: iconst_0
    //   1965: istore 6
    //   1967: goto -1266 -> 701
    //   1970: iconst_0
    //   1971: istore_2
    //   1972: goto -971 -> 1001
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1975	0	this	a
    //   0	1975	1	paramContext	Context
    //   826	1146	2	i	int
    //   832	31	3	j	int
    //   13	1601	4	l	long
    //   679	1287	6	bool	boolean
    //   260	1499	7	localObject1	Object
    //   1783	82	7	localObject2	Object
    //   1948	1	7	localObject3	Object
    //   984	34	8	str	String
    //   1731	11	8	localIOException1	java.io.IOException
    //   1848	5	8	localThrowable	java.lang.Throwable
    //   1953	1	8	localIOException2	java.io.IOException
    //   176	170	9	localnv	com.tencent.mm.protocal.protobuf.nv
    // Exception table:
    //   from	to	target	type
    //   15	63	63	java/lang/Exception
    //   98	247	63	java/lang/Exception
    //   283	288	63	java/lang/Exception
    //   288	583	63	java/lang/Exception
    //   583	678	63	java/lang/Exception
    //   681	698	63	java/lang/Exception
    //   701	708	63	java/lang/Exception
    //   708	721	63	java/lang/Exception
    //   721	1001	63	java/lang/Exception
    //   1001	1080	63	java/lang/Exception
    //   1080	1190	63	java/lang/Exception
    //   1190	1232	63	java/lang/Exception
    //   1232	1325	63	java/lang/Exception
    //   1325	1350	63	java/lang/Exception
    //   1350	1631	63	java/lang/Exception
    //   1700	1707	63	java/lang/Exception
    //   1715	1728	63	java/lang/Exception
    //   1758	1763	63	java/lang/Exception
    //   1767	1780	63	java/lang/Exception
    //   1791	1795	63	java/lang/Exception
    //   1795	1803	63	java/lang/Exception
    //   1804	1817	63	java/lang/Exception
    //   1820	1845	63	java/lang/Exception
    //   1850	1870	63	java/lang/Exception
    //   1873	1878	63	java/lang/Exception
    //   1881	1886	63	java/lang/Exception
    //   1889	1904	63	java/lang/Exception
    //   1907	1912	63	java/lang/Exception
    //   1915	1920	63	java/lang/Exception
    //   1923	1928	63	java/lang/Exception
    //   1932	1945	63	java/lang/Exception
    //   283	288	1714	java/io/IOException
    //   247	262	1731	java/io/IOException
    //   1758	1763	1766	java/io/IOException
    //   247	262	1783	finally
    //   1791	1795	1803	java/io/IOException
    //   708	721	1848	java/lang/Throwable
    //   1631	1638	1931	java/lang/Exception
    //   1642	1671	1931	java/lang/Exception
    //   1671	1700	1931	java/lang/Exception
    //   265	283	1948	finally
    //   1739	1753	1948	finally
    //   265	283	1953	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.a
 * JD-Core Version:    0.7.0.1
 */