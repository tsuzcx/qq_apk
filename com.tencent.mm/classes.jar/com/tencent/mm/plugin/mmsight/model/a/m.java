package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  implements e
{
  private int audioSampleRate;
  private float bJg;
  private int bitrate;
  private int eRm;
  private int eVA;
  private boolean fcD;
  private String oJv;
  
  public m(int paramInt1, String paramString, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(76627);
    this.eRm = paramInt1;
    this.oJv = paramString;
    this.bJg = paramFloat;
    this.bitrate = paramInt2;
    this.eVA = paramInt3;
    this.audioSampleRate = paramInt4;
    this.fcD = paramBoolean;
    ab.i("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(76627);
  }
  
  /* Error */
  public final boolean bRm()
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 83	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   8: lstore_2
    //   9: aload_0
    //   10: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:oJv	Ljava/lang/String;
    //   13: invokestatic 89	com/tencent/mm/plugin/sight/base/d:Zm	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 95	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   23: istore 4
    //   25: iload 4
    //   27: ifne +6 -> 33
    //   30: aconst_null
    //   31: astore 5
    //   33: ldc 45
    //   35: ldc 97
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 31	com/tencent/mm/plugin/mmsight/model/a/m:eRm	I
    //   47: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload 5
    //   55: aastore
    //   56: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 31	com/tencent/mm/plugin/mmsight/model/a/m:eRm	I
    //   63: aload 5
    //   65: aload_0
    //   66: getfield 41	com/tencent/mm/plugin/mmsight/model/a/m:audioSampleRate	I
    //   69: sipush 1024
    //   72: iconst_2
    //   73: iconst_1
    //   74: lconst_0
    //   75: aload_0
    //   76: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:oJv	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:bJg	F
    //   83: sipush 1000
    //   86: aload_0
    //   87: getfield 39	com/tencent/mm/plugin/mmsight/model/a/m:eVA	I
    //   90: invokestatic 103	java/lang/Math:max	(II)I
    //   93: aload_0
    //   94: getfield 37	com/tencent/mm/plugin/mmsight/model/a/m:bitrate	I
    //   97: getstatic 108	com/tencent/mm/plugin/sight/base/b:qSn	I
    //   100: bipush 8
    //   102: iconst_2
    //   103: ldc 109
    //   105: aconst_null
    //   106: iconst_0
    //   107: iconst_0
    //   108: aload_0
    //   109: getfield 43	com/tencent/mm/plugin/mmsight/model/a/m:fcD	Z
    //   112: invokestatic 115	com/tencent/mm/plugin/sight/base/SightVideoJNI:muxingLock	(ILjava/lang/String;IIIIJLjava/lang/String;FIIIIIF[BIZZ)I
    //   115: istore_1
    //   116: ldc 45
    //   118: ldc 117
    //   120: iconst_2
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: iload_1
    //   127: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: lload_2
    //   134: invokestatic 121	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   137: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: aastore
    //   141: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload 5
    //   146: invokestatic 129	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   149: ifne +9 -> 158
    //   152: aload 5
    //   154: invokestatic 132	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   157: pop
    //   158: iload_1
    //   159: iflt +18 -> 177
    //   162: ldc 77
    //   164: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_1
    //   168: ireturn
    //   169: astore 5
    //   171: aconst_null
    //   172: astore 5
    //   174: goto -141 -> 33
    //   177: ldc 77
    //   179: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore 5
    //   186: goto -28 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	m
    //   115	44	1	i	int
    //   8	126	2	l	long
    //   23	3	4	bool	boolean
    //   16	137	5	str	String
    //   169	1	5	localException1	java.lang.Exception
    //   172	1	5	localObject	Object
    //   184	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	25	169	java/lang/Exception
    //   152	158	184	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */