package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aa;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-gamelife_release"})
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
    AppMethodBeat.i(241522);
    setBackgroundResource(2131099650);
    paramContext = aa.jQ(paramContext).inflate(2131494975, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    AppMethodBeat.o(241522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeEmptyCoverView
 * JD-Core Version:    0.7.0.1
 */