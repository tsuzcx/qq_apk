package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class b
  extends com.google.android.exoplayer2.f.b
{
  private static final int bve;
  private static final int bvf;
  private static final int bvg;
  private final m bfp;
  private final e.a bvh;
  
  static
  {
    AppMethodBeat.i(92887);
    bve = x.aY("payl");
    bvf = x.aY("sttg");
    bvg = x.aY("vttc");
    AppMethodBeat.o(92887);
  }
  
  public b()
  {
    super("Mp4WebvttDecoder");
    AppMethodBeat.i(92884);
    this.bfp = new m();
    this.bvh = new e.a();
    AppMethodBeat.o(92884);
  }
  
  private static a a(m paramm, e.a parama, int paramInt)
  {
    AppMethodBeat.i(92885);
    parama.reset();
    while (paramInt > 0)
    {
      if (paramInt < 8)
      {
        paramm = new com.google.android.exoplayer2.f.f("Incomplete vtt cue box header found.");
        AppMethodBeat.o(92885);
        throw paramm;
      }
      int i = paramm.readInt();
      int j = paramm.readInt();
      i -= 8;
      String str = new String(paramm.data, paramm.position, i);
      paramm.fl(i);
      i = paramInt - 8 - i;
      if (j == bvf)
      {
        f.a(str, parama);
        paramInt = i;
      }
      else
      {
        paramInt = i;
        if (j == bve)
        {
          f.a(null, str.trim(), parama, Collections.emptyList());
          paramInt = i;
        }
      }
    }
    paramm = parama.uX();
    AppMethodBeat.o(92885);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.b
 * JD-Core Version:    0.7.0.1
 */