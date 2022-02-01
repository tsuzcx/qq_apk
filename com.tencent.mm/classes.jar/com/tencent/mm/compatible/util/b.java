package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  b fGj;
  private final String fGk;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(155865);
    this.mContext = null;
    this.fGj = null;
    this.fGk = "audio_lock";
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
        b.this.fGj = new c(b.this.mContext);
        AppMethodBeat.o(155864);
      }
    });
    AppMethodBeat.o(155865);
  }
  
  public final boolean XF()
  {
    AppMethodBeat.i(155867);
    try
    {
      if (this.fGj == null) {
        return false;
      }
      boolean bool = this.fGj.XF();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155867);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(155868);
    if (this.fGj != null) {
      this.fGj.a(parama);
    }
    AppMethodBeat.o(155868);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(155866);
    try
    {
      if (this.fGj == null) {
        return false;
      }
      boolean bool = this.fGj.requestFocus();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(155866);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hM(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean XF();
    
    public abstract void a(b.a parama);
    
    public abstract boolean requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */