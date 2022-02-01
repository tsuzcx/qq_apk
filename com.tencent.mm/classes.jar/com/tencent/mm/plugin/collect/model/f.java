package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements g
{
  public static f nTd;
  private final String TAG;
  public Map<l, a> mwx;
  
  public f()
  {
    AppMethodBeat.i(63782);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.mwx = new HashMap();
    AppMethodBeat.o(63782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63783);
    a locala;
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      locala = (a)this.mwx.get(paramn);
      if (locala == null)
      {
        ad.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(63783);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.nTH);
    }
    for (;;)
    {
      this.mwx.remove(paramn);
      AppMethodBeat.o(63783);
      return;
      label91:
      ad.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.nTH);
    }
  }
  
  public static abstract interface a
  {
    public abstract void I(String paramString1, String paramString2, int paramInt);
    
    public abstract void a(boolean paramBoolean, sh paramsh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */