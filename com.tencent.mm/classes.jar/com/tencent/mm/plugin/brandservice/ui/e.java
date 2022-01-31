package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e
  extends a
{
  private static a.b jTh;
  int Fb;
  long jTl;
  String jTm;
  String jUF;
  
  public e(long paramLong, int paramInt, String paramString)
  {
    super(2, null);
    this.jTl = paramLong;
    this.jTm = paramString;
    this.Fb = paramInt;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.jUF = "";
  }
  
  public final a.b aWu()
  {
    AppMethodBeat.i(14019);
    if (jTh == null) {
      jTh = new e.1(this);
    }
    a.b localb = jTh;
    AppMethodBeat.o(14019);
    return localb;
  }
  
  public final a.a aWv()
  {
    AppMethodBeat.i(14020);
    e.a locala = new e.a();
    AppMethodBeat.o(14020);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */