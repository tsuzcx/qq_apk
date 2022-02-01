package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "(Ljava/lang/String;J)V", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"})
class h
{
  public static final a pKN;
  final long nMj;
  final String name;
  
  static
  {
    AppMethodBeat.i(224138);
    pKN = new a((byte)0);
    AppMethodBeat.o(224138);
  }
  
  public h(q paramq)
  {
    this(str, paramq.lastModified());
    AppMethodBeat.i(224135);
    AppMethodBeat.o(224135);
  }
  
  public h(String paramString, long paramLong)
  {
    AppMethodBeat.i(224134);
    this.name = paramString;
    this.nMj = paramLong;
    AppMethodBeat.o(224134);
  }
  
  public JSONObject toJson()
  {
    AppMethodBeat.i(224133);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.name);
      localJSONObject.put("lastModified", this.nMj);
      AppMethodBeat.o(224133);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonFile", "luggage-xweb-ext_release"})
  public static final class a
  {
    public static h an(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(226790);
      p.k(paramJSONObject, "json");
      if (paramJSONObject.has("subMetas"))
      {
        g.a locala = g.pKM;
        paramJSONObject = (h)g.a.am(paramJSONObject);
        AppMethodBeat.o(226790);
        return paramJSONObject;
      }
      paramJSONObject = ao(paramJSONObject);
      AppMethodBeat.o(226790);
      return paramJSONObject;
    }
    
    private static h ao(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(226792);
      try
      {
        String str = paramJSONObject.getString("name");
        long l = paramJSONObject.getLong("lastModified");
        p.j(str, "name");
        paramJSONObject = new h(str, l);
        AppMethodBeat.o(226792);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.h
 * JD-Core Version:    0.7.0.1
 */