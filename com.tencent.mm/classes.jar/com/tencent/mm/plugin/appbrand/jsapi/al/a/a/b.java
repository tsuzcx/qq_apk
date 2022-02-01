package com.tencent.mm.plugin.appbrand.jsapi.al.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.d;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
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
  public boolean rQw;
  
  public final boolean a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final com.tencent.mm.plugin.appbrand.jsapi.camera.f paramf1, final a parama)
  {
    AppMethodBeat.i(139417);
    s.c(String.valueOf(paramf.getAppId()), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(139416);
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.cry().rPk = true;
            b.this.a(paramf, paramf1, parama);
            AppMethodBeat.o(139416);
            return;
          }
          paramAnonymousArrayOfString = new HashMap();
          paramAnonymousArrayOfString.put("cameraId", Integer.valueOf(paramf1.getCameraId()));
          paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString).toString();
          new com.tencent.mm.plugin.appbrand.jsapi.camera.i().i(paramf).ZR(paramAnonymousArrayOfString).cpV();
          com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.cry().rPk = false;
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
    boolean bool = com.tencent.luggage.l.i.a(localActivity, paramf, "android.permission.WRITE_EXTERNAL_STORAGE");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.cry().jk(bool);
    bool = com.tencent.luggage.l.i.a(localActivity, paramf, "android.permission.CAMERA", 16, "", "");
    com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.cry().rPk = bool;
    if (!bool)
    {
      AppMethodBeat.o(139417);
      return false;
    }
    s.afs(paramf.getAppId());
    if (!this.rQw)
    {
      if (parama != null) {
        parama.cyH();
      }
      paramf1.initView();
      this.rQw = true;
    }
    AppMethodBeat.o(139417);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void cyH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a.a.b
 * JD-Core Version:    0.7.0.1
 */