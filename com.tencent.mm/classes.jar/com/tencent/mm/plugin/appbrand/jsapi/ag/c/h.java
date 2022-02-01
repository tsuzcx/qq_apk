package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "(Ljava/lang/String;J)V", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"})
class h
{
  public static final a mJV;
  final long kSb;
  final String name;
  
  static
  {
    AppMethodBeat.i(216007);
    mJV = new a((byte)0);
    AppMethodBeat.o(216007);
  }
  
  public h(o paramo)
  {
    this(str, paramo.lastModified());
    AppMethodBeat.i(216006);
    AppMethodBeat.o(216006);
  }
  
  public h(String paramString, long paramLong)
  {
    AppMethodBeat.i(216005);
    this.name = paramString;
    this.kSb = paramLong;
    AppMethodBeat.o(216005);
  }
  
  public JSONObject toJson()
  {
    AppMethodBeat.i(216004);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.name);
      localJSONObject.put("lastModified", this.kSb);
      AppMethodBeat.o(216004);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#toJson, fail since ".concat(String.valueOf(localException)));
        Object localObject = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonFile", "luggage-xweb-ext_release"})
  public static final class a
  {
    public static h aj(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(216002);
      p.h(paramJSONObject, "json");
      if (paramJSONObject.has("subMetas"))
      {
        g.a locala = g.mJU;
        paramJSONObject = (h)g.a.ai(paramJSONObject);
        AppMethodBeat.o(216002);
        return paramJSONObject;
      }
      paramJSONObject = ak(paramJSONObject);
      AppMethodBeat.o(216002);
      return paramJSONObject;
    }
    
    private static h ak(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(216003);
      try
      {
        String str = paramJSONObject.getString("name");
        long l = paramJSONObject.getLong("lastModified");
        p.g(str, "name");
        paramJSONObject = new h(str, l);
        AppMethodBeat.o(216003);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#fromJsonFile, fail since ".concat(String.valueOf(paramJSONObject)));
          paramJSONObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.h
 * JD-Core Version:    0.7.0.1
 */