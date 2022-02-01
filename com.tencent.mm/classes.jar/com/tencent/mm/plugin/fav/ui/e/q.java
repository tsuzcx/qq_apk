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
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  extends b
{
  private final int qkA;
  
  public q(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.qkA = a.ao(paramo.context, 2131165358);
    AppMethodBeat.o(107493);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107494);
    Object localObject1 = paramViewGroup.getContext();
    TextView localTextView;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localObject1 = a(View.inflate((Context)localObject1, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.kXS = ((ImageView)((View)localObject1).findViewById(2131299794));
      paramViewGroup.qkS = ((ImageView)((View)localObject1).findViewById(2131299798));
      paramViewGroup.ica = ((TextView)((View)localObject1).findViewById(2131299848));
      paramViewGroup.ica.setMaxLines(2);
      a(paramViewGroup, paramg);
      afy localafy1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      ahd localahd = paramg.field_favProto.DhE;
      localTextView = paramViewGroup.ica;
      afy localafy2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localahd != null) {
        paramView = localahd.title;
      }
      localObject2 = paramView;
      if (bt.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localafy2 != null) {
          localObject2 = localafy2.title;
        }
      }
      if (!bt.isNullOrNil((String)localObject2)) {
        break label311;
      }
      localTextView.setVisibility(8);
      label176:
      int j = e.aAq(localafy1.Dgo);
      paramView = this.qcI;
      localObject2 = paramViewGroup.kXS;
      int i = j;
      if (j == e.euN()) {
        i = 2131689584;
      }
      paramView.a((ImageView)localObject2, localafy1, paramg, i, this.qkA, this.qkA);
      if (((paramg.field_favProto.AWL == null) || (paramg.field_favProto.AWL.gGx != 5)) && ((localahd == null) || (bt.isNullOrNil(localahd.Djk)))) {
        break label327;
      }
      paramViewGroup.qkS.setImageResource(2131232278);
      paramViewGroup.qkS.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(107494);
      return localObject1;
      paramViewGroup = (a)paramView.getTag();
      localObject1 = paramView;
      break;
      label311:
      localTextView.setText((CharSequence)localObject2);
      localTextView.setVisibility(0);
      break label176;
      label327:
      paramViewGroup.qkS.setVisibility(8);
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.kXS;
    com.tencent.mm.plugin.fav.a.g localg = locala.qaS;
    if ((localg.field_favProto == null) || (localg.field_favProto.AWL == null) || (localg.field_favProto.AWL.gGx < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.AWL;
        ((agg)localObject).Div = new agh();
        ((agg)localObject).Div.left = arrayOfInt[0];
        ((agg)localObject).Div.top = arrayOfInt[1];
        ((agg)localObject).Div.width = i;
        ((agg)localObject).Div.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      if (!bt.isNullOrNil(paramb.qaS.field_favProto.DhE.Djk))
      {
        paramb.imt.setText(2131764521);
        AppMethodBeat.o(107495);
        return;
      }
      super.a(paramb);
      AppMethodBeat.o(107495);
      return;
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(107495);
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView ica;
    ImageView kXS;
    ImageView qkS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.q
 * JD-Core Version:    0.7.0.1
 */