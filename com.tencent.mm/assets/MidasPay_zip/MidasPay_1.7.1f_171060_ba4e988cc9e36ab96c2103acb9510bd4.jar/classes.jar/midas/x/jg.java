package midas.x;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

class jg
  implements jk
{
  private final ArrayList<jf> a = new ArrayList();
  private final jm b;
  
  jg(jm paramjm)
  {
    this.b = paramjm;
  }
  
  private jo a(jn paramjn)
  {
    jo localjo = new jo();
    if (paramjn == null) {
      return localjo;
    }
    localjo.a(paramjn);
    paramjn.d = System.currentTimeMillis();
    int i;
    if (this.b != null)
    {
      i = this.b.c();
      if (i > 5) {
        i = 5;
      } else if (i >= 0) {}
    }
    else
    {
      i = 0;
    }
    int j = paramjn.k;
    if (j > 5) {
      i = 5;
    } else if (j >= 0) {
      i = j;
    }
    boolean bool;
    if (i <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    localjo = a(paramjn, bool);
    if ((localjo != null) && (localjo.d())) {
      return localjo;
    }
    int k;
    for (j = 0; j < i; j = k)
    {
      k = j + 1;
      paramjn.i = k;
      a(paramjn.i, i, paramjn, localjo);
      if (j == i - 1) {
        bool = true;
      } else {
        bool = false;
      }
      localjo = a(paramjn, bool);
      if ((localjo != null) && (localjo.d())) {
        return localjo;
      }
    }
    return localjo;
  }
  
  /* Error */
  private jo a(jn paramjn, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 27	midas/x/jo
    //   3: dup
    //   4: invokespecial 28	midas/x/jo:<init>	()V
    //   7: astore 18
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload 18
    //   15: areturn
    //   16: aload 18
    //   18: aload_1
    //   19: invokevirtual 31	midas/x/jo:a	(Lmidas/x/jn;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 75	midas/x/jg:b	(Lmidas/x/jn;)V
    //   27: aload_1
    //   28: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   31: putfield 78	midas/x/jn:e	J
    //   34: aload_1
    //   35: invokevirtual 81	midas/x/jn:f	()V
    //   38: aload_1
    //   39: invokevirtual 85	midas/x/jn:s	()Ljava/lang/String;
    //   42: astore 7
    //   44: aload 7
    //   46: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: istore 4
    //   51: iload 4
    //   53: ifeq +521 -> 574
    //   56: aload_0
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   62: aload_1
    //   63: aconst_null
    //   64: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   67: aload_1
    //   68: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   71: aload_1
    //   72: getfield 78	midas/x/jn:e	J
    //   75: lsub
    //   76: putfield 100	midas/x/jn:f	J
    //   79: iload_2
    //   80: ifeq +19 -> 99
    //   83: aload 18
    //   85: getfield 102	midas/x/jo:a	I
    //   88: sipush 200
    //   91: if_icmpeq +8 -> 99
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 106	midas/x/jn:j	Z
    //   99: aload_0
    //   100: aload_1
    //   101: aload 18
    //   103: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   106: aload 7
    //   108: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifeq +41 -> 152
    //   114: new 111	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   121: astore 8
    //   123: aload 8
    //   125: ldc 114
    //   127: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 8
    //   133: aload 7
    //   135: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 120
    //   141: aload 8
    //   143: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto +38 -> 187
    //   152: new 111	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   159: astore 8
    //   161: aload 8
    //   163: ldc 114
    //   165: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 8
    //   171: aload 7
    //   173: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 120
    //   179: aload 8
    //   181: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: ldc 132
    //   189: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: ifeq +41 -> 233
    //   195: new 111	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   202: astore 7
    //   204: aload 7
    //   206: ldc 134
    //   208: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 7
    //   214: ldc 132
    //   216: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: ldc 120
    //   222: aload 7
    //   224: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto +38 -> 268
    //   233: new 111	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   240: astore 7
    //   242: aload 7
    //   244: ldc 134
    //   246: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 7
    //   252: ldc 132
    //   254: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 120
    //   260: aload 7
    //   262: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 18
    //   270: getfield 102	midas/x/jo:a	I
    //   273: sipush 200
    //   276: if_icmpeq +44 -> 320
    //   279: new 111	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   286: astore 7
    //   288: aload 7
    //   290: ldc 136
    //   292: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 7
    //   298: aload 18
    //   300: getfield 102	midas/x/jo:a	I
    //   303: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 120
    //   309: aload 7
    //   311: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: goto +41 -> 358
    //   320: new 111	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   327: astore 7
    //   329: aload 7
    //   331: ldc 136
    //   333: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: aload 18
    //   341: getfield 102	midas/x/jo:a	I
    //   344: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 120
    //   350: aload 7
    //   352: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 18
    //   360: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   363: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifeq +44 -> 410
    //   369: new 111	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   376: astore 7
    //   378: aload 7
    //   380: ldc 144
    //   382: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 7
    //   388: aload 18
    //   390: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   393: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 120
    //   399: aload 7
    //   401: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: goto +41 -> 448
    //   410: new 111	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   417: astore 7
    //   419: aload 7
    //   421: ldc 144
    //   423: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 7
    //   429: aload 18
    //   431: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   434: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: ldc 120
    //   440: aload 7
    //   442: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload 18
    //   450: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   453: ifnonnull +62 -> 515
    //   456: new 111	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   463: astore 7
    //   465: aload 7
    //   467: ldc 149
    //   469: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 7
    //   475: aload 18
    //   477: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   480: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 7
    //   486: ldc 154
    //   488: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 7
    //   494: aload_1
    //   495: invokevirtual 157	midas/x/jn:x	()Z
    //   498: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: ldc 120
    //   504: aload 7
    //   506: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload 18
    //   514: areturn
    //   515: new 111	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   522: astore 7
    //   524: aload 7
    //   526: ldc 149
    //   528: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 7
    //   534: aload 18
    //   536: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   539: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 7
    //   545: ldc 154
    //   547: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 7
    //   553: aload_1
    //   554: invokevirtual 157	midas/x/jn:x	()Z
    //   557: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: ldc 120
    //   563: aload 7
    //   565: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload 18
    //   573: areturn
    //   574: new 162	java/net/URL
    //   577: dup
    //   578: aload 7
    //   580: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   583: invokevirtual 169	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   586: astore 8
    //   588: aload 8
    //   590: ifnonnull +521 -> 1111
    //   593: aload_0
    //   594: aconst_null
    //   595: aconst_null
    //   596: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   599: aload_1
    //   600: aconst_null
    //   601: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   604: aload_1
    //   605: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   608: aload_1
    //   609: getfield 78	midas/x/jn:e	J
    //   612: lsub
    //   613: putfield 100	midas/x/jn:f	J
    //   616: iload_2
    //   617: ifeq +19 -> 636
    //   620: aload 18
    //   622: getfield 102	midas/x/jo:a	I
    //   625: sipush 200
    //   628: if_icmpeq +8 -> 636
    //   631: aload_1
    //   632: iconst_1
    //   633: putfield 106	midas/x/jn:j	Z
    //   636: aload_0
    //   637: aload_1
    //   638: aload 18
    //   640: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   643: aload 7
    //   645: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   648: ifeq +41 -> 689
    //   651: new 111	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   658: astore 8
    //   660: aload 8
    //   662: ldc 114
    //   664: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 8
    //   670: aload 7
    //   672: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 120
    //   678: aload 8
    //   680: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: goto +38 -> 724
    //   689: new 111	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   696: astore 8
    //   698: aload 8
    //   700: ldc 114
    //   702: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 8
    //   708: aload 7
    //   710: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: ldc 120
    //   716: aload 8
    //   718: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: ldc 132
    //   726: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +41 -> 770
    //   732: new 111	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   739: astore 7
    //   741: aload 7
    //   743: ldc 134
    //   745: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 7
    //   751: ldc 132
    //   753: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: ldc 120
    //   759: aload 7
    //   761: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: goto +38 -> 805
    //   770: new 111	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   777: astore 7
    //   779: aload 7
    //   781: ldc 134
    //   783: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 7
    //   789: ldc 132
    //   791: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: ldc 120
    //   797: aload 7
    //   799: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload 18
    //   807: getfield 102	midas/x/jo:a	I
    //   810: sipush 200
    //   813: if_icmpeq +44 -> 857
    //   816: new 111	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   823: astore 7
    //   825: aload 7
    //   827: ldc 136
    //   829: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload 7
    //   835: aload 18
    //   837: getfield 102	midas/x/jo:a	I
    //   840: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: ldc 120
    //   846: aload 7
    //   848: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: goto +41 -> 895
    //   857: new 111	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   864: astore 7
    //   866: aload 7
    //   868: ldc 136
    //   870: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 7
    //   876: aload 18
    //   878: getfield 102	midas/x/jo:a	I
    //   881: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: ldc 120
    //   887: aload 7
    //   889: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: aload 18
    //   897: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   900: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   903: ifeq +44 -> 947
    //   906: new 111	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   913: astore 7
    //   915: aload 7
    //   917: ldc 144
    //   919: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 7
    //   925: aload 18
    //   927: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   930: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: ldc 120
    //   936: aload 7
    //   938: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   944: goto +41 -> 985
    //   947: new 111	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   954: astore 7
    //   956: aload 7
    //   958: ldc 144
    //   960: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 7
    //   966: aload 18
    //   968: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   971: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: ldc 120
    //   977: aload 7
    //   979: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   985: aload 18
    //   987: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   990: ifnonnull +62 -> 1052
    //   993: new 111	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1000: astore 7
    //   1002: aload 7
    //   1004: ldc 149
    //   1006: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload 7
    //   1012: aload 18
    //   1014: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   1017: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 7
    //   1023: ldc 154
    //   1025: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload 7
    //   1031: aload_1
    //   1032: invokevirtual 157	midas/x/jn:x	()Z
    //   1035: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: ldc 120
    //   1041: aload 7
    //   1043: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1049: aload 18
    //   1051: areturn
    //   1052: new 111	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1059: astore 7
    //   1061: aload 7
    //   1063: ldc 149
    //   1065: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload 7
    //   1071: aload 18
    //   1073: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   1076: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload 7
    //   1082: ldc 154
    //   1084: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 7
    //   1090: aload_1
    //   1091: invokevirtual 157	midas/x/jn:x	()Z
    //   1094: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: ldc 120
    //   1100: aload 7
    //   1102: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1108: aload 18
    //   1110: areturn
    //   1111: aload 8
    //   1113: instanceof 171
    //   1116: istore 4
    //   1118: iload 4
    //   1120: ifne +521 -> 1641
    //   1123: aload_0
    //   1124: aconst_null
    //   1125: aconst_null
    //   1126: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1129: aload_1
    //   1130: aconst_null
    //   1131: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   1134: aload_1
    //   1135: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   1138: aload_1
    //   1139: getfield 78	midas/x/jn:e	J
    //   1142: lsub
    //   1143: putfield 100	midas/x/jn:f	J
    //   1146: iload_2
    //   1147: ifeq +19 -> 1166
    //   1150: aload 18
    //   1152: getfield 102	midas/x/jo:a	I
    //   1155: sipush 200
    //   1158: if_icmpeq +8 -> 1166
    //   1161: aload_1
    //   1162: iconst_1
    //   1163: putfield 106	midas/x/jn:j	Z
    //   1166: aload_0
    //   1167: aload_1
    //   1168: aload 18
    //   1170: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   1173: aload 7
    //   1175: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1178: ifeq +41 -> 1219
    //   1181: new 111	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1188: astore 8
    //   1190: aload 8
    //   1192: ldc 114
    //   1194: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 8
    //   1200: aload 7
    //   1202: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: ldc 120
    //   1208: aload 8
    //   1210: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1216: goto +38 -> 1254
    //   1219: new 111	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1226: astore 8
    //   1228: aload 8
    //   1230: ldc 114
    //   1232: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: pop
    //   1236: aload 8
    //   1238: aload 7
    //   1240: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: ldc 120
    //   1246: aload 8
    //   1248: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1254: ldc 132
    //   1256: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1259: ifeq +41 -> 1300
    //   1262: new 111	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1269: astore 7
    //   1271: aload 7
    //   1273: ldc 134
    //   1275: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: aload 7
    //   1281: ldc 132
    //   1283: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: ldc 120
    //   1289: aload 7
    //   1291: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1297: goto +38 -> 1335
    //   1300: new 111	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1307: astore 7
    //   1309: aload 7
    //   1311: ldc 134
    //   1313: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload 7
    //   1319: ldc 132
    //   1321: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: ldc 120
    //   1327: aload 7
    //   1329: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1332: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1335: aload 18
    //   1337: getfield 102	midas/x/jo:a	I
    //   1340: sipush 200
    //   1343: if_icmpeq +44 -> 1387
    //   1346: new 111	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1353: astore 7
    //   1355: aload 7
    //   1357: ldc 136
    //   1359: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: pop
    //   1363: aload 7
    //   1365: aload 18
    //   1367: getfield 102	midas/x/jo:a	I
    //   1370: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: ldc 120
    //   1376: aload 7
    //   1378: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1384: goto +41 -> 1425
    //   1387: new 111	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1394: astore 7
    //   1396: aload 7
    //   1398: ldc 136
    //   1400: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload 7
    //   1406: aload 18
    //   1408: getfield 102	midas/x/jo:a	I
    //   1411: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: ldc 120
    //   1417: aload 7
    //   1419: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1422: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1425: aload 18
    //   1427: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   1430: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1433: ifeq +44 -> 1477
    //   1436: new 111	java/lang/StringBuilder
    //   1439: dup
    //   1440: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1443: astore 7
    //   1445: aload 7
    //   1447: ldc 144
    //   1449: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload 7
    //   1455: aload 18
    //   1457: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   1460: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: ldc 120
    //   1466: aload 7
    //   1468: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1474: goto +41 -> 1515
    //   1477: new 111	java/lang/StringBuilder
    //   1480: dup
    //   1481: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1484: astore 7
    //   1486: aload 7
    //   1488: ldc 144
    //   1490: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 7
    //   1496: aload 18
    //   1498: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   1501: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: ldc 120
    //   1507: aload 7
    //   1509: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1512: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1515: aload 18
    //   1517: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   1520: ifnonnull +62 -> 1582
    //   1523: new 111	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1530: astore 7
    //   1532: aload 7
    //   1534: ldc 149
    //   1536: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: pop
    //   1540: aload 7
    //   1542: aload 18
    //   1544: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   1547: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: aload 7
    //   1553: ldc 154
    //   1555: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 7
    //   1561: aload_1
    //   1562: invokevirtual 157	midas/x/jn:x	()Z
    //   1565: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: ldc 120
    //   1571: aload 7
    //   1573: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1579: aload 18
    //   1581: areturn
    //   1582: new 111	java/lang/StringBuilder
    //   1585: dup
    //   1586: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1589: astore 7
    //   1591: aload 7
    //   1593: ldc 149
    //   1595: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: pop
    //   1599: aload 7
    //   1601: aload 18
    //   1603: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   1606: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1609: pop
    //   1610: aload 7
    //   1612: ldc 154
    //   1614: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 7
    //   1620: aload_1
    //   1621: invokevirtual 157	midas/x/jn:x	()Z
    //   1624: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1627: pop
    //   1628: ldc 120
    //   1630: aload 7
    //   1632: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1638: aload 18
    //   1640: areturn
    //   1641: aload 8
    //   1643: checkcast 171	java/net/HttpURLConnection
    //   1646: astore 9
    //   1648: aload_1
    //   1649: aload 9
    //   1651: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   1654: aload 9
    //   1656: iconst_0
    //   1657: invokevirtual 175	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1660: aload 9
    //   1662: iconst_0
    //   1663: invokevirtual 178	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1666: aload_0
    //   1667: aload 9
    //   1669: aload_1
    //   1670: invokespecial 181	midas/x/jg:c	(Ljava/net/HttpURLConnection;Lmidas/x/jn;)V
    //   1673: aload 9
    //   1675: aload_1
    //   1676: invokestatic 183	midas/x/jg:b	(Ljava/net/HttpURLConnection;Lmidas/x/jn;)V
    //   1679: aload_0
    //   1680: aload 9
    //   1682: aload_1
    //   1683: invokespecial 185	midas/x/jg:a	(Ljava/net/HttpURLConnection;Lmidas/x/jn;)V
    //   1686: aload 9
    //   1688: iconst_1
    //   1689: invokevirtual 188	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1692: aload_1
    //   1693: invokevirtual 190	midas/x/jn:k	()Ljava/lang/String;
    //   1696: astore 8
    //   1698: aload_1
    //   1699: invokevirtual 193	midas/x/jn:o	()Z
    //   1702: ifeq +696 -> 2398
    //   1705: aload 9
    //   1707: ldc 195
    //   1709: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1712: aload 9
    //   1714: iconst_1
    //   1715: invokevirtual 201	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1718: aload_1
    //   1719: invokevirtual 204	midas/x/jn:r	()Z
    //   1722: ifeq +691 -> 2413
    //   1725: aload 8
    //   1727: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1730: ifne +683 -> 2413
    //   1733: aload 8
    //   1735: ldc 206
    //   1737: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1740: astore 10
    //   1742: aload 10
    //   1744: arraylength
    //   1745: istore_3
    //   1746: aload 9
    //   1748: ldc 214
    //   1750: iload_3
    //   1751: invokestatic 218	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1754: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1757: aload 9
    //   1759: iload_3
    //   1760: invokevirtual 225	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   1763: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   1766: lstore 5
    //   1768: aload_1
    //   1769: invokevirtual 157	midas/x/jn:x	()Z
    //   1772: ifeq +538 -> 2310
    //   1775: ldc 120
    //   1777: ldc 227
    //   1779: invokestatic 229	midas/x/jh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1782: aload_0
    //   1783: aconst_null
    //   1784: aconst_null
    //   1785: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1788: aload 9
    //   1790: ifnull +8 -> 1798
    //   1793: aload 9
    //   1795: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   1798: aload_1
    //   1799: aconst_null
    //   1800: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   1803: aload_1
    //   1804: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   1807: aload_1
    //   1808: getfield 78	midas/x/jn:e	J
    //   1811: lsub
    //   1812: putfield 100	midas/x/jn:f	J
    //   1815: iload_2
    //   1816: ifeq +19 -> 1835
    //   1819: aload 18
    //   1821: getfield 102	midas/x/jo:a	I
    //   1824: sipush 200
    //   1827: if_icmpeq +8 -> 1835
    //   1830: aload_1
    //   1831: iconst_1
    //   1832: putfield 106	midas/x/jn:j	Z
    //   1835: aload_0
    //   1836: aload_1
    //   1837: aload 18
    //   1839: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   1842: aload 7
    //   1844: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1847: ifeq +41 -> 1888
    //   1850: new 111	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1857: astore 9
    //   1859: aload 9
    //   1861: ldc 114
    //   1863: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 9
    //   1869: aload 7
    //   1871: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: pop
    //   1875: ldc 120
    //   1877: aload 9
    //   1879: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1885: goto +38 -> 1923
    //   1888: new 111	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1895: astore 9
    //   1897: aload 9
    //   1899: ldc 114
    //   1901: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: pop
    //   1905: aload 9
    //   1907: aload 7
    //   1909: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: pop
    //   1913: ldc 120
    //   1915: aload 9
    //   1917: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1920: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1923: aload 8
    //   1925: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1928: ifeq +41 -> 1969
    //   1931: new 111	java/lang/StringBuilder
    //   1934: dup
    //   1935: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1938: astore 7
    //   1940: aload 7
    //   1942: ldc 134
    //   1944: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: pop
    //   1948: aload 7
    //   1950: aload 8
    //   1952: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: ldc 120
    //   1958: aload 7
    //   1960: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1963: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1966: goto +38 -> 2004
    //   1969: new 111	java/lang/StringBuilder
    //   1972: dup
    //   1973: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1976: astore 7
    //   1978: aload 7
    //   1980: ldc 134
    //   1982: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: pop
    //   1986: aload 7
    //   1988: aload 8
    //   1990: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: pop
    //   1994: ldc 120
    //   1996: aload 7
    //   1998: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2001: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2004: aload 18
    //   2006: getfield 102	midas/x/jo:a	I
    //   2009: sipush 200
    //   2012: if_icmpeq +44 -> 2056
    //   2015: new 111	java/lang/StringBuilder
    //   2018: dup
    //   2019: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2022: astore 7
    //   2024: aload 7
    //   2026: ldc 136
    //   2028: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: pop
    //   2032: aload 7
    //   2034: aload 18
    //   2036: getfield 102	midas/x/jo:a	I
    //   2039: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2042: pop
    //   2043: ldc 120
    //   2045: aload 7
    //   2047: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2050: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2053: goto +41 -> 2094
    //   2056: new 111	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2063: astore 7
    //   2065: aload 7
    //   2067: ldc 136
    //   2069: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 7
    //   2075: aload 18
    //   2077: getfield 102	midas/x/jo:a	I
    //   2080: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: ldc 120
    //   2086: aload 7
    //   2088: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2091: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2094: aload 18
    //   2096: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2099: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2102: ifeq +44 -> 2146
    //   2105: new 111	java/lang/StringBuilder
    //   2108: dup
    //   2109: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2112: astore 7
    //   2114: aload 7
    //   2116: ldc 144
    //   2118: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2121: pop
    //   2122: aload 7
    //   2124: aload 18
    //   2126: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2129: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: pop
    //   2133: ldc 120
    //   2135: aload 7
    //   2137: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2143: goto +41 -> 2184
    //   2146: new 111	java/lang/StringBuilder
    //   2149: dup
    //   2150: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2153: astore 7
    //   2155: aload 7
    //   2157: ldc 144
    //   2159: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: pop
    //   2163: aload 7
    //   2165: aload 18
    //   2167: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2170: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: pop
    //   2174: ldc 120
    //   2176: aload 7
    //   2178: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2181: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2184: aload 18
    //   2186: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2189: ifnonnull +62 -> 2251
    //   2192: new 111	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2199: astore 7
    //   2201: aload 7
    //   2203: ldc 149
    //   2205: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: pop
    //   2209: aload 7
    //   2211: aload 18
    //   2213: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2216: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2219: pop
    //   2220: aload 7
    //   2222: ldc 154
    //   2224: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: pop
    //   2228: aload 7
    //   2230: aload_1
    //   2231: invokevirtual 157	midas/x/jn:x	()Z
    //   2234: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2237: pop
    //   2238: ldc 120
    //   2240: aload 7
    //   2242: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2245: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2248: aload 18
    //   2250: areturn
    //   2251: new 111	java/lang/StringBuilder
    //   2254: dup
    //   2255: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2258: astore 7
    //   2260: aload 7
    //   2262: ldc 149
    //   2264: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2267: pop
    //   2268: aload 7
    //   2270: aload 18
    //   2272: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2275: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2278: pop
    //   2279: aload 7
    //   2281: ldc 154
    //   2283: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2286: pop
    //   2287: aload 7
    //   2289: aload_1
    //   2290: invokevirtual 157	midas/x/jn:x	()Z
    //   2293: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2296: pop
    //   2297: ldc 120
    //   2299: aload 7
    //   2301: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2304: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2307: aload 18
    //   2309: areturn
    //   2310: new 234	java/io/DataOutputStream
    //   2313: dup
    //   2314: aload 9
    //   2316: invokevirtual 238	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   2319: invokespecial 241	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2322: astore 11
    //   2324: aload 11
    //   2326: aload 10
    //   2328: invokevirtual 245	java/io/DataOutputStream:write	([B)V
    //   2331: aload_1
    //   2332: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   2335: lload 5
    //   2337: lsub
    //   2338: putfield 248	midas/x/jn:g	J
    //   2341: aload 11
    //   2343: invokevirtual 251	java/io/DataOutputStream:flush	()V
    //   2346: aload 11
    //   2348: invokevirtual 254	java/io/DataOutputStream:close	()V
    //   2351: goto +62 -> 2413
    //   2354: astore 10
    //   2356: new 111	java/lang/StringBuilder
    //   2359: dup
    //   2360: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2363: astore 11
    //   2365: aload 11
    //   2367: ldc_w 256
    //   2370: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: pop
    //   2374: aload 11
    //   2376: aload 10
    //   2378: invokevirtual 259	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2381: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: pop
    //   2385: ldc 120
    //   2387: aload 11
    //   2389: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2392: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2395: goto +18 -> 2413
    //   2398: aload_1
    //   2399: invokevirtual 262	midas/x/jn:q	()Z
    //   2402: ifeq +11 -> 2413
    //   2405: aload 9
    //   2407: ldc_w 264
    //   2410: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   2413: aload_1
    //   2414: invokevirtual 157	midas/x/jn:x	()Z
    //   2417: ifeq +539 -> 2956
    //   2420: ldc 120
    //   2422: ldc_w 266
    //   2425: invokestatic 229	midas/x/jh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2428: aload_0
    //   2429: aconst_null
    //   2430: aconst_null
    //   2431: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   2434: aload 9
    //   2436: ifnull +8 -> 2444
    //   2439: aload 9
    //   2441: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   2444: aload_1
    //   2445: aconst_null
    //   2446: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   2449: aload_1
    //   2450: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   2453: aload_1
    //   2454: getfield 78	midas/x/jn:e	J
    //   2457: lsub
    //   2458: putfield 100	midas/x/jn:f	J
    //   2461: iload_2
    //   2462: ifeq +19 -> 2481
    //   2465: aload 18
    //   2467: getfield 102	midas/x/jo:a	I
    //   2470: sipush 200
    //   2473: if_icmpeq +8 -> 2481
    //   2476: aload_1
    //   2477: iconst_1
    //   2478: putfield 106	midas/x/jn:j	Z
    //   2481: aload_0
    //   2482: aload_1
    //   2483: aload 18
    //   2485: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   2488: aload 7
    //   2490: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2493: ifeq +41 -> 2534
    //   2496: new 111	java/lang/StringBuilder
    //   2499: dup
    //   2500: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2503: astore 9
    //   2505: aload 9
    //   2507: ldc 114
    //   2509: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2512: pop
    //   2513: aload 9
    //   2515: aload 7
    //   2517: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: pop
    //   2521: ldc 120
    //   2523: aload 9
    //   2525: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2528: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2531: goto +38 -> 2569
    //   2534: new 111	java/lang/StringBuilder
    //   2537: dup
    //   2538: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2541: astore 9
    //   2543: aload 9
    //   2545: ldc 114
    //   2547: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: pop
    //   2551: aload 9
    //   2553: aload 7
    //   2555: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: pop
    //   2559: ldc 120
    //   2561: aload 9
    //   2563: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2569: aload 8
    //   2571: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2574: ifeq +41 -> 2615
    //   2577: new 111	java/lang/StringBuilder
    //   2580: dup
    //   2581: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2584: astore 7
    //   2586: aload 7
    //   2588: ldc 134
    //   2590: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: pop
    //   2594: aload 7
    //   2596: aload 8
    //   2598: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: pop
    //   2602: ldc 120
    //   2604: aload 7
    //   2606: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2609: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2612: goto +38 -> 2650
    //   2615: new 111	java/lang/StringBuilder
    //   2618: dup
    //   2619: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2622: astore 7
    //   2624: aload 7
    //   2626: ldc 134
    //   2628: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2631: pop
    //   2632: aload 7
    //   2634: aload 8
    //   2636: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2639: pop
    //   2640: ldc 120
    //   2642: aload 7
    //   2644: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2647: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2650: aload 18
    //   2652: getfield 102	midas/x/jo:a	I
    //   2655: sipush 200
    //   2658: if_icmpeq +44 -> 2702
    //   2661: new 111	java/lang/StringBuilder
    //   2664: dup
    //   2665: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2668: astore 7
    //   2670: aload 7
    //   2672: ldc 136
    //   2674: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2677: pop
    //   2678: aload 7
    //   2680: aload 18
    //   2682: getfield 102	midas/x/jo:a	I
    //   2685: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2688: pop
    //   2689: ldc 120
    //   2691: aload 7
    //   2693: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2696: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2699: goto +41 -> 2740
    //   2702: new 111	java/lang/StringBuilder
    //   2705: dup
    //   2706: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2709: astore 7
    //   2711: aload 7
    //   2713: ldc 136
    //   2715: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: pop
    //   2719: aload 7
    //   2721: aload 18
    //   2723: getfield 102	midas/x/jo:a	I
    //   2726: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2729: pop
    //   2730: ldc 120
    //   2732: aload 7
    //   2734: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2737: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2740: aload 18
    //   2742: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2745: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2748: ifeq +44 -> 2792
    //   2751: new 111	java/lang/StringBuilder
    //   2754: dup
    //   2755: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2758: astore 7
    //   2760: aload 7
    //   2762: ldc 144
    //   2764: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: pop
    //   2768: aload 7
    //   2770: aload 18
    //   2772: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2775: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2778: pop
    //   2779: ldc 120
    //   2781: aload 7
    //   2783: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2786: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2789: goto +41 -> 2830
    //   2792: new 111	java/lang/StringBuilder
    //   2795: dup
    //   2796: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2799: astore 7
    //   2801: aload 7
    //   2803: ldc 144
    //   2805: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: pop
    //   2809: aload 7
    //   2811: aload 18
    //   2813: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   2816: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: pop
    //   2820: ldc 120
    //   2822: aload 7
    //   2824: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2827: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2830: aload 18
    //   2832: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2835: ifnonnull +62 -> 2897
    //   2838: new 111	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2845: astore 7
    //   2847: aload 7
    //   2849: ldc 149
    //   2851: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2854: pop
    //   2855: aload 7
    //   2857: aload 18
    //   2859: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2862: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2865: pop
    //   2866: aload 7
    //   2868: ldc 154
    //   2870: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: pop
    //   2874: aload 7
    //   2876: aload_1
    //   2877: invokevirtual 157	midas/x/jn:x	()Z
    //   2880: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2883: pop
    //   2884: ldc 120
    //   2886: aload 7
    //   2888: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2891: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2894: aload 18
    //   2896: areturn
    //   2897: new 111	java/lang/StringBuilder
    //   2900: dup
    //   2901: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   2904: astore 7
    //   2906: aload 7
    //   2908: ldc 149
    //   2910: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2913: pop
    //   2914: aload 7
    //   2916: aload 18
    //   2918: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   2921: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2924: pop
    //   2925: aload 7
    //   2927: ldc 154
    //   2929: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2932: pop
    //   2933: aload 7
    //   2935: aload_1
    //   2936: invokevirtual 157	midas/x/jn:x	()Z
    //   2939: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2942: pop
    //   2943: ldc 120
    //   2945: aload 7
    //   2947: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2950: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2953: aload 18
    //   2955: areturn
    //   2956: aload 9
    //   2958: invokevirtual 269	java/net/HttpURLConnection:getResponseCode	()I
    //   2961: istore_3
    //   2962: aload 18
    //   2964: iload_3
    //   2965: putfield 102	midas/x/jo:a	I
    //   2968: iload_3
    //   2969: sipush 200
    //   2972: if_icmpne +770 -> 3742
    //   2975: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   2978: lstore 5
    //   2980: aload_1
    //   2981: invokevirtual 157	midas/x/jn:x	()Z
    //   2984: ifeq +539 -> 3523
    //   2987: ldc 120
    //   2989: ldc_w 271
    //   2992: invokestatic 229	midas/x/jh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2995: aload_0
    //   2996: aconst_null
    //   2997: aconst_null
    //   2998: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   3001: aload 9
    //   3003: ifnull +8 -> 3011
    //   3006: aload 9
    //   3008: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   3011: aload_1
    //   3012: aconst_null
    //   3013: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   3016: aload_1
    //   3017: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   3020: aload_1
    //   3021: getfield 78	midas/x/jn:e	J
    //   3024: lsub
    //   3025: putfield 100	midas/x/jn:f	J
    //   3028: iload_2
    //   3029: ifeq +19 -> 3048
    //   3032: aload 18
    //   3034: getfield 102	midas/x/jo:a	I
    //   3037: sipush 200
    //   3040: if_icmpeq +8 -> 3048
    //   3043: aload_1
    //   3044: iconst_1
    //   3045: putfield 106	midas/x/jn:j	Z
    //   3048: aload_0
    //   3049: aload_1
    //   3050: aload 18
    //   3052: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   3055: aload 7
    //   3057: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3060: ifeq +41 -> 3101
    //   3063: new 111	java/lang/StringBuilder
    //   3066: dup
    //   3067: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3070: astore 9
    //   3072: aload 9
    //   3074: ldc 114
    //   3076: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: pop
    //   3080: aload 9
    //   3082: aload 7
    //   3084: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3087: pop
    //   3088: ldc 120
    //   3090: aload 9
    //   3092: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3095: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3098: goto +38 -> 3136
    //   3101: new 111	java/lang/StringBuilder
    //   3104: dup
    //   3105: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3108: astore 9
    //   3110: aload 9
    //   3112: ldc 114
    //   3114: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3117: pop
    //   3118: aload 9
    //   3120: aload 7
    //   3122: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3125: pop
    //   3126: ldc 120
    //   3128: aload 9
    //   3130: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3133: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3136: aload 8
    //   3138: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3141: ifeq +41 -> 3182
    //   3144: new 111	java/lang/StringBuilder
    //   3147: dup
    //   3148: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3151: astore 7
    //   3153: aload 7
    //   3155: ldc 134
    //   3157: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: pop
    //   3161: aload 7
    //   3163: aload 8
    //   3165: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: pop
    //   3169: ldc 120
    //   3171: aload 7
    //   3173: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3176: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3179: goto +38 -> 3217
    //   3182: new 111	java/lang/StringBuilder
    //   3185: dup
    //   3186: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3189: astore 7
    //   3191: aload 7
    //   3193: ldc 134
    //   3195: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3198: pop
    //   3199: aload 7
    //   3201: aload 8
    //   3203: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3206: pop
    //   3207: ldc 120
    //   3209: aload 7
    //   3211: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3214: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3217: aload 18
    //   3219: getfield 102	midas/x/jo:a	I
    //   3222: sipush 200
    //   3225: if_icmpeq +44 -> 3269
    //   3228: new 111	java/lang/StringBuilder
    //   3231: dup
    //   3232: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3235: astore 7
    //   3237: aload 7
    //   3239: ldc 136
    //   3241: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: pop
    //   3245: aload 7
    //   3247: aload 18
    //   3249: getfield 102	midas/x/jo:a	I
    //   3252: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3255: pop
    //   3256: ldc 120
    //   3258: aload 7
    //   3260: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3263: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3266: goto +41 -> 3307
    //   3269: new 111	java/lang/StringBuilder
    //   3272: dup
    //   3273: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3276: astore 7
    //   3278: aload 7
    //   3280: ldc 136
    //   3282: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3285: pop
    //   3286: aload 7
    //   3288: aload 18
    //   3290: getfield 102	midas/x/jo:a	I
    //   3293: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3296: pop
    //   3297: ldc 120
    //   3299: aload 7
    //   3301: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3304: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3307: aload 18
    //   3309: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   3312: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3315: ifeq +44 -> 3359
    //   3318: new 111	java/lang/StringBuilder
    //   3321: dup
    //   3322: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3325: astore 7
    //   3327: aload 7
    //   3329: ldc 144
    //   3331: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: pop
    //   3335: aload 7
    //   3337: aload 18
    //   3339: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   3342: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: pop
    //   3346: ldc 120
    //   3348: aload 7
    //   3350: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3353: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3356: goto +41 -> 3397
    //   3359: new 111	java/lang/StringBuilder
    //   3362: dup
    //   3363: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3366: astore 7
    //   3368: aload 7
    //   3370: ldc 144
    //   3372: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: pop
    //   3376: aload 7
    //   3378: aload 18
    //   3380: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   3383: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3386: pop
    //   3387: ldc 120
    //   3389: aload 7
    //   3391: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3394: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3397: aload 18
    //   3399: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   3402: ifnonnull +62 -> 3464
    //   3405: new 111	java/lang/StringBuilder
    //   3408: dup
    //   3409: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3412: astore 7
    //   3414: aload 7
    //   3416: ldc 149
    //   3418: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: pop
    //   3422: aload 7
    //   3424: aload 18
    //   3426: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   3429: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3432: pop
    //   3433: aload 7
    //   3435: ldc 154
    //   3437: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: pop
    //   3441: aload 7
    //   3443: aload_1
    //   3444: invokevirtual 157	midas/x/jn:x	()Z
    //   3447: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3450: pop
    //   3451: ldc 120
    //   3453: aload 7
    //   3455: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3458: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3461: aload 18
    //   3463: areturn
    //   3464: new 111	java/lang/StringBuilder
    //   3467: dup
    //   3468: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3471: astore 7
    //   3473: aload 7
    //   3475: ldc 149
    //   3477: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: pop
    //   3481: aload 7
    //   3483: aload 18
    //   3485: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   3488: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3491: pop
    //   3492: aload 7
    //   3494: ldc 154
    //   3496: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3499: pop
    //   3500: aload 7
    //   3502: aload_1
    //   3503: invokevirtual 157	midas/x/jn:x	()Z
    //   3506: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3509: pop
    //   3510: ldc 120
    //   3512: aload 7
    //   3514: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3517: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3520: aload 18
    //   3522: areturn
    //   3523: aload 9
    //   3525: invokevirtual 275	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3528: astore 10
    //   3530: aload_1
    //   3531: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   3534: lload 5
    //   3536: lsub
    //   3537: putfield 278	midas/x/jn:h	J
    //   3540: new 280	java/io/ByteArrayOutputStream
    //   3543: dup
    //   3544: invokespecial 281	java/io/ByteArrayOutputStream:<init>	()V
    //   3547: astore 15
    //   3549: aload 9
    //   3551: astore 11
    //   3553: aload 10
    //   3555: astore 12
    //   3557: aload 7
    //   3559: astore 13
    //   3561: aload 8
    //   3563: astore 14
    //   3565: aload 15
    //   3567: astore 16
    //   3569: sipush 1024
    //   3572: newarray byte
    //   3574: astore 17
    //   3576: aload 9
    //   3578: astore 11
    //   3580: aload 10
    //   3582: astore 12
    //   3584: aload 7
    //   3586: astore 13
    //   3588: aload 8
    //   3590: astore 14
    //   3592: aload 15
    //   3594: astore 16
    //   3596: aload 10
    //   3598: aload 17
    //   3600: invokevirtual 287	java/io/InputStream:read	([B)I
    //   3603: istore_3
    //   3604: iload_3
    //   3605: ifle +35 -> 3640
    //   3608: aload 9
    //   3610: astore 11
    //   3612: aload 10
    //   3614: astore 12
    //   3616: aload 7
    //   3618: astore 13
    //   3620: aload 8
    //   3622: astore 14
    //   3624: aload 15
    //   3626: astore 16
    //   3628: aload 15
    //   3630: aload 17
    //   3632: iconst_0
    //   3633: iload_3
    //   3634: invokevirtual 290	java/io/ByteArrayOutputStream:write	([BII)V
    //   3637: goto -61 -> 3576
    //   3640: aload 9
    //   3642: astore 11
    //   3644: aload 10
    //   3646: astore 12
    //   3648: aload 7
    //   3650: astore 13
    //   3652: aload 8
    //   3654: astore 14
    //   3656: aload 15
    //   3658: astore 16
    //   3660: aload 18
    //   3662: new 208	java/lang/String
    //   3665: dup
    //   3666: aload 15
    //   3668: invokevirtual 294	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3671: ldc 206
    //   3673: invokespecial 297	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3676: putfield 142	midas/x/jo:b	Ljava/lang/String;
    //   3679: goto +70 -> 3749
    //   3682: astore 17
    //   3684: goto +637 -> 4321
    //   3687: astore 17
    //   3689: goto +1139 -> 4828
    //   3692: astore 17
    //   3694: goto +1641 -> 5335
    //   3697: astore 17
    //   3699: goto +2143 -> 5842
    //   3702: astore 11
    //   3704: aconst_null
    //   3705: astore 16
    //   3707: goto +2739 -> 6446
    //   3710: astore 17
    //   3712: aconst_null
    //   3713: astore 15
    //   3715: goto +606 -> 4321
    //   3718: astore 17
    //   3720: aconst_null
    //   3721: astore 15
    //   3723: goto +1105 -> 4828
    //   3726: astore 17
    //   3728: aconst_null
    //   3729: astore 15
    //   3731: goto +1604 -> 5335
    //   3734: astore 17
    //   3736: aconst_null
    //   3737: astore 15
    //   3739: goto +2103 -> 5842
    //   3742: aconst_null
    //   3743: astore 10
    //   3745: aload 10
    //   3747: astore 15
    //   3749: aload_0
    //   3750: aload 10
    //   3752: aload 15
    //   3754: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   3757: aload 9
    //   3759: ifnull +8 -> 3767
    //   3762: aload 9
    //   3764: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   3767: aload_1
    //   3768: aconst_null
    //   3769: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   3772: aload_1
    //   3773: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   3776: aload_1
    //   3777: getfield 78	midas/x/jn:e	J
    //   3780: lsub
    //   3781: putfield 100	midas/x/jn:f	J
    //   3784: iload_2
    //   3785: ifeq +19 -> 3804
    //   3788: aload 18
    //   3790: getfield 102	midas/x/jo:a	I
    //   3793: sipush 200
    //   3796: if_icmpeq +8 -> 3804
    //   3799: aload_1
    //   3800: iconst_1
    //   3801: putfield 106	midas/x/jn:j	Z
    //   3804: aload_0
    //   3805: aload_1
    //   3806: aload 18
    //   3808: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   3811: aload 7
    //   3813: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3816: ifeq +41 -> 3857
    //   3819: new 111	java/lang/StringBuilder
    //   3822: dup
    //   3823: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3826: astore 9
    //   3828: aload 9
    //   3830: ldc 114
    //   3832: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3835: pop
    //   3836: aload 9
    //   3838: aload 7
    //   3840: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3843: pop
    //   3844: ldc 120
    //   3846: aload 9
    //   3848: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3851: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3854: goto +38 -> 3892
    //   3857: new 111	java/lang/StringBuilder
    //   3860: dup
    //   3861: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3864: astore 9
    //   3866: aload 9
    //   3868: ldc 114
    //   3870: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3873: pop
    //   3874: aload 9
    //   3876: aload 7
    //   3878: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3881: pop
    //   3882: ldc 120
    //   3884: aload 9
    //   3886: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3889: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3892: aload 8
    //   3894: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3897: ifeq +41 -> 3938
    //   3900: new 111	java/lang/StringBuilder
    //   3903: dup
    //   3904: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3907: astore 7
    //   3909: aload 7
    //   3911: ldc 134
    //   3913: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3916: pop
    //   3917: aload 7
    //   3919: aload 8
    //   3921: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3924: pop
    //   3925: ldc 120
    //   3927: aload 7
    //   3929: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3932: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3935: goto +38 -> 3973
    //   3938: new 111	java/lang/StringBuilder
    //   3941: dup
    //   3942: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3945: astore 7
    //   3947: aload 7
    //   3949: ldc 134
    //   3951: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3954: pop
    //   3955: aload 7
    //   3957: aload 8
    //   3959: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3962: pop
    //   3963: ldc 120
    //   3965: aload 7
    //   3967: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3970: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3973: aload 18
    //   3975: getfield 102	midas/x/jo:a	I
    //   3978: sipush 200
    //   3981: if_icmpeq +44 -> 4025
    //   3984: new 111	java/lang/StringBuilder
    //   3987: dup
    //   3988: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   3991: astore 7
    //   3993: aload 7
    //   3995: ldc 136
    //   3997: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4000: pop
    //   4001: aload 7
    //   4003: aload 18
    //   4005: getfield 102	midas/x/jo:a	I
    //   4008: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4011: pop
    //   4012: ldc 120
    //   4014: aload 7
    //   4016: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4019: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4022: goto +41 -> 4063
    //   4025: new 111	java/lang/StringBuilder
    //   4028: dup
    //   4029: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4032: astore 7
    //   4034: aload 7
    //   4036: ldc 136
    //   4038: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4041: pop
    //   4042: aload 7
    //   4044: aload 18
    //   4046: getfield 102	midas/x/jo:a	I
    //   4049: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4052: pop
    //   4053: ldc 120
    //   4055: aload 7
    //   4057: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4060: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4063: aload 18
    //   4065: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4068: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4071: ifeq +44 -> 4115
    //   4074: new 111	java/lang/StringBuilder
    //   4077: dup
    //   4078: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4081: astore 7
    //   4083: aload 7
    //   4085: ldc 144
    //   4087: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4090: pop
    //   4091: aload 7
    //   4093: aload 18
    //   4095: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4098: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: pop
    //   4102: ldc 120
    //   4104: aload 7
    //   4106: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4109: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4112: goto +41 -> 4153
    //   4115: new 111	java/lang/StringBuilder
    //   4118: dup
    //   4119: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4122: astore 7
    //   4124: aload 7
    //   4126: ldc 144
    //   4128: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload 7
    //   4134: aload 18
    //   4136: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4139: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4142: pop
    //   4143: ldc 120
    //   4145: aload 7
    //   4147: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4150: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4153: aload 18
    //   4155: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   4158: ifnonnull +15 -> 4173
    //   4161: new 111	java/lang/StringBuilder
    //   4164: dup
    //   4165: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4168: astore 7
    //   4170: goto +2145 -> 6315
    //   4173: new 111	java/lang/StringBuilder
    //   4176: dup
    //   4177: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4180: astore 7
    //   4182: goto +2192 -> 6374
    //   4185: astore 11
    //   4187: goto +29 -> 4216
    //   4190: astore 17
    //   4192: goto +33 -> 4225
    //   4195: astore 17
    //   4197: goto +37 -> 4234
    //   4200: astore 17
    //   4202: goto +41 -> 4243
    //   4205: astore 17
    //   4207: goto +45 -> 4252
    //   4210: astore 11
    //   4212: ldc 132
    //   4214: astore 8
    //   4216: goto +77 -> 4293
    //   4219: astore 17
    //   4221: ldc 132
    //   4223: astore 8
    //   4225: goto +90 -> 4315
    //   4228: astore 17
    //   4230: ldc 132
    //   4232: astore 8
    //   4234: goto +588 -> 4822
    //   4237: astore 17
    //   4239: ldc 132
    //   4241: astore 8
    //   4243: goto +1086 -> 5329
    //   4246: astore 17
    //   4248: ldc 132
    //   4250: astore 8
    //   4252: goto +1584 -> 5836
    //   4255: astore 11
    //   4257: goto +29 -> 4286
    //   4260: astore 17
    //   4262: goto +46 -> 4308
    //   4265: astore 17
    //   4267: goto +548 -> 4815
    //   4270: astore 17
    //   4272: goto +1050 -> 5322
    //   4275: astore 17
    //   4277: goto +1552 -> 5829
    //   4280: astore 11
    //   4282: ldc 132
    //   4284: astore 7
    //   4286: ldc 132
    //   4288: astore 8
    //   4290: aconst_null
    //   4291: astore 9
    //   4293: aconst_null
    //   4294: astore 10
    //   4296: aconst_null
    //   4297: astore 16
    //   4299: goto +2147 -> 6446
    //   4302: astore 17
    //   4304: ldc 132
    //   4306: astore 7
    //   4308: ldc 132
    //   4310: astore 8
    //   4312: aconst_null
    //   4313: astore 9
    //   4315: aconst_null
    //   4316: astore 10
    //   4318: aconst_null
    //   4319: astore 15
    //   4321: aload 9
    //   4323: astore 11
    //   4325: aload 10
    //   4327: astore 12
    //   4329: aload 7
    //   4331: astore 13
    //   4333: aload 8
    //   4335: astore 14
    //   4337: aload 15
    //   4339: astore 16
    //   4341: aload 17
    //   4343: invokevirtual 300	java/lang/Exception:printStackTrace	()V
    //   4346: aload 9
    //   4348: astore 11
    //   4350: aload 10
    //   4352: astore 12
    //   4354: aload 7
    //   4356: astore 13
    //   4358: aload 8
    //   4360: astore 14
    //   4362: aload 15
    //   4364: astore 16
    //   4366: aload 18
    //   4368: aload 17
    //   4370: putfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   4373: aload_0
    //   4374: aload 10
    //   4376: aload 15
    //   4378: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   4381: aload 9
    //   4383: ifnull +8 -> 4391
    //   4386: aload 9
    //   4388: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   4391: aload_1
    //   4392: aconst_null
    //   4393: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   4396: aload_1
    //   4397: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   4400: aload_1
    //   4401: getfield 78	midas/x/jn:e	J
    //   4404: lsub
    //   4405: putfield 100	midas/x/jn:f	J
    //   4408: iload_2
    //   4409: ifeq +19 -> 4428
    //   4412: aload 18
    //   4414: getfield 102	midas/x/jo:a	I
    //   4417: sipush 200
    //   4420: if_icmpeq +8 -> 4428
    //   4423: aload_1
    //   4424: iconst_1
    //   4425: putfield 106	midas/x/jn:j	Z
    //   4428: aload_0
    //   4429: aload_1
    //   4430: aload 18
    //   4432: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   4435: aload 7
    //   4437: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4440: ifeq +41 -> 4481
    //   4443: new 111	java/lang/StringBuilder
    //   4446: dup
    //   4447: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4450: astore 9
    //   4452: aload 9
    //   4454: ldc 114
    //   4456: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4459: pop
    //   4460: aload 9
    //   4462: aload 7
    //   4464: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4467: pop
    //   4468: ldc 120
    //   4470: aload 9
    //   4472: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4475: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4478: goto +38 -> 4516
    //   4481: new 111	java/lang/StringBuilder
    //   4484: dup
    //   4485: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4488: astore 9
    //   4490: aload 9
    //   4492: ldc 114
    //   4494: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4497: pop
    //   4498: aload 9
    //   4500: aload 7
    //   4502: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4505: pop
    //   4506: ldc 120
    //   4508: aload 9
    //   4510: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4513: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4516: aload 8
    //   4518: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4521: ifeq +41 -> 4562
    //   4524: new 111	java/lang/StringBuilder
    //   4527: dup
    //   4528: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4531: astore 7
    //   4533: aload 7
    //   4535: ldc 134
    //   4537: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4540: pop
    //   4541: aload 7
    //   4543: aload 8
    //   4545: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4548: pop
    //   4549: ldc 120
    //   4551: aload 7
    //   4553: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4556: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4559: goto +38 -> 4597
    //   4562: new 111	java/lang/StringBuilder
    //   4565: dup
    //   4566: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4569: astore 7
    //   4571: aload 7
    //   4573: ldc 134
    //   4575: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4578: pop
    //   4579: aload 7
    //   4581: aload 8
    //   4583: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4586: pop
    //   4587: ldc 120
    //   4589: aload 7
    //   4591: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4594: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4597: aload 18
    //   4599: getfield 102	midas/x/jo:a	I
    //   4602: sipush 200
    //   4605: if_icmpeq +44 -> 4649
    //   4608: new 111	java/lang/StringBuilder
    //   4611: dup
    //   4612: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4615: astore 7
    //   4617: aload 7
    //   4619: ldc 136
    //   4621: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4624: pop
    //   4625: aload 7
    //   4627: aload 18
    //   4629: getfield 102	midas/x/jo:a	I
    //   4632: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4635: pop
    //   4636: ldc 120
    //   4638: aload 7
    //   4640: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4643: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4646: goto +41 -> 4687
    //   4649: new 111	java/lang/StringBuilder
    //   4652: dup
    //   4653: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4656: astore 7
    //   4658: aload 7
    //   4660: ldc 136
    //   4662: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4665: pop
    //   4666: aload 7
    //   4668: aload 18
    //   4670: getfield 102	midas/x/jo:a	I
    //   4673: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4676: pop
    //   4677: ldc 120
    //   4679: aload 7
    //   4681: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4684: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4687: aload 18
    //   4689: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4692: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4695: ifeq +44 -> 4739
    //   4698: new 111	java/lang/StringBuilder
    //   4701: dup
    //   4702: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4705: astore 7
    //   4707: aload 7
    //   4709: ldc 144
    //   4711: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4714: pop
    //   4715: aload 7
    //   4717: aload 18
    //   4719: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4722: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4725: pop
    //   4726: ldc 120
    //   4728: aload 7
    //   4730: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4733: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4736: goto +41 -> 4777
    //   4739: new 111	java/lang/StringBuilder
    //   4742: dup
    //   4743: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4746: astore 7
    //   4748: aload 7
    //   4750: ldc 144
    //   4752: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4755: pop
    //   4756: aload 7
    //   4758: aload 18
    //   4760: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   4763: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: pop
    //   4767: ldc 120
    //   4769: aload 7
    //   4771: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4774: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4777: aload 18
    //   4779: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   4782: ifnonnull +15 -> 4797
    //   4785: new 111	java/lang/StringBuilder
    //   4788: dup
    //   4789: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4792: astore 7
    //   4794: goto +1521 -> 6315
    //   4797: new 111	java/lang/StringBuilder
    //   4800: dup
    //   4801: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4804: astore 7
    //   4806: goto +1568 -> 6374
    //   4809: astore 17
    //   4811: ldc 132
    //   4813: astore 7
    //   4815: ldc 132
    //   4817: astore 8
    //   4819: aconst_null
    //   4820: astore 9
    //   4822: aconst_null
    //   4823: astore 10
    //   4825: aconst_null
    //   4826: astore 15
    //   4828: aload 9
    //   4830: astore 11
    //   4832: aload 10
    //   4834: astore 12
    //   4836: aload 7
    //   4838: astore 13
    //   4840: aload 8
    //   4842: astore 14
    //   4844: aload 15
    //   4846: astore 16
    //   4848: aload 17
    //   4850: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   4853: aload 9
    //   4855: astore 11
    //   4857: aload 10
    //   4859: astore 12
    //   4861: aload 7
    //   4863: astore 13
    //   4865: aload 8
    //   4867: astore 14
    //   4869: aload 15
    //   4871: astore 16
    //   4873: aload 18
    //   4875: aload 17
    //   4877: putfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   4880: aload_0
    //   4881: aload 10
    //   4883: aload 15
    //   4885: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   4888: aload 9
    //   4890: ifnull +8 -> 4898
    //   4893: aload 9
    //   4895: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   4898: aload_1
    //   4899: aconst_null
    //   4900: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   4903: aload_1
    //   4904: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   4907: aload_1
    //   4908: getfield 78	midas/x/jn:e	J
    //   4911: lsub
    //   4912: putfield 100	midas/x/jn:f	J
    //   4915: iload_2
    //   4916: ifeq +19 -> 4935
    //   4919: aload 18
    //   4921: getfield 102	midas/x/jo:a	I
    //   4924: sipush 200
    //   4927: if_icmpeq +8 -> 4935
    //   4930: aload_1
    //   4931: iconst_1
    //   4932: putfield 106	midas/x/jn:j	Z
    //   4935: aload_0
    //   4936: aload_1
    //   4937: aload 18
    //   4939: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   4942: aload 7
    //   4944: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4947: ifeq +41 -> 4988
    //   4950: new 111	java/lang/StringBuilder
    //   4953: dup
    //   4954: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4957: astore 9
    //   4959: aload 9
    //   4961: ldc 114
    //   4963: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4966: pop
    //   4967: aload 9
    //   4969: aload 7
    //   4971: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4974: pop
    //   4975: ldc 120
    //   4977: aload 9
    //   4979: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4982: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4985: goto +38 -> 5023
    //   4988: new 111	java/lang/StringBuilder
    //   4991: dup
    //   4992: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   4995: astore 9
    //   4997: aload 9
    //   4999: ldc 114
    //   5001: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5004: pop
    //   5005: aload 9
    //   5007: aload 7
    //   5009: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5012: pop
    //   5013: ldc 120
    //   5015: aload 9
    //   5017: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5020: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5023: aload 8
    //   5025: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5028: ifeq +41 -> 5069
    //   5031: new 111	java/lang/StringBuilder
    //   5034: dup
    //   5035: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5038: astore 7
    //   5040: aload 7
    //   5042: ldc 134
    //   5044: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5047: pop
    //   5048: aload 7
    //   5050: aload 8
    //   5052: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5055: pop
    //   5056: ldc 120
    //   5058: aload 7
    //   5060: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5063: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5066: goto +38 -> 5104
    //   5069: new 111	java/lang/StringBuilder
    //   5072: dup
    //   5073: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5076: astore 7
    //   5078: aload 7
    //   5080: ldc 134
    //   5082: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5085: pop
    //   5086: aload 7
    //   5088: aload 8
    //   5090: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5093: pop
    //   5094: ldc 120
    //   5096: aload 7
    //   5098: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5101: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5104: aload 18
    //   5106: getfield 102	midas/x/jo:a	I
    //   5109: sipush 200
    //   5112: if_icmpeq +44 -> 5156
    //   5115: new 111	java/lang/StringBuilder
    //   5118: dup
    //   5119: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5122: astore 7
    //   5124: aload 7
    //   5126: ldc 136
    //   5128: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5131: pop
    //   5132: aload 7
    //   5134: aload 18
    //   5136: getfield 102	midas/x/jo:a	I
    //   5139: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5142: pop
    //   5143: ldc 120
    //   5145: aload 7
    //   5147: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5150: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5153: goto +41 -> 5194
    //   5156: new 111	java/lang/StringBuilder
    //   5159: dup
    //   5160: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5163: astore 7
    //   5165: aload 7
    //   5167: ldc 136
    //   5169: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5172: pop
    //   5173: aload 7
    //   5175: aload 18
    //   5177: getfield 102	midas/x/jo:a	I
    //   5180: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5183: pop
    //   5184: ldc 120
    //   5186: aload 7
    //   5188: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5191: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5194: aload 18
    //   5196: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5199: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5202: ifeq +44 -> 5246
    //   5205: new 111	java/lang/StringBuilder
    //   5208: dup
    //   5209: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5212: astore 7
    //   5214: aload 7
    //   5216: ldc 144
    //   5218: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5221: pop
    //   5222: aload 7
    //   5224: aload 18
    //   5226: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5229: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5232: pop
    //   5233: ldc 120
    //   5235: aload 7
    //   5237: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5240: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5243: goto +41 -> 5284
    //   5246: new 111	java/lang/StringBuilder
    //   5249: dup
    //   5250: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5253: astore 7
    //   5255: aload 7
    //   5257: ldc 144
    //   5259: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: pop
    //   5263: aload 7
    //   5265: aload 18
    //   5267: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5270: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5273: pop
    //   5274: ldc 120
    //   5276: aload 7
    //   5278: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5281: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5284: aload 18
    //   5286: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   5289: ifnonnull +15 -> 5304
    //   5292: new 111	java/lang/StringBuilder
    //   5295: dup
    //   5296: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5299: astore 7
    //   5301: goto +1014 -> 6315
    //   5304: new 111	java/lang/StringBuilder
    //   5307: dup
    //   5308: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5311: astore 7
    //   5313: goto +1061 -> 6374
    //   5316: astore 17
    //   5318: ldc 132
    //   5320: astore 7
    //   5322: ldc 132
    //   5324: astore 8
    //   5326: aconst_null
    //   5327: astore 9
    //   5329: aconst_null
    //   5330: astore 10
    //   5332: aconst_null
    //   5333: astore 15
    //   5335: aload 9
    //   5337: astore 11
    //   5339: aload 10
    //   5341: astore 12
    //   5343: aload 7
    //   5345: astore 13
    //   5347: aload 8
    //   5349: astore 14
    //   5351: aload 15
    //   5353: astore 16
    //   5355: aload 17
    //   5357: invokevirtual 302	java/net/SocketTimeoutException:printStackTrace	()V
    //   5360: aload 9
    //   5362: astore 11
    //   5364: aload 10
    //   5366: astore 12
    //   5368: aload 7
    //   5370: astore 13
    //   5372: aload 8
    //   5374: astore 14
    //   5376: aload 15
    //   5378: astore 16
    //   5380: aload 18
    //   5382: aload 17
    //   5384: putfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   5387: aload_0
    //   5388: aload 10
    //   5390: aload 15
    //   5392: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   5395: aload 9
    //   5397: ifnull +8 -> 5405
    //   5400: aload 9
    //   5402: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   5405: aload_1
    //   5406: aconst_null
    //   5407: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   5410: aload_1
    //   5411: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   5414: aload_1
    //   5415: getfield 78	midas/x/jn:e	J
    //   5418: lsub
    //   5419: putfield 100	midas/x/jn:f	J
    //   5422: iload_2
    //   5423: ifeq +19 -> 5442
    //   5426: aload 18
    //   5428: getfield 102	midas/x/jo:a	I
    //   5431: sipush 200
    //   5434: if_icmpeq +8 -> 5442
    //   5437: aload_1
    //   5438: iconst_1
    //   5439: putfield 106	midas/x/jn:j	Z
    //   5442: aload_0
    //   5443: aload_1
    //   5444: aload 18
    //   5446: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   5449: aload 7
    //   5451: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5454: ifeq +41 -> 5495
    //   5457: new 111	java/lang/StringBuilder
    //   5460: dup
    //   5461: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5464: astore 9
    //   5466: aload 9
    //   5468: ldc 114
    //   5470: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5473: pop
    //   5474: aload 9
    //   5476: aload 7
    //   5478: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5481: pop
    //   5482: ldc 120
    //   5484: aload 9
    //   5486: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5489: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5492: goto +38 -> 5530
    //   5495: new 111	java/lang/StringBuilder
    //   5498: dup
    //   5499: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5502: astore 9
    //   5504: aload 9
    //   5506: ldc 114
    //   5508: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5511: pop
    //   5512: aload 9
    //   5514: aload 7
    //   5516: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5519: pop
    //   5520: ldc 120
    //   5522: aload 9
    //   5524: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5527: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5530: aload 8
    //   5532: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5535: ifeq +41 -> 5576
    //   5538: new 111	java/lang/StringBuilder
    //   5541: dup
    //   5542: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5545: astore 7
    //   5547: aload 7
    //   5549: ldc 134
    //   5551: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5554: pop
    //   5555: aload 7
    //   5557: aload 8
    //   5559: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: pop
    //   5563: ldc 120
    //   5565: aload 7
    //   5567: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5570: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5573: goto +38 -> 5611
    //   5576: new 111	java/lang/StringBuilder
    //   5579: dup
    //   5580: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5583: astore 7
    //   5585: aload 7
    //   5587: ldc 134
    //   5589: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5592: pop
    //   5593: aload 7
    //   5595: aload 8
    //   5597: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5600: pop
    //   5601: ldc 120
    //   5603: aload 7
    //   5605: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5608: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5611: aload 18
    //   5613: getfield 102	midas/x/jo:a	I
    //   5616: sipush 200
    //   5619: if_icmpeq +44 -> 5663
    //   5622: new 111	java/lang/StringBuilder
    //   5625: dup
    //   5626: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5629: astore 7
    //   5631: aload 7
    //   5633: ldc 136
    //   5635: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5638: pop
    //   5639: aload 7
    //   5641: aload 18
    //   5643: getfield 102	midas/x/jo:a	I
    //   5646: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5649: pop
    //   5650: ldc 120
    //   5652: aload 7
    //   5654: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5657: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5660: goto +41 -> 5701
    //   5663: new 111	java/lang/StringBuilder
    //   5666: dup
    //   5667: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5670: astore 7
    //   5672: aload 7
    //   5674: ldc 136
    //   5676: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5679: pop
    //   5680: aload 7
    //   5682: aload 18
    //   5684: getfield 102	midas/x/jo:a	I
    //   5687: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5690: pop
    //   5691: ldc 120
    //   5693: aload 7
    //   5695: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5698: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5701: aload 18
    //   5703: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5706: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5709: ifeq +44 -> 5753
    //   5712: new 111	java/lang/StringBuilder
    //   5715: dup
    //   5716: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5719: astore 7
    //   5721: aload 7
    //   5723: ldc 144
    //   5725: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5728: pop
    //   5729: aload 7
    //   5731: aload 18
    //   5733: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5736: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5739: pop
    //   5740: ldc 120
    //   5742: aload 7
    //   5744: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5747: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5750: goto +41 -> 5791
    //   5753: new 111	java/lang/StringBuilder
    //   5756: dup
    //   5757: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5760: astore 7
    //   5762: aload 7
    //   5764: ldc 144
    //   5766: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5769: pop
    //   5770: aload 7
    //   5772: aload 18
    //   5774: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   5777: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5780: pop
    //   5781: ldc 120
    //   5783: aload 7
    //   5785: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5788: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5791: aload 18
    //   5793: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   5796: ifnonnull +15 -> 5811
    //   5799: new 111	java/lang/StringBuilder
    //   5802: dup
    //   5803: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5806: astore 7
    //   5808: goto +507 -> 6315
    //   5811: new 111	java/lang/StringBuilder
    //   5814: dup
    //   5815: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5818: astore 7
    //   5820: goto +554 -> 6374
    //   5823: astore 17
    //   5825: ldc 132
    //   5827: astore 7
    //   5829: ldc 132
    //   5831: astore 8
    //   5833: aconst_null
    //   5834: astore 9
    //   5836: aconst_null
    //   5837: astore 10
    //   5839: aconst_null
    //   5840: astore 15
    //   5842: aload 9
    //   5844: astore 11
    //   5846: aload 10
    //   5848: astore 12
    //   5850: aload 7
    //   5852: astore 13
    //   5854: aload 8
    //   5856: astore 14
    //   5858: aload 15
    //   5860: astore 16
    //   5862: aload 17
    //   5864: invokevirtual 303	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   5867: aload 9
    //   5869: astore 11
    //   5871: aload 10
    //   5873: astore 12
    //   5875: aload 7
    //   5877: astore 13
    //   5879: aload 8
    //   5881: astore 14
    //   5883: aload 15
    //   5885: astore 16
    //   5887: aload 18
    //   5889: aload 17
    //   5891: putfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   5894: aload_0
    //   5895: aload 10
    //   5897: aload 15
    //   5899: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   5902: aload 9
    //   5904: ifnull +8 -> 5912
    //   5907: aload 9
    //   5909: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   5912: aload_1
    //   5913: aconst_null
    //   5914: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   5917: aload_1
    //   5918: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   5921: aload_1
    //   5922: getfield 78	midas/x/jn:e	J
    //   5925: lsub
    //   5926: putfield 100	midas/x/jn:f	J
    //   5929: iload_2
    //   5930: ifeq +19 -> 5949
    //   5933: aload 18
    //   5935: getfield 102	midas/x/jo:a	I
    //   5938: sipush 200
    //   5941: if_icmpeq +8 -> 5949
    //   5944: aload_1
    //   5945: iconst_1
    //   5946: putfield 106	midas/x/jn:j	Z
    //   5949: aload_0
    //   5950: aload_1
    //   5951: aload 18
    //   5953: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   5956: aload 7
    //   5958: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5961: ifeq +41 -> 6002
    //   5964: new 111	java/lang/StringBuilder
    //   5967: dup
    //   5968: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   5971: astore 9
    //   5973: aload 9
    //   5975: ldc 114
    //   5977: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5980: pop
    //   5981: aload 9
    //   5983: aload 7
    //   5985: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5988: pop
    //   5989: ldc 120
    //   5991: aload 9
    //   5993: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5996: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5999: goto +38 -> 6037
    //   6002: new 111	java/lang/StringBuilder
    //   6005: dup
    //   6006: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6009: astore 9
    //   6011: aload 9
    //   6013: ldc 114
    //   6015: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6018: pop
    //   6019: aload 9
    //   6021: aload 7
    //   6023: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6026: pop
    //   6027: ldc 120
    //   6029: aload 9
    //   6031: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6034: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6037: aload 8
    //   6039: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6042: ifeq +41 -> 6083
    //   6045: new 111	java/lang/StringBuilder
    //   6048: dup
    //   6049: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6052: astore 7
    //   6054: aload 7
    //   6056: ldc 134
    //   6058: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6061: pop
    //   6062: aload 7
    //   6064: aload 8
    //   6066: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6069: pop
    //   6070: ldc 120
    //   6072: aload 7
    //   6074: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6077: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6080: goto +38 -> 6118
    //   6083: new 111	java/lang/StringBuilder
    //   6086: dup
    //   6087: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6090: astore 7
    //   6092: aload 7
    //   6094: ldc 134
    //   6096: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6099: pop
    //   6100: aload 7
    //   6102: aload 8
    //   6104: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6107: pop
    //   6108: ldc 120
    //   6110: aload 7
    //   6112: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6115: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6118: aload 18
    //   6120: getfield 102	midas/x/jo:a	I
    //   6123: sipush 200
    //   6126: if_icmpeq +44 -> 6170
    //   6129: new 111	java/lang/StringBuilder
    //   6132: dup
    //   6133: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6136: astore 7
    //   6138: aload 7
    //   6140: ldc 136
    //   6142: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6145: pop
    //   6146: aload 7
    //   6148: aload 18
    //   6150: getfield 102	midas/x/jo:a	I
    //   6153: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6156: pop
    //   6157: ldc 120
    //   6159: aload 7
    //   6161: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6164: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6167: goto +41 -> 6208
    //   6170: new 111	java/lang/StringBuilder
    //   6173: dup
    //   6174: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6177: astore 7
    //   6179: aload 7
    //   6181: ldc 136
    //   6183: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6186: pop
    //   6187: aload 7
    //   6189: aload 18
    //   6191: getfield 102	midas/x/jo:a	I
    //   6194: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6197: pop
    //   6198: ldc 120
    //   6200: aload 7
    //   6202: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6205: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6208: aload 18
    //   6210: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6213: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6216: ifeq +44 -> 6260
    //   6219: new 111	java/lang/StringBuilder
    //   6222: dup
    //   6223: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6226: astore 7
    //   6228: aload 7
    //   6230: ldc 144
    //   6232: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6235: pop
    //   6236: aload 7
    //   6238: aload 18
    //   6240: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6243: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6246: pop
    //   6247: ldc 120
    //   6249: aload 7
    //   6251: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6254: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6257: goto +41 -> 6298
    //   6260: new 111	java/lang/StringBuilder
    //   6263: dup
    //   6264: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6267: astore 7
    //   6269: aload 7
    //   6271: ldc 144
    //   6273: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6276: pop
    //   6277: aload 7
    //   6279: aload 18
    //   6281: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6284: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6287: pop
    //   6288: ldc 120
    //   6290: aload 7
    //   6292: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6295: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6298: aload 18
    //   6300: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6303: ifnonnull +62 -> 6365
    //   6306: new 111	java/lang/StringBuilder
    //   6309: dup
    //   6310: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6313: astore 7
    //   6315: aload 7
    //   6317: ldc 149
    //   6319: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6322: pop
    //   6323: aload 7
    //   6325: aload 18
    //   6327: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6330: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6333: pop
    //   6334: aload 7
    //   6336: ldc 154
    //   6338: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6341: pop
    //   6342: aload 7
    //   6344: aload_1
    //   6345: invokevirtual 157	midas/x/jn:x	()Z
    //   6348: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6351: pop
    //   6352: ldc 120
    //   6354: aload 7
    //   6356: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6359: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6362: aload 18
    //   6364: areturn
    //   6365: new 111	java/lang/StringBuilder
    //   6368: dup
    //   6369: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6372: astore 7
    //   6374: aload 7
    //   6376: ldc 149
    //   6378: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6381: pop
    //   6382: aload 7
    //   6384: aload 18
    //   6386: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6389: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6392: pop
    //   6393: aload 7
    //   6395: ldc 154
    //   6397: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6400: pop
    //   6401: aload 7
    //   6403: aload_1
    //   6404: invokevirtual 157	midas/x/jn:x	()Z
    //   6407: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6410: pop
    //   6411: ldc 120
    //   6413: aload 7
    //   6415: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6418: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6421: aload 18
    //   6423: areturn
    //   6424: astore 15
    //   6426: aload 14
    //   6428: astore 8
    //   6430: aload 13
    //   6432: astore 7
    //   6434: aload 12
    //   6436: astore 10
    //   6438: aload 11
    //   6440: astore 9
    //   6442: aload 15
    //   6444: astore 11
    //   6446: aload_0
    //   6447: aload 10
    //   6449: aload 16
    //   6451: invokespecial 94	midas/x/jg:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   6454: aload 9
    //   6456: ifnull +8 -> 6464
    //   6459: aload 9
    //   6461: invokevirtual 232	java/net/HttpURLConnection:disconnect	()V
    //   6464: aload_1
    //   6465: aconst_null
    //   6466: putfield 98	midas/x/jn:p	Ljava/net/HttpURLConnection;
    //   6469: aload_1
    //   6470: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   6473: aload_1
    //   6474: getfield 78	midas/x/jn:e	J
    //   6477: lsub
    //   6478: putfield 100	midas/x/jn:f	J
    //   6481: iload_2
    //   6482: ifeq +19 -> 6501
    //   6485: aload 18
    //   6487: getfield 102	midas/x/jo:a	I
    //   6490: sipush 200
    //   6493: if_icmpeq +8 -> 6501
    //   6496: aload_1
    //   6497: iconst_1
    //   6498: putfield 106	midas/x/jn:j	Z
    //   6501: aload_0
    //   6502: aload_1
    //   6503: aload 18
    //   6505: invokespecial 109	midas/x/jg:b	(Lmidas/x/jn;Lmidas/x/jo;)V
    //   6508: aload 7
    //   6510: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6513: ifeq +41 -> 6554
    //   6516: new 111	java/lang/StringBuilder
    //   6519: dup
    //   6520: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6523: astore 9
    //   6525: aload 9
    //   6527: ldc 114
    //   6529: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6532: pop
    //   6533: aload 9
    //   6535: aload 7
    //   6537: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6540: pop
    //   6541: ldc 120
    //   6543: aload 9
    //   6545: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6548: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6551: goto +38 -> 6589
    //   6554: new 111	java/lang/StringBuilder
    //   6557: dup
    //   6558: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6561: astore 9
    //   6563: aload 9
    //   6565: ldc 114
    //   6567: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6570: pop
    //   6571: aload 9
    //   6573: aload 7
    //   6575: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6578: pop
    //   6579: ldc 120
    //   6581: aload 9
    //   6583: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6586: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6589: aload 8
    //   6591: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6594: ifeq +41 -> 6635
    //   6597: new 111	java/lang/StringBuilder
    //   6600: dup
    //   6601: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6604: astore 7
    //   6606: aload 7
    //   6608: ldc 134
    //   6610: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6613: pop
    //   6614: aload 7
    //   6616: aload 8
    //   6618: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6621: pop
    //   6622: ldc 120
    //   6624: aload 7
    //   6626: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6629: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6632: goto +38 -> 6670
    //   6635: new 111	java/lang/StringBuilder
    //   6638: dup
    //   6639: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6642: astore 7
    //   6644: aload 7
    //   6646: ldc 134
    //   6648: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6651: pop
    //   6652: aload 7
    //   6654: aload 8
    //   6656: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6659: pop
    //   6660: ldc 120
    //   6662: aload 7
    //   6664: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6667: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6670: aload 18
    //   6672: getfield 102	midas/x/jo:a	I
    //   6675: sipush 200
    //   6678: if_icmpeq +44 -> 6722
    //   6681: new 111	java/lang/StringBuilder
    //   6684: dup
    //   6685: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6688: astore 7
    //   6690: aload 7
    //   6692: ldc 136
    //   6694: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6697: pop
    //   6698: aload 7
    //   6700: aload 18
    //   6702: getfield 102	midas/x/jo:a	I
    //   6705: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6708: pop
    //   6709: ldc 120
    //   6711: aload 7
    //   6713: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6716: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6719: goto +41 -> 6760
    //   6722: new 111	java/lang/StringBuilder
    //   6725: dup
    //   6726: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6729: astore 7
    //   6731: aload 7
    //   6733: ldc 136
    //   6735: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6738: pop
    //   6739: aload 7
    //   6741: aload 18
    //   6743: getfield 102	midas/x/jo:a	I
    //   6746: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6749: pop
    //   6750: ldc 120
    //   6752: aload 7
    //   6754: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6757: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6760: aload 18
    //   6762: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6765: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6768: ifeq +44 -> 6812
    //   6771: new 111	java/lang/StringBuilder
    //   6774: dup
    //   6775: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6778: astore 7
    //   6780: aload 7
    //   6782: ldc 144
    //   6784: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6787: pop
    //   6788: aload 7
    //   6790: aload 18
    //   6792: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6795: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6798: pop
    //   6799: ldc 120
    //   6801: aload 7
    //   6803: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6806: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6809: goto +41 -> 6850
    //   6812: new 111	java/lang/StringBuilder
    //   6815: dup
    //   6816: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6819: astore 7
    //   6821: aload 7
    //   6823: ldc 144
    //   6825: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6828: pop
    //   6829: aload 7
    //   6831: aload 18
    //   6833: getfield 142	midas/x/jo:b	Ljava/lang/String;
    //   6836: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6839: pop
    //   6840: ldc 120
    //   6842: aload 7
    //   6844: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6847: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6850: aload 18
    //   6852: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6855: ifnonnull +62 -> 6917
    //   6858: new 111	java/lang/StringBuilder
    //   6861: dup
    //   6862: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6865: astore 7
    //   6867: aload 7
    //   6869: ldc 149
    //   6871: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6874: pop
    //   6875: aload 7
    //   6877: aload 18
    //   6879: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6882: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6885: pop
    //   6886: aload 7
    //   6888: ldc 154
    //   6890: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6893: pop
    //   6894: aload 7
    //   6896: aload_1
    //   6897: invokevirtual 157	midas/x/jn:x	()Z
    //   6900: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6903: pop
    //   6904: ldc 120
    //   6906: aload 7
    //   6908: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6911: invokestatic 130	midas/x/jh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6914: goto +59 -> 6973
    //   6917: new 111	java/lang/StringBuilder
    //   6920: dup
    //   6921: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   6924: astore 7
    //   6926: aload 7
    //   6928: ldc 149
    //   6930: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6933: pop
    //   6934: aload 7
    //   6936: aload 18
    //   6938: getfield 147	midas/x/jo:c	Ljava/lang/Exception;
    //   6941: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6944: pop
    //   6945: aload 7
    //   6947: ldc 154
    //   6949: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6952: pop
    //   6953: aload 7
    //   6955: aload_1
    //   6956: invokevirtual 157	midas/x/jn:x	()Z
    //   6959: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6962: pop
    //   6963: ldc 120
    //   6965: aload 7
    //   6967: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6970: invokestatic 128	midas/x/jh:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   6973: aload 11
    //   6975: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6976	0	this	jg
    //   0	6976	1	paramjn	jn
    //   0	6976	2	paramBoolean	boolean
    //   1745	1889	3	i	int
    //   49	1070	4	bool	boolean
    //   1766	1769	5	l	long
    //   42	6924	7	localObject1	Object
    //   121	6534	8	localObject2	Object
    //   1646	4936	9	localObject3	Object
    //   1740	587	10	arrayOfByte1	byte[]
    //   2354	23	10	localIOException1	java.io.IOException
    //   3528	2920	10	localObject4	Object
    //   2322	1321	11	localObject5	Object
    //   3702	1	11	localObject6	Object
    //   4185	1	11	localObject7	Object
    //   4210	1	11	localObject8	Object
    //   4255	1	11	localObject9	Object
    //   4280	1	11	localObject10	Object
    //   4323	2651	11	localObject11	Object
    //   3555	2880	12	localObject12	Object
    //   3559	2872	13	localObject13	Object
    //   3563	2864	14	localObject14	Object
    //   3547	2351	15	localObject15	Object
    //   6424	19	15	localObject16	Object
    //   3567	2883	16	localObject17	Object
    //   3574	57	17	arrayOfByte2	byte[]
    //   3682	1	17	localException1	Exception
    //   3687	1	17	localIOException2	java.io.IOException
    //   3692	1	17	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   3697	1	17	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   3710	1	17	localException2	Exception
    //   3718	1	17	localIOException3	java.io.IOException
    //   3726	1	17	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   3734	1	17	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   4190	1	17	localException3	Exception
    //   4195	1	17	localIOException4	java.io.IOException
    //   4200	1	17	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   4205	1	17	localConnectTimeoutException3	org.apache.http.conn.ConnectTimeoutException
    //   4219	1	17	localException4	Exception
    //   4228	1	17	localIOException5	java.io.IOException
    //   4237	1	17	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   4246	1	17	localConnectTimeoutException4	org.apache.http.conn.ConnectTimeoutException
    //   4260	1	17	localException5	Exception
    //   4265	1	17	localIOException6	java.io.IOException
    //   4270	1	17	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   4275	1	17	localConnectTimeoutException5	org.apache.http.conn.ConnectTimeoutException
    //   4302	67	17	localException6	Exception
    //   4809	67	17	localIOException7	java.io.IOException
    //   5316	67	17	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   5823	67	17	localConnectTimeoutException6	org.apache.http.conn.ConnectTimeoutException
    //   7	6930	18	localjo	jo
    // Exception table:
    //   from	to	target	type
    //   2346	2351	2354	java/io/IOException
    //   3569	3576	3682	java/lang/Exception
    //   3596	3604	3682	java/lang/Exception
    //   3628	3637	3682	java/lang/Exception
    //   3660	3679	3682	java/lang/Exception
    //   3569	3576	3687	java/io/IOException
    //   3596	3604	3687	java/io/IOException
    //   3628	3637	3687	java/io/IOException
    //   3660	3679	3687	java/io/IOException
    //   3569	3576	3692	java/net/SocketTimeoutException
    //   3596	3604	3692	java/net/SocketTimeoutException
    //   3628	3637	3692	java/net/SocketTimeoutException
    //   3660	3679	3692	java/net/SocketTimeoutException
    //   3569	3576	3697	org/apache/http/conn/ConnectTimeoutException
    //   3596	3604	3697	org/apache/http/conn/ConnectTimeoutException
    //   3628	3637	3697	org/apache/http/conn/ConnectTimeoutException
    //   3660	3679	3697	org/apache/http/conn/ConnectTimeoutException
    //   3530	3549	3702	finally
    //   3530	3549	3710	java/lang/Exception
    //   3530	3549	3718	java/io/IOException
    //   3530	3549	3726	java/net/SocketTimeoutException
    //   3530	3549	3734	org/apache/http/conn/ConnectTimeoutException
    //   1698	1782	4185	finally
    //   2310	2346	4185	finally
    //   2346	2351	4185	finally
    //   2356	2395	4185	finally
    //   2398	2413	4185	finally
    //   2413	2428	4185	finally
    //   2956	2968	4185	finally
    //   2975	2995	4185	finally
    //   3523	3530	4185	finally
    //   1698	1782	4190	java/lang/Exception
    //   2310	2346	4190	java/lang/Exception
    //   2346	2351	4190	java/lang/Exception
    //   2356	2395	4190	java/lang/Exception
    //   2398	2413	4190	java/lang/Exception
    //   2413	2428	4190	java/lang/Exception
    //   2956	2968	4190	java/lang/Exception
    //   2975	2995	4190	java/lang/Exception
    //   3523	3530	4190	java/lang/Exception
    //   1698	1782	4195	java/io/IOException
    //   2310	2346	4195	java/io/IOException
    //   2356	2395	4195	java/io/IOException
    //   2398	2413	4195	java/io/IOException
    //   2413	2428	4195	java/io/IOException
    //   2956	2968	4195	java/io/IOException
    //   2975	2995	4195	java/io/IOException
    //   3523	3530	4195	java/io/IOException
    //   1698	1782	4200	java/net/SocketTimeoutException
    //   2310	2346	4200	java/net/SocketTimeoutException
    //   2346	2351	4200	java/net/SocketTimeoutException
    //   2356	2395	4200	java/net/SocketTimeoutException
    //   2398	2413	4200	java/net/SocketTimeoutException
    //   2413	2428	4200	java/net/SocketTimeoutException
    //   2956	2968	4200	java/net/SocketTimeoutException
    //   2975	2995	4200	java/net/SocketTimeoutException
    //   3523	3530	4200	java/net/SocketTimeoutException
    //   1698	1782	4205	org/apache/http/conn/ConnectTimeoutException
    //   2310	2346	4205	org/apache/http/conn/ConnectTimeoutException
    //   2346	2351	4205	org/apache/http/conn/ConnectTimeoutException
    //   2356	2395	4205	org/apache/http/conn/ConnectTimeoutException
    //   2398	2413	4205	org/apache/http/conn/ConnectTimeoutException
    //   2413	2428	4205	org/apache/http/conn/ConnectTimeoutException
    //   2956	2968	4205	org/apache/http/conn/ConnectTimeoutException
    //   2975	2995	4205	org/apache/http/conn/ConnectTimeoutException
    //   3523	3530	4205	org/apache/http/conn/ConnectTimeoutException
    //   1648	1698	4210	finally
    //   1648	1698	4219	java/lang/Exception
    //   1648	1698	4228	java/io/IOException
    //   1648	1698	4237	java/net/SocketTimeoutException
    //   1648	1698	4246	org/apache/http/conn/ConnectTimeoutException
    //   44	51	4255	finally
    //   574	588	4255	finally
    //   1111	1118	4255	finally
    //   1641	1648	4255	finally
    //   44	51	4260	java/lang/Exception
    //   574	588	4260	java/lang/Exception
    //   1111	1118	4260	java/lang/Exception
    //   1641	1648	4260	java/lang/Exception
    //   44	51	4265	java/io/IOException
    //   574	588	4265	java/io/IOException
    //   1111	1118	4265	java/io/IOException
    //   1641	1648	4265	java/io/IOException
    //   44	51	4270	java/net/SocketTimeoutException
    //   574	588	4270	java/net/SocketTimeoutException
    //   1111	1118	4270	java/net/SocketTimeoutException
    //   1641	1648	4270	java/net/SocketTimeoutException
    //   44	51	4275	org/apache/http/conn/ConnectTimeoutException
    //   574	588	4275	org/apache/http/conn/ConnectTimeoutException
    //   1111	1118	4275	org/apache/http/conn/ConnectTimeoutException
    //   1641	1648	4275	org/apache/http/conn/ConnectTimeoutException
    //   34	44	4280	finally
    //   34	44	4302	java/lang/Exception
    //   34	44	4809	java/io/IOException
    //   34	44	5316	java/net/SocketTimeoutException
    //   34	44	5823	org/apache/http/conn/ConnectTimeoutException
    //   3569	3576	6424	finally
    //   3596	3604	6424	finally
    //   3628	3637	6424	finally
    //   3660	3679	6424	finally
    //   4341	4346	6424	finally
    //   4366	4373	6424	finally
    //   4848	4853	6424	finally
    //   4873	4880	6424	finally
    //   5355	5360	6424	finally
    //   5380	5387	6424	finally
    //   5862	5867	6424	finally
    //   5887	5894	6424	finally
  }
  
  private void a(int paramInt1, int paramInt2, jn paramjn, jo paramjo)
  {
    if (this.a.size() == 0) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((jf)localIterator.next()).a(paramInt1, paramInt2, paramjn, paramjo);
    }
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.flush();
        paramOutputStream.close();
        return;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, jn paramjn)
  {
    if (paramjn == null) {
      return;
    }
    paramjn = paramjn.l();
    if (paramjn == null) {
      return;
    }
    if (paramjn.size() <= 0) {
      return;
    }
    paramjn = paramjn.entrySet().iterator();
    while (paramjn.hasNext())
    {
      Object localObject = (Map.Entry)paramjn.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!TextUtils.isEmpty(str)) {
        paramHttpURLConnection.setRequestProperty(str, (String)localObject);
      }
    }
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, jn paramjn)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    if (paramjn == null) {
      return;
    }
    if (!paramjn.n()) {
      return;
    }
    if (!(paramHttpURLConnection instanceof HttpsURLConnection)) {
      return;
    }
    paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
    HostnameVerifier localHostnameVerifier = paramjn.i();
    if (localHostnameVerifier != null) {
      paramHttpURLConnection.setHostnameVerifier(localHostnameVerifier);
    }
    paramjn = paramjn.j();
    if (paramjn != null) {
      paramHttpURLConnection.setSSLSocketFactory(paramjn);
    }
  }
  
  private void b(jn paramjn)
  {
    if (this.a.size() == 0) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((jf)localIterator.next()).a(paramjn);
    }
  }
  
  private void b(jn paramjn, jo paramjo)
  {
    if (this.a.size() == 0) {
      return;
    }
    int i = this.a.size();
    ListIterator localListIterator = this.a.listIterator(i);
    while (localListIterator.hasPrevious()) {
      ((jf)localListIterator.previous()).a(paramjn, paramjo);
    }
  }
  
  private void c(HttpURLConnection paramHttpURLConnection, jn paramjn)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    int j;
    if (this.b != null)
    {
      k = this.b.a;
      j = this.b.b;
    }
    else
    {
      k = 15000;
      j = 15000;
    }
    int i = k;
    if (paramjn != null)
    {
      i = k;
      if (paramjn.n > 0) {
        i = paramjn.n;
      }
    }
    if ((paramjn != null) && (paramjn.o > 0)) {
      j = paramjn.o;
    }
    if (i > 60000)
    {
      paramjn = new StringBuilder();
      paramjn.append("Current connect timeout may be to high = ");
      paramjn.append(i);
      jh.a("HTTP", paramjn.toString());
    }
    int k = i;
    if (i <= 0) {
      k = 15000;
    }
    if (j > 60000)
    {
      paramjn = new StringBuilder();
      paramjn.append("Current read timeout may be to high = ");
      paramjn.append(j);
      jh.a("HTTP", paramjn.toString());
    }
    i = j;
    if (j <= 0) {
      i = 15000;
    }
    paramHttpURLConnection.setConnectTimeout(k);
    paramjn = new StringBuilder();
    paramjn.append("Use connect timeout = ");
    paramjn.append(k);
    jh.b("HTTP", paramjn.toString());
    paramHttpURLConnection.setReadTimeout(i);
    paramHttpURLConnection = new StringBuilder();
    paramHttpURLConnection.append("Use read timeout = ");
    paramHttpURLConnection.append(i);
    jh.b("HTTP", paramHttpURLConnection.toString());
  }
  
  public jo a(jn paramjn, jo paramjo)
  {
    if (paramjn == null) {
      return paramjo;
    }
    return a(paramjn);
  }
  
  void a(jf paramjf)
  {
    if (paramjf != null) {
      this.a.add(paramjf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jg
 * JD-Core Version:    0.7.0.1
 */