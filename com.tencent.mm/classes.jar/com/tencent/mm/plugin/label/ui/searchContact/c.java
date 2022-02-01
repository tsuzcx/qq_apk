package com.tencent.mm.plugin.label.ui.searchContact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "query", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "(Ljava/lang/String;Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "allsearchResultUserNames", "Ljava/util/ArrayList;", "getAllsearchResultUserNames", "()Ljava/util/ArrayList;", "setAllsearchResultUserNames", "(Ljava/util/ArrayList;)V", "contactDataItemList", "Lkotlin/collections/ArrayList;", "getContactDataItemList", "setContactDataItemList", "contactDataLiveList", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "getContactDataLiveList", "()Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "setContactDataLiveList", "(Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;)V", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "deleteSuccess", "Ljava/util/HashSet;", "getDeleteSuccess", "()Ljava/util/HashSet;", "setDeleteSuccess", "(Ljava/util/HashSet;)V", "ftsQuery", "getFtsQuery", "()Ljava/lang/String;", "setFtsQuery", "(Ljava/lang/String;)V", "handler2", "getHandler2", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler2", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "listenerResult", "getListenerResult", "()Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "setListenerResult", "(Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;)V", "liveListContact", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveListContact", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveListContact", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "nocanNickNames", "getNocanNickNames", "setNocanNickNames", "searchCanShowUserNames", "getSearchCanShowUserNames", "setSearchCanShowUserNames", "self", "kotlin.jvm.PlatformType", "getSelf", "setSelf", "createContactItem", "contact", "Lcom/tencent/mm/storage/Contact;", "position", "", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "doSearch", "", "getContactSearchTypes", "", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "isInDataSource", "", "item", "onCreate", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "updateData", "userNames", "selectedContacts", "", "i", "selectedContactDataItems", "nameToInfo", "Ljava/util/HashMap;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.mvvmlist.a.a<a>
  implements com.tencent.mm.plugin.fts.a.l
{
  public static final c.a JXA;
  private com.tencent.mm.plugin.fts.a.a.c DHR;
  private String JXB;
  private MMHandler JXC;
  HashSet<String> JXD;
  ContactDataItemList JXE;
  com.tencent.mm.plugin.fts.a.l JXF;
  private String JXG;
  private ArrayList<a> JXH;
  private ArrayList<String> JXI;
  private ArrayList<String> JXJ;
  ArrayList<String> JXK;
  
  static
  {
    AppMethodBeat.i(268927);
    JXA = new c.a((byte)0);
    AppMethodBeat.o(268927);
  }
  
  public c(String paramString, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(268909);
    this.JXB = "";
    this.JXB = paramString;
    this.JXC = paramMMHandler;
    this.JXD = new HashSet();
    paramString = h.baE().ban().d(2, null);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(268909);
      throw paramString;
    }
    this.JXG = Util.nullAs((String)paramString, "");
    this.JXH = new ArrayList();
    this.JXI = new ArrayList();
    this.JXJ = new ArrayList();
    this.JXK = new ArrayList();
    AppMethodBeat.o(268909);
  }
  
  private final int a(ArrayList<String> paramArrayList, List<String> paramList, m paramm, int paramInt, ArrayList<a> paramArrayList1, HashMap<String, o> paramHashMap)
  {
    AppMethodBeat.i(268917);
    ArrayList localArrayList = new ArrayList();
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzA();
    Object localObject2 = ((Collection)paramArrayList).toArray(new String[0]);
    if (localObject2 == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(268917);
      throw paramArrayList;
    }
    localObject2 = ((bx)localObject1).a((String[])localObject2, "@all.contact.android", (List)new ArrayList());
    int i = paramInt;
    if (localObject2 != null)
    {
      i = paramInt;
      if (((Cursor)localObject2).getCount() > 0)
      {
        if (((Cursor)localObject2).moveToNext())
        {
          Log.d("MicroMsg.Mvvm.ContactDataSource", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramInt) });
          au localau = new au();
          localau.convertFrom((Cursor)localObject2);
          a locala = new a(paramInt);
          locala.contact = localau;
          locala.rpp = ((o)paramHashMap.get(localau.field_username));
          locala.query = this.JXB;
          if (paramm == null)
          {
            localObject1 = null;
            label216:
            locala.FWt = ((j)localObject1);
            localObject1 = locala.contact;
            if (localObject1 != null) {
              localArrayList.add(localObject1);
            }
            this.JXH.add(locala);
            localObject1 = this.JXE;
            if (localObject1 == null) {
              break label363;
            }
            localObject1 = ((ContactDataItemList)localObject1).JXy;
            if ((localObject1 == null) || (((List)localObject1).contains(localau.field_username) != true)) {
              break label363;
            }
          }
          label363:
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject1 = localau.field_username;
              s.s(localObject1, "contact.username");
              paramList.add(localObject1);
              paramArrayList1.add(locala);
            }
            paramInt += 1;
            this.JXJ.add(localau.field_username);
            break;
            localObject1 = paramm.FWt;
            break label216;
          }
        }
        ((Cursor)localObject2).close();
        i = paramInt;
      }
    }
    paramList = this.JXE;
    if (paramList != null) {
      paramList.jg((List)this.JXH);
    }
    paramArrayList.clear();
    AppMethodBeat.o(268917);
    return i;
  }
  
  private static int[] fTC()
  {
    return new int[] { 131072, 131081 };
  }
  
  public final g<d<a>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<a> paramc)
  {
    AppMethodBeat.i(268941);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new d(paramc);
    q localq = new q();
    int j = paramc.offset;
    int i = paramc.pageSize;
    if (j < this.JXH.size())
    {
      if (this.JXH.size() <= j + i) {
        break label144;
      }
      paramLifecycleScope.ABD = true;
      i += j;
      if (j >= i) {}
    }
    for (;;)
    {
      int k = j + 1;
      paramLifecycleScope.pUj.add(this.JXH.get(j));
      if (k >= i)
      {
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = k.a((kotlinx.coroutines.a.f)localq);
        AppMethodBeat.o(268941);
        return paramLifecycleScope;
        label144:
        i = this.JXH.size();
        break;
      }
      j = k;
    }
  }
  
  public final void aEJ(String paramString)
  {
    AppMethodBeat.i(268946);
    s.u(paramString, "query");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(268946);
      return;
    }
    if (this.JXD != null) {
      this.JXD.add(this.JXG);
    }
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.query = paramString;
    locall.Htx = fTC();
    locall.HtB = ((Comparator)b.Hue);
    locall.HtA = this.JXD;
    locall.HtC = ((com.tencent.mm.plugin.fts.a.l)this);
    locall.handler = this.JXC;
    locall.qRb = 16;
    this.DHR = ((n)h.az(n.class)).search(2, locall);
    AppMethodBeat.o(268946);
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(268951);
    Log.i("MicroMsg.Mvvm.ContactDataSource", s.X("ftsResult = ", paramm));
    if (paramm == null)
    {
      AppMethodBeat.o(268951);
      return;
    }
    this.DHR = null;
    this.JXH.clear();
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    this.JXJ.clear();
    this.JXI.clear();
    this.JXK.clear();
    if (paramm.HtF.size() == 0)
    {
      localObject3 = this.JXE;
      if (localObject3 != null) {
        ((ContactDataItemList)localObject3).jg((List)this.JXH);
      }
      localObject3 = this.JXE;
      if (localObject3 != null) {
        ((ContactDataItemList)localObject3).iI((List)localObject2);
      }
      localObject2 = this.JXE;
      if (localObject2 != null) {
        ((ContactDataItemList)localObject2).aU((ArrayList)localObject1);
      }
      localObject1 = this.JXF;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.fts.a.l)localObject1).b(paramm);
      }
      AppMethodBeat.o(268951);
      return;
    }
    Object localObject3 = new ArrayList();
    Object localObject4 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Iterator localIterator = paramm.HtF.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      ((ArrayList)localObject3).add(localo.Hsz);
      localArrayList.add(localo.Hsz);
      ((HashMap)localObject4).put(localo.Hsz, localo);
      if (((ArrayList)localObject3).size() > 300) {
        i = a((ArrayList)localObject3, (List)localObject2, paramm, i, (ArrayList)localObject1, (HashMap)localObject4);
      }
    }
    if (((ArrayList)localObject3).size() > 0) {
      a((ArrayList)localObject3, (List)localObject2, paramm, i, (ArrayList)localObject1, (HashMap)localObject4);
    }
    this.JXI.addAll((Collection)localArrayList);
    localObject3 = this.JXI.iterator();
    do
    {
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject3).next();
      } while (this.JXJ.contains(localObject4));
      bh.bCz();
      localObject4 = com.tencent.mm.model.c.bzA().JE((String)localObject4);
      this.JXK.add(((au)localObject4).aSU());
    } while (this.JXK.size() < 2);
    localObject3 = this.JXE;
    if (localObject3 != null) {
      ((ContactDataItemList)localObject3).iI((List)localObject2);
    }
    localObject2 = this.JXE;
    if (localObject2 != null) {
      ((ContactDataItemList)localObject2).aU((ArrayList)localObject1);
    }
    localObject1 = this.JXF;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.l)localObject1).b(paramm);
    }
    AppMethodBeat.o(268951);
  }
  
  public final int getPriority()
  {
    return 1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(268932);
    this.JXH.clear();
    aEJ(this.JXB);
    AppMethodBeat.o(268932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchContact.c
 * JD-Core Version:    0.7.0.1
 */