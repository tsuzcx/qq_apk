package com.tencent.midas.comm;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class APMidasRSATools
{
  private final String DEFAULT_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r";
  private RSAPublicKey publicKey;
  
  private byte charToByte(char paramChar)
  {
    AppMethodBeat.i(193222);
    byte b = (byte)"0123456789ABCDEF".indexOf(paramChar);
    AppMethodBeat.o(193222);
    return b;
  }
  
  private byte[] decrypt(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193226);
    if (paramRSAPublicKey == null)
    {
      paramRSAPublicKey = new Exception("解密私钥为空, 请设置");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA");
      localCipher.init(2, paramRSAPublicKey);
      paramRSAPublicKey = localCipher.doFinal(paramArrayOfByte);
      AppMethodBeat.o(193226);
      return paramRSAPublicKey;
    }
    catch (NoSuchAlgorithmException paramRSAPublicKey)
    {
      paramRSAPublicKey = new Exception("没有这样的解密算法");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
    catch (InvalidKeyException paramRSAPublicKey)
    {
      paramRSAPublicKey = new Exception("密钥无效，请检查确认");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
    catch (IllegalBlockSizeException paramRSAPublicKey)
    {
      paramRSAPublicKey = new Exception("密文长度无效或者过长");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
    catch (BadPaddingException paramRSAPublicKey)
    {
      paramRSAPublicKey = new Exception("密文数据已损坏");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
    catch (Exception paramRSAPublicKey)
    {
      APLog.i("APMidasRSATools exception", paramRSAPublicKey.toString());
      paramRSAPublicKey = new Exception("其他错误");
      AppMethodBeat.o(193226);
      throw paramRSAPublicKey;
    }
  }
  
  private byte[] getByte(String paramString)
  {
    AppMethodBeat.i(193223);
    paramString = hexStringToBytes(paramString);
    AppMethodBeat.o(193223);
    return paramString;
  }
  
  private byte[] hexStringToBytes(String paramString)
  {
    AppMethodBeat.i(193221);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(193221);
      return null;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = charToByte(paramString[k]);
      arrayOfByte[i] = ((byte)(charToByte(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    AppMethodBeat.o(193221);
    return arrayOfByte;
  }
  
  private void loadPublicKey(String paramString)
  {
    AppMethodBeat.i(193224);
    try
    {
      paramString = Base64.decode(paramString, 0);
      this.publicKey = ((RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString)));
      AppMethodBeat.o(193224);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(193224);
    }
  }
  
  public String deCodeKey(String paramString)
  {
    AppMethodBeat.i(193225);
    try
    {
      getClass();
      loadPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r");
      paramString = getByte(paramString);
      paramString = decrypt(this.publicKey, paramString);
      paramString = new String(paramString);
      AppMethodBeat.o(193225);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(193225);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.APMidasRSATools
 * JD-Core Version:    0.7.0.1
 */