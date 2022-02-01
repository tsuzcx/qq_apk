package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;

public final class f
  extends b
{
  private static int tlc;
  
  public f(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107454);
    tlc = a.aG(paramo.context, 2131165370);
    AppMethodBeat.o(107454);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107455);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131494130, null), paramViewGroup, paramg);
      paramViewGroup.tlo = ((ImageView)paramView.findViewById(2131300476));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup = paramViewGroup.tlo;
      int i = tlc;
      o.a(paramViewGroup, 2131690179, (aml)localObject, paramg, false, i, i);
      AppMethodBeat.o(107455);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107456);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107456);
  }
  
  public static final class a
    extends b.b
  {
    ImageView tlo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.f
 * JD-Core Version:    0.7.0.1
 */