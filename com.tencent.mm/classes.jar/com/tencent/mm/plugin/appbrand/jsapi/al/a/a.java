package com.tencent.mm.plugin.appbrand.jsapi.al.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.camera.g;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.utils.aq;
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
  public static a sOG;
  com.tencent.mm.plugin.appbrand.jsapi.f eqB;
  Surface mSurface;
  g sOF;
  List<Runnable> sOH;
  int sOI;
  
  public a()
  {
    AppMethodBeat.i(139408);
    this.sOH = new Vector();
    AppMethodBeat.o(139408);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, p paramp, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139413);
        if ((this.mSurface == null) || (this.mSurface.hashCode() == this.sOI) || (this.sOI == 0)) {
          break label555;
        }
        localObject = this.mSurface;
        this.sOI = localObject.hashCode();
        g localg = this.sOF;
        Log.i("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (localg == null)
        {
          Log.w("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
          i = 0;
          if (i != 0)
          {
            paramf.callback(paramInt, paramp.ZP("ok"));
            AppMethodBeat.o(139413);
          }
        }
        else
        {
          int j = paramJSONObject.optInt("cameraId");
          String str1 = paramJSONObject.optString("devicePosition", "back");
          String str2 = paramJSONObject.optString("flash", "auto");
          bool = paramJSONObject.optBoolean("needOutput", false);
          localg.setAppId(paramf.getAppId());
          localg.aE(str1, false);
          localg.setFlash(str2);
          localg.setNeedOutput(bool);
          i = 0;
          if (localObject != null)
          {
            localg.setCustomSurface((Surface)localObject);
            i = 1;
            Log.i("MicroMsg.JsApiUpdateXWebCamera", "set a new surface when update camera");
          }
          localObject = paramJSONObject.optJSONObject("position");
          int k = i.a((JSONObject)localObject, "width", 0);
          int m = i.a((JSONObject)localObject, "height", 0);
          Log.d("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(j), str1, str2, Integer.valueOf(k), Integer.valueOf(m) });
          if ((k == 0) || (m == 0)) {
            break label549;
          }
          bool = localg.fs(k, m);
          if ((paramf instanceof ad))
          {
            localObject = aq.d((ad)paramf);
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
            localg.F(i.DC(((JSONArray)localObject).optInt(0)), i.DC(((JSONArray)localObject).optInt(1)), i.DC(((JSONArray)localObject).optInt(2)), i.DC(((JSONArray)localObject).optInt(3)));
          }
          localg.setScanFreq(paramJSONObject.optInt("scanFreq"));
          if ((bool) || (i != 0))
          {
            localg.release();
            localg.initView();
          }
          else
          {
            localg.crB();
          }
        }
      }
      finally {}
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
      paramf.callback(paramInt, paramp.ZP("fail:internal error"));
      AppMethodBeat.o(139413);
      continue;
      label549:
      boolean bool = false;
      continue;
      label555:
      Object localObject = null;
      continue;
      int i = 1;
    }
  }
  
  public final void atW()
  {
    AppMethodBeat.i(139410);
    super.atW();
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.sOF == null)
    {
      Log.w("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
      AppMethodBeat.o(139410);
      return;
    }
    if ((this.eqB instanceof h))
    {
      h localh = (h)this.eqB;
      localh.b(this.sOF);
      localh.b(this.sOF);
      localh.b(this.sOF);
    }
    this.sOF.release();
    AppMethodBeat.o(139410);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139409);
    i(new Surface(paramSurfaceTexture));
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
      final com.tencent.mm.plugin.appbrand.jsapi.f localf = localb.rot;
      final p localp = localb.ros;
      final JSONObject localJSONObject = localb.rmi;
      final int i = localb.ror;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localp.getName(), localJSONObject.toString() });
      localf.V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139401);
          a.this.eqB = localf;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Object localObject1;
          int j;
          int i;
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
            localObject2 = a.this;
            localObject3 = localf;
            localObject4 = parama;
            localObject1 = localJSONObject;
            Object localObject6 = localp;
            int k = i;
            if (((a)localObject2).mSurface == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
              AppMethodBeat.o(139401);
              return;
            }
            Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject3).getContext();
            ((a)localObject2).sOF = ((g)a.sOG.eG((Context)localObject5));
            Object localObject8;
            Object localObject7;
            String str4;
            if ((localObject3 instanceof h))
            {
              localObject5 = (h)localObject3;
              localObject8 = (com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject6;
              localObject7 = ((a)localObject2).sOF;
              Object localObject9 = ((a)localObject2).mSurface;
              ((com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject8).rQw = false;
              localObject8 = ((h)localObject5).getContext();
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
                  ((g)localObject7).setAppId(((h)localObject5).getAppId());
                  ((g)localObject7).setPage((h)localObject5);
                  ((g)localObject7).setCameraId(m);
                  ((g)localObject7).setMode(str1);
                  ((g)localObject7).aE(str2, true);
                  ((g)localObject7).setFlash(str3);
                  ((g)localObject7).setFrameLimitSize(i);
                  ((g)localObject7).setNeedOutput(bool);
                  ((g)localObject7).setResolution(str4);
                  ((g)localObject7).setCustomSurface((Surface)localObject9);
                  ((g)localObject7).setPageOrientation(((h)localObject5).cdZ());
                  localObject9 = ((JSONObject)localObject1).optJSONObject("position");
                  i = i.a((JSONObject)localObject9, "width", 0);
                  j = i.a((JSONObject)localObject9, "height", 0);
                  if ((i != 0) && (j != 0)) {
                    ((g)localObject7).fs(i, j);
                  }
                  if ((localObject5 instanceof ad))
                  {
                    localObject9 = aq.d((ad)localObject5);
                    ((g)localObject7).setDisplayScreenSize(new Size(localObject9[0], localObject9[1]));
                  }
                  localObject9 = ((JSONObject)localObject1).optJSONArray("scanArea");
                  if ((localObject9 != null) && (((JSONArray)localObject9).length() == 4))
                  {
                    Log.i("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject9, Integer.valueOf(((JSONArray)localObject9).length()) });
                    ((g)localObject7).F(i.DC(((JSONArray)localObject9).optInt(0)), i.DC(((JSONArray)localObject9).optInt(1)), i.DC(((JSONArray)localObject9).optInt(2)), i.DC(((JSONArray)localObject9).optInt(3)));
                    label600:
                    ((g)localObject7).setScanFreq(((JSONObject)localObject1).optInt("scanFreq"));
                    ((g)localObject7).setPreviewCenterCrop(((JSONObject)localObject1).optBoolean("centerCrop"));
                    Log.d("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(m), str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
                    localObject7 = ((g)localObject7).getView();
                    if (!"normal".equals(str1)) {
                      break label911;
                    }
                    localObject1 = ((Context)localObject8).getString(a.g.app_brand_accessibility_camera_normal_mode);
                    label703:
                    ((View)localObject7).setContentDescription((CharSequence)localObject1);
                    if (((a)localObject2).mSurface != null) {
                      ((a)localObject2).sOI = ((a)localObject2).mSurface.hashCode();
                    }
                    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject6;
                    localObject7 = ((a)localObject2).sOF;
                    localObject6 = new a.3((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.f)localObject3, k, (p)localObject6);
                    Log.i("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
                    if (localObject7 != null) {
                      break label924;
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
              ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject3).V(new a.4((a)localObject2, (h)localObject5));
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).a(new a.5((a)localObject2, (h)localObject5, (com.tencent.mm.plugin.appbrand.jsapi.f)localObject3, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject4));
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
              ((g)localObject7).F(0, 0, i, j);
              break label600;
              label911:
              localObject1 = ((Context)localObject8).getString(a.g.app_brand_accessibility_camera_scan_mode);
              break label703;
              label924:
              ((com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject1).a((com.tencent.mm.plugin.appbrand.jsapi.f)localObject5, (com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7, (b.a)localObject6);
              com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.cry().a(((com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7).getCameraId(), (com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7);
              ((h)localObject5).a((i.d)localObject7);
              ((h)localObject5).a((i.b)localObject7);
              ((h)localObject5).a((i.c)localObject7);
              localObject6 = new WeakReference(localObject7);
              k.a(((h)localObject5).getAppId(), new b.1((com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject1, (WeakReference)localObject6, (h)localObject5));
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7).setOutPutCallBack(new b.2((com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)localObject1));
            }
          }
          if ((localp instanceof d))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
            a.this.a(localf, localJSONObject, localp, i);
            AppMethodBeat.o(139401);
            return;
          }
          if ((localp instanceof c))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
            localObject3 = a.this;
            localObject1 = localf;
            localObject2 = localp;
            j = i;
            localObject3 = ((a)localObject3).sOF;
            Log.i("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
            if (localObject3 == null) {
              Log.w("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
            }
            for (i = 0; i != 0; i = 1)
            {
              ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).callback(j, ((p)localObject2).ZP("ok"));
              AppMethodBeat.o(139401);
              return;
              if ((localObject1 instanceof h))
              {
                localObject4 = (h)localObject1;
                ((h)localObject4).b((i.d)localObject3);
                ((h)localObject4).b((i.b)localObject3);
                ((h)localObject4).b((i.c)localObject3);
              }
              ((g)localObject3).release();
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
            ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).callback(j, ((p)localObject2).ZP("fail:internal error"));
          }
          AppMethodBeat.o(139401);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(139402);
          if ((a.this.mSurface == null) && (((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b)) || ((localp instanceof d))))
          {
            a.this.sOH.add(this.val$runnable);
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
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(327003);
    super.i(paramSurface);
    this.mSurface = paramSurface;
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", new Object[] { Integer.valueOf(this.sOH.size()) });
    paramSurface = this.sOH.iterator();
    while (paramSurface.hasNext()) {
      ((Runnable)paramSurface.next()).run();
    }
    AppMethodBeat.o(327003);
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139412);
    this.sOF.o(paramMotionEvent);
    AppMethodBeat.o(139412);
  }
  
  public static abstract interface a
  {
    public abstract com.tencent.mm.plugin.appbrand.jsapi.camera.f eG(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a.a
 * JD-Core Version:    0.7.0.1
 */