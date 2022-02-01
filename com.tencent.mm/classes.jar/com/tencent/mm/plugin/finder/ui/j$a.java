package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "_items", "", "", "getActivity", "()Landroid/app/Activity;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "value", "getValue", "()Ljava/lang/String;", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "plugin-finder_release"})
public final class j$a
{
  private final Activity activity;
  List<String> vQe;
  final e vQf;
  
  public j$a(Activity paramActivity, e parame)
  {
    AppMethodBeat.i(252811);
    this.activity = paramActivity;
    this.vQf = parame;
    this.vQe = this.vQf.dyo();
    AppMethodBeat.o(252811);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(252810);
    int i = this.vQf.vFI;
    Object localObject = this.vQe;
    if (localObject != null)
    {
      if ((i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (String)((List)localObject).get(i);
        AppMethodBeat.o(252810);
        return localObject;
      }
      localObject = this.vQf.dyp();
      AppMethodBeat.o(252810);
      return localObject;
    }
    AppMethodBeat.o(252810);
    return "";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class a
    implements h.e
  {
    a(j.a parama, j.f paramf, MMPreference paramMMPreference) {}
    
    public final void cy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252809);
      try
      {
        this.vQg.vQf.Lc(paramInt1);
        this.vQh.refresh();
        this.vQi.getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(252809);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("SettingHelper", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(252809);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.j.a
 * JD-Core Version:    0.7.0.1
 */