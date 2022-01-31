package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;

public final class aa
{
  public static bmk I(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    bmk localbmk = new bmk();
    localbmk.bs(paramArrayOfByte);
    return localbmk;
  }
  
  public static String a(b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.coM();
  }
  
  public static String a(bml parambml)
  {
    if (parambml == null) {
      return null;
    }
    return parambml.tFO;
  }
  
  public static byte[] a(bmk parambmk)
  {
    if ((parambmk == null) || (parambmk.tFM == null)) {
      return null;
    }
    return parambmk.tFM.toByteArray();
  }
  
  public static byte[] a(bmk parambmk, byte[] paramArrayOfByte)
  {
    if ((parambmk == null) || (parambmk.tFM == null)) {
      return paramArrayOfByte;
    }
    return parambmk.tFM.toByteArray();
  }
  
  public static String b(bmk parambmk)
  {
    if ((parambmk == null) || (parambmk.tFM == null)) {
      return null;
    }
    return parambmk.tFM.coM();
  }
  
  public static bml pj(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    bml localbml = new bml();
    localbml.YI(paramString);
    return localbml;
  }
  
  public static bmk pk(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = Base64.decode(paramString, 0);
    } while (paramString == null);
    bmk localbmk = new bmk();
    localbmk.bs(paramString);
    return localbmk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.aa
 * JD-Core Version:    0.7.0.1
 */