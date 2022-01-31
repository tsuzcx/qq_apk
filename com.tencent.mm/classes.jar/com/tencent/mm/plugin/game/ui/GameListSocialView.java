package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.LinkedList;

public class GameListSocialView
  extends LinearLayout
{
  public GameListSocialView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112063);
    super.onFinishInflate();
    AppMethodBeat.o(112063);
  }
  
  public void setData(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112064);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0) || (paramLinkedList.size() % 2 != 0))
    {
      setVisibility(8);
      AppMethodBeat.o(112064);
      return;
    }
    setVisibility(0);
    if (getChildCount() < paramLinkedList.size() / 2)
    {
      int j = paramLinkedList.size() / 2;
      int k = getChildCount();
      i = 0;
      while (i < j - k)
      {
        inflate(getContext(), 2130969781, this);
        i += 1;
      }
    }
    int i = 0;
    if (i < getChildCount())
    {
      if (i < paramLinkedList.size() / 2) {
        getChildAt(i).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        getChildAt(i).setVisibility(8);
      }
    }
    i = 0;
    while (i < paramLinkedList.size() / 2)
    {
      Object localObject = getChildAt(i);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131824684);
      localObject = (TextView)((View)localObject).findViewById(2131824685);
      localTextView.setText(j.b(getContext(), (CharSequence)paramLinkedList.get(i * 2), localTextView.getTextSize()));
      ((TextView)localObject).setText(j.b(getContext(), (CharSequence)paramLinkedList.get(i * 2 + 1), ((TextView)localObject).getTextSize()));
      i += 1;
    }
    AppMethodBeat.o(112064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameListSocialView
 * JD-Core Version:    0.7.0.1
 */