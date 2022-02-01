package com.tencent.mm.plugin.appbrand.jsapi.ai.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.camera.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  public static a pJO;
  e cyi;
  SurfaceTexture mSurfaceTexture;
  com.tencent.mm.plugin.appbrand.jsapi.camera.g pJN;
  List<Runnable> pJP;
  
  public a()
  {
    AppMethodBeat.i(139408);
    this.pJP = new Vector();
    AppMethodBeat.o(139408);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(139410);
    super.Tr();
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    if (this.pJN == null)
    {
      Log.w("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
      AppMethodBeat.o(139410);
      return;
    }
    if ((this.cyi instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
    {
      com.tencent.mm.plugin.appbrand.jsapi.g localg = (com.tencent.mm.plugin.appbrand.jsapi.g)this.cyi;
      localg.b(this.pJN);
      localg.b(this.pJN);
      localg.b(this.pJN);
    }
    this.pJN.release();
    AppMethodBeat.o(139410);
  }
  
  final void a(e parame, JSONObject paramJSONObject, o paramo, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139413);
        com.tencent.mm.plugin.appbrand.jsapi.camera.g localg = this.pJN;
        Log.i("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (localg == null)
        {
          Log.w("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
          i = 0;
          if (i != 0)
          {
            parame.j(paramInt, paramo.h("ok", null));
            AppMethodBeat.o(139413);
          }
        }
        else
        {
          i = paramJSONObject.optInt("cameraId");
          Object localObject = paramJSONObject.optString("devicePosition", "back");
          String str = paramJSONObject.optString("flash", "auto");
          bool = paramJSONObject.optBoolean("needOutput", false);
          localg.setAppId(parame.getAppId());
          localg.at((String)localObject, false);
          localg.setFlash(str);
          localg.setNeedOutput(bool);
          JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
          int j = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "width", 0);
          int k = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "height", 0);
          Log.d("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(i), localObject, str, Integer.valueOf(j), Integer.valueOf(k) });
          if ((j == 0) || (k == 0)) {
            break label477;
          }
          bool = localg.ey(j, k);
          if ((parame instanceof ad))
          {
            localObject = ak.f((ad)parame);
            localg.setDisplayScreenSize(new Size(localObject[0], localObject[1]));
          }
          localObject = paramJSONObject.optString("mode");
          if (!Util.isNullOrNil((String)localObject)) {
            localg.setMode((String)localObject);
          }
          localObject = paramJSONObject.optJSONArray("scanArea");
          if ((localObject != null) && (((JSONArray)localObject).length() == 4))
          {
            Log.i("MicroMsg.JsApiUpdateXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject, Integer.valueOf(((JSONArray)localObject).length()) });
            localg.z(com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject).optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject).optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject).optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject).optInt(3)));
          }
          localg.setScanFreq(paramJSONObject.optInt("scanFreq"));
          if (bool)
          {
            localg.release();
            localg.initView();
          }
          else
          {
            localg.bRv();
          }
        }
      }
      finally {}
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
      parame.j(paramInt, paramo.h("fail:internal error", null));
      AppMethodBeat.o(139413);
      continue;
      label477:
      boolean bool = false;
      continue;
      int i = 1;
    }
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139409);
    super.e(paramSurfaceTexture);
    this.mSurfaceTexture = paramSurfaceTexture;
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", new Object[] { Integer.valueOf(this.pJP.size()) });
    paramSurfaceTexture = this.pJP.iterator();
    while (paramSurfaceTexture.hasNext()) {
      ((Runnable)paramSurfaceTexture.next()).run();
    }
    AppMethodBeat.o(139409);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139411);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      final e locale = localb.okQ;
      final o localo = localb.okP;
      final JSONObject localJSONObject = localb.oiG;
      final int i = localb.okO;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localo.getName(), localJSONObject.toString() });
      locale.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139401);
          a.this.cyi = locale;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Object localObject1;
          int j;
          int i;
          if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
            localObject2 = a.this;
            localObject3 = locale;
            localObject4 = parama;
            localObject1 = localJSONObject;
            Object localObject6 = localo;
            int k = i;
            if (((a)localObject2).mSurfaceTexture == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
              AppMethodBeat.o(139401);
              return;
            }
            Object localObject5 = ((e)localObject3).getContext();
            ((a)localObject2).pJN = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)a.pJO.dM((Context)localObject5));
            Object localObject8;
            Object localObject7;
            String str4;
            if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
            {
              localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.g)localObject3;
              localObject8 = (com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject6;
              localObject7 = ((a)localObject2).pJN;
              Object localObject9 = ((a)localObject2).mSurfaceTexture;
              ((com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject8).oMA = false;
              localObject8 = ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).getContext();
              int m = ((JSONObject)localObject1).optInt("cameraId");
              String str1 = ((JSONObject)localObject1).optString("mode", "normal");
              String str2 = ((JSONObject)localObject1).optString("devicePosition", "back");
              String str3 = ((JSONObject)localObject1).optString("flash", "auto");
              str4 = ((JSONObject)localObject1).optString("size");
              j = 288;
              i = -1;
              switch (str4.hashCode())
              {
              default: 
                switch (i)
                {
                default: 
                  i = j;
                  label294:
                  boolean bool = ((JSONObject)localObject1).optBoolean("needOutput", false);
                  str4 = ((JSONObject)localObject1).optString("resolution");
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setAppId(((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).getAppId());
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPage((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCameraId(m);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setMode(str1);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).at(str2, true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFlash(str3);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFrameLimitSize(i);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setNeedOutput(bool);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setResolution(str4);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCustomSurfaceTexture((SurfaceTexture)localObject9);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPageOrientation(((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).bEN());
                  localObject9 = ((JSONObject)localObject1).optJSONObject("position");
                  i = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject9, "width", 0);
                  j = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject9, "height", 0);
                  if ((i != 0) && (j != 0)) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).ey(i, j);
                  }
                  if ((localObject5 instanceof ad))
                  {
                    localObject9 = ak.f((ad)localObject5);
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setDisplayScreenSize(new Size(localObject9[0], localObject9[1]));
                  }
                  localObject9 = ((JSONObject)localObject1).optJSONArray("scanArea");
                  if ((localObject9 != null) && (((JSONArray)localObject9).length() == 4))
                  {
                    Log.i("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject9, Integer.valueOf(((JSONArray)localObject9).length()) });
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).z(com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject9).optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject9).optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject9).optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.Di(((JSONArray)localObject9).optInt(3)));
                    label600:
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setScanFreq(((JSONObject)localObject1).optInt("scanFreq"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPreviewCenterCrop(((JSONObject)localObject1).optBoolean("centerCrop"));
                    Log.d("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(m), str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
                    localObject7 = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).getView();
                    if (!"normal".equals(str1)) {
                      break label890;
                    }
                    localObject1 = ((Context)localObject8).getString(a.g.app_brand_accessibility_camera_normal_mode);
                    label703:
                    ((View)localObject7).setContentDescription((CharSequence)localObject1);
                    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject6;
                    localObject7 = ((a)localObject2).pJN;
                    localObject6 = new a.3((a)localObject2, (e)localObject3, k, (o)localObject6);
                    Log.i("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
                    if (localObject7 != null) {
                      break label903;
                    }
                    Log.w("MicroMsg.JsApiInsertXWebCamera", "onInsertView failed, cameraView is null");
                  }
                  break;
                }
                break;
              }
            }
            for (;;)
            {
              ((e)localObject3).P(new a.4((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.g)localObject5));
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).a(new a.5((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.g)localObject5, (e)localObject3, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject4));
              AppMethodBeat.o(139401);
              return;
              if (!str4.equals("small")) {
                break;
              }
              i = 0;
              break;
              if (!str4.equals("medium")) {
                break;
              }
              i = 1;
              break;
              if (!str4.equals("large")) {
                break;
              }
              i = 2;
              break;
              i = 288;
              break label294;
              i = 480;
              break label294;
              i = 720;
              break label294;
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).z(0, 0, i, j);
              break label600;
              label890:
              localObject1 = ((Context)localObject8).getString(a.g.app_brand_accessibility_camera_scan_mode);
              break label703;
              label903:
              ((com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject1).a((e)localObject5, (f)localObject7, (b.a)localObject6);
              com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().a(((f)localObject7).getCameraId(), (f)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).a((h.d)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).a((h.b)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).a((h.c)localObject7);
              localObject6 = new WeakReference(localObject7);
              k.a(((com.tencent.mm.plugin.appbrand.jsapi.g)localObject5).getAppId(), new b.1((com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject1, (WeakReference)localObject6, (com.tencent.mm.plugin.appbrand.jsapi.g)localObject5));
              ((f)localObject7).setOutPutCallBack(new b.2((com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)localObject1));
            }
          }
          if ((localo instanceof d))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
            a.this.a(locale, localJSONObject, localo, i);
            AppMethodBeat.o(139401);
            return;
          }
          if ((localo instanceof c))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
            localObject3 = a.this;
            localObject1 = locale;
            localObject2 = localo;
            j = i;
            localObject3 = ((a)localObject3).pJN;
            Log.i("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
            if (localObject3 == null) {
              Log.w("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
            }
            for (i = 0; i != 0; i = 1)
            {
              ((e)localObject1).j(j, ((o)localObject2).h("ok", null));
              AppMethodBeat.o(139401);
              return;
              if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
              {
                localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.g)localObject1;
                ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject4).b((h.d)localObject3);
                ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject4).b((h.b)localObject3);
                ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject4).b((h.c)localObject3);
              }
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject3).release();
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
            ((e)localObject1).j(j, ((o)localObject2).h("fail:internal error", null));
          }
          AppMethodBeat.o(139401);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(139402);
          if ((a.this.mSurfaceTexture == null) && ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b)))
          {
            a.this.pJP.add(this.val$runnable);
            AppMethodBeat.o(139402);
            return;
          }
          this.val$runnable.run();
          AppMethodBeat.o(139402);
        }
      });
    }
    AppMethodBeat.o(139411);
    return null;
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139412);
    this.pJN.o(paramMotionEvent);
    AppMethodBeat.o(139412);
  }
  
  public static abstract interface a
  {
    public abstract f dM(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.a
 * JD-Core Version:    0.7.0.1
 */