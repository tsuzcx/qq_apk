package com.tencent.mm.ce;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class h
{
  SparseIntArray ENd;
  byte[] ENe;
  
  private h(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.ENd = paramSparseIntArray;
    this.ENe = paramArrayOfByte;
  }
  
  public static h a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(141264);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        ad.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new h(paramSparseIntArray, arrayOfByte);
      AppMethodBeat.o(141264);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      ad.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bt.m(paramSparseIntArray) });
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
        paramInt = this.ENd.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          AppMethodBeat.o(141265);
          return null;
        }
        i = this.ENd.valueAt(paramInt);
        if (paramInt >= this.ENd.size() - 1) {
          continue;
        }
        paramInt = this.ENd.valueAt(paramInt + 1) - i;
        str = new String(this.ENe, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        ad.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bt.m(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bt.m(localException) });
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(141265);
      return str;
      paramInt = this.ENe.length;
      paramInt -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.h
 * JD-Core Version:    0.7.0.1
 */