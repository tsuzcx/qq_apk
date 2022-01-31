package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiGetInstallState$GetInstallStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetInstallStateTask> CREATOR;
  private int bxX;
  private r gPA;
  private String hBc;
  private JSONArray hBd;
  private boolean hBe;
  private m hyA;
  private boolean hyI;
  private String mPackageName;
  private String mVersionName;
  
  static
  {
    AppMethodBeat.i(114348);
    CREATOR = new JsApiGetInstallState.GetInstallStateTask.1();
    AppMethodBeat.o(114348);
  }
  
  public JsApiGetInstallState$GetInstallStateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(114343);
    f(paramParcel);
    AppMethodBeat.o(114343);
  }
  
  public JsApiGetInstallState$GetInstallStateTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(114342);
    aBj();
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.mPackageName = paramJSONObject.optString("packageName");
    paramm = paramJSONObject.optJSONArray("packageNameArray");
    if (paramm != null) {
      this.hBc = paramm.toString();
    }
    this.hyI = true;
    AppMethodBeat.o(114342);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(114344);
    if (!bo.isNullOrNil(this.hBc)) {}
    for (;;)
    {
      int i;
      Object localObject2;
      boolean bool;
      try
      {
        localObject1 = new JSONArray(this.hBc);
        this.hBd = new JSONArray();
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label266;
        }
        String str3 = ((JSONArray)localObject1).optString(i);
        localObject2 = b.getPackageInfo(ah.getContext(), str3);
        int j;
        if (localObject2 == null)
        {
          j = 0;
          break label406;
          ab.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + str3 + ", packageInfo = " + localObject2 + ", version = " + j + ", versionName = " + str1);
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
            this.hBd.put(localObject2);
          }
          catch (JSONException localJSONException1)
          {
            ab.i("MicroMsg.JsApiGetInstallState", localJSONException1.getMessage());
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
        ab.e("MicroMsg.JsApiGetInstallState", localJSONException2.getMessage());
        this.hyI = true;
      }
      str1 = ((PackageInfo)localObject2).versionName;
      continue;
      for (;;)
      {
        aBp();
        AppMethodBeat.o(114344);
        return;
        label266:
        this.hyI = false;
      }
      Object localObject1 = b.getPackageInfo(ah.getContext(), this.mPackageName);
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
        ab.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + localObject1 + ", version = " + i + ", versionName = " + str2);
        if (localObject1 != null) {
          break label392;
        }
      }
      for (this.hBe = false;; this.hBe = true)
      {
        this.hyI = false;
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
  
  public final void atb()
  {
    boolean bool = true;
    AppMethodBeat.i(114345);
    if (this.gPA == null) {}
    for (;;)
    {
      ab.d("MicroMsg.JsApiGetInstallState", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
      aBk();
      if (!this.hyI) {
        break;
      }
      this.gPA.h(this.bxX, this.hyA.j("fail", null));
      AppMethodBeat.o(114345);
      return;
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    if (this.hBd != null) {
      localHashMap.put("result", this.hBd);
    }
    for (;;)
    {
      this.gPA.h(this.bxX, this.hyA.j("ok", localHashMap));
      AppMethodBeat.o(114345);
      return;
      localHashMap.put("versionName", this.mVersionName);
      localHashMap.put("isInstalled", Boolean.valueOf(this.hBe));
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(114346);
    this.mPackageName = paramParcel.readString();
    this.hBc = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.hyI = bool1;
      if (paramParcel.readInt() != 1) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hBe = bool1;
      this.mVersionName = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (paramParcel == null) {
        break label123;
      }
      try
      {
        this.hBd = new JSONArray(paramParcel);
        AppMethodBeat.o(114346);
        return;
      }
      catch (JSONException paramParcel)
      {
        ab.e("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + paramParcel.getMessage());
      }
      bool1 = false;
      break;
    }
    label123:
    AppMethodBeat.o(114346);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(114347);
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeString(this.hBc);
    if (this.hyI)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.hBe) {
        break label92;
      }
      paramInt = i;
      label46:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mVersionName);
      if (this.hBd == null) {
        break label97;
      }
    }
    label92:
    label97:
    for (String str = this.hBd.toString();; str = null)
    {
      paramParcel.writeString(str);
      AppMethodBeat.o(114347);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState.GetInstallStateTask
 * JD-Core Version:    0.7.0.1
 */