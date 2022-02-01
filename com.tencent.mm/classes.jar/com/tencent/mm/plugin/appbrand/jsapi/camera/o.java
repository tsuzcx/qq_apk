package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  Runnable rQC;
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137480);
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null or nil"));
      AppMethodBeat.o(137480);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137479);
        int i = paramJSONObject.optInt("cameraId");
        String str = paramJSONObject.optString("type");
        boolean bool = paramJSONObject.optBoolean("selfieMirror", true);
        Log.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
        Object localObject = a.a.cry();
        if (((a)localObject).rPn.indexOfKey(i) >= 0)
        {
          localObject = (WeakReference)((a)localObject).rPn.get(i);
          if (localObject != null) {
            localObject = (f)((WeakReference)localObject).get();
          }
        }
        while (localObject == null)
        {
          paramf.callback(paramInt, o.this.ZP("fail:no such camera"));
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
              o.1.this.qwp.callback(o.1.this.elZ, o.this.m("ok", paramAnonymous2String2));
              AppMethodBeat.o(137475);
              return;
            }
            o.1.this.qwp.callback(o.1.this.elZ, o.this.ZP("fail:".concat(String.valueOf(paramAnonymous2String2))));
            AppMethodBeat.o(137475);
          }
          
          public final void a(int paramAnonymous2Int1, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, int paramAnonymous2Int2, long paramAnonymous2Long, int paramAnonymous2Int3, int paramAnonymous2Int4)
          {
            AppMethodBeat.i(137477);
            Log.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", new Object[] { Integer.valueOf(paramAnonymous2Int1), paramAnonymous2String2, paramAnonymous2String3, Integer.valueOf(paramAnonymous2Int2), Long.valueOf(paramAnonymous2Long), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
            if (paramAnonymous2Int1 == 0)
            {
              paramAnonymous2String1 = new HashMap();
              paramAnonymous2String1.put("tempThumbPath", paramAnonymous2String2);
              paramAnonymous2String1.put("tempVideoPath", paramAnonymous2String3);
              paramAnonymous2String1.put("duration", Integer.valueOf(paramAnonymous2Int2));
              paramAnonymous2String1.put("size", Long.valueOf(paramAnonymous2Long));
              paramAnonymous2String1.put("height", Integer.valueOf(paramAnonymous2Int4));
              paramAnonymous2String1.put("width", Integer.valueOf(paramAnonymous2Int3));
              o.1.this.qwp.callback(o.1.this.elZ, o.this.m("ok", paramAnonymous2String1));
              AppMethodBeat.o(137477);
              return;
            }
            o.1.this.qwp.callback(o.1.this.elZ, o.this.ZP("fail:".concat(String.valueOf(paramAnonymous2String1))));
            AppMethodBeat.o(137477);
          }
          
          public final void av(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(137476);
            if (paramAnonymous2Int == 0)
            {
              o.1.this.qwp.callback(o.1.this.elZ, o.this.ZP("ok"));
              AppMethodBeat.o(137476);
              return;
            }
            o.1.this.qwp.callback(o.1.this.elZ, o.this.ZP("fail:".concat(String.valueOf(paramAnonymous2String))));
            AppMethodBeat.o(137476);
          }
          
          public final void i(String paramAnonymous2String, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(137478);
            if (!Util.isNullOrNil(paramAnonymous2String))
            {
              o.1.this.qwp.callback(o.1.this.elZ, o.this.ZP("fail:".concat(String.valueOf(paramAnonymous2String))));
              AppMethodBeat.o(137478);
              return;
            }
            Log.d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
            paramAnonymous2String = new HashMap();
            paramAnonymous2String.put("bufferId", Integer.valueOf(paramAnonymous2Int1));
            paramAnonymous2String.put("width", Integer.valueOf(paramAnonymous2Int2));
            paramAnonymous2String.put("height", Integer.valueOf(paramAnonymous2Int3));
            o.1.this.qwp.callback(o.1.this.elZ, o.this.m("ok", paramAnonymous2String));
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
            Log.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
            paramf.callback(paramInt, o.this.ZP("fail:operateType not supported"));
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
        ((f)localObject).jl(bool);
        AppMethodBeat.o(137479);
        return;
        float f = ((f)localObject).bH((float)paramJSONObject.optDouble("zoom"));
        if (f < 1.0F)
        {
          paramf.callback(paramInt, o.this.ZP("fail: zoom multiple not support"));
          AppMethodBeat.o(137479);
          return;
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("zoom", Float.valueOf(f));
        paramf.callback(paramInt, o.this.m("ok", (Map)localObject));
        AppMethodBeat.o(137479);
        return;
        if (!o.a(o.this, paramf, paramJSONObject, paramInt))
        {
          AppMethodBeat.o(137479);
          return;
        }
        ((f)localObject).jm(bool);
        if (o.this.rQC != null)
        {
          Log.i("MicroMsg.JsApiOperateCamera", "found stop record runnable");
          o.this.rQC.run();
          o.this.rQC = null;
          AppMethodBeat.o(137479);
          return;
          o.this.rQC = new o.1..ExternalSyntheticLambda0(paramJSONObject, (f)localObject);
          if (!a.a.cry().rPm)
          {
            Log.i("MicroMsg.JsApiOperateCamera", "stop record immediately");
            o.this.rQC.run();
            o.this.rQC = null;
            AppMethodBeat.o(137479);
            return;
          }
          Log.i("MicroMsg.JsApiOperateCamera", "stop record, bug is requesting microphone permission");
          AppMethodBeat.o(137479);
          return;
          paramJSONObject.optString("size");
          ((f)localObject).s(paramf);
          AppMethodBeat.o(137479);
          return;
          ((f)localObject).crC();
          paramf.callback(paramInt, o.this.ZP("ok"));
          AppMethodBeat.o(137479);
          return;
        }
        AppMethodBeat.o(137479);
      }
    });
    AppMethodBeat.o(137480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.o
 * JD-Core Version:    0.7.0.1
 */