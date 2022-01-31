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
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedGameTemplateView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView iIV;
  private int kXw;
  private com.tencent.mm.plugin.game.model.e kXy;
  private ImageView kZD;
  private TextView kZE;
  private GameTagListView laX;
  private FrameLayout laY;
  private GameRoundImageView laZ;
  private ImageView lba;
  private GameFeedSubscriptView lbb;
  private GameDownloadView lbc;
  
  public GameFeedGameTemplateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    int i = getResources().getDimensionPixelSize(g.c.GameMatchImageWidth);
    int j = getResources().getDimensionPixelSize(g.c.GameMatchImageHeight);
    com.tencent.mm.plugin.game.f.e.baw().a(paramImageView, paramString, i, j, c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    if ((this.kXy == null) || (this.kXy.kOu == null)) {}
    do
    {
      return;
      if ((paramView.getId() == g.e.video_ly) && (!bk.bl(this.kXy.kOu.kTm.kTY)))
      {
        i = c.an(getContext(), this.kXy.kOu.kTm.kTY);
        b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.O(this.kXy.kOu.kSs, "clickType", "middle"));
        return;
      }
    } while (bk.bl(this.kXy.kOu.kRP));
    int i = c.an(getContext(), this.kXy.kOu.kRP);
    b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.O(this.kXy.kOu.kSs, "clickType", "card"));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kZD = ((ImageView)findViewById(g.e.game_icon));
    this.kZE = ((TextView)findViewById(g.e.game_name));
    this.laX = ((GameTagListView)findViewById(g.e.game_tag_list));
    this.iIV = ((TextView)findViewById(g.e.desc));
    this.laY = ((FrameLayout)findViewById(g.e.video_ly));
    this.laZ = ((GameRoundImageView)findViewById(g.e.image));
    this.lba = ((ImageView)findViewById(g.e.video_play));
    this.lbb = ((GameFeedSubscriptView)findViewById(g.e.subscript));
    this.lbc = ((GameDownloadView)findViewById(g.e.game_download_container));
    setOnClickListener(this);
    this.kXw = (c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 175));
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTm == null))
    {
      setVisibility(8);
      return;
    }
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    com.tencent.mm.plugin.game.f.e.baw().a(this.kZD, parame.kTm.kRQ.kRX, com.tencent.mm.cb.a.getDensity(getContext()));
    this.kZE.setText(parame.kTm.kRQ.kRZ);
    this.laX.f(parame.kTm.kRQ.kSo, this.kXw);
    if (!bk.bl(parame.kTm.kTX))
    {
      this.iIV.setText(parame.kTm.kTX);
      this.iIV.setVisibility(0);
      label143:
      this.laY.setVisibility(0);
      if (bk.bl(parame.kTm.kTZ)) {
        break label335;
      }
      b(this.laZ, parame.kTm.kRO);
      this.lba.setVisibility(0);
    }
    for (;;)
    {
      this.laY.setOnClickListener(this);
      this.lbb.setData(parame);
      parame = y.a(this.kXy.kOu.kTm.kRQ);
      parame.scene = 10;
      parame.bXn = 1024;
      parame.position = this.kXy.position;
      this.lbc.setDownloadInfo(new l(parame));
      if (this.kXy.kOw) {
        break;
      }
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.kXy.position, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.fy(this.kXy.kOu.kSs));
      this.kXy.kOw = true;
      return;
      this.iIV.setVisibility(8);
      break label143;
      label335:
      if (!bk.bl(parame.kTm.kRO))
      {
        b(this.laZ, parame.kTm.kRO);
        this.lba.setVisibility(8);
      }
      else
      {
        this.laY.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedGameTemplateView
 * JD-Core Version:    0.7.0.1
 */