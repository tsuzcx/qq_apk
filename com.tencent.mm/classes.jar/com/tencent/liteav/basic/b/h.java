package com.tencent.liteav.basic.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  implements f
{
  private Context a;
  
  public h(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    AppMethodBeat.i(221394);
    if (this.a != null) {
      e.a().a(null, this.a);
    }
    if (e.a().b() >= 2)
    {
      AppMethodBeat.o(221394);
      return true;
    }
    AppMethodBeat.o(221394);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.b.h
 * JD-Core Version:    0.7.0.1
 */