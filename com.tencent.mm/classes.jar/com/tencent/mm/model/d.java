package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
{
  private Context IR;
  private b dcI;
  private b.a hHp;
  a hHq;
  private boolean hHr;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.hHr = false;
    this.IR = ak.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static d aAm()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(218655);
    if (this.dcI == null)
    {
      AppMethodBeat.o(218655);
      return false;
    }
    if (this.hHr)
    {
      AppMethodBeat.o(218655);
      return false;
    }
    this.dcI.requestFocus();
    this.hHr = true;
    boolean bool = this.hHr;
    AppMethodBeat.o(218655);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.hHq = parama;
    boolean bool = aAn();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean aAn()
  {
    AppMethodBeat.i(218656);
    b localb = new b((byte)0);
    if (this.dcI == null) {
      this.dcI = new b(this.IR);
    }
    if (this.hHp != localb) {
      this.hHp = localb;
    }
    this.dcI.a(this.hHp);
    boolean bool = requestFocus();
    AppMethodBeat.o(218656);
    return bool;
  }
  
  public final boolean abn()
  {
    AppMethodBeat.i(150153);
    boolean bool = ez(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean ez(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.dcI != null) {}
    for (boolean bool = this.dcI.abn();; bool = false)
    {
      this.hHr = false;
      if (paramBoolean)
      {
        this.dcI = null;
        this.hHp = null;
        this.hHq = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aAo();
    
    public abstract void aAp();
    
    public abstract void aAq();
    
    public abstract void aAr();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hF(int paramInt)
    {
      AppMethodBeat.i(150149);
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
              AppMethodBeat.o(150149);
              return;
              ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.hHq == null);
            d.this.hHq.aAo();
            AppMethodBeat.o(150149);
            return;
            ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.hHq == null);
          d.this.hHq.aAp();
          AppMethodBeat.o(150149);
          return;
          ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.hHq == null);
        d.this.hHq.aAq();
        AppMethodBeat.o(150149);
        return;
        ae.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.hHq == null);
      d.this.hHq.aAr();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */