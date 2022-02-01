package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "targetSnapPos", "findSnapView", "Landroid/view/View;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "plugin-finder_release"})
public final class i
  extends ak
{
  public static final i.a uMC;
  private int uMA = -1;
  b<? super Integer, x> uMB;
  
  static
  {
    AppMethodBeat.i(248601);
    uMC = new i.a((byte)0);
    AppMethodBeat.o(248601);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248599);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.uMA = paramInt1;
    paramLayoutManager = this.uMB;
    if (paramLayoutManager != null) {
      paramLayoutManager.invoke(Integer.valueOf(paramInt1));
    }
    Log.i("MegaVideoPagerSnapHelper", "findTargetSnapPosition: targetSnapPos = " + this.uMA);
    AppMethodBeat.o(248599);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(248600);
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
    for (int i = paramLayoutManager.lG();; i = -1)
    {
      Log.i("MegaVideoPagerSnapHelper", "findSnapView: targetPos = ".concat(String.valueOf(i)));
      if (this.uMA == -1)
      {
        paramLayoutManager = this.uMB;
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(i));
        }
      }
      this.uMA = -1;
      AppMethodBeat.o(248600);
      return localView;
      paramLayoutManager = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.i
 * JD-Core Version:    0.7.0.1
 */