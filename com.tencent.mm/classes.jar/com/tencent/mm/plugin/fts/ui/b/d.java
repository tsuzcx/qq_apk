package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class d
  extends m
{
  public CharSequence HAq;
  private a HAr;
  public aj Hyy;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.HAr = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    au localau = ((n)h.ax(n.class)).bzA().JE(this.rpp.talker);
    if (localau == null) {
      parama = com.tencent.mm.plugin.fts.a.d.atS(this.rpp.Hsz);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(parama)) {
        this.HAq = p.d(paramContext, parama, b.c.HwS);
      }
      AppMethodBeat.o(112061);
      return;
      if (Util.isNullOrNil(localau.field_conRemark))
      {
        if (this.Hyy != null)
        {
          paramVarArgs = this.Hyy.getDisplayName(this.rpp.talker);
          parama = paramVarArgs;
          if (Util.isNullOrNil(paramVarArgs)) {
            parama = localau.field_nickname;
          }
        }
        else
        {
          parama = localau.field_nickname;
        }
      }
      else {
        parama = localau.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HAr;
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
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, d.this.Hup);
      if (Util.isNullOrNil(paramContext.rpp.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, paramContext.rpp.Hsz);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.HAq, parama.lBD);
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.nnT, parama.lNZ);
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.HBn, parama.timeTV);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, paramContext.rpp.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.d
 * JD-Core Version:    0.7.0.1
 */