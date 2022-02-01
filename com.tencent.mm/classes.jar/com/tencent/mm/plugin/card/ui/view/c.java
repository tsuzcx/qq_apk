package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.tu;

public final class c
  extends i
{
  private View oUQ;
  private TextView oUR;
  
  public final void bZG()
  {
    AppMethodBeat.i(113664);
    if (this.oUQ != null) {
      this.oUQ.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.oUQ == null)
    {
      this.oUQ = ((ViewStub)findViewById(2131297728)).inflate();
      this.oUR = ((TextView)this.oUQ.findViewById(2131297729));
    }
    this.oUQ.setVisibility(0);
    this.oUQ.setOnClickListener(this.oVd.bXE());
    b localb = this.oVd.bXA();
    if (!TextUtils.isEmpty(localb.bVc().Gkp.GuX))
    {
      this.oUR.setText(localb.bVc().Gkp.GuX);
      AppMethodBeat.o(113663);
      return;
    }
    this.oUR.setText(getString(2131756933));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */