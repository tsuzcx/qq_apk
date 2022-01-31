package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.Collections;

public final class b
  extends com.google.android.exoplayer2.f.b
{
  private static final int aPH = t.aG("payl");
  private static final int aPI = t.aG("sttg");
  private static final int aPJ = t.aG("vttc");
  private final j aDf = new j();
  private final e.a aPK = new e.a();
  
  public b()
  {
    super("Mp4WebvttDecoder");
  }
  
  private static a a(j paramj, e.a parama, int paramInt)
  {
    parama.reset();
    while (paramInt > 0)
    {
      if (paramInt < 8) {
        throw new com.google.android.exoplayer2.f.f("Incomplete vtt cue box header found.");
      }
      int i = paramj.readInt();
      int j = paramj.readInt();
      i -= 8;
      String str = new String(paramj.data, paramj.position, i);
      paramj.dB(i);
      i = paramInt - 8 - i;
      if (j == aPI)
      {
        f.a(str, parama);
        paramInt = i;
      }
      else
      {
        paramInt = i;
        if (j == aPH)
        {
          f.a(null, str.trim(), parama, Collections.emptyList());
          paramInt = i;
        }
      }
    }
    return parama.nF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.b
 * JD-Core Version:    0.7.0.1
 */