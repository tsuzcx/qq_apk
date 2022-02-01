package com.tencent.mm.plugin.finder.storage.config;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.item.a;
import com.tencent.mm.plugin.finder.storage.config.item.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import d.a.j;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "initChosenIndex", "", "initFakeConfigItemList", "", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "", "isSettingUIOpen", "itemNameList", "onItemClick", "index", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "Companion", "plugin-finder_release"})
public class b<T>
  extends d
{
  private static final String TAG = "Finder.FinderFakeConfig";
  private static final ax cBy;
  public static final a szy;
  private String szu;
  private ArrayList<a<T>> szv;
  private a<T> szw;
  private final T szx;
  
  static
  {
    AppMethodBeat.i(203765);
    szy = new a((byte)0);
    TAG = "Finder.FinderFakeConfig";
    cBy = ax.aQz("FINDER_CONFIG_USER_KEY");
    AppMethodBeat.o(203765);
  }
  
  public b(T paramT, String paramString)
  {
    super(paramString);
    AppMethodBeat.i(203764);
    this.szx = paramT;
    AppMethodBeat.o(203764);
  }
  
  private final void Fr(int paramInt)
  {
    AppMethodBeat.i(203761);
    String str = this.szu;
    if (str != null)
    {
      cBy.putInt(str, paramInt).commit();
      AppMethodBeat.o(203761);
      return;
    }
    AppMethodBeat.o(203761);
  }
  
  private final void ag(LinkedList<o<T, String>> paramLinkedList)
  {
    AppMethodBeat.i(203758);
    if (this.szv == null) {
      this.szv = new ArrayList();
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      o localo = (o)paramLinkedList.next();
      ArrayList localArrayList = this.szv;
      if (localArrayList != null) {
        localArrayList.add(new a(localo.first, (String)localo.second));
      }
    }
    AppMethodBeat.o(203758);
  }
  
  private final int cIY()
  {
    AppMethodBeat.i(203759);
    int i;
    if (this.szu != null)
    {
      localo = new o(Integer.valueOf(cBy.getInt(this.szu, -1)), "get from mmkv");
      int j = ((Number)localo.first).intValue();
      ArrayList localArrayList = this.szv;
      if (localArrayList != null)
      {
        i = localArrayList.size();
        if (j < i) {}
      }
    }
    for (o localo = new o(Integer.valueOf(-1), "reset_default");; localo = new o(Integer.valueOf(-1), "default"))
    {
      ad.i(TAG, "code:" + hashCode() + "  keyName " + this.szu + " initChosenIndex " + ((Number)localo.first).intValue() + " reason " + (String)localo.second + " defValue:" + this.szx);
      i = ((Number)localo.first).intValue();
      AppMethodBeat.o(203759);
      return i;
      i = 0;
      break;
    }
  }
  
  private static boolean cIZ()
  {
    return i.DEBUG;
  }
  
  public void Fq(int paramInt)
  {
    AppMethodBeat.i(203760);
    ArrayList localArrayList = this.szv;
    if (localArrayList != null)
    {
      i = localArrayList.size();
      if (paramInt <= i) {
        break label124;
      }
    }
    label124:
    for (int i = -1;; i = paramInt)
    {
      this.szz = i;
      Fr(paramInt);
      if (cIZ()) {
        ad.i(TAG, "code:" + hashCode() + "  keyName " + this.szu + " onItemClick click: " + paramInt + " chosenIndex: " + this.szz + " defValue:" + this.szx);
      }
      AppMethodBeat.o(203760);
      return;
      i = 0;
      break;
    }
  }
  
  public final b<T> aiA(String paramString)
  {
    AppMethodBeat.i(203754);
    p.h(paramString, "dyConfigKey");
    this.szw = ((a)new c(this.szx, paramString));
    AppMethodBeat.o(203754);
    return this;
  }
  
  public final b<T> b(String paramString, List<? extends T> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(203755);
    p.h(paramString, "keyName");
    p.h(paramList, "configDataList");
    p.h(paramList1, "configDataNameList");
    this.szu = paramString;
    paramString = com.tencent.mm.plugin.finder.storage.config.item.b.szA;
    ag(com.tencent.mm.plugin.finder.storage.config.item.b.a.l(paramList, paramList1));
    this.szz = cIY();
    AppMethodBeat.o(203755);
    return this;
  }
  
  public final b<T> c(com.tencent.mm.plugin.expt.b.b.a parama)
  {
    AppMethodBeat.i(203753);
    p.h(parama, "expKey");
    this.szw = ((a)new com.tencent.mm.plugin.finder.storage.config.item.d(this.szx, parama));
    AppMethodBeat.o(203753);
    return this;
  }
  
  public final List<String> cIW()
  {
    AppMethodBeat.i(203756);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.szv;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((a)((Iterator)localObject2).next()).name);
      }
    }
    localObject2 = this.szw;
    if (localObject2 != null) {
      ((LinkedList)localObject1).add(((a)localObject2).name + ':' + ((a)localObject2).value());
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(203756);
    return localObject1;
  }
  
  public final String cIX()
  {
    AppMethodBeat.i(203757);
    Object localObject = this.szw;
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
    AppMethodBeat.o(203757);
    return localObject;
  }
  
  public void reset()
  {
    AppMethodBeat.i(203762);
    ad.i(TAG, "code:" + hashCode() + "  keyName " + this.szu + " reset");
    this.szz = -1;
    Fr(this.szz);
    AppMethodBeat.o(203762);
  }
  
  public T value()
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(203763);
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("getValue");
    int i;
    Object localObject1;
    if ((i.DEBUG) || (com.tencent.mm.sdk.a.b.fjN()) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE))
    {
      i = 1;
      if ((i != 0) && (this.szz != -1))
      {
        int k = this.szz;
        localObject1 = this.szv;
        i = j;
        if (localObject1 != null) {
          i = ((ArrayList)localObject1).size();
        }
        if ((k < i) && (this.szz >= 0)) {
          break label347;
        }
      }
      localObject1 = this.szw;
      if (localObject1 == null) {
        break label341;
      }
      localObject1 = new o(((a)localObject1).value(), "svrConfig");
      label125:
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = new o(this.szx, "defaultValue");
    }
    label406:
    label412:
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (cIZ())
      {
        str = TAG;
        localStringBuilder = new StringBuilder("code:").append(hashCode()).append("  keyName ").append(this.szu).append(" config getValue chosenIndex ").append(this.szz).append(" size:");
        localObject2 = this.szv;
        if (localObject2 == null) {
          break label406;
        }
      }
      for (Object localObject2 = Integer.valueOf(((ArrayList)localObject2).size());; localObject2 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject2).append(" realConfig ");
        a locala = this.szw;
        localObject2 = localObject3;
        if (locala != null) {
          localObject2 = locala.value();
        }
        ad.i(str, localObject2 + " ret:" + (String)((o)localObject1).second + "==>" + ((o)localObject1).first + ' ' + localb);
        localObject1 = ((o)localObject1).first;
        AppMethodBeat.o(203763);
        return localObject1;
        i = 0;
        break;
        label341:
        localObject1 = null;
        break label125;
        label347:
        localObject1 = this.szv;
        if (localObject1 != null)
        {
          localObject1 = (a)j.E((List)localObject1, this.szz);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig$Companion;", "", "()V", "FINDER_CONFIG_USER_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.b
 * JD-Core Version:    0.7.0.1
 */