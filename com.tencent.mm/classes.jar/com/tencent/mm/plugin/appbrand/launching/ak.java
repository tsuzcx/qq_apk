package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ew;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.af.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import org.apache.commons.c.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
  extends ew
{
  static final IAutoDBItem.MAutoDBInfo DB_INFO;
  public transient boolean tbv;
  
  static
  {
    AppMethodBeat.i(47285);
    DB_INFO = ew.aJm();
    AppMethodBeat.o(47285);
  }
  
  public final boolean adf(String paramString)
  {
    AppMethodBeat.i(47283);
    if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.abdQ))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.abdQ);
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
  
  public final void b(dgu paramdgu)
  {
    AppMethodBeat.i(320701);
    this.field_launchAction = paramdgu.aaLZ;
    this.field_jsapiInfo = paramdgu.aaMa;
    this.field_hostInfo = paramdgu.aaMb;
    this.field_actionsheetInfo = paramdgu.aaMd;
    this.field_operationInfo = paramdgu.aaMe;
    this.field_opConfig = paramdgu.eqk;
    long l = paramdgu.aaMg & 0xFFFFFFFF;
    if (l > 0L)
    {
      this.field_expiredAtTimestampSeconds = (l + cn.getSyncServerTimeSecond());
      AppMethodBeat.o(320701);
      return;
    }
    this.field_expiredAtTimestampSeconds = 0L;
    AppMethodBeat.o(320701);
  }
  
  public final void c(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47282);
    boolean bool1;
    label51:
    label75:
    int i;
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.YCO))
    {
      bool1 = true;
      paramAppBrandSysConfigWC.qZb = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.YCP)) {
        break label272;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.qZc = bool1;
      if ((this.field_actionsheetInfo == null) || (!this.field_actionsheetInfo.YCR)) {
        break label277;
      }
      bool1 = true;
      paramAppBrandSysConfigWC.qZd = bool1;
      if (this.field_actionsheetInfo == null) {
        break label282;
      }
      i = this.field_actionsheetInfo.YCQ;
      label95:
      paramAppBrandSysConfigWC.qZe = i;
      if ((this.field_actionsheetInfo == null) || (this.field_actionsheetInfo.YCS == null)) {
        break label287;
      }
      paramAppBrandSysConfigWC.qZf = this.field_actionsheetInfo.YCS.Op;
      Log.i("MicroMsg.AppBrand.LaunchWxaAppInfo", "fillLaunchConfig, has control bytes");
      label138:
      if ((this.field_operationInfo != null) && (!Util.isNullOrNil(this.field_operationInfo.abdQ))) {
        paramAppBrandSysConfigWC.epF = this.field_operationInfo.abdQ;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAppBrandSysConfigWC.epF).getJSONObject("privacy");
        if (localJSONObject.getInt("banLocationIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = true;
        paramAppBrandSysConfigWC.qYU = bool1;
        if (localJSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
          continue;
        }
        bool1 = bool2;
        paramAppBrandSysConfigWC.qYV = bool1;
      }
      catch (JSONException localJSONException)
      {
        label272:
        label277:
        label282:
        label287:
        paramAppBrandSysConfigWC.qYU = false;
        paramAppBrandSysConfigWC.qYV = false;
        continue;
      }
      x.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.epF);
      paramAppBrandSysConfigWC.epC = new LaunchWxaAppInfoParcelized(new AppRuntimeApiPermissionBundle(this.field_jsapiInfo), null, this.field_opConfig, false, false);
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
      paramAppBrandSysConfigWC.qZf = null;
      break label138;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(47284);
    if ((paramObject instanceof ak))
    {
      paramObject = (ak)paramObject;
      if ((this.field_appId.equals(paramObject.field_appId)) && (this.field_launchAction != null) && (l.a(this.field_launchAction, paramObject.field_launchAction)) && (this.field_jsapiInfo != null) && (l.a(this.field_jsapiInfo, paramObject.field_jsapiInfo)) && (this.field_hostInfo != null) && (l.a(this.field_hostInfo, paramObject.field_hostInfo)) && (this.field_actionsheetInfo != null) && (l.a(this.field_actionsheetInfo, paramObject.field_actionsheetInfo)) && (this.field_operationInfo != null) && (l.a(this.field_operationInfo, paramObject.field_operationInfo)) && (i.qA(this.field_opConfig, paramObject.field_opConfig)) && (this.field_expiredAtTimestampSeconds == paramObject.field_expiredAtTimestampSeconds))
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
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ak
 * JD-Core Version:    0.7.0.1
 */