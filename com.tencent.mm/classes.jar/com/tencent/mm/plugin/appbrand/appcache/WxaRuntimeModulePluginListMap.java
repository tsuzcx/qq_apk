package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "Landroid/os/Parcelable;", "p", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isEmpty", "", "()Z", "mPrimaryMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "mSecondaryMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "Ljava/util/LinkedList;", "size", "", "getSize", "()I", "describeContents", "getPluginInfoForId", "pluginId", "", "getPluginList", "moduleName", "listAllPlugins", "mergeUpdatedPlugin", "", "updated", "putPluginList", "list", "setupMapping", "writeToParcel", "dest", "flags", "addPluginInfoInstance", "plugin", "createModuleMappedPluginList", "writeModuleMappedPluginList", "Companion", "Namespace", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaRuntimeModulePluginListMap
  implements Parcelable
{
  public static final Parcelable.Creator<WxaRuntimeModulePluginListMap> CREATOR;
  public static final WxaRuntimeModulePluginListMap.a qIb;
  public final ArrayMap<WxaRuntimeModulePluginListMap.c.a, List<WxaPluginPkgInfo>> qIc;
  public ArrayMap<WxaRuntimeModulePluginListMap.c.b, LinkedList<WxaPluginPkgInfo>> qId;
  
  static
  {
    AppMethodBeat.i(178662);
    qIb = new WxaRuntimeModulePluginListMap.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(178662);
  }
  
  public WxaRuntimeModulePluginListMap()
  {
    AppMethodBeat.i(178661);
    this.qIc = new ArrayMap();
    AppMethodBeat.o(178661);
  }
  
  public WxaRuntimeModulePluginListMap(Parcel paramParcel)
  {
    AppMethodBeat.i(178660);
    int j = paramParcel.readInt();
    this.qIc = new ArrayMap(j);
    this.qId = new ArrayMap();
    int i = 0;
    if (j > 0) {}
    for (;;)
    {
      i += 1;
      String str = paramParcel.readString();
      s.checkNotNull(str);
      s.s(str, "p.readString()!!");
      List localList = i(paramParcel);
      ((Map)this.qIc).put(new WxaRuntimeModulePluginListMap.c.a(str), localList);
      if (i >= j)
      {
        AppMethodBeat.o(178660);
        return;
      }
    }
  }
  
  private static void a(ArrayMap<WxaRuntimeModulePluginListMap.c.b, LinkedList<WxaPluginPkgInfo>> paramArrayMap, WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178659);
    Object localObject = paramWxaPluginPkgInfo.provider;
    s.s(localObject, "plugin.provider");
    WxaRuntimeModulePluginListMap.c.b localb = new WxaRuntimeModulePluginListMap.c.b((String)localObject);
    LinkedList localLinkedList = (LinkedList)paramArrayMap.get(localb);
    localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      ((Map)paramArrayMap).put(localb, localObject);
    }
    ((LinkedList)localObject).add(paramWxaPluginPkgInfo);
    AppMethodBeat.o(178659);
  }
  
  private final List<WxaPluginPkgInfo> i(Parcel paramParcel)
  {
    AppMethodBeat.i(178658);
    LinkedList localLinkedList = new LinkedList();
    int j = paramParcel.readInt();
    int i = 0;
    if (j > 0) {}
    for (;;)
    {
      i += 1;
      WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)WxaPluginPkgInfo.CREATOR.createFromParcel(paramParcel);
      ArrayMap localArrayMap2 = this.qId;
      ArrayMap localArrayMap1 = localArrayMap2;
      if (localArrayMap2 == null)
      {
        s.bIx("mSecondaryMap");
        localArrayMap1 = null;
      }
      s.s(localWxaPluginPkgInfo, "p");
      a(localArrayMap1, localWxaPluginPkgInfo);
      localLinkedList.add(localWxaPluginPkgInfo);
      if (i >= j)
      {
        paramParcel = (List)localLinkedList;
        AppMethodBeat.o(178658);
        return paramParcel;
      }
    }
  }
  
  public final List<WxaPluginPkgInfo> VE(String paramString)
  {
    AppMethodBeat.i(178653);
    s.u(paramString, "moduleName");
    paramString = (List)this.qIc.get(new WxaRuntimeModulePluginListMap.c.a(paramString));
    AppMethodBeat.o(178653);
    return paramString;
  }
  
  public final void a(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    AppMethodBeat.i(178655);
    s.u(paramWxaPluginPkgInfo, "updated");
    Object localObject2 = this.qId;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mSecondaryMap");
      localObject1 = null;
    }
    localObject2 = paramWxaPluginPkgInfo.provider;
    s.s(localObject2, "updated.provider");
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
    }
    AppMethodBeat.o(178655);
  }
  
  public final void che()
  {
    AppMethodBeat.i(178656);
    if (this.qId == null)
    {
      this.qId = new ArrayMap();
      Object localObject = this.qIc.values();
      s.s(localObject, "mPrimaryMap.values");
      Iterator localIterator1 = ((Iterable)localObject).iterator();
      while (localIterator1.hasNext())
      {
        localObject = (List)localIterator1.next();
        s.s(localObject, "list");
        Iterator localIterator2 = ((Iterable)localObject).iterator();
        while (localIterator2.hasNext())
        {
          WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)localIterator2.next();
          ArrayMap localArrayMap = this.qId;
          localObject = localArrayMap;
          if (localArrayMap == null)
          {
            s.bIx("mSecondaryMap");
            localObject = null;
          }
          a((ArrayMap)localObject, localWxaPluginPkgInfo);
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
    if (this.qIc.size() <= 0)
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
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.qIc.size());
    Iterator localIterator = ((Map)this.qIc).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (WxaRuntimeModulePluginListMap.c.a)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      paramParcel.writeString(((WxaRuntimeModulePluginListMap.c.a)localObject1).name);
      s.s(localObject2, "value");
      paramParcel.writeInt(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((WxaPluginPkgInfo)((Iterator)localObject1).next()).writeToParcel(paramParcel, 0);
      }
    }
    AppMethodBeat.o(178657);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WxaRuntimeModulePluginListMap>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap
 * JD-Core Version:    0.7.0.1
 */