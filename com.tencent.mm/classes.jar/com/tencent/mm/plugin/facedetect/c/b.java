package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public enum b
{
  private b() {}
  
  public static a a(Context paramContext, e parame, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      return new c(paramContext, parame, paramInt1, paramInt2);
    }
    return new d(paramContext, parame, paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.b
 * JD-Core Version:    0.7.0.1
 */