package com.tencent.mm.cj;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class i
{
  SparseIntArray URd;
  byte[] URe;
  
  private i(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.URd = paramSparseIntArray;
    this.URe = paramArrayOfByte;
  }
  
  public static i a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141264);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        Log.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new i(paramSparseIntArray, arrayOfByte);
      AppMethodBeat.o(141264);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      Log.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { Util.stackTraceToString(paramSparseIntArray) });
      AppMethodBeat.o(141264);
    }
    return null;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(141265);
    for (;;)
    {
      try
      {
        paramInt = this.URd.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          AppMethodBeat.o(141265);
          return null;
        }
        i = this.URd.valueAt(paramInt);
        if (paramInt >= this.URd.size() - 1) {
          continue;
        }
        paramInt = this.URd.valueAt(paramInt + 1) - i;
        str = new String(this.URe, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        Log.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { Util.stackTraceToString(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { Util.stackTraceToString(localException) });
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(141265);
      return str;
      paramInt = this.URe.length;
      paramInt -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cj.i
 * JD-Core Version:    0.7.0.1
 */