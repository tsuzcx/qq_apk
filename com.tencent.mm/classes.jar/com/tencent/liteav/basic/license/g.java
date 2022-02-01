package com.tencent.liteav.basic.license;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
  implements e
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    AppMethodBeat.i(241455);
    if (this.a != null) {
      LicenceCheck.a().a(null, this.a);
    }
    if (LicenceCheck.a().b() >= 2)
    {
      AppMethodBeat.o(241455);
      return true;
    }
    AppMethodBeat.o(241455);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.license.g
 * JD-Core Version:    0.7.0.1
 */