package com.tencent.mm.plugin.appbrand.launching.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;

 enum b
{
  final String iqJ;
  final int scene;
  
  static
  {
    AppMethodBeat.i(47409);
    lRf = new b("WALLET", 0, "weapp://wallet/", 1019);
    lRg = new b("SEARCH_NATIVE_FEATURE", 1, "weapp://search/", 1005);
    lRh = new b[] { lRf, lRg };
    AppMethodBeat.o(47409);
  }
  
  private b(String paramString, int paramInt)
  {
    this.iqJ = paramString;
    this.scene = paramInt;
  }
  
  static WeAppOpenDeclarePromptBundle L(Bundle paramBundle)
  {
    AppMethodBeat.i(222808);
    if (paramBundle == null)
    {
      AppMethodBeat.o(222808);
      return null;
    }
    paramBundle = (WeAppOpenDeclarePromptBundle)paramBundle.getParcelable("weapp_open_declare_prompt_key");
    AppMethodBeat.o(222808);
    return paramBundle;
  }
  
  static String bsE()
  {
    return "";
  }
  
  static String bsF()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.b
 * JD-Core Version:    0.7.0.1
 */