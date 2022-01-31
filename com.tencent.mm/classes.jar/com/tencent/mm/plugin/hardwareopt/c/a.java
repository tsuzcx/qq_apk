package com.tencent.mm.plugin.hardwareopt.c;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements com.tencent.mm.vending.c.a<aoy, Context>
{
  private Context mContext = null;
  
  private static String Fn(String paramString)
  {
    Object localObject2 = null;
    String str2 = null;
    str1 = str2;
    localObject1 = localObject2;
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label53;
      }
      str1 = str2;
      localObject1 = localObject2;
      paramString = MediaCodec.createEncoderByType(paramString);
      str1 = paramString;
      localObject1 = paramString;
      str2 = paramString.getName();
      str1 = str2;
      localObject1 = str1;
      if (paramString != null)
      {
        paramString.release();
        localObject1 = str1;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject1 = str1;
        y.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", paramString, "hy: error in handle media codec", new Object[0]);
        localObject1 = "undefined";
      } while (str1 == null);
      str1.release();
      return "undefined";
    }
    finally
    {
      if (localObject1 == null) {
        break label94;
      }
      ((MediaCodec)localObject1).release();
    }
    return localObject1;
    label53:
    return "too low version";
  }
  
  private static LinkedList<awp> baQ()
  {
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
    y.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[] { localObject3 });
    Object localObject1 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new awp();
      ((awp)localObject3).jkV = ((String)((Map.Entry)localObject2).getKey());
      localObject4 = new LinkedList();
      if (((Map.Entry)localObject2).getValue() != null) {
        ((LinkedList)localObject4).addAll((Collection)((Map.Entry)localObject2).getValue());
      }
      ((awp)localObject3).tth = ((LinkedList)localObject4);
      localLinkedList.add(localObject3);
    }
    return localLinkedList;
  }
  
  /* Error */
  private aoy dD(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   5: invokestatic 171	java/lang/System:nanoTime	()J
    //   8: lstore 4
    //   10: new 173	com/tencent/mm/protocal/c/gb
    //   13: dup
    //   14: invokespecial 174	com/tencent/mm/protocal/c/gb:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   23: invokestatic 180	com/tencent/mm/sdk/platformtools/bk:fP	(Landroid/content/Context;)Ljava/lang/String;
    //   26: putfield 183	com/tencent/mm/protocal/c/gb:imei	Ljava/lang/String;
    //   29: aload_1
    //   30: getfield 183	com/tencent/mm/protocal/c/gb:imei	Ljava/lang/String;
    //   33: invokestatic 187	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   36: ifeq +48 -> 84
    //   39: ldc 45
    //   41: ldc 189
    //   43: invokestatic 193	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 9	com/tencent/mm/plugin/hardwareopt/c/a$a
    //   49: dup
    //   50: invokespecial 194	com/tencent/mm/plugin/hardwareopt/c/a$a:<init>	()V
    //   53: athrow
    //   54: astore_1
    //   55: ldc 45
    //   57: aload_1
    //   58: ldc 196
    //   60: iconst_0
    //   61: anewarray 5	java/lang/Object
    //   64: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: invokestatic 202	com/tencent/mm/vending/g/f:cLc	()Lcom/tencent/mm/vending/g/b;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +10 -> 82
    //   75: aload_1
    //   76: aconst_null
    //   77: invokeinterface 208 2 0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_1
    //   85: getstatic 213	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   88: putfield 216	com/tencent/mm/protocal/c/gb:sAg	Ljava/lang/String;
    //   91: aload_1
    //   92: getstatic 219	android/os/Build:MODEL	Ljava/lang/String;
    //   95: putfield 222	com/tencent/mm/protocal/c/gb:sAh	Ljava/lang/String;
    //   98: aload_1
    //   99: getstatic 225	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   102: putfield 228	com/tencent/mm/protocal/c/gb:sAi	Ljava/lang/String;
    //   105: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   108: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   111: aload_1
    //   112: putfield 244	com/tencent/mm/protocal/c/aoy:tkL	Lcom/tencent/mm/protocal/c/gb;
    //   115: ldc 45
    //   117: ldc 246
    //   119: iconst_4
    //   120: anewarray 5	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: getfield 183	com/tencent/mm/protocal/c/gb:imei	Ljava/lang/String;
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_1
    //   133: getfield 216	com/tencent/mm/protocal/c/gb:sAg	Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_2
    //   139: aload_1
    //   140: getfield 222	com/tencent/mm/protocal/c/gb:sAh	Ljava/lang/String;
    //   143: aastore
    //   144: dup
    //   145: iconst_3
    //   146: aload_1
    //   147: getfield 228	com/tencent/mm/protocal/c/gb:sAi	Ljava/lang/String;
    //   150: aastore
    //   151: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: new 251	com/tencent/mm/protocal/c/lh
    //   157: dup
    //   158: invokespecial 252	com/tencent/mm/protocal/c/lh:<init>	()V
    //   161: astore 9
    //   163: aload 9
    //   165: getstatic 255	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   168: putfield 258	com/tencent/mm/protocal/c/lh:sGX	Ljava/lang/String;
    //   171: invokestatic 264	com/tencent/mm/compatible/e/n:yV	()Ljava/util/Map;
    //   174: astore_1
    //   175: aload 9
    //   177: aload_1
    //   178: ldc_w 266
    //   181: invokeinterface 94 2 0
    //   186: checkcast 85	java/lang/String
    //   189: ldc_w 268
    //   192: invokestatic 272	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   195: putfield 275	com/tencent/mm/protocal/c/lh:sGV	Ljava/lang/String;
    //   198: aload 9
    //   200: aload_1
    //   201: ldc_w 277
    //   204: invokeinterface 94 2 0
    //   209: checkcast 85	java/lang/String
    //   212: putfield 278	com/tencent/mm/protocal/c/lh:sAh	Ljava/lang/String;
    //   215: aload 9
    //   217: aload_1
    //   218: ldc_w 280
    //   221: invokeinterface 94 2 0
    //   226: checkcast 85	java/lang/String
    //   229: putfield 283	com/tencent/mm/protocal/c/lh:sGY	Ljava/lang/String;
    //   232: new 285	java/io/RandomAccessFile
    //   235: dup
    //   236: ldc_w 287
    //   239: ldc_w 289
    //   242: invokespecial 291	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: astore 7
    //   247: aload 7
    //   249: astore_1
    //   250: aload 9
    //   252: aload 7
    //   254: invokevirtual 294	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   257: iconst_m1
    //   258: invokestatic 298	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   261: sipush 1000
    //   264: idiv
    //   265: putfield 301	com/tencent/mm/protocal/c/lh:sGW	I
    //   268: aload 7
    //   270: invokevirtual 304	java/io/RandomAccessFile:close	()V
    //   273: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   276: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   279: aload 9
    //   281: putfield 308	com/tencent/mm/protocal/c/aoy:tkM	Lcom/tencent/mm/protocal/c/lh;
    //   284: ldc 45
    //   286: ldc_w 310
    //   289: iconst_5
    //   290: anewarray 5	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload 9
    //   297: getfield 258	com/tencent/mm/protocal/c/lh:sGX	Ljava/lang/String;
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aload 9
    //   305: getfield 275	com/tencent/mm/protocal/c/lh:sGV	Ljava/lang/String;
    //   308: aastore
    //   309: dup
    //   310: iconst_2
    //   311: aload 9
    //   313: getfield 301	com/tencent/mm/protocal/c/lh:sGW	I
    //   316: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: aastore
    //   320: dup
    //   321: iconst_3
    //   322: aload 9
    //   324: getfield 278	com/tencent/mm/protocal/c/lh:sAh	Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: iconst_4
    //   330: aload 9
    //   332: getfield 283	com/tencent/mm/protocal/c/lh:sGY	Ljava/lang/String;
    //   335: aastore
    //   336: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: aload_0
    //   340: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   343: ldc_w 318
    //   346: invokevirtual 324	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   349: checkcast 326	android/app/ActivityManager
    //   352: astore 7
    //   354: new 328	android/app/ActivityManager$MemoryInfo
    //   357: dup
    //   358: invokespecial 329	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   361: astore_1
    //   362: aload 7
    //   364: aload_1
    //   365: invokevirtual 333	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   368: new 335	com/tencent/mm/protocal/c/awj
    //   371: dup
    //   372: invokespecial 336	com/tencent/mm/protocal/c/awj:<init>	()V
    //   375: astore 7
    //   377: aload 7
    //   379: aload_1
    //   380: getfield 340	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   383: ldc2_w 341
    //   386: ldiv
    //   387: ldc2_w 341
    //   390: ldiv
    //   391: l2i
    //   392: putfield 345	com/tencent/mm/protocal/c/awj:tsV	I
    //   395: aload 7
    //   397: aload_1
    //   398: getfield 348	android/app/ActivityManager$MemoryInfo:threshold	J
    //   401: ldc2_w 341
    //   404: ldiv
    //   405: ldc2_w 341
    //   408: ldiv
    //   409: l2i
    //   410: putfield 351	com/tencent/mm/protocal/c/awj:tsW	I
    //   413: aload 7
    //   415: aload_0
    //   416: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   419: ldc_w 318
    //   422: invokevirtual 324	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   425: checkcast 326	android/app/ActivityManager
    //   428: invokevirtual 354	android/app/ActivityManager:getLargeMemoryClass	()I
    //   431: putfield 357	com/tencent/mm/protocal/c/awj:tsX	I
    //   434: aload 7
    //   436: aload_0
    //   437: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   440: ldc_w 318
    //   443: invokevirtual 324	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   446: checkcast 326	android/app/ActivityManager
    //   449: invokevirtual 360	android/app/ActivityManager:getMemoryClass	()I
    //   452: putfield 363	com/tencent/mm/protocal/c/awj:tsY	I
    //   455: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   458: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   461: aload 7
    //   463: putfield 367	com/tencent/mm/protocal/c/aoy:tkN	Lcom/tencent/mm/protocal/c/awj;
    //   466: ldc 45
    //   468: ldc_w 369
    //   471: iconst_4
    //   472: anewarray 5	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: aload 7
    //   479: getfield 345	com/tencent/mm/protocal/c/awj:tsV	I
    //   482: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload 7
    //   490: getfield 351	com/tencent/mm/protocal/c/awj:tsW	I
    //   493: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: dup
    //   498: iconst_2
    //   499: aload 7
    //   501: getfield 357	com/tencent/mm/protocal/c/awj:tsX	I
    //   504: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: dup
    //   509: iconst_3
    //   510: aload 7
    //   512: getfield 363	com/tencent/mm/protocal/c/awj:tsY	I
    //   515: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: new 371	android/os/StatFs
    //   525: dup
    //   526: getstatic 376	com/tencent/mm/compatible/util/e:bkF	Ljava/lang/String;
    //   529: invokespecial 379	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   532: astore_1
    //   533: new 381	com/tencent/mm/protocal/c/bvx
    //   536: dup
    //   537: invokespecial 382	com/tencent/mm/protocal/c/bvx:<init>	()V
    //   540: astore 7
    //   542: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   545: bipush 18
    //   547: if_icmplt +1252 -> 1799
    //   550: aload 7
    //   552: aload_1
    //   553: invokevirtual 385	android/os/StatFs:getTotalBytes	()J
    //   556: ldc2_w 341
    //   559: ldiv
    //   560: ldc2_w 341
    //   563: ldiv
    //   564: l2i
    //   565: putfield 388	com/tencent/mm/protocal/c/bvx:tMI	I
    //   568: aload 7
    //   570: invokestatic 393	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   573: ldc_w 395
    //   576: invokevirtual 398	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   579: putfield 402	com/tencent/mm/protocal/c/bvx:tMJ	Z
    //   582: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   585: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   588: aload 7
    //   590: putfield 406	com/tencent/mm/protocal/c/aoy:tkO	Lcom/tencent/mm/protocal/c/bvx;
    //   593: ldc 45
    //   595: ldc_w 408
    //   598: iconst_2
    //   599: anewarray 5	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload 7
    //   606: getfield 388	com/tencent/mm/protocal/c/bvx:tMI	I
    //   609: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload 7
    //   617: getfield 402	com/tencent/mm/protocal/c/bvx:tMJ	Z
    //   620: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   623: aastore
    //   624: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   627: aload_0
    //   628: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   631: ldc_w 318
    //   634: invokevirtual 324	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   637: checkcast 326	android/app/ActivityManager
    //   640: invokevirtual 417	android/app/ActivityManager:getDeviceConfigurationInfo	()Landroid/content/pm/ConfigurationInfo;
    //   643: astore_1
    //   644: new 419	com/tencent/mm/protocal/c/zs
    //   647: dup
    //   648: invokespecial 420	com/tencent/mm/protocal/c/zs:<init>	()V
    //   651: astore 7
    //   653: aload_1
    //   654: getfield 425	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   657: ldc_w 426
    //   660: if_icmplt +1277 -> 1937
    //   663: iconst_1
    //   664: istore 6
    //   666: aload 7
    //   668: iload 6
    //   670: putfield 429	com/tencent/mm/protocal/c/zs:sYT	Z
    //   673: aload_1
    //   674: getfield 425	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   677: ldc_w 430
    //   680: if_icmplt +1263 -> 1943
    //   683: iconst_1
    //   684: istore 6
    //   686: aload 7
    //   688: iload 6
    //   690: putfield 433	com/tencent/mm/protocal/c/zs:sYU	Z
    //   693: aload 7
    //   695: ldc_w 435
    //   698: invokestatic 440	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   701: checkcast 435	com/tencent/mm/plugin/appbrand/r/b
    //   704: invokeinterface 443 1 0
    //   709: putfield 446	com/tencent/mm/protocal/c/zs:sYV	Z
    //   712: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   715: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   718: aload 7
    //   720: putfield 450	com/tencent/mm/protocal/c/aoy:tkS	Lcom/tencent/mm/protocal/c/zs;
    //   723: ldc 45
    //   725: ldc_w 452
    //   728: iconst_4
    //   729: anewarray 5	java/lang/Object
    //   732: dup
    //   733: iconst_0
    //   734: aload 7
    //   736: getfield 429	com/tencent/mm/protocal/c/zs:sYT	Z
    //   739: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   742: aastore
    //   743: dup
    //   744: iconst_1
    //   745: aload 7
    //   747: getfield 433	com/tencent/mm/protocal/c/zs:sYU	Z
    //   750: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   753: aastore
    //   754: dup
    //   755: iconst_2
    //   756: aload_1
    //   757: getfield 425	android/content/pm/ConfigurationInfo:reqGlEsVersion	I
    //   760: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: aastore
    //   764: dup
    //   765: iconst_3
    //   766: aload 7
    //   768: getfield 446	com/tencent/mm/protocal/c/zs:sYV	Z
    //   771: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   774: aastore
    //   775: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: aload_0
    //   779: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   782: ldc_w 454
    //   785: invokevirtual 324	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   788: checkcast 456	android/view/WindowManager
    //   791: invokeinterface 460 1 0
    //   796: astore_1
    //   797: new 462	android/graphics/Point
    //   800: dup
    //   801: invokespecial 463	android/graphics/Point:<init>	()V
    //   804: astore 7
    //   806: aload_1
    //   807: aload 7
    //   809: invokevirtual 469	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   812: aload 7
    //   814: getfield 472	android/graphics/Point:x	I
    //   817: istore_2
    //   818: aload 7
    //   820: getfield 475	android/graphics/Point:y	I
    //   823: istore_3
    //   824: new 477	com/tencent/mm/protocal/c/bnb
    //   827: dup
    //   828: invokespecial 478	com/tencent/mm/protocal/c/bnb:<init>	()V
    //   831: astore_1
    //   832: aload_1
    //   833: new 480	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   840: iload_2
    //   841: invokestatic 484	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   844: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: ldc_w 489
    //   850: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: iload_3
    //   854: invokevirtual 492	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   857: invokevirtual 495	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: putfield 498	com/tencent/mm/protocal/c/bnb:tGg	Ljava/lang/String;
    //   863: aload_1
    //   864: aload_0
    //   865: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   868: invokevirtual 502	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   871: invokevirtual 508	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   874: getfield 514	android/util/DisplayMetrics:density	F
    //   877: f2i
    //   878: putfield 516	com/tencent/mm/protocal/c/bnb:density	I
    //   881: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   884: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   887: aload_1
    //   888: putfield 520	com/tencent/mm/protocal/c/aoy:tkP	Lcom/tencent/mm/protocal/c/bnb;
    //   891: ldc 45
    //   893: ldc_w 522
    //   896: iconst_2
    //   897: anewarray 5	java/lang/Object
    //   900: dup
    //   901: iconst_0
    //   902: aload_1
    //   903: getfield 498	com/tencent/mm/protocal/c/bnb:tGg	Ljava/lang/String;
    //   906: aastore
    //   907: dup
    //   908: iconst_1
    //   909: aload_1
    //   910: getfield 516	com/tencent/mm/protocal/c/bnb:density	I
    //   913: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   916: aastore
    //   917: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   920: new 524	com/tencent/mm/protocal/c/qx
    //   923: dup
    //   924: invokespecial 525	com/tencent/mm/protocal/c/qx:<init>	()V
    //   927: astore_1
    //   928: aload_1
    //   929: ldc_w 527
    //   932: invokestatic 529	com/tencent/mm/plugin/hardwareopt/c/a:Fn	(Ljava/lang/String;)Ljava/lang/String;
    //   935: putfield 532	com/tencent/mm/protocal/c/qx:sOC	Ljava/lang/String;
    //   938: aload_1
    //   939: ldc_w 534
    //   942: invokestatic 529	com/tencent/mm/plugin/hardwareopt/c/a:Fn	(Ljava/lang/String;)Ljava/lang/String;
    //   945: putfield 537	com/tencent/mm/protocal/c/qx:sOD	Ljava/lang/String;
    //   948: aload_1
    //   949: invokestatic 539	com/tencent/mm/plugin/hardwareopt/c/a:baQ	()Ljava/util/LinkedList;
    //   952: putfield 542	com/tencent/mm/protocal/c/qx:sOE	Ljava/util/LinkedList;
    //   955: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   958: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   961: aload_1
    //   962: putfield 546	com/tencent/mm/protocal/c/aoy:tkQ	Lcom/tencent/mm/protocal/c/qx;
    //   965: aload_1
    //   966: getfield 532	com/tencent/mm/protocal/c/qx:sOC	Ljava/lang/String;
    //   969: astore 7
    //   971: aload_1
    //   972: getfield 537	com/tencent/mm/protocal/c/qx:sOD	Ljava/lang/String;
    //   975: astore 8
    //   977: aload_1
    //   978: getfield 542	com/tencent/mm/protocal/c/qx:sOE	Ljava/util/LinkedList;
    //   981: ifnull +968 -> 1949
    //   984: aload_1
    //   985: getfield 542	com/tencent/mm/protocal/c/qx:sOE	Ljava/util/LinkedList;
    //   988: invokevirtual 549	java/util/LinkedList:size	()I
    //   991: istore_2
    //   992: ldc 45
    //   994: ldc_w 551
    //   997: iconst_3
    //   998: anewarray 5	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 7
    //   1005: aastore
    //   1006: dup
    //   1007: iconst_1
    //   1008: aload 8
    //   1010: aastore
    //   1011: dup
    //   1012: iconst_2
    //   1013: iload_2
    //   1014: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1017: aastore
    //   1018: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1021: new 553	com/tencent/mm/protocal/c/zb
    //   1024: dup
    //   1025: invokespecial 554	com/tencent/mm/protocal/c/zb:<init>	()V
    //   1028: astore_1
    //   1029: aload_1
    //   1030: aload_0
    //   1031: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1034: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1037: ldc_w 560
    //   1040: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1043: putfield 568	com/tencent/mm/protocal/c/zb:sYe	Z
    //   1046: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   1049: bipush 18
    //   1051: if_icmplt +801 -> 1852
    //   1054: aload_1
    //   1055: aload_0
    //   1056: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1059: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1062: ldc_w 570
    //   1065: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1068: putfield 573	com/tencent/mm/protocal/c/zb:sYf	Z
    //   1071: aload_1
    //   1072: aload_0
    //   1073: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1076: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1079: ldc_w 575
    //   1082: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1085: putfield 578	com/tencent/mm/protocal/c/zb:sYg	Z
    //   1088: aload_1
    //   1089: aload_0
    //   1090: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1093: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1096: ldc_w 580
    //   1099: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1102: putfield 583	com/tencent/mm/protocal/c/zb:sYh	Z
    //   1105: aload_1
    //   1106: aload_0
    //   1107: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1110: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1113: ldc_w 585
    //   1116: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1119: putfield 588	com/tencent/mm/protocal/c/zb:sYi	Z
    //   1122: aload_1
    //   1123: aload_0
    //   1124: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1127: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1130: ldc_w 590
    //   1133: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1136: putfield 593	com/tencent/mm/protocal/c/zb:sYj	Z
    //   1139: aload_1
    //   1140: aload_0
    //   1141: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1144: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1147: ldc_w 595
    //   1150: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1153: putfield 598	com/tencent/mm/protocal/c/zb:sYk	Z
    //   1156: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   1159: bipush 19
    //   1161: if_icmplt +699 -> 1860
    //   1164: aload_1
    //   1165: aload_0
    //   1166: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1169: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1172: ldc_w 600
    //   1175: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1178: putfield 603	com/tencent/mm/protocal/c/zb:sYv	Z
    //   1181: aload_1
    //   1182: aload_0
    //   1183: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1186: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1189: ldc_w 595
    //   1192: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1195: putfield 606	com/tencent/mm/protocal/c/zb:sYl	Z
    //   1198: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   1201: bipush 23
    //   1203: if_icmplt +665 -> 1868
    //   1206: aload_1
    //   1207: aload_0
    //   1208: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1211: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1214: ldc_w 608
    //   1217: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1220: putfield 611	com/tencent/mm/protocal/c/zb:sYm	Z
    //   1223: aload_1
    //   1224: aload_0
    //   1225: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1228: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1231: ldc_w 613
    //   1234: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1237: putfield 616	com/tencent/mm/protocal/c/zb:sYn	Z
    //   1240: aload_1
    //   1241: aload_0
    //   1242: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1245: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1248: ldc_w 618
    //   1251: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1254: putfield 621	com/tencent/mm/protocal/c/zb:sYo	Z
    //   1257: aload_1
    //   1258: aload_0
    //   1259: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1262: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1265: ldc_w 623
    //   1268: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1271: putfield 626	com/tencent/mm/protocal/c/zb:sYp	Z
    //   1274: aload_1
    //   1275: aload_0
    //   1276: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1279: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1282: ldc_w 628
    //   1285: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1288: putfield 631	com/tencent/mm/protocal/c/zb:sYq	Z
    //   1291: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   1294: bipush 19
    //   1296: if_icmplt +598 -> 1894
    //   1299: aload_1
    //   1300: aload_0
    //   1301: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1304: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1307: ldc_w 633
    //   1310: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1313: putfield 636	com/tencent/mm/protocal/c/zb:sYr	Z
    //   1316: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   1319: bipush 19
    //   1321: if_icmplt +581 -> 1902
    //   1324: aload_1
    //   1325: aload_0
    //   1326: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1329: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1332: ldc_w 638
    //   1335: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1338: putfield 641	com/tencent/mm/protocal/c/zb:sYs	Z
    //   1341: aload_1
    //   1342: aload_0
    //   1343: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1346: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1349: ldc_w 643
    //   1352: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1355: putfield 646	com/tencent/mm/protocal/c/zb:sYt	Z
    //   1358: aload_1
    //   1359: aload_0
    //   1360: getfield 17	com/tencent/mm/plugin/hardwareopt/c/a:mContext	Landroid/content/Context;
    //   1363: invokevirtual 558	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1366: ldc_w 648
    //   1369: invokevirtual 565	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   1372: putfield 651	com/tencent/mm/protocal/c/zb:sYu	Z
    //   1375: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1378: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   1381: aload_1
    //   1382: putfield 655	com/tencent/mm/protocal/c/aoy:tkR	Lcom/tencent/mm/protocal/c/zb;
    //   1385: ldc 45
    //   1387: ldc_w 657
    //   1390: bipush 18
    //   1392: anewarray 5	java/lang/Object
    //   1395: dup
    //   1396: iconst_0
    //   1397: aload_1
    //   1398: getfield 568	com/tencent/mm/protocal/c/zb:sYe	Z
    //   1401: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1404: aastore
    //   1405: dup
    //   1406: iconst_1
    //   1407: aload_1
    //   1408: getfield 573	com/tencent/mm/protocal/c/zb:sYf	Z
    //   1411: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1414: aastore
    //   1415: dup
    //   1416: iconst_2
    //   1417: aload_1
    //   1418: getfield 578	com/tencent/mm/protocal/c/zb:sYg	Z
    //   1421: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1424: aastore
    //   1425: dup
    //   1426: iconst_3
    //   1427: aload_1
    //   1428: getfield 583	com/tencent/mm/protocal/c/zb:sYh	Z
    //   1431: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1434: aastore
    //   1435: dup
    //   1436: iconst_4
    //   1437: aload_1
    //   1438: getfield 588	com/tencent/mm/protocal/c/zb:sYi	Z
    //   1441: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1444: aastore
    //   1445: dup
    //   1446: iconst_5
    //   1447: aload_1
    //   1448: getfield 593	com/tencent/mm/protocal/c/zb:sYj	Z
    //   1451: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1454: aastore
    //   1455: dup
    //   1456: bipush 6
    //   1458: aload_1
    //   1459: getfield 598	com/tencent/mm/protocal/c/zb:sYk	Z
    //   1462: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1465: aastore
    //   1466: dup
    //   1467: bipush 7
    //   1469: aload_1
    //   1470: getfield 603	com/tencent/mm/protocal/c/zb:sYv	Z
    //   1473: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1476: aastore
    //   1477: dup
    //   1478: bipush 8
    //   1480: aload_1
    //   1481: getfield 606	com/tencent/mm/protocal/c/zb:sYl	Z
    //   1484: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1487: aastore
    //   1488: dup
    //   1489: bipush 9
    //   1491: aload_1
    //   1492: getfield 611	com/tencent/mm/protocal/c/zb:sYm	Z
    //   1495: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1498: aastore
    //   1499: dup
    //   1500: bipush 10
    //   1502: aload_1
    //   1503: getfield 616	com/tencent/mm/protocal/c/zb:sYn	Z
    //   1506: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1509: aastore
    //   1510: dup
    //   1511: bipush 11
    //   1513: aload_1
    //   1514: getfield 621	com/tencent/mm/protocal/c/zb:sYo	Z
    //   1517: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1520: aastore
    //   1521: dup
    //   1522: bipush 12
    //   1524: aload_1
    //   1525: getfield 626	com/tencent/mm/protocal/c/zb:sYp	Z
    //   1528: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1531: aastore
    //   1532: dup
    //   1533: bipush 13
    //   1535: aload_1
    //   1536: getfield 631	com/tencent/mm/protocal/c/zb:sYq	Z
    //   1539: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1542: aastore
    //   1543: dup
    //   1544: bipush 14
    //   1546: aload_1
    //   1547: getfield 636	com/tencent/mm/protocal/c/zb:sYr	Z
    //   1550: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1553: aastore
    //   1554: dup
    //   1555: bipush 15
    //   1557: aload_1
    //   1558: getfield 641	com/tencent/mm/protocal/c/zb:sYs	Z
    //   1561: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1564: aastore
    //   1565: dup
    //   1566: bipush 16
    //   1568: aload_1
    //   1569: getfield 646	com/tencent/mm/protocal/c/zb:sYt	Z
    //   1572: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1575: aastore
    //   1576: dup
    //   1577: bipush 17
    //   1579: aload_1
    //   1580: getfield 651	com/tencent/mm/protocal/c/zb:sYu	Z
    //   1583: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1586: aastore
    //   1587: invokestatic 249	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1590: ldc 45
    //   1592: ldc_w 659
    //   1595: iconst_1
    //   1596: anewarray 5	java/lang/Object
    //   1599: dup
    //   1600: iconst_0
    //   1601: invokestatic 171	java/lang/System:nanoTime	()J
    //   1604: lload 4
    //   1606: lsub
    //   1607: ldc2_w 660
    //   1610: ldiv
    //   1611: ldc2_w 660
    //   1614: ldiv
    //   1615: invokestatic 666	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1618: aastore
    //   1619: invokestatic 114	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1622: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1625: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   1628: astore_1
    //   1629: aload_1
    //   1630: ifnull +61 -> 1691
    //   1633: aload_1
    //   1634: getfield 308	com/tencent/mm/protocal/c/aoy:tkM	Lcom/tencent/mm/protocal/c/lh;
    //   1637: ifnull +25 -> 1662
    //   1640: invokestatic 670	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   1643: invokevirtual 676	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   1646: getstatic 682	com/tencent/mm/storage/ac$a:uyP	Lcom/tencent/mm/storage/ac$a;
    //   1649: aload_1
    //   1650: getfield 308	com/tencent/mm/protocal/c/aoy:tkM	Lcom/tencent/mm/protocal/c/lh;
    //   1653: getfield 301	com/tencent/mm/protocal/c/lh:sGW	I
    //   1656: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1659: invokevirtual 688	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1662: aload_1
    //   1663: getfield 367	com/tencent/mm/protocal/c/aoy:tkN	Lcom/tencent/mm/protocal/c/awj;
    //   1666: ifnull +25 -> 1691
    //   1669: invokestatic 670	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   1672: invokevirtual 676	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   1675: getstatic 691	com/tencent/mm/storage/ac$a:uyQ	Lcom/tencent/mm/storage/ac$a;
    //   1678: aload_1
    //   1679: getfield 367	com/tencent/mm/protocal/c/aoy:tkN	Lcom/tencent/mm/protocal/c/awj;
    //   1682: getfield 345	com/tencent/mm/protocal/c/awj:tsV	I
    //   1685: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1688: invokevirtual 688	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1691: invokestatic 234	com/tencent/mm/plugin/hardwareopt/b/a:baO	()Lcom/tencent/mm/plugin/hardwareopt/b/a;
    //   1694: invokevirtual 238	com/tencent/mm/plugin/hardwareopt/b/a:baP	()Lcom/tencent/mm/protocal/c/aoy;
    //   1697: areturn
    //   1698: astore_1
    //   1699: ldc 45
    //   1701: aload_1
    //   1702: ldc_w 693
    //   1705: iconst_0
    //   1706: anewarray 5	java/lang/Object
    //   1709: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1712: goto -1439 -> 273
    //   1715: astore 8
    //   1717: aconst_null
    //   1718: astore 7
    //   1720: aload 7
    //   1722: astore_1
    //   1723: ldc 45
    //   1725: aload 8
    //   1727: ldc_w 695
    //   1730: iconst_0
    //   1731: anewarray 5	java/lang/Object
    //   1734: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1737: aload 7
    //   1739: ifnull -1466 -> 273
    //   1742: aload 7
    //   1744: invokevirtual 304	java/io/RandomAccessFile:close	()V
    //   1747: goto -1474 -> 273
    //   1750: astore_1
    //   1751: ldc 45
    //   1753: aload_1
    //   1754: ldc_w 693
    //   1757: iconst_0
    //   1758: anewarray 5	java/lang/Object
    //   1761: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1764: goto -1491 -> 273
    //   1767: astore 7
    //   1769: aconst_null
    //   1770: astore_1
    //   1771: aload_1
    //   1772: ifnull +7 -> 1779
    //   1775: aload_1
    //   1776: invokevirtual 304	java/io/RandomAccessFile:close	()V
    //   1779: aload 7
    //   1781: athrow
    //   1782: astore_1
    //   1783: ldc 45
    //   1785: aload_1
    //   1786: ldc_w 693
    //   1789: iconst_0
    //   1790: anewarray 5	java/lang/Object
    //   1793: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1796: goto -17 -> 1779
    //   1799: aload 7
    //   1801: aload_1
    //   1802: invokevirtual 698	android/os/StatFs:getBlockSize	()I
    //   1805: i2l
    //   1806: aload_1
    //   1807: invokevirtual 701	android/os/StatFs:getAvailableBlocks	()I
    //   1810: i2l
    //   1811: lmul
    //   1812: ldc2_w 341
    //   1815: ldiv
    //   1816: ldc2_w 341
    //   1819: ldiv
    //   1820: l2i
    //   1821: putfield 388	com/tencent/mm/protocal/c/bvx:tMI	I
    //   1824: goto -1256 -> 568
    //   1827: astore 8
    //   1829: ldc 45
    //   1831: aload 8
    //   1833: ldc_w 703
    //   1836: iconst_0
    //   1837: anewarray 5	java/lang/Object
    //   1840: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1843: aload 7
    //   1845: iconst_0
    //   1846: putfield 446	com/tencent/mm/protocal/c/zs:sYV	Z
    //   1849: goto -1137 -> 712
    //   1852: aload_1
    //   1853: iconst_0
    //   1854: putfield 573	com/tencent/mm/protocal/c/zb:sYf	Z
    //   1857: goto -786 -> 1071
    //   1860: aload_1
    //   1861: iconst_0
    //   1862: putfield 603	com/tencent/mm/protocal/c/zb:sYv	Z
    //   1865: goto -684 -> 1181
    //   1868: getstatic 709	com/tencent/mm/compatible/e/q:dyh	Lcom/tencent/mm/compatible/e/s;
    //   1871: getfield 714	com/tencent/mm/compatible/e/s:dyq	I
    //   1874: iconst_1
    //   1875: if_icmpne +11 -> 1886
    //   1878: aload_1
    //   1879: iconst_1
    //   1880: putfield 611	com/tencent/mm/protocal/c/zb:sYm	Z
    //   1883: goto -660 -> 1223
    //   1886: aload_1
    //   1887: iconst_0
    //   1888: putfield 611	com/tencent/mm/protocal/c/zb:sYm	Z
    //   1891: goto -668 -> 1223
    //   1894: aload_1
    //   1895: iconst_0
    //   1896: putfield 636	com/tencent/mm/protocal/c/zb:sYr	Z
    //   1899: goto -583 -> 1316
    //   1902: aload_1
    //   1903: iconst_0
    //   1904: putfield 641	com/tencent/mm/protocal/c/zb:sYs	Z
    //   1907: goto -566 -> 1341
    //   1910: astore_1
    //   1911: ldc 45
    //   1913: aload_1
    //   1914: ldc_w 716
    //   1917: iconst_0
    //   1918: anewarray 5	java/lang/Object
    //   1921: invokestatic 53	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1924: goto -233 -> 1691
    //   1927: astore 7
    //   1929: goto -158 -> 1771
    //   1932: astore 8
    //   1934: goto -214 -> 1720
    //   1937: iconst_0
    //   1938: istore 6
    //   1940: goto -1274 -> 666
    //   1943: iconst_0
    //   1944: istore 6
    //   1946: goto -1260 -> 686
    //   1949: iconst_0
    //   1950: istore_2
    //   1951: goto -959 -> 992
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1954	0	this	a
    //   0	1954	1	paramContext	Context
    //   817	1134	2	i	int
    //   823	31	3	j	int
    //   8	1597	4	l	long
    //   664	1281	6	bool	boolean
    //   245	1498	7	localObject1	Object
    //   1767	77	7	localObject2	Object
    //   1927	1	7	localObject3	Object
    //   975	34	8	str	String
    //   1715	11	8	localIOException1	java.io.IOException
    //   1827	5	8	localThrowable	java.lang.Throwable
    //   1932	1	8	localIOException2	java.io.IOException
    //   161	170	9	locallh	com.tencent.mm.protocal.c.lh
    // Exception table:
    //   from	to	target	type
    //   10	54	54	java/lang/Exception
    //   84	232	54	java/lang/Exception
    //   268	273	54	java/lang/Exception
    //   273	568	54	java/lang/Exception
    //   568	663	54	java/lang/Exception
    //   666	683	54	java/lang/Exception
    //   686	693	54	java/lang/Exception
    //   693	712	54	java/lang/Exception
    //   712	992	54	java/lang/Exception
    //   992	1071	54	java/lang/Exception
    //   1071	1181	54	java/lang/Exception
    //   1181	1223	54	java/lang/Exception
    //   1223	1316	54	java/lang/Exception
    //   1316	1341	54	java/lang/Exception
    //   1341	1622	54	java/lang/Exception
    //   1691	1698	54	java/lang/Exception
    //   1699	1712	54	java/lang/Exception
    //   1742	1747	54	java/lang/Exception
    //   1751	1764	54	java/lang/Exception
    //   1775	1779	54	java/lang/Exception
    //   1779	1782	54	java/lang/Exception
    //   1783	1796	54	java/lang/Exception
    //   1799	1824	54	java/lang/Exception
    //   1829	1849	54	java/lang/Exception
    //   1852	1857	54	java/lang/Exception
    //   1860	1865	54	java/lang/Exception
    //   1868	1883	54	java/lang/Exception
    //   1886	1891	54	java/lang/Exception
    //   1894	1899	54	java/lang/Exception
    //   1902	1907	54	java/lang/Exception
    //   1911	1924	54	java/lang/Exception
    //   268	273	1698	java/io/IOException
    //   232	247	1715	java/io/IOException
    //   1742	1747	1750	java/io/IOException
    //   232	247	1767	finally
    //   1775	1779	1782	java/io/IOException
    //   693	712	1827	java/lang/Throwable
    //   1622	1629	1910	java/lang/Exception
    //   1633	1662	1910	java/lang/Exception
    //   1662	1691	1910	java/lang/Exception
    //   250	268	1927	finally
    //   1723	1737	1927	finally
    //   250	268	1932	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.a
 * JD-Core Version:    0.7.0.1
 */