package com.tencent.mm.plugin.finder.presenter.base;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16})
public final class c$a
{
  public static <T> Resources a(c<T> paramc)
  {
    AppMethodBeat.i(166483);
    paramc = paramc.getActivity().getResources();
    if (paramc == null) {
      k.fOy();
    }
    AppMethodBeat.o(166483);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.base.c.a
 * JD-Core Version:    0.7.0.1
 */