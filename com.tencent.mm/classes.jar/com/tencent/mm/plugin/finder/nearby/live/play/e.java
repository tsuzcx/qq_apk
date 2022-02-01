package com.tencent.mm.plugin.finder.nearby.live.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.h.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "invokeOnTouchMoveCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "invokeAutoPlayCallback", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "isInvokeAutoPlayCallbackByLongClick", "", "isInvokeAutoPlayCallbackByScroll", "onScrolledY", "onTouchPos", "handleOnScrolled", "dy", "onItemTouch", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "holder", "event", "Landroid/view/MotionEvent;", "onLongClick", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "Companion", "plugin-finder-nearby_release"})
public final class e
  implements h.e<i>
{
  public static final a zFG;
  public int zFA;
  int zFB;
  boolean zFC;
  public boolean zFD;
  public final b<Integer, x> zFE;
  final b<Integer, x> zFF;
  
  static
  {
    AppMethodBeat.i(203709);
    zFG = new a((byte)0);
    AppMethodBeat.o(203709);
  }
  
  public e(b<? super Integer, x> paramb1, b<? super Integer, x> paramb2)
  {
    AppMethodBeat.i(203706);
    this.zFE = paramb1;
    this.zFF = paramb2;
    this.zFA = -1;
    AppMethodBeat.o(203706);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter$Companion;", "", "()V", "MOVE_INVOKE_THRESHOLD", "", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.e
 * JD-Core Version:    0.7.0.1
 */