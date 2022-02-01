package com.google.android.exoplayer2.source.dash.manifest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a
{
  public final List<g> bnK;
  public final List<d> bnL;
  public final List<d> bnM;
  public final int id;
  public final int type;
  
  public a(int paramInt1, int paramInt2, List<g> paramList, List<d> paramList1, List<d> paramList2)
  {
    AppMethodBeat.i(10515);
    this.id = paramInt1;
    this.type = paramInt2;
    this.bnK = Collections.unmodifiableList(paramList);
    this.bnL = Collections.unmodifiableList(paramList1);
    this.bnM = Collections.unmodifiableList(paramList2);
    AppMethodBeat.o(10515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.a
 * JD-Core Version:    0.7.0.1
 */