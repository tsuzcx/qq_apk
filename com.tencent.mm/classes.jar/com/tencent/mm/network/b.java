package com.tencent.mm.network;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class b
{
  private static b jDF;
  public dfx jDB;
  public String jDC;
  private String jDD;
  private long jDE;
  
  static
  {
    AppMethodBeat.i(197089);
    jDF = new b();
    AppMethodBeat.o(197089);
  }
  
  private b()
  {
    AppMethodBeat.i(197081);
    this.jDB = new dfx();
    this.jDC = "";
    this.jDD = "";
    this.jDE = 0L;
    AppMethodBeat.o(197081);
  }
  
  public static b bjq()
  {
    return jDF;
  }
  
  private boolean bjs()
  {
    boolean bool = true;
    AppMethodBeat.i(197086);
    byte[][] arrayOfByte = UtilsJni.ecdsaGeneralOctKeyPair();
    if ((arrayOfByte == null) || (arrayOfByte.length == 0) || (arrayOfByte.length == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder("gen keypair failed ");
      if (arrayOfByte == null) {}
      for (;;)
      {
        Log.w("CgiSignerPublicAndPrivateKey", bool);
        AppMethodBeat.o(197086);
        return false;
        bool = false;
      }
    }
    try
    {
      this.jDD = new String(arrayOfByte[0], StandardCharsets.ISO_8859_1);
      this.jDC = new String(arrayOfByte[1], StandardCharsets.ISO_8859_1);
      if (!bjt())
      {
        Log.e("CgiSignerPublicAndPrivateKey", "public or private key is empty, public key is empty: " + TextUtils.isEmpty(this.jDD) + ", private key is empty: " + TextUtils.isEmpty(this.jDC));
        AppMethodBeat.o(197086);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed: " + localException.getLocalizedMessage());
      AppMethodBeat.o(197086);
      return false;
    }
    Log.i("CgiSignerPublicAndPrivateKey", "public key length " + this.jDD.length() + " private key length " + this.jDC.length());
    this.jDE = System.currentTimeMillis();
    this.jDB.KLU = new SKBuiltinBuffer_t().setBuffer(this.jDD.getBytes(StandardCharsets.ISO_8859_1));
    this.jDB.LrO = 415;
    AppMethodBeat.o(197086);
    return true;
  }
  
  private boolean bjt()
  {
    AppMethodBeat.i(197087);
    if ((!TextUtils.isEmpty(this.jDD)) && (!TextUtils.isEmpty(this.jDC)))
    {
      AppMethodBeat.o(197087);
      return true;
    }
    AppMethodBeat.o(197087);
    return false;
  }
  
  private boolean bju()
  {
    AppMethodBeat.i(197088);
    if (System.currentTimeMillis() - this.jDE > 86400000L)
    {
      AppMethodBeat.o(197088);
      return true;
    }
    if (!bjt())
    {
      AppMethodBeat.o(197088);
      return true;
    }
    AppMethodBeat.o(197088);
    return false;
  }
  
  public final String RO(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(197082);
    if (TextUtils.isEmpty(this.jDC)) {}
    for (;;)
    {
      try
      {
        arrayOfString = com.tencent.mm.kernel.g.aAg().hqi.iMw.aZl();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.jDD = arrayOfString[0];
          this.jDC = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.jDD.length() + " " + this.jDC.length());
        }
      }
      catch (Exception localException)
      {
        String[] arrayOfString;
        StringBuilder localStringBuilder;
        Log.e("CgiSignerPublicAndPrivateKey", "try restore key from push failed " + localException.getLocalizedMessage());
        continue;
        bool = false;
        continue;
      }
      try
      {
        paramString = UtilsJni.ecdsaSignWithOctKey(this.jDC.getBytes(StandardCharsets.ISO_8859_1), paramString.getBytes(StandardCharsets.ISO_8859_1));
        if (paramString != null) {
          break label254;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(197082);
        return "";
      }
      catch (Exception paramString)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data failed " + paramString.getLocalizedMessage());
        AppMethodBeat.o(197082);
        return "";
      }
      localStringBuilder = new StringBuilder("backup key is empty ");
      if (arrayOfString != null) {
        continue;
      }
      Log.w("CgiSignerPublicAndPrivateKey", bool);
    }
    label254:
    Log.d("CgiSignerPublicAndPrivateKey", "sign result length " + paramString.length);
    paramString = new String(paramString, StandardCharsets.ISO_8859_1);
    AppMethodBeat.o(197082);
    return paramString;
  }
  
  public final byte[] az(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(197083);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(197083);
      return null;
    }
    if (TextUtils.isEmpty(this.jDC)) {}
    for (;;)
    {
      try
      {
        arrayOfString = com.tencent.mm.kernel.g.aAg().hqi.iMw.aZl();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.jDD = arrayOfString[0];
          this.jDC = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.jDD.length() + " " + this.jDC.length());
        }
      }
      catch (Exception localException)
      {
        String[] arrayOfString;
        StringBuilder localStringBuilder;
        Log.e("CgiSignerPublicAndPrivateKey", "try restore key from push failed " + localException.getLocalizedMessage());
        continue;
        bool = false;
        continue;
      }
      try
      {
        paramArrayOfByte = UtilsJni.ecdsaSignWithOctKey(this.jDC.getBytes(StandardCharsets.ISO_8859_1), paramArrayOfByte);
        if (paramArrayOfByte != null) {
          break label257;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(197083);
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data byte failed " + paramArrayOfByte.getLocalizedMessage());
        AppMethodBeat.o(197083);
        return null;
      }
      localStringBuilder = new StringBuilder("backup key is empty ");
      if (arrayOfString != null) {
        continue;
      }
      Log.w("CgiSignerPublicAndPrivateKey", bool);
    }
    label257:
    Log.d("CgiSignerPublicAndPrivateKey", "sign byte result length " + paramArrayOfByte.length);
    AppMethodBeat.o(197083);
    return paramArrayOfByte;
  }
  
  public final int bL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197084);
    try
    {
      int i = UtilsJni.ecdsaVerifyWithOctKey(this.jDD.getBytes(StandardCharsets.ISO_8859_1), paramString1.getBytes(StandardCharsets.ISO_8859_1), paramString2.getBytes(StandardCharsets.ISO_8859_1));
      Log.d("CgiSignerPublicAndPrivateKey", "verify result ".concat(String.valueOf(i)));
      AppMethodBeat.o(197084);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "verify failed " + paramString1.getLocalizedMessage());
      AppMethodBeat.o(197084);
    }
    return -1;
  }
  
  public final String bjr()
  {
    AppMethodBeat.i(197085);
    if ((bju()) && (!bjs()))
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed");
      AppMethodBeat.o(197085);
      return "";
    }
    String str = this.jDD;
    AppMethodBeat.o(197085);
    return str;
  }
  
  public static final class a
  {
    public String jDC = "";
    public String jDD = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */