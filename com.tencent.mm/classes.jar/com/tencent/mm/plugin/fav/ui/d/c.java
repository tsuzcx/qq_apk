package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends a
{
  public c(l paraml)
  {
    super(paraml);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74618);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new c.a();
      paramView = a(View.inflate((Context)localObject, 2130969540, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820603));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      aca localaca = b.c(paramg);
      localObject = paramg.field_favProto.title;
      paramg = (com.tencent.mm.plugin.fav.a.g)localObject;
      if (bo.isNullOrNil((String)localObject)) {
        paramg = localaca.title;
      }
      paramViewGroup.gpL.setText(paramg);
      paramViewGroup.gpM.setText(b.aJ((float)localaca.wSX));
      if (localaca.wTK == 2) {
        paramViewGroup.gpM.setText(">25MB");
      }
      paramViewGroup.ivs.setImageResource(com.tencent.mm.plugin.fav.ui.c.NV(localaca.wSR));
      AppMethodBeat.o(74618);
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74619);
    com.tencent.mm.plugin.fav.a.g localg = ((c.a)paramView.getTag()).muk;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, localg, paramacs);
    AppMethodBeat.o(74619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.c
 * JD-Core Version:    0.7.0.1
 */