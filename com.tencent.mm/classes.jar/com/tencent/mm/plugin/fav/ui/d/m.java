package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;

public final class m
  extends a
{
  public m(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74651);
    paramViewGroup = paramViewGroup.getContext();
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = a(View.inflate(paramViewGroup, 2130969548, null), paramView, paramg);
      paramView.ekg = ((TextView)localView.findViewById(2131824042));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      if ((paramg.field_favProto.desc != null) && (paramg.field_favProto.desc.length() > 0)) {
        break;
      }
      paramViewGroup.ekg.setText("");
      AppMethodBeat.o(74651);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.ekg.setText(j.b(paramViewGroup.ekg.getContext(), paramg.field_favProto.desc, paramViewGroup.ekg.getTextSize()));
    AppMethodBeat.o(74651);
    return localView;
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74652);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74652);
  }
  
  public static final class a
    extends a.b
  {
    TextView ekg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.m
 * JD-Core Version:    0.7.0.1
 */