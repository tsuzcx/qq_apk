package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;

public final class l
  extends a
{
  private final int mDa;
  private final String mDx;
  
  public l(com.tencent.mm.plugin.fav.ui.l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74648);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427652);
    this.mDx = "";
    AppMethodBeat.o(74648);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74649);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new l.a();
      paramView = a(View.inflate(localContext, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.mzO = ((MMImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820602));
      paramViewGroup.mCZ = ((TextView)paramView.findViewById(2131820615));
      paramViewGroup.mCZ.setVisibility(0);
      a(paramViewGroup, paramg);
      acz localacz = paramg.field_favProto.wUj;
      if (localacz == null) {
        break label218;
      }
      paramViewGroup.gpL.setText(bo.nullAsNil(localacz.title));
      paramViewGroup.gpM.setText(bo.nullAsNil(localacz.desc));
    }
    for (;;)
    {
      paramViewGroup.mCZ.setText(bo.bf(b.getAppName(localContext, paramg.field_favProto.wVa.appId), this.mDx));
      this.mvC.a(paramViewGroup.mzO, null, paramg, 2131230822, this.mDa, this.mDa);
      AppMethodBeat.o(74649);
      return paramView;
      paramViewGroup = (l.a)paramView.getTag();
      break;
      label218:
      paramViewGroup.gpL.setText("");
      paramViewGroup.gpM.setText("");
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74650);
    l.a locala = (l.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.l
 * JD-Core Version:    0.7.0.1
 */