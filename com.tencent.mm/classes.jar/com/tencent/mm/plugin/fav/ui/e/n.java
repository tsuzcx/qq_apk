package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMImageView;

public final class n
  extends b
{
  private final String rDO;
  private final int rDf;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107486);
    this.rDf = a.ax(paramo.context, 2131165358);
    this.rDO = "";
    AppMethodBeat.o(107486);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107487);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.rzS = ((MMImageView)paramView.findViewById(2131299794));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iCV = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.rDq = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rDq.setVisibility(0);
      a(paramViewGroup, paramg);
      akm localakm = paramg.field_favProto.GiA;
      if (localakm == null) {
        break label218;
      }
      paramViewGroup.iVq.setText(bt.nullAsNil(localakm.title));
      paramViewGroup.iCV.setText(bt.nullAsNil(localakm.desc));
    }
    for (;;)
    {
      paramViewGroup.rDq.setText(bt.bI(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.Gjv.appId), this.rDO));
      this.rvp.a(paramViewGroup.rzS, null, paramg, 2131689577, this.rDf, this.rDf);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label218:
      paramViewGroup.iVq.setText("");
      paramViewGroup.iCV.setText("");
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCV;
    TextView iVq;
    TextView rDq;
    MMImageView rzS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.n
 * JD-Core Version:    0.7.0.1
 */