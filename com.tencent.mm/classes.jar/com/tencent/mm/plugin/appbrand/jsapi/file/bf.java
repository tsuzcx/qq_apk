package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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

final class bf
  extends g
{
  private static i.a a(m paramm, String paramString)
  {
    AppMethodBeat.i(216173);
    switch (1.oSw[paramm.ordinal()])
    {
    default: 
      paramm = new i.a("fail " + paramm.name(), new Object[0]);
      AppMethodBeat.o(216173);
      return paramm;
    case 3: 
      paramm = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(216173);
      return paramm;
    case 4: 
      paramm = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(216173);
      return paramm;
    }
    paramm = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(216173);
    return paramm;
  }
  
  private static void a(i<Map<String, ByteBuffer>> parami, h paramh, i<i.a> parami1, i<Map<String, Object>> parami2)
  {
    AppMethodBeat.i(216171);
    if ((parami.value == null) || (parami1.value == null) || (parami2.value == null))
    {
      AppMethodBeat.o(216171);
      return;
    }
    parami = ((Map)parami.value).entrySet().iterator();
    if (parami.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)parami.next();
      HashMap localHashMap = new HashMap();
      if (paramh == null)
      {
        Object localObject = localEntry.getValue();
        ((i.a)parami1.value).p("file:" + (String)localEntry.getKey(), localObject);
        localHashMap.put("errMsg", "ok");
      }
      for (;;)
      {
        ((Map)parami2.value).put("file:" + (String)localEntry.getKey(), localHashMap);
        break;
        localHashMap.put("data", paramh.k((ByteBuffer)localEntry.getValue()));
        localHashMap.put("errMsg", "ok");
      }
    }
    AppMethodBeat.o(216171);
  }
  
  private static void t(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(216169);
    if (paramBoolean) {
      u.deleteFile(paramString);
    }
    AppMethodBeat.o(216169);
  }
  
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(216168);
    Object localObject1 = parame.getFileSystem().adL(paramString);
    Object localObject2;
    if ((localObject1 == null) || (!((q)localObject1).ifE()))
    {
      if (parame.getFileSystem().acT(paramString) != m.nMR) {
        break label1068;
      }
      localObject2 = parame.getFileSystem().adN(URLEncoder.encode(paramString));
      if (localObject2 == null) {
        break label1068;
      }
      localObject1 = new i();
      parame.getFileSystem().b(paramString, (i)localObject1);
    }
    for (;;)
    {
      q localq;
      try
      {
        Channels.newChannel(u.an((q)localObject2)).write((ByteBuffer)((i)localObject1).value);
        localObject1 = new q(((q)localObject2).bOF());
        bool = true;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", "copy ByteBuffer failed e = %s", new Object[] { localIOException });
        localq = null;
        bool = false;
        continue;
      }
      if (localObject1 == null)
      {
        parame = new i.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(216168);
        return parame;
        if ((localq.isDirectory()) || (o.t(localq)))
        {
          parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          AppMethodBeat.o(216168);
          return parame;
        }
        bool = false;
      }
      for (;;)
      {
        localObject2 = new i.a("ok", new Object[0]);
        i locali1 = new i();
        locali1.value = localObject2;
        HashMap localHashMap = new HashMap();
        i locali2 = new i();
        locali2.value = localHashMap;
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
          Object localObject3 = new i();
          try
          {
            parame = parame.getFileSystem().a(paramString, (i)localObject3, "", 0L, 9223372036854775807L);
            t(bool, localq.bOF());
            if ((parame != m.nMR) || (((i)localObject3).value == null)) {
              break label503;
            }
            a((i)localObject3, paramJSONObject, locali1, locali2);
            parame = ((i.a)localObject2).p("entries", localHashMap);
            AppMethodBeat.o(216168);
            return parame;
          }
          catch (Exception parame)
          {
            Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", parame, "read zip stream, all files mode", new Object[0]);
            parame = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read zip data", new Object[0]);
            AppMethodBeat.o(216168);
            return parame;
          }
          paramJSONObject = (h)h.a.oRM.get(paramJSONObject.toLowerCase());
          if (paramJSONObject == null)
          {
            parame = new i.a("fail invalid encoding", new Object[0]);
            AppMethodBeat.o(216168);
            return parame;
            label503:
            parame = a(parame, paramString);
            AppMethodBeat.o(216168);
            return parame;
            localObject3 = paramJSONObject.optJSONArray("entries");
            if (localObject3 == null)
            {
              parame = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail invalid input: entries format wrong", new Object[0]);
              AppMethodBeat.o(216168);
              return parame;
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
                parame = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryinvalid input data", new Object[0]);
                AppMethodBeat.o(216168);
                return parame;
              }
              str = paramJSONObject.optString("path");
              localObject4 = paramJSONObject.optString("encoding", "");
              l1 = paramJSONObject.optLong("position", 0L);
              l2 = paramJSONObject.optLong("length", 9223372036854775807L);
              if (Util.isNullOrNil((String)localObject4)) {
                paramJSONObject = null;
              }
            }
            label1059:
            for (;;)
            {
              localObject4 = new i();
              for (;;)
              {
                m localm;
                try
                {
                  localm = parame.getFileSystem().a(paramString, (i)localObject4, str, l1, l2);
                  t(bool, localq.bOF());
                  if ((localm != m.nMR) || (((i)localObject4).value == null) || (((Map)((i)localObject4).value).size() <= 0)) {
                    break label851;
                  }
                  a((i)localObject4, paramJSONObject, locali1, locali2);
                  i += 1;
                }
                catch (Exception parame)
                {
                  Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitReadZipEntry", parame, "read zip stream, single file mode", new Object[0]);
                  parame = new i.a("MicroMsg.AppBrand.FileSystem.UnitReadZipEntryfail read ZipEntry", new Object[0]);
                  AppMethodBeat.o(216168);
                  return parame;
                }
                paramJSONObject = (h)h.a.oRM.get(((String)localObject4).toLowerCase());
                if (paramJSONObject != null) {
                  break label1059;
                }
                paramJSONObject = new HashMap();
                paramJSONObject.put("errMsg", "fail invalid encoding");
                localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                continue;
                label851:
                if ((((i)localObject4).value != null) && (((Map)((i)localObject4).value).size() == 0))
                {
                  paramJSONObject = new HashMap();
                  paramJSONObject.put("errMsg", "fail no such file");
                  localHashMap.put("file:".concat(String.valueOf(str)), paramJSONObject);
                }
                else
                {
                  switch (1.oSw[localm.ordinal()])
                  {
                  default: 
                    parame = a(localm, paramString);
                    AppMethodBeat.o(216168);
                    return parame;
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
              parame = ((i.a)localObject2).p("entries", localHashMap);
              AppMethodBeat.o(216168);
              return parame;
            }
          }
        }
      }
      label1068:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bf
 * JD-Core Version:    0.7.0.1
 */