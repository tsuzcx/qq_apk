package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;

public final class p
  extends b
{
  public p(o paramo)
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
      localView = a(View.inflate(paramViewGroup, 2131494135, null), paramView, paramg);
      paramView.gBb = ((TextView)localView.findViewById(2131300524));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      if ((paramg.field_favProto.desc != null) && (paramg.field_favProto.desc.length() > 0)) {
        break;
      }
      paramViewGroup.gBb.setText("");
      AppMethodBeat.o(107489);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.gBb.setText(l.b(paramViewGroup.gBb.getContext(), paramg.field_favProto.desc, paramViewGroup.gBb.getTextSize()));
    AppMethodBeat.o(107489);
    return localView;
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107490);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107490);
  }
  
  public static final class a
    extends b.b
  {
    TextView gBb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.p
 * JD-Core Version:    0.7.0.1
 */