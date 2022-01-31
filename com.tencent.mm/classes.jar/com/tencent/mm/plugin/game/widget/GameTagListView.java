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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(112412);
    if (bo.es(paramLinkedList))
    {
      setVisibility(8);
      AppMethodBeat.o(112412);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject1 = new TextView(getContext());
      ((TextView)localObject1).setBackgroundResource(2130839038);
      ((TextView)localObject1).setMaxLines(1);
      ((TextView)localObject1).setTextColor(this.textColor);
      ((TextView)localObject1).setTextSize(0, this.textSize);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(2131427731), 0);
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
        ab.d("MicroMsg.GameTagListView", (String)localObject1);
        localObject2 = (TextView)getChildAt(i);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        float f2 = ((TextView)localObject2).getPaint().measureText((String)localObject1);
        float f3 = ((TextView)localObject2).getPaddingLeft();
        float f4 = ((TextView)localObject2).getPaddingRight();
        f1 = getResources().getDimensionPixelSize(2131427731) + (f2 + f3 + f4 + f1);
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
      }
      i += 1;
    }
    AppMethodBeat.o(112412);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112411);
    super.onFinishInflate();
    this.textColor = getResources().getColor(2131690108);
    this.textSize = getResources().getDimensionPixelSize(2131427733);
    AppMethodBeat.o(112411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameTagListView
 * JD-Core Version:    0.7.0.1
 */