package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;

public final class l
  extends a
{
  CharSequence mZu;
  private a.b mZv;
  a.a mZw;
  
  public l(int paramInt)
  {
    super(18, paramInt);
    AppMethodBeat.i(62011);
    this.mZv = new l.b(this);
    this.mZw = new l.a(this);
    AppMethodBeat.o(62011);
  }
  
  public final a.b Pr()
  {
    return this.mZv;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62012);
    parama = TextUtils.ellipsize(this.mRX.mSw, b.c.mVY, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.mZu = f.a(paramContext.getString(2131302982), paramContext.getString(2131302981), d.b(parama, parama)).mSp;
    AppMethodBeat.o(62012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */