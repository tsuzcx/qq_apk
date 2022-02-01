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
  private static final k cJZ;
  private static final k cKa;
  private static int cKb;
  private static final k cKc;
  
  static
  {
    AppMethodBeat.i(973);
    cJZ = new k(84298576L);
    cKa = new k(50613072L);
    cKb = 0;
    cKc = new k(101010256L);
    AppMethodBeat.o(973);
  }
  
  public static String B(File paramFile)
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
        locala.K(paramFile);
        paramFile = locala.cKd.getProperty("apkSecurityCode");
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
  
  private static String J(byte[] paramArrayOfByte)
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
    byte[] arrayOfByte = cKc.getBytes();
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
    if (cKb != l + 16L + 4L) {
      cKb = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    System.err.println("readComment:length bytes data = " + J(arrayOfByte));
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
  public static void g(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 975
    //   6: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 82	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 177
    //   16: invokespecial 87	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 91	com/tencent/mm/d/c:d	(Ljava/io/RandomAccessFile;)[B
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +128 -> 154
    //   29: aload 4
    //   31: astore_0
    //   32: new 6	com/tencent/mm/d/c$a
    //   35: dup
    //   36: iconst_0
    //   37: invokespecial 103	com/tencent/mm/d/c$a:<init>	(B)V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_0
    //   45: invokevirtual 107	com/tencent/mm/d/c$a:K	([B)V
    //   48: aload 4
    //   50: getfield 111	com/tencent/mm/d/c$a:cKd	Ljava/util/Properties;
    //   53: ldc 113
    //   55: aload_1
    //   56: invokevirtual 181	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   59: pop
    //   60: aload 4
    //   62: invokevirtual 184	com/tencent/mm/d/c$a:Kj	()[B
    //   65: astore_0
    //   66: aload_3
    //   67: getstatic 37	com/tencent/mm/d/c:cKb	I
    //   70: i2l
    //   71: invokevirtual 140	java/io/RandomAccessFile:seek	(J)V
    //   74: aload_3
    //   75: new 166	com/tencent/mm/d/l
    //   78: dup
    //   79: aload_0
    //   80: arraylength
    //   81: invokespecial 186	com/tencent/mm/d/l:<init>	(I)V
    //   84: invokevirtual 187	com/tencent/mm/d/l:getBytes	()[B
    //   87: invokevirtual 190	java/io/RandomAccessFile:write	([B)V
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 190	java/io/RandomAccessFile:write	([B)V
    //   95: getstatic 37	com/tencent/mm/d/c:cKb	I
    //   98: istore_2
    //   99: aload_3
    //   100: aload_0
    //   101: arraylength
    //   102: iload_2
    //   103: iadd
    //   104: iconst_2
    //   105: iadd
    //   106: i2l
    //   107: invokevirtual 193	java/io/RandomAccessFile:setLength	(J)V
    //   110: getstatic 53	java/lang/System:err	Ljava/io/PrintStream;
    //   113: new 63	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 195
    //   119: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_3
    //   123: invokevirtual 135	java/io/RandomAccessFile:length	()J
    //   126: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 61	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   135: aload_3
    //   136: invokevirtual 98	java/io/RandomAccessFile:close	()V
    //   139: getstatic 53	java/lang/System:err	Ljava/io/PrintStream;
    //   142: ldc 200
    //   144: invokevirtual 61	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   147: sipush 975
    //   150: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: aload_0
    //   155: invokestatic 206	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   158: astore 4
    //   160: iconst_4
    //   161: newarray byte
    //   163: astore 5
    //   165: aload 4
    //   167: aload 5
    //   169: invokevirtual 209	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   172: pop
    //   173: getstatic 31	com/tencent/mm/d/c:cJZ	Lcom/tencent/mm/d/k;
    //   176: new 23	com/tencent/mm/d/k
    //   179: dup
    //   180: aload 5
    //   182: invokespecial 210	com/tencent/mm/d/k:<init>	([B)V
    //   185: invokevirtual 214	com/tencent/mm/d/k:equals	(Ljava/lang/Object;)Z
    //   188: ifeq +6 -> 194
    //   191: goto -159 -> 32
    //   194: getstatic 35	com/tencent/mm/d/c:cKa	Lcom/tencent/mm/d/k;
    //   197: new 23	com/tencent/mm/d/k
    //   200: dup
    //   201: aload 5
    //   203: invokespecial 210	com/tencent/mm/d/k:<init>	([B)V
    //   206: invokevirtual 214	com/tencent/mm/d/k:equals	(Ljava/lang/Object;)Z
    //   209: ifeq +6 -> 215
    //   212: goto -180 -> 32
    //   215: new 216	java/io/ByteArrayOutputStream
    //   218: dup
    //   219: invokespecial 217	java/io/ByteArrayOutputStream:<init>	()V
    //   222: astore 4
    //   224: aload 4
    //   226: getstatic 35	com/tencent/mm/d/c:cKa	Lcom/tencent/mm/d/k;
    //   229: invokevirtual 144	com/tencent/mm/d/k:getBytes	()[B
    //   232: invokevirtual 218	java/io/ByteArrayOutputStream:write	([B)V
    //   235: aload 4
    //   237: new 166	com/tencent/mm/d/l
    //   240: dup
    //   241: aload_0
    //   242: arraylength
    //   243: invokespecial 186	com/tencent/mm/d/l:<init>	(I)V
    //   246: invokevirtual 187	com/tencent/mm/d/l:getBytes	()[B
    //   249: invokevirtual 218	java/io/ByteArrayOutputStream:write	([B)V
    //   252: aload 4
    //   254: aload_0
    //   255: invokevirtual 218	java/io/ByteArrayOutputStream:write	([B)V
    //   258: aload 4
    //   260: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   263: astore_0
    //   264: goto -232 -> 32
    //   267: astore_0
    //   268: aconst_null
    //   269: astore_1
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 98	java/io/RandomAccessFile:close	()V
    //   278: getstatic 53	java/lang/System:err	Ljava/io/PrintStream;
    //   281: ldc 200
    //   283: invokevirtual 61	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   286: sipush 975
    //   289: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_0
    //   295: aload_3
    //   296: astore_1
    //   297: goto -27 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramFile	File
    //   0	300	1	paramString	String
    //   98	6	2	i	int
    //   19	277	3	localRandomAccessFile	RandomAccessFile
    //   1	258	4	localObject	Object
    //   163	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	20	267	finally
    //   20	25	294	finally
    //   32	135	294	finally
    //   154	191	294	finally
    //   194	212	294	finally
    //   215	264	294	finally
  }
  
  static final class a
  {
    Properties cKd;
    byte[] cKe;
    
    private a()
    {
      AppMethodBeat.i(970);
      this.cKd = new Properties();
      AppMethodBeat.o(970);
    }
    
    final void K(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(971);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        AppMethodBeat.o(971);
        return;
      }
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      c.Kh();
      byte[] arrayOfByte = new byte[4];
      localByteBuffer.get(arrayOfByte);
      System.out.println("securityPart: " + new k(arrayOfByte).value);
      int i;
      if (c.Kh().equals(new k(arrayOfByte)))
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
        this.cKd.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - 4 - i - 2;
        if (i > 0)
        {
          c.Ki();
          paramArrayOfByte = new byte[4];
          localByteBuffer.get(paramArrayOfByte);
          if (c.Ki().equals(new k(paramArrayOfByte)))
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
            this.cKe = new byte[j];
            localByteBuffer.get(this.cKe);
            AppMethodBeat.o(971);
          }
        }
      }
      else
      {
        if (c.Ki().equals(new k(arrayOfByte)))
        {
          c.Ki();
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
          this.cKe = new byte[i];
          localByteBuffer.get(this.cKe);
          AppMethodBeat.o(971);
          return;
        }
        paramArrayOfByte = new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
        AppMethodBeat.o(971);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(971);
    }
    
    final byte[] Kj()
    {
      AppMethodBeat.i(972);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Iterator localIterator;
      if (this.cKd.size() > 0)
      {
        localByteArrayOutputStream.write(c.Kh().getBytes());
        localIterator = this.cKd.keySet().iterator();
      }
      Object localObject2;
      for (Object localObject1 = "";; localObject1 = localObject1 + localObject2 + "=" + this.cKd.getProperty((String)localObject2) + "\r\n")
      {
        if (!localIterator.hasNext())
        {
          localObject1 = ((String)localObject1).getBytes();
          localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
          localByteArrayOutputStream.write((byte[])localObject1);
          if ((this.cKe != null) && (this.cKe.length > 0))
          {
            localByteArrayOutputStream.write(c.Ki().getBytes());
            localByteArrayOutputStream.write(new l(this.cKe.length).getBytes());
            localByteArrayOutputStream.write(this.cKe);
          }
          localObject1 = localByteArrayOutputStream.toByteArray();
          AppMethodBeat.o(972);
          return localObject1;
        }
        localObject2 = localIterator.next();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.c
 * JD-Core Version:    0.7.0.1
 */