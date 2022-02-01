package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.do;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.z.j;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class au
  extends do
{
  static final c.a jmW;
  public transient boolean lnb;
  
  static
  {
    AppMethodBeat.i(47285);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.GvH.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appIdHash";
    locala.columns[1] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.GvH.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.GvH.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.GvH.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.GvH.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.GvH.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    jmW = locala;
    AppMethodBeat.o(47285);
  }
  
  public final boolean Ot(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!bs.isNullOrNil(this.field_operationInfo.FpK))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.FpK);
        boolean bool = localJSONObject.has("jumpWeAppFromLongPressCodeBanInfo");
        if (!bool)
        {
          AppMethodBeat.o(47283);
          return false;
        }
        localJSONObject = localJSONObject.getJSONObject("jumpWeAppFromLongPressCodeBanInfo");
        bool = localJSONObject.has(paramString);
        if (!bool)
        {
          AppMethodBeat.o(47283);
          return false;
        }
        if (localJSONObject.optInt(paramString, 0) == 1)
        {
          AppMethodBeat.o(47283);
          return true;
        }
        AppMethodBeat.o(47283);
        return false;
      }
      catch (JSONException paramString)
      {
        ac.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(47283);
    return false;
  }
  
  public final void a(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47282);
    boolean bool1;
    label51:
    label75:
    int i;
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.DNF))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.jEj = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.DNG)) {
        break label220;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jEk = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.DNI)) {
        break label225;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jEl = bool1;
      if (this.field_actionsheetInfo == null) {
        break label230;
      }
      i = this.field_actionsheetInfo.DNH;
      label95:
      paramAppBrandSysConfigWC.jEm = i;
      paramAppBrandSysConfigWC.ccr = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bs.isNullOrNil(this.field_operationInfo.FpK))) {
        paramAppBrandSysConfigWC.cct = this.field_operationInfo.FpK;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cct).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.jEc = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.jEd = bool1;
      }
      catch (JSONException localJSONException)
      {
        label220:
        label225:
        label230:
        paramAppBrandSysConfigWC.jEc = false;
        paramAppBrandSysConfigWC.jEd = false;
        continue;
      }
      r.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cct);
      AppMethodBeat.o(47282);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
      bool1 = false;
      break label75;
      i = 0;
      break label95;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void a(bot parambot)
  {
    this.field_launchAction = parambot.Fef;
    this.field_jsapiInfo = parambot.Feg;
    this.field_hostInfo = parambot.Feh;
    this.field_actionsheetInfo = parambot.Fej;
    this.field_operationInfo = parambot.Fek;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47284);
    if ((paramObject instanceof au))
    {
      paramObject = (au)paramObject;
      if ((this.field_appId.equals(paramObject.field_appId)) && (this.field_launchAction != null) && (j.a(this.field_launchAction, paramObject.field_launchAction)) && (this.field_jsapiInfo != null) && (j.a(this.field_jsapiInfo, paramObject.field_jsapiInfo)) && (this.field_hostInfo != null) && (j.a(this.field_hostInfo, paramObject.field_hostInfo)) && (this.field_actionsheetInfo != null) && (j.a(this.field_actionsheetInfo, paramObject.field_actionsheetInfo)) && (this.field_operationInfo != null) && (j.a(this.field_operationInfo, paramObject.field_operationInfo)))
      {
        AppMethodBeat.o(47284);
        return true;
      }
      AppMethodBeat.o(47284);
      return false;
    }
    AppMethodBeat.o(47284);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return jmW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */