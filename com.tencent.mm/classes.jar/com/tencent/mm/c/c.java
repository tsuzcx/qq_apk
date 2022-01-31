package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c
{
  private static final k bWC;
  private static final k bWD;
  private static int bWE;
  private static final k bWF;
  
  static
  {
    AppMethodBeat.i(125713);
    bWC = new k(84298576L);
    bWD = new k(50613072L);
    bWE = 0;
    bWF = new k(101010256L);
    AppMethodBeat.o(125713);
  }
  
  private static String C(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125717);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= 2)
      {
        paramArrayOfByte = localStringBuilder.toString();
        AppMethodBeat.o(125717);
        return paramArrayOfByte;
      }
      localStringBuilder.append(paramArrayOfByte[i]);
      localStringBuilder.append(",");
      i += 1;
    }
  }
  
  /* Error */
  public static void c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 71
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 73	java/io/RandomAccessFile
    //   11: dup
    //   12: aload_0
    //   13: ldc 75
    //   15: invokespecial 77	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokestatic 80	com/tencent/mm/c/c:c	(Ljava/io/RandomAccessFile;)[B
    //   23: astore_0
    //   24: aload_0
    //   25: ifnonnull +127 -> 152
    //   28: aload 4
    //   30: astore_0
    //   31: new 6	com/tencent/mm/c/c$a
    //   34: dup
    //   35: iconst_0
    //   36: invokespecial 83	com/tencent/mm/c/c$a:<init>	(B)V
    //   39: astore 4
    //   41: aload 4
    //   43: aload_0
    //   44: invokevirtual 87	com/tencent/mm/c/c$a:D	([B)V
    //   47: aload 4
    //   49: getfield 91	com/tencent/mm/c/c$a:bWG	Ljava/util/Properties;
    //   52: ldc 93
    //   54: aload_1
    //   55: invokevirtual 99	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   58: pop
    //   59: aload 4
    //   61: invokevirtual 103	com/tencent/mm/c/c$a:AJ	()[B
    //   64: astore_0
    //   65: aload_3
    //   66: getstatic 37	com/tencent/mm/c/c:bWE	I
    //   69: i2l
    //   70: invokevirtual 106	java/io/RandomAccessFile:seek	(J)V
    //   73: aload_3
    //   74: new 108	com/tencent/mm/c/l
    //   77: dup
    //   78: aload_0
    //   79: arraylength
    //   80: invokespecial 110	com/tencent/mm/c/l:<init>	(I)V
    //   83: invokevirtual 113	com/tencent/mm/c/l:getBytes	()[B
    //   86: invokevirtual 116	java/io/RandomAccessFile:write	([B)V
    //   89: aload_3
    //   90: aload_0
    //   91: invokevirtual 116	java/io/RandomAccessFile:write	([B)V
    //   94: getstatic 37	com/tencent/mm/c/c:bWE	I
    //   97: istore_2
    //   98: aload_3
    //   99: aload_0
    //   100: arraylength
    //   101: iload_2
    //   102: iadd
    //   103: iconst_2
    //   104: iadd
    //   105: i2l
    //   106: invokevirtual 119	java/io/RandomAccessFile:setLength	(J)V
    //   109: getstatic 125	java/lang/System:err	Ljava/io/PrintStream;
    //   112: new 53	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 127
    //   118: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: invokevirtual 134	java/io/RandomAccessFile:length	()J
    //   125: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   128: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 142	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   134: aload_3
    //   135: invokevirtual 145	java/io/RandomAccessFile:close	()V
    //   138: getstatic 125	java/lang/System:err	Ljava/io/PrintStream;
    //   141: ldc 147
    //   143: invokevirtual 142	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   146: ldc 71
    //   148: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: aload_0
    //   153: invokestatic 153	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   156: astore 4
    //   158: iconst_4
    //   159: newarray byte
    //   161: astore 5
    //   163: aload 4
    //   165: aload 5
    //   167: invokevirtual 156	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   170: pop
    //   171: getstatic 31	com/tencent/mm/c/c:bWC	Lcom/tencent/mm/c/k;
    //   174: new 23	com/tencent/mm/c/k
    //   177: dup
    //   178: aload 5
    //   180: invokespecial 158	com/tencent/mm/c/k:<init>	([B)V
    //   183: invokevirtual 162	com/tencent/mm/c/k:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -158 -> 31
    //   192: getstatic 35	com/tencent/mm/c/c:bWD	Lcom/tencent/mm/c/k;
    //   195: new 23	com/tencent/mm/c/k
    //   198: dup
    //   199: aload 5
    //   201: invokespecial 158	com/tencent/mm/c/k:<init>	([B)V
    //   204: invokevirtual 162	com/tencent/mm/c/k:equals	(Ljava/lang/Object;)Z
    //   207: ifeq +6 -> 213
    //   210: goto -179 -> 31
    //   213: new 164	java/io/ByteArrayOutputStream
    //   216: dup
    //   217: invokespecial 165	java/io/ByteArrayOutputStream:<init>	()V
    //   220: astore 4
    //   222: aload 4
    //   224: getstatic 35	com/tencent/mm/c/c:bWD	Lcom/tencent/mm/c/k;
    //   227: invokevirtual 166	com/tencent/mm/c/k:getBytes	()[B
    //   230: invokevirtual 167	java/io/ByteArrayOutputStream:write	([B)V
    //   233: aload 4
    //   235: new 108	com/tencent/mm/c/l
    //   238: dup
    //   239: aload_0
    //   240: arraylength
    //   241: invokespecial 110	com/tencent/mm/c/l:<init>	(I)V
    //   244: invokevirtual 113	com/tencent/mm/c/l:getBytes	()[B
    //   247: invokevirtual 167	java/io/ByteArrayOutputStream:write	([B)V
    //   250: aload 4
    //   252: aload_0
    //   253: invokevirtual 167	java/io/ByteArrayOutputStream:write	([B)V
    //   256: aload 4
    //   258: invokevirtual 170	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   261: astore_0
    //   262: goto -231 -> 31
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_1
    //   269: ifnull +7 -> 276
    //   272: aload_1
    //   273: invokevirtual 145	java/io/RandomAccessFile:close	()V
    //   276: getstatic 125	java/lang/System:err	Ljava/io/PrintStream;
    //   279: ldc 147
    //   281: invokevirtual 142	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   284: ldc 71
    //   286: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: astore_0
    //   292: aload_3
    //   293: astore_1
    //   294: goto -26 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramFile	File
    //   0	297	1	paramString	String
    //   97	6	2	i	int
    //   18	275	3	localRandomAccessFile	RandomAccessFile
    //   1	256	4	localObject	Object
    //   161	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	19	265	finally
    //   19	24	291	finally
    //   31	134	291	finally
    //   152	189	291	finally
    //   192	210	291	finally
    //   213	262	291	finally
  }
  
  private static byte[] c(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    AppMethodBeat.i(125714);
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = bWF.getBytes();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      if (i == -1) {
        i = 0;
      }
      do
      {
        if (i != 0) {
          break label130;
        }
        System.err.println("archive is not a ZIP archive");
        paramRandomAccessFile = new ZipException("archive is not a ZIP archive");
        AppMethodBeat.o(125714);
        throw paramRandomAccessFile;
        if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2])) {
          break;
        }
        i = j;
      } while (paramRandomAccessFile.read() == arrayOfByte[3]);
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    label130:
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (bWE != l + 16L + 4L) {
      bWE = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    System.err.println("readComment:length bytes data = " + C(arrayOfByte));
    i = new l(arrayOfByte).value;
    if (i == 0)
    {
      AppMethodBeat.o(125714);
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    AppMethodBeat.o(125714);
    return arrayOfByte;
  }
  
  public static String u(File paramFile)
  {
    AppMethodBeat.i(125716);
    System.err.println("enter getSecurityCode");
    System.err.println("apkFile filename:" + paramFile.getName());
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      c.a locala;
      if (localRandomAccessFile == null) {
        break label147;
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
          AppMethodBeat.o(125716);
          return null;
        }
        locala = new c.a((byte)0);
        locala.D(paramFile);
        paramFile = locala.bWG.getProperty("apkSecurityCode");
        localRandomAccessFile.close();
        System.err.println("exit getSecurityCode");
        AppMethodBeat.o(125716);
        return paramFile;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        break label139;
      }
      paramFile = finally;
      localRandomAccessFile = null;
    }
    label139:
    localRandomAccessFile.close();
    label147:
    System.err.println("exit getSecurityCode");
    AppMethodBeat.o(125716);
    throw paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.c.c
 * JD-Core Version:    0.7.0.1
 */