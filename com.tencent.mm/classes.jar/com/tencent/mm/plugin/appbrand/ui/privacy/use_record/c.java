package com.tencent.mm.plugin.appbrand.ui.privacy.use_record;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gnf;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/PrivacyUseRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/PrivacyUseRecordViewHolder;", "()V", "othersDateFormat", "Ljava/text/SimpleDateFormat;", "todayDateFormat", "useRecordList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoRecord;", "Lkotlin/collections/ArrayList;", "appendFetchedUseRecordList", "", "fetchedUseRecordList", "", "formatTime", "", "timeInSecond", "", "getItemCount", "", "getItemId", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c
  extends RecyclerView.a<d>
{
  private final ArrayList<gnf> ukZ;
  private final SimpleDateFormat ula;
  private final SimpleDateFormat ulb;
  
  public c()
  {
    AppMethodBeat.i(322760);
    this.ukZ = new ArrayList();
    this.ula = new SimpleDateFormat("HH:mm", Locale.US);
    this.ulb = new SimpleDateFormat("MM/dd HH:mm", Locale.US);
    AppMethodBeat.o(322760);
  }
  
  public final void dI(List<? extends gnf> paramList)
  {
    AppMethodBeat.i(322765);
    s.u(paramList, "fetchedUseRecordList");
    int i = this.ukZ.size();
    int j = paramList.size();
    Log.i("MicroMsg.AppBrandPrivacyUseRecordPage", "appendFetchedUseRecordList, posInsert: " + i + ", insertCount: " + j);
    this.ukZ.addAll((Collection)paramList);
    bA(i, j);
    AppMethodBeat.o(322765);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(322775);
    int i = this.ukZ.size();
    AppMethodBeat.o(322775);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.use_record.c
 * JD-Core Version:    0.7.0.1
 */