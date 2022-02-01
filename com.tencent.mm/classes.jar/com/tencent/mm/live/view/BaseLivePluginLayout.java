package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/live/view/ILivePlugin;", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "pluginList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "getCurrentOrientation", "", "getRelativeLayoutId", "initLogic", "", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "isLandscape", "keyboardChange", "show", "height", "mount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "", "onRotationSwitchChange", "rotationEnable", "pause", "registerPlugin", "plugin", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class BaseLivePluginLayout
  extends RelativeLayout
  implements j, b, a
{
  private ViewGroup parent;
  private final ArrayList<com.tencent.mm.live.c.a> pluginList = new ArrayList();
  
  public BaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(getRelativeLayoutId(), (ViewGroup)this, true);
    if (paramContext == null) {
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    this.parent = ((ViewGroup)paramContext);
  }
  
  public int getCurrentOrientation()
  {
    Object localObject = getContext();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getWindowManager();
    p.g(localObject, "(context as Activity).window.windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "(context as Activity).wi…dowManager.defaultDisplay");
    return ((Display)localObject).getRotation();
  }
  
  protected final ViewGroup getParent()
  {
    return this.parent;
  }
  
  protected final ArrayList<com.tencent.mm.live.c.a> getPluginList()
  {
    return this.pluginList;
  }
  
  public abstract int getRelativeLayoutId();
  
  public abstract void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean);
  
  public boolean isLandscape()
  {
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  public void keyboardChange(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).keyboardChange(paramBoolean, paramInt);
    }
  }
  
  public void mount()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).mount();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.c.a locala = (com.tencent.mm.live.c.a)localIterator.next();
      if (locala.onBackPress())
      {
        Log.i(name(), locala.name() + " handle back-press");
        return true;
      }
    }
    return false;
  }
  
  public abstract void onCallStateChanged(int paramInt, String paramString);
  
  public abstract void onRotationSwitchChange(boolean paramBoolean);
  
  public void pause()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).pause();
    }
  }
  
  public void registerPlugin(com.tencent.mm.live.c.a parama)
  {
    if (parama != null)
    {
      Log.i(name(), "register plugin " + parama.name());
      this.pluginList.add(parama);
    }
  }
  
  public void resume()
  {
    setVisibility(0);
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).resume();
    }
  }
  
  protected final void setParent(ViewGroup paramViewGroup)
  {
    p.h(paramViewGroup, "<set-?>");
    this.parent = paramViewGroup;
  }
  
  public void start()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public void statusChange(b.c paramc, Bundle paramBundle)
  {
    p.h(paramc, "status");
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).statusChange(paramc, paramBundle);
    }
  }
  
  public void stop()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public void unMount()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).unMount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.BaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */