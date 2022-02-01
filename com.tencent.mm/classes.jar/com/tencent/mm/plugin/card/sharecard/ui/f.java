package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;

public final class f
{
  View plc;
  private MMActivity wry;
  b wxM;
  ImageView wxQ;
  TextView wxR;
  TextView wxS;
  
  public f(MMActivity paramMMActivity, View paramView)
  {
    this.wry = paramMMActivity;
    this.plc = paramView;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113091);
    this.wxR.setVisibility(0);
    this.wxQ.setImageDrawable(this.wry.getResources().getDrawable(a.c.wen));
    this.wxR.setText(a.g.wpS);
    this.wxS.setText(a.g.wpR);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.wxQ.getLayoutParams();
    localLayoutParams.topMargin = this.wry.getResources().getDimensionPixelOffset(a.b.wed);
    this.wxQ.setLayoutParams(localLayoutParams);
    this.wxQ.invalidate();
    AppMethodBeat.o(113091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.f
 * JD-Core Version:    0.7.0.1
 */