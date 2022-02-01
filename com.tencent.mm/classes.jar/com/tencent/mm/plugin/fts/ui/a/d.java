package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class d
  extends m
{
  public ah BNi;
  public CharSequence BOA;
  private a BOB;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.BOB = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.olG.talker);
    if (localas == null) {
      parama = com.tencent.mm.plugin.fts.a.d.azM(this.olG.BHS);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(parama)) {
        this.BOA = l.d(paramContext, parama, b.c.BLW);
      }
      AppMethodBeat.o(112061);
      return;
      if (Util.isNullOrNil(localas.field_conRemark))
      {
        if (this.BNi != null)
        {
          paramVarArgs = this.BNi.PJ(this.olG.talker);
          parama = paramVarArgs;
          if (Util.isNullOrNil(paramVarArgs)) {
            parama = localas.field_nickname;
          }
        }
        else
        {
          parama = localas.field_nickname;
        }
      }
      else {
        parama = localas.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BOB;
  }
  
  public final class a
    extends m.b
  {
    public a()
    {
      super();
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112059);
      paramContext = (d)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.n.q(parama.olM, d.this.BJG);
      if (Util.isNullOrNil(paramContext.olG.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, paramContext.olG.BHS);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.n.a(paramContext.BOA, parama.iZH);
        com.tencent.mm.plugin.fts.ui.n.a(paramContext.kLX, parama.jlh);
        com.tencent.mm.plugin.fts.ui.n.a(paramContext.BPv, parama.timeTV);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, paramContext.olG.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */