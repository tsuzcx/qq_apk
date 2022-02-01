package com.tencent.apkupdate.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.protocol.jce.Response;
import com.tencent.apkupdate.logic.protocol.jce.RspHead;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private String a;
  private final LinkedHashMap b = new LinkedHashMap();
  
  public static int a(int paramInt)
  {
    return (paramInt & 0xFF) << 24 | (paramInt >> 8 & 0xFF) << 16 | (paramInt >> 16 & 0xFF) << 8 | paramInt >>> 24;
  }
  
  private static JceStruct a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - 7) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName("com.tencent.apkupdate.logic.protocol.jce." + paramJceStruct).newInstance();
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
  }
  
  public static JceStruct a(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = a(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          paramJceStruct.printStackTrace();
          return null;
        }
      }
    }
    return null;
  }
  
  public static Response a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Response localResponse = new Response();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localResponse;
        if (localResponse.head.ret == 0)
        {
          if ((localResponse.head.encryptWithPack & 0x2) == 2)
          {
            paramArrayOfByte = localResponse.body;
            byte[] arrayOfByte = "ji*9^&43U0X-~./(".getBytes();
            localResponse.body = new com.tencent.apkupdate.c.a().a(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte);
          }
          if ((localResponse.head.encryptWithPack & 0x1) == 1) {
            localResponse.body = c(localResponse.body);
          }
          com.tencent.apkupdate.c.b.a().b(localResponse.head.phoneGuid);
          return localResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(b paramb, DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeInt(1347094280);
    paramDataOutputStream.writeInt(a(paramb.g));
    paramDataOutputStream.writeInt(a(paramb.h));
    paramDataOutputStream.writeInt(a(paramb.i));
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 173	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 174	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: new 176	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: aload_0
    //   13: arraylength
    //   14: invokespecial 178	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore_1
    //   18: aload_2
    //   19: bipush 9
    //   21: invokevirtual 181	java/util/zip/Deflater:setLevel	(I)V
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 184	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_2
    //   30: invokevirtual 187	java/util/zip/Deflater:finish	()V
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 191	java/util/zip/Deflater:finished	()Z
    //   43: ifne +32 -> 75
    //   46: aload_1
    //   47: aload_0
    //   48: iconst_0
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 195	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 199	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 202	java/util/zip/Deflater:end	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_2
    //   76: invokevirtual 202	java/util/zip/Deflater:end	()V
    //   79: aload_1
    //   80: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   93: goto -10 -> 83
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   101: goto -28 -> 73
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -46 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   17	67	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   96	2	1	localIOException	java.io.IOException
    //   106	1	1	localObject	Object
    //   7	69	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   18	39	60	finally
    //   39	57	60	finally
    //   79	83	88	java/io/IOException
    //   69	73	96	java/io/IOException
    //   8	18	104	finally
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 213	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 214	java/util/zip/Inflater:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: new 176	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_0
    //   16: arraylength
    //   17: invokespecial 178	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: invokevirtual 215	java/util/zip/Inflater:setInput	([B)V
    //   37: aload_1
    //   38: astore_2
    //   39: aload 4
    //   41: invokevirtual 216	java/util/zip/Inflater:finished	()Z
    //   44: ifne +51 -> 95
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: aload_3
    //   51: iconst_0
    //   52: aload 4
    //   54: aload_3
    //   55: invokevirtual 219	java/util/zip/Inflater:inflate	([B)I
    //   58: invokevirtual 199	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -24 -> 37
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 220	java/util/zip/DataFormatException:printStackTrace	()V
    //   73: aload 4
    //   75: invokevirtual 221	java/util/zip/Inflater:end	()V
    //   78: aload_0
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +9 -> 90
    //   84: aload_0
    //   85: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_0
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: areturn
    //   95: aload 4
    //   97: invokevirtual 221	java/util/zip/Inflater:end	()V
    //   100: aload_1
    //   101: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   104: goto -14 -> 90
    //   107: astore_0
    //   108: goto -18 -> 90
    //   111: astore_0
    //   112: aload 4
    //   114: invokevirtual 221	java/util/zip/Inflater:end	()V
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: astore_1
    //   130: goto -40 -> 90
    //   133: astore_1
    //   134: goto -9 -> 125
    //   137: astore_0
    //   138: goto -26 -> 112
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -77 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramArrayOfByte	byte[]
    //   20	81	1	localObject1	Object
    //   127	1	1	localIOException1	java.io.IOException
    //   129	1	1	arrayOfByte1	byte[]
    //   133	1	1	localIOException2	java.io.IOException
    //   10	112	2	localObject2	Object
    //   28	27	3	arrayOfByte2	byte[]
    //   64	6	3	localDataFormatException1	java.util.zip.DataFormatException
    //   141	1	3	localDataFormatException2	java.util.zip.DataFormatException
    //   7	106	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   23	29	64	java/util/zip/DataFormatException
    //   31	37	64	java/util/zip/DataFormatException
    //   39	47	64	java/util/zip/DataFormatException
    //   49	61	64	java/util/zip/DataFormatException
    //   100	104	107	java/io/IOException
    //   11	21	111	finally
    //   84	88	127	java/io/IOException
    //   121	125	133	java/io/IOException
    //   23	29	137	finally
    //   31	37	137	finally
    //   39	47	137	finally
    //   49	61	137	finally
    //   69	73	137	finally
    //   11	21	141	java/util/zip/DataFormatException
  }
  
  public final LinkedHashMap a()
  {
    return this.b;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
    paramString = new g();
    try
    {
      paramString.a(this.a);
      paramString = paramString.b.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        LinkedHashMap localLinkedHashMap = this.b;
        Object localObject = localEntry.getKey();
        int i = ((b)localEntry.getValue()).g;
        localLinkedHashMap.put(localObject, Long.valueOf(((b)localEntry.getValue()).i | i));
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.a.a
 * JD-Core Version:    0.7.0.1
 */