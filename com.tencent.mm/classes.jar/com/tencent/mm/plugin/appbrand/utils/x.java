package com.tencent.mm.plugin.appbrand.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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

public final class x
{
  public static final b a(i parami, m paramm, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(201309);
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
        ae.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.mUn;
        AppMethodBeat.o(201309);
        return parami;
        bool1 = false;
        break;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray(locala.mUj);
    if (localJSONArray == null)
    {
      parami = b.mUn;
      AppMethodBeat.o(201309);
      return parami;
    }
    paramJSONObject.remove(locala.mUj);
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
          String str = parama.optString(locala.mUk);
          if (!bu.isNullOrNil(str))
          {
            int m = parama.optInt(locala.mUl, -1);
            if (m == -1) {}
            try
            {
              parama = parama.optString(locala.mUm, "");
              if (bu.isNullOrNil(parama))
              {
                ae.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(parama.getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException parama)
            {
              ae.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { parama.getMessage() });
            }
            parama = (k)parami.P(k.class);
            if (parama == null)
            {
              ae.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label465;
            }
            if (paramm == null) {}
            for (parama = parama.J(m, false); parama == null; parama = paramm.a(str, parama, m))
            {
              ae.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
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
        ae.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(i) });
        if (i > locala.jZY)
        {
          ae.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.jZY) });
          parami = b.mUo;
          AppMethodBeat.o(201309);
          return parami;
        }
        parami = b.mUn;
        AppMethodBeat.o(201309);
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
        ae.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.mUn;
        AppMethodBeat.o(140856);
        return parami;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
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
          parami.put(locala.mUk, localObject1);
          if (parama != null)
          {
            k = parama.getNativeBufferId();
            if (k != -1)
            {
              localObject1 = (ByteBuffer)localObject2;
              if (localObject1 == null) {
                ae.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
              }
            }
          }
        }
        catch (JSONException parami) {}
      }
    }
    for (;;)
    {
      ae.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { parami.getMessage() });
      localIterator.remove();
      break;
      parama.setNativeBuffer(k, (ByteBuffer)localObject1);
      parami.put(locala.mUl, k);
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
        localObject1 = new String(Base64.encode(d.p((ByteBuffer)localObject2), 2), StandardCharsets.UTF_8);
        parami.put(locala.mUm, localObject1);
      }
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.d("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.jZY) {
          break;
        }
        ae.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.jZY) });
        parami = b.mUo;
        AppMethodBeat.o(140856);
        return parami;
      }
      if (j != 0) {
        paramMap.put(locala.mUj, localJSONArray);
      }
      parami = b.mUn;
      AppMethodBeat.o(140856);
      return parami;
    }
  }
  
  public static ByteBuffer ay(byte[] paramArrayOfByte)
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
  
  public static void l(c paramc, String paramString)
  {
    AppMethodBeat.i(140858);
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    paramc.cb("onError", new JSONObject(localHashMap).toString());
    AppMethodBeat.o(140858);
  }
  
  public static ByteBuffer q(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(201308);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(201308);
      return paramByteBuffer;
    }
    if (paramByteBuffer.isDirect())
    {
      AppMethodBeat.o(201308);
      return paramByteBuffer;
    }
    if (!paramByteBuffer.hasArray())
    {
      AppMethodBeat.o(201308);
      return paramByteBuffer;
    }
    paramByteBuffer = ay(paramByteBuffer.array());
    AppMethodBeat.o(201308);
    return paramByteBuffer;
  }
  
  public static class a
    implements j
  {
    public int jZY = 2147483647;
    public String mUj = "__nativeBuffers__";
    public String mUk = "key";
    public String mUl = "id";
    public String mUm = "base64";
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140854);
      mUn = new b("OK", 0);
      mUo = new b("FAIL_SIZE_EXCEED_LIMIT", 1);
      mUp = new b[] { mUn, mUo };
      AppMethodBeat.o(140854);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */