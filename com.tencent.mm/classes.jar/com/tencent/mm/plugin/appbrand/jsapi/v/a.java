package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 705;
  public static final String NAME = "openVideoEditor";
  
  private static ArrayList<GameShareOption> a(c paramc, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(188516);
    ArrayList localArrayList = new ArrayList(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      localArrayList.add(new GameShareOption(0, paramc.getContext().getString(2131755972), false));
      AppMethodBeat.o(188516);
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length()) {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new GameShareOption(localJSONObject.getInt("id"), localJSONObject.getString("name"), localJSONObject.optBoolean("needExtUrl", false)));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        ad.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", paramJSONArray, "hy: json exception!", new Object[0]);
        localArrayList.clear();
        localArrayList.add(new GameShareOption(0, paramc.getContext().getString(2131755972), false));
        AppMethodBeat.o(188516);
        return localArrayList;
      }
    }
    AppMethodBeat.o(188516);
    return localArrayList;
  }
  
  private void a(final c paramc, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.game.g.d<JSONObject> paramd)
  {
    AppMethodBeat.i(188514);
    try
    {
      ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForMediaSdk %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
      JSONObject localJSONObject = new JSONObject();
      Object localObject = paramJSONObject.optString("videoSrc", "");
      if (bt.isNullOrNil((String)localObject))
      {
        paramd.a(2, -3, "sdkParmas videoSrc not set", new JSONObject());
        AppMethodBeat.o(188514);
        return;
      }
      localJSONObject.put("videoPath", com.tencent.mm.vfs.q.B(paramc.getRuntime().EY().Mj((String)localObject).fOK()));
      localObject = paramJSONObject.optString("bgmSrc", "");
      if (!bt.isNullOrNil((String)localObject)) {
        localJSONObject.put("audioPath", com.tencent.mm.vfs.q.B(paramc.getRuntime().EY().Mj((String)localObject).fOK()));
      }
      localObject = paramJSONObject.optJSONArray("timeRange");
      if (localObject != null) {
        localJSONObject.put("videoSlices", localObject);
      }
      localJSONObject.put("audioVolume", paramJSONObject.optDouble("volume", 1.0D));
      localJSONObject.put("atempo", paramJSONObject.optDouble("atempo", 1.0D));
      localJSONObject.put("mix", paramJSONObject.optBoolean("audioMix"));
      paramc = c(paramc, new Date().getTime() + ".mp4");
      if ((paramc == null) || (bt.isNullOrNil(paramc.klC)) || (bt.isNullOrNil(paramc.klD)))
      {
        paramd.a(1, -1, "create file failed", new JSONObject());
        AppMethodBeat.o(188514);
        return;
      }
      localJSONObject.put("filePath", paramc.klC);
      com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null).a(localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(188514);
      return;
    }
    catch (JSONException paramc)
    {
      paramd.a(2, -1, String.format("editForMediaSdk error: " + paramc.getMessage(), new Object[0]), new JSONObject());
      AppMethodBeat.o(188514);
    }
  }
  
  private static ArrayList<String> p(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(188517);
    ArrayList localArrayList = new ArrayList(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      AppMethodBeat.o(188517);
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          localArrayList.add(paramJSONArray.getString(i));
          i += 1;
        }
        catch (JSONException paramJSONArray)
        {
          ad.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", paramJSONArray, "hy: convertToolBars json exception! " + paramJSONArray.getMessage(), new Object[0]);
        }
      }
    }
    AppMethodBeat.o(188517);
    return localArrayList;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(188513);
    ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
    if (paramc.au(Activity.class) == null)
    {
      paramc.h(paramInt, e("fail:internal error invalid android context", null));
      AppMethodBeat.o(188513);
      return;
    }
    int i = paramJSONObject.optInt("editType");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("sdkParmas");
    paramJSONObject = paramJSONObject.optJSONObject("editorParmas");
    if (i == 1)
    {
      if (localJSONObject == null)
      {
        paramc.h(paramInt, e(String.format("fail: sdkParmas get failed", new Object[0]), null));
        AppMethodBeat.o(188513);
        return;
      }
      a(paramc, localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(188513);
      return;
    }
    if (i == 2)
    {
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e(String.format("fail: editorParmas get failed", new Object[0]), null));
        AppMethodBeat.o(188513);
        return;
      }
      b(paramc, paramJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(188513);
      return;
    }
    if ((localJSONObject == null) || (paramJSONObject == null))
    {
      paramc.h(paramInt, e(String.format("fail: sdkParmas or editorParmas get failed", new Object[0]), null));
      AppMethodBeat.o(188513);
      return;
    }
    a(paramc, localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
    AppMethodBeat.o(188513);
  }
  
  final void b(c paramc, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.game.g.d<JSONObject> paramd)
  {
    AppMethodBeat.i(188515);
    ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForNativeView %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
    final int i = com.tencent.luggage.sdk.g.a.aC(this);
    com.tencent.luggage.h.e.aA(paramc.getContext()).b(new e.c()
    {
      public final boolean b(final int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(188512);
        if (paramAnonymousInt1 == i)
        {
          ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: on result callback, result code: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt2 == 3001))
          {
            ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: user cancelled share!");
            paramd.a(3, 803, "user cancelled", new JSONObject());
          }
          for (;;)
          {
            AppMethodBeat.o(188512);
            return true;
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.hasExtra("key_req_result")))
            {
              Object localObject = (SightCaptureResult)paramAnonymousIntent.getParcelableExtra("key_req_result");
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_selected_item", 0);
              ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d", new Object[] { Boolean.valueOf(((SightCaptureResult)localObject).pzW), ((SightCaptureResult)localObject).vMu, ((SightCaptureResult)localObject).vMv, ((SightCaptureResult)localObject).vMx, Integer.valueOf(paramAnonymousInt1) });
              if (!((SightCaptureResult)localObject).pzW)
              {
                paramd.a(3, 804, "not a video", new JSONObject());
              }
              else if ((bt.isNullOrNil(((SightCaptureResult)localObject).vMw)) || (bt.isNullOrNil(((SightCaptureResult)localObject).vMx)))
              {
                paramd.a(1, 804, "edit failed", new JSONObject());
              }
              else
              {
                paramAnonymousIntent = ((SightCaptureResult)localObject).vMu;
                localObject = ((SightCaptureResult)localObject).vMv;
                Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Gq(paramAnonymousIntent);
                if (localBitmap != null) {}
                for (;;)
                {
                  try
                  {
                    com.tencent.mm.sdk.platformtools.g.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject, true);
                    com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null).a(paramAnonymousIntent, new com.tencent.mm.plugin.appbrand.game.g.d() {});
                  }
                  catch (IOException localIOException)
                  {
                    ad.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", localIOException, "hy: exception when convert bitmap", new Object[0]);
                    continue;
                  }
                  ad.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: generated thumb path is null!");
                }
              }
            }
            else
            {
              paramd.a(1, 804, "edit file failed", new JSONObject());
            }
          }
        }
        AppMethodBeat.o(188512);
        return false;
      }
    });
    Object localObject = paramJSONObject.optString("filePath", "");
    if (bt.isNullOrNil((String)localObject))
    {
      paramd.a(2, -3, "editorParmas filePath not set", new JSONObject());
      AppMethodBeat.o(188515);
      return;
    }
    paramd = com.tencent.mm.vfs.q.B(paramc.getRuntime().EY().Mj((String)localObject).fOK());
    String str = paramJSONObject.optString("title", "");
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("buttonOptions");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("toolBars");
    int j = paramJSONObject.optInt("minDuration", -1);
    int k = paramJSONObject.optInt("maxDuration", -1);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("k_ext_editor_from", 1);
    ((Bundle)localObject).putString("k_ext_wording", str);
    ((Bundle)localObject).putParcelableArrayList("k_ext_share_options", a(paramc, localJSONArray1));
    ((Bundle)localObject).putStringArrayList("k_ext_tool_bars", p(localJSONArray2));
    if (j > 0) {
      ((Bundle)localObject).putInt("minDuration", j);
    }
    if (k > 0) {
      ((Bundle)localObject).putInt("maxDuration", k);
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().aXb() != null)) {}
    for (paramJSONObject = paramc.getRuntime().aXb().doD;; paramJSONObject = "")
    {
      ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(paramc.getContext(), paramc.getAppId(), paramJSONObject, paramd, i, (Bundle)localObject);
      AppMethodBeat.o(188515);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a
 * JD-Core Version:    0.7.0.1
 */