package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class o$b<T extends q>
{
  public long jdI;
  public T jdJ;
  
  public final boolean execute()
  {
    AppMethodBeat.i(225961);
    if (this.jdJ == null) {
      Log.e("SendMsgCgiFactory", "[execute] cgi is null. %s", new Object[] { Util.getStack() });
    }
    Objects.requireNonNull(this.jdJ);
    boolean bool = aa.iNn.azA().a(this.jdJ, 0);
    AppMethodBeat.o(225961);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.b
 * JD-Core Version:    0.7.0.1
 */