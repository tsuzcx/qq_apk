package com.tencent.mm.plugin.finder.megavideo.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "targetSnapPos", "findSnapView", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "plugin-finder_release"})
public final class i
  extends v
{
  public static final a zyC;
  private int zyA = -1;
  b<? super Integer, x> zyB;
  
  static
  {
    AppMethodBeat.i(266459);
    zyC = new a((byte)0);
    AppMethodBeat.o(266459);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266455);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.zyA = paramInt1;
    paramLayoutManager = this.zyB;
    if (paramLayoutManager != null) {
      paramLayoutManager.invoke(Integer.valueOf(paramInt1));
    }
    Log.i("MegaVideoPagerSnapHelper", "findTargetSnapPosition: targetSnapPos = " + this.zyA);
    AppMethodBeat.o(266455);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(266457);
    View localView = super.a(paramLayoutManager);
    if (localView != null)
    {
      paramLayoutManager = localView.getLayoutParams();
      RecyclerView.LayoutManager localLayoutManager = paramLayoutManager;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        localLayoutManager = null;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)localLayoutManager;
      if (paramLayoutManager == null) {
        break label108;
      }
    }
    label108:
    for (int i = paramLayoutManager.lS();; i = -1)
    {
      Log.i("MegaVideoPagerSnapHelper", "findSnapView: targetPos = ".concat(String.valueOf(i)));
      if (this.zyA == -1)
      {
        paramLayoutManager = this.zyB;
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(i));
        }
      }
      this.zyA = -1;
      AppMethodBeat.o(266457);
      return localView;
      paramLayoutManager = null;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.i
 * JD-Core Version:    0.7.0.1
 */