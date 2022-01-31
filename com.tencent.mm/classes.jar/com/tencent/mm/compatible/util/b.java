package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;

public final class b
{
  b.b esi;
  private final String esj;
  Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(93060);
    this.mContext = null;
    this.esi = null;
    this.esj = "audio_lock";
    this.mContext = paramContext;
    a.a(8, new b.1(this));
    AppMethodBeat.o(93060);
  }
  
  public final boolean Mh()
  {
    AppMethodBeat.i(93062);
    try
    {
      if (this.esi == null) {
        return false;
      }
      boolean bool = this.esi.Mh();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(93062);
    }
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(93063);
    if (this.esi != null) {
      this.esi.a(parama);
    }
    AppMethodBeat.o(93063);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(93061);
    try
    {
      if (this.esi == null) {
        return false;
      }
      boolean bool = this.esi.requestFocus();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(93061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.util.b
 * JD-Core Version:    0.7.0.1
 */