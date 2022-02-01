package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;

public final class d
  extends m
{
  public w rtK;
  public CharSequence rvd;
  private a rve;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.rve = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.jpy.talker);
    if (localaf == null) {
      parama = com.tencent.mm.plugin.fts.a.d.XV(this.jpy.roN);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(parama)) {
        this.rvd = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, parama, b.c.rsM);
      }
      AppMethodBeat.o(112061);
      return;
      if (bt.isNullOrNil(localaf.field_conRemark))
      {
        if (this.rtK != null)
        {
          paramVarArgs = this.rtK.sh(this.jpy.talker);
          parama = paramVarArgs;
          if (bt.isNullOrNil(paramVarArgs)) {
            parama = localaf.field_nickname;
          }
        }
        else
        {
          parama = localaf.field_nickname;
        }
      }
      else {
        parama = localaf.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rve;
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
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, d.this.rqz);
      if (bt.isNullOrNil(paramContext.jpy.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, paramContext.jpy.roN);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.rvd, parama.frs);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.ibX, parama.fwR);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.rvW, parama.fwS);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, paramContext.jpy.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */