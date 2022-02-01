package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;

public final class d
{
  public SparseArray<a> NDr;
  public byte[] mData;
  
  private d(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.NDr = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static d a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141240);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        Log.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new d(paramSparseArray, arrayOfByte);
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
      j = this.NDr.indexOfKey(paramInt1);
      if (j < 0)
      {
        AppMethodBeat.o(141241);
        return null;
      }
      localObject1 = (a)this.NDr.valueAt(j);
      k = ((a)localObject1).NDt.length;
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
      if (localObject1.NDt[paramInt1] == paramInt2) {
        i = paramInt1;
      }
    }
    else
    {
      if (j <= this.NDr.size() - 1) {
        if (i >= k - 1)
        {
          localObject2 = (a)this.NDr.valueAt(j + 1);
          localObject1 = new String(this.mData, localObject1.NDu[i], localObject2.NDu[0] - localObject1.NDu[i]);
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
        localObject1 = new String(this.mData, localObject1.NDu[i], localObject1.NDu[(i + 1)] - localObject1.NDu[i]);
        continue;
        if (i >= k - 1) {
          localObject1 = new String(this.mData, localObject1.NDu[i], this.mData.length - localObject1.NDu[i]);
        } else {
          localObject1 = new String(this.mData, localObject1.NDu[i], localObject1.NDu[(i + 1)] - localObject1.NDu[i]);
        }
      }
    }
  }
  
  static final class a
  {
    public final int NDs;
    public final int[] NDt;
    public final int[] NDu;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.NDs = paramInt;
      this.NDt = paramArrayOfInt1;
      this.NDu = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.d
 * JD-Core Version:    0.7.0.1
 */