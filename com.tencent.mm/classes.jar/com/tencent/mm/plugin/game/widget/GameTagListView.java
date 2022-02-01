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
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  
  public final void i(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42623);
    if (Util.isNullOrNil(paramLinkedList))
    {
      setVisibility(8);
      AppMethodBeat.o(42623);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject1 = new TextView(getContext());
      ((TextView)localObject1).setBackgroundResource(g.d.Chk);
      ((TextView)localObject1).setMaxLines(1);
      ((TextView)localObject1).setTextColor(this.textColor);
      ((TextView)localObject1).setTextSize(0, this.textSize);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(g.c.CgU), 0);
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
        Log.d("MicroMsg.GameTagListView", (String)localObject1);
        localObject2 = (TextView)getChildAt(i);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        float f2 = ((TextView)localObject2).getPaint().measureText((String)localObject1);
        float f3 = ((TextView)localObject2).getPaddingLeft();
        float f4 = ((TextView)localObject2).getPaddingRight();
        f1 = getResources().getDimensionPixelSize(g.c.CgU) + (f2 + f3 + f4 + f1);
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
    AppMethodBeat.o(42623);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42622);
    super.onFinishInflate();
    this.textColor = getResources().getColor(g.b.CgG);
    this.textSize = getResources().getDimensionPixelSize(g.c.CgV);
    AppMethodBeat.o(42622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameTagListView
 * JD-Core Version:    0.7.0.1
 */