package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/RoomLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyState", "", "state", "enableCloseBtn", "closeClickListener", "Lkotlin/Function0;", "floatScene", "releaseState", "setState", "updateCloseBtnVisible", "show", "", "plugin-logic_release"})
public final class RoomLiveMiniView
  extends AbsLiveMiniView
{
  public RoomLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(190714);
    AppMethodBeat.o(190714);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190716);
    AppMethodBeat.o(190716);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190711);
    View.inflate(MMApplicationContext.getContext(), b.f.live_mini_view_ui, (ViewGroup)this);
    paramContext = u.kwz;
    setOnClickListener(u.aPc());
    AppMethodBeat.o(190711);
  }
  
  public final int aMn()
  {
    return 16;
  }
  
  public final void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(190701);
    View localView = findViewById(b.e.chatroom_live_mini_view_close_group);
    p.j(localView, "findViewById<View>(R.id.…ve_mini_view_close_group)");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(190701);
      return;
    }
  }
  
  public final void setState(int paramInt) {}
  
  public final void tj(int paramInt) {}
  
  public final void tk(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomLiveMiniView
 * JD-Core Version:    0.7.0.1
 */