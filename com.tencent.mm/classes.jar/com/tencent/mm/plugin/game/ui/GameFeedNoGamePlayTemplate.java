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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView jFL;
  GameDownloadView sfa;
  private d sfe;
  private GameFeedTitleDescView siI;
  private FrameLayout siJ;
  private RelativeLayout siK;
  private TextView siL;
  private GameRoundImageView siv;
  private ImageView siw;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42122);
    if ((this.sfe == null) || (this.sfe.rVo == null) || (this.sfe.rVo.saQ == null))
    {
      AppMethodBeat.o(42122);
      return;
    }
    int i;
    if ((paramView.getId() == 2131300951) && (!bt.isNullOrNil(this.sfe.rVo.saQ.sbz)))
    {
      i = c.ax(getContext(), this.sfe.rVo.saQ.sbz);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ad(this.sfe.rVo.rZW, "clickType", "middle"));
      AppMethodBeat.o(42122);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      i = c.ax(getContext(), this.sfe.rVo.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42122);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42120);
    super.onFinishInflate();
    this.siI = ((GameFeedTitleDescView)findViewById(2131300441));
    this.siJ = ((FrameLayout)findViewById(2131300951));
    this.siv = ((GameRoundImageView)findViewById(2131298822));
    this.siw = ((ImageView)findViewById(2131306363));
    this.siK = ((RelativeLayout)findViewById(2131300373));
    this.jFL = ((ImageView)findViewById(2131300462));
    this.siL = ((TextView)findViewById(2131300524));
    this.sfa = ((GameDownloadView)findViewById(2131300435));
    setOnClickListener(this);
    this.siJ.setOnClickListener(this);
    AppMethodBeat.o(42120);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42121);
    ad.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saQ == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42121);
      return;
    }
    ad.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.sfe = paramd;
    paramd = paramd.rVo;
    setVisibility(0);
    this.siI.b(paramd.saQ.Title, paramd.saQ.Desc, paramd.saQ.sdt);
    this.siJ.setVisibility(0);
    if (!bt.isNullOrNil(paramd.saQ.rZn))
    {
      com.tencent.mm.plugin.game.f.e.cEB().a(this.siv, paramd.saQ.rZn, getResources().getDimensionPixelSize(2131165434), getResources().getDimensionPixelSize(2131165433), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bt.isNullOrNil(paramd.saQ.sbz)) {
        this.siw.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramd.saQ.rZp != null)
      {
        this.siK.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.cEB().c(this.jFL, paramd.saQ.rZp.fVC, com.tencent.mm.cd.a.getDensity(getContext()));
        this.siL.setText(paramd.saQ.rZp.Name);
        paramd = x.a(paramd.saQ.rZp);
        paramd.scene = 10;
        paramd.dvS = 1024;
        paramd.position = this.sfe.position;
        this.sfa.setDownloadInfo(new l(paramd));
      }
      if (!this.sfe.rVq)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.qh(this.sfe.rVo.rZW));
        this.sfe.rVq = true;
      }
      AppMethodBeat.o(42121);
      return;
      this.siw.setVisibility(8);
      continue;
      this.siJ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */