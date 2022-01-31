package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private b bDz;
  private b.a dUs;
  a dUt;
  private boolean dUu = false;
  private Context ze = ae.getContext();
  
  public final boolean a(a parama)
  {
    this.dUt = parama;
    parama = new b((byte)0);
    if (this.bDz == null) {
      this.bDz = new b(this.ze);
    }
    if (this.dUs != parama) {
      this.dUs = parama;
    }
    this.bDz.a(this.dUs);
    if (this.bDz == null) {}
    while (this.dUu) {
      return false;
    }
    this.bDz.requestFocus();
    this.dUu = true;
    return this.dUu;
  }
  
  public final boolean bH(boolean paramBoolean)
  {
    if (this.bDz != null) {}
    for (boolean bool = this.bDz.zE();; bool = false)
    {
      this.dUu = false;
      if (paramBoolean)
      {
        this.bDz = null;
        this.dUs = null;
        this.dUt = null;
      }
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  private final class b
    implements b.a
  {
    private b() {}
    
    public final void ex(int paramInt)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        y.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              y.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.dUt == null);
            return;
            y.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.dUt == null);
          return;
          y.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.dUt == null);
        return;
        y.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.dUt == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */