package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetInstallStateForNative
  extends a<q>
{
  public static final int CTRL_INDEX = 656;
  public static final String NAME = "getInstallStateForNative";
  
  static class GetInstallStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetInstallStateTask> CREATOR;
    private int bWl;
    private boolean jYA;
    private m jYs;
    private q jdy;
    private String kbc;
    private JSONArray kbd;
    private boolean kbe;
    private String mPackageName;
    private String mVersionName;
    
    static
    {
      AppMethodBeat.i(45800);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45800);
    }
    
    public GetInstallStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45795);
      e(paramParcel);
      AppMethodBeat.o(45795);
    }
    
    public GetInstallStateTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45794);
      bej();
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.mPackageName = paramJSONObject.optString("packageName");
      paramm = paramJSONObject.optJSONArray("packageNameArray");
      if (paramm != null) {
        this.kbc = paramm.toString();
      }
      this.jYA = true;
      AppMethodBeat.o(45794);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45796);
      if (!bs.isNullOrNil(this.kbc)) {}
      for (;;)
      {
        int i;
        Object localObject2;
        boolean bool;
        try
        {
          localObject1 = new JSONArray(this.kbc);
          this.kbd = new JSONArray();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label266;
          }
          String str3 = ((JSONArray)localObject1).optString(i);
          localObject2 = b.getPackageInfo(ai.getContext(), str3);
          int j;
          if (localObject2 == null)
          {
            j = 0;
            break label406;
            ac.i("MicroMsg.JsApiGetInstallStateForNative", "getInstallState, packageName = " + str3 + ", packageInfo = " + localObject2 + ", version = " + j + ", versionName = " + str1);
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
              this.kbd.put(localObject2);
            }
            catch (JSONException localJSONException1)
            {
              ac.i("MicroMsg.JsApiGetInstallStateForNative", localJSONException1.getMessage());
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
          ac.e("MicroMsg.JsApiGetInstallStateForNative", localJSONException2.getMessage());
          this.jYA = true;
        }
        str1 = ((PackageInfo)localObject2).versionName;
        continue;
        for (;;)
        {
          bet();
          AppMethodBeat.o(45796);
          return;
          label266:
          this.jYA = false;
        }
        Object localObject1 = b.getPackageInfo(ai.getContext(), this.mPackageName);
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
          ac.i("MicroMsg.JsApiGetInstallStateForNative", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + localObject1 + ", version = " + i + ", versionName = " + str2);
          if (localObject1 != null) {
            break label392;
          }
        }
        for (this.kbe = false;; this.kbe = true)
        {
          this.jYA = false;
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
    
    public final void aLr()
    {
      boolean bool = true;
      AppMethodBeat.i(45797);
      if (this.jdy == null) {}
      for (;;)
      {
        ac.d("MicroMsg.JsApiGetInstallStateForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        bek();
        if (!this.jYA) {
          break;
        }
        this.jdy.h(this.bWl, this.jYs.e("fail", null));
        AppMethodBeat.o(45797);
        return;
        bool = false;
      }
      HashMap localHashMap = new HashMap();
      if (this.kbd != null) {
        localHashMap.put("result", this.kbd);
      }
      for (;;)
      {
        this.jdy.h(this.bWl, this.jYs.k("ok", localHashMap));
        AppMethodBeat.o(45797);
        return;
        localHashMap.put("versionName", this.mVersionName);
        localHashMap.put("isInstalled", Boolean.valueOf(this.kbe));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45798);
      this.mPackageName = paramParcel.readString();
      this.kbc = paramParcel.readString();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.jYA = bool1;
        if (paramParcel.readInt() != 1) {
          break label93;
        }
      }
      label93:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kbe = bool1;
        this.mVersionName = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (paramParcel == null) {
          break label123;
        }
        try
        {
          this.kbd = new JSONArray(paramParcel);
          AppMethodBeat.o(45798);
          return;
        }
        catch (JSONException paramParcel)
        {
          ac.e("MicroMsg.JsApiGetInstallStateForNative", "parseFromParcel: " + paramParcel.getMessage());
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
      paramParcel.writeString(this.kbc);
      if (this.jYA)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.kbe) {
          break label94;
        }
        paramInt = i;
        label47:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.mVersionName);
        if (this.kbd == null) {
          break label99;
        }
      }
      label94:
      label99:
      for (String str = this.kbd.toString();; str = null)
      {
        paramParcel.writeString(str);
        AppMethodBeat.o(45799);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label47;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallStateForNative
 * JD-Core Version:    0.7.0.1
 */