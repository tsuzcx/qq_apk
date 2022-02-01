package com.tencent.mm.live.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/live/view/ILivePlugin;", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "multiTalkActionListener", "parent", "Landroid/view/ViewGroup;", "pluginList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "getRelativeLayoutId", "", "initLogic", "", "router", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "keyboardChange", "show", "height", "mount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "", "pause", "registerPlugin", "plugin", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class BaseLivePluginLayout
  extends RelativeLayout
  implements b, a
{
  private final c<ww> KzT;
  private ViewGroup fSZ;
  private final c<?> tPg;
  public final ArrayList<com.tencent.mm.live.c.a> vnf = new ArrayList();
  
  public BaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(getRelativeLayoutId(), (ViewGroup)this, true);
    if (paramContext == null) {
      throw new v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    this.fSZ = ((ViewGroup)paramContext);
    this.KzT = ((c)new a(this));
    this.tPg = ((c)new b(this));
  }
  
  public abstract void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean);
  
  public final void a(com.tencent.mm.live.c.a parama)
  {
    ad.i(name(), "register plugin " + parama.name());
    this.vnf.add(parama);
  }
  
  public void a(b.c paramc, Bundle paramBundle)
  {
    k.h(paramc, "status");
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).a(paramc, paramBundle);
    }
  }
  
  public boolean dia()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.c.a locala = (com.tencent.mm.live.c.a)localIterator.next();
      if (locala.dia())
      {
        ad.i(name(), locala.name() + " handle back-press");
        return true;
      }
    }
    return false;
  }
  
  public void fOM()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).fOM();
    }
    this.KzT.alive();
    this.tPg.alive();
  }
  
  public void fON()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).fON();
    }
    this.KzT.dead();
    this.tPg.dead();
  }
  
  protected final ArrayList<com.tencent.mm.live.c.a> getPluginList()
  {
    return this.vnf;
  }
  
  public abstract int getRelativeLayoutId();
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public abstract void onCallStateChanged(int paramInt, String paramString);
  
  public void pause()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).pause();
    }
  }
  
  public void resume()
  {
    setVisibility(0);
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).resume();
    }
  }
  
  public void start()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).start();
    }
  }
  
  public final void stop()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.c.a)localIterator.next()).stop();
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/BaseLivePluginLayout$mVoipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class a
    extends c<ww>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/BaseLivePluginLayout$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class b
    extends c<lk>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.BaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */