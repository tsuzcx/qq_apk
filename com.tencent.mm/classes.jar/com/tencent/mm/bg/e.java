package com.tencent.mm.bg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.b;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class e
{
  public static c a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(78818);
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131297087);
    paramContext.Rf(paramInt);
    paramContext.Ri(2131296977).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78812);
        if (this.fUL != null) {
          this.fUL.run();
        }
        AppMethodBeat.o(78812);
      }
    });
    paramContext.rG(true);
    paramContext.e(new e.2(paramRunnable));
    paramContext = paramContext.aLZ();
    paramContext.show();
    AppMethodBeat.o(78818);
    return paramContext;
  }
  
  public static boolean alb()
  {
    AppMethodBeat.i(78815);
    kf localkf = new kf();
    localkf.czQ.action = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localkf);
    boolean bool = localkf.czR.isStart;
    AppMethodBeat.o(78815);
    return bool;
  }
  
  public static boolean alc()
  {
    AppMethodBeat.i(78816);
    if ((g.fUM != null) && (g.fUM.akO()))
    {
      AppMethodBeat.o(78816);
      return true;
    }
    AppMethodBeat.o(78816);
    return false;
  }
  
  public static boolean ald()
  {
    AppMethodBeat.i(78817);
    if ((d.fUO != null) && (d.fUO.ale()))
    {
      AppMethodBeat.o(78817);
      return true;
    }
    AppMethodBeat.o(78817);
    return false;
  }
  
  public static boolean bM(Context paramContext)
  {
    AppMethodBeat.i(78814);
    boolean bool = com.tencent.mm.r.a.bM(paramContext);
    AppMethodBeat.o(78814);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bg.e
 * JD-Core Version:    0.7.0.1
 */