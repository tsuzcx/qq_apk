package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class s
  extends c
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128879);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(128879);
      return;
    }
    e.rXi.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128878);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128878);
          return;
        }
        u localu = paramf.getFileSystem().Wm(paramJSONObject);
        if (localu == null)
        {
          paramf.callback(paramInt, s.this.ZP(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { paramJSONObject })));
          AppMethodBeat.o(128878);
          return;
        }
        HashMap localHashMap = new HashMap(3);
        localHashMap.put("size", Long.valueOf(localu.length()));
        localHashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(localu.lastModified())));
        paramf.callback(paramInt, s.this.m("ok", localHashMap));
        AppMethodBeat.o(128878);
      }
    });
    AppMethodBeat.o(128879);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.s
 * JD-Core Version:    0.7.0.1
 */