package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.sdk.platformtools.ai;

public class NoSpaceProfile
  extends d
{
  public static final String cIB;
  
  static
  {
    AppMethodBeat.i(19462);
    cIB = ai.getPackageName() + ":nospace";
    AppMethodBeat.o(19462);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19461);
    s.ep(cIB);
    com.tencent.mm.sdk.platformtools.ab.initLanguage(ai.getContext());
    ab.KT();
    AppMethodBeat.o(19461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.NoSpaceProfile
 * JD-Core Version:    0.7.0.1
 */