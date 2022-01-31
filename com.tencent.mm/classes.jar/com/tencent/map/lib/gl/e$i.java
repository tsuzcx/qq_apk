package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class e$i
  extends Thread
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private ArrayList<Runnable> q;
  private boolean r;
  private e.h s;
  private WeakReference<e> t;
  
  e$i(WeakReference<e> paramWeakReference)
  {
    AppMethodBeat.i(98075);
    this.q = new ArrayList();
    this.r = true;
    this.l = 0;
    this.m = 0;
    this.o = true;
    this.n = 1;
    this.t = paramWeakReference;
    AppMethodBeat.o(98075);
  }
  
  private void j()
  {
    AppMethodBeat.i(98077);
    if (this.i)
    {
      this.i = false;
      this.s.e();
    }
    AppMethodBeat.o(98077);
  }
  
  private void k()
  {
    AppMethodBeat.i(98078);
    if (this.h)
    {
      this.s.f();
      this.h = false;
      e.c().c(this);
    }
    AppMethodBeat.o(98078);
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 76	com/tencent/map/lib/gl/e$h
    //   9: dup
    //   10: aload_0
    //   11: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   14: invokespecial 98	com/tencent/map/lib/gl/e$h:<init>	(Ljava/lang/ref/WeakReference;)V
    //   17: putfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 81	com/tencent/map/lib/gl/e$i:h	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   30: iconst_0
    //   31: istore_3
    //   32: iconst_0
    //   33: istore 4
    //   35: iconst_0
    //   36: istore 6
    //   38: iconst_0
    //   39: istore_2
    //   40: iconst_0
    //   41: istore 5
    //   43: iconst_0
    //   44: istore 8
    //   46: iconst_0
    //   47: istore_1
    //   48: iconst_0
    //   49: istore 12
    //   51: iconst_0
    //   52: istore 9
    //   54: iconst_0
    //   55: istore 10
    //   57: aconst_null
    //   58: astore 22
    //   60: aconst_null
    //   61: astore 21
    //   63: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   66: astore 23
    //   68: aload 23
    //   70: monitorenter
    //   71: iload 12
    //   73: istore 7
    //   75: aload_0
    //   76: getfield 100	com/tencent/map/lib/gl/e$i:a	Z
    //   79: ifeq +71 -> 150
    //   82: aload_0
    //   83: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   86: invokevirtual 106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   89: checkcast 6	com/tencent/map/lib/gl/e
    //   92: astore 21
    //   94: aload 21
    //   96: ifnull +13 -> 109
    //   99: aload 21
    //   101: invokestatic 109	com/tencent/map/lib/gl/e:g	(Lcom/tencent/map/lib/gl/e;)Lcom/tencent/map/lib/gl/e$m;
    //   104: invokeinterface 113 1 0
    //   109: aload 23
    //   111: monitorexit
    //   112: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   115: astore 21
    //   117: aload 21
    //   119: monitorenter
    //   120: aload_0
    //   121: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   124: aload_0
    //   125: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   128: aload 21
    //   130: monitorexit
    //   131: ldc 96
    //   133: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: astore 22
    //   139: aload 21
    //   141: monitorexit
    //   142: ldc 96
    //   144: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload 22
    //   149: athrow
    //   150: aload_0
    //   151: getfield 49	com/tencent/map/lib/gl/e$i:q	Ljava/util/ArrayList;
    //   154: invokevirtual 120	java/util/ArrayList:isEmpty	()Z
    //   157: ifne +63 -> 220
    //   160: aload_0
    //   161: getfield 49	com/tencent/map/lib/gl/e$i:q	Ljava/util/ArrayList;
    //   164: iconst_0
    //   165: invokevirtual 124	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   168: checkcast 126	java/lang/Runnable
    //   171: astore 22
    //   173: iload 7
    //   175: istore 12
    //   177: iload 9
    //   179: istore 13
    //   181: iload 4
    //   183: istore 7
    //   185: iload_1
    //   186: istore 4
    //   188: aload 23
    //   190: monitorexit
    //   191: aload 22
    //   193: ifnull +619 -> 812
    //   196: aload 22
    //   198: invokeinterface 129 1 0
    //   203: aconst_null
    //   204: astore 22
    //   206: iload 4
    //   208: istore_1
    //   209: iload 7
    //   211: istore 4
    //   213: iload 13
    //   215: istore 9
    //   217: goto -154 -> 63
    //   220: aload_0
    //   221: getfield 131	com/tencent/map/lib/gl/e$i:d	Z
    //   224: aload_0
    //   225: getfield 133	com/tencent/map/lib/gl/e$i:c	Z
    //   228: if_icmpeq +1047 -> 1275
    //   231: aload_0
    //   232: getfield 133	com/tencent/map/lib/gl/e$i:c	Z
    //   235: istore 19
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 133	com/tencent/map/lib/gl/e$i:c	Z
    //   242: putfield 131	com/tencent/map/lib/gl/e$i:d	Z
    //   245: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   248: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   251: aload_0
    //   252: getfield 140	com/tencent/map/lib/gl/e$i:k	Z
    //   255: ifeq +19 -> 274
    //   258: aload_0
    //   259: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   262: aload_0
    //   263: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield 140	com/tencent/map/lib/gl/e$i:k	Z
    //   271: iconst_1
    //   272: istore 7
    //   274: iload_2
    //   275: istore 11
    //   277: iload_2
    //   278: ifeq +14 -> 292
    //   281: aload_0
    //   282: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   285: aload_0
    //   286: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   289: iconst_0
    //   290: istore 11
    //   292: iload 19
    //   294: ifeq +14 -> 308
    //   297: aload_0
    //   298: getfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   301: ifeq +7 -> 308
    //   304: aload_0
    //   305: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   308: iload 19
    //   310: ifeq +48 -> 358
    //   313: aload_0
    //   314: getfield 81	com/tencent/map/lib/gl/e$i:h	Z
    //   317: ifeq +41 -> 358
    //   320: aload_0
    //   321: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   324: invokevirtual 106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   327: checkcast 6	com/tencent/map/lib/gl/e
    //   330: astore 24
    //   332: aload 24
    //   334: ifnonnull +333 -> 667
    //   337: iconst_0
    //   338: istore 20
    //   340: iload 20
    //   342: ifeq +12 -> 354
    //   345: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   348: invokevirtual 142	com/tencent/map/lib/gl/e$j:a	()Z
    //   351: ifeq +7 -> 358
    //   354: aload_0
    //   355: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   358: iload 19
    //   360: ifeq +19 -> 379
    //   363: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   366: invokevirtual 144	com/tencent/map/lib/gl/e$j:b	()Z
    //   369: ifeq +10 -> 379
    //   372: aload_0
    //   373: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   376: invokevirtual 83	com/tencent/map/lib/gl/e$h:f	()V
    //   379: aload_0
    //   380: getfield 146	com/tencent/map/lib/gl/e$i:e	Z
    //   383: ifne +37 -> 420
    //   386: aload_0
    //   387: getfield 148	com/tencent/map/lib/gl/e$i:g	Z
    //   390: ifne +30 -> 420
    //   393: aload_0
    //   394: getfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   397: ifeq +7 -> 404
    //   400: aload_0
    //   401: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield 148	com/tencent/map/lib/gl/e$i:g	Z
    //   409: aload_0
    //   410: iconst_0
    //   411: putfield 150	com/tencent/map/lib/gl/e$i:f	Z
    //   414: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   417: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   420: aload_0
    //   421: getfield 146	com/tencent/map/lib/gl/e$i:e	Z
    //   424: ifeq +21 -> 445
    //   427: aload_0
    //   428: getfield 148	com/tencent/map/lib/gl/e$i:g	Z
    //   431: ifeq +14 -> 445
    //   434: aload_0
    //   435: iconst_0
    //   436: putfield 148	com/tencent/map/lib/gl/e$i:g	Z
    //   439: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   442: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   445: iload_1
    //   446: istore 12
    //   448: iload 8
    //   450: istore 13
    //   452: iload_1
    //   453: ifeq +20 -> 473
    //   456: iconst_0
    //   457: istore 13
    //   459: iconst_0
    //   460: istore 12
    //   462: aload_0
    //   463: iconst_1
    //   464: putfield 152	com/tencent/map/lib/gl/e$i:p	Z
    //   467: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   470: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   473: iload 4
    //   475: istore 18
    //   477: iload 7
    //   479: istore 14
    //   481: iload 5
    //   483: istore 17
    //   485: iload 6
    //   487: istore 15
    //   489: iload_3
    //   490: istore 16
    //   492: aload_0
    //   493: invokespecial 154	com/tencent/map/lib/gl/e$i:m	()Z
    //   496: ifeq +278 -> 774
    //   499: iload 7
    //   501: istore_2
    //   502: iload_3
    //   503: istore_1
    //   504: aload_0
    //   505: getfield 81	com/tencent/map/lib/gl/e$i:h	Z
    //   508: ifne +12 -> 520
    //   511: iload 7
    //   513: ifeq +164 -> 677
    //   516: iconst_0
    //   517: istore_2
    //   518: iload_3
    //   519: istore_1
    //   520: iload 4
    //   522: istore 8
    //   524: iload 5
    //   526: istore 7
    //   528: iload 6
    //   530: istore_3
    //   531: aload_0
    //   532: getfield 81	com/tencent/map/lib/gl/e$i:h	Z
    //   535: ifeq +34 -> 569
    //   538: iload 4
    //   540: istore 8
    //   542: iload 5
    //   544: istore 7
    //   546: iload 6
    //   548: istore_3
    //   549: aload_0
    //   550: getfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   553: ifne +16 -> 569
    //   556: aload_0
    //   557: iconst_1
    //   558: putfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   561: iconst_1
    //   562: istore 8
    //   564: iconst_1
    //   565: istore_3
    //   566: iconst_1
    //   567: istore 7
    //   569: iload 8
    //   571: istore 18
    //   573: iload_2
    //   574: istore 14
    //   576: iload 7
    //   578: istore 17
    //   580: iload_3
    //   581: istore 15
    //   583: iload_1
    //   584: istore 16
    //   586: aload_0
    //   587: getfield 72	com/tencent/map/lib/gl/e$i:i	Z
    //   590: ifeq +184 -> 774
    //   593: aload_0
    //   594: getfield 51	com/tencent/map/lib/gl/e$i:r	Z
    //   597: ifeq +659 -> 1256
    //   600: iconst_1
    //   601: istore 5
    //   603: aload_0
    //   604: getfield 53	com/tencent/map/lib/gl/e$i:l	I
    //   607: istore 9
    //   609: aload_0
    //   610: getfield 55	com/tencent/map/lib/gl/e$i:m	I
    //   613: istore 4
    //   615: iconst_1
    //   616: istore 8
    //   618: iconst_1
    //   619: istore 6
    //   621: aload_0
    //   622: iconst_0
    //   623: putfield 51	com/tencent/map/lib/gl/e$i:r	Z
    //   626: aload_0
    //   627: iconst_0
    //   628: putfield 57	com/tencent/map/lib/gl/e$i:o	Z
    //   631: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   634: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   637: iload 4
    //   639: istore 10
    //   641: iload 12
    //   643: istore 4
    //   645: iload 6
    //   647: istore 7
    //   649: iload 9
    //   651: istore 13
    //   653: iload_2
    //   654: istore 12
    //   656: iload 11
    //   658: istore_2
    //   659: iload_3
    //   660: istore 6
    //   662: iload_1
    //   663: istore_3
    //   664: goto -476 -> 188
    //   667: aload 24
    //   669: invokestatic 157	com/tencent/map/lib/gl/e:h	(Lcom/tencent/map/lib/gl/e;)Z
    //   672: istore 20
    //   674: goto -334 -> 340
    //   677: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   680: aload_0
    //   681: invokevirtual 160	com/tencent/map/lib/gl/e$j:b	(Lcom/tencent/map/lib/gl/e$i;)Z
    //   684: istore 19
    //   686: iload 7
    //   688: istore_2
    //   689: iload_3
    //   690: istore_1
    //   691: iload 19
    //   693: ifeq -173 -> 520
    //   696: aload_0
    //   697: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   700: invokevirtual 162	com/tencent/map/lib/gl/e$h:a	()V
    //   703: aload_0
    //   704: iconst_1
    //   705: putfield 81	com/tencent/map/lib/gl/e$i:h	Z
    //   708: iconst_1
    //   709: istore_1
    //   710: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   713: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   716: iload 7
    //   718: istore_2
    //   719: goto -199 -> 520
    //   722: astore 21
    //   724: aload 23
    //   726: monitorexit
    //   727: ldc 96
    //   729: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   732: aload 21
    //   734: athrow
    //   735: astore 21
    //   737: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   740: astore 21
    //   742: aload 21
    //   744: monitorenter
    //   745: aload_0
    //   746: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   749: aload_0
    //   750: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   753: aload 21
    //   755: monitorexit
    //   756: ldc 96
    //   758: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   761: return
    //   762: astore 24
    //   764: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   767: aload_0
    //   768: invokevirtual 91	com/tencent/map/lib/gl/e$j:c	(Lcom/tencent/map/lib/gl/e$i;)V
    //   771: goto -68 -> 703
    //   774: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   777: invokevirtual 165	java/lang/Object:wait	()V
    //   780: iload 12
    //   782: istore_1
    //   783: iload 18
    //   785: istore 4
    //   787: iload 14
    //   789: istore 7
    //   791: iload 13
    //   793: istore 8
    //   795: iload 17
    //   797: istore 5
    //   799: iload 11
    //   801: istore_2
    //   802: iload 15
    //   804: istore 6
    //   806: iload 16
    //   808: istore_3
    //   809: goto -734 -> 75
    //   812: iload 7
    //   814: istore 9
    //   816: iload 7
    //   818: ifeq +38 -> 856
    //   821: aload_0
    //   822: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   825: invokevirtual 166	com/tencent/map/lib/gl/e$h:b	()Z
    //   828: ifeq +326 -> 1154
    //   831: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   834: astore 23
    //   836: aload 23
    //   838: monitorenter
    //   839: aload_0
    //   840: iconst_1
    //   841: putfield 168	com/tencent/map/lib/gl/e$i:j	Z
    //   844: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   847: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   850: aload 23
    //   852: monitorexit
    //   853: iconst_0
    //   854: istore 9
    //   856: iload 6
    //   858: ifeq +395 -> 1253
    //   861: aload_0
    //   862: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   865: invokevirtual 171	com/tencent/map/lib/gl/e$h:c	()Ljavax/microedition/khronos/opengles/GL;
    //   868: checkcast 173	javax/microedition/khronos/opengles/GL10
    //   871: astore 21
    //   873: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   876: aload 21
    //   878: invokevirtual 176	com/tencent/map/lib/gl/e$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   881: iconst_0
    //   882: istore 6
    //   884: iload_3
    //   885: istore 7
    //   887: iload_3
    //   888: ifeq +42 -> 930
    //   891: aload_0
    //   892: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   895: invokevirtual 106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   898: checkcast 6	com/tencent/map/lib/gl/e
    //   901: astore 23
    //   903: aload 23
    //   905: ifnull +388 -> 1293
    //   908: aload 23
    //   910: invokestatic 109	com/tencent/map/lib/gl/e:g	(Lcom/tencent/map/lib/gl/e;)Lcom/tencent/map/lib/gl/e$m;
    //   913: aload 21
    //   915: aload_0
    //   916: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   919: getfield 179	com/tencent/map/lib/gl/e$h:d	Ljavax/microedition/khronos/egl/EGLConfig;
    //   922: invokeinterface 182 3 0
    //   927: goto +366 -> 1293
    //   930: iload 5
    //   932: istore_3
    //   933: iload 5
    //   935: ifeq +39 -> 974
    //   938: aload_0
    //   939: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   942: invokevirtual 106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   945: checkcast 6	com/tencent/map/lib/gl/e
    //   948: astore 23
    //   950: aload 23
    //   952: ifnull +347 -> 1299
    //   955: aload 23
    //   957: invokestatic 109	com/tencent/map/lib/gl/e:g	(Lcom/tencent/map/lib/gl/e;)Lcom/tencent/map/lib/gl/e$m;
    //   960: aload 21
    //   962: iload 13
    //   964: iload 10
    //   966: invokeinterface 185 4 0
    //   971: goto +328 -> 1299
    //   974: aload_0
    //   975: getfield 61	com/tencent/map/lib/gl/e$i:t	Ljava/lang/ref/WeakReference;
    //   978: invokevirtual 106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   981: checkcast 6	com/tencent/map/lib/gl/e
    //   984: astore 23
    //   986: aload 23
    //   988: ifnull +299 -> 1287
    //   991: aload 23
    //   993: invokestatic 109	com/tencent/map/lib/gl/e:g	(Lcom/tencent/map/lib/gl/e;)Lcom/tencent/map/lib/gl/e$m;
    //   996: aload 21
    //   998: invokeinterface 188 2 0
    //   1003: istore 19
    //   1005: iload_2
    //   1006: istore 11
    //   1008: iload 19
    //   1010: ifeq +75 -> 1085
    //   1013: aload_0
    //   1014: getfield 74	com/tencent/map/lib/gl/e$i:s	Lcom/tencent/map/lib/gl/e$h;
    //   1017: invokevirtual 191	com/tencent/map/lib/gl/e$h:d	()I
    //   1020: istore_1
    //   1021: iload_2
    //   1022: istore 11
    //   1024: iload_1
    //   1025: lookupswitch	default:+279->1304, 12288:+60->1085, 12302:+183->1208
    //   1053: instanceof 4803
    //   1056: iload_1
    //   1057: invokestatic 198	com/tencent/map/lib/gl/e$h:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1060: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   1063: astore 23
    //   1065: aload 23
    //   1067: monitorenter
    //   1068: aload_0
    //   1069: iconst_1
    //   1070: putfield 150	com/tencent/map/lib/gl/e$i:f	Z
    //   1073: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   1076: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   1079: aload 23
    //   1081: monitorexit
    //   1082: iload_2
    //   1083: istore 11
    //   1085: iload 8
    //   1087: ifeq +194 -> 1281
    //   1090: iconst_1
    //   1091: istore_1
    //   1092: iload 9
    //   1094: istore 4
    //   1096: iload 13
    //   1098: istore 9
    //   1100: iload_3
    //   1101: istore 5
    //   1103: iload 11
    //   1105: istore_2
    //   1106: iload 7
    //   1108: istore_3
    //   1109: goto -1046 -> 63
    //   1112: astore 21
    //   1114: aload 23
    //   1116: monitorexit
    //   1117: ldc 96
    //   1119: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: aload 21
    //   1124: athrow
    //   1125: astore 22
    //   1127: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   1130: astore 21
    //   1132: aload 21
    //   1134: monitorenter
    //   1135: aload_0
    //   1136: invokespecial 114	com/tencent/map/lib/gl/e$i:j	()V
    //   1139: aload_0
    //   1140: invokespecial 116	com/tencent/map/lib/gl/e$i:k	()V
    //   1143: aload 21
    //   1145: monitorexit
    //   1146: ldc 96
    //   1148: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1151: aload 22
    //   1153: athrow
    //   1154: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   1157: astore 23
    //   1159: aload 23
    //   1161: monitorenter
    //   1162: aload_0
    //   1163: iconst_1
    //   1164: putfield 168	com/tencent/map/lib/gl/e$i:j	Z
    //   1167: aload_0
    //   1168: iconst_1
    //   1169: putfield 150	com/tencent/map/lib/gl/e$i:f	Z
    //   1172: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   1175: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   1178: aload 23
    //   1180: monitorexit
    //   1181: iload 4
    //   1183: istore_1
    //   1184: iload 7
    //   1186: istore 4
    //   1188: iload 13
    //   1190: istore 9
    //   1192: goto -1129 -> 63
    //   1195: astore 21
    //   1197: aload 23
    //   1199: monitorexit
    //   1200: ldc 96
    //   1202: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1205: aload 21
    //   1207: athrow
    //   1208: iconst_1
    //   1209: istore 11
    //   1211: goto -126 -> 1085
    //   1214: astore 21
    //   1216: aload 23
    //   1218: monitorexit
    //   1219: ldc 96
    //   1221: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1224: aload 21
    //   1226: athrow
    //   1227: astore 22
    //   1229: aload 21
    //   1231: monitorexit
    //   1232: ldc 96
    //   1234: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1237: aload 22
    //   1239: athrow
    //   1240: astore 22
    //   1242: aload 21
    //   1244: monitorexit
    //   1245: ldc 96
    //   1247: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1250: aload 22
    //   1252: athrow
    //   1253: goto -369 -> 884
    //   1256: iload 10
    //   1258: istore 4
    //   1260: iload 8
    //   1262: istore 6
    //   1264: iload 13
    //   1266: istore 8
    //   1268: iload 7
    //   1270: istore 5
    //   1272: goto -646 -> 626
    //   1275: iconst_0
    //   1276: istore 19
    //   1278: goto -1027 -> 251
    //   1281: iload 4
    //   1283: istore_1
    //   1284: goto -192 -> 1092
    //   1287: iconst_0
    //   1288: istore 19
    //   1290: goto -285 -> 1005
    //   1293: iconst_0
    //   1294: istore 7
    //   1296: goto -366 -> 930
    //   1299: iconst_0
    //   1300: istore_3
    //   1301: goto -327 -> 974
    //   1304: goto -252 -> 1052
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1307	0	this	i
    //   47	1237	1	i1	int
    //   39	1067	2	i2	int
    //   31	1270	3	i3	int
    //   33	1249	4	i4	int
    //   41	1230	5	i5	int
    //   36	1227	6	i6	int
    //   73	1222	7	i7	int
    //   44	1223	8	i8	int
    //   52	1139	9	i9	int
    //   55	1202	10	i10	int
    //   275	935	11	i11	int
    //   49	732	12	i12	int
    //   179	1086	13	i13	int
    //   479	309	14	i14	int
    //   487	316	15	i15	int
    //   490	317	16	i16	int
    //   483	313	17	i17	int
    //   475	309	18	i18	int
    //   235	1054	19	bool1	boolean
    //   338	335	20	bool2	boolean
    //   61	79	21	localObject1	Object
    //   722	11	21	localObject2	Object
    //   735	1	21	localException	java.lang.Exception
    //   1112	11	21	localObject4	Object
    //   1195	11	21	localObject5	Object
    //   1214	29	21	localObject6	Object
    //   58	1	22	localObject7	Object
    //   137	11	22	localObject8	Object
    //   171	34	22	localRunnable	Runnable
    //   1125	27	22	localObject9	Object
    //   1227	11	22	localObject10	Object
    //   1240	11	22	localObject11	Object
    //   330	338	24	locale	e
    //   762	1	24	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   120	131	137	finally
    //   139	142	137	finally
    //   75	94	722	finally
    //   99	109	722	finally
    //   109	112	722	finally
    //   150	173	722	finally
    //   188	191	722	finally
    //   220	251	722	finally
    //   251	271	722	finally
    //   281	289	722	finally
    //   297	308	722	finally
    //   313	332	722	finally
    //   345	354	722	finally
    //   354	358	722	finally
    //   363	379	722	finally
    //   379	404	722	finally
    //   404	420	722	finally
    //   420	445	722	finally
    //   462	473	722	finally
    //   492	499	722	finally
    //   504	511	722	finally
    //   531	538	722	finally
    //   549	561	722	finally
    //   586	600	722	finally
    //   603	615	722	finally
    //   621	626	722	finally
    //   626	637	722	finally
    //   667	674	722	finally
    //   677	686	722	finally
    //   696	703	722	finally
    //   703	708	722	finally
    //   710	716	722	finally
    //   724	727	722	finally
    //   764	771	722	finally
    //   774	780	722	finally
    //   63	71	735	java/lang/Exception
    //   196	203	735	java/lang/Exception
    //   727	735	735	java/lang/Exception
    //   821	839	735	java/lang/Exception
    //   861	881	735	java/lang/Exception
    //   891	903	735	java/lang/Exception
    //   908	927	735	java/lang/Exception
    //   938	950	735	java/lang/Exception
    //   955	971	735	java/lang/Exception
    //   974	986	735	java/lang/Exception
    //   991	1005	735	java/lang/Exception
    //   1013	1021	735	java/lang/Exception
    //   1052	1068	735	java/lang/Exception
    //   1117	1125	735	java/lang/Exception
    //   1154	1162	735	java/lang/Exception
    //   1200	1208	735	java/lang/Exception
    //   1219	1227	735	java/lang/Exception
    //   696	703	762	java/lang/RuntimeException
    //   839	853	1112	finally
    //   1114	1117	1112	finally
    //   63	71	1125	finally
    //   196	203	1125	finally
    //   727	735	1125	finally
    //   821	839	1125	finally
    //   861	881	1125	finally
    //   891	903	1125	finally
    //   908	927	1125	finally
    //   938	950	1125	finally
    //   955	971	1125	finally
    //   974	986	1125	finally
    //   991	1005	1125	finally
    //   1013	1021	1125	finally
    //   1052	1068	1125	finally
    //   1117	1125	1125	finally
    //   1154	1162	1125	finally
    //   1200	1208	1125	finally
    //   1219	1227	1125	finally
    //   1162	1181	1195	finally
    //   1197	1200	1195	finally
    //   1068	1082	1214	finally
    //   1216	1219	1214	finally
    //   745	756	1227	finally
    //   1229	1232	1227	finally
    //   1135	1146	1240	finally
    //   1242	1245	1240	finally
  }
  
  private boolean m()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0) && ((this.o) || (this.n == 1));
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(98081);
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(98081);
      throw ((Throwable)???);
    }
    synchronized (e.c())
    {
      this.n = paramInt;
      e.c().notifyAll();
      AppMethodBeat.o(98081);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98088);
    synchronized (e.c())
    {
      this.l = paramInt1;
      this.m = paramInt2;
      this.r = true;
      this.o = true;
      this.p = false;
      e.c().notifyAll();
      for (;;)
      {
        if ((!this.b) && (!this.d) && (!this.p))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              e.c().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(98088);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(98080);
    if ((this.h) && (this.i) && (m()))
    {
      AppMethodBeat.o(98080);
      return true;
    }
    AppMethodBeat.o(98080);
    return false;
  }
  
  public int b()
  {
    AppMethodBeat.i(98082);
    synchronized (e.c())
    {
      int i1 = this.n;
      AppMethodBeat.o(98082);
      return i1;
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(98083);
    synchronized (e.c())
    {
      this.o = true;
      e.c().notifyAll();
      AppMethodBeat.o(98083);
      return;
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(98084);
    synchronized (e.c())
    {
      this.e = true;
      this.j = false;
      e.c().notifyAll();
      for (;;)
      {
        if ((this.g) && (!this.j))
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              e.c().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(98084);
  }
  
  public void e()
  {
    AppMethodBeat.i(98085);
    synchronized (e.c())
    {
      this.e = false;
      e.c().notifyAll();
      for (;;)
      {
        if (!this.g)
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              e.c().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(98085);
  }
  
  public void f()
  {
    AppMethodBeat.i(98086);
    synchronized (e.c())
    {
      this.c = true;
      e.c().notifyAll();
      for (;;)
      {
        if (!this.b)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              e.c().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(98086);
  }
  
  public void g()
  {
    AppMethodBeat.i(98087);
    synchronized (e.c())
    {
      this.c = false;
      this.o = true;
      this.p = false;
      e.c().notifyAll();
      for (;;)
      {
        if ((!this.b) && (this.d))
        {
          boolean bool = this.p;
          if (!bool) {
            try
            {
              e.c().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(98087);
  }
  
  public void h()
  {
    AppMethodBeat.i(98089);
    synchronized (e.c())
    {
      this.a = true;
      e.c().notifyAll();
      for (;;)
      {
        boolean bool = this.b;
        if (!bool) {
          try
          {
            e.c().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(98089);
  }
  
  public void i()
  {
    AppMethodBeat.i(98090);
    this.k = true;
    e.c().notifyAll();
    AppMethodBeat.o(98090);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 230	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 232
    //   12: invokespecial 233	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 237	com/tencent/map/lib/gl/e$i:getId	()J
    //   19: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 248	com/tencent/map/lib/gl/e$i:setName	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokespecial 250	com/tencent/map/lib/gl/e$i:l	()V
    //   32: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   35: aload_0
    //   36: invokevirtual 252	com/tencent/map/lib/gl/e$j:a	(Lcom/tencent/map/lib/gl/e$i;)V
    //   39: ldc 228
    //   41: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_1
    //   46: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   49: aload_0
    //   50: invokevirtual 252	com/tencent/map/lib/gl/e$j:a	(Lcom/tencent/map/lib/gl/e$i;)V
    //   53: ldc 228
    //   55: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_1
    //   60: invokestatic 86	com/tencent/map/lib/gl/e:c	()Lcom/tencent/map/lib/gl/e$j;
    //   63: aload_0
    //   64: invokevirtual 252	com/tencent/map/lib/gl/e$j:a	(Lcom/tencent/map/lib/gl/e$i;)V
    //   67: ldc 228
    //   69: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	i
    //   45	1	1	localInterruptedException	InterruptedException
    //   59	14	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	32	45	java/lang/InterruptedException
    //   28	32	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.gl.e.i
 * JD-Core Version:    0.7.0.1
 */