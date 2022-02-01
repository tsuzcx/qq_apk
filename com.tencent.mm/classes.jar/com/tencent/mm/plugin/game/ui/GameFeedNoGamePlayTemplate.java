package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.di;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  GameDownloadView CSX;
  private d CTb;
  private GameFeedTitleDescView CWE;
  private FrameLayout CWF;
  private RelativeLayout CWG;
  private TextView CWH;
  private GameRoundImageView CWr;
  private ImageView CWs;
  private ImageView oFa;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.CTb == null) || (this.CTb.CIr == null) || (this.CTb.CIr.COB == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == g.e.CkC) && (!Util.isNullOrNil(this.CTb.CIr.COB.CPs)))
    {
      i = c.aY(getContext(), this.CTb.CIr.COB.CPs);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      i = c.aY(getContext(), this.CTb.CIr.CMD);
      com.tencent.mm.game.report.g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.CWE = ((GameFeedTitleDescView)findViewById(g.e.Cjh));
    this.CWF = ((FrameLayout)findViewById(g.e.CkC));
    this.CWr = ((GameRoundImageView)findViewById(g.e.ChB));
    this.CWs = ((ImageView)findViewById(g.e.Cma));
    this.CWG = ((RelativeLayout)findViewById(g.e.Cib));
    this.oFa = ((ImageView)findViewById(g.e.Cjt));
    this.CWH = ((TextView)findViewById(g.e.Cke));
    this.CSX = ((GameDownloadView)findViewById(g.e.Cje));
    setOnClickListener(this);
    this.CWF.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COB == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    this.CWE.a(paramd.COB.fwr, paramd.COB.CMB, paramd.COB.CRe);
    this.CWF.setVisibility(0);
    if (!Util.isNullOrNil(paramd.COB.CMC))
    {
      e.eAa().a(this.CWr, paramd.COB.CMC, getResources().getDimensionPixelSize(g.c.CgT), getResources().getDimensionPixelSize(g.c.CgS), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!Util.isNullOrNil(paramd.COB.CPs)) {
        this.CWs.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.COB.CME != null)
      {
        this.CWG.setVisibility(0);
        e.eAa().c(this.oFa, paramd.COB.CME.jUi, com.tencent.mm.ci.a.getDensity(getContext()));
        this.CWH.setText(paramd.COB.CME.CMP);
        paramd = x.a(paramd.COB.CME);
        paramd.scene = 10;
        paramd.fSl = 1024;
        paramd.position = this.CTb.position;
        this.CSX.setDownloadInfo(new l(paramd));
      }
      if (!this.CTb.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
        this.CTb.CIt = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.CWs.setVisibility(8);
      continue;
      this.CWF.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */