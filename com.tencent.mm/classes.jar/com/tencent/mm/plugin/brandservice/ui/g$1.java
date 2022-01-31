package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

final class g$1
  extends a.b
{
  g$1(g paramg) {}
  
  public final void a(Context paramContext, a.a parama, a paramVarArgs) {}
  
  public final void a(View paramView, a.a parama) {}
  
  public final boolean a(Context paramContext, a parama, Object... paramVarArgs)
  {
    return true;
  }
  
  public final View c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(14055);
    View localView = paramView;
    if (paramView == null) {
      localView = new View(paramContext);
    }
    AppMethodBeat.o(14055);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g.1
 * JD-Core Version:    0.7.0.1
 */