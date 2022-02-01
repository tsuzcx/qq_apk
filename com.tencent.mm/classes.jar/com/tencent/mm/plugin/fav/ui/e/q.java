package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  extends b
{
  private final int rDf;
  
  public q(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.rDf = a.ax(paramo.context, 2131165358);
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
      paramViewGroup.lZa = ((ImageView)((View)localObject1).findViewById(2131299794));
      paramViewGroup.rDx = ((ImageView)((View)localObject1).findViewById(2131299798));
      paramViewGroup.iVq = ((TextView)((View)localObject1).findViewById(2131299848));
      paramViewGroup.iVq.setMaxLines(2);
      a(paramViewGroup, paramg);
      ajn localajn1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      aks localaks = paramg.field_favProto.Giw;
      localTextView = paramViewGroup.iVq;
      ajn localajn2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localaks != null) {
        paramView = localaks.title;
      }
      localObject2 = paramView;
      if (bt.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localajn2 != null) {
          localObject2 = localajn2.title;
        }
      }
      if (!bt.isNullOrNil((String)localObject2)) {
        break label311;
      }
      localTextView.setVisibility(8);
      label176:
      int j = f.aLi(localajn1.Ghg);
      paramView = this.rvp;
      localObject2 = paramViewGroup.lZa;
      int i = j;
      if (j == f.eYU()) {
        i = 2131689584;
      }
      paramView.a((ImageView)localObject2, localajn1, paramg, i, this.rDf, this.rDf);
      if (((paramg.field_favProto.DSw == null) || (paramg.field_favProto.DSw.hzh != 5)) && ((localaks == null) || (bt.isNullOrNil(localaks.Gkc)))) {
        break label327;
      }
      paramViewGroup.rDx.setImageResource(2131691166);
      paramViewGroup.rDx.setVisibility(0);
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
      paramViewGroup.rDx.setVisibility(8);
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.lZa;
    com.tencent.mm.plugin.fav.a.g localg = locala.rtA;
    if ((localg.field_favProto == null) || (localg.field_favProto.DSw == null) || (localg.field_favProto.DSw.hzh < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.DSw;
        ((ajv)localObject).Gjn = new ajw();
        ((ajv)localObject).Gjn.left = arrayOfInt[0];
        ((ajv)localObject).Gjn.top = arrayOfInt[1];
        ((ajv)localObject).Gjn.width = i;
        ((ajv)localObject).Gjn.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      if (!bt.isNullOrNil(paramb.rtA.field_favProto.Giw.Gkc))
      {
        paramb.jfJ.setText(2131764521);
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
    TextView iVq;
    ImageView lZa;
    ImageView rDx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.q
 * JD-Core Version:    0.7.0.1
 */