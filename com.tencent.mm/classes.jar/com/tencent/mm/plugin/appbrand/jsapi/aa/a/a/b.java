package com.tencent.mm.plugin.appbrand.jsapi.aa.a.a;

import android.app.Activity;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.f;
import com.tencent.mm.plugin.appbrand.jsapi.camera.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.permission.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 806;
  public static final String NAME = "insertXWebCamera";
  public boolean jME;
  
  public final boolean a(final c paramc, final f paramf, final a parama)
  {
    AppMethodBeat.i(139417);
    o.b(String.valueOf(paramc.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(139416);
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLz = true;
            b.this.a(paramc, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new i().h(paramc).HK(paramAnonymousArrayOfString).aXQ();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLz = false;
          AppMethodBeat.o(139416);
          return;
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLA = true;
            b.this.a(paramc, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new i().h(paramc).HK(paramAnonymousArrayOfString).aXQ();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLA = false;
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
    boolean bool = h.a(localActivity, "android.permission.CAMERA", 16, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLz = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    bool = h.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.aZh().jLA = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    o.Mi(paramc.getAppId());
    if (!this.jME)
    {
      if (parama != null) {
        parama.bfd();
      }
      paramf.initView();
      this.jME = true;
    }
    AppMethodBeat.o(139417);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bfd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.a.b
 * JD-Core Version:    0.7.0.1
 */