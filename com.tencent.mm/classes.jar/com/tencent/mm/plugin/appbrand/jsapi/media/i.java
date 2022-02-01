package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends a
{
  private static final int CTRL_INDEX = 733;
  public static final String NAME = "compressVideo";
  AtomicBoolean kYy;
  
  public i()
  {
    AppMethodBeat.i(46573);
    this.kYy = new AtomicBoolean(false);
    AppMethodBeat.o(46573);
  }
  
  private void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final int paramInt, final t.a parama)
  {
    AppMethodBeat.i(222601);
    this.kYy.compareAndSet(false, true);
    com.tencent.mm.plugin.appbrand.y.m.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46572);
        int i = t.QM(parama.filePath);
        Object localObject1 = i.this;
        Object localObject2 = paramc;
        int j = paramInt;
        switch (i)
        {
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label181;
          }
          i.this.kYy.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
          ae.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((com.tencent.mm.plugin.appbrand.jsapi.m)localObject1).e("fail:compress failed, video type not be supported", null));
          break;
          ae.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((com.tencent.mm.plugin.appbrand.jsapi.m)localObject1).e("fail:compress failed, video duration error", null));
          break;
          ae.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((com.tencent.mm.plugin.appbrand.jsapi.m)localObject1).e("fail:file doesn't exist", null));
          break;
        }
        label181:
        localObject1 = t.a(parama);
        if (!o.fB((String)localObject1))
        {
          ae.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
          paramc.h(paramInt, i.this.e("fail:compress failed, generate path failed", null));
          i.this.kYy.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if ((paramc == null) || (paramc.Fl() == null))
        {
          ae.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
          i.this.kYy.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if (((String)localObject1).equals(parama.filePath))
        {
          ae.e("MicroMsg.JsApiCompressVideo", "file not be compressed, probably video no need to compress or file format not be supported");
          paramc.h(paramInt, i.this.e("fail:compress failed", null));
          i.this.kYy.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject2 = new com.tencent.mm.plugin.appbrand.y.i();
        paramc.Fl().a(new k((String)localObject1), null, false, (com.tencent.mm.plugin.appbrand.y.i)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.y.i)localObject2).value);
        localHashMap.put("size", Long.valueOf(Math.round(o.aZR((String)localObject1) * 1.0D / 1024.0D)));
        paramc.h(paramInt, i.this.n("ok", localHashMap));
        i.this.kYy.compareAndSet(true, false);
        AppMethodBeat.o(46572);
      }
    });
    AppMethodBeat.o(222601);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46574);
    if (this.kYy.get())
    {
      ae.i("MicroMsg.JsApiCompressVideo", "is compressing now");
      paramc.h(paramInt, e("fail:is compressing now", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramc == null)
    {
      ae.e("MicroMsg.JsApiCompressVideo", "fail:component is null");
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject1 = paramJSONObject.optString("src");
    if (bu.isNullOrNil((String)localObject1))
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (!((String)localObject1).startsWith("wxfile://"))
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
      paramc.h(paramInt, e("fail:src path not be supported", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject2 = paramc.Fl();
    if (localObject2 == null)
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
      paramc.h(paramInt, e("fail:internal error", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((q)localObject2).MP((String)localObject1);
    if (localObject1 == null)
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = w.B(((k)localObject1).fTh());
    if (!o.fB((String)localObject1))
    {
      ae.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    if ((!paramJSONObject.has("quality")) && (!paramJSONObject.has("bitrate")) && (!paramJSONObject.has("fps")) && (!paramJSONObject.has("resolution")))
    {
      ae.w("MicroMsg.JsApiCompressVideo", "no quality config");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject.has("quality"))
    {
      ae.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
      paramJSONObject = paramJSONObject.optString("quality");
      ae.i("MicroMsg.JsApiCompressVideo", "quality: %s", new Object[] { paramJSONObject });
      localObject2 = t.QN((String)localObject1);
      if (localObject2 == null)
      {
        j = 720;
        if (localObject2 != null) {
          break label521;
        }
        k = 540;
        label426:
        i = -1;
        switch (paramJSONObject.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            label468:
            paramJSONObject = null;
          }
          break;
        }
      }
      for (;;)
      {
        a(paramc, paramInt, paramJSONObject);
        AppMethodBeat.o(46574);
        return;
        j = ((t.b)localObject2).width;
        break;
        label521:
        k = ((t.b)localObject2).height;
        break label426;
        if (!paramJSONObject.equals("high")) {
          break label468;
        }
        i = 0;
        break label468;
        if (!paramJSONObject.equals("medium")) {
          break label468;
        }
        i = 1;
        break label468;
        if (!paramJSONObject.equals("low")) {
          break label468;
        }
        i = 2;
        break label468;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.8F), Math.round(k * 0.8F), Math.round(t.kZt * 2.0F), com.tencent.mm.plugin.sight.base.c.zhn);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.5F), Math.round(k * 0.5F), Math.round(t.kZt * 1.5F), com.tencent.mm.plugin.sight.base.c.zhn);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.3F), Math.round(k * 0.3F), t.kZt, com.tencent.mm.plugin.sight.base.c.zhn);
      }
    }
    ae.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
    float f1 = (float)paramJSONObject.optDouble("resolution", 1.0D);
    if ((f1 > 0.0F) && (f1 <= 1.0F)) {}
    for (f1 = Math.round(f1 * 10.0F) * 1.0F / 10.0F;; f1 = 1.0F)
    {
      localObject2 = t.QN((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      ae.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
      paramc.h(paramInt, e("fail:can't get info from video file", null));
      AppMethodBeat.o(46574);
      return;
    }
    int j = Math.round(((t.b)localObject2).width * f1);
    int k = Math.round(((t.b)localObject2).height * f1);
    int i = paramJSONObject.optInt("bitrate", Math.round(t.kZt * 1.0F / 1000.0F)) * 1000;
    float f2;
    if ((i > 0) && (i < ((t.b)localObject2).bitrate))
    {
      f2 = (float)paramJSONObject.optDouble("fps", com.tencent.mm.plugin.sight.base.c.zhn);
      if ((f2 < 1.0F) || (f2 > ((t.b)localObject2).cwp)) {
        break label985;
      }
      label896:
      ae.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
      if ((j != 0) && (k != 0)) {
        break label993;
      }
    }
    label985:
    label993:
    for (paramJSONObject = new t.a((String)localObject1, 720, 540, 0, 0, i, f2);; paramJSONObject = new t.a((String)localObject1, 0, 0, j, k, i, f2))
    {
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(46574);
      return;
      i = t.kZt;
      break;
      f2 = com.tencent.mm.plugin.sight.base.c.zhn;
      break label896;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i
 * JD-Core Version:    0.7.0.1
 */