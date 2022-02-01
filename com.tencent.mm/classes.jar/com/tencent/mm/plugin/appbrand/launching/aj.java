package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.ei;
import com.tencent.mm.plugin.appbrand.ac.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
  extends ei
{
  static final IAutoDBItem.MAutoDBInfo nFK;
  public transient boolean pWG;
  
  static
  {
    AppMethodBeat.i(47285);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appIdHash";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "launchAction";
    localMAutoDBInfo.colsMap.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "jsapiInfo";
    localMAutoDBInfo.colsMap.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "hostInfo";
    localMAutoDBInfo.colsMap.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionsheetInfo";
    localMAutoDBInfo.colsMap.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "operationInfo";
    localMAutoDBInfo.colsMap.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "opConfig";
    localMAutoDBInfo.colsMap.put("opConfig", "TEXT");
    localStringBuilder.append(" opConfig TEXT");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    nFK = localMAutoDBInfo;
    AppMethodBeat.o(47285);
  }
  
  public final boolean aka(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.TNx))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.TNx);
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
        Log.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(47283);
    return false;
  }
  
  public final void b(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47282);
    boolean bool1;
    label51:
    label75:
    int i;
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.RGa))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.nYU = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.RGb)) {
        break label271;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.nYV = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.RGd)) {
        break label276;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.nYW = bool1;
      if (this.field_actionsheetInfo == null) {
        break label281;
      }
      i = this.field_actionsheetInfo.RGc;
      label95:
      paramAppBrandSysConfigWC.nYX = i;
      if ((this.field_actionsheetInfo == null) || (this.field_actionsheetInfo.RGe == null)) {
        break label286;
      }
      paramAppBrandSysConfigWC.nYY = this.field_actionsheetInfo.RGe.UH;
      Log.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
      label138:
      if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.TNx))) {
        paramAppBrandSysConfigWC.cxn = this.field_operationInfo.TNx;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cxn).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.nYN = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.nYO = bool1;
      }
      catch (JSONException localJSONException)
      {
        label271:
        label276:
        label281:
        label286:
        paramAppBrandSysConfigWC.nYN = false;
        paramAppBrandSysConfigWC.nYO = false;
        continue;
      }
      u.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cxn);
      paramAppBrandSysConfigWC.cxk = new LaunchWxaAppInfoParcelized(new AppRuntimeApiPermissionBundle(this.field_jsapiInfo), null, this.field_opConfig, false);
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
      Log.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, control bytes is null");
      paramAppBrandSysConfigWC.nYY = null;
      break label138;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void b(cqa paramcqa)
  {
    this.field_launchAction = paramcqa.Txu;
    this.field_jsapiInfo = paramcqa.Txv;
    this.field_hostInfo = paramcqa.Txw;
    this.field_actionsheetInfo = paramcqa.Txy;
    this.field_operationInfo = paramcqa.Txz;
    this.field_opConfig = paramcqa.cxQ;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47284);
    if ((paramObject instanceof aj))
    {
      paramObject = (aj)paramObject;
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nFK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj
 * JD-Core Version:    0.7.0.1
 */