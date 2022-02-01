package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.iu;
import com.tencent.mm.plugin.ai.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public final class h
  extends iu
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(267383);
    info = iu.aJm();
    AppMethodBeat.o(267383);
  }
  
  public final boolean TZ(String paramString)
  {
    AppMethodBeat.i(267398);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267398);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.field_appTbe = paramString.optLong("tbe", 0L);
      this.field_appTen = paramString.optLong("ten", 0L);
      this.field_appIn = paramString.optLong("in", 0L);
      this.field_appInbg = paramString.optLong("inbg", 0L);
      label72:
      if ((this.field_appTbe <= 0L) || (this.field_appTen <= 0L))
      {
        AppMethodBeat.o(267398);
        return false;
      }
      this.field_appDs = Util.getInt(a.cav().format(Long.valueOf(this.field_appTbe)), -1);
      this.field_appHour = a.jv(this.field_appTbe);
      AppMethodBeat.o(267398);
      return true;
    }
    catch (Exception paramString)
    {
      break label72;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.h
 * JD-Core Version:    0.7.0.1
 */