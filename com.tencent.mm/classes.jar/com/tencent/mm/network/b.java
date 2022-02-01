package com.tencent.mm.network;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class b
{
  private static b mui;
  public dpr mue;
  public String muf;
  private String mug;
  private long muh;
  
  static
  {
    AppMethodBeat.i(198019);
    mui = new b();
    AppMethodBeat.o(198019);
  }
  
  private b()
  {
    AppMethodBeat.i(197958);
    this.mue = new dpr();
    this.muf = "";
    this.mug = "";
    this.muh = 0L;
    AppMethodBeat.o(197958);
  }
  
  public static b bsU()
  {
    return mui;
  }
  
  private boolean bsW()
  {
    boolean bool = true;
    AppMethodBeat.i(198010);
    byte[][] arrayOfByte = UtilsJni.ecdsaGeneralOctKeyPair();
    if ((arrayOfByte == null) || (arrayOfByte.length == 0) || (arrayOfByte.length == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder("gen keypair failed ");
      if (arrayOfByte == null) {}
      for (;;)
      {
        Log.w("CgiSignerPublicAndPrivateKey", bool);
        AppMethodBeat.o(198010);
        return false;
        bool = false;
      }
    }
    try
    {
      this.mug = new String(arrayOfByte[0], StandardCharsets.ISO_8859_1);
      this.muf = new String(arrayOfByte[1], StandardCharsets.ISO_8859_1);
      if (!bsX())
      {
        Log.e("CgiSignerPublicAndPrivateKey", "public or private key is empty, public key is empty: " + TextUtils.isEmpty(this.mug) + ", private key is empty: " + TextUtils.isEmpty(this.muf));
        AppMethodBeat.o(198010);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed: " + localException.getLocalizedMessage());
      AppMethodBeat.o(198010);
      return false;
    }
    Log.i("CgiSignerPublicAndPrivateKey", "public key length " + this.mug.length() + " private key length " + this.muf.length());
    this.muh = System.currentTimeMillis();
    this.mue.RMR = new eae().dc(this.mug.getBytes(StandardCharsets.ISO_8859_1));
    this.mue.Stl = 415;
    AppMethodBeat.o(198010);
    return true;
  }
  
  private boolean bsX()
  {
    AppMethodBeat.i(198017);
    if ((!TextUtils.isEmpty(this.mug)) && (!TextUtils.isEmpty(this.muf)))
    {
      AppMethodBeat.o(198017);
      return true;
    }
    AppMethodBeat.o(198017);
    return false;
  }
  
  private boolean bsY()
  {
    AppMethodBeat.i(198018);
    if (System.currentTimeMillis() - this.muh > 86400000L)
    {
      AppMethodBeat.o(198018);
      return true;
    }
    if (!bsX())
    {
      AppMethodBeat.o(198018);
      return true;
    }
    AppMethodBeat.o(198018);
    return false;
  }
  
  public final String Zo(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(197978);
    if (TextUtils.isEmpty(this.muf)) {}
    for (;;)
    {
      try
      {
        arrayOfString = h.aHF().kcd.lCD.biA();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.mug = arrayOfString[0];
          this.muf = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.mug.length() + " " + this.muf.length());
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
        paramString = UtilsJni.ecdsaSignWithOctKey(this.muf.getBytes(StandardCharsets.ISO_8859_1), paramString.getBytes(StandardCharsets.ISO_8859_1));
        if (paramString != null) {
          break label254;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(197978);
        return "";
      }
      catch (Exception paramString)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data failed " + paramString.getLocalizedMessage());
        AppMethodBeat.o(197978);
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
    AppMethodBeat.o(197978);
    return paramString;
  }
  
  public final byte[] aK(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(197997);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(197997);
      return null;
    }
    if (TextUtils.isEmpty(this.muf)) {}
    for (;;)
    {
      try
      {
        arrayOfString = h.aHF().kcd.lCD.biA();
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          this.mug = arrayOfString[0];
          this.muf = arrayOfString[1];
          Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.mug.length() + " " + this.muf.length());
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
        paramArrayOfByte = UtilsJni.ecdsaSignWithOctKey(this.muf.getBytes(StandardCharsets.ISO_8859_1), paramArrayOfByte);
        if (paramArrayOfByte != null) {
          break label257;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
        AppMethodBeat.o(197997);
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("CgiSignerPublicAndPrivateKey", "sign data byte failed " + paramArrayOfByte.getLocalizedMessage());
        AppMethodBeat.o(197997);
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
    AppMethodBeat.o(197997);
    return paramArrayOfByte;
  }
  
  public final int bO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198000);
    try
    {
      int i = UtilsJni.ecdsaVerifyWithOctKey(this.mug.getBytes(StandardCharsets.ISO_8859_1), paramString1.getBytes(StandardCharsets.ISO_8859_1), paramString2.getBytes(StandardCharsets.ISO_8859_1));
      Log.d("CgiSignerPublicAndPrivateKey", "verify result ".concat(String.valueOf(i)));
      AppMethodBeat.o(198000);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.e("CgiSignerPublicAndPrivateKey", "verify failed " + paramString1.getLocalizedMessage());
      AppMethodBeat.o(198000);
    }
    return -1;
  }
  
  public final String bsV()
  {
    AppMethodBeat.i(198002);
    if ((bsY()) && (!bsW()))
    {
      Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed");
      AppMethodBeat.o(198002);
      return "";
    }
    String str = this.mug;
    AppMethodBeat.o(198002);
    return str;
  }
  
  public static class a
  {
    public String muf = "";
    public String mug = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.b
 * JD-Core Version:    0.7.0.1
 */