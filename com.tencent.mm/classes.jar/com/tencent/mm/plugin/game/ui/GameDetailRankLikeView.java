package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ab.a;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  private int kQh;
  ab kYZ;
  ab.a kZa;
  private Drawable kZb;
  private Drawable kZc;
  private Animation kZd;
  private ImageView kZe;
  private TextView kZf;
  String mAppId;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setCount(int paramInt)
  {
    if (paramInt > 99)
    {
      this.kZf.setText("99+");
      return;
    }
    if (paramInt == 0)
    {
      this.kZf.setText("");
      return;
    }
    this.kZf.setText(String.valueOf(paramInt));
  }
  
  final void bag()
  {
    if (this.kZa != null)
    {
      if (this.kZa.kQv) {
        this.kZe.setImageDrawable(this.kZb);
      }
      for (;;)
      {
        setCount(this.kZa.kQu);
        return;
        this.kZe.setImageDrawable(this.kZc);
      }
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (q.Gj().equals(this.kZa.bVI)) {
      if (this.kZa.kQu > 0)
      {
        paramView = new Intent(getContext(), GameDetailRankLikedUI.class);
        paramView.putExtra("extra_appdi", this.mAppId);
        getContext().startActivity(paramView);
      }
    }
    while (this.kZa.kQv) {
      return;
    }
    this.kZa.kQv = true;
    paramView = this.kZa;
    paramView.kQu += 1;
    this.kYZ.aZG();
    paramView = this.mAppId;
    String str = this.kZa.bVI;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new di();
    ((b.a)localObject).ecI = new dj();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/upfriend";
    ((b.a)localObject).ecG = 1330;
    localObject = ((b.a)localObject).Kt();
    di localdi = (di)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localdi.kRX = paramView;
    localdi.kWm = str;
    w.a((com.tencent.mm.ah.b)localObject, new GameDetailRankLikeView.1(this));
    com.tencent.mm.plugin.game.e.b.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.kQh, null);
    bag();
    this.kZe.startAnimation(this.kZd);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kZb = getContext().getResources().getDrawable(g.d.game_rank_like_btn_hightlight);
    this.kZc = getContext().getResources().getDrawable(g.d.game_rank_like_btn_gray);
    this.kZd = AnimationUtils.loadAnimation(getContext(), g.a.scale_up_down);
    inflate(getContext(), g.f.game_detail2_rank_item_like, this);
    setOnClickListener(this);
    this.kZe = ((ImageView)findViewById(g.e.like_btn));
    this.kZf = ((TextView)findViewById(g.e.like_count));
  }
  
  public void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */