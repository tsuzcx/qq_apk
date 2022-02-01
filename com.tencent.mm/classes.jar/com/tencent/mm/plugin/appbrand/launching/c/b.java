package com.tencent.mm.plugin.appbrand.launching.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;

 enum b
{
  final String prefix;
  final int scene;
  
  static
  {
    AppMethodBeat.i(47409);
    pYN = new b("WALLET", 0, "weapp://wallet/", 1019);
    pYO = new b("SEARCH_NATIVE_FEATURE", 1, "weapp://search/", 1005);
    pYP = new b[] { pYN, pYO };
    AppMethodBeat.o(47409);
  }
  
  private b(String paramString, int paramInt)
  {
    this.prefix = paramString;
    this.scene = paramInt;
  }
  
  static WeAppOpenDeclarePromptBundle T(Bundle paramBundle)
  {
    AppMethodBeat.i(275072);
    if (paramBundle == null)
    {
      AppMethodBeat.o(275072);
      return null;
    }
    paramBundle = (WeAppOpenDeclarePromptBundle)paramBundle.getParcelable("weapp_open_declare_prompt_key");
    AppMethodBeat.o(275072);
    return paramBundle;
  }
  
  static String cau()
  {
    return "";
  }
  
  static String cav()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.b
 * JD-Core Version:    0.7.0.1
 */