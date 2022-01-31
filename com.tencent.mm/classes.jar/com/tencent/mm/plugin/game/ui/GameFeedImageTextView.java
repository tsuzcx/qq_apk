package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.bz;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int gHR = 0;
  private com.tencent.mm.plugin.game.model.e kXy;
  private GameFeedTitleDescView laV;
  private GameRoundImageView laZ;
  private LinearLayout lbd;
  private GameRoundImageView lbe;
  private GameRoundImageView lbf;
  private GameRoundImageView lbg;
  private TextView lbh;
  private GameFeedSubscriptView lbi;
  private int lbj = 0;
  private int lbk;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
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
    b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.O(this.kXy.kOu.kSs, "clickType", "card"));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.laV = ((GameFeedTitleDescView)findViewById(g.e.game_feed_title_desc));
    this.laZ = ((GameRoundImageView)findViewById(g.e.big_image));
    this.lbd = ((LinearLayout)findViewById(g.e.small_image_layout));
    this.lbe = ((GameRoundImageView)findViewById(g.e.first_image));
    this.lbf = ((GameRoundImageView)findViewById(g.e.second_image));
    this.lbg = ((GameRoundImageView)findViewById(g.e.third_image));
    this.lbh = ((TextView)findViewById(g.e.more_image_text));
    this.lbi = ((GameFeedSubscriptView)findViewById(g.e.subscript));
    setOnClickListener(this);
    this.gHR = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.lbj = ((this.gHR - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.lbk = com.tencent.mm.cb.a.fromDPToPix(getContext(), 105);
    if (this.lbj < this.lbk) {
      this.lbk = this.lbj;
    }
    ViewGroup.LayoutParams localLayoutParams = this.lbe.getLayoutParams();
    localLayoutParams.width = this.lbk;
    localLayoutParams.height = this.lbk;
    this.lbe.setLayoutParams(localLayoutParams);
    this.lbf.setLayoutParams(localLayoutParams);
    this.lbg.setLayoutParams(localLayoutParams);
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTi == null))
    {
      setVisibility(8);
      return;
    }
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    this.laV.a(parame.kTi.bGw, parame.kTi.kVs, null);
    int i;
    if (!bk.dk(parame.kTi.kVt))
    {
      i = parame.kTi.kVt.size();
      if (i == 1)
      {
        this.lbd.setVisibility(8);
        this.laZ.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.baw().a(this.laZ, (String)parame.kTi.kVt.get(0), getResources().getDimensionPixelSize(g.c.GameImageTextWidth), getResources().getDimensionPixelSize(g.c.GameImageTextHeight), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.lbi.setData(parame);
      if (this.kXy.kOw) {
        break;
      }
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.kXy.position, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.fy(this.kXy.kOu.kSs));
      this.kXy.kOw = true;
      return;
      this.laZ.setVisibility(8);
      this.lbd.setVisibility(0);
      this.lbh.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).lgz = true;
      localObject = ((e.a.a)localObject).bax();
      com.tencent.mm.plugin.game.f.e.baw().a(this.lbe, (String)parame.kTi.kVt.get(0), (e.a)localObject);
      com.tencent.mm.plugin.game.f.e.baw().a(this.lbf, (String)parame.kTi.kVt.get(1), (e.a)localObject);
      if (i > 2)
      {
        com.tencent.mm.plugin.game.f.e.baw().a(this.lbg, (String)parame.kTi.kVt.get(2), (e.a)localObject);
        this.lbg.setVisibility(0);
        if (i > 3)
        {
          this.lbh.setVisibility(0);
          this.lbh.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.lbg.setVisibility(4);
        continue;
        this.laZ.setVisibility(8);
        this.lbd.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */