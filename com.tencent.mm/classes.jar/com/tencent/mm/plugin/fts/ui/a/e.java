package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;

public final class e
  extends k
{
  public int count;
  private e.a mYH;
  e.b mYI;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(61980);
    this.mYH = new e.a(this);
    this.mYI = new e.b(this);
    AppMethodBeat.o(61980);
  }
  
  public final a.b Pr()
  {
    return this.mYH;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61981);
    this.mZq = paramContext.getString(2131303023, new Object[] { TextUtils.ellipsize(d.NA(this.talker), b.c.mVY, 500.0F, TextUtils.TruncateAt.MIDDLE) });
    AppMethodBeat.o(61981);
  }
  
  public final a.a bCW()
  {
    return this.mYI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */