package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ax
  extends dy
{
  static final c.a jJU;
  public transient boolean lOV;
  
  static
  {
    AppMethodBeat.i(47285);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.IBN.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appIdHash";
    locala.columns[1] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.IBN.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.IBN.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.IBN.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.IBN.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.IBN.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    jJU = locala;
    AppMethodBeat.o(47285);
  }
  
  public final boolean SC(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!bu.isNullOrNil(this.field_operationInfo.HsV))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.HsV);
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
        ae.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
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
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.FLi))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.kbz = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.FLj)) {
        break label258;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.kbA = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.FLl)) {
        break label263;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.kbB = bool1;
      if (this.field_actionsheetInfo == null) {
        break label268;
      }
      i = this.field_actionsheetInfo.FLk;
      label95:
      paramAppBrandSysConfigWC.kbC = i;
      if ((this.field_actionsheetInfo == null) || (this.field_actionsheetInfo.FLm == null)) {
        break label273;
      }
      paramAppBrandSysConfigWC.kbD = this.field_actionsheetInfo.FLm.zr;
      ae.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
      label138:
      paramAppBrandSysConfigWC.cmK = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bu.isNullOrNil(this.field_operationInfo.HsV))) {
        paramAppBrandSysConfigWC.cmM = this.field_operationInfo.HsV;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cmM).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.kbs = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.kbt = bool1;
      }
      catch (JSONException localJSONException)
      {
        label258:
        label263:
        label268:
        label273:
        paramAppBrandSysConfigWC.kbs = false;
        paramAppBrandSysConfigWC.kbt = false;
        continue;
      }
      r.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cmM);
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
      ae.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, control bytes is null");
      paramAppBrandSysConfigWC.kbD = null;
      break label138;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void a(bua parambua)
  {
    this.field_launchAction = parambua.Hhj;
    this.field_jsapiInfo = parambua.Hhk;
    this.field_hostInfo = parambua.Hhl;
    this.field_actionsheetInfo = parambua.Hhn;
    this.field_operationInfo = parambua.Hho;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47284);
    if ((paramObject instanceof ax))
    {
      paramObject = (ax)paramObject;
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
    return jJU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */