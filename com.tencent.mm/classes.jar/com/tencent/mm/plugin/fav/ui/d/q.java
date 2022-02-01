package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.and;

public final class q
  extends b
{
  public q(o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107491);
    paramView = new View(paramViewGroup.getContext());
    AppMethodBeat.o(107491);
    return paramView;
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107492);
    if (paramView != null) {
      Toast.makeText(paramView.getContext(), 2131759353, 0).show();
    }
    AppMethodBeat.o(107492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.q
 * JD-Core Version:    0.7.0.1
 */