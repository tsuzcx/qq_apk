package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b oOe;
  private com.tencent.mm.plugin.backup.c.a oLp;
  private c oOf;
  private e oOg;
  private d oOh;
  private a oOi;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b cga()
  {
    AppMethodBeat.i(21549);
    if (oOe == null)
    {
      localb = new b();
      oOe = localb;
      a(localb);
    }
    b localb = oOe;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void ceH()
  {
    oOe = null;
  }
  
  public final void ceN()
  {
    AppMethodBeat.i(21556);
    MMHandlerThread.postToMainThread(new b.1(this));
    AppMethodBeat.o(21556);
  }
  
  public final void ceO()
  {
    AppMethodBeat.i(21557);
    MMHandlerThread.postToMainThread(new b.2(this));
    AppMethodBeat.o(21557);
  }
  
  public final com.tencent.mm.plugin.backup.c.a cfw()
  {
    AppMethodBeat.i(21551);
    if (this.oLp == null) {
      this.oLp = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.oLp;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final c cgb()
  {
    AppMethodBeat.i(21552);
    if (this.oOf == null) {
      this.oOf = new c();
    }
    c localc = this.oOf;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e cgc()
  {
    AppMethodBeat.i(21553);
    if (this.oOg == null) {
      this.oOg = new e();
    }
    e locale = this.oOg;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d cgd()
  {
    AppMethodBeat.i(21554);
    if (this.oOh == null) {
      this.oOh = new d();
    }
    d locald = this.oOh;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a cge()
  {
    AppMethodBeat.i(21555);
    if (this.oOi == null) {
      this.oOi = new a();
    }
    a locala = this.oOi;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = cga().cgb();
    new MMHandler(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */