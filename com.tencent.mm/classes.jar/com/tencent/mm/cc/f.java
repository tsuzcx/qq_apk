package com.tencent.mm.cc;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  SparseIntArray ubm;
  byte[] ubn;
  
  private f(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    this.ubm = paramSparseIntArray;
    this.ubn = paramArrayOfByte;
  }
  
  public static f a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        y.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new f(paramSparseIntArray, arrayOfByte);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      y.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bk.j(paramSparseIntArray) });
    }
    return null;
  }
  
  public final String getString(int paramInt)
  {
    try
    {
      paramInt = this.ubm.indexOfKey(paramInt);
      if (paramInt < 0) {
        return null;
      }
      int i = this.ubm.valueAt(paramInt);
      if (paramInt < this.ubm.size() - 1) {
        paramInt = this.ubm.valueAt(paramInt + 1) - i;
      }
      for (;;)
      {
        String str1 = new String(this.ubn, i, paramInt, "UTF-8");
        break;
        paramInt = this.ubn.length;
        paramInt -= i;
      }
      Object localObject;
      String str2;
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      y.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bk.j(localUnsupportedEncodingException) });
      localObject = null;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bk.j(localException) });
      str2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.f
 * JD-Core Version:    0.7.0.1
 */