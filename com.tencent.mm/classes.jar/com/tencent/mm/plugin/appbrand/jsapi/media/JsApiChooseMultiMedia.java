package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 549;
  public static final String NAME = "chooseMultiMedia";
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46542);
    if (o.Ld(paramc.getAppId()).jCb)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46542);
      return;
    }
    final Context localContext = paramc.getContext();
    if (!(localContext instanceof Activity))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46542);
      return;
    }
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46542);
      return;
    }
    int i = paramJSONObject.optInt("maxDuration", 10);
    ae.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", new Object[] { Integer.valueOf(i) });
    if ((i <= 0) || (i > 1800))
    {
      ae.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
      paramc.h(paramInt, e("fail:invalid maxDuration parameter", null));
      AppMethodBeat.o(46542);
      return;
    }
    localContext.getSharedPreferences(ak.fow() + "_locCache", 0).edit().putString("locStr", null).apply();
    Object localObject1 = new a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(46493);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = (int)(paramAnonymousa.latitude * 1000000.0D);
          int i = (int)(paramAnonymousa.longitude * 1000000.0D);
          paramAnonymousString = new StringBuilder();
          paramAnonymousString.append(paramAnonymousInt);
          paramAnonymousString.append(",");
          paramAnonymousString.append(i);
          localContext.getSharedPreferences(ak.fow() + "_locCache", 0).edit().putString("locStr", paramAnonymousString.toString()).apply();
          ae.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude), paramAnonymousString });
          ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("wgs84", this, null);
          AppMethodBeat.o(46493);
          return;
        }
        ae.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(46493);
      }
    };
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("wgs84", (a.b)localObject1, null);
    int j = paramJSONObject.optInt("count", 9);
    localObject1 = paramJSONObject.optJSONObject("location");
    double d2 = 181.0D;
    double d1 = 91.0D;
    boolean bool1;
    if (localObject1 != null)
    {
      d2 = ((JSONObject)localObject1).optDouble("longitude");
      d1 = ((JSONObject)localObject1).optDouble("latitude");
      if ((!Double.isNaN(d2)) && (!Double.isNaN(d1))) {
        break label781;
      }
      d2 = 181.0D;
      d1 = 91.0D;
      bool1 = true;
    }
    for (;;)
    {
      localObject1 = paramJSONObject.optString("poiName", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = paramc.getContext().getString(2131756002);
      }
      for (;;)
      {
        double d3 = paramJSONObject.optDouble("locationRadius", 50.0D);
        Object localObject2 = paramJSONObject.optJSONArray("sourceType");
        JSONArray localJSONArray = paramJSONObject.optJSONArray("cameraType");
        int k = paramJSONObject.optInt("pickAlbumType", 0);
        boolean bool2;
        boolean bool3;
        label427:
        boolean bool5;
        boolean bool4;
        label446:
        int m;
        if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
        {
          bool2 = true;
          bool3 = true;
          if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
            break label548;
          }
          bool5 = false;
          bool4 = false;
          if (!bool2) {
            break label622;
          }
          r.b(paramc.getAppId(), new android.support.v4.app.a.a()
          {
            public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
            {
              AppMethodBeat.i(46496);
              if (paramAnonymousInt != 113)
              {
                AppMethodBeat.o(46496);
                return;
              }
              if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
              {
                JsApiChooseMultiMedia.this.a(paramc, paramJSONObject, paramInt);
                AppMethodBeat.o(46496);
                return;
              }
              paramc.h(paramInt, JsApiChooseMultiMedia.this.e("fail:system permission denied", null));
              AppMethodBeat.o(46496);
            }
          });
          paramJSONObject = paramc.getContext();
          if ((paramJSONObject instanceof Activity)) {
            break label577;
          }
          paramc.h(paramInt, e("fail", null));
          m = 0;
        }
        for (;;)
        {
          if (m != 0) {
            break label622;
          }
          AppMethodBeat.o(46542);
          return;
          bool1 = true;
          break;
          bool2 = ((JSONArray)localObject2).toString().contains("camera");
          bool3 = ((JSONArray)localObject2).toString().contains("album");
          break label427;
          label548:
          bool4 = localJSONArray.toString().contains("video");
          bool5 = localJSONArray.toString().contains("photo");
          break label446;
          label577:
          boolean bool6 = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
          m = bool6;
          if (bool6)
          {
            r.UC(paramc.getAppId());
            m = bool6;
          }
        }
        label622:
        o.Le(paramc.getAppId()).jCb = true;
        h.a(paramc.getAppId(), new h.c()
        {
          public final void onResume()
          {
            AppMethodBeat.i(46494);
            o.Le(paramc.getAppId()).jCb = false;
            h.b(paramc.getAppId(), this);
            AppMethodBeat.o(46494);
          }
        });
        paramJSONObject = new ChooseRequest();
        paramJSONObject.appId = paramc.getAppId();
        paramJSONObject.count = j;
        localObject2 = com.tencent.mm.modelgeo.a.a.c(d2, d1);
        paramJSONObject.longitude = localObject2[0];
        paramJSONObject.latitude = localObject2[1];
        paramJSONObject.jGd = ((String)localObject1);
        paramJSONObject.inH = d3;
        paramJSONObject.kWX = bool2;
        paramJSONObject.kWY = bool3;
        paramJSONObject.jxK = i;
        paramJSONObject.kXU = bool4;
        paramJSONObject.kXV = bool5;
        paramJSONObject.kXW = k;
        paramJSONObject.kXX = bool1;
        com.tencent.mm.plugin.appbrand.ipc.a.a(localContext, paramJSONObject, new AppBrandProxyUIProcessTask.b() {});
        AppMethodBeat.o(46542);
        return;
      }
      label781:
      bool1 = false;
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    double inH;
    String jGd;
    int jxK;
    boolean kWX;
    boolean kWY;
    boolean kXU;
    boolean kXV;
    int kXW;
    boolean kXX;
    double latitude;
    double longitude;
    
    static
    {
      AppMethodBeat.i(46501);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46501);
    }
    
    ChooseRequest() {}
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46500);
      j(paramParcel);
      AppMethodBeat.o(46500);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bhv()
    {
      return JsApiChooseMultiMedia.a.class;
    }
    
    public final boolean biA()
    {
      return true;
    }
    
    public final String biB()
    {
      return "GalleryChooseMultiMedia";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46499);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      this.longitude = paramParcel.readDouble();
      this.latitude = paramParcel.readDouble();
      this.jGd = paramParcel.readString();
      this.inH = paramParcel.readDouble();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kWX = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label78:
        this.kWY = bool1;
        this.jxK = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
        bool1 = true;
        label100:
        this.kXU = bool1;
        if (paramParcel.readByte() == 0) {
          break label162;
        }
        bool1 = true;
        label114:
        this.kXV = bool1;
        this.kXW = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label167;
        }
      }
      label152:
      label157:
      label162:
      label167:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kXX = bool1;
        AppMethodBeat.o(46499);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label78;
        bool1 = false;
        break label100;
        bool1 = false;
        break label114;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46498);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.count);
      paramParcel.writeDouble(this.longitude);
      paramParcel.writeDouble(this.latitude);
      paramParcel.writeString(this.jGd);
      paramParcel.writeDouble(this.inH);
      if (this.kWX)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kWY) {
          break label154;
        }
        b1 = 1;
        label79:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.jxK);
        if (!this.kXU) {
          break label159;
        }
        b1 = 1;
        label101:
        paramParcel.writeByte(b1);
        if (!this.kXV) {
          break label164;
        }
        b1 = 1;
        label115:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.kXW);
        if (!this.kXX) {
          break label169;
        }
      }
      label154:
      label159:
      label164:
      label169:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46498);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label79;
        b1 = 0;
        break label101;
        b1 = 0;
        break label115;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int bZU;
    String kXY;
    
    static
    {
      AppMethodBeat.i(46505);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46505);
    }
    
    ChooseResult() {}
    
    ChooseResult(Parcel paramParcel)
    {
      super();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46503);
      this.bZU = paramParcel.readInt();
      this.kXY = paramParcel.readString();
      AppMethodBeat.o(46503);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46504);
      paramParcel.writeInt(this.bZU);
      paramParcel.writeString(this.kXY);
      AppMethodBeat.o(46504);
    }
  }
  
  static final class b
  {
    public String cpm;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia
 * JD-Core Version:    0.7.0.1
 */