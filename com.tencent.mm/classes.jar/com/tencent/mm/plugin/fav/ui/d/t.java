package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;

public final class t
  extends b
{
  public t(o paramo)
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
      paramView = a(View.inflate(localContext, 2131494136, null), paramViewGroup, paramg);
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      a(paramViewGroup, paramg);
      i = (int)com.tencent.mm.plugin.fav.a.b.AO(com.tencent.mm.plugin.fav.a.b.c(paramg).duration);
      paramg = paramViewGroup.jVO;
      paramViewGroup = this.tdg.context;
      if (i > 0) {
        break label130;
      }
    }
    label130:
    for (paramViewGroup = paramViewGroup.getString(2131759358, new Object[] { Integer.valueOf(0) });; paramViewGroup = paramViewGroup.getString(2131759358, new Object[] { Integer.valueOf(i) }))
    {
      paramg.setText(paramViewGroup);
      AppMethodBeat.o(107501);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107502);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107502);
  }
  
  public static final class a
    extends b.b
  {
    TextView jVO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.t
 * JD-Core Version:    0.7.0.1
 */