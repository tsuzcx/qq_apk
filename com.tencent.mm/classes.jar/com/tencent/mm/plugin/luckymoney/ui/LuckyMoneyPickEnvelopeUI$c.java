package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPickEnvelopeUI$c
  extends RecyclerView.v
{
  ImageView ehv;
  private Dialog gKM;
  TextView gve;
  TextView hsI;
  TextView kgG;
  ImageView owb;
  RadioButton owc;
  View owd;
  ImageView owe;
  ProgressBar owf;
  TextView owg;
  TextView owh;
  ViewGroup owi;
  ImageView owj;
  ViewGroup owk;
  
  public LuckyMoneyPickEnvelopeUI$c(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(42925);
    this.gKM = null;
    this.owk = ((ViewGroup)paramView.findViewById(2131825763));
    this.owb = ((ImageView)paramView.findViewById(2131825764));
    this.gve = ((TextView)paramView.findViewById(2131825769));
    this.hsI = ((TextView)paramView.findViewById(2131825772));
    this.owc = ((RadioButton)paramView.findViewById(2131825771));
    this.ehv = ((ImageView)paramView.findViewById(2131825766));
    this.kgG = ((TextView)paramView.findViewById(2131825767));
    this.owd = paramView.findViewById(2131825774);
    this.owe = ((ImageView)paramView.findViewById(2131825775));
    this.owf = ((ProgressBar)paramView.findViewById(2131825776));
    this.owg = ((TextView)paramView.findViewById(2131825777));
    this.owh = ((TextView)paramView.findViewById(2131825773));
    this.owi = ((ViewGroup)paramView.findViewById(2131825770));
    this.owj = ((ImageView)paramView.findViewById(2131825778));
    AppMethodBeat.o(42925);
  }
  
  final void a(aus paramaus, boolean paramBoolean)
  {
    AppMethodBeat.i(42926);
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try load cover image");
    if (paramBoolean)
    {
      this.owe.setVisibility(8);
      this.owf.setVisibility(0);
      this.owg.setVisibility(8);
    }
    ((a)g.E(a.class)).a(this.owb, paramaus, new LuckyMoneyPickEnvelopeUI.c.2(this));
    AppMethodBeat.o(42926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.c
 * JD-Core Version:    0.7.0.1
 */