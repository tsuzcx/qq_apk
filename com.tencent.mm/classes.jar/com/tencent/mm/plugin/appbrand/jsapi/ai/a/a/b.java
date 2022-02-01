package com.tencent.mm.plugin.appbrand.jsapi.ai.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.d;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.camera.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
  implements d
{
  private static final int CTRL_INDEX = 806;
  public static final String NAME = "insertXWebCamera";
  public boolean oMA;
  
  public final boolean a(final e parame, final f paramf, final a parama)
  {
    AppMethodBeat.i(139417);
    r.b(String.valueOf(parame.getAppId()), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(139416);
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLp = true;
            b.this.a(parame, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new com.tencent.mm.plugin.appbrand.jsapi.camera.i().j(parame).agU(paramAnonymousArrayOfString).bPO();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLp = false;
          AppMethodBeat.o(139416);
          return;
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLq = true;
            b.this.a(parame, paramf, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new com.tencent.mm.plugin.appbrand.jsapi.camera.i().j(parame).agU(paramAnonymousArrayOfString).bPO();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLq = false;
        }
        AppMethodBeat.o(139416);
      }
    });
    Activity localActivity = (Activity)parame.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    boolean bool = com.tencent.luggage.k.i.a(localActivity, "android.permission.CAMERA", 16, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLp = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    bool = com.tencent.luggage.k.i.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.bRr().oLq = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    r.amk(parame.getAppId());
    if (!this.oMA)
    {
      if (parama != null) {
        parama.bYr();
      }
      paramf.initView();
      this.oMA = true;
    }
    AppMethodBeat.o(139417);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bYr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.a.b
 * JD-Core Version:    0.7.0.1
 */