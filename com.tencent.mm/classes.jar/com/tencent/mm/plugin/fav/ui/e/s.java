package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agq;

public final class s
  extends b
{
  public s(o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107501);
    Context localContext = paramViewGroup.getContext();
    int i;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131493966, null), paramViewGroup, paramg);
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      a(paramViewGroup, paramg);
      i = (int)com.tencent.mm.plugin.fav.a.b.mI(com.tencent.mm.plugin.fav.a.b.c(paramg).duration);
      paramg = paramViewGroup.ica;
      paramViewGroup = this.qcI.context;
      if (i > 0) {
        break label130;
      }
    }
    label130:
    for (paramViewGroup = paramViewGroup.getString(2131759032, new Object[] { Integer.valueOf(0) });; paramViewGroup = paramViewGroup.getString(2131759032, new Object[] { Integer.valueOf(i) }))
    {
      paramg.setText(paramViewGroup);
      AppMethodBeat.o(107501);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107502);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107502);
  }
  
  public static final class a
    extends b.b
  {
    TextView ica;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.s
 * JD-Core Version:    0.7.0.1
 */