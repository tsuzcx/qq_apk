package com.tencent.mm.plugin.ac.a;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.pending.PendingEventHandler;
import com.tencent.mm.sdk.event.pending.PendingEventNotifier;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.observer.IMvvmTypeObserverOwner;
import com.tencent.mm.sdk.observer.IMvvmTypeObserverOwner.DefaultImpls;
import com.tencent.mm.sdk.observer.MvvmTypeObserverOwner;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ColumnOrder;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.ISqlOrder;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.sdk.storage.sql.Sql.BitAndEqual;
import com.tencent.mm.sdk.storage.sql.Sql.BitAndNotEqual;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmStorage;", "Lcom/tencent/mm/sdk/observer/IMvvmTypeObserverOwner;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "", "Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "()V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "notifier", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "getNotifier", "()Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "notifier$delegate", "owner", "com/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$owner$2$1", "getOwner", "()Lcom/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$owner$2$1;", "owner$delegate", "transactionCallback", "com/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$transactionCallback$1", "Lcom/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$transactionCallback$1;", "getAllKey", "getListContact", "", "usernameList", "handleEvent", "", "eventList", "hasObserver", "", "key", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "onCleared", "removeObserver", "Companion", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.ac.b
  implements PendingEventHandler<StorageObserverEvent<au>>, IMvvmTypeObserverOwner<IStorageObserver<au>, StorageObserverEvent<au>, String>
{
  public static final a MnU;
  private final j DHI;
  private final j MnR;
  private final e MnV;
  private final j owner$delegate;
  
  static
  {
    AppMethodBeat.i(262759);
    MnU = new a((byte)0);
    AppMethodBeat.o(262759);
  }
  
  public a()
  {
    AppMethodBeat.i(262752);
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.MnX);
    this.MnV = new e(this);
    h.baC().aZJ();
    bx localbx = ((n)h.ax(n.class)).bzA();
    com.tencent.mm.kernel.a locala = h.baC().mBP;
    s.s(locala, "account().accountModelOwner");
    localbx.observe((q)locala, (IMvvmObserver)new IStorageObserver() {});
    h.baE().a((h.a)this.MnV);
    this.MnR = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.owner$delegate = kotlin.k.cm((kotlin.g.a.a)d.MnY);
    AppMethodBeat.o(262752);
  }
  
  private final a.d.1 gsB()
  {
    AppMethodBeat.i(262755);
    a.d.1 local1 = (a.d.1)this.owner$delegate.getValue();
    AppMethodBeat.o(262755);
    return local1;
  }
  
  public final void handleEvent(List<? extends StorageObserverEvent<au>> paramList)
  {
    AppMethodBeat.i(262763);
    s.u(paramList, "eventList");
    Log.i("MicroMsg.Mvvm.MvvmContactStorage", s.X("handleEvent: ", Integer.valueOf(paramList.size())));
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      StorageObserverEvent localStorageObserverEvent = (StorageObserverEvent)localIterator.next();
      gsB().notify(localStorageObserverEvent.getPendingKey(), localStorageObserverEvent, false);
    }
    gsB().notifyAll(paramList);
    AppMethodBeat.o(262763);
  }
  
  public final List<au> jh(List<String> paramList)
  {
    AppMethodBeat.i(262765);
    s.u(paramList, "usernameList");
    Object localObject = au.TABLE.selectAll().where((ISqlCondition)au.USERNAME.inString(paramList)).log("MicroMsg.Mvvm.MvvmContactStorage").build();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Iterable)((SelectSql)localObject).multiQuery(((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB(), au.class)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      au localau = (au)((Iterator)localObject).next();
      Map localMap = (Map)localHashMap;
      String str = localau.field_username;
      s.s(str, "contact.username");
      localMap.put(str, localau);
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject = (au)localHashMap.get((String)paramList.next());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(262765);
    return paramList;
  }
  
  public final void notifyAll(List<? extends StorageObserverEvent<au>> paramList)
  {
    AppMethodBeat.i(262766);
    IMvvmTypeObserverOwner.DefaultImpls.notifyAll(this, paramList);
    AppMethodBeat.o(262766);
  }
  
  public final void observe(q paramq, IStorageObserver<au> paramIStorageObserver)
  {
    AppMethodBeat.i(262764);
    s.u(paramq, "lifecycleOwner");
    s.u(paramIStorageObserver, "observer");
    gsB().observe(paramq, (IMvvmObserver)paramIStorageObserver);
    AppMethodBeat.o(262764);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(262761);
    f localf = h.baE();
    h.a locala = (h.a)this.MnV;
    localf.mCG.remove(locala);
    AppMethodBeat.o(262761);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$Companion;", "", "()V", "ALL_KEY", "", "MAX_ASCII", "", "TAG", "THREAD_TAG", "calculateContactShowHead", "displayName", "getNormalContactCondition", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "getShowHeadOrder", "", "Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static char aPL(String paramString)
    {
      int j = 1;
      AppMethodBeat.i(262756);
      s.u(paramString, "displayName");
      paramString = paramString.toCharArray();
      s.s(paramString, "(this as java.lang.String).toCharArray()");
      paramString = kotlin.a.k.c(paramString);
      char c;
      int i;
      if (paramString == null)
      {
        c = ' ';
        if ('a' > c) {
          break label80;
        }
        if (c > 'z') {
          break label75;
        }
        i = 1;
        label50:
        if (i == 0) {
          break label85;
        }
        c = (char)(c - ' ');
      }
      label75:
      label80:
      label85:
      label117:
      for (;;)
      {
        AppMethodBeat.o(262756);
        return c;
        c = paramString.charValue();
        break;
        i = 0;
        break label50;
        i = 0;
        break label50;
        if ('A' <= c) {
          if (c <= 'Z') {
            i = j;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label117;
          }
          c = '{';
          break;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    
    public static List<ISqlOrder> gsC()
    {
      AppMethodBeat.i(262741);
      List localList = p.listOf(new ISqlOrder[] { (ISqlOrder)new ColumnOrder("showHead", false, 2, null), (ISqlOrder)new a.a.a() });
      AppMethodBeat.o(262741);
      return localList;
    }
    
    public static ISqlCondition gsD()
    {
      AppMethodBeat.i(262753);
      ISqlCondition localISqlCondition = new Sql.BitAndNotEqual("type", d.aSp(), 0).and((ISqlCondition)new Sql.BitAndEqual("type", d.aSA(), 0)).and((ISqlCondition)new Sql.BitAndEqual("type", d.aSq(), 0)).and((ISqlCondition)new Sql.BitAndEqual("verifyFlag", au.iZH(), 0));
      AppMethodBeat.o(262753);
      return localISqlCondition;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b MnX;
    
    static
    {
      AppMethodBeat.i(262739);
      MnX = new b();
      AppMethodBeat.o(262739);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Lcom/tencent/mm/storage/Contact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<PendingEventNotifier<StorageObserverEvent<au>>>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$owner$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<1>
  {
    public static final d MnY;
    
    static
    {
      AppMethodBeat.i(262736);
      MnY = new d();
      AppMethodBeat.o(262736);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$transactionCallback$1", "Lcom/tencent/mm/storagebase/SqliteDB$Callbacks;", "postBeginTransCallback", "", "postEndTransCallback", "preCloseCallback", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements h.a
  {
    e(a parama) {}
    
    public final void bau()
    {
      AppMethodBeat.i(262737);
      Log.i("MicroMsg.Mvvm.MvvmContactStorage", "preCloseCallback sqliteDB");
      a.a(this.MnW).resumePendingNotify();
      AppMethodBeat.o(262737);
    }
    
    public final void bav()
    {
      AppMethodBeat.i(262744);
      a.a(this.MnW).pausePendingNotify();
      AppMethodBeat.o(262744);
    }
    
    public final void baw()
    {
      AppMethodBeat.i(262747);
      a.a(this.MnW).resumePendingNotify();
      AppMethodBeat.o(262747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a.a
 * JD-Core Version:    0.7.0.1
 */