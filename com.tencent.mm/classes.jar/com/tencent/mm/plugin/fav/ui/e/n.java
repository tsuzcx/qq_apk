package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMImageView;

public final class n
  extends b
{
  private final int qkA;
  private final String qlj;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107486);
    this.qkA = a.ao(paramo.context, 2131165358);
    this.qlj = "";
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
      paramViewGroup.qhq = ((MMImageView)paramView.findViewById(2131299794));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.qkL = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.qkL.setVisibility(0);
      a(paramViewGroup, paramg);
      agx localagx = paramg.field_favProto.DhI;
      if (localagx == null) {
        break label218;
      }
      paramViewGroup.ica.setText(bt.nullAsNil(localagx.title));
      paramViewGroup.hJe.setText(bt.nullAsNil(localagx.desc));
    }
    for (;;)
    {
      paramViewGroup.qkL.setText(bt.by(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.DiD.appId), this.qlj));
      this.qcI.a(paramViewGroup.qhq, null, paramg, 2131689577, this.qkA, this.qkA);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label218:
      paramViewGroup.ica.setText("");
      paramViewGroup.hJe.setText("");
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    TextView hJe;
    TextView ica;
    MMImageView qhq;
    TextView qkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.n
 * JD-Core Version:    0.7.0.1
 */