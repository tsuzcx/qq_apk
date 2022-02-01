package com.tencent.mm.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/IFinderMultiTaskService;", "Lcom/tencent/mm/kernel/service/IService;", "checkMoveBackFinderTask", "", "checkReenterFinderFromLauncherUI", "", "activity", "Landroid/app/Activity;", "checkShowMultiTaskDialog", "context", "Landroid/content/Context;", "enterType", "", "checkUIisFinderTask", "clearAllFinderTaskActivity", "forceClose", "getTopForegroundActivity", "isFinderForeground", "isFinderTaskForeground", "isHomeFromFinderTask", "onEnterFinder", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "onExitFinder", "onFinderBackground", "onFinderForeground", "onLauncherUIPause", "onLauncherUIStart", "reportShowPush", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface l
  extends a
{
  public abstract boolean D(Activity paramActivity);
  
  public abstract boolean E(Activity paramActivity);
  
  public abstract void R(Context paramContext, int paramInt);
  
  public abstract void a(MMFinderUI paramMMFinderUI);
  
  public abstract void b(MMFinderUI paramMMFinderUI);
  
  public abstract Activity bUR();
  
  public abstract boolean bUS();
  
  public abstract void bUT();
  
  public abstract void bUU();
  
  public abstract void bUV();
  
  public abstract void bUW();
  
  public abstract boolean bUe();
  
  public abstract boolean ep(Context paramContext);
  
  public abstract void hG(boolean paramBoolean);
  
  public abstract void onEnterFinder(MMFinderUI paramMMFinderUI);
  
  public abstract void onExitFinder(MMFinderUI paramMMFinderUI);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.l
 * JD-Core Version:    0.7.0.1
 */