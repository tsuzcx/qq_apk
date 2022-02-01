package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.uz;

public final class c
  extends i
{
  private View qjK;
  private TextView qjL;
  
  public final void cxw()
  {
    AppMethodBeat.i(113664);
    if (this.qjK != null) {
      this.qjK.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.qjK == null)
    {
      this.qjK = ((ViewStub)findViewById(2131298032)).inflate();
      this.qjL = ((TextView)this.qjK.findViewById(2131298033));
    }
    this.qjK.setVisibility(0);
    this.qjK.setOnClickListener(this.qjX.cvu());
    b localb = this.qjX.cvq();
    if (!TextUtils.isEmpty(localb.csQ().LeS.LqC))
    {
      this.qjL.setText(localb.csQ().LeS.LqC);
      AppMethodBeat.o(113663);
      return;
    }
    this.qjL.setText(getString(2131757103));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */