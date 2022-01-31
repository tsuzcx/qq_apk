package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g
  extends a
{
  private static a.b jTh;
  
  public g(Object paramObject)
  {
    super(0, paramObject);
    this.zsv = true;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public final a.b aWu()
  {
    AppMethodBeat.i(14056);
    if (jTh == null) {
      jTh = new g.1(this);
    }
    a.b localb = jTh;
    AppMethodBeat.o(14056);
    return localb;
  }
  
  public final a.a aWv()
  {
    AppMethodBeat.i(14057);
    g.a locala = new g.a();
    AppMethodBeat.o(14057);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */