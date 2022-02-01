package com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
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
  public boolean lQg;
  
  public final boolean a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final com.tencent.mm.plugin.appbrand.jsapi.camera.f paramf1, final a parama)
  {
    AppMethodBeat.i(139417);
    r.b(String.valueOf(paramf.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(139416);
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOV = true;
            b.this.a(paramf, paramf1, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf1.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new com.tencent.mm.plugin.appbrand.jsapi.camera.i().h(paramf).Zh(paramAnonymousArrayOfString).bEo();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOV = false;
          AppMethodBeat.o(139416);
          return;
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOW = true;
            b.this.a(paramf, paramf1, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf1.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new com.tencent.mm.plugin.appbrand.jsapi.camera.i().h(paramf).Zh(paramAnonymousArrayOfString).bEo();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOW = false;
        }
        AppMethodBeat.o(139416);
      }
    });
    Activity localActivity = (Activity)paramf.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    boolean bool = com.tencent.luggage.h.i.a(localActivity, "android.permission.CAMERA", 16, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOV = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    bool = com.tencent.luggage.h.i.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bFI().lOW = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    r.aeq(paramf.getAppId());
    if (!this.lQg)
    {
      if (parama != null) {
        parama.bMa();
      }
      paramf1.initView();
      this.lQg = true;
    }
    AppMethodBeat.o(139417);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bMa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b
 * JD-Core Version:    0.7.0.1
 */