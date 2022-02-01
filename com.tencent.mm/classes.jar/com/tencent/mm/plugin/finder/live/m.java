package com.tencent.mm.plugin.finder.live;

import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/IFinderLiveDataLoader;", "", "getLoader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "loadData", "", "type", "", "loadParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "loading", "onAttach", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "onDetach", "preloading", "setLoader", "loader", "plugin-finder_release"})
public abstract interface m
{
  public abstract void a(c.a parama);
  
  public abstract boolean a(int paramInt, j paramj);
  
  public abstract FinderLiveRelatedLoader dwi();
  
  public abstract boolean dwj();
  
  public abstract boolean dwk();
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.m
 * JD-Core Version:    0.7.0.1
 */