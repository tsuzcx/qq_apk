package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "parseFileName", "filePath", "fileExt", "fileName", "plugin-appbrand-integration_release"})
public final class db
{
  public static final String D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228298);
    p.h(paramString1, "filePath");
    CharSequence localCharSequence = (CharSequence)paramString3;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.AppBrand.SendVideoCommons", "parseFileName, fileName: ".concat(String.valueOf(paramString3)));
      AppMethodBeat.o(228298);
      return paramString3;
    }
    paramString3 = new StringBuilder().append(new o(paramString1).getName());
    paramString1 = (CharSequence)paramString2;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      label106:
      if (i != 0) {
        break label137;
      }
    }
    label137:
    for (paramString1 = ".".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      paramString3 = paramString1;
      break;
      i = 0;
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.db
 * JD-Core Version:    0.7.0.1
 */