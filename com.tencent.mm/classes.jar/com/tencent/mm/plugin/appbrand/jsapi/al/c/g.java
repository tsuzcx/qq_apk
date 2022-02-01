package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "subMetas", "", "(Ljava/lang/String;JLjava/util/List;)V", "getSubMetas", "()Ljava/util/List;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  extends h
{
  public static final a sPE;
  final List<h> sPF;
  
  static
  {
    AppMethodBeat.i(327102);
    sPE = new a((byte)0);
    AppMethodBeat.o(327102);
  }
  
  public g(u paramu)
  {
    this(str, l, (List)localCollection);
    AppMethodBeat.o(327096);
  }
  
  private g(String paramString, long paramLong, List<? extends h> paramList)
  {
    super(paramString, paramLong);
    this.sPF = paramList;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(327111);
    try
    {
      localJSONObject = super.toJson();
      if (localJSONObject != null) {
        break label23;
      }
      localJSONObject = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        JSONArray localJSONArray;
        Iterator localIterator;
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("DirMetaData#toJson, fail since ", localException));
        Object localObject = null;
        continue;
        localObject.put("subMetas", localJSONArray);
      }
    }
    AppMethodBeat.o(327111);
    return localJSONObject;
    label23:
    localJSONArray = new JSONArray();
    localIterator = ((Iterable)this.sPF).iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((h)localIterator.next()).toJson());
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static g F(u paramu)
    {
      AppMethodBeat.i(327107);
      s.u(paramu, "unzipDir");
      if (paramu.isDirectory())
      {
        paramu = new g(paramu);
        AppMethodBeat.o(327107);
        return paramu;
      }
      AppMethodBeat.o(327107);
      return null;
    }
    
    public static g aw(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(327117);
      s.u(paramJSONObject, "json");
      Object localObject1;
      Object localObject3;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.getJSONArray("subMetas");
        localObject3 = (Iterable)k.qt(0, ((JSONArray)localObject1).length());
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((Collection)localObject2).add(((JSONArray)localObject1).getJSONObject(((ah)localObject3).Zo()));
          continue;
          AppMethodBeat.o(327117);
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("DirMetaData#fromJsonFile, fail since ", paramJSONObject));
        paramJSONObject = null;
      }
      for (;;)
      {
        return paramJSONObject;
        localObject2 = (Iterable)localObject2;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (JSONObject)((Iterator)localObject2).next();
          h.a locala = h.sPG;
          s.s(localObject3, "it");
          localObject3 = h.a.ax((JSONObject)localObject3);
          s.checkNotNull(localObject3);
          ((Collection)localObject1).add(localObject3);
        }
        localObject1 = (List)localObject1;
        localObject2 = paramJSONObject.getString("name");
        long l = paramJSONObject.getLong("lastModified");
        s.s(localObject2, "name");
        paramJSONObject = new g((String)localObject2, l, (List)localObject1, (byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.g
 * JD-Core Version:    0.7.0.1
 */