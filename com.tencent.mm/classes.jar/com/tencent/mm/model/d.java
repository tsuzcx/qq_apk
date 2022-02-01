package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d
{
  private b dtz;
  a iBA;
  private boolean iBB;
  private b.a iBz;
  private Context mAppContext;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.iBB = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static d aTu()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(223527);
    if (this.dtz == null)
    {
      AppMethodBeat.o(223527);
      return false;
    }
    if (this.iBB)
    {
      AppMethodBeat.o(223527);
      return false;
    }
    this.dtz.requestFocus();
    this.iBB = true;
    boolean bool = this.iBB;
    AppMethodBeat.o(223527);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.iBA = parama;
    boolean bool = aTv();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean aTv()
  {
    AppMethodBeat.i(223528);
    b localb = new b((byte)0);
    if (this.dtz == null) {
      this.dtz = new b(this.mAppContext);
    }
    if (this.iBz != localb) {
      this.iBz = localb;
    }
    this.dtz.a(this.iBz);
    boolean bool = requestFocus();
    AppMethodBeat.o(223528);
    return bool;
  }
  
  public final boolean apm()
  {
    AppMethodBeat.i(150153);
    boolean bool = fp(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean fp(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.dtz != null) {}
    for (boolean bool = this.dtz.apm();; bool = false)
    {
      this.iBB = false;
      if (paramBoolean)
      {
        this.dtz = null;
        this.iBz = null;
        this.iBA = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aTw();
    
    public abstract void aTx();
    
    public abstract void aTy();
    
    public abstract void aTz();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void iZ(int paramInt)
    {
      AppMethodBeat.i(150149);
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
              AppMethodBeat.o(150149);
              return;
              Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.iBA == null);
            d.this.iBA.aTw();
            AppMethodBeat.o(150149);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.iBA == null);
          d.this.iBA.aTx();
          AppMethodBeat.o(150149);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.iBA == null);
        d.this.iBA.aTy();
        AppMethodBeat.o(150149);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.iBA == null);
      d.this.iBA.aTz();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */