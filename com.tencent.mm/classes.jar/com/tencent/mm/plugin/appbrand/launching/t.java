package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.h.c.cp;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.u.l;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
  extends cp
{
  static final c.a fCU;
  public transient boolean gLa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.ujN.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appIdHash";
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "launchAction";
    locala.ujN.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "jsapiInfo";
    locala.ujN.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "hostInfo";
    locala.ujN.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionsheetInfo";
    locala.ujN.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "operationInfo";
    locala.ujN.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    fCU = locala;
  }
  
  public final void a(ati paramati)
  {
    this.field_launchAction = paramati.toV;
    this.field_jsapiInfo = paramati.toW;
    this.field_hostInfo = paramati.toX;
    this.field_actionsheetInfo = paramati.toZ;
    this.field_operationInfo = paramati.tpa;
  }
  
  public final void b(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    if ((this.field_actionsheetInfo != null) && (this.field_actionsheetInfo.sus)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppBrandSysConfigWC.fQi = bool;
      paramAppBrandSysConfigWC.fPW = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
      if ((this.field_operationInfo != null) && (!bk.bl(this.field_operationInfo.txL))) {
        paramAppBrandSysConfigWC.fPX = this.field_operationInfo.txL;
      }
      o.a(paramAppBrandSysConfigWC, paramAppBrandSysConfigWC.fPX);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof t))
    {
      paramObject = (t)paramObject;
      bool1 = bool2;
      if (this.field_appId.equals(paramObject.field_appId))
      {
        bool1 = bool2;
        if (this.field_launchAction != null)
        {
          bool1 = bool2;
          if (l.a(this.field_launchAction, paramObject.field_launchAction))
          {
            bool1 = bool2;
            if (this.field_jsapiInfo != null)
            {
              bool1 = bool2;
              if (l.a(this.field_jsapiInfo, paramObject.field_jsapiInfo))
              {
                bool1 = bool2;
                if (this.field_hostInfo != null)
                {
                  bool1 = bool2;
                  if (l.a(this.field_hostInfo, paramObject.field_hostInfo))
                  {
                    bool1 = bool2;
                    if (this.field_actionsheetInfo != null)
                    {
                      bool1 = bool2;
                      if (l.a(this.field_actionsheetInfo, paramObject.field_actionsheetInfo))
                      {
                        bool1 = bool2;
                        if (this.field_operationInfo != null)
                        {
                          bool1 = bool2;
                          if (l.a(this.field_operationInfo, paramObject.field_operationInfo)) {
                            bool1 = true;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected final c.a rM()
  {
    return fCU;
  }
  
  public final boolean uU(String paramString)
  {
    if ((this.field_operationInfo != null) && (!bk.bl(this.field_operationInfo.txL))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.field_operationInfo.txL);
        if (!localJSONObject.has("jumpWeAppFromLongPressCodeBanInfo")) {
          return false;
        }
        localJSONObject = localJSONObject.getJSONObject("jumpWeAppFromLongPressCodeBanInfo");
        if (localJSONObject.has(paramString))
        {
          int i = localJSONObject.optInt(paramString, 0);
          if (i == 1) {
            return true;
          }
        }
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", new Object[] { paramString });
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t
 * JD-Core Version:    0.7.0.1
 */