package com.tencent.luggage.bridge;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class n
{
  private o byf;
  private Handler byg;
  
  n(o paramo)
  {
    AppMethodBeat.i(90732);
    this.byf = paramo;
    paramo = new HandlerThread("AsyncJSThread");
    paramo.start();
    this.byg = new Handler(paramo.getLooper());
    AppMethodBeat.o(90732);
  }
  
  private static m bv(String paramString)
  {
    AppMethodBeat.i(90735);
    try
    {
      paramString = new m(new JSONObject(paramString));
      AppMethodBeat.o(90735);
      return paramString;
    }
    catch (Exception paramString)
    {
      d.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(90735);
    }
    return null;
  }
  
  final String i(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90733);
    if (paramBoolean)
    {
      paramString = j(paramString, true);
      AppMethodBeat.o(90733);
      return paramString;
    }
    this.byg.post(new n.1(this, paramString));
    AppMethodBeat.o(90733);
    return "";
  }
  
  final String j(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90734);
    Object localObject = bv(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(90734);
      return "";
    }
    d.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", new Object[] { ((m)localObject).tR().name() });
    paramString = null;
    switch (n.2.byj[localObject.tR().ordinal()])
    {
    default: 
      if (paramString != null) {
        break;
      }
    }
    for (localObject = "null";; localObject = paramString.tR().name())
    {
      d.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", new Object[] { localObject });
      if (paramString != null) {
        break label181;
      }
      AppMethodBeat.o(90734);
      return "";
      this.byf.bym.tT();
      break;
      paramString = this.byf.a((m)localObject, paramBoolean);
      break;
      this.byf.a((m)localObject);
      break;
      this.byf.b((m)localObject);
      break;
    }
    label181:
    paramString = paramString.toString();
    AppMethodBeat.o(90734);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.n
 * JD-Core Version:    0.7.0.1
 */