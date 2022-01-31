package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView kXq;
  ImageView kXr;
  TextView kXs;
  GameTagListView kXt;
  GameDownloadView kXu;
  View kXv;
  private int kXw;
  private x kXx;
  private com.tencent.mm.plugin.game.model.e kXy;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if ((this.kXx == null) || (bk.bl(this.kXx.kRQ.kRS))) {
      return;
    }
    int i = c.an(getContext(), this.kXx.kRQ.kRS);
    b.a(getContext(), 10, 1022, this.kXy.kOv + 1, i, this.kXx.kRQ.kRX, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.fy(this.kXy.kOu.kSs));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kXq = ((AutoResizeTextView)findViewById(g.e.game_num));
    this.kXr = ((ImageView)findViewById(g.e.game_icon));
    this.kXs = ((TextView)findViewById(g.e.game_name));
    this.kXt = ((GameTagListView)findViewById(g.e.tag_list));
    this.kXu = ((GameDownloadView)findViewById(g.e.game_btn_container));
    this.kXv = findViewById(g.e.social_stub);
    this.kXw = (c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTo == null) || (bk.dk(parame.kOu.kTo.kSr))) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      this.kXy = parame;
      x localx = (x)parame.kOu.kTo.kSr.get(parame.kOv);
      int i = parame.kOv + 1;
      if ((localx == null) || (localx.kRQ == null)) {
        setVisibility(8);
      }
      while (!parame.kOw)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1022, parame.kOv + 1, localx.kRQ.kRX, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.fy(parame.kOu.kSs));
        parame.kOw = true;
        return;
        this.kXx = localx;
        d locald = y.a(this.kXx.kRQ);
        locald.scene = 10;
        locald.bXn = 1022;
        locald.position = (this.kXy.kOv + 1);
        this.kXu.setDownloadInfo(new l(locald));
        setVisibility(0);
        this.kXq.setText(String.valueOf(i));
        if (i == 1) {
          this.kXq.setTextColor(c.parseColor("#EED157"));
        }
        for (;;)
        {
          com.tencent.mm.plugin.game.f.e.baw().a(this.kXr, localx.kRQ.kRX, com.tencent.mm.cb.a.getDensity(getContext()));
          this.kXs.setText(localx.kRQ.kRZ);
          this.kXt.f(localx.kRQ.kSo, this.kXw);
          if ((bk.dk(localx.kSZ)) && (localx.kTa == null) && (localx.kRN == null)) {
            break label422;
          }
          if ((this.kXv instanceof ViewStub)) {
            this.kXv = ((ViewStub)this.kXv).inflate();
          }
          ((GameFeedSocialInfoView)this.kXv.findViewById(g.e.game_social_info)).setData(localx);
          break;
          if (i == 2) {
            this.kXq.setTextColor(c.parseColor("#BDC5CB"));
          } else if (i == 3) {
            this.kXq.setTextColor(c.parseColor("#D4B897"));
          } else {
            this.kXq.setTextColor(c.parseColor("#B2B2B2"));
          }
        }
        label422:
        this.kXv.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */