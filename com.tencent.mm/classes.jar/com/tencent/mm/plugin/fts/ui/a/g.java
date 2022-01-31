package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
  extends m
{
  private g.a kDc = new g.a(this);
  CharSequence kDd;
  
  public g(int paramInt)
  {
    super(paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDc;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.Cy(this.fYx.talker);
    parama = paramVarArgs;
    if (bk.bl(paramVarArgs)) {
      parama = d.Cy(this.fYx.kwg);
    }
    this.kDd = j.b(paramContext, parama, b.c.kAf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */