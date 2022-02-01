package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dm;
import com.tencent.mm.plugin.appbrand.aa.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class au
  extends dm
{
  static final c.a iMP;
  public transient boolean kLF;
  
  static
  {
    AppMethodBeat.i(47285);
    c.a locala = new c.a();
    locala.EYt = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.EYv.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "appIdHash";
    locala.columns[1] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.EYv.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.EYv.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.EYv.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.EYv.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.EYv.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    iMP = locala;
    AppMethodBeat.o(47285);
  }
  
  public final boolean Km(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!bt.isNullOrNil(this.field_operationInfo.DTo))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.DTo);
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
        ad.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
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
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.Cvk))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.jdV = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.Cvl)) {
        break label220;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jdW = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.Cvn)) {
        break label225;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jdX = bool1;
      if (this.field_actionsheetInfo == null) {
        break label230;
      }
      i = this.field_actionsheetInfo.Cvm;
      label95:
      paramAppBrandSysConfigWC.jdY = i;
      paramAppBrandSysConfigWC.cfu = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bt.isNullOrNil(this.field_operationInfo.DTo))) {
        paramAppBrandSysConfigWC.cfw = this.field_operationInfo.DTo;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cfw).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.jdO = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.jdP = bool1;
      }
      catch (JSONException localJSONException)
      {
        label220:
        label225:
        label230:
        paramAppBrandSysConfigWC.jdO = false;
        paramAppBrandSysConfigWC.jdP = false;
        continue;
      }
      r.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cfw);
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
  
  public final void a(bkx parambkx)
  {
    this.field_launchAction = parambkx.DIK;
    this.field_jsapiInfo = parambkx.DIL;
    this.field_hostInfo = parambkx.DIM;
    this.field_actionsheetInfo = parambkx.DIO;
    this.field_operationInfo = parambkx.DIP;
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
    return iMP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */