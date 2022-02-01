package com.tencent.mm.plugin.finder.storage.config;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.item.a;
import com.tencent.mm.plugin.finder.storage.config.item.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "clickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "bindOnClick", "initChosenIndex", "initFakeConfigItemList", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "", "isSettingUIOpen", "itemNameList", "onItemClick", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "Companion", "plugin-finder_release"})
public class b<T>
  extends d
{
  private static final String TAG = "Finder.FinderFakeConfig";
  private static final ay cCf;
  public static final a sKq;
  private String sKl;
  private ArrayList<a<T>> sKm;
  private a<T> sKn;
  private d.g.a.b<? super Integer, z> sKo;
  private final T sKp;
  
  static
  {
    AppMethodBeat.i(204348);
    sKq = new a((byte)0);
    TAG = "Finder.FinderFakeConfig";
    cCf = ay.aRW("FINDER_CONFIG_USER_KEY");
    AppMethodBeat.o(204348);
  }
  
  public b(T paramT, String paramString)
  {
    super(paramString);
    AppMethodBeat.i(204347);
    this.sKp = paramT;
    this.sKo = ((d.g.a.b)b.sKr);
    AppMethodBeat.o(204347);
  }
  
  private final void FO(int paramInt)
  {
    AppMethodBeat.i(204344);
    String str = this.sKl;
    if (str != null)
    {
      cCf.putInt(str, paramInt).commit();
      AppMethodBeat.o(204344);
      return;
    }
    AppMethodBeat.o(204344);
  }
  
  private final void ag(LinkedList<o<T, String>> paramLinkedList)
  {
    AppMethodBeat.i(204341);
    if (this.sKm == null) {
      this.sKm = new ArrayList();
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      o localo = (o)paramLinkedList.next();
      ArrayList localArrayList = this.sKm;
      if (localArrayList != null) {
        localArrayList.add(new a(localo.first, (String)localo.second));
      }
    }
    AppMethodBeat.o(204341);
  }
  
  private final int cLA()
  {
    AppMethodBeat.i(204342);
    int i;
    if (this.sKl != null)
    {
      localo = new o(Integer.valueOf(cCf.getInt(this.sKl, -1)), "get from mmkv");
      int j = ((Number)localo.first).intValue();
      ArrayList localArrayList = this.sKm;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        if (j < i) {}
      }
    }
    for (o localo = new o(Integer.valueOf(-1), "reset_default");; localo = new o(Integer.valueOf(-1), "default"))
    {
      ae.i(TAG, "code:" + hashCode() + "  keyName " + this.sKl + " initChosenIndex " + ((Number)localo.first).intValue() + " reason " + (String)localo.second + " defValue:" + this.sKp);
      i = ((Number)localo.first).intValue();
      AppMethodBeat.o(204342);
      return i;
      i = 0;
      break;
    }
  }
  
  private static boolean cLB()
  {
    return com.tencent.mm.sdk.platformtools.j.DEBUG;
  }
  
  public final b<T> C(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(204338);
    p.h(paramb, "clickListener");
    this.sKo = paramb;
    AppMethodBeat.o(204338);
    return this;
  }
  
  public void FN(int paramInt)
  {
    AppMethodBeat.i(204343);
    ArrayList localArrayList = this.sKm;
    if (localArrayList != null)
    {
      i = localArrayList.size();
      if (paramInt <= i) {
        break label141;
      }
    }
    label141:
    for (int i = -1;; i = paramInt)
    {
      this.sKs = i;
      FO(paramInt);
      if (cLB()) {
        ae.i(TAG, "code:" + hashCode() + "  keyName " + this.sKl + " onItemClick click: " + paramInt + " chosenIndex: " + this.sKs + " defValue:" + this.sKp);
      }
      this.sKo.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(204343);
      return;
      i = 0;
      break;
    }
  }
  
  public final b<T> ajx(String paramString)
  {
    AppMethodBeat.i(204336);
    p.h(paramString, "dyConfigKey");
    this.sKn = ((a)new c(this.sKp, paramString));
    AppMethodBeat.o(204336);
    return this;
  }
  
  public final b<T> b(String paramString, List<? extends T> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(204337);
    p.h(paramString, "keyName");
    p.h(paramList, "configDataList");
    p.h(paramList1, "configDataNameList");
    this.sKl = paramString;
    paramString = com.tencent.mm.plugin.finder.storage.config.item.b.sKt;
    ag(com.tencent.mm.plugin.finder.storage.config.item.b.a.l(paramList, paramList1));
    this.sKs = cLA();
    AppMethodBeat.o(204337);
    return this;
  }
  
  public final List<String> cLy()
  {
    AppMethodBeat.i(204339);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.sKm;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((a)((Iterator)localObject2).next()).name);
      }
    }
    localObject2 = this.sKn;
    if (localObject2 != null) {
      ((LinkedList)localObject1).add(((a)localObject2).name + ':' + ((a)localObject2).value());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(204339);
    return localObject1;
  }
  
  public final String cLz()
  {
    AppMethodBeat.i(204340);
    Object localObject = this.sKn;
    if (localObject != null)
    {
      String str = ((a)localObject).name + ':' + ((a)localObject).value();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "None";
    }
    AppMethodBeat.o(204340);
    return localObject;
  }
  
  public final b<T> d(com.tencent.mm.plugin.expt.b.b.a parama)
  {
    AppMethodBeat.i(204335);
    p.h(parama, "expKey");
    this.sKn = ((a)new com.tencent.mm.plugin.finder.storage.config.item.d(this.sKp, parama));
    AppMethodBeat.o(204335);
    return this;
  }
  
  public void reset()
  {
    AppMethodBeat.i(204345);
    ae.i(TAG, "code:" + hashCode() + "  keyName " + this.sKl + " reset");
    this.sKs = -1;
    FO(this.sKs);
    AppMethodBeat.o(204345);
  }
  
  public T value()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(204346);
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("getValue");
    int i;
    Object localObject1;
    if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.a.b.fnF()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
    {
      i = 1;
      if ((i != 0) && (this.sKs != -1))
      {
        int k = this.sKs;
        localObject1 = this.sKm;
        i = j;
        if (localObject1 != null) {
          i = ((ArrayList)localObject1).size();
        }
        if ((k < i) && (this.sKs >= 0)) {
          break label347;
        }
      }
      localObject1 = this.sKn;
      if (localObject1 == null) {
        break label341;
      }
      localObject1 = new o(((a)localObject1).value(), "svrConfig");
      label125:
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = new o(this.sKp, "defaultValue");
    }
    label406:
    label412:
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (cLB())
      {
        str = TAG;
        localStringBuilder = new StringBuilder("code:").append(hashCode()).append("  keyName ").append(this.sKl).append(" config getValue chosenIndex ").append(this.sKs).append(" size:");
        localObject2 = this.sKm;
        if (localObject2 == null) {
          break label406;
        }
      }
      for (Object localObject2 = Integer.valueOf(((ArrayList)localObject2).size());; localObject2 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject2).append(" realConfig ");
        a locala = this.sKn;
        localObject2 = localObject3;
        if (locala != null) {
          localObject2 = locala.value();
        }
        ae.i(str, localObject2 + " ret:" + (String)((o)localObject1).second + "==>" + ((o)localObject1).first + ' ' + localb);
        localObject1 = ((o)localObject1).first;
        AppMethodBeat.o(204346);
        return localObject1;
        i = 0;
        break;
        label341:
        localObject1 = null;
        break label125;
        label347:
        localObject1 = this.sKm;
        if (localObject1 != null)
        {
          localObject1 = (a)d.a.j.F((List)localObject1, this.sKs);
          if (localObject1 != null)
          {
            localObject1 = new o(((a)localObject1).value(), "userConfig");
            break label125;
          }
        }
        localObject1 = null;
        break label125;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig$Companion;", "", "()V", "FINDER_CONFIG_USER_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "index", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Integer, z>
  {
    public static final b sKr;
    
    static
    {
      AppMethodBeat.i(204334);
      sKr = new b();
      AppMethodBeat.o(204334);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.b
 * JD-Core Version:    0.7.0.1
 */