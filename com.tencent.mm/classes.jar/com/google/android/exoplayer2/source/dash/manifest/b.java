package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  public final long bnN;
  public final long bnO;
  public final boolean bnP;
  public final long bnQ;
  public final long bnR;
  public final long bnS;
  public final k bnT;
  public final Uri bnU;
  private final List<e> bnV;
  public final long duration;
  
  public b(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4, long paramLong5, long paramLong6, k paramk, Uri paramUri, List<e> paramList)
  {
    this.bnN = paramLong1;
    this.duration = paramLong2;
    this.bnO = paramLong3;
    this.bnP = paramBoolean;
    this.bnQ = paramLong4;
    this.bnR = paramLong5;
    this.bnS = paramLong6;
    this.bnT = paramk;
    this.bnU = paramUri;
    this.bnV = paramList;
  }
  
  private long eM(int paramInt)
  {
    AppMethodBeat.i(10518);
    if (paramInt == this.bnV.size() - 1)
    {
      if (this.duration == -9223372036854775807L)
      {
        AppMethodBeat.o(10518);
        return -9223372036854775807L;
      }
      l1 = this.duration;
      l2 = ((e)this.bnV.get(paramInt)).bof;
      AppMethodBeat.o(10518);
      return l1 - l2;
    }
    long l1 = ((e)this.bnV.get(paramInt + 1)).bof;
    long l2 = ((e)this.bnV.get(paramInt)).bof;
    AppMethodBeat.o(10518);
    return l1 - l2;
  }
  
  public final e eL(int paramInt)
  {
    AppMethodBeat.i(10517);
    e locale = (e)this.bnV.get(paramInt);
    AppMethodBeat.o(10517);
    return locale;
  }
  
  public final long eN(int paramInt)
  {
    AppMethodBeat.i(10519);
    long l = com.google.android.exoplayer2.b.u(eM(paramInt));
    AppMethodBeat.o(10519);
    return l;
  }
  
  public final int rQ()
  {
    AppMethodBeat.i(10516);
    int i = this.bnV.size();
    AppMethodBeat.o(10516);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.b
 * JD-Core Version:    0.7.0.1
 */