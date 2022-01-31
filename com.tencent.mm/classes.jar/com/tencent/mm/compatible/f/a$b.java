package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import java.util.Locale;

public final class a$b
{
  public int dzk;
  SparseArray<String> dzl;
  public String dzm;
  public String model;
  public String version;
  
  public final String toString()
  {
    return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[] { this.dzm, this.model, this.version, this.dzl, Integer.valueOf(this.dzk) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a.b
 * JD-Core Version:    0.7.0.1
 */