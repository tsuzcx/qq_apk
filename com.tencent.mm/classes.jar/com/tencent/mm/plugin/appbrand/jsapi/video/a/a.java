package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  private Context GX;
  private b cQq;
  private b.a hmk;
  private boolean hmm;
  a kPu;
  
  public a()
  {
    AppMethodBeat.i(194143);
    this.hmm = false;
    this.GX = ai.getContext();
    AppMethodBeat.o(194143);
  }
  
  private boolean axi()
  {
    AppMethodBeat.i(194146);
    b localb = new b((byte)0);
    if (this.cQq == null) {
      this.cQq = new b(this.GX);
    }
    if (this.hmk != localb) {
      this.hmk = localb;
    }
    this.cQq.a(this.hmk);
    boolean bool = requestFocus();
    AppMethodBeat.o(194146);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(194145);
    if (this.cQq == null)
    {
      AppMethodBeat.o(194145);
      return false;
    }
    if (this.hmm)
    {
      AppMethodBeat.o(194145);
      return false;
    }
    this.cQq.requestFocus();
    this.hmm = true;
    boolean bool = this.hmm;
    AppMethodBeat.o(194145);
    return bool;
  }
  
  public final boolean bjK()
  {
    AppMethodBeat.i(194144);
    this.kPu = null;
    boolean bool = axi();
    AppMethodBeat.o(194144);
    return bool;
  }
  
  public final boolean bjL()
  {
    AppMethodBeat.i(194147);
    if (this.cQq != null) {}
    for (boolean bool = this.cQq.YC();; bool = false)
    {
      this.hmm = false;
      AppMethodBeat.o(194147);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hw(int paramInt)
    {
      AppMethodBeat.i(194142);
      switch (paramInt)
      {
      case 0: 
      default: 
        ac.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(194142);
              return;
              ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.kPu == null);
            AppMethodBeat.o(194142);
            return;
            ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.kPu == null);
          AppMethodBeat.o(194142);
          return;
          ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.kPu == null);
        AppMethodBeat.o(194142);
        return;
        ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.kPu == null);
      AppMethodBeat.o(194142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */