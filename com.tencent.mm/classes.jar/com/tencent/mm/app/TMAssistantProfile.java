package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ak;

public class TMAssistantProfile
  extends d
{
  public static final String cUu;
  
  static
  {
    AppMethodBeat.i(19479);
    cUu = ak.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(19479);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19478);
    a.bH(ak.getContext());
    t.fq(cUu);
    ab.Mv();
    AppMethodBeat.o(19478);
  }
  
  public String toString()
  {
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */