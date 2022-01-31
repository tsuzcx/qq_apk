package a.j.b.a;

import a.j.b.a.b.i;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflect-api"})
public final class y
{
  private static final ConcurrentMap<ah, WeakReference<i>> BQi;
  
  static
  {
    AppMethodBeat.i(118896);
    BQi = (ConcurrentMap)new ConcurrentHashMap();
    AppMethodBeat.o(118896);
  }
  
  /* Error */
  public static final i aJ(java.lang.Class<?> paramClass)
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 50
    //   8: invokestatic 56	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokestatic 62	a/j/b/a/e/b:aQ	(Ljava/lang/Class;)Ljava/lang/ClassLoader;
    //   15: astore 10
    //   17: new 64	a/j/b/a/ah
    //   20: dup
    //   21: aload 10
    //   23: invokespecial 67	a/j/b/a/ah:<init>	(Ljava/lang/ClassLoader;)V
    //   26: astore_0
    //   27: getstatic 41	a/j/b/a/y:BQi	Ljava/util/concurrent/ConcurrentMap;
    //   30: aload_0
    //   31: invokeinterface 71 2 0
    //   36: checkcast 73	java/lang/ref/WeakReference
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +39 -> 80
    //   44: aload_2
    //   45: invokevirtual 76	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   48: checkcast 78	a/j/b/a/b/i
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +16 -> 69
    //   56: aload_3
    //   57: ldc 80
    //   59: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   62: ldc 48
    //   64: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_3
    //   68: areturn
    //   69: getstatic 41	a/j/b/a/y:BQi	Ljava/util/concurrent/ConcurrentMap;
    //   72: aload_0
    //   73: aload_2
    //   74: invokeinterface 87 3 0
    //   79: pop
    //   80: getstatic 91	a/j/b/a/b/i:BRn	La/j/b/a/b/i$a;
    //   83: astore_2
    //   84: aload 10
    //   86: ldc 93
    //   88: invokestatic 56	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: new 95	a/j/b/a/c/k/b
    //   94: dup
    //   95: invokespecial 96	a/j/b/a/c/k/b:<init>	()V
    //   98: astore 8
    //   100: new 98	a/j/b/a/c/a/b/e
    //   103: dup
    //   104: aload 8
    //   106: checkcast 100	a/j/b/a/c/k/i
    //   109: iconst_0
    //   110: invokespecial 103	a/j/b/a/c/a/b/e:<init>	(La/j/b/a/c/k/i;B)V
    //   113: astore_2
    //   114: new 105	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 107
    //   120: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 10
    //   125: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: bipush 62
    //   130: invokevirtual 117	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   133: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 127	a/j/b/a/c/f/f:ayV	(Ljava/lang/String;)La/j/b/a/c/f/f;
    //   139: astore_3
    //   140: aload_3
    //   141: ldc 129
    //   143: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   146: new 131	a/j/b/a/c/b/c/v
    //   149: dup
    //   150: aload_3
    //   151: aload 8
    //   153: checkcast 100	a/j/b/a/c/k/i
    //   156: aload_2
    //   157: checkcast 133	a/j/b/a/c/a/g
    //   160: aconst_null
    //   161: bipush 56
    //   163: invokespecial 136	a/j/b/a/c/b/c/v:<init>	(La/j/b/a/c/f/f;La/j/b/a/c/k/i;La/j/b/a/c/a/g;Ljava/util/Map;I)V
    //   166: astore_3
    //   167: new 138	a/j/b/a/b/f
    //   170: dup
    //   171: aload 10
    //   173: invokespecial 139	a/j/b/a/b/f:<init>	(Ljava/lang/ClassLoader;)V
    //   176: astore 9
    //   178: new 141	a/j/b/a/c/d/b/e
    //   181: dup
    //   182: invokespecial 142	a/j/b/a/c/d/b/e:<init>	()V
    //   185: astore 5
    //   187: new 144	a/j/b/a/c/d/a/c/l
    //   190: dup
    //   191: invokespecial 145	a/j/b/a/c/d/a/c/l:<init>	()V
    //   194: astore 6
    //   196: new 147	a/j/b/a/b/j
    //   199: dup
    //   200: aload 10
    //   202: invokespecial 148	a/j/b/a/b/j:<init>	(Ljava/lang/ClassLoader;)V
    //   205: astore 4
    //   207: getstatic 154	a/j/b/a/c/d/a/a/g:Ceb	La/j/b/a/c/d/a/a/g;
    //   210: astore 11
    //   212: new 156	a/j/b/a/c/b/aa
    //   215: dup
    //   216: aload 8
    //   218: checkcast 100	a/j/b/a/c/k/i
    //   221: aload_3
    //   222: checkcast 158	a/j/b/a/c/b/y
    //   225: invokespecial 161	a/j/b/a/c/b/aa:<init>	(La/j/b/a/c/k/i;La/j/b/a/c/b/y;)V
    //   228: astore 7
    //   230: new 163	a/j/b/a/c/d/a/a
    //   233: dup
    //   234: aload 8
    //   236: checkcast 100	a/j/b/a/c/k/i
    //   239: getstatic 169	a/j/b/a/c/n/e:CEU	La/j/b/a/c/n/e;
    //   242: invokespecial 172	a/j/b/a/c/d/a/a:<init>	(La/j/b/a/c/k/i;La/j/b/a/c/n/e;)V
    //   245: astore 12
    //   247: aload 8
    //   249: checkcast 100	a/j/b/a/c/k/i
    //   252: astore 13
    //   254: new 174	a/j/b/a/b/c
    //   257: dup
    //   258: aload 10
    //   260: invokespecial 175	a/j/b/a/b/c:<init>	(Ljava/lang/ClassLoader;)V
    //   263: checkcast 177	a/j/b/a/c/d/a/j
    //   266: astore 10
    //   268: aload 9
    //   270: checkcast 179	a/j/b/a/c/d/b/m
    //   273: astore 14
    //   275: getstatic 185	a/j/b/a/c/d/a/a/k:Cef	La/j/b/a/c/d/a/a/k;
    //   278: astore 15
    //   280: aload 15
    //   282: ldc 187
    //   284: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   287: getstatic 193	a/j/b/a/b/h:BRk	La/j/b/a/b/h;
    //   290: checkcast 195	a/j/b/a/c/j/a/m
    //   293: astore 16
    //   295: aload 11
    //   297: ldc 197
    //   299: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   302: new 199	a/j/b/a/c/d/a/c/g
    //   305: dup
    //   306: new 201	a/j/b/a/c/d/a/c/b
    //   309: dup
    //   310: aload 13
    //   312: aload 10
    //   314: aload 14
    //   316: aload 5
    //   318: aload 15
    //   320: aload 16
    //   322: aload 11
    //   324: getstatic 207	a/j/b/a/c/d/a/a/f$a:Cea	La/j/b/a/c/d/a/a/f$a;
    //   327: checkcast 209	a/j/b/a/c/d/a/a/f
    //   330: getstatic 215	a/j/b/a/c/d/a/a/j$a:Cee	La/j/b/a/c/d/a/a/j$a;
    //   333: checkcast 217	a/j/b/a/c/d/a/a/j
    //   336: getstatic 223	a/j/b/a/b/k:BRs	La/j/b/a/b/k;
    //   339: checkcast 225	a/j/b/a/c/d/a/d/b
    //   342: aload 6
    //   344: checkcast 227	a/j/b/a/c/d/a/c/j
    //   347: aload 4
    //   349: checkcast 229	a/j/b/a/c/d/b/s
    //   352: getstatic 235	a/j/b/a/c/b/ap$a:BWH	La/j/b/a/c/b/ap$a;
    //   355: checkcast 237	a/j/b/a/c/b/ap
    //   358: getstatic 243	a/j/b/a/c/c/a/b$a:Cbs	La/j/b/a/c/c/a/b$a;
    //   361: checkcast 245	a/j/b/a/c/c/a/b
    //   364: aload_3
    //   365: checkcast 158	a/j/b/a/c/b/y
    //   368: new 247	a/j/b/a/c/a/i
    //   371: dup
    //   372: aload_3
    //   373: checkcast 158	a/j/b/a/c/b/y
    //   376: aload 7
    //   378: invokespecial 250	a/j/b/a/c/a/i:<init>	(La/j/b/a/c/b/y;La/j/b/a/c/b/aa;)V
    //   381: aload 12
    //   383: new 252	a/j/b/a/c/d/a/f/l
    //   386: dup
    //   387: aload 12
    //   389: getstatic 169	a/j/b/a/c/n/e:CEU	La/j/b/a/c/n/e;
    //   392: invokespecial 255	a/j/b/a/c/d/a/f/l:<init>	(La/j/b/a/c/d/a/a;La/j/b/a/c/n/e;)V
    //   395: getstatic 261	a/j/b/a/c/d/a/k$a:CcS	La/j/b/a/c/d/a/k$a;
    //   398: checkcast 263	a/j/b/a/c/d/a/k
    //   401: getstatic 269	a/j/b/a/c/d/a/c/c$b:CeY	La/j/b/a/c/d/a/c/c$b;
    //   404: checkcast 271	a/j/b/a/c/d/a/c/c
    //   407: invokespecial 274	a/j/b/a/c/d/a/c/b:<init>	(La/j/b/a/c/k/i;La/j/b/a/c/d/a/j;La/j/b/a/c/d/b/m;La/j/b/a/c/d/b/e;La/j/b/a/c/d/a/a/k;La/j/b/a/c/j/a/m;La/j/b/a/c/d/a/a/g;La/j/b/a/c/d/a/a/f;La/j/b/a/c/d/a/a/j;La/j/b/a/c/d/a/d/b;La/j/b/a/c/d/a/c/j;La/j/b/a/c/d/b/s;La/j/b/a/c/b/ap;La/j/b/a/c/c/a/b;La/j/b/a/c/b/y;La/j/b/a/c/a/i;La/j/b/a/c/d/a/a;La/j/b/a/c/d/a/f/l;La/j/b/a/c/d/a/k;La/j/b/a/c/d/a/c/c;)V
    //   410: invokespecial 277	a/j/b/a/c/d/a/c/g:<init>	(La/j/b/a/c/d/a/c/b;)V
    //   413: astore 10
    //   415: aload_3
    //   416: checkcast 158	a/j/b/a/c/b/y
    //   419: astore 12
    //   421: aload 12
    //   423: ldc_w 279
    //   426: invokestatic 56	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   429: aload_2
    //   430: getfield 283	a/j/b/a/c/a/b/e:BVs	La/j/b/a/c/b/y;
    //   433: ifnonnull +36 -> 469
    //   436: iconst_1
    //   437: istore_1
    //   438: getstatic 289	a/aa:BMh	Z
    //   441: ifeq +33 -> 474
    //   444: iload_1
    //   445: ifne +29 -> 474
    //   448: new 291	java/lang/AssertionError
    //   451: dup
    //   452: ldc_w 293
    //   455: invokespecial 296	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   458: checkcast 298	java/lang/Throwable
    //   461: astore_0
    //   462: ldc 48
    //   464: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: aload_0
    //   468: athrow
    //   469: iconst_0
    //   470: istore_1
    //   471: goto -33 -> 438
    //   474: aload_2
    //   475: aload 12
    //   477: putfield 283	a/j/b/a/c/a/b/e:BVs	La/j/b/a/c/b/y;
    //   480: aload_2
    //   481: iconst_1
    //   482: putfield 301	a/j/b/a/c/a/b/e:BVt	Z
    //   485: new 303	a/j/b/a/c/i/d/a
    //   488: dup
    //   489: aload 10
    //   491: aload 11
    //   493: invokespecial 306	a/j/b/a/c/i/d/a:<init>	(La/j/b/a/c/d/a/c/g;La/j/b/a/c/d/a/a/g;)V
    //   496: astore 11
    //   498: new 308	a/j/b/a/c/d/b/f
    //   501: dup
    //   502: aload 9
    //   504: checkcast 179	a/j/b/a/c/d/b/m
    //   507: aload 5
    //   509: invokespecial 311	a/j/b/a/c/d/b/f:<init>	(La/j/b/a/c/d/b/m;La/j/b/a/c/d/b/e;)V
    //   512: astore 12
    //   514: new 313	a/j/b/a/c/d/b/c
    //   517: dup
    //   518: aload_3
    //   519: checkcast 158	a/j/b/a/c/b/y
    //   522: aload 7
    //   524: aload 8
    //   526: checkcast 100	a/j/b/a/c/k/i
    //   529: aload 9
    //   531: checkcast 179	a/j/b/a/c/d/b/m
    //   534: invokespecial 316	a/j/b/a/c/d/b/c:<init>	(La/j/b/a/c/b/y;La/j/b/a/c/b/aa;La/j/b/a/c/k/i;La/j/b/a/c/d/b/m;)V
    //   537: astore 9
    //   539: aload 8
    //   541: checkcast 100	a/j/b/a/c/k/i
    //   544: astore 8
    //   546: aload_3
    //   547: checkcast 158	a/j/b/a/c/b/y
    //   550: astore 13
    //   552: getstatic 322	a/j/b/a/c/j/a/j$a:CyP	La/j/b/a/c/j/a/j$a;
    //   555: checkcast 324	a/j/b/a/c/j/a/j
    //   558: astore 14
    //   560: getstatic 193	a/j/b/a/b/h:BRk	La/j/b/a/b/h;
    //   563: checkcast 195	a/j/b/a/c/j/a/m
    //   566: astore 15
    //   568: getstatic 243	a/j/b/a/c/c/a/b$a:Cbs	La/j/b/a/c/c/a/b$a;
    //   571: checkcast 245	a/j/b/a/c/c/a/b
    //   574: astore 16
    //   576: getstatic 330	a/j/b/a/c/j/a/h:CyA	La/j/b/a/c/j/a/h$a;
    //   579: astore 17
    //   581: new 332	a/j/b/a/c/d/b/d
    //   584: dup
    //   585: aload 8
    //   587: aload 13
    //   589: aload 14
    //   591: aload 12
    //   593: aload 9
    //   595: aload 10
    //   597: aload 7
    //   599: aload 15
    //   601: aload 16
    //   603: invokestatic 338	a/j/b/a/c/j/a/h$a:eoo	()La/j/b/a/c/j/a/h;
    //   606: invokespecial 341	a/j/b/a/c/d/b/d:<init>	(La/j/b/a/c/k/i;La/j/b/a/c/b/y;La/j/b/a/c/j/a/j;La/j/b/a/c/d/b/f;La/j/b/a/c/d/b/c;La/j/b/a/c/d/a/c/g;La/j/b/a/c/b/aa;La/j/b/a/c/j/a/m;La/j/b/a/c/c/a/b;La/j/b/a/c/j/a/h;)V
    //   609: astore 7
    //   611: aload 11
    //   613: ldc_w 343
    //   616: invokestatic 56	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   619: aload 6
    //   621: aload 11
    //   623: putfield 347	a/j/b/a/c/d/a/c/l:Cfs	La/j/b/a/c/i/d/a;
    //   626: aload 7
    //   628: ldc_w 349
    //   631: invokestatic 56	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   634: aload 5
    //   636: aload 7
    //   638: getfield 353	a/j/b/a/c/d/b/d:CiZ	La/j/b/a/c/j/a/i;
    //   641: putfield 354	a/j/b/a/c/d/b/e:CiZ	La/j/b/a/c/j/a/i;
    //   644: aload_2
    //   645: getfield 358	a/j/b/a/c/a/g:BRP	La/j/b/a/c/b/c/v;
    //   648: astore_2
    //   649: aload_2
    //   650: ldc_w 360
    //   653: invokestatic 83	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   656: aload_3
    //   657: iconst_2
    //   658: anewarray 131	a/j/b/a/c/b/c/v
    //   661: dup
    //   662: iconst_0
    //   663: aload_3
    //   664: aastore
    //   665: dup
    //   666: iconst_1
    //   667: aload_2
    //   668: aastore
    //   669: invokevirtual 364	a/j/b/a/c/b/c/v:a	([La/j/b/a/c/b/c/v;)V
    //   672: aload_3
    //   673: aload 11
    //   675: getfield 368	a/j/b/a/c/i/d/a:CwS	La/j/b/a/c/d/a/c/g;
    //   678: checkcast 370	a/j/b/a/c/b/ac
    //   681: invokevirtual 373	a/j/b/a/c/b/c/v:a	(La/j/b/a/c/b/ac;)V
    //   684: new 78	a/j/b/a/b/i
    //   687: dup
    //   688: aload 7
    //   690: getfield 353	a/j/b/a/c/d/b/d:CiZ	La/j/b/a/c/j/a/i;
    //   693: aload 4
    //   695: iconst_0
    //   696: invokespecial 376	a/j/b/a/b/i:<init>	(La/j/b/a/c/j/a/i;La/j/b/a/b/j;B)V
    //   699: astore_2
    //   700: getstatic 41	a/j/b/a/y:BQi	Ljava/util/concurrent/ConcurrentMap;
    //   703: aload_0
    //   704: new 73	java/lang/ref/WeakReference
    //   707: dup
    //   708: aload_2
    //   709: invokespecial 377	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   712: invokeinterface 381 3 0
    //   717: checkcast 73	java/lang/ref/WeakReference
    //   720: astore_3
    //   721: aload_3
    //   722: ifnonnull +15 -> 737
    //   725: aload_0
    //   726: aconst_null
    //   727: putfield 385	a/j/b/a/ah:BQu	Ljava/lang/ClassLoader;
    //   730: ldc 48
    //   732: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   735: aload_2
    //   736: areturn
    //   737: aload_3
    //   738: invokevirtual 76	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   741: checkcast 78	a/j/b/a/b/i
    //   744: astore 4
    //   746: aload 4
    //   748: ifnull +16 -> 764
    //   751: aload_0
    //   752: aconst_null
    //   753: putfield 385	a/j/b/a/ah:BQu	Ljava/lang/ClassLoader;
    //   756: ldc 48
    //   758: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   761: aload 4
    //   763: areturn
    //   764: getstatic 41	a/j/b/a/y:BQi	Ljava/util/concurrent/ConcurrentMap;
    //   767: aload_0
    //   768: aload_3
    //   769: invokeinterface 87 3 0
    //   774: pop
    //   775: goto -75 -> 700
    //   778: astore_2
    //   779: aload_0
    //   780: aconst_null
    //   781: putfield 385	a/j/b/a/ah:BQu	Ljava/lang/ClassLoader;
    //   784: ldc 48
    //   786: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   789: aload_2
    //   790: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	paramClass	java.lang.Class<?>
    //   437	34	1	i	int
    //   39	697	2	localObject1	Object
    //   778	12	2	localObject2	Object
    //   51	718	3	localObject3	Object
    //   205	557	4	localObject4	Object
    //   185	450	5	locale	a.j.b.a.c.d.b.e
    //   194	426	6	locall	a.j.b.a.c.d.a.c.l
    //   228	461	7	localObject5	Object
    //   98	488	8	localObject6	Object
    //   176	418	9	localObject7	Object
    //   15	581	10	localObject8	Object
    //   210	464	11	localObject9	Object
    //   245	347	12	localObject10	Object
    //   252	336	13	localObject11	Object
    //   273	317	14	localObject12	Object
    //   278	322	15	localObject13	Object
    //   293	309	16	localObject14	Object
    //   579	1	17	locala	a.j.b.a.c.j.a.h.a
    // Exception table:
    //   from	to	target	type
    //   700	721	778	finally
    //   737	746	778	finally
    //   764	775	778	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.y
 * JD-Core Version:    0.7.0.1
 */