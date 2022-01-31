package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends m
{
  private g.a mYY;
  CharSequence mYZ;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(61988);
    this.mYY = new g.a(this);
    AppMethodBeat.o(61988);
  }
  
  public final a.b Pr()
  {
    return this.mYY;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61989);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.NA(this.hrL.talker);
    parama = paramVarArgs;
    if (bo.isNullOrNil(paramVarArgs)) {
      parama = d.NA(this.hrL.mRV);
    }
    this.mYZ = j.d(paramContext, parama, b.c.mVX);
    AppMethodBeat.o(61989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */