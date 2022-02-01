package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ai;

public class TMAssistantProfile
  extends d
{
  public static final String cIB;
  
  static
  {
    AppMethodBeat.i(19479);
    cIB = ai.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(19479);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19478);
    a.bG(ai.getContext());
    s.ep(cIB);
    ab.KT();
    AppMethodBeat.o(19478);
  }
  
  public String toString()
  {
    return cIB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */