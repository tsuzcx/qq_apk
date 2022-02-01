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
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.vb;

public final class c
  extends i
{
  private View tFG;
  private TextView tFH;
  
  public final void cKY()
  {
    AppMethodBeat.i(113664);
    if (this.tFG != null) {
      this.tFG.setVisibility(8);
    }
    AppMethodBeat.o(113664);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113663);
    if (this.tFG == null)
    {
      this.tFG = ((ViewStub)findViewById(a.d.tbc)).inflate();
      this.tFH = ((TextView)this.tFG.findViewById(a.d.tbd));
    }
    this.tFG.setVisibility(0);
    this.tFG.setOnClickListener(this.tFT.cIW());
    b localb = this.tFT.cIS();
    if (!TextUtils.isEmpty(localb.cGs().Sgg.Ssa))
    {
      this.tFH.setText(localb.cGs().Sgg.Ssa);
      AppMethodBeat.o(113663);
      return;
    }
    this.tFH.setText(getString(a.g.tkZ));
    AppMethodBeat.o(113663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */