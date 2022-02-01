package com.tencent.mm.chatroom.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class GroupToolsManagereUI$d
  extends RecyclerView.v
{
  static final c frV;
  View frN;
  RelativeLayout frO;
  ImageView frP;
  ImageView frQ;
  ImageView frR;
  TextView frS;
  RelativeLayout frT;
  ImageView frU;
  
  static
  {
    AppMethodBeat.i(182181);
    c.a locala1 = new c.a();
    locala1.hkf = 2131689599;
    c.a locala2 = locala1.de(a.fromDPToPix(aj.getContext(), 20), a.fromDPToPix(aj.getContext(), 20));
    locala2.gkG = true;
    locala2.hjU = true;
    locala2.hjS = true;
    frV = locala1.azc();
    AppMethodBeat.o(182181);
  }
  
  public GroupToolsManagereUI$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(182180);
    this.frN = paramView;
    this.frO = ((RelativeLayout)paramView.findViewById(2131305983));
    this.frP = ((ImageView)paramView.findViewById(2131305977));
    this.frQ = ((ImageView)paramView.findViewById(2131305979));
    this.frR = ((ImageView)paramView.findViewById(2131296846));
    this.frS = ((TextView)paramView.findViewById(2131305985));
    this.frT = ((RelativeLayout)paramView.findViewById(2131305981));
    this.frU = ((ImageView)paramView.findViewById(2131305980));
    AppMethodBeat.o(182180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.d
 * JD-Core Version:    0.7.0.1
 */