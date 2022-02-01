package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.z.j;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ax
  extends dy
{
  static final c.a jGU;
  public transient boolean lKu;
  
  static
  {
    AppMethodBeat.i(47285);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.IhC.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appIdHash";
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.IhC.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.IhC.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.IhC.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.IhC.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.IhC.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    jGU = locala;
    AppMethodBeat.o(47285);
  }
  
  public final boolean RT(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!bt.isNullOrNil(this.field_operationInfo.GZu))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.GZu);
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
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.FsK))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.jYk = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.FsL)) {
        break label258;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jYl = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.FsN)) {
        break label263;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.jYm = bool1;
      if (this.field_actionsheetInfo == null) {
        break label268;
      }
      i = this.field_actionsheetInfo.FsM;
      label95:
      paramAppBrandSysConfigWC.jYn = i;
      if ((this.field_actionsheetInfo == null) || (this.field_actionsheetInfo.FsO == null)) {
        break label273;
      }
      paramAppBrandSysConfigWC.jYo = this.field_actionsheetInfo.FsO.zr;
      ad.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
      label138:
      paramAppBrandSysConfigWC.cmI = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bt.isNullOrNil(this.field_operationInfo.GZu))) {
        paramAppBrandSysConfigWC.cmK = this.field_operationInfo.GZu;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cmK).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.jYd = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.jYe = bool1;
      }
      catch (JSONException localJSONException)
      {
        label258:
        label263:
        label268:
        label273:
        paramAppBrandSysConfigWC.jYd = false;
        paramAppBrandSysConfigWC.jYe = false;
        continue;
      }
      r.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cmK);
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
      ad.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, control bytes is null");
      paramAppBrandSysConfigWC.jYo = null;
      break label138;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void a(btg parambtg)
  {
    this.field_launchAction = parambtg.GNJ;
    this.field_jsapiInfo = parambtg.GNK;
    this.field_hostInfo = parambtg.GNL;
    this.field_actionsheetInfo = parambtg.GNN;
    this.field_operationInfo = parambtg.GNO;
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
    return jGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */