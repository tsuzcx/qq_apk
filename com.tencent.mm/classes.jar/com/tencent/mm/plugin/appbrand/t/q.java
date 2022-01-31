package com.tencent.mm.plugin.appbrand.t;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class q
{
  public static final b a(i parami, Map paramMap, a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91182);
    boolean bool1;
    if ((parami == null) || (paramMap == null))
    {
      if (parami == null) {}
      for (bool1 = true;; bool1 = false)
      {
        if (paramMap == null) {
          bool2 = true;
        }
        ab.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.iXY;
        AppMethodBeat.o(91182);
        return parami;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    parama = (k)parami.v(k.class);
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
          parami.put(locala.iXV, localObject1);
          if (parama != null)
          {
            k = parama.getNativeBufferId();
            if (k != -1)
            {
              localObject1 = (ByteBuffer)localObject2;
              if (localObject1 == null) {
                ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
              }
            }
          }
        }
        catch (JSONException parami) {}
      }
    }
    for (;;)
    {
      ab.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { parami.getMessage() });
      localIterator.remove();
      break;
      parama.setNativeBuffer(k, (ByteBuffer)localObject1);
      parami.put(locala.iXW, k);
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
        parami.put(locala.iXX, localObject1);
      }
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.i("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.hhQ) {
          break;
        }
        ab.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.hhQ) });
        parami = b.iXZ;
        AppMethodBeat.o(91182);
        return parami;
      }
      if (j != 0) {
        paramMap.put(locala.iXU, localJSONArray);
      }
      parami = b.iXY;
      AppMethodBeat.o(91182);
      return parami;
    }
  }
  
  public static final b a(i parami, JSONObject paramJSONObject, a parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91183);
    if ((parami == null) || (paramJSONObject == null))
    {
      if (parami == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject == null) {
          bool2 = true;
        }
        ab.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parami = b.iXY;
        AppMethodBeat.o(91183);
        return parami;
      }
    }
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    parama = paramJSONObject.optJSONArray(locala.iXU);
    if (parama == null)
    {
      parami = b.iXY;
      AppMethodBeat.o(91183);
      return parami;
    }
    paramJSONObject.remove(locala.iXU);
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
          String str = ((JSONObject)localObject).optString(locala.iXV);
          if (!bo.isNullOrNil(str))
          {
            int m = ((JSONObject)localObject).optInt(locala.iXW, -1);
            if (m == -1) {}
            try
            {
              localObject = ((JSONObject)localObject).optString(locala.iXX, "");
              if (bo.isNullOrNil((String)localObject))
              {
                ab.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(((String)localObject).getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException localJSONException)
            {
              ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { localJSONException.getMessage() });
            }
            localObject = (k)parami.v(k.class);
            if (localObject == null)
            {
              ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label456;
            }
            localObject = ((k)localObject).getNativeBuffer(m);
            if (localObject == null)
            {
              ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
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
        ab.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(i) });
        if (i > locala.hhQ)
        {
          ab.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.hhQ) });
          parami = b.iXZ;
          AppMethodBeat.o(91183);
          return parami;
        }
        parami = b.iXY;
        AppMethodBeat.o(91183);
        return parami;
      }
      label456:
      j += 1;
    }
  }
  
  public static ByteBuffer ak(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91181);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(91181);
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    localByteBuffer.rewind();
    AppMethodBeat.o(91181);
    return localByteBuffer;
  }
  
  public static void l(c paramc, String paramString)
  {
    AppMethodBeat.i(91184);
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    paramc.bY("onError", new JSONObject(localHashMap).toString());
    AppMethodBeat.o(91184);
  }
  
  public static class a
    implements j
  {
    public int hhQ = 2147483647;
    public String iXU = "__nativeBuffers__";
    public String iXV = "key";
    public String iXW = "id";
    public String iXX = "base64";
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(91180);
      iXY = new b("OK", 0);
      iXZ = new b("FAIL_SIZE_EXCEED_LIMIT", 1);
      iYa = new b[] { iXY, iXZ };
      AppMethodBeat.o(91180);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.q
 * JD-Core Version:    0.7.0.1
 */