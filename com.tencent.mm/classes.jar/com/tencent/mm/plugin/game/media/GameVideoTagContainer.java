package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.plugin.game.autogen.b.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import java.util.LinkedList;

public class GameVideoTagContainer
  extends LinearLayout
{
  public GameVideoTagContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameVideoTagContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41167);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(41167);
  }
  
  public void setData(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(41168);
    if (Util.isNullOrNil(paramLinkedList))
    {
      setVisibility(8);
      AppMethodBeat.o(41168);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).height = bd.fromDPToPix(getContext(), 14);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = bd.fromDPToPix(getContext(), 4);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      addView((View)localObject1);
    }
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setVisibility(8);
      i += 1;
    }
    i = 0;
    while (i < paramLinkedList.size())
    {
      localObject1 = (l)paramLinkedList.get(i);
      localObject2 = (ImageView)getChildAt(i);
      ((LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams()).width = bd.fromDPToPix(getContext(), ((l)localObject1).width);
      a.bKl().loadImage(((l)localObject1).IdD, (ImageView)localObject2);
      ((ImageView)localObject2).setVisibility(0);
      i += 1;
    }
    AppMethodBeat.o(41168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoTagContainer
 * JD-Core Version:    0.7.0.1
 */