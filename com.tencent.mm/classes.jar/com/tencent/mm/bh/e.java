package com.tencent.mm.bh;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.mu.b;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.d.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new d.a(paramContext);
    paramContext.aoO(2131755998);
    paramContext.aoS(paramInt);
    paramContext.aoV(2131755874).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (this.jpx != null) {
          this.jpx.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.Dk(true);
    paramContext.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (this.jpx != null) {
          this.jpx.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.hbn();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean bgF()
  {
    AppMethodBeat.i(151158);
    mu localmu = new mu();
    localmu.dSs.action = 2;
    EventCenter.instance.publish(localmu);
    boolean bool = localmu.dSt.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean bgG()
  {
    AppMethodBeat.i(151159);
    if ((g.jpy != null) && (g.jpy.bgr()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean bgH()
  {
    AppMethodBeat.i(151160);
    if ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.bgJ()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean bgI()
  {
    AppMethodBeat.i(223643);
    if (h.aqJ().getInt("MultitalkBlockReceiver", 0) == 0)
    {
      AppMethodBeat.o(223643);
      return true;
    }
    AppMethodBeat.o(223643);
    return false;
  }
  
  public static boolean cA(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.q.a.cA(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
  
  public static boolean isCalling()
  {
    AppMethodBeat.i(223644);
    if (((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(223644);
      return true;
    }
    AppMethodBeat.o(223644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bh.e
 * JD-Core Version:    0.7.0.1
 */