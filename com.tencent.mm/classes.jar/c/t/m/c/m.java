package c.t.m.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class m
{
  public static final byte[] a = { 84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49 };
  public static final byte[] b = new byte[0];
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39954);
    paramString1 = a(paramString1, paramString2, 2);
    AppMethodBeat.o(39954);
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39951);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString1 = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(39951);
      throw paramString1;
    }
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      if (paramInt != 1) {}
    }
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getBytes();
        if ((paramString1 != null) && (paramString1.length != 0))
        {
          paramString1 = a(paramString1, paramString2, paramInt);
          if (paramInt == 1)
          {
            paramString1 = Base64.encodeToString(paramString1, 2);
            AppMethodBeat.o(39951);
            return paramString1;
            if (paramInt != 2) {
              break label157;
            }
            paramString1 = Base64.decode(paramString1.getBytes(), 2);
            continue;
          }
          if (paramInt == 2)
          {
            paramString1 = new String(paramString1);
            AppMethodBeat.o(39951);
            return paramString1;
          }
          AppMethodBeat.o(39951);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        AppMethodBeat.o(39951);
        return "";
      }
      AppMethodBeat.o(39951);
      return "";
      AppMethodBeat.o(39951);
      return "";
      label157:
      paramString1 = null;
    }
  }
  
  public static Cipher a(String paramString, int paramInt)
  {
    AppMethodBeat.i(39950);
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramString, new IvParameterSpec(a));
    AppMethodBeat.o(39950);
    return localCipher;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(39956);
    paramArrayOfByte = a(paramArrayOfByte, paramString, 2);
    AppMethodBeat.o(39956);
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(39952);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramArrayOfByte = new IllegalArgumentException("wrong mode.");
      AppMethodBeat.o(39952);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      try
      {
        paramString = a(paramString, paramInt);
        if (paramString == null)
        {
          paramArrayOfByte = b;
          AppMethodBeat.o(39952);
          return paramArrayOfByte;
        }
        paramArrayOfByte = paramString.doFinal(paramArrayOfByte);
        AppMethodBeat.o(39952);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte = b;
        AppMethodBeat.o(39952);
        return paramArrayOfByte;
      }
    }
    paramArrayOfByte = b;
    AppMethodBeat.o(39952);
    return paramArrayOfByte;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39953);
    paramString1 = a(paramString1, paramString2, 1);
    AppMethodBeat.o(39953);
    return paramString1;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(39955);
    paramArrayOfByte = a(paramArrayOfByte, paramString, 1);
    AppMethodBeat.o(39955);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.c.m
 * JD-Core Version:    0.7.0.1
 */