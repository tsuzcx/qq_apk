package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import a.l.m;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.c.d;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
public final class ForceNotifyListUI$a
  extends RecyclerView.a<ForceNotifyListUI.b>
{
  public final int getItemCount()
  {
    AppMethodBeat.i(51065);
    int i = ForceNotifyListUI.a(this.mHI).size();
    AppMethodBeat.o(51065);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(140612);
    Object localObject = ForceNotifyListUI.a(this.mHI).get(paramInt);
    j.p(localObject, "data[position]");
    localObject = ((d)localObject).field_UserName;
    j.p(localObject, "info.field_UserName");
    if (m.jx((String)localObject, "@app"))
    {
      AppMethodBeat.o(140612);
      return 1;
    }
    AppMethodBeat.o(140612);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.a
 * JD-Core Version:    0.7.0.1
 */