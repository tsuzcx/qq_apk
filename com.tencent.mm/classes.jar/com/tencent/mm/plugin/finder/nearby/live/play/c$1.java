package com.tencent.mm.plugin.finder.nearby.live.play;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder-nearby_release"})
public final class c$1
  extends RecyclerView.l
{
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(200760);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
    a.c("com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("NearbyLiveAutoPlayManager", "onScrollStateChanged newState:".concat(String.valueOf(paramInt)));
    localObject = c.d(this.zFq);
    p.k(paramRecyclerView, "recyclerView");
    if ((paramInt == 0) && (((e)localObject).zFC)) {
      ((e)localObject).zFF.invoke(Integer.valueOf(((e)localObject).zFA));
    }
    if (paramInt == 0) {
      this.zFq.dLN();
    }
    a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(200760);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200765);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
    a.c("com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    c.e(this.zFq);
    localObject = c.d(this.zFq);
    p.k(paramRecyclerView, "recyclerView");
    if (((e)localObject).zFC) {
      Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled return for isInvokeAutoPlayCallback");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(200765);
      return;
      if (((e)localObject).zFA < 0)
      {
        Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled return for onTouchPos:" + ((e)localObject).zFA);
      }
      else
      {
        if (((e)localObject).zFB == 0) {
          ((e)localObject).zFB = paramInt2;
        }
        if (Math.abs(paramInt2 - ((e)localObject).zFB) > 1)
        {
          Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled hit auto play pos:" + ((e)localObject).zFA + " (" + ((e)localObject).zFB + ", " + paramInt2 + ')');
          ((e)localObject).zFE.invoke(Integer.valueOf(((e)localObject).zFA));
          ((e)localObject).zFC = true;
        }
        else
        {
          Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled auto play pos:" + ((e)localObject).zFA + " (" + ((e)localObject).zFB + ", " + paramInt2 + " move:" + Math.abs(paramInt2 - ((e)localObject).zFB) + " threshold:1");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.c.1
 * JD-Core Version:    0.7.0.1
 */