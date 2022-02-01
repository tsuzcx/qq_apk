package com.tencent.mm.bh;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lt.b;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.acF(2131755906);
    paramContext.acJ(paramInt);
    paramContext.acM(2131755793).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.hXV != null) {
          this.hXV.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.yf(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.hXV != null) {
          this.hXV.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.fvp();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean aIX()
  {
    AppMethodBeat.i(151158);
    lt locallt = new lt();
    locallt.dnK.action = 2;
    com.tencent.mm.sdk.b.a.GpY.l(locallt);
    boolean bool = locallt.dnL.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean aIY()
  {
    AppMethodBeat.i(151159);
    if ((g.hXW != null) && (g.hXW.aIJ()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean aIZ()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.aJa()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean cf(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.r.a.cf(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bh.e
 * JD-Core Version:    0.7.0.1
 */