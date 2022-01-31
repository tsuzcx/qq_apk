package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class g$2
  implements c.a
{
  byte[] gbJ;
  
  g$2(g paramg) {}
  
  public final void CO()
  {
    AppMethodBeat.i(116710);
    ab.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.gbI.stop(false);
    AppMethodBeat.o(116710);
  }
  
  public final void amM()
  {
    AppMethodBeat.i(116708);
    ab.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
    if ((g.k(this.gbI) instanceof c))
    {
      int i = e.cM(g.amL());
      try
      {
        ((c)g.k(this.gbI)).mt(i);
        AppMethodBeat.o(116708);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
        this.gbI.cL(6, -1);
      }
    }
    AppMethodBeat.o(116708);
  }
  
  public final void amN()
  {
    AppMethodBeat.i(116709);
    ab.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
    if ((g.k(this.gbI) instanceof c)) {
      try
      {
        ((c)g.k(this.gbI)).gaW.amR();
        if (!g.b(this.gbI).Fc())
        {
          this.gbI.cL(5, -1);
          AppMethodBeat.o(116709);
          return;
        }
        AppMethodBeat.o(116709);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
        this.gbI.cL(6, -1);
      }
    }
    AppMethodBeat.o(116709);
  }
  
  public final void c(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(116707);
    if (paramArrayOfShort == null)
    {
      AppMethodBeat.o(116707);
      return;
    }
    if ((this.gbJ == null) || (this.gbJ.length < paramInt * 2)) {
      this.gbJ = new byte[paramInt * 2];
    }
    int i = 0;
    while (i < paramInt)
    {
      this.gbJ[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
      this.gbJ[(i * 2 + 1)] = ((byte)((paramArrayOfShort[i] & 0xFF00) >> 8));
      i += 1;
    }
    if (g.b(this.gbI) != null) {}
    for (paramInt = g.b(this.gbI).a(new g.a(this.gbJ, paramInt * 2), 0, true);; paramInt = -1)
    {
      if (-1 == paramInt)
      {
        this.gbI.cL(4, -1);
        ab.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
        AppMethodBeat.o(116707);
        return;
      }
      g.a(this.gbI, paramInt + g.h(this.gbI));
      if ((!g.i(this.gbI)) && (g.h(this.gbI) > 200) && (!g.j(this.gbI)))
      {
        com.tencent.mm.kernel.g.RO().ac(new g.2.1(this));
        g.l(this.gbI);
      }
      AppMethodBeat.o(116707);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.2
 * JD-Core Version:    0.7.0.1
 */