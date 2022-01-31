package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cx;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends cx
{
  static final c.a gUb;
  public transient boolean imf;
  
  static
  {
    AppMethodBeat.i(131924);
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.yrM.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appIdHash";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.yrM.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.yrM.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.yrM.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.yrM.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.yrM.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    gUb = locala;
    AppMethodBeat.o(131924);
  }
  
  public final boolean Dn(String paramString)
  {
    AppMethodBeat.i(131922);
    if ((this.field_operationInfo != null) && (!bo.isNullOrNil(this.field_operationInfo.xxR))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.xxR);
        boolean bool = localJSONObject.has("jumpWeAppFromLongPressCodeBanInfo");
        if (!bool)
        {
          AppMethodBeat.o(131922);
          return false;
        }
        localJSONObject = localJSONObject.getJSONObject("jumpWeAppFromLongPressCodeBanInfo");
        bool = localJSONObject.has(paramString);
        if (!bool)
        {
          AppMethodBeat.o(131922);
          return false;
        }
        if (localJSONObject.optInt(paramString, 0) == 1)
        {
          AppMethodBeat.o(131922);
          return true;
        }
        AppMethodBeat.o(131922);
        return false;
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(131922);
    return false;
  }
  
  public final void a(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131921);
    boolean bool1;
    label51:
    int i;
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.wmV))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.hja = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.wmW)) {
        break label196;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.hjb = bool1;
      if (this.field_actionsheetInfo == null) {
        break label201;
      }
      i = this.field_actionsheetInfo.wmX;
      label71:
      paramAppBrandSysConfigWC.hjc = i;
      paramAppBrandSysConfigWC.bDn = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bo.isNullOrNil(this.field_operationInfo.xxR))) {
        paramAppBrandSysConfigWC.bDo = this.field_operationInfo.xxR;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.bDo).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.hiT = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.hiU = bool1;
      }
      catch (JSONException localJSONException)
      {
        label196:
        label201:
        paramAppBrandSysConfigWC.hiT = false;
        paramAppBrandSysConfigWC.hiU = false;
        continue;
      }
      n.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.bDo);
      AppMethodBeat.o(131921);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
      i = 0;
      break label71;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void a(azn paramazn)
  {
    this.field_launchAction = paramazn.xoT;
    this.field_jsapiInfo = paramazn.xoU;
    this.field_hostInfo = paramazn.xoV;
    this.field_actionsheetInfo = paramazn.xoX;
    this.field_operationInfo = paramazn.xoY;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(131923);
    if ((paramObject instanceof ab))
    {
      paramObject = (ab)paramObject;
      if ((this.field_appId.equals(paramObject.field_appId)) && (this.field_launchAction != null) && (k.a(this.field_launchAction, paramObject.field_launchAction)) && (this.field_jsapiInfo != null) && (k.a(this.field_jsapiInfo, paramObject.field_jsapiInfo)) && (this.field_hostInfo != null) && (k.a(this.field_hostInfo, paramObject.field_hostInfo)) && (this.field_actionsheetInfo != null) && (k.a(this.field_actionsheetInfo, paramObject.field_actionsheetInfo)) && (this.field_operationInfo != null) && (k.a(this.field_operationInfo, paramObject.field_operationInfo)))
      {
        AppMethodBeat.o(131923);
        return true;
      }
      AppMethodBeat.o(131923);
      return false;
    }
    AppMethodBeat.o(131923);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return gUb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ab
 * JD-Core Version:    0.7.0.1
 */