package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.accessibility.core.ViewTagManager;
import com.tencent.mm.accessibility.type.ViewType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/TypeModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "BUTTON_CLASS", "", "TAG", "TEXTVIEW_CLASS", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TypeModifier
  extends Provider
{
  public static final String BUTTON_CLASS = "android.widget.Button";
  public static final TypeModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.TypeModifier";
  public static final String TEXTVIEW_CLASS = "android.widget.TextView";
  
  static
  {
    AppMethodBeat.i(234264);
    TypeModifier localTypeModifier = new TypeModifier();
    INSTANCE = localTypeModifier;
    localTypeModifier.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234264);
  }
  
  public final void dealNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234272);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AccessibilityNodeInfo localAccessibilityNodeInfo = null;
        AppMethodBeat.i(234245);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Map localMap = (Map)paramAnonymousMMBaseAccessibilityConfig.getTypeMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localMap == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234245);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)localMap.keySet()));
        if (paramAnonymousMMBaseAccessibilityConfig == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = null;
          paramAnonymousMMBaseAccessibilityConfig = (ViewType)localMap.get(paramAnonymousMMBaseAccessibilityConfig);
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label159;
          }
          paramAnonymousMMBaseAccessibilityConfig = (ViewType)localMap.get(TypeModifier.INSTANCE.getLayoutId(this.$view));
        }
        label159:
        for (;;)
        {
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label162;
          }
          paramAnonymousMMBaseAccessibilityConfig = localAccessibilityNodeInfo;
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label298;
          }
          TypeModifier.INSTANCE.logMsg("MicroMsg.Acc.TypeModifier", this.$view, "findRoot success but not found Type?");
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234245);
          return paramAnonymousMMBaseAccessibilityConfig;
          paramAnonymousMMBaseAccessibilityConfig = Integer.valueOf(paramAnonymousMMBaseAccessibilityConfig.getId());
          break;
        }
        label162:
        localAccessibilityNodeInfo = paramAccessibilityNodeInfo;
        switch (WhenMappings.$EnumSwitchMapping$0[paramAnonymousMMBaseAccessibilityConfig.ordinal()])
        {
        default: 
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234245);
          return paramAnonymousMMBaseAccessibilityConfig;
        case 1: 
          localAccessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
        }
        for (;;)
        {
          paramAnonymousMMBaseAccessibilityConfig = ah.aiuX;
          break;
          localAccessibilityNodeInfo.setClassName((CharSequence)TextView.class.getName());
          continue;
          localAccessibilityNodeInfo.setClassName((CharSequence)SeekBar.class.getName());
          continue;
          localAccessibilityNodeInfo.setClassName((CharSequence)CheckBox.class.getName());
          continue;
          localAccessibilityNodeInfo.setClassName((CharSequence)EditText.class.getName());
        }
        label298:
        paramAnonymousMMBaseAccessibilityConfig = ViewTagManager.INSTANCE.getTagData(this.$view);
        if (paramAnonymousMMBaseAccessibilityConfig != null) {
          paramAnonymousMMBaseAccessibilityConfig.setViewType(paramAccessibilityNodeInfo.getClassName());
        }
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234245);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234272);
  }
  
  public final int getAuthority()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.TypeModifier
 * JD-Core Version:    0.7.0.1
 */