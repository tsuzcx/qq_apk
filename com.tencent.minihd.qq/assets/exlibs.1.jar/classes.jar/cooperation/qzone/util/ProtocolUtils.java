package cooperation.qzone.util;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.WNSStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ProtocolUtils
{
  public static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new WNSStream();
    try
    {
      paramArrayOfByte = ((WNSStream)localObject).a(b(paramArrayOfByte));
      localObject = new UniAttribute();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
      {
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.Extra);
        localObject = (QmfBusiControl)((UniAttribute)localObject).get("busiCompCtl");
        if ((localObject != null) && (1 == ((QmfBusiControl)localObject).compFlag))
        {
          localObject = WNSStream.b(paramArrayOfByte.BusiBuff);
          if (localObject == null) {
            break label146;
          }
          paramArrayOfByte.BusiBuff = ((byte[])localObject);
        }
        localObject = new UniAttribute();
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.BusiBuff);
        return (JceStruct)((UniAttribute)localObject).get(paramString);
      }
      if (paramArrayOfByte != null)
      {
        int i = paramArrayOfByte.WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label146:
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length + 4);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(paramArrayOfByte.length + 4);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label76:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(localByteArrayInputStream);
    try
    {
      paramArrayOfByte = new byte[localDataInputStream.readInt() - 4];
      label72:
      return paramArrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException5) {}
      localException1 = localException1;
      paramArrayOfByte = null;
      localException1.printStackTrace();
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        return paramArrayOfByte;
      }
    }
    finally
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException3)
      {
        break label72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.util.ProtocolUtils
 * JD-Core Version:    0.7.0.1
 */