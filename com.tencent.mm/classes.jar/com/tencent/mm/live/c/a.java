package com.tencent.mm.live.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "getVisible", "", "keyboardChange", "", "show", "", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class a
  implements com.tencent.mm.live.view.a
{
  public final ViewGroup pTc;
  
  public a(ViewGroup paramViewGroup, b paramb)
  {
    this.pTc = paramViewGroup;
    paramb.a(this);
  }
  
  public void X(boolean paramBoolean, int paramInt) {}
  
  public void a(b.c paramc, Bundle paramBundle)
  {
    k.h(paramc, "status");
  }
  
  public void agK(int paramInt)
  {
    this.pTc.setVisibility(paramInt);
  }
  
  public boolean dia()
  {
    return false;
  }
  
  public void fOM() {}
  
  public void fON() {}
  
  public String name()
  {
    String str = getClass().getSimpleName();
    k.g(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.a
 * JD-Core Version:    0.7.0.1
 */