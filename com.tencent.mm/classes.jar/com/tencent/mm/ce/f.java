package com.tencent.mm.ce;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;

public final class f
{
  public SparseArray<a> acmd;
  public byte[] mData;
  
  private f(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.acmd = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static f a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141240);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        Log.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new f(paramSparseArray, arrayOfByte);
      AppMethodBeat.o(141240);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      Log.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { Util.stackTraceToString(paramSparseArray) });
      AppMethodBeat.o(141240);
    }
    return null;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141241);
    try
    {
      j = this.acmd.indexOfKey(paramInt1);
      if (j < 0)
      {
        AppMethodBeat.o(141241);
        return null;
      }
      localObject1 = (a)this.acmd.valueAt(j);
      k = ((a)localObject1).acmf.length;
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
        Log.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", new Object[] { Util.stackTraceToString(paramVarArgs) });
        Object localObject2 = localObject1;
        continue;
        paramInt1 += 1;
      }
    }
    if (paramInt1 < k)
    {
      if (localObject1.acmf[paramInt1] == paramInt2) {
        i = paramInt1;
      }
    }
    else
    {
      if (j <= this.acmd.size() - 1) {
        if (i >= k - 1)
        {
          localObject2 = (a)this.acmd.valueAt(j + 1);
          localObject1 = new String(this.mData, localObject1.acmg[i], localObject2.acmg[0] - localObject1.acmg[i]);
        }
      }
      for (;;)
      {
        try
        {
          if (!Util.isNullOrNil((String)localObject1))
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
        localObject1 = new String(this.mData, localObject1.acmg[i], localObject1.acmg[(i + 1)] - localObject1.acmg[i]);
        continue;
        if (i >= k - 1) {
          localObject1 = new String(this.mData, localObject1.acmg[i], this.mData.length - localObject1.acmg[i]);
        } else {
          localObject1 = new String(this.mData, localObject1.acmg[i], localObject1.acmg[(i + 1)] - localObject1.acmg[i]);
        }
      }
    }
  }
  
  static final class a
  {
    public final int acme;
    public final int[] acmf;
    public final int[] acmg;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.acme = paramInt;
      this.acmf = paramArrayOfInt1;
      this.acmg = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ce.f
 * JD-Core Version:    0.7.0.1
 */