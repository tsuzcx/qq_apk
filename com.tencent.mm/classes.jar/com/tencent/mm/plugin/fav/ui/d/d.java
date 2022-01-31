package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acs;

public final class d
  extends a
{
  private static int mDa;
  
  public d(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74620);
    mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427653);
    AppMethodBeat.o(74620);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74621);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new d.a();
      paramView = a(View.inflate((Context)localObject, 2130969544, null), paramViewGroup, paramg);
      paramViewGroup.mDc = ((ImageView)paramView.findViewById(2131824033));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      paramViewGroup = paramViewGroup.mDc;
      int i = mDa;
      l.a(paramViewGroup, (aca)localObject, paramg, false, i, i);
      AppMethodBeat.o(74621);
      return paramView;
      paramViewGroup = (d.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74622);
    d.a locala = (d.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.d
 * JD-Core Version:    0.7.0.1
 */