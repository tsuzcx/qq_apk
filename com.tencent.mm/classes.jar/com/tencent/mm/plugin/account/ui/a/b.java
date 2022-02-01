package com.tencent.mm.plugin.account.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.account.ui.r.f;
import com.tencent.mm.plugin.account.ui.r.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/ui/acc/RegByMobileAccConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-account_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305069);
    AppMethodBeat.o(305069);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305073);
    root(r.f.keyboard_change_input_panel).view(r.f.setinfo_avatar).desc(r.j.regsetinfo_avatar_acc).type(ViewType.Button);
    AppMethodBeat.o(305073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a.b
 * JD-Core Version:    0.7.0.1
 */