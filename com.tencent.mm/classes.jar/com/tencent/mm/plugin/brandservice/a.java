package com.tencent.mm.plugin.brandservice;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String jSr = "//biz";
  public static final a.a jSs;
  
  static
  {
    AppMethodBeat.i(14761);
    jSs = new a.a((byte)0);
    jSr = "//biz";
    AppMethodBeat.o(14761);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(14760);
    if ((paramArrayOfString != null) && (j.e(jSr, paramArrayOfString[0])))
    {
      if ((j.e("openbiztimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = as.eu("brandService", 1);
        paramContext.encode("BizTimeLineOpenStatus", bo.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(14760);
        return true;
      }
      if ((j.e("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = as.eu("brandService", 1);
        paramContext.encode("BizTimeLineDeleteOldData", bo.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(14760);
        return true;
      }
      if ((j.e("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = as.eu("brandService", 1);
        paramContext.encode("BizTimeLineShowDigest", bo.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(14760);
        return true;
      }
    }
    AppMethodBeat.o(14760);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */