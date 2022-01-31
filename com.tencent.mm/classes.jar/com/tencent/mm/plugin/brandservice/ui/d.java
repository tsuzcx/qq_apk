package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d
  extends a
{
  private static a.b jTh;
  String jTi;
  
  public d(Object paramObject)
  {
    super(1, paramObject);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    if ((this.data instanceof String)) {
      this.jTi = ((String)this.data);
    }
  }
  
  public final a.b aWu()
  {
    AppMethodBeat.i(13940);
    if (jTh == null) {
      jTh = new d.1(this);
    }
    a.b localb = jTh;
    AppMethodBeat.o(13940);
    return localb;
  }
  
  public final a.a aWv()
  {
    AppMethodBeat.i(13941);
    d.a locala = new d.a();
    AppMethodBeat.o(13941);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.d
 * JD-Core Version:    0.7.0.1
 */