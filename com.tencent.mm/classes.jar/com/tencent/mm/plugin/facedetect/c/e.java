package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends a
{
  private static final String TAG;
  private boolean isRetry = false;
  private int sQt;
  
  static
  {
    AppMethodBeat.i(103684);
    TAG = "MicroMsg." + e.class.getSimpleName();
    AppMethodBeat.o(103684);
  }
  
  e(Context paramContext, f paramf, int paramInt)
  {
    super(paramContext, paramf, paramInt, 0);
    this.sQt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.e
 * JD-Core Version:    0.7.0.1
 */