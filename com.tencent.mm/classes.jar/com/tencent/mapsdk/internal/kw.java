package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class kw
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final kp<String, String> b;
  private final kt.g<kt.i<MessageDigest>> c;
  
  public kw()
  {
    AppMethodBeat.i(222257);
    this.b = new kp(1000);
    this.c = kt.a(10, new kt.e()
    {
      private static kt.i<MessageDigest> b()
      {
        AppMethodBeat.i(223096);
        try
        {
          kt.i locali = new kt.i(MessageDigest.getInstance("SHA-256"));
          AppMethodBeat.o(223096);
          return locali;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          RuntimeException localRuntimeException = new RuntimeException(localNoSuchAlgorithmException);
          AppMethodBeat.o(223096);
          throw localRuntimeException;
        }
      }
    });
    AppMethodBeat.o(222257);
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222267);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
        j = (byte)(j >>> 4);
        arrayOfChar[(i * 2 + 0)] = a[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      AppMethodBeat.o(222267);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(222267);
    return null;
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 51	com/tencent/mapsdk/internal/kw:b	Lcom/tencent/mapsdk/internal/kp;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 51	com/tencent/mapsdk/internal/kw:b	Lcom/tencent/mapsdk/internal/kp;
    //   18: aload_1
    //   19: invokevirtual 76	com/tencent/mapsdk/internal/kp:b	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 68	java/lang/String
    //   25: astore 4
    //   27: aload 5
    //   29: monitorexit
    //   30: aload 4
    //   32: ifnonnull +225 -> 257
    //   35: aload_0
    //   36: getfield 61	com/tencent/mapsdk/internal/kw:c	Lcom/tencent/mapsdk/internal/kt$g;
    //   39: invokeinterface 81 1 0
    //   44: checkcast 83	com/tencent/mapsdk/internal/kt$i
    //   47: astore 5
    //   49: aload 5
    //   51: getfield 86	com/tencent/mapsdk/internal/kt$i:a	Ljava/lang/Object;
    //   54: checkcast 88	java/security/MessageDigest
    //   57: aload_1
    //   58: invokevirtual 92	java/lang/String:getBytes	()[B
    //   61: invokevirtual 96	java/security/MessageDigest:update	([B)V
    //   64: aload 5
    //   66: getfield 86	com/tencent/mapsdk/internal/kt$i:a	Ljava/lang/Object;
    //   69: checkcast 88	java/security/MessageDigest
    //   72: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +141 -> 220
    //   82: aload 4
    //   84: arraylength
    //   85: ifeq +135 -> 220
    //   88: aload 4
    //   90: arraylength
    //   91: iconst_2
    //   92: imul
    //   93: newarray char
    //   95: astore 6
    //   97: iconst_0
    //   98: istore_2
    //   99: iload_2
    //   100: aload 4
    //   102: arraylength
    //   103: if_icmpge +63 -> 166
    //   106: aload 4
    //   108: iload_2
    //   109: baload
    //   110: istore_3
    //   111: aload 6
    //   113: iload_2
    //   114: iconst_2
    //   115: imul
    //   116: iconst_1
    //   117: iadd
    //   118: getstatic 34	com/tencent/mapsdk/internal/kw:a	[C
    //   121: iload_3
    //   122: bipush 15
    //   124: iand
    //   125: caload
    //   126: castore
    //   127: iload_3
    //   128: iconst_4
    //   129: iushr
    //   130: i2b
    //   131: istore_3
    //   132: aload 6
    //   134: iload_2
    //   135: iconst_2
    //   136: imul
    //   137: iconst_0
    //   138: iadd
    //   139: getstatic 34	com/tencent/mapsdk/internal/kw:a	[C
    //   142: iload_3
    //   143: bipush 15
    //   145: iand
    //   146: caload
    //   147: castore
    //   148: iload_2
    //   149: iconst_1
    //   150: iadd
    //   151: istore_2
    //   152: goto -53 -> 99
    //   155: astore_1
    //   156: aload 5
    //   158: monitorexit
    //   159: ldc 73
    //   161: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: athrow
    //   166: new 68	java/lang/String
    //   169: dup
    //   170: aload 6
    //   172: invokespecial 71	java/lang/String:<init>	([C)V
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 61	com/tencent/mapsdk/internal/kw:c	Lcom/tencent/mapsdk/internal/kt$g;
    //   181: aload 5
    //   183: invokeinterface 102 2 0
    //   188: pop
    //   189: aload_0
    //   190: getfield 51	com/tencent/mapsdk/internal/kw:b	Lcom/tencent/mapsdk/internal/kp;
    //   193: astore 5
    //   195: aload 5
    //   197: monitorenter
    //   198: aload_0
    //   199: getfield 51	com/tencent/mapsdk/internal/kw:b	Lcom/tencent/mapsdk/internal/kp;
    //   202: aload_1
    //   203: aload 4
    //   205: invokevirtual 105	com/tencent/mapsdk/internal/kp:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: pop
    //   209: aload 5
    //   211: monitorexit
    //   212: ldc 73
    //   214: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload 4
    //   219: areturn
    //   220: aconst_null
    //   221: astore 4
    //   223: goto -46 -> 177
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 61	com/tencent/mapsdk/internal/kw:c	Lcom/tencent/mapsdk/internal/kt$g;
    //   231: aload 5
    //   233: invokeinterface 102 2 0
    //   238: pop
    //   239: ldc 73
    //   241: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_1
    //   245: athrow
    //   246: astore_1
    //   247: aload 5
    //   249: monitorexit
    //   250: ldc 73
    //   252: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_1
    //   256: athrow
    //   257: goto -68 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	kw
    //   0	260	1	paramString	String
    //   98	54	2	i	int
    //   110	36	3	j	int
    //   25	197	4	localObject1	Object
    //   95	76	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   14	30	155	finally
    //   49	77	226	finally
    //   82	97	226	finally
    //   99	106	226	finally
    //   111	127	226	finally
    //   132	148	226	finally
    //   166	177	226	finally
    //   198	212	246	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kw
 * JD-Core Version:    0.7.0.1
 */