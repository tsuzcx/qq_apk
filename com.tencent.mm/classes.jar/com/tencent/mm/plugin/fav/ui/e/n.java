package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMImageView;

public final class n
  extends b
{
  private final String qTL;
  private final int qTc;
  
  public n(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107486);
    this.qTc = a.au(paramo.context, 2131165358);
    this.qTL = "";
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
      paramViewGroup.qPS = ((MMImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.qTn = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.qTn.setVisibility(0);
      a(paramViewGroup, paramg);
      ahw localahw = paramg.field_favProto.EAO;
      if (localahw == null) {
        break label218;
      }
      paramViewGroup.iCg.setText(bs.nullAsNil(localahw.title));
      paramViewGroup.ijE.setText(bs.nullAsNil(localahw.desc));
    }
    for (;;)
    {
      paramViewGroup.qTn.setText(bs.bG(com.tencent.mm.plugin.fav.a.b.getAppName(localContext, paramg.field_favProto.EBJ.appId), this.qTL));
      this.qLn.a(paramViewGroup.qPS, null, paramg, 2131689577, this.qTc, this.qTc);
      AppMethodBeat.o(107487);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label218:
      paramViewGroup.iCg.setText("");
      paramViewGroup.ijE.setText("");
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107488);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107488);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    MMImageView qPS;
    TextView qTn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.n
 * JD-Core Version:    0.7.0.1
 */