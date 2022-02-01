package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "_items", "", "", "getActivity", "()Landroid/app/Activity;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "value", "getValue", "()Ljava/lang/String;", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "plugin-finder_release"})
public final class f$a
{
  private final Activity activity;
  final d sTA;
  private List<String> sTz;
  
  public f$a(Activity paramActivity, d paramd)
  {
    AppMethodBeat.i(204881);
    this.activity = paramActivity;
    this.sTA = paramd;
    this.sTz = this.sTA.cLy();
    AppMethodBeat.o(204881);
  }
  
  public final void a(final MMPreference paramMMPreference, final f.f paramf)
  {
    AppMethodBeat.i(204880);
    p.h(paramMMPreference, "activity");
    p.h(paramf, "operation");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    List localList = this.sTz;
    if (localList == null) {
      p.gkB();
    }
    int j = ((Collection)localList).size();
    int i = 0;
    while (i < j)
    {
      localList = this.sTz;
      if (localList == null) {
        p.gkB();
      }
      localLinkedList1.add(localList.get(i));
      localLinkedList2.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)paramMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", (h.d)new a(this, paramf, paramMMPreference));
    AppMethodBeat.o(204880);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(204879);
    int i = this.sTA.sKs;
    Object localObject = this.sTz;
    if (localObject != null)
    {
      if ((i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (String)((List)localObject).get(i);
        AppMethodBeat.o(204879);
        return localObject;
      }
      localObject = this.sTA.cLz();
      AppMethodBeat.o(204879);
      return localObject;
    }
    AppMethodBeat.o(204879);
    return "";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class a
    implements h.d
  {
    a(f.a parama, f.f paramf, MMPreference paramMMPreference) {}
    
    public final void cv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204878);
      try
      {
        this.sTB.sTA.FN(paramInt1);
        paramf.refresh();
        paramMMPreference.getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(204878);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("SettingHelper", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(204878);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.a
 * JD-Core Version:    0.7.0.1
 */