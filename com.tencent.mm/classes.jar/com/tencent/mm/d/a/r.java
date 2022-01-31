package com.tencent.mm.d.a;

import android.os.HandlerThread;
import android.util.SparseArray;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class r
  extends n
{
  int ccd;
  final SparseArray<r.b> cce;
  volatile al ccf;
  private final boolean ccg;
  
  r()
  {
    AppMethodBeat.i(113882);
    this.ccd = 0;
    this.cce = new SparseArray();
    this.ccf = null;
    this.ccg = false;
    AppMethodBeat.o(113882);
  }
  
  static int dP(String paramString)
  {
    AppMethodBeat.i(113883);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(113883);
        return -2147483648;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(113883);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", paramString, "", new Object[0]);
      AppMethodBeat.o(113883);
    }
    return -2147483648;
  }
  
  protected final void a(l paraml, V8Object paramV8Object)
  {
    AppMethodBeat.i(113884);
    if (!(paraml.cbC instanceof b)) {
      this.ccf = new al("MicroMsg.J2V8.V8DirectApiTimer");
    }
    paramV8Object.registerJavaMethod(new r.1(this, paraml), "setTimeout");
    paramV8Object.registerJavaMethod(new r.2(this, paraml), "setInterval");
    paramV8Object.registerJavaMethod(new r.3(this), "clearTimeout");
    paramV8Object.registerJavaMethod(new r.4(this), "clearInterval");
    AppMethodBeat.o(113884);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(113885);
    int i = 0;
    while (i < this.cce.size())
    {
      ((r.b)this.cce.valueAt(i)).cancel();
      i += 1;
    }
    this.cce.clear();
    al localal = this.ccf;
    if (localal != null)
    {
      localal.oNc.quit();
      this.ccf = null;
    }
    AppMethodBeat.o(113885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.r
 * JD-Core Version:    0.7.0.1
 */