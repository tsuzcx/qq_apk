package com.tencent.mm.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d
{
  private b hqw;
  private Context mAppContext;
  private b.a oiE;
  a oiF;
  private boolean oiG;
  
  public d()
  {
    AppMethodBeat.i(150150);
    this.oiG = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(150150);
  }
  
  public static void a(d paramd, String paramString)
  {
    AppMethodBeat.i(241922);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "MicroMsg.AudioHelperTool";
    }
    if (paramd != null) {
      paramd.a(new d.1(str));
    }
    AppMethodBeat.o(241922);
  }
  
  private boolean requestFocus()
  {
    AppMethodBeat.i(241916);
    if (this.hqw == null)
    {
      AppMethodBeat.o(241916);
      return false;
    }
    if (this.oiG)
    {
      AppMethodBeat.o(241916);
      return false;
    }
    this.hqw.requestFocus();
    this.oiG = true;
    boolean bool = this.oiG;
    AppMethodBeat.o(241916);
    return bool;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150152);
    this.oiF = parama;
    boolean bool = bAh();
    AppMethodBeat.o(150152);
    return bool;
  }
  
  public final boolean bAh()
  {
    AppMethodBeat.i(241936);
    b localb = new b((byte)0);
    if (this.hqw == null) {
      this.hqw = new b(this.mAppContext);
    }
    if (this.oiE != localb) {
      this.oiE = localb;
    }
    this.hqw.a(this.oiE);
    boolean bool = requestFocus();
    AppMethodBeat.o(241936);
    return bool;
  }
  
  public final boolean gR(boolean paramBoolean)
  {
    AppMethodBeat.i(150154);
    if (this.hqw != null) {}
    for (boolean bool = this.hqw.aPS();; bool = false)
    {
      this.oiG = false;
      if (paramBoolean)
      {
        this.hqw = null;
        this.oiE = null;
        this.oiF = null;
      }
      AppMethodBeat.o(150154);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bAi();
    
    public abstract void bAj();
    
    public abstract void bAk();
    
    public abstract void bAl();
  }
  
  final class b
    implements b.a
  {
    private b() {}
    
    public final void onChange(int paramInt)
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
            } while (d.this.oiF == null);
            d.this.oiF.bAi();
            AppMethodBeat.o(150149);
            return;
            Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.oiF == null);
          d.this.oiF.bAj();
          AppMethodBeat.o(150149);
          return;
          Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.oiF == null);
        d.this.oiF.bAk();
        AppMethodBeat.o(150149);
        return;
        Log.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.oiF == null);
      d.this.oiF.bAl();
      AppMethodBeat.o(150149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */