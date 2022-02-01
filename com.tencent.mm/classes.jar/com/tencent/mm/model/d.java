package com.tencent.mm.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class d
{
  private b fmh;
  private b.a lrd;
  private a lre;
  private boolean lrf;
  private Context mAppContext;
  
  private d()
  {
    AppMethodBeat.i(150150);
    this.lrf = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static void a(d paramd, String paramString)
  {
    AppMethodBeat.i(203189);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "MicroMsg.AudioHelperTool";
    }
    if (paramd != null) {
      paramd.a(new d.1(str));
    }
    AppMethodBeat.o(203189);
  }
  
  private boolean avy()
  {
    AppMethodBeat.i(203184);
    if (this.fmh == null)
    {
      AppMethodBeat.o(203184);
      return false;
    }
    if (this.lrf)
    {
      AppMethodBeat.o(203184);
      return false;
    }
    this.fmh.avy();
    this.lrf = true;
    boolean bool = this.lrf;
    AppMethodBeat.o(203184);
    return bool;
  }
  
  public static d bcs()
  {
    AppMethodBeat.i(150151);
    d locald = new d();
    AppMethodBeat.o(150151);
    return locald;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.lre = parama;
    boolean bool = bct();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean avz()
  {
    AppMethodBeat.i(150153);
    boolean bool = fZ(false);
    AppMethodBeat.o(150153);
    return bool;
  }
  
  public final boolean bct()
  {
    AppMethodBeat.i(203187);
    b localb = new b((byte)0);
    if (this.fmh == null) {
      this.fmh = new b(this.mAppContext);
    }
    if (this.lrd != localb) {
      this.lrd = localb;
    }
    this.fmh.a(this.lrd);
    boolean bool = avy();
    AppMethodBeat.o(203187);
    return bool;
  }
  
  public final boolean fZ(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.fmh != null) {}
    for (boolean bool = this.fmh.avz();; bool = false)
    {
      this.lrf = false;
      if (paramBoolean)
      {
        this.fmh = null;
        this.lrd = null;
        this.lre = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bcu();
    
    public abstract void bcv();
    
    public abstract void bcw();
    
    public abstract void bcx();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void kp(int paramInt)
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
            } while (d.a(d.this) == null);
            d.a(d.this).bcu();
            AppMethodBeat.o(150149);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.a(d.this) == null);
          d.a(d.this).bcv();
          AppMethodBeat.o(150149);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.a(d.this) == null);
        d.a(d.this).bcw();
        AppMethodBeat.o(150149);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.a(d.this) == null);
      d.a(d.this).bcx();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */