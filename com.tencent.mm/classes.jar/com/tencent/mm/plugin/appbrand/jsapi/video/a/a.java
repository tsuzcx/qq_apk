package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private Context IR;
  private b dbG;
  private b.a hEx;
  private boolean hEz;
  a llW;
  
  public a()
  {
    AppMethodBeat.i(205955);
    this.hEz = false;
    this.IR = aj.getContext();
    AppMethodBeat.o(205955);
  }
  
  private boolean azX()
  {
    AppMethodBeat.i(205958);
    b localb = new b((byte)0);
    if (this.dbG == null) {
      this.dbG = new b(this.IR);
    }
    if (this.hEx != localb) {
      this.hEx = localb;
    }
    this.dbG.a(this.hEx);
    boolean bool = requestFocus();
    AppMethodBeat.o(205958);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(205957);
    if (this.dbG == null)
    {
      AppMethodBeat.o(205957);
      return false;
    }
    if (this.hEz)
    {
      AppMethodBeat.o(205957);
      return false;
    }
    this.dbG.requestFocus();
    this.hEz = true;
    boolean bool = this.hEz;
    AppMethodBeat.o(205957);
    return bool;
  }
  
  public final boolean bnv()
  {
    AppMethodBeat.i(205956);
    this.llW = null;
    boolean bool = azX();
    AppMethodBeat.o(205956);
    return bool;
  }
  
  public final boolean bnw()
  {
    AppMethodBeat.i(205959);
    if (this.dbG != null) {}
    for (boolean bool = this.dbG.abe();; bool = false)
    {
      this.hEz = false;
      AppMethodBeat.o(205959);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hD(int paramInt)
    {
      AppMethodBeat.i(205954);
      switch (paramInt)
      {
      case 0: 
      default: 
        ad.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(205954);
              return;
              ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.llW == null);
            AppMethodBeat.o(205954);
            return;
            ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.llW == null);
          AppMethodBeat.o(205954);
          return;
          ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.llW == null);
        AppMethodBeat.o(205954);
        return;
        ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.llW == null);
      AppMethodBeat.o(205954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */