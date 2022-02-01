package com.tencent.mm.bi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.mc.b;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.afe(2131755906);
    paramContext.afi(paramInt);
    paramContext.afl(2131755793).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.irq != null) {
          this.irq.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.yR(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.irq != null) {
          this.irq.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.fMb();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean aMh()
  {
    AppMethodBeat.i(151158);
    mc localmc = new mc();
    localmc.dzy.action = 2;
    com.tencent.mm.sdk.b.a.IbL.l(localmc);
    boolean bool = localmc.dzz.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean aMi()
  {
    AppMethodBeat.i(151159);
    if ((g.irs != null) && (g.irs.aLT()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean aMj()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.aMk()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean cd(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.s.a.cd(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bi.e
 * JD-Core Version:    0.7.0.1
 */