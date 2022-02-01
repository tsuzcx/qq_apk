package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  b gLg;
  private final String gLh;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(155865);
    this.mContext = null;
    this.gLg = null;
    this.gLh = "audio_lock";
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
        b.this.gLg = new c(b.this.mContext);
        AppMethodBeat.o(155864);
      }
    });
    AppMethodBeat.o(155865);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(155868);
    if (this.gLg != null) {
      this.gLg.a(parama);
    }
    AppMethodBeat.o(155868);
  }
  
  public final boolean apm()
  {
    AppMethodBeat.i(155867);
    try
    {
      if (this.gLg == null) {
        return false;
      }
      boolean bool = this.gLg.apm();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155867);
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(215252);
    if (this.gLg != null) {
      this.gLg.b(parama);
    }
    AppMethodBeat.o(215252);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(155866);
    try
    {
      if (this.gLg == null) {
        return false;
      }
      boolean bool = this.gLg.requestFocus();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155866);
    }
  }
  
  public static abstract interface a
  {
    public abstract void iZ(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract boolean apm();
    
    public abstract void b(b.a parama);
    
    public abstract boolean requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */