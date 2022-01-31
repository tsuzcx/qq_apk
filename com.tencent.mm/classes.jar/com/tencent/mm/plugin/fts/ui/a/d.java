package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;

public final class d
  extends m
{
  public u mWV;
  public CharSequence mYE;
  private d.a mYF;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(61976);
    this.mYF = new d.a(this);
    AppMethodBeat.o(61976);
  }
  
  public final a.b Pr()
  {
    return this.mYF;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61977);
    super.a(paramContext, parama, paramVarArgs);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.hrL.talker);
    if (localad == null) {
      parama = com.tencent.mm.plugin.fts.a.d.NA(this.hrL.mRV);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(parama)) {
        this.mYE = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, parama, b.c.mVX);
      }
      AppMethodBeat.o(61977);
      return;
      if (bo.isNullOrNil(localad.field_conRemark))
      {
        if (this.mWV != null)
        {
          paramVarArgs = this.mWV.nE(this.hrL.talker);
          parama = paramVarArgs;
          if (bo.isNullOrNil(paramVarArgs)) {
            parama = localad.field_nickname;
          }
        }
        else
        {
          parama = localad.field_nickname;
        }
      }
      else {
        parama = localad.field_conRemark;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d
 * JD-Core Version:    0.7.0.1
 */