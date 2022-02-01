package com.tencent.mm.plugin.appbrand.launching.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;

 enum b
{
  final String inP;
  final int scene;
  
  static
  {
    AppMethodBeat.i(47409);
    lMF = new b("WALLET", 0, "weapp://wallet/", 1019);
    lMG = new b("SEARCH_NATIVE_FEATURE", 1, "weapp://search/", 1005);
    lMH = new b[] { lMF, lMG };
    AppMethodBeat.o(47409);
  }
  
  private b(String paramString, int paramInt)
  {
    this.inP = paramString;
    this.scene = paramInt;
  }
  
  static WeAppOpenDeclarePromptBundle K(Bundle paramBundle)
  {
    AppMethodBeat.i(188646);
    if (paramBundle == null)
    {
      AppMethodBeat.o(188646);
      return null;
    }
    paramBundle = (WeAppOpenDeclarePromptBundle)paramBundle.getParcelable("weapp_open_declare_prompt_key");
    AppMethodBeat.o(188646);
    return paramBundle;
  }
  
  static String brT()
  {
    return "";
  }
  
  static String brU()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.b
 * JD-Core Version:    0.7.0.1
 */