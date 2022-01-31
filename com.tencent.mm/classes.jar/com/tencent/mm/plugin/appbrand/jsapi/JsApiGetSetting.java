package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.protocal.c.clt;
import com.tencent.mm.protocal.c.clu;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetSetting
  extends a
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new GetSettingTask();
    paramJSONObject.mAppId = paramc.getAppId();
    paramJSONObject.bhx = paramInt;
    paramJSONObject.gfZ = paramc;
    com.tencent.mm.plugin.appbrand.v.c.aU(paramJSONObject);
    AppBrandMainProcessService.a(paramJSONObject);
  }
  
  private static final class GetSettingTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetSettingTask> CREATOR = new JsApiGetSetting.GetSettingTask.2();
    public int bhx;
    public c gfZ;
    public String mAppId;
    private String mAuthInfo;
    
    public GetSettingTask() {}
    
    public GetSettingTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public final void Zu()
    {
      b.a locala = new b.a();
      locala.ecH = new clt();
      locala.ecI = new clu();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
      locala.ecG = 1115;
      locala.ecJ = 0;
      locala.ecK = 0;
      clt localclt = new clt();
      localclt.appId = this.mAppId;
      locala.ecH = localclt;
      w.a(locala.Kt(), new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, m paramAnonymousm)
        {
          y.d("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            return 0;
          }
          paramAnonymousString = (clu)paramAnonymousb.ecF.ecN;
          if (paramAnonymousString == null) {
            y.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq failed, response is null!");
          }
          for (;;)
          {
            JsApiGetSetting.GetSettingTask.a(JsApiGetSetting.GetSettingTask.this);
            return 0;
            paramAnonymousInt1 = paramAnonymousString.tYN.errCode;
            paramAnonymousb = paramAnonymousString.tYN.aox;
            if (paramAnonymousInt1 == 0)
            {
              paramAnonymousb = paramAnonymousString.tYO;
              paramAnonymousString = new JSONArray();
              paramAnonymousb = paramAnonymousb.iterator();
              while (paramAnonymousb.hasNext())
              {
                paramAnonymousm = (ep)paramAnonymousb.next();
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("scope", paramAnonymousm.scope);
                  localJSONObject.put("state", paramAnonymousm.state);
                  localJSONObject.put("desc", paramAnonymousm.syf);
                  paramAnonymousString.put(localJSONObject);
                }
                catch (Exception paramAnonymousm)
                {
                  y.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { paramAnonymousm.getMessage() });
                }
              }
              JsApiGetSetting.GetSettingTask.a(JsApiGetSetting.GetSettingTask.this, paramAnonymousString.toString());
              y.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramAnonymousString });
            }
            else
            {
              y.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq error %s", new Object[] { paramAnonymousb });
            }
          }
        }
      }, true);
    }
    
    public final void Zv()
    {
      y.i("MicroMsg.JsApiGetSetting", "runInClientProcess");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errMsg", "getSetting:ok");
        localJSONObject.put("authSetting", new JSONArray(bk.pm(this.mAuthInfo)));
        this.gfZ.C(this.bhx, localJSONObject.toString());
        com.tencent.mm.plugin.appbrand.v.c.aa(this);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiGetSetting", "set json error!");
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      this.mAuthInfo = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.bhx = paramParcel.readInt();
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mAuthInfo);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeInt(this.bhx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting
 * JD-Core Version:    0.7.0.1
 */