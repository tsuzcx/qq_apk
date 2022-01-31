package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;

public final class d
{
  public byte[] mData;
  public SparseArray<a> ubb;
  
  private d(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.ubb = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static d b(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        y.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new d(paramSparseArray, arrayOfByte);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      y.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bk.j(paramSparseArray) });
    }
    return null;
  }
  
  static final class a
  {
    public final int kCB;
    public final int[] ubc;
    
    public a(int paramInt, int[] paramArrayOfInt)
    {
      this.kCB = paramInt;
      this.ubc = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.d
 * JD-Core Version:    0.7.0.1
 */