package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ap;
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
  implements ao
{
  private static volatile a iPf;
  private List<ap> callbacks;
  private PhoneStatusWatcher iPd;
  private PhoneStatusWatcher.PhoneCallListener iPe;
  private IListener iPg;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.iPd = new PhoneStatusWatcher();
    this.iPe = new PhoneStatusWatcher.PhoneCallListener()
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
          a.this.aqm();
          AppMethodBeat.o(149953);
          return;
          Log.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.aqn();
        }
      }
    };
    this.iPd.addPhoneCallListener(this.iPe);
    this.iPd.begin(MMApplicationContext.getContext());
    if (this.iPg == null) {
      this.iPg = new a.2(this);
    }
    EventCenter.instance.addListener(this.iPg);
    AppMethodBeat.o(149955);
  }
  
  public static a aql()
  {
    AppMethodBeat.i(149956);
    if (iPf == null) {}
    try
    {
      if (iPf == null) {
        iPf = new a();
      }
      a locala = iPf;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void a(ap paramap)
  {
    AppMethodBeat.i(149957);
    Log.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramap.toString() });
    this.callbacks.add(paramap);
    AppMethodBeat.o(149957);
  }
  
  public final void aqm()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ap)localIterator.next()).beo();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void aqn()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ap)localIterator.next()).bep();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void b(ap paramap)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramap);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */