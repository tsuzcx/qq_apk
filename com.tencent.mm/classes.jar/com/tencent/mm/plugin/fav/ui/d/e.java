package com.tencent.mm.plugin.fav.ui.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends a
{
  public e(l paraml)
  {
    super(paraml);
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74623);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new e.a();
      paramView = a(View.inflate((Context)localObject, 2130969540, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820603));
      a(paramViewGroup, paramg);
      paramViewGroup.ivs.setImageResource(2131230807);
      localObject = paramg.field_favProto.wUd;
      paramg = paramg.field_favProto.hKa;
      if (!bo.isNullOrNil(paramg)) {
        break label193;
      }
      if (!k.Ob(((ach)localObject).cDl)) {
        break label169;
      }
      paramViewGroup.gpL.setText(((ach)localObject).cDl);
      label139:
      paramViewGroup.gpM.setText(((ach)localObject).label);
    }
    for (;;)
    {
      AppMethodBeat.o(74623);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
      break;
      label169:
      paramViewGroup.gpL.setText(((ach)localObject).label);
      paramViewGroup.gpM.setVisibility(8);
      continue;
      label193:
      paramViewGroup.gpL.setText(j.b(paramViewGroup.gpL.getContext(), paramg, paramViewGroup.gpL.getTextSize()));
      if (!k.Ob(((ach)localObject).cDl)) {
        break label139;
      }
      paramViewGroup.gpM.setText(((ach)localObject).cDl);
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74624);
    e.a locala = (e.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.e
 * JD-Core Version:    0.7.0.1
 */