package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
  private boolean isRunning = false;
  private com.tencent.mm.modelgeo.b wRR = null;
  private com.tencent.mm.modelgeo.b.a wRS = null;
  private MMHandler wRT = null;
  
  public static b dOb()
  {
    AppMethodBeat.i(25055);
    b localb = b.dOc();
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
    this.wRR = d.bca();
    if (this.wRR == null)
    {
      Log.e(TAG, "doGeoLocation fail, iGetLocation is null");
      AppMethodBeat.o(25056);
      return;
    }
    if (this.wRS == null) {
      this.wRS = new com.tencent.mm.modelgeo.b.a()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          AppMethodBeat.i(25052);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(25052);
            return true;
          }
          Log.v(b.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
          if (b.a(b.this) != null) {
            b.a(b.this).c(b.b(b.this));
          }
          if (b.b(b.this) == null)
          {
            Log.w(b.TAG, "already callback");
            AppMethodBeat.o(25052);
            return false;
          }
          b.c(b.this);
          parama.V(paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(25052);
          return false;
        }
      };
    }
    if (this.wRT == null) {
      this.wRT = new MMHandler(Looper.myLooper());
    }
    this.wRT.postDelayed(new Runnable()
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
          Log.w(b.TAG, "already callback");
          AppMethodBeat.o(25053);
          return;
        }
        b.c(b.this);
        AppMethodBeat.o(25053);
      }
    }, 20000L);
    this.wRR.a(this.wRS);
    AppMethodBeat.o(25056);
  }
  
  public static abstract interface a
  {
    public abstract void V(float paramFloat1, float paramFloat2);
  }
  
  static final class b
  {
    private static b wRW;
    
    static
    {
      AppMethodBeat.i(25054);
      wRW = new b((byte)0);
      AppMethodBeat.o(25054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b
 * JD-Core Version:    0.7.0.1
 */