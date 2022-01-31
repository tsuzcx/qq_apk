package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class b
  extends com.google.android.exoplayer2.f.b
{
  private static final int aXb;
  private static final int aXc;
  private static final int aXd;
  private final m aJR;
  private final e.a aXe;
  
  static
  {
    AppMethodBeat.i(95719);
    aXb = x.aS("payl");
    aXc = x.aS("sttg");
    aXd = x.aS("vttc");
    AppMethodBeat.o(95719);
  }
  
  public b()
  {
    super("Mp4WebvttDecoder");
    AppMethodBeat.i(95716);
    this.aJR = new m();
    this.aXe = new e.a();
    AppMethodBeat.o(95716);
  }
  
  private static a a(m paramm, e.a parama, int paramInt)
  {
    AppMethodBeat.i(95717);
    parama.reset();
    while (paramInt > 0)
    {
      if (paramInt < 8)
      {
        paramm = new com.google.android.exoplayer2.f.f("Incomplete vtt cue box header found.");
        AppMethodBeat.o(95717);
        throw paramm;
      }
      int i = paramm.readInt();
      int j = paramm.readInt();
      i -= 8;
      String str = new String(paramm.data, paramm.position, i);
      paramm.en(i);
      i = paramInt - 8 - i;
      if (j == aXc)
      {
        f.a(str, parama);
        paramInt = i;
      }
      else
      {
        paramInt = i;
        if (j == aXb)
        {
          f.a(null, str.trim(), parama, Collections.emptyList());
          paramInt = i;
        }
      }
    }
    paramm = parama.qd();
    AppMethodBeat.o(95717);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.b
 * JD-Core Version:    0.7.0.1
 */