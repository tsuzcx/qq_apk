package com.tencent.mm.audio.e;

import com.tencent.e.i.e;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public final class c
  implements a
{
  private static a.a dko;
  public BlockingQueue<g.a> dkc;
  public boolean dkd;
  private String dke;
  private int dkf;
  private byte[] dkg;
  private int dkh;
  private Object dki;
  public a dkj;
  private boolean dkk;
  private int dkl;
  private boolean dkm;
  private i dkn;
  private volatile OutputStream mFileOutputStream;
  private int mSampleRate;
  
  static
  {
    AppMethodBeat.i(130022);
    dko = new a.a();
    AppMethodBeat.o(130022);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130015);
    this.dkc = new ArrayBlockingQueue(1024);
    this.dkd = false;
    this.dkf = 0;
    this.dkg = null;
    this.mSampleRate = 16000;
    this.dkh = 16000;
    this.dki = new Object();
    this.dkj = null;
    this.dkk = false;
    this.dkm = false;
    this.mSampleRate = paramInt1;
    this.dkh = paramInt2;
    AppMethodBeat.o(130015);
  }
  
  private void Rz()
  {
    AppMethodBeat.i(130018);
    synchronized (this.dki)
    {
      if (this.dkn != null) {
        MediaRecorder.SilkEncUnInit(this.dkn.izk);
      }
      ae.i("MicroMsg.SilkWriter", "finish Thread file:" + this.dke);
      if (this.mFileOutputStream == null) {}
    }
    try
    {
      this.mFileOutputStream.close();
      this.mFileOutputStream = null;
      AppMethodBeat.o(130018);
      return;
      localObject2 = finally;
      AppMethodBeat.o(130018);
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SilkWriter", "close silk file:" + this.dke + "msg:" + localException.getMessage());
      }
    }
  }
  
  /* Error */
  public final void Rx()
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 104
    //   7: ldc 156
    //   9: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 66	com/tencent/mm/audio/e/c:dkd	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 78	com/tencent/mm/audio/e/c:dkj	Lcom/tencent/mm/audio/e/c$a;
    //   25: ifnull +10 -> 35
    //   28: aload_0
    //   29: getfield 78	com/tencent/mm/audio/e/c:dkj	Lcom/tencent/mm/audio/e/c$a;
    //   32: invokevirtual 159	com/tencent/mm/audio/e/c$a:RB	()V
    //   35: aload_0
    //   36: invokespecial 161	com/tencent/mm/audio/e/c:Rz	()V
    //   39: ldc 154
    //   41: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc 154
    //   50: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: ldc 104
    //   58: ldc 163
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_1
    //   67: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   70: aastore
    //   71: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -39 -> 35
    //   77: astore_1
    //   78: ldc 104
    //   80: ldc 163
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: goto -61 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	c
    //   45	9	1	localObject	Object
    //   55	12	1	localInterruptedException	InterruptedException
    //   77	12	1	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   14	21	45	finally
    //   46	48	45	finally
    //   28	35	55	java/lang/InterruptedException
    //   28	35	77	java/util/concurrent/ExecutionException
  }
  
  public final boolean Ry()
  {
    AppMethodBeat.i(130019);
    ae.i("MicroMsg.SilkWriter", "resetWriter");
    synchronized (this.dki)
    {
      if (this.dkn != null) {
        MediaRecorder.SilkEncUnInit(this.dkn.izk);
      }
      this.dkn = new i(this.mSampleRate, this.dkh, this.dkl);
      if (0L == this.dkn.izk)
      {
        ae.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error");
        this.dkn = null;
        AppMethodBeat.o(130019);
        return false;
      }
    }
    AppMethodBeat.o(130019);
    return true;
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(130020);
    int i = a(parama, 0, false);
    AppMethodBeat.o(130020);
    return i;
  }
  
  /* Error */
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 193	com/tencent/mm/compatible/util/f$a
    //   8: dup
    //   9: invokespecial 194	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   12: astore 15
    //   14: aload_0
    //   15: getfield 72	com/tencent/mm/audio/e/c:mSampleRate	I
    //   18: bipush 20
    //   20: imul
    //   21: iconst_2
    //   22: imul
    //   23: sipush 1000
    //   26: idiv
    //   27: i2s
    //   28: istore 4
    //   30: aload_0
    //   31: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   34: aload_1
    //   35: getfield 199	com/tencent/mm/audio/b/g$a:diR	I
    //   38: iadd
    //   39: istore 7
    //   41: iload 4
    //   43: newarray byte
    //   45: astore 16
    //   47: aload_0
    //   48: getfield 82	com/tencent/mm/audio/e/c:dkm	Z
    //   51: ifeq +529 -> 580
    //   54: bipush 6
    //   56: istore 5
    //   58: iload 5
    //   60: iload 4
    //   62: imul
    //   63: newarray byte
    //   65: astore 17
    //   67: iconst_1
    //   68: istore 12
    //   70: iload 12
    //   72: istore 11
    //   74: invokestatic 204	com/tencent/mm/sdk/platformtools/ak:coh	()Z
    //   77: ifeq +48 -> 125
    //   80: ldc 206
    //   82: invokestatic 212	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   85: checkcast 206	com/tencent/mm/plugin/zero/b/a
    //   88: invokeinterface 216 1 0
    //   93: ldc 218
    //   95: invokevirtual 224	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 18
    //   100: iload 12
    //   102: istore 11
    //   104: aload 18
    //   106: invokestatic 228	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   109: ifne +16 -> 125
    //   112: aload 18
    //   114: iconst_1
    //   115: invokestatic 232	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   118: iconst_1
    //   119: if_icmpne +467 -> 586
    //   122: iconst_1
    //   123: istore 11
    //   125: iload_3
    //   126: ifeq +6 -> 132
    //   129: iconst_0
    //   130: istore 11
    //   132: ldc 104
    //   134: ldc 234
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: iload 11
    //   144: invokestatic 240	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 243	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: iconst_0
    //   152: istore 5
    //   154: iconst_0
    //   155: istore 6
    //   157: iload 7
    //   159: iload 4
    //   161: if_icmplt +770 -> 931
    //   164: aload_0
    //   165: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   168: ifle +474 -> 642
    //   171: aload_0
    //   172: getfield 70	com/tencent/mm/audio/e/c:dkg	[B
    //   175: iconst_0
    //   176: aload 16
    //   178: iconst_0
    //   179: aload_0
    //   180: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   183: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   186: aload_1
    //   187: getfield 252	com/tencent/mm/audio/b/g$a:buf	[B
    //   190: astore 18
    //   192: aload_0
    //   193: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   196: istore 8
    //   198: aload 18
    //   200: iconst_0
    //   201: aload 16
    //   203: iload 8
    //   205: iload 4
    //   207: iload 8
    //   209: isub
    //   210: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   213: iload 4
    //   215: aload_0
    //   216: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   219: isub
    //   220: iload 6
    //   222: iadd
    //   223: istore 6
    //   225: aload_0
    //   226: iconst_0
    //   227: putfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   230: iload 7
    //   232: iload 4
    //   234: isub
    //   235: istore 7
    //   237: iconst_1
    //   238: newarray short
    //   240: astore 18
    //   242: aload_0
    //   243: getfield 76	com/tencent/mm/audio/e/c:dki	Ljava/lang/Object;
    //   246: astore 19
    //   248: aload 19
    //   250: monitorenter
    //   251: aload_0
    //   252: getfield 82	com/tencent/mm/audio/e/c:dkm	Z
    //   255: ifeq +44 -> 299
    //   258: iload 7
    //   260: iload 4
    //   262: if_icmpge +447 -> 709
    //   265: aload_1
    //   266: getfield 255	com/tencent/mm/audio/b/g$a:diS	Z
    //   269: ifeq +440 -> 709
    //   272: aload_0
    //   273: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   276: ifnull +15 -> 291
    //   279: aload_0
    //   280: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   283: sipush 201
    //   286: iconst_1
    //   287: invokevirtual 259	com/tencent/mm/modelvoice/i:ds	(II)I
    //   290: pop
    //   291: ldc 104
    //   293: ldc_w 261
    //   296: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_0
    //   300: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   303: ifnull +877 -> 1180
    //   306: aload 16
    //   308: iload 4
    //   310: aload 17
    //   312: aload 18
    //   314: iload 11
    //   316: aload_0
    //   317: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   320: getfield 96	com/tencent/mm/modelvoice/i:izk	J
    //   323: invokestatic 265	com/tencent/mm/modelvoice/MediaRecorder:SilkDoEnc	([BS[B[SZJ)I
    //   326: istore 8
    //   328: aload 19
    //   330: monitorexit
    //   331: iconst_0
    //   332: istore 10
    //   334: iload 10
    //   336: istore 9
    //   338: iload_3
    //   339: ifeq +160 -> 499
    //   342: iload 10
    //   344: istore 9
    //   346: aload 18
    //   348: iconst_0
    //   349: saload
    //   350: bipush 10
    //   352: if_icmplt +147 -> 499
    //   355: iload 10
    //   357: istore 9
    //   359: aload 17
    //   361: iconst_0
    //   362: baload
    //   363: iconst_2
    //   364: if_icmpne +135 -> 499
    //   367: iload 10
    //   369: istore 9
    //   371: aload 17
    //   373: iconst_1
    //   374: baload
    //   375: bipush 35
    //   377: if_icmpne +122 -> 499
    //   380: iload 10
    //   382: istore 9
    //   384: aload 17
    //   386: iconst_2
    //   387: baload
    //   388: bipush 33
    //   390: if_icmpne +109 -> 499
    //   393: iload 10
    //   395: istore 9
    //   397: aload 17
    //   399: iconst_3
    //   400: baload
    //   401: bipush 83
    //   403: if_icmpne +96 -> 499
    //   406: iload 10
    //   408: istore 9
    //   410: aload 17
    //   412: iconst_4
    //   413: baload
    //   414: bipush 73
    //   416: if_icmpne +83 -> 499
    //   419: iload 10
    //   421: istore 9
    //   423: aload 17
    //   425: iconst_5
    //   426: baload
    //   427: bipush 76
    //   429: if_icmpne +70 -> 499
    //   432: iload 10
    //   434: istore 9
    //   436: aload 17
    //   438: bipush 6
    //   440: baload
    //   441: bipush 75
    //   443: if_icmpne +56 -> 499
    //   446: iload 10
    //   448: istore 9
    //   450: aload 17
    //   452: bipush 7
    //   454: baload
    //   455: bipush 95
    //   457: if_icmpne +42 -> 499
    //   460: iload 10
    //   462: istore 9
    //   464: aload 17
    //   466: bipush 8
    //   468: baload
    //   469: bipush 86
    //   471: if_icmpne +28 -> 499
    //   474: iload 10
    //   476: istore 9
    //   478: aload 17
    //   480: bipush 9
    //   482: baload
    //   483: bipush 51
    //   485: if_icmpne +14 -> 499
    //   488: ldc 104
    //   490: ldc_w 267
    //   493: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: iconst_1
    //   497: istore 9
    //   499: iload 8
    //   501: ifeq +241 -> 742
    //   504: aload_0
    //   505: iconst_0
    //   506: putfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   509: ldc 104
    //   511: ldc_w 269
    //   514: iconst_1
    //   515: anewarray 4	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: iload 8
    //   522: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: aload_0
    //   530: getfield 80	com/tencent/mm/audio/e/c:dkk	Z
    //   533: ifne +40 -> 573
    //   536: getstatic 280	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   539: ldc2_w 281
    //   542: ldc2_w 283
    //   545: lconst_1
    //   546: invokevirtual 288	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
    //   549: aload_0
    //   550: iconst_1
    //   551: putfield 80	com/tencent/mm/audio/e/c:dkk	Z
    //   554: getstatic 293	com/tencent/mm/protocal/d:FFK	Z
    //   557: ifeq +16 -> 573
    //   560: getstatic 280	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   563: ldc_w 295
    //   566: ldc_w 297
    //   569: aconst_null
    //   570: invokevirtual 301	com/tencent/mm/plugin/report/service/g:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   573: ldc 191
    //   575: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   578: iconst_m1
    //   579: ireturn
    //   580: iconst_1
    //   581: istore 5
    //   583: goto -525 -> 58
    //   586: iconst_0
    //   587: istore 11
    //   589: goto -464 -> 125
    //   592: astore_1
    //   593: ldc 104
    //   595: ldc_w 303
    //   598: iconst_3
    //   599: anewarray 4	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload_0
    //   605: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   608: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: aastore
    //   612: dup
    //   613: iconst_1
    //   614: iload 4
    //   616: aload_0
    //   617: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   620: isub
    //   621: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   624: aastore
    //   625: dup
    //   626: iconst_2
    //   627: aload_1
    //   628: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   631: aastore
    //   632: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: ldc 191
    //   637: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: iconst_m1
    //   641: ireturn
    //   642: aload_1
    //   643: getfield 252	com/tencent/mm/audio/b/g$a:buf	[B
    //   646: iload 6
    //   648: aload 16
    //   650: iconst_0
    //   651: iload 4
    //   653: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   656: iload 6
    //   658: iload 4
    //   660: iadd
    //   661: istore 6
    //   663: goto -433 -> 230
    //   666: astore_1
    //   667: ldc 104
    //   669: ldc_w 305
    //   672: iconst_3
    //   673: anewarray 4	java/lang/Object
    //   676: dup
    //   677: iconst_0
    //   678: iload 6
    //   680: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: iload 4
    //   688: invokestatic 310	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   691: aastore
    //   692: dup
    //   693: iconst_2
    //   694: aload_1
    //   695: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   698: aastore
    //   699: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: ldc 191
    //   704: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   707: iconst_m1
    //   708: ireturn
    //   709: aload_0
    //   710: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   713: ifnull -414 -> 299
    //   716: aload_0
    //   717: getfield 90	com/tencent/mm/audio/e/c:dkn	Lcom/tencent/mm/modelvoice/i;
    //   720: sipush 201
    //   723: iconst_0
    //   724: invokevirtual 259	com/tencent/mm/modelvoice/i:ds	(II)I
    //   727: pop
    //   728: goto -429 -> 299
    //   731: astore_1
    //   732: aload 19
    //   734: monitorexit
    //   735: ldc 191
    //   737: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   740: aload_1
    //   741: athrow
    //   742: ldc 104
    //   744: ldc_w 312
    //   747: iconst_4
    //   748: anewarray 4	java/lang/Object
    //   751: dup
    //   752: iconst_0
    //   753: aload 18
    //   755: iconst_0
    //   756: saload
    //   757: invokestatic 310	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   760: aastore
    //   761: dup
    //   762: iconst_1
    //   763: iload 4
    //   765: invokestatic 310	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   768: aastore
    //   769: dup
    //   770: iconst_2
    //   771: aload_1
    //   772: getfield 255	com/tencent/mm/audio/b/g$a:diS	Z
    //   775: invokestatic 240	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   778: aastore
    //   779: dup
    //   780: iconst_3
    //   781: aload_1
    //   782: getfield 199	com/tencent/mm/audio/b/g$a:diR	I
    //   785: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: invokestatic 315	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   792: aload 18
    //   794: iconst_0
    //   795: saload
    //   796: aload 17
    //   798: arraylength
    //   799: if_icmpge +378 -> 1177
    //   802: aload 18
    //   804: iconst_0
    //   805: saload
    //   806: ifle +371 -> 1177
    //   809: aload_0
    //   810: getfield 128	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   813: ifnull +364 -> 1177
    //   816: iload_3
    //   817: ifeq +57 -> 874
    //   820: iload 9
    //   822: ifeq +52 -> 874
    //   825: ldc 104
    //   827: ldc_w 317
    //   830: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: aload 17
    //   835: iconst_1
    //   836: aload 17
    //   838: arraylength
    //   839: invokestatic 323	java/util/Arrays:copyOfRange	([BII)[B
    //   842: astore 19
    //   844: aload_0
    //   845: getfield 128	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   848: aload 19
    //   850: iconst_0
    //   851: aload 18
    //   853: iconst_0
    //   854: saload
    //   855: iconst_1
    //   856: isub
    //   857: invokevirtual 327	java/io/OutputStream:write	([BII)V
    //   860: iload 5
    //   862: aload 18
    //   864: iconst_0
    //   865: saload
    //   866: iconst_1
    //   867: isub
    //   868: iadd
    //   869: istore 5
    //   871: goto -714 -> 157
    //   874: aload_0
    //   875: getfield 128	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   878: aload 17
    //   880: iconst_0
    //   881: aload 18
    //   883: iconst_0
    //   884: saload
    //   885: invokevirtual 327	java/io/OutputStream:write	([BII)V
    //   888: aload 18
    //   890: iconst_0
    //   891: saload
    //   892: istore 8
    //   894: iload 8
    //   896: iload 5
    //   898: iadd
    //   899: istore 5
    //   901: goto -744 -> 157
    //   904: astore_1
    //   905: ldc 104
    //   907: ldc_w 329
    //   910: iconst_1
    //   911: anewarray 4	java/lang/Object
    //   914: dup
    //   915: iconst_0
    //   916: aload_0
    //   917: getfield 113	com/tencent/mm/audio/e/c:dke	Ljava/lang/String;
    //   920: aastore
    //   921: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: ldc 191
    //   926: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: iconst_m1
    //   930: ireturn
    //   931: aload_0
    //   932: getfield 128	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   935: ifnull +10 -> 945
    //   938: aload_0
    //   939: getfield 128	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   942: invokevirtual 332	java/io/OutputStream:flush	()V
    //   945: aload_1
    //   946: getfield 252	com/tencent/mm/audio/b/g$a:buf	[B
    //   949: iload 6
    //   951: aload_0
    //   952: getfield 70	com/tencent/mm/audio/e/c:dkg	[B
    //   955: aload_0
    //   956: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   959: iload 7
    //   961: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   964: aload_0
    //   965: aload_0
    //   966: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   969: iload 7
    //   971: iadd
    //   972: putfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   975: aload 15
    //   977: invokevirtual 336	com/tencent/mm/compatible/util/f$a:abs	()J
    //   980: lstore 13
    //   982: iload_2
    //   983: iconst_1
    //   984: if_icmpne +42 -> 1026
    //   987: getstatic 51	com/tencent/mm/audio/e/c:dko	Lcom/tencent/mm/audio/e/a$a;
    //   990: astore_1
    //   991: aload_1
    //   992: aload_1
    //   993: getfield 339	com/tencent/mm/audio/e/a$a:djZ	J
    //   996: aload_1
    //   997: getfield 342	com/tencent/mm/audio/e/a$a:count	I
    //   1000: i2l
    //   1001: lmul
    //   1002: lload 13
    //   1004: ladd
    //   1005: aload_1
    //   1006: getfield 342	com/tencent/mm/audio/e/a$a:count	I
    //   1009: iconst_1
    //   1010: iadd
    //   1011: i2l
    //   1012: ldiv
    //   1013: putfield 339	com/tencent/mm/audio/e/a$a:djZ	J
    //   1016: aload_1
    //   1017: aload_1
    //   1018: getfield 342	com/tencent/mm/audio/e/a$a:count	I
    //   1021: iconst_1
    //   1022: iadd
    //   1023: putfield 342	com/tencent/mm/audio/e/a$a:count	I
    //   1026: ldc 104
    //   1028: new 106	java/lang/StringBuilder
    //   1031: dup
    //   1032: ldc_w 344
    //   1035: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1038: lload 13
    //   1040: invokevirtual 347	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: ldc_w 349
    //   1046: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: iload_2
    //   1050: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1053: ldc_w 354
    //   1056: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: getstatic 51	com/tencent/mm/audio/e/c:dko	Lcom/tencent/mm/audio/e/a$a;
    //   1062: getfield 339	com/tencent/mm/audio/e/a$a:djZ	J
    //   1065: invokevirtual 347	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: ldc_w 356
    //   1071: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: getstatic 51	com/tencent/mm/audio/e/c:dko	Lcom/tencent/mm/audio/e/a$a;
    //   1077: getfield 342	com/tencent/mm/audio/e/a$a:count	I
    //   1080: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 358	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: ldc 191
    //   1091: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1094: iload 5
    //   1096: ireturn
    //   1097: astore_1
    //   1098: ldc 104
    //   1100: ldc_w 360
    //   1103: iconst_1
    //   1104: anewarray 4	java/lang/Object
    //   1107: dup
    //   1108: iconst_0
    //   1109: aload_0
    //   1110: getfield 113	com/tencent/mm/audio/e/c:dke	Ljava/lang/String;
    //   1113: aastore
    //   1114: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1117: ldc 191
    //   1119: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: iconst_m1
    //   1123: ireturn
    //   1124: astore_1
    //   1125: ldc 104
    //   1127: ldc_w 362
    //   1130: iconst_4
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: iload 6
    //   1138: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_1
    //   1144: aload_0
    //   1145: getfield 68	com/tencent/mm/audio/e/c:dkf	I
    //   1148: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1151: aastore
    //   1152: dup
    //   1153: iconst_2
    //   1154: iload 7
    //   1156: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: aastore
    //   1160: dup
    //   1161: iconst_3
    //   1162: aload_1
    //   1163: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1166: aastore
    //   1167: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1170: ldc 191
    //   1172: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1175: iconst_m1
    //   1176: ireturn
    //   1177: goto -276 -> 901
    //   1180: iconst_0
    //   1181: istore 8
    //   1183: goto -855 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1186	0	this	c
    //   0	1186	1	parama	g.a
    //   0	1186	2	paramInt	int
    //   0	1186	3	paramBoolean	boolean
    //   28	736	4	i	int
    //   56	7	5	j	int
    //   152	943	5	k	int
    //   155	506	6	m	int
    //   661	476	6	n	int
    //   39	196	7	i1	int
    //   235	920	7	i2	int
    //   196	14	8	i3	int
    //   326	856	8	i4	int
    //   336	485	9	i5	int
    //   332	143	10	i6	int
    //   72	516	11	bool1	boolean
    //   68	33	12	bool2	boolean
    //   980	59	13	l	long
    //   12	964	15	locala	com.tencent.mm.compatible.util.f.a
    //   45	604	16	arrayOfByte1	byte[]
    //   65	814	17	arrayOfByte2	byte[]
    //   98	791	18	localObject1	Object
    //   246	603	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   171	213	592	java/lang/Exception
    //   642	656	666	java/lang/Exception
    //   251	258	731	finally
    //   265	291	731	finally
    //   291	299	731	finally
    //   299	328	731	finally
    //   328	331	731	finally
    //   709	728	731	finally
    //   732	735	731	finally
    //   792	802	904	java/io/IOException
    //   809	816	904	java/io/IOException
    //   825	860	904	java/io/IOException
    //   874	888	904	java/io/IOException
    //   938	945	1097	java/io/IOException
    //   945	975	1124	java/lang/Exception
  }
  
  public final boolean gI(String paramString)
  {
    AppMethodBeat.i(130016);
    ae.i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      ae.e("MicroMsg.SilkWriter", "path is null");
      AppMethodBeat.o(130016);
      return false;
    }
    try
    {
      localObject1 = new k(paramString);
      localk = new k(paramString);
      String str = paramString.substring(0, paramString.lastIndexOf("/") + 1);
      ae.e("MicroMsg.SilkWriter", "[carl] !!!! VFS parent! exists(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(new k(str).exists()), str });
      if (((k)localObject1).fTg().exists())
      {
        if (!localk.fTg().exists())
        {
          ae.e("MicroMsg.SilkWriter", "[carl] !!!! VFS not created dir! Do mkdirs(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(localk.fTg().mkdirs()), w.B(((k)localObject1).fTg().fTh()) });
          g.yxI.n(357L, 57L, 1L);
        }
        localk = null;
      }
    }
    catch (Throwable localException)
    {
      try
      {
        localObject1 = o.db(paramString, false);
        label197:
        if (localObject1 == null) {
          break label676;
        }
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject1;
          k localk;
          this.dke = paramString;
          this.mFileOutputStream = ((OutputStream)localObject1);
          this.dkk = false;
          i = m.aao();
          if ((i & 0x400) != 0) {}
          for (this.dkl = 4;; this.dkl = 2)
          {
            this.dkn = new i(this.mSampleRate, this.dkh, this.dkl);
            if (0L != this.dkn.izk) {
              break label517;
            }
            ae.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error");
            this.dkn = null;
            AppMethodBeat.o(130016);
            return false;
            ae.e("MicroMsg.SilkWriter", "[carl] ???? Dir not created! Do mkdirs(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(((k)localObject1).fTg().mkdirs()), w.B(((k)localObject1).fTg().fTh()) });
            g.yxI.n(357L, 58L, 1L);
            break;
            localThrowable = localThrowable;
            ae.printErrStackTrace("MicroMsg.SilkWriter", localThrowable, "Check out file dir error.", new Object[0]);
            break;
            localException = localException;
            ae.printErrStackTrace("MicroMsg.SilkWriter", localException, "initWriter openWrite failed: %s", new Object[] { localException.getMessage() });
            g.yxI.n(357L, 55L, 1L);
            Object localObject2 = localk;
            if (!com.tencent.mm.protocal.d.FFK) {
              break label197;
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("stack", localException.getMessage());
            g.yxI.g("Record", "Write failed", (Map)localObject2);
            localObject2 = localk;
            break label197;
            if ((i & 0x200) == 0) {
              break label501;
            }
          }
          ae.e("MicroMsg.SilkWriter", "initWriter cpuType error! silk don't support arm_v5!!!!");
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(130016);
          return false;
        }
        label501:
        AppMethodBeat.o(130016);
        return false;
      }
    }
    label517:
    this.dkg = new byte[this.mSampleRate * 20 * 2 / 1000];
    int j = -1;
    int i = j;
    if (ak.coh())
    {
      paramString = com.tencent.mm.model.c.d.aDI().xi("100279");
      i = j;
      if (paramString.isValid()) {
        i = bu.getInt((String)paramString.fsy().get("isVoiceMsgOptOpen"), 0);
      }
    }
    if (1 == i) {
      this.dkm = true;
    }
    if (i == 0) {
      this.dkm = false;
    }
    if (this.dkm)
    {
      if (this.dkn != null) {
        this.dkn.ds(200, 1);
      }
      ae.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
    }
    for (;;)
    {
      AppMethodBeat.o(130016);
      return true;
      if (this.dkn != null) {
        this.dkn.ds(200, 0);
      }
      ae.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
    }
    label676:
    AppMethodBeat.o(130016);
    return false;
  }
  
  public final class a
    implements e, h
  {
    private Future<?> dkp;
    
    private a() {}
    
    public final void RB()
    {
      AppMethodBeat.i(184404);
      if (this.dkp != null) {
        this.dkp.get();
      }
      AppMethodBeat.o(184404);
    }
    
    public final void a(Future<?> paramFuture)
    {
      this.dkp = paramFuture;
    }
    
    public final String getKey()
    {
      return "SilkWriter_run";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130014);
      ae.i("MicroMsg.SilkWriter", "Silk Thread start run");
      int i;
      for (;;)
      {
        boolean bool;
        synchronized (c.this)
        {
          bool = c.a(c.this);
          ae.d("MicroMsg.SilkWriter", "ThreadSilk in :" + bool + " cnt :" + c.b(c.this).size());
          if (bool) {
            if (c.b(c.this).isEmpty()) {
              break label286;
            }
          }
        }
        continue;
        i = c.b(c.this).size();
        if ((i > 10) || (bool))
        {
          ae.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + i + " stop:" + bool);
          i = 0;
        }
      }
      for (;;)
      {
        int j = i;
        if (c.RA().count >= 10)
        {
          j = i;
          if (c.RA().djZ > 240L) {
            j = 0;
          }
        }
        c.this.a(localInterruptedException, j, false);
        break;
        if (i < 9)
        {
          i = 1;
          continue;
          label286:
          AppMethodBeat.o(130014);
        }
        else
        {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.e.c
 * JD-Core Version:    0.7.0.1
 */