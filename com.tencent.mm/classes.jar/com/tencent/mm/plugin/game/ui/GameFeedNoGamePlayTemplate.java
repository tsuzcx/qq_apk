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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView kgj;
  GameDownloadView tmT;
  private d tmX;
  private GameFeedTitleDescView tqB;
  private FrameLayout tqC;
  private RelativeLayout tqD;
  private TextView tqE;
  private GameRoundImageView tqo;
  private ImageView tqp;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    if ((this.tmX == null) || (this.tmX.tdg == null) || (this.tmX.tdg.tiK == null))
    {
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == 2131300951) && (!bs.isNullOrNil(this.tmX.tdg.tiK.tjt)))
    {
      i = c.ay(getContext(), this.tmX.tdg.tiK.tjt);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ae(this.tmX.tdg.thP, "clickType", "middle"));
      AppMethodBeat.o(42122);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      i = c.ay(getContext(), this.tmX.tdg.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.tqB = ((GameFeedTitleDescView)findViewById(2131300441));
    this.tqC = ((FrameLayout)findViewById(2131300951));
    this.tqo = ((GameRoundImageView)findViewById(2131298822));
    this.tqp = ((ImageView)findViewById(2131306363));
    this.tqD = ((RelativeLayout)findViewById(2131300373));
    this.kgj = ((ImageView)findViewById(2131300462));
    this.tqE = ((TextView)findViewById(2131300524));
    this.tmT = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.tqC.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    ac.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiK == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    ac.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    this.tqB.b(paramd.tiK.Title, paramd.tiK.Desc, paramd.tiK.tln);
    this.tqC.setVisibility(0);
    if (!bs.isNullOrNil(paramd.tiK.thg))
    {
      com.tencent.mm.plugin.game.f.e.cRL().a(this.tqo, paramd.tiK.thg, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bs.isNullOrNil(paramd.tiK.tjt)) {
        this.tqp.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.tiK.thi != null)
      {
        this.tqD.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.cRL().c(this.kgj, paramd.tiK.thi.fZx, com.tencent.mm.cc.a.getDensity(getContext()));
        this.tqE.setText(paramd.tiK.thi.Name);
        paramd = x.a(paramd.tiK.thi);
        paramd.scene = 10;
        paramd.dtF = 1024;
        paramd.position = this.tmX.position;
        this.tmT.setDownloadInfo(new l(paramd));
      }
      if (!this.tmX.tdi)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.tu(this.tmX.tdg.thP));
        this.tmX.tdi = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.tqp.setVisibility(8);
      continue;
      this.tqC.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */