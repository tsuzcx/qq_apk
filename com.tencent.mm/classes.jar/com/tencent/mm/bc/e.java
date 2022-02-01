package com.tencent.mm.bc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.autogen.a.os.b;
import com.tencent.mm.bd.d;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.e.a;

public final class e
{
  public static com.tencent.mm.ui.widget.a.e a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(151161);
    paramContext = new e.a(paramContext);
    paramContext.aEK(c.h.app_tip);
    paramContext.aEO(paramInt);
    paramContext.aER(c.h.app_i_known).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(151155);
        if (e.this != null) {
          e.this.run();
        }
        AppMethodBeat.o(151155);
      }
    });
    paramContext.NC(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151156);
        if (e.this != null) {
          e.this.run();
        }
        AppMethodBeat.o(151156);
      }
    });
    paramContext = paramContext.jHH();
    paramContext.show();
    AppMethodBeat.o(151161);
    return paramContext;
  }
  
  public static boolean bNA()
  {
    AppMethodBeat.i(151158);
    os localos = new os();
    localos.hRy.action = 2;
    localos.publish();
    boolean bool = localos.hRz.isStart;
    AppMethodBeat.o(151158);
    return bool;
  }
  
  public static boolean bNB()
  {
    AppMethodBeat.i(151159);
    if ((g.oXL != null) && (g.oXL.bNn()))
    {
      AppMethodBeat.o(151159);
      return true;
    }
    AppMethodBeat.o(151159);
    return false;
  }
  
  public static boolean bNC()
  {
    AppMethodBeat.i(151160);
    if ((d.oXN != null) && (d.oXN.bNE()))
    {
      AppMethodBeat.o(151160);
      return true;
    }
    AppMethodBeat.o(151160);
    return false;
  }
  
  public static boolean bND()
  {
    AppMethodBeat.i(231896);
    if (i.aRC().getInt("MultitalkBlockReceiver", 0) == 0)
    {
      AppMethodBeat.o(231896);
      return true;
    }
    AppMethodBeat.o(231896);
    return false;
  }
  
  public static boolean dl(Context paramContext)
  {
    AppMethodBeat.i(151157);
    boolean bool = com.tencent.mm.n.a.dl(paramContext);
    AppMethodBeat.o(151157);
    return bool;
  }
  
  public static boolean isCalling()
  {
    AppMethodBeat.i(231901);
    if (((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(231901);
      return true;
    }
    AppMethodBeat.o(231901);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.e
 * JD-Core Version:    0.7.0.1
 */