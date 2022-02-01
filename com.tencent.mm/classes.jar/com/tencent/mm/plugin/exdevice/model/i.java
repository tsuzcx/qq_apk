package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.lz;
import com.tencent.mm.autogen.a.lz.b;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.q;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.fpf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
  implements com.tencent.mm.am.h
{
  String hQU;
  long lul;
  long mxN;
  String oHX;
  public g.a osH;
  boolean yqT;
  boolean yqU;
  boolean yqV;
  String yqW;
  String yqX;
  String yqY;
  boolean yqZ;
  boolean yra;
  public HashMap<String, ae> yrb;
  dao yrc;
  long yrd;
  private List<b> yre;
  List<b> yrf;
  List<dlf> yrg;
  HashMap<String, String> yrh;
  HashMap<String, Integer> yri;
  private HashMap<String, Boolean> yrj;
  l.a yrk;
  l.a yrl;
  l.a yrm;
  l.a yrn;
  c yro;
  Runnable yrp;
  dao yrq;
  String yrr;
  String yrs;
  int yrt;
  private HashMap<Integer, String> yru;
  
  public i(long paramLong)
  {
    AppMethodBeat.i(274626);
    this.yqT = false;
    this.yqU = false;
    this.yqV = false;
    this.yqZ = false;
    this.yra = false;
    this.yrb = new HashMap();
    this.oHX = "";
    this.yrf = new ArrayList();
    this.yrh = new HashMap();
    this.yri = new HashMap();
    this.yrj = new HashMap();
    this.yrp = new Runnable()
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
        //   13: invokestatic 38	com/tencent/mm/loader/i/b:bmI	()Ljava/lang/String;
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
        //   33: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   36: getfield 50	com/tencent/mm/plugin/exdevice/model/i:hQU	Ljava/lang/String;
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
        //   63: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   66: getfield 50	com/tencent/mm/plugin/exdevice/model/i:hQU	Ljava/lang/String;
        //   69: invokestatic 77	com/tencent/mm/plugin/exdevice/model/e:apr	(Ljava/lang/String;)[B
        //   72: astore_2
        //   73: aload_2
        //   74: ifnull +252 -> 326
        //   77: aload_2
        //   78: iconst_0
        //   79: aload_2
        //   80: arraylength
        //   81: invokestatic 83	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
        //   84: astore 4
        //   86: aload_0
        //   87: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   90: astore 6
        //   92: aload 5
        //   94: iconst_0
        //   95: invokestatic 89	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   98: astore_3
        //   99: aload_3
        //   100: astore_2
        //   101: aload 4
        //   103: getstatic 95	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   106: bipush 80
        //   108: aload_3
        //   109: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   112: pop
        //   113: aload_3
        //   114: astore_2
        //   115: aload_3
        //   116: invokevirtual 106	java/io/OutputStream:flush	()V
        //   119: aload_3
        //   120: ifnull +7 -> 127
        //   123: aload_3
        //   124: invokevirtual 109	java/io/OutputStream:close	()V
        //   127: aload_0
        //   128: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   131: aload 5
        //   133: invokestatic 113	com/tencent/mm/plugin/exdevice/model/i:a	(Lcom/tencent/mm/plugin/exdevice/model/i;Ljava/lang/String;)Ljava/lang/String;
        //   136: pop
        //   137: aload_0
        //   138: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   141: invokestatic 116	com/tencent/mm/plugin/exdevice/model/i:a	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/lang/String;
        //   144: ifnonnull +209 -> 353
        //   147: aload_0
        //   148: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   151: invokestatic 116	com/tencent/mm/plugin/exdevice/model/i:a	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/lang/String;
        //   154: invokestatic 120	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
        //   157: ifne +196 -> 353
        //   160: ldc 122
        //   162: ldc 124
        //   164: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: aload_0
        //   168: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   171: getfield 133	com/tencent/mm/plugin/exdevice/model/i:yrs	Ljava/lang/String;
        //   174: getstatic 136	com/tencent/mm/plugin/exdevice/model/e:ypy	Ljava/lang/String;
        //   177: invokestatic 139	com/tencent/mm/plugin/exdevice/model/e:gR	(Ljava/lang/String;Ljava/lang/String;)V
        //   180: sipush 23317
        //   183: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   186: return
        //   187: astore_2
        //   188: ldc 122
        //   190: aload_2
        //   191: ldc 144
        //   193: iconst_0
        //   194: anewarray 4	java/lang/Object
        //   197: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   200: goto -73 -> 127
        //   203: astore_2
        //   204: ldc 122
        //   206: aload_2
        //   207: ldc 144
        //   209: iconst_0
        //   210: anewarray 4	java/lang/Object
        //   213: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   216: sipush 23317
        //   219: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   222: return
        //   223: astore 4
        //   225: aconst_null
        //   226: astore_3
        //   227: aload_3
        //   228: astore_2
        //   229: ldc 122
        //   231: ldc 150
        //   233: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   236: aload_3
        //   237: astore_2
        //   238: aload 6
        //   240: getfield 133	com/tencent/mm/plugin/exdevice/model/i:yrs	Ljava/lang/String;
        //   243: getstatic 136	com/tencent/mm/plugin/exdevice/model/e:ypy	Ljava/lang/String;
        //   246: invokestatic 139	com/tencent/mm/plugin/exdevice/model/e:gR	(Ljava/lang/String;Ljava/lang/String;)V
        //   249: aload_3
        //   250: astore_2
        //   251: ldc 122
        //   253: aload 4
        //   255: ldc 144
        //   257: iconst_0
        //   258: anewarray 4	java/lang/Object
        //   261: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   264: aload_3
        //   265: ifnull -138 -> 127
        //   268: aload_3
        //   269: invokevirtual 109	java/io/OutputStream:close	()V
        //   272: goto -145 -> 127
        //   275: astore_2
        //   276: ldc 122
        //   278: aload_2
        //   279: ldc 144
        //   281: iconst_0
        //   282: anewarray 4	java/lang/Object
        //   285: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   288: goto -161 -> 127
        //   291: astore_3
        //   292: aconst_null
        //   293: astore_2
        //   294: aload_2
        //   295: ifnull +7 -> 302
        //   298: aload_2
        //   299: invokevirtual 109	java/io/OutputStream:close	()V
        //   302: sipush 23317
        //   305: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   308: aload_3
        //   309: athrow
        //   310: astore_2
        //   311: ldc 122
        //   313: aload_2
        //   314: ldc 144
        //   316: iconst_0
        //   317: anewarray 4	java/lang/Object
        //   320: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   323: goto -21 -> 302
        //   326: ldc 122
        //   328: ldc 152
        //   330: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   333: aload_0
        //   334: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   337: getfield 133	com/tencent/mm/plugin/exdevice/model/i:yrs	Ljava/lang/String;
        //   340: getstatic 136	com/tencent/mm/plugin/exdevice/model/e:ypy	Ljava/lang/String;
        //   343: invokestatic 139	com/tencent/mm/plugin/exdevice/model/e:gR	(Ljava/lang/String;Ljava/lang/String;)V
        //   346: sipush 23317
        //   349: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   352: return
        //   353: iconst_m1
        //   354: istore_1
        //   355: new 154	com/tencent/mm/protocal/protobuf/dap
        //   358: dup
        //   359: invokespecial 155	com/tencent/mm/protocal/protobuf/dap:<init>	()V
        //   362: astore 5
        //   364: aload_0
        //   365: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   368: invokestatic 116	com/tencent/mm/plugin/exdevice/model/i:a	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/lang/String;
        //   371: astore 6
        //   373: aload 6
        //   375: ifnull +215 -> 590
        //   378: aload 6
        //   380: invokevirtual 158	java/lang/String:length	()I
        //   383: ifle +207 -> 590
        //   386: new 160	com/tencent/mm/vfs/u
        //   389: dup
        //   390: aload 6
        //   392: invokespecial 163	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   395: astore_2
        //   396: aload_2
        //   397: invokevirtual 166	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
        //   400: astore_3
        //   401: aload_2
        //   402: invokevirtual 169	com/tencent/mm/vfs/u:length	()J
        //   405: l2i
        //   406: istore_1
        //   407: aload_3
        //   408: aload_3
        //   409: ldc 171
        //   411: invokevirtual 175	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
        //   414: iconst_1
        //   415: iadd
        //   416: aload_3
        //   417: invokevirtual 158	java/lang/String:length	()I
        //   420: invokevirtual 179	java/lang/String:substring	(II)Ljava/lang/String;
        //   423: astore_2
        //   424: aload 6
        //   426: invokestatic 183	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
        //   429: astore 4
        //   431: ldc 122
        //   433: ldc 185
        //   435: iconst_1
        //   436: anewarray 4	java/lang/Object
        //   439: dup
        //   440: iconst_0
        //   441: aload 6
        //   443: aastore
        //   444: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   447: ldc 122
        //   449: ldc 190
        //   451: iconst_1
        //   452: anewarray 4	java/lang/Object
        //   455: dup
        //   456: iconst_0
        //   457: iload_1
        //   458: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   461: aastore
        //   462: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   465: ldc 122
        //   467: ldc 192
        //   469: iconst_1
        //   470: anewarray 4	java/lang/Object
        //   473: dup
        //   474: iconst_0
        //   475: aload 4
        //   477: aastore
        //   478: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   481: aload 5
        //   483: aload_2
        //   484: putfield 195	com/tencent/mm/protocal/protobuf/dap:crp	Ljava/lang/String;
        //   487: aload 5
        //   489: aload_3
        //   490: putfield 198	com/tencent/mm/protocal/protobuf/dap:IGU	Ljava/lang/String;
        //   493: aload 5
        //   495: iload_1
        //   496: putfield 202	com/tencent/mm/protocal/protobuf/dap:vhE	I
        //   499: aload 5
        //   501: aload 4
        //   503: putfield 205	com/tencent/mm/protocal/protobuf/dap:Md5	Ljava/lang/String;
        //   506: aload_0
        //   507: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   510: getfield 209	com/tencent/mm/plugin/exdevice/model/i:yrq	Lcom/tencent/mm/protocal/protobuf/dao;
        //   513: aload 5
        //   515: putfield 215	com/tencent/mm/protocal/protobuf/dao:aaGd	Lcom/tencent/mm/protocal/protobuf/dap;
        //   518: aload_0
        //   519: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   522: getfield 209	com/tencent/mm/plugin/exdevice/model/i:yrq	Lcom/tencent/mm/protocal/protobuf/dao;
        //   525: iconst_3
        //   526: putfield 218	com/tencent/mm/protocal/protobuf/dao:aaGa	I
        //   529: new 220	com/tencent/mm/plugin/exdevice/model/p
        //   532: dup
        //   533: aload_0
        //   534: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   537: getfield 209	com/tencent/mm/plugin/exdevice/model/i:yrq	Lcom/tencent/mm/protocal/protobuf/dao;
        //   540: aload_0
        //   541: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   544: getfield 223	com/tencent/mm/plugin/exdevice/model/i:yrr	Ljava/lang/String;
        //   547: aload_0
        //   548: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   551: getfield 133	com/tencent/mm/plugin/exdevice/model/i:yrs	Ljava/lang/String;
        //   554: aload_0
        //   555: getfield 14	com/tencent/mm/plugin/exdevice/model/i$1:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
        //   558: getfield 226	com/tencent/mm/plugin/exdevice/model/i:yrt	I
        //   561: invokespecial 229	com/tencent/mm/plugin/exdevice/model/p:<init>	(Lcom/tencent/mm/protocal/protobuf/dao;Ljava/lang/String;Ljava/lang/String;I)V
        //   564: astore_2
        //   565: invokestatic 235	com/tencent/mm/model/bh:aZW	()Lcom/tencent/mm/am/s;
        //   568: aload_2
        //   569: iconst_0
        //   570: invokevirtual 240	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
        //   573: pop
        //   574: sipush 23317
        //   577: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   580: return
        //   581: astore_3
        //   582: goto -288 -> 294
        //   585: astore 4
        //   587: goto -360 -> 227
        //   590: aconst_null
        //   591: astore_2
        //   592: aconst_null
        //   593: astore_3
        //   594: aconst_null
        //   595: astore 4
        //   597: goto -116 -> 481
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	600	0	this	1
        //   354	142	1	i	int
        //   72	43	2	localObject1	Object
        //   187	4	2	localIOException1	java.io.IOException
        //   203	4	2	localException	Exception
        //   228	23	2	localObject2	Object
        //   275	4	2	localIOException2	java.io.IOException
        //   293	6	2	localObject3	Object
        //   310	4	2	localIOException3	java.io.IOException
        //   395	197	2	localObject4	Object
        //   98	171	3	localOutputStream	java.io.OutputStream
        //   291	18	3	localObject5	Object
        //   400	90	3	str1	String
        //   581	1	3	localObject6	Object
        //   593	1	3	localObject7	Object
        //   84	18	4	localBitmap	android.graphics.Bitmap
        //   223	31	4	localIOException4	java.io.IOException
        //   429	73	4	str2	String
        //   585	1	4	localIOException5	java.io.IOException
        //   595	1	4	localObject8	Object
        //   60	454	5	localObject9	Object
        //   90	352	6	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   123	127	187	java/io/IOException
        //   6	73	203	java/lang/Exception
        //   77	92	203	java/lang/Exception
        //   123	127	203	java/lang/Exception
        //   127	180	203	java/lang/Exception
        //   188	200	203	java/lang/Exception
        //   268	272	203	java/lang/Exception
        //   276	288	203	java/lang/Exception
        //   298	302	203	java/lang/Exception
        //   302	310	203	java/lang/Exception
        //   311	323	203	java/lang/Exception
        //   326	346	203	java/lang/Exception
        //   355	373	203	java/lang/Exception
        //   378	481	203	java/lang/Exception
        //   481	574	203	java/lang/Exception
        //   92	99	223	java/io/IOException
        //   268	272	275	java/io/IOException
        //   92	99	291	finally
        //   298	302	310	java/io/IOException
        //   101	113	581	finally
        //   115	119	581	finally
        //   229	236	581	finally
        //   238	249	581	finally
        //   251	264	581	finally
        //   101	113	585	java/io/IOException
        //   115	119	585	java/io/IOException
      }
    };
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(23318);
        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[] { i.this.oHX, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(i.this.yqZ) });
        if (paramAnonymousc != null) {}
        label571:
        label579:
        for (;;)
        {
          try
          {
            paramAnonymousInt = (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F);
            Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt < 100) {
              break label579;
            }
            paramAnonymousInt = 99;
            paramAnonymousString = i.this.yrb.keySet().iterator();
            if (paramAnonymousString.hasNext())
            {
              e.ee((String)paramAnonymousString.next(), paramAnonymousInt);
              continue;
            }
            if (paramAnonymousd == null) {
              break label571;
            }
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(23318);
            return 0;
          }
          if (i.this.yqZ)
          {
            paramAnonymousString = new dao();
            i.a(i.this, paramAnonymousString, i.b(i.this));
            i.this.yqZ = false;
            bh.bCz();
            paramAnonymousc = com.tencent.mm.model.c.bzD().sl(i.b(i.this));
            if ((e.aN(paramAnonymousc).booleanValue()) || (e.aO(paramAnonymousc).booleanValue()))
            {
              paramAnonymousString.aaGd.ZaN = paramAnonymousd.field_aesKey;
              paramAnonymousString.aaGd.aaGh = i.this.yrd;
              paramAnonymousString.aaGd.YKw = paramAnonymousd.field_fileId;
              paramAnonymousString.aaGd.Url = paramAnonymousd.field_fileUrl;
              Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[] { paramAnonymousString.aaGd.Url });
            }
            for (;;)
            {
              i.a(i.this, paramAnonymousString);
              paramAnonymousc = i.this.yrb.keySet().iterator();
              while (paramAnonymousc.hasNext())
              {
                paramAnonymousd = (String)paramAnonymousc.next();
                ae localae = (ae)i.this.yrb.get(paramAnonymousd);
                if ((localae != null) && (!localae.hEm))
                {
                  paramAnonymousd = new p(paramAnonymousString, localae.hEr, paramAnonymousd, 1);
                  bh.aZW().a(paramAnonymousd, 0);
                }
              }
              if (e.aM(paramAnonymousc).booleanValue())
              {
                paramAnonymousString.aaGe.ZaN = paramAnonymousd.field_aesKey;
                paramAnonymousString.aaGe.YKw = paramAnonymousd.field_fileId;
                paramAnonymousString.aaGe.Url = paramAnonymousd.field_fileUrl;
                Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[] { paramAnonymousString.aaGe.Url });
              }
              else if (e.aP(paramAnonymousc).booleanValue())
              {
                paramAnonymousString.aaGg.Url = paramAnonymousd.field_fileUrl;
                Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[] { paramAnonymousString.aaGg.Url });
              }
            }
            i.this.yrb.clear();
          }
          AppMethodBeat.o(23318);
          return 0;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(23319);
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(23319);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23320);
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
        AppMethodBeat.o(23320);
        return paramAnonymousArrayOfByte;
      }
    };
    this.yru = new HashMap();
    this.yro = new c(paramLong);
    this.yrf.clear();
    this.yrh.clear();
    this.yrj.clear();
    this.yre = ah.dFO().dGG();
    this.yrg = ah.dFP().dGK();
    if (((this.yre != null) && (this.yre.size() > 0)) || ((this.yrg != null) && (this.yrg.size() > 0)))
    {
      int j = this.yre.size();
      int i = 0;
      while (i < j)
      {
        if ((((b)this.yre.get(i)).kDj.contains("internet_to_device")) && (!((b)this.yre.get(i)).kDj.contains("wechat_to_device"))) {
          this.yrf.add((b)this.yre.get(i));
        }
        i += 1;
      }
      Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "callbackRegister");
      this.yrn = new i.3(this);
      this.yrk = new l.a()
      {
        /* Error */
        public final void h(int paramAnonymousInt, Object... paramAnonymousVarArgs)
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
          //   43: astore_2
          //   44: new 35	org/json/JSONObject
          //   47: dup
          //   48: new 37	java/lang/String
          //   51: dup
          //   52: aload_2
          //   53: invokespecial 40	java/lang/String:<init>	([B)V
          //   56: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   59: astore 6
          //   61: aload 6
          //   63: ldc 45
          //   65: invokevirtual 49	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
          //   68: astore_2
          //   69: aload_2
          //   70: ldc 51
          //   72: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   75: astore 5
          //   77: aload_2
          //   78: ldc 57
          //   80: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   83: astore 4
          //   85: aload 6
          //   87: ldc 59
          //   89: invokevirtual 63	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
          //   92: ifeq +17 -> 109
          //   95: ldc 65
          //   97: ldc 67
          //   99: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   102: sipush 23322
          //   105: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   108: return
          //   109: ldc 65
          //   111: ldc 75
          //   113: iconst_1
          //   114: anewarray 4	java/lang/Object
          //   117: dup
          //   118: iconst_0
          //   119: aload 6
          //   121: ldc 59
          //   123: invokevirtual 79	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
          //   126: invokevirtual 85	org/json/JSONArray:toString	()Ljava/lang/String;
          //   129: aastore
          //   130: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   133: aload_2
          //   134: astore 6
          //   136: aload 5
          //   138: ifnull +29 -> 167
          //   141: aload 4
          //   143: ifnull +24 -> 167
          //   146: ldc 65
          //   148: ldc 90
          //   150: iconst_2
          //   151: anewarray 4	java/lang/Object
          //   154: dup
          //   155: iconst_0
          //   156: aload 5
          //   158: aastore
          //   159: dup
          //   160: iconst_1
          //   161: aload 4
          //   163: aastore
          //   164: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   167: aload_0
          //   168: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   171: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   174: invokeinterface 101 1 0
          //   179: istore_3
          //   180: iconst_0
          //   181: istore_1
          //   182: iload_1
          //   183: iload_3
          //   184: if_icmpge +208 -> 392
          //   187: aload_0
          //   188: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   191: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   194: iload_1
          //   195: invokeinterface 105 2 0
          //   200: checkcast 107	com/tencent/mm/plugin/exdevice/i/b
          //   203: getfield 111	com/tencent/mm/plugin/exdevice/i/b:field_deviceID	Ljava/lang/String;
          //   206: aload 4
          //   208: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   211: ifeq +142 -> 353
          //   214: aload_0
          //   215: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   218: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   221: iload_1
          //   222: invokeinterface 105 2 0
          //   227: checkcast 107	com/tencent/mm/plugin/exdevice/i/b
          //   230: getfield 118	com/tencent/mm/plugin/exdevice/i/b:field_deviceType	Ljava/lang/String;
          //   233: aload 5
          //   235: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   238: ifeq +115 -> 353
          //   241: aload_0
          //   242: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   245: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   248: iload_1
          //   249: invokeinterface 105 2 0
          //   254: checkcast 107	com/tencent/mm/plugin/exdevice/i/b
          //   257: getfield 123	com/tencent/mm/autogen/b/ee:kDj	Ljava/lang/String;
          //   260: ldc 125
          //   262: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   265: ifeq +88 -> 353
          //   268: aload_0
          //   269: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   272: invokestatic 132	com/tencent/mm/plugin/exdevice/model/i:e	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   275: aload_0
          //   276: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   279: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   282: iload_1
          //   283: invokeinterface 105 2 0
          //   288: invokeinterface 134 2 0
          //   293: ifne +60 -> 353
          //   296: aload_0
          //   297: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   300: invokestatic 138	com/tencent/mm/plugin/exdevice/model/i:f	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/HashMap;
          //   303: aload 4
          //   305: aload 6
          //   307: invokevirtual 139	org/json/JSONObject:toString	()Ljava/lang/String;
          //   310: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   313: pop
          //   314: aload_0
          //   315: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   318: invokestatic 132	com/tencent/mm/plugin/exdevice/model/i:e	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   321: aload_0
          //   322: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   325: invokestatic 95	com/tencent/mm/plugin/exdevice/model/i:d	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   328: iload_1
          //   329: invokeinterface 105 2 0
          //   334: checkcast 107	com/tencent/mm/plugin/exdevice/i/b
          //   337: invokeinterface 148 2 0
          //   342: pop
          //   343: aload_0
          //   344: getfield 14	com/tencent/mm/plugin/exdevice/model/i$4:yrv	Lcom/tencent/mm/plugin/exdevice/model/i;
          //   347: invokestatic 132	com/tencent/mm/plugin/exdevice/model/i:e	(Lcom/tencent/mm/plugin/exdevice/model/i;)Ljava/util/List;
          //   350: invokestatic 152	com/tencent/mm/plugin/exdevice/model/i:fk	(Ljava/util/List;)V
          //   353: iload_1
          //   354: iconst_1
          //   355: iadd
          //   356: istore_1
          //   357: goto -175 -> 182
          //   360: astore 4
          //   362: aconst_null
          //   363: astore 6
          //   365: aconst_null
          //   366: astore_2
          //   367: aconst_null
          //   368: astore 5
          //   370: ldc 65
          //   372: ldc 154
          //   374: iconst_1
          //   375: anewarray 4	java/lang/Object
          //   378: dup
          //   379: iconst_0
          //   380: aload 4
          //   382: aastore
          //   383: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   386: aload_2
          //   387: astore 4
          //   389: goto -253 -> 136
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
          //   179	6	3	i	int
          //   83	221	4	str1	String
          //   360	21	4	localException1	Exception
          //   387	1	4	arrayOfObject1	Object[]
          //   399	1	4	localException2	Exception
          //   416	17	4	localException3	Exception
          //   438	1	4	localException4	Exception
          //   75	331	5	str2	String
          //   59	364	6	localObject	Object
          //   430	7	6	localException5	Exception
          //   441	1	6	arrayOfObject2	Object[]
          //   402	42	7	localException6	Exception
          // Exception table:
          //   from	to	target	type
          //   44	69	360	java/lang/Exception
          //   69	77	399	java/lang/Exception
          //   77	85	416	java/lang/Exception
          //   85	102	430	java/lang/Exception
          //   109	133	430	java/lang/Exception
        }
      };
      this.yrl = new i.5(this);
      this.yrm = new i.6(this);
      bh.aZW().a(1717, this);
      l.dFF().a(14, this.yrk);
      l.dFF().a(12, this.yrl);
      l.dFF().a(13, this.yrm);
      l.dFF().a(15, this.yrn);
      Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
      Java2CExDevice.initWCLanDeviceLib();
    }
    AppMethodBeat.o(274626);
  }
  
  private String lu(long paramLong)
  {
    AppMethodBeat.i(23337);
    String str = "";
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzD().sl(paramLong);
    if ((localObject1 == null) || (((fi)localObject1).field_msgId == 0L))
    {
      AppMethodBeat.o(23337);
      return "";
    }
    int i = ((cc)localObject1).getType();
    Object localObject2 = ((fi)localObject1).field_content;
    if (((cc)localObject1).fxR())
    {
      localObject2 = k.b.Hf((String)localObject2);
      if ((localObject2 != null) && ((((k.b)localObject2).type == 6) || (((k.b)localObject2).type == 2)))
      {
        localObject1 = as.cWJ().bpI(((k.b)localObject2).hzM);
        if (localObject1 != null) {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23337);
      return localObject1;
      Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
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
          this.yqU = true;
          localObject1 = str;
          continue;
          if (i == 3)
          {
            localObject2 = r.bKa().af((cc)localObject1);
            localObject1 = str;
            if (localObject2 != null)
            {
              str = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGr);
              localObject1 = str;
              if (Util.isNullOrNil(str)) {
                localObject1 = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGt);
              }
            }
          }
          else if (i == 62)
          {
            v.bOh();
            localObject1 = aa.PX(((fi)localObject1).field_imgPath);
          }
          else
          {
            localObject1 = str;
            if (i == 48)
            {
              this.yqU = true;
              localObject1 = str;
            }
          }
        }
      }
    }
  }
  
  final dmz a(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(23333);
    paramTimeLineObject = paramTimeLineObject.ContentObj.Zpr.iterator();
    while (paramTimeLineObject.hasNext())
    {
      dmz localdmz = (dmz)paramTimeLineObject.next();
      if (localdmz.Id.equals(this.yqY))
      {
        AppMethodBeat.o(23333);
        return localdmz;
      }
    }
    AppMethodBeat.o(23333);
    return null;
  }
  
  final boolean b(dao paramdao, long paramLong)
  {
    AppMethodBeat.i(23335);
    int j = -1;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str = lu(paramLong);
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
        localObject1 = new u(str);
        localObject2 = ((u)localObject1).getName();
        i = (int)((u)localObject1).length();
        localObject3 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1, ((String)localObject2).length());
        localObject1 = y.bub(str);
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[] { str });
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[] { Integer.valueOf(i) });
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[] { localObject1 });
      }
    }
    bh.bCz();
    localObject4 = com.tencent.mm.model.c.bzD().sl(paramLong);
    if ((localObject4 == null) || (((fi)localObject4).field_msgId == 0L))
    {
      Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
      AppMethodBeat.o(23335);
      return false;
    }
    switch (((cc)localObject4).getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23335);
      return true;
      localObject3 = k.b.Hf(((fi)localObject4).field_content);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
        AppMethodBeat.o(23335);
        return false;
      }
      if ((((k.b)localObject3).type == 3) || (((k.b)localObject3).type == 76))
      {
        localObject1 = new dar();
        ((dar)localObject1).hAP = ((k.b)localObject3).title;
        ((dar)localObject1).aaGk = ((k.b)localObject3).description;
        ((dar)localObject1).Url = ((k.b)localObject3).url;
        ((dar)localObject1).aaGl = ((k.b)localObject3).nRc;
        ((dar)localObject1).ZjC = ((k.b)localObject3).nRx;
        ((dar)localObject1).aaGm = ((k.b)localObject3).nRy;
        ((dar)localObject1).IKJ = ((k.b)localObject3).appName;
        if (Util.isNullOrNil(((dar)localObject1).IKJ))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(((k.b)localObject3).appId, ((k.b)localObject3).appVersion);
          if (localObject2 != null) {
            ((dar)localObject1).IKJ = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        ((dar)localObject1).aaGn = ((k.b)localObject3).nRr;
        ((dar)localObject1).aaGo = ((k.b)localObject3).nRs;
        ((dar)localObject1).aaGp = ((k.b)localObject3).nRv;
        paramdao.aaGb = ((dar)localObject1);
        paramdao.aaGa = 1;
      }
      else if (((k.b)localObject3).type == 6)
      {
        localObject2 = new dan();
        ((dan)localObject2).crp = ((k.b)localObject3).nRe;
        ((dan)localObject2).IGU = ((k.b)localObject3).title;
        ((dan)localObject2).vhE = i;
        ((dan)localObject2).Md5 = ((String)localObject1);
        paramdao.aaGe = ((dan)localObject2);
        paramdao.aaGa = 4;
      }
      else if (((k.b)localObject3).type == 5)
      {
        localObject1 = new das();
        ((das)localObject1).Url = ((k.b)localObject3).url;
        ((das)localObject1).hAP = ((k.b)localObject3).title;
        ((das)localObject1).aaGk = ((k.b)localObject3).description;
        ((das)localObject1).IKJ = ((k.b)localObject3).appName;
        if (Util.isNullOrNil(((das)localObject1).IKJ))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(((k.b)localObject3).appId, ((k.b)localObject3).appVersion);
          if (localObject2 != null) {
            ((das)localObject1).IKJ = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          }
        }
        paramdao.aaGf = ((das)localObject1);
        paramdao.aaGa = 5;
      }
      else if (((k.b)localObject3).type == 2)
      {
        localObject3 = new dap();
        ((dap)localObject3).crp = "jpg";
        ((dap)localObject3).IGU = ((String)localObject2);
        ((dap)localObject3).vhE = i;
        ((dap)localObject3).Md5 = ((String)localObject1);
        paramdao.aaGd = ((dap)localObject3);
        paramdao.aaGa = 3;
        continue;
        localObject4 = new dap();
        ((dap)localObject4).crp = ((String)localObject3);
        ((dap)localObject4).IGU = ((String)localObject2);
        ((dap)localObject4).vhE = i;
        ((dap)localObject4).Md5 = ((String)localObject1);
        paramdao.aaGd = ((dap)localObject4);
        paramdao.aaGa = 3;
        continue;
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzD().aLV(((fi)localObject4).field_content);
        localObject2 = new daq();
        ((daq)localObject2).X = ((float)((cc.c)localObject1).KbW);
        ((daq)localObject2).Y = ((float)((cc.c)localObject1).KbX);
        ((daq)localObject2).aaGi = ((cc.c)localObject1).hQp;
        ((daq)localObject2).ILD = ((cc.c)localObject1).label;
        ((daq)localObject2).aaGj = ((cc.c)localObject1).poiName;
        paramdao.aaGc = ((daq)localObject2);
        paramdao.aaGa = 2;
        continue;
        localObject4 = new dat();
        ((dat)localObject4).crp = ((String)localObject3);
        ((dat)localObject4).vhE = i;
        ((dat)localObject4).Md5 = ((String)localObject1);
        ((dat)localObject4).IGU = ((String)localObject2);
        paramdao.aaGg = ((dat)localObject4);
        paramdao.aaGa = 6;
      }
    }
  }
  
  public final TimeLineObject dFC()
  {
    AppMethodBeat.i(23334);
    Object localObject = new lz();
    ((lz)localObject).hNQ.hES = this.yqW;
    ((lz)localObject).publish();
    localObject = ((lz)localObject).hNR.hNS;
    AppMethodBeat.o(23334);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(23339);
    Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
      AppMethodBeat.o(23339);
      return;
    }
    if ((paramp instanceof p))
    {
      Object localObject = (p)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        e.gR(((p)localObject).hEl, e.ypy);
        AppMethodBeat.o(23339);
        return;
      }
      if ((((p)localObject).rr != null) && (c.c.b(((p)localObject).rr.otC) != null)) {}
      for (paramString = (fpf)c.c.b(((p)localObject).rr.otC);; paramString = null)
      {
        paramp = paramString.abPk;
        if (1 != ((p)localObject).ysb) {
          break;
        }
        e.gR(((p)localObject).hEl, e.ypx);
        AppMethodBeat.o(23339);
        return;
      }
      localObject = ((p)localObject).hEl;
      String str = (String)this.yrh.get(localObject);
      e.gR((String)localObject, e.ypz);
      if ((this.yqV) && (this.yqW != null)) {}
      for (paramString = this.yqX; (str == null) || (str.length() == 0); paramString = lu(this.lul))
      {
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
        e.gR((String)localObject, e.ypy);
        AppMethodBeat.o(23339);
        return;
      }
      if (!this.yqT)
      {
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
        Java2CExDevice.stopScanWCLanDevice();
        this.yqT = true;
      }
      if ((!this.yrj.containsKey(localObject)) || (!((Boolean)this.yrj.get(localObject)).booleanValue()))
      {
        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str)));
        if (Java2CExDevice.connectWCLanDevice(str.getBytes(), true) != 0)
        {
          e.gR((String)localObject, e.ypy);
          Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
        }
      }
      if (this.yqU)
      {
        paramInt1 = Java2CExDevice.useWCLanDeviceService(str.getBytes(), paramp.getBytes());
        if (paramInt1 != 0)
        {
          this.yru.put(Integer.valueOf(paramInt1), localObject);
          this.yri.put(localObject, Integer.valueOf(paramInt1));
          Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(paramInt1)));
          AppMethodBeat.o(23339);
          return;
        }
        e.gR((String)localObject, e.ypy);
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
        AppMethodBeat.o(23339);
        return;
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
        e.gR((String)localObject, e.ypy);
        AppMethodBeat.o(23339);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendDataToNearFieldDevice %s", new Object[] { paramString });
      paramString = q.n(paramString, false);
      paramInt1 = Java2CExDevice.sendFileToWCLanDevice(str.getBytes(), paramp.getBytes(), paramString.getBytes());
      if (paramInt1 != 0)
      {
        this.yru.put(Integer.valueOf(paramInt1), localObject);
        this.yri.put(localObject, Integer.valueOf(paramInt1));
        Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(23339);
        return;
      }
      e.gR((String)localObject, e.ypy);
      Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
    }
    AppMethodBeat.o(23339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */