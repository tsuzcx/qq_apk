package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hr;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends hr
{
  public static IAutoDBItem.MAutoDBInfo info;
  private SimpleDateFormat kxO = null;
  
  static
  {
    AppMethodBeat.i(238950);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appDs";
    localMAutoDBInfo.colsMap.put("appDs", "INTEGER");
    localStringBuilder.append(" appDs INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appHour";
    localMAutoDBInfo.colsMap.put("appHour", "INTEGER");
    localStringBuilder.append(" appHour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appTbe";
    localMAutoDBInfo.colsMap.put("appTbe", "LONG");
    localStringBuilder.append(" appTbe LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "appTen";
    localMAutoDBInfo.colsMap.put("appTen", "LONG");
    localStringBuilder.append(" appTen LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "appIn";
    localMAutoDBInfo.colsMap.put("appIn", "LONG");
    localStringBuilder.append(" appIn LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "appInbg";
    localMAutoDBInfo.colsMap.put("appInbg", "LONG");
    localStringBuilder.append(" appInbg LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(238950);
  }
  
  public final boolean TN(String paramString)
  {
    AppMethodBeat.i(238949);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238949);
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
        AppMethodBeat.o(238949);
        return false;
      }
      if (this.kxO == null) {
        this.kxO = new SimpleDateFormat("yyyyMMdd");
      }
      this.field_appDs = Util.getInt(this.kxO.format(Long.valueOf(this.field_appTbe)), -1);
      this.field_appHour = a.AU(this.field_appTbe);
      AppMethodBeat.o(238949);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.e
 * JD-Core Version:    0.7.0.1
 */