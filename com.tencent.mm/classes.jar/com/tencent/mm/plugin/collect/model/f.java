package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements h
{
  public static f wYd;
  private final String TAG;
  public Map<k, a> vcA;
  
  public f()
  {
    AppMethodBeat.i(63782);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.vcA = new HashMap();
    AppMethodBeat.o(63782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63783);
    a locala;
    if ((paramp instanceof k))
    {
      paramString = (k)paramp;
      locala = (a)this.vcA.get(paramp);
      if (locala == null)
      {
        Log.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(63783);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.wYF);
    }
    for (;;)
    {
      this.vcA.remove(paramp);
      AppMethodBeat.o(63783);
      return;
      label91:
      Log.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.wYF);
    }
  }
  
  public static abstract interface a
  {
    public abstract void U(String paramString1, String paramString2, int paramInt);
    
    public abstract void a(boolean paramBoolean, xp paramxp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */