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
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  extends b
{
  private final String qTL;
  private final int qTc;
  
  public k(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107474);
    this.qTc = a.au(paramo.context, 2131165358);
    this.qTL = paramo.context.getString(2131758954);
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
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.ijE.setVisibility(8);
      paramViewGroup.qTn = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.qTn.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      ahm localahm = paramg.field_favProto.EAM;
      paramViewGroup.iCg.setText(bs.nullAsNil(localahm.title));
      paramViewGroup.qTn.setText(bs.bG(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.EBJ.appId), this.qTL));
      this.qLn.a(paramViewGroup.lzC, null, paramg, 2131689577, this.qTc, this.qTc);
      AppMethodBeat.o(107475);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107476);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107476);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    ImageView lzC;
    TextView qTn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.k
 * JD-Core Version:    0.7.0.1
 */