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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.dh;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView lIM;
  GameDownloadView xOO;
  private d xOS;
  private GameRoundImageView xSg;
  private ImageView xSh;
  private GameFeedTitleDescView xSt;
  private FrameLayout xSu;
  private RelativeLayout xSv;
  private TextView xSw;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOS == null) || (this.xOS.xEq == null) || (this.xOS.xEq.xKu == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == 2131302584) && (!Util.isNullOrNil(this.xOS.xEq.xKu.xLk)))
    {
      i = c.aQ(getContext(), this.xOS.xEq.xKu.xLk);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "middle"));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42122);
      return;
    }
    if (!Util.isNullOrNil(this.xOS.xEq.xIy))
    {
      i = c.aQ(getContext(), this.xOS.xEq.xIy);
      f.a(getContext(), 10, 1024, this.xOS.position, i, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.as(this.xOS.xEq.xJt, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedNoGamePlayTemplate", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.xSt = ((GameFeedTitleDescView)findViewById(2131301964));
    this.xSu = ((FrameLayout)findViewById(2131302584));
    this.xSg = ((GameRoundImageView)findViewById(2131299287));
    this.xSh = ((ImageView)findViewById(2131309792));
    this.xSv = ((RelativeLayout)findViewById(2131301896));
    this.lIM = ((ImageView)findViewById(2131301985));
    this.xSw = ((TextView)findViewById(2131302051));
    this.xOO = ((GameDownloadView)findViewById(2131301958));
    setOnClickListener(this);
    this.xSu.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKu == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    Log.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.xOS = paramd;
    paramd = paramd.xEq;
    setVisibility(0);
    this.xSt.b(paramd.xKu.Title, paramd.xKu.Desc, paramd.xKu.xMV);
    this.xSu.setVisibility(0);
    if (!Util.isNullOrNil(paramd.xKu.xIx))
    {
      e.dWR().a(this.xSg, paramd.xKu.xIx, getResources().getDimensionPixelSize(2131165450), getResources().getDimensionPixelSize(2131165449), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!Util.isNullOrNil(paramd.xKu.xLk)) {
        this.xSh.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.xKu.xIz != null)
      {
        this.xSv.setVisibility(0);
        e.dWR().c(this.lIM, paramd.xKu.xIz.hik, com.tencent.mm.cb.a.getDensity(getContext()));
        this.xSw.setText(paramd.xKu.xIz.Name);
        paramd = x.a(paramd.xKu.xIz);
        paramd.scene = 10;
        paramd.dYu = 1024;
        paramd.position = this.xOS.position;
        this.xOO.setDownloadInfo(new l(paramd));
      }
      if (!this.xOS.xEs)
      {
        com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1024, this.xOS.position, this.xOS.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
        this.xOS.xEs = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.xSh.setVisibility(8);
      continue;
      this.xSu.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */