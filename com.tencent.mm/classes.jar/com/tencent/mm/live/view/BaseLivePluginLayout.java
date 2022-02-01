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
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/live/view/ILivePlugin;", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "pluginList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "getPluginList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getCurrentOrientation", "", "getPluginSize", "getRelativeLayoutId", "initLogic", "", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "isLandscape", "keyboardChange", "show", "height", "mount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "", "onRotationSwitchChange", "rotationEnable", "onSwipeBack", "pause", "registerPlugin", "plugin", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseLivePluginLayout
  extends RelativeLayout
  implements b, g
{
  private ViewGroup parent;
  private final CopyOnWriteArrayList<a> pluginList = new CopyOnWriteArrayList();
  
  public BaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(getRelativeLayoutId(), (ViewGroup)this, true);
    if (paramContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    this.parent = ((ViewGroup)paramContext);
  }
  
  public int getCurrentOrientation()
  {
    Context localContext = getContext();
    if (localContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    return ((Activity)localContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
  }
  
  protected final ViewGroup getParent()
  {
    return this.parent;
  }
  
  public final CopyOnWriteArrayList<a> getPluginList()
  {
    return this.pluginList;
  }
  
  public int getPluginSize()
  {
    return this.pluginList.size();
  }
  
  public abstract int getRelativeLayoutId();
  
  public abstract void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean);
  
  public boolean isLandscape()
  {
    return getContext().getResources().getConfiguration().orientation == 2;
  }
  
  public boolean isLiving()
  {
    s.u(this, "this");
    return true;
  }
  
  public void keyboardChange(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).keyboardChange(paramBoolean, paramInt);
    }
  }
  
  public void mount()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).mount();
    }
  }
  
  public String name()
  {
    s.u(this, "this");
    String str = getClass().getSimpleName();
    s.s(str, "this.javaClass.simpleName");
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.onBackPress())
      {
        Log.i(name(), s.X(locala.name(), " handle back-press"));
        return true;
      }
    }
    return false;
  }
  
  public abstract void onCallStateChanged(int paramInt, String paramString);
  
  public abstract void onRotationSwitchChange(boolean paramBoolean);
  
  public boolean onSwipeBack()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.onSwipeBack())
      {
        Log.i(name(), s.X(locala.name(), " handle onSwipeBack"));
        return true;
      }
    }
    return false;
  }
  
  public void pause()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).pause();
    }
  }
  
  public void registerPlugin(a parama)
  {
    if (parama != null)
    {
      Log.i(name(), s.X("register plugin ", parama.name()));
      getPluginList().add(parama);
    }
  }
  
  public void resume()
  {
    setVisibility(0);
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).resume();
    }
  }
  
  protected final void setParent(ViewGroup paramViewGroup)
  {
    s.u(paramViewGroup, "<set-?>");
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
    s.u(paramc, "status");
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).statusChange(paramc, paramBundle);
    }
  }
  
  public void stop()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).stop();
    }
  }
  
  public void unMount()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).unMount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.BaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */