package com.tencent.mm.modelvideo;

import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;

public final class x
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );" };
  e dXw;
  
  public x(h paramh)
  {
    this.dXw = paramh;
  }
  
  /* Error */
  public final boolean b(String paramString, com.tencent.mm.pointers.PInt paramPInt1, com.tencent.mm.pointers.PInt paramPInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 23	com/tencent/mm/modelvideo/x:dXw	Lcom/tencent/mm/sdk/e/e;
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 33	com/tencent/mm/sdk/platformtools/bk:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload 7
    //   16: ldc 35
    //   18: iconst_2
    //   19: anewarray 12	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 37
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 39
    //   31: aastore
    //   32: ldc 41
    //   34: iconst_1
    //   35: anewarray 12	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: ldc 43
    //   44: ldc 43
    //   46: ldc 43
    //   48: iconst_2
    //   49: invokeinterface 49 9 0
    //   54: astore_1
    //   55: aload_1
    //   56: astore 6
    //   58: aload 6
    //   60: ifnull +208 -> 268
    //   63: aload 6
    //   65: astore_1
    //   66: aload 6
    //   68: invokeinterface 55 1 0
    //   73: ifeq +195 -> 268
    //   76: aload 6
    //   78: astore_1
    //   79: aload_2
    //   80: aload 6
    //   82: aload 6
    //   84: ldc 37
    //   86: invokeinterface 59 2 0
    //   91: invokeinterface 63 2 0
    //   96: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 6
    //   101: astore_1
    //   102: aload_3
    //   103: aload 6
    //   105: aload 6
    //   107: ldc 39
    //   109: invokeinterface 59 2 0
    //   114: invokeinterface 63 2 0
    //   119: putfield 69	com/tencent/mm/pointers/PInt:value	I
    //   122: iconst_1
    //   123: istore 4
    //   125: iload 4
    //   127: istore 5
    //   129: aload 6
    //   131: ifnull +14 -> 145
    //   134: aload 6
    //   136: invokeinterface 72 1 0
    //   141: iload 4
    //   143: istore 5
    //   145: ldc 74
    //   147: new 76	java/lang/StringBuilder
    //   150: dup
    //   151: ldc 78
    //   153: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: iload 5
    //   158: invokevirtual 85	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: ldc 87
    //   163: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_2
    //   167: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   170: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 95
    //   175: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: getfield 69	com/tencent/mm/pointers/PInt:value	I
    //   182: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 105	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iload 5
    //   193: ireturn
    //   194: astore 7
    //   196: aconst_null
    //   197: astore 6
    //   199: aload 6
    //   201: astore_1
    //   202: ldc 74
    //   204: aload 7
    //   206: ldc 43
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 109	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload 6
    //   217: ifnull +45 -> 262
    //   220: aload 6
    //   222: invokeinterface 72 1 0
    //   227: iconst_0
    //   228: istore 5
    //   230: goto -85 -> 145
    //   233: astore_1
    //   234: aload 6
    //   236: astore_2
    //   237: aload_2
    //   238: ifnull +9 -> 247
    //   241: aload_2
    //   242: invokeinterface 72 1 0
    //   247: aload_1
    //   248: athrow
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: goto -17 -> 237
    //   257: astore 7
    //   259: goto -60 -> 199
    //   262: iconst_0
    //   263: istore 5
    //   265: goto -120 -> 145
    //   268: iconst_0
    //   269: istore 4
    //   271: goto -146 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	x
    //   0	274	1	paramString	String
    //   0	274	2	paramPInt1	com.tencent.mm.pointers.PInt
    //   0	274	3	paramPInt2	com.tencent.mm.pointers.PInt
    //   123	147	4	bool1	boolean
    //   127	137	5	bool2	boolean
    //   1	234	6	str	String
    //   7	8	7	locale	e
    //   194	11	7	localException1	java.lang.Exception
    //   257	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	55	194	java/lang/Exception
    //   3	55	233	finally
    //   66	76	249	finally
    //   79	99	249	finally
    //   102	122	249	finally
    //   202	215	249	finally
    //   66	76	257	java/lang/Exception
    //   79	99	257	java/lang/Exception
    //   102	122	257	java/lang/Exception
  }
  
  /* Error */
  public final boolean ok(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 114	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 23	com/tencent/mm/modelvideo/x:dXw	Lcom/tencent/mm/sdk/e/e;
    //   15: astore 4
    //   17: aload_1
    //   18: invokestatic 33	com/tencent/mm/sdk/platformtools/bk:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload 4
    //   24: ldc 35
    //   26: iconst_1
    //   27: anewarray 12	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 116
    //   34: aastore
    //   35: ldc 41
    //   37: iconst_1
    //   38: anewarray 12	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: ldc 43
    //   47: ldc 43
    //   49: ldc 43
    //   51: invokeinterface 120 8 0
    //   56: astore_1
    //   57: aload_1
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +28 -> 88
    //   63: aload_3
    //   64: astore_1
    //   65: aload_3
    //   66: invokeinterface 55 1 0
    //   71: istore_2
    //   72: iload_2
    //   73: ifeq +15 -> 88
    //   76: aload_3
    //   77: ifnull +9 -> 86
    //   80: aload_3
    //   81: invokeinterface 72 1 0
    //   86: iconst_1
    //   87: ireturn
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 72 1 0
    //   98: iconst_0
    //   99: ireturn
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: astore_1
    //   106: ldc 74
    //   108: aload 4
    //   110: ldc 43
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 109	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_3
    //   120: ifnull -22 -> 98
    //   123: aload_3
    //   124: invokeinterface 72 1 0
    //   129: goto -31 -> 98
    //   132: astore_1
    //   133: aload_3
    //   134: ifnull +9 -> 143
    //   137: aload_3
    //   138: invokeinterface 72 1 0
    //   143: aload_1
    //   144: athrow
    //   145: astore 4
    //   147: aload_1
    //   148: astore_3
    //   149: aload 4
    //   151: astore_1
    //   152: goto -19 -> 133
    //   155: astore 4
    //   157: goto -53 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	x
    //   0	160	1	paramString	String
    //   71	2	2	bool	boolean
    //   10	139	3	str	String
    //   15	8	4	locale	e
    //   100	9	4	localException1	java.lang.Exception
    //   145	5	4	localObject	Object
    //   155	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	57	100	java/lang/Exception
    //   11	57	132	finally
    //   65	72	145	finally
    //   106	119	145	finally
    //   65	72	155	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.x
 * JD-Core Version:    0.7.0.1
 */