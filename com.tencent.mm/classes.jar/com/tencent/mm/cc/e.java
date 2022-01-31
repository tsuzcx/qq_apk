package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;

public final class e
{
  public byte[] mData;
  public SparseArray<a> yjr;
  
  private e(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.yjr = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static e b(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(105918);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ab.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new e(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(105918);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      ab.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bo.l(paramSparseArray) });
      AppMethodBeat.o(105918);
    }
    return null;
  }
  
  static final class a
  {
    public final int resId;
    public final int[] yjs;
    
    public a(int paramInt, int[] paramArrayOfInt)
    {
      this.resId = paramInt;
      this.yjs = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.e
 * JD-Core Version:    0.7.0.1
 */