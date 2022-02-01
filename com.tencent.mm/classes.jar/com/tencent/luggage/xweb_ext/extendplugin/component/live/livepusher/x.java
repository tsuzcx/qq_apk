package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.graphics.Color;
import android.os.Bundle;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class x
{
  private static p.b eCQ = p.b.eAV;
  private final n eCR;
  private final p eCS;
  private boolean eCT;
  private boolean eCU;
  boolean mInited;
  
  public x(V2TXLivePusherJSAdapter paramV2TXLivePusherJSAdapter)
  {
    this(y.a(paramV2TXLivePusherJSAdapter));
    AppMethodBeat.i(220852);
    AppMethodBeat.o(220852);
  }
  
  private x(n paramn)
  {
    AppMethodBeat.i(220859);
    this.mInited = false;
    this.eCS = eCQ.aun();
    this.eCT = false;
    this.eCU = false;
    this.eCR = paramn;
    AppMethodBeat.o(220859);
  }
  
  public x(TXLivePusher paramTXLivePusher)
  {
    this(y.b(paramTXLivePusher));
    AppMethodBeat.i(220845);
    AppMethodBeat.o(220845);
  }
  
  private static o.b A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221012);
    paramJSONObject = paramJSONObject.optString("makeupType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseMakeupType, makeupTypeStr is empty");
      AppMethodBeat.o(221012);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("lipStick"))
    {
      paramJSONObject = o.b.eAI;
      AppMethodBeat.o(221012);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeShadow"))
    {
      paramJSONObject = o.b.eAJ;
      AppMethodBeat.o(221012);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("blusherStick"))
    {
      paramJSONObject = o.b.eAK;
      AppMethodBeat.o(221012);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("faceContour"))
    {
      paramJSONObject = o.b.eAL;
      AppMethodBeat.o(221012);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeBrow"))
    {
      paramJSONObject = o.b.eAM;
      AppMethodBeat.o(221012);
      return paramJSONObject;
    }
    Log.w("TXLivePusherWeEffectJSAdapter", "parseMakeupType, makeupTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(221012);
    return null;
  }
  
  private void C(Bundle paramBundle)
  {
    AppMethodBeat.i(220888);
    a(paramBundle, "skinWhiteness", o.a.eAD);
    AppMethodBeat.o(220888);
  }
  
  private void D(Bundle paramBundle)
  {
    AppMethodBeat.i(220896);
    a(paramBundle, "skinSmoothness", o.a.eAE);
    AppMethodBeat.o(220896);
  }
  
  private void E(Bundle paramBundle)
  {
    AppMethodBeat.i(220907);
    a(paramBundle, "faceThinness", o.a.eAF);
    AppMethodBeat.o(220907);
  }
  
  private void F(Bundle paramBundle)
  {
    AppMethodBeat.i(220917);
    a(paramBundle, "eyeBigness", o.a.eAG);
    AppMethodBeat.o(220917);
  }
  
  private void a(Bundle paramBundle, String paramString, o.a parama)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(221010);
    if (!paramBundle.containsKey(paramString))
    {
      Log.d("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", new Object[] { paramString });
      AppMethodBeat.o(221010);
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
      auv();
      Log.d("TXLivePusherWeEffectJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", new Object[] { parama, Float.valueOf(f2) });
      this.eCS.a(parama, f2);
      AppMethodBeat.o(221010);
      return;
      f1 = f2;
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(220868);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(220868);
      return;
    }
    this.eCU = paramBundle.getBoolean("customEffect", this.eCU);
    if (aur())
    {
      Log.i("TXLivePusherWeEffectJSAdapter", "parseAndApplyParams, useCustomEffect");
      C(paramBundle);
      D(paramBundle);
      E(paramBundle);
      F(paramBundle);
    }
    AppMethodBeat.o(220868);
  }
  
  public static void a(p.b paramb)
  {
    eCQ = paramb;
  }
  
  private boolean aur()
  {
    AppMethodBeat.i(220878);
    if ((this.eCU) && (this.eCS.isEnabled()))
    {
      AppMethodBeat.o(220878);
      return true;
    }
    AppMethodBeat.o(220878);
    return false;
  }
  
  private boolean aus()
  {
    AppMethodBeat.i(220933);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "clearFilters, useCustomEffect is false");
      AppMethodBeat.o(220933);
      return false;
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "clearFilters");
    this.eCS.clearFilters();
    AppMethodBeat.o(220933);
    return true;
  }
  
  private boolean aut()
  {
    AppMethodBeat.i(220956);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "clearStickers, useCustomEffect is false");
      AppMethodBeat.o(220956);
      return false;
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "clearStickers");
    this.eCS.aul();
    AppMethodBeat.o(220956);
    return true;
  }
  
  private boolean auu()
  {
    AppMethodBeat.i(221005);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "clearMakeups, useCustomEffect is false");
      AppMethodBeat.o(221005);
      return false;
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "clearMakeups");
    this.eCS.aum();
    AppMethodBeat.o(221005);
    return true;
  }
  
  private void auv()
  {
    AppMethodBeat.i(221014);
    if (!this.eCT)
    {
      Log.d("TXLivePusherWeEffectJSAdapter", "applyWeEffect");
      this.eCR.setVideoProcessListener(this.eCS);
      this.eCT = true;
    }
    AppMethodBeat.o(221014);
  }
  
  private static float b(JSONObject paramJSONObject, String paramString)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    AppMethodBeat.i(220995);
    float f3 = (float)paramJSONObject.optDouble(paramString, 1.0D);
    if (f3 < 0.0F) {
      Log.i("TXLivePusherWeEffectJSAdapter", "parseRate, rate(%f) is illegal", new Object[] { Float.valueOf(f3) });
    }
    for (;;)
    {
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherWeEffectJSAdapter", "parseRate, rate(%f)  is illegal", new Object[] { Float.valueOf(f1) });
        f1 = f2;
      }
      for (;;)
      {
        AppMethodBeat.o(220995);
        return f1;
      }
      f1 = f3;
    }
  }
  
  private boolean o(JSONObject paramJSONObject)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    AppMethodBeat.i(220927);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyFilter, useCustomEffect is false");
      AppMethodBeat.o(220927);
      return false;
    }
    String str = paramJSONObject.optString("path", null);
    if (Util.isNullOrNil(str))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyFilter, resourcePath is null");
      AppMethodBeat.o(220927);
      return false;
    }
    float f3 = (float)paramJSONObject.optDouble("alpha", 1.0D);
    if (f3 < 0.0F) {
      Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, alpha(%f) is illegal", new Object[] { Float.valueOf(f3) });
    }
    for (;;)
    {
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
        f1 = f2;
      }
      for (;;)
      {
        auv();
        Log.d("TXLivePusherWeEffectJSAdapter", "applyFilter, resourcePath: %s, alpha: %f", new Object[] { str, Float.valueOf(f1) });
        this.eCS.c(str, f1);
        AppMethodBeat.o(220927);
        return true;
      }
      f1 = f3;
    }
  }
  
  private boolean p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220941);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applySticker, useCustomEffect is false");
      AppMethodBeat.o(220941);
      return false;
    }
    String str = paramJSONObject.optString("path", null);
    if (Util.isNullOrNil(str))
    {
      Log.i("TXLivePusherWeEffectJSAdapter", "applySticker, resourcePath is null");
      boolean bool = q(paramJSONObject);
      AppMethodBeat.o(220941);
      return bool;
    }
    paramJSONObject = z(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applySticker, stickerType is null");
      AppMethodBeat.o(220941);
      return false;
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "applySticker, stickerType: %s, resourcePath: %s", new Object[] { paramJSONObject, str });
    this.eCS.a(paramJSONObject, str);
    AppMethodBeat.o(220941);
    return true;
  }
  
  private boolean q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220951);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
      AppMethodBeat.o(220951);
      return false;
    }
    o.c localc = z(paramJSONObject);
    if (localc == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickerType is null");
      AppMethodBeat.o(220951);
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
      AppMethodBeat.o(220951);
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
        AppMethodBeat.o(220951);
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
          AppMethodBeat.o(220951);
          return false;
        }
        String str3 = localJSONObject.optString("md5", "");
        paramJSONObject = null;
        if ((o.c.eAQ == localc) || (o.c.eAP == localc))
        {
          paramJSONObject = localJSONObject.getJSONArray("pos");
          if (4 != paramJSONObject.length())
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(220951);
            return false;
          }
          paramJSONObject = new StickerItemInfo.a(paramJSONObject.getDouble(0), paramJSONObject.getDouble(1), paramJSONObject.getDouble(2), paramJSONObject.getDouble(3));
        }
        Object localObject1 = StickerItemInfo.StickerBackType.BACKGROUND;
        if (o.c.eAO == localc)
        {
          localObject2 = StickerItemInfo.StickerBackType.from(localJSONObject.getInt("segtype"));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, type is null", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(220951);
            return false;
          }
        }
        int m = localJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
        Object localObject2 = StickerItemInfo.TriggerAction.from(m);
        if (localObject2 == null)
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
          AppMethodBeat.o(220951);
          return false;
        }
        localArrayList.add(new StickerItemInfo(localJSONObject.optInt("id", i), str1, k, (StickerItemInfo.TriggerAction)localObject2, str2, str3, paramJSONObject, (StickerItemInfo.StickerBackType)localObject1));
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", new Object[] { Integer.valueOf(i), paramJSONObject });
        AppMethodBeat.o(220951);
        return false;
      }
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "applyStickerWorkaround, stickerType: %s", new Object[] { localc });
    boolean bool = this.eCS.a(localc, localArrayList);
    AppMethodBeat.o(220951);
    return bool;
  }
  
  private boolean r(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220960);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeup, useCustomEffect is false");
      AppMethodBeat.o(220960);
      return false;
    }
    boolean bool = s(paramJSONObject);
    AppMethodBeat.o(220960);
    return bool;
  }
  
  private boolean s(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220967);
    if (!aur())
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, useCustomEffect is false");
      AppMethodBeat.o(220967);
      return false;
    }
    o.b localb = A(paramJSONObject);
    if (localb == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupType is null");
      AppMethodBeat.o(220967);
      return false;
    }
    paramJSONObject = paramJSONObject.optJSONObject("makeup");
    if (paramJSONObject == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupJsonObj is null");
      AppMethodBeat.o(220967);
      return false;
    }
    auv();
    Log.d("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupType: %s", new Object[] { localb });
    switch (1.eCV[localb.ordinal()])
    {
    default: 
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, should not reach");
      AppMethodBeat.o(220967);
      return false;
    case 1: 
      paramJSONObject = t(paramJSONObject);
      if (paramJSONObject == null)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, lipStickInfo is null");
        AppMethodBeat.o(220967);
        return false;
      }
      bool = this.eCS.a(paramJSONObject);
      AppMethodBeat.o(220967);
      return bool;
    case 2: 
      paramJSONObject = u(paramJSONObject);
      if (paramJSONObject == null)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, eyeShadowInfo is null");
        AppMethodBeat.o(220967);
        return false;
      }
      bool = this.eCS.a(paramJSONObject);
      AppMethodBeat.o(220967);
      return bool;
    case 3: 
      paramJSONObject = v(paramJSONObject);
      if (paramJSONObject == null)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, blusherStickInfo is null");
        AppMethodBeat.o(220967);
        return false;
      }
      bool = this.eCS.a(paramJSONObject);
      AppMethodBeat.o(220967);
      return bool;
    case 4: 
      paramJSONObject = w(paramJSONObject);
      if (paramJSONObject == null)
      {
        Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, faceContourInfo is null");
        AppMethodBeat.o(220967);
        return false;
      }
      bool = this.eCS.a(paramJSONObject);
      AppMethodBeat.o(220967);
      return bool;
    }
    paramJSONObject = x(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, eyeBrowInfo is null");
      AppMethodBeat.o(220967);
      return false;
    }
    boolean bool = this.eCS.a(paramJSONObject);
    AppMethodBeat.o(220967);
    return bool;
  }
  
  private static q t(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220970);
    float f = b(paramJSONObject, "alpha");
    q.a locala = y(paramJSONObject);
    if (locala == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, color is null");
      AppMethodBeat.o(220970);
      return null;
    }
    q.b localb = q.b.mG(paramJSONObject.optInt("lipstickType", 0));
    if (localb == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, type is null");
      AppMethodBeat.o(220970);
      return null;
    }
    int i = paramJSONObject.optInt("faceModel", 0);
    if (i != 0)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, faceModel is illegal");
      AppMethodBeat.o(220970);
      return null;
    }
    paramJSONObject = new q(f, locala, localb, i, q.c.eBm);
    AppMethodBeat.o(220970);
    return paramJSONObject;
  }
  
  private static d u(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220978);
    float f = b(paramJSONObject, "alpha");
    a locala = a.mE(paramJSONObject.optInt("blendMode", 0));
    if (locala == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeShadowInfoV2, blendMode is null");
      AppMethodBeat.o(220978);
      return null;
    }
    String str1 = paramJSONObject.optString("path", "");
    if (Util.isNullOrNil(str1))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeShadowInfoV2, path is empty");
      AppMethodBeat.o(220978);
      return null;
    }
    String str2 = paramJSONObject.optString("pathMd5", "");
    String str3 = paramJSONObject.optString("shimmerPosition", "");
    if (Util.isNullOrNil(str3))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeShadowInfoV2, shimmerPosPath is empty");
      AppMethodBeat.o(220978);
      return null;
    }
    paramJSONObject = new d(f, locala, str1, str2, str3, paramJSONObject.optString("shimmerPositionMD5", ""));
    AppMethodBeat.o(220978);
    return paramJSONObject;
  }
  
  private static b v(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220984);
    float f = b(paramJSONObject, "alpha");
    a locala = a.mE(paramJSONObject.optInt("blendMode", 0));
    if (locala == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, blendMode is null");
      AppMethodBeat.o(220984);
      return null;
    }
    String str1 = paramJSONObject.optString("path", "");
    if (Util.isNullOrNil(str1))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, path is empty");
      AppMethodBeat.o(220984);
      return null;
    }
    String str2 = paramJSONObject.optString("pathMd5", "");
    int i = paramJSONObject.optInt("faceModel", 0);
    if (i != 0)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, faceModel is illegal");
      AppMethodBeat.o(220984);
      return null;
    }
    paramJSONObject = new b(f, i, locala, str1, str2);
    AppMethodBeat.o(220984);
    return paramJSONObject;
  }
  
  private static e w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220988);
    float f = b(paramJSONObject, "alpha");
    String str1 = paramJSONObject.optString("path", "");
    if (Util.isNullOrNil(str1))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseFaceContourInfo, path is empty");
      AppMethodBeat.o(220988);
      return null;
    }
    String str2 = paramJSONObject.optString("pathMd5", "");
    int i = paramJSONObject.optInt("faceModel", 0);
    if (i != 0)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseFaceContourInfo, faceModel is illegal");
      AppMethodBeat.o(220988);
      return null;
    }
    paramJSONObject = new e(i, f, str1, str2);
    AppMethodBeat.o(220988);
    return paramJSONObject;
  }
  
  private static c x(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220993);
    float f = b(paramJSONObject, "alpha");
    int i = paramJSONObject.optInt("faceModel", 0);
    if (i != 0)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, faceModel is illegal");
      AppMethodBeat.o(220993);
      return null;
    }
    a locala = a.mE(paramJSONObject.optInt("blendMode", 0));
    if (locala == null)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, blendMode is null");
      AppMethodBeat.o(220993);
      return null;
    }
    String str = paramJSONObject.optString("path", "");
    if (Util.isNullOrNil(str))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, path is empty");
      AppMethodBeat.o(220993);
      return null;
    }
    paramJSONObject = new c(f, i, locala, str, paramJSONObject.optString("pathMd5", ""), b(paramJSONObject, "shrinkRate"));
    AppMethodBeat.o(220993);
    return paramJSONObject;
  }
  
  private static q.a y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220999);
    paramJSONObject = paramJSONObject.optString("color");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseColor, colorStr is empty");
      AppMethodBeat.o(220999);
      return null;
    }
    try
    {
      int i = Color.parseColor(paramJSONObject);
      paramJSONObject = new q.a(Color.red(i), Color.green(i), Color.blue(i));
      AppMethodBeat.o(220999);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseColor, colorStr is illegal");
      AppMethodBeat.o(220999);
    }
    return null;
  }
  
  private static o.c z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221011);
    paramJSONObject = paramJSONObject.optString("stickerType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherWeEffectJSAdapter", "parseStickerType, stickerTypeStr is empty");
      AppMethodBeat.o(221011);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("back"))
    {
      paramJSONObject = o.c.eAO;
      AppMethodBeat.o(221011);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("front"))
    {
      paramJSONObject = o.c.eAP;
      AppMethodBeat.o(221011);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("2d"))
    {
      paramJSONObject = o.c.eAQ;
      AppMethodBeat.o(221011);
      return paramJSONObject;
    }
    Log.w("TXLivePusherWeEffectJSAdapter", "parseStickerType, stickerTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(221011);
    return null;
  }
  
  public final void A(Bundle paramBundle)
  {
    AppMethodBeat.i(221016);
    if (paramBundle == null)
    {
      AppMethodBeat.o(221016);
      return;
    }
    a(paramBundle, true);
    this.mInited = true;
    AppMethodBeat.o(221016);
  }
  
  public final void B(Bundle paramBundle)
  {
    AppMethodBeat.i(221018);
    if (paramBundle == null)
    {
      AppMethodBeat.o(221018);
      return;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(221018);
      return;
    }
    a(paramBundle, false);
    AppMethodBeat.o(221018);
  }
  
  public final void c(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(221015);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      AppMethodBeat.o(221015);
      return;
    }
    a(paramBundle, true);
    this.mInited = true;
    AppMethodBeat.o(221015);
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    int n = 1;
    int i1 = 1;
    int i = 1;
    int i2 = 0;
    int k = 0;
    int i3 = 0;
    int m = 0;
    int i4 = 0;
    int j = 0;
    AppMethodBeat.i(221020);
    if (paramString.equalsIgnoreCase("applyFilter"))
    {
      if ((paramJSONObject != null) && (o(paramJSONObject)))
      {
        if (i == 0) {
          break label90;
        }
        label58:
        if (i == 0) {
          break label97;
        }
      }
      label90:
      label97:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = 0;
        break;
        j = -2;
        break label58;
      }
    }
    boolean bool;
    if (paramString.equalsIgnoreCase("clearFilters"))
    {
      bool = aus();
      if (bool)
      {
        i = i2;
        if (!bool) {
          break label161;
        }
      }
      label161:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(i, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = -2;
        break;
      }
    }
    if (paramString.equalsIgnoreCase("applySticker"))
    {
      if ((paramJSONObject != null) && (p(paramJSONObject)))
      {
        i = n;
        if (i == 0) {
          break label233;
        }
        j = k;
        label201:
        if (i == 0) {
          break label240;
        }
      }
      label233:
      label240:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = 0;
        break;
        j = -2;
        break label201;
      }
    }
    if (paramString.equalsIgnoreCase("clearStickers"))
    {
      bool = aut();
      if (bool)
      {
        i = i3;
        if (!bool) {
          break label304;
        }
      }
      label304:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(i, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = -2;
        break;
      }
    }
    if (paramString.equalsIgnoreCase("applyMakeup"))
    {
      if ((paramJSONObject != null) && (r(paramJSONObject)))
      {
        i = i1;
        if (i == 0) {
          break label376;
        }
        j = m;
        label344:
        if (i == 0) {
          break label383;
        }
      }
      label376:
      label383:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = 0;
        break;
        j = -2;
        break label344;
      }
    }
    if (paramString.equalsIgnoreCase("clearMakeups"))
    {
      bool = auu();
      if (bool)
      {
        i = i4;
        if (!bool) {
          break label447;
        }
      }
      label447:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(i, paramString);
        AppMethodBeat.o(221020);
        return paramString;
        i = -2;
        break;
      }
    }
    paramString = new k(-4, "invalid operate command");
    AppMethodBeat.o(221020);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.x
 * JD-Core Version:    0.7.0.1
 */