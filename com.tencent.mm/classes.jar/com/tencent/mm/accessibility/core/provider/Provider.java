package com.tencent.mm.accessibility.core.provider;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.IdUtil;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/Provider;", "", "()V", "activityViewRootDescMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroidx/appcompat/app/AppCompatActivity;", "", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "mappers", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "addRootIdMapper", "", "f", "addRootIdMapper$plugin_autoaccessibility_release", "bindConfig", "activity", "config", "dealAccEvent", "view", "event", "Landroid/view/accessibility/AccessibilityEvent;", "dealNodeInfo", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dealOnAction", "host", "action", "args", "Landroid/os/Bundle;", "dealOnViewInflateAsync", "getAuthority", "getConfig", "", "configCallback", "Lkotlin/Function1;", "getLayoutId", "(Landroid/view/View;)Ljava/lang/Integer;", "logMsg", "tag", "", "msg", "preFindRoot", "preFindRoot$plugin_autoaccessibility_release", "unbindConfig", "Companion", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class Provider
{
  public static final Companion Companion = new Companion(null);
  public static final String TAG = "MicroMsg.Acc.Provider";
  private final ConcurrentHashMap<AppCompatActivity, List<MMBaseAccessibilityConfig>> activityViewRootDescMap = new ConcurrentHashMap();
  private final List<m<View, MMBaseAccessibilityConfig, List<Integer>>> mappers = (List)new ArrayList();
  
  public final void addRootIdMapper$plugin_autoaccessibility_release(m<? super View, ? super MMBaseAccessibilityConfig, ? extends List<Integer>> paramm)
  {
    s.u(paramm, "f");
    this.mappers.add(paramm);
  }
  
  public void bindConfig(AppCompatActivity paramAppCompatActivity, MMBaseAccessibilityConfig paramMMBaseAccessibilityConfig)
  {
    s.u(paramAppCompatActivity, "activity");
    s.u(paramMMBaseAccessibilityConfig, "config");
    Object localObject2 = (ConcurrentMap)this.activityViewRootDescMap;
    Object localObject1 = ((ConcurrentMap)localObject2).get(paramAppCompatActivity);
    if (localObject1 == null)
    {
      localObject1 = Collections.synchronizedList((List)new ArrayList());
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(paramAppCompatActivity, localObject1);
      paramAppCompatActivity = (AppCompatActivity)localObject2;
      if (localObject2 != null) {}
    }
    for (paramAppCompatActivity = (AppCompatActivity)localObject1;; paramAppCompatActivity = (AppCompatActivity)localObject1)
    {
      ((List)paramAppCompatActivity).add(paramMMBaseAccessibilityConfig);
      return;
    }
  }
  
  public void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
  }
  
  public void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
  }
  
  public void dealOnAction(View paramView, int paramInt, Bundle paramBundle)
  {
    s.u(paramView, "host");
  }
  
  public void dealOnViewInflateAsync(View paramView)
  {
    s.u(paramView, "view");
  }
  
  public abstract int getAuthority();
  
  public final boolean getConfig(View paramView, b<? super MMBaseAccessibilityConfig, Boolean> paramb)
  {
    s.u(paramView, "view");
    s.u(paramb, "configCallback");
    paramView = paramView.getContext();
    List localList;
    if ((paramView instanceof AppCompatActivity))
    {
      paramView = (AppCompatActivity)paramView;
      if (paramView == null) {
        break label130;
      }
      localList = (List)this.activityViewRootDescMap.get(paramView);
      if (localList != null) {
        break label105;
      }
      paramView = null;
    }
    for (;;)
    {
      if (paramView == null) {
        break label130;
      }
      paramView = ((Iterable)paramView).iterator();
      do
      {
        if (!paramView.hasNext()) {
          break;
        }
      } while (!((Boolean)paramb.invoke((MMBaseAccessibilityConfig)paramView.next())).booleanValue());
      return true;
      paramView = null;
      break;
      label105:
      paramView = (List)new ArrayList();
      paramView.addAll((Collection)localList);
    }
    label130:
    return false;
  }
  
  public final Integer getLayoutId(View paramView)
  {
    if (paramView == null) {}
    for (paramView = null; (paramView instanceof Integer); paramView = paramView.getTag(a.a.tag_acc_layout_id)) {
      return (Integer)paramView;
    }
    return null;
  }
  
  public final void logMsg(String paramString1, View paramView, String paramString2)
  {
    s.u(paramString1, "tag");
    s.u(paramView, "view");
    s.u(paramString2, "msg");
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(':').append(IdUtil.INSTANCE.getName(paramView.getId())).append('@').append(paramView.hashCode()).append(":parent:");
    IdUtil localIdUtil = IdUtil.INSTANCE;
    paramView = getLayoutId(paramView);
    if (paramView == null) {}
    for (int i = 0;; i = paramView.intValue())
    {
      Log.d(paramString1, localIdUtil.getName(i) + ':' + paramString2);
      return;
    }
  }
  
  public final void preFindRoot$plugin_autoaccessibility_release(final View paramView)
  {
    s.u(paramView, "view");
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234184);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "config");
        Object localObject2 = (Iterable)Provider.access$getMappers$p(this.this$0);
        View localView = paramView;
        Object localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          List localList = (List)((m)((Iterator)localObject2).next()).invoke(localView, paramAnonymousMMBaseAccessibilityConfig);
          if (localList != null) {
            ((Collection)localObject1).add(localList);
          }
        }
        localObject1 = (Iterable)localObject1;
        localView = paramView;
        localObject1 = ((Iterable)localObject1).iterator();
        boolean bool = false;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (List)((Iterator)localObject1).next();
          if (bool) {
            break label181;
          }
          if (paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(localView, (List)localObject2) != null) {
            bool = true;
          }
        }
        label181:
        for (;;)
        {
          break;
          bool = false;
          continue;
          AppMethodBeat.o(234184);
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  public void unbindConfig(AppCompatActivity paramAppCompatActivity)
  {
    s.u(paramAppCompatActivity, "activity");
    this.activityViewRootDescMap.remove(paramAppCompatActivity);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/Provider$Companion;", "", "()V", "TAG", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.Provider
 * JD-Core Version:    0.7.0.1
 */