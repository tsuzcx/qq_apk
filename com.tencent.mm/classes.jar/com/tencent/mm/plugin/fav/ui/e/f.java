package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akf;

public final class f
  extends b
{
  private static int rDf;
  
  public f(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107454);
    rDf = a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107454);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107455);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493961, null), paramViewGroup, paramg);
      paramViewGroup.rDr = ((ImageView)paramView.findViewById(2131299801));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup = paramViewGroup.rDr;
      int i = rDf;
      o.a(paramViewGroup, 2131690142, (ajn)localObject, paramg, false, i, i);
      AppMethodBeat.o(107455);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107456);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107456);
  }
  
  public static final class a
    extends b.b
  {
    ImageView rDr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.f
 * JD-Core Version:    0.7.0.1
 */