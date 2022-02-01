package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  b gdr;
  private final String gds;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(155865);
    this.mContext = null;
    this.gdr = null;
    this.gds = "audio_lock";
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = aj.getContext();
    }
    this.mContext = localContext;
    a.a(8, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(155864);
        b.this.gdr = new c(b.this.mContext);
        AppMethodBeat.o(155864);
      }
    });
    AppMethodBeat.o(155865);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(155868);
    if (this.gdr != null) {
      this.gdr.a(parama);
    }
    AppMethodBeat.o(155868);
  }
  
  public final boolean abe()
  {
    AppMethodBeat.i(155867);
    try
    {
      if (this.gdr == null) {
        return false;
      }
      boolean bool = this.gdr.abe();
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
      if (this.gdr == null) {
        return false;
      }
      boolean bool = this.gdr.requestFocus();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155866);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract boolean abe();
    
    public abstract boolean requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */