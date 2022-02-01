package com.tencent.mm.plugin.appbrand.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v
{
  public static final v.b a(i parami, Map paramMap, v.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(140856);
    boolean bool1;
    if ((parami == null) || (paramMap == null))
    {
      if (parami == null) {}
      for (bool1 = true;; bool1 = false)
      {
        if (paramMap == null) {
          bool2 = true;
        }
        ad.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = v.b.lMJ;
        AppMethodBeat.o(140856);
        return parami;
      }
    }
    v.a locala = parama;
    if (parama == null) {
      locala = new v.a();
    }
    parama = (k)parami.P(k.class);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    int j = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        parami = (Map.Entry)localIterator.next();
        localObject1 = (String)parami.getKey();
        localObject2 = parami.getValue();
        if ((localObject2 == null) || (!(localObject2 instanceof ByteBuffer))) {
          continue;
        }
        try
        {
          parami = new JSONObject();
          parami.put(locala.lMG, localObject1);
          if (parama != null)
          {
            k = parama.getNativeBufferId();
            if (k != -1)
            {
              localObject1 = (ByteBuffer)localObject2;
              if (localObject1 == null) {
                ad.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
              }
            }
          }
        }
        catch (JSONException parami) {}
      }
    }
    for (;;)
    {
      ad.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { parami.getMessage() });
      localIterator.remove();
      break;
      parama.setNativeBuffer(k, (ByteBuffer)localObject1);
      parami.put(locala.lMH, k);
      k = ((ByteBuffer)localObject1).capacity();
      i += k;
      for (;;)
      {
        try
        {
          localJSONArray.put(parami);
          j = 1;
        }
        catch (JSONException parami) {}
        localObject1 = new String(Base64.encode(d.q((ByteBuffer)localObject2), 2), StandardCharsets.UTF_8);
        parami.put(locala.lMI, localObject1);
      }
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.d("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.jcA) {
          break;
        }
        ad.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.jcA) });
        parami = v.b.lMK;
        AppMethodBeat.o(140856);
        return parami;
      }
      if (j != 0) {
        paramMap.put(locala.lMF, localJSONArray);
      }
      parami = v.b.lMJ;
      AppMethodBeat.o(140856);
      return parami;
    }
  }
  
  public static final v.b a(i parami, JSONObject paramJSONObject, v.a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(140857);
    if ((parami == null) || (paramJSONObject == null))
    {
      if (parami == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject == null) {
          bool2 = true;
        }
        ad.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = v.b.lMJ;
        AppMethodBeat.o(140857);
        return parami;
      }
    }
    v.a locala = parama;
    if (parama == null) {
      locala = new v.a();
    }
    parama = paramJSONObject.optJSONArray(locala.lMF);
    if (parama == null)
    {
      parami = v.b.lMJ;
      AppMethodBeat.o(140857);
      return parami;
    }
    paramJSONObject.remove(locala.lMF);
    int k = parama.length();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        Object localObject = parama.optJSONObject(j);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString(locala.lMG);
          if (!bt.isNullOrNil(str))
          {
            int m = ((JSONObject)localObject).optInt(locala.lMH, -1);
            if (m == -1) {}
            try
            {
              localObject = ((JSONObject)localObject).optString(locala.lMI, "");
              if (bt.isNullOrNil((String)localObject))
              {
                ad.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(((String)localObject).getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException localJSONException)
            {
              ad.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { localJSONException.getMessage() });
            }
            localObject = (k)parami.P(k.class);
            if (localObject == null)
            {
              ad.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label456;
            }
            localObject = ((k)localObject).getNativeBuffer(m);
            if (localObject == null)
            {
              ad.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
              break label456;
            }
            ((ByteBuffer)localObject).position(0);
            paramJSONObject.put(str, localObject);
            m = ((ByteBuffer)localObject).capacity();
            i = m + i;
            break label456;
          }
        }
      }
      else
      {
        ad.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(i) });
        if (i > locala.jcA)
        {
          ad.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.jcA) });
          parami = v.b.lMK;
          AppMethodBeat.o(140857);
          return parami;
        }
        parami = v.b.lMJ;
        AppMethodBeat.o(140857);
        return parami;
      }
      label456:
      j += 1;
    }
  }
  
  public static ByteBuffer az(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140855);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(140855);
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    localByteBuffer.rewind();
    AppMethodBeat.o(140855);
    return localByteBuffer;
  }
  
  public static void k(c paramc, String paramString)
  {
    AppMethodBeat.i(140858);
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    paramc.bR("onError", new JSONObject(localHashMap).toString());
    AppMethodBeat.o(140858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.v
 * JD-Core Version:    0.7.0.1
 */