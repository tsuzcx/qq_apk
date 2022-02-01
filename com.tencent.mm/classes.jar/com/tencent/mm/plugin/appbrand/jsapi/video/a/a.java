package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private b hqw;
  private Context mAppContext;
  private b.a oiE;
  private boolean oiG;
  a sAC;
  
  public a()
  {
    AppMethodBeat.i(328228);
    this.oiG = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(328228);
  }
  
  private boolean bAh()
  {
    AppMethodBeat.i(328237);
    b localb = new b((byte)0);
    if (this.hqw == null) {
      this.hqw = new b(this.mAppContext);
    }
    if (this.oiE != localb) {
      this.oiE = localb;
    }
    this.hqw.a(this.oiE);
    boolean bool = requestFocus();
    AppMethodBeat.o(328237);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(328233);
    if (this.hqw == null)
    {
      AppMethodBeat.o(328233);
      return false;
    }
    if (this.oiG)
    {
      AppMethodBeat.o(328233);
      return false;
    }
    this.hqw.requestFocus();
    this.oiG = true;
    boolean bool = this.oiG;
    AppMethodBeat.o(328233);
    return bool;
  }
  
  public final boolean cvF()
  {
    AppMethodBeat.i(328244);
    this.sAC = null;
    boolean bool = bAh();
    AppMethodBeat.o(328244);
    return bool;
  }
  
  public final boolean cvG()
  {
    AppMethodBeat.i(328251);
    if (this.hqw != null) {}
    for (boolean bool = this.hqw.aPS();; bool = false)
    {
      this.oiG = false;
      AppMethodBeat.o(328251);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void onChange(int paramInt)
    {
      AppMethodBeat.i(328257);
      switch (paramInt)
      {
      case 0: 
      default: 
        Log.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(328257);
              return;
              Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.sAC == null);
            AppMethodBeat.o(328257);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.sAC == null);
          AppMethodBeat.o(328257);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.sAC == null);
        AppMethodBeat.o(328257);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.sAC == null);
      AppMethodBeat.o(328257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */