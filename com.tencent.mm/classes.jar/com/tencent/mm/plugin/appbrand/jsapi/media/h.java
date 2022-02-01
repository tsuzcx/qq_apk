package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class h
  extends a
{
  private static final int CTRL_INDEX = 733;
  public static final String NAME = "compressVideo";
  AtomicBoolean jXU;
  
  public h()
  {
    AppMethodBeat.i(46573);
    this.jXU = new AtomicBoolean(false);
    AppMethodBeat.o(46573);
  }
  
  private void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final int paramInt, final r.a parama)
  {
    AppMethodBeat.i(195919);
    this.jXU.compareAndSet(false, true);
    l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46572);
        int i = r.IE(parama.filePath);
        Object localObject1 = h.this;
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
          h.this.jXU.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
          ad.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((m)localObject1).e("fail:compress failed, video type not be supported", null));
          break;
          ad.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((m)localObject1).e("fail:compress failed, video duration error", null));
          break;
          ad.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).h(j, ((m)localObject1).e("fail:file doesn't exist", null));
          break;
        }
        label181:
        localObject1 = r.a(parama);
        if (!com.tencent.mm.vfs.i.eK((String)localObject1))
        {
          ad.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
          paramc.h(paramInt, h.this.e("fail:compress failed, generate path failed", null));
          h.this.jXU.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if ((paramc == null) || (paramc.Ee() == null))
        {
          ad.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
          h.this.jXU.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if (((String)localObject1).equals(parama.filePath))
        {
          ad.e("MicroMsg.JsApiCompressVideo", "file not be compressed, probably video no need to compress or file format not be supported");
          paramc.h(paramInt, h.this.e("fail:compress failed", null));
          h.this.jXU.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject2 = new com.tencent.mm.plugin.appbrand.aa.i();
        paramc.Ee().a(new e((String)localObject1), null, false, (com.tencent.mm.plugin.appbrand.aa.i)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.aa.i)localObject2).value);
        localHashMap.put("size", Long.valueOf(Math.round(com.tencent.mm.vfs.i.aMN((String)localObject1) * 1.0D / 1024.0D)));
        paramc.h(paramInt, h.this.k("ok", localHashMap));
        h.this.jXU.compareAndSet(true, false);
        AppMethodBeat.o(46572);
      }
    });
    AppMethodBeat.o(195919);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46574);
    if (this.jXU.get())
    {
      ad.i("MicroMsg.JsApiCompressVideo", "is compressing now");
      paramc.h(paramInt, e("fail:is compressing now", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramc == null)
    {
      ad.e("MicroMsg.JsApiCompressVideo", "fail:component is null");
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject1 = paramJSONObject.optString("src");
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (!((String)localObject1).startsWith("wxfile://"))
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
      paramc.h(paramInt, e("fail:src path not be supported", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject2 = paramc.Ee();
    if (localObject2 == null)
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
      paramc.h(paramInt, e("fail:internal error", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((p)localObject2).EP((String)localObject1);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = q.B(((e)localObject1).fhU());
    if (!com.tencent.mm.vfs.i.eK((String)localObject1))
    {
      ad.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    if ((!paramJSONObject.has("quality")) && (!paramJSONObject.has("bitrate")) && (!paramJSONObject.has("fps")) && (!paramJSONObject.has("resolution")))
    {
      ad.w("MicroMsg.JsApiCompressVideo", "no quality config");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject.has("quality"))
    {
      ad.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
      paramJSONObject = paramJSONObject.optString("quality");
      ad.i("MicroMsg.JsApiCompressVideo", "quality: %s", new Object[] { paramJSONObject });
      localObject2 = r.IF((String)localObject1);
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
        j = ((r.b)localObject2).width;
        break;
        label521:
        k = ((r.b)localObject2).height;
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
        paramJSONObject = new r.a((String)localObject1, 0, 0, Math.round(j * 0.8F), Math.round(k * 0.8F), Math.round(r.jYO * 2.0F), com.tencent.mm.plugin.sight.base.c.wrc);
        continue;
        paramJSONObject = new r.a((String)localObject1, 0, 0, Math.round(j * 0.5F), Math.round(k * 0.5F), Math.round(r.jYO * 1.5F), com.tencent.mm.plugin.sight.base.c.wrc);
        continue;
        paramJSONObject = new r.a((String)localObject1, 0, 0, Math.round(j * 0.3F), Math.round(k * 0.3F), r.jYO, com.tencent.mm.plugin.sight.base.c.wrc);
      }
    }
    ad.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
    float f1 = (float)paramJSONObject.optDouble("resolution", 1.0D);
    if ((f1 > 0.0F) && (f1 <= 1.0F)) {}
    for (f1 = Math.round(f1 * 10.0F) * 1.0F / 10.0F;; f1 = 1.0F)
    {
      localObject2 = r.IF((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      ad.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
      paramc.h(paramInt, e("fail:can't get info from video file", null));
      AppMethodBeat.o(46574);
      return;
    }
    int j = Math.round(((r.b)localObject2).width * f1);
    int k = Math.round(((r.b)localObject2).height * f1);
    int i = paramJSONObject.optInt("bitrate", Math.round(r.jYO * 1.0F / 1000.0F)) * 1000;
    float f2;
    if ((i > 0) && (i < ((r.b)localObject2).bitrate))
    {
      f2 = (float)paramJSONObject.optDouble("fps", com.tencent.mm.plugin.sight.base.c.wrc);
      if ((f2 < 1.0F) || (f2 > ((r.b)localObject2).coh)) {
        break label985;
      }
      label896:
      ad.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
      if ((j != 0) && (k != 0)) {
        break label993;
      }
    }
    label985:
    label993:
    for (paramJSONObject = new r.a((String)localObject1, 720, 540, 0, 0, i, f2);; paramJSONObject = new r.a((String)localObject1, 0, 0, j, k, i, f2))
    {
      a(paramc, paramInt, paramJSONObject);
      AppMethodBeat.o(46574);
      return;
      i = r.jYO;
      break;
      f2 = com.tencent.mm.plugin.sight.base.c.wrc;
      break label896;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */