package com.tencent.mm.c;

import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c
{
  private static final k bvr = new k(84298576L);
  private static final k bvs = new k(50613072L);
  private static int bvt = 0;
  private static final k bvu = new k(101010256L);
  
  /* Error */
  public static void c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 39	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc 41
    //   10: invokespecial 43	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic 46	com/tencent/mm/c/c:c	(Ljava/io/RandomAccessFile;)[B
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +122 -> 142
    //   23: aload 4
    //   25: astore_0
    //   26: new 6	com/tencent/mm/c/c$a
    //   29: dup
    //   30: iconst_0
    //   31: invokespecial 49	com/tencent/mm/c/c$a:<init>	(B)V
    //   34: astore 4
    //   36: aload 4
    //   38: aload_0
    //   39: invokevirtual 53	com/tencent/mm/c/c$a:u	([B)V
    //   42: aload 4
    //   44: getfield 57	com/tencent/mm/c/c$a:bvv	Ljava/util/Properties;
    //   47: ldc 59
    //   49: aload_1
    //   50: invokevirtual 65	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   53: pop
    //   54: aload 4
    //   56: invokevirtual 69	com/tencent/mm/c/c$a:ss	()[B
    //   59: astore_0
    //   60: aload_3
    //   61: getstatic 30	com/tencent/mm/c/c:bvt	I
    //   64: i2l
    //   65: invokevirtual 72	java/io/RandomAccessFile:seek	(J)V
    //   68: aload_3
    //   69: new 74	com/tencent/mm/c/l
    //   72: dup
    //   73: aload_0
    //   74: arraylength
    //   75: invokespecial 77	com/tencent/mm/c/l:<init>	(I)V
    //   78: invokevirtual 80	com/tencent/mm/c/l:getBytes	()[B
    //   81: invokevirtual 83	java/io/RandomAccessFile:write	([B)V
    //   84: aload_3
    //   85: aload_0
    //   86: invokevirtual 83	java/io/RandomAccessFile:write	([B)V
    //   89: getstatic 30	com/tencent/mm/c/c:bvt	I
    //   92: istore_2
    //   93: aload_3
    //   94: aload_0
    //   95: arraylength
    //   96: iload_2
    //   97: iadd
    //   98: iconst_2
    //   99: iadd
    //   100: i2l
    //   101: invokevirtual 86	java/io/RandomAccessFile:setLength	(J)V
    //   104: getstatic 92	java/lang/System:err	Ljava/io/PrintStream;
    //   107: new 94	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 96
    //   113: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_3
    //   117: invokevirtual 103	java/io/RandomAccessFile:length	()J
    //   120: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 116	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: invokevirtual 119	java/io/RandomAccessFile:close	()V
    //   133: getstatic 92	java/lang/System:err	Ljava/io/PrintStream;
    //   136: ldc 121
    //   138: invokevirtual 116	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   141: return
    //   142: aload_0
    //   143: invokestatic 127	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   146: astore 4
    //   148: getstatic 24	com/tencent/mm/c/c:bvr	Lcom/tencent/mm/c/k;
    //   151: invokevirtual 128	com/tencent/mm/c/k:getBytes	()[B
    //   154: pop
    //   155: iconst_4
    //   156: newarray byte
    //   158: astore 5
    //   160: aload 4
    //   162: aload 5
    //   164: invokevirtual 131	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   167: pop
    //   168: getstatic 24	com/tencent/mm/c/c:bvr	Lcom/tencent/mm/c/k;
    //   171: new 16	com/tencent/mm/c/k
    //   174: dup
    //   175: aload 5
    //   177: invokespecial 133	com/tencent/mm/c/k:<init>	([B)V
    //   180: invokevirtual 137	com/tencent/mm/c/k:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +6 -> 189
    //   186: goto -160 -> 26
    //   189: getstatic 28	com/tencent/mm/c/c:bvs	Lcom/tencent/mm/c/k;
    //   192: new 16	com/tencent/mm/c/k
    //   195: dup
    //   196: aload 5
    //   198: invokespecial 133	com/tencent/mm/c/k:<init>	([B)V
    //   201: invokevirtual 137	com/tencent/mm/c/k:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +6 -> 210
    //   207: goto -181 -> 26
    //   210: new 139	java/io/ByteArrayOutputStream
    //   213: dup
    //   214: invokespecial 141	java/io/ByteArrayOutputStream:<init>	()V
    //   217: astore 4
    //   219: aload 4
    //   221: getstatic 28	com/tencent/mm/c/c:bvs	Lcom/tencent/mm/c/k;
    //   224: invokevirtual 128	com/tencent/mm/c/k:getBytes	()[B
    //   227: invokevirtual 142	java/io/ByteArrayOutputStream:write	([B)V
    //   230: aload 4
    //   232: new 74	com/tencent/mm/c/l
    //   235: dup
    //   236: aload_0
    //   237: arraylength
    //   238: invokespecial 77	com/tencent/mm/c/l:<init>	(I)V
    //   241: invokevirtual 80	com/tencent/mm/c/l:getBytes	()[B
    //   244: invokevirtual 142	java/io/ByteArrayOutputStream:write	([B)V
    //   247: aload 4
    //   249: aload_0
    //   250: invokevirtual 142	java/io/ByteArrayOutputStream:write	([B)V
    //   253: aload 4
    //   255: invokevirtual 145	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   258: astore_0
    //   259: goto -233 -> 26
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 119	java/io/RandomAccessFile:close	()V
    //   273: getstatic 92	java/lang/System:err	Ljava/io/PrintStream;
    //   276: ldc 121
    //   278: invokevirtual 116	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: athrow
    //   283: astore_0
    //   284: aload_3
    //   285: astore_1
    //   286: goto -21 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramFile	File
    //   0	289	1	paramString	String
    //   92	6	2	i	int
    //   13	272	3	localRandomAccessFile	RandomAccessFile
    //   1	253	4	localObject	Object
    //   158	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	14	262	finally
    //   14	19	283	finally
    //   26	129	283	finally
    //   142	186	283	finally
    //   189	207	283	finally
    //   210	259	283	finally
  }
  
  private static byte[] c(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = bvu.getBytes();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      if (i == -1) {
        i = 0;
      }
      do
      {
        if (i != 0) {
          break label118;
        }
        System.err.println("archive is not a ZIP archive");
        throw new ZipException("archive is not a ZIP archive");
        if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2])) {
          break;
        }
        i = j;
      } while (paramRandomAccessFile.read() == arrayOfByte[3]);
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    label118:
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (bvt != l + 16L + 4L) {
      bvt = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    System.err.println("readComment:length bytes data = " + t(arrayOfByte));
    i = new l(arrayOfByte).value;
    if (i == 0) {
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    return arrayOfByte;
  }
  
  public static String p(File paramFile)
  {
    System.err.println("enter getSecurityCode");
    System.err.println("apkFile filename:" + paramFile.getName());
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      c.a locala;
      if (localRandomAccessFile == null) {
        break label132;
      }
    }
    finally
    {
      try
      {
        paramFile = c(localRandomAccessFile);
        if (paramFile == null)
        {
          System.err.println("null == readComment");
          System.err.println("exit");
          localRandomAccessFile.close();
          System.err.println("exit getSecurityCode");
          return null;
        }
        locala = new c.a((byte)0);
        locala.u(paramFile);
        paramFile = locala.bvv.getProperty("apkSecurityCode");
        localRandomAccessFile.close();
        System.err.println("exit getSecurityCode");
        return paramFile;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        break label124;
      }
      paramFile = finally;
      localRandomAccessFile = null;
    }
    label124:
    localRandomAccessFile.close();
    label132:
    System.err.println("exit getSecurityCode");
    throw paramFile;
  }
  
  private static String t(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= 2) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramArrayOfByte[i]);
      localStringBuilder.append(",");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.c.c
 * JD-Core Version:    0.7.0.1
 */