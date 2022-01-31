package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 549;
  public static final String NAME = "chooseMultiMedia";
  public static final String hRn;
  double hRo;
  double hRp;
  double hRq;
  double hRr;
  
  static
  {
    AppMethodBeat.i(131268);
    hRn = ah.getResources().getString(2131297158);
    AppMethodBeat.o(131268);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131266);
    if (com.tencent.mm.plugin.appbrand.n.yc(paramc.getAppId()).gRd)
    {
      paramc.h(paramInt, j("cancel", null));
      AppMethodBeat.o(131266);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131266);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(131266);
      return;
    }
    int i = paramJSONObject.optInt("maxDuration", 10);
    ab.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", new Object[] { Integer.valueOf(i) });
    if ((i <= 0) || (i > 1800))
    {
      ab.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
      paramc.h(paramInt, j("fail:invalid maxDuration parameter", null));
      AppMethodBeat.o(131266);
      return;
    }
    localContext.getSharedPreferences(ah.dsP() + "_locCache", 0).edit().putString("locStr", null).apply();
    Object localObject1 = new JsApiChooseMultiMedia.1(this, localContext);
    ((com.tencent.mm.plugin.appbrand.t.b.a)com.tencent.luggage.a.e.q(com.tencent.mm.plugin.appbrand.t.b.a.class)).b("wgs84", (a.b)localObject1, null);
    int j = paramJSONObject.optInt("count", 9);
    localObject1 = paramJSONObject.optJSONObject("location");
    double d2 = 91.0D;
    if (localObject1 != null) {
      d2 = ((JSONObject)localObject1).optDouble("longitude", 91.0D);
    }
    for (double d1 = ((JSONObject)localObject1).optDouble("latitude", 181.0D);; d1 = 181.0D)
    {
      localObject1 = paramJSONObject.optString("poiName", hRn);
      double d3 = paramJSONObject.optDouble("locationRadius", 50.0D);
      Object localObject2 = paramJSONObject.optJSONArray("sourceType");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("cameraType");
      int k = paramJSONObject.optInt("pickAlbumType", 0);
      boolean bool1;
      boolean bool2;
      boolean bool4;
      boolean bool3;
      label403:
      int m;
      if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
      {
        bool1 = true;
        bool2 = true;
        if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
          break label503;
        }
        bool4 = false;
        bool3 = false;
        if (!bool1) {
          break label577;
        }
        com.tencent.mm.plugin.appbrand.permission.n.b(paramc.getAppId(), new JsApiChooseMultiMedia.4(this, paramc, paramJSONObject, paramInt));
        paramJSONObject = paramc.getContext();
        if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
          break label532;
        }
        paramc.h(paramInt, j("fail", null));
        m = 0;
      }
      for (;;)
      {
        if (m != 0) {
          break label577;
        }
        AppMethodBeat.o(131266);
        return;
        bool1 = ((JSONArray)localObject2).toString().contains("camera");
        bool2 = ((JSONArray)localObject2).toString().contains("album");
        break;
        label503:
        bool3 = localJSONArray.toString().contains("video");
        bool4 = localJSONArray.toString().contains("photo");
        break label403;
        label532:
        boolean bool5 = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
        m = bool5;
        if (bool5)
        {
          com.tencent.mm.plugin.appbrand.permission.n.EA(paramc.getAppId());
          m = bool5;
        }
      }
      label577:
      com.tencent.mm.plugin.appbrand.n.yd(paramc.getAppId()).gRd = true;
      com.tencent.mm.plugin.appbrand.e.a(paramc.getAppId(), new JsApiChooseMultiMedia.2(this, paramc));
      paramJSONObject = new JsApiChooseMultiMedia.ChooseRequest();
      paramJSONObject.appId = paramc.getAppId();
      paramJSONObject.count = j;
      localObject2 = a.a.f(d2, d1);
      this.hRp = d2;
      this.hRo = d1;
      this.hRr = localObject2[0];
      this.hRq = localObject2[1];
      paramJSONObject.longitude = this.hRr;
      paramJSONObject.latitude = this.hRq;
      paramJSONObject.eSM = ((String)localObject1);
      paramJSONObject.fOc = d3;
      paramJSONObject.hQD = bool1;
      paramJSONObject.hQE = bool2;
      paramJSONObject.gNT = i;
      paramJSONObject.hRu = bool3;
      paramJSONObject.hRv = bool4;
      paramJSONObject.hRw = k;
      com.tencent.mm.plugin.appbrand.ipc.a.a(localContext, paramJSONObject, new JsApiChooseMultiMedia.3(this, paramc, paramInt));
      AppMethodBeat.o(131266);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia
 * JD-Core Version:    0.7.0.1
 */