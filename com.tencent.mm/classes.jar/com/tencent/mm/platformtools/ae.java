package com.tencent.mm.platformtools;

public final class ae
{
  public final int action;
  public final String content;
  public final int dGe;
  public final int errorCode;
  public final int jPP;
  public final String title;
  public final int type;
  public final String url;
  
  /* Error */
  public ae(int paramInt1, int paramInt2, String paramString)
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
    //   19: aconst_null
    //   20: invokestatic 38	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   23: astore 9
    //   25: aload 9
    //   27: ifnonnull +100 -> 127
    //   30: new 40	java/lang/IllegalArgumentException
    //   33: dup
    //   34: ldc 42
    //   36: invokespecial 45	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: ldc 22
    //   42: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_3
    //   46: athrow
    //   47: astore 9
    //   49: ldc 30
    //   51: astore 8
    //   53: ldc 30
    //   55: astore_3
    //   56: iconst_0
    //   57: istore 5
    //   59: iconst_0
    //   60: istore 6
    //   62: ldc 50
    //   64: aload 9
    //   66: invokevirtual 54	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 10
    //   74: astore 9
    //   76: aload_0
    //   77: iload_2
    //   78: putfield 61	com/tencent/mm/platformtools/ae:errorCode	I
    //   81: aload_0
    //   82: iload_1
    //   83: putfield 63	com/tencent/mm/platformtools/ae:dGe	I
    //   86: aload_0
    //   87: iload 6
    //   89: putfield 65	com/tencent/mm/platformtools/ae:type	I
    //   92: aload_0
    //   93: iload 5
    //   95: putfield 67	com/tencent/mm/platformtools/ae:action	I
    //   98: aload_0
    //   99: aload 9
    //   101: putfield 69	com/tencent/mm/platformtools/ae:content	Ljava/lang/String;
    //   104: aload_0
    //   105: iload 4
    //   107: putfield 71	com/tencent/mm/platformtools/ae:jPP	I
    //   110: aload_0
    //   111: aload 8
    //   113: putfield 73	com/tencent/mm/platformtools/ae:title	Ljava/lang/String;
    //   116: aload_0
    //   117: aload_3
    //   118: putfield 75	com/tencent/mm/platformtools/ae:url	Ljava/lang/String;
    //   121: ldc 22
    //   123: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: aload 9
    //   129: ldc 77
    //   131: invokeinterface 83 2 0
    //   136: checkcast 85	java/lang/String
    //   139: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   142: invokevirtual 95	java/lang/Integer:intValue	()I
    //   145: istore 6
    //   147: aload 9
    //   149: ldc 97
    //   151: invokeinterface 83 2 0
    //   156: checkcast 85	java/lang/String
    //   159: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   162: invokevirtual 95	java/lang/Integer:intValue	()I
    //   165: istore 5
    //   167: aload 9
    //   169: ldc 99
    //   171: invokeinterface 83 2 0
    //   176: checkcast 85	java/lang/String
    //   179: invokestatic 91	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   182: invokevirtual 95	java/lang/Integer:intValue	()I
    //   185: istore 7
    //   187: iload 7
    //   189: istore 4
    //   191: aload 9
    //   193: ldc 101
    //   195: invokeinterface 83 2 0
    //   200: checkcast 85	java/lang/String
    //   203: astore 8
    //   205: aload 9
    //   207: ldc 103
    //   209: invokeinterface 83 2 0
    //   214: checkcast 85	java/lang/String
    //   217: astore_3
    //   218: aload 9
    //   220: ldc 105
    //   222: invokeinterface 83 2 0
    //   227: checkcast 85	java/lang/String
    //   230: astore 9
    //   232: goto -156 -> 76
    //   235: astore 9
    //   237: ldc 30
    //   239: astore 8
    //   241: ldc 30
    //   243: astore_3
    //   244: iconst_0
    //   245: istore 5
    //   247: goto -185 -> 62
    //   250: astore 9
    //   252: ldc 30
    //   254: astore 8
    //   256: ldc 30
    //   258: astore_3
    //   259: goto -197 -> 62
    //   262: astore 9
    //   264: ldc 30
    //   266: astore 8
    //   268: ldc 30
    //   270: astore_3
    //   271: goto -209 -> 62
    //   274: astore 9
    //   276: ldc 30
    //   278: astore_3
    //   279: goto -217 -> 62
    //   282: astore 9
    //   284: goto -222 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	ae
    //   0	287	1	paramInt1	int
    //   0	287	2	paramInt2	int
    //   0	287	3	paramString	String
    //   14	176	4	i	int
    //   57	189	5	j	int
    //   60	86	6	k	int
    //   185	3	7	m	int
    //   51	216	8	str1	String
    //   23	3	9	localMap	java.util.Map
    //   47	18	9	localException1	java.lang.Exception
    //   74	157	9	str2	String
    //   235	1	9	localException2	java.lang.Exception
    //   250	1	9	localException3	java.lang.Exception
    //   262	1	9	localException4	java.lang.Exception
    //   274	1	9	localException5	java.lang.Exception
    //   282	1	9	localException6	java.lang.Exception
    //   11	62	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   16	25	47	java/lang/Exception
    //   30	47	47	java/lang/Exception
    //   127	147	47	java/lang/Exception
    //   147	167	235	java/lang/Exception
    //   167	187	250	java/lang/Exception
    //   191	205	262	java/lang/Exception
    //   205	218	274	java/lang/Exception
    //   218	232	282	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */