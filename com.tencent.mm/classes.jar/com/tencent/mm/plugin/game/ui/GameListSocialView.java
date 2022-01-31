package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
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
    super.onFinishInflate();
  }
  
  public void setData(LinkedList<String> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0) || (paramLinkedList.size() % 2 != 0)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      if (getChildCount() < paramLinkedList.size() / 2)
      {
        int j = paramLinkedList.size() / 2;
        int k = getChildCount();
        i = 0;
        while (i < j - k)
        {
          inflate(getContext(), g.f.game_list_item_social_item, this);
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
        TextView localTextView = (TextView)((View)localObject).findViewById(g.e.game_social_item_text1);
        localObject = (TextView)((View)localObject).findViewById(g.e.game_social_item_text2);
        localTextView.setText(j.a(getContext(), (CharSequence)paramLinkedList.get(i * 2), localTextView.getTextSize()));
        ((TextView)localObject).setText(j.a(getContext(), (CharSequence)paramLinkedList.get(i * 2 + 1), ((TextView)localObject).getTextSize()));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameListSocialView
 * JD-Core Version:    0.7.0.1
 */