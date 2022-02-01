package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.aj;

public class TMAssistantProfile
  extends d
{
  public static final String cTJ;
  
  static
  {
    AppMethodBeat.i(19479);
    cTJ = aj.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(19479);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19478);
    a.bF(aj.getContext());
    s.fk(cTJ);
    ab.MA();
    AppMethodBeat.o(19478);
  }
  
  public String toString()
  {
    return cTJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */