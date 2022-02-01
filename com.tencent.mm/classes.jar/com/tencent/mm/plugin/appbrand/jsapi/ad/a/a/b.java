package com.tencent.mm.plugin.appbrand.jsapi.ad.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.f;
import com.tencent.mm.plugin.appbrand.jsapi.camera.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.permission.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 806;
  public static final String NAME = "insertXWebCamera";
  public boolean kLu;
  
  public final boolean a(final c paramc, final f paramf, final a parama)
  {
    AppMethodBeat.i(139417);
    r.b(String.valueOf(paramc.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(139416);
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKp = true;
            b.this.a(paramc, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new i().h(paramc).PQ(paramAnonymousArrayOfString).bja();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKp = false;
          AppMethodBeat.o(139416);
          return;
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKq = true;
            b.this.a(paramc, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new i().h(paramc).PQ(paramAnonymousArrayOfString).bja();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKq = false;
        }
        AppMethodBeat.o(139416);
      }
    });
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    boolean bool = com.tencent.luggage.h.h.a(localActivity, "android.permission.CAMERA", 16, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKp = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    bool = com.tencent.luggage.h.h.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bkm().kKq = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    r.UC(paramc.getAppId());
    if (!this.kLu)
    {
      if (parama != null) {
        parama.bqs();
      }
      paramf.initView();
      this.kLu = true;
    }
    AppMethodBeat.o(139417);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bqs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.a.b
 * JD-Core Version:    0.7.0.1
 */