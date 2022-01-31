package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class d$a
  extends m.b
{
  public d$a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61975);
    paramContext = (d)parama1;
    parama = (m.a)parama;
    m.p(parama.hrR, this.mYG.mTH);
    if (bo.isNullOrNil(paramContext.hrL.talker)) {
      a.b.c(parama.egq, paramContext.hrL.mRV);
    }
    for (;;)
    {
      m.a(paramContext.mYE, parama.egr);
      m.a(paramContext.gpI, parama.ekg);
      m.a(paramContext.mZz, parama.ekh);
      AppMethodBeat.o(61975);
      return;
      a.b.c(parama.egq, paramContext.hrL.talker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d.a
 * JD-Core Version:    0.7.0.1
 */