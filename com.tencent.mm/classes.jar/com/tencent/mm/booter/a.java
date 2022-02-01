package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements an
{
  private static volatile a gkY;
  private List<ao> callbacks;
  private PhoneStatusWatcher gkW;
  private PhoneStatusWatcher.PhoneCallListener gkX;
  private IListener gkZ;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.gkW = new PhoneStatusWatcher();
    this.gkX = new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(149953);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(149953);
          return;
          Log.v("MicroMsg.BackgroundPlayer", "call end");
          a.this.akq();
          AppMethodBeat.o(149953);
          return;
          Log.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.akr();
        }
      }
    };
    this.gkW.addPhoneCallListener(this.gkX);
    this.gkW.begin(MMApplicationContext.getContext());
    if (this.gkZ == null) {
      this.gkZ = new IListener() {};
    }
    EventCenter.instance.addListener(this.gkZ);
    AppMethodBeat.o(149955);
  }
  
  public static a akp()
  {
    AppMethodBeat.i(149956);
    if (gkY == null) {}
    try
    {
      if (gkY == null) {
        gkY = new a();
      }
      a locala = gkY;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(149957);
    Log.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramao.toString() });
    this.callbacks.add(paramao);
    AppMethodBeat.o(149957);
  }
  
  public final void akq()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ao)localIterator.next()).aVl();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void akr()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ao)localIterator.next()).aVm();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void b(ao paramao)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramao);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */