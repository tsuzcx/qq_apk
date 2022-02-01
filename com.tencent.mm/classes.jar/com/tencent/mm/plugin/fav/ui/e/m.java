package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.LinkedList;

public final class m
  extends b
{
  final int qkA;
  private HashSet<Long> qlr;
  
  public m(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107483);
    this.qkA = a.ao(paramo.context, 2131165359);
    this.qlr = new HashSet();
    AppMethodBeat.o(107483);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, final com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107484);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493963, null), paramViewGroup, paramg);
      paramViewGroup.qkM = ((ImageView)paramView.findViewById(2131299801));
      paramViewGroup.qlt = ((TextView)paramView.findViewById(2131299855));
      LinkedList localLinkedList = paramg.field_favProto.mVb;
      if (localLinkedList.size() <= 0) {
        break label231;
      }
      int i = ((afy)localLinkedList.getFirst()).duration;
      paramViewGroup.qlt.setText(com.tencent.mm.plugin.fav.ui.m.C((Context)localObject, i));
      if ((paramg != null) && (i <= 1)) {
        break label180;
      }
      label118:
      paramViewGroup.qlt.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      this.qcI.a(paramViewGroup.qkM, (afy)localObject, paramg, 2131689581, this.qkA, this.qkA);
      AppMethodBeat.o(107484);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label180:
      if (this.qlr.contains(Long.valueOf(paramg.field_localId))) {
        break label118;
      }
      this.qlr.add(Long.valueOf(paramg.field_localId));
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107482);
          com.tencent.mm.plugin.fav.a.b.o(paramg);
          AppMethodBeat.o(107482);
        }
      });
      break label118;
      label231:
      paramViewGroup.qlt.setVisibility(8);
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107485);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107485);
  }
  
  public static final class a
    extends b.b
  {
    ImageView qkM;
    TextView qlt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.m
 * JD-Core Version:    0.7.0.1
 */