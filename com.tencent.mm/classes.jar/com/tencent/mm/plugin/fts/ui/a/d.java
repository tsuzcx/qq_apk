package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;

public final class d
  extends m
{
  public u kBd;
  public CharSequence kCI;
  private d.a kCJ = new d.a(this);
  
  public d(int paramInt)
  {
    super(paramInt);
  }
  
  public final a.b BD()
  {
    return this.kCJ;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    super.a(paramContext, parama, paramVarArgs);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.fYx.talker);
    if (localad == null) {
      parama = com.tencent.mm.plugin.fts.a.d.Cy(this.fYx.kwg);
    }
    for (;;)
    {
      if (!bk.bl(parama)) {
        this.kCI = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, b.c.kAf);
      }
      return;
      if (bk.bl(localad.field_conRemark))
      {
        if (this.kBd != null)
        {
          paramVarArgs = this.kBd.gV(this.fYx.talker);
          parama = paramVarArgs;
          if (bk.bl(paramVarArgs)) {
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