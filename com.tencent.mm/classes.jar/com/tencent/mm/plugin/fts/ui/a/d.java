package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;

public final class d
  extends m
{
  public x sCD;
  public CharSequence sDV;
  private a sDW;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.sDW = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.jPN.talker);
    if (localai == null) {
      parama = com.tencent.mm.plugin.fts.a.d.acr(this.jPN.sxG);
    }
    for (;;)
    {
      if (!bs.isNullOrNil(parama)) {
        this.sDV = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, parama, b.c.sBG);
      }
      AppMethodBeat.o(112061);
      return;
      if (bs.isNullOrNil(localai.field_conRemark))
      {
        if (this.sCD != null)
        {
          paramVarArgs = this.sCD.wk(this.jPN.talker);
          parama = paramVarArgs;
          if (bs.isNullOrNil(paramVarArgs)) {
            parama = localai.field_nickname;
          }
        }
        else
        {
          parama = localai.field_nickname;
        }
      }
      else {
        parama = localai.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sDW;
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
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, d.this.szt);
      if (bs.isNullOrNil(paramContext.jPN.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, paramContext.jPN.sxG);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.sDV, parama.fuZ);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.gIg, parama.fAy);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.sEO, parama.fAz);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, paramContext.jPN.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */