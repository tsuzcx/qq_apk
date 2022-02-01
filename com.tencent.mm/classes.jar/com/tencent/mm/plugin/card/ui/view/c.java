package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.ro;

public final class c
  extends i
{
  private View nHT;
  private TextView nHU;
  
  public final void bMB()
  {
    AppMethodBeat.i(113664);
    if (this.nHT != null) {
      this.nHT.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.nHT == null)
    {
      this.nHT = ((ViewStub)findViewById(2131297728)).inflate();
      this.nHU = ((TextView)this.nHT.findViewById(2131297729));
    }
    this.nHT.setVisibility(0);
    this.nHT.setOnClickListener(this.nIg.bKx());
    b localb = this.nIg.bKt();
    if (!TextUtils.isEmpty(localb.bHV().CRW.DbP))
    {
      this.nHU.setText(localb.bHV().CRW.DbP);
      AppMethodBeat.o(113663);
      return;
    }
    this.nHU.setText(getString(2131756933));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */