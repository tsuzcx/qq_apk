package com.tencent.mm.plugin.fav.ui.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;

public final class o
  extends b
{
  public o(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107489);
    paramViewGroup = paramViewGroup.getContext();
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = a(View.inflate(paramViewGroup, 2131493965, null), paramView, paramg);
      paramView.fTO = ((TextView)localView.findViewById(2131299846));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      if ((paramg.field_favProto.desc != null) && (paramg.field_favProto.desc.length() > 0)) {
        break;
      }
      paramViewGroup.fTO.setText("");
      AppMethodBeat.o(107489);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.fTO.setText(k.b(paramViewGroup.fTO.getContext(), paramg.field_favProto.desc, paramViewGroup.fTO.getTextSize()));
    AppMethodBeat.o(107489);
    return localView;
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107490);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107490);
  }
  
  public static final class a
    extends b.b
  {
    TextView fTO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.o
 * JD-Core Version:    0.7.0.1
 */