package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
    AppMethodBeat.i(226976);
    ArrayList localArrayList = new ArrayList(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      localArrayList.add(new GameShareOption(0, paramc.getContext().getString(2131756078), false));
      AppMethodBeat.o(226976);
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
        Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", paramJSONArray, "hy: json exception!", new Object[0]);
        localArrayList.clear();
        localArrayList.add(new GameShareOption(0, paramc.getContext().getString(2131756078), false));
        AppMethodBeat.o(226976);
        return localArrayList;
      }
    }
    AppMethodBeat.o(226976);
    return localArrayList;
  }
  
  private void a(c paramc, final JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.game.g.d<JSONObject> paramd)
  {
    AppMethodBeat.i(226974);
    try
    {
      Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForMediaSdk %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
      JSONObject localJSONObject = new JSONObject();
      Object localObject = paramJSONObject.optString("videoSrc", "");
      if (Util.isNullOrNil((String)localObject))
      {
        paramd.a(2, -3, "sdkParmas videoSrc not set", new JSONObject());
        AppMethodBeat.o(226974);
        return;
      }
      localJSONObject.put("videoPath", aa.z(paramc.getRuntime().OK().VY((String)localObject).her()));
      localObject = paramJSONObject.optString("bgmSrc", "");
      if (!Util.isNullOrNil((String)localObject)) {
        localJSONObject.put("audioPath", aa.z(paramc.getRuntime().OK().VY((String)localObject).her()));
      }
      localObject = paramJSONObject.optJSONArray("timeRange");
      if (localObject != null) {
        localJSONObject.put("videoSlices", localObject);
      }
      localJSONObject.put("audioVolume", paramJSONObject.optDouble("volume", 1.0D));
      localJSONObject.put("atempo", paramJSONObject.optDouble("atempo", 1.0D));
      localJSONObject.put("mix", paramJSONObject.optBoolean("audioMix"));
      paramJSONObject = d(paramc, new Date().getTime() + ".mp4");
      if ((paramJSONObject == null) || (Util.isNullOrNil(paramJSONObject.lsB)) || (Util.isNullOrNil(paramJSONObject.lsC)))
      {
        paramd.a(1, -1, "create file failed", new JSONObject());
        AppMethodBeat.o(226974);
        return;
      }
      localJSONObject.put("filePath", paramJSONObject.lsB);
      d(paramc).a(localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(226974);
      return;
    }
    catch (JSONException paramc)
    {
      paramd.a(2, -1, String.format("editForMediaSdk error: " + paramc.getMessage(), new Object[0]), new JSONObject());
      AppMethodBeat.o(226974);
    }
  }
  
  private static ArrayList<String> q(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(226977);
    ArrayList localArrayList = new ArrayList(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      AppMethodBeat.o(226977);
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
          Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", paramJSONArray, "hy: convertToolBars json exception! " + paramJSONArray.getMessage(), new Object[0]);
        }
      }
    }
    AppMethodBeat.o(226977);
    return localArrayList;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(226973);
    Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
    if (paramc.ay(Activity.class) == null)
    {
      paramc.i(paramInt, h("fail:internal error invalid android context", null));
      AppMethodBeat.o(226973);
      return;
    }
    int i = paramJSONObject.optInt("editType");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("sdkParmas");
    paramJSONObject = paramJSONObject.optJSONObject("editorParmas");
    if (i == 1)
    {
      if (localJSONObject == null)
      {
        paramc.i(paramInt, h(String.format("fail: sdkParmas get failed", new Object[0]), null));
        AppMethodBeat.o(226973);
        return;
      }
      a(paramc, localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(226973);
      return;
    }
    if (i == 2)
    {
      if (paramJSONObject == null)
      {
        paramc.i(paramInt, h(String.format("fail: editorParmas get failed", new Object[0]), null));
        AppMethodBeat.o(226973);
        return;
      }
      b(paramc, paramJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
      AppMethodBeat.o(226973);
      return;
    }
    if ((localJSONObject == null) || (paramJSONObject == null))
    {
      paramc.i(paramInt, h(String.format("fail: sdkParmas or editorParmas get failed", new Object[0]), null));
      AppMethodBeat.o(226973);
      return;
    }
    a(paramc, localJSONObject, new com.tencent.mm.plugin.appbrand.game.g.d() {});
    AppMethodBeat.o(226973);
  }
  
  final void b(final c paramc, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.game.g.d<JSONObject> paramd)
  {
    AppMethodBeat.i(226975);
    Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: editForNativeView %s %s", new Object[] { "openVideoEditor", paramJSONObject.toString() });
    final int i = com.tencent.luggage.sdk.g.a.aK(this);
    f.aK(paramc.getContext()).b(new f.c()
    {
      public final boolean c(final int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(226972);
        if (paramAnonymousInt1 == i)
        {
          Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: on result callback, result code: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt2 == 3001))
          {
            Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: user cancelled share!");
            paramd.a(3, 803, "user cancelled", new JSONObject());
          }
          for (;;)
          {
            AppMethodBeat.o(226972);
            return true;
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.hasExtra("key_req_result")))
            {
              Object localObject = (SightCaptureResult)paramAnonymousIntent.getParcelableExtra("key_req_result");
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_selected_item", 0);
              Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d", new Object[] { Boolean.valueOf(((SightCaptureResult)localObject).tkD), ((SightCaptureResult)localObject).zsA, ((SightCaptureResult)localObject).zsB, ((SightCaptureResult)localObject).zsD, Integer.valueOf(paramAnonymousInt1) });
              if (!((SightCaptureResult)localObject).tkD)
              {
                paramd.a(3, 804, "not a video", new JSONObject());
              }
              else if ((Util.isNullOrNil(((SightCaptureResult)localObject).zsC)) || (Util.isNullOrNil(((SightCaptureResult)localObject).zsD)))
              {
                paramd.a(1, 804, "edit failed", new JSONObject());
              }
              else
              {
                paramAnonymousIntent = ((SightCaptureResult)localObject).zsA;
                localObject = ((SightCaptureResult)localObject).zsB;
                Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.PF(paramAnonymousIntent);
                if (localBitmap != null) {}
                for (;;)
                {
                  try
                  {
                    BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject, true);
                    a.d(paramc).a(paramAnonymousIntent, new com.tencent.mm.plugin.appbrand.game.g.d() {});
                  }
                  catch (IOException localIOException)
                  {
                    Log.printErrStackTrace("MicroMsg.GameRecord.JsApiOpenVideoEditor", localIOException, "hy: exception when convert bitmap", new Object[0]);
                    continue;
                  }
                  Log.i("MicroMsg.GameRecord.JsApiOpenVideoEditor", "hy: generated thumb path is null!");
                }
              }
            }
            else
            {
              paramd.a(1, 804, "edit file failed", new JSONObject());
            }
          }
        }
        AppMethodBeat.o(226972);
        return false;
      }
    });
    Object localObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil((String)localObject))
    {
      paramd.a(2, -3, "editorParmas filePath not set", new JSONObject());
      AppMethodBeat.o(226975);
      return;
    }
    paramd = aa.z(paramc.getRuntime().OK().VY((String)localObject).her());
    String str = paramJSONObject.optString("title", "");
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("buttonOptions");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("toolBars");
    int j = paramJSONObject.optInt("minDuration", -1);
    int k = paramJSONObject.optInt("maxDuration", -1);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("k_ext_editor_from", 1);
    ((Bundle)localObject).putString("k_ext_wording", str);
    ((Bundle)localObject).putParcelableArrayList("k_ext_share_options", a(paramc, localJSONArray1));
    ((Bundle)localObject).putStringArrayList("k_ext_tool_bars", q(localJSONArray2));
    if (j > 0) {
      ((Bundle)localObject).putInt("minDuration", j);
    }
    if (k > 0) {
      ((Bundle)localObject).putInt("maxDuration", k);
    }
    if ((paramc.getRuntime() != null) && (paramc.getRuntime().bsB() != null)) {}
    for (paramJSONObject = paramc.getRuntime().bsB().brandName;; paramJSONObject = "")
    {
      ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(paramc.getContext(), paramc.getAppId(), paramJSONObject, paramd, i, (Bundle)localObject);
      AppMethodBeat.o(226975);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a
 * JD-Core Version:    0.7.0.1
 */