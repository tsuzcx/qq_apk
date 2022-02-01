package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private b dtz;
  private boolean iBB;
  private b.a iBz;
  private Context mAppContext;
  a mxc;
  
  public a()
  {
    AppMethodBeat.i(234651);
    this.iBB = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(234651);
  }
  
  private boolean aTv()
  {
    AppMethodBeat.i(234654);
    b localb = new b((byte)0);
    if (this.dtz == null) {
      this.dtz = new b(this.mAppContext);
    }
    if (this.iBz != localb) {
      this.iBz = localb;
    }
    this.dtz.a(this.iBz);
    boolean bool = requestFocus();
    AppMethodBeat.o(234654);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(234653);
    if (this.dtz == null)
    {
      AppMethodBeat.o(234653);
      return false;
    }
    if (this.iBB)
    {
      AppMethodBeat.o(234653);
      return false;
    }
    this.dtz.requestFocus();
    this.iBB = true;
    boolean bool = this.iBB;
    AppMethodBeat.o(234653);
    return bool;
  }
  
  public final boolean bJI()
  {
    AppMethodBeat.i(234652);
    this.mxc = null;
    boolean bool = aTv();
    AppMethodBeat.o(234652);
    return bool;
  }
  
  public final boolean bJJ()
  {
    AppMethodBeat.i(234655);
    if (this.dtz != null) {}
    for (boolean bool = this.dtz.apm();; bool = false)
    {
      this.iBB = false;
      AppMethodBeat.o(234655);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void iZ(int paramInt)
    {
      AppMethodBeat.i(234650);
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
              AppMethodBeat.o(234650);
              return;
              Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.mxc == null);
            AppMethodBeat.o(234650);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.mxc == null);
          AppMethodBeat.o(234650);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.mxc == null);
        AppMethodBeat.o(234650);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.mxc == null);
      AppMethodBeat.o(234650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */