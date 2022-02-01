package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends d
{
  private static final int CTRL_INDEX = 733;
  public static final String NAME = "compressVideo";
  AtomicBoolean mdI;
  
  public i()
  {
    AppMethodBeat.i(46573);
    this.mdI = new AtomicBoolean(false);
    AppMethodBeat.o(46573);
  }
  
  private void a(final f paramf, final int paramInt, final t.a parama)
  {
    AppMethodBeat.i(226903);
    this.mdI.compareAndSet(false, true);
    m.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46572);
        int i = t.aan(parama.filePath);
        Object localObject1 = i.this;
        Object localObject2 = paramf;
        int j = paramInt;
        switch (i)
        {
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label181;
          }
          i.this.mdI.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
          ((f)localObject2).i(j, ((p)localObject1).h("fail:compress failed, video type not be supported", null));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
          ((f)localObject2).i(j, ((p)localObject1).h("fail:compress failed, video duration error", null));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
          ((f)localObject2).i(j, ((p)localObject1).h("fail:file doesn't exist", null));
          break;
        }
        label181:
        localObject1 = t.a(parama);
        if (!s.YS((String)localObject1))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
          paramf.i(paramInt, i.this.h("fail:compress failed, generate path failed", null));
          i.this.mdI.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if ((paramf == null) || (paramf.getFileSystem() == null))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
          i.this.mdI.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if (((String)localObject1).equals(parama.filePath))
        {
          Log.e("MicroMsg.JsApiCompressVideo", "file not be compressed, probably video no need to compress or file format not be supported");
          paramf.i(paramInt, i.this.h("fail:compress failed", null));
          i.this.mdI.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
        paramf.getFileSystem().a(new o((String)localObject1), null, false, (com.tencent.mm.plugin.appbrand.ac.i)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value);
        localHashMap.put("size", Long.valueOf(Math.round(s.boW((String)localObject1) * 1.0D / 1024.0D)));
        paramf.i(paramInt, i.this.n("ok", localHashMap));
        i.this.mdI.compareAndSet(true, false);
        AppMethodBeat.o(46572);
      }
    });
    AppMethodBeat.o(226903);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46574);
    if (this.mdI.get())
    {
      Log.i("MicroMsg.JsApiCompressVideo", "is compressing now");
      paramf.i(paramInt, h("fail:is compressing now", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiCompressVideo", "fail:component is null");
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject1 = paramJSONObject.optString("src");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (!((String)localObject1).startsWith("wxfile://"))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
      paramf.i(paramInt, h("fail:src path not be supported", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject2 = paramf.getFileSystem();
    if (localObject2 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
      paramf.i(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((q)localObject2).VY((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
      paramf.i(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = aa.z(((o)localObject1).her());
    if (!s.YS((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
      paramf.i(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    if ((!paramJSONObject.has("quality")) && (!paramJSONObject.has("bitrate")) && (!paramJSONObject.has("fps")) && (!paramJSONObject.has("resolution")))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "no quality config");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject.has("quality"))
    {
      Log.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
      paramJSONObject = paramJSONObject.optString("quality");
      Log.i("MicroMsg.JsApiCompressVideo", "quality: %s", new Object[] { paramJSONObject });
      localObject2 = t.aao((String)localObject1);
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
        a(paramf, paramInt, paramJSONObject);
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
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.8F), Math.round(k * 0.8F), Math.round(t.meG * 2.0F), c.Dme);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.5F), Math.round(k * 0.5F), Math.round(t.meG * 1.5F), c.Dme);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.3F), Math.round(k * 0.3F), t.meG, c.Dme);
      }
    }
    Log.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
    float f1 = (float)paramJSONObject.optDouble("resolution", 1.0D);
    if ((f1 > 0.0F) && (f1 <= 1.0F)) {}
    for (f1 = Math.round(f1 * 10.0F) * 1.0F / 10.0F;; f1 = 1.0F)
    {
      localObject2 = t.aao((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      Log.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
      paramf.i(paramInt, h("fail:can't get info from video file", null));
      AppMethodBeat.o(46574);
      return;
    }
    int j = Math.round(((t.b)localObject2).width * f1);
    int k = Math.round(((t.b)localObject2).height * f1);
    int i = paramJSONObject.optInt("bitrate", Math.round(t.meG * 1.0F / 1000.0F)) * 1000;
    float f2;
    if ((i > 0) && (i < ((t.b)localObject2).bitrate))
    {
      f2 = (float)paramJSONObject.optDouble("fps", c.Dme);
      if ((f2 < 1.0F) || (f2 > ((t.b)localObject2).cKu)) {
        break label985;
      }
      label896:
      Log.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
      if ((j != 0) && (k != 0)) {
        break label993;
      }
    }
    label985:
    label993:
    for (paramJSONObject = new t.a((String)localObject1, 720, 540, 0, 0, i, f2);; paramJSONObject = new t.a((String)localObject1, 0, 0, j, k, i, f2))
    {
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(46574);
      return;
      i = t.meG;
      break;
      f2 = c.Dme;
      break label896;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i
 * JD-Core Version:    0.7.0.1
 */