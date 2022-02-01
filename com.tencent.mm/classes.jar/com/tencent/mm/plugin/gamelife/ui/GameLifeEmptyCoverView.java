package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.z;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-gamelife_release"})
public final class GameLifeEmptyCoverView
  extends FrameLayout
{
  public GameLifeEmptyCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public GameLifeEmptyCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212279);
    setBackgroundResource(2131099650);
    paramContext = z.jV(paramContext).inflate(2131496522, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    AppMethodBeat.o(212279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeEmptyCoverView
 * JD-Core Version:    0.7.0.1
 */