package com.tencent.mm.cc;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class h
{
  SparseIntArray Iqj;
  byte[] Iqk;
  
  private h(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.Iqj = paramSparseIntArray;
    this.Iqk = paramArrayOfByte;
  }
  
  public static h a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141264);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ae.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new h(paramSparseIntArray, arrayOfByte);
      AppMethodBeat.o(141264);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      ae.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bu.o(paramSparseIntArray) });
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
        paramInt = this.Iqj.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          AppMethodBeat.o(141265);
          return null;
        }
        i = this.Iqj.valueAt(paramInt);
        if (paramInt >= this.Iqj.size() - 1) {
          continue;
        }
        paramInt = this.Iqj.valueAt(paramInt + 1) - i;
        str = new String(this.Iqk, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        ae.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bu.o(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bu.o(localException) });
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(141265);
      return str;
      paramInt = this.Iqk.length;
      paramInt -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.h
 * JD-Core Version:    0.7.0.1
 */