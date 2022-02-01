package com.tencent.mm.plugin.appbrand.jsapi.video.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private Context IR;
  private b dcI;
  private b.a hHp;
  private boolean hHr;
  a lqw;
  
  public a()
  {
    AppMethodBeat.i(210982);
    this.hHr = false;
    this.IR = ak.getContext();
    AppMethodBeat.o(210982);
  }
  
  private boolean aAn()
  {
    AppMethodBeat.i(210985);
    b localb = new b((byte)0);
    if (this.dcI == null) {
      this.dcI = new b(this.IR);
    }
    if (this.hHp != localb) {
      this.hHp = localb;
    }
    this.dcI.a(this.hHp);
    boolean bool = requestFocus();
    AppMethodBeat.o(210985);
    return bool;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(210984);
    if (this.dcI == null)
    {
      AppMethodBeat.o(210984);
      return false;
    }
    if (this.hHr)
    {
      AppMethodBeat.o(210984);
      return false;
    }
    this.dcI.requestFocus();
    this.hHr = true;
    boolean bool = this.hHr;
    AppMethodBeat.o(210984);
    return bool;
  }
  
  public final boolean bof()
  {
    AppMethodBeat.i(210983);
    this.lqw = null;
    boolean bool = aAn();
    AppMethodBeat.o(210983);
    return bool;
  }
  
  public final boolean bog()
  {
    AppMethodBeat.i(210986);
    if (this.dcI != null) {}
    for (boolean bool = this.dcI.abn();; bool = false)
    {
      this.hHr = false;
      AppMethodBeat.o(210986);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hF(int paramInt)
    {
      AppMethodBeat.i(210981);
      switch (paramInt)
      {
      case 0: 
      default: 
        ae.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(210981);
              return;
              ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (a.this.lqw == null);
            AppMethodBeat.o(210981);
            return;
            ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (a.this.lqw == null);
          AppMethodBeat.o(210981);
          return;
          ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (a.this.lqw == null);
        AppMethodBeat.o(210981);
        return;
        ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (a.this.lqw == null);
      AppMethodBeat.o(210981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.a.a
 * JD-Core Version:    0.7.0.1
 */