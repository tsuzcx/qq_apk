package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APBytesUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class APLogEncryptor
{
  private static String ENCRYPT_KEY = "}VjZtoJF;dE+7iJs";
  private static final byte MAGIC_END = 0;
  private static final byte MAGIC_START = 2;
  private static byte PROTOCOL_VERSION = 1;
  private static byte[] header = new byte[7];
  private Cipher encryptCipher = null;
  
  private static byte[] assembleHeader(int paramInt)
  {
    AppMethodBeat.i(217279);
    System.arraycopy(APBytesUtil.int2bytes(paramInt), 0, header, 3, 4);
    byte[] arrayOfByte = header;
    AppMethodBeat.o(217279);
    return arrayOfByte;
  }
  
  public static APLogEncryptor create()
  {
    AppMethodBeat.i(217249);
    APLogEncryptor localAPLogEncryptor = new APLogEncryptor();
    localAPLogEncryptor.init();
    AppMethodBeat.o(217249);
    return localAPLogEncryptor;
  }
  
  private void init()
  {
    AppMethodBeat.i(217257);
    try
    {
      header[0] = 2;
      header[1] = PROTOCOL_VERSION;
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
      this.encryptCipher = Cipher.getInstance("AES/ECB/NoPadding");
      this.encryptCipher.init(1, localSecretKeySpec);
      AppMethodBeat.o(217257);
      return;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      AppMethodBeat.o(217257);
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      AppMethodBeat.o(217257);
      return;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      AppMethodBeat.o(217257);
    }
  }
  
  public static void setEncryptKey(String paramString)
  {
    ENCRYPT_KEY = paramString;
  }
  
  public static void setProtocolVersion(byte paramByte)
  {
    PROTOCOL_VERSION = paramByte;
  }
  
  public void close()
  {
    this.encryptCipher = null;
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217299);
    int i = paramArrayOfByte.length;
    int j = i % 16;
    byte[] arrayOfByte1 = paramArrayOfByte;
    if (j != 0)
    {
      arrayOfByte2 = paramArrayOfByte;
      arrayOfByte3 = paramArrayOfByte;
    }
    try
    {
      arrayOfByte1 = new byte[16 - j + i];
      arrayOfByte2 = paramArrayOfByte;
      arrayOfByte3 = paramArrayOfByte;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, i);
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      paramArrayOfByte = this.encryptCipher.doFinal(arrayOfByte1);
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = arrayOfByte2;
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = arrayOfByte3;
      }
    }
    arrayOfByte1 = assembleHeader(i);
    arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length + 1];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    arrayOfByte2[(arrayOfByte2.length - 1)] = 0;
    AppMethodBeat.o(217299);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.log.processor.APLogEncryptor
 * JD-Core Version:    0.7.0.1
 */