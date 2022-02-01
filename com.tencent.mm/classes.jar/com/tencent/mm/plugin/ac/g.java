package com.tencent.mm.plugin.ac;

import android.content.ContentValues;
import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.pending.PendingEventHandler;
import com.tencent.mm.sdk.event.pending.PendingEventNotifier;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ObservableStorage;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.MultiCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleCondition;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.sdk.storage.sql.Sql.Equal;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.c;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/sdk/storage/ObservableStorage;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "getDbProvider", "()Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "createObserverOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "delete", "", "item", "isNotify", "", "needLog", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)I", "get", "cv", "Landroid/content/ContentValues;", "clazz", "Lkotlin/reflect/KClass;", "(Landroid/content/ContentValues;Lkotlin/reflect/KClass;)Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "", "insert", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)Z", "replace", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)J", "update", "Companion", "LiveStorageObserverOwner", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g<T extends IAutoDBItem>
  extends ObservableStorage<T>
{
  public static final a MnP = new a((byte)0);
  public final IMvvmDBProvider MnQ;
  
  protected g(IMvvmDBProvider paramIMvvmDBProvider)
  {
    this.MnQ = paramIMvvmDBProvider;
  }
  
  public final T a(ContentValues paramContentValues, c<T> paramc)
  {
    Object localObject1 = null;
    s.u(paramContentValues, "cv");
    s.u(paramc, "clazz");
    ISQLiteDatabase localISQLiteDatabase = this.MnQ.getDB();
    if (localISQLiteDatabase != null)
    {
      localObject1 = paramContentValues.keySet();
      s.s(localObject1, "cv.keySet()");
      Iterator localIterator = ((Iterable)localObject1).iterator();
      localObject1 = null;
      label169:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = paramContentValues.get(str);
        if (localObject2 != null)
        {
          if (localObject1 == null) {}
          for (MultiCondition localMultiCondition = null;; localMultiCondition = ((MultiCondition)localObject1).and((ISqlCondition)new Sql.Equal(str, localObject2.toString())))
          {
            if (localMultiCondition != null) {
              break label169;
            }
            s.s(str, "key");
            localObject1 = new MultiCondition((SingleCondition)new Sql.Equal(str, localObject2.toString()));
            break;
            s.s(str, "key");
          }
        }
      }
      paramContentValues = ((IAutoDBItem)kotlin.g.a.b(paramc).newInstance()).getTableName();
      s.s(paramContentValues, "item.tableName");
      localObject1 = new SingleTable(paramContentValues).selectAll().log(getLogTag()).where((ISqlCondition)localObject1).limit(1, 0).build().singleQuery(localISQLiteDatabase, kotlin.g.a.b(paramc));
    }
    return localObject1;
  }
  
  public StorageObserverOwner<T> createObserverOwner()
  {
    return (StorageObserverOwner)new b();
  }
  
  public String getLogTag()
  {
    return "MicroMsg.Mvvm.MMLiveStorage";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage$Companion;", "", "()V", "TAG", "", "getDbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "item", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getStorage", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T extends g<? extends IAutoDBItem>> T a(Class<T> paramClass, IMvvmDBProvider paramIMvvmDBProvider)
    {
      AppMethodBeat.i(262720);
      s.u(paramClass, "modelClass");
      s.u(paramIMvvmDBProvider, "dbProvider");
      paramClass = new ah((ak)h.baC().mBP, (ah.b)new a(paramIMvvmDBProvider)).q(paramClass);
      s.s(paramClass, "dbProvider: IMvvmDBProvi…       }).get(modelClass)");
      paramClass = (g)paramClass;
      AppMethodBeat.o(262720);
      return paramClass;
    }
    
    public static <T extends IAutoDBItem> IAutoDBItem.MAutoDBInfo b(T paramT)
    {
      AppMethodBeat.i(262716);
      s.u(paramT, "item");
      paramT = paramT.getDBInfo();
      CharSequence localCharSequence = (CharSequence)paramT.primaryKey;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramT.primaryKey = "rowid";
        }
        s.s(paramT, "item.dbInfo.also {\n     …          }\n            }");
        AppMethodBeat.o(262716);
        return paramT;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mvvmstorage/MvvmStorage$Companion$getStorage$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ah.b
    {
      a(IMvvmDBProvider paramIMvvmDBProvider) {}
      
      public final <T extends af> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(262733);
        s.u(paramClass, "modelClass");
        paramClass = (af)paramClass.getConstructor(new Class[] { IMvvmDBProvider.class }).newInstance(new Object[] { this.JmS });
        AppMethodBeat.o(262733);
        return paramClass;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage$LiveStorageObserverOwner;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "(Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;)V", "notifier", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "getNotifier", "()Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "notifier$delegate", "Lkotlin/Lazy;", "handleEvent", "", "eventList", "", "notify", "event", "superNotify", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b<T extends IAutoDBItem>
    extends StorageObserverOwner<T>
    implements PendingEventHandler<StorageObserverEvent<T>>
  {
    private final j MnR;
    
    public b()
    {
      AppMethodBeat.i(262711);
      this.MnR = k.cm((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(262711);
    }
    
    public final void handleEvent(List<? extends StorageObserverEvent<T>> paramList)
    {
      AppMethodBeat.i(262717);
      s.u(paramList, "eventList");
      super.notify(paramList);
      AppMethodBeat.o(262717);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<PendingEventNotifier<StorageObserverEvent<T>>>
    {
      a(g<T>.b<T> paramg)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.g
 * JD-Core Version:    0.7.0.1
 */