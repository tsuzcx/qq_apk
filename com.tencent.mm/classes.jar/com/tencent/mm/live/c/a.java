package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "applyState", "", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "getCurrentOrientation", "getVisible", "isLandscape", "", "keyboardChange", "show", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onNetworkChange", "state", "onSwipeBack", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stop", "unMount", "plugin-logic_release"})
public abstract class a
{
  public final ViewGroup kiF;
  
  public a(ViewGroup paramViewGroup, b paramb)
  {
    this.kiF = paramViewGroup;
    paramb.registerPlugin(this);
  }
  
  public void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    p.k(paramLinkedHashMap, "micUserMap");
  }
  
  public void applyState(int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public final int getCurrentOrientation()
  {
    Object localObject = this.kiF.getContext();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    p.j(localObject, "(root.context as Activity).window");
    localObject = ((Window)localObject).getWindowManager();
    p.j(localObject, "(root.context as Activity).window.windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.j(localObject, "(root.context as Activit…dowManager.defaultDisplay");
    return ((Display)localObject).getRotation();
  }
  
  public final boolean isLandscape()
  {
    Object localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "root.context.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  public void keyboardChange(boolean paramBoolean, int paramInt) {}
  
  public void mount() {}
  
  public String name()
  {
    String str = getClass().getSimpleName();
    p.j(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onNetworkChange(int paramInt) {}
  
  public boolean onSwipeBack()
  {
    return false;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void statusChange(b.c paramc, Bundle paramBundle)
  {
    p.k(paramc, "status");
  }
  
  public void tU(int paramInt)
  {
    this.kiF.setVisibility(paramInt);
  }
  
  public void unMount() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.a
 * JD-Core Version:    0.7.0.1
 */