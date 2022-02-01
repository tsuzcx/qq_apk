package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 733;
  public static final String NAME = "compressVideo";
  AtomicBoolean pbA;
  
  public i()
  {
    AppMethodBeat.i(46573);
    this.pbA = new AtomicBoolean(false);
    AppMethodBeat.o(46573);
  }
  
  private void a(final e parame, final int paramInt, final t.a parama)
  {
    AppMethodBeat.i(275118);
    this.pbA.compareAndSet(false, true);
    m.clV().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46572);
        int j = t.aie(parama.filePath);
        Object localObject1 = i.this;
        Object localObject2 = parame;
        int i = paramInt;
        switch (j)
        {
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label189;
          }
          i.this.pbA.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
          ((e)localObject2).j(i, ((o)localObject1).h("fail:compress failed, video type not be supported", null));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
          ((e)localObject2).j(i, ((o)localObject1).h("fail:compress failed, video duration error", null));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
          ((e)localObject2).j(i, ((o)localObject1).h("fail:file doesn't exist", null));
          break;
        }
        label189:
        if ((parame == null) || (parame.getFileSystem() == null))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
          i.this.pbA.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if (j == 2)
        {
          Log.e("MicroMsg.JsApiCompressVideo", "file not be compressed, cuz unnecessary");
          localObject1 = new com.tencent.mm.plugin.appbrand.ac.i();
          parame.getFileSystem().a(new q(parama.filePath), "mp4", false, (com.tencent.mm.plugin.appbrand.ac.i)localObject1);
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("tempFilePath", ((com.tencent.mm.plugin.appbrand.ac.i)localObject1).value);
          ((HashMap)localObject2).put("size", Long.valueOf(Math.round(u.bBQ(parama.filePath) * 1.0D / 1024.0D)));
          parame.j(paramInt, i.this.m("ok", (Map)localObject2));
          i.this.pbA.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject1 = t.a(parama);
        if (!u.agG((String)localObject1))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
          parame.j(paramInt, i.this.h("fail:compress failed, generate path failed", null));
          i.this.pbA.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
        parame.getFileSystem().a(new q((String)localObject1), null, false, (com.tencent.mm.plugin.appbrand.ac.i)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value);
        localHashMap.put("size", Long.valueOf(Math.round(u.bBQ((String)localObject1) * 1.0D / 1024.0D)));
        parame.j(paramInt, i.this.m("ok", localHashMap));
        i.this.pbA.compareAndSet(true, false);
        AppMethodBeat.o(46572);
      }
    });
    AppMethodBeat.o(275118);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46574);
    if (this.pbA.get())
    {
      Log.i("MicroMsg.JsApiCompressVideo", "is compressing now");
      parame.j(paramInt, h("fail:is compressing now", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiCompressVideo", "fail:component is null");
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject1 = paramJSONObject.optString("src");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (!((String)localObject1).startsWith("wxfile://"))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
      parame.j(paramInt, h("fail:src path not be supported", null));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject2 = parame.getFileSystem();
    if (localObject2 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
      parame.j(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((r)localObject2).adL((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
      parame.j(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((q)localObject1).bOF();
    if (!u.agG((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
      parame.j(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46574);
      return;
    }
    if ((!paramJSONObject.has("quality")) && (!paramJSONObject.has("bitrate")) && (!paramJSONObject.has("fps")) && (!paramJSONObject.has("resolution")))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "no quality config");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject.has("quality"))
    {
      Log.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
      paramJSONObject = paramJSONObject.optString("quality");
      Log.i("MicroMsg.JsApiCompressVideo", "quality: %s", new Object[] { paramJSONObject });
      localObject2 = t.aif((String)localObject1);
      if (localObject2 == null)
      {
        j = 720;
        if (localObject2 != null) {
          break label517;
        }
        k = 540;
        label423:
        i = -1;
        switch (paramJSONObject.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            label464:
            paramJSONObject = null;
          }
          break;
        }
      }
      for (;;)
      {
        a(parame, paramInt, paramJSONObject);
        AppMethodBeat.o(46574);
        return;
        j = ((t.b)localObject2).width;
        break;
        label517:
        k = ((t.b)localObject2).height;
        break label423;
        if (!paramJSONObject.equals("high")) {
          break label464;
        }
        i = 0;
        break label464;
        if (!paramJSONObject.equals("medium")) {
          break label464;
        }
        i = 1;
        break label464;
        if (!paramJSONObject.equals("low")) {
          break label464;
        }
        i = 2;
        break label464;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.8F), Math.round(k * 0.8F), Math.round(t.pcy * 2.0F), d.JrJ);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.5F), Math.round(k * 0.5F), Math.round(t.pcy * 1.5F), d.JrJ);
        continue;
        paramJSONObject = new t.a((String)localObject1, 0, 0, Math.round(j * 0.3F), Math.round(k * 0.3F), t.pcy, d.JrJ);
      }
    }
    Log.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
    float f1 = (float)paramJSONObject.optDouble("resolution", 1.0D);
    if ((f1 > 0.0F) && (f1 <= 1.0F)) {}
    for (f1 = Math.round(f1 * 10.0F) * 1.0F / 10.0F;; f1 = 1.0F)
    {
      localObject2 = t.aif((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      Log.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
      parame.j(paramInt, h("fail:can't get info from video file", null));
      AppMethodBeat.o(46574);
      return;
    }
    int j = Math.round(((t.b)localObject2).width * f1);
    int k = Math.round(((t.b)localObject2).height * f1);
    int i = paramJSONObject.optInt("bitrate", Math.round(t.pcy * 1.0F / 1000.0F)) * 1000;
    float f2;
    if ((i > 0) && (i < ((t.b)localObject2).bitrate))
    {
      f2 = (float)paramJSONObject.optDouble("fps", d.JrJ);
      if ((f2 < 1.0F) || (f2 > ((t.b)localObject2).cLa)) {
        break label981;
      }
      label892:
      Log.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
      if ((j != 0) && (k != 0)) {
        break label989;
      }
    }
    label981:
    label989:
    for (paramJSONObject = new t.a((String)localObject1, 720, 540, 0, 0, i, f2);; paramJSONObject = new t.a((String)localObject1, 0, 0, j, k, i, f2))
    {
      a(parame, paramInt, paramJSONObject);
      AppMethodBeat.o(46574);
      return;
      i = t.pcy;
      break;
      f2 = d.JrJ;
      break label892;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i
 * JD-Core Version:    0.7.0.1
 */