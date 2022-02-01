package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View qkH;
  
  public final void cxw()
  {
    AppMethodBeat.i(113720);
    if (this.qkH != null) {
      this.qkH.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.qkH == null) {
      this.qkH = ((ViewStub)findViewById(2131298223)).inflate();
    }
    abz localabz = this.qjX.cvq().csR().Lcw;
    if (this.qkH != null)
    {
      ((TextView)this.qkH.findViewById(2131309037)).setText(localabz.title);
      ((TextView)this.qkH.findViewById(2131309036)).setText(localabz.pRY);
      if ((!this.qjX.cvv().cwq()) || (!this.qjX.cvv().cwr())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.qkH).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.qkH).getLayoutParams()).bottomMargin = this.qjX.cvt().getResources().getDimensionPixelSize(2131165576);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */