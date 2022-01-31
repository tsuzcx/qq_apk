package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedModuleTitle
  extends LinearLayout
{
  private TextView haW;
  
  public GameFeedModuleTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.haW = ((TextView)findViewById(g.e.game_feed_title));
  }
  
  public void setData(e parame)
  {
    if ((parame == null) || (bk.bl(parame.kOt)))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.haW.setText(parame.kOt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedModuleTitle
 * JD-Core Version:    0.7.0.1
 */