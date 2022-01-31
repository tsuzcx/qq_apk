package com.tencent.mm.plugin.fts.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.List;

public final class e$a
{
  public int businessType = 0;
  public g mRX = null;
  public int mTA = 2147483647;
  public boolean mTB = false;
  public List<l> mTC = null;
  public boolean mTD = true;
  public l mTE;
  public int mTF = 0;
  public int mTy = 2147483647;
  public boolean mTz = true;
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(114298);
    int j = this.mTy;
    boolean bool1 = this.mTz;
    int k = this.mTA;
    boolean bool2 = this.mTB;
    int m = this.businessType;
    if (this.mTC == null) {}
    for (;;)
    {
      String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.mTF) });
      AppMethodBeat.o(114298);
      return str;
      i = this.mTC.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e.a
 * JD-Core Version:    0.7.0.1
 */