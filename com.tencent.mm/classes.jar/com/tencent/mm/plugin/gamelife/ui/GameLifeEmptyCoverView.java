package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.d.a;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.ui.af;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLifeEmptyCoverView
  extends FrameLayout
{
  public GameLifeEmptyCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(267821);
    AppMethodBeat.o(267821);
  }
  
  public GameLifeEmptyCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(267807);
    setBackgroundResource(d.a.BG_2);
    paramContext = af.mU(paramContext).inflate(d.d.Jaa, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    AppMethodBeat.o(267807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeEmptyCoverView
 * JD-Core Version:    0.7.0.1
 */