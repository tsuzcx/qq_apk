package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class d
{
  private Context IR;
  private b dbG;
  private b.a hEx;
  a hEy;
  private boolean hEz;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.hEz = false;
    this.IR = aj.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static d azW()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(195205);
    if (this.dbG == null)
    {
      AppMethodBeat.o(195205);
      return false;
    }
    if (this.hEz)
    {
      AppMethodBeat.o(195205);
      return false;
    }
    this.dbG.requestFocus();
    this.hEz = true;
    boolean bool = this.hEz;
    AppMethodBeat.o(195205);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.hEy = parama;
    boolean bool = azX();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean abe()
  {
    AppMethodBeat.i(150153);
    boolean bool = ex(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean azX()
  {
    AppMethodBeat.i(195206);
    b localb = new b((byte)0);
    if (this.dbG == null) {
      this.dbG = new b(this.IR);
    }
    if (this.hEx != localb) {
      this.hEx = localb;
    }
    this.dbG.a(this.hEx);
    boolean bool = requestFocus();
    AppMethodBeat.o(195206);
    return bool;
  }
  
  public final boolean ex(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.dbG != null) {}
    for (boolean bool = this.dbG.abe();; bool = false)
    {
      this.hEz = false;
      if (paramBoolean)
      {
        this.dbG = null;
        this.hEx = null;
        this.hEy = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aAa();
    
    public abstract void aAb();
    
    public abstract void azY();
    
    public abstract void azZ();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void hD(int paramInt)
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
            } while (d.this.hEy == null);
            d.this.hEy.azY();
            AppMethodBeat.o(150149);
            return;
            ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.hEy == null);
          d.this.hEy.azZ();
          AppMethodBeat.o(150149);
          return;
          ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.hEy == null);
        d.this.hEy.aAa();
        AppMethodBeat.o(150149);
        return;
        ad.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.hEy == null);
      d.this.hEy.aAb();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */