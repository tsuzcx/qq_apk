package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "(Ljava/lang/String;J)V", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
class h
{
  public static final a sPG;
  final String name;
  final long qMk;
  
  static
  {
    AppMethodBeat.i(327098);
    sPG = new a((byte)0);
    AppMethodBeat.o(327098);
  }
  
  public h(u paramu)
  {
    this(str, paramu.lastModified());
    AppMethodBeat.i(327094);
    AppMethodBeat.o(327094);
  }
  
  public h(String paramString, long paramLong)
  {
    AppMethodBeat.i(327093);
    this.name = paramString;
    this.qMk = paramLong;
    AppMethodBeat.o(327093);
  }
  
  public JSONObject toJson()
  {
    AppMethodBeat.i(327103);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.name);
      localJSONObject.put("lastModified", this.qMk);
      AppMethodBeat.o(327103);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("FileMetaData#toJson, fail since ", localException));
        Object localObject = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonFile", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static h ax(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(327106);
      s.u(paramJSONObject, "json");
      if (paramJSONObject.has("subMetas"))
      {
        g.a locala = g.sPE;
        paramJSONObject = (h)g.a.aw(paramJSONObject);
        AppMethodBeat.o(327106);
        return paramJSONObject;
      }
      paramJSONObject = ay(paramJSONObject);
      AppMethodBeat.o(327106);
      return paramJSONObject;
    }
    
    private static h ay(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(327113);
      try
      {
        String str = paramJSONObject.getString("name");
        long l = paramJSONObject.getLong("lastModified");
        s.s(str, "name");
        paramJSONObject = new h(str, l);
        AppMethodBeat.o(327113);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("FileMetaData#fromJsonFile, fail since ", paramJSONObject));
          paramJSONObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.h
 * JD-Core Version:    0.7.0.1
 */