package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class g
  implements com.tencent.mm.al.g
{
  String dpz;
  long fYz;
  long fll;
  String hhN;
  public g.a hhW;
  boolean oUY;
  boolean oUZ;
  HashMap<Integer, String> oVA;
  boolean oVa;
  String oVb;
  String oVc;
  String oVd;
  String oVe;
  String oVf;
  private String oVg;
  boolean oVh;
  boolean oVi;
  public HashMap<String, String> oVj;
  bgs oVk;
  long oVl;
  List<com.tencent.mm.plugin.exdevice.i.b> oVm;
  List<com.tencent.mm.plugin.exdevice.i.b> oVn;
  HashMap<String, String> oVo;
  HashMap<String, Integer> oVp;
  HashMap<String, Boolean> oVq;
  j.a oVr;
  j.a oVs;
  j.a oVt;
  j.a oVu;
  Runnable oVv;
  bgs oVw;
  String oVx;
  String oVy;
  int oVz;
  
  public g()
  {
    AppMethodBeat.i(23327);
    this.oUY = false;
    this.oUZ = false;
    this.oVa = false;
    this.oVe = "send_data_sucess";
    this.oVf = "send_data_failed";
    this.oVg = "send_data_sending";
    this.oVh = false;
    this.oVi = false;
    this.oVj = new HashMap();
    this.hhN = "";
    this.oVm = null;
    this.oVn = new ArrayList();
    this.oVo = new HashMap();
    this.oVp = new HashMap();
    this.oVq = new HashMap();
    this.oVv = new Runnable()
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
        //   13: invokestatic 38	com/tencent/mm/loader/j/b:aip	()Ljava/lang/String;
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
        //   33: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   36: getfield 50	com/tencent/mm/plugin/exdevice/model/g:dpz	Ljava/lang/String;
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
        //   63: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   66: getfield 50	com/tencent/mm/plugin/exdevice/model/g:dpz	Ljava/lang/String;
        //   69: invokestatic 75	com/tencent/mm/plugin/exdevice/model/g:UD	(Ljava/lang/String;)[B
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
        //   87: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   90: astore 6
        //   92: aload 5
        //   94: iconst_0
        //   95: invokestatic 87	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
        //   128: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   131: aload 5
        //   133: putfield 110	com/tencent/mm/plugin/exdevice/model/g:oVc	Ljava/lang/String;
        //   136: aload_0
        //   137: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   140: getfield 110	com/tencent/mm/plugin/exdevice/model/g:oVc	Ljava/lang/String;
        //   143: ifnonnull +219 -> 362
        //   146: aload_0
        //   147: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   150: getfield 110	com/tencent/mm/plugin/exdevice/model/g:oVc	Ljava/lang/String;
        //   153: invokestatic 114	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
        //   156: ifne +206 -> 362
        //   159: ldc 116
        //   161: ldc 118
        //   163: invokestatic 124	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   166: aload_0
        //   167: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   170: getfield 127	com/tencent/mm/plugin/exdevice/model/g:oVy	Ljava/lang/String;
        //   173: aload_0
        //   174: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   177: getfield 130	com/tencent/mm/plugin/exdevice/model/g:oVf	Ljava/lang/String;
        //   180: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:ff	(Ljava/lang/String;Ljava/lang/String;)V
        //   183: sipush 23317
        //   186: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   189: return
        //   190: astore_2
        //   191: ldc 116
        //   193: aload_2
        //   194: ldc 138
        //   196: iconst_0
        //   197: anewarray 4	java/lang/Object
        //   200: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   203: goto -76 -> 127
        //   206: astore_2
        //   207: ldc 116
        //   209: aload_2
        //   210: ldc 138
        //   212: iconst_0
        //   213: anewarray 4	java/lang/Object
        //   216: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   236: invokestatic 124	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   239: aload_3
        //   240: astore_2
        //   241: aload 6
        //   243: getfield 127	com/tencent/mm/plugin/exdevice/model/g:oVy	Ljava/lang/String;
        //   246: aload 6
        //   248: getfield 130	com/tencent/mm/plugin/exdevice/model/g:oVf	Ljava/lang/String;
        //   251: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:ff	(Ljava/lang/String;Ljava/lang/String;)V
        //   254: aload_3
        //   255: astore_2
        //   256: ldc 116
        //   258: aload 4
        //   260: ldc 138
        //   262: iconst_0
        //   263: anewarray 4	java/lang/Object
        //   266: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   290: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   325: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   328: goto -21 -> 307
        //   331: ldc 116
        //   333: ldc 146
        //   335: invokestatic 124	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   338: aload_0
        //   339: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   342: getfield 127	com/tencent/mm/plugin/exdevice/model/g:oVy	Ljava/lang/String;
        //   345: aload_0
        //   346: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   349: getfield 130	com/tencent/mm/plugin/exdevice/model/g:oVf	Ljava/lang/String;
        //   352: invokestatic 133	com/tencent/mm/plugin/exdevice/model/g:ff	(Ljava/lang/String;Ljava/lang/String;)V
        //   355: sipush 23317
        //   358: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   361: return
        //   362: iconst_m1
        //   363: istore_1
        //   364: new 148	com/tencent/mm/protocal/protobuf/bgt
        //   367: dup
        //   368: invokespecial 149	com/tencent/mm/protocal/protobuf/bgt:<init>	()V
        //   371: astore 5
        //   373: aload_0
        //   374: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   377: getfield 110	com/tencent/mm/plugin/exdevice/model/g:oVc	Ljava/lang/String;
        //   380: astore 6
        //   382: aload 6
        //   384: ifnull +215 -> 599
        //   387: aload 6
        //   389: invokevirtual 152	java/lang/String:length	()I
        //   392: ifle +207 -> 599
        //   395: new 154	com/tencent/mm/vfs/e
        //   398: dup
        //   399: aload 6
        //   401: invokespecial 157	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   404: astore_2
        //   405: aload_2
        //   406: invokevirtual 160	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
        //   409: astore_3
        //   410: aload_2
        //   411: invokevirtual 163	com/tencent/mm/vfs/e:length	()J
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
        //   435: invokestatic 177	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
        //   438: astore 4
        //   440: ldc 116
        //   442: ldc 179
        //   444: iconst_1
        //   445: anewarray 4	java/lang/Object
        //   448: dup
        //   449: iconst_0
        //   450: aload 6
        //   452: aastore
        //   453: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   456: ldc 116
        //   458: ldc 184
        //   460: iconst_1
        //   461: anewarray 4	java/lang/Object
        //   464: dup
        //   465: iconst_0
        //   466: iload_1
        //   467: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   470: aastore
        //   471: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   474: ldc 116
        //   476: ldc 186
        //   478: iconst_1
        //   479: anewarray 4	java/lang/Object
        //   482: dup
        //   483: iconst_0
        //   484: aload 4
        //   486: aastore
        //   487: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   490: aload 5
        //   492: aload_2
        //   493: putfield 189	com/tencent/mm/protocal/protobuf/bgt:Type	Ljava/lang/String;
        //   496: aload 5
        //   498: aload_3
        //   499: putfield 192	com/tencent/mm/protocal/protobuf/bgt:Name	Ljava/lang/String;
        //   502: aload 5
        //   504: iload_1
        //   505: putfield 196	com/tencent/mm/protocal/protobuf/bgt:mBC	I
        //   508: aload 5
        //   510: aload 4
        //   512: putfield 199	com/tencent/mm/protocal/protobuf/bgt:Md5	Ljava/lang/String;
        //   515: aload_0
        //   516: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   519: getfield 203	com/tencent/mm/plugin/exdevice/model/g:oVw	Lcom/tencent/mm/protocal/protobuf/bgs;
        //   522: aload 5
        //   524: putfield 209	com/tencent/mm/protocal/protobuf/bgs:DEF	Lcom/tencent/mm/protocal/protobuf/bgt;
        //   527: aload_0
        //   528: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   531: getfield 203	com/tencent/mm/plugin/exdevice/model/g:oVw	Lcom/tencent/mm/protocal/protobuf/bgs;
        //   534: iconst_3
        //   535: putfield 212	com/tencent/mm/protocal/protobuf/bgs:DEC	I
        //   538: new 214	com/tencent/mm/plugin/exdevice/model/n
        //   541: dup
        //   542: aload_0
        //   543: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   546: getfield 203	com/tencent/mm/plugin/exdevice/model/g:oVw	Lcom/tencent/mm/protocal/protobuf/bgs;
        //   549: aload_0
        //   550: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   553: getfield 217	com/tencent/mm/plugin/exdevice/model/g:oVx	Ljava/lang/String;
        //   556: aload_0
        //   557: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   560: getfield 127	com/tencent/mm/plugin/exdevice/model/g:oVy	Ljava/lang/String;
        //   563: aload_0
        //   564: getfield 14	com/tencent/mm/plugin/exdevice/model/g$1:oVB	Lcom/tencent/mm/plugin/exdevice/model/g;
        //   567: getfield 220	com/tencent/mm/plugin/exdevice/model/g:oVz	I
        //   570: invokespecial 223	com/tencent/mm/plugin/exdevice/model/n:<init>	(Lcom/tencent/mm/protocal/protobuf/bgs;Ljava/lang/String;Ljava/lang/String;I)V
        //   573: astore_2
        //   574: invokestatic 229	com/tencent/mm/model/az:aeS	()Lcom/tencent/mm/al/q;
        //   577: aload_2
        //   578: iconst_0
        //   579: invokevirtual 235	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
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
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(23318);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[] { g.this.hhN, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(g.this.oVh) });
        if (paramAnonymousc != null) {}
        label560:
        label568:
        for (;;)
        {
          try
          {
            paramAnonymousInt = (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt < 100) {
              break label568;
            }
            paramAnonymousInt = 99;
            paramAnonymousString = g.this.oVj.keySet().iterator();
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
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(23318);
            return 0;
          }
          if (g.this.oVh)
          {
            paramAnonymousString = new bgs();
            g.this.a(paramAnonymousString, g.this.fll);
            g.this.oVh = false;
            if ((g.oJ(g.this.fll).booleanValue()) || (g.oK(g.this.fll).booleanValue()))
            {
              paramAnonymousString.DEF.COP = paramAnonymousd.field_aesKey;
              paramAnonymousString.DEF.DEJ = g.this.oVl;
              paramAnonymousString.DEF.CCm = paramAnonymousd.field_fileId;
              paramAnonymousString.DEF.Url = paramAnonymousd.field_fileUrl;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[] { paramAnonymousString.DEF.Url });
            }
            for (;;)
            {
              g.this.oVk = paramAnonymousString;
              paramAnonymousc = g.this.oVj.keySet().iterator();
              while (paramAnonymousc.hasNext())
              {
                paramAnonymousd = (String)paramAnonymousc.next();
                paramAnonymousd = new n(paramAnonymousString, (String)g.this.oVj.get(paramAnonymousd), paramAnonymousd, 1);
                az.aeS().a(paramAnonymousd, 0);
              }
              if (g.oI(g.this.fll).booleanValue())
              {
                paramAnonymousString.DEG.COP = paramAnonymousd.field_aesKey;
                paramAnonymousString.DEG.CCm = paramAnonymousd.field_fileId;
                paramAnonymousString.DEG.Url = paramAnonymousd.field_fileUrl;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[] { paramAnonymousString.DEG.Url });
              }
              else if (g.oL(g.this.fll).booleanValue())
              {
                paramAnonymousString.DEI.Url = paramAnonymousd.field_fileUrl;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[] { paramAnonymousString.DEI.Url });
              }
            }
            g.this.oVj.clear();
          }
          AppMethodBeat.o(23318);
          return 0;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(23319);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(23319);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23320);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
        AppMethodBeat.o(23320);
        return paramAnonymousArrayOfByte;
      }
    };
    this.oVA = new HashMap();
    this.oVn.clear();
    this.oVo.clear();
    this.oVq.clear();
    this.oVm = ad.bZG().cak();
    if ((this.oVm != null) && (this.oVm.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[] { Integer.valueOf(this.oVm.size()) });
      int j = this.oVm.size();
      int i = 0;
      while (i < j)
      {
        if ((((com.tencent.mm.plugin.exdevice.i.b)this.oVm.get(i)).eKt.contains("internet_to_device")) && (!((com.tencent.mm.plugin.exdevice.i.b)this.oVm.get(i)).eKt.contains("wechat_to_device"))) {
          this.oVn.add(this.oVm.get(i));
        }
        i += 1;
      }
      this.oVu = new g.3(this);
      this.oVr = new g.4(this);
      this.oVs = new g.5(this);
      this.oVt = new g.6(this);
      az.aeS().a(1717, this);
      j.bZx().a(14, this.oVr);
      j.bZx().a(12, this.oVs);
      j.bZx().a(13, this.oVt);
      j.bZx().a(15, this.oVu);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
      Java2CExDevice.initWCLanDeviceLib();
    }
    AppMethodBeat.o(23327);
  }
  
  /* Error */
  static String U(String paramString, long paramLong)
  {
    // Byte code:
    //   0: sipush 23336
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 23336
    //   13: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: iconst_0
    //   20: aload_0
    //   21: ldc 247
    //   23: invokevirtual 251	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   26: invokevirtual 255	java/lang/String:substring	(II)Ljava/lang/String;
    //   29: astore_3
    //   30: new 257	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 259
    //   37: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 265	java/lang/String:hashCode	()I
    //   44: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 4
    //   52: new 257	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   59: aload_3
    //   60: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 247
    //   65: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 4
    //   70: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 6
    //   78: new 279	com/tencent/mm/modelsfs/b
    //   81: dup
    //   82: new 281	com/tencent/mm/vfs/e
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 282	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   91: lload_1
    //   92: invokespecial 285	com/tencent/mm/modelsfs/b:<init>	(Lcom/tencent/mm/vfs/e;J)V
    //   95: astore_3
    //   96: aload_0
    //   97: invokestatic 291	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   100: astore_0
    //   101: aload_0
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: sipush 1024
    //   110: newarray byte
    //   112: astore 7
    //   114: aload_0
    //   115: astore 5
    //   117: aload_3
    //   118: astore 4
    //   120: aload_0
    //   121: aload 7
    //   123: invokevirtual 297	java/io/InputStream:read	([B)I
    //   126: iconst_m1
    //   127: if_icmpeq +74 -> 201
    //   130: aload_0
    //   131: astore 5
    //   133: aload_3
    //   134: astore 4
    //   136: aload_3
    //   137: aload 7
    //   139: invokevirtual 303	java/io/OutputStream:write	([B)V
    //   142: goto -28 -> 114
    //   145: astore 6
    //   147: aload_0
    //   148: astore 5
    //   150: aload_3
    //   151: astore 4
    //   153: ldc 147
    //   155: ldc_w 305
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload 6
    //   166: invokevirtual 308	java/io/IOException:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 311	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_3
    //   174: ifnull +11 -> 185
    //   177: aload_3
    //   178: invokevirtual 314	java/io/OutputStream:flush	()V
    //   181: aload_3
    //   182: invokevirtual 317	java/io/OutputStream:close	()V
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 318	java/io/InputStream:close	()V
    //   193: sipush 23336
    //   196: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aconst_null
    //   200: areturn
    //   201: aload_3
    //   202: invokevirtual 314	java/io/OutputStream:flush	()V
    //   205: aload_3
    //   206: invokevirtual 317	java/io/OutputStream:close	()V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 318	java/io/InputStream:close	()V
    //   217: sipush 23336
    //   220: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload 6
    //   225: areturn
    //   226: astore_0
    //   227: ldc 147
    //   229: aload_0
    //   230: ldc 98
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: sipush 23336
    //   242: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: ldc 147
    //   250: aload_0
    //   251: ldc 98
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: sipush 23336
    //   263: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: ldc 147
    //   271: aload_0
    //   272: ldc 98
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: sipush 23336
    //   284: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aconst_null
    //   288: areturn
    //   289: astore_0
    //   290: ldc 147
    //   292: aload_0
    //   293: ldc 98
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: sipush 23336
    //   305: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aconst_null
    //   309: areturn
    //   310: astore_0
    //   311: aconst_null
    //   312: astore 5
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_3
    //   317: ifnull +11 -> 328
    //   320: aload_3
    //   321: invokevirtual 314	java/io/OutputStream:flush	()V
    //   324: aload_3
    //   325: invokevirtual 317	java/io/OutputStream:close	()V
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 318	java/io/InputStream:close	()V
    //   338: sipush 23336
    //   341: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: ldc 147
    //   349: aload_0
    //   350: ldc 98
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: sipush 23336
    //   362: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: aconst_null
    //   366: areturn
    //   367: astore_0
    //   368: ldc 147
    //   370: aload_0
    //   371: ldc 98
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: sipush 23336
    //   383: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_0
    //   389: aconst_null
    //   390: astore 5
    //   392: goto -76 -> 316
    //   395: astore_0
    //   396: aload 4
    //   398: astore_3
    //   399: goto -83 -> 316
    //   402: astore 6
    //   404: aconst_null
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_3
    //   408: goto -261 -> 147
    //   411: astore 6
    //   413: aconst_null
    //   414: astore_0
    //   415: goto -268 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString	String
    //   0	418	1	paramLong	long
    //   29	379	3	localObject1	Object
    //   50	347	4	localObject2	Object
    //   102	289	5	str1	String
    //   76	11	6	str2	String
    //   145	79	6	localIOException1	java.io.IOException
    //   402	1	6	localIOException2	java.io.IOException
    //   411	1	6	localIOException3	java.io.IOException
    //   112	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	114	145	java/io/IOException
    //   120	130	145	java/io/IOException
    //   136	142	145	java/io/IOException
    //   201	209	226	java/io/IOException
    //   213	217	247	java/io/IOException
    //   177	185	268	java/io/IOException
    //   189	193	289	java/io/IOException
    //   78	96	310	finally
    //   320	328	346	java/io/IOException
    //   333	338	367	java/io/IOException
    //   96	101	388	finally
    //   107	114	395	finally
    //   120	130	395	finally
    //   136	142	395	finally
    //   153	173	395	finally
    //   78	96	402	java/io/IOException
    //   96	101	411	java/io/IOException
  }
  
  /* Error */
  public static byte[] UD(String paramString)
  {
    // Byte code:
    //   0: sipush 23332
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 147
    //   8: ldc_w 328
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 161	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: aconst_null
    //   24: invokestatic 333	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 335
    //   32: invokevirtual 340	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: sipush 25000
    //   39: invokevirtual 343	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   42: aload_2
    //   43: sipush 25000
    //   46: invokevirtual 346	com/tencent/mm/network/v:setReadTimeout	(I)V
    //   49: aload_2
    //   50: invokevirtual 350	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 353	com/tencent/mm/network/v:getResponseCode	()I
    //   58: sipush 200
    //   61: if_icmpne +235 -> 296
    //   64: new 355	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 356	java/io/ByteArrayOutputStream:<init>	()V
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
    //   100: invokevirtual 297	java/io/InputStream:read	([B)I
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
    //   123: invokevirtual 359	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore 4
    //   131: aload_2
    //   132: astore 7
    //   134: aload_3
    //   135: astore 6
    //   137: aload_0
    //   138: astore 5
    //   140: ldc 147
    //   142: aload 4
    //   144: ldc 98
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 318	java/io/InputStream:close	()V
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 363	com/tencent/mm/network/v:disconnect	()V
    //   177: sipush 23332
    //   180: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_2
    //   186: astore 7
    //   188: aload_3
    //   189: astore 6
    //   191: aload_0
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_2
    //   199: astore 7
    //   201: aload_3
    //   202: astore 6
    //   204: aload_0
    //   205: astore 5
    //   207: aload_3
    //   208: invokevirtual 318	java/io/InputStream:close	()V
    //   211: aload_2
    //   212: astore 7
    //   214: aload_3
    //   215: astore 6
    //   217: aload_0
    //   218: astore 5
    //   220: aload_2
    //   221: invokevirtual 363	com/tencent/mm/network/v:disconnect	()V
    //   224: aload_2
    //   225: astore 7
    //   227: aload_3
    //   228: astore 6
    //   230: aload_0
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 367	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   237: astore 4
    //   239: aload_0
    //   240: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 318	java/io/InputStream:close	()V
    //   251: aload_2
    //   252: invokevirtual 363	com/tencent/mm/network/v:disconnect	()V
    //   255: sipush 23332
    //   258: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload 4
    //   263: areturn
    //   264: astore_0
    //   265: ldc 147
    //   267: aload_0
    //   268: ldc 98
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: goto -34 -> 243
    //   280: astore_0
    //   281: ldc 147
    //   283: aload_0
    //   284: ldc 98
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -42 -> 251
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 318	java/io/InputStream:close	()V
    //   304: aload_2
    //   305: invokevirtual 363	com/tencent/mm/network/v:disconnect	()V
    //   308: goto -131 -> 177
    //   311: astore_0
    //   312: ldc 147
    //   314: aload_0
    //   315: ldc 98
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -20 -> 304
    //   327: astore_0
    //   328: ldc 147
    //   330: aload_0
    //   331: ldc 98
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -179 -> 161
    //   343: astore_0
    //   344: ldc 147
    //   346: aload_0
    //   347: ldc 98
    //   349: iconst_0
    //   350: anewarray 4	java/lang/Object
    //   353: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   372: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   375: aload_3
    //   376: ifnull +7 -> 383
    //   379: aload_3
    //   380: invokevirtual 318	java/io/InputStream:close	()V
    //   383: aload 7
    //   385: ifnull +8 -> 393
    //   388: aload 7
    //   390: invokevirtual 363	com/tencent/mm/network/v:disconnect	()V
    //   393: sipush 23332
    //   396: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_0
    //   400: athrow
    //   401: astore_2
    //   402: ldc 147
    //   404: aload_2
    //   405: ldc 98
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: goto -39 -> 375
    //   417: astore_2
    //   418: ldc 147
    //   420: aload_2
    //   421: ldc 98
    //   423: iconst_0
    //   424: anewarray 4	java/lang/Object
    //   427: invokestatic 322	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    if (!bt.isNullOrNil(paramb.eKn)) {
      str = paramb.eKn;
    }
    for (;;)
    {
      paramb = bt.nullAsNil(str);
      AppMethodBeat.o(23340);
      return paramb;
      if (!bt.isNullOrNil(paramb.eKo)) {
        str = paramb.eKo;
      } else if (paramb.field_mac != 0L) {
        str = com.tencent.mm.plugin.exdevice.k.b.pe(paramb.field_mac);
      } else if (!bt.isNullOrNil(paramb.field_deviceID)) {
        str = paramb.field_deviceID;
      }
    }
  }
  
  static void ff(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23338);
    er localer = new er();
    localer.dhh.dhj = paramString2;
    localer.dhh.cLR = paramString1;
    a.ESL.l(localer);
    AppMethodBeat.o(23338);
  }
  
  static Boolean oI(long paramLong)
  {
    AppMethodBeat.i(23328);
    boolean bool2 = false;
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23328);
      return localObject;
    }
    String str = ((du)localObject).field_content;
    boolean bool1 = bool2;
    if (((bl)localObject).getType() == 49)
    {
      localObject = k.b.rx(str);
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
  
  static Boolean oJ(long paramLong)
  {
    AppMethodBeat.i(23329);
    boolean bool = false;
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23329);
      return localObject;
    }
    if (((bl)localObject).getType() == 3) {
      bool = true;
    }
    AppMethodBeat.o(23329);
    return Boolean.valueOf(bool);
  }
  
  static Boolean oK(long paramLong)
  {
    AppMethodBeat.i(23330);
    boolean bool = false;
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23330);
      return localObject;
    }
    if (((bl)localObject).eMb()) {
      bool = true;
    }
    AppMethodBeat.o(23330);
    return Boolean.valueOf(bool);
  }
  
  static Boolean oL(long paramLong)
  {
    AppMethodBeat.i(23331);
    boolean bool = false;
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(23331);
      return localObject;
    }
    if (((bl)localObject).getType() == 62) {
      bool = true;
    }
    AppMethodBeat.o(23331);
    return Boolean.valueOf(bool);
  }
  
  private String oM(long paramLong)
  {
    AppMethodBeat.i(23337);
    String str = "";
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject1).field_msgId == 0L)
    {
      AppMethodBeat.o(23337);
      return "";
    }
    int i = ((bl)localObject1).getType();
    Object localObject2 = ((du)localObject1).field_content;
    if (((bl)localObject1).cxB())
    {
      localObject2 = k.b.rx((String)localObject2);
      if ((localObject2 != null) && ((((k.b)localObject2).type == 6) || (((k.b)localObject2).type == 2)))
      {
        localObject1 = ap.bxS().aAL(((k.b)localObject2).dbA);
        if (localObject1 != null) {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23337);
      return localObject1;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
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
          this.oUZ = true;
          localObject1 = str;
          continue;
          if (i == 3)
          {
            localObject2 = com.tencent.mm.aw.o.ayF().I((bl)localObject1);
            localObject1 = str;
            if (localObject2 != null)
            {
              str = com.tencent.mm.aw.o.ayF().yg(((com.tencent.mm.aw.e)localObject2).hgj);
              localObject1 = str;
              if (bt.isNullOrNil(str)) {
                localObject1 = com.tencent.mm.aw.o.ayF().yg(((com.tencent.mm.aw.e)localObject2).hgl);
              }
            }
          }
          else if (i == 62)
          {
            com.tencent.mm.modelvideo.o.aCI();
            localObject1 = t.zQ(((du)localObject1).field_imgPath);
          }
          else
          {
            localObject1 = str;
            if (i == 48)
            {
              this.oUZ = true;
              localObject1 = str;
            }
          }
        }
      }
    }
  }
  
  final bpi a(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(23333);
    paramTimeLineObject = paramTimeLineObject.Etm.DaC.iterator();
    while (paramTimeLineObject.hasNext())
    {
      bpi localbpi = (bpi)paramTimeLineObject.next();
      if (localbpi.Id.equals(this.oVd))
      {
        AppMethodBeat.o(23333);
        return localbpi;
      }
    }
    AppMethodBeat.o(23333);
    return null;
  }
  
  final boolean a(bgs parambgs, long paramLong)
  {
    AppMethodBeat.i(23335);
    int j = -1;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str = oM(paramLong);
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
        localObject1 = new com.tencent.mm.vfs.e(str);
        localObject2 = ((com.tencent.mm.vfs.e)localObject1).getName();
        i = (int)((com.tencent.mm.vfs.e)localObject1).length();
        localObject3 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1, ((String)localObject2).length());
        localObject1 = i.aEN(str);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[] { str });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[] { localObject1 });
      }
    }
    az.arV();
    localObject4 = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject4).field_msgId == 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
      AppMethodBeat.o(23335);
      return false;
    }
    switch (((bl)localObject4).getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23335);
      return true;
      localObject3 = k.b.rx(((du)localObject4).field_content);
      if (localObject3 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
        AppMethodBeat.o(23335);
        return false;
      }
      if (((k.b)localObject3).type == 3)
      {
        localObject1 = new bgv();
        ((bgv)localObject1).Title = ((k.b)localObject3).title;
        ((bgv)localObject1).DEO = ((k.b)localObject3).description;
        ((bgv)localObject1).Url = ((k.b)localObject3).url;
        ((bgv)localObject1).DEP = ((k.b)localObject3).gHd;
        ((bgv)localObject1).CXg = ((k.b)localObject3).gHA;
        ((bgv)localObject1).DEQ = ((k.b)localObject3).gHB;
        ((bgv)localObject1).scR = ((k.b)localObject3).appName;
        if (bt.isNullOrNil(((bgv)localObject1).scR))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.fv(((k.b)localObject3).appId, ((k.b)localObject3).aAS);
          if (localObject2 != null) {
            ((bgv)localObject1).scR = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        ((bgv)localObject1).DER = ((k.b)localObject3).gHu;
        ((bgv)localObject1).DES = ((k.b)localObject3).gHv;
        ((bgv)localObject1).DET = ((k.b)localObject3).gHy;
        parambgs.DED = ((bgv)localObject1);
        parambgs.DEC = 1;
      }
      else if (((k.b)localObject3).type == 6)
      {
        localObject2 = new bgr();
        ((bgr)localObject2).Type = ((k.b)localObject3).gHf;
        ((bgr)localObject2).Name = ((k.b)localObject3).title;
        ((bgr)localObject2).mBC = i;
        ((bgr)localObject2).Md5 = ((String)localObject1);
        parambgs.DEG = ((bgr)localObject2);
        parambgs.DEC = 4;
      }
      else if (((k.b)localObject3).type == 5)
      {
        localObject1 = new bgw();
        ((bgw)localObject1).Url = ((k.b)localObject3).url;
        ((bgw)localObject1).Title = ((k.b)localObject3).title;
        ((bgw)localObject1).DEO = ((k.b)localObject3).description;
        ((bgw)localObject1).scR = ((k.b)localObject3).appName;
        if (bt.isNullOrNil(((bgw)localObject1).scR))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.fv(((k.b)localObject3).appId, ((k.b)localObject3).aAS);
          if (localObject2 != null) {
            ((bgw)localObject1).scR = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        parambgs.DEH = ((bgw)localObject1);
        parambgs.DEC = 5;
      }
      else if (((k.b)localObject3).type == 2)
      {
        localObject3 = new bgt();
        ((bgt)localObject3).Type = "jpg";
        ((bgt)localObject3).Name = ((String)localObject2);
        ((bgt)localObject3).mBC = i;
        ((bgt)localObject3).Md5 = ((String)localObject1);
        parambgs.DEF = ((bgt)localObject3);
        parambgs.DEC = 3;
        continue;
        localObject4 = new bgt();
        ((bgt)localObject4).Type = ((String)localObject3);
        ((bgt)localObject4).Name = ((String)localObject2);
        ((bgt)localObject4).mBC = i;
        ((bgt)localObject4).Md5 = ((String)localObject1);
        parambgs.DEF = ((bgt)localObject4);
        parambgs.DEC = 3;
        continue;
        az.arV();
        localObject1 = com.tencent.mm.model.c.apO().agD(((du)localObject4).field_content);
        localObject2 = new bgu();
        ((bgu)localObject2).DEK = ((float)((bl.b)localObject1).sOv);
        ((bgu)localObject2).DEL = ((float)((bl.b)localObject1).sOw);
        ((bgu)localObject2).DEM = ((bl.b)localObject1).dpd;
        ((bgu)localObject2).Label = ((bl.b)localObject1).label;
        ((bgu)localObject2).DEN = ((bl.b)localObject1).goQ;
        parambgs.DEE = ((bgu)localObject2);
        parambgs.DEC = 2;
        continue;
        localObject4 = new bgx();
        ((bgx)localObject4).Type = ((String)localObject3);
        ((bgx)localObject4).mBC = i;
        ((bgx)localObject4).Md5 = ((String)localObject1);
        ((bgx)localObject4).Name = ((String)localObject2);
        parambgs.DEI = ((bgx)localObject4);
        parambgs.DEC = 6;
      }
    }
  }
  
  public final TimeLineObject bZv()
  {
    AppMethodBeat.i(23334);
    Object localObject = new ja();
    ((ja)localObject).dmY.dgg = this.oVb;
    a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((ja)localObject).dmZ.dna;
    AppMethodBeat.o(23334);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(23339);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
      AppMethodBeat.o(23339);
      return;
    }
    if ((paramn instanceof n))
    {
      Object localObject = (n)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        ff(((n)localObject).cLR, this.oVf);
        AppMethodBeat.o(23339);
        return;
      }
      if ((((n)localObject).rr != null) && (((n)localObject).rr.gUT.gUX != null)) {}
      for (paramString = (ddt)((n)localObject).rr.gUT.gUX;; paramString = null)
      {
        paramn = paramString.Evs;
        if (1 != ((n)localObject).oWg) {
          break;
        }
        ff(((n)localObject).cLR, this.oVe);
        AppMethodBeat.o(23339);
        return;
      }
      localObject = ((n)localObject).cLR;
      String str = (String)this.oVo.get(localObject);
      ff((String)localObject, this.oVg);
      if ((this.oVa) && (this.oVb != null)) {}
      for (paramString = this.oVc; (str == null) || (str.length() == 0); paramString = oM(this.fll))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
        ff((String)localObject, this.oVf);
        AppMethodBeat.o(23339);
        return;
      }
      if (!this.oUY)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
        Java2CExDevice.stopScanWCLanDevice();
        this.oUY = true;
      }
      if ((!this.oVq.containsKey(localObject)) || (!((Boolean)this.oVq.get(localObject)).booleanValue()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str)));
        if (Java2CExDevice.connectWCLanDevice(str.getBytes(), true) != 0)
        {
          ff((String)localObject, this.oVf);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
        }
      }
      if (this.oUZ)
      {
        paramInt1 = Java2CExDevice.useWCLanDeviceService(str.getBytes(), paramn.getBytes());
        if (paramInt1 != 0)
        {
          this.oVA.put(Integer.valueOf(paramInt1), localObject);
          this.oVp.put(localObject, Integer.valueOf(paramInt1));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(paramInt1)));
          AppMethodBeat.o(23339);
          return;
        }
        ff((String)localObject, this.oVf);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
        AppMethodBeat.o(23339);
        return;
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
        ff((String)localObject, this.oVf);
        AppMethodBeat.o(23339);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendDataToNearFieldDevice %s", new Object[] { paramString });
      paramString = com.tencent.mm.b.q.k(paramString, false);
      paramInt1 = Java2CExDevice.sendFileToWCLanDevice(str.getBytes(), paramn.getBytes(), paramString.getBytes());
      if (paramInt1 != 0)
      {
        this.oVA.put(Integer.valueOf(paramInt1), localObject);
        this.oVp.put(localObject, Integer.valueOf(paramInt1));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(23339);
        return;
      }
      ff((String)localObject, this.oVf);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
    }
    AppMethodBeat.o(23339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g
 * JD-Core Version:    0.7.0.1
 */