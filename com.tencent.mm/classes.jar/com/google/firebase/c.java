package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements BackgroundDetector.BackgroundStateChangeListener
{
  public final void onBackgroundStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(10639);
    a.rC();
    AppMethodBeat.o(10639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.firebase.c
 * JD-Core Version:    0.7.0.1
 */