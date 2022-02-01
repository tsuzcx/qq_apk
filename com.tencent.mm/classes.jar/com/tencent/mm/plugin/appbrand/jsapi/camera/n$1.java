package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class n$1
  implements Runnable
{
  n$1(n paramn, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(137479);
    int i = this.cjV.optInt("cameraId");
    String str = this.cjV.optString("type");
    ae.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
    Object localObject = a.a.bkm();
    if (((a)localObject).kKr.indexOfKey(i) >= 0)
    {
      localObject = (WeakReference)((a)localObject).kKr.get(i);
      if (localObject != null) {
        localObject = (f)((WeakReference)localObject).get();
      }
    }
    while (localObject == null)
    {
      this.kxj.h(this.cjS, this.kLz.e("fail:no such camera", null));
      AppMethodBeat.o(137479);
      return;
      localObject = null;
      continue;
      localObject = null;
    }
    ((f)localObject).setOperateCallBack(new c()
    {
      public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137475);
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString2 = new HashMap();
          paramAnonymousString2.put("tempImagePath", paramAnonymousString1);
          paramAnonymousString2.put("width", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString2.put("height", Integer.valueOf(paramAnonymousInt3));
          n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.n("ok", paramAnonymousString2));
          AppMethodBeat.o(137475);
          return;
        }
        n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.e("fail:".concat(String.valueOf(paramAnonymousString2)), null));
        AppMethodBeat.o(137475);
      }
      
      public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2, long paramAnonymousLong, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(137477);
        ae.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString1 = new HashMap();
          paramAnonymousString1.put("tempThumbPath", paramAnonymousString2);
          paramAnonymousString1.put("tempVideoPath", paramAnonymousString3);
          paramAnonymousString1.put("duration", Integer.valueOf(paramAnonymousInt2));
          paramAnonymousString1.put("size", Long.valueOf(paramAnonymousLong));
          paramAnonymousString1.put("height", Integer.valueOf(paramAnonymousInt4));
          paramAnonymousString1.put("width", Integer.valueOf(paramAnonymousInt3));
          n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.n("ok", paramAnonymousString1));
          AppMethodBeat.o(137477);
          return;
        }
        n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.e("fail:".concat(String.valueOf(paramAnonymousString1)), null));
        AppMethodBeat.o(137477);
      }
      
      public final void ag(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(137476);
        if (paramAnonymousInt == 0)
        {
          n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.e("ok", null));
          AppMethodBeat.o(137476);
          return;
        }
        n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.e("fail:".concat(String.valueOf(paramAnonymousString)), null));
        AppMethodBeat.o(137476);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137478);
        if (!bu.isNullOrNil(paramAnonymousString))
        {
          n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.e("fail:".concat(String.valueOf(paramAnonymousString)), null));
          AppMethodBeat.o(137478);
          return;
        }
        ae.d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        paramAnonymousString = new HashMap();
        paramAnonymousString.put("bufferId", Integer.valueOf(paramAnonymousInt1));
        paramAnonymousString.put("width", Integer.valueOf(paramAnonymousInt2));
        paramAnonymousString.put("height", Integer.valueOf(paramAnonymousInt3));
        n.1.this.kxj.h(n.1.this.cjS, n.1.this.kLz.n("ok", paramAnonymousString));
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
        ae.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
        this.kxj.h(this.cjS, this.kLz.e("fail:operateType not supported", null));
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
    ((f)localObject).setQuality(this.cjV.optString("quality", "high"));
    ((f)localObject).bko();
    AppMethodBeat.o(137479);
    return;
    float f = ((f)localObject).az((float)this.cjV.optDouble("zoom"));
    if (f < 1.0F)
    {
      this.kxj.h(this.cjS, this.kLz.e("fail: zoom multiple not support", null));
      AppMethodBeat.o(137479);
      return;
    }
    localObject = new HashMap(1);
    ((Map)localObject).put("zoom", Float.valueOf(f));
    this.kxj.h(this.cjS, this.kLz.n("ok", (Map)localObject));
    AppMethodBeat.o(137479);
    return;
    ((f)localObject).bkx();
    AppMethodBeat.o(137479);
    return;
    ((f)localObject).setCompressRecord(this.cjV.optBoolean("compressed"));
    ((f)localObject).bky();
    AppMethodBeat.o(137479);
    return;
    this.cjV.optString("size");
    ((f)localObject).o(this.kxj);
    AppMethodBeat.o(137479);
    return;
    ((f)localObject).bkr();
    this.kxj.h(this.cjS, this.kLz.e("ok", null));
    AppMethodBeat.o(137479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.n.1
 * JD-Core Version:    0.7.0.1
 */