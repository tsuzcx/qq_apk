package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137480);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(137480);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137479);
        int i = paramJSONObject.optInt("cameraId");
        String str = paramJSONObject.optString("type");
        ac.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
        Object localObject = a.a.bfZ();
        if (((a)localObject).kmc.indexOfKey(i) >= 0)
        {
          localObject = (WeakReference)((a)localObject).kmc.get(i);
          if (localObject != null) {
            localObject = (f)((WeakReference)localObject).get();
          }
        }
        while (localObject == null)
        {
          paramc.h(paramInt, n.this.e("fail:no such camera", null));
          AppMethodBeat.o(137479);
          return;
          localObject = null;
          continue;
          localObject = null;
        }
        ((f)localObject).setOperateCallBack(new c()
        {
          public final void a(int paramAnonymous2Int1, String paramAnonymous2String1, String paramAnonymous2String2, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(137475);
            if (paramAnonymous2Int1 == 0)
            {
              paramAnonymous2String2 = new HashMap();
              paramAnonymous2String2.put("tempImagePath", paramAnonymous2String1);
              paramAnonymous2String2.put("width", Integer.valueOf(paramAnonymous2Int2));
              paramAnonymous2String2.put("height", Integer.valueOf(paramAnonymous2Int3));
              n.1.this.jZx.h(n.1.this.bZy, n.this.k("ok", paramAnonymous2String2));
              AppMethodBeat.o(137475);
              return;
            }
            n.1.this.jZx.h(n.1.this.bZy, n.this.e("fail:".concat(String.valueOf(paramAnonymous2String2)), null));
            AppMethodBeat.o(137475);
          }
          
          public final void a(int paramAnonymous2Int1, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, int paramAnonymous2Int2, long paramAnonymous2Long, int paramAnonymous2Int3, int paramAnonymous2Int4)
          {
            AppMethodBeat.i(137477);
            ac.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", new Object[] { Integer.valueOf(paramAnonymous2Int1), paramAnonymous2String2, paramAnonymous2String3, Integer.valueOf(paramAnonymous2Int2), Long.valueOf(paramAnonymous2Long), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
            if (paramAnonymous2Int1 == 0)
            {
              paramAnonymous2String1 = new HashMap();
              paramAnonymous2String1.put("tempThumbPath", paramAnonymous2String2);
              paramAnonymous2String1.put("tempVideoPath", paramAnonymous2String3);
              paramAnonymous2String1.put("duration", Integer.valueOf(paramAnonymous2Int2));
              paramAnonymous2String1.put("size", Long.valueOf(paramAnonymous2Long));
              paramAnonymous2String1.put("height", Integer.valueOf(paramAnonymous2Int4));
              paramAnonymous2String1.put("width", Integer.valueOf(paramAnonymous2Int3));
              n.1.this.jZx.h(n.1.this.bZy, n.this.k("ok", paramAnonymous2String1));
              AppMethodBeat.o(137477);
              return;
            }
            n.1.this.jZx.h(n.1.this.bZy, n.this.e("fail:".concat(String.valueOf(paramAnonymous2String1)), null));
            AppMethodBeat.o(137477);
          }
          
          public final void ae(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(137476);
            if (paramAnonymous2Int == 0)
            {
              n.1.this.jZx.h(n.1.this.bZy, n.this.e("ok", null));
              AppMethodBeat.o(137476);
              return;
            }
            n.1.this.jZx.h(n.1.this.bZy, n.this.e("fail:".concat(String.valueOf(paramAnonymous2String)), null));
            AppMethodBeat.o(137476);
          }
          
          public final void h(String paramAnonymous2String, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(137478);
            if (!bs.isNullOrNil(paramAnonymous2String))
            {
              n.1.this.jZx.h(n.1.this.bZy, n.this.e("fail:".concat(String.valueOf(paramAnonymous2String)), null));
              AppMethodBeat.o(137478);
              return;
            }
            ac.d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
            paramAnonymous2String = new HashMap();
            paramAnonymous2String.put("bufferId", Integer.valueOf(paramAnonymous2Int1));
            paramAnonymous2String.put("width", Integer.valueOf(paramAnonymous2Int2));
            paramAnonymous2String.put("height", Integer.valueOf(paramAnonymous2Int3));
            n.1.this.jZx.h(n.1.this.bZy, n.this.k("ok", paramAnonymous2String));
            AppMethodBeat.o(137478);
          }
        });
        i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            ac.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
            paramc.h(paramInt, n.this.e("fail:operateType not supported", null));
            AppMethodBeat.o(137479);
            return;
            if (str.equals("takePhoto"))
            {
              i = 0;
              continue;
              if (str.equals("setZoom"))
              {
                i = 1;
                continue;
                if (str.equals("startRecord"))
                {
                  i = 2;
                  continue;
                  if (str.equals("stopRecord"))
                  {
                    i = 3;
                    continue;
                    if (str.equals("listenFrameChange"))
                    {
                      i = 4;
                      continue;
                      if (str.equals("closeFrameChange")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        ((f)localObject).setQuality(paramJSONObject.optString("quality", "high"));
        ((f)localObject).bgb();
        AppMethodBeat.o(137479);
        return;
        float f = ((f)localObject).aw((float)paramJSONObject.optDouble("zoom"));
        if (f < 1.0F)
        {
          paramc.h(paramInt, n.this.e("fail: zoom multiple not support", null));
          AppMethodBeat.o(137479);
          return;
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("zoom", Float.valueOf(f));
        paramc.h(paramInt, n.this.k("ok", (Map)localObject));
        AppMethodBeat.o(137479);
        return;
        ((f)localObject).bgk();
        AppMethodBeat.o(137479);
        return;
        ((f)localObject).setCompressRecord(paramJSONObject.optBoolean("compressed"));
        ((f)localObject).bgl();
        AppMethodBeat.o(137479);
        return;
        paramJSONObject.optString("size");
        ((f)localObject).o(paramc);
        AppMethodBeat.o(137479);
        return;
        ((f)localObject).bge();
        paramc.h(paramInt, n.this.e("ok", null));
        AppMethodBeat.o(137479);
      }
    });
    AppMethodBeat.o(137480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.n
 * JD-Core Version:    0.7.0.1
 */