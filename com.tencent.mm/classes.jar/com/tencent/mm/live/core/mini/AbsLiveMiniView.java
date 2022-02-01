package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyState", "", "state", "floatScene", "releaseState", "setState", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AbsLiveMiniView
  extends FrameLayout
{
  public static final AbsLiveMiniView.a mUC = new AbsLiveMiniView.a((byte)0);
  
  public AbsLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int bfN();
  
  public abstract void setState(int paramInt);
  
  public abstract void te(int paramInt);
  
  public abstract void tf(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.AbsLiveMiniView
 * JD-Core Version:    0.7.0.1
 */