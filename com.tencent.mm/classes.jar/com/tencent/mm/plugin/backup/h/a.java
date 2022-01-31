package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

public final class a
{
  public ak handler;
  LinkedList<a.a> jGk;
  
  public a()
  {
    AppMethodBeat.i(17685);
    this.jGk = new LinkedList();
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(17685);
  }
  
  public final boolean h(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(17686);
    this.handler.post(new a.1(this, paramInt, paramObject));
    AppMethodBeat.o(17686);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a
 * JD-Core Version:    0.7.0.1
 */