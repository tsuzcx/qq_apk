package com.tencent.mm.plugin.findersdk.d.a.a;

import android.content.SharedPreferences.Editor;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.plugin.findersdk.d.a.b.f;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "booleanWrapper", "Lkotlin/Function1;", "", "chosenData", "Landroidx/lifecycle/MutableLiveData;", "clickListener", "", "Lkotlin/ParameterName;", "name", "index", "", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "versionTag", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "bindOnClick", "booleanValue", "initChosenIndex", "initFakeConfigItemList", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "isSettingUIOpen", "itemNameList", "map", "wrapper", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "onItemClick", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "tag", "Companion", "finder-sdk_release"})
public class b<T>
  extends e
{
  public static final a Bwv;
  private static final String TAG = "Finder.FinderFakeConfig";
  private static final MultiProcessMMKV cQO;
  private String Bwo;
  private ArrayList<com.tencent.mm.plugin.findersdk.d.a.b.a<T>> Bwp;
  private com.tencent.mm.plugin.findersdk.d.a.b.a<T> Bwq;
  private kotlin.g.a.b<? super Integer, x> Bwr;
  private final r<T> Bws;
  private String Bwt;
  private final T Bwu;
  
  static
  {
    AppMethodBeat.i(207644);
    Bwv = new a((byte)0);
    TAG = "Finder.FinderFakeConfig";
    cQO = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY");
    AppMethodBeat.o(207644);
  }
  
  public b(T paramT, String paramString)
  {
    super(paramString);
    AppMethodBeat.i(207641);
    this.Bwu = paramT;
    this.Bwr = ((kotlin.g.a.b)d.Bwx);
    this.Bws = new r();
    this.Bwt = "";
    AppMethodBeat.o(207641);
  }
  
  private static boolean No()
  {
    return BuildInfo.DEBUG;
  }
  
  private final void Sj(int paramInt)
  {
    AppMethodBeat.i(207633);
    String str = this.Bwo;
    if (str != null)
    {
      cQO.putInt(str, paramInt).commit();
      AppMethodBeat.o(207633);
      return;
    }
    AppMethodBeat.o(207633);
  }
  
  private final void bc(LinkedList<o<T, String>> paramLinkedList)
  {
    AppMethodBeat.i(207628);
    if (this.Bwp == null) {
      this.Bwp = new ArrayList();
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      o localo = (o)paramLinkedList.next();
      ArrayList localArrayList = this.Bwp;
      if (localArrayList != null) {
        localArrayList.add(new com.tencent.mm.plugin.findersdk.d.a.b.a(localo.Mx, (String)localo.My));
      }
    }
    AppMethodBeat.o(207628);
  }
  
  private final int enz()
  {
    AppMethodBeat.i(207631);
    int i;
    if (this.Bwo != null)
    {
      localo = new o(Integer.valueOf(cQO.getInt(this.Bwo, -1)), "get from mmkv");
      int j = ((Number)localo.Mx).intValue();
      ArrayList localArrayList = this.Bwp;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        if (j < i) {}
      }
    }
    for (o localo = new o(Integer.valueOf(-1), "reset_default");; localo = new o(Integer.valueOf(-1), "default"))
    {
      Log.i(TAG, "code:" + hashCode() + "  keyName " + this.Bwo + " initChosenIndex " + ((Number)localo.Mx).intValue() + " reason " + (String)localo.My + " defValue:" + this.Bwu);
      i = ((Number)localo.Mx).intValue();
      AppMethodBeat.o(207631);
      return i;
      i = 0;
      break;
    }
  }
  
  public final b<T> R(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(207619);
    p.k(paramb, "clickListener");
    this.Bwr = paramb;
    AppMethodBeat.o(207619);
    return this;
  }
  
  public void Si(int paramInt)
  {
    AppMethodBeat.i(207632);
    Object localObject = this.Bwp;
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
      this.BwA = i;
      localObject = this.Bwp;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.findersdk.d.a.b.a)j.M((List)localObject, this.BwA);
        if (localObject != null) {
          this.Bws.setValue(((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject).aSr());
        }
      }
      Sj(paramInt);
      if (No()) {
        Log.i(TAG, "code:" + hashCode() + "  keyName " + this.Bwo + " onItemClick click: " + paramInt + " chosenIndex: " + this.BwA + " defValue:" + this.Bwu);
      }
      this.Bwr.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(207632);
      return;
      i = 0;
      break;
    }
  }
  
  public final b<T> aGT(String paramString)
  {
    AppMethodBeat.i(207615);
    p.k(paramString, "dyConfigKey");
    this.Bwq = ((com.tencent.mm.plugin.findersdk.d.a.b.a)new com.tencent.mm.plugin.findersdk.d.a.b.e(this.Bwu, paramString, (kotlin.g.a.a)new b(this)));
    AppMethodBeat.o(207615);
    return this;
  }
  
  public final b<T> aGU(String paramString)
  {
    AppMethodBeat.i(207622);
    p.k(paramString, "tag");
    this.Bwt = paramString;
    AppMethodBeat.o(207622);
    return this;
  }
  
  public T aSr()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(207638);
    c localc = new c("getValue");
    int i;
    Object localObject1;
    if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      i = 1;
      if ((i != 0) && (this.BwA != -1))
      {
        int k = this.BwA;
        localObject1 = this.Bwp;
        i = j;
        if (localObject1 != null) {
          i = ((ArrayList)localObject1).size();
        }
        if ((k < i) && (this.BwA >= 0)) {
          break label349;
        }
      }
      localObject1 = this.Bwq;
      if (localObject1 == null) {
        break label343;
      }
      localObject1 = new o(((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject1).aSr(), "svrConfig");
      label125:
      if (localObject1 != null) {
        break label414;
      }
      localObject1 = new o(this.Bwu, "defaultValue");
    }
    label408:
    label414:
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (No())
      {
        str = TAG;
        localStringBuilder = new StringBuilder("code:").append(hashCode()).append("  keyName ").append(this.Bwo).append(" config getValue chosenIndex ").append(this.BwA).append(" size:");
        localObject2 = this.Bwp;
        if (localObject2 == null) {
          break label408;
        }
      }
      for (Object localObject2 = Integer.valueOf(((ArrayList)localObject2).size());; localObject2 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject2).append(" realConfig ");
        com.tencent.mm.plugin.findersdk.d.a.b.a locala = this.Bwq;
        localObject2 = localObject3;
        if (locala != null) {
          localObject2 = locala.aSr();
        }
        Log.i(str, localObject2 + " ret:" + (String)((o)localObject1).My + "==>" + ((o)localObject1).Mx + ' ' + localc);
        localObject1 = ((o)localObject1).Mx;
        AppMethodBeat.o(207638);
        return localObject1;
        i = 0;
        break;
        label343:
        localObject1 = null;
        break label125;
        label349:
        localObject1 = this.Bwp;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.findersdk.d.a.b.a)j.M((List)localObject1, this.BwA);
          if (localObject1 != null)
          {
            localObject1 = new o(((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject1).aSr(), "userConfig");
            break label125;
          }
        }
        localObject1 = null;
        break label125;
      }
    }
  }
  
  public final b<T> b(String paramString, List<? extends T> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(207617);
    p.k(paramString, "keyName");
    p.k(paramList, "configDataList");
    p.k(paramList1, "configDataNameList");
    this.Bwo = paramString;
    paramString = com.tencent.mm.plugin.findersdk.d.a.b.b.BwD;
    bc(com.tencent.mm.plugin.findersdk.d.a.b.b.a.q(paramList, paramList1));
    this.BwA = enz();
    AppMethodBeat.o(207617);
    return this;
  }
  
  public final b<T> d(com.tencent.mm.plugin.expt.b.b.a parama)
  {
    AppMethodBeat.i(207613);
    p.k(parama, "expKey");
    this.Bwq = ((com.tencent.mm.plugin.findersdk.d.a.b.a)new f(this.Bwu, parama, (kotlin.g.a.a)new c(this)));
    AppMethodBeat.o(207613);
    return this;
  }
  
  public final List<String> enw()
  {
    AppMethodBeat.i(207624);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.Bwp;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((com.tencent.mm.plugin.findersdk.d.a.b.a)((Iterator)localObject2).next()).name);
      }
    }
    localObject2 = this.Bwq;
    if (localObject2 != null) {
      ((LinkedList)localObject1).add(((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject2).name + ':' + ((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject2).aSr());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(207624);
    return localObject1;
  }
  
  public final String enx()
  {
    AppMethodBeat.i(207625);
    Object localObject = this.Bwq;
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject).name + ':' + ((com.tencent.mm.plugin.findersdk.d.a.b.a)localObject).aSr();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "None";
    }
    AppMethodBeat.o(207625);
    return localObject;
  }
  
  public final String eny()
  {
    return this.Bwt;
  }
  
  public void reset()
  {
    AppMethodBeat.i(207634);
    Log.i(TAG, "code:" + hashCode() + "  keyName " + this.Bwo + " reset");
    this.BwA = -1;
    Sj(this.BwA);
    AppMethodBeat.o(207634);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig$Companion;", "", "()V", "FINDER_CONFIG_USER_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "finder-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "index", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final d Bwx;
    
    static
    {
      AppMethodBeat.i(208006);
      Bwx = new d();
      AppMethodBeat.o(208006);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */