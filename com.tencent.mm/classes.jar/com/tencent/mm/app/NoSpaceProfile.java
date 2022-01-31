package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

public class NoSpaceProfile
  extends e
{
  public static final String bXW;
  
  static
  {
    AppMethodBeat.i(15389);
    bXW = ah.getPackageName() + ":nospace";
    AppMethodBeat.o(15389);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(15388);
    m.dw(bXW);
    aa.initLanguage(ah.getContext());
    s.By();
    AppMethodBeat.o(15388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.NoSpaceProfile
 * JD-Core Version:    0.7.0.1
 */