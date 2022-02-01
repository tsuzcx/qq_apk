package com.tencent.mm.accessibility.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
final class ViewSetter$clickAs$1$1
  extends u
  implements b<View, Boolean>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(234397);
    INSTANCE = new 1();
    AppMethodBeat.o(234397);
  }
  
  ViewSetter$clickAs$1$1()
  {
    super(1);
  }
  
  public final Boolean invoke(View paramView)
  {
    AppMethodBeat.i(234401);
    s.u(paramView, "it");
    paramView = Boolean.TRUE;
    AppMethodBeat.o(234401);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.ViewSetter.clickAs.1.1
 * JD-Core Version:    0.7.0.1
 */