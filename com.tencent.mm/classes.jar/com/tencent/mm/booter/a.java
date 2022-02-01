package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ap
{
  private static volatile a lrb;
  private List<aq> bPE;
  private PhoneStatusWatcher lqZ;
  private PhoneStatusWatcher.PhoneCallListener lra;
  private IListener lrc;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.bPE = new ArrayList();
    this.lqZ = new PhoneStatusWatcher();
    this.lra = new PhoneStatusWatcher.PhoneCallListener()
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
          a.this.aKk();
          AppMethodBeat.o(149953);
          return;
          Log.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.aKl();
        }
      }
    };
    this.lqZ.addPhoneCallListener(this.lra);
    this.lqZ.begin(MMApplicationContext.getContext());
    if (this.lrc == null) {
      this.lrc = new BackgroundPlayer.2(this, f.hfK);
    }
    this.lrc.alive();
    AppMethodBeat.o(149955);
  }
  
  public static a aKj()
  {
    AppMethodBeat.i(149956);
    if (lrb == null) {}
    try
    {
      if (lrb == null) {
        lrb = new a();
      }
      a locala = lrb;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void a(aq paramaq)
  {
    AppMethodBeat.i(149957);
    Log.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramaq.toString() });
    this.bPE.add(paramaq);
    AppMethodBeat.o(149957);
  }
  
  public final void aKk()
  {
    AppMethodBeat.i(149959);
    if (this.bPE == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((aq)localIterator.next()).bCh();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void aKl()
  {
    AppMethodBeat.i(149960);
    if (this.bPE == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((aq)localIterator.next()).bCi();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void b(aq paramaq)
  {
    AppMethodBeat.i(149958);
    this.bPE.remove(paramaq);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */