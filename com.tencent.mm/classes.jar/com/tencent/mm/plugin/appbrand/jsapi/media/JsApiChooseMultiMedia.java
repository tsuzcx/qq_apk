package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia
  extends c
{
  public static final int CTRL_INDEX = 549;
  public static final String NAME = "chooseMultiMedia";
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46542);
    if (u.Ux(paramf.getAppId()).qvf)
    {
      paramf.callback(paramInt, ZP("cancel"));
      AppMethodBeat.o(46542);
      return;
    }
    final Context localContext = paramf.getContext();
    if (!(localContext instanceof Activity))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46542);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(46542);
      return;
    }
    int i = paramJSONObject.optInt("maxDuration", 10);
    Log.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", new Object[] { Integer.valueOf(i) });
    if ((i <= 0) || (i > 1800))
    {
      Log.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
      paramf.callback(paramInt, ZP("fail:invalid maxDuration parameter"));
      AppMethodBeat.o(46542);
      return;
    }
    localContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).edit().putString("locStr", null).apply();
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
          localContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).edit().putString("locStr", paramAnonymousString.toString()).apply();
          Log.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude), paramAnonymousString });
          ((com.tencent.mm.plugin.appbrand.utils.b.a)e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("wgs84", this, null);
          AppMethodBeat.o(46493);
          return;
        }
        Log.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(46493);
      }
    };
    ((com.tencent.mm.plugin.appbrand.utils.b.a)e.T(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("wgs84", (a.b)localObject1, null);
    int j = paramJSONObject.optInt("count", 9);
    localObject1 = paramJSONObject.optJSONObject("location");
    double d2;
    double d1;
    boolean bool1;
    if (localObject1 != null)
    {
      d2 = ((JSONObject)localObject1).optDouble("longitude");
      d1 = ((JSONObject)localObject1).optDouble("latitude");
      if ((!Double.isNaN(d2)) && (!Double.isNaN(d1))) {
        break label796;
      }
      bool1 = true;
      d1 = 91.0D;
      d2 = 181.0D;
    }
    for (;;)
    {
      localObject1 = paramJSONObject.optString("poiName", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = paramf.getContext().getString(ba.i.appbrand_my_life_around_default_hint);
      }
      for (;;)
      {
        double d3 = paramJSONObject.optDouble("locationRadius", 50.0D);
        Object localObject2 = paramJSONObject.optJSONArray("sourceType");
        JSONArray localJSONArray = paramJSONObject.optJSONArray("cameraType");
        int k = paramJSONObject.optInt("pickAlbumType", 0);
        boolean bool2;
        boolean bool3;
        label411:
        boolean bool4;
        boolean bool5;
        label430:
        int m;
        if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
        {
          bool2 = true;
          bool3 = true;
          if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
            break label541;
          }
          bool4 = false;
          bool5 = false;
          if (!bool2) {
            break label616;
          }
          s.c(paramf.getAppId(), new androidx.core.app.a.a()
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
                JsApiChooseMultiMedia.this.a(paramf, paramJSONObject, paramInt);
                AppMethodBeat.o(46496);
                return;
              }
              paramf.callback(paramInt, JsApiChooseMultiMedia.this.ZP("fail:system permission denied"));
              AppMethodBeat.o(46496);
            }
          });
          paramJSONObject = paramf.getContext();
          if ((paramJSONObject instanceof Activity)) {
            break label570;
          }
          paramf.callback(paramInt, ZP("fail"));
          m = 0;
        }
        for (;;)
        {
          if (m != 0) {
            break label616;
          }
          AppMethodBeat.o(46542);
          return;
          bool1 = true;
          d1 = 91.0D;
          d2 = 181.0D;
          break;
          bool2 = ((JSONArray)localObject2).toString().contains("camera");
          bool3 = ((JSONArray)localObject2).toString().contains("album");
          break label411;
          label541:
          bool4 = localJSONArray.toString().contains("video");
          bool5 = localJSONArray.toString().contains("photo");
          break label430;
          label570:
          boolean bool6 = i.a((Activity)paramJSONObject, paramf, "android.permission.CAMERA", 113, "", "");
          m = bool6;
          if (bool6)
          {
            s.afs(paramf.getAppId());
            m = bool6;
          }
        }
        label616:
        u.Uy(paramf.getAppId()).qvf = true;
        k.a(paramf.getAppId(), new k.c()
        {
          public final void onResume()
          {
            AppMethodBeat.i(46494);
            u.Uy(paramf.getAppId()).qvf = false;
            k.b(paramf.getAppId(), this);
            AppMethodBeat.o(46494);
          }
        });
        paramJSONObject = new ChooseRequest();
        paramJSONObject.appId = paramf.getAppId();
        paramJSONObject.count = j;
        localObject2 = com.tencent.mm.modelgeo.a.a.f(d2, d1);
        if (localObject2.length != 2)
        {
          Log.e("MicroMsg.JsApiChooseMultiMedia", "coordinate transfer error!");
          AppMethodBeat.o(46542);
          return;
        }
        paramJSONObject.longitude = localObject2[0];
        paramJSONObject.latitude = localObject2[1];
        paramJSONObject.poiName = ((String)localObject1);
        paramJSONObject.sgn = d3;
        paramJSONObject.sft = bool2;
        paramJSONObject.sfu = bool3;
        paramJSONObject.qqa = i;
        paramJSONObject.sgo = bool4;
        paramJSONObject.sgp = bool5;
        paramJSONObject.sgq = k;
        paramJSONObject.sgr = bool1;
        com.tencent.mm.plugin.appbrand.ipc.a.a(localContext, paramJSONObject, new AppBrandProxyUIProcessTask.b() {});
        AppMethodBeat.o(46542);
        return;
      }
      label796:
      bool1 = false;
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    double latitude;
    double longitude;
    String poiName;
    int qqa;
    boolean sft;
    boolean sfu;
    double sgn;
    boolean sgo;
    boolean sgp;
    int sgq;
    boolean sgr;
    
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
      readParcel(paramParcel);
      AppMethodBeat.o(46500);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiChooseMultiMedia.a.class;
    }
    
    public final String getUIAlias()
    {
      return "GalleryChooseMultiMedia";
    }
    
    public final boolean oneShotForeground()
    {
      return true;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46499);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      this.longitude = paramParcel.readDouble();
      this.latitude = paramParcel.readDouble();
      this.poiName = paramParcel.readString();
      this.sgn = paramParcel.readDouble();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.sft = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label78:
        this.sfu = bool1;
        this.qqa = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
        bool1 = true;
        label100:
        this.sgo = bool1;
        if (paramParcel.readByte() == 0) {
          break label162;
        }
        bool1 = true;
        label114:
        this.sgp = bool1;
        this.sgq = paramParcel.readInt();
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
        this.sgr = bool1;
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
      paramParcel.writeString(this.poiName);
      paramParcel.writeDouble(this.sgn);
      if (this.sft)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.sfu) {
          break label154;
        }
        b1 = 1;
        label79:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.qqa);
        if (!this.sgo) {
          break label159;
        }
        b1 = 1;
        label101:
        paramParcel.writeByte(b1);
        if (!this.sgp) {
          break label164;
        }
        b1 = 1;
        label115:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.sgq);
        if (!this.sgr) {
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
  
  static final class b
  {
    public String euP;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia
 * JD-Core Version:    0.7.0.1
 */