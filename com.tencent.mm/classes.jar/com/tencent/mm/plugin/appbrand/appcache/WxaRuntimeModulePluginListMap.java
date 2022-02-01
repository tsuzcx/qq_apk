package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "Landroid/os/Parcelable;", "p", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isEmpty", "", "()Z", "mPrimaryMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "mSecondaryMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "Ljava/util/LinkedList;", "size", "", "getSize", "()I", "describeContents", "getPluginList", "moduleName", "", "mergeUpdatedPlugin", "", "updated", "putPluginList", "list", "setupMapping", "writeToParcel", "dest", "flags", "addPluginInfoInstance", "plugin", "createModuleMappedPluginList", "writeModuleMappedPluginList", "Companion", "Namespace", "luggage-wxa-app_release"})
public final class WxaRuntimeModulePluginListMap
  implements Parcelable
{
  public static final Parcelable.Creator<WxaRuntimeModulePluginListMap> CREATOR;
  public static final a jJh;
  public final ArrayMap<c.a, List<WxaPluginPkgInfo>> jJf;
  private ArrayMap<WxaRuntimeModulePluginListMap.c.b, LinkedList<WxaPluginPkgInfo>> jJg;
  
  static
  {
    AppMethodBeat.i(178662);
    jJh = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(178662);
  }
  
  public WxaRuntimeModulePluginListMap()
  {
    AppMethodBeat.i(178661);
    this.jJf = new ArrayMap();
    AppMethodBeat.o(178661);
  }
  
  public WxaRuntimeModulePluginListMap(Parcel paramParcel)
  {
    AppMethodBeat.i(178660);
    int j = paramParcel.readInt();
    this.jJf = new ArrayMap(j);
    this.jJg = new ArrayMap();
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      if (str == null) {
        p.gfZ();
      }
      List localList = f(paramParcel);
      ((Map)this.jJf).put(new c.a(str), localList);
      i += 1;
    }
    AppMethodBeat.o(178660);
  }
  
  private static void a(ArrayMap<WxaRuntimeModulePluginListMap.c.b, LinkedList<WxaPluginPkgInfo>> paramArrayMap, WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178659);
    Object localObject = paramWxaPluginPkgInfo.provider;
    p.g(localObject, "plugin.provider");
    WxaRuntimeModulePluginListMap.c.b localb = new WxaRuntimeModulePluginListMap.c.b((String)localObject);
    LinkedList localLinkedList = (LinkedList)paramArrayMap.get(localb);
    localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      ((Map)paramArrayMap).put(localb, localObject);
    }
    p.g(localObject, "this[namespace] ?: Linke… { this[namespace] = it }");
    ((LinkedList)localObject).add(paramWxaPluginPkgInfo);
    AppMethodBeat.o(178659);
  }
  
  private final List<WxaPluginPkgInfo> f(Parcel paramParcel)
  {
    AppMethodBeat.i(178658);
    LinkedList localLinkedList = new LinkedList();
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)WxaPluginPkgInfo.CREATOR.createFromParcel(paramParcel);
      ArrayMap localArrayMap = this.jJg;
      if (localArrayMap == null) {
        p.bcb("mSecondaryMap");
      }
      p.g(localWxaPluginPkgInfo, "p");
      a(localArrayMap, localWxaPluginPkgInfo);
      localLinkedList.add(localWxaPluginPkgInfo);
      i += 1;
    }
    paramParcel = (List)localLinkedList;
    AppMethodBeat.o(178658);
    return paramParcel;
  }
  
  public final List<WxaPluginPkgInfo> LN(String paramString)
  {
    AppMethodBeat.i(178653);
    p.h(paramString, "moduleName");
    paramString = (List)this.jJf.get(new c.a(paramString));
    AppMethodBeat.o(178653);
    return paramString;
  }
  
  public final void a(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178655);
    p.h(paramWxaPluginPkgInfo, "updated");
    Object localObject1 = this.jJg;
    if (localObject1 == null) {
      p.bcb("mSecondaryMap");
    }
    Object localObject2 = paramWxaPluginPkgInfo.provider;
    p.g(localObject2, "updated.provider");
    localObject1 = (LinkedList)((ArrayMap)localObject1).get(new WxaRuntimeModulePluginListMap.c.b((String)localObject2));
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
        if (paramWxaPluginPkgInfo.isAssignable((WxaPluginPkgInfo)localObject2))
        {
          ((WxaPluginPkgInfo)localObject2).pkgPath = paramWxaPluginPkgInfo.pkgPath;
          ((WxaPluginPkgInfo)localObject2).md5 = paramWxaPluginPkgInfo.md5;
          ((WxaPluginPkgInfo)localObject2).stringVersion = paramWxaPluginPkgInfo.stringVersion;
        }
      }
      AppMethodBeat.o(178655);
      return;
    }
    AppMethodBeat.o(178655);
  }
  
  public final void baP()
  {
    AppMethodBeat.i(178656);
    if (((WxaRuntimeModulePluginListMap)this).jJg == null)
    {
      this.jJg = new ArrayMap();
      Object localObject1 = this.jJf.values();
      p.g(localObject1, "mPrimaryMap.values");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (List)((Iterator)localObject1).next();
        p.g(localObject2, "list");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)((Iterator)localObject2).next();
          ArrayMap localArrayMap = this.jJg;
          if (localArrayMap == null) {
            p.bcb("mSecondaryMap");
          }
          a(localArrayMap, localWxaPluginPkgInfo);
        }
      }
    }
    AppMethodBeat.o(178656);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(178654);
    if (this.jJf.size() <= 0)
    {
      AppMethodBeat.o(178654);
      return true;
    }
    AppMethodBeat.o(178654);
    return false;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(178657);
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.jJf.size());
    Iterator localIterator = ((Map)this.jJf).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (c.a)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      paramParcel.writeString(((c.a)localObject1).name);
      p.g(localObject2, "value");
      paramParcel.writeInt(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((WxaPluginPkgInfo)((Iterator)localObject1).next()).writeToParcel(paramParcel, 0);
      }
    }
    AppMethodBeat.o(178657);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "luggage-wxa-app_release"})
  public static final class b
    implements Parcelable.Creator<WxaRuntimeModulePluginListMap>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "luggage-wxa-app_release"})
  public static final class c$a
  {
    final String name;
    
    public c$a(String paramString)
    {
      AppMethodBeat.i(178648);
      paramString = WxaPkgWrappingInfo.LK(paramString);
      if (paramString == null) {
        p.gfZ();
      }
      this.name = paramString;
      AppMethodBeat.o(178648);
    }
    
    public final boolean equals(Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(178647);
      if (!(paramObject instanceof a)) {
        paramObject = null;
      }
      for (;;)
      {
        a locala = (a)paramObject;
        paramObject = localObject;
        if (locala != null) {
          paramObject = locala.name;
        }
        boolean bool = p.i(paramObject, this.name);
        AppMethodBeat.o(178647);
        return bool;
      }
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(178646);
      int i = this.name.hashCode();
      AppMethodBeat.o(178646);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap
 * JD-Core Version:    0.7.0.1
 */