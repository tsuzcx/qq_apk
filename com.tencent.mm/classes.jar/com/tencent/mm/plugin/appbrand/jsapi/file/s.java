package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class s
  extends d
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128879);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(128879);
      return;
    }
    e.lUJ.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128878);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128878);
          return;
        }
        o localo = paramf.getFileSystem().VY(paramJSONObject);
        if (localo == null)
        {
          paramf.i(paramInt, s.this.h(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { paramJSONObject }), null));
          AppMethodBeat.o(128878);
          return;
        }
        HashMap localHashMap = new HashMap(3);
        localHashMap.put("size", Long.valueOf(localo.length()));
        localHashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(localo.lastModified())));
        paramf.i(paramInt, s.this.n("ok", localHashMap));
        AppMethodBeat.o(128878);
      }
    });
    AppMethodBeat.o(128879);
  }
  
  public final boolean bEa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.s
 * JD-Core Version:    0.7.0.1
 */