package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerPageSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "TAG", "", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "loop", "", "getLoop", "()Z", "setLoop", "(Z)V", "targetStayLocateX", "", "getTargetStayLocateX", "()I", "setTargetStayLocateX", "(I)V", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "helper", "distanceToStart", "findStartView", "findTargetSnapPosition", "velocityX", "velocityY", "getHorizontalHelper", "getVerticalHelper", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends t
{
  private final String TAG = "MicroMsg.EmojiStoreV3BannerPageSnapHelper";
  boolean loop;
  private androidx.recyclerview.widget.s mlU;
  private androidx.recyclerview.widget.s mlV;
  int ybb = -1;
  
  private final int a(View paramView, androidx.recyclerview.widget.s params)
  {
    AppMethodBeat.i(270565);
    if (params == null)
    {
      AppMethodBeat.o(270565);
      return 0;
    }
    int i = params.bs(paramView);
    int j = this.ybb;
    AppMethodBeat.o(270565);
    return i - j;
  }
  
  private final androidx.recyclerview.widget.s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(270558);
    if (this.mlV == null) {
      this.mlV = androidx.recyclerview.widget.s.d(paramLayoutManager);
    }
    paramLayoutManager = this.mlV;
    AppMethodBeat.o(270558);
    return paramLayoutManager;
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = 0;
    AppMethodBeat.i(270575);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    if (paramLayoutManager.getItemCount() == 0)
    {
      AppMethodBeat.o(270575);
      return -1;
    }
    androidx.recyclerview.widget.s locals = c(paramLayoutManager);
    if (locals == null)
    {
      AppMethodBeat.o(270575);
      return -1;
    }
    int i1 = paramLayoutManager.getChildCount();
    if (i1 == 0) {}
    while (localObject2 == null)
    {
      AppMethodBeat.o(270575);
      return -1;
      if (i1 > 0)
      {
        int k = 0;
        for (i = 2147483647;; i = j)
        {
          int n = k + 1;
          localObject2 = paramLayoutManager.getChildAt(k);
          k = locals.bs((View)localObject2);
          j = i;
          if (k < i)
          {
            j = k;
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (n >= i1) {
            break;
          }
          k = n;
        }
      }
    }
    int j = paramLayoutManager.getPosition((View)localObject2);
    if (j == -1)
    {
      AppMethodBeat.o(270575);
      return -1;
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0)
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label322;
        }
        if (j != paramLayoutManager.getItemCount() - 1) {
          break label314;
        }
        if (!this.loop) {
          break label304;
        }
        paramInt2 = m;
        label211:
        localObject1 = a(paramLayoutManager);
        if (localObject1 != null) {
          break label328;
        }
      }
    }
    label304:
    label314:
    label322:
    label328:
    for (int i = -1;; i = paramLayoutManager.getPosition((View)localObject1))
    {
      Log.d(this.TAG, "findTargetSnapPosition result:" + paramInt2 + ", centerPosition:" + j + ", velocityX:" + paramInt1 + " , snapPos:" + i);
      AppMethodBeat.o(270575);
      return paramInt2;
      paramInt2 = 0;
      break;
      if (paramInt2 > 0)
      {
        paramInt2 = 1;
        break;
      }
      paramInt2 = 0;
      break;
      paramInt2 = paramLayoutManager.getItemCount() - 1;
      break label211;
      paramInt2 = j + 1;
      break label211;
      paramInt2 = j;
      break label211;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(270584);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = a(paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label89;
      }
      if (this.mlU == null) {
        this.mlU = androidx.recyclerview.widget.s.e(paramLayoutManager);
      }
      arrayOfInt[1] = a(paramView, this.mlU);
    }
    for (;;)
    {
      AppMethodBeat.o(270584);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label89:
      arrayOfInt[1] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.c
 * JD-Core Version:    0.7.0.1
 */