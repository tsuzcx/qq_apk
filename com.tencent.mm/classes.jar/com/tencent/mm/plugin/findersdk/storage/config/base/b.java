package com.tencent.mm.plugin.findersdk.storage.config.base;

import android.content.SharedPreferences.Editor;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.storage.config.a.e;
import com.tencent.mm.plugin.findersdk.storage.config.a.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "booleanWrapper", "Lkotlin/Function1;", "", "chosenData", "Landroidx/lifecycle/MutableLiveData;", "clickListener", "", "Lkotlin/ParameterName;", "name", "index", "", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "versionTag", "applyChosenDebugConfigFromAssist", "providerKeyName", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "bindOnClick", "booleanValue", "initChosenIndex", "initFakeConfigItemList", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "isSettingUIOpen", "itemNameList", "map", "wrapper", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "onItemClick", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "tag", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T>
  extends d
{
  public static final b.a HdA;
  private static final String TAG;
  private static final MultiProcessMMKV eMf;
  private kotlin.g.a.b<? super Integer, ah> Epm;
  private final T HdB;
  private String HdC;
  private ArrayList<com.tencent.mm.plugin.findersdk.storage.config.a.a<T>> HdD;
  private com.tencent.mm.plugin.findersdk.storage.config.a.a<T> HdE;
  private final x<T> HdF;
  private String HdG;
  
  static
  {
    AppMethodBeat.i(273855);
    HdA = new b.a((byte)0);
    TAG = "Finder.FinderFakeConfig";
    eMf = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY");
    AppMethodBeat.o(273855);
  }
  
  public b(T paramT, String paramString)
  {
    super(paramString);
    AppMethodBeat.i(273812);
    this.HdB = paramT;
    this.Epm = ((kotlin.g.a.b)b.d.HdI);
    this.HdF = new x();
    this.HdG = "";
    AppMethodBeat.o(273812);
  }
  
  private final void VC(int paramInt)
  {
    AppMethodBeat.i(273841);
    String str = this.HdC;
    if (str != null) {
      eMf.putInt(str, paramInt).commit();
    }
    AppMethodBeat.o(273841);
  }
  
  private static boolean anH()
  {
    return BuildInfo.DEBUG;
  }
  
  private final void bk(LinkedList<r<T, String>> paramLinkedList)
  {
    AppMethodBeat.i(273822);
    if (this.HdD == null) {
      this.HdD = new ArrayList();
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      r localr = (r)paramLinkedList.next();
      ArrayList localArrayList = this.HdD;
      if (localArrayList != null) {
        localArrayList.add(new com.tencent.mm.plugin.findersdk.storage.config.a.a(localr.bsC, (String)localr.bsD));
      }
    }
    AppMethodBeat.o(273822);
  }
  
  private final int fsl()
  {
    AppMethodBeat.i(273831);
    r localr;
    if (this.HdC == null)
    {
      localr = null;
      if (localr != null) {
        break label220;
      }
      localr = new r(Integer.valueOf(-1), "default");
    }
    label217:
    label220:
    for (;;)
    {
      Log.i(TAG, "code:" + hashCode() + "  keyName " + this.HdC + " initChosenIndex " + ((Number)localr.bsC).intValue() + " reason " + (String)localr.bsD + " defValue:" + this.HdB);
      int i = ((Number)localr.bsC).intValue();
      AppMethodBeat.o(273831);
      return i;
      localr = new r(Integer.valueOf(eMf.getInt(this.HdC, -1)), "get from mmkv");
      int j = ((Number)localr.bsC).intValue();
      ArrayList localArrayList = this.HdD;
      if (localArrayList == null) {}
      for (i = 0;; i = localArrayList.size())
      {
        if (j < i) {
          break label217;
        }
        localr = new r(Integer.valueOf(-1), "reset_default");
        break;
      }
      break;
    }
  }
  
  public void VB(int paramInt)
  {
    AppMethodBeat.i(273931);
    Object localObject = this.HdD;
    if (localObject == null)
    {
      i = 0;
      if (paramInt <= i) {
        break label182;
      }
    }
    label182:
    for (int i = -1;; i = paramInt)
    {
      this.HdL = i;
      localObject = this.HdD;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.findersdk.storage.config.a.a)p.ae((List)localObject, this.HdL);
        if (localObject != null) {
          this.HdF.setValue(((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject).bmg());
        }
      }
      VC(paramInt);
      if (anH()) {
        Log.i(TAG, "code:" + hashCode() + "  keyName " + this.HdC + " onItemClick click: " + paramInt + " chosenIndex: " + this.HdL + " defValue:" + this.HdB);
      }
      this.Epm.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(273931);
      return;
      i = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public final b<T> aDk(String paramString)
  {
    AppMethodBeat.i(273871);
    s.u(paramString, "dyConfigKey");
    this.HdE = ((com.tencent.mm.plugin.findersdk.storage.config.a.a)new e(this.HdB, paramString, (kotlin.g.a.a)new b(this)));
    AppMethodBeat.o(273871);
    return this;
  }
  
  public final b<T> aDl(String paramString)
  {
    AppMethodBeat.i(273887);
    s.u(paramString, "providerKeyName");
    if (this.HdD != null)
    {
      localObject = this.HdD;
      s.checkNotNull(localObject);
      if (!((ArrayList)localObject).isEmpty()) {}
    }
    else
    {
      Log.e(TAG, "applyChosenDebugConfigFromAssist: please call bindDebugConfig first.");
      AppMethodBeat.o(273887);
      return this;
    }
    Object localObject = com.tencent.mm.booter.d.cO(MMApplicationContext.getContext());
    if (localObject == null)
    {
      Log.e(TAG, "Fail to get debugger, skip apply chosen item from assist key %s", new Object[] { paramString });
      AppMethodBeat.o(273887);
      return this;
    }
    localObject = ((com.tencent.mm.booter.d)localObject).Cj(paramString);
    if ((localObject == null) || (((Integer)localObject).intValue() < 0))
    {
      Log.w(TAG, "Assist does not specify value with key %s", new Object[] { paramString });
      AppMethodBeat.o(273887);
      return this;
    }
    int i = ((Integer)localObject).intValue();
    ArrayList localArrayList = this.HdD;
    s.checkNotNull(localArrayList);
    if (i >= localArrayList.size())
    {
      Log.e(TAG, "Bad value %s from assist specified with key %s", new Object[] { localObject, paramString });
      AppMethodBeat.o(273887);
      return this;
    }
    this.HdL = ((Integer)localObject).intValue();
    Log.i(TAG, "Chosen item of debug config %s was override by assist with key %s", new Object[] { this.HdC, paramString });
    AppMethodBeat.o(273887);
    return this;
  }
  
  public final b<T> aDm(String paramString)
  {
    AppMethodBeat.i(273900);
    s.u(paramString, "tag");
    this.HdG = paramString;
    AppMethodBeat.o(273900);
    return this;
  }
  
  public final b<T> ax(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(273893);
    s.u(paramb, "clickListener");
    this.Epm = paramb;
    AppMethodBeat.o(273893);
    return this;
  }
  
  public T bmg()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(273947);
    c localc = new c("getValue");
    int i;
    Object localObject1;
    label79:
    label105:
    label126:
    String str;
    StringBuilder localStringBuilder;
    if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      i = 1;
      if ((i != 0) && (this.HdL != -1))
      {
        int k = this.HdL;
        localObject1 = this.HdD;
        if (localObject1 != null) {
          break label308;
        }
        i = j;
        if ((k < i) && (this.HdL >= 0)) {
          break label337;
        }
      }
      localObject1 = this.HdE;
      if (localObject1 != null) {
        break label317;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label402;
      }
      localObject1 = new r(this.HdB, "defaultValue");
      if (anH())
      {
        str = TAG;
        localStringBuilder = new StringBuilder("code:").append(hashCode()).append("  keyName ").append(this.HdC).append(" config getValue chosenIndex ").append(this.HdL).append(" size:");
        localObject2 = this.HdD;
        if (localObject2 != null) {
          break label405;
        }
        localObject2 = null;
        label201:
        localStringBuilder = localStringBuilder.append(localObject2).append(" realConfig ");
        localObject2 = this.HdE;
        if (localObject2 != null) {
          break label418;
        }
      }
    }
    label402:
    label405:
    label418:
    for (Object localObject2 = localObject3;; localObject2 = ((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject2).bmg())
    {
      Log.i(str, localObject2 + " ret:" + (String)((r)localObject1).bsD + "==>" + ((r)localObject1).bsC + ' ' + localc);
      localObject1 = ((r)localObject1).bsC;
      AppMethodBeat.o(273947);
      return localObject1;
      i = 0;
      break;
      label308:
      i = ((ArrayList)localObject1).size();
      break label79;
      label317:
      localObject1 = new r(((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject1).bmg(), "svrConfig");
      break label105;
      label337:
      localObject1 = this.HdD;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label105;
      }
      localObject1 = (com.tencent.mm.plugin.findersdk.storage.config.a.a)p.ae((List)localObject1, this.HdL);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label105;
      }
      localObject1 = new r(((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject1).bmg(), "userConfig");
      break label105;
      break label126;
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      break label201;
    }
  }
  
  public final b<T> c(String paramString, List<? extends T> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(273878);
    s.u(paramString, "keyName");
    s.u(paramList, "configDataList");
    s.u(paramList1, "configDataNameList");
    this.HdC = paramString;
    paramString = com.tencent.mm.plugin.findersdk.storage.config.a.b.HdO;
    bk(com.tencent.mm.plugin.findersdk.storage.config.a.b.a.B(paramList, paramList1));
    this.HdL = fsl();
    AppMethodBeat.o(273878);
    return this;
  }
  
  public final b<T> d(c.a parama)
  {
    AppMethodBeat.i(273863);
    s.u(parama, "expKey");
    this.HdE = ((com.tencent.mm.plugin.findersdk.storage.config.a.a)new f(this.HdB, parama, (kotlin.g.a.a)new c(this)));
    AppMethodBeat.o(273863);
    return this;
  }
  
  public final List<String> fsi()
  {
    AppMethodBeat.i(273912);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.HdD;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((com.tencent.mm.plugin.findersdk.storage.config.a.a)((Iterator)localObject2).next()).name);
      }
    }
    localObject2 = this.HdE;
    if (localObject2 != null) {
      ((LinkedList)localObject1).add(((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject2).name + ':' + ((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject2).bmg());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(273912);
    return localObject1;
  }
  
  public final String fsj()
  {
    AppMethodBeat.i(273920);
    Object localObject = this.HdE;
    if (localObject == null)
    {
      AppMethodBeat.o(273920);
      return "None";
    }
    localObject = ((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject).name + ':' + ((com.tencent.mm.plugin.findersdk.storage.config.a.a)localObject).bmg();
    if (localObject == null)
    {
      AppMethodBeat.o(273920);
      return "None";
    }
    AppMethodBeat.o(273920);
    return localObject;
  }
  
  public final String fsk()
  {
    return this.HdG;
  }
  
  public void reset()
  {
    AppMethodBeat.i(273938);
    Log.i(TAG, "code:" + hashCode() + "  keyName " + this.HdC + " reset");
    this.HdL = -1;
    VC(this.HdL);
    AppMethodBeat.o(273938);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b<T> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b<T> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.base.b
 * JD-Core Version:    0.7.0.1
 */