package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "subMetas", "", "(Ljava/lang/String;JLjava/util/List;)V", "getSubMetas", "()Ljava/util/List;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"})
final class g
  extends h
{
  public static final a pKM;
  final List<h> pKL;
  
  static
  {
    AppMethodBeat.i(221438);
    pKM = new a((byte)0);
    AppMethodBeat.o(221438);
  }
  
  public g(q paramq)
  {
    this(str, l, (List)localCollection);
    AppMethodBeat.o(221435);
  }
  
  private g(String paramString, long paramLong, List<? extends h> paramList)
  {
    super(paramString, paramLong);
    this.pKL = paramList;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(221428);
    JSONArray localJSONArray;
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = super.toJson();
      if (localJSONObject1 != null)
      {
        localJSONArray = new JSONArray();
        Iterator localIterator = ((Iterable)this.pKL).iterator();
        while (localIterator.hasNext())
        {
          localJSONArray.put(((h)localIterator.next()).toJson());
          continue;
          AppMethodBeat.o(221428);
        }
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#toJson, fail since ".concat(String.valueOf(localException)));
      localJSONObject2 = null;
    }
    for (;;)
    {
      return localJSONObject2;
      localJSONObject2.put("subMetas", localJSONArray);
      continue;
      localJSONObject2 = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "luggage-xweb-ext_release"})
  public static final class a
  {
    public static g F(q paramq)
    {
      AppMethodBeat.i(227232);
      p.k(paramq, "unzipDir");
      if (paramq.isDirectory())
      {
        paramq = new g(paramq);
        AppMethodBeat.o(227232);
        return paramq;
      }
      AppMethodBeat.o(227232);
      return null;
    }
    
    public static g am(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(227245);
      p.k(paramJSONObject, "json");
      Object localObject1;
      Object localObject3;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.getJSONArray("subMetas");
        localObject3 = (Iterable)i.ou(0, ((JSONArray)localObject1).length());
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((Collection)localObject2).add(((JSONArray)localObject1).getJSONObject(((ab)localObject3).zD()));
          continue;
          AppMethodBeat.o(227245);
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#fromJsonFile, fail since ".concat(String.valueOf(paramJSONObject)));
        paramJSONObject = null;
      }
      for (;;)
      {
        return paramJSONObject;
        localObject2 = (Iterable)localObject2;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (JSONObject)((Iterator)localObject2).next();
          h.a locala = h.pKN;
          p.j(localObject3, "it");
          localObject3 = h.a.an((JSONObject)localObject3);
          if (localObject3 == null) {
            p.iCn();
          }
          ((Collection)localObject1).add(localObject3);
        }
        localObject1 = (List)localObject1;
        localObject2 = paramJSONObject.getString("name");
        long l = paramJSONObject.getLong("lastModified");
        p.j(localObject2, "name");
        paramJSONObject = new g((String)localObject2, l, (List)localObject1, (byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.g
 * JD-Core Version:    0.7.0.1
 */