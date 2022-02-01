package com.tencent.mm.plugin.ab;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmcomm/DefaultMvvmStorage;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "K", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "provider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "liveData", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "convert", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;Lcom/tencent/mm/plugin/mvvmlist/MvvmList;Lkotlin/jvm/functions/Function1;)V", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "getConvert", "()Lkotlin/jvm/functions/Function1;", "setConvert", "(Lkotlin/jvm/functions/Function1;)V", "getLiveData", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveData", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "convertLiveData", "item", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "liveObserve", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Companion", "plugin-mvvmcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<T extends IAutoDBItem, K extends com.tencent.mm.plugin.mvvmlist.b<K>>
  extends g<T>
  implements IStorageObserver<T>
{
  public static final b.a MmD;
  private MvvmList<K> MmE;
  public kotlin.g.a.b<? super T, ? extends K> MmF;
  
  static
  {
    AppMethodBeat.i(260446);
    MmD = new b.a((byte)0);
    AppMethodBeat.o(260446);
  }
  
  public b(IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(260422);
    AppMethodBeat.o(260422);
  }
  
  public b(IMvvmDBProvider paramIMvvmDBProvider, MvvmList<K> paramMvvmList, kotlin.g.a.b<? super T, ? extends K> paramb)
  {
    this(paramIMvvmDBProvider);
    AppMethodBeat.i(260428);
    this.MmE = paramMvvmList;
    paramIMvvmDBProvider = this.MmE;
    if (paramIMvvmDBProvider != null) {
      observe((q)paramIMvvmDBProvider, (IStorageObserver)this);
    }
    this.MmF = paramb;
    AppMethodBeat.o(260428);
  }
  
  private K a(T paramT)
  {
    AppMethodBeat.i(260442);
    s.u(paramT, "item");
    kotlin.g.a.b localb = this.MmF;
    if (localb == null)
    {
      AppMethodBeat.o(260442);
      return null;
    }
    paramT = (com.tencent.mm.plugin.mvvmlist.b)localb.invoke(paramT);
    AppMethodBeat.o(260442);
    return paramT;
  }
  
  public final b<T, K> a(MvvmList<K> paramMvvmList)
  {
    AppMethodBeat.i(260451);
    s.u(paramMvvmList, "liveData");
    this.MmE = paramMvvmList;
    observe((q)paramMvvmList, (IStorageObserver)this);
    AppMethodBeat.o(260451);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.b
 * JD-Core Version:    0.7.0.1
 */