package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import java.util.LinkedList;

public final class p
  extends a
{
  final int mDa;
  
  public p(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74658);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427653);
    AppMethodBeat.o(74658);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74659);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new p.a();
      paramView = a(View.inflate((Context)localObject, 2130969546, null), paramViewGroup, paramg);
      paramViewGroup.mDc = ((ImageView)paramView.findViewById(2131824033));
      paramViewGroup.mDI = ((TextView)paramView.findViewById(2131824041));
      paramViewGroup.mDI.setVisibility(0);
      LinkedList localLinkedList = paramg.field_favProto.wVc;
      if ((localLinkedList.size() <= 0) || (((aca)localLinkedList.getFirst()).duration <= 0)) {
        break label180;
      }
      paramViewGroup.mDI.setText(j.C((Context)localObject, ((aca)localLinkedList.getFirst()).duration));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      this.mvC.a(paramViewGroup.mDc, (aca)localObject, paramg, 2131230826, this.mDa, this.mDa);
      AppMethodBeat.o(74659);
      return paramView;
      paramViewGroup = (p.a)paramView.getTag();
      break;
      label180:
      paramViewGroup.mDI.setText("");
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74660);
    p.a locala = (p.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.p
 * JD-Core Version:    0.7.0.1
 */