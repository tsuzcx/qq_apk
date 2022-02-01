package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;

public class NoSpaceProfile
  extends d
{
  public static final String cTJ;
  
  static
  {
    AppMethodBeat.i(19462);
    cTJ = aj.getPackageName() + ":nospace";
    AppMethodBeat.o(19462);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19461);
    ac.initLanguage(aj.getContext());
    ab.MA();
    AppMethodBeat.o(19461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.NoSpaceProfile
 * JD-Core Version:    0.7.0.1
 */