package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

public class o
{
  private String a;
  private Context b;
  private List<p> c;
  private volatile int d;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(180833);
    this.a = o.class.getSimpleName();
    this.b = paramContext;
    AppMethodBeat.o(180833);
  }
  
  private boolean a(p paramp)
  {
    AppMethodBeat.i(180837);
    try
    {
      if (x.a(paramp.a)) {}
      boolean bool;
      for (String str = x.e + File.separator + t.F[paramp.a] + File.separator + paramp.c;; str = x.d + File.separator + paramp.c)
      {
        localObject = new File(x.b(this.b, str));
        if (((File)localObject).exists()) {
          break;
        }
        bool = ((File)localObject).isFile();
        if (bool) {
          break;
        }
        AppMethodBeat.o(180837);
        return false;
      }
      str = ((File)localObject).getName();
      long l = ((File)localObject).length();
      Object localObject = x.a((File)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(180837);
        return false;
      }
      if ((paramp.c.equals(str)) && (paramp.d == l))
      {
        bool = paramp.e.equals(localObject);
        if (bool)
        {
          AppMethodBeat.o(180837);
          return true;
        }
      }
    }
    catch (Exception paramp)
    {
      AppMethodBeat.o(180837);
    }
    return false;
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte, p paramp)
  {
    AppMethodBeat.i(180835);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(180835);
      return false;
    }
    if (!new w(paramString).a(paramArrayOfByte))
    {
      AppMethodBeat.o(180835);
      return false;
    }
    paramString = x.a(new File(paramString));
    if ((paramString == null) || (!paramp.e.equals(paramString)))
    {
      AppMethodBeat.o(180835);
      return false;
    }
    AppMethodBeat.o(180835);
    return true;
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 124
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 126	com/tencent/map/tools/internal/o:d	I
    //   12: aload_0
    //   13: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   16: ifnull +915 -> 931
    //   19: aload_0
    //   20: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   23: invokeinterface 134 1 0
    //   28: ifle +903 -> 931
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 126	com/tencent/map/tools/internal/o:d	I
    //   36: invokestatic 136	com/tencent/map/tools/internal/x:d	()J
    //   39: ldc2_w 137
    //   42: lcmp
    //   43: ifge +21 -> 64
    //   46: aload_0
    //   47: iconst_2
    //   48: putfield 126	com/tencent/map/tools/internal/o:d	I
    //   51: iconst_0
    //   52: istore 7
    //   54: ldc 124
    //   56: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload 7
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   68: getstatic 141	com/tencent/map/tools/internal/t:B	Ljava/lang/String;
    //   71: ldc 143
    //   73: invokestatic 146	com/tencent/map/tools/internal/x:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 8
    //   78: aload 8
    //   80: ifnull +875 -> 955
    //   83: aload 8
    //   85: ldc 143
    //   87: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +865 -> 955
    //   93: aload 8
    //   95: invokestatic 149	com/tencent/map/tools/internal/x:a	(Ljava/lang/String;)Ljava/util/List;
    //   98: astore 8
    //   100: iconst_0
    //   101: istore_1
    //   102: iconst_0
    //   103: istore_2
    //   104: aload_0
    //   105: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   108: invokestatic 154	com/tencent/map/tools/internal/s:a	(Landroid/content/Context;)Lcom/tencent/map/tools/internal/s;
    //   111: invokevirtual 156	com/tencent/map/tools/internal/s:a	()I
    //   114: istore 6
    //   116: new 158	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 159	java/util/ArrayList:<init>	()V
    //   123: astore 10
    //   125: new 158	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 159	java/util/ArrayList:<init>	()V
    //   132: astore 11
    //   134: iconst_0
    //   135: istore 4
    //   137: iload 4
    //   139: aload_0
    //   140: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   143: invokeinterface 134 1 0
    //   148: if_icmpge +512 -> 660
    //   151: aload_0
    //   152: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   155: iload 4
    //   157: invokeinterface 163 2 0
    //   162: checkcast 45	com/tencent/map/tools/internal/p
    //   165: astore 12
    //   167: aload 12
    //   169: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   172: aload 8
    //   174: invokestatic 166	com/tencent/map/tools/internal/x:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   177: astore 14
    //   179: aload_0
    //   180: aload 12
    //   182: invokespecial 168	com/tencent/map/tools/internal/o:a	(Lcom/tencent/map/tools/internal/p;)Z
    //   185: ifeq +57 -> 242
    //   188: aload 11
    //   190: new 170	android/util/Pair
    //   193: dup
    //   194: ldc 143
    //   196: ldc 143
    //   198: invokespecial 173	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   201: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   204: pop
    //   205: aload 12
    //   207: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   210: invokestatic 52	com/tencent/map/tools/internal/x:a	(I)Z
    //   213: ifeq +22 -> 235
    //   216: iconst_1
    //   217: istore_1
    //   218: aload 10
    //   220: aload 12
    //   222: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   225: pop
    //   226: iload 4
    //   228: iconst_1
    //   229: iadd
    //   230: istore 4
    //   232: goto -95 -> 137
    //   235: iload_2
    //   236: iconst_1
    //   237: iadd
    //   238: istore_2
    //   239: goto -21 -> 218
    //   242: iload_1
    //   243: istore_3
    //   244: new 54	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   251: getstatic 179	com/tencent/map/tools/internal/t:E	Ljava/lang/String;
    //   254: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 12
    //   259: getfield 113	com/tencent/map/tools/internal/p:e	Ljava/lang/String;
    //   262: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 184	com/tencent/map/tools/internal/r:a	(Ljava/lang/String;)[B
    //   271: astore 9
    //   273: aload 9
    //   275: ifnull +677 -> 952
    //   278: iload_1
    //   279: istore_3
    //   280: aload 9
    //   282: ldc 186
    //   284: getstatic 190	com/tencent/map/tools/internal/t:G	Ljavax/crypto/spec/IvParameterSpec;
    //   287: invokestatic 196	com/tencent/map/tools/EncryptAesUtils:decryptAes256	([BLjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)[B
    //   290: invokestatic 199	com/tencent/map/tools/internal/x:a	([B)[B
    //   293: astore 13
    //   295: iload_1
    //   296: istore_3
    //   297: aload 12
    //   299: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   302: invokestatic 52	com/tencent/map/tools/internal/x:a	(I)Z
    //   305: ifeq +204 -> 509
    //   308: iload_1
    //   309: istore_3
    //   310: aload 12
    //   312: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   315: iload 6
    //   317: if_icmpne +635 -> 952
    //   320: iload_1
    //   321: istore_3
    //   322: new 54	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   329: getstatic 58	com/tencent/map/tools/internal/x:e	Ljava/lang/String;
    //   332: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   338: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: getstatic 73	com/tencent/map/tools/internal/t:F	[Ljava/lang/String;
    //   344: iload 6
    //   346: aaload
    //   347: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: astore 9
    //   355: iload_1
    //   356: istore_3
    //   357: aload_0
    //   358: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   361: aload 9
    //   363: invokestatic 81	com/tencent/map/tools/internal/x:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   366: astore 16
    //   368: iload_1
    //   369: istore_3
    //   370: new 54	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   377: aload 16
    //   379: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   385: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 12
    //   390: getfield 75	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   393: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: astore 15
    //   401: aconst_null
    //   402: astore 9
    //   404: aload 14
    //   406: ifnull +36 -> 442
    //   409: iload_1
    //   410: istore_3
    //   411: new 54	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   418: aload 16
    //   420: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   426: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 14
    //   431: getfield 75	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   434: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: astore 9
    //   442: iload_1
    //   443: istore_3
    //   444: aload 15
    //   446: aload 13
    //   448: aload 12
    //   450: invokestatic 201	com/tencent/map/tools/internal/o:a	(Ljava/lang/String;[BLcom/tencent/map/tools/internal/p;)Z
    //   453: ifeq +515 -> 968
    //   456: iconst_1
    //   457: istore 5
    //   459: iconst_1
    //   460: istore_1
    //   461: iload 5
    //   463: istore_3
    //   464: aload 12
    //   466: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   469: aload 8
    //   471: invokestatic 166	com/tencent/map/tools/internal/x:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   474: pop
    //   475: iload 5
    //   477: istore_3
    //   478: aload 11
    //   480: new 170	android/util/Pair
    //   483: dup
    //   484: aload 9
    //   486: aload 15
    //   488: invokespecial 173	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   491: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   494: pop
    //   495: iload 5
    //   497: istore_3
    //   498: aload 10
    //   500: aload 12
    //   502: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   505: pop
    //   506: goto -280 -> 226
    //   509: iload_1
    //   510: istore_3
    //   511: aload_0
    //   512: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   515: getstatic 93	com/tencent/map/tools/internal/x:d	Ljava/lang/String;
    //   518: invokestatic 81	com/tencent/map/tools/internal/x:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 16
    //   523: iload_1
    //   524: istore_3
    //   525: new 54	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   532: aload 16
    //   534: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   540: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 12
    //   545: getfield 75	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   548: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: astore 15
    //   556: aconst_null
    //   557: astore 9
    //   559: aload 14
    //   561: ifnull +36 -> 597
    //   564: iload_1
    //   565: istore_3
    //   566: new 54	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   573: aload 16
    //   575: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   581: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 14
    //   586: getfield 75	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   589: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: astore 9
    //   597: iload_1
    //   598: istore_3
    //   599: aload 15
    //   601: aload 13
    //   603: aload 12
    //   605: invokestatic 201	com/tencent/map/tools/internal/o:a	(Ljava/lang/String;[BLcom/tencent/map/tools/internal/p;)Z
    //   608: ifeq +344 -> 952
    //   611: iload_1
    //   612: istore_3
    //   613: aload 12
    //   615: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   618: aload 8
    //   620: invokestatic 166	com/tencent/map/tools/internal/x:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   623: pop
    //   624: iload_1
    //   625: istore_3
    //   626: aload 11
    //   628: new 170	android/util/Pair
    //   631: dup
    //   632: aload 9
    //   634: aload 15
    //   636: invokespecial 173	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   639: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   642: pop
    //   643: iload_1
    //   644: istore_3
    //   645: aload 10
    //   647: aload 12
    //   649: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   652: pop
    //   653: iload_2
    //   654: iconst_1
    //   655: iadd
    //   656: istore_2
    //   657: goto -431 -> 226
    //   660: getstatic 205	com/tencent/map/tools/internal/y:e	I
    //   663: iconst_1
    //   664: if_icmpne +160 -> 824
    //   667: iload_2
    //   668: ifle +126 -> 794
    //   671: iload_1
    //   672: ifeq +122 -> 794
    //   675: aload_0
    //   676: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   679: invokeinterface 134 1 0
    //   684: aload 10
    //   686: invokevirtual 206	java/util/ArrayList:size	()I
    //   689: if_icmpne +105 -> 794
    //   692: iconst_1
    //   693: istore_1
    //   694: iload_1
    //   695: ifeq +209 -> 904
    //   698: aload 11
    //   700: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   703: astore 8
    //   705: aload 8
    //   707: invokeinterface 215 1 0
    //   712: ifeq +140 -> 852
    //   715: aload 8
    //   717: invokeinterface 219 1 0
    //   722: checkcast 170	android/util/Pair
    //   725: astore 10
    //   727: aload 10
    //   729: getfield 223	android/util/Pair:first	Ljava/lang/Object;
    //   732: checkcast 105	java/lang/String
    //   735: astore 9
    //   737: aload 10
    //   739: getfield 226	android/util/Pair:second	Ljava/lang/Object;
    //   742: astore 10
    //   744: aload 9
    //   746: ifnull -41 -> 705
    //   749: aload 9
    //   751: ldc 143
    //   753: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   756: ifne -51 -> 705
    //   759: new 64	java/io/File
    //   762: dup
    //   763: aload 9
    //   765: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   768: astore 9
    //   770: aload 9
    //   772: invokevirtual 88	java/io/File:exists	()Z
    //   775: ifeq -70 -> 705
    //   778: aload 9
    //   780: invokevirtual 229	java/io/File:delete	()Z
    //   783: pop
    //   784: goto -79 -> 705
    //   787: astore 8
    //   789: aload_0
    //   790: monitorexit
    //   791: aload 8
    //   793: athrow
    //   794: iload_2
    //   795: ifne +178 -> 973
    //   798: iload_1
    //   799: ifeq +174 -> 973
    //   802: aload_0
    //   803: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   806: invokeinterface 134 1 0
    //   811: aload 10
    //   813: invokevirtual 206	java/util/ArrayList:size	()I
    //   816: if_icmpne +157 -> 973
    //   819: iconst_1
    //   820: istore_1
    //   821: goto -127 -> 694
    //   824: getstatic 205	com/tencent/map/tools/internal/y:e	I
    //   827: ifne +120 -> 947
    //   830: aload_0
    //   831: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   834: invokeinterface 134 1 0
    //   839: aload 10
    //   841: invokevirtual 206	java/util/ArrayList:size	()I
    //   844: if_icmpne +103 -> 947
    //   847: iconst_1
    //   848: istore_1
    //   849: goto -155 -> 694
    //   852: aload_0
    //   853: getfield 128	com/tencent/map/tools/internal/o:c	Ljava/util/List;
    //   856: invokestatic 232	com/tencent/map/tools/internal/x:a	(Ljava/util/List;)Ljava/lang/String;
    //   859: astore 8
    //   861: aload_0
    //   862: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   865: getstatic 141	com/tencent/map/tools/internal/t:B	Ljava/lang/String;
    //   868: aload 8
    //   870: invokestatic 235	com/tencent/map/tools/internal/x:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   873: pop
    //   874: aload_0
    //   875: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   878: getstatic 238	com/tencent/map/tools/internal/t:u	Ljava/lang/String;
    //   881: getstatic 241	com/tencent/map/tools/internal/t:k	Ljava/lang/String;
    //   884: invokestatic 235	com/tencent/map/tools/internal/x:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   887: pop
    //   888: aload_0
    //   889: iconst_4
    //   890: putfield 126	com/tencent/map/tools/internal/o:d	I
    //   893: iconst_1
    //   894: istore 7
    //   896: ldc 124
    //   898: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   901: goto -842 -> 59
    //   904: new 64	java/io/File
    //   907: dup
    //   908: getstatic 244	com/tencent/map/tools/internal/t:h	Ljava/lang/String;
    //   911: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   914: invokestatic 247	com/tencent/map/tools/internal/x:c	(Ljava/io/File;)Z
    //   917: pop
    //   918: aload_0
    //   919: getfield 35	com/tencent/map/tools/internal/o:b	Landroid/content/Context;
    //   922: getstatic 141	com/tencent/map/tools/internal/t:B	Ljava/lang/String;
    //   925: ldc 143
    //   927: invokestatic 235	com/tencent/map/tools/internal/x:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   930: pop
    //   931: aload_0
    //   932: iconst_3
    //   933: putfield 126	com/tencent/map/tools/internal/o:d	I
    //   936: iconst_0
    //   937: istore 7
    //   939: ldc 124
    //   941: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: goto -885 -> 59
    //   947: iconst_0
    //   948: istore_1
    //   949: goto -255 -> 694
    //   952: goto -295 -> 657
    //   955: aconst_null
    //   956: astore 8
    //   958: goto -858 -> 100
    //   961: astore 9
    //   963: iload_3
    //   964: istore_1
    //   965: goto -739 -> 226
    //   968: iconst_0
    //   969: istore_1
    //   970: goto -744 -> 226
    //   973: iconst_0
    //   974: istore_1
    //   975: goto -281 -> 694
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	o
    //   101	874	1	i	int
    //   103	692	2	j	int
    //   243	721	3	k	int
    //   135	96	4	m	int
    //   457	39	5	n	int
    //   114	231	6	i1	int
    //   52	886	7	bool	boolean
    //   76	640	8	localObject1	Object
    //   787	5	8	localObject2	Object
    //   859	98	8	str1	String
    //   271	508	9	localObject3	Object
    //   961	1	9	localThrowable	Throwable
    //   123	717	10	localObject4	Object
    //   132	567	11	localArrayList	java.util.ArrayList
    //   165	483	12	localp1	p
    //   293	309	13	arrayOfByte	byte[]
    //   177	408	14	localp2	p
    //   399	236	15	str2	String
    //   366	208	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	51	787	finally
    //   54	59	787	finally
    //   64	78	787	finally
    //   83	100	787	finally
    //   104	134	787	finally
    //   137	216	787	finally
    //   218	226	787	finally
    //   244	273	787	finally
    //   280	295	787	finally
    //   297	308	787	finally
    //   310	320	787	finally
    //   322	355	787	finally
    //   357	368	787	finally
    //   370	401	787	finally
    //   411	442	787	finally
    //   444	456	787	finally
    //   464	475	787	finally
    //   478	495	787	finally
    //   498	506	787	finally
    //   511	523	787	finally
    //   525	556	787	finally
    //   566	597	787	finally
    //   599	611	787	finally
    //   613	624	787	finally
    //   626	643	787	finally
    //   645	653	787	finally
    //   660	667	787	finally
    //   675	692	787	finally
    //   698	705	787	finally
    //   705	744	787	finally
    //   749	784	787	finally
    //   802	819	787	finally
    //   824	847	787	finally
    //   852	893	787	finally
    //   896	901	787	finally
    //   904	931	787	finally
    //   931	936	787	finally
    //   939	944	787	finally
    //   244	273	961	java/lang/Throwable
    //   280	295	961	java/lang/Throwable
    //   297	308	961	java/lang/Throwable
    //   310	320	961	java/lang/Throwable
    //   322	355	961	java/lang/Throwable
    //   357	368	961	java/lang/Throwable
    //   370	401	961	java/lang/Throwable
    //   411	442	961	java/lang/Throwable
    //   444	456	961	java/lang/Throwable
    //   464	475	961	java/lang/Throwable
    //   478	495	961	java/lang/Throwable
    //   498	506	961	java/lang/Throwable
    //   511	523	961	java/lang/Throwable
    //   525	556	961	java/lang/Throwable
    //   566	597	961	java/lang/Throwable
    //   599	611	961	java/lang/Throwable
    //   613	624	961	java/lang/Throwable
    //   626	643	961	java/lang/Throwable
    //   645	653	961	java/lang/Throwable
  }
  
  public final int a()
  {
    return this.d;
  }
  
  public final void a(List<p> paramList)
  {
    this.c = paramList;
  }
  
  public final void b()
  {
    AppMethodBeat.i(224093);
    try
    {
      v.a(this.b).a("update");
      int i = 0;
      while ((i < 3) && (!c())) {
        i += 1;
      }
      v.a(this.b).b("update");
      AppMethodBeat.o(224093);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(224093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.o
 * JD-Core Version:    0.7.0.1
 */