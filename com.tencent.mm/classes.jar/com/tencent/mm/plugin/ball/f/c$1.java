package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c$1
  implements RequestFloatWindowPermissionDialog.a
{
  c$1(c.a parama) {}
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(106330);
    Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission granted");
    paramRequestFloatWindowPermissionDialog.finish();
    c.a(this.olq, true);
    AppMethodBeat.o(106330);
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(106331);
    Log.w("MicroMsg.FloatBallPermissionUtil", "float window permission refused");
    paramRequestFloatWindowPermissionDialog.finish();
    c.a(this.olq, false);
    AppMethodBeat.o(106331);
  }
  
  public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(186121);
    boolean bool = b.ct(MMApplicationContext.getContext());
    Log.w("MicroMsg.FloatBallPermissionUtil", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(bool) });
    paramRequestFloatWindowPermissionDialog.finish();
    c.a(this.olq, bool);
    AppMethodBeat.o(186121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.c.1
 * JD-Core Version:    0.7.0.1
 */