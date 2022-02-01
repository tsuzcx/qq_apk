package com.tencent.mm.network;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class b
{
  private static b pnC;
  private String pnA;
  private long pnB;
  public eil pny;
  public String pnz;
  
  static
  {
    AppMethodBeat.i(241175);
    pnC = new b();
    AppMethodBeat.o(241175);
  }
  
  private b()
  {
    AppMethodBeat.i(241168);
    this.pny = new eil();
    this.pnz = "";
    this.pnA = "";
    this.pnB = 0L;
    AppMethodBeat.o(241168);
  }
  
  public static b bQD()
  {
    return pnC;
  }
  
  private boolean bQF()
  {
    boolean bool = true;
    AppMethodBeat.i(241170);
    byte[][] arrayOfByte = UtilsJni.ecdsaGeneralOctKeyPair();
    if ((arrayOfByte == null) || (arrayOfByte.length == 0) || (arrayOfByte.length == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder("gen keypair failed ");
      if (arrayOfByte == null) {}
      for (;;)
      {
        Log.w("CgiSignerPublicAndPrivateKey", bool);
        AppMethodBeat.o(241170);
        return false;
        bool = false;
      }
    }
    try
    {
      this.pnA = new String(arrayOfByte[0], StandardCharsets.ISO_8859_1);
      this.pnz = new String(arrayOfByte[1], StandardCharsets.ISO_8859_1);
      if (!bQG())
      {
        Log.e("CgiSignerPublicAndPrivateKey", "public or private key is empty, public key is empty: " + TextUtils.isEmpty(this.pnA) + ", private key is empty: " + TextUtils.isEmpty(this.pnz));
        AppMethodBeat.o(241170);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed: " + localException.getLocalizedMessage());
      AppMethodBeat.o(241170);
      return false;
    }
    Log.i("CgiSignerPublicAndPrivateKey", "public key length " + this.pnA.length() + " private key length " + this.pnz.length());
    this.pnB = System.currentTimeMillis();
    this.pny.YKf = new gol().df(this.pnA.getBytes(StandardCharsets.ISO_8859_1));
    this.pny.Zsz = 415;
    AppMethodBeat.o(241170);
    return true;
  }
  
  private boolean bQG()
  {
    AppMethodBeat.i(241171);
    if ((!TextUtils.isEmpty(this.pnA)) && (!TextUtils.isEmpty(this.pnz)))
    {
      AppMethodBeat.o(241171);
      return true;
    }
    AppMethodBeat.o(241171);
    return false;
  }
  
  private boolean bQH()
  {
    AppMethodBeat.i(241172);
    if (System.currentTimeMillis() - this.pnB > 86400000L)
    {
      AppMethodBeat.o(241172);
      return true;
    }
    if (!bQG())
    {
      AppMethodBeat.o(241172);
      return true;
    }
    AppMethodBeat.o(241172);
    return false;
  }
  
  public final String Rs(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(241183);
    if (TextUtils.isEmpty(this.pnz)) {}
    for (;;)
    {
      try
      {
        arrayOfString = h.baD().mCm.oun.bGk();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.pnA = arrayOfString[0];
          this.pnz = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.pnA.length() + " " + this.pnz.length());
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
        paramString = UtilsJni.ecdsaSignWithOctKey(this.pnz.getBytes(StandardCharsets.ISO_8859_1), paramString.getBytes(StandardCharsets.ISO_8859_1));
        if (paramString != null) {
          break label254;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(241183);
        return "";
      }
      catch (Exception paramString)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data failed " + paramString.getLocalizedMessage());
        AppMethodBeat.o(241183);
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
    AppMethodBeat.o(241183);
    return paramString;
  }
  
  public final byte[] aK(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(241185);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(241185);
      return null;
    }
    if (TextUtils.isEmpty(this.pnz)) {}
    for (;;)
    {
      try
      {
        arrayOfString = h.baD().mCm.oun.bGk();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.pnA = arrayOfString[0];
          this.pnz = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.pnA.length() + " " + this.pnz.length());
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
        paramArrayOfByte = UtilsJni.ecdsaSignWithOctKey(this.pnz.getBytes(StandardCharsets.ISO_8859_1), paramArrayOfByte);
        if (paramArrayOfByte != null) {
          break label257;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(241185);
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data byte failed " + paramArrayOfByte.getLocalizedMessage());
        AppMethodBeat.o(241185);
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
    AppMethodBeat.o(241185);
    return paramArrayOfByte;
  }
  
  public final String bQE()
  {
    AppMethodBeat.i(241190);
    if ((bQH()) && (!bQF()))
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed");
      AppMethodBeat.o(241190);
      return "";
    }
    String str = this.pnA;
    AppMethodBeat.o(241190);
    return str;
  }
  
  public final int bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241189);
    try
    {
      int i = UtilsJni.ecdsaVerifyWithOctKey(this.pnA.getBytes(StandardCharsets.ISO_8859_1), paramString1.getBytes(StandardCharsets.ISO_8859_1), paramString2.getBytes(StandardCharsets.ISO_8859_1));
      Log.d("CgiSignerPublicAndPrivateKey", "verify result ".concat(String.valueOf(i)));
      AppMethodBeat.o(241189);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "verify failed " + paramString1.getLocalizedMessage());
      AppMethodBeat.o(241189);
    }
    return -1;
  }
  
  public static class a
  {
    public String pnA = "";
    public String pnz = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */