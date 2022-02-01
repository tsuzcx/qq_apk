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
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "getCurrentOrientation", "", "getVisible", "isLandscape", "", "keyboardChange", "", "show", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class a
  implements com.tencent.mm.live.view.a
{
  public final ViewGroup gJt;
  
  public a(ViewGroup paramViewGroup, b paramb)
  {
    this.gJt = paramViewGroup;
    paramb.a(this);
  }
  
  public void a(b.c paramc, Bundle paramBundle)
  {
    p.h(paramc, "status");
  }
  
  public final boolean aoA()
  {
    Object localObject = this.gJt.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "root.context.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  public void aoO() {}
  
  public void aoP() {}
  
  public boolean aoQ()
  {
    return false;
  }
  
  public final int getCurrentOrientation()
  {
    Object localObject = this.gJt.getContext();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "(root.context as Activity).window");
    localObject = ((Window)localObject).getWindowManager();
    p.g(localObject, "(root.context as Activity).window.windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "(root.context as Activit…dowManager.defaultDisplay");
    return ((Display)localObject).getRotation();
  }
  
  public void i(boolean paramBoolean, int paramInt) {}
  
  public void nL(int paramInt)
  {
    this.gJt.setVisibility(paramInt);
  }
  
  public String name()
  {
    String str = getClass().getSimpleName();
    p.g(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.a
 * JD-Core Version:    0.7.0.1
 */