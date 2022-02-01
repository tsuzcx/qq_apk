package com.tencent.mm.plugin.appbrand.jsapi.ag.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.ai;
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
  public static a mIW;
  com.tencent.mm.plugin.appbrand.jsapi.f czm;
  com.tencent.mm.plugin.appbrand.jsapi.camera.g mIV;
  List<Runnable> mIX;
  SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139408);
    this.mIX = new Vector();
    AppMethodBeat.o(139408);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(139410);
    super.PQ();
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    if (this.mIV == null)
    {
      Log.w("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
      AppMethodBeat.o(139410);
      return;
    }
    if ((this.czm instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
    {
      com.tencent.mm.plugin.appbrand.jsapi.h localh = (com.tencent.mm.plugin.appbrand.jsapi.h)this.czm;
      localh.b(this.mIV);
      localh.b(this.mIV);
      localh.b(this.mIV);
    }
    this.mIV.release();
    AppMethodBeat.o(139410);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, p paramp, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139413);
        com.tencent.mm.plugin.appbrand.jsapi.camera.g localg = this.mIV;
        Log.i("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (localg == null)
        {
          Log.w("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
          i = 0;
          if (i != 0)
          {
            paramf.i(paramInt, paramp.h("ok", null));
            AppMethodBeat.o(139413);
          }
        }
        else
        {
          i = paramJSONObject.optInt("cameraId");
          Object localObject = paramJSONObject.optString("devicePosition", "back");
          String str = paramJSONObject.optString("flash", "auto");
          bool = paramJSONObject.optBoolean("needOutput", false);
          localg.setAppId(paramf.getAppId());
          localg.ar((String)localObject, false);
          localg.setFlash(str);
          localg.setNeedOutput(bool);
          JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
          int j = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "width", 0);
          int k = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "height", 0);
          Log.d("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(i), localObject, str, Integer.valueOf(j), Integer.valueOf(k) });
          if ((j == 0) || (k == 0)) {
            break label477;
          }
          bool = localg.dZ(j, k);
          if ((paramf instanceof ac))
          {
            localObject = ai.f((ac)paramf);
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
            localg.x(com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject).optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject).optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject).optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject).optInt(3)));
          }
          localg.setScanFreq(paramJSONObject.optInt("scanFreq"));
          if (bool)
          {
            localg.release();
            localg.initView();
          }
          else
          {
            localg.bFM();
          }
        }
      }
      finally {}
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
      paramf.i(paramInt, paramp.h("fail:internal error", null));
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
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", new Object[] { Integer.valueOf(this.mIX.size()) });
    paramSurfaceTexture = this.mIX.iterator();
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
      final com.tencent.mm.plugin.appbrand.jsapi.f localf = localb.lqg;
      final p localp = localb.lqf;
      final JSONObject localJSONObject = localb.lnV;
      final int i = localb.lqe;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Lb(), localp.getName(), localJSONObject.toString() });
      localf.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139401);
          a.this.czm = localf;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Object localObject1;
          int j;
          int i;
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
            localObject2 = a.this;
            localObject3 = localf;
            localObject4 = parama;
            localObject1 = localJSONObject;
            Object localObject6 = localp;
            int k = i;
            if (((a)localObject2).mSurfaceTexture == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
              AppMethodBeat.o(139401);
              return;
            }
            Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject3).getContext();
            ((a)localObject2).mIV = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)a.mIW.dN((Context)localObject5));
            Object localObject8;
            Object localObject7;
            String str4;
            if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
            {
              localObject5 = (com.tencent.mm.plugin.appbrand.jsapi.h)localObject3;
              localObject8 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject6;
              localObject7 = ((a)localObject2).mIV;
              Object localObject9 = ((a)localObject2).mSurfaceTexture;
              ((com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject8).lQg = false;
              localObject8 = ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).getContext();
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
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setAppId(((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).getAppId());
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPage((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCameraId(m);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setMode(str1);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).ar(str2, true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFlash(str3);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFrameLimitSize(i);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setNeedOutput(bool);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setResolution(str4);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCustomSurfaceTexture((SurfaceTexture)localObject9);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPageOrientation(((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).btO());
                  localObject9 = ((JSONObject)localObject1).optJSONObject("position");
                  i = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject9, "width", 0);
                  j = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject9, "height", 0);
                  if ((i != 0) && (j != 0)) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).dZ(i, j);
                  }
                  if ((localObject5 instanceof ac))
                  {
                    localObject9 = ai.f((ac)localObject5);
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setDisplayScreenSize(new Size(localObject9[0], localObject9[1]));
                  }
                  localObject9 = ((JSONObject)localObject1).optJSONArray("scanArea");
                  if ((localObject9 != null) && (((JSONArray)localObject9).length() == 4))
                  {
                    Log.i("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject9, Integer.valueOf(((JSONArray)localObject9).length()) });
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).x(com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject9).optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject9).optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject9).optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONArray)localObject9).optInt(3)));
                    label600:
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setScanFreq(((JSONObject)localObject1).optInt("scanFreq"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPreviewCenterCrop(((JSONObject)localObject1).optBoolean("centerCrop"));
                    Log.d("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(m), str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
                    localObject7 = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).getView();
                    if (!"normal".equals(str1)) {
                      break label890;
                    }
                    localObject1 = ((Context)localObject8).getString(2131755319);
                    label703:
                    ((View)localObject7).setContentDescription((CharSequence)localObject1);
                    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject6;
                    localObject7 = ((a)localObject2).mIV;
                    localObject6 = new a.3((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.f)localObject3, k, (p)localObject6);
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
              ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject3).P(new a.4((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.h)localObject5));
              ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).a(new a.5((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.h)localObject5, (com.tencent.mm.plugin.appbrand.jsapi.f)localObject3, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject4));
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
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).x(0, 0, i, j);
              break label600;
              label890:
              localObject1 = ((Context)localObject8).getString(2131755320);
              break label703;
              label903:
              ((com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject1).a((com.tencent.mm.plugin.appbrand.jsapi.f)localObject5, (com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7, (b.a)localObject6);
              com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().a(((com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7).getCameraId(), (com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).a((i.d)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).a((i.b)localObject7);
              ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).a((i.c)localObject7);
              localObject6 = new WeakReference(localObject7);
              com.tencent.mm.plugin.appbrand.h.a(((com.tencent.mm.plugin.appbrand.jsapi.h)localObject5).getAppId(), new b.1((com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject1, (WeakReference)localObject6, (com.tencent.mm.plugin.appbrand.jsapi.h)localObject5));
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.f)localObject7).setOutPutCallBack(new b.2((com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)localObject1));
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
            localObject3 = ((a)localObject3).mIV;
            Log.i("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
            if (localObject3 == null) {
              Log.w("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
            }
            for (i = 0; i != 0; i = 1)
            {
              ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).i(j, ((p)localObject2).h("ok", null));
              AppMethodBeat.o(139401);
              return;
              if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
              {
                localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.h)localObject1;
                ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject4).b((i.d)localObject3);
                ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject4).b((i.b)localObject3);
                ((com.tencent.mm.plugin.appbrand.jsapi.h)localObject4).b((i.c)localObject3);
              }
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject3).release();
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
            ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).i(j, ((p)localObject2).h("fail:internal error", null));
          }
          AppMethodBeat.o(139401);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(139402);
          if ((a.this.mSurfaceTexture == null) && ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)))
          {
            a.this.mIX.add(this.val$runnable);
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
    this.mIV.o(paramMotionEvent);
    AppMethodBeat.o(139412);
  }
  
  public static abstract interface a
  {
    public abstract com.tencent.mm.plugin.appbrand.jsapi.camera.f dN(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a.a
 * JD-Core Version:    0.7.0.1
 */