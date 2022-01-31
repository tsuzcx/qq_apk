package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.cw;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater Lu;
  int kQh;
  private ViewGroup mContainer;
  private Context mContext;
  
  public GameRecomBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
  }
  
  final void a(ag paramag, int paramInt1, int paramInt2)
  {
    this.mContainer.removeAllViews();
    if (bk.dk(paramag.kTw))
    {
      setVisibility(8);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.e.a.fy(paramag.kSs));
    }
    this.Lu.inflate(g.f.game_center_4_block_recom, this, true);
    Object localObject1 = (TextView)findViewById(g.e.recom_module_title);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(g.e.recom_item_layout);
    Object localObject2 = findViewById(g.e.recom_more_layout);
    Object localObject3 = (TextView)findViewById(g.e.recom_more_text);
    label147:
    int k;
    int i;
    label185:
    int j;
    Object localObject4;
    if (!bk.bl(paramag.kSt))
    {
      ((TextView)localObject1).setText(paramag.kSt);
      if (bk.bl(paramag.kTx)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramag.kTx);
      ((View)localObject2).setTag(new GameRecomBlockView.a(null, 999, paramag.kTy, paramag.kSs, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramag.kTw.size()) {
        break label589;
      }
      localObject1 = (cw)paramag.kTw.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label589;
        }
        k += 1;
        localObject4 = (LinearLayout)this.Lu.inflate(g.f.game_center_4_block_recom_item, this, false);
        ((LinearLayout)localObject4).setTag(new GameRecomBlockView.a(((cw)localObject1).euK, k, ((cw)localObject1).kRP, ((cw)localObject1).kSs, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(g.e.recom_item_title);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(g.e.recom_item_img);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(g.e.recom_item_name);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(g.e.recom_item_desc);
        switch (i)
        {
        default: 
          label388:
          ((TextView)localObject2).setText(((cw)localObject1).bGw);
          e.baw().g((ImageView)localObject3, ((cw)localObject1).kRO);
          localTextView.setText(((cw)localObject1).kVn);
          if (!bk.bl(((cw)localObject1).kRN)) {
            ((TextView)localObject4).setText(((cw)localObject1).kRN);
          }
          break;
        }
      }
    }
    for (;;)
    {
      j = k;
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, k, ((cw)localObject1).euK, paramInt2, com.tencent.mm.plugin.game.e.a.fy(((cw)localObject1).kSs));
        j = k;
      }
      i += 1;
      k = j;
      break label185;
      ((TextView)localObject1).setVisibility(8);
      break;
      label506:
      ((TextView)localObject3).setVisibility(8);
      break label147;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.game_recom_first_item_color));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.game_recom_second_item_color));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.game_recom_third_item_color));
      break label388;
      ((TextView)localObject4).setVisibility(8);
    }
    label589:
    paramag = new View(getContext());
    paramag.setBackgroundColor(getContext().getResources().getColor(g.b.game_divided_line_color));
    addView(paramag, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameRecomBlockView.a)))
    {
      y.w("MicroMsg.GameRecomBlockView", "getTag is null");
      return;
    }
    paramView = (GameRecomBlockView.a)paramView.getTag();
    if (bk.bl(paramView.jumpUrl))
    {
      y.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      return;
    }
    int i = c.o(this.mContext, paramView.jumpUrl, paramView.bYM);
    b.a(this.mContext, 10, 1021, paramView.kRc, i, paramView.appId, this.kQh, com.tencent.mm.plugin.game.e.a.fy(paramView.kOo));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    y.i("MicroMsg.GameRecomBlockView", "initView finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */