package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/RoomLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "floatScene", "updateState", "", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "plugin-logic_release"})
public final class RoomLiveMiniView
  extends AbsLiveMiniView
{
  public RoomLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(208646);
    AppMethodBeat.o(208646);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208647);
    AppMethodBeat.o(208647);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208645);
    paramContext = x.hJf;
    setOnClickListener(x.aHc());
    AppMethodBeat.o(208645);
  }
  
  public final int aEg()
  {
    return 16;
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(208644);
    p.h(paramd, "state");
    AppMethodBeat.o(208644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomLiveMiniView
 * JD-Core Version:    0.7.0.1
 */