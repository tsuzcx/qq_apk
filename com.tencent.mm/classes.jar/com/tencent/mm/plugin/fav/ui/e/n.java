package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMImageView;

public final class n
  extends b
{
  private final String rLZ;
  private final int rLq;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107486);
    this.rLq = a.ax(paramo.context, 2131165358);
    this.rLZ = "";
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
      paramViewGroup.rId = ((MMImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.rLB = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rLB.setVisibility(0);
      a(paramViewGroup, paramg);
      akw localakw = paramg.field_favProto.GBj;
      if (localakw == null) {
        break label218;
      }
      paramViewGroup.iYj.setText(bu.nullAsNil(localakw.title));
      paramViewGroup.iFO.setText(bu.nullAsNil(localakw.desc));
    }
    for (;;)
    {
      paramViewGroup.rLB.setText(bu.bI(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.GCe.appId), this.rLZ));
      this.rDB.a(paramViewGroup.rId, null, paramg, 2131689577, this.rLq, this.rLq);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label218:
      paramViewGroup.iYj.setText("");
      paramViewGroup.iFO.setText("");
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    MMImageView rId;
    TextView rLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.n
 * JD-Core Version:    0.7.0.1
 */