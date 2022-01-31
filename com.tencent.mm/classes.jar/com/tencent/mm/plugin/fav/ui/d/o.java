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
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends a
{
  private final int mDa;
  
  public o(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74655);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427652);
    AppMethodBeat.o(74655);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74656);
    Object localObject1 = paramViewGroup.getContext();
    Object localObject2;
    TextView localTextView;
    if (paramView == null)
    {
      paramViewGroup = new o.a();
      localObject1 = a(View.inflate((Context)localObject1, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)((View)localObject1).findViewById(2131821517));
      paramViewGroup.mDg = ((ImageView)((View)localObject1).findViewById(2131821518));
      paramViewGroup.gpL = ((TextView)((View)localObject1).findViewById(2131820619));
      paramViewGroup.gpL.setMaxLines(2);
      a(paramViewGroup, paramg);
      aca localaca1 = b.c(paramg);
      localObject2 = paramg.field_favProto.wUf;
      localTextView = paramViewGroup.gpL;
      aca localaca2 = b.c(paramg);
      paramView = "";
      if (localObject2 != null) {
        paramView = ((adf)localObject2).title;
      }
      localObject2 = paramView;
      if (bo.isNullOrNil(paramView))
      {
        localObject2 = paramView;
        if (localaca2 != null) {
          localObject2 = localaca2.title;
        }
      }
      if (!bo.isNullOrNil((String)localObject2)) {
        break label295;
      }
      localTextView.setVisibility(8);
      label176:
      int j = d.akU(localaca1.wSR);
      paramView = this.mvC;
      localObject2 = paramViewGroup.ivs;
      int i = j;
      if (j == d.dkP()) {
        i = 2131230829;
      }
      paramView.a((ImageView)localObject2, localaca1, paramg, i, this.mDa, this.mDa);
      if ((paramg.field_favProto.uVl == null) || (paramg.field_favProto.uVl.fgh != 5)) {
        break label311;
      }
      paramViewGroup.mDg.setImageResource(2130838836);
      paramViewGroup.mDg.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(74656);
      return localObject1;
      paramViewGroup = (o.a)paramView.getTag();
      localObject1 = paramView;
      break;
      label295:
      localTextView.setText((CharSequence)localObject2);
      localTextView.setVisibility(0);
      break label176;
      label311:
      paramViewGroup.mDg.setVisibility(8);
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74657);
    o.a locala = (o.a)paramView.getTag();
    paramView = paramView.getContext();
    Object localObject = locala.ivs;
    com.tencent.mm.plugin.fav.a.g localg = locala.muk;
    if ((localg.field_favProto == null) || (localg.field_favProto.uVl == null) || (localg.field_favProto.uVl.fgh < 0)) {}
    for (;;)
    {
      ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
      AppMethodBeat.o(74657);
      return;
      int[] arrayOfInt = new int[2];
      if (localObject != null)
      {
        int i = ((View)localObject).getWidth();
        int j = ((View)localObject).getHeight();
        ((View)localObject).getLocationInWindow(arrayOfInt);
        localObject = localg.field_favProto.uVl;
        ((aci)localObject).wUS = new acj();
        ((aci)localObject).wUS.left = arrayOfInt[0];
        ((aci)localObject).wUS.top = arrayOfInt[1];
        ((aci)localObject).wUS.width = i;
        ((aci)localObject).wUS.height = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.o
 * JD-Core Version:    0.7.0.1
 */