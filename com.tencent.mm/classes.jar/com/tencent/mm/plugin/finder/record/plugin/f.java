package com.tencent.mm.plugin.finder.record.plugin;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/StartEndDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "centerPos", "", "(I)V", "getCenterPos", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.h
{
  private final int Fjp;
  
  public f(int paramInt)
  {
    this.Fjp = paramInt;
  }
  
  public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int k = 0;
    int m = 0;
    AppMethodBeat.i(337000);
    s.u(paramRect, "outRect");
    s.u(paramRecyclerView, "parent");
    Object localObject = paramRecyclerView.getAdapter();
    int i;
    if (localObject == null)
    {
      i = 0;
      if (paramInt == 0)
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject != null) {
          break label143;
        }
        localObject = null;
        label55:
        int n = this.Fjp;
        if (localObject != null) {
          break label154;
        }
        j = 0;
        paramRect.left = (n - j);
      }
      if (paramInt == i - 1)
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject != null) {
          break label225;
        }
      }
    }
    label143:
    label154:
    label191:
    label215:
    label225:
    for (localObject = null;; localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(paramInt))
    {
      i = paramRecyclerView.getWidth() - this.Fjp;
      if (localObject != null) {
        break label236;
      }
      paramInt = m;
      paramRect.right = (i - paramInt);
      AppMethodBeat.o(337000);
      return;
      i = ((RecyclerView.a)localObject).getItemCount();
      break;
      localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(paramInt);
      break label55;
      int i1 = (((View)localObject).getRight() - ((View)localObject).getLeft()) / 2;
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (localObject != null) {
          break label215;
        }
      }
      for (j = 0;; j = ((ViewGroup.MarginLayoutParams)localObject).leftMargin)
      {
        j += i1;
        break;
        localObject = null;
        break label191;
      }
    }
    label236:
    int j = (((View)localObject).getRight() - ((View)localObject).getLeft()) / 2;
    paramRecyclerView = ((View)localObject).getLayoutParams();
    if ((paramRecyclerView instanceof ViewGroup.MarginLayoutParams))
    {
      paramRecyclerView = (ViewGroup.MarginLayoutParams)paramRecyclerView;
      label269:
      if (paramRecyclerView != null) {
        break label289;
      }
    }
    label289:
    for (paramInt = k;; paramInt = paramRecyclerView.rightMargin)
    {
      paramInt += j;
      break;
      paramRecyclerView = null;
      break label269;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.f
 * JD-Core Version:    0.7.0.1
 */