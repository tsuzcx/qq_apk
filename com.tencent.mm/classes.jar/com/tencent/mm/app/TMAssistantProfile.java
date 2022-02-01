package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class TMAssistantProfile
  extends c
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(19479);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(19479);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19478);
    t.f(false, PROCESS_NAME);
    ac.abg();
    AppMethodBeat.o(19478);
  }
  
  public String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */