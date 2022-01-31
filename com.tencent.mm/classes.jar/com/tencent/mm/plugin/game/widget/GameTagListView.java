package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class GameTagListView
  extends LinearLayout
{
  private int textColor;
  private int textSize;
  
  public GameTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void f(LinkedList<String> paramLinkedList, int paramInt)
  {
    if (bk.dk(paramLinkedList))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject1 = new TextView(getContext());
      ((TextView)localObject1).setBackgroundResource(g.d.game_tag_text_style);
      ((TextView)localObject1).setMaxLines(1);
      ((TextView)localObject1).setTextColor(this.textColor);
      ((TextView)localObject1).setTextSize(0, this.textSize);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(g.c.GameMiniPadding), 0);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      addView((View)localObject1);
    }
    int i = 0;
    float f1 = 0.0F;
    for (;;)
    {
      int j = i;
      if (i < paramLinkedList.size())
      {
        localObject1 = (String)paramLinkedList.get(i);
        y.d("MicroMsg.GameTagListView", (String)localObject1);
        localObject2 = (TextView)getChildAt(i);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        float f2 = ((TextView)localObject2).getPaint().measureText((String)localObject1);
        float f3 = ((TextView)localObject2).getPaddingLeft();
        float f4 = ((TextView)localObject2).getPaddingRight();
        f1 = getResources().getDimensionPixelSize(g.c.GameMiniPadding) + (f2 + f3 + f4 + f1);
        if (f1 > paramInt)
        {
          ((TextView)localObject2).setVisibility(8);
          j = i;
        }
      }
      else
      {
        while (j < getChildCount())
        {
          getChildAt(j).setVisibility(8);
          j += 1;
        }
        break;
      }
      i += 1;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.textColor = getResources().getColor(g.b.game_title_color);
    this.textSize = getResources().getDimensionPixelSize(g.c.GameNormalTextSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameTagListView
 * JD-Core Version:    0.7.0.1
 */