package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;

public final class c
{
  public byte[] mData;
  public SparseArray<a> yjm;
  
  private c(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.yjm = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static c a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(105910);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ab.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new c(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(105910);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      ab.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bo.l(paramSparseArray) });
      AppMethodBeat.o(105910);
    }
    return null;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(105911);
    try
    {
      j = this.yjm.indexOfKey(paramInt1);
      if (j < 0)
      {
        AppMethodBeat.o(105911);
        return null;
      }
      localObject1 = (a)this.yjm.valueAt(j);
      k = ((a)localObject1).yjo.length;
      paramInt1 = 0;
      i = 0;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        int j;
        int k;
        int i;
        Object localObject1 = null;
        ab.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", new Object[] { bo.l(paramVarArgs) });
        Object localObject2 = localObject1;
        continue;
        paramInt1 += 1;
      }
    }
    if (paramInt1 < k)
    {
      if (localObject1.yjo[paramInt1] == paramInt2) {
        i = paramInt1;
      }
    }
    else
    {
      if (j <= this.yjm.size() - 1) {
        if (i >= k - 1)
        {
          localObject2 = (a)this.yjm.valueAt(j + 1);
          localObject1 = new String(this.mData, localObject1.yjp[i], localObject2.yjp[0] - localObject1.yjp[i]);
        }
      }
      for (;;)
      {
        try
        {
          if (!bo.isNullOrNil((String)localObject1))
          {
            localObject2 = localObject1;
            if (paramVarArgs == null) {}
          }
          else
          {
            localObject2 = String.format((String)localObject1, paramVarArgs);
          }
          AppMethodBeat.o(105911);
          return localObject2;
        }
        catch (Exception paramVarArgs)
        {
          continue;
        }
        localObject1 = new String(this.mData, localObject1.yjp[i], localObject1.yjp[(i + 1)] - localObject1.yjp[i]);
        continue;
        if (i >= k - 1) {
          localObject1 = new String(this.mData, localObject1.yjp[i], this.mData.length - localObject1.yjp[i]);
        } else {
          localObject1 = new String(this.mData, localObject1.yjp[i], localObject1.yjp[(i + 1)] - localObject1.yjp[i]);
        }
      }
    }
  }
  
  static final class a
  {
    public final int yjn;
    public final int[] yjo;
    public final int[] yjp;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.yjn = paramInt;
      this.yjo = paramArrayOfInt1;
      this.yjp = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.c
 * JD-Core Version:    0.7.0.1
 */