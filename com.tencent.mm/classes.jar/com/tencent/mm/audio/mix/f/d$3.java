package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.m;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.t.a;
import java.util.HashMap;

final class d$3
  implements m
{
  d$3(d paramd) {}
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(137170);
    int j = paramt.cmZ.action;
    int i;
    if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
      i = 1;
    }
    while (i == 0)
    {
      if (!this.chN.chy.containsKey(paramt.cmZ.ceu)) {
        break label178;
      }
      ??? = (e)this.chN.chy.get(paramt.cmZ.ceu);
      if (??? != null) {
        if (((e)???).g(new Integer[] { Integer.valueOf(j) }))
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
          AppMethodBeat.o(137170);
          return;
          i = 0;
          continue;
        }
      }
      if (??? != null)
      {
        ((e)???).ab(Integer.valueOf(j));
        this.chN.chy.put(paramt.cmZ.ceu, ???);
      }
    }
    while (this.chN.cht == null)
    {
      AppMethodBeat.o(137170);
      return;
      label178:
      synchronized (this.chN.chq)
      {
        e locale = new e(Integer.valueOf(j));
        this.chN.chy.put(paramt.cmZ.ceu, locale);
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramt.cmZ.ceu, paramt.cmZ.state });
    if (j == 9)
    {
      this.chN.cht.b(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 7)
    {
      this.chN.cht.c(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 0)
    {
      this.chN.cht.d(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 1)
    {
      this.chN.cht.d(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 2)
    {
      this.chN.cht.e(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 3)
    {
      this.chN.chx.put(paramt.cmZ.ceu, Boolean.FALSE);
      this.chN.cht.f(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 5)
    {
      this.chN.chx.put(paramt.cmZ.ceu, Boolean.FALSE);
      this.chN.cht.g(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 4)
    {
      this.chN.chx.put(paramt.cmZ.ceu, Boolean.FALSE);
      this.chN.cht.j(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 10)
    {
      this.chN.cht.h(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 6)
    {
      this.chN.cht.i(paramt);
      AppMethodBeat.o(137170);
      return;
    }
    if (j == 11) {
      this.chN.cht.k(paramt);
    }
    AppMethodBeat.o(137170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d.3
 * JD-Core Version:    0.7.0.1
 */