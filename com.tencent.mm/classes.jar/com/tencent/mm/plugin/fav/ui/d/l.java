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
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  extends b
{
  private final String tlM;
  private final int tlc;
  
  public l(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107474);
    this.tlc = a.aG(paramo.context, 2131165369);
    this.tlM = paramo.context.getString(2131759278);
    AppMethodBeat.o(107474);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107475);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131494124, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131300451));
      paramViewGroup.jBR.setVisibility(8);
      paramViewGroup.tln = ((TextView)paramView.findViewById(2131300503));
      paramViewGroup.tln.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      ana localana = paramg.field_favProto.LwU;
      paramViewGroup.jVO.setText(Util.nullAsNil(localana.title));
      paramViewGroup.tln.setText(Util.nullAs(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.Lya.appId), this.tlM));
      this.tdg.a(paramViewGroup.nnL, null, paramg, 2131689580, this.tlc, this.tlc);
      AppMethodBeat.o(107475);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107476);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107476);
  }
  
  public static final class a
    extends b.b
  {
    TextView jBR;
    TextView jVO;
    ImageView nnL;
    TextView tln;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.l
 * JD-Core Version:    0.7.0.1
 */