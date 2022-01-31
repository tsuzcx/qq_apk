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
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends a
{
  private final int mDa;
  private final String mDx;
  
  public i(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74636);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427652);
    this.mDx = paraml.context.getString(2131299782);
    AppMethodBeat.o(74636);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74637);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new i.a();
      paramView = a(View.inflate(localContext, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820602));
      paramViewGroup.gpM.setVisibility(8);
      paramViewGroup.mCZ = ((TextView)paramView.findViewById(2131820615));
      paramViewGroup.mCZ.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      acp localacp = paramg.field_favProto.wUh;
      paramViewGroup.gpL.setText(bo.nullAsNil(localacp.title));
      paramViewGroup.mCZ.setText(bo.bf(b.getAppName(localContext, paramg.field_favProto.wVa.appId), this.mDx));
      this.mvC.a(paramViewGroup.ivs, null, paramg, 2131230822, this.mDa, this.mDa);
      AppMethodBeat.o(74637);
      return paramView;
      paramViewGroup = (i.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74638);
    i.a locala = (i.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.i
 * JD-Core Version:    0.7.0.1
 */