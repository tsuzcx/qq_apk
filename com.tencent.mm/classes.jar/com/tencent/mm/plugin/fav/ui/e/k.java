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
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends b
{
  private final String rDO;
  private final int rDf;
  
  public k(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107474);
    this.rDf = a.ax(paramo.context, 2131165358);
    this.rDO = paramo.context.getString(2131758954);
    AppMethodBeat.o(107474);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107475);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.lZa = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iCV = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.iCV.setVisibility(8);
      paramViewGroup.rDq = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rDq.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      akc localakc = paramg.field_favProto.Giy;
      paramViewGroup.iVq.setText(bt.nullAsNil(localakc.title));
      paramViewGroup.rDq.setText(bt.bI(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.Gjv.appId), this.rDO));
      this.rvp.a(paramViewGroup.lZa, null, paramg, 2131689577, this.rDf, this.rDf);
      AppMethodBeat.o(107475);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107476);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107476);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCV;
    TextView iVq;
    ImageView lZa;
    TextView rDq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.k
 * JD-Core Version:    0.7.0.1
 */