package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private b fmh;
  private b.a lrd;
  private boolean lrf;
  private Context mAppContext;
  a pvw;
  
  public a()
  {
    AppMethodBeat.i(227144);
    this.lrf = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(227144);
  }
  
  private boolean avy()
  {
    AppMethodBeat.i(227150);
    if (this.fmh == null)
    {
      AppMethodBeat.o(227150);
      return false;
    }
    if (this.lrf)
    {
      AppMethodBeat.o(227150);
      return false;
    }
    this.fmh.avy();
    this.lrf = true;
    boolean bool = this.lrf;
    AppMethodBeat.o(227150);
    return bool;
  }
  
  private boolean bct()
  {
    AppMethodBeat.i(227153);
    b localb = new b((byte)0);
    if (this.fmh == null) {
      this.fmh = new b(this.mAppContext);
    }
    if (this.lrd != localb) {
      this.lrd = localb;
    }
    this.fmh.a(this.lrd);
    boolean bool = avy();
    AppMethodBeat.o(227153);
    return bool;
  }
  
  public final boolean bVr()
  {
    AppMethodBeat.i(227148);
    this.pvw = null;
    boolean bool = bct();
    AppMethodBeat.o(227148);
    return bool;
  }
  
  public final boolean bVs()
  {
    AppMethodBeat.i(227155);
    if (this.fmh != null) {}
    for (boolean bool = this.fmh.avz();; bool = false)
    {
      this.lrf = false;
      AppMethodBeat.o(227155);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void kp(int paramInt)
    {
      AppMethodBeat.i(229360);
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
              AppMethodBeat.o(229360);
              return;
              Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.pvw == null);
            AppMethodBeat.o(229360);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.pvw == null);
          AppMethodBeat.o(229360);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.pvw == null);
        AppMethodBeat.o(229360);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.pvw == null);
      AppMethodBeat.o(229360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */