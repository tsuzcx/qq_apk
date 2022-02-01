package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
  extends b
{
  private final String rLZ;
  private final int rLq;
  
  public k(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107474);
    this.rLq = a.ax(paramo.context, 2131165358);
    this.rLZ = paramo.context.getString(2131758954);
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
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.iFO.setVisibility(8);
      paramViewGroup.rLB = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rLB.setVisibility(0);
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      akm localakm = paramg.field_favProto.GBh;
      paramViewGroup.iYj.setText(bu.nullAsNil(localakm.title));
      paramViewGroup.rLB.setText(bu.bI(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.GCe.appId), this.rLZ));
      this.rDB.a(paramViewGroup.mdt, null, paramg, 2131689577, this.rLq, this.rLq);
      AppMethodBeat.o(107475);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107476);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107476);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    ImageView mdt;
    TextView rLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.k
 * JD-Core Version:    0.7.0.1
 */