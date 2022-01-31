package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ah;

public class TMAssistantProfile
  extends e
{
  public static final String bXW;
  
  static
  {
    AppMethodBeat.i(15404);
    bXW = ah.getPackageName() + ":TMAssistantDownloadSDKService";
    AppMethodBeat.o(15404);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(15403);
    a.bp(ah.getContext());
    m.dw(bXW);
    s.By();
    AppMethodBeat.o(15403);
  }
  
  public String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */