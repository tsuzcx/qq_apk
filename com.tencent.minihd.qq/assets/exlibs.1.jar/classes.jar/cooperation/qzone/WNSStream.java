package cooperation.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfTokenInfo;
import QMF_PROTOCAL.QmfUpstream;
import QMF_PROTOCAL.RetryInfo;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class WNSStream
{
  private static final String jdField_a_of_type_JavaLangString = WNSStream.class.getName();
  private static final byte[] jdField_b_of_type_ArrayOfByte = { 119, 110, 115, 0 };
  private static final String jdField_d_of_type_JavaLangString = "busiCompCtl";
  private static final String jdField_e_of_type_JavaLangString = "UTF-8";
  private static final String f = "wifi";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private RetryInfo jdField_a_of_type_QMF_PROTOCALRetryInfo = null;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  private int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString = null;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  
  public WNSStream()
  {
    this.e = 2;
  }
  
  public WNSStream(int paramInt, String paramString1, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    this.e = 2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  public WNSStream(int paramInt, String paramString1, long paramLong, byte[] paramArrayOfByte, String paramString2, RetryInfo paramRetryInfo)
  {
    this(paramInt, paramString1, paramLong, paramArrayOfByte, paramString2);
    this.jdField_a_of_type_QMF_PROTOCALRetryInfo = paramRetryInfo;
  }
  
  private QmfBusiControl a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QmfBusiControl localQmfBusiControl = new QmfBusiControl();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localQmfBusiControl.compFlag = i;
      localQmfBusiControl.lenBeforeComp = paramInt1;
      localQmfBusiControl.rspCompFlag = paramInt2;
      return localQmfBusiControl;
    }
  }
  
  public static JceStruct a(Class paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(new JceInputStream(paramArrayOfByte));
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte2 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte2, 0, localInflater.inflate(arrayOfByte2));
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
        try
        {
          localByteArrayOutputStream.close();
          paramArrayOfByte = localIOException2;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = localIOException2;
        }
      }
    }
    finally {}
  }
  
  public QmfDownstream a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return (QmfDownstream)a(QmfDownstream.class, paramArrayOfByte);
    }
    return null;
  }
  
  QmfUpstream a(int paramInt1, String paramString1, int paramInt2, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3, RetryInfo paramRetryInfo)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramArrayOfByte1 == null)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), new byte[] { 0 });
    return new QmfUpstream(paramInt1, paramInt2, paramLong, paramString2, paramString1, paramString3, new QmfTokenInfo(64, paramArrayOfByte1, localHashMap), new QmfClientIpInfo((byte)0, (short)0, 0, new byte[] { 0, 0, 0, 0, 0, 0 }), paramArrayOfByte2, paramArrayOfByte3, 0L, 0L, paramRetryInfo);
  }
  
  public byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.put("busiCompCtl", a(paramBoolean, paramArrayOfByte.length, this.jdField_c_of_type_Int));
    if (paramBoolean)
    {
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      return a(a(paramInt, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte, localUniAttribute.encode(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_QMF_PROTOCALRetryInfo));
    }
    return a(a(paramInt, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte, localUniAttribute.encode(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_QMF_PROTOCALRetryInfo));
  }
  
  public byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean, JceStruct paramJceStruct)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.put("busiCompCtl", a(paramBoolean, paramArrayOfByte.length, this.jdField_c_of_type_Int));
    if (paramJceStruct != null)
    {
      localUniAttribute.put("conf_info_req", paramJceStruct);
      localUniAttribute.put("wns_sdk_version", new Integer(1));
    }
    if (paramBoolean)
    {
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      return a(a(paramInt, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte, localUniAttribute.encode(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_QMF_PROTOCALRetryInfo));
    }
    return a(a(paramInt, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte, localUniAttribute.encode(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_QMF_PROTOCALRetryInfo));
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Deflater localDeflater = new Deflater();
    localDeflater.reset();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte2 = new byte[1024];
      while (!localDeflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte2, 0, localDeflater.deflate(arrayOfByte2));
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localDeflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
        try
        {
          localByteArrayOutputStream.close();
          paramArrayOfByte = localIOException2;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = localIOException2;
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.WNSStream
 * JD-Core Version:    0.7.0.1
 */