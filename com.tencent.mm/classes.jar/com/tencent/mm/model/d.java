package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class d
{
  private Context FZ;
  private b cST;
  private b.a gLK;
  a gLL;
  private boolean gLM;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.gLM = false;
    this.FZ = aj.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static d aqs()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  public final boolean XF()
  {
    AppMethodBeat.i(150153);
    boolean bool = ea(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.gLL = parama;
    parama = new b((byte)0);
    if (this.cST == null) {
      this.cST = new b(this.FZ);
    }
    if (this.gLK != parama) {
      this.gLK = parama;
    }
    this.cST.a(this.gLK);
    if (this.cST == null)
    {
      AppMethodBeat.o(150152);
      return false;
    }
    if (this.gLM)
    {
      AppMethodBeat.o(150152);
      return false;
    }
    this.cST.requestFocus();
    this.gLM = true;
    boolean bool = this.gLM;
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean ea(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.cST != null) {}
    for (boolean bool = this.cST.XF();; bool = false)
    {
      this.gLM = false;
      if (paramBoolean)
      {
        this.cST = null;
        this.gLK = null;
        this.gLL = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aqt();
    
    public abstract void aqu();
    
    public abstract void aqv();
    
    public abstract void aqw();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hM(int paramInt)
    {
      AppMethodBeat.i(150149);
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
              AppMethodBeat.o(150149);
              return;
              ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.gLL == null);
            d.this.gLL.aqt();
            AppMethodBeat.o(150149);
            return;
            ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.gLL == null);
          d.this.gLL.aqu();
          AppMethodBeat.o(150149);
          return;
          ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.gLL == null);
        d.this.gLL.aqv();
        AppMethodBeat.o(150149);
        return;
        ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.gLL == null);
      d.this.gLL.aqw();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */