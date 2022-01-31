package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.f;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence mYp;
  private a.b mYq;
  private a.a mYr;
  
  public a(int paramInt)
  {
    super(10, paramInt);
    AppMethodBeat.i(61970);
    this.mYq = new a.b(this);
    this.mYr = new a.a(this);
    AppMethodBeat.o(61970);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b Pr()
  {
    return this.mYq;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61971);
    this.mYp = f.a(paramContext.getResources().getString(2131300203), "", d.b(this.mRX.mSw, this.mRX.mSw)).mSp;
    AppMethodBeat.o(61971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */