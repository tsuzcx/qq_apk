package com.tencent.mm.platformtools;

public final class ad
{
  public final int action;
  public final String content;
  public final int deV;
  public final int errorCode;
  public final int hWO;
  public final String title;
  public final int type;
  public final String url;
  
  /* Error */
  public ad(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	java/lang/Object:<init>	()V
    //   4: ldc 22
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 30
    //   11: astore 10
    //   13: iconst_5
    //   14: istore 4
    //   16: aload_3
    //   17: ldc 32
    //   19: invokestatic 38	com/tencent/mm/sdk/platformtools/bw:K	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   22: astore 9
    //   24: aload 9
    //   26: ifnonnull +100 -> 126
    //   29: new 40	java/lang/IllegalArgumentException
    //   32: dup
    //   33: ldc 42
    //   35: invokespecial 45	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   38: astore_3
    //   39: ldc 22
    //   41: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_3
    //   45: athrow
    //   46: astore 9
    //   48: ldc 30
    //   50: astore 8
    //   52: ldc 30
    //   54: astore_3
    //   55: iconst_0
    //   56: istore 5
    //   58: iconst_0
    //   59: istore 6
    //   61: ldc 50
    //   63: aload 9
    //   65: invokevirtual 54	java/lang/Exception:toString	()Ljava/lang/String;
    //   68: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 10
    //   73: astore 9
    //   75: aload_0
    //   76: iload_2
    //   77: putfield 61	com/tencent/mm/platformtools/ad:errorCode	I
    //   80: aload_0
    //   81: iload_1
    //   82: putfield 63	com/tencent/mm/platformtools/ad:deV	I
    //   85: aload_0
    //   86: iload 6
    //   88: putfield 65	com/tencent/mm/platformtools/ad:type	I
    //   91: aload_0
    //   92: iload 5
    //   94: putfield 67	com/tencent/mm/platformtools/ad:action	I
    //   97: aload_0
    //   98: aload 9
    //   100: putfield 69	com/tencent/mm/platformtools/ad:content	Ljava/lang/String;
    //   103: aload_0
    //   104: iload 4
    //   106: putfield 71	com/tencent/mm/platformtools/ad:hWO	I
    //   109: aload_0
    //   110: aload 8
    //   112: putfield 73	com/tencent/mm/platformtools/ad:title	Ljava/lang/String;
    //   115: aload_0
    //   116: aload_3
    //   117: putfield 75	com/tencent/mm/platformtools/ad:url	Ljava/lang/String;
    //   120: ldc 22
    //   122: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: aload 9
    //   128: ldc 77
    //   130: invokeinterface 83 2 0
    //   135: checkcast 85	java/lang/String
    //   138: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   141: invokevirtual 95	java/lang/Integer:intValue	()I
    //   144: istore 6
    //   146: aload 9
    //   148: ldc 97
    //   150: invokeinterface 83 2 0
    //   155: checkcast 85	java/lang/String
    //   158: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 95	java/lang/Integer:intValue	()I
    //   164: istore 5
    //   166: aload 9
    //   168: ldc 99
    //   170: invokeinterface 83 2 0
    //   175: checkcast 85	java/lang/String
    //   178: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   181: invokevirtual 95	java/lang/Integer:intValue	()I
    //   184: istore 7
    //   186: iload 7
    //   188: istore 4
    //   190: aload 9
    //   192: ldc 101
    //   194: invokeinterface 83 2 0
    //   199: checkcast 85	java/lang/String
    //   202: astore 8
    //   204: aload 9
    //   206: ldc 103
    //   208: invokeinterface 83 2 0
    //   213: checkcast 85	java/lang/String
    //   216: astore_3
    //   217: aload 9
    //   219: ldc 105
    //   221: invokeinterface 83 2 0
    //   226: checkcast 85	java/lang/String
    //   229: astore 9
    //   231: goto -156 -> 75
    //   234: astore 9
    //   236: ldc 30
    //   238: astore 8
    //   240: ldc 30
    //   242: astore_3
    //   243: iconst_0
    //   244: istore 5
    //   246: goto -185 -> 61
    //   249: astore 9
    //   251: ldc 30
    //   253: astore 8
    //   255: ldc 30
    //   257: astore_3
    //   258: goto -197 -> 61
    //   261: astore 9
    //   263: ldc 30
    //   265: astore 8
    //   267: ldc 30
    //   269: astore_3
    //   270: goto -209 -> 61
    //   273: astore 9
    //   275: ldc 30
    //   277: astore_3
    //   278: goto -217 -> 61
    //   281: astore 9
    //   283: goto -222 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	ad
    //   0	286	1	paramInt1	int
    //   0	286	2	paramInt2	int
    //   0	286	3	paramString	String
    //   14	175	4	i	int
    //   56	189	5	j	int
    //   59	86	6	k	int
    //   184	3	7	m	int
    //   50	216	8	str1	String
    //   22	3	9	localMap	java.util.Map
    //   46	18	9	localException1	java.lang.Exception
    //   73	157	9	str2	String
    //   234	1	9	localException2	java.lang.Exception
    //   249	1	9	localException3	java.lang.Exception
    //   261	1	9	localException4	java.lang.Exception
    //   273	1	9	localException5	java.lang.Exception
    //   281	1	9	localException6	java.lang.Exception
    //   11	61	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   16	24	46	java/lang/Exception
    //   29	46	46	java/lang/Exception
    //   126	146	46	java/lang/Exception
    //   146	166	234	java/lang/Exception
    //   166	186	249	java/lang/Exception
    //   190	204	261	java/lang/Exception
    //   204	217	273	java/lang/Exception
    //   217	231	281	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */