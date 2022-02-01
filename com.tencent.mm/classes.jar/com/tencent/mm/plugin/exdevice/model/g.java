package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.jq.b;
import com.tencent.mm.g.c.di;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.vfs.k;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class g
  implements f
{
  String dAd;
  long fIR;
  long gzw;
  String idX;
  public g.a ieg;
  String qiA;
  private String qiB;
  boolean qiC;
  boolean qiD;
  public HashMap<String, String> qiE;
  bpm qiF;
  long qiG;
  List<com.tencent.mm.plugin.exdevice.i.b> qiH;
  List<com.tencent.mm.plugin.exdevice.i.b> qiI;
  HashMap<String, String> qiJ;
  HashMap<String, Integer> qiK;
  HashMap<String, Boolean> qiL;
  j.a qiM;
  j.a qiN;
  j.a qiO;
  j.a qiP;
  Runnable qiQ;
  bpm qiR;
  String qiS;
  String qiT;
  int qiU;
  HashMap<Integer, String> qiV;
  boolean qit;
  boolean qiu;
  boolean qiv;
  String qiw;
  String qix;
  String qiy;
  String qiz;
  
  public g()
  {
    AppMethodBeat.i(23327);
    this.qit = false;
    this.qiu = false;
    this.qiv = false;
    this.qiz = "send_data_sucess";
    this.qiA = "send_data_failed";
    this.qiB = "send_data_sending";
    this.qiC = false;
    this.qiD = false;
    this.qiE = new HashMap();
    this.idX = "";
    this.qiH = null;
    this.qiI = new ArrayList();
    this.qiJ = new HashMap();
    this.qiK = new HashMap();
    this.qiL = new HashMap();
    this.qiQ = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: sipush 23317
        //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: new 31	java/lang/StringBuilder
        //   9: dup
        //   10: invokespecial 32	java/lang/StringBuilder:<init>	()V
        //   13: invokestatic 38	com/tencent/mm/loader/j/b:ass	()Ljava/lang/String;
        //   16: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: ldc 44
        //   21: iconst_3
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 46
        //   29: aastore
        //   30: dup
        //   31: iconst_1
        //   32: aload_0
        //   33: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   36: getfield 50	com/tencent/mm/plugin/exdevice/model/g:dAd	Ljava/lang/String;
        //   39: invokevirtual 56	java/lang/String:hashCode	()I
        //   42: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   45: aastore
        //   46: dup
        //   47: iconst_2
        //   48: ldc 64
        //   50: aastore
        //   51: invokestatic 68	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   54: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   57: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   60: astore 5
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   66: getfield 50	com/tencent/mm/plugin/exdevice/model/g:dAd	Ljava/lang/String;
        //   69: invokestatic 75	com/tencent/mm/plugin/exdevice/model/g:adm	(Ljava/lang/String;)[B
        //   72: astore_2
        //   73: aload_2
        //   74: ifnull +257 -> 331
        //   77: aload_2
        //   78: iconst_0
        //   79: aload_2
        //   80: arraylength
        //   81: invokestatic 81	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
        //   84: astore 4
        //   86: aload_0
        //   87: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   90: astore 6
        //   92: aload 5
        //   94: iconst_0
        //   95: invokestatic 87	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   98: astore_3
        //   99: aload_3
        //   100: astore_2
        //   101: aload 4
        //   103: getstatic 93	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   106: bipush 80
        //   108: aload_3
        //   109: invokevirtual 99	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   112: pop
        //   113: aload_3
        //   114: astore_2
        //   115: aload_3
        //   116: invokevirtual 104	java/io/OutputStream:flush	()V
        //   119: aload_3
        //   120: ifnull +7 -> 127
        //   123: aload_3
        //   124: invokevirtual 107	java/io/OutputStream:close	()V
        //   127: aload_0
        //   128: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   131: aload 5
        //   133: putfield 110	com/tencent/mm/plugin/exdevice/model/g:qix	Ljava/lang/String;
        //   136: aload_0
        //   137: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   140: getfield 110	com/tencent/mm/plugin/exdevice/model/g:qix	Ljava/lang/String;
        //   143: ifnonnull +219 -> 362
        //   146: aload_0
        //   147: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   150: getfield 110	com/tencent/mm/plugin/exdevice/model/g:qix	Ljava/lang/String;
        //   153: invokestatic 114	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
        //   156: ifne +206 -> 362
        //   159: ldc 116
        //   161: ldc 118
        //   163: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   166: aload_0
        //   167: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   170: getfield 127	com/tencent/mm/plugin/exdevice/model/g:qiT	Ljava/lang/String;
        //   173: aload_0
        //   174: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   177: getfield 130	com/tencent/mm/plugin/exdevice/model/g:qiA	Ljava/lang/String;
        //   180: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:fG	(Ljava/lang/String;Ljava/lang/String;)V
        //   183: sipush 23317
        //   186: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   189: return
        //   190: astore_2
        //   191: ldc 116
        //   193: aload_2
        //   194: ldc 138
        //   196: iconst_0
        //   197: anewarray 4	java/lang/Object
        //   200: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   203: goto -76 -> 127
        //   206: astore_2
        //   207: ldc 116
        //   209: aload_2
        //   210: ldc 138
        //   212: iconst_0
        //   213: anewarray 4	java/lang/Object
        //   216: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   219: sipush 23317
        //   222: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   225: return
        //   226: astore 4
        //   228: aconst_null
        //   229: astore_3
        //   230: aload_3
        //   231: astore_2
        //   232: ldc 116
        //   234: ldc 144
        //   236: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   239: aload_3
        //   240: astore_2
        //   241: aload 6
        //   243: getfield 127	com/tencent/mm/plugin/exdevice/model/g:qiT	Ljava/lang/String;
        //   246: aload 6
        //   248: getfield 130	com/tencent/mm/plugin/exdevice/model/g:qiA	Ljava/lang/String;
        //   251: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:fG	(Ljava/lang/String;Ljava/lang/String;)V
        //   254: aload_3
        //   255: astore_2
        //   256: ldc 116
        //   258: aload 4
        //   260: ldc 138
        //   262: iconst_0
        //   263: anewarray 4	java/lang/Object
        //   266: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   269: aload_3
        //   270: ifnull -143 -> 127
        //   273: aload_3
        //   274: invokevirtual 107	java/io/OutputStream:close	()V
        //   277: goto -150 -> 127
        //   280: astore_2
        //   281: ldc 116
        //   283: aload_2
        //   284: ldc 138
        //   286: iconst_0
        //   287: anewarray 4	java/lang/Object
        //   290: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   293: goto -166 -> 127
        //   296: astore_3
        //   297: aconst_null
        //   298: astore_2
        //   299: aload_2
        //   300: ifnull +7 -> 307
        //   303: aload_2
        //   304: invokevirtual 107	java/io/OutputStream:close	()V
        //   307: sipush 23317
        //   310: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   313: aload_3
        //   314: athrow
        //   315: astore_2
        //   316: ldc 116
        //   318: aload_2
        //   319: ldc 138
        //   321: iconst_0
        //   322: anewarray 4	java/lang/Object
        //   325: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   328: goto -21 -> 307
        //   331: ldc 116
        //   333: ldc 146
        //   335: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   338: aload_0
        //   339: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   342: getfield 127	com/tencent/mm/plugin/exdevice/model/g:qiT	Ljava/lang/String;
        //   345: aload_0
        //   346: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   349: getfield 130	com/tencent/mm/plugin/exdevice/model/g:qiA	Ljava/lang/String;
        //   352: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:fG	(Ljava/lang/String;Ljava/lang/String;)V
        //   355: sipush 23317
        //   358: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   361: return
        //   362: iconst_m1
        //   363: istore_1
        //   364: new 148	com/tencent/mm/protocal/protobuf/bpn
        //   367: dup
        //   368: invokespecial 149	com/tencent/mm/protocal/protobuf/bpn:<init>	()V
        //   371: astore 5
        //   373: aload_0
        //   374: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   377: getfield 110	com/tencent/mm/plugin/exdevice/model/g:qix	Ljava/lang/String;
        //   380: astore 6
        //   382: aload 6
        //   384: ifnull +215 -> 599
        //   387: aload 6
        //   389: invokevirtual 152	java/lang/String:length	()I
        //   392: ifle +207 -> 599
        //   395: new 154	com/tencent/mm/vfs/k
        //   398: dup
        //   399: aload 6
        //   401: invokespecial 157	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
        //   404: astore_2
        //   405: aload_2
        //   406: invokevirtual 160	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
        //   409: astore_3
        //   410: aload_2
        //   411: invokevirtual 163	com/tencent/mm/vfs/k:length	()J
        //   414: l2i
        //   415: istore_1
        //   416: aload_3
        //   417: aload_3
        //   418: ldc 165
        //   420: invokevirtual 169	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
        //   423: iconst_1
        //   424: iadd
        //   425: aload_3
        //   426: invokevirtual 152	java/lang/String:length	()I
        //   429: invokevirtual 173	java/lang/String:substring	(II)Ljava/lang/String;
        //   432: astore_2
        //   433: aload 6
        //   435: invokestatic 177	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
        //   438: astore 4
        //   440: ldc 116
        //   442: ldc 179
        //   444: iconst_1
        //   445: anewarray 4	java/lang/Object
        //   448: dup
        //   449: iconst_0
        //   450: aload 6
        //   452: aastore
        //   453: invokestatic 182	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   456: ldc 116
        //   458: ldc 184
        //   460: iconst_1
        //   461: anewarray 4	java/lang/Object
        //   464: dup
        //   465: iconst_0
        //   466: iload_1
        //   467: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   470: aastore
        //   471: invokestatic 182	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   474: ldc 116
        //   476: ldc 186
        //   478: iconst_1
        //   479: anewarray 4	java/lang/Object
        //   482: dup
        //   483: iconst_0
        //   484: aload 4
        //   486: aastore
        //   487: invokestatic 182	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   490: aload 5
        //   492: aload_2
        //   493: putfield 189	com/tencent/mm/protocal/protobuf/bpn:Type	Ljava/lang/String;
        //   496: aload 5
        //   498: aload_3
        //   499: putfield 192	com/tencent/mm/protocal/protobuf/bpn:Name	Ljava/lang/String;
        //   502: aload 5
        //   504: iload_1
        //   505: putfield 196	com/tencent/mm/protocal/protobuf/bpn:nJv	I
        //   508: aload 5
        //   510: aload 4
        //   512: putfield 199	com/tencent/mm/protocal/protobuf/bpn:Md5	Ljava/lang/String;
        //   515: aload_0
        //   516: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   519: getfield 203	com/tencent/mm/plugin/exdevice/model/g:qiR	Lcom/tencent/mm/protocal/protobuf/bpm;
        //   522: aload 5
        //   524: putfield 209	com/tencent/mm/protocal/protobuf/bpm:Hda	Lcom/tencent/mm/protocal/protobuf/bpn;
        //   527: aload_0
        //   528: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   531: getfield 203	com/tencent/mm/plugin/exdevice/model/g:qiR	Lcom/tencent/mm/protocal/protobuf/bpm;
        //   534: iconst_3
        //   535: putfield 212	com/tencent/mm/protocal/protobuf/bpm:HcX	I
        //   538: new 214	com/tencent/mm/plugin/exdevice/model/n
        //   541: dup
        //   542: aload_0
        //   543: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   546: getfield 203	com/tencent/mm/plugin/exdevice/model/g:qiR	Lcom/tencent/mm/protocal/protobuf/bpm;
        //   549: aload_0
        //   550: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   553: getfield 217	com/tencent/mm/plugin/exdevice/model/g:qiS	Ljava/lang/String;
        //   556: aload_0
        //   557: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   560: getfield 127	com/tencent/mm/plugin/exdevice/model/g:qiT	Ljava/lang/String;
        //   563: aload_0
        //   564: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   567: getfield 220	com/tencent/mm/plugin/exdevice/model/g:qiU	I
        //   570: invokespecial 223	com/tencent/mm/plugin/exdevice/model/n:<init>	(Lcom/tencent/mm/protocal/protobuf/bpm;Ljava/lang/String;Ljava/lang/String;I)V
        //   573: astore_2
        //   574: invokestatic 229	com/tencent/mm/model/bc:ajj	()Lcom/tencent/mm/ak/q;
        //   577: aload_2
        //   578: iconst_0
        //   579: invokevirtual 235	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
        //   582: pop
        //   583: sipush 23317
        //   586: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   589: return
        //   590: astore_3
        //   591: goto -292 -> 299
        //   594: astore 4
        //   596: goto -366 -> 230
        //   599: aconst_null
        //   600: astore_2
        //   601: aconst_null
        //   602: astore_3
        //   603: aconst_null
        //   604: astore 4
        //   606: goto -116 -> 490
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	609	0	this	1
        //   363	142	1	i	int
        //   72	43	2	localObject1	Object
        //   190	4	2	localIOException1	java.io.IOException
        //   206	4	2	localException	Exception
        //   231	25	2	localObject2	Object
        //   280	4	2	localIOException2	java.io.IOException
        //   298	6	2	localObject3	Object
        //   315	4	2	localIOException3	java.io.IOException
        //   404	197	2	localObject4	Object
        //   98	176	3	localOutputStream	java.io.OutputStream
        //   296	18	3	localObject5	Object
        //   409	90	3	str1	String
        //   590	1	3	localObject6	Object
        //   602	1	3	localObject7	Object
        //   84	18	4	localBitmap	android.graphics.Bitmap
        //   226	33	4	localIOException4	java.io.IOException
        //   438	73	4	str2	String
        //   594	1	4	localIOException5	java.io.IOException
        //   604	1	4	localObject8	Object
        //   60	463	5	localObject9	Object
        //   90	361	6	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   123	127	190	java/io/IOException
        //   6	73	206	java/lang/Exception
        //   77	92	206	java/lang/Exception
        //   123	127	206	java/lang/Exception
        //   127	183	206	java/lang/Exception
        //   191	203	206	java/lang/Exception
        //   273	277	206	java/lang/Exception
        //   281	293	206	java/lang/Exception
        //   303	307	206	java/lang/Exception
        //   307	315	206	java/lang/Exception
        //   316	328	206	java/lang/Exception
        //   331	355	206	java/lang/Exception
        //   364	382	206	java/lang/Exception
        //   387	490	206	java/lang/Exception
        //   490	583	206	java/lang/Exception
        //   92	99	226	java/io/IOException
        //   273	277	280	java/io/IOException
        //   92	99	296	finally
        //   303	307	315	java/io/IOException
        //   101	113	590	finally
        //   115	119	590	finally
        //   232	239	590	finally
        //   241	254	590	finally
        //   256	269	590	finally
        //   101	113	594	java/io/IOException
        //   115	119	594	java/io/IOException
      }
    };
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(23318);
        ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[] { g.this.idX, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(g.this.qiC) });
        if (paramAnonymousc != null) {}
        label560:
        label568:
        for (;;)
        {
          try
          {
            paramAnonymousInt = (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F);
            ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt < 100) {
              break label568;
            }
            paramAnonymousInt = 99;
            paramAnonymousString = g.this.qiE.keySet().iterator();
            if (paramAnonymousString.hasNext())
            {
              paramAnonymousc = (String)paramAnonymousString.next();
              g.a(g.this, paramAnonymousc, paramAnonymousInt);
              continue;
            }
            if (paramAnonymousd == null) {
              break label560;
            }
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(23318);
            return 0;
          }
          if (g.this.qiC)
          {
            paramAnonymousString = new bpm();
            g.this.a(paramAnonymousString, g.this.fIR);
            g.this.qiC = false;
            if ((g.uK(g.this.fIR).booleanValue()) || (g.uL(g.this.fIR).booleanValue()))
            {
              paramAnonymousString.Hda.Ghg = paramAnonymousd.field_aesKey;
              paramAnonymousString.Hda.Hde = g.this.qiG;
              paramAnonymousString.Hda.FSC = paramAnonymousd.field_fileId;
              paramAnonymousString.Hda.Url = paramAnonymousd.field_fileUrl;
              ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[] { paramAnonymousString.Hda.Url });
            }
            for (;;)
            {
              g.this.qiF = paramAnonymousString;
              paramAnonymousc = g.this.qiE.keySet().iterator();
              while (paramAnonymousc.hasNext())
              {
                paramAnonymousd = (String)paramAnonymousc.next();
                paramAnonymousd = new n(paramAnonymousString, (String)g.this.qiE.get(paramAnonymousd), paramAnonymousd, 1);
                bc.ajj().a(paramAnonymousd, 0);
              }
              if (g.uJ(g.this.fIR).booleanValue())
              {
                paramAnonymousString.Hdb.Ghg = paramAnonymousd.field_aesKey;
                paramAnonymousString.Hdb.FSC = paramAnonymousd.field_fileId;
                paramAnonymousString.Hdb.Url = paramAnonymousd.field_fileUrl;
                ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[] { paramAnonymousString.Hdb.Url });
              }
              else if (g.uM(g.this.fIR).booleanValue())
              {
                paramAnonymousString.Hdd.Url = paramAnonymousd.field_fileUrl;
                ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[] { paramAnonymousString.Hdd.Url });
              }
            }
            g.this.qiE.clear();
          }
          AppMethodBeat.o(23318);
          return 0;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(23319);
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(23319);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23320);
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
        AppMethodBeat.o(23320);
        return paramAnonymousArrayOfByte;
      }
    };
    this.qiV = new HashMap();
    this.qiI.clear();
    this.qiJ.clear();
    this.qiL.clear();
    this.qiH = ad.cmJ().cnn();
    if ((this.qiH != null) && (this.qiH.size() > 0))
    {
      ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[] { Integer.valueOf(this.qiH.size()) });
      int j = this.qiH.size();
      int i = 0;
      while (i < j)
      {
        if ((((com.tencent.mm.plugin.exdevice.i.b)this.qiH.get(i)).fhE.contains("internet_to_device")) && (!((com.tencent.mm.plugin.exdevice.i.b)this.qiH.get(i)).fhE.contains("wechat_to_device"))) {
          this.qiI.add(this.qiH.get(i));
        }
        i += 1;
      }
      this.qiP = new g.3(this);
      this.qiM = new j.a()
      {
        /* Error */
        public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs)
        {
          // Byte code:
          //   0: sipush 23322
          //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: iload_1
          //   7: bipush 14
          //   9: if_icmpne +21 -> 30
          //   12: aload_2
          //   13: ifnull +17 -> 30
          //   16: aload_2
          //   17: arraylength
          //   18: ifle +12 -> 30
          //   21: aload_2
          //   22: iconst_0
          //   23: aaload
          //   24: instanceof 30
          //   27: ifne +10 -> 37
          //   30: sipush 23322
          //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   36: return
          //   37: aload_2
          //   38: iconst_0
          //   39: aaload
          //   40: checkcast 30	[B
          //   43: checkcast 30	[B
          //   46: astore_2
          //   47: new 35	org/json/JSONObject
          //   50: dup
          //   51: new 37	java/lang/String
          //   54: dup
          //   55: aload_2
          //   56: invokespecial 40	java/lang/String:<init>	([B)V
          //   59: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   62: astore 6
          //   64: aload 6
          //   66: ldc 45
          //   68: invokevirtual 49	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
          //   71: astore_2
          //   72: aload_2
          //   73: ldc 51
          //   75: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   78: astore 5
          //   80: aload_2
          //   81: ldc 57
          //   83: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   86: astore 4
          //   88: aload 6
          //   90: ldc 59
          //   92: invokevirtual 63	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
          //   95: ifeq +17 -> 112
          //   98: ldc 65
          //   100: ldc 67
          //   102: invokestatic 73	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   105: sipush 23322
          //   108: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   111: return
          //   112: ldc 65
          //   114: ldc 75
          //   116: iconst_1
          //   117: anewarray 4	java/lang/Object
          //   120: dup
          //   121: iconst_0
          //   122: aload 6
          //   124: ldc 59
          //   126: invokevirtual 79	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
          //   129: invokevirtual 85	org/json/JSONArray:toString	()Ljava/lang/String;
          //   132: aastore
          //   133: invokestatic 88	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   136: aload_2
          //   137: astore 6
          //   139: aload 5
          //   141: ifnull +29 -> 170
          //   144: aload 4
          //   146: ifnull +24 -> 170
          //   149: ldc 65
          //   151: ldc 90
          //   153: iconst_2
          //   154: anewarray 4	java/lang/Object
          //   157: dup
          //   158: iconst_0
          //   159: aload 5
          //   161: aastore
          //   162: dup
          //   163: iconst_1
          //   164: aload 4
          //   166: aastore
          //   167: invokestatic 92	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   170: aload_0
          //   171: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   174: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   177: invokeinterface 102 1 0
          //   182: istore_3
          //   183: iconst_0
          //   184: istore_1
          //   185: iload_1
          //   186: iload_3
          //   187: if_icmpge +205 -> 392
          //   190: aload_0
          //   191: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   194: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   197: iload_1
          //   198: invokeinterface 106 2 0
          //   203: checkcast 108	com/tencent/mm/plugin/exdevice/i/b
          //   206: getfield 112	com/tencent/mm/plugin/exdevice/i/b:field_deviceID	Ljava/lang/String;
          //   209: aload 4
          //   211: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   214: ifeq +139 -> 353
          //   217: aload_0
          //   218: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   221: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   224: iload_1
          //   225: invokeinterface 106 2 0
          //   230: checkcast 108	com/tencent/mm/plugin/exdevice/i/b
          //   233: getfield 119	com/tencent/mm/plugin/exdevice/i/b:field_deviceType	Ljava/lang/String;
          //   236: aload 5
          //   238: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   241: ifeq +112 -> 353
          //   244: aload_0
          //   245: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   248: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   251: iload_1
          //   252: invokeinterface 106 2 0
          //   257: checkcast 108	com/tencent/mm/plugin/exdevice/i/b
          //   260: getfield 124	com/tencent/mm/g/c/di:fhE	Ljava/lang/String;
          //   263: ldc 126
          //   265: invokevirtual 130	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   268: ifeq +85 -> 353
          //   271: aload_0
          //   272: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   275: getfield 133	com/tencent/mm/plugin/exdevice/model/g:qiI	Ljava/util/List;
          //   278: aload_0
          //   279: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   282: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   285: iload_1
          //   286: invokeinterface 106 2 0
          //   291: invokeinterface 135 2 0
          //   296: ifne +57 -> 353
          //   299: aload_0
          //   300: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   303: getfield 139	com/tencent/mm/plugin/exdevice/model/g:qiJ	Ljava/util/HashMap;
          //   306: aload 4
          //   308: aload 6
          //   310: invokevirtual 140	org/json/JSONObject:toString	()Ljava/lang/String;
          //   313: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   316: pop
          //   317: aload_0
          //   318: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   321: getfield 133	com/tencent/mm/plugin/exdevice/model/g:qiI	Ljava/util/List;
          //   324: aload_0
          //   325: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   328: getfield 96	com/tencent/mm/plugin/exdevice/model/g:qiH	Ljava/util/List;
          //   331: iload_1
          //   332: invokeinterface 106 2 0
          //   337: invokeinterface 149 2 0
          //   342: pop
          //   343: aload_0
          //   344: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:qiW	Lcom/tencent/mm/plugin/exdevice/model/g;
          //   347: getfield 133	com/tencent/mm/plugin/exdevice/model/g:qiI	Ljava/util/List;
          //   350: invokestatic 153	com/tencent/mm/plugin/exdevice/model/g:cX	(Ljava/util/List;)V
          //   353: iload_1
          //   354: iconst_1
          //   355: iadd
          //   356: istore_1
          //   357: goto -172 -> 185
          //   360: astore 4
          //   362: aconst_null
          //   363: astore 6
          //   365: aconst_null
          //   366: astore_2
          //   367: aconst_null
          //   368: astore 5
          //   370: ldc 65
          //   372: ldc 155
          //   374: iconst_1
          //   375: anewarray 4	java/lang/Object
          //   378: dup
          //   379: iconst_0
          //   380: aload 4
          //   382: aastore
          //   383: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   386: aload_2
          //   387: astore 4
          //   389: goto -250 -> 139
          //   392: sipush 23322
          //   395: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   398: return
          //   399: astore 4
          //   401: aconst_null
          //   402: astore 7
          //   404: aconst_null
          //   405: astore 5
          //   407: aload_2
          //   408: astore 6
          //   410: aload 7
          //   412: astore_2
          //   413: goto -43 -> 370
          //   416: astore 4
          //   418: aconst_null
          //   419: astore 7
          //   421: aload_2
          //   422: astore 6
          //   424: aload 7
          //   426: astore_2
          //   427: goto -57 -> 370
          //   430: astore 6
          //   432: aload 4
          //   434: astore 7
          //   436: aload 6
          //   438: astore 4
          //   440: aload_2
          //   441: astore 6
          //   443: aload 7
          //   445: astore_2
          //   446: goto -76 -> 370
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	449	0	this	4
          //   0	449	1	paramAnonymousInt	int
          //   0	449	2	paramAnonymousVarArgs	Object[]
          //   182	6	3	i	int
          //   86	221	4	str1	String
          //   360	21	4	localException1	Exception
          //   387	1	4	arrayOfObject1	Object[]
          //   399	1	4	localException2	Exception
          //   416	17	4	localException3	Exception
          //   438	1	4	localException4	Exception
          //   78	328	5	str2	String
          //   62	361	6	localObject	Object
          //   430	7	6	localException5	Exception
          //   441	1	6	arrayOfObject2	Object[]
          //   402	42	7	localException6	Exception
          // Exception table:
          //   from	to	target	type
          //   47	72	360	java/lang/Exception
          //   72	80	399	java/lang/Exception
          //   80	88	416	java/lang/Exception
          //   88	105	430	java/lang/Exception
          //   112	136	430	java/lang/Exception
        }
      };
      this.qiN = new g.5(this);
      this.qiO = new g.6(this);
      bc.ajj().a(1717, this);
      j.cmA().a(14, this.qiM);
      j.cmA().a(12, this.qiN);
      j.cmA().a(13, this.qiO);
      j.cmA().a(15, this.qiP);
      ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
      Java2CExDevice.initWCLanDeviceLib();
    }
    AppMethodBeat.o(23327);
  }
  
  /* Error */
  static String ac(String paramString, long paramLong)
  {
    // Byte code:
    //   0: sipush 23336
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 23336
    //   13: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: iconst_0
    //   20: aload_0
    //   21: ldc_w 280
    //   24: invokevirtual 284	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   27: invokevirtual 288	java/lang/String:substring	(II)Ljava/lang/String;
    //   30: astore_3
    //   31: new 290	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 292
    //   38: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: invokevirtual 298	java/lang/String:hashCode	()I
    //   45: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 290	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   60: aload_3
    //   61: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 280
    //   67: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 4
    //   72: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 6
    //   80: new 312	com/tencent/mm/modelsfs/b
    //   83: dup
    //   84: new 314	com/tencent/mm/vfs/k
    //   87: dup
    //   88: aload 6
    //   90: invokespecial 315	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   93: lload_1
    //   94: invokespecial 318	com/tencent/mm/modelsfs/b:<init>	(Lcom/tencent/mm/vfs/k;J)V
    //   97: astore_3
    //   98: aload_0
    //   99: invokestatic 324	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   102: astore_0
    //   103: aload_0
    //   104: astore 5
    //   106: aload_3
    //   107: astore 4
    //   109: sipush 1024
    //   112: newarray byte
    //   114: astore 7
    //   116: aload_0
    //   117: astore 5
    //   119: aload_3
    //   120: astore 4
    //   122: aload_0
    //   123: aload 7
    //   125: invokevirtual 330	java/io/InputStream:read	([B)I
    //   128: iconst_m1
    //   129: if_icmpeq +74 -> 203
    //   132: aload_0
    //   133: astore 5
    //   135: aload_3
    //   136: astore 4
    //   138: aload_3
    //   139: aload 7
    //   141: invokevirtual 336	java/io/OutputStream:write	([B)V
    //   144: goto -28 -> 116
    //   147: astore 6
    //   149: aload_0
    //   150: astore 5
    //   152: aload_3
    //   153: astore 4
    //   155: ldc 153
    //   157: ldc_w 338
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload 6
    //   168: invokevirtual 341	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 344	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_3
    //   176: ifnull +11 -> 187
    //   179: aload_3
    //   180: invokevirtual 347	java/io/OutputStream:flush	()V
    //   183: aload_3
    //   184: invokevirtual 350	java/io/OutputStream:close	()V
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 351	java/io/InputStream:close	()V
    //   195: sipush 23336
    //   198: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aconst_null
    //   202: areturn
    //   203: aload_3
    //   204: invokevirtual 347	java/io/OutputStream:flush	()V
    //   207: aload_3
    //   208: invokevirtual 350	java/io/OutputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 351	java/io/InputStream:close	()V
    //   219: sipush 23336
    //   222: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload 6
    //   227: areturn
    //   228: astore_0
    //   229: ldc 153
    //   231: aload_0
    //   232: ldc 104
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: sipush 23336
    //   244: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: ldc 153
    //   252: aload_0
    //   253: ldc 104
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: sipush 23336
    //   265: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_0
    //   271: ldc 153
    //   273: aload_0
    //   274: ldc 104
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: sipush 23336
    //   286: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aconst_null
    //   290: areturn
    //   291: astore_0
    //   292: ldc 153
    //   294: aload_0
    //   295: ldc 104
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: sipush 23336
    //   307: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore_0
    //   313: aconst_null
    //   314: astore 5
    //   316: aconst_null
    //   317: astore_3
    //   318: aload_3
    //   319: ifnull +11 -> 330
    //   322: aload_3
    //   323: invokevirtual 347	java/io/OutputStream:flush	()V
    //   326: aload_3
    //   327: invokevirtual 350	java/io/OutputStream:close	()V
    //   330: aload 5
    //   332: ifnull +8 -> 340
    //   335: aload 5
    //   337: invokevirtual 351	java/io/InputStream:close	()V
    //   340: sipush 23336
    //   343: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: aload_0
    //   347: athrow
    //   348: astore_0
    //   349: ldc 153
    //   351: aload_0
    //   352: ldc 104
    //   354: iconst_0
    //   355: anewarray 4	java/lang/Object
    //   358: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: sipush 23336
    //   364: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aconst_null
    //   368: areturn
    //   369: astore_0
    //   370: ldc 153
    //   372: aload_0
    //   373: ldc 104
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: sipush 23336
    //   385: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aconst_null
    //   389: areturn
    //   390: astore_0
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -76 -> 318
    //   397: astore_0
    //   398: aload 4
    //   400: astore_3
    //   401: goto -83 -> 318
    //   404: astore 6
    //   406: aconst_null
    //   407: astore_0
    //   408: aconst_null
    //   409: astore_3
    //   410: goto -261 -> 149
    //   413: astore 6
    //   415: aconst_null
    //   416: astore_0
    //   417: goto -268 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramString	String
    //   0	420	1	paramLong	long
    //   30	380	3	localObject1	Object
    //   51	348	4	localObject2	Object
    //   104	289	5	str1	String
    //   78	11	6	str2	String
    //   147	79	6	localIOException1	java.io.IOException
    //   404	1	6	localIOException2	java.io.IOException
    //   413	1	6	localIOException3	java.io.IOException
    //   114	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   109	116	147	java/io/IOException
    //   122	132	147	java/io/IOException
    //   138	144	147	java/io/IOException
    //   203	211	228	java/io/IOException
    //   215	219	249	java/io/IOException
    //   179	187	270	java/io/IOException
    //   191	195	291	java/io/IOException
    //   80	98	312	finally
    //   322	330	348	java/io/IOException
    //   335	340	369	java/io/IOException
    //   98	103	390	finally
    //   109	116	397	finally
    //   122	132	397	finally
    //   138	144	397	finally
    //   155	175	397	finally
    //   80	98	404	java/io/IOException
    //   98	103	413	java/io/IOException
  }
  
  /* Error */
  public static byte[] adm(String paramString)
  {
    // Byte code:
    //   0: sipush 23332
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 153
    //   8: ldc_w 361
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 167	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: aconst_null
    //   24: invokestatic 366	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 368
    //   32: invokevirtual 373	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: sipush 25000
    //   39: invokevirtual 376	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   42: aload_2
    //   43: sipush 25000
    //   46: invokevirtual 379	com/tencent/mm/network/v:setReadTimeout	(I)V
    //   49: aload_2
    //   50: invokevirtual 383	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 386	com/tencent/mm/network/v:getResponseCode	()I
    //   58: sipush 200
    //   61: if_icmpne +235 -> 296
    //   64: new 388	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 389	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore_0
    //   72: aload_2
    //   73: astore 7
    //   75: aload_3
    //   76: astore 6
    //   78: aload_0
    //   79: astore 5
    //   81: sipush 1024
    //   84: newarray byte
    //   86: astore 4
    //   88: aload_2
    //   89: astore 7
    //   91: aload_3
    //   92: astore 6
    //   94: aload_0
    //   95: astore 5
    //   97: aload_3
    //   98: aload 4
    //   100: invokevirtual 330	java/io/InputStream:read	([B)I
    //   103: istore_1
    //   104: iload_1
    //   105: iconst_m1
    //   106: if_icmpeq +79 -> 185
    //   109: aload_2
    //   110: astore 7
    //   112: aload_3
    //   113: astore 6
    //   115: aload_0
    //   116: astore 5
    //   118: aload_0
    //   119: aload 4
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 392	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore 4
    //   131: aload_2
    //   132: astore 7
    //   134: aload_3
    //   135: astore 6
    //   137: aload_0
    //   138: astore 5
    //   140: ldc 153
    //   142: aload 4
    //   144: ldc 104
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 393	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 351	java/io/InputStream:close	()V
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 396	com/tencent/mm/network/v:disconnect	()V
    //   177: sipush 23332
    //   180: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_2
    //   186: astore 7
    //   188: aload_3
    //   189: astore 6
    //   191: aload_0
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 393	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_2
    //   199: astore 7
    //   201: aload_3
    //   202: astore 6
    //   204: aload_0
    //   205: astore 5
    //   207: aload_3
    //   208: invokevirtual 351	java/io/InputStream:close	()V
    //   211: aload_2
    //   212: astore 7
    //   214: aload_3
    //   215: astore 6
    //   217: aload_0
    //   218: astore 5
    //   220: aload_2
    //   221: invokevirtual 396	com/tencent/mm/network/v:disconnect	()V
    //   224: aload_2
    //   225: astore 7
    //   227: aload_3
    //   228: astore 6
    //   230: aload_0
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 400	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   237: astore 4
    //   239: aload_0
    //   240: invokevirtual 393	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 351	java/io/InputStream:close	()V
    //   251: aload_2
    //   252: invokevirtual 396	com/tencent/mm/network/v:disconnect	()V
    //   255: sipush 23332
    //   258: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload 4
    //   263: areturn
    //   264: astore_0
    //   265: ldc 153
    //   267: aload_0
    //   268: ldc 104
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: goto -34 -> 243
    //   280: astore_0
    //   281: ldc 153
    //   283: aload_0
    //   284: ldc 104
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -42 -> 251
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 351	java/io/InputStream:close	()V
    //   304: aload_2
    //   305: invokevirtual 396	com/tencent/mm/network/v:disconnect	()V
    //   308: goto -131 -> 177
    //   311: astore_0
    //   312: ldc 153
    //   314: aload_0
    //   315: ldc 104
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -20 -> 304
    //   327: astore_0
    //   328: ldc 153
    //   330: aload_0
    //   331: ldc 104
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -179 -> 161
    //   343: astore_0
    //   344: ldc 153
    //   346: aload_0
    //   347: ldc 104
    //   349: iconst_0
    //   350: anewarray 4	java/lang/Object
    //   353: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: goto -187 -> 169
    //   359: astore_0
    //   360: aconst_null
    //   361: astore 7
    //   363: aconst_null
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: aload_2
    //   368: ifnull +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 393	java/io/ByteArrayOutputStream:close	()V
    //   375: aload_3
    //   376: ifnull +7 -> 383
    //   379: aload_3
    //   380: invokevirtual 351	java/io/InputStream:close	()V
    //   383: aload 7
    //   385: ifnull +8 -> 393
    //   388: aload 7
    //   390: invokevirtual 396	com/tencent/mm/network/v:disconnect	()V
    //   393: sipush 23332
    //   396: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_0
    //   400: athrow
    //   401: astore_2
    //   402: ldc 153
    //   404: aload_2
    //   405: ldc 104
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: goto -39 -> 375
    //   417: astore_2
    //   418: ldc 153
    //   420: aload_2
    //   421: ldc 104
    //   423: iconst_0
    //   424: anewarray 4	java/lang/Object
    //   427: invokestatic 355	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: goto -47 -> 383
    //   433: astore_0
    //   434: aconst_null
    //   435: astore_3
    //   436: aconst_null
    //   437: astore 4
    //   439: aload_2
    //   440: astore 7
    //   442: aload 4
    //   444: astore_2
    //   445: goto -78 -> 367
    //   448: astore_0
    //   449: aconst_null
    //   450: astore 4
    //   452: aload_2
    //   453: astore 7
    //   455: aload 4
    //   457: astore_2
    //   458: goto -91 -> 367
    //   461: astore_0
    //   462: aload 6
    //   464: astore_3
    //   465: aload 5
    //   467: astore_2
    //   468: goto -101 -> 367
    //   471: astore 4
    //   473: aconst_null
    //   474: astore_2
    //   475: aconst_null
    //   476: astore_3
    //   477: aconst_null
    //   478: astore_0
    //   479: goto -348 -> 131
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_3
    //   486: aconst_null
    //   487: astore_0
    //   488: goto -357 -> 131
    //   491: astore 4
    //   493: aconst_null
    //   494: astore_0
    //   495: goto -364 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	paramString	String
    //   103	20	1	i	int
    //   27	345	2	localv	com.tencent.mm.network.v
    //   401	4	2	localIOException1	java.io.IOException
    //   417	23	2	localIOException2	java.io.IOException
    //   444	31	2	localObject1	Object
    //   53	433	3	localObject2	Object
    //   86	34	4	arrayOfByte1	byte[]
    //   129	14	4	localException1	Exception
    //   237	219	4	arrayOfByte2	byte[]
    //   471	1	4	localException2	Exception
    //   482	1	4	localException3	Exception
    //   491	1	4	localException4	Exception
    //   79	387	5	str	String
    //   76	387	6	localObject3	Object
    //   73	381	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	88	129	java/lang/Exception
    //   97	104	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   194	198	129	java/lang/Exception
    //   207	211	129	java/lang/Exception
    //   220	224	129	java/lang/Exception
    //   233	239	129	java/lang/Exception
    //   239	243	264	java/io/IOException
    //   247	251	280	java/io/IOException
    //   300	304	311	java/io/IOException
    //   157	161	327	java/io/IOException
    //   165	169	343	java/io/IOException
    //   22	28	359	finally
    //   371	375	401	java/io/IOException
    //   379	383	417	java/io/IOException
    //   28	54	433	finally
    //   54	72	448	finally
    //   81	88	461	finally
    //   97	104	461	finally
    //   118	126	461	finally
    //   140	153	461	finally
    //   194	198	461	finally
    //   207	211	461	finally
    //   220	224	461	finally
    //   233	239	461	finally
    //   22	28	471	java/lang/Exception
    //   28	54	482	java/lang/Exception
    //   54	72	491	java/lang/Exception
  }
  
  static String c(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(23340);
    if (paramb == null)
    {
      AppMethodBeat.o(23340);
      return "";
    }
    String str = null;
    if (!bu.isNullOrNil(paramb.fhy)) {
      str = paramb.fhy;
    }
    for (;;)
    {
      paramb = bu.nullAsNil(str);
      AppMethodBeat.o(23340);
      return paramb;
      if (!bu.isNullOrNil(paramb.fhz)) {
        str = paramb.fhz;
      } else if (paramb.field_mac != 0L) {
        str = com.tencent.mm.plugin.exdevice.k.b.vf(paramb.field_mac);
      } else if (!bu.isNullOrNil(paramb.field_deviceID)) {
        str = paramb.field_deviceID;
      }
    }
  }
  
  static void fG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23338);
    ew localew = new ew();
    localew.drd.drf = paramString2;
    localew.drd.cVh = paramString1;
    a.IvT.l(localew);
    AppMethodBeat.o(23338);
  }
  
  static Boolean uJ(long paramLong)
  {
    AppMethodBeat.i(23328);
    boolean bool2 = false;
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23328);
      return localObject;
    }
    String str = ((ei)localObject).field_content;
    boolean bool1 = bool2;
    if (((bv)localObject).getType() == 49)
    {
      localObject = k.b.zb(str);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((k.b)localObject).type == 6) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(23328);
    return Boolean.valueOf(bool1);
  }
  
  static Boolean uK(long paramLong)
  {
    AppMethodBeat.i(23329);
    boolean bool = false;
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23329);
      return localObject;
    }
    if (((bv)localObject).getType() == 3) {
      bool = true;
    }
    AppMethodBeat.o(23329);
    return Boolean.valueOf(bool);
  }
  
  static Boolean uL(long paramLong)
  {
    AppMethodBeat.i(23330);
    boolean bool = false;
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23330);
      return localObject;
    }
    if (((bv)localObject).fvK()) {
      bool = true;
    }
    AppMethodBeat.o(23330);
    return Boolean.valueOf(bool);
  }
  
  static Boolean uM(long paramLong)
  {
    AppMethodBeat.i(23331);
    boolean bool = false;
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23331);
      return localObject;
    }
    if (((bv)localObject).getType() == 62) {
      bool = true;
    }
    AppMethodBeat.o(23331);
    return Boolean.valueOf(bool);
  }
  
  private String uN(long paramLong)
  {
    AppMethodBeat.i(23337);
    String str = "";
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject1).field_msgId == 0L)
    {
      AppMethodBeat.o(23337);
      return "";
    }
    int i = ((bv)localObject1).getType();
    Object localObject2 = ((ei)localObject1).field_content;
    if (((bv)localObject1).cVH())
    {
      localObject2 = k.b.zb((String)localObject2);
      if ((localObject2 != null) && ((((k.b)localObject2).type == 6) || (((k.b)localObject2).type == 2)))
      {
        localObject1 = ao.bJV().aMZ(((k.b)localObject2).dlu);
        if (localObject1 != null) {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23337);
      return localObject1;
      ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
      localObject1 = str;
      continue;
      localObject1 = str;
      if (localObject2 != null) {
        if (((k.b)localObject2).type != 3)
        {
          localObject1 = str;
          if (((k.b)localObject2).type != 5) {}
        }
        else
        {
          this.qiu = true;
          localObject1 = str;
          continue;
          if (i == 3)
          {
            localObject2 = com.tencent.mm.av.q.aIX().L((bv)localObject1);
            localObject1 = str;
            if (localObject2 != null)
            {
              str = com.tencent.mm.av.q.aIX().FO(((com.tencent.mm.av.g)localObject2).ico);
              localObject1 = str;
              if (bu.isNullOrNil(str)) {
                localObject1 = com.tencent.mm.av.q.aIX().FO(((com.tencent.mm.av.g)localObject2).icq);
              }
            }
          }
          else if (i == 62)
          {
            com.tencent.mm.modelvideo.o.aNh();
            localObject1 = t.HJ(((ei)localObject1).field_imgPath);
          }
          else
          {
            localObject1 = str;
            if (i == 48)
            {
              this.qiu = true;
              localObject1 = str;
            }
          }
        }
      }
    }
  }
  
  final bzh a(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(23333);
    paramTimeLineObject = paramTimeLineObject.HUG.Gtx.iterator();
    while (paramTimeLineObject.hasNext())
    {
      bzh localbzh = (bzh)paramTimeLineObject.next();
      if (localbzh.Id.equals(this.qiy))
      {
        AppMethodBeat.o(23333);
        return localbzh;
      }
    }
    AppMethodBeat.o(23333);
    return null;
  }
  
  final boolean a(bpm parambpm, long paramLong)
  {
    AppMethodBeat.i(23335);
    int j = -1;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str = uN(paramLong);
    Object localObject3 = localObject6;
    Object localObject2 = localObject5;
    Object localObject1 = localObject4;
    int i = j;
    if (str != null)
    {
      localObject3 = localObject6;
      localObject2 = localObject5;
      localObject1 = localObject4;
      i = j;
      if (str.length() > 0)
      {
        localObject1 = new k(str);
        localObject2 = ((k)localObject1).getName();
        i = (int)((k)localObject1).length();
        localObject3 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1, ((String)localObject2).length());
        localObject1 = com.tencent.mm.vfs.o.aRh(str);
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[] { str });
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[] { Integer.valueOf(i) });
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[] { localObject1 });
      }
    }
    bc.aCg();
    localObject4 = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject4).field_msgId == 0L)
    {
      ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
      AppMethodBeat.o(23335);
      return false;
    }
    switch (((bv)localObject4).getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23335);
      return true;
      localObject3 = k.b.zb(((ei)localObject4).field_content);
      if (localObject3 == null)
      {
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
        AppMethodBeat.o(23335);
        return false;
      }
      if (((k.b)localObject3).type == 3)
      {
        localObject1 = new bpp();
        ((bpp)localObject1).Title = ((k.b)localObject3).title;
        ((bpp)localObject1).Hdj = ((k.b)localObject3).description;
        ((bpp)localObject1).Url = ((k.b)localObject3).url;
        ((bpp)localObject1).Hdk = ((k.b)localObject3).hCB;
        ((bpp)localObject1).Gpz = ((k.b)localObject3).hCY;
        ((bpp)localObject1).Hdl = ((k.b)localObject3).hCZ;
        ((bpp)localObject1).uuo = ((k.b)localObject3).appName;
        if (bu.isNullOrNil(((bpp)localObject1).uuo))
        {
          localObject2 = h.gg(((k.b)localObject3).appId, ((k.b)localObject3).aDD);
          if (localObject2 != null) {
            ((bpp)localObject1).uuo = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        ((bpp)localObject1).Hdm = ((k.b)localObject3).hCS;
        ((bpp)localObject1).Hdn = ((k.b)localObject3).hCT;
        ((bpp)localObject1).Hdo = ((k.b)localObject3).hCW;
        parambpm.HcY = ((bpp)localObject1);
        parambpm.HcX = 1;
      }
      else if (((k.b)localObject3).type == 6)
      {
        localObject2 = new bpl();
        ((bpl)localObject2).Type = ((k.b)localObject3).hCD;
        ((bpl)localObject2).Name = ((k.b)localObject3).title;
        ((bpl)localObject2).nJv = i;
        ((bpl)localObject2).Md5 = ((String)localObject1);
        parambpm.Hdb = ((bpl)localObject2);
        parambpm.HcX = 4;
      }
      else if (((k.b)localObject3).type == 5)
      {
        localObject1 = new bpq();
        ((bpq)localObject1).Url = ((k.b)localObject3).url;
        ((bpq)localObject1).Title = ((k.b)localObject3).title;
        ((bpq)localObject1).Hdj = ((k.b)localObject3).description;
        ((bpq)localObject1).uuo = ((k.b)localObject3).appName;
        if (bu.isNullOrNil(((bpq)localObject1).uuo))
        {
          localObject2 = h.gg(((k.b)localObject3).appId, ((k.b)localObject3).aDD);
          if (localObject2 != null) {
            ((bpq)localObject1).uuo = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        parambpm.Hdc = ((bpq)localObject1);
        parambpm.HcX = 5;
      }
      else if (((k.b)localObject3).type == 2)
      {
        localObject3 = new bpn();
        ((bpn)localObject3).Type = "jpg";
        ((bpn)localObject3).Name = ((String)localObject2);
        ((bpn)localObject3).nJv = i;
        ((bpn)localObject3).Md5 = ((String)localObject1);
        parambpm.Hda = ((bpn)localObject3);
        parambpm.HcX = 3;
        continue;
        localObject4 = new bpn();
        ((bpn)localObject4).Type = ((String)localObject3);
        ((bpn)localObject4).Name = ((String)localObject2);
        ((bpn)localObject4).nJv = i;
        ((bpn)localObject4).Md5 = ((String)localObject1);
        parambpm.Hda = ((bpn)localObject4);
        parambpm.HcX = 3;
        continue;
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azI().arq(((ei)localObject4).field_content);
        localObject2 = new bpo();
        ((bpo)localObject2).Hdf = ((float)((bv.b)localObject1).vlC);
        ((bpo)localObject2).Hdg = ((float)((bv.b)localObject1).vlD);
        ((bpo)localObject2).Hdh = ((bv.b)localObject1).dzG;
        ((bpo)localObject2).Label = ((bv.b)localObject1).label;
        ((bpo)localObject2).Hdi = ((bv.b)localObject1).jGd;
        parambpm.HcZ = ((bpo)localObject2);
        parambpm.HcX = 2;
        continue;
        localObject4 = new bpr();
        ((bpr)localObject4).Type = ((String)localObject3);
        ((bpr)localObject4).nJv = i;
        ((bpr)localObject4).Md5 = ((String)localObject1);
        ((bpr)localObject4).Name = ((String)localObject2);
        parambpm.Hdd = ((bpr)localObject4);
        parambpm.HcX = 6;
      }
    }
  }
  
  public final TimeLineObject cmy()
  {
    AppMethodBeat.i(23334);
    Object localObject = new jq();
    ((jq)localObject).dxy.dqc = this.qiw;
    a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jq)localObject).dxz.dxA;
    AppMethodBeat.o(23334);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(23339);
    ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
      AppMethodBeat.o(23339);
      return;
    }
    if ((paramn instanceof n))
    {
      Object localObject = (n)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        fG(((n)localObject).cVh, this.qiA);
        AppMethodBeat.o(23339);
        return;
      }
      if ((((n)localObject).rr != null) && (((n)localObject).rr.hQE.hQJ != null)) {}
      for (paramString = (dpu)((n)localObject).rr.hQE.hQJ;; paramString = null)
      {
        paramn = paramString.HWR;
        if (1 != ((n)localObject).qjB) {
          break;
        }
        fG(((n)localObject).cVh, this.qiz);
        AppMethodBeat.o(23339);
        return;
      }
      localObject = ((n)localObject).cVh;
      String str = (String)this.qiJ.get(localObject);
      fG((String)localObject, this.qiB);
      if ((this.qiv) && (this.qiw != null)) {}
      for (paramString = this.qix; (str == null) || (str.length() == 0); paramString = uN(this.fIR))
      {
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
        fG((String)localObject, this.qiA);
        AppMethodBeat.o(23339);
        return;
      }
      if (!this.qit)
      {
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
        Java2CExDevice.stopScanWCLanDevice();
        this.qit = true;
      }
      if ((!this.qiL.containsKey(localObject)) || (!((Boolean)this.qiL.get(localObject)).booleanValue()))
      {
        ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str)));
        if (Java2CExDevice.connectWCLanDevice(str.getBytes(), true) != 0)
        {
          fG((String)localObject, this.qiA);
          ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
        }
      }
      if (this.qiu)
      {
        paramInt1 = Java2CExDevice.useWCLanDeviceService(str.getBytes(), paramn.getBytes());
        if (paramInt1 != 0)
        {
          this.qiV.put(Integer.valueOf(paramInt1), localObject);
          this.qiK.put(localObject, Integer.valueOf(paramInt1));
          ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(paramInt1)));
          AppMethodBeat.o(23339);
          return;
        }
        fG((String)localObject, this.qiA);
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
        AppMethodBeat.o(23339);
        return;
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
        fG((String)localObject, this.qiA);
        AppMethodBeat.o(23339);
        return;
      }
      ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendDataToNearFieldDevice %s", new Object[] { paramString });
      paramString = com.tencent.mm.b.q.k(paramString, false);
      paramInt1 = Java2CExDevice.sendFileToWCLanDevice(str.getBytes(), paramn.getBytes(), paramString.getBytes());
      if (paramInt1 != 0)
      {
        this.qiV.put(Integer.valueOf(paramInt1), localObject);
        this.qiK.put(localObject, Integer.valueOf(paramInt1));
        ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(23339);
        return;
      }
      fG((String)localObject, this.qiA);
      ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
    }
    AppMethodBeat.o(23339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g
 * JD-Core Version:    0.7.0.1
 */