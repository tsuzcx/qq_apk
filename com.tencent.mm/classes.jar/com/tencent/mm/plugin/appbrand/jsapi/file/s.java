package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128879);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil(paramJSONObject))
    {
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(128879);
      return;
    }
    e.oRI.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128878);
        if (!parame.isRunning())
        {
          AppMethodBeat.o(128878);
          return;
        }
        q localq = parame.getFileSystem().adL(paramJSONObject);
        if (localq == null)
        {
          parame.j(paramInt, s.this.h(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { paramJSONObject }), null));
          AppMethodBeat.o(128878);
          return;
        }
        HashMap localHashMap = new HashMap(3);
        localHashMap.put("size", Long.valueOf(localq.length()));
        localHashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(localq.lastModified())));
        parame.j(paramInt, s.this.m("ok", localHashMap));
        AppMethodBeat.o(128878);
      }
    });
    AppMethodBeat.o(128879);
  }
  
  public final boolean bPy()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.s
 * JD-Core Version:    0.7.0.1
 */