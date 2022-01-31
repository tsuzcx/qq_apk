package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;

public final class b
{
  public byte[] mData;
  public SparseArray<a> uaW;
  
  private b(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    this.uaW = paramSparseArray;
    this.mData = paramArrayOfByte;
  }
  
  public static b a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        y.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new b(paramSparseArray, arrayOfByte);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      y.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bk.j(paramSparseArray) });
    }
    return null;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        int j = this.uaW.indexOfKey(paramInt1);
        if (j < 0) {
          return null;
        }
        localObject = (a)this.uaW.valueAt(j);
        k = ((a)localObject).uaY.length;
        paramInt1 = 0;
        i = 0;
        if (paramInt1 < k)
        {
          if (localObject.uaY[paramInt1] != paramInt2) {
            break label326;
          }
          i = paramInt1;
          break label332;
        }
        if (j <= this.uaW.size() - 1) {
          if (i >= k - 1)
          {
            a locala = (a)this.uaW.valueAt(j + 1);
            localObject = new String(this.mData, localObject.uaZ[i], locala.uaZ[0] - localObject.uaZ[i]);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        int k;
        int i;
        localObject = null;
        y.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", new Object[] { bk.j(paramVarArgs) });
        return localObject;
      }
      try
      {
        if ((!bk.bl((String)localObject)) && (paramVarArgs == null)) {
          break label329;
        }
        paramVarArgs = String.format((String)localObject, paramVarArgs);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        continue;
      }
      Object localObject = new String(this.mData, localObject.uaZ[i], localObject.uaZ[(i + 1)] - localObject.uaZ[i]);
      continue;
      if (i >= k - 1)
      {
        localObject = new String(this.mData, localObject.uaZ[i], this.mData.length - localObject.uaZ[i]);
      }
      else
      {
        localObject = new String(this.mData, localObject.uaZ[i], localObject.uaZ[(i + 1)] - localObject.uaZ[i]);
        continue;
        label326:
        break label332;
        label329:
        return localObject;
        label332:
        paramInt1 += 1;
      }
    }
  }
  
  static final class a
  {
    public final int uaX;
    public final int[] uaY;
    public final int[] uaZ;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.uaX = paramInt;
      this.uaY = paramArrayOfInt1;
      this.uaZ = paramArrayOfInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.b
 * JD-Core Version:    0.7.0.1
 */