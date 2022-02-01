package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  implements e
{
  private int audioSampleRate;
  private int bitrate;
  private float clj;
  private int gNJ;
  private boolean gUr;
  private boolean gUs;
  private boolean hdh;
  private String uNb;
  private int videoDuration;
  
  public m(int paramInt1, String paramString, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(89539);
    this.gNJ = paramInt1;
    this.uNb = paramString;
    this.clj = paramFloat;
    this.bitrate = paramInt2;
    this.videoDuration = paramInt3;
    this.audioSampleRate = paramInt4;
    this.hdh = paramBoolean1;
    this.gUr = paramBoolean2;
    this.gUs = paramBoolean3;
    ac.i("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s, useSoftEncode:%s, enableHevc:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    AppMethodBeat.o(89539);
  }
  
  /* Error */
  public final boolean ddO()
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 89	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   8: lstore_2
    //   9: aload_0
    //   10: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:uNb	Ljava/lang/String;
    //   13: invokestatic 95	com/tencent/mm/plugin/sight/base/e:asv	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 101	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   23: istore 4
    //   25: iload 4
    //   27: ifne +6 -> 33
    //   30: aconst_null
    //   31: astore 5
    //   33: ldc 51
    //   35: ldc 103
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:gNJ	I
    //   47: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload 5
    //   55: aastore
    //   56: invokestatic 74	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:gNJ	I
    //   63: aload 5
    //   65: aload_0
    //   66: getfield 43	com/tencent/mm/plugin/mmsight/model/a/m:audioSampleRate	I
    //   69: sipush 1024
    //   72: iconst_2
    //   73: iconst_1
    //   74: lconst_0
    //   75: aload_0
    //   76: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:uNb	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 37	com/tencent/mm/plugin/mmsight/model/a/m:clj	F
    //   83: sipush 1000
    //   86: aload_0
    //   87: getfield 41	com/tencent/mm/plugin/mmsight/model/a/m:videoDuration	I
    //   90: invokestatic 109	java/lang/Math:max	(II)I
    //   93: aload_0
    //   94: getfield 39	com/tencent/mm/plugin/mmsight/model/a/m:bitrate	I
    //   97: getstatic 114	com/tencent/mm/plugin/sight/base/c:xCp	I
    //   100: bipush 8
    //   102: iconst_2
    //   103: ldc 115
    //   105: aconst_null
    //   106: iconst_0
    //   107: iconst_0
    //   108: aload_0
    //   109: getfield 45	com/tencent/mm/plugin/mmsight/model/a/m:hdh	Z
    //   112: aload_0
    //   113: getfield 47	com/tencent/mm/plugin/mmsight/model/a/m:gUr	Z
    //   116: aload_0
    //   117: getfield 49	com/tencent/mm/plugin/mmsight/model/a/m:gUs	Z
    //   120: aload_0
    //   121: getfield 47	com/tencent/mm/plugin/mmsight/model/a/m:gUr	Z
    //   124: aload_0
    //   125: getfield 49	com/tencent/mm/plugin/mmsight/model/a/m:gUs	Z
    //   128: invokestatic 121	com/tencent/mm/plugin/sight/base/b:ac	(ZZ)Z
    //   131: invokestatic 127	com/tencent/mm/plugin/sight/base/SightVideoJNI:muxingLock	(ILjava/lang/String;IIIIJLjava/lang/String;FIIIIIF[BIZZZZZ)I
    //   134: istore_1
    //   135: ldc 51
    //   137: ldc 129
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: iload_1
    //   146: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: lload_2
    //   153: invokestatic 133	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   156: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   159: aastore
    //   160: invokestatic 74	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload 5
    //   165: invokestatic 141	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   168: ifne +9 -> 177
    //   171: aload 5
    //   173: invokestatic 144	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   176: pop
    //   177: iload_1
    //   178: iflt +18 -> 196
    //   181: ldc 83
    //   183: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore 5
    //   190: aconst_null
    //   191: astore 5
    //   193: goto -160 -> 33
    //   196: ldc 83
    //   198: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore 5
    //   205: goto -28 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	m
    //   134	44	1	i	int
    //   8	145	2	l	long
    //   23	3	4	bool	boolean
    //   16	156	5	str	String
    //   188	1	5	localException1	java.lang.Exception
    //   191	1	5	localObject	Object
    //   203	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	25	188	java/lang/Exception
    //   171	177	203	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */