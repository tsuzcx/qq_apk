package midas.x;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class a1
{
  public RSAPublicKey a;
  
  public final byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public String a(String paramString)
  {
    try
    {
      d("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r");
      paramString = b(paramString);
      paramString = a(this.a, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString == null) {
      return "";
    }
    return new String(paramString);
  }
  
  public byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramRSAPublicKey != null) {}
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA");
      localCipher.init(2, paramRSAPublicKey);
      paramRSAPublicKey = localCipher.doFinal(paramArrayOfByte);
      return paramRSAPublicKey;
    }
    catch (NoSuchAlgorithmException paramRSAPublicKey)
    {
      break label64;
    }
    catch (InvalidKeyException paramRSAPublicKey)
    {
      break label54;
    }
    catch (IllegalBlockSizeException paramRSAPublicKey)
    {
      break label44;
    }
    catch (BadPaddingException paramRSAPublicKey)
    {
      break label34;
    }
    catch (Exception paramRSAPublicKey)
    {
      label24:
      break label24;
    }
    throw new Exception("其他错误");
    label34:
    throw new Exception("密文数据已损坏");
    label44:
    throw new Exception("密文长度无效或者过长");
    label54:
    throw new Exception("密钥无效，请检查确认");
    label64:
    throw new Exception("没有这样的解密算法");
    throw new Exception("解密私钥为空, 请设置");
  }
  
  public final byte[] b(String paramString)
  {
    return c(paramString);
  }
  
  public final byte[] c(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = paramString.toUpperCase();
      int j = paramString.length() / 2;
      paramString = paramString.toCharArray();
      byte[] arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 2;
        int m = a(paramString[k]);
        arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public void d(String paramString)
    throws Exception
  {
    try
    {
      paramString = e.a(paramString);
      this.a = ((RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString)));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a1
 * JD-Core Version:    0.7.0.1
 */