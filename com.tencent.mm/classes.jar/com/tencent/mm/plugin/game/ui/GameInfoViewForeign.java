package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.y;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int djo = 0;
  private int kQh = 0;
  private TextView lca;
  private int lcb = 2;
  private View.OnClickListener lcc = new GameInfoViewForeign.1(this);
  private Context mContext;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void baj()
  {
    this.djo = ((c)g.r(c.class)).aYf().aZv();
    if ((this.djo > 0) && (this.djo <= 99))
    {
      this.lca.setVisibility(0);
      this.lca.setText(this.djo);
      return;
    }
    if (this.djo > 99)
    {
      this.lca.setVisibility(0);
      this.lca.setText("99+");
      this.lca.setTextSize(1, 9.0F);
      return;
    }
    this.lca.setVisibility(4);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this.lcc);
    this.lca = ((TextView)findViewById(g.e.game_msg_unread_count));
    baj();
    y.i("MicroMsg.GameInfoViewForeign", "initView finished");
  }
  
  public void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */