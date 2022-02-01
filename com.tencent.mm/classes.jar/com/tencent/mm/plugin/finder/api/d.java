package com.tencent.mm.plugin.finder.api;

import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "", "addSyncHandler", "", "cmdId", "", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "doSync", "selector", "scene", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "unregister", "Companion", "plugin-finder_release"})
public abstract interface d
{
  public static final d.a qWw = d.a.qWy;
  
  public abstract void a(int paramInt, e parame);
  
  public abstract void a(MMFinderUI paramMMFinderUI);
  
  public abstract void b(int paramInt, e parame);
  
  public abstract void b(MMFinderUI paramMMFinderUI);
  
  public abstract void fx(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d
 * JD-Core Version:    0.7.0.1
 */