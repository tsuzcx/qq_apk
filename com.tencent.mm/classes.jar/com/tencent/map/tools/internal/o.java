package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

public class o
{
  List<p> a;
  volatile int b;
  private String c;
  private Context d;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(180833);
    this.c = o.class.getSimpleName();
    this.d = paramContext;
    AppMethodBeat.o(180833);
  }
  
  private boolean a(p paramp)
  {
    AppMethodBeat.i(180837);
    try
    {
      if (y.a(paramp.a)) {}
      boolean bool;
      for (String str = y.e + File.separator + u.F[paramp.a] + File.separator + paramp.c;; str = y.d + File.separator + paramp.c)
      {
        localObject = new File(y.b(this.d, str));
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
      Object localObject = y.a((File)localObject);
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
    if (!new x(paramString).a(paramArrayOfByte))
    {
      AppMethodBeat.o(180835);
      return false;
    }
    paramString = y.a(new File(paramString));
    if ((paramString == null) || (!paramp.e.equals(paramString)))
    {
      AppMethodBeat.o(180835);
      return false;
    }
    AppMethodBeat.o(180835);
    return true;
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 125	com/tencent/map/tools/internal/o:b	I
    //   12: aload_0
    //   13: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   16: ifnull +912 -> 928
    //   19: aload_0
    //   20: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   23: invokeinterface 133 1 0
    //   28: ifle +900 -> 928
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 125	com/tencent/map/tools/internal/o:b	I
    //   36: invokestatic 135	com/tencent/map/tools/internal/y:d	()J
    //   39: ldc2_w 136
    //   42: lcmp
    //   43: ifge +21 -> 64
    //   46: aload_0
    //   47: iconst_2
    //   48: putfield 125	com/tencent/map/tools/internal/o:b	I
    //   51: iconst_0
    //   52: istore 7
    //   54: ldc 123
    //   56: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload 7
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   68: getstatic 140	com/tencent/map/tools/internal/u:B	Ljava/lang/String;
    //   71: ldc 142
    //   73: invokestatic 145	com/tencent/map/tools/internal/y:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 8
    //   78: aload 8
    //   80: ifnull +872 -> 952
    //   83: aload 8
    //   85: ldc 142
    //   87: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +862 -> 952
    //   93: aload 8
    //   95: invokestatic 148	com/tencent/map/tools/internal/y:a	(Ljava/lang/String;)Ljava/util/List;
    //   98: astore 8
    //   100: iconst_0
    //   101: istore_1
    //   102: iconst_0
    //   103: istore_2
    //   104: aload_0
    //   105: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   108: invokestatic 153	com/tencent/map/tools/internal/t:a	(Landroid/content/Context;)Lcom/tencent/map/tools/internal/t;
    //   111: getfield 154	com/tencent/map/tools/internal/t:a	I
    //   114: istore 6
    //   116: new 156	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 157	java/util/ArrayList:<init>	()V
    //   123: astore 10
    //   125: new 156	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 157	java/util/ArrayList:<init>	()V
    //   132: astore 11
    //   134: iconst_0
    //   135: istore 4
    //   137: iload 4
    //   139: aload_0
    //   140: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   143: invokeinterface 133 1 0
    //   148: if_icmpge +509 -> 657
    //   151: aload_0
    //   152: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   155: iload 4
    //   157: invokeinterface 161 2 0
    //   162: checkcast 45	com/tencent/map/tools/internal/p
    //   165: astore 12
    //   167: aload 12
    //   169: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   172: aload 8
    //   174: invokestatic 164	com/tencent/map/tools/internal/y:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   177: astore 14
    //   179: aload_0
    //   180: aload 12
    //   182: invokespecial 166	com/tencent/map/tools/internal/o:a	(Lcom/tencent/map/tools/internal/p;)Z
    //   185: ifeq +57 -> 242
    //   188: aload 11
    //   190: new 168	android/util/Pair
    //   193: dup
    //   194: ldc 142
    //   196: ldc 142
    //   198: invokespecial 171	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   201: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   204: pop
    //   205: aload 12
    //   207: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   210: invokestatic 52	com/tencent/map/tools/internal/y:a	(I)Z
    //   213: ifeq +22 -> 235
    //   216: iconst_1
    //   217: istore_1
    //   218: aload 10
    //   220: aload 12
    //   222: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   251: getstatic 177	com/tencent/map/tools/internal/u:E	Ljava/lang/String;
    //   254: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 12
    //   259: getfield 112	com/tencent/map/tools/internal/p:e	Ljava/lang/String;
    //   262: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 182	com/tencent/map/tools/internal/s:a	(Ljava/lang/String;)[B
    //   271: astore 9
    //   273: aload 9
    //   275: ifnull +674 -> 949
    //   278: iload_1
    //   279: istore_3
    //   280: aload 9
    //   282: ldc 184
    //   284: invokestatic 189	com/tencent/map/tools/internal/q:b	([BLjava/lang/String;)[B
    //   287: invokestatic 192	com/tencent/map/tools/internal/y:a	([B)[B
    //   290: astore 13
    //   292: iload_1
    //   293: istore_3
    //   294: aload 12
    //   296: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   299: invokestatic 52	com/tencent/map/tools/internal/y:a	(I)Z
    //   302: ifeq +204 -> 506
    //   305: iload_1
    //   306: istore_3
    //   307: aload 12
    //   309: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   312: iload 6
    //   314: if_icmpne +635 -> 949
    //   317: iload_1
    //   318: istore_3
    //   319: new 54	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   326: getstatic 58	com/tencent/map/tools/internal/y:e	Ljava/lang/String;
    //   329: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   335: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: getstatic 73	com/tencent/map/tools/internal/u:F	[Ljava/lang/String;
    //   341: iload 6
    //   343: aaload
    //   344: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 9
    //   352: iload_1
    //   353: istore_3
    //   354: aload_0
    //   355: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   358: aload 9
    //   360: invokestatic 80	com/tencent/map/tools/internal/y:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   363: astore 16
    //   365: iload_1
    //   366: istore_3
    //   367: new 54	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   374: aload 16
    //   376: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   382: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 12
    //   387: getfield 74	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   390: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: astore 15
    //   398: aconst_null
    //   399: astore 9
    //   401: aload 14
    //   403: ifnull +36 -> 439
    //   406: iload_1
    //   407: istore_3
    //   408: new 54	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   415: aload 16
    //   417: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   423: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 14
    //   428: getfield 74	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   431: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: astore 9
    //   439: iload_1
    //   440: istore_3
    //   441: aload 15
    //   443: aload 13
    //   445: aload 12
    //   447: invokestatic 194	com/tencent/map/tools/internal/o:a	(Ljava/lang/String;[BLcom/tencent/map/tools/internal/p;)Z
    //   450: ifeq +515 -> 965
    //   453: iconst_1
    //   454: istore 5
    //   456: iconst_1
    //   457: istore_1
    //   458: iload 5
    //   460: istore_3
    //   461: aload 12
    //   463: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   466: aload 8
    //   468: invokestatic 164	com/tencent/map/tools/internal/y:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   471: pop
    //   472: iload 5
    //   474: istore_3
    //   475: aload 11
    //   477: new 168	android/util/Pair
    //   480: dup
    //   481: aload 9
    //   483: aload 15
    //   485: invokespecial 171	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   488: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   491: pop
    //   492: iload 5
    //   494: istore_3
    //   495: aload 10
    //   497: aload 12
    //   499: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   502: pop
    //   503: goto -277 -> 226
    //   506: iload_1
    //   507: istore_3
    //   508: aload_0
    //   509: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   512: getstatic 92	com/tencent/map/tools/internal/y:d	Ljava/lang/String;
    //   515: invokestatic 80	com/tencent/map/tools/internal/y:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   518: astore 16
    //   520: iload_1
    //   521: istore_3
    //   522: new 54	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   529: aload 16
    //   531: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   537: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 12
    //   542: getfield 74	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   545: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: astore 15
    //   553: aconst_null
    //   554: astore 9
    //   556: aload 14
    //   558: ifnull +36 -> 594
    //   561: iload_1
    //   562: istore_3
    //   563: new 54	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   570: aload 16
    //   572: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   578: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 14
    //   583: getfield 74	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   586: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: astore 9
    //   594: iload_1
    //   595: istore_3
    //   596: aload 15
    //   598: aload 13
    //   600: aload 12
    //   602: invokestatic 194	com/tencent/map/tools/internal/o:a	(Ljava/lang/String;[BLcom/tencent/map/tools/internal/p;)Z
    //   605: ifeq +344 -> 949
    //   608: iload_1
    //   609: istore_3
    //   610: aload 12
    //   612: getfield 47	com/tencent/map/tools/internal/p:a	I
    //   615: aload 8
    //   617: invokestatic 164	com/tencent/map/tools/internal/y:a	(ILjava/util/List;)Lcom/tencent/map/tools/internal/p;
    //   620: pop
    //   621: iload_1
    //   622: istore_3
    //   623: aload 11
    //   625: new 168	android/util/Pair
    //   628: dup
    //   629: aload 9
    //   631: aload 15
    //   633: invokespecial 171	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   636: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   639: pop
    //   640: iload_1
    //   641: istore_3
    //   642: aload 10
    //   644: aload 12
    //   646: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   649: pop
    //   650: iload_2
    //   651: iconst_1
    //   652: iadd
    //   653: istore_2
    //   654: goto -428 -> 226
    //   657: getstatic 198	com/tencent/map/tools/internal/z:e	I
    //   660: iconst_1
    //   661: if_icmpne +160 -> 821
    //   664: iload_2
    //   665: ifle +126 -> 791
    //   668: iload_1
    //   669: ifeq +122 -> 791
    //   672: aload_0
    //   673: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   676: invokeinterface 133 1 0
    //   681: aload 10
    //   683: invokevirtual 199	java/util/ArrayList:size	()I
    //   686: if_icmpne +105 -> 791
    //   689: iconst_1
    //   690: istore_1
    //   691: iload_1
    //   692: ifeq +209 -> 901
    //   695: aload 11
    //   697: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   700: astore 8
    //   702: aload 8
    //   704: invokeinterface 208 1 0
    //   709: ifeq +140 -> 849
    //   712: aload 8
    //   714: invokeinterface 212 1 0
    //   719: checkcast 168	android/util/Pair
    //   722: astore 10
    //   724: aload 10
    //   726: getfield 216	android/util/Pair:first	Ljava/lang/Object;
    //   729: checkcast 104	java/lang/String
    //   732: astore 9
    //   734: aload 10
    //   736: getfield 219	android/util/Pair:second	Ljava/lang/Object;
    //   739: astore 10
    //   741: aload 9
    //   743: ifnull -41 -> 702
    //   746: aload 9
    //   748: ldc 142
    //   750: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   753: ifne -51 -> 702
    //   756: new 64	java/io/File
    //   759: dup
    //   760: aload 9
    //   762: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   765: astore 9
    //   767: aload 9
    //   769: invokevirtual 87	java/io/File:exists	()Z
    //   772: ifeq -70 -> 702
    //   775: aload 9
    //   777: invokevirtual 222	java/io/File:delete	()Z
    //   780: pop
    //   781: goto -79 -> 702
    //   784: astore 8
    //   786: aload_0
    //   787: monitorexit
    //   788: aload 8
    //   790: athrow
    //   791: iload_2
    //   792: ifne +178 -> 970
    //   795: iload_1
    //   796: ifeq +174 -> 970
    //   799: aload_0
    //   800: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   803: invokeinterface 133 1 0
    //   808: aload 10
    //   810: invokevirtual 199	java/util/ArrayList:size	()I
    //   813: if_icmpne +157 -> 970
    //   816: iconst_1
    //   817: istore_1
    //   818: goto -127 -> 691
    //   821: getstatic 198	com/tencent/map/tools/internal/z:e	I
    //   824: ifne +120 -> 944
    //   827: aload_0
    //   828: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   831: invokeinterface 133 1 0
    //   836: aload 10
    //   838: invokevirtual 199	java/util/ArrayList:size	()I
    //   841: if_icmpne +103 -> 944
    //   844: iconst_1
    //   845: istore_1
    //   846: goto -155 -> 691
    //   849: aload_0
    //   850: getfield 127	com/tencent/map/tools/internal/o:a	Ljava/util/List;
    //   853: invokestatic 225	com/tencent/map/tools/internal/y:a	(Ljava/util/List;)Ljava/lang/String;
    //   856: astore 8
    //   858: aload_0
    //   859: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   862: getstatic 140	com/tencent/map/tools/internal/u:B	Ljava/lang/String;
    //   865: aload 8
    //   867: invokestatic 228	com/tencent/map/tools/internal/y:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   870: pop
    //   871: aload_0
    //   872: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   875: getstatic 231	com/tencent/map/tools/internal/u:u	Ljava/lang/String;
    //   878: getstatic 234	com/tencent/map/tools/internal/u:k	Ljava/lang/String;
    //   881: invokestatic 228	com/tencent/map/tools/internal/y:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   884: pop
    //   885: aload_0
    //   886: iconst_4
    //   887: putfield 125	com/tencent/map/tools/internal/o:b	I
    //   890: iconst_1
    //   891: istore 7
    //   893: ldc 123
    //   895: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: goto -839 -> 59
    //   901: new 64	java/io/File
    //   904: dup
    //   905: getstatic 237	com/tencent/map/tools/internal/u:h	Ljava/lang/String;
    //   908: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   911: invokestatic 240	com/tencent/map/tools/internal/y:c	(Ljava/io/File;)Z
    //   914: pop
    //   915: aload_0
    //   916: getfield 35	com/tencent/map/tools/internal/o:d	Landroid/content/Context;
    //   919: getstatic 140	com/tencent/map/tools/internal/u:B	Ljava/lang/String;
    //   922: ldc 142
    //   924: invokestatic 228	com/tencent/map/tools/internal/y:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   927: pop
    //   928: aload_0
    //   929: iconst_3
    //   930: putfield 125	com/tencent/map/tools/internal/o:b	I
    //   933: iconst_0
    //   934: istore 7
    //   936: ldc 123
    //   938: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   941: goto -882 -> 59
    //   944: iconst_0
    //   945: istore_1
    //   946: goto -255 -> 691
    //   949: goto -295 -> 654
    //   952: aconst_null
    //   953: astore 8
    //   955: goto -855 -> 100
    //   958: astore 9
    //   960: iload_3
    //   961: istore_1
    //   962: goto -736 -> 226
    //   965: iconst_0
    //   966: istore_1
    //   967: goto -741 -> 226
    //   970: iconst_0
    //   971: istore_1
    //   972: goto -281 -> 691
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	this	o
    //   101	871	1	i	int
    //   103	689	2	j	int
    //   243	718	3	k	int
    //   135	96	4	m	int
    //   454	39	5	n	int
    //   114	228	6	i1	int
    //   52	883	7	bool	boolean
    //   76	637	8	localObject1	Object
    //   784	5	8	localObject2	Object
    //   856	98	8	str1	String
    //   271	505	9	localObject3	Object
    //   958	1	9	localThrowable	Throwable
    //   123	714	10	localObject4	Object
    //   132	564	11	localArrayList	java.util.ArrayList
    //   165	480	12	localp1	p
    //   290	309	13	arrayOfByte	byte[]
    //   177	405	14	localp2	p
    //   396	236	15	str2	String
    //   363	208	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	51	784	finally
    //   54	59	784	finally
    //   64	78	784	finally
    //   83	100	784	finally
    //   104	134	784	finally
    //   137	216	784	finally
    //   218	226	784	finally
    //   244	273	784	finally
    //   280	292	784	finally
    //   294	305	784	finally
    //   307	317	784	finally
    //   319	352	784	finally
    //   354	365	784	finally
    //   367	398	784	finally
    //   408	439	784	finally
    //   441	453	784	finally
    //   461	472	784	finally
    //   475	492	784	finally
    //   495	503	784	finally
    //   508	520	784	finally
    //   522	553	784	finally
    //   563	594	784	finally
    //   596	608	784	finally
    //   610	621	784	finally
    //   623	640	784	finally
    //   642	650	784	finally
    //   657	664	784	finally
    //   672	689	784	finally
    //   695	702	784	finally
    //   702	741	784	finally
    //   746	781	784	finally
    //   799	816	784	finally
    //   821	844	784	finally
    //   849	890	784	finally
    //   893	898	784	finally
    //   901	928	784	finally
    //   928	933	784	finally
    //   936	941	784	finally
    //   244	273	958	java/lang/Throwable
    //   280	292	958	java/lang/Throwable
    //   294	305	958	java/lang/Throwable
    //   307	317	958	java/lang/Throwable
    //   319	352	958	java/lang/Throwable
    //   354	365	958	java/lang/Throwable
    //   367	398	958	java/lang/Throwable
    //   408	439	958	java/lang/Throwable
    //   441	453	958	java/lang/Throwable
    //   461	472	958	java/lang/Throwable
    //   475	492	958	java/lang/Throwable
    //   495	503	958	java/lang/Throwable
    //   508	520	958	java/lang/Throwable
    //   522	553	958	java/lang/Throwable
    //   563	594	958	java/lang/Throwable
    //   596	608	958	java/lang/Throwable
    //   610	621	958	java/lang/Throwable
    //   623	640	958	java/lang/Throwable
    //   642	650	958	java/lang/Throwable
  }
  
  public final void a()
  {
    AppMethodBeat.i(180834);
    try
    {
      w.a(this.d).a("update");
      int i = 0;
      while ((i < 3) && (!b())) {
        i += 1;
      }
      w.a(this.d).b("update");
      AppMethodBeat.o(180834);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(180834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.o
 * JD-Core Version:    0.7.0.1
 */