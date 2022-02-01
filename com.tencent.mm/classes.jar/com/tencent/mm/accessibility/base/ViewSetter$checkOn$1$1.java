package com.tencent.mm.accessibility.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
final class ViewSetter$checkOn$1$1
  extends u
  implements b<View, Boolean>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(234412);
    INSTANCE = new 1();
    AppMethodBeat.o(234412);
  }
  
  ViewSetter$checkOn$1$1()
  {
    super(1);
  }
  
  public final Boolean invoke(View paramView)
  {
    AppMethodBeat.i(234420);
    s.u(paramView, "it");
    paramView = Boolean.TRUE;
    AppMethodBeat.o(234420);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.ViewSetter.checkOn.1.1
 * JD-Core Version:    0.7.0.1
 */