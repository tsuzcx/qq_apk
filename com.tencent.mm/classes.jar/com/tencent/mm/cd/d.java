package com.tencent.mm.cd;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;

public final class d
{
  public SparseArray<a> HVM;
  public byte[] mData;
  
  private d(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.HVM = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static d a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141240);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ad.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new d(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(141240);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      ad.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bt.n(paramSparseArray) });
      AppMethodBeat.o(141240);
    }
    return null;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141241);
    try
    {
      j = this.HVM.indexOfKey(paramInt1);
      if (j < 0)
      {
        AppMethodBeat.o(141241);
        return null;
      }
      localObject1 = (a)this.HVM.valueAt(j);
      k = ((a)localObject1).HVO.length;
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
        ad.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", new Object[] { bt.n(paramVarArgs) });
        Object localObject2 = localObject1;
        continue;
        paramInt1 += 1;
      }
    }
    if (paramInt1 < k)
    {
      if (localObject1.HVO[paramInt1] == paramInt2) {
        i = paramInt1;
      }
    }
    else
    {
      if (j <= this.HVM.size() - 1) {
        if (i >= k - 1)
        {
          localObject2 = (a)this.HVM.valueAt(j + 1);
          localObject1 = new String(this.mData, localObject1.HVP[i], localObject2.HVP[0] - localObject1.HVP[i]);
        }
      }
      for (;;)
      {
        try
        {
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = localObject1;
            if (paramVarArgs == null) {}
          }
          else
          {
            localObject2 = String.format((String)localObject1, paramVarArgs);
          }
          AppMethodBeat.o(141241);
          return localObject2;
        }
        catch (Exception paramVarArgs)
        {
          continue;
        }
        localObject1 = new String(this.mData, localObject1.HVP[i], localObject1.HVP[(i + 1)] - localObject1.HVP[i]);
        continue;
        if (i >= k - 1) {
          localObject1 = new String(this.mData, localObject1.HVP[i], this.mData.length - localObject1.HVP[i]);
        } else {
          localObject1 = new String(this.mData, localObject1.HVP[i], localObject1.HVP[(i + 1)] - localObject1.HVP[i]);
        }
      }
    }
  }
  
  static final class a
  {
    public final int HVN;
    public final int[] HVO;
    public final int[] HVP;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.HVN = paramInt;
      this.HVO = paramArrayOfInt1;
      this.HVP = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.d
 * JD-Core Version:    0.7.0.1
 */