package com.tencent.mm.plugin.label.ui.searchContact;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "mContactDataItems", "", "", "getMContactDataItems", "()Ljava/util/List;", "selectedContactDataItems", "Ljava/util/ArrayList;", "getSelectedContactDataItems", "()Ljava/util/ArrayList;", "setSelectedContactDataItems", "(Ljava/util/ArrayList;)V", "selectedContacts", "getSelectedContacts", "setSelectedContacts", "(Ljava/util/List;)V", "getLogTag", "handleSnapshotList", "", "snapshotList", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactDataItemList
  extends MvvmList<a>
{
  public static final ContactDataItemList.a JXw;
  private final List<String> JXx;
  List<String> JXy;
  ArrayList<a> JXz;
  
  static
  {
    AppMethodBeat.i(268924);
    JXw = new ContactDataItemList.a((byte)0);
    AppMethodBeat.o(268924);
  }
  
  public ContactDataItemList(f<a, c<a>, d<a>> paramf, e parame, q paramq)
  {
    super(paramf, parame, paramq);
    AppMethodBeat.i(268918);
    this.JXx = ((List)new ArrayList());
    this.JXy = ((List)new ArrayList());
    this.JXz = new ArrayList();
    AppMethodBeat.o(268918);
  }
  
  public final void aU(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(268936);
    s.u(paramArrayList, "<set-?>");
    this.JXz = paramArrayList;
    AppMethodBeat.o(268936);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.ContactDataItemList";
  }
  
  public final List<a> hF(List<a> paramList)
  {
    AppMethodBeat.i(268943);
    s.u(paramList, "snapshotList");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add((a)((a)((Iterator)localObject).next()).gsx());
    }
    paramList = (List)paramList;
    AppMethodBeat.o(268943);
    return paramList;
  }
  
  public final void iI(List<String> paramList)
  {
    AppMethodBeat.i(268931);
    s.u(paramList, "<set-?>");
    this.JXy = paramList;
    AppMethodBeat.o(268931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchContact.ContactDataItemList
 * JD-Core Version:    0.7.0.1
 */