package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "parseFileName", "filePath", "fileExt", "fileName", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class dm
{
  public static final String I(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(325915);
    s.u(paramString1, "filePath");
    CharSequence localCharSequence = (CharSequence)paramString3;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.AppBrand.SendVideoCommons", s.X("parseFileName, fileName: ", paramString3));
      AppMethodBeat.o(325915);
      return paramString3;
    }
    paramString3 = new u(paramString1).getName();
    paramString1 = (CharSequence)paramString2;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      label93:
      if (i != 0) {
        break label118;
      }
    }
    label118:
    for (paramString1 = s.X(".", paramString2);; paramString1 = "")
    {
      paramString3 = s.X(paramString3, paramString1);
      break;
      i = 0;
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dm
 * JD-Core Version:    0.7.0.1
 */