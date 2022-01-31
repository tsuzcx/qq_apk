package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiGetInstallState$GetInstallStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetInstallStateTask> CREATOR = new JsApiGetInstallState.GetInstallStateTask.1();
  private int bhx;
  private o fyo;
  private String ghZ;
  private i gho;
  private boolean ghr;
  private JSONArray gia;
  private boolean gib;
  private String mPackageName;
  private String mVersionName;
  
  public JsApiGetInstallState$GetInstallStateTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiGetInstallState$GetInstallStateTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
  {
    ahC();
    this.gho = parami;
    this.fyo = paramo;
    this.bhx = paramInt;
    this.mPackageName = paramJSONObject.optString("packageName");
    parami = paramJSONObject.optJSONArray("packageNameArray");
    if (parami != null) {
      this.ghZ = parami.toString();
    }
    this.ghr = true;
  }
  
  public final void Zu()
  {
    if (!bk.bl(this.ghZ)) {}
    for (;;)
    {
      int i;
      Object localObject2;
      boolean bool;
      try
      {
        localObject1 = new JSONArray(this.ghZ);
        this.gia = new JSONArray();
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label256;
        }
        String str3 = ((JSONArray)localObject1).optString(i);
        localObject2 = p.getPackageInfo(ae.getContext(), str3);
        int j;
        if (localObject2 == null)
        {
          j = 0;
          break label396;
          y.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + str3 + ", packageInfo = " + localObject2 + ", version = " + j + ", versionName = " + str1);
          if (localObject2 == null) {
            break label408;
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
            this.gia.put(localObject2);
          }
          catch (JSONException localJSONException1)
          {
            y.i("MicroMsg.JsApiGetInstallState", localJSONException1.getMessage());
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
        y.e("MicroMsg.JsApiGetInstallState", localJSONException2.getMessage());
        this.ghr = true;
      }
      str1 = ((PackageInfo)localObject2).versionName;
      continue;
      for (;;)
      {
        ahI();
        return;
        label256:
        this.ghr = false;
      }
      Object localObject1 = p.getPackageInfo(ae.getContext(), this.mPackageName);
      label283:
      String str2;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject1 != null) {
          break label372;
        }
        str2 = "null";
        label292:
        y.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + localObject1 + ", version = " + i + ", versionName = " + str2);
        if (localObject1 != null) {
          break label382;
        }
      }
      for (this.gib = false;; this.gib = true)
      {
        this.ghr = false;
        break;
        i = ((PackageInfo)localObject1).versionCode;
        break label283;
        label372:
        str2 = ((PackageInfo)localObject1).versionName;
        break label292;
        label382:
        this.mVersionName = str2;
      }
      label396:
      if (localObject2 == null)
      {
        str2 = "null";
        continue;
        label408:
        bool = false;
      }
    }
  }
  
  public final void Zv()
  {
    boolean bool = true;
    if (this.fyo == null) {}
    for (;;)
    {
      y.d("MicroMsg.JsApiGetInstallState", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
      ahD();
      if (!this.ghr) {
        break;
      }
      this.fyo.C(this.bhx, this.gho.h("fail", null));
      return;
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    if (this.gia != null) {
      localHashMap.put("result", this.gia);
    }
    for (;;)
    {
      this.fyo.C(this.bhx, this.gho.h("ok", localHashMap));
      return;
      localHashMap.put("versionName", this.mVersionName);
      localHashMap.put("isInstalled", Boolean.valueOf(this.gib));
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.mPackageName = paramParcel.readString();
    this.ghZ = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.ghr = bool1;
      if (paramParcel.readInt() != 1) {
        break label83;
      }
    }
    label83:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gib = bool1;
      this.mVersionName = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {}
      try
      {
        this.gia = new JSONArray(paramParcel);
        return;
      }
      catch (JSONException paramParcel)
      {
        y.e("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + paramParcel.getMessage());
      }
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeString(this.ghZ);
    if (this.ghr)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.gib) {
        break label82;
      }
      paramInt = i;
      label41:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mVersionName);
      if (this.gia == null) {
        break label87;
      }
    }
    label82:
    label87:
    for (String str = this.gia.toString();; str = null)
    {
      paramParcel.writeString(str);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState.GetInstallStateTask
 * JD-Core Version:    0.7.0.1
 */