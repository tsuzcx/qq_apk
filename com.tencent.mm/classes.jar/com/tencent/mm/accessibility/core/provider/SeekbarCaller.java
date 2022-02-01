package com.tencent.mm.accessibility.core.provider;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.widget.SeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.accessibility.core.ViewTagManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/SeekbarCaller;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dealOnAction", "host", "action", "", "args", "Landroid/os/Bundle;", "getAuthority", "isScrollAction", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SeekbarCaller
  extends Provider
{
  public static final SeekbarCaller INSTANCE;
  
  static
  {
    AppMethodBeat.i(234324);
    INSTANCE = new SeekbarCaller();
    AppMethodBeat.o(234324);
  }
  
  private final boolean isScrollAction(int paramInt)
  {
    return (paramInt == 8192) || (paramInt == 4096);
  }
  
  public final void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234335);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    paramView = ViewTagManager.INSTANCE.getTagData(paramView);
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getViewType())
    {
      if (s.p(paramView, SeekBar.class.getName()))
      {
        paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        paramAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        paramAccessibilityNodeInfo.setClassName((CharSequence)SeekBar.class.getName());
      }
      AppMethodBeat.o(234335);
      return;
    }
  }
  
  public final void dealOnAction(View paramView, int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(234344);
    s.u(paramView, "host");
    paramBundle = ViewTagManager.INSTANCE.getTagData(paramView);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getViewType())
    {
      if ((s.p(paramBundle, SeekBar.class.getName())) && (isScrollAction(paramInt)))
      {
        paramBundle = new ah.f();
        getConfig(paramView, (b)new u(paramView)
        {
          public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
          {
            AppMethodBeat.i(234291);
            s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
            Object localObject = (Map)paramAnonymousMMBaseAccessibilityConfig.getViewRootSeekCallback$plugin_autoaccessibility_release().get(Integer.valueOf(this.$host.getId()));
            if (localObject == null)
            {
              paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
              AppMethodBeat.o(234291);
              return paramAnonymousMMBaseAccessibilityConfig;
            }
            paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$host, p.p((Iterable)((Map)localObject).keySet()));
            ah.f localf = paramBundle;
            if (paramAnonymousMMBaseAccessibilityConfig == null) {}
            for (paramAnonymousMMBaseAccessibilityConfig = null;; paramAnonymousMMBaseAccessibilityConfig = Integer.valueOf(paramAnonymousMMBaseAccessibilityConfig.getId()))
            {
              paramAnonymousMMBaseAccessibilityConfig = (r)((Map)localObject).get(paramAnonymousMMBaseAccessibilityConfig);
              if (paramAnonymousMMBaseAccessibilityConfig != null) {
                break;
              }
              localObject = (r)((Map)localObject).get(SeekbarCaller.INSTANCE.getLayoutId(this.$host));
              paramAnonymousMMBaseAccessibilityConfig = (MMBaseAccessibilityConfig)localObject;
              if (localObject != null) {
                break;
              }
              paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
              AppMethodBeat.o(234291);
              return paramAnonymousMMBaseAccessibilityConfig;
            }
            localf.aqH = paramAnonymousMMBaseAccessibilityConfig;
            paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
            AppMethodBeat.o(234291);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        });
        if (paramInt == 8192)
        {
          Object localObject = (r)paramBundle.aqH;
          if (localObject != null)
          {
            localObject = (b)((r)localObject).bsD;
            if (localObject != null) {
              ((b)localObject).invoke(paramView);
            }
          }
        }
        if (paramInt == 4096)
        {
          paramBundle = (r)paramBundle.aqH;
          if (paramBundle != null)
          {
            paramBundle = (b)paramBundle.bsC;
            if (paramBundle != null) {
              paramBundle.invoke(paramView);
            }
          }
        }
      }
      AppMethodBeat.o(234344);
      return;
    }
  }
  
  public final int getAuthority()
  {
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.SeekbarCaller
 * JD-Core Version:    0.7.0.1
 */