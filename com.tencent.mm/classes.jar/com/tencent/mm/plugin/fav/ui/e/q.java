package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
  extends b
{
  private final int rLq;
  
  public q(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.rLq = a.ax(paramo.context, 2131165358);
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
      paramViewGroup.mdt = ((ImageView)((View)localObject1).findViewById(2131299794));
      paramViewGroup.rLI = ((ImageView)((View)localObject1).findViewById(2131299798));
      paramViewGroup.iYj = ((TextView)((View)localObject1).findViewById(2131299848));
      paramViewGroup.iYj.setMaxLines(2);
      a(paramViewGroup, paramg);
      ajx localajx1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      alc localalc = paramg.field_favProto.GBf;
      localTextView = paramViewGroup.iYj;
      ajx localajx2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localalc != null) {
        paramView = localalc.title;
      }
      localObject2 = paramView;
      if (bu.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localajx2 != null) {
          localObject2 = localajx2.title;
        }
      }
      if (!bu.isNullOrNil((String)localObject2)) {
        break label311;
      }
      localTextView.setVisibility(8);
      label176:
      int j = f.aME(localajx1.GzP);
      paramView = this.rDB;
      localObject2 = paramViewGroup.mdt;
      int i = j;
      if (j == f.fcI()) {
        i = 2131689584;
      }
      paramView.a((ImageView)localObject2, localajx1, paramg, i, this.rLq, this.rLq);
      if (((paramg.field_favProto.Ekw == null) || (paramg.field_favProto.Ekw.hBV != 5)) && ((localalc == null) || (bu.isNullOrNil(localalc.GCL)))) {
        break label327;
      }
      paramViewGroup.rLI.setImageResource(2131691166);
      paramViewGroup.rLI.setVisibility(0);
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
      paramViewGroup.rLI.setVisibility(8);
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.mdt;
    com.tencent.mm.plugin.fav.a.g localg = locala.rBM;
    if ((localg.field_favProto == null) || (localg.field_favProto.Ekw == null) || (localg.field_favProto.Ekw.hBV < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.Ekw;
        ((akf)localObject).GBW = new akg();
        ((akf)localObject).GBW.left = arrayOfInt[0];
        ((akf)localObject).GBW.top = arrayOfInt[1];
        ((akf)localObject).GBW.width = i;
        ((akf)localObject).GBW.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      if (!bu.isNullOrNil(paramb.rBM.field_favProto.GBf.GCL))
      {
        paramb.jiC.setText(2131764521);
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
    TextView iYj;
    ImageView mdt;
    ImageView rLI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.q
 * JD-Core Version:    0.7.0.1
 */