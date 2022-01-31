package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater fhz;
  private int kQh;
  private LinearLayout kjd;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(dh paramdh, int paramInt1, int paramInt2)
  {
    if ((paramdh == null) || (bk.dk(paramdh.kTw))) {
      setVisibility(8);
    }
    do
    {
      return;
      this.kQh = paramInt2;
      if (this.fhz == null) {
        this.fhz = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
      }
      this.kjd.removeAllViews();
      LinearLayout localLinearLayout;
      while (this.kjd.getChildCount() < paramdh.kTw.size())
      {
        localLinearLayout = (LinearLayout)this.fhz.inflate(g.f.game_new_classify_item, this, false);
        localLinearLayout.setOnClickListener(this);
        this.kjd.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      }
      paramInt2 = 0;
      if (paramInt2 < this.kjd.getChildCount())
      {
        if (paramInt2 < paramdh.kTw.size()) {
          this.kjd.getChildAt(paramInt2).setVisibility(0);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.kjd.getChildAt(paramInt2).setVisibility(8);
        }
      }
      paramInt2 = 0;
      while (paramInt2 < paramdh.kTw.size())
      {
        localLinearLayout = (LinearLayout)this.kjd.getChildAt(paramInt2);
        ImageView localImageView = (ImageView)localLinearLayout.findViewById(g.e.game_classify_icon);
        TextView localTextView = (TextView)localLinearLayout.findViewById(g.e.game_classify_text);
        e.baw().g(localImageView, ((dg)paramdh.kTw.get(paramInt2)).kSy);
        localTextView.setText(((dg)paramdh.kTw.get(paramInt2)).bGw);
        localLinearLayout.setTag(new GameNewClassifyView.a(((dg)paramdh.kTw.get(paramInt2)).kRP, paramInt2 + 1, ((dg)paramdh.kTw.get(paramInt2)).kSs));
        paramInt2 += 1;
      }
      setVisibility(0);
    } while (paramInt1 != 2);
    a.a(getContext(), 10, 1019, 0, null, this.kQh, null);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameNewClassifyView.a))) {}
    do
    {
      return;
      paramView = (GameNewClassifyView.a)paramView.getTag();
    } while (bk.bl(paramView.url));
    c.an(getContext(), paramView.url);
    b.a(getContext(), 10, 1019, paramView.position, 7, null, this.kQh, a.fy(paramView.extInfo));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.fhz = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.kjd = ((LinearLayout)findViewById(g.e.game_list));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */