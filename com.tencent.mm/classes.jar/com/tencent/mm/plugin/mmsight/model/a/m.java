package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  implements e
{
  private String KXw;
  private int audioSampleRate;
  private int bitrate;
  private int bufId;
  private float eGw;
  private boolean nBZ;
  private boolean nLP;
  private boolean nyh;
  private int videoDuration;
  
  public m(int paramInt1, String paramString, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(89539);
    this.bufId = paramInt1;
    this.KXw = paramString;
    this.eGw = paramFloat;
    this.bitrate = paramInt2;
    this.videoDuration = paramInt3;
    this.audioSampleRate = paramInt4;
    this.nLP = paramBoolean1;
    this.nBZ = paramBoolean2;
    this.nyh = paramBoolean3;
    Log.i("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s, useSoftEncode:%s, enableHevc:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    AppMethodBeat.o(89539);
  }
  
  /* Error */
  public final boolean yu(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   8: lstore 4
    //   10: new 91	com/tencent/mm/vfs/u
    //   13: dup
    //   14: aload_0
    //   15: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:KXw	Ljava/lang/String;
    //   18: invokespecial 94	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 98	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   24: invokevirtual 102	com/tencent/mm/vfs/u:jKY	()Z
    //   27: pop
    //   28: aload_0
    //   29: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:KXw	Ljava/lang/String;
    //   32: invokestatic 108	com/tencent/mm/plugin/sight/base/f:aVV	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 6
    //   37: aload 6
    //   39: invokestatic 114	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifne +6 -> 50
    //   47: aconst_null
    //   48: astore 6
    //   50: ldc 51
    //   52: ldc 116
    //   54: iconst_3
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:bufId	I
    //   64: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload 6
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: iload_1
    //   76: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 33	com/tencent/mm/plugin/mmsight/model/a/m:bufId	I
    //   87: aload 6
    //   89: aload_0
    //   90: getfield 43	com/tencent/mm/plugin/mmsight/model/a/m:audioSampleRate	I
    //   93: sipush 1024
    //   96: iconst_2
    //   97: iconst_1
    //   98: lconst_0
    //   99: aload_0
    //   100: getfield 35	com/tencent/mm/plugin/mmsight/model/a/m:KXw	Ljava/lang/String;
    //   103: aload_0
    //   104: getfield 37	com/tencent/mm/plugin/mmsight/model/a/m:eGw	F
    //   107: sipush 1000
    //   110: aload_0
    //   111: getfield 41	com/tencent/mm/plugin/mmsight/model/a/m:videoDuration	I
    //   114: invokestatic 122	java/lang/Math:max	(II)I
    //   117: aload_0
    //   118: getfield 39	com/tencent/mm/plugin/mmsight/model/a/m:bitrate	I
    //   121: getstatic 127	com/tencent/mm/plugin/sight/base/d:PFh	I
    //   124: bipush 8
    //   126: iconst_2
    //   127: ldc 128
    //   129: aconst_null
    //   130: iconst_0
    //   131: iconst_0
    //   132: aload_0
    //   133: getfield 45	com/tencent/mm/plugin/mmsight/model/a/m:nLP	Z
    //   136: aload_0
    //   137: getfield 47	com/tencent/mm/plugin/mmsight/model/a/m:nBZ	Z
    //   140: aload_0
    //   141: getfield 49	com/tencent/mm/plugin/mmsight/model/a/m:nyh	Z
    //   144: iload_1
    //   145: invokestatic 134	com/tencent/mm/plugin/sight/base/SightVideoJNI:muxingLock	(ILjava/lang/String;IIIIJLjava/lang/String;FIIIIIF[BIZZZZZ)I
    //   148: istore_2
    //   149: ldc 51
    //   151: ldc 136
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload_2
    //   160: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: lload 4
    //   168: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   171: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload 6
    //   180: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   183: ifne +9 -> 192
    //   186: aload 6
    //   188: invokestatic 151	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   191: pop
    //   192: iload_2
    //   193: iflt +18 -> 211
    //   196: ldc 83
    //   198: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore 6
    //   205: aconst_null
    //   206: astore 6
    //   208: goto -158 -> 50
    //   211: ldc 83
    //   213: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore 6
    //   220: goto -28 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	m
    //   0	223	1	paramBoolean	boolean
    //   148	45	2	i	int
    //   42	2	3	bool	boolean
    //   8	159	4	l	long
    //   35	152	6	str	String
    //   203	1	6	localException1	java.lang.Exception
    //   206	1	6	localObject	Object
    //   218	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   37	43	203	java/lang/Exception
    //   186	192	218	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */