package com.tencent.mm.plugin.exdevice.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/accessibility/ExdeviceRankInfoUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274762);
    AppMethodBeat.o(274762);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(274766);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.gjK);
    localConfigHelper.view(R.h.exdevice_rank_ll).descFormat(R.l.exdevice_rank_ll).valueByView(R.h.fHl).valueByView(R.h.fHp).valueByView(R.h.fGS);
    localConfigHelper.view(R.h.fGW).disable();
    localConfigHelper.view(R.h.fHo).desc(R.l.avatar_desc);
    localConfigHelper.view(R.h.fHq).disable();
    localConfigHelper.view(R.h.fHd).descFormat(R.l.exdevice_like).valueByView(R.h.fHc);
    AppMethodBeat.o(274766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */