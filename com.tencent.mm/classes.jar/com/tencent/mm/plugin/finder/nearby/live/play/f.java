package com.tencent.mm.plugin.finder.nearby.live.play;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isEnableVoice", "", "invokeOnTouchMoveCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "invokeAutoPlayCallback", "(Landroidx/recyclerview/widget/RecyclerView;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "flingClickEvent", "Landroid/view/MotionEvent;", "isFling", "isFlingClick", "isInvokeAutoPlayCallbackByLongClick", "isInvokeAutoPlayCallbackByScroll", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "onScrolledY", "onTouchPos", "calculateCurrentTouchPosition", "firstVisibleItemPos", "", "lastVisibleItemPos", "getCurrentTouchPosition", "handleOnScrolled", "dy", "onItemTouch", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "holder", "event", "onLongClick", "onRecyclerViewTouchEvent", "onScrollStateChanged", "newState", "onScrolled", "dx", "readyToPlay", "safelyInvoke", "T", "defaultValue", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements i.e<com.tencent.mm.view.recyclerview.j>
{
  public static final a EKP;
  public final b<Integer, ah> EKQ;
  final b<Integer, ah> EKR;
  public int EKS;
  int EKT;
  boolean EKU;
  public boolean EKV;
  boolean EKW;
  boolean EKX;
  MotionEvent EKY;
  private final kotlin.j EKZ;
  final boolean EKx;
  private final RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(340958);
    EKP = new a((byte)0);
    AppMethodBeat.o(340958);
  }
  
  public f(RecyclerView paramRecyclerView, boolean paramBoolean, b<? super Integer, ah> paramb1, b<? super Integer, ah> paramb2)
  {
    AppMethodBeat.i(340911);
    this.mkw = paramRecyclerView;
    this.EKx = paramBoolean;
    this.EKQ = paramb1;
    this.EKR = paramb2;
    this.EKS = -1;
    this.EKZ = k.cm((a)new c(this));
    AppMethodBeat.o(340911);
  }
  
  private static <T> T c(T paramT, a<? extends T> parama)
  {
    AppMethodBeat.i(340925);
    try
    {
      parama = parama.invoke();
      paramT = parama;
    }
    finally
    {
      for (;;)
      {
        Log.e("NearbyLiveItemOnTouchEventAdapter", "safelyInvoke exception", new Object[] { parama.getMessage() });
      }
    }
    AppMethodBeat.o(340925);
    return paramT;
  }
  
  private final StaggeredGridLayoutManager eFf()
  {
    AppMethodBeat.i(340920);
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(340920);
    return localStaggeredGridLayoutManager;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter$Companion;", "", "()V", "MOVE_INVOKE_THRESHOLD", "", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Integer>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<StaggeredGridLayoutManager>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(f paramf)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(f paramf, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.f
 * JD-Core Version:    0.7.0.1
 */