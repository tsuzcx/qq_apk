package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.ws;

public final class c
  extends i
{
  private View wJf;
  private TextView wJg;
  
  public final void doE()
  {
    AppMethodBeat.i(113664);
    if (this.wJf != null) {
      this.wJf.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.wJf == null)
    {
      this.wJf = ((ViewStub)findViewById(a.d.wfm)).inflate();
      this.wJg = ((TextView)this.wJf.findViewById(a.d.wfn));
    }
    this.wJf.setVisibility(0);
    this.wJf.setOnClickListener(this.wJs.dmo());
    b localb = this.wJs.dmk();
    if (!TextUtils.isEmpty(localb.djK().Zeb.Zri))
    {
      this.wJg.setText(localb.djK().Zeb.Zri);
      AppMethodBeat.o(113663);
      return;
    }
    this.wJg.setText(getString(a.g.wpy));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */