package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class d
  extends m
{
  public ah xbi;
  public CharSequence xcC;
  private a xcD;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.xcD = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.lqW.talker);
    if (localas == null) {
      parama = com.tencent.mm.plugin.fts.a.d.arL(this.lqW.wVX);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(parama)) {
        this.xcC = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, parama, b.c.wZX);
      }
      AppMethodBeat.o(112061);
      return;
      if (Util.isNullOrNil(localas.field_conRemark))
      {
        if (this.xbi != null)
        {
          paramVarArgs = this.xbi.getDisplayName(this.lqW.talker);
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xcD;
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
      n.q(parama.lrc, d.this.wXK);
      if (Util.isNullOrNil(paramContext.lqW.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, paramContext.lqW.wVX);
      }
      for (;;)
      {
        n.a(paramContext.xcC, parama.gvw);
        n.a(paramContext.hXr, parama.gBb);
        n.a(paramContext.xdx, parama.timeTV);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, paramContext.lqW.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */