package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static String P(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106335);
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      paramContext = paramContext.getString(2131760764);
    }
    for (;;)
    {
      AppMethodBeat.o(106335);
      return paramContext;
      paramContext = paramContext.getString(2131760769);
      continue;
      paramContext = paramContext.getString(2131760770);
      continue;
      paramContext = paramContext.getString(2131760772);
      continue;
      paramContext = paramContext.getString(2131760765);
      continue;
      paramContext = paramContext.getString(2131760771);
      continue;
      paramContext = paramContext.getString(2131760768);
      continue;
      paramContext = paramContext.getString(2131760767);
      continue;
      paramContext = paramContext.getString(2131760766);
      continue;
      paramContext = paramContext.getString(2131760770);
    }
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106333);
    if (b.cx(paramContext))
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
      e.ciJ();
      int i = e.agV(str);
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
        e.ciJ();
        e.cz(str, i + 1);
      }
    }
    a(paramContext, P(paramContext, paramInt), paramBoolean, parama);
    AppMethodBeat.o(106333);
  }
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106334);
    if (b.cx(paramContext))
    {
      Log.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
      a(parama, true);
      AppMethodBeat.o(106334);
      return;
    }
    RequestFloatWindowPermissionDialog.a(paramContext, paramString, new RequestFloatWindowPermissionDialog.a()
    {
      public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(106330);
        Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.lqG, true);
        AppMethodBeat.o(106330);
      }
      
      public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(186121);
        boolean bool = b.cx(MMApplicationContext.getContext());
        Log.w("MicroMsg.FloatBallPermissionUtil", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(bool) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.lqG, bool);
        AppMethodBeat.o(186121);
      }
      
      public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(106331);
        Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.lqG, false);
        AppMethodBeat.o(106331);
      }
    }, paramBoolean, a.apJ());
    AppMethodBeat.o(106334);
  }
  
  static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(106336);
    if (parama != null) {
      parama.ha(paramBoolean);
    }
    AppMethodBeat.o(106336);
  }
  
  public static abstract interface a
  {
    public abstract void ha(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.c
 * JD-Core Version:    0.7.0.1
 */