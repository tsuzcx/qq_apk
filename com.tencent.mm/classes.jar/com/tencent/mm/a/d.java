package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.y;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d
{
  private Cipher btZ;
  private Cipher bua;
  
  public d(String paramString)
  {
    try
    {
      paramString = new DESKeySpec(paramString.getBytes("UTF8"));
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
      this.btZ = Cipher.getInstance("DES/CBC/PKCS5Padding");
      this.btZ.init(1, paramString, localIvParameterSpec);
      this.bua = Cipher.getInstance("DES/CBC/PKCS5Padding");
      this.bua.init(2, paramString, localIvParameterSpec);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.DESUtil", paramString, "", new Object[0]);
    }
  }
  
  public final String bI(String paramString)
  {
    try
    {
      Object localObject = Base64.decode(paramString, 0);
      localObject = new String(this.bua.doFinal((byte[])localObject), "UTF8");
      return localObject;
    }
    catch (Exception localException)
    {
      return "[des]" + paramString + "|" + localException.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.d
 * JD-Core Version:    0.7.0.1
 */