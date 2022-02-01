package com.tencent.mqp.app.dbfs;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

public class DBSecurity
{
  public static final int a = 8;
  private static final String jdField_a_of_type_JavaLangString = "PBE_PWD";
  public static final int b = 100;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public DBSecurity(Context paramContext)
  {
    a(paramContext);
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 10
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 28	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +60 -> 69
    //   12: aload_0
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 31	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   18: ldc 10
    //   20: invokevirtual 37	java/lang/String:getBytes	()[B
    //   23: invokestatic 40	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   26: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   29: aload_0
    //   30: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   33: ifnull +13 -> 46
    //   36: aload_0
    //   37: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   40: arraylength
    //   41: bipush 8
    //   43: if_icmpge +26 -> 69
    //   46: ldc2_w 43
    //   49: invokestatic 50	java/lang/Thread:sleep	(J)V
    //   52: aload_0
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial 31	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   58: ldc 10
    //   60: invokevirtual 37	java/lang/String:getBytes	()[B
    //   63: invokestatic 40	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   66: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   69: aload_0
    //   70: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   73: ifnull +15 -> 88
    //   76: aload_0
    //   77: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   80: arraylength
    //   81: istore_2
    //   82: iload_2
    //   83: bipush 8
    //   85: if_icmpge +83 -> 168
    //   88: aconst_null
    //   89: astore 4
    //   91: ldc 52
    //   93: invokestatic 57	com/tencent/util/QQDeviceInfo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 6
    //   98: aload 6
    //   100: ifnull +21 -> 121
    //   103: aload 6
    //   105: astore 4
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: invokevirtual 61	java/lang/String:length	()I
    //   116: bipush 8
    //   118: if_icmpge +120 -> 238
    //   121: aload 6
    //   123: astore 4
    //   125: aload_1
    //   126: ldc 63
    //   128: invokevirtual 69	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   131: checkcast 71	android/net/wifi/WifiManager
    //   134: invokevirtual 75	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   137: invokevirtual 81	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   140: astore 5
    //   142: aload 5
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +13 -> 161
    //   151: aload 4
    //   153: invokevirtual 61	java/lang/String:length	()I
    //   156: bipush 8
    //   158: if_icmpge +60 -> 218
    //   161: aload_0
    //   162: invokestatic 83	com/tencent/mqp/app/dbfs/DBSecurity:a	()[B
    //   165: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   168: aload_1
    //   169: aload_0
    //   170: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   173: ldc 10
    //   175: invokevirtual 37	java/lang/String:getBytes	()[B
    //   178: invokestatic 85	com/tencent/mqp/app/dbfs/DBSecurity:a	([B[B)[B
    //   181: invokestatic 88	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;[B)V
    //   184: ldc 10
    //   186: monitorexit
    //   187: return
    //   188: astore 4
    //   190: aload 4
    //   192: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   195: goto -126 -> 69
    //   198: astore_1
    //   199: ldc 10
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore 5
    //   206: aload 5
    //   208: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   211: aload 4
    //   213: astore 5
    //   215: goto +23 -> 238
    //   218: aload_0
    //   219: aload 4
    //   221: invokevirtual 37	java/lang/String:getBytes	()[B
    //   224: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   227: goto -59 -> 168
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   235: goto -51 -> 184
    //   238: aload 5
    //   240: astore 4
    //   242: goto -96 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	DBSecurity
    //   0	245	1	paramContext	Context
    //   81	5	2	i	int
    //   7	2	3	bool	boolean
    //   89	63	4	localObject1	Object
    //   188	32	4	localException1	Exception
    //   240	1	4	localObject2	Object
    //   109	34	5	str1	String
    //   204	3	5	localException2	Exception
    //   213	26	5	localException3	Exception
    //   96	26	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   12	46	188	java/lang/Exception
    //   46	69	188	java/lang/Exception
    //   3	8	198	finally
    //   12	46	198	finally
    //   46	69	198	finally
    //   69	82	198	finally
    //   91	98	198	finally
    //   111	121	198	finally
    //   125	142	198	finally
    //   151	161	198	finally
    //   161	168	198	finally
    //   168	184	198	finally
    //   184	187	198	finally
    //   190	195	198	finally
    //   199	202	198	finally
    //   206	211	198	finally
    //   218	227	198	finally
    //   231	235	198	finally
    //   91	98	204	java/lang/Exception
    //   111	121	204	java/lang/Exception
    //   125	142	204	java/lang/Exception
    //   168	184	230	java/io/IOException
  }
  
  private static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    paramContext = paramContext.openFileOutput("PBE_PWD", 0);
    paramContext.write(paramArrayOfByte);
    paramContext.close();
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("PBE_PWD") != null) && (paramContext.getFileStreamPath("PBE_PWD").exists());
  }
  
  private static byte[] a()
  {
    return new SecureRandom().generateSeed(8);
  }
  
  private byte[] a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("PBE_PWD");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(a(a(paramArrayOfByte1, true), a(paramArrayOfByte2, false)), false);
  }
  
  private static byte[] a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt.length << 2;
    int i;
    if (paramBoolean)
    {
      int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
      i = k;
      if (k > j) {
        return null;
      }
    }
    else
    {
      i = j;
    }
    byte[] arrayOfByte = new byte[i];
    j = 0;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramArrayOfInt[(j >>> 2)] >>> ((j & 0x3) << 3) & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int[] arrayOfInt;
    if ((paramArrayOfByte.length & 0x3) == 0)
    {
      i = paramArrayOfByte.length >>> 2;
      if (!paramBoolean) {
        break label85;
      }
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    for (;;)
    {
      int j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        int k = i >>> 2;
        arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
        i += 1;
      }
      i = (paramArrayOfByte.length >>> 2) + 1;
      break;
      label85:
      arrayOfInt = new int[i];
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[i1];
      int j = paramArrayOfInt1[0];
      j = 52 / (i1 + 1);
      int k = 0;
      j += 6;
      while (j > 0)
      {
        int m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = paramArrayOfInt1[(i + 1)];
          i3 = paramArrayOfInt1[i];
          k = ((k ^ arrayOfInt[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          paramArrayOfInt1[i] = k;
          i += 1;
        }
        n = paramArrayOfInt1[0];
        int i3 = paramArrayOfInt1[i1];
        i = ((arrayOfInt[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfInt1[i1] = i;
        j -= 1;
        k = m;
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(b(a(paramArrayOfByte1, false), a(paramArrayOfByte2, false)), true);
  }
  
  private static final int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramArrayOfInt1.length - 1;
    if (m < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[m];
      i = paramArrayOfInt1[0];
      int j = (52 / (m + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int n = j >>> 2 & 0x3;
        int k = i;
        i = m;
        while (i > 0)
        {
          i1 = paramArrayOfInt1[(i - 1)];
          k = paramArrayOfInt1[i] - ((k ^ j) + (i1 ^ arrayOfInt[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          paramArrayOfInt1[i] = k;
          i -= 1;
        }
        int i1 = paramArrayOfInt1[m];
        i = paramArrayOfInt1[0] - ((arrayOfInt[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        paramArrayOfInt1[0] = i;
        j += 1640531527;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a();
    if (this.a != null) {
      try
      {
        byte[] arrayOfByte2 = a(paramArrayOfByte, a(this.a, arrayOfByte1));
        byte[] arrayOfByte4 = new byte[arrayOfByte2.length + 8];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, arrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte4, arrayOfByte2.length, 8);
        return arrayOfByte4;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    byte[] arrayOfByte3 = new byte[paramArrayOfByte.length + 8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, paramArrayOfByte.length, 8);
    return arrayOfByte3;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[8];
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 8, arrayOfByte1, 0, 8);
    try
    {
      if (this.a != null)
      {
        byte[] arrayOfByte3 = new byte[paramArrayOfByte.length - 8];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length - 8);
        arrayOfByte1 = b(arrayOfByte3, a(this.a, arrayOfByte1));
        return arrayOfByte1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - 8];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length - 8);
      return arrayOfByte2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBSecurity
 * JD-Core Version:    0.7.0.1
 */