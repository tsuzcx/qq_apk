package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class GroupToolsManagereUI$d
  extends RecyclerView.v
{
  static final c jak;
  View jac;
  RelativeLayout jad;
  ImageView jae;
  ImageView jaf;
  ImageView jag;
  TextView jah;
  RelativeLayout jai;
  ImageView jaj;
  
  static
  {
    AppMethodBeat.i(182181);
    c.a locala1 = new c.a();
    locala1.lRP = a.h.app_brand_app_default_icon_for_tail;
    c.a locala2 = locala1.dO(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.kPz = true;
    locala2.lRD = true;
    locala2.lRB = true;
    jak = locala1.bmL();
    AppMethodBeat.o(182181);
  }
  
  public GroupToolsManagereUI$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(182180);
    this.jac = paramView;
    this.jad = ((RelativeLayout)paramView.findViewById(a.e.jdy));
    this.jae = ((ImageView)paramView.findViewById(a.e.jdu));
    this.jaf = ((ImageView)paramView.findViewById(a.e.jdv));
    this.jag = ((ImageView)paramView.findViewById(a.e.dqX));
    this.jah = ((TextView)paramView.findViewById(a.e.jdz));
    this.jai = ((RelativeLayout)paramView.findViewById(a.e.jdx));
    this.jaj = ((ImageView)paramView.findViewById(a.e.jdw));
    AppMethodBeat.o(182180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.d
 * JD-Core Version:    0.7.0.1
 */