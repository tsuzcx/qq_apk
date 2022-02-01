package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class d
{
  private Context GX;
  private b cQq;
  private b.a hmk;
  a hml;
  private boolean hmm;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.hmm = false;
    this.GX = ai.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static d axh()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(192599);
    if (this.cQq == null)
    {
      AppMethodBeat.o(192599);
      return false;
    }
    if (this.hmm)
    {
      AppMethodBeat.o(192599);
      return false;
    }
    this.cQq.requestFocus();
    this.hmm = true;
    boolean bool = this.hmm;
    AppMethodBeat.o(192599);
    return bool;
  }
  
  public final boolean YC()
  {
    AppMethodBeat.i(150153);
    boolean bool = ev(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.hml = parama;
    boolean bool = axi();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean axi()
  {
    AppMethodBeat.i(192600);
    b localb = new b((byte)0);
    if (this.cQq == null) {
      this.cQq = new b(this.GX);
    }
    if (this.hmk != localb) {
      this.hmk = localb;
    }
    this.cQq.a(this.hmk);
    boolean bool = requestFocus();
    AppMethodBeat.o(192600);
    return bool;
  }
  
  public final boolean ev(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.cQq != null) {}
    for (boolean bool = this.cQq.YC();; bool = false)
    {
      this.hmm = false;
      if (paramBoolean)
      {
        this.cQq = null;
        this.hmk = null;
        this.hml = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void axj();
    
    public abstract void axk();
    
    public abstract void axl();
    
    public abstract void axm();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hw(int paramInt)
    {
      AppMethodBeat.i(150149);
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
              AppMethodBeat.o(150149);
              return;
              ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.hml == null);
            d.this.hml.axj();
            AppMethodBeat.o(150149);
            return;
            ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.hml == null);
          d.this.hml.axk();
          AppMethodBeat.o(150149);
          return;
          ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.hml == null);
        d.this.hml.axl();
        AppMethodBeat.o(150149);
        return;
        ac.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.hml == null);
      d.this.hml.axm();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */