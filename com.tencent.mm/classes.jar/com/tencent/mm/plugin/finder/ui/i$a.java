package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "_items", "", "", "getActivity", "()Landroid/app/Activity;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "value", "getValue", "()Ljava/lang/String;", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
{
  private final d FVO;
  private List<String> FVP;
  private final Activity activity;
  
  public i$a(Activity paramActivity, d paramd)
  {
    AppMethodBeat.i(347199);
    this.activity = paramActivity;
    this.FVO = paramd;
    this.FVP = this.FVO.fsi();
    AppMethodBeat.o(347199);
  }
  
  private static final void a(a parama, i.f paramf, MMPreference paramMMPreference, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(347208);
    s.u(parama, "this$0");
    s.u(paramf, "$operation");
    s.u(paramMMPreference, "$activity");
    try
    {
      parama.FVO.VB(paramInt1);
      paramf.bDL();
      paramMMPreference.getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(347208);
      return;
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace("SettingHelper", (Throwable)parama, "", new Object[0]);
      AppMethodBeat.o(347208);
    }
  }
  
  public final void a(MMPreference paramMMPreference, i.f paramf)
  {
    AppMethodBeat.i(347228);
    s.u(paramMMPreference, "activity");
    s.u(paramf, "operation");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    List localList = this.FVP;
    s.checkNotNull(localList);
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      localList = this.FVP;
      s.checkNotNull(localList);
      localLinkedList1.add(localList.get(i));
      localLinkedList2.add(Integer.valueOf(i));
      if (j > k)
      {
        k.a((Context)paramMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", new i.a..ExternalSyntheticLambda0(this, paramf, paramMMPreference));
        AppMethodBeat.o(347228);
        return;
      }
      i = j;
    }
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(347222);
    int i = this.FVO.HdL;
    Object localObject = this.FVP;
    if (localObject == null)
    {
      AppMethodBeat.o(347222);
      return "";
    }
    if ((i >= 0) && (i < ((List)localObject).size()))
    {
      localObject = (String)((List)localObject).get(i);
      AppMethodBeat.o(347222);
      return localObject;
    }
    localObject = this.FVO.fsj();
    AppMethodBeat.o(347222);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i.a
 * JD-Core Version:    0.7.0.1
 */