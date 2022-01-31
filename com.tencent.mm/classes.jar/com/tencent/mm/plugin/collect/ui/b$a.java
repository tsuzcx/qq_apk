package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletTextView;

final class b$a
{
  TextView kGe;
  TextView kPB;
  WalletTextView kQx;
  TextView kQy;
  
  public b$a(View paramView)
  {
    AppMethodBeat.i(41178);
    this.kGe = ((TextView)paramView.findViewById(2131822904));
    this.kQy = ((TextView)paramView.findViewById(2131822905));
    this.kQx = ((WalletTextView)paramView.findViewById(2131822906));
    this.kPB = ((TextView)paramView.findViewById(2131822907));
    AppMethodBeat.o(41178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b.a
 * JD-Core Version:    0.7.0.1
 */