package com.tencent.mm.ext.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean oppohasCutOut(Context paramContext)
  {
    AppMethodBeat.i(259085);
    if (paramContext == null)
    {
      AppMethodBeat.o(259085);
      return false;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    AppMethodBeat.o(259085);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.b.b
 * JD-Core Version:    0.7.0.1
 */