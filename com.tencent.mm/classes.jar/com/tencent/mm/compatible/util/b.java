package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  public b lYM;
  private final String lYN;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(155865);
    this.mContext = null;
    this.lYM = null;
    this.lYN = "audio_lock";
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = MMApplicationContext.getContext();
    }
    this.mContext = localContext;
    a.a(8, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(155864);
        b.this.lYM = new c(b.this.mContext);
        AppMethodBeat.o(155864);
      }
    });
    AppMethodBeat.o(155865);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(155868);
    if (this.lYM != null) {
      this.lYM.a(parama);
    }
    AppMethodBeat.o(155868);
  }
  
  public final boolean aPS()
  {
    AppMethodBeat.i(155867);
    try
    {
      if (this.lYM == null) {
        return false;
      }
      boolean bool = this.lYM.aPS();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155867);
    }
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(155866);
    try
    {
      if (this.lYM == null) {
        return false;
      }
      boolean bool = this.lYM.requestFocus();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155866);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onChange(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract boolean aPS();
    
    public abstract void b(b.a parama);
    
    public abstract boolean requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */