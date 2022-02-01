package com.tencent.mm.bi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.lk.b;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.aau(2131755906);
    paramContext.aay(paramInt);
    paramContext.aaB(2131755793).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.hxu != null) {
          this.hxu.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.wX(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.hxu != null) {
          this.hxu.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.fft();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean aCh()
  {
    AppMethodBeat.i(151158);
    lk locallk = new lk();
    locallk.dpZ.action = 2;
    com.tencent.mm.sdk.b.a.ESL.l(locallk);
    boolean bool = locallk.dqa.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean aCi()
  {
    AppMethodBeat.i(151159);
    if ((g.hxv != null) && (g.hxv.aBT()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean aCj()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.aCk()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean cc(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.r.a.cc(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bi.e
 * JD-Core Version:    0.7.0.1
 */