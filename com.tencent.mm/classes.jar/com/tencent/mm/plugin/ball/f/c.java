package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.service.d;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106333);
    if (b.dh(paramContext))
    {
      Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
      a(parama, true);
      AppMethodBeat.o(106333);
      return;
    }
    String str = null;
    switch (paramInt)
    {
    }
    while (str != null)
    {
      d.cYL();
      int i = d.ahW(str);
      Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission from type:%d reqCnt: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (i >= 3)
      {
        a(parama, false);
        AppMethodBeat.o(106333);
        return;
        str = "req_perm_cnt";
        continue;
        str = "req_perm_cnt_game_download";
      }
      else
      {
        d.cYL();
        d.dw(str, i + 1);
      }
    }
    a(paramContext, ac(paramContext, paramInt), paramBoolean, parama);
    AppMethodBeat.o(106333);
  }
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106334);
    if (b.dh(paramContext))
    {
      Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
      a(parama, true);
      AppMethodBeat.o(106334);
      return;
    }
    RequestFloatWindowPermissionDialog.a(paramContext, paramString, new c.1(parama), paramBoolean, a.aQB());
    AppMethodBeat.o(106334);
  }
  
  static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(106336);
    if (parama != null) {
      parama.onCheckResult(paramBoolean);
    }
    AppMethodBeat.o(106336);
  }
  
  private static String ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106335);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert);
    }
    for (;;)
    {
      AppMethodBeat.o(106335);
      return paramContext;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_location);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_music);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_webpage);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_appbrand);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_note);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_files);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_download);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_appbrand_voip);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_music);
      continue;
      paramContext = paramContext.getString(a.h.float_ball_no_float_window_permission_alert_bluetooth);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCheckResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.c
 * JD-Core Version:    0.7.0.1
 */