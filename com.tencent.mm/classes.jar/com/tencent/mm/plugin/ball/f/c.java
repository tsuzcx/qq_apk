package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  private static String L(Context paramContext, int paramInt)
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
      paramContext = paramContext.getString(2131759450);
    }
    for (;;)
    {
      AppMethodBeat.o(106335);
      return paramContext;
      paramContext = paramContext.getString(2131759455);
      continue;
      paramContext = paramContext.getString(2131759456);
      continue;
      paramContext = paramContext.getString(2131759458);
      continue;
      paramContext = paramContext.getString(2131759451);
      continue;
      paramContext = paramContext.getString(2131759457);
      continue;
      paramContext = paramContext.getString(2131759454);
      continue;
      paramContext = paramContext.getString(2131759453);
      continue;
      paramContext = paramContext.getString(2131759452);
      continue;
      paramContext = paramContext.getString(2131759456);
    }
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106333);
    if (b.cc(paramContext))
    {
      ae.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
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
      e.bLU();
      int i = e.Xa(str);
      ae.i("MicroMsg.FloatBallPermissionUtil", "checkPermission from type:%d reqCnt: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
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
        e.bLU();
        e.cs(str, i + 1);
      }
    }
    a(paramContext, L(paramContext, paramInt), paramBoolean, parama);
    AppMethodBeat.o(106333);
  }
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(106334);
    if (b.cc(paramContext))
    {
      ae.i("MicroMsg.FloatBallPermissionUtil", "checkPermission already had");
      a(parama, true);
      AppMethodBeat.o(106334);
      return;
    }
    RequestFloatWindowPermissionDialog.a(paramContext, paramString, new RequestFloatWindowPermissionDialog.a()
    {
      public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(106330);
        ae.w("MicroMsg.FloatBallPermissionUtil", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.kmY, true);
        AppMethodBeat.o(106330);
      }
      
      public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(106331);
        ae.w("MicroMsg.FloatBallPermissionUtil", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.kmY, false);
        AppMethodBeat.o(106331);
      }
      
      public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(186121);
        boolean bool = b.cc(ak.getContext());
        ae.w("MicroMsg.FloatBallPermissionUtil", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(bool) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        c.a(this.kmY, bool);
        AppMethodBeat.o(186121);
      }
    }, paramBoolean, a.abK());
    AppMethodBeat.o(106334);
  }
  
  static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(106336);
    if (parama != null) {
      parama.gd(paramBoolean);
    }
    AppMethodBeat.o(106336);
  }
  
  public static abstract interface a
  {
    public abstract void gd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.c
 * JD-Core Version:    0.7.0.1
 */