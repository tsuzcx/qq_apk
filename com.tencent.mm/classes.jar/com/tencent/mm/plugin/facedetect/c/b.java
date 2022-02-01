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
    wwo = new b("IML");
    wwp = new b[] { wwo };
    AppMethodBeat.o(103645);
  }
  
  private b() {}
  
  public static a a(Context paramContext, f paramf, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(189664);
    Log.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(189664);
      return null;
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      paramContext = new c(paramContext, paramf, paramInt);
      AppMethodBeat.o(189664);
      return paramContext;
    case 2: 
    case 5: 
      paramContext = new d(paramContext, paramf, paramInt, paramBundle);
      AppMethodBeat.o(189664);
      return paramContext;
    }
    paramContext = new e(paramContext, paramf, paramInt);
    AppMethodBeat.o(189664);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.b
 * JD-Core Version:    0.7.0.1
 */