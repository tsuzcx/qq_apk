package com.tencent.mm.bj;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.f.a.nl.b;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.ayc(c.h.app_tip);
    paramContext.ayg(paramInt);
    paramContext.ayj(c.h.app_i_known).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.meS != null) {
          this.meS.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.HG(true);
    paramContext.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.meS != null) {
          this.meS.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.icu();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean bpU()
  {
    AppMethodBeat.i(151158);
    nl localnl = new nl();
    localnl.fLP.action = 2;
    EventCenter.instance.publish(localnl);
    boolean bool = localnl.fLQ.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean bpV()
  {
    AppMethodBeat.i(151159);
    if ((g.meT != null) && (g.meT.bpH()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean bpW()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.bpY()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean bpX()
  {
    AppMethodBeat.i(193643);
    if (h.axc().getInt("MultitalkBlockReceiver", 0) == 0)
    {
      AppMethodBeat.o(193643);
      return true;
    }
    AppMethodBeat.o(193643);
    return false;
  }
  
  public static boolean cw(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.q.a.cw(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
  
  public static boolean isCalling()
  {
    AppMethodBeat.i(193644);
    if (((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(193644);
      return true;
    }
    AppMethodBeat.o(193644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bj.e
 * JD-Core Version:    0.7.0.1
 */