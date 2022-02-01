package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.u;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private aq IRc;
  private TextView IRh;
  private TextView IRi;
  private LinearLayout IRj;
  private TextView IRk;
  private TextView IRl;
  private ImageView xaN;
  private TextView yEQ;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void XK(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = com.tencent.mm.plugin.game.c.a.aw(this.IRc.IHI, "clickType", "leftCorner");; str = com.tencent.mm.plugin.game.c.a.aw(this.IRc.IHI, "clickType", "rightCorner"))
    {
      g.a(getContext(), 10, 1024, this.IRc.IHK, 7, this.IRc.oOI, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.IRc == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == h.e.HWL) || (paramView.getId() == h.e.HWM) || (paramView.getId() == h.e.HTy)) {
      if ((this.IRc.IIQ != null) && (!Util.isNullOrNil(this.IRc.IIQ.IGI)))
      {
        c.ba(getContext(), this.IRc.IIQ.IGI);
        XK(1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
      if ((paramView.getId() == h.e.HXC) && (this.IRc.IIR != null) && (!Util.isNullOrNil(this.IRc.IIR.IGI)))
      {
        c.ba(getContext(), this.IRc.IIR.IGI);
        XK(2);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(h.f.HZt, this, true);
    this.IRh = ((TextView)localView.findViewById(h.e.HWL));
    this.IRi = ((TextView)localView.findViewById(h.e.HWM));
    this.IRj = ((LinearLayout)localView.findViewById(h.e.HTy));
    this.xaN = ((ImageView)localView.findViewById(h.e.avatar));
    this.yEQ = ((TextView)localView.findViewById(h.e.nick_name));
    this.IRk = ((TextView)localView.findViewById(h.e.HYb));
    this.IRl = ((TextView)localView.findViewById(h.e.HXC));
    this.IRh.setOnClickListener(this);
    this.IRi.setOnClickListener(this);
    this.IRj.setOnClickListener(this);
    this.IRl.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(aq paramaq)
  {
    AppMethodBeat.i(42132);
    if ((paramaq == null) || ((paramaq.IIQ == null) && (paramaq.IIR == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.IRc = paramaq;
    setVisibility(0);
    this.IRh.setVisibility(8);
    this.IRi.setVisibility(8);
    this.IRj.setVisibility(8);
    if (paramaq.IIQ != null) {
      switch (paramaq.IIQ.IHX)
      {
      }
    }
    while (paramaq.IIR != null)
    {
      this.IRl.setText(paramaq.IIR.IGG);
      this.IRl.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.IRh.setVisibility(0);
      this.IRh.setText(paramaq.IIQ.IGG);
      continue;
      this.IRi.setVisibility(0);
      this.IRi.setText(paramaq.IIQ.IGG);
      continue;
      this.IRj.setVisibility(0);
      if (!Util.isNullOrNil(paramaq.IIQ.IHW))
      {
        e.a.a locala = new e.a.a();
        locala.nrc = true;
        e.fIb().a(this.xaN, paramaq.IIQ.IHW, locala.fIc());
        this.xaN.setVisibility(0);
      }
      this.yEQ.setText(paramaq.IIQ.IGU);
      this.IRk.setText(paramaq.IIQ.IGG);
    }
    this.IRl.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */