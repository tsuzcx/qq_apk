package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.y;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView fcy;
  private com.tencent.mm.plugin.game.model.d kQE;
  private TextView kYW;
  private l kZA;
  k.a kZy;
  private TextView lew;
  private ImageView lex;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bah()
  {
    if (g.a(getContext(), this.kQE))
    {
      int i = c.Fe(this.kQE.field_packageName);
      if (this.kQE.versionCode > i)
      {
        this.kYW.setText(g.i.game_detail_rank_update);
        return;
      }
      this.kYW.setText(g.i.game_detail_rank_launch);
      return;
    }
    switch (this.kQE.status)
    {
    default: 
      this.kYW.setText(g.i.game_detail_rank_download);
      return;
    }
    if (this.kZA == null)
    {
      this.kYW.setVisibility(8);
      this.lex.setVisibility(8);
      return;
    }
    this.kYW.setVisibility(0);
    this.lex.setVisibility(0);
    switch (this.kZA.status)
    {
    default: 
      return;
    case 0: 
      this.kYW.setText(g.i.game_detail_rank_download);
      return;
    case 1: 
      this.kYW.setText(g.i.game_detail_rank_downloading);
      return;
    case 2: 
      this.kYW.setText(g.i.game_detail_rank_continue);
      return;
    }
    this.kYW.setText(g.i.game_detail_rank_install);
  }
  
  public void onClick(View paramView)
  {
    paramView = new d(getContext());
    l locall = new l(this.kQE);
    paramView.a(this.kQE, locall);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.fcy = ((TextView)findViewById(g.e.game_detail_rank_title));
    this.lew = ((TextView)findViewById(g.e.game_detail_rank_desc));
    this.kYW = ((TextView)findViewById(g.e.game_detail_rank_tag));
    this.lex = ((ImageView)findViewById(g.e.game_more_icon));
    y.i("MicroMsg.GameRankHeadView", "initView finished");
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    this.fcy.setText(parama.kZr);
    this.lew.setText(parama.kZs);
    this.kQE = parama.kZt;
    this.kQE.bXn = 1203;
    this.kQE.position = 2;
    if (this.kZA == null) {
      this.kZA = new l(this.kQE);
    }
    this.kZA.dz(getContext());
    this.kZA.aGu();
    bah();
    if (this.kZy != null) {
      k.a(this.kZy);
    }
    for (;;)
    {
      this.kYW.setOnClickListener(this);
      return;
      this.kZy = new GameRankHeadView.1(this);
      k.a(this.kZy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */