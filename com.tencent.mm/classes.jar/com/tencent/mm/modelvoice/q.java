package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.Closeable;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class q
{
  public static int Qy(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(148450);
    switch (Rc(paramString))
    {
    default: 
      i = Rd(s.getFullPath(paramString));
      AppMethodBeat.o(148450);
      return i;
    case 0: 
      i = Rd(s.getFullPath(paramString));
      AppMethodBeat.o(148450);
      return i;
    case 1: 
      paramString = s.getFullPath(paramString);
      if (paramString.length() >= 0) {}
      for (;;)
      {
        Assert.assertTrue(bool1);
        paramString = new o(paramString);
        if (paramString.exists()) {
          break;
        }
        AppMethodBeat.o(148450);
        return 0;
        bool1 = false;
      }
      i = (int)paramString.length();
      if (i <= 0)
      {
        AppMethodBeat.o(148450);
        return 0;
      }
      AppMethodBeat.o(148450);
      return i;
    }
    paramString = s.getFullPath(paramString);
    if (paramString.length() >= 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramString = new o(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(148450);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(148450);
      return 0;
    }
    AppMethodBeat.o(148450);
    return i;
  }
  
  public static int Rc(String paramString)
  {
    AppMethodBeat.i(148446);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148446);
      return -1;
    }
    Log.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(paramString)));
    if (h(paramString, 0, false))
    {
      AppMethodBeat.o(148446);
      return 0;
    }
    if (i(paramString, 0, false))
    {
      AppMethodBeat.o(148446);
      return 2;
    }
    AppMethodBeat.o(148446);
    return 1;
  }
  
  private static int Rd(String paramString)
  {
    AppMethodBeat.i(148451);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new o(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(148451);
      return 0;
    }
    int i = (int)paramString.length() - 6;
    if (i <= 0)
    {
      AppMethodBeat.o(148451);
      return 0;
    }
    AppMethodBeat.o(148451);
    return i;
  }
  
  public static int g(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(148447);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148447);
      return -1;
    }
    Log.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(paramString)));
    if (h(paramString, paramInt, paramBoolean))
    {
      AppMethodBeat.o(148447);
      return 0;
    }
    if (i(paramString, paramInt, paramBoolean))
    {
      AppMethodBeat.o(148447);
      return 2;
    }
    AppMethodBeat.o(148447);
    return 1;
  }
  
  /* Error */
  private static boolean h(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_2
    //   6: ifeq +66 -> 72
    //   9: ldc 63
    //   11: ldc 93
    //   13: aload_0
    //   14: invokestatic 69	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: iconst_0
    //   25: invokestatic 99	com/tencent/mm/vfs/s:dB	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   28: astore_3
    //   29: aload_3
    //   30: astore_0
    //   31: bipush 6
    //   33: newarray byte
    //   35: astore 4
    //   37: aload_3
    //   38: astore_0
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: bipush 6
    //   45: invokevirtual 105	java/io/RandomAccessFile:read	([BII)I
    //   48: iconst_m1
    //   49: if_icmpne +35 -> 84
    //   52: aload_3
    //   53: astore_0
    //   54: ldc 63
    //   56: ldc 107
    //   58: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_3
    //   62: invokestatic 116	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   65: ldc 91
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: ireturn
    //   72: iload_1
    //   73: ifne +140 -> 213
    //   76: aload_0
    //   77: invokestatic 22	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_0
    //   81: goto -72 -> 9
    //   84: aload_3
    //   85: astore_0
    //   86: new 30	java/lang/String
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 119	java/lang/String:<init>	([B)V
    //   95: astore 5
    //   97: aload_3
    //   98: astore_0
    //   99: ldc 63
    //   101: ldc 121
    //   103: iconst_3
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 4
    //   111: invokestatic 125	com/tencent/mm/sdk/platformtools/Util:dumpHex	([B)Ljava/lang/String;
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload 5
    //   119: aastore
    //   120: dup
    //   121: iconst_2
    //   122: ldc 127
    //   124: aastore
    //   125: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: astore_0
    //   130: aload 5
    //   132: ldc 127
    //   134: invokevirtual 133	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   137: istore_2
    //   138: iload_2
    //   139: ifeq +14 -> 153
    //   142: aload_3
    //   143: invokestatic 116	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   146: ldc 91
    //   148: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: iconst_1
    //   152: ireturn
    //   153: aload_3
    //   154: invokestatic 116	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   157: ldc 91
    //   159: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore_0
    //   170: ldc 63
    //   172: aload 4
    //   174: ldc 135
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_3
    //   184: invokestatic 116	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   187: goto -30 -> 157
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_0
    //   193: aload_0
    //   194: invokestatic 116	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   197: ldc 91
    //   199: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_3
    //   203: athrow
    //   204: astore_3
    //   205: goto -12 -> 193
    //   208: astore 4
    //   210: goto -42 -> 168
    //   213: aconst_null
    //   214: astore_0
    //   215: goto -206 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   0	218	1	paramInt	int
    //   0	218	2	paramBoolean	boolean
    //   28	156	3	localRandomAccessFile	RandomAccessFile
    //   190	13	3	localObject1	Object
    //   204	1	3	localObject2	Object
    //   35	75	4	arrayOfByte	byte[]
    //   164	9	4	localException1	Exception
    //   208	1	4	localException2	Exception
    //   95	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	29	164	java/lang/Exception
    //   23	29	190	finally
    //   31	37	204	finally
    //   39	52	204	finally
    //   54	61	204	finally
    //   86	97	204	finally
    //   99	128	204	finally
    //   130	138	204	finally
    //   170	183	204	finally
    //   31	37	208	java/lang/Exception
    //   39	52	208	java/lang/Exception
    //   54	61	208	java/lang/Exception
    //   86	97	208	java/lang/Exception
    //   99	128	208	java/lang/Exception
    //   130	138	208	java/lang/Exception
  }
  
  public static boolean i(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    byte[] arrayOfByte = null;
    AppMethodBeat.i(148449);
    if (paramBoolean) {}
    for (Object localObject2 = paramString;; localObject2 = null)
    {
      for (;;)
      {
        Log.d("MicroMsg.VoiceFile", "isSilkHeader path ".concat(String.valueOf(localObject2)));
        paramString = arrayOfByte;
        try
        {
          localObject2 = com.tencent.mm.vfs.s.dB((String)localObject2, false);
          paramString = (String)localObject2;
          localObject1 = localObject2;
          arrayOfByte = new byte[9];
          paramString = (String)localObject2;
          localObject1 = localObject2;
          ((RandomAccessFile)localObject2).seek(1L);
          paramString = (String)localObject2;
          localObject1 = localObject2;
          paramInt = ((RandomAccessFile)localObject2).read(arrayOfByte, 0, 9);
          if (paramInt == -1)
          {
            aa.closeQuietly((Closeable)localObject2);
            AppMethodBeat.o(148449);
            return false;
            if (paramInt == 0)
            {
              localObject2 = s.getFullPath(paramString);
            }
            else
            {
              if (paramInt != 1) {
                break;
              }
              Log.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", new Object[] { paramString });
              AppMethodBeat.o(148449);
              return false;
            }
          }
          else
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            String str2 = new String(arrayOfByte);
            paramString = (String)localObject2;
            localObject1 = localObject2;
            Log.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", new Object[] { Util.dumpHex(arrayOfByte), str2, "#!SILK_V3" });
            paramString = (String)localObject2;
            localObject1 = localObject2;
            paramBoolean = str2.endsWith("#!SILK_V3");
            if (paramBoolean)
            {
              aa.closeQuietly((Closeable)localObject2);
              AppMethodBeat.o(148449);
              return true;
            }
            aa.closeQuietly((Closeable)localObject2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            str1 = paramString;
            Log.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
            aa.closeQuietly(paramString);
          }
        }
        finally
        {
          String str1;
          aa.closeQuietly(str1);
          AppMethodBeat.o(148449);
        }
      }
      AppMethodBeat.o(148449);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.q
 * JD-Core Version:    0.7.0.1
 */