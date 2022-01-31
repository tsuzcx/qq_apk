package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.n;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView iIS;
  private TextView lbA;
  private LinearLayout lbB;
  private TextView lbC;
  private TextView lbD;
  private TextView lbE;
  private ac lbu;
  private TextView lbz;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void sj(int paramInt)
  {
    if (paramInt == 1) {}
    for (String str = a.O(this.lbu.kSs, "clickType", "leftCorner");; str = a.O(this.lbu.kSs, "clickType", "rightCorner"))
    {
      b.a(getContext(), 10, 1024, this.lbu.kSu, 7, this.lbu.euK, GameIndexListView.getSourceScene(), str);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.lbu == null) {}
    do
    {
      do
      {
        return;
        if ((paramView.getId() != g.e.left_subscript) && (paramView.getId() != g.e.left_subscript_with_box) && (paramView.getId() != g.e.avatar_sub_script)) {
          break;
        }
      } while ((this.lbu.kTs == null) || (bk.bl(this.lbu.kTs.kRP)));
      c.an(getContext(), this.lbu.kTs.kRP);
      sj(1);
      return;
    } while ((paramView.getId() != g.e.right_subscript) || (this.lbu.kTt == null) || (bk.bl(this.lbu.kTt.kRP)));
    c.an(getContext(), this.lbu.kTt.kRP);
    sj(2);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.game_feed_subscript, this, true);
    this.lbz = ((TextView)localView.findViewById(g.e.left_subscript));
    this.lbA = ((TextView)localView.findViewById(g.e.left_subscript_with_box));
    this.lbB = ((LinearLayout)localView.findViewById(g.e.avatar_sub_script));
    this.iIS = ((ImageView)localView.findViewById(g.e.avatar));
    this.lbC = ((TextView)localView.findViewById(g.e.nick_name));
    this.lbD = ((TextView)localView.findViewById(g.e.user_action));
    this.lbE = ((TextView)localView.findViewById(g.e.right_subscript));
    this.lbz.setOnClickListener(this);
    this.lbA.setOnClickListener(this);
    this.lbB.setOnClickListener(this);
    this.lbE.setOnClickListener(this);
  }
  
  public void setData(ac paramac)
  {
    if ((paramac == null) || ((paramac.kTs == null) && (paramac.kTt == null)))
    {
      setVisibility(8);
      return;
    }
    this.lbu = paramac;
    setVisibility(0);
    this.lbz.setVisibility(8);
    this.lbA.setVisibility(8);
    this.lbB.setVisibility(8);
    if (paramac.kTs != null) {
      switch (paramac.kTs.kSG)
      {
      }
    }
    while (paramac.kTt != null)
    {
      this.lbE.setText(paramac.kTt.kRN);
      this.lbE.setVisibility(0);
      return;
      this.lbz.setVisibility(0);
      this.lbz.setText(paramac.kTs.kRN);
      continue;
      this.lbA.setVisibility(0);
      this.lbA.setText(paramac.kTs.kRN);
      continue;
      this.lbB.setVisibility(0);
      if (!bk.bl(paramac.kTs.kSF))
      {
        e.a.a locala = new e.a.a();
        locala.erD = true;
        e.baw().a(this.iIS, paramac.kTs.kSF, locala.bax());
        this.iIS.setVisibility(0);
      }
      this.lbC.setText(paramac.kTs.kRZ);
      this.lbD.setText(paramac.kTs.kRN);
    }
    this.lbE.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */