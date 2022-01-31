package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.y;

public final class m
  implements e
{
  private int audioSampleRate;
  private int bitrate;
  private int eIz;
  private boolean gEx;
  private int jlu;
  private float mjQ;
  private String mjY;
  
  public m(int paramInt1, String paramString, float paramFloat, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.eIz = paramInt1;
    this.mjY = paramString;
    this.mjQ = paramFloat;
    this.bitrate = paramInt2;
    this.jlu = paramInt3;
    this.audioSampleRate = paramInt4;
    this.gEx = paramBoolean;
    y.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
  }
  
  /* Error */
  public final boolean bjx()
  {
    // Byte code:
    //   0: invokestatic 73	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 26	com/tencent/mm/plugin/mmsight/model/a/m:mjY	Ljava/lang/String;
    //   8: invokestatic 79	com/tencent/mm/plugin/sight/base/d:MF	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 5
    //   13: aload 5
    //   15: invokestatic 85	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifne +6 -> 28
    //   25: aconst_null
    //   26: astore 5
    //   28: ldc 38
    //   30: ldc 87
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 24	com/tencent/mm/plugin/mmsight/model/a/m:eIz	I
    //   42: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload 5
    //   50: aastore
    //   51: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: getfield 24	com/tencent/mm/plugin/mmsight/model/a/m:eIz	I
    //   58: aload 5
    //   60: aload_0
    //   61: getfield 34	com/tencent/mm/plugin/mmsight/model/a/m:audioSampleRate	I
    //   64: sipush 1024
    //   67: iconst_2
    //   68: iconst_1
    //   69: lconst_0
    //   70: aload_0
    //   71: getfield 26	com/tencent/mm/plugin/mmsight/model/a/m:mjY	Ljava/lang/String;
    //   74: aload_0
    //   75: getfield 28	com/tencent/mm/plugin/mmsight/model/a/m:mjQ	F
    //   78: sipush 1000
    //   81: aload_0
    //   82: getfield 32	com/tencent/mm/plugin/mmsight/model/a/m:jlu	I
    //   85: invokestatic 96	java/lang/Math:max	(II)I
    //   88: aload_0
    //   89: getfield 30	com/tencent/mm/plugin/mmsight/model/a/m:bitrate	I
    //   92: getstatic 101	com/tencent/mm/plugin/sight/base/b:odY	I
    //   95: bipush 8
    //   97: iconst_2
    //   98: ldc 102
    //   100: aconst_null
    //   101: iconst_0
    //   102: iconst_0
    //   103: aload_0
    //   104: getfield 36	com/tencent/mm/plugin/mmsight/model/a/m:gEx	Z
    //   107: invokestatic 108	com/tencent/mm/plugin/sight/base/SightVideoJNI:muxingLock	(ILjava/lang/String;IIIIJLjava/lang/String;FIIIIIF[BIZZ)I
    //   110: istore_1
    //   111: ldc 38
    //   113: ldc 110
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: iload_1
    //   122: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: lload_2
    //   129: invokestatic 114	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   132: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 5
    //   141: invokestatic 122	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   144: ifne +9 -> 153
    //   147: aload 5
    //   149: invokestatic 125	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   152: pop
    //   153: iload_1
    //   154: iflt +13 -> 167
    //   157: iconst_1
    //   158: ireturn
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 5
    //   164: goto -136 -> 28
    //   167: iconst_0
    //   168: ireturn
    //   169: astore 5
    //   171: goto -18 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	m
    //   110	44	1	i	int
    //   3	126	2	l	long
    //   18	3	4	bool	boolean
    //   11	137	5	str	String
    //   159	1	5	localException1	java.lang.Exception
    //   162	1	5	localObject	Object
    //   169	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   13	20	159	java/lang/Exception
    //   147	153	169	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */