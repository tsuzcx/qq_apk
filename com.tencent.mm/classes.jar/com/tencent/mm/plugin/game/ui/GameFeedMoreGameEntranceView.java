package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.cm;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private e kXy;
  private TextView lh;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
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
    b.a(getContext(), 10, 1024, this.kXy.position, i, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), a.O(this.kXy.kOu.kSs, "clickType", "card"));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.lh = ((TextView)findViewById(g.e.more_game_text));
    setOnClickListener(this);
  }
  
  public void setData(e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTq == null)) {
      setVisibility(8);
    }
    do
    {
      return;
      this.kXy = parame;
      setVisibility(0);
      this.lh.setText(parame.kOu.kTq.kRN);
    } while (this.kXy.kOw);
    a.a(getContext(), 10, 1024, this.kXy.position, this.kXy.kOu.euK, GameIndexListView.getSourceScene(), a.fy(this.kXy.kOu.kSs));
    this.kXy.kOw = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */