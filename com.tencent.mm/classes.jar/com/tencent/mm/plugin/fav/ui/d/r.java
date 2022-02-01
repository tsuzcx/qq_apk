package com.tencent.mm.plugin.fav.ui.d;

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
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends b
{
  private final int tlc;
  
  public r(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107493);
    this.tlc = a.aG(paramo.context, 2131165369);
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
      localObject1 = a(View.inflate((Context)localObject1, 2131494124, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)((View)localObject1).findViewById(2131300468));
      paramViewGroup.tlu = ((ImageView)((View)localObject1).findViewById(2131300473));
      paramViewGroup.jVO = ((TextView)((View)localObject1).findViewById(2131300526));
      paramViewGroup.jVO.setMaxLines(2);
      a(paramViewGroup, paramg);
      aml localaml1 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      anq localanq = paramg.field_favProto.LwS;
      localTextView = paramViewGroup.jVO;
      aml localaml2 = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramView = "";
      if (localanq != null) {
        paramView = localanq.title;
      }
      localObject2 = paramView;
      if (Util.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localaml2 != null) {
          localObject2 = localaml2.title;
        }
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        break label311;
      }
      localTextView.setVisibility(8);
      label176:
      int j = f.bcX(localaml1.LvC);
      paramView = this.tdg;
      localObject2 = paramViewGroup.nnL;
      int i = j;
      if (j == f.glU()) {
        i = 2131689587;
      }
      paramView.a((ImageView)localObject2, localaml1, paramg, i, this.tlc, this.tlc);
      if (((paramg.field_favProto.IXu == null) || (paramg.field_favProto.IXu.iwc != 5)) && ((localanq == null) || (Util.isNullOrNil(localanq.LyH)))) {
        break label327;
      }
      paramViewGroup.tlu.setImageResource(2131691480);
      paramViewGroup.tlu.setVisibility(0);
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
      paramViewGroup.tlu.setVisibility(8);
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107496);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.nnL;
    com.tencent.mm.plugin.fav.a.g localg = locala.tbr;
    if ((localg.field_favProto == null) || (localg.field_favProto.IXu == null) || (localg.field_favProto.IXu.iwc < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
      AppMethodBeat.o(107496);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.IXu;
        ((amt)localObject).LxS = new amu();
        ((amt)localObject).LxS.left = arrayOfInt[0];
        ((amt)localObject).LxS.top = arrayOfInt[1];
        ((amt)localObject).LxS.width = i;
        ((amt)localObject).LxS.height = j;
      }
    }
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(107495);
    try
    {
      anq localanq = paramb.tbr.field_favProto.LwS;
      if ((localanq != null) && (!Util.isNullOrNil(localanq.LyH)))
      {
        paramb.kgE.setText(2131766865);
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
    TextView jVO;
    ImageView nnL;
    ImageView tlu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.r
 * JD-Core Version:    0.7.0.1
 */