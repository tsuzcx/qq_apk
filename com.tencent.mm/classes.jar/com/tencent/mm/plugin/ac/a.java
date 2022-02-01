package com.tencent.mm.plugin.ac;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.storagebase.h.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "storageOwner", "Landroidx/lifecycle/ViewModelStore;", "collectFinderDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getStorage", "T", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "()Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "getViewModelStore", "onCleared", "", "updateTableInfo", "Companion", "EntityFactory", "InnerLifeDBProvider", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends af
  implements ak
{
  public static final a MnH = new a((byte)0);
  private final x<String> MnI = new x();
  private final aj MnJ = new aj();
  
  public final <T extends g<? extends IAutoDBItem>> T bV(Class<T> paramClass)
  {
    s.u(paramClass, "modelClass");
    paramClass = new ah(this.MnJ, (ah.b)new d(this)).q(paramClass);
    s.s(paramClass, "fun <T : MvvmStorage<out… }).get(modelClass)\n    }");
    return (g)paramClass;
  }
  
  protected final HashMap<Integer, h.b> collectFinderDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (e)getClass().getAnnotation(e.class);
    if (localObject != null)
    {
      localObject = ai.d(((e)localObject).gsA());
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          c localc = localObject[i];
          String str = ((IAutoDBItem)kotlin.g.a.b(localc).newInstance()).getTableName();
          Log.i("MicroMsg.Mvvm.BaseMvvmDB", s.X("collectFinderDatabaseFactory tableName:", str));
          Map localMap = (Map)localHashMap;
          int k = str.hashCode();
          s.s(str, "tableName");
          localMap.put(Integer.valueOf(k), new b(localc, str));
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  public abstract com.tencent.mm.storagebase.h getDB();
  
  public aj getViewModelStore()
  {
    return this.MnJ;
  }
  
  protected final void gsz()
  {
    Object localObject1 = (e)getClass().getAnnotation(e.class);
    if (localObject1 != null)
    {
      localObject1 = ai.d(((e)localObject1).gsA());
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          com.tencent.mm.storagebase.h localh = getDB();
          if (localh != null)
          {
            Object localObject3 = (IAutoDBItem)kotlin.g.a.b((c)localObject2).newInstance();
            localObject2 = ((IAutoDBItem)localObject3).getTableName();
            localObject3 = MAutoStorage.getUpdateSQLs(((IAutoDBItem)localObject3).getDBInfo(), (String)localObject2, (ISQLiteDatabase)localh);
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                Log.i("MicroMsg.Mvvm.BaseMvvmDB", s.X("exec SQL ", str));
                localh.execSQL((String)localObject2, str);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onCleared()
  {
    int i = 1;
    this.MnJ.clear();
    com.tencent.mm.storagebase.h localh = getDB();
    if ((localh != null) && (localh.isOpen() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localh = getDB();
        if (localh != null) {
          localh.closeDB();
        }
      }
      return;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB$Companion;", "", "()V", "TAG", "", "getLiveDB", "T", "Landroidx/lifecycle/ViewModel;", "()Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T extends af> T bW(Class<T> paramClass)
    {
      AppMethodBeat.i(262724);
      s.u(paramClass, "modelClass");
      com.tencent.mm.kernel.h.baC().aZJ();
      if (!a.class.isAssignableFrom(paramClass))
      {
        paramClass = new IllegalArgumentException("getLiveDB modelClass must extends BaseMMLiveDB");
        AppMethodBeat.o(262724);
        throw paramClass;
      }
      paramClass = new ah((ak)com.tencent.mm.kernel.h.baC().mBP, (ah.b)new a.a.a()).q(paramClass);
      AppMethodBeat.o(262724);
      return paramClass;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB$EntityFactory;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "tableName", "", "(Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB;Lkotlin/reflect/KClass;Ljava/lang/String;)V", "getClazz", "()Lkotlin/reflect/KClass;", "getTableName", "()Ljava/lang/String;", "getSQLs", "", "()[Ljava/lang/String;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements h.b
  {
    private final c<? extends IAutoDBItem> MnK;
    private final String tableName;
    
    public b(String paramString)
    {
      AppMethodBeat.i(262728);
      this.MnK = paramString;
      this.tableName = localObject;
      AppMethodBeat.o(262728);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(262732);
      Object localObject1 = new ArrayList();
      Object localObject2 = MAutoStorage.getCreateSQLs(((IAutoDBItem)kotlin.g.a.b(this.MnK).newInstance()).getDBInfo(), this.tableName);
      if (localObject2 != null) {
        ((ArrayList)localObject1).add(localObject2);
      }
      localObject2 = (Collection)localObject1;
      String[] arrayOfString = ((IAutoDBItem)kotlin.g.a.b(this.MnK).newInstance()).getIndexCreateSQL();
      s.s(arrayOfString, "clazz.java.newInstance().indexCreateSQL");
      p.a((Collection)localObject2, (Object[])arrayOfString);
      localObject1 = ((Collection)localObject1).toArray(new String[0]);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(262732);
        throw ((Throwable)localObject1);
      }
      localObject1 = (String[])localObject1;
      AppMethodBeat.o(262732);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB$InnerLifeDBProvider;", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB;)V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements IMvvmDBProvider
  {
    public c()
    {
      AppMethodBeat.i(262719);
      AppMethodBeat.o(262719);
    }
    
    public final ISQLiteDatabase getDB()
    {
      int i = 1;
      AppMethodBeat.i(262723);
      Object localObject = this.MnL.getDB();
      if ((localObject != null) && (((com.tencent.mm.storagebase.h)localObject).isOpen() == true)) {}
      while (i != 0)
      {
        localObject = (ISQLiteDatabase)this.MnL.getDB();
        AppMethodBeat.o(262723);
        return localObject;
        i = 0;
      }
      AppMethodBeat.o(262723);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mvvmstorage/BaseMvvmDB$getStorage$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ah.b
  {
    d(a parama) {}
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(262722);
      s.u(paramClass, "modelClass");
      paramClass = (af)paramClass.getConstructor(new Class[] { IMvvmDBProvider.class }).newInstance(new Object[] { new a.c(this.MnL) });
      AppMethodBeat.o(262722);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a
 * JD-Core Version:    0.7.0.1
 */