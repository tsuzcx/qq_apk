package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMessageListContainerView
  extends LinearLayout
{
  private Context mContext;
  
  public GameMessageListContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void a(o paramo, LinkedList<o.l> paramLinkedList, int paramInt1, int paramInt2, f<String, Bitmap> paramf)
  {
    AppMethodBeat.i(42284);
    if ((paramo == null) || (Util.isNullOrNil(paramLinkedList)))
    {
      setVisibility(8);
      AppMethodBeat.o(42284);
      return;
    }
    setVisibility(0);
    if (paramInt1 > paramLinkedList.size()) {}
    int j;
    GameMessageListUserIconView localGameMessageListUserIconView;
    for (int i = 1;; i = 2)
    {
      j = this.mContext.getResources().getDimensionPixelSize(h.c.BasicPaddingSize);
      while (getChildCount() < i)
      {
        localGameMessageListUserIconView = new GameMessageListUserIconView(this.mContext);
        if (getChildCount() > 0) {
          localGameMessageListUserIconView.setPadding(0, j, 0, 0);
        }
        localGameMessageListUserIconView.setSourceScene(paramInt2);
        addView(localGameMessageListUserIconView);
      }
    }
    paramInt2 = 0;
    if (paramInt2 < getChildCount())
    {
      if (paramInt2 < i)
      {
        getChildAt(paramInt2).setVisibility(0);
        localGameMessageListUserIconView = (GameMessageListUserIconView)getChildAt(paramInt2);
        LinkedList localLinkedList = new LinkedList();
        j = paramInt2 * paramInt1;
        while ((j < (paramInt2 + 1) * paramInt1) && (j < paramLinkedList.size()))
        {
          localLinkedList.add((o.l)paramLinkedList.get(j));
          j += 1;
        }
        localGameMessageListUserIconView.a(paramo, localLinkedList, paramf);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        getChildAt(paramInt2).setVisibility(8);
      }
    }
    AppMethodBeat.o(42284);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42283);
    super.onFinishInflate();
    AppMethodBeat.o(42283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListContainerView
 * JD-Core Version:    0.7.0.1
 */