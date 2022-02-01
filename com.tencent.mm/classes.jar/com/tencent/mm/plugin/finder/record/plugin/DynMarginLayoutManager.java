package com.tencent.mm.plugin.finder.record.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/DynMarginLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "anchorOffset", "", "(Landroid/content/Context;I)V", "getAnchorOffset", "()I", "maxOffset", "maxRange", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "updateChildren", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public class DynMarginLayoutManager
  extends LinearLayoutManager
{
  private final int FiA;
  private final int FiB;
  private final int Fiz;
  
  public DynMarginLayoutManager(Context paramContext, int paramInt)
  {
    super(0, false);
    AppMethodBeat.i(337018);
    this.Fiz = paramInt;
    this.FiA = paramContext.getResources().getDimensionPixelSize(l.c.Edge_3A);
    this.FiB = paramContext.getResources().getDimensionPixelSize(l.c.Edge_7A);
    AppMethodBeat.o(337018);
  }
  
  private final void aVW()
  {
    AppMethodBeat.i(337024);
    int k = getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      int m;
      int i;
      if (localView != null)
      {
        m = (localView.getLeft() + localView.getRight()) / 2;
        if (m >= this.Fiz - this.FiB) {
          break label149;
        }
        i = -this.FiA;
      }
      for (;;)
      {
        localView.setTranslationX(i);
        Log.d("MicroMsg.FinderTemplateListPlugin", "center: " + m + " tx: " + localView.getTranslationX() + " ao: " + this.Fiz + " mr: " + this.FiB + " mo: " + this.FiA);
        j += 1;
        break;
        label149:
        if (m > this.Fiz + this.FiB) {
          i = this.FiA;
        } else {
          i = (m - this.Fiz) * this.FiA / this.FiB;
        }
      }
    }
    AppMethodBeat.o(337024);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(337041);
    super.onLayoutChildren(paramn, params);
    aVW();
    AppMethodBeat.o(337041);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(337031);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    aVW();
    AppMethodBeat.o(337031);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.DynMarginLayoutManager
 * JD-Core Version:    0.7.0.1
 */