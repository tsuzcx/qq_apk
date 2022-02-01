package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class d
  extends m
{
  public CharSequence tAK;
  private a tAL;
  public ab tzs;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.tAL = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    am localam = ((l)g.ab(l.class)).azp().Bf(this.kjY.talker);
    if (localam == null) {
      parama = com.tencent.mm.plugin.fts.a.d.agg(this.kjY.tuh);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(parama)) {
        this.tAK = k.d(paramContext, parama, b.c.tyh);
      }
      AppMethodBeat.o(112061);
      return;
      if (bt.isNullOrNil(localam.field_conRemark))
      {
        if (this.tzs != null)
        {
          paramVarArgs = this.tzs.zf(this.kjY.talker);
          parama = paramVarArgs;
          if (bt.isNullOrNil(paramVarArgs)) {
            parama = localam.field_nickname;
          }
        }
        else
        {
          parama = localam.field_nickname;
        }
      }
      else {
        parama = localam.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tAL;
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
      n.p(parama.kke, d.this.tvU);
      if (bt.isNullOrNil(paramContext.kjY.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, paramContext.kjY.tuh);
      }
      for (;;)
      {
        n.a(paramContext.tAK, parama.fOg);
        n.a(paramContext.hbQ, parama.fTO);
        n.a(paramContext.tBG, parama.fTP);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, paramContext.kjY.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */