package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoSpaceProfile
  extends c
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(19462);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":nospace";
    AppMethodBeat.o(19462);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19461);
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    ac.abg();
    AppMethodBeat.o(19461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.NoSpaceProfile
 * JD-Core Version:    0.7.0.1
 */