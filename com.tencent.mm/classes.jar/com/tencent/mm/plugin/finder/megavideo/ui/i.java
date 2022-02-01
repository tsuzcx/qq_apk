package com.tencent.mm.plugin.finder.megavideo.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "targetSnapPos", "findSnapView", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends t
{
  public static final a EBs;
  private int EBt = -1;
  b<? super Integer, ah> EBu;
  
  static
  {
    AppMethodBeat.i(342066);
    EBs = new a((byte)0);
    AppMethodBeat.o(342066);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342074);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.EBt = paramInt1;
    paramLayoutManager = this.EBu;
    if (paramLayoutManager != null) {
      paramLayoutManager.invoke(Integer.valueOf(paramInt1));
    }
    Log.i("MegaVideoPagerSnapHelper", s.X("findTargetSnapPosition: targetSnapPos = ", Integer.valueOf(this.EBt)));
    AppMethodBeat.o(342074);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(342080);
    View localView = super.a(paramLayoutManager);
    if (localView == null)
    {
      paramLayoutManager = null;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        break label97;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)paramLayoutManager;
      label29:
      if (paramLayoutManager != null) {
        break label102;
      }
    }
    label97:
    label102:
    for (int i = -1;; i = paramLayoutManager.bXh.KJ())
    {
      Log.i("MegaVideoPagerSnapHelper", s.X("findSnapView: targetPos = ", Integer.valueOf(i)));
      if (this.EBt == -1)
      {
        paramLayoutManager = this.EBu;
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(i));
        }
      }
      this.EBt = -1;
      AppMethodBeat.o(342080);
      return localView;
      paramLayoutManager = localView.getLayoutParams();
      break;
      paramLayoutManager = null;
      break label29;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.i
 * JD-Core Version:    0.7.0.1
 */