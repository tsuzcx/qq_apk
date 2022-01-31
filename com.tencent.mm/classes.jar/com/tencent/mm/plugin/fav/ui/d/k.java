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
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.LinkedList;

public final class k
  extends a
{
  private HashSet<Long> mDG;
  final int mDa;
  
  public k(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74645);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427653);
    this.mDG = new HashSet();
    AppMethodBeat.o(74645);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74646);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new k.a();
      paramView = a(View.inflate((Context)localObject, 2130969546, null), paramViewGroup, paramg);
      paramViewGroup.mDc = ((ImageView)paramView.findViewById(2131824033));
      paramViewGroup.mDI = ((TextView)paramView.findViewById(2131824041));
      LinkedList localLinkedList = paramg.field_favProto.wVc;
      if (localLinkedList.size() <= 0) {
        break label231;
      }
      int i = ((aca)localLinkedList.getFirst()).duration;
      paramViewGroup.mDI.setText(j.C((Context)localObject, i));
      if ((paramg != null) && (i <= 1)) {
        break label180;
      }
      label118:
      paramViewGroup.mDI.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      this.mvC.a(paramViewGroup.mDc, (aca)localObject, paramg, 2131230826, this.mDa, this.mDa);
      AppMethodBeat.o(74646);
      return paramView;
      paramViewGroup = (k.a)paramView.getTag();
      break;
      label180:
      if (this.mDG.contains(Long.valueOf(paramg.field_localId))) {
        break label118;
      }
      this.mDG.add(Long.valueOf(paramg.field_localId));
      com.tencent.mm.kernel.g.RO().ac(new k.1(this, paramg));
      break label118;
      label231:
      paramViewGroup.mDI.setVisibility(8);
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74647);
    k.a locala = (k.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.k
 * JD-Core Version:    0.7.0.1
 */