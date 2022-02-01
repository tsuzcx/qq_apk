package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class s
  extends a
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128879);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bu.isNullOrNil(paramJSONObject))
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(128879);
      return;
    }
    e.kPL.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128878);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128878);
          return;
        }
        k localk = paramc.Fl().MP(paramJSONObject);
        if (localk == null)
        {
          paramc.h(paramInt, s.this.e(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { paramJSONObject }), null));
          AppMethodBeat.o(128878);
          return;
        }
        HashMap localHashMap = new HashMap(3);
        localHashMap.put("size", Long.valueOf(localk.length()));
        localHashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(localk.lastModified())));
        paramc.h(paramInt, s.this.n("ok", localHashMap));
        AppMethodBeat.o(128878);
      }
    });
    AppMethodBeat.o(128879);
  }
  
  public final boolean biK()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.s
 * JD-Core Version:    0.7.0.1
 */