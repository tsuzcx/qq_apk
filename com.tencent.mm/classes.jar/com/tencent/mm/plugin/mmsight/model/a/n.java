package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  implements e
{
  private int audioSampleRate;
  private int bitrate;
  private int bufId;
  private float cwp;
  private boolean hpg;
  private boolean hph;
  private boolean hyd;
  private int videoDuration;
  private String wcm;
  
  public n(int paramInt1, String paramString, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(89539);
    this.bufId = paramInt1;
    this.wcm = paramString;
    this.cwp = paramFloat;
    this.bitrate = paramInt2;
    this.videoDuration = paramInt3;
    this.audioSampleRate = paramInt4;
    this.hyd = paramBoolean1;
    this.hpg = paramBoolean2;
    this.hph = paramBoolean3;
    ae.i("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s, useSoftEncode:%s, enableHevc:%s", new Object[] { Integer.valueOf(paramInt1), paramString, Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    AppMethodBeat.o(89539);
  }
  
  /* Error */
  public final boolean dqi()
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 89	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   8: lstore_2
    //   9: new 91	com/tencent/mm/vfs/k
    //   12: dup
    //   13: aload_0
    //   14: getfield 35	com/tencent/mm/plugin/mmsight/model/a/n:wcm	Ljava/lang/String;
    //   17: invokespecial 94	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 98	com/tencent/mm/vfs/k:fTg	()Lcom/tencent/mm/vfs/k;
    //   23: invokevirtual 101	com/tencent/mm/vfs/k:mkdirs	()Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 35	com/tencent/mm/plugin/mmsight/model/a/n:wcm	Ljava/lang/String;
    //   31: invokestatic 107	com/tencent/mm/plugin/sight/base/e:ayL	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: invokestatic 113	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   41: istore 4
    //   43: iload 4
    //   45: ifne +6 -> 51
    //   48: aconst_null
    //   49: astore 5
    //   51: ldc 51
    //   53: ldc 115
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 33	com/tencent/mm/plugin/mmsight/model/a/n:bufId	I
    //   65: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload 5
    //   73: aastore
    //   74: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload_0
    //   78: getfield 33	com/tencent/mm/plugin/mmsight/model/a/n:bufId	I
    //   81: aload 5
    //   83: aload_0
    //   84: getfield 43	com/tencent/mm/plugin/mmsight/model/a/n:audioSampleRate	I
    //   87: sipush 1024
    //   90: iconst_2
    //   91: iconst_1
    //   92: lconst_0
    //   93: aload_0
    //   94: getfield 35	com/tencent/mm/plugin/mmsight/model/a/n:wcm	Ljava/lang/String;
    //   97: aload_0
    //   98: getfield 37	com/tencent/mm/plugin/mmsight/model/a/n:cwp	F
    //   101: sipush 1000
    //   104: aload_0
    //   105: getfield 41	com/tencent/mm/plugin/mmsight/model/a/n:videoDuration	I
    //   108: invokestatic 121	java/lang/Math:max	(II)I
    //   111: aload_0
    //   112: getfield 39	com/tencent/mm/plugin/mmsight/model/a/n:bitrate	I
    //   115: getstatic 126	com/tencent/mm/plugin/sight/base/c:zhj	I
    //   118: bipush 8
    //   120: iconst_2
    //   121: ldc 127
    //   123: aconst_null
    //   124: iconst_0
    //   125: iconst_0
    //   126: aload_0
    //   127: getfield 45	com/tencent/mm/plugin/mmsight/model/a/n:hyd	Z
    //   130: aload_0
    //   131: getfield 47	com/tencent/mm/plugin/mmsight/model/a/n:hpg	Z
    //   134: aload_0
    //   135: getfield 49	com/tencent/mm/plugin/mmsight/model/a/n:hph	Z
    //   138: aload_0
    //   139: getfield 47	com/tencent/mm/plugin/mmsight/model/a/n:hpg	Z
    //   142: aload_0
    //   143: getfield 49	com/tencent/mm/plugin/mmsight/model/a/n:hph	Z
    //   146: invokestatic 133	com/tencent/mm/plugin/sight/base/b:af	(ZZ)Z
    //   149: invokestatic 139	com/tencent/mm/plugin/sight/base/SightVideoJNI:muxingLock	(ILjava/lang/String;IIIIJLjava/lang/String;FIIIIIF[BIZZZZZ)I
    //   152: istore_1
    //   153: ldc 51
    //   155: ldc 141
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: iload_1
    //   164: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: lload_2
    //   171: invokestatic 145	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   174: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   177: aastore
    //   178: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload 5
    //   183: invokestatic 153	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   186: ifne +9 -> 195
    //   189: aload 5
    //   191: invokestatic 156	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   194: pop
    //   195: iload_1
    //   196: iflt +18 -> 214
    //   199: ldc 83
    //   201: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore 5
    //   208: aconst_null
    //   209: astore 5
    //   211: goto -160 -> 51
    //   214: ldc 83
    //   216: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore 5
    //   223: goto -28 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	n
    //   152	44	1	i	int
    //   8	163	2	l	long
    //   41	3	4	bool	boolean
    //   34	156	5	str	String
    //   206	1	5	localException1	java.lang.Exception
    //   209	1	5	localObject	Object
    //   221	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	43	206	java/lang/Exception
    //   189	195	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */