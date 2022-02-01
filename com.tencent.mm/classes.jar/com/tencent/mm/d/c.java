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
  private static final j het;
  private static final j heu;
  private static int hev;
  private static final j hew;
  
  static
  {
    AppMethodBeat.i(973);
    het = new j(84298576L);
    heu = new j(50613072L);
    hev = 0;
    hew = new j(101010256L);
    AppMethodBeat.o(973);
  }
  
  private static String ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(977);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 2)
    {
      localStringBuilder.append(paramArrayOfByte[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(977);
    return paramArrayOfByte;
  }
  
  private static byte[] d(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    AppMethodBeat.i(974);
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = hew.getBytes();
    int i = paramRandomAccessFile.read();
    if (i != -1) {
      if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2]) || (paramRandomAccessFile.read() != arrayOfByte[3])) {}
    }
    for (i = j;; i = 0)
    {
      if (i == 0)
      {
        System.err.println("archive is not a ZIP archive");
        paramRandomAccessFile = new ZipException("archive is not a ZIP archive");
        AppMethodBeat.o(974);
        throw paramRandomAccessFile;
        l -= 1L;
        paramRandomAccessFile.seek(l);
        i = paramRandomAccessFile.read();
        break;
      }
      paramRandomAccessFile.seek(l + 16L + 4L);
      if (hev != l + 16L + 4L) {
        hev = (int)(l + 16L + 4L);
      }
      arrayOfByte = new byte[2];
      paramRandomAccessFile.readFully(arrayOfByte);
      System.err.println("readComment:length bytes data = " + ac(arrayOfByte));
      i = new k(arrayOfByte).value;
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
    //   50: getfield 147	com/tencent/mm/d/c$a:hex	Ljava/util/Properties;
    //   53: ldc 149
    //   55: aload_1
    //   56: invokevirtual 155	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   59: pop
    //   60: aload 4
    //   62: invokevirtual 158	com/tencent/mm/d/c$a:akn	()[B
    //   65: astore_0
    //   66: aload_3
    //   67: getstatic 37	com/tencent/mm/d/c:hev	I
    //   70: i2l
    //   71: invokevirtual 80	java/io/RandomAccessFile:seek	(J)V
    //   74: aload_3
    //   75: new 121	com/tencent/mm/d/k
    //   78: dup
    //   79: aload_0
    //   80: arraylength
    //   81: invokespecial 160	com/tencent/mm/d/k:<init>	(I)V
    //   84: invokevirtual 161	com/tencent/mm/d/k:getBytes	()[B
    //   87: invokevirtual 164	java/io/RandomAccessFile:write	([B)V
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 164	java/io/RandomAccessFile:write	([B)V
    //   95: getstatic 37	com/tencent/mm/d/c:hev	I
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
    //   129: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   160: getstatic 31	com/tencent/mm/d/c:het	Lcom/tencent/mm/d/j;
    //   163: invokevirtual 84	com/tencent/mm/d/j:getBytes	()[B
    //   166: arraylength
    //   167: newarray byte
    //   169: astore 5
    //   171: aload 4
    //   173: aload 5
    //   175: invokevirtual 186	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   178: pop
    //   179: getstatic 31	com/tencent/mm/d/c:het	Lcom/tencent/mm/d/j;
    //   182: new 23	com/tencent/mm/d/j
    //   185: dup
    //   186: aload 5
    //   188: invokespecial 187	com/tencent/mm/d/j:<init>	([B)V
    //   191: invokevirtual 191	com/tencent/mm/d/j:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +6 -> 200
    //   197: goto -165 -> 32
    //   200: getstatic 35	com/tencent/mm/d/c:heu	Lcom/tencent/mm/d/j;
    //   203: new 23	com/tencent/mm/d/j
    //   206: dup
    //   207: aload 5
    //   209: invokespecial 187	com/tencent/mm/d/j:<init>	([B)V
    //   212: invokevirtual 191	com/tencent/mm/d/j:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +6 -> 221
    //   218: goto -186 -> 32
    //   221: new 193	java/io/ByteArrayOutputStream
    //   224: dup
    //   225: invokespecial 194	java/io/ByteArrayOutputStream:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: getstatic 35	com/tencent/mm/d/c:heu	Lcom/tencent/mm/d/j;
    //   235: invokevirtual 84	com/tencent/mm/d/j:getBytes	()[B
    //   238: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   241: aload 4
    //   243: new 121	com/tencent/mm/d/k
    //   246: dup
    //   247: aload_0
    //   248: arraylength
    //   249: invokespecial 160	com/tencent/mm/d/k:<init>	(I)V
    //   252: invokevirtual 161	com/tencent/mm/d/k:getBytes	()[B
    //   255: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   258: aload 4
    //   260: aload_0
    //   261: invokevirtual 195	java/io/ByteArrayOutputStream:write	([B)V
    //   264: aload 4
    //   266: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   269: astore_0
    //   270: goto -238 -> 32
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   284: getstatic 94	java/lang/System:err	Ljava/io/PrintStream;
    //   287: ldc 177
    //   289: invokevirtual 102	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   292: sipush 975
    //   295: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_0
    //   299: athrow
    //   300: astore_0
    //   301: aload_3
    //   302: astore_1
    //   303: goto -27 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramFile	File
    //   0	306	1	paramString	String
    //   98	6	2	i	int
    //   19	283	3	localRandomAccessFile	RandomAccessFile
    //   1	264	4	localObject	Object
    //   169	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	20	273	finally
    //   20	25	300	finally
    //   32	135	300	finally
    //   154	197	300	finally
    //   200	218	300	finally
    //   221	270	300	finally
  }
  
  public static String z(File paramFile)
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
        paramFile = locala.hex.getProperty("apkSecurityCode");
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
    Properties hex;
    byte[] hey;
    
    private a()
    {
      AppMethodBeat.i(970);
      this.hex = new Properties();
      AppMethodBeat.o(970);
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
      int i = c.aBL().getBytes().length;
      byte[] arrayOfByte = new byte[i];
      localByteBuffer.get(arrayOfByte);
      System.out.println("securityPart: " + new j(arrayOfByte).value);
      int j;
      if (c.aBL().equals(new j(arrayOfByte)))
      {
        if (paramArrayOfByte.length - i <= 2)
        {
          System.err.println("data.length - securityMarkLength <= 2");
          AppMethodBeat.o(971);
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        j = new k(arrayOfByte).value;
        if (paramArrayOfByte.length - i - 2 < j)
        {
          System.err.println("data.length - securityMarkLength - 2 < len");
          System.err.println("exit");
          AppMethodBeat.o(971);
          return;
        }
        arrayOfByte = new byte[j];
        localByteBuffer.get(arrayOfByte);
        this.hex.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - i - j - 2;
        if (i > 0)
        {
          j = c.aBM().getBytes().length;
          paramArrayOfByte = new byte[j];
          localByteBuffer.get(paramArrayOfByte);
          if (c.aBM().equals(new j(paramArrayOfByte)))
          {
            if (i - j <= 2)
            {
              System.err.println("data.length - oriMarkLength <= 2");
              AppMethodBeat.o(971);
              return;
            }
            paramArrayOfByte = new byte[2];
            localByteBuffer.get(paramArrayOfByte);
            int k = new k(paramArrayOfByte).value;
            if (i - j - 2 < k)
            {
              System.err.println("data.length - oriMarkLength - 2 < len");
              System.err.println("exit");
              AppMethodBeat.o(971);
              return;
            }
            this.hey = new byte[k];
            localByteBuffer.get(this.hey);
          }
        }
        AppMethodBeat.o(971);
        return;
      }
      if (c.aBM().equals(new j(arrayOfByte)))
      {
        j = c.aBM().getBytes().length;
        if (paramArrayOfByte.length - i <= 2)
        {
          System.err.println("data.length - oriMarkLength <= 2");
          AppMethodBeat.o(971);
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        i = new k(arrayOfByte).value;
        if (paramArrayOfByte.length - j - 2 < i)
        {
          System.err.println("data.length - oriMarkLength - 2 < len");
          System.err.println("exit");
          AppMethodBeat.o(971);
          return;
        }
        this.hey = new byte[i];
        localByteBuffer.get(this.hey);
        AppMethodBeat.o(971);
        return;
      }
      paramArrayOfByte = new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
      AppMethodBeat.o(971);
      throw paramArrayOfByte;
    }
    
    final byte[] akn()
    {
      AppMethodBeat.i(972);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      if (this.hex.size() > 0)
      {
        localByteArrayOutputStream.write(c.aBL().getBytes());
        Iterator localIterator = this.hex.keySet().iterator();
        Object localObject2;
        for (localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.hex.getProperty((String)localObject2) + "\r\n") {
          localObject2 = localIterator.next();
        }
        localObject1 = ((String)localObject1).getBytes();
        localByteArrayOutputStream.write(new k(localObject1.length).getBytes());
        localByteArrayOutputStream.write((byte[])localObject1);
      }
      if ((this.hey != null) && (this.hey.length > 0))
      {
        localByteArrayOutputStream.write(c.aBM().getBytes());
        localByteArrayOutputStream.write(new k(this.hey.length).getBytes());
        localByteArrayOutputStream.write(this.hey);
      }
      Object localObject1 = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(972);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.c
 * JD-Core Version:    0.7.0.1
 */