package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
  private boolean isRunning = false;
  private b mNM = null;
  private b.a mNN = null;
  private ak mNO = null;
  
  public static c bBz()
  {
    AppMethodBeat.i(20996);
    c localc = c.b.bBA();
    AppMethodBeat.o(20996);
    return localc;
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(20997);
    if (this.isRunning)
    {
      AppMethodBeat.o(20997);
      return;
    }
    this.isRunning = true;
    this.mNM = d.agQ();
    if (this.mNM == null)
    {
      ab.e(TAG, "doGeoLocation fail, iGetLocation is null");
      AppMethodBeat.o(20997);
      return;
    }
    if (this.mNN == null) {
      this.mNN = new b.a()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
        {
          AppMethodBeat.i(20993);
          if (!paramAnonymousBoolean)
          {
            AppMethodBeat.o(20993);
            return true;
          }
          ab.v(c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
          if (c.a(c.this) != null) {
            c.a(c.this).c(c.b(c.this));
          }
          if (c.b(c.this) == null)
          {
            ab.w(c.TAG, "already callback");
            AppMethodBeat.o(20993);
            return false;
          }
          c.c(c.this);
          parama.U(paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(20993);
          return false;
        }
      };
    }
    if (this.mNO == null) {
      this.mNO = new ak(Looper.myLooper());
    }
    this.mNO.postDelayed(new c.2(this), 20000L);
    this.mNM.a(this.mNN);
    AppMethodBeat.o(20997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.c
 * JD-Core Version:    0.7.0.1
 */