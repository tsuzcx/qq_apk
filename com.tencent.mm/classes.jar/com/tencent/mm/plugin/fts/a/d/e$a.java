package com.tencent.mm.plugin.fts.a.d;

import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.List;

public final class e$a
{
  public int businessType = 0;
  public g kwi = null;
  public int kxK = 2147483647;
  public boolean kxL = true;
  public int kxM = 2147483647;
  public boolean kxN = false;
  public List<l> kxO = null;
  public boolean kxP = true;
  public l kxQ;
  public int kxR = 0;
  
  public final String toString()
  {
    int i = 0;
    int j = this.kxK;
    boolean bool1 = this.kxL;
    int k = this.kxM;
    boolean bool2 = this.kxN;
    int m = this.businessType;
    if (this.kxO == null) {}
    for (;;)
    {
      return String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.kxR) });
      i = this.kxO.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e.a
 * JD-Core Version:    0.7.0.1
 */