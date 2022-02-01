package com.tencent.mm.app;

import androidx.lifecycle.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.plugin.PluginLifecycleRegistry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/app/ApplicationLifecycleRegistry;", "Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry;", "()V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "Companion", "wechat-internal-support_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends PluginLifecycleRegistry
{
  public static final d.a hfH = new d.a((byte)0);
  
  public final void addObserver(p paramp)
  {
    s.u(paramp, "observer");
    super.addObserver(paramp);
    StringBuilder localStringBuilder = new StringBuilder("addObserver totalCount:");
    Object localObject = getObserverMap();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((ConcurrentHashMap)localObject).size()))
    {
      Log.i("MicroMsg.Mvvm.ApplicationLifecycleRegistry", localObject + " observer:" + paramp);
      return;
    }
  }
  
  public final void removeObserver(p paramp)
  {
    s.u(paramp, "observer");
    super.removeObserver(paramp);
    StringBuilder localStringBuilder = new StringBuilder("removeObserver totalCount:");
    Object localObject = getObserverMap();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((ConcurrentHashMap)localObject).size()))
    {
      Log.i("MicroMsg.Mvvm.ApplicationLifecycleRegistry", localObject + " observer:" + paramp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.d
 * JD-Core Version:    0.7.0.1
 */