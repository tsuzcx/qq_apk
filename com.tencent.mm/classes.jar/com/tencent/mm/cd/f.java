package com.tencent.mm.cd;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;

public final class f
{
  public SparseArray<a> HVQ;
  public byte[] mData;
  
  private f(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.HVQ = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static f b(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141248);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ad.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new f(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(141248);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      ad.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bt.n(paramSparseArray) });
      AppMethodBeat.o(141248);
    }
    return null;
  }
  
  static final class a
  {
    public final int[] HVR;
    public final int resId;
    
    public a(int paramInt, int[] paramArrayOfInt)
    {
      this.resId = paramInt;
      this.HVR = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.f
 * JD-Core Version:    0.7.0.1
 */