package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum b
{
  static
  {
    AppMethodBeat.i(103645);
    sQr = new b("IML");
    sQs = new b[] { sQr };
    AppMethodBeat.o(103645);
  }
  
  private b() {}
  
  public static a a(Context paramContext, f paramf, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(186362);
    Log.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(186362);
      return null;
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      paramContext = new c(paramContext, paramf, paramInt);
      AppMethodBeat.o(186362);
      return paramContext;
    case 2: 
    case 5: 
      paramContext = new d(paramContext, paramf, paramInt, paramBundle);
      AppMethodBeat.o(186362);
      return paramContext;
    }
    paramContext = new e(paramContext, paramf, paramInt);
    AppMethodBeat.o(186362);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.b
 * JD-Core Version:    0.7.0.1
 */