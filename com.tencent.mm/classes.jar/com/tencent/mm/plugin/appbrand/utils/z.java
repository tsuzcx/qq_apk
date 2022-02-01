package com.tencent.mm.plugin.appbrand.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
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

public final class z
{
  public static final z.b a(i parami, o paramo, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(207844);
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
        parami = z.b.rjc;
        AppMethodBeat.o(207844);
        return parami;
        bool1 = false;
        break;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray(locala.riY);
    if (localJSONArray == null)
    {
      parami = z.b.rjc;
      AppMethodBeat.o(207844);
      return parami;
    }
    paramJSONObject.remove(locala.riY);
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
          String str = parama.optString(locala.riZ);
          if (!Util.isNullOrNil(str))
          {
            int m = parama.optInt(locala.rja, -1);
            if (m == -1) {}
            try
            {
              parama = parama.optString(locala.rjb, "");
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
            parama = (k)parami.Q(k.class);
            if (parama == null)
            {
              Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label465;
            }
            if (paramo == null) {}
            for (parama = parama.P(m, false); parama == null; parama = paramo.a(str, parama, m))
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
        if (i > locala.nXk)
        {
          Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.nXk) });
          parami = z.b.rjd;
          AppMethodBeat.o(207844);
          return parami;
        }
        parami = z.b.rjc;
        AppMethodBeat.o(207844);
        return parami;
      }
      label465:
      j += 1;
    }
  }
  
  public static final z.b a(i parami, Map paramMap, a parama)
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
        parami = z.b.rjc;
        AppMethodBeat.o(140856);
        return parami;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    parama = (k)parami.Q(k.class);
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
          parami.put(locala.riZ, localObject1);
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
      parami.put(locala.rja, k);
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
        localObject1 = new String(Base64.encode(d.m((ByteBuffer)localObject2), 2), StandardCharsets.UTF_8);
        parami.put(locala.rjb, localObject1);
      }
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.nXk) {
          break;
        }
        Log.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.nXk) });
        parami = z.b.rjd;
        AppMethodBeat.o(140856);
        return parami;
      }
      if (j != 0) {
        paramMap.put(locala.riY, localJSONArray);
      }
      parami = z.b.rjc;
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
  
  public static ByteBuffer n(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(207842);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(207842);
      return paramByteBuffer;
    }
    if (paramByteBuffer.isDirect())
    {
      AppMethodBeat.o(207842);
      return paramByteBuffer;
    }
    if (!paramByteBuffer.hasArray())
    {
      AppMethodBeat.o(207842);
      return paramByteBuffer;
    }
    paramByteBuffer = bc(paramByteBuffer.array());
    AppMethodBeat.o(207842);
    return paramByteBuffer;
  }
  
  public static void n(e parame, String paramString)
  {
    AppMethodBeat.i(140858);
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    parame.ct("onError", new JSONObject(localHashMap).toString());
    AppMethodBeat.o(140858);
  }
  
  public static class a
    implements l
  {
    public int nXk = 2147483647;
    public String riY = "__nativeBuffers__";
    public String riZ = "key";
    public String rja = "id";
    public String rjb = "base64";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */