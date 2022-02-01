package com.tencent.mm.cd;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class h
{
  SparseIntArray Gkp;
  byte[] Gkq;
  
  private h(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.Gkp = paramSparseIntArray;
    this.Gkq = paramArrayOfByte;
  }
  
  public static h a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141264);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ac.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new h(paramSparseIntArray, arrayOfByte);
      AppMethodBeat.o(141264);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      ac.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bs.m(paramSparseIntArray) });
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
        paramInt = this.Gkp.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          AppMethodBeat.o(141265);
          return null;
        }
        i = this.Gkp.valueAt(paramInt);
        if (paramInt >= this.Gkp.size() - 1) {
          continue;
        }
        paramInt = this.Gkp.valueAt(paramInt + 1) - i;
        str = new String(this.Gkq, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        ac.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bs.m(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bs.m(localException) });
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(141265);
      return str;
      paramInt = this.Gkq.length;
      paramInt -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.h
 * JD-Core Version:    0.7.0.1
 */