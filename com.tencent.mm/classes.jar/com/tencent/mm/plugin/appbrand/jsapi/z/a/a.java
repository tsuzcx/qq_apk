package com.tencent.mm.plugin.appbrand.jsapi.z.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.k.a.b.a
{
  public static a kZZ;
  com.tencent.mm.plugin.appbrand.jsapi.c ccU;
  com.tencent.mm.plugin.appbrand.jsapi.camera.g kZY;
  List<Runnable> laa;
  SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139408);
    this.laa = new Vector();
    AppMethodBeat.o(139408);
  }
  
  public final void EC()
  {
    AppMethodBeat.i(139410);
    super.EC();
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    if (this.kZY == null)
    {
      ac.w("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
      AppMethodBeat.o(139410);
      return;
    }
    if ((this.ccU instanceof e))
    {
      e locale = (e)this.ccU;
      locale.b(this.kZY);
      locale.b(this.kZY);
      locale.b(this.kZY);
    }
    this.kZY.release();
    AppMethodBeat.o(139410);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139413);
        com.tencent.mm.plugin.appbrand.jsapi.camera.g localg = this.kZY;
        ac.i("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (localg == null)
        {
          ac.w("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
          i = 0;
          if (i != 0)
          {
            paramc.h(paramInt, paramm.e("ok", null));
            AppMethodBeat.o(139413);
          }
        }
        else
        {
          i = paramJSONObject.optInt("cameraId");
          Object localObject = paramJSONObject.optString("devicePosition", "back");
          String str = paramJSONObject.optString("flash", "auto");
          bool = paramJSONObject.optBoolean("needOutput", false);
          localg.setAppId(paramc.getAppId());
          localg.ao((String)localObject, false);
          localg.setFlash(str);
          localg.setNeedOutput(bool);
          JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
          int j = com.tencent.mm.plugin.appbrand.z.g.a(localJSONObject, "width", 0);
          int k = com.tencent.mm.plugin.appbrand.z.g.a(localJSONObject, "height", 0);
          ac.d("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(i), localObject, str, Integer.valueOf(j), Integer.valueOf(k) });
          if ((j == 0) || (k == 0)) {
            break label477;
          }
          bool = localg.dM(j, k);
          if ((paramc instanceof aa))
          {
            localObject = ad.g((aa)paramc);
            localg.setDisplayScreenSize(new Size(localObject[0], localObject[1]));
          }
          localObject = paramJSONObject.optString("mode");
          if (!bs.isNullOrNil((String)localObject)) {
            localg.setMode((String)localObject);
          }
          localObject = paramJSONObject.optJSONArray("scanArea");
          if ((localObject != null) && (((JSONArray)localObject).length() == 4))
          {
            ac.i("MicroMsg.JsApiUpdateXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject, Integer.valueOf(((JSONArray)localObject).length()) });
            localg.w(com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject).optInt(0)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject).optInt(1)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject).optInt(2)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject).optInt(3)));
          }
          localg.setScanFreq(paramJSONObject.optInt("scanFreq"));
          if (bool)
          {
            localg.release();
            localg.initView();
          }
          else
          {
            localg.bgd();
          }
        }
      }
      finally {}
      ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
      paramc.h(paramInt, paramm.e("fail:internal error", null));
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
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", new Object[] { Integer.valueOf(this.laa.size()) });
    paramSurfaceTexture = this.laa.iterator();
    while (paramSurfaceTexture.hasNext()) {
      ((Runnable)paramSurfaceTexture.next()).run();
    }
    AppMethodBeat.o(139409);
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String h(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139411);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      com.tencent.mm.plugin.appbrand.i.b localb = (com.tencent.mm.plugin.appbrand.i.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = localb.jOV;
      final m localm = localb.jOU;
      final JSONObject localJSONObject = localb.jML;
      final int i = localb.jOT;
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Ap(), localm.getName(), localJSONObject.toString() });
      localc.N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139401);
          a.this.ccU = localc;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Object localObject1;
          int j;
          int i;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b))
          {
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
            localObject2 = a.this;
            localObject3 = localc;
            localObject4 = parama;
            localObject1 = localJSONObject;
            Object localObject6 = localm;
            int k = i;
            if (((a)localObject2).mSurfaceTexture == null)
            {
              ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
              AppMethodBeat.o(139401);
              return;
            }
            Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).getContext();
            ((a)localObject2).kZY = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)a.kZZ.ds((Context)localObject5));
            Object localObject8;
            Object localObject7;
            String str4;
            if ((localObject3 instanceof e))
            {
              localObject5 = (e)localObject3;
              localObject8 = (com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject6;
              localObject7 = ((a)localObject2).kZY;
              Object localObject9 = ((a)localObject2).mSurfaceTexture;
              ((com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject8).knf = false;
              localObject8 = ((e)localObject5).getContext();
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
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setAppId(((e)localObject5).getAppId());
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPage((e)localObject5);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCameraId(m);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setMode(str1);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).ao(str2, true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFlash(str3);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setFrameLimitSize(i);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setNeedOutput(bool);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setResolution(str4);
                  ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setCustomSurfaceTexture((SurfaceTexture)localObject9);
                  localObject9 = ((JSONObject)localObject1).optJSONObject("position");
                  i = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject9, "width", 0);
                  j = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject9, "height", 0);
                  if ((i != 0) && (j != 0)) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).dM(i, j);
                  }
                  if ((localObject5 instanceof aa))
                  {
                    localObject9 = ad.g((aa)localObject5);
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setDisplayScreenSize(new Size(localObject9[0], localObject9[1]));
                  }
                  localObject9 = ((JSONObject)localObject1).optJSONArray("scanArea");
                  if ((localObject9 != null) && (((JSONArray)localObject9).length() == 4))
                  {
                    ac.i("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject9, Integer.valueOf(((JSONArray)localObject9).length()) });
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).w(com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject9).optInt(0)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject9).optInt(1)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject9).optInt(2)), com.tencent.mm.plugin.appbrand.z.g.ve(((JSONArray)localObject9).optInt(3)));
                    label586:
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setScanFreq(((JSONObject)localObject1).optInt("scanFreq"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).setPreviewCenterCrop(((JSONObject)localObject1).optBoolean("centerCrop"));
                    ac.d("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(m), str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
                    localObject7 = ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).getView();
                    if (!"normal".equals(str1)) {
                      break label876;
                    }
                    localObject1 = ((Context)localObject8).getString(2131755283);
                    label689:
                    ((View)localObject7).setContentDescription((CharSequence)localObject1);
                    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject6;
                    localObject7 = ((a)localObject2).kZY;
                    localObject6 = new a.3((a)localObject2, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, k, (m)localObject6);
                    ac.i("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
                    if (localObject7 != null) {
                      break label889;
                    }
                    ac.w("MicroMsg.JsApiInsertXWebCamera", "onInsertView failed, cameraView is null");
                  }
                  break;
                }
                break;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject3).N(new a.4((a)localObject2, (e)localObject5));
              ((com.tencent.luggage.k.a.a)localObject4).a(new a.5((a)localObject2, (e)localObject5, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject3, (com.tencent.luggage.k.a.a)localObject4));
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
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject7).w(0, 0, i, j);
              break label586;
              label876:
              localObject1 = ((Context)localObject8).getString(2131755284);
              break label689;
              label889:
              ((com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject1).a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject5, (f)localObject7, (b.a)localObject6);
              com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bfZ().a(((f)localObject7).getCameraId(), (f)localObject7);
              ((e)localObject5).a((f.d)localObject7);
              ((e)localObject5).a((f.b)localObject7);
              ((e)localObject5).a((f.c)localObject7);
              localObject6 = new WeakReference(localObject7);
              com.tencent.mm.plugin.appbrand.g.a(((e)localObject5).getAppId(), new b.1((com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject1, (WeakReference)localObject6, (e)localObject5));
              ((f)localObject7).setOutPutCallBack(new b.2((com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)localObject1));
            }
          }
          if ((localm instanceof d))
          {
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
            a.this.a(localc, localJSONObject, localm, i);
            AppMethodBeat.o(139401);
            return;
          }
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.a.a.c))
          {
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
            localObject3 = a.this;
            localObject1 = localc;
            localObject2 = localm;
            j = i;
            localObject3 = ((a)localObject3).kZY;
            ac.i("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
            if (localObject3 == null) {
              ac.w("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
            }
            for (i = 0; i != 0; i = 1)
            {
              ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).h(j, ((m)localObject2).e("ok", null));
              AppMethodBeat.o(139401);
              return;
              if ((localObject1 instanceof e))
              {
                localObject4 = (e)localObject1;
                ((e)localObject4).b((f.d)localObject3);
                ((e)localObject4).b((f.b)localObject3);
                ((e)localObject4).b((f.c)localObject3);
              }
              ((com.tencent.mm.plugin.appbrand.jsapi.camera.g)localObject3).release();
            }
            ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
            ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).h(j, ((m)localObject2).e("fail:internal error", null));
          }
          AppMethodBeat.o(139401);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(139402);
          if ((a.this.mSurfaceTexture == null) && ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b)))
          {
            a.this.laa.add(this.val$runnable);
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
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139412);
    this.kZY.l(paramMotionEvent);
    AppMethodBeat.o(139412);
  }
  
  public static abstract interface a
  {
    public abstract f ds(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.a
 * JD-Core Version:    0.7.0.1
 */