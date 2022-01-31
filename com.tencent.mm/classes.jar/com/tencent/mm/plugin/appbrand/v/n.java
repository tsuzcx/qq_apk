package com.tencent.mm.plugin.appbrand.v;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
{
  public static ByteBuffer Q(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    localByteBuffer.rewind();
    return localByteBuffer;
  }
  
  public static final n.b a(f paramf, Map paramMap, n.a parama)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramf == null) || (paramMap == null))
    {
      if (paramf == null) {}
      for (bool1 = true;; bool1 = false)
      {
        if (paramMap == null) {
          bool2 = true;
        }
        y.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return n.b.hlF;
      }
    }
    n.a locala = parama;
    if (parama == null) {
      locala = new n.a();
    }
    parama = (h)paramf.I(h.class);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    int j = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramf = (Map.Entry)localIterator.next();
      localObject1 = (String)paramf.getKey();
      localObject2 = paramf.getValue();
    } while ((localObject2 == null) || (!(localObject2 instanceof ByteBuffer)));
    for (;;)
    {
      try
      {
        paramf = new JSONObject();
        paramf.put(locala.hlC, localObject1);
        if (parama != null)
        {
          k = parama.getNativeBufferId();
          if (k != -1)
          {
            localObject1 = (ByteBuffer)localObject2;
            if (localObject1 == null) {
              y.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
            }
          }
        }
      }
      catch (JSONException paramf)
      {
        y.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { paramf.getMessage() });
        localIterator.remove();
        break;
        parama.setNativeBuffer(k, (ByteBuffer)localObject1);
        paramf.put(locala.hlD, k);
        int k = ((ByteBuffer)localObject1).capacity();
        i += k;
        try
        {
          localJSONArray.put(paramf);
          j = 1;
        }
        catch (UnsupportedEncodingException paramf)
        {
          break label345;
        }
        catch (JSONException paramf) {}
        localObject1 = new String(Base64.encode(((ByteBuffer)localObject2).array(), 2), "utf-8");
        paramf.put(locala.hlE, localObject1);
        continue;
      }
      catch (UnsupportedEncodingException paramf) {}
      label345:
      y.w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", new Object[] { paramf.getMessage() });
      continue;
      if (parama != null) {}
      for (bool1 = true;; bool1 = false)
      {
        y.i("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (i <= locala.fOQ) {
          break;
        }
        y.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.fOQ) });
        return n.b.hlG;
      }
      if (j != 0) {
        paramMap.put(locala.hlB, localJSONArray);
      }
      return n.b.hlF;
    }
  }
  
  public static final n.b a(f paramf, JSONObject paramJSONObject, n.a parama)
  {
    boolean bool2 = false;
    if ((paramf == null) || (paramJSONObject == null))
    {
      if (paramf == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject == null) {
          bool2 = true;
        }
        y.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return n.b.hlF;
      }
    }
    n.a locala = parama;
    if (parama == null) {
      locala = new n.a();
    }
    parama = paramJSONObject.optJSONArray(locala.hlB);
    if (parama == null) {
      return n.b.hlF;
    }
    paramJSONObject.remove(locala.hlB);
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
          String str = ((JSONObject)localObject).optString(locala.hlC);
          if (!bk.bl(str))
          {
            int m = ((JSONObject)localObject).optInt(locala.hlD, -1);
            if (m == -1) {}
            try
            {
              localObject = ((JSONObject)localObject).optString(locala.hlE, "");
              if (bk.bl((String)localObject))
              {
                y.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(((String)localObject).getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException localJSONException)
            {
              y.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { localJSONException.getMessage() });
            }
            localObject = (h)paramf.I(h.class);
            if (localObject == null)
            {
              y.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
              break label423;
            }
            localObject = ((h)localObject).getNativeBuffer(m);
            if (localObject == null)
            {
              y.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
              break label423;
            }
            ((ByteBuffer)localObject).position(0);
            paramJSONObject.put(str, localObject);
            m = ((ByteBuffer)localObject).capacity();
            i = m + i;
            break label423;
          }
        }
      }
      else
      {
        y.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(i) });
        if (i > locala.fOQ)
        {
          y.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.fOQ) });
          return n.b.hlG;
        }
        return n.b.hlF;
      }
      label423:
      j += 1;
    }
  }
  
  public static void m(c paramc, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", "convert native buffer parameter fail, event=" + paramString + ", error=native buffer exceed size limit");
    localHashMap.put("stack", "");
    paramc.bw("onError", new JSONObject(localHashMap).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.n
 * JD-Core Version:    0.7.0.1
 */