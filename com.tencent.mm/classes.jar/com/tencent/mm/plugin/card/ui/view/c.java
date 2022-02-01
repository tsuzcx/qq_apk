package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.ts;

public final class c
  extends i
{
  private View oOo;
  private TextView oOp;
  
  public final void bYr()
  {
    AppMethodBeat.i(113664);
    if (this.oOo != null) {
      this.oOo.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.oOo == null)
    {
      this.oOo = ((ViewStub)findViewById(2131297728)).inflate();
      this.oOp = ((TextView)this.oOo.findViewById(2131297729));
    }
    this.oOo.setVisibility(0);
    this.oOo.setOnClickListener(this.oOB.bWp());
    b localb = this.oOB.bWl();
    if (!TextUtils.isEmpty(localb.bTN().FRQ.Gcq))
    {
      this.oOp.setText(localb.bTN().FRQ.Gcq);
      AppMethodBeat.o(113663);
      return;
    }
    this.oOp.setText(getString(2131756933));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */