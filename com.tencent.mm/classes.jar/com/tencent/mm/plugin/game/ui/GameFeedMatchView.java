package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedMatchView
  extends LinearLayout
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.game.model.e kXy;
  private GameFeedTitleDescView laV;
  private GameFeedSubscriptView lbi;
  private GameRoundImageView lbl;
  
  public GameFeedMatchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if ((this.kXy == null) || (this.kXy.kOu == null)) {}
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
    this.lbl = ((GameRoundImageView)findViewById(g.e.big_image));
    this.lbi = ((GameFeedSubscriptView)findViewById(g.e.subscript));
    setOnClickListener(this);
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTl == null))
    {
      setVisibility(8);
      return;
    }
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    this.laV.a(parame.kTl.bGw, parame.kTl.kRN, null);
    if (!bk.bl(parame.kTl.kRO))
    {
      this.lbl.setVisibility(0);
      com.tencent.mm.plugin.game.f.e.baw().a(this.lbl, parame.kTl.kRO, getResources().getDimensionPixelSize(g.c.GameMatchImageWidth), getResources().getDimensionPixelSize(g.c.GameMatchImageHeight), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
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
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMatchView
 * JD-Core Version:    0.7.0.1
 */