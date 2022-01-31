package com.tencent.mm.cc;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class g
{
  SparseIntArray yjC;
  byte[] yjD;
  
  private g(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.yjC = paramSparseIntArray;
    this.yjD = paramArrayOfByte;
  }
  
  public static g a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(105934);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ab.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new g(paramSparseIntArray, arrayOfByte);
      AppMethodBeat.o(105934);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      ab.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bo.l(paramSparseIntArray) });
      AppMethodBeat.o(105934);
    }
    return null;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(105935);
    for (;;)
    {
      try
      {
        paramInt = this.yjC.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          AppMethodBeat.o(105935);
          return null;
        }
        i = this.yjC.valueAt(paramInt);
        if (paramInt >= this.yjC.size() - 1) {
          continue;
        }
        paramInt = this.yjC.valueAt(paramInt + 1) - i;
        str = new String(this.yjD, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        ab.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bo.l(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bo.l(localException) });
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(105935);
      return str;
      paramInt = this.yjD.length;
      paramInt -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.g
 * JD-Core Version:    0.7.0.1
 */