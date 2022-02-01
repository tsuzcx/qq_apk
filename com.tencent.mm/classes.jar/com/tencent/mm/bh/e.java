package com.tencent.mm.bh;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.md.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static boolean PC()
  {
    AppMethodBeat.i(218744);
    if (((TelephonyManager)ak.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(218744);
      return true;
    }
    AppMethodBeat.o(218744);
    return false;
  }
  
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.afN(2131755906);
    paramContext.afR(paramInt);
    paramContext.afU(2131755793).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.iul != null) {
          this.iul.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.zf(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.iul != null) {
          this.iul.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.fQv();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean aME()
  {
    AppMethodBeat.i(151158);
    md localmd = new md();
    localmd.dAD.action = 2;
    com.tencent.mm.sdk.b.a.IvT.l(localmd);
    boolean bool = localmd.dAE.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean aMF()
  {
    AppMethodBeat.i(151159);
    if ((g.ium != null) && (g.ium.aMq()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean aMG()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.aMI()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean aMH()
  {
    AppMethodBeat.i(218743);
    if (com.tencent.mm.n.g.acL().getInt("MultitalkBlockReceiver", 0) == 0)
    {
      AppMethodBeat.o(218743);
      return true;
    }
    AppMethodBeat.o(218743);
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