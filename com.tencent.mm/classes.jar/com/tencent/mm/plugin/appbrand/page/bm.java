package com.tencent.mm.plugin.appbrand.page;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.h;
import com.tencent.mm.plugin.appbrand.b.i;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
final class bm
  extends i
{
  final h iAi;
  final h iAj;
  private boolean izJ;
  
  private void l(Message paramMessage)
  {
    int j = 1;
    AppMethodBeat.i(140970);
    ab.i("Luggage.MPWebViewRenderEngine.StateMachine", "executeOrPostMessage %d, %s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj });
    if ((Looper.myLooper() == this.yrd.getLooper()) && (duh() != null) && (duh().what != -2))
    {
      bl[] arrayOfbl = bl.values();
      int k = arrayOfbl.length;
      int i = 0;
      if (i < k)
      {
        bl localbl = arrayOfbl[i];
        if (!this.yrd.hasMessages(localbl.ordinal())) {}
      }
      for (i = j;; i = 0)
      {
        if ((i != 0) || (this.gYX)) {
          break label145;
        }
        this.yrd.dispatchMessage(paramMessage);
        AppMethodBeat.o(140970);
        return;
        i += 1;
        break;
      }
    }
    label145:
    this.yrd.sendMessage(paramMessage);
    AppMethodBeat.o(140970);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(140973);
    ab.i("Luggage.MPWebViewRenderEngine.StateMachine", "onNewStateEntered %s", new Object[] { paramh.getName() });
    AppMethodBeat.o(140973);
  }
  
  final void a(bl parambl, Object paramObject)
  {
    AppMethodBeat.i(140971);
    l(obtainMessage(parambl.ordinal(), paramObject));
    AppMethodBeat.o(140971);
  }
  
  final a aKb()
  {
    AppMethodBeat.i(140972);
    a locala = super.dui();
    AppMethodBeat.o(140972);
    return locala;
  }
  
  final void aKc()
  {
    AppMethodBeat.i(140975);
    super.duj();
    AppMethodBeat.o(140975);
  }
  
  final boolean aKd()
  {
    AppMethodBeat.i(140976);
    Message localMessage = duh();
    if (this.yrd == null)
    {
      if (localMessage.what == -1)
      {
        AppMethodBeat.o(140976);
        return true;
      }
      AppMethodBeat.o(140976);
      return false;
    }
    boolean bool = d.c.w(localMessage);
    AppMethodBeat.o(140976);
    return bool;
  }
  
  public final void j(Message paramMessage)
  {
    AppMethodBeat.i(140974);
    super.j(paramMessage);
    ab.i("Luggage.MPWebViewRenderEngine.StateMachine", "unhandledMessage %s, %s", new Object[] { bl.pn(paramMessage.what), paramMessage.obj });
    if (bl.iAg.po(paramMessage.what)) {
      this.izJ = true;
    }
    if (bl.iAc.po(paramMessage.what)) {
      b(this.iAj);
    }
    AppMethodBeat.o(140974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */