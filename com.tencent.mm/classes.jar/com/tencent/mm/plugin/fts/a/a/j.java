package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class j
{
  public int bpE;
  public i mPi;
  public g mRX;
  public a mSV;
  public List<l> mSW;
  
  public j(i parami)
  {
    AppMethodBeat.i(114272);
    this.mSW = new ArrayList();
    this.mPi = parami;
    AppMethodBeat.o(114272);
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(114273);
    int j = this.bpE;
    if (this.mSW == null) {}
    for (;;)
    {
      String str = String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(114273);
      return str;
      i = this.mSW.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.j
 * JD-Core Version:    0.7.0.1
 */