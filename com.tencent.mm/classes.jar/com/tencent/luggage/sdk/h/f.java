package com.tencent.luggage.sdk.h;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/WebkitUtils;", "", "()V", "println", "", "Landroid/webkit/ConsoleMessage;", "tag", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f evP;
  
  static
  {
    AppMethodBeat.i(176453);
    evP = new f();
    AppMethodBeat.o(176453);
  }
  
  public static final void a(ConsoleMessage paramConsoleMessage, String paramString)
  {
    AppMethodBeat.i(176452);
    s.u(paramString, "tag");
    ConsoleMessage.MessageLevel localMessageLevel;
    if (paramConsoleMessage == null)
    {
      localMessageLevel = null;
      label17:
      if (localMessageLevel != null) {
        break label91;
      }
    }
    label91:
    for (int i = -1;; i = a.$EnumSwitchMapping$0[localMessageLevel.ordinal()]) {
      switch (i)
      {
      case 0: 
      default: 
        paramConsoleMessage = new p();
        AppMethodBeat.o(176452);
        throw paramConsoleMessage;
        localMessageLevel = paramConsoleMessage.messageLevel();
        break label17;
      }
    }
    AppMethodBeat.o(176452);
    return;
    i = 3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.f
 * JD-Core Version:    0.7.0.1
 */