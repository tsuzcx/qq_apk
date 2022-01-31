package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView kXA;
  private e kXy;
  private TextView kXz;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if ((this.kXy == null) || (this.kXy.kOu == null) || (this.kXy.kOu.kTo == null) || (bk.bl(this.kXy.kOu.kTo.kTQ))) {
      return;
    }
    int i = c.an(getContext(), this.kXy.kOu.kTo.kTQ);
    b.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), a.fy(this.kXy.kOu.kSs));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kXz = ((TextView)findViewById(g.e.more_game_text));
    this.kXA = ((ImageView)findViewById(g.e.more_game_arrow));
    setOnClickListener(this);
  }
  
  public void setData(e parame)
  {
    this.kXy = parame;
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTo == null) || (bk.bl(parame.kOu.kTo.kTx)))
    {
      this.kXz.setVisibility(8);
      this.kXA.setVisibility(8);
      setPadding(0, 0, 0, 0);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(g.c.GameLargePadding), 0, getResources().getDimensionPixelSize(g.c.GameLargePadding), getResources().getDimensionPixelSize(g.c.GameLargePadding));
    this.kXz.setVisibility(0);
    this.kXA.setVisibility(0);
    this.kXz.setText(parame.kOu.kTo.kTx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */