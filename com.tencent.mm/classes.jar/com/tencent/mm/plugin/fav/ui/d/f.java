package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends a
{
  private final int mDa;
  
  public f(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74625);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427652);
    AppMethodBeat.o(74625);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74626);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new f.a();
      paramView = a(View.inflate((Context)localObject, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820602));
      paramViewGroup.mCZ = ((TextView)paramView.findViewById(2131820615));
      paramViewGroup.mCZ.setVisibility(8);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      localObject = paramg.field_favProto.wUh;
      paramViewGroup.gpL.setText(bo.nullAsNil(((acp)localObject).title));
      paramViewGroup.gpM.setText(bo.nullAsNil(((acp)localObject).desc));
      paramViewGroup.gpL.setSingleLine(false);
      paramViewGroup.gpL.setMaxLines(2);
      this.mvC.a(paramViewGroup.ivs, null, paramg, 2131230822, this.mDa, this.mDa);
      AppMethodBeat.o(74626);
      return paramView;
      paramViewGroup = (f.a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74627);
    f.a locala = (f.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.f
 * JD-Core Version:    0.7.0.1
 */