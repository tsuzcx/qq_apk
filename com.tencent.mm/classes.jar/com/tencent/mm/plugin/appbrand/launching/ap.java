package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ee;
import com.tencent.mm.plugin.appbrand.ac.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  extends ee
{
  static final IAutoDBItem.MAutoDBInfo kLR;
  public transient boolean mWd;
  
  static
  {
    AppMethodBeat.i(47285);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
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
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    kLR = localMAutoDBInfo;
    AppMethodBeat.o(47285);
  }
  
  public final boolean acg(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.MBR))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.MBR);
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
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.KEI))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.leH = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.KEJ)) {
        break label258;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.leI = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.KEL)) {
        break label263;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.leJ = bool1;
      if (this.field_actionsheetInfo == null) {
        break label268;
      }
      i = this.field_actionsheetInfo.KEK;
      label95:
      paramAppBrandSysConfigWC.leK = i;
      if ((this.field_actionsheetInfo == null) || (this.field_actionsheetInfo.KEM == null)) {
        break label273;
      }
      paramAppBrandSysConfigWC.leL = this.field_actionsheetInfo.KEM.zy;
      Log.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
      label138:
      paramAppBrandSysConfigWC.cyG = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.MBR))) {
        paramAppBrandSysConfigWC.cyI = this.field_operationInfo.MBR;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.cyI).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.leA = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.leB = bool1;
      }
      catch (JSONException localJSONException)
      {
        label258:
        label263:
        label268:
        label273:
        paramAppBrandSysConfigWC.leA = false;
        paramAppBrandSysConfigWC.leB = false;
        continue;
      }
      u.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.cyI);
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
      paramAppBrandSysConfigWC.leL = null;
      break label138;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final void b(che paramche)
  {
    this.field_launchAction = paramche.Mmz;
    this.field_jsapiInfo = paramche.MmA;
    this.field_hostInfo = paramche.MmB;
    this.field_actionsheetInfo = paramche.MmD;
    this.field_operationInfo = paramche.MmE;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47284);
    if ((paramObject instanceof ap))
    {
      paramObject = (ap)paramObject;
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
    return kLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */