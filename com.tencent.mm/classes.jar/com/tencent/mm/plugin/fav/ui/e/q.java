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
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
  extends b
{
  private final int qTc;
  
  public q(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.qTc = a.au(paramo.context, 2131165358);
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
      paramViewGroup.lzC = ((ImageView)((View)localObject1).findViewById(2131299794));
      paramViewGroup.qTu = ((ImageView)((View)localObject1).findViewById(2131299798));
      paramViewGroup.iCg = ((TextView)((View)localObject1).findViewById(2131299848));
      paramViewGroup.iCg.setMaxLines(2);
      a(paramViewGroup, paramg);
      agx localagx1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      aic localaic = paramg.field_favProto.EAK;
      localTextView = paramViewGroup.iCg;
      agx localagx2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localaic != null) {
        paramView = localaic.title;
      }
      localObject2 = paramView;
      if (bs.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localagx2 != null) {
          localObject2 = localagx2.title;
        }
      }
      if (!bs.isNullOrNil((String)localObject2)) {
        break label311;
      }
      localTextView.setVisibility(8);
      label176:
      int j = e.aFI(localagx1.Ezu);
      paramView = this.qLn;
      localObject2 = paramViewGroup.lzC;
      int i = j;
      if (j == e.eKg()) {
        i = 2131689584;
      }
      paramView.a((ImageView)localObject2, localagx1, paramg, i, this.qTc, this.qTc);
      if (((paramg.field_favProto.CoY == null) || (paramg.field_favProto.CoY.hgY != 5)) && ((localaic == null) || (bs.isNullOrNil(localaic.ECq)))) {
        break label327;
      }
      paramViewGroup.qTu.setImageResource(2131232278);
      paramViewGroup.qTu.setVisibility(0);
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
      paramViewGroup.qTu.setVisibility(8);
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.lzC;
    com.tencent.mm.plugin.fav.a.g localg = locala.qJy;
    if ((localg.field_favProto == null) || (localg.field_favProto.CoY == null) || (localg.field_favProto.CoY.hgY < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.CoY;
        ((ahf)localObject).EBB = new ahg();
        ((ahf)localObject).EBB.left = arrayOfInt[0];
        ((ahf)localObject).EBB.top = arrayOfInt[1];
        ((ahf)localObject).EBB.width = i;
        ((ahf)localObject).EBB.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      if (!bs.isNullOrNil(paramb.qJy.field_favProto.EAK.ECq))
      {
        paramb.iMz.setText(2131764521);
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
    TextView iCg;
    ImageView lzC;
    ImageView qTu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.q
 * JD-Core Version:    0.7.0.1
 */