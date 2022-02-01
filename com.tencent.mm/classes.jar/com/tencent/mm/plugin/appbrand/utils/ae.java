package com.tencent.mm.plugin.appbrand.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

public final class ae
{
  public static final b a(i parami, p paramp, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(317347);
    if ((parami == null) || (paramJSONObject == null))
    {
      boolean bool1;
      if (parami == null)
      {
        bool1 = true;
        if (paramJSONObject != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.urr;
        AppMethodBeat.o(317347);
        return parami;
        bool1 = false;
        break;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray(locala.urn);
    if (localJSONArray == null)
    {
      parami = b.urr;
      AppMethodBeat.o(317347);
      return parami;
    }
    paramJSONObject.remove(locala.urn);
    int k = localJSONArray.length();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        parama = localJSONArray.optJSONObject(j);
        if (parama != null)
        {
          String str = parama.optString(locala.uro);
          if (!Util.isNullOrNil(str))
          {
            int m = parama.optInt(locala.urp, -1);
            if (m == -1) {}
            try
            {
              parama = parama.optString(locala.urq, "");
              if (Util.isNullOrNil(parama))
              {
                Log.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(parama.getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException parama)
            {
              Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { parama.getMessage() });
            }
            parama = (k)parami.Z(k.class);
            if (parama == null)
            {
              Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label465;
            }
            if (paramp == null) {}
            for (parama = parama.ae(m, false); parama == null; parama = paramp.a(str, parama, m))
            {
              Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
              break label465;
            }
            parama.position(0);
            paramJSONObject.put(str, parama);
            m = parama.capacity();
            i = m + i;
            break label465;
          }
        }
      }
      else
      {
        Log.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(i) });
        if (i > locala.qXa)
        {
          Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.qXa) });
          parami = b.urs;
          AppMethodBeat.o(317347);
          return parami;
        }
        parami = b.urr;
        AppMethodBeat.o(317347);
        return parami;
      }
      label465:
      j += 1;
    }
  }
  
  public static final b a(i parami, Map paramMap, a parama)
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
        Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.urr;
        AppMethodBeat.o(140856);
        return parami;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    parama = (k)parami.Z(k.class);
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
          parami.put(locala.uro, localObject1);
          if (parama != null)
          {
            k = parama.getNativeBufferId();
            if (k != -1)
            {
              localObject1 = (ByteBuffer)localObject2;
              if (localObject1 == null) {
                Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
              }
            }
          }
        }
        catch (JSONException parami) {}
      }
    }
    for (;;)
    {
      Log.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { parami.getMessage() });
      localIterator.remove();
      break;
      parama.setNativeBuffer(k, (ByteBuffer)localObject1);
      parami.put(locala.urp, k);
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
        localObject1 = new String(Base64.encode(d.s((ByteBuffer)localObject2), 2), StandardCharsets.UTF_8);
        parami.put(locala.urq, localObject1);
      }
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.qXa) {
          break;
        }
        Log.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.qXa) });
        parami = b.urs;
        AppMethodBeat.o(140856);
        return parami;
      }
      if (j != 0) {
        paramMap.put(locala.urn, localJSONArray);
      }
      parami = b.urr;
      AppMethodBeat.o(140856);
      return parami;
    }
  }
  
  public static ByteBuffer bc(byte[] paramArrayOfByte)
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
  
  public static void m(f paramf, String paramString)
  {
    AppMethodBeat.i(140858);
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    paramf.cJ("onError", new JSONObject(localHashMap).toString());
    AppMethodBeat.o(140858);
  }
  
  public static ByteBuffer t(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(317334);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(317334);
      return paramByteBuffer;
    }
    if (paramByteBuffer.isDirect())
    {
      AppMethodBeat.o(317334);
      return paramByteBuffer;
    }
    if (!paramByteBuffer.hasArray())
    {
      AppMethodBeat.o(317334);
      return paramByteBuffer;
    }
    paramByteBuffer = bc(paramByteBuffer.array());
    AppMethodBeat.o(317334);
    return paramByteBuffer;
  }
  
  public static class a
    implements m
  {
    public int qXa = 2147483647;
    public String urn = "__nativeBuffers__";
    public String uro = "key";
    public String urp = "id";
    public String urq = "base64";
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140854);
      urr = new b("OK", 0);
      urs = new b("FAIL_SIZE_EXCEED_LIMIT", 1);
      urt = new b[] { urr, urs };
      AppMethodBeat.o(140854);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ae
 * JD-Core Version:    0.7.0.1
 */