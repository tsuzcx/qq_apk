package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 733;
  public static final String NAME = "compressVideo";
  AtomicBoolean sgL;
  
  public i()
  {
    AppMethodBeat.i(46573);
    this.sgL = new AtomicBoolean(false);
    AppMethodBeat.o(46573);
  }
  
  private void a(final f paramf, final int paramInt, final u.a parama)
  {
    AppMethodBeat.i(329282);
    this.sgL.compareAndSet(false, true);
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46572);
        int j = u.abc(parama.filePath);
        Object localObject1 = i.this;
        Object localObject2 = paramf;
        int i = paramInt;
        switch (j)
        {
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label186;
          }
          i.this.sgL.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file type not be supported");
          ((f)localObject2).callback(i, ((i)localObject1).ZP("fail:compress failed, video type not be supported"));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, video duration error");
          ((f)localObject2).callback(i, ((i)localObject1).ZP("fail:compress failed, video duration error"));
          break;
          Log.i("MicroMsg.JsApiCompressVideo", "fail:compress failed, file not exist");
          ((f)localObject2).callback(i, ((i)localObject1).ZP("fail:file doesn't exist"));
          break;
        }
        label186:
        if ((paramf == null) || (paramf.getFileSystem() == null))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "component or file system is null");
          i.this.sgL.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        if (j == 2)
        {
          Log.e("MicroMsg.JsApiCompressVideo", "file not be compressed, cuz unnecessary");
          localObject1 = new k();
          paramf.getFileSystem().a(new com.tencent.mm.vfs.u(parama.filePath), "mp4", false, (k)localObject1);
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("tempFilePath", ((k)localObject1).value);
          ((HashMap)localObject2).put("size", Long.valueOf(Math.round(y.bEl(parama.filePath) * 1.0D / 1024.0D)));
          paramf.callback(paramInt, i.this.m("ok", (Map)localObject2));
          i.this.sgL.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject1 = u.a(parama);
        if (!y.ZC((String)localObject1))
        {
          Log.i("MicroMsg.JsApiCompressVideo", "compressed file not exist");
          paramf.callback(paramInt, i.this.ZP("fail:compress failed, generate path failed"));
          i.this.sgL.compareAndSet(true, false);
          AppMethodBeat.o(46572);
          return;
        }
        localObject2 = new k();
        paramf.getFileSystem().a(new com.tencent.mm.vfs.u((String)localObject1), null, false, (k)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((k)localObject2).value);
        localHashMap.put("size", Long.valueOf(Math.round(y.bEl((String)localObject1) * 1.0D / 1024.0D)));
        paramf.callback(paramInt, i.this.m("ok", localHashMap));
        i.this.sgL.compareAndSet(true, false);
        AppMethodBeat.o(46572);
      }
    });
    AppMethodBeat.o(329282);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46574);
    if (this.sgL.get())
    {
      Log.i("MicroMsg.JsApiCompressVideo", "is compressing now");
      paramf.callback(paramInt, ZP("fail:is compressing now"));
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
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject1 = paramJSONObject.optString("src");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:data src is empty");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46574);
      return;
    }
    if (!((String)localObject1).startsWith("wxfile://"))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:src path not supported");
      paramf.callback(paramInt, ZP("fail:src path not be supported"));
      AppMethodBeat.o(46574);
      return;
    }
    Object localObject2 = paramf.getFileSystem();
    if (localObject2 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:runtime fileSystem is null");
      paramf.callback(paramInt, ZP("fail:internal error"));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ((w)localObject2).Wm((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:srcFile is null");
      paramf.callback(paramInt, ZP("fail:file doesn't exist"));
      AppMethodBeat.o(46574);
      return;
    }
    localObject1 = ah.v(((com.tencent.mm.vfs.u)localObject1).jKT());
    if (!y.ZC((String)localObject1))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "fail:filePath is null or without exist file");
      paramf.callback(paramInt, ZP("fail:file doesn't exist"));
      AppMethodBeat.o(46574);
      return;
    }
    if ((!paramJSONObject.has("quality")) && (!paramJSONObject.has("bitrate")) && (!paramJSONObject.has("fps")) && (!paramJSONObject.has("resolution")))
    {
      Log.w("MicroMsg.JsApiCompressVideo", "no quality config");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46574);
      return;
    }
    if (paramJSONObject.has("quality"))
    {
      Log.i("MicroMsg.JsApiCompressVideo", "compress with quality config");
      paramJSONObject = paramJSONObject.optString("quality");
      Log.i("MicroMsg.JsApiCompressVideo", "quality: %s", new Object[] { paramJSONObject });
      localObject2 = u.abd((String)localObject1);
      if (localObject2 == null)
      {
        j = 720;
        if (localObject2 != null) {
          break label513;
        }
        k = 540;
        label418:
        i = -1;
        switch (paramJSONObject.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            label460:
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
        j = ((u.b)localObject2).width;
        break;
        label513:
        k = ((u.b)localObject2).height;
        break label418;
        if (!paramJSONObject.equals("high")) {
          break label460;
        }
        i = 0;
        break label460;
        if (!paramJSONObject.equals("medium")) {
          break label460;
        }
        i = 1;
        break label460;
        if (!paramJSONObject.equals("low")) {
          break label460;
        }
        i = 2;
        break label460;
        paramJSONObject = new u.a((String)localObject1, 0, 0, Math.round(j * 0.8F), Math.round(k * 0.8F), Math.round(u.shM * 2.0F), d.PFl);
        continue;
        paramJSONObject = new u.a((String)localObject1, 0, 0, Math.round(j * 0.5F), Math.round(k * 0.5F), Math.round(u.shM * 1.5F), d.PFl);
        continue;
        paramJSONObject = new u.a((String)localObject1, 0, 0, Math.round(j * 0.3F), Math.round(k * 0.3F), u.shM, d.PFl);
      }
    }
    Log.i("MicroMsg.JsApiCompressVideo", "compress with advance config");
    float f1 = (float)paramJSONObject.optDouble("resolution", 1.0D);
    if ((f1 > 0.0F) && (f1 <= 1.0F)) {}
    for (f1 = Math.round(f1 * 10.0F) * 1.0F / 10.0F;; f1 = 1.0F)
    {
      localObject2 = u.abd((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      Log.w("MicroMsg.JsApiCompressVideo", "fail:videoInfo is null");
      paramf.callback(paramInt, ZP("fail:can't get info from video file"));
      AppMethodBeat.o(46574);
      return;
    }
    int j = Math.round(((u.b)localObject2).width * f1);
    int k = Math.round(((u.b)localObject2).height * f1);
    int i = paramJSONObject.optInt("bitrate", Math.round(u.shM * 1.0F / 1000.0F)) * 1000;
    float f2;
    if ((i > 0) && (i < ((u.b)localObject2).bitrate))
    {
      f2 = (float)paramJSONObject.optDouble("fps", d.PFl);
      if ((f2 < 1.0F) || (f2 > ((u.b)localObject2).eGw)) {
        break label976;
      }
      label887:
      Log.i("MicroMsg.JsApiCompressVideo", "ratio: %f, bitrate: %d, fps: %f", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
      if ((j != 0) && (k != 0)) {
        break label984;
      }
    }
    label976:
    label984:
    for (paramJSONObject = new u.a((String)localObject1, 720, 540, 0, 0, i, f2);; paramJSONObject = new u.a((String)localObject1, 0, 0, j, k, i, f2))
    {
      a(paramf, paramInt, paramJSONObject);
      AppMethodBeat.o(46574);
      return;
      i = u.shM;
      break;
      f2 = d.PFl;
      break label887;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i
 * JD-Core Version:    0.7.0.1
 */