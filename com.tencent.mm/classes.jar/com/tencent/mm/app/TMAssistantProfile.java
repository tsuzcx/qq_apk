package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.aj;

public class TMAssistantProfile
  extends d
{
  public static final String cLt;
  
  static
  {
    AppMethodBeat.i(19479);
    cLt = aj.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(19479);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19478);
    a.bD(aj.getContext());
    s.eA(cLt);
    aa.KV();
    AppMethodBeat.o(19478);
  }
  
  public String toString()
  {
    return cLt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */