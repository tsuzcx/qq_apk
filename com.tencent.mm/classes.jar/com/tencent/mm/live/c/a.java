package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "getCurrentOrientation", "", "getVisible", "isLandscape", "", "keyboardChange", "", "show", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class a
  implements com.tencent.mm.live.view.a
{
  public final ViewGroup gnb;
  
  public a(ViewGroup paramViewGroup, b paramb)
  {
    this.gnb = paramViewGroup;
    paramb.a(this);
  }
  
  public void a(b.c paramc, Bundle paramBundle)
  {
    k.h(paramc, "status");
  }
  
  public void alM() {}
  
  public void alN() {}
  
  public boolean alO()
  {
    return false;
  }
  
  public final boolean aly()
  {
    Object localObject = this.gnb.getContext();
    k.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "root.context.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  public final int getCurrentOrientation()
  {
    Object localObject = this.gnb.getContext();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    k.g(localObject, "(root.context as Activity).window");
    localObject = ((Window)localObject).getWindowManager();
    k.g(localObject, "(root.context as Activity).window.windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    k.g(localObject, "(root.context as Activit…dowManager.defaultDisplay");
    return ((Display)localObject).getRotation();
  }
  
  public void i(boolean paramBoolean, int paramInt) {}
  
  public String name()
  {
    String str = getClass().getSimpleName();
    k.g(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void nj(int paramInt)
  {
    this.gnb.setVisibility(paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.a
 * JD-Core Version:    0.7.0.1
 */