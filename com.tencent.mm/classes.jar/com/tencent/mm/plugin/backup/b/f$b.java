package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b
  implements Cloneable, Comparable<b>
{
  public long mSA = 0L;
  public long mSB = 0L;
  public long mSC = -1L;
  public long mSD = -1L;
  public String mSz;
  
  public final b bCZ()
  {
    AppMethodBeat.i(21166);
    b localb = new b();
    localb.mSz = this.mSz;
    localb.mSA = this.mSA;
    localb.mSB = this.mSB;
    localb.mSC = this.mSC;
    localb.mSD = this.mSD;
    AppMethodBeat.o(21166);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.f.b
 * JD-Core Version:    0.7.0.1
 */