package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetInstallStateForNative
  extends c<y>
{
  public static final int CTRL_INDEX = 656;
  public static final String NAME = "getInstallStateForNative";
  
  static class GetInstallStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetInstallStateTask> CREATOR;
    private int eit;
    private String mPackageName;
    private String mVersionName;
    private y qsi;
    private String rCA;
    private JSONArray rCB;
    private boolean rCC;
    private p ryT;
    private boolean rzb;
    
    static
    {
      AppMethodBeat.i(45800);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45800);
    }
    
    public GetInstallStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45795);
      h(paramParcel);
      AppMethodBeat.o(45795);
    }
    
    public GetInstallStateTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45794);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.mPackageName = paramJSONObject.optString("packageName");
      paramp = paramJSONObject.optJSONArray("packageNameArray");
      if (paramp != null) {
        this.rCA = paramp.toString();
      }
      this.rzb = true;
      AppMethodBeat.o(45794);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45796);
      if (!Util.isNullOrNil(this.rCA)) {}
      for (;;)
      {
        int i;
        Object localObject2;
        boolean bool;
        try
        {
          localObject1 = new JSONArray(this.rCA);
          this.rCB = new JSONArray();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label266;
          }
          String str3 = ((JSONArray)localObject1).optString(i);
          localObject2 = b.getPackageInfo(MMApplicationContext.getContext(), str3);
          int j;
          if (localObject2 == null)
          {
            j = 0;
            break label406;
            Log.i("MicroMsg.JsApiGetInstallStateForNative", "getInstallState, packageName = " + str3 + ", packageInfo = " + localObject2 + ", version = " + j + ", versionName = " + str1);
            if (localObject2 == null) {
              break label418;
            }
            bool = true;
          }
          else
          {
            try
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("packageName", str3);
              ((JSONObject)localObject2).put("isInstalled", bool);
              if (bool)
              {
                ((JSONObject)localObject2).put("versionCode", j);
                ((JSONObject)localObject2).put("versionName", str1);
              }
              this.rCB.put(localObject2);
            }
            catch (JSONException localJSONException1)
            {
              Log.i("MicroMsg.JsApiGetInstallStateForNative", localJSONException1.getMessage());
              continue;
            }
            i += 1;
            continue;
            j = ((PackageInfo)localObject2).versionCode;
          }
        }
        catch (JSONException localJSONException2)
        {
          String str1;
          Log.e("MicroMsg.JsApiGetInstallStateForNative", localJSONException2.getMessage());
          this.rzb = true;
        }
        str1 = ((PackageInfo)localObject2).versionName;
        continue;
        for (;;)
        {
          cpA();
          AppMethodBeat.o(45796);
          return;
          label266:
          this.rzb = false;
        }
        Object localObject1 = b.getPackageInfo(MMApplicationContext.getContext(), this.mPackageName);
        label293:
        String str2;
        if (localObject1 == null)
        {
          i = 0;
          if (localObject1 != null) {
            break label382;
          }
          str2 = "null";
          label302:
          Log.i("MicroMsg.JsApiGetInstallStateForNative", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + localObject1 + ", version = " + i + ", versionName = " + str2);
          if (localObject1 != null) {
            break label392;
          }
        }
        for (this.rCC = false;; this.rCC = true)
        {
          this.rzb = false;
          break;
          i = ((PackageInfo)localObject1).versionCode;
          break label293;
          label382:
          str2 = ((PackageInfo)localObject1).versionName;
          break label302;
          label392:
          this.mVersionName = str2;
        }
        label406:
        if (localObject2 == null)
        {
          str2 = "null";
          continue;
          label418:
          bool = false;
        }
      }
    }
    
    public final void bQr()
    {
      boolean bool = true;
      AppMethodBeat.i(45797);
      if (this.qsi == null) {}
      for (;;)
      {
        Log.d("MicroMsg.JsApiGetInstallStateForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        cpx();
        if (!this.rzb) {
          break;
        }
        this.qsi.callback(this.eit, this.ryT.ZP("fail"));
        AppMethodBeat.o(45797);
        return;
        bool = false;
      }
      HashMap localHashMap = new HashMap();
      if (this.rCB != null) {
        localHashMap.put("result", this.rCB);
      }
      for (;;)
      {
        this.qsi.callback(this.eit, this.ryT.m("ok", localHashMap));
        AppMethodBeat.o(45797);
        return;
        localHashMap.put("versionName", this.mVersionName);
        localHashMap.put("isInstalled", Boolean.valueOf(this.rCC));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45798);
      this.mPackageName = paramParcel.readString();
      this.rCA = paramParcel.readString();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.rzb = bool1;
        if (paramParcel.readInt() != 1) {
          break label93;
        }
      }
      label93:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rCC = bool1;
        this.mVersionName = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (paramParcel == null) {
          break label123;
        }
        try
        {
          this.rCB = new JSONArray(paramParcel);
          AppMethodBeat.o(45798);
          return;
        }
        catch (JSONException paramParcel)
        {
          Log.e("MicroMsg.JsApiGetInstallStateForNative", "parseFromParcel: " + paramParcel.getMessage());
        }
        bool1 = false;
        break;
      }
      label123:
      AppMethodBeat.o(45798);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45799);
      paramParcel.writeString(this.mPackageName);
      paramParcel.writeString(this.rCA);
      if (this.rzb)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.rCC) {
          break label92;
        }
        paramInt = i;
        label46:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.mVersionName);
        if (this.rCB == null) {
          break label97;
        }
      }
      label92:
      label97:
      for (String str = this.rCB.toString();; str = null)
      {
        paramParcel.writeString(str);
        AppMethodBeat.o(45799);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label46;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallStateForNative
 * JD-Core Version:    0.7.0.1
 */