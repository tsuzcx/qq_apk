package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
  private boolean isRunning = false;
  private com.tencent.mm.modelgeo.b tAQ = null;
  private com.tencent.mm.modelgeo.b.a tAR = null;
  private aq tAS = null;
  
  public static b cUS()
  {
    AppMethodBeat.i(25055);
    b localb = b.cUT();
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
    this.tAQ = d.aIh();
    if (this.tAQ == null)
    {
      ae.e(TAG, "doGeoLocation fail, iGetLocation is null");
      AppMethodBeat.o(25056);
      return;
    }
    if (this.tAR == null) {
      this.tAR = new com.tencent.mm.modelgeo.b.a()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          AppMethodBeat.i(25052);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(25052);
            return true;
          }
          ae.v(b.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
          if (b.a(b.this) != null) {
            b.a(b.this).c(b.b(b.this));
          }
          if (b.b(b.this) == null)
          {
            ae.w(b.TAG, "already callback");
            AppMethodBeat.o(25052);
            return false;
          }
          b.c(b.this);
          parama.R(paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(25052);
          return false;
        }
      };
    }
    if (this.tAS == null) {
      this.tAS = new aq(Looper.myLooper());
    }
    this.tAS.postDelayed(new Runnable()
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
          ae.w(b.TAG, "already callback");
          AppMethodBeat.o(25053);
          return;
        }
        b.c(b.this);
        AppMethodBeat.o(25053);
      }
    }, 20000L);
    this.tAQ.a(this.tAR);
    AppMethodBeat.o(25056);
  }
  
  public static abstract interface a
  {
    public abstract void R(float paramFloat1, float paramFloat2);
  }
  
  static final class b
  {
    private static b tAV;
    
    static
    {
      AppMethodBeat.i(25054);
      tAV = new b((byte)0);
      AppMethodBeat.o(25054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b
 * JD-Core Version:    0.7.0.1
 */