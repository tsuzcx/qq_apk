package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends a
{
  public String mSN;
  public boolean mZf;
  public CharSequence mZg;
  private i.b mZh;
  private i.a mZi;
  
  public i(int paramInt)
  {
    super(19, paramInt);
    AppMethodBeat.i(61998);
    this.mZh = new i.b(this);
    this.mZi = new i.a(this);
    this.mTH = false;
    AppMethodBeat.o(61998);
  }
  
  public final a.b Pr()
  {
    return this.mZh;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61999);
    parama = TextUtils.ellipsize(this.mRX.mSz[0], b.c.mVY, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.mRX.mSz[1], b.c.mVY, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bo.isNullOrNil(this.mSN))
    {
      this.mZg = TextUtils.concat(new CharSequence[] { paramContext.getString(2131303024), f.j(parama, parama.length()), paramContext.getString(2131303025), f.j(paramVarArgs, paramVarArgs.length()), paramContext.getString(2131303026) });
      AppMethodBeat.o(61999);
      return;
    }
    this.mZg = TextUtils.concat(new CharSequence[] { paramContext.getString(2131303027), f.j(parama, parama.length()), paramContext.getString(2131303025), f.j(paramVarArgs, paramVarArgs.length()), paramContext.getString(2131303026) });
    AppMethodBeat.o(61999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */