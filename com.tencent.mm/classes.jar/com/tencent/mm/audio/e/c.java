package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements a
{
  private static a.a clM;
  public boolean clA;
  private String clB;
  private int clC;
  private byte[] clD;
  private int clE;
  private Object clF;
  public a clG;
  private boolean clH;
  private OutputStream clI;
  private int clJ;
  private boolean clK;
  private i clL;
  public BlockingQueue<g.a> clz;
  private int mSampleRate;
  
  static
  {
    AppMethodBeat.i(55773);
    clM = new a.a();
    AppMethodBeat.o(55773);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55766);
    this.clz = new ArrayBlockingQueue(1024);
    this.clA = false;
    this.clC = 0;
    this.clD = null;
    this.mSampleRate = 16000;
    this.clE = 16000;
    this.clF = new Object();
    this.clG = null;
    this.clH = false;
    this.clK = false;
    this.mSampleRate = paramInt1;
    this.clE = paramInt2;
    AppMethodBeat.o(55766);
  }
  
  private void Fd()
  {
    AppMethodBeat.i(55769);
    synchronized (this.clF)
    {
      if (this.clL != null) {
        MediaRecorder.SilkEncUnInit(this.clL.fZI);
      }
      ab.i("MicroMsg.SilkWriter", "finish Thread file:" + this.clB);
      if (this.clI == null) {}
    }
    try
    {
      this.clI.close();
      this.clI = null;
      AppMethodBeat.o(55769);
      return;
      localObject2 = finally;
      AppMethodBeat.o(55769);
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SilkWriter", "close silk file:" + this.clB + "msg:" + localException.getMessage());
      }
    }
  }
  
  /* Error */
  public final void Fb()
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 102
    //   7: ldc 156
    //   9: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 66	com/tencent/mm/audio/e/c:clA	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 78	com/tencent/mm/audio/e/c:clG	Lcom/tencent/mm/audio/e/c$a;
    //   25: ifnull +15 -> 40
    //   28: getstatic 162	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   31: aload_0
    //   32: getfield 78	com/tencent/mm/audio/e/c:clG	Lcom/tencent/mm/audio/e/c$a;
    //   35: invokeinterface 168 2 0
    //   40: aload_0
    //   41: invokespecial 170	com/tencent/mm/audio/e/c:Fd	()V
    //   44: ldc 154
    //   46: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: ldc 154
    //   55: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: ldc 102
    //   63: ldc 172
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_1
    //   72: invokestatic 178	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -39 -> 40
    //   82: astore_1
    //   83: ldc 102
    //   85: ldc 172
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: invokestatic 178	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: goto -61 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	c
    //   50	9	1	localObject	Object
    //   60	12	1	localInterruptedException	InterruptedException
    //   82	12	1	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   14	21	50	finally
    //   51	53	50	finally
    //   28	40	60	java/lang/InterruptedException
    //   28	40	82	java/util/concurrent/ExecutionException
  }
  
  public final boolean Fc()
  {
    AppMethodBeat.i(55770);
    ab.i("MicroMsg.SilkWriter", "resetWriter");
    synchronized (this.clF)
    {
      if (this.clL != null) {
        MediaRecorder.SilkEncUnInit(this.clL.fZI);
      }
      this.clL = new i(this.mSampleRate, this.clE, this.clJ);
      if (0L == this.clL.fZI)
      {
        ab.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error");
        this.clL = null;
        AppMethodBeat.o(55770);
        return false;
      }
    }
    AppMethodBeat.o(55770);
    return true;
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(55771);
    int i = a(parama, 0, false);
    AppMethodBeat.o(55771);
    return i;
  }
  
  /* Error */
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 201
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 203	com/tencent/mm/compatible/util/g$a
    //   8: dup
    //   9: invokespecial 204	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   12: astore 14
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
    //   31: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   34: aload_1
    //   35: getfield 209	com/tencent/mm/audio/b/g$a:ckj	I
    //   38: iadd
    //   39: istore 7
    //   41: iload 4
    //   43: newarray byte
    //   45: astore 15
    //   47: aload_0
    //   48: getfield 82	com/tencent/mm/audio/e/c:clK	Z
    //   51: ifeq +515 -> 566
    //   54: bipush 6
    //   56: istore 5
    //   58: iload 5
    //   60: iload 4
    //   62: imul
    //   63: newarray byte
    //   65: astore 16
    //   67: iconst_1
    //   68: istore 11
    //   70: ldc 211
    //   72: invokestatic 217	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   75: checkcast 211	com/tencent/mm/plugin/zero/b/a
    //   78: invokeinterface 221 1 0
    //   83: ldc 223
    //   85: invokevirtual 229	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 17
    //   90: aload 17
    //   92: invokestatic 233	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   95: ifne +16 -> 111
    //   98: aload 17
    //   100: iconst_1
    //   101: invokestatic 237	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   104: iconst_1
    //   105: if_icmpne +467 -> 572
    //   108: iconst_1
    //   109: istore 11
    //   111: iload_3
    //   112: ifeq +6 -> 118
    //   115: iconst_0
    //   116: istore 11
    //   118: ldc 102
    //   120: ldc 239
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: iload 11
    //   130: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   133: aastore
    //   134: invokestatic 248	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iconst_0
    //   141: istore 6
    //   143: iload 7
    //   145: iload 4
    //   147: if_icmplt +770 -> 917
    //   150: aload_0
    //   151: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   154: ifle +474 -> 628
    //   157: aload_0
    //   158: getfield 70	com/tencent/mm/audio/e/c:clD	[B
    //   161: iconst_0
    //   162: aload 15
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   169: invokestatic 254	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: aload_1
    //   173: getfield 257	com/tencent/mm/audio/b/g$a:buf	[B
    //   176: astore 17
    //   178: aload_0
    //   179: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   182: istore 8
    //   184: aload 17
    //   186: iconst_0
    //   187: aload 15
    //   189: iload 8
    //   191: iload 4
    //   193: iload 8
    //   195: isub
    //   196: invokestatic 254	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   199: iload 4
    //   201: aload_0
    //   202: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   205: isub
    //   206: iload 6
    //   208: iadd
    //   209: istore 6
    //   211: aload_0
    //   212: iconst_0
    //   213: putfield 68	com/tencent/mm/audio/e/c:clC	I
    //   216: iload 7
    //   218: iload 4
    //   220: isub
    //   221: istore 7
    //   223: iconst_1
    //   224: newarray short
    //   226: astore 17
    //   228: aload_0
    //   229: getfield 76	com/tencent/mm/audio/e/c:clF	Ljava/lang/Object;
    //   232: astore 18
    //   234: aload 18
    //   236: monitorenter
    //   237: aload_0
    //   238: getfield 82	com/tencent/mm/audio/e/c:clK	Z
    //   241: ifeq +44 -> 285
    //   244: iload 7
    //   246: iload 4
    //   248: if_icmpge +447 -> 695
    //   251: aload_1
    //   252: getfield 260	com/tencent/mm/audio/b/g$a:ckk	Z
    //   255: ifeq +440 -> 695
    //   258: aload_0
    //   259: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   262: ifnull +15 -> 277
    //   265: aload_0
    //   266: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   269: sipush 201
    //   272: iconst_1
    //   273: invokevirtual 264	com/tencent/mm/modelvoice/i:cK	(II)I
    //   276: pop
    //   277: ldc 102
    //   279: ldc_w 266
    //   282: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   289: ifnull +877 -> 1166
    //   292: aload 15
    //   294: iload 4
    //   296: aload 16
    //   298: aload 17
    //   300: iload 11
    //   302: aload_0
    //   303: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   306: getfield 94	com/tencent/mm/modelvoice/i:fZI	J
    //   309: invokestatic 270	com/tencent/mm/modelvoice/MediaRecorder:SilkDoEnc	([BS[B[SZJ)I
    //   312: istore 8
    //   314: aload 18
    //   316: monitorexit
    //   317: iconst_0
    //   318: istore 10
    //   320: iload 10
    //   322: istore 9
    //   324: iload_3
    //   325: ifeq +160 -> 485
    //   328: iload 10
    //   330: istore 9
    //   332: aload 17
    //   334: iconst_0
    //   335: saload
    //   336: bipush 10
    //   338: if_icmplt +147 -> 485
    //   341: iload 10
    //   343: istore 9
    //   345: aload 16
    //   347: iconst_0
    //   348: baload
    //   349: iconst_2
    //   350: if_icmpne +135 -> 485
    //   353: iload 10
    //   355: istore 9
    //   357: aload 16
    //   359: iconst_1
    //   360: baload
    //   361: bipush 35
    //   363: if_icmpne +122 -> 485
    //   366: iload 10
    //   368: istore 9
    //   370: aload 16
    //   372: iconst_2
    //   373: baload
    //   374: bipush 33
    //   376: if_icmpne +109 -> 485
    //   379: iload 10
    //   381: istore 9
    //   383: aload 16
    //   385: iconst_3
    //   386: baload
    //   387: bipush 83
    //   389: if_icmpne +96 -> 485
    //   392: iload 10
    //   394: istore 9
    //   396: aload 16
    //   398: iconst_4
    //   399: baload
    //   400: bipush 73
    //   402: if_icmpne +83 -> 485
    //   405: iload 10
    //   407: istore 9
    //   409: aload 16
    //   411: iconst_5
    //   412: baload
    //   413: bipush 76
    //   415: if_icmpne +70 -> 485
    //   418: iload 10
    //   420: istore 9
    //   422: aload 16
    //   424: bipush 6
    //   426: baload
    //   427: bipush 75
    //   429: if_icmpne +56 -> 485
    //   432: iload 10
    //   434: istore 9
    //   436: aload 16
    //   438: bipush 7
    //   440: baload
    //   441: bipush 95
    //   443: if_icmpne +42 -> 485
    //   446: iload 10
    //   448: istore 9
    //   450: aload 16
    //   452: bipush 8
    //   454: baload
    //   455: bipush 86
    //   457: if_icmpne +28 -> 485
    //   460: iload 10
    //   462: istore 9
    //   464: aload 16
    //   466: bipush 9
    //   468: baload
    //   469: bipush 51
    //   471: if_icmpne +14 -> 485
    //   474: ldc 102
    //   476: ldc_w 272
    //   479: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: iconst_1
    //   483: istore 9
    //   485: iload 8
    //   487: ifeq +241 -> 728
    //   490: aload_0
    //   491: iconst_0
    //   492: putfield 68	com/tencent/mm/audio/e/c:clC	I
    //   495: ldc 102
    //   497: ldc_w 274
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: iload 8
    //   508: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: getfield 80	com/tencent/mm/audio/e/c:clH	Z
    //   519: ifne +40 -> 559
    //   522: getstatic 285	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   525: ldc2_w 286
    //   528: ldc2_w 288
    //   531: lconst_1
    //   532: invokevirtual 293	com/tencent/mm/plugin/report/service/h:j	(JJJ)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 80	com/tencent/mm/audio/e/c:clH	Z
    //   540: getstatic 298	com/tencent/mm/protocal/d:whK	Z
    //   543: ifeq +16 -> 559
    //   546: getstatic 285	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   549: ldc_w 300
    //   552: ldc_w 302
    //   555: aconst_null
    //   556: invokevirtual 306	com/tencent/mm/plugin/report/service/h:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   559: ldc 201
    //   561: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: iconst_m1
    //   565: ireturn
    //   566: iconst_1
    //   567: istore 5
    //   569: goto -511 -> 58
    //   572: iconst_0
    //   573: istore 11
    //   575: goto -464 -> 111
    //   578: astore_1
    //   579: ldc 102
    //   581: ldc_w 308
    //   584: iconst_3
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_0
    //   591: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   594: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: aastore
    //   598: dup
    //   599: iconst_1
    //   600: iload 4
    //   602: aload_0
    //   603: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   606: isub
    //   607: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: iconst_2
    //   613: aload_1
    //   614: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   617: aastore
    //   618: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   621: ldc 201
    //   623: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: iconst_m1
    //   627: ireturn
    //   628: aload_1
    //   629: getfield 257	com/tencent/mm/audio/b/g$a:buf	[B
    //   632: iload 6
    //   634: aload 15
    //   636: iconst_0
    //   637: iload 4
    //   639: invokestatic 254	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   642: iload 6
    //   644: iload 4
    //   646: iadd
    //   647: istore 6
    //   649: goto -433 -> 216
    //   652: astore_1
    //   653: ldc 102
    //   655: ldc_w 310
    //   658: iconst_3
    //   659: anewarray 4	java/lang/Object
    //   662: dup
    //   663: iconst_0
    //   664: iload 6
    //   666: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   669: aastore
    //   670: dup
    //   671: iconst_1
    //   672: iload 4
    //   674: invokestatic 315	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   677: aastore
    //   678: dup
    //   679: iconst_2
    //   680: aload_1
    //   681: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   684: aastore
    //   685: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: ldc 201
    //   690: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   693: iconst_m1
    //   694: ireturn
    //   695: aload_0
    //   696: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   699: ifnull -414 -> 285
    //   702: aload_0
    //   703: getfield 88	com/tencent/mm/audio/e/c:clL	Lcom/tencent/mm/modelvoice/i;
    //   706: sipush 201
    //   709: iconst_0
    //   710: invokevirtual 264	com/tencent/mm/modelvoice/i:cK	(II)I
    //   713: pop
    //   714: goto -429 -> 285
    //   717: astore_1
    //   718: aload 18
    //   720: monitorexit
    //   721: ldc 201
    //   723: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_1
    //   727: athrow
    //   728: ldc 102
    //   730: ldc_w 317
    //   733: iconst_4
    //   734: anewarray 4	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: aload 17
    //   741: iconst_0
    //   742: saload
    //   743: invokestatic 315	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: iload 4
    //   751: invokestatic 315	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   754: aastore
    //   755: dup
    //   756: iconst_2
    //   757: aload_1
    //   758: getfield 260	com/tencent/mm/audio/b/g$a:ckk	Z
    //   761: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   764: aastore
    //   765: dup
    //   766: iconst_3
    //   767: aload_1
    //   768: getfield 209	com/tencent/mm/audio/b/g$a:ckj	I
    //   771: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: invokestatic 320	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: aload 17
    //   780: iconst_0
    //   781: saload
    //   782: aload 16
    //   784: arraylength
    //   785: if_icmpge +378 -> 1163
    //   788: aload 17
    //   790: iconst_0
    //   791: saload
    //   792: ifle +371 -> 1163
    //   795: aload_0
    //   796: getfield 126	com/tencent/mm/audio/e/c:clI	Ljava/io/OutputStream;
    //   799: ifnull +364 -> 1163
    //   802: iload_3
    //   803: ifeq +57 -> 860
    //   806: iload 9
    //   808: ifeq +52 -> 860
    //   811: ldc 102
    //   813: ldc_w 322
    //   816: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: aload 16
    //   821: iconst_1
    //   822: aload 16
    //   824: arraylength
    //   825: invokestatic 328	java/util/Arrays:copyOfRange	([BII)[B
    //   828: astore 18
    //   830: aload_0
    //   831: getfield 126	com/tencent/mm/audio/e/c:clI	Ljava/io/OutputStream;
    //   834: aload 18
    //   836: iconst_0
    //   837: aload 17
    //   839: iconst_0
    //   840: saload
    //   841: iconst_1
    //   842: isub
    //   843: invokevirtual 332	java/io/OutputStream:write	([BII)V
    //   846: iload 5
    //   848: aload 17
    //   850: iconst_0
    //   851: saload
    //   852: iconst_1
    //   853: isub
    //   854: iadd
    //   855: istore 5
    //   857: goto -714 -> 143
    //   860: aload_0
    //   861: getfield 126	com/tencent/mm/audio/e/c:clI	Ljava/io/OutputStream;
    //   864: aload 16
    //   866: iconst_0
    //   867: aload 17
    //   869: iconst_0
    //   870: saload
    //   871: invokevirtual 332	java/io/OutputStream:write	([BII)V
    //   874: aload 17
    //   876: iconst_0
    //   877: saload
    //   878: istore 8
    //   880: iload 8
    //   882: iload 5
    //   884: iadd
    //   885: istore 5
    //   887: goto -744 -> 143
    //   890: astore_1
    //   891: ldc 102
    //   893: ldc_w 334
    //   896: iconst_1
    //   897: anewarray 4	java/lang/Object
    //   900: dup
    //   901: iconst_0
    //   902: aload_0
    //   903: getfield 111	com/tencent/mm/audio/e/c:clB	Ljava/lang/String;
    //   906: aastore
    //   907: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   910: ldc 201
    //   912: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: iconst_m1
    //   916: ireturn
    //   917: aload_0
    //   918: getfield 126	com/tencent/mm/audio/e/c:clI	Ljava/io/OutputStream;
    //   921: ifnull +10 -> 931
    //   924: aload_0
    //   925: getfield 126	com/tencent/mm/audio/e/c:clI	Ljava/io/OutputStream;
    //   928: invokevirtual 337	java/io/OutputStream:flush	()V
    //   931: aload_1
    //   932: getfield 257	com/tencent/mm/audio/b/g$a:buf	[B
    //   935: iload 6
    //   937: aload_0
    //   938: getfield 70	com/tencent/mm/audio/e/c:clD	[B
    //   941: aload_0
    //   942: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   945: iload 7
    //   947: invokestatic 254	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   950: aload_0
    //   951: aload_0
    //   952: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   955: iload 7
    //   957: iadd
    //   958: putfield 68	com/tencent/mm/audio/e/c:clC	I
    //   961: aload 14
    //   963: invokevirtual 341	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   966: lstore 12
    //   968: iload_2
    //   969: iconst_1
    //   970: if_icmpne +42 -> 1012
    //   973: getstatic 51	com/tencent/mm/audio/e/c:clM	Lcom/tencent/mm/audio/e/a$a;
    //   976: astore_1
    //   977: aload_1
    //   978: aload_1
    //   979: getfield 344	com/tencent/mm/audio/e/a$a:clw	J
    //   982: aload_1
    //   983: getfield 347	com/tencent/mm/audio/e/a$a:count	I
    //   986: i2l
    //   987: lmul
    //   988: lload 12
    //   990: ladd
    //   991: aload_1
    //   992: getfield 347	com/tencent/mm/audio/e/a$a:count	I
    //   995: iconst_1
    //   996: iadd
    //   997: i2l
    //   998: ldiv
    //   999: putfield 344	com/tencent/mm/audio/e/a$a:clw	J
    //   1002: aload_1
    //   1003: aload_1
    //   1004: getfield 347	com/tencent/mm/audio/e/a$a:count	I
    //   1007: iconst_1
    //   1008: iadd
    //   1009: putfield 347	com/tencent/mm/audio/e/a$a:count	I
    //   1012: ldc 102
    //   1014: new 104	java/lang/StringBuilder
    //   1017: dup
    //   1018: ldc_w 349
    //   1021: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1024: lload 12
    //   1026: invokevirtual 352	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1029: ldc_w 354
    //   1032: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: iload_2
    //   1036: invokevirtual 357	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1039: ldc_w 359
    //   1042: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: getstatic 51	com/tencent/mm/audio/e/c:clM	Lcom/tencent/mm/audio/e/a$a;
    //   1048: getfield 344	com/tencent/mm/audio/e/a$a:clw	J
    //   1051: invokevirtual 352	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1054: ldc_w 361
    //   1057: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: getstatic 51	com/tencent/mm/audio/e/c:clM	Lcom/tencent/mm/audio/e/a$a;
    //   1063: getfield 347	com/tencent/mm/audio/e/a$a:count	I
    //   1066: invokevirtual 357	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 363	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: ldc 201
    //   1077: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1080: iload 5
    //   1082: ireturn
    //   1083: astore_1
    //   1084: ldc 102
    //   1086: ldc_w 365
    //   1089: iconst_1
    //   1090: anewarray 4	java/lang/Object
    //   1093: dup
    //   1094: iconst_0
    //   1095: aload_0
    //   1096: getfield 111	com/tencent/mm/audio/e/c:clB	Ljava/lang/String;
    //   1099: aastore
    //   1100: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1103: ldc 201
    //   1105: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1108: iconst_m1
    //   1109: ireturn
    //   1110: astore_1
    //   1111: ldc 102
    //   1113: ldc_w 367
    //   1116: iconst_4
    //   1117: anewarray 4	java/lang/Object
    //   1120: dup
    //   1121: iconst_0
    //   1122: iload 6
    //   1124: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_1
    //   1130: aload_0
    //   1131: getfield 68	com/tencent/mm/audio/e/c:clC	I
    //   1134: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1137: aastore
    //   1138: dup
    //   1139: iconst_2
    //   1140: iload 7
    //   1142: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1145: aastore
    //   1146: dup
    //   1147: iconst_3
    //   1148: aload_1
    //   1149: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1152: aastore
    //   1153: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1156: ldc 201
    //   1158: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1161: iconst_m1
    //   1162: ireturn
    //   1163: goto -276 -> 887
    //   1166: iconst_0
    //   1167: istore 8
    //   1169: goto -855 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1172	0	this	c
    //   0	1172	1	parama	g.a
    //   0	1172	2	paramInt	int
    //   0	1172	3	paramBoolean	boolean
    //   28	722	4	i	int
    //   56	7	5	j	int
    //   138	943	5	k	int
    //   141	506	6	m	int
    //   647	476	6	n	int
    //   39	182	7	i1	int
    //   221	920	7	i2	int
    //   182	14	8	i3	int
    //   312	856	8	i4	int
    //   322	485	9	i5	int
    //   318	143	10	i6	int
    //   68	506	11	bool	boolean
    //   966	59	12	l	long
    //   12	950	14	locala	com.tencent.mm.compatible.util.g.a
    //   45	590	15	arrayOfByte1	byte[]
    //   65	800	16	arrayOfByte2	byte[]
    //   88	787	17	localObject1	Object
    //   232	603	18	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	199	578	java/lang/Exception
    //   628	642	652	java/lang/Exception
    //   237	244	717	finally
    //   251	277	717	finally
    //   277	285	717	finally
    //   285	314	717	finally
    //   314	317	717	finally
    //   695	714	717	finally
    //   718	721	717	finally
    //   778	788	890	java/io/IOException
    //   795	802	890	java/io/IOException
    //   811	846	890	java/io/IOException
    //   860	874	890	java/io/IOException
    //   924	931	1083	java/io/IOException
    //   931	961	1110	java/lang/Exception
  }
  
  public final boolean eN(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(55767);
    ab.i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      ab.e("MicroMsg.SilkWriter", "path is null");
      AppMethodBeat.o(55767);
      return false;
    }
    try
    {
      localObject1 = e.M(paramString, false);
      if (localObject1 == null) {
        break label438;
      }
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject1;
        this.clB = paramString;
        this.clI = ((OutputStream)localObject1);
        this.clH = false;
        i = m.Lo();
        if ((i & 0x400) != 0) {}
        for (this.clJ = 4;; this.clJ = 2)
        {
          this.clL = new i(this.mSampleRate, this.clE, this.clJ);
          if (0L != this.clL.fZI) {
            break label289;
          }
          ab.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error");
          this.clL = null;
          AppMethodBeat.o(55767);
          return false;
          localException = localException;
          ab.printErrStackTrace("MicroMsg.SilkWriter", localException, "initWriter openWrite failed: %s", new Object[] { localException.getMessage() });
          h.qsU.j(357L, 55L, 1L);
          localObject1 = localObject2;
          if (!com.tencent.mm.protocal.d.whK) {
            break;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("stack", localException.getMessage());
          h.qsU.g("Record", "Write failed", (Map)localObject1);
          localObject1 = localObject2;
          break;
          if ((i & 0x200) == 0) {
            break label272;
          }
        }
        ab.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(55767);
        return false;
      }
      label272:
      AppMethodBeat.o(55767);
      return false;
    }
    label289:
    this.clD = new byte[this.mSampleRate * 20 * 2 / 1000];
    int i = -1;
    paramString = com.tencent.mm.model.c.c.abU().me("100279");
    if (paramString.isValid()) {
      i = bo.getInt((String)paramString.dvN().get("isVoiceMsgOptOpen"), 0);
    }
    if (1 == i) {
      this.clK = true;
    }
    if (i == 0) {
      this.clK = false;
    }
    if (this.clK)
    {
      if (this.clL != null) {
        this.clL.cK(200, 1);
      }
      ab.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
    }
    for (;;)
    {
      AppMethodBeat.o(55767);
      return true;
      if (this.clL != null) {
        this.clL.cK(200, 0);
      }
      ab.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
    }
    label438:
    AppMethodBeat.o(55767);
    return false;
  }
  
  public final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(55765);
      ab.i("MicroMsg.SilkWriter", "Silk Thread start run");
      int i;
      for (;;)
      {
        boolean bool;
        synchronized (c.this)
        {
          bool = c.a(c.this);
          ab.d("MicroMsg.SilkWriter", "ThreadSilk in :" + bool + " cnt :" + c.b(c.this).size());
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
          ab.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + i + " stop:" + bool);
          i = 0;
        }
      }
      for (;;)
      {
        int j = i;
        if (c.Fe().count >= 10)
        {
          j = i;
          if (c.Fe().clw > 240L) {
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
          AppMethodBeat.o(55765);
        }
        else
        {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.e.c
 * JD-Core Version:    0.7.0.1
 */