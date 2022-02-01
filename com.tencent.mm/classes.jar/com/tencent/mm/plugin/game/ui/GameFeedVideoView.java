package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.cz;
import com.tencent.mm.plugin.game.protobuf.em;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private d CTb;
  private GameFeedSubscriptView CWA;
  private GameRoundImageView CWW;
  private LinearLayout CWX;
  private ImageView CWY;
  private TextView CWZ;
  private GameFeedTitleDescView CWn;
  private FrameLayout CWq;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42143);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.CTb == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42143);
      return;
    }
    if (!Util.isNullOrNil(this.CTb.CIr.CMD))
    {
      int i = c.aY(getContext(), this.CTb.CIr.CMD);
      g.a(getContext(), 10, 1024, this.CTb.position, i, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.am(this.CTb.CIr.CNA, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedVideoView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42143);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42140);
    super.onFinishInflate();
    this.CWn = ((GameFeedTitleDescView)findViewById(g.e.Cjh));
    this.CWq = ((FrameLayout)findViewById(g.e.ClZ));
    this.CWW = ((GameRoundImageView)findViewById(g.e.ClV));
    this.CWX = ((LinearLayout)findViewById(g.e.video_desc));
    this.CWY = ((ImageView)findViewById(g.e.Cmb));
    this.CWZ = ((TextView)findViewById(g.e.ClX));
    this.CWA = ((GameFeedSubscriptView)findViewById(g.e.ClJ));
    setOnClickListener(this);
    AppMethodBeat.o(42140);
  }
  
  public void setLiveData(d paramd)
  {
    AppMethodBeat.i(42142);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COy == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42142);
      return;
    }
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    this.CWn.a(paramd.COy.fwr, paramd.COy.CMB, null);
    if (!Util.isNullOrNil(paramd.COy.CMC))
    {
      this.CWq.setVisibility(0);
      e.eAa().a(this.CWW, paramd.COy.CMC, getResources().getDimensionPixelSize(g.c.CgQ), getResources().getDimensionPixelSize(g.c.CgP), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (Util.isNullOrNil(paramd.COy.CQS)) {
        break label282;
      }
      this.CWX.setVisibility(0);
      this.CWY.setVisibility(0);
      this.CWZ.setText(paramd.COy.CQS);
    }
    for (;;)
    {
      this.CWA.setData(paramd);
      if (!this.CTb.CIt)
      {
        com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1024, this.CTb.position, this.CTb.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CTb.CIr.CNA));
        this.CTb.CIt = true;
      }
      AppMethodBeat.o(42142);
      return;
      this.CWq.setVisibility(8);
      break;
      label282:
      this.CWX.setVisibility(8);
    }
  }
  
  public void setVideoData(d paramd)
  {
    AppMethodBeat.i(42141);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COx == null) || (Util.isNullOrNil(paramd.CIr.COx.CMC)))
    {
      setVisibility(8);
      AppMethodBeat.o(42141);
      return;
    }
    this.CTb = paramd;
    paramd = paramd.CIr;
    setVisibility(0);
    this.CWn.a(paramd.COx.fwr, paramd.COx.CMB, null);
    e.eAa().a(this.CWW, paramd.COx.CMC, getResources().getDimensionPixelSize(g.c.CgQ), getResources().getDimensionPixelSize(g.c.CgP), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!Util.isNullOrNil(paramd.COx.CRS))
    {
      this.CWX.setVisibility(0);
      this.CWY.setVisibility(8);
      this.CWZ.setText(paramd.COx.CRS);
    }
    for (;;)
    {
      this.CWA.setData(paramd);
      AppMethodBeat.o(42141);
      return;
      this.CWX.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */