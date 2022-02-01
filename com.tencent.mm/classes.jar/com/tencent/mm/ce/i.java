package com.tencent.mm.ce;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;

public final class i
{
  public SparseArray<a> acmh;
  public byte[] mData;
  
  private i(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.acmh = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static i b(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141248);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        Log.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new i(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(141248);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      Log.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { Util.stackTraceToString(paramSparseArray) });
      AppMethodBeat.o(141248);
    }
    return null;
  }
  
  static final class a
  {
    public final int[] acmi;
    public final int resId;
    
    public a(int paramInt, int[] paramArrayOfInt)
    {
      this.resId = paramInt;
      this.acmi = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ce.i
 * JD-Core Version:    0.7.0.1
 */