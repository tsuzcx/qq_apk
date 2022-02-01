package com.tencent.mm.accessibility.core.provider;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MapExpandKt;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.accessibility.core.ViewTagManager;
import com.tencent.mm.accessibility.core.area.AreaProvider;
import com.tencent.mm.accessibility.uitl.AccNodeUtil;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.accessibility.uitl.IdUtil;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/AccProviderFactory;", "", "()V", "MOCK_INFLATE_DELAY", "", "TAG", "", "providers", "", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "bindConfig", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "config", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "dealTagSync", "root", "Landroid/view/View;", "dispatchAccEvent", "view", "event", "Landroid/view/accessibility/AccessibilityEvent;", "dispatchNodeInfo", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dispatchOnAction", "action", "", "args", "Landroid/os/Bundle;", "dispatchViewInflate", "onInflateRootAsync", "onMockInflate", "runInProtect", "runnable", "Lkotlin/Function0;", "unbindConfig", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccProviderFactory
{
  public static final AccProviderFactory INSTANCE;
  private static final long MOCK_INFLATE_DELAY = 200L;
  private static final String TAG = "MicroMsg.Acc.AccProviderFactory";
  private static final List<Provider> providers;
  
  static
  {
    AppMethodBeat.i(234319);
    INSTANCE = new AccProviderFactory();
    List localList = (List)new ArrayList();
    providers = localList;
    localList.add(EventRecorder.INSTANCE);
    providers.add(PreFocusModifier.INSTANCE);
    providers.add(ContentDescProvider.INSTANCE);
    providers.add(DisableFocusModifier.INSTANCE);
    providers.add(OrderProvider.INSTANCE);
    providers.add(CallbackCaller.INSTANCE);
    providers.add(TypeModifier.INSTANCE);
    providers.add(TalkController.INSTANCE);
    providers.add(DisableChildModifier.INSTANCE);
    providers.add(ClickConductionProvider.INSTANCE);
    providers.add(TextViewSpannedModifier.INSTANCE);
    providers.add(CheckableModifier.INSTANCE);
    providers.add(SeekbarCaller.INSTANCE);
    AppMethodBeat.o(234319);
  }
  
  private final void dealTagSync(View paramView)
  {
    AppMethodBeat.i(234304);
    MapExpandKt.visitChild(paramView, (b)dealTagSync.1.INSTANCE);
    AppMethodBeat.o(234304);
  }
  
  private final List<Provider> providers()
  {
    return providers;
  }
  
  private final void runInProtect(View paramView, a<ah> parama)
  {
    AppMethodBeat.i(234308);
    try
    {
      parama.invoke();
      AppMethodBeat.o(234308);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.Acc.AccProviderFactory", parama, "throw in view(%s)", new Object[] { IdUtil.INSTANCE.getName(paramView.getId()) });
      AppMethodBeat.o(234308);
    }
  }
  
  public final void bindConfig(AppCompatActivity paramAppCompatActivity, MMBaseAccessibilityConfig paramMMBaseAccessibilityConfig)
  {
    AppMethodBeat.i(234347);
    s.u(paramAppCompatActivity, "activity");
    s.u(paramMMBaseAccessibilityConfig, "config");
    Iterator localIterator = ((Iterable)providers).iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).bindConfig(paramAppCompatActivity, paramMMBaseAccessibilityConfig);
    }
    AreaProvider.INSTANCE.bindConfig(paramAppCompatActivity, paramMMBaseAccessibilityConfig);
    AppMethodBeat.o(234347);
  }
  
  public final void dispatchAccEvent(View paramView, final AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234381);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    runInProtect(paramView, (a)new u(paramView)
    {
      public final void invoke()
      {
        AppMethodBeat.i(234255);
        Object localObject = (Iterable)AccProviderFactory.access$getProviders$p();
        View localView = this.$view;
        AccessibilityEvent localAccessibilityEvent = paramAccessibilityEvent;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Provider localProvider = (Provider)((Iterator)localObject).next();
          if ((localProvider.getAuthority() & 0x4) == 4) {
            localProvider.dealAccEvent(localView, localAccessibilityEvent);
          }
        }
        AppMethodBeat.o(234255);
      }
    });
    AppMethodBeat.o(234381);
  }
  
  public final void dispatchNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234358);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    runInProtect(paramView, (a)new u(paramView)
    {
      public final void invoke()
      {
        AppMethodBeat.i(234313);
        Object localObject = (Iterable)AccProviderFactory.access$getProviders$p();
        View localView = this.$view;
        AccessibilityNodeInfo localAccessibilityNodeInfo = paramAccessibilityNodeInfo;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Provider localProvider = (Provider)((Iterator)localObject).next();
          if ((localProvider.getAuthority() & 0x1) == 1) {
            localProvider.dealNodeInfo(localView, localAccessibilityNodeInfo);
          }
        }
        AppMethodBeat.o(234313);
      }
    });
    AppMethodBeat.o(234358);
  }
  
  public final void dispatchOnAction(View paramView, final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(234374);
    s.u(paramView, "view");
    runInProtect(paramView, (a)new u(paramView)
    {
      public final void invoke()
      {
        AppMethodBeat.i(234195);
        Object localObject = (Iterable)AccProviderFactory.access$getProviders$p();
        View localView = this.$view;
        int i = paramInt;
        Bundle localBundle = paramBundle;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Provider localProvider = (Provider)((Iterator)localObject).next();
          if ((localProvider.getAuthority() & 0x8) == 8) {
            localProvider.dealOnAction(localView, i, localBundle);
          }
        }
        AppMethodBeat.o(234195);
      }
    });
    AppMethodBeat.o(234374);
  }
  
  public final void dispatchViewInflate(View paramView)
  {
    AppMethodBeat.i(234366);
    s.u(paramView, "view");
    runInProtect(paramView, (a)new u(paramView)
    {
      public final void invoke()
      {
        AppMethodBeat.i(234175);
        Object localObject = (Iterable)AccProviderFactory.access$getProviders$p();
        View localView = this.$view;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Provider localProvider = (Provider)((Iterator)localObject).next();
          if ((localProvider.getAuthority() & 0x2) == 2) {
            localProvider.dealOnViewInflateAsync(localView);
          }
          localProvider.preFindRoot$plugin_autoaccessibility_release(localView);
        }
        AppMethodBeat.o(234175);
      }
    });
    AppMethodBeat.o(234366);
  }
  
  public final void onInflateRootAsync(View paramView)
  {
    AppMethodBeat.i(234329);
    s.u(paramView, "root");
    dealTagSync(paramView);
    ViewTag localViewTag;
    if (AccUtil.INSTANCE.canPreDeal())
    {
      localViewTag = ViewTagManager.INSTANCE.getTagData(paramView);
      if (localViewTag != null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = false;; bool = s.p(localViewTag.getHavenInflate(), Boolean.TRUE))
    {
      if (!bool) {
        MapExpandKt.postIfNeed(paramView, (a)new u(paramView)
        {
          public final void invoke()
          {
            AppMethodBeat.i(234220);
            d.a("AccessibilityThreadTag", false, (a)new u(this.$root)
            {
              public final void invoke()
              {
                AppMethodBeat.i(234239);
                MapExpandKt.visitChild(this.$root, (b)1.INSTANCE);
                AppMethodBeat.o(234239);
              }
            }, 200L);
            AppMethodBeat.o(234220);
          }
        });
      }
      AppMethodBeat.o(234329);
      return;
    }
  }
  
  public final void onMockInflate(View paramView)
  {
    AppMethodBeat.i(234338);
    s.u(paramView, "view");
    if ((AccUtil.INSTANCE.isAccessibilityEnabled()) || (AccUtil.INSTANCE.isEnableAccEnableForced())) {
      dispatchViewInflate(paramView);
    }
    if (AccUtil.INSTANCE.canExpand())
    {
      ViewTag localViewTag = ViewTagManager.INSTANCE.getTagData(paramView);
      if ((localViewTag != null) && (!s.p(localViewTag.getHavenExpand(), Boolean.TRUE)))
      {
        localViewTag.setHavenExpand(Boolean.TRUE);
        AreaProvider.INSTANCE.dealOnViewInflateAsync(paramView);
      }
    }
    AppMethodBeat.o(234338);
  }
  
  public final void unbindConfig(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(234352);
    s.u(paramAppCompatActivity, "activity");
    Iterator localIterator = ((Iterable)providers).iterator();
    while (localIterator.hasNext()) {
      ((Provider)localIterator.next()).unbindConfig(paramAppCompatActivity);
    }
    AreaProvider.INSTANCE.unbindConfig(paramAppCompatActivity);
    AppMethodBeat.o(234352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.AccProviderFactory
 * JD-Core Version:    0.7.0.1
 */