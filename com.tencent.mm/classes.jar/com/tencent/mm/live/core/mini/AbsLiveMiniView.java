package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "floatScene", "updateState", "", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "plugin-core_release"})
public abstract class AbsLiveMiniView
  extends FrameLayout
{
  public AbsLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int aEg();
  
  public abstract void b(d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.AbsLiveMiniView
 * JD-Core Version:    0.7.0.1
 */