package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

public final class a
{
  ak handler;
  public LinkedList<a.a> jGk;
  
  public a()
  {
    AppMethodBeat.i(18000);
    this.jGk = new LinkedList();
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(18000);
  }
  
  public final boolean h(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(18001);
    this.handler.post(new a.1(this, paramInt, paramObject));
    AppMethodBeat.o(18001);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.a
 * JD-Core Version:    0.7.0.1
 */