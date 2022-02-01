package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipException;

public final class c
{
  private static final k faT;
  private static final k faU;
  private static int faV;
  private static final k faW;
  
  static
  {
    AppMethodBeat.i(973);
    faT = new k(84298576L);
    faU = new k(50613072L);
    faV = 0;
    faW = new k(101010256L);
    AppMethodBeat.o(973);
  }
  
  private static String ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(977);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= 2)
      {
        paramArrayOfByte = localStringBuilder.toString();
        AppMethodBeat.o(977);
        return paramArrayOfByte;
      }
      localStringBuilder.append(paramArrayOfByte[i]);
      localStringBuilder.append(",");
      i += 1;
    }
  }
  
  private static byte[] d(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    AppMethodBeat.i(974);
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = faW.getBytes();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      if (i == -1) {
        i = 0;
      }
      do
      {
        if (i != 0) {
          break label132;
        }
        System.err.println("archive is not a ZIP archive");
        paramRandomAccessFile = new ZipException("archive is not a ZIP archive");
        AppMethodBeat.o(974);
        throw paramRandomAccessFile;
        if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2])) {
          break;
        }
        i = j;
      } while (paramRandomAccessFile.read() == arrayOfByte[3]);
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    label132:
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (faV != l + 16L + 4L) {
      faV = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    System.err.println("readComment:length bytes data = " + ac(arrayOfByte));
    i = new l(arrayOfByte).value;
    if (i == 0)
    {
      AppMethodBeat.o(974);
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    AppMethodBeat.o(974);
    return arrayOfByte;
  }
  
  /* Error */
  public static void h(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 975
    //   6: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 71	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 133
    //   16: invokespecial 135	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 137	com/tencent/mm/d/c:d	(Ljava/io/RandomAccessFile;)[B
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +128 -> 154
    //   29: aload 4
    //   31: astore_0
    //   32: new 6	com/tencent/mm/d/c$a
    //   35: dup
    //   36: iconst_0
    //   37: invokespecial 140	com/tencent/mm/d/c$a:<init>	(B)V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_0
    //   45: invokevirtual 143	com/tencent/mm/d/c$a:ad	([B)V
    //   48: aload 4
    //   50: getfield 147	com/tencent/mm/d/c$a:faX	Ljava/util/Properties;
    //   53: ldc 149
    //   55: aload_1
    //   56: invokevirtual 155	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   59: pop
    //   60: aload 4
    //   62: invokevirtual 158	com/tencent/mm/d/c$a:Km	()[B
    //   65: astore_0
    //   66: aload_3
    //   67: getstatic 37	com/tencent/mm/d/c:faV	I
    //   70: i2l
    //   71: invokevirtual 80	java/io/RandomAccessFile:seek	(J)V
    //   74: aload_3
    //   75: new 121	com/tencent/mm/d/l
    //   78: dup
    //   79: aload_0
    //   80: arraylength
    //   81: invokespecial 160	com/tencent/mm/d/l:<init>	(I)V
    //   84: invokevirtual 161	com/tencent/mm/d/l:getBytes	()[B
    //   87: invokevirtual 164	java/io/RandomAccessFile:write	([B)V
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 164	java/io/RandomAccessFile:write	([B)V
    //   95: getstatic 37	com/tencent/mm/d/c:faV	I
    //   98: istore_2
    //   99: aload_3
    //   100: aload_0
    //   101: arraylength
    //   102: iload_2
    //   103: iadd
    //   104: iconst_2
    //   105: iadd
    //   106: i2l
    //   107: invokevirtual 167	java/io/RandomAccessFile:setLength	(J)V
    //   110: getstatic 94	java/lang/System:err	Ljava/io/PrintStream;
    //   113: new 52	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 169
    //   119: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_3
    //   123: invokevirtual 75	java/io/RandomAccessFile:length	()J
    //   126: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   135: aload_3
    //   136: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   139: getstatic 94	java/lang/System:err	Ljava/io/PrintStream;
    //   142: ldc 177
    //   144: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   147: sipush 975
    //   150: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: aload_0
    //   155: invokestatic 183	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   158: astore 4
    //   160: getstatic 31	com/tencent/mm/d/c:faT	Lcom/tencent/mm/d/k;
    //   163: invokevirtual 84	com/tencent/mm/d/k:getBytes	()[B
    //   166: pop
    //   167: iconst_4
    //   168: newarray byte
    //   170: astore 5
    //   172: aload 4
    //   174: aload 5
    //   176: invokevirtual 186	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   179: pop
    //   180: getstatic 31	com/tencent/mm/d/c:faT	Lcom/tencent/mm/d/k;
    //   183: new 23	com/tencent/mm/d/k
    //   186: dup
    //   187: aload 5
    //   189: invokespecial 187	com/tencent/mm/d/k:<init>	([B)V
    //   192: invokevirtual 191	com/tencent/mm/d/k:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +6 -> 201
    //   198: goto -166 -> 32
    //   201: getstatic 35	com/tencent/mm/d/c:faU	Lcom/tencent/mm/d/k;
    //   204: new 23	com/tencent/mm/d/k
    //   207: dup
    //   208: aload 5
    //   210: invokespecial 187	com/tencent/mm/d/k:<init>	([B)V
    //   213: invokevirtual 191	com/tencent/mm/d/k:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +6 -> 222
    //   219: goto -187 -> 32
    //   222: new 193	java/io/ByteArrayOutputStream
    //   225: dup
    //   226: invokespecial 194	java/io/ByteArrayOutputStream:<init>	()V
    //   229: astore 4
    //   231: aload 4
    //   233: getstatic 35	com/tencent/mm/d/c:faU	Lcom/tencent/mm/d/k;
    //   236: invokevirtual 84	com/tencent/mm/d/k:getBytes	()[B
    //   239: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   242: aload 4
    //   244: new 121	com/tencent/mm/d/l
    //   247: dup
    //   248: aload_0
    //   249: arraylength
    //   250: invokespecial 160	com/tencent/mm/d/l:<init>	(I)V
    //   253: invokevirtual 161	com/tencent/mm/d/l:getBytes	()[B
    //   256: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   259: aload 4
    //   261: aload_0
    //   262: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   265: aload 4
    //   267: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   270: astore_0
    //   271: goto -239 -> 32
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   285: getstatic 94	java/lang/System:err	Ljava/io/PrintStream;
    //   288: ldc 177
    //   290: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   293: sipush 975
    //   296: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload_0
    //   300: athrow
    //   301: astore_0
    //   302: aload_3
    //   303: astore_1
    //   304: goto -27 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramFile	File
    //   0	307	1	paramString	String
    //   98	6	2	i	int
    //   19	284	3	localRandomAccessFile	RandomAccessFile
    //   1	265	4	localObject	Object
    //   170	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	20	274	finally
    //   20	25	301	finally
    //   32	135	301	finally
    //   154	198	301	finally
    //   201	219	301	finally
    //   222	271	301	finally
  }
  
  public static String u(File paramFile)
  {
    AppMethodBeat.i(976);
    System.err.println("enter getSecurityCode");
    System.err.println("apkFile filename:" + paramFile.getName());
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      a locala;
      if (localRandomAccessFile == null) {
        break label150;
      }
    }
    finally
    {
      try
      {
        paramFile = d(localRandomAccessFile);
        if (paramFile == null)
        {
          System.err.println("null == readComment");
          System.err.println("exit");
          localRandomAccessFile.close();
          System.err.println("exit getSecurityCode");
          AppMethodBeat.o(976);
          return null;
        }
        locala = new a((byte)0);
        locala.ad(paramFile);
        paramFile = locala.faX.getProperty("apkSecurityCode");
        localRandomAccessFile.close();
        System.err.println("exit getSecurityCode");
        AppMethodBeat.o(976);
        return paramFile;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        break label142;
      }
      paramFile = finally;
      localRandomAccessFile = null;
    }
    label142:
    localRandomAccessFile.close();
    label150:
    System.err.println("exit getSecurityCode");
    AppMethodBeat.o(976);
    throw paramFile;
  }
  
  static final class a
  {
    Properties faX;
    byte[] faY;
    
    private a()
    {
      AppMethodBeat.i(970);
      this.faX = new Properties();
      AppMethodBeat.o(970);
    }
    
    final byte[] Km()
    {
      AppMethodBeat.i(972);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Iterator localIterator;
      if (this.faX.size() > 0)
      {
        localByteArrayOutputStream.write(c.aah().getBytes());
        localIterator = this.faX.keySet().iterator();
      }
      Object localObject2;
      for (Object localObject1 = "";; localObject1 = localObject1 + localObject2 + "=" + this.faX.getProperty((String)localObject2) + "\r\n")
      {
        if (!localIterator.hasNext())
        {
          localObject1 = ((String)localObject1).getBytes();
          localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
          localByteArrayOutputStream.write((byte[])localObject1);
          if ((this.faY != null) && (this.faY.length > 0))
          {
            localByteArrayOutputStream.write(c.aai().getBytes());
            localByteArrayOutputStream.write(new l(this.faY.length).getBytes());
            localByteArrayOutputStream.write(this.faY);
          }
          localObject1 = localByteArrayOutputStream.toByteArray();
          AppMethodBeat.o(972);
          return localObject1;
        }
        localObject2 = localIterator.next();
      }
    }
    
    final void ad(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(971);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        AppMethodBeat.o(971);
        return;
      }
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      c.aah().getBytes();
      byte[] arrayOfByte = new byte[4];
      localByteBuffer.get(arrayOfByte);
      System.out.println("securityPart: " + new k(arrayOfByte).value);
      int i;
      if (c.aah().equals(new k(arrayOfByte)))
      {
        if (paramArrayOfByte.length - 4 <= 2)
        {
          System.err.println("data.length - securityMarkLength <= 2");
          AppMethodBeat.o(971);
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        i = new l(arrayOfByte).value;
        if (paramArrayOfByte.length - 4 - 2 < i)
        {
          System.err.println("data.length - securityMarkLength - 2 < len");
          System.err.println("exit");
          AppMethodBeat.o(971);
          return;
        }
        arrayOfByte = new byte[i];
        localByteBuffer.get(arrayOfByte);
        this.faX.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - 4 - i - 2;
        if (i > 0)
        {
          c.aai().getBytes();
          paramArrayOfByte = new byte[4];
          localByteBuffer.get(paramArrayOfByte);
          if (c.aai().equals(new k(paramArrayOfByte)))
          {
            if (i - 4 <= 2)
            {
              System.err.println("data.length - oriMarkLength <= 2");
              AppMethodBeat.o(971);
              return;
            }
            paramArrayOfByte = new byte[2];
            localByteBuffer.get(paramArrayOfByte);
            int j = new l(paramArrayOfByte).value;
            if (i - 4 - 2 < j)
            {
              System.err.println("data.length - oriMarkLength - 2 < len");
              System.err.println("exit");
              AppMethodBeat.o(971);
              return;
            }
            this.faY = new byte[j];
            localByteBuffer.get(this.faY);
            AppMethodBeat.o(971);
          }
        }
      }
      else
      {
        if (c.aai().equals(new k(arrayOfByte)))
        {
          c.aai().getBytes();
          if (paramArrayOfByte.length - 4 <= 2)
          {
            System.err.println("data.length - oriMarkLength <= 2");
            AppMethodBeat.o(971);
            return;
          }
          arrayOfByte = new byte[2];
          localByteBuffer.get(arrayOfByte);
          i = new l(arrayOfByte).value;
          if (paramArrayOfByte.length - 4 - 2 < i)
          {
            System.err.println("data.length - oriMarkLength - 2 < len");
            System.err.println("exit");
            AppMethodBeat.o(971);
            return;
          }
          this.faY = new byte[i];
          localByteBuffer.get(this.faY);
          AppMethodBeat.o(971);
          return;
        }
        paramArrayOfByte = new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
        AppMethodBeat.o(971);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.c
 * JD-Core Version:    0.7.0.1
 */