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
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedNoGamePlayTemplate
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView hok;
  GameDownloadView kXu;
  private com.tencent.mm.plugin.game.model.e kXy;
  private GameRoundImageView laZ;
  private ImageView lba;
  private GameFeedTitleDescView lbm;
  private FrameLayout lbn;
  private RelativeLayout lbo;
  private TextView lbp;
  
  public GameFeedNoGamePlayTemplate(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if ((this.kXy == null) || (this.kXy.kOu == null) || (this.kXy.kOu.kTn == null)) {}
    do
    {
      return;
      if ((paramView.getId() == g.e.image_ly) && (!bk.bl(this.kXy.kOu.kTn.kTZ)))
      {
        i = c.an(getContext(), this.kXy.kOu.kTn.kTZ);
        b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.O(this.kXy.kOu.kSs, "clickType", "middle"));
        return;
      }
    } while (bk.bl(this.kXy.kOu.kRP));
    int i = c.an(getContext(), this.kXy.kOu.kRP);
    b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.O(this.kXy.kOu.kSs, "clickType", "card"));
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.lbm = ((GameFeedTitleDescView)findViewById(g.e.game_feed_title_desc));
    this.lbn = ((FrameLayout)findViewById(g.e.image_ly));
    this.laZ = ((GameRoundImageView)findViewById(g.e.cover_image));
    this.lba = ((ImageView)findViewById(g.e.video_play));
    this.lbo = ((RelativeLayout)findViewById(g.e.game_desc_container));
    this.hok = ((ImageView)findViewById(g.e.game_icon));
    this.lbp = ((TextView)findViewById(g.e.game_name));
    this.kXu = ((GameDownloadView)findViewById(g.e.game_download_container));
    setOnClickListener(this);
    this.lbn.setOnClickListener(this);
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTn == null))
    {
      setVisibility(8);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
    this.kXy = parame;
    parame = parame.kOu;
    setVisibility(0);
    this.lbm.a(parame.kTn.bGw, parame.kTn.kRN, parame.kTn.kVS);
    this.lbn.setVisibility(0);
    if (!bk.bl(parame.kTn.kRO))
    {
      com.tencent.mm.plugin.game.f.e.baw().a(this.laZ, parame.kTn.kRO, getResources().getDimensionPixelSize(g.c.GameMatchImageWidth), getResources().getDimensionPixelSize(g.c.GameMatchImageHeight), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      if (!bk.bl(parame.kTn.kTZ)) {
        this.lba.setVisibility(0);
      }
    }
    for (;;)
    {
      if (parame.kTn.kRQ != null)
      {
        this.lbo.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.baw().a(this.hok, parame.kTn.kRQ.kRX, com.tencent.mm.cb.a.getDensity(getContext()));
        this.lbp.setText(parame.kTn.kRQ.kRZ);
        parame = com.tencent.mm.plugin.game.model.y.a(parame.kTn.kRQ);
        parame.scene = 10;
        parame.bXn = 1024;
        parame.position = this.kXy.position;
        this.kXu.setDownloadInfo(new l(parame));
      }
      if (this.kXy.kOw) {
        break;
      }
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.kXy.position, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.fy(this.kXy.kOu.kSs));
      this.kXy.kOw = true;
      return;
      this.lba.setVisibility(8);
      continue;
      this.lbn.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedNoGamePlayTemplate
 * JD-Core Version:    0.7.0.1
 */