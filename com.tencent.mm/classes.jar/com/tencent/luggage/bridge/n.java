package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

final class n
{
  private o csD;
  private MMHandler csE;
  
  n(o paramo)
  {
    AppMethodBeat.i(140332);
    this.csD = paramo;
    this.csE = new MMHandler("Js2JavaAsyncHandler_" + this.csD.hashCode());
    AppMethodBeat.o(140332);
  }
  
  private static m cM(String paramString)
  {
    AppMethodBeat.i(140335);
    try
    {
      paramString = new m(new JSONObject(paramString));
      AppMethodBeat.o(140335);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(140335);
    }
    return null;
  }
  
  final String i(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140333);
    if (paramBoolean)
    {
      paramString = j(paramString, true);
      AppMethodBeat.o(140333);
      return paramString;
    }
    this.csE.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140330);
        n.this.j(paramString, false);
        AppMethodBeat.o(140330);
      }
    });
    AppMethodBeat.o(140333);
    return "";
  }
  
  final String j(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140334);
    Object localObject = cM(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(140334);
      return "";
    }
    Log.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", new Object[] { ((m)localObject).KW().name() });
    paramString = null;
    switch (2.csG[localObject.KW().ordinal()])
    {
    default: 
      if (paramString != null) {
        break;
      }
    }
    for (localObject = "null";; localObject = paramString.KW().name())
    {
      Log.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", new Object[] { localObject });
      if (paramString != null) {
        break label181;
      }
      AppMethodBeat.o(140334);
      return "";
      this.csD.csJ.KY();
      break;
      paramString = this.csD.a((m)localObject, paramBoolean);
      break;
      this.csD.a((m)localObject);
      break;
      this.csD.b((m)localObject);
      break;
    }
    label181:
    paramString = paramString.toString();
    AppMethodBeat.o(140334);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.n
 * JD-Core Version:    0.7.0.1
 */