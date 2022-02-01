package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyState", "", "state", "floatScene", "releaseState", "setState", "Companion", "plugin-core_release"})
public abstract class AbsLiveMiniView
  extends FrameLayout
{
  public static final a kqD = new a((byte)0);
  
  public AbsLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int aMn();
  
  public abstract void setState(int paramInt);
  
  public abstract void tj(int paramInt);
  
  public abstract void tk(int paramInt);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/AbsLiveMiniView$Companion;", "", "()V", "STATE_DISCONNECT", "", "STATE_FINISH", "STATE_NORMAL", "STATE_PAUSE", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.AbsLiveMiniView
 * JD-Core Version:    0.7.0.1
 */