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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class d
  extends m
{
  public ac tKj;
  public CharSequence tLB;
  private a tLC;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112060);
    this.tLC = new a();
    AppMethodBeat.o(112060);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112061);
    super.a(paramContext, parama, paramVarArgs);
    an localan = ((l)g.ab(l.class)).azF().BH(this.kno.talker);
    if (localan == null) {
      parama = com.tencent.mm.plugin.fts.a.d.ahd(this.kno.tEY);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(parama)) {
        this.tLB = k.d(paramContext, parama, b.c.tIY);
      }
      AppMethodBeat.o(112061);
      return;
      if (bu.isNullOrNil(localan.field_conRemark))
      {
        if (this.tKj != null)
        {
          paramVarArgs = this.tKj.zP(this.kno.talker);
          parama = paramVarArgs;
          if (bu.isNullOrNil(paramVarArgs)) {
            parama = localan.field_nickname;
          }
        }
        else
        {
          parama = localan.field_nickname;
        }
      }
      else {
        parama = localan.field_conRemark;
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tLC;
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
      n.p(parama.knu, d.this.tGL);
      if (bu.isNullOrNil(paramContext.kno.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, paramContext.kno.tEY);
      }
      for (;;)
      {
        n.a(paramContext.tLB, parama.fQm);
        n.a(paramContext.heE, parama.fVU);
        n.a(paramContext.tMx, parama.fVV);
        AppMethodBeat.o(112059);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, paramContext.kno.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */