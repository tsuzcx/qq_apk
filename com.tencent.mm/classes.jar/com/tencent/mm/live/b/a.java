package com.tencent.mm.live.b;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "applyState", "", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "getCurrentOrientation", "getVisible", "isLandscape", "", "keyboardChange", "show", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onNetworkChange", "state", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSwipeBack", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stop", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public final ViewGroup mJe;
  
  public a(ViewGroup paramViewGroup, b paramb)
  {
    this.mJe = paramViewGroup;
    paramb.registerPlugin(this);
  }
  
  public void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    s.u(paramLinkedHashMap, "micUserMap");
  }
  
  public void applyState(int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public final int getCurrentOrientation()
  {
    Context localContext = this.mJe.getContext();
    if (localContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    return ((Activity)localContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
  }
  
  public final ViewGroup getRoot()
  {
    return this.mJe;
  }
  
  public final boolean isLandscape()
  {
    return this.mJe.getContext().getResources().getConfiguration().orientation == 2;
  }
  
  public void keyboardChange(boolean paramBoolean, int paramInt) {}
  
  public void mount() {}
  
  public String name()
  {
    String str = getClass().getSimpleName();
    s.s(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onNetworkChange(int paramInt) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
  }
  
  public boolean onSwipeBack()
  {
    return false;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void statusChange(b.c paramc, Bundle paramBundle)
  {
    s.u(paramc, "status");
  }
  
  public void stop() {}
  
  public void tO(int paramInt)
  {
    this.mJe.setVisibility(paramInt);
  }
  
  public void unMount() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */