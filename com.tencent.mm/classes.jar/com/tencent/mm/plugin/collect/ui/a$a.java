package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletTextView;

final class a$a
{
  TextView kGe;
  TextView kPB;
  WalletTextView kQx;
  
  public a$a(View paramView)
  {
    AppMethodBeat.i(41168);
    this.kGe = ((TextView)paramView.findViewById(2131822897));
    this.kQx = ((WalletTextView)paramView.findViewById(2131822898));
    this.kPB = ((TextView)paramView.findViewById(2131822899));
    AppMethodBeat.o(41168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a.a
 * JD-Core Version:    0.7.0.1
 */