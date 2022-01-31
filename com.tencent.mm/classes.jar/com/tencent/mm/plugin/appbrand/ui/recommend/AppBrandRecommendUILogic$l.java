package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.l;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
public final class AppBrandRecommendUILogic$l
  extends RecyclerView.m
{
  private boolean iSZ;
  private final ArrayList<Integer> iXb;
  private final ArrayList<Integer> iXc;
  
  AppBrandRecommendUILogic$l()
  {
    AppMethodBeat.i(135196);
    this.iXb = new ArrayList();
    this.iXc = new ArrayList();
    AppMethodBeat.o(135196);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135194);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (paramRecyclerView != null) {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
    }
    while ((paramRecyclerView instanceof LinearLayoutManager))
    {
      paramInt1 = ((LinearLayoutManager)paramRecyclerView).it();
      paramInt2 = ((LinearLayoutManager)paramRecyclerView).iv();
      if ((paramInt1 == 0) && (paramInt2 == 1))
      {
        j.b(this.iWS.context, AppBrandRecommendUILogic.d(this.iWS).aNe());
        AppMethodBeat.o(135194);
        return;
        paramRecyclerView = null;
      }
      else
      {
        this.iXc.clear();
        if (paramInt1 <= paramInt2)
        {
          if (paramInt1 == 0) {
            j.b(this.iWS.context, AppBrandRecommendUILogic.d(this.iWS).aNe());
          }
          for (;;)
          {
            if (paramInt1 == paramInt2) {
              break label334;
            }
            paramInt1 += 1;
            break;
            paramRecyclerView = this.iWS.aNK().bQ(paramInt1);
            if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a.c)))
            {
              this.iXc.add(Integer.valueOf(paramInt1));
              if (!this.iXb.contains(Integer.valueOf(paramInt1)))
              {
                int i = this.iWS.aNK().S(paramRecyclerView);
                ab.d(AppBrandRecommendUILogic.access$getTAG$cp(), "reportExposeData index:%d, holderPosition:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
                if (i < this.iWS.iWC.getItemCount())
                {
                  paramRecyclerView = this.iWS.iWC.aNz().get(i);
                  a.f.b.j.p(paramRecyclerView, "wxaList[position]");
                  paramRecyclerView = (bsi)paramRecyclerView;
                  AppBrandRecommendUILogic.f(this.iWS).d(i, paramRecyclerView);
                  this.iWS.iWM.put(paramRecyclerView.iFH, Long.valueOf(System.currentTimeMillis()));
                  this.iWS.iWN.put(Integer.valueOf(paramInt1), paramRecyclerView.iFH);
                  this.iWS.iWK.add(Integer.valueOf(paramInt1));
                }
              }
            }
          }
        }
        label334:
        this.iWS.iWL.clear();
        this.iXb.removeAll((Collection)this.iXc);
        this.iWS.iWL.addAll((Collection)this.iXb);
        this.iXb.clear();
        this.iXb.addAll((Collection)this.iXc);
        this.iWS.iWK.removeAll((Collection)this.iWS.iWL);
        AppBrandRecommendUILogic.a(this.iWS, this.iWS.iWL);
      }
    }
    AppMethodBeat.o(135194);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(135195);
    super.c(paramRecyclerView, paramInt);
    boolean bool;
    if (paramInt == 2)
    {
      bool = true;
      this.iSZ = bool;
      if (this.iSZ) {
        AppBrandRecommendUILogic.f(this.iWS).eV(this.iSZ);
      }
      if (paramRecyclerView == null) {
        break label112;
      }
    }
    label112:
    for (paramRecyclerView = paramRecyclerView.getLayoutManager();; paramRecyclerView = null)
    {
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        ((LinearLayoutManager)paramRecyclerView).it();
        int i = ((LinearLayoutManager)paramRecyclerView).iv();
        paramInt = i;
        if (i >= 3) {
          paramInt = i - 1;
        }
        AppBrandRecommendUILogic.c(this.iWS).cKB = paramInt;
      }
      AppMethodBeat.o(135195);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic.l
 * JD-Core Version:    0.7.0.1
 */