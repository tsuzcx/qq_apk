package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storagebase.h;

public final class x
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );" };
  e db;
  
  public x(h paramh)
  {
    this.db = paramh;
  }
  
  /* Error */
  public final boolean Ii(String paramString)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 39	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 28
    //   14: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 23	com/tencent/mm/modelvideo/x:db	Lcom/tencent/mm/sdk/e/e;
    //   25: astore 4
    //   27: aload_1
    //   28: invokestatic 46	com/tencent/mm/sdk/platformtools/bu:aSk	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_1
    //   32: aload 4
    //   34: ldc 48
    //   36: iconst_1
    //   37: anewarray 12	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 50
    //   44: aastore
    //   45: ldc 52
    //   47: iconst_1
    //   48: anewarray 12	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: ldc 54
    //   57: ldc 54
    //   59: ldc 54
    //   61: invokeinterface 60 8 0
    //   66: astore_1
    //   67: aload_1
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +33 -> 103
    //   73: aload_3
    //   74: astore_1
    //   75: aload_3
    //   76: invokeinterface 66 1 0
    //   81: istore_2
    //   82: iload_2
    //   83: ifeq +20 -> 103
    //   86: aload_3
    //   87: ifnull +9 -> 96
    //   90: aload_3
    //   91: invokeinterface 69 1 0
    //   96: ldc 28
    //   98: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_3
    //   104: ifnull +9 -> 113
    //   107: aload_3
    //   108: invokeinterface 69 1 0
    //   113: ldc 28
    //   115: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_3
    //   124: aload_3
    //   125: astore_1
    //   126: ldc 71
    //   128: aload 4
    //   130: ldc 54
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 77	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_3
    //   140: ifnull -27 -> 113
    //   143: aload_3
    //   144: invokeinterface 69 1 0
    //   149: goto -36 -> 113
    //   152: astore_1
    //   153: aload_3
    //   154: ifnull +9 -> 163
    //   157: aload_3
    //   158: invokeinterface 69 1 0
    //   163: ldc 28
    //   165: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: astore 4
    //   172: aload_1
    //   173: astore_3
    //   174: aload 4
    //   176: astore_1
    //   177: goto -24 -> 153
    //   180: astore 4
    //   182: goto -58 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	x
    //   0	185	1	paramString	String
    //   81	2	2	bool	boolean
    //   20	154	3	str	String
    //   25	8	4	locale	e
    //   120	9	4	localException1	java.lang.Exception
    //   170	5	4	localObject	Object
    //   180	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	67	120	java/lang/Exception
    //   21	67	152	finally
    //   75	82	170	finally
    //   126	139	170	finally
    //   75	82	180	java/lang/Exception
  }
  
  /* Error */
  public final boolean b(String paramString, com.tencent.mm.pointers.PInt paramPInt1, com.tencent.mm.pointers.PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_0
    //   9: getfield 23	com/tencent/mm/modelvideo/x:db	Lcom/tencent/mm/sdk/e/e;
    //   12: astore 7
    //   14: aload_1
    //   15: invokestatic 46	com/tencent/mm/sdk/platformtools/bu:aSk	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload 7
    //   21: ldc 48
    //   23: iconst_2
    //   24: anewarray 12	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc 82
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: ldc 84
    //   36: aastore
    //   37: ldc 52
    //   39: iconst_1
    //   40: anewarray 12	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: ldc 54
    //   49: ldc 54
    //   51: ldc 54
    //   53: iconst_2
    //   54: invokeinterface 88 9 0
    //   59: astore_1
    //   60: aload_1
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +218 -> 283
    //   68: aload 6
    //   70: astore_1
    //   71: aload 6
    //   73: invokeinterface 66 1 0
    //   78: ifeq +205 -> 283
    //   81: aload 6
    //   83: astore_1
    //   84: aload_2
    //   85: aload 6
    //   87: aload 6
    //   89: ldc 82
    //   91: invokeinterface 92 2 0
    //   96: invokeinterface 96 2 0
    //   101: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   104: aload 6
    //   106: astore_1
    //   107: aload_3
    //   108: aload 6
    //   110: aload 6
    //   112: ldc 84
    //   114: invokeinterface 92 2 0
    //   119: invokeinterface 96 2 0
    //   124: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   127: iconst_1
    //   128: istore 4
    //   130: iload 4
    //   132: istore 5
    //   134: aload 6
    //   136: ifnull +14 -> 150
    //   139: aload 6
    //   141: invokeinterface 69 1 0
    //   146: iload 4
    //   148: istore 5
    //   150: ldc 71
    //   152: new 104	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 106
    //   158: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: iload 5
    //   163: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   166: ldc 115
    //   168: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: getfield 102	com/tencent/mm/pointers/PInt:value	I
    //   175: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 123
    //   180: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_3
    //   184: getfield 102	com/tencent/mm/pointers/PInt:value	I
    //   187: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 130	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc 80
    //   198: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iload 5
    //   203: ireturn
    //   204: astore 7
    //   206: aconst_null
    //   207: astore 6
    //   209: aload 6
    //   211: astore_1
    //   212: ldc 71
    //   214: aload 7
    //   216: ldc 54
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 77	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 6
    //   227: ifnull +50 -> 277
    //   230: aload 6
    //   232: invokeinterface 69 1 0
    //   237: iconst_0
    //   238: istore 5
    //   240: goto -90 -> 150
    //   243: astore_1
    //   244: aload 6
    //   246: astore_2
    //   247: aload_2
    //   248: ifnull +9 -> 257
    //   251: aload_2
    //   252: invokeinterface 69 1 0
    //   257: ldc 80
    //   259: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: aload_1
    //   263: athrow
    //   264: astore_3
    //   265: aload_1
    //   266: astore_2
    //   267: aload_3
    //   268: astore_1
    //   269: goto -22 -> 247
    //   272: astore 7
    //   274: goto -65 -> 209
    //   277: iconst_0
    //   278: istore 5
    //   280: goto -130 -> 150
    //   283: iconst_0
    //   284: istore 4
    //   286: goto -156 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	x
    //   0	289	1	paramString	String
    //   0	289	2	paramPInt1	com.tencent.mm.pointers.PInt
    //   0	289	3	paramPInt2	com.tencent.mm.pointers.PInt
    //   128	157	4	bool1	boolean
    //   132	147	5	bool2	boolean
    //   6	239	6	str	String
    //   12	8	7	locale	e
    //   204	11	7	localException1	java.lang.Exception
    //   272	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   8	60	204	java/lang/Exception
    //   8	60	243	finally
    //   71	81	264	finally
    //   84	104	264	finally
    //   107	127	264	finally
    //   212	225	264	finally
    //   71	81	272	java/lang/Exception
    //   84	104	272	java/lang/Exception
    //   107	127	272	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.x
 * JD-Core Version:    0.7.0.1
 */