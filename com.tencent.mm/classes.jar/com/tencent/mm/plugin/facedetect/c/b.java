package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum b
{
  static
  {
    AppMethodBeat.i(120);
    mhw = new b("IML");
    mhx = new b[] { mhw };
    AppMethodBeat.o(120);
  }
  
  private b() {}
  
  public static a a(Context paramContext, f paramf, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(119);
    ab.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(119);
      return null;
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      paramContext = new c(paramContext, paramf, paramInt1, paramInt2);
      AppMethodBeat.o(119);
      return paramContext;
    case 2: 
    case 5: 
      paramContext = new d(paramContext, paramf, paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(119);
      return paramContext;
    }
    paramContext = new e(paramContext, paramf, paramInt1, paramInt2);
    AppMethodBeat.o(119);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.b
 * JD-Core Version:    0.7.0.1
 */