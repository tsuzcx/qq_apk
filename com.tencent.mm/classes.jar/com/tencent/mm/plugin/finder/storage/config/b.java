package com.tencent.mm.plugin.finder.storage.config;

import android.arch.lifecycle.MutableLiveData;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.storage.config.item.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "booleanWrapper", "Lkotlin/Function1;", "", "chosenData", "Landroid/arch/lifecycle/MutableLiveData;", "clickListener", "", "Lkotlin/ParameterName;", "name", "index", "", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "versionTag", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "bindOnClick", "booleanValue", "initChosenIndex", "initFakeConfigItemList", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "isSettingUIOpen", "itemNameList", "map", "wrapper", "observe", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "observer", "Landroid/arch/lifecycle/Observer;", "onItemClick", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "tag", "Companion", "plugin-finder_release"})
public class b<T>
  extends e
{
  private static final String TAG = "Finder.FinderFakeConfig";
  private static final MultiProcessMMKV cQe;
  public static final a vFD;
  private final MutableLiveData<T> vFA;
  private String vFB;
  private final T vFC;
  private String vFw;
  private ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> vFx;
  private com.tencent.mm.plugin.finder.storage.config.item.a<T> vFy;
  private kotlin.g.a.b<? super Integer, x> vFz;
  
  static
  {
    AppMethodBeat.i(251922);
    vFD = new a((byte)0);
    TAG = "Finder.FinderFakeConfig";
    cQe = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY");
    AppMethodBeat.o(251922);
  }
  
  public b(T paramT, String paramString)
  {
    super(paramString);
    AppMethodBeat.i(251921);
    this.vFC = paramT;
    this.vFz = ((kotlin.g.a.b)d.vFF);
    this.vFA = new MutableLiveData();
    this.vFB = "";
    AppMethodBeat.o(251921);
  }
  
  private static boolean KB()
  {
    return BuildInfo.DEBUG;
  }
  
  private final void Ld(int paramInt)
  {
    AppMethodBeat.i(251918);
    String str = this.vFw;
    if (str != null)
    {
      cQe.putInt(str, paramInt).commit();
      AppMethodBeat.o(251918);
      return;
    }
    AppMethodBeat.o(251918);
  }
  
  private final void ax(LinkedList<o<T, String>> paramLinkedList)
  {
    AppMethodBeat.i(251915);
    if (this.vFx == null) {
      this.vFx = new ArrayList();
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      o localo = (o)paramLinkedList.next();
      ArrayList localArrayList = this.vFx;
      if (localArrayList != null) {
        localArrayList.add(new com.tencent.mm.plugin.finder.storage.config.item.a(localo.first, (String)localo.second));
      }
    }
    AppMethodBeat.o(251915);
  }
  
  private final int dyr()
  {
    AppMethodBeat.i(251916);
    int i;
    if (this.vFw != null)
    {
      localo = new o(Integer.valueOf(cQe.getInt(this.vFw, -1)), "get from mmkv");
      int j = ((Number)localo.first).intValue();
      ArrayList localArrayList = this.vFx;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        if (j < i) {}
      }
    }
    for (o localo = new o(Integer.valueOf(-1), "reset_default");; localo = new o(Integer.valueOf(-1), "default"))
    {
      Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " initChosenIndex " + ((Number)localo.first).intValue() + " reason " + (String)localo.second + " defValue:" + this.vFC);
      i = ((Number)localo.first).intValue();
      AppMethodBeat.o(251916);
      return i;
      i = 0;
      break;
    }
  }
  
  public final b<T> H(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(251911);
    p.h(paramb, "clickListener");
    this.vFz = paramb;
    AppMethodBeat.o(251911);
    return this;
  }
  
  public void Lc(int paramInt)
  {
    AppMethodBeat.i(251917);
    Object localObject = this.vFx;
    if (localObject != null)
    {
      i = ((ArrayList)localObject).size();
      if (paramInt <= i) {
        break label183;
      }
    }
    label183:
    for (int i = -1;; i = paramInt)
    {
      this.vFI = i;
      localObject = this.vFx;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.storage.config.item.a)j.L((List)localObject, this.vFI);
        if (localObject != null) {
          this.vFA.setValue(((com.tencent.mm.plugin.finder.storage.config.item.a)localObject).value());
        }
      }
      Ld(paramInt);
      if (KB()) {
        Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " onItemClick click: " + paramInt + " chosenIndex: " + this.vFI + " defValue:" + this.vFC);
      }
      this.vFz.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(251917);
      return;
      i = 0;
      break;
    }
  }
  
  public final b<T> avD(String paramString)
  {
    AppMethodBeat.i(251909);
    p.h(paramString, "dyConfigKey");
    this.vFy = ((com.tencent.mm.plugin.finder.storage.config.item.a)new com.tencent.mm.plugin.finder.storage.config.item.e(this.vFC, paramString, (kotlin.g.a.a)new b(this)));
    AppMethodBeat.o(251909);
    return this;
  }
  
  public final b<T> avE(String paramString)
  {
    AppMethodBeat.i(251912);
    p.h(paramString, "tag");
    this.vFB = paramString;
    AppMethodBeat.o(251912);
    return this;
  }
  
  public final b<T> b(String paramString, List<? extends T> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(251910);
    p.h(paramString, "keyName");
    p.h(paramList, "configDataList");
    p.h(paramList1, "configDataNameList");
    this.vFw = paramString;
    paramString = com.tencent.mm.plugin.finder.storage.config.item.b.vFL;
    ax(com.tencent.mm.plugin.finder.storage.config.item.b.a.n(paramList, paramList1));
    this.vFI = dyr();
    AppMethodBeat.o(251910);
    return this;
  }
  
  public final b<T> d(com.tencent.mm.plugin.expt.b.b.a parama)
  {
    AppMethodBeat.i(251908);
    p.h(parama, "expKey");
    this.vFy = ((com.tencent.mm.plugin.finder.storage.config.item.a)new f(this.vFC, parama, (kotlin.g.a.a)new c(this)));
    AppMethodBeat.o(251908);
    return this;
  }
  
  public final List<String> dyo()
  {
    AppMethodBeat.i(251913);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.vFx;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((com.tencent.mm.plugin.finder.storage.config.item.a)((Iterator)localObject2).next()).name);
      }
    }
    localObject2 = this.vFy;
    if (localObject2 != null) {
      ((LinkedList)localObject1).add(((com.tencent.mm.plugin.finder.storage.config.item.a)localObject2).name + ':' + ((com.tencent.mm.plugin.finder.storage.config.item.a)localObject2).value());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(251913);
    return localObject1;
  }
  
  public final String dyp()
  {
    AppMethodBeat.i(251914);
    Object localObject = this.vFy;
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.finder.storage.config.item.a)localObject).name + ':' + ((com.tencent.mm.plugin.finder.storage.config.item.a)localObject).value();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "None";
    }
    AppMethodBeat.o(251914);
    return localObject;
  }
  
  public final String dyq()
  {
    return this.vFB;
  }
  
  public void reset()
  {
    AppMethodBeat.i(251919);
    Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " reset");
    this.vFI = -1;
    Ld(this.vFI);
    AppMethodBeat.o(251919);
  }
  
  public T value()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(251920);
    c localc = new c("getValue");
    int i;
    Object localObject1;
    if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      i = 1;
      if ((i != 0) && (this.vFI != -1))
      {
        int k = this.vFI;
        localObject1 = this.vFx;
        i = j;
        if (localObject1 != null) {
          i = ((ArrayList)localObject1).size();
        }
        if ((k < i) && (this.vFI >= 0)) {
          break label349;
        }
      }
      localObject1 = this.vFy;
      if (localObject1 == null) {
        break label343;
      }
      localObject1 = new o(((com.tencent.mm.plugin.finder.storage.config.item.a)localObject1).value(), "svrConfig");
      label125:
      if (localObject1 != null) {
        break label414;
      }
      localObject1 = new o(this.vFC, "defaultValue");
    }
    label408:
    label414:
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (KB())
      {
        str = TAG;
        localStringBuilder = new StringBuilder("code:").append(hashCode()).append("  keyName ").append(this.vFw).append(" config getValue chosenIndex ").append(this.vFI).append(" size:");
        localObject2 = this.vFx;
        if (localObject2 == null) {
          break label408;
        }
      }
      for (Object localObject2 = Integer.valueOf(((ArrayList)localObject2).size());; localObject2 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject2).append(" realConfig ");
        com.tencent.mm.plugin.finder.storage.config.item.a locala = this.vFy;
        localObject2 = localObject3;
        if (locala != null) {
          localObject2 = locala.value();
        }
        Log.i(str, localObject2 + " ret:" + (String)((o)localObject1).second + "==>" + ((o)localObject1).first + ' ' + localc);
        localObject1 = ((o)localObject1).first;
        AppMethodBeat.o(251920);
        return localObject1;
        i = 0;
        break;
        label343:
        localObject1 = null;
        break label125;
        label349:
        localObject1 = this.vFx;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.finder.storage.config.item.a)j.L((List)localObject1, this.vFI);
          if (localObject1 != null)
          {
            localObject1 = new o(((com.tencent.mm.plugin.finder.storage.config.item.a)localObject1).value(), "userConfig");
            break label125;
          }
        }
        localObject1 = null;
        break label125;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig$Companion;", "", "()V", "FINDER_CONFIG_USER_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "index", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final d vFF;
    
    static
    {
      AppMethodBeat.i(251907);
      vFF = new d();
      AppMethodBeat.o(251907);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.b
 * JD-Core Version:    0.7.0.1
 */