package com.tencent.mm.msgsubscription.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$BizSubscribeMsgManagerUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizSubscribeMsgManagerUI$a
  extends MMBaseAccessibilityConfig
{
  public BizSubscribeMsgManagerUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236633);
    AppMethodBeat.o(236633);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(236639);
    root(c.f.biz_subscribe_msg_manager_ui).view(c.e.subscribe_msg_switch).disable();
    AppMethodBeat.o(236639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI.a
 * JD-Core Version:    0.7.0.1
 */