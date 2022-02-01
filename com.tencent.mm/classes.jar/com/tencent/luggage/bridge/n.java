package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

final class n
{
  private o cqI;
  private MMHandler cqJ;
  
  n(o paramo)
  {
    AppMethodBeat.i(140332);
    this.cqI = paramo;
    this.cqJ = new MMHandler("Js2JavaAsyncHandler_" + this.cqI.hashCode());
    AppMethodBeat.o(140332);
  }
  
  private static m dg(String paramString)
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
  
  final String j(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140333);
    if (paramBoolean)
    {
      paramString = k(paramString, true);
      AppMethodBeat.o(140333);
      return paramString;
    }
    this.cqJ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140330);
        n.this.k(paramString, false);
        AppMethodBeat.o(140330);
      }
    });
    AppMethodBeat.o(140333);
    return "";
  }
  
  final String k(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140334);
    Object localObject = dg(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(140334);
      return "";
    }
    Log.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", new Object[] { ((m)localObject).NM().name() });
    paramString = null;
    switch (2.cqL[localObject.NM().ordinal()])
    {
    default: 
      if (paramString != null) {
        break;
      }
    }
    for (localObject = "null";; localObject = paramString.NM().name())
    {
      Log.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", new Object[] { localObject });
      if (paramString != null) {
        break label181;
      }
      AppMethodBeat.o(140334);
      return "";
      this.cqI.cqO.NO();
      break;
      paramString = this.cqI.a((m)localObject, paramBoolean);
      break;
      this.cqI.a((m)localObject);
      break;
      this.cqI.b((m)localObject);
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