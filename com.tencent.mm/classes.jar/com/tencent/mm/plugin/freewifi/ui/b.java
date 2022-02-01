package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
  private boolean isRunning = false;
  private com.tencent.mm.modelgeo.b stx = null;
  private com.tencent.mm.modelgeo.b.a sty = null;
  private ao stz = null;
  
  public static b cJY()
  {
    AppMethodBeat.i(25055);
    b localb = b.cJZ();
    AppMethodBeat.o(25055);
    return localb;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(25056);
    if (this.isRunning)
    {
      AppMethodBeat.o(25056);
      return;
    }
    this.isRunning = true;
    this.stx = d.aEL();
    if (this.stx == null)
    {
      ac.e(TAG, "doGeoLocation fail, iGetLocation is null");
      AppMethodBeat.o(25056);
      return;
    }
    if (this.sty == null) {
      this.sty = new com.tencent.mm.modelgeo.b.a()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          AppMethodBeat.i(25052);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(25052);
            return true;
          }
          ac.v(b.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
          if (b.a(b.this) != null) {
            b.a(b.this).c(b.b(b.this));
          }
          if (b.b(b.this) == null)
          {
            ac.w(b.TAG, "already callback");
            AppMethodBeat.o(25052);
            return false;
          }
          b.c(b.this);
          parama.P(paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(25052);
          return false;
        }
      };
    }
    if (this.stz == null) {
      this.stz = new ao(Looper.myLooper());
    }
    this.stz.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25053);
        b.d(b.this);
        if (b.a(b.this) != null) {
          b.a(b.this).c(b.b(b.this));
        }
        if (b.b(b.this) == null)
        {
          ac.w(b.TAG, "already callback");
          AppMethodBeat.o(25053);
          return;
        }
        b.c(b.this);
        AppMethodBeat.o(25053);
      }
    }, 20000L);
    this.stx.a(this.sty);
    AppMethodBeat.o(25056);
  }
  
  public static abstract interface a
  {
    public abstract void P(float paramFloat1, float paramFloat2);
  }
  
  static final class b
  {
    private static b stC;
    
    static
    {
      AppMethodBeat.i(25054);
      stC = new b((byte)0);
      AppMethodBeat.o(25054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b
 * JD-Core Version:    0.7.0.1
 */