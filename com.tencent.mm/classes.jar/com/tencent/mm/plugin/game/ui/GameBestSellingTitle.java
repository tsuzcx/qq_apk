package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;

public class GameBestSellingTitle
  extends LinearLayout
{
  public GameBestSellingTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setText(String paramString)
  {
    if (bk.bl(paramString))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    ((TextView)findViewById(g.e.game_best_selling_item_title)).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingTitle
 * JD-Core Version:    0.7.0.1
 */