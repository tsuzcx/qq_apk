package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class a$a
{
  public String bYA;
  public int erX;
  public int erY;
  public int erZ;
  SparseArray<String> esa;
  
  public final String toString()
  {
    AppMethodBeat.i(93039);
    String str = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[] { this.bYA, Integer.valueOf(this.erX), Integer.valueOf(this.erY), this.esa, Integer.valueOf(this.erZ) });
    AppMethodBeat.o(93039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a.a
 * JD-Core Version:    0.7.0.1
 */