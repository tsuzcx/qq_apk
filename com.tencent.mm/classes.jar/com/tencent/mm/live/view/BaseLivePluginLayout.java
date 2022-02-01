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
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/live/view/ILivePlugin;", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "parent", "Landroid/view/ViewGroup;", "pluginList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "getCurrentOrientation", "", "getRelativeLayoutId", "initLogic", "", "router", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "isLandscape", "keyboardChange", "show", "height", "mount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "", "onRotationSwitchChange", "rotationEnable", "pause", "registerPlugin", "plugin", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class BaseLivePluginLayout
  extends RelativeLayout
  implements b, a
{
  private ViewGroup gsV;
  private final ArrayList<com.tencent.mm.live.c.a> hcO = new ArrayList();
  private final c<yh> hcP;
  private final c<?> hcQ;
  
  public BaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(getRelativeLayoutId(), (ViewGroup)this, true);
    if (paramContext == null) {
      throw new v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    this.gsV = ((ViewGroup)paramContext);
    this.hcP = ((c)new a(this));
    this.hcQ = ((c)new b(this));
  }
  
  public abstract void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean);
  
  public final void a(com.tencent.mm.live.c.a parama)
  {
    ae.i(name(), "register plugin " + parama.name());
    this.hcO.add(parama);
  }
  
  public void a(b.c paramc, Bundle paramBundle)
  {
    p.h(paramc, "status");
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).a(paramc, paramBundle);
    }
  }
  
  public final boolean aoA()
  {
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  public void aoO()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).aoO();
    }
    this.hcP.alive();
    this.hcQ.alive();
  }
  
  public void aoP()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).aoP();
    }
    this.hcP.dead();
    this.hcQ.dead();
  }
  
  public boolean aoQ()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.c.a locala = (com.tencent.mm.live.c.a)localIterator.next();
      if (locala.aoQ())
      {
        ae.i(name(), locala.name() + " handle back-press");
        return true;
      }
    }
    return false;
  }
  
  public abstract void dY(boolean paramBoolean);
  
  public int getCurrentOrientation()
  {
    Object localObject = getContext();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getWindowManager();
    p.g(localObject, "(context as Activity).window.windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "(context as Activity).wi…dowManager.defaultDisplay");
    return ((Display)localObject).getRotation();
  }
  
  protected final ArrayList<com.tencent.mm.live.c.a> getPluginList()
  {
    return this.hcO;
  }
  
  public abstract int getRelativeLayoutId();
  
  public void i(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).i(paramBoolean, paramInt);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public abstract void onCallStateChanged(int paramInt, String paramString);
  
  public void pause()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).pause();
    }
  }
  
  public void resume()
  {
    setVisibility(0);
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).resume();
    }
  }
  
  public void start()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).start();
    }
  }
  
  public final void stop()
  {
    Iterator localIterator = ((Iterable)this.hcO).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).stop();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/BaseLivePluginLayout$mVoipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class a
    extends c<yh>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/BaseLivePluginLayout$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class b
    extends c<md>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.BaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */