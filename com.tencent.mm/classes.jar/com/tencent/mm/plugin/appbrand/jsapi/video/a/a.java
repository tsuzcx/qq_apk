package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private Context FZ;
  private b cST;
  private b.a gLK;
  private boolean gLM;
  a knZ;
  
  public a()
  {
    AppMethodBeat.i(193796);
    this.gLM = false;
    this.FZ = aj.getContext();
    AppMethodBeat.o(193796);
  }
  
  private boolean bcP()
  {
    AppMethodBeat.i(193799);
    b localb = new b((byte)0);
    if (this.cST == null) {
      this.cST = new b(this.FZ);
    }
    if (this.gLK != localb) {
      this.gLK = localb;
    }
    this.cST.a(this.gLK);
    boolean bool = requestFocus();
    AppMethodBeat.o(193799);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(193798);
    if (this.cST == null)
    {
      AppMethodBeat.o(193798);
      return false;
    }
    if (this.gLM)
    {
      AppMethodBeat.o(193798);
      return false;
    }
    this.cST.requestFocus();
    this.gLM = true;
    boolean bool = this.gLM;
    AppMethodBeat.o(193798);
    return bool;
  }
  
  public final boolean bcO()
  {
    AppMethodBeat.i(193797);
    this.knZ = null;
    boolean bool = bcP();
    AppMethodBeat.o(193797);
    return bool;
  }
  
  public final boolean bcQ()
  {
    AppMethodBeat.i(193800);
    if (this.cST != null) {}
    for (boolean bool = this.cST.XF();; bool = false)
    {
      this.gLM = false;
      AppMethodBeat.o(193800);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hM(int paramInt)
    {
      AppMethodBeat.i(193795);
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
              AppMethodBeat.o(193795);
              return;
              ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.knZ == null);
            AppMethodBeat.o(193795);
            return;
            ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.knZ == null);
          AppMethodBeat.o(193795);
          return;
          ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.knZ == null);
        AppMethodBeat.o(193795);
        return;
        ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.knZ == null);
      AppMethodBeat.o(193795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */