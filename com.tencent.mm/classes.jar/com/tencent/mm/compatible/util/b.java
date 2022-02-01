package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  b jvv;
  private final String jvw;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(155865);
    this.mContext = null;
    this.jvv = null;
    this.jvw = "audio_lock";
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
        b.this.jvv = new c(b.this.mContext);
        AppMethodBeat.o(155864);
      }
    });
    AppMethodBeat.o(155865);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(155868);
    if (this.jvv != null) {
      this.jvv.a(parama);
    }
    AppMethodBeat.o(155868);
  }
  
  public final boolean avy()
  {
    AppMethodBeat.i(155866);
    try
    {
      if (this.jvv == null) {
        return false;
      }
      boolean bool = this.jvv.avy();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155866);
    }
  }
  
  public final boolean avz()
  {
    AppMethodBeat.i(155867);
    try
    {
      if (this.jvv == null) {
        return false;
      }
      boolean bool = this.jvv.avz();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155867);
    }
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(262244);
    if (this.jvv != null) {
      this.jvv.b(parama);
    }
    AppMethodBeat.o(262244);
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract boolean avy();
    
    public abstract boolean avz();
    
    public abstract void b(b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */