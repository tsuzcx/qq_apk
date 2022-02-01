package com.tencent.luggage.sdk.g;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import d.g.b.p;
import d.l;
import d.m;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/wxa_ktx/WebkitUtils;", "", "()V", "println", "", "Landroid/webkit/ConsoleMessage;", "tag", "", "luggage-wxa-app_release"})
public final class e
{
  public static final e cpP;
  
  static
  {
    AppMethodBeat.i(176453);
    cpP = new e();
    AppMethodBeat.o(176453);
  }
  
  public static final void a(ConsoleMessage paramConsoleMessage, String paramString)
  {
    AppMethodBeat.i(176452);
    p.h(paramString, "tag");
    if (paramConsoleMessage != null) {}
    for (ConsoleMessage.MessageLevel localMessageLevel = paramConsoleMessage.messageLevel(); localMessageLevel == null; localMessageLevel = null)
    {
      AppMethodBeat.o(176452);
      return;
    }
    int i;
    switch (f.cpQ[localMessageLevel.ordinal()])
    {
    default: 
      paramConsoleMessage = new m();
      AppMethodBeat.o(176452);
      throw paramConsoleMessage;
    case 1: 
    case 2: 
    case 3: 
      i = 3;
    }
    for (;;)
    {
      Log.println(i, paramString, "ConsoleMessage: message:" + paramConsoleMessage.message() + ", sourceId:" + paramConsoleMessage.sourceId() + ", lineNumber:" + paramConsoleMessage.lineNumber());
      AppMethodBeat.o(176452);
      return;
      i = 5;
      continue;
      i = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.e
 * JD-Core Version:    0.7.0.1
 */