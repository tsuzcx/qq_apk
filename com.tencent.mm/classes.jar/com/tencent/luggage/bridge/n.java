package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

final class n
{
  private o cgI;
  private aq cgJ;
  
  n(o paramo)
  {
    AppMethodBeat.i(140332);
    this.cgI = paramo;
    this.cgJ = new aq("Js2JavaAsyncHandler_" + this.cgI.hashCode());
    AppMethodBeat.o(140332);
  }
  
  private static m cv(String paramString)
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
      ae.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", new Object[] { paramString.getMessage() });
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
    this.cgJ.post(new Runnable()
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
    Object localObject = cv(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(140334);
      return "";
    }
    ae.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", new Object[] { ((m)localObject).BH().name() });
    paramString = null;
    switch (2.cgL[localObject.BH().ordinal()])
    {
    default: 
      if (paramString != null) {
        break;
      }
    }
    for (localObject = "null";; localObject = paramString.BH().name())
    {
      ae.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", new Object[] { localObject });
      if (paramString != null) {
        break label181;
      }
      AppMethodBeat.o(140334);
      return "";
      this.cgI.cgO.BJ();
      break;
      paramString = this.cgI.a((m)localObject, paramBoolean);
      break;
      this.cgI.a((m)localObject);
      break;
      this.cgI.b((m)localObject);
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