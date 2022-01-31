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
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ci;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedVideoView
  extends LinearLayout
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.game.model.e kXy;
  private GameFeedTitleDescView laV;
  private FrameLayout laY;
  private GameRoundImageView lbG;
  private LinearLayout lbH;
  private ImageView lbI;
  private TextView lbJ;
  private GameFeedSubscriptView lbi;
  
  public GameFeedVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if (this.kXy == null) {}
    while (bk.bl(this.kXy.kOu.kRP)) {
      return;
    }
    int i = c.an(getContext(), this.kXy.kOu.kRP);
    b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), a.O(this.kXy.kOu.kSs, "clickType", "card"));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.laV = ((GameFeedTitleDescView)findViewById(g.e.game_feed_title_desc));
    this.laY = ((FrameLayout)findViewById(g.e.video_ly));
    this.lbG = ((GameRoundImageView)findViewById(g.e.video_cover_image));
    this.lbH = ((LinearLayout)findViewById(g.e.video_desc));
    this.lbI = ((ImageView)findViewById(g.e.video_redot));
    this.lbJ = ((TextView)findViewById(g.e.video_desc_text));
    this.lbi = ((GameFeedSubscriptView)findViewById(g.e.subscript));
    setOnClickListener(this);
  }
  
  public void setLiveData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTk == null))
    {
      setVisibility(8);
      return;
    }
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    this.laV.a(parame.kTk.bGw, parame.kTk.kRN, null);
    if (!bk.bl(parame.kTk.kRO))
    {
      this.laY.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.baw().a(this.lbG, parame.kTk.kRO, getResources().getDimensionPixelSize(g.c.GameImageTextWidth), getResources().getDimensionPixelSize(g.c.GameImageTextHeight), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      label140:
      if (bk.bl(parame.kTk.kVF)) {
        break label267;
      }
      this.lbH.setVisibility(0);
      this.lbI.setVisibility(0);
      this.lbJ.setText(parame.kTk.kVF);
    }
    for (;;)
    {
      this.lbi.setData(parame);
      if (this.kXy.kOw) {
        break;
      }
      a.a(getContext(), 10, 1024, this.kXy.position, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), a.fy(this.kXy.kOu.kSs));
      this.kXy.kOw = true;
      return;
      this.laY.setVisibility(8);
      break label140;
      label267:
      this.lbH.setVisibility(8);
    }
  }
  
  public void setVideoData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTj == null) || (bk.bl(parame.kOu.kTj.kRO)))
    {
      setVisibility(8);
      return;
    }
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    this.laV.a(parame.kTj.bGw, parame.kTj.kRN, null);
    com.tencent.mm.plugin.game.f.e.baw().a(this.lbG, parame.kTj.kRO, getResources().getDimensionPixelSize(g.c.GameImageTextWidth), getResources().getDimensionPixelSize(g.c.GameImageTextHeight), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    if (!bk.bl(parame.kTj.kWo))
    {
      this.lbH.setVisibility(0);
      this.lbI.setVisibility(8);
      this.lbJ.setText(parame.kTj.kWo);
    }
    for (;;)
    {
      this.lbi.setData(parame);
      return;
      this.lbH.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedVideoView
 * JD-Core Version:    0.7.0.1
 */