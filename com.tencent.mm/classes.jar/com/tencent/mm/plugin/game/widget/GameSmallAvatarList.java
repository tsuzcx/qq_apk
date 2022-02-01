package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameSmallAvatarList
  extends LinearLayout
{
  public GameSmallAvatarList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setData(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42620);
    if (Util.isNullOrNil(paramLinkedList))
    {
      setVisibility(8);
      AppMethodBeat.o(42620);
      return;
    }
    setVisibility(0);
    Object localObject;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(h.c.HTg), getResources().getDimensionPixelSize(h.c.HTg));
      localLayoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(h.c.HTd), 0);
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      addView((View)localObject);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= paramLinkedList.size()) {
        break;
      }
      localObject = new e.a.a();
      ((e.a.a)localObject).nrc = true;
      e.fIb().a((ImageView)getChildAt(i), (String)paramLinkedList.get(i), ((e.a.a)localObject).fIc());
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while (j < getChildCount())
    {
      getChildAt(j).setVisibility(8);
      j += 1;
    }
    AppMethodBeat.o(42620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameSmallAvatarList
 * JD-Core Version:    0.7.0.1
 */