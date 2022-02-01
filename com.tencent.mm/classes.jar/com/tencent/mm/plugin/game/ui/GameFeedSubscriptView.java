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
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.t;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ap CWL;
  private TextView CWQ;
  private TextView CWR;
  private LinearLayout CWS;
  private TextView CWT;
  private TextView CWU;
  private ImageView tXu;
  private TextView vsF;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void TQ(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = com.tencent.mm.plugin.game.c.a.am(this.CWL.CNA, "clickType", "leftCorner");; str = com.tencent.mm.plugin.game.c.a.am(this.CWL.CNA, "clickType", "rightCorner"))
    {
      g.a(getContext(), 10, 1024, this.CWL.CNC, 7, this.CWL.lVG, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.CWL == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == g.e.CkD) || (paramView.getId() == g.e.CkE) || (paramView.getId() == g.e.Chp)) {
      if ((this.CWL.COG != null) && (!Util.isNullOrNil(this.CWL.COG.CMD)))
      {
        c.aY(getContext(), this.CWL.COG.CMD);
        TQ(1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
      if ((paramView.getId() == g.e.Clu) && (this.CWL.COH != null) && (!Util.isNullOrNil(this.CWL.COH.CMD)))
      {
        c.aY(getContext(), this.CWL.COH.CMD);
        TQ(2);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.Cnl, this, true);
    this.CWQ = ((TextView)localView.findViewById(g.e.CkD));
    this.CWR = ((TextView)localView.findViewById(g.e.CkE));
    this.CWS = ((LinearLayout)localView.findViewById(g.e.Chp));
    this.tXu = ((ImageView)localView.findViewById(g.e.avatar));
    this.vsF = ((TextView)localView.findViewById(g.e.nick_name));
    this.CWT = ((TextView)localView.findViewById(g.e.ClT));
    this.CWU = ((TextView)localView.findViewById(g.e.Clu));
    this.CWQ.setOnClickListener(this);
    this.CWR.setOnClickListener(this);
    this.CWS.setOnClickListener(this);
    this.CWU.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(ap paramap)
  {
    AppMethodBeat.i(42132);
    if ((paramap == null) || ((paramap.COG == null) && (paramap.COH == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.CWL = paramap;
    setVisibility(0);
    this.CWQ.setVisibility(8);
    this.CWR.setVisibility(8);
    this.CWS.setVisibility(8);
    if (paramap.COG != null) {
      switch (paramap.COG.CNN)
      {
      }
    }
    while (paramap.COH != null)
    {
      this.CWU.setText(paramap.COH.CMB);
      this.CWU.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.CWQ.setVisibility(0);
      this.CWQ.setText(paramap.COG.CMB);
      continue;
      this.CWR.setVisibility(0);
      this.CWR.setText(paramap.COG.CMB);
      continue;
      this.CWS.setVisibility(0);
      if (!Util.isNullOrNil(paramap.COG.CNM))
      {
        e.a.a locala = new e.a.a();
        locala.kPz = true;
        e.eAa().a(this.tXu, paramap.COG.CNM, locala.eAb());
        this.tXu.setVisibility(0);
      }
      this.vsF.setText(paramap.COG.CMP);
      this.CWT.setText(paramap.COG.CMB);
    }
    this.CWU.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */