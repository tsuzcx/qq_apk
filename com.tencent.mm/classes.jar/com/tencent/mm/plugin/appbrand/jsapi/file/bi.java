package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class bi
  extends g
{
  private static void F(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(329085);
    if (paramBoolean) {
      y.deleteFile(paramString);
    }
    AppMethodBeat.o(329085);
  }
  
  private static i.a a(r paramr, String paramString)
  {
    AppMethodBeat.i(329097);
    switch (1.rXN[paramr.ordinal()])
    {
    default: 
      paramr = new i.a("fail " + paramr.name(), new Object[0]);
      AppMethodBeat.o(329097);
      return paramr;
    case 3: 
      paramr = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(329097);
      return paramr;
    case 4: 
      paramr = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(329097);
      return paramr;
    }
    paramr = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(329097);
    return paramr;
  }
  
  private static void a(k<Map<String, ByteBuffer>> paramk, h paramh, k<i.a> paramk1, k<Map<String, Object>> paramk2)
  {
    AppMethodBeat.i(329092);
    if ((paramk.value == null) || (paramk1.value == null) || (paramk2.value == null))
    {
      AppMethodBeat.o(329092);
      return;
    }
    paramk = ((Map)paramk.value).entrySet().iterator();
    if (paramk.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramk.next();
      HashMap localHashMap = new HashMap();
      if (paramh == null)
      {
        Object localObject = localEntry.getValue();
        ((i.a)paramk1.value).x("file:" + (String)localEntry.getKey(), localObject);
        localHashMap.put("errMsg", "ok");
      }
      for (;;)
      {
        ((Map)paramk2.value).put("file:" + (String)localEntry.getKey(), localHashMap);
        break;
        localHashMap.put("data", paramh.q((ByteBuffer)localEntry.getValue()));
        localHashMap.put("errMsg", "ok");
      }
    }
    AppMethodBeat.o(329092);
  }
  
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329114);
    Object localObject1 = paramf.getFileSystem().Wm(paramString);
    Object localObject2;
    if ((localObject1 == null) || (!((u)localObject1).jKS()))
    {
      if (paramf.getFileSystem().Vr(paramString) != r.qML) {
        break label1076;
      }
      localObject2 = paramf.getFileSystem().Wo(URLEncoder.encode(paramString));
      if (localObject2 == null) {
        break label1076;
      }
      localObject1 = new k();
      paramf.getFileSystem().b(paramString, (k)localObject1);
    }
    for (;;)
    {
      u localu;
      try
      {
        Channels.newChannel(y.ap((u)localObject2)).write((ByteBuffer)((k)localObject1).value);
        localObject1 = new u(ah.v(((u)localObject2).jKT()));
        bool = true;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", "copy ByteBuffer failed e = %s", new Object[] { localIOException });
        localu = null;
        bool = false;
        continue;
      }
      if (localObject1 == null)
      {
        paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(329114);
        return paramf;
        if ((localu.isDirectory()) || (t.u(localu)))
        {
          paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(329114);
          return paramf;
        }
        bool = false;
      }
      for (;;)
      {
        localObject2 = new i.a("ok", new Object[0]);
        k localk1 = new k();
        localk1.value = localObject2;
        HashMap localHashMap = new HashMap();
        k localk2 = new k();
        localk2.value = localHashMap;
        if ("all".equals(paramJSONObject.optString("entries", "")))
        {
          paramJSONObject = paramJSONObject.optString("encoding");
          Log.i("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", "call, all files, path %s, encoding %s", new Object[] { paramString, paramJSONObject });
          if (Util.isNullOrNil(paramJSONObject)) {
            paramJSONObject = null;
          }
        }
        for (;;)
        {
          Object localObject3 = new k();
          try
          {
            paramf = paramf.getFileSystem().a(paramString, (k)localObject3, "", 0L, 9223372036854775807L);
            F(bool, ah.v(localu.jKT()));
            if ((paramf != r.qML) || (((k)localObject3).value == null)) {
              break label510;
            }
            a((k)localObject3, paramJSONObject, localk1, localk2);
            paramf = ((i.a)localObject2).x("entries", localHashMap);
            AppMethodBeat.o(329114);
            return paramf;
          }
          catch (Exception paramf)
          {
            Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", paramf, "read zip stream, all files mode", new Object[0]);
            paramf = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read zip data", new Object[0]);
            AppMethodBeat.o(329114);
            return paramf;
          }
          paramJSONObject = (h)h.a.rXm.get(paramJSONObject.toLowerCase());
          if (paramJSONObject == null)
          {
            paramf = new i.a("fail invalid encoding", new Object[0]);
            AppMethodBeat.o(329114);
            return paramf;
            label510:
            paramf = a(paramf, paramString);
            AppMethodBeat.o(329114);
            return paramf;
            localObject3 = paramJSONObject.optJSONArray("entries");
            if (localObject3 == null)
            {
              paramf = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail invalid input: entries format wrong", new Object[0]);
              AppMethodBeat.o(329114);
              return paramf;
            }
            int i = 0;
            String str;
            Object localObject4;
            long l1;
            long l2;
            if (i < ((JSONArray)localObject3).length())
            {
              paramJSONObject = ((JSONArray)localObject3).optJSONObject(i);
              if ((paramJSONObject == null) || (Util.isNullOrNil(paramJSONObject.optString("path"))))
              {
                paramf = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryinvalid input data", new Object[0]);
                AppMethodBeat.o(329114);
                return paramf;
              }
              str = paramJSONObject.optString("path");
              localObject4 = paramJSONObject.optString("encoding", "");
              l1 = paramJSONObject.optLong("position", 0L);
              l2 = paramJSONObject.optLong("length", 9223372036854775807L);
              if (Util.isNullOrNil((String)localObject4)) {
                paramJSONObject = null;
              }
            }
            label1067:
            for (;;)
            {
              localObject4 = new k();
              for (;;)
              {
                r localr;
                try
                {
                  localr = paramf.getFileSystem().a(paramString, (k)localObject4, str, l1, l2);
                  F(bool, ah.v(localu.jKT()));
                  if ((localr != r.qML) || (((k)localObject4).value == null) || (((Map)((k)localObject4).value).size() <= 0)) {
                    break label861;
                  }
                  a((k)localObject4, paramJSONObject, localk1, localk2);
                  i += 1;
                }
                catch (Exception paramf)
                {
                  Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", paramf, "read zip stream, single file mode", new Object[0]);
                  paramf = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read ZipEntry", new Object[0]);
                  AppMethodBeat.o(329114);
                  return paramf;
                }
                paramJSONObject = (h)h.a.rXm.get(((String)localObject4).toLowerCase());
                if (paramJSONObject != null) {
                  break label1067;
                }
                paramJSONObject = new HashMap();
                paramJSONObject.put("errMsg", "fail invalid encoding");
                localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                continue;
                label861:
                if ((((k)localObject4).value != null) && (((Map)((k)localObject4).value).size() == 0))
                {
                  paramJSONObject = new HashMap();
                  paramJSONObject.put("errMsg", "fail no such file");
                  localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                }
                else
                {
                  switch (1.rXN[localr.ordinal()])
                  {
                  default: 
                    paramf = a(localr, paramString);
                    AppMethodBeat.o(329114);
                    return paramf;
                  case 1: 
                    paramJSONObject = new HashMap();
                    paramJSONObject.put("errMsg", "fail the value of position is out of range");
                    localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                    break;
                  case 2: 
                    paramJSONObject = new HashMap();
                    paramJSONObject.put("errMsg", "fail the value of length is out of range");
                    localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                  }
                }
              }
              paramf = ((i.a)localObject2).x("entries", localHashMap);
              AppMethodBeat.o(329114);
              return paramf;
            }
          }
        }
      }
      label1076:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bi
 * JD-Core Version:    0.7.0.1
 */