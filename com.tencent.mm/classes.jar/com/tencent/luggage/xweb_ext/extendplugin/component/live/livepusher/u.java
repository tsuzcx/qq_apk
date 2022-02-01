package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.jsapi.live.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public final class u
  extends t
  implements l
{
  private final v cJn;
  private ITXLivePushListener mLivePushListener;
  
  public u(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(222559);
    this.cJn = new v(this.oVW);
    AppMethodBeat.o(222559);
  }
  
  public static void a(n.b paramb)
  {
    AppMethodBeat.i(222558);
    v.a(paramb);
    AppMethodBeat.o(222558);
  }
  
  public final k TK()
  {
    AppMethodBeat.i(222639);
    k localk = super.TK();
    this.cJn.mInited = false;
    AppMethodBeat.o(222639);
    return localk;
  }
  
  public final void Tp()
  {
    AppMethodBeat.i(222650);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapterV2SameLayerSupport", "sendHandupStop, send event 5000");
      this.mLivePushListener.onPushEvent(5000, new Bundle());
    }
    AppMethodBeat.o(222650);
  }
  
  public final void Tq()
  {
    AppMethodBeat.i(222652);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapterV2SameLayerSupport", "sendWeChatStop, send event 5001");
      this.mLivePushListener.onPushEvent(5001, new Bundle());
    }
    AppMethodBeat.o(222652);
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(222571);
    k localk = super.b(paramTXCloudVideoView, paramBundle);
    v localv = this.cJn;
    if ((paramTXCloudVideoView == null) || (paramBundle == null)) {}
    for (;;)
    {
      AppMethodBeat.o(222571);
      return localk;
      localv.a(paramBundle, true);
      localv.mInited = true;
    }
  }
  
  public final k cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222642);
    k localk = new k(this.oVW.setSurfaceSize(paramInt1, paramInt2));
    AppMethodBeat.o(222642);
    return localk;
  }
  
  public final k e(Surface paramSurface)
  {
    AppMethodBeat.i(222641);
    paramSurface = new k(this.oVW.setSurface(paramSurface));
    AppMethodBeat.o(222641);
    return paramSurface;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222638);
    Object localObject1 = super.e(paramString, paramJSONObject);
    if (-4 == ((k)localObject1).errorCode)
    {
      localObject1 = this.cJn;
      int i;
      label68:
      int j;
      label76:
      float f2;
      float f1;
      if (paramString.equalsIgnoreCase("applyFilter"))
      {
        if (paramJSONObject != null) {
          if (!((v)localObject1).TM())
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyFilter, useCustomEffect is false");
            i = 0;
            if (i == 0) {
              break label248;
            }
            i = 1;
            if (i == 0) {
              break label254;
            }
            j = 0;
            if (i == 0) {
              break label261;
            }
          }
        }
        label261:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          paramString = paramJSONObject.optString("path", null);
          if (Util.isNullOrNil(paramString))
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyFilter, resourcePath is null");
            i = 0;
            break;
          }
          f2 = (float)paramJSONObject.optDouble("alpha", 1.0D);
          f1 = f2;
          if (f2 < 0.0F)
          {
            Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, alpha(%f) is illegal", new Object[] { Float.valueOf(f2) });
            f1 = 0.0F;
          }
          f2 = f1;
          if (f1 > 1.0F)
          {
            Log.i("TXLivePusherWeEffectJSAdapter", "applyFaceBeautyIfNeed, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
            f2 = 1.0F;
          }
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "applyFilter, resourcePath: %s, alpha: %f", new Object[] { paramString, Float.valueOf(f2) });
          ((v)localObject1).cJh.b(paramString, f2);
          i = 1;
          break;
          label248:
          i = 0;
          break label68;
          label254:
          j = -2;
          break label76;
        }
      }
      if (paramString.equalsIgnoreCase("clearFilters"))
      {
        if (!((v)localObject1).TM())
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "clearFilters, useCustomEffect is false");
          i = 0;
          if (i == 0) {
            break label356;
          }
          j = 0;
          label302:
          if (i == 0) {
            break label363;
          }
        }
        label356:
        label363:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "clearFilters");
          ((v)localObject1).cJh.clearFilters();
          i = 1;
          break;
          j = -2;
          break label302;
        }
      }
      boolean bool;
      if (paramString.equalsIgnoreCase("applySticker"))
      {
        if (paramJSONObject != null) {
          if (!((v)localObject1).TM())
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applySticker, useCustomEffect is false");
            bool = false;
            if (!bool) {
              break label539;
            }
            i = 1;
            label408:
            if (i == 0) {
              break label545;
            }
            j = 0;
            label416:
            if (i == 0) {
              break label552;
            }
          }
        }
        label539:
        label545:
        label552:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          paramString = paramJSONObject.optString("path", null);
          if (Util.isNullOrNil(paramString))
          {
            Log.i("TXLivePusherWeEffectJSAdapter", "applySticker, resourcePath is null");
            bool = ((v)localObject1).p(paramJSONObject);
            break;
          }
          paramJSONObject = v.r(paramJSONObject);
          if (paramJSONObject == null)
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applySticker, stickerType is null");
            bool = false;
            break;
          }
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "applySticker, stickerType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
          ((v)localObject1).cJh.a(paramJSONObject, paramString);
          bool = true;
          break;
          i = 0;
          break label408;
          j = -2;
          break label416;
        }
      }
      if (paramString.equalsIgnoreCase("clearStickers"))
      {
        if (!((v)localObject1).TM())
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "clearStickers, useCustomEffect is false");
          i = 0;
          if (i == 0) {
            break label647;
          }
          j = 0;
          label593:
          if (i == 0) {
            break label654;
          }
        }
        label647:
        label654:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "clearStickers");
          ((v)localObject1).cJh.TG();
          i = 1;
          break;
          j = -2;
          break label593;
        }
      }
      label1025:
      label1687:
      if (paramString.equalsIgnoreCase("applyMakeup"))
      {
        if (paramJSONObject != null) {
          if (!((v)localObject1).TM())
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeup, useCustomEffect is false");
            bool = false;
            if (!bool) {
              break label1769;
            }
            i = 1;
            label699:
            if (i == 0) {
              break label1775;
            }
            j = 0;
            label707:
            if (i == 0) {
              break label1782;
            }
          }
        }
        label1325:
        label1512:
        label1769:
        label1775:
        label1782:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          paramString = paramJSONObject.optString("path", null);
          if (Util.isNullOrNil(paramString))
          {
            Log.i("TXLivePusherWeEffectJSAdapter", "applyMakeup, resourcePath is null");
            if (!((v)localObject1).TM())
            {
              Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, useCustomEffect is false");
              bool = false;
              break;
            }
            Object localObject2 = v.s(paramJSONObject);
            if (localObject2 == null)
            {
              Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupType is null");
              bool = false;
              break;
            }
            paramString = paramJSONObject.optJSONObject("makeup");
            if (paramString == null)
            {
              Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupJsonObj is null");
              bool = false;
              break;
            }
            ((v)localObject1).TN();
            Log.d("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, makeupType: %s", new Object[] { localObject2 });
            label1142:
            String str1;
            String str2;
            switch (v.1.cJm[localObject2.ordinal()])
            {
            default: 
              Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, should not reach");
              bool = false;
              break;
            case 1: 
              f1 = v.b(paramString, "alpha");
              paramJSONObject = v.q(paramString);
              if (paramJSONObject == null)
              {
                Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, color is null");
                paramString = null;
              }
              for (;;)
              {
                if (paramString != null) {
                  break label1025;
                }
                Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, lipStickInfo is null");
                bool = false;
                break;
                localObject2 = o.b.jd(paramString.optInt("lipstickType", 0));
                if (localObject2 == null)
                {
                  Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, type is null");
                  paramString = null;
                }
                else
                {
                  i = paramString.optInt("faceModel", 0);
                  if (i != 0)
                  {
                    Log.w("TXLivePusherWeEffectJSAdapter", "parseLipStickInfo, faceModel is illegal");
                    paramString = null;
                  }
                  else
                  {
                    paramString = new o(f1, paramJSONObject, (o.b)localObject2, i, o.c.cHP);
                  }
                }
              }
              bool = ((v)localObject1).cJh.a(paramString);
              break;
            case 2: 
              f1 = v.b(paramString, "alpha");
              paramJSONObject = paramString.optString("leftPath", "");
              if (Util.isNullOrNil(paramJSONObject)) {
                Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeShadowInfo, leftPath is empty");
              }
              for (paramString = null;; paramString = new c(f1, paramJSONObject, (String)localObject2, paramJSONObject, (String)localObject2, paramString.optString("shimmerPosition", null), paramString.optString("shimmerPositionMD5", "")))
              {
                if (paramString != null) {
                  break label1142;
                }
                Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, eyeShadowInfo is null");
                bool = false;
                break;
                localObject2 = paramString.optString("leftPathMD5", "");
              }
              bool = ((v)localObject1).cJh.a(paramString);
              break;
            case 3: 
              f1 = v.b(paramString, "alpha");
              paramJSONObject = a.a.cGJ;
              localObject2 = paramString.optString("leftPath", "");
              if (Util.isNullOrNil((String)localObject2))
              {
                Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, leftPath is empty");
                paramString = null;
              }
              for (;;)
              {
                if (paramString != null) {
                  break label1325;
                }
                Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, blusherStickInfo is null");
                bool = false;
                break;
                str1 = paramString.optString("leftPathMD5", "");
                str2 = paramString.optString("rightPath", "");
                if (Util.isNullOrNil(str2))
                {
                  Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, rightPath is empty");
                  paramString = null;
                }
                else
                {
                  String str3 = paramString.optString("rightPathMD5", "");
                  i = paramString.optInt("faceModel", 0);
                  if (i != 0)
                  {
                    Log.w("TXLivePusherWeEffectJSAdapter", "parseBlusherStickInfo, faceModel is illegal");
                    paramString = null;
                  }
                  else
                  {
                    paramString = new a(f1, paramJSONObject, (String)localObject2, str1, str2, str3, i);
                  }
                }
              }
              bool = ((v)localObject1).cJh.a(paramString);
              break;
            case 4: 
              f1 = v.b(paramString, "highlightAlpha");
              f2 = v.b(paramString, "shadowAlpha");
              paramJSONObject = paramString.optString("highlightPath", "");
              if (Util.isNullOrNil(paramJSONObject))
              {
                Log.w("TXLivePusherWeEffectJSAdapter", "parseFaceContourInfo, highLightPath is empty");
                paramString = null;
              }
              for (;;)
              {
                if (paramString != null) {
                  break label1512;
                }
                Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, faceContourInfo is null");
                bool = false;
                break;
                localObject2 = paramString.optString("highlightPathMD5", "");
                str1 = paramString.optString("shadowPath", "");
                if (Util.isNullOrNil(str1))
                {
                  Log.w("TXLivePusherWeEffectJSAdapter", "parseFaceContourInfo, shadowPath is empty");
                  paramString = null;
                }
                else
                {
                  str2 = paramString.optString("shadowPathMD5", "");
                  i = paramString.optInt("faceModel", 0);
                  if (i != 0)
                  {
                    Log.w("TXLivePusherWeEffectJSAdapter", "parseFaceContourInfo, faceModel is illegal");
                    paramString = null;
                  }
                  else
                  {
                    paramString = new d(f1, f2, paramJSONObject, (String)localObject2, str1, str2, i);
                  }
                }
              }
              bool = ((v)localObject1).cJh.a(paramString);
              break;
            case 5: 
              f1 = v.b(paramString, "alpha");
              paramJSONObject = paramString.optString("leftPath", "");
              if (Util.isNullOrNil(paramJSONObject))
              {
                Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, leftPath is empty");
                paramString = null;
              }
              for (;;)
              {
                if (paramString != null) {
                  break label1687;
                }
                Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeupWorkaround, eyeBrowInfo is null");
                bool = false;
                break;
                localObject2 = paramString.optString("leftPathMD5", "");
                str1 = paramString.optString("rightPath", "");
                if (Util.isNullOrNil(str1))
                {
                  Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, rightPath is empty");
                  paramString = null;
                }
                else
                {
                  str2 = paramString.optString("rightPathMD5", "");
                  i = paramString.optInt("faceModel", 0);
                  if (i != 0)
                  {
                    Log.w("TXLivePusherWeEffectJSAdapter", "parseEyeBrowInfo, faceModel is illegal");
                    paramString = null;
                  }
                  else
                  {
                    paramString = new b(f1, paramJSONObject, (String)localObject2, str1, str2, i);
                  }
                }
              }
              bool = ((v)localObject1).cJh.a(paramString);
              break;
            }
          }
          paramJSONObject = v.s(paramJSONObject);
          if (paramJSONObject == null)
          {
            Log.w("TXLivePusherWeEffectJSAdapter", "applyMakeup, makeupType is null");
            bool = false;
            break;
          }
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "applyMakeup, makeupType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
          ((v)localObject1).cJh.a(paramJSONObject, paramString);
          bool = true;
          break;
          i = 0;
          break label699;
          j = -2;
          break label707;
        }
      }
      if (paramString.equalsIgnoreCase("clearMakeups"))
      {
        if (!((v)localObject1).TM())
        {
          Log.w("TXLivePusherWeEffectJSAdapter", "clearMakeups, useCustomEffect is false");
          i = 0;
          if (i == 0) {
            break label1880;
          }
          j = 0;
          label1825:
          if (i == 0) {
            break label1887;
          }
        }
        label1880:
        label1887:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(j, paramString);
          AppMethodBeat.o(222638);
          return paramString;
          ((v)localObject1).TN();
          Log.d("TXLivePusherWeEffectJSAdapter", "clearMakeups");
          ((v)localObject1).cJh.TH();
          i = 1;
          break;
          j = -2;
          break label1825;
        }
      }
      paramString = new k(-4, "invalid operate command");
      AppMethodBeat.o(222638);
      return paramString;
    }
    AppMethodBeat.o(222638);
    return localObject1;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(222649);
    int i = this.oVW.getMaxZoom();
    AppMethodBeat.o(222649);
    return i;
  }
  
  public final k jc(int paramInt)
  {
    AppMethodBeat.i(222648);
    k localk = new k(this.oVW.setZoom(paramInt));
    AppMethodBeat.o(222648);
    return localk;
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(222564);
    super.setPushListener(paramITXLivePushListener);
    this.mLivePushListener = paramITXLivePushListener;
    AppMethodBeat.o(222564);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(222561);
    this.oVW.setThreadHandler(paramHandler);
    AppMethodBeat.o(222561);
  }
  
  public final k t(Bundle paramBundle)
  {
    AppMethodBeat.i(222575);
    V2TXJSAdapterError localV2TXJSAdapterError = this.oVW.initLivePusher(paramBundle);
    v localv = this.cJn;
    if (paramBundle != null)
    {
      localv.a(paramBundle, true);
      localv.mInited = true;
    }
    paramBundle = new k(localV2TXJSAdapterError);
    AppMethodBeat.o(222575);
    return paramBundle;
  }
  
  public final k u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222645);
    k localk = new k(this.oVW.setFocusPosition(paramFloat1, paramFloat2));
    AppMethodBeat.o(222645);
    return localk;
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(222577);
    k localk = super.u(paramBundle);
    v localv = this.cJn;
    if ((paramBundle != null) && (localv.mInited)) {
      localv.a(paramBundle, false);
    }
    AppMethodBeat.o(222577);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.u
 * JD-Core Version:    0.7.0.1
 */