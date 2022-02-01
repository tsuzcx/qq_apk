package com.tencent.mm.mj_template.sns;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.recordvideo.util.l;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/Utils;", "", "()V", "checkMiaojian", "", "context", "Landroid/content/Context;", "checkMiaojianInstalled", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b odP;
  
  static
  {
    AppMethodBeat.i(240158);
    odP = new b();
    AppMethodBeat.o(240158);
  }
  
  private static final void a(boolean paramBoolean, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(240150);
    s.u(paramContext, "$context");
    e.xfd.f("SnsPublishProcess", "ifEgExit", Integer.valueOf(1));
    if (paramBoolean)
    {
      paramDialogInterface = l.ObI;
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.util.k.ObH;
      paramDialogInterface = l.gH("moments", com.tencent.mm.plugin.recordvideo.util.k.gLn());
      l locall = l.ObI;
      l.aG(paramContext, paramDialogInterface);
      AppMethodBeat.o(240150);
      return;
    }
    paramDialogInterface = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    paramDialogInterface = com.tencent.mm.plugin.recordvideo.util.k.ObH;
    com.tencent.mm.plugin.recordvideo.util.b.aL(paramContext, s.X(com.tencent.mm.plugin.recordvideo.util.k.gLo(), "1106"));
    AppMethodBeat.o(240150);
  }
  
  private static final void b(DialogInterface paramDialogInterface, int paramInt) {}
  
  public static boolean dD(Context paramContext)
  {
    AppMethodBeat.i(240133);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.recordvideo.util.b localb = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    boolean bool = com.tencent.mm.plugin.recordvideo.util.b.D(paramContext, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    paramContext = e.xfd;
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      paramContext.f("SnsTemplate", "installMiaojian", Integer.valueOf(i));
      AppMethodBeat.o(240133);
      return bool;
    }
  }
  
  public static void dE(Context paramContext)
  {
    AppMethodBeat.i(240141);
    s.u(paramContext, "context");
    boolean bool = dD(paramContext);
    e.xfd.f("SnsTemplate", "moreAction", Integer.valueOf(1));
    int i;
    int j;
    if (bool)
    {
      i = c.g.app_field_secondcut_jump_tip;
      if (!bool) {
        break label93;
      }
      j = c.g.app_tip;
      label49:
      if (!bool) {
        break label100;
      }
    }
    label93:
    label100:
    for (int k = c.g.app_ok;; k = c.g.odd)
    {
      com.tencent.mm.ui.base.k.a(paramContext, i, j, k, c.g.app_cancel, new b..ExternalSyntheticLambda0(bool, paramContext), b..ExternalSyntheticLambda1.INSTANCE);
      AppMethodBeat.o(240141);
      return;
      i = 0;
      break;
      j = c.g.ode;
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.b
 * JD-Core Version:    0.7.0.1
 */