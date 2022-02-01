package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/EventRecorder;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "dealAccEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EventRecorder
  extends Provider
{
  public static final EventRecorder INSTANCE;
  
  static
  {
    AppMethodBeat.i(234261);
    INSTANCE = new EventRecorder();
    AppMethodBeat.o(234261);
  }
  
  public final void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234276);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    if ((paramAccessibilityEvent.getEventType() & 0x8000) != 32768)
    {
      AppMethodBeat.o(234276);
      return;
    }
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234305);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        if (s.p(paramAnonymousMMBaseAccessibilityConfig.getStartView$plugin_autoaccessibility_release(), this.$view))
        {
          paramAnonymousMMBaseAccessibilityConfig.setHasFocusStartView$plugin_autoaccessibility_release(true);
          paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
          AppMethodBeat.o(234305);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
        AppMethodBeat.o(234305);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234276);
  }
  
  public final int getAuthority()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.EventRecorder
 * JD-Core Version:    0.7.0.1
 */