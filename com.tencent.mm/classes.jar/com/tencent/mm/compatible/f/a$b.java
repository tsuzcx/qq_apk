package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class a$b
{
  public int erZ;
  SparseArray<String> esa;
  public String esb;
  public String model;
  public String version;
  
  public final String toString()
  {
    AppMethodBeat.i(93040);
    String str = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[] { this.esb, this.model, this.version, this.esa, Integer.valueOf(this.erZ) });
    AppMethodBeat.o(93040);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a.b
 * JD-Core Version:    0.7.0.1
 */