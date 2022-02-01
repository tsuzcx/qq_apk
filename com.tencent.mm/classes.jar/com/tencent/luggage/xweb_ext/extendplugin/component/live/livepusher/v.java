package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.graphics.Color;
import android.os.Bundle;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class v
{
  private static n.b cJk = n.b.cHy;
  final n cJh;
  private boolean cJi;
  private boolean cJj;
  private final V2TXLivePusherJSAdapter cJo;
  boolean mInited;
  
  public v(V2TXLivePusherJSAdapter paramV2TXLivePusherJSAdapter)
  {
    AppMethodBeat.i(222068);
    this.mInited = false;
    this.cJh = cJk.TI();
    this.cJi = false;
    this.cJj = false;
    this.cJo = paramV2TXLivePusherJSAdapter;
    AppMethodBeat.o(222068);
  }
  
  private void a(Bundle paramBundle, String paramString, m.a parama)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(222135);
    if (!paramBundle.containsKey(paramString))
    {
      Log.d("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", new Object[] { paramString });
      AppMethodBeat.o(222135);
      return;
    }
    float f2 = paramBundle.getFloat(paramString, 0.0F);
    if (f2 < 0.0F) {
      Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f2), paramString });
    }
    for (;;)
    {
      f2 = f1;
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f1), paramString });
        f2 = 1.0F;
      }
      TN();
      Log.d("TXLivePusherWeEffectJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", new Object[] { parama, Float.valueOf(f2) });
      this.cJh.a(parama, f2);
      AppMethodBeat.o(222135);
      return;
      f1 = f2;
    }
  }
  
  public static void a(n.b paramb)
  {
    cJk = paramb;
  }
  
  static float b(JSONObject paramJSONObject, String paramString)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    AppMethodBeat.i(222113);
    float f3 = (float)paramJSONObject.optDouble(paramString, 1.0D);
    if (f3 < 0.0F) {
      Log.i("TXLivePusherWeEffectJSAdapter", "parseAlpha, alpha(%f) is illegal", new Object[] { Float.valueOf(f3) });
    }
    for (;;)
    {
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherWeEffectJSAdapter", "parseAlpha, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
        f1 = f2;
      }
      for (;;)
      {
        AppMethodBeat.o(222113);
        return f1;
      }
      f1 = f3;
    }
  }
  
  static o.a q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222123);
    paramJSONObject = paramJSONObject.optString("color");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseColor, colorStr is empty");
      AppMethodBeat.o(222123);
      return null;
    }
    try
    {
      int i = Color.parseColor(paramJSONObject);
      paramJSONObject = new o.a(Color.red(i), Color.green(i), Color.blue(i));
      AppMethodBeat.o(222123);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseColor, colorStr is illegal");
      AppMethodBeat.o(222123);
    }
    return null;
  }
  
  static m.c r(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222140);
    paramJSONObject = paramJSONObject.optString("stickerType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseStickerType, stickerTypeStr is empty");
      AppMethodBeat.o(222140);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("back"))
    {
      paramJSONObject = m.c.cHr;
      AppMethodBeat.o(222140);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("front"))
    {
      paramJSONObject = m.c.cHs;
      AppMethodBeat.o(222140);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("2d"))
    {
      paramJSONObject = m.c.cHt;
      AppMethodBeat.o(222140);
      return paramJSONObject;
    }
    Log.w("TXLivePusherWeEffectJSAdapter", "parseStickerType, stickerTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(222140);
    return null;
  }
  
  static m.b s(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222147);
    paramJSONObject = paramJSONObject.optString("makeupType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseMakeupType, makeupTypeStr is empty");
      AppMethodBeat.o(222147);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("lipStick"))
    {
      paramJSONObject = m.b.cHl;
      AppMethodBeat.o(222147);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeShadow"))
    {
      paramJSONObject = m.b.cHm;
      AppMethodBeat.o(222147);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("blusherStick"))
    {
      paramJSONObject = m.b.cHn;
      AppMethodBeat.o(222147);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("faceContour"))
    {
      paramJSONObject = m.b.cHo;
      AppMethodBeat.o(222147);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeBrow"))
    {
      paramJSONObject = m.b.cHp;
      AppMethodBeat.o(222147);
      return paramJSONObject;
    }
    Log.w("TXLivePusherWeEffectJSAdapter", "parseMakeupType, makeupTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(222147);
    return null;
  }
  
  private void v(Bundle paramBundle)
  {
    AppMethodBeat.i(222078);
    a(paramBundle, "skinWhiteness", m.a.cHg);
    AppMethodBeat.o(222078);
  }
  
  private void w(Bundle paramBundle)
  {
    AppMethodBeat.i(222080);
    a(paramBundle, "skinSmoothness", m.a.cHh);
    AppMethodBeat.o(222080);
  }
  
  private void x(Bundle paramBundle)
  {
    AppMethodBeat.i(222084);
    a(paramBundle, "faceThinness", m.a.cHi);
    AppMethodBeat.o(222084);
  }
  
  private void y(Bundle paramBundle)
  {
    AppMethodBeat.i(222085);
    a(paramBundle, "eyeBigness", m.a.cHj);
    AppMethodBeat.o(222085);
  }
  
  final boolean TM()
  {
    AppMethodBeat.i(222075);
    if ((this.cJj) && (this.cJh.isEnabled()))
    {
      AppMethodBeat.o(222075);
      return true;
    }
    AppMethodBeat.o(222075);
    return false;
  }
  
  final void TN()
  {
    AppMethodBeat.i(222150);
    if (!this.cJi)
    {
      Log.d("TXLivePusherWeEffectJSAdapter", "applyWeEffect");
      this.cJo.setVideoProcessListener(this.cJh);
      this.cJi = true;
    }
    AppMethodBeat.o(222150);
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(222073);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(222073);
      return;
    }
    this.cJj = paramBundle.getBoolean("customEffect", this.cJj);
    if (TM())
    {
      Log.i("TXLivePusherWeEffectJSAdapter", "parseAndApplyParams, useCustomEffect");
      v(paramBundle);
      w(paramBundle);
      x(paramBundle);
      y(paramBundle);
    }
    AppMethodBeat.o(222073);
  }
  
  final boolean p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222104);
    if (!TM())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
      AppMethodBeat.o(222104);
      return false;
    }
    m.c localc = r(paramJSONObject);
    if (localc == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickerType is null");
      AppMethodBeat.o(222104);
      return false;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("stickers");
    int j;
    if (localJSONArray != null)
    {
      j = localJSONArray.length();
      if (j != 0) {}
    }
    else
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickersJsonArr is empty");
      AppMethodBeat.o(222104);
      return false;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject == null)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickerJsonObj(%d) is null", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(222104);
        return false;
      }
      try
      {
        String str1 = localJSONObject.getString("title");
        int k = localJSONObject.getInt("len");
        String str2 = localJSONObject.getString("path");
        if (Util.isNullOrNil(str2))
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, resDirPath is empty", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(222104);
          return false;
        }
        String str3 = localJSONObject.optString("md5", "");
        paramJSONObject = null;
        if ((m.c.cHt == localc) || (m.c.cHs == localc))
        {
          paramJSONObject = localJSONObject.getJSONArray("pos");
          if (4 != paramJSONObject.length())
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(222104);
            return false;
          }
          paramJSONObject = new StickerItemInfo.a(paramJSONObject.getDouble(0), paramJSONObject.getDouble(1), paramJSONObject.getDouble(2), paramJSONObject.getDouble(3));
        }
        Object localObject1 = StickerItemInfo.StickerBackType.BACKGROUND;
        if (m.c.cHr == localc)
        {
          localObject2 = StickerItemInfo.StickerBackType.from(localJSONObject.getInt("segtype"));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, type is null", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(222104);
            return false;
          }
        }
        int m = localJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
        Object localObject2 = StickerItemInfo.TriggerAction.from(m);
        if (localObject2 == null)
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
          AppMethodBeat.o(222104);
          return false;
        }
        localArrayList.add(new StickerItemInfo(localJSONObject.optInt("id", i), str1, k, (StickerItemInfo.TriggerAction)localObject2, str2, str3, paramJSONObject, (StickerItemInfo.StickerBackType)localObject1));
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", new Object[] { Integer.valueOf(i), paramJSONObject });
        AppMethodBeat.o(222104);
        return false;
      }
    }
    TN();
    Log.d("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickerType: %s", new Object[] { localc });
    boolean bool = this.cJh.a(localc, localArrayList);
    AppMethodBeat.o(222104);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.v
 * JD-Core Version:    0.7.0.1
 */