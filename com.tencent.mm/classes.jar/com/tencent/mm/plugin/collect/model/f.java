package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements com.tencent.mm.al.f
{
  public static f oZT;
  private final String TAG;
  public Map<l, a> nyV;
  
  public f()
  {
    AppMethodBeat.i(63782);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.nyV = new HashMap();
    AppMethodBeat.o(63782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63783);
    a locala;
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      locala = (a)this.nyV.get(paramn);
      if (locala == null)
      {
        ad.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(63783);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.pax);
    }
    for (;;)
    {
      this.nyV.remove(paramn);
      AppMethodBeat.o(63783);
      return;
      label91:
      ad.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.pax);
    }
  }
  
  public static abstract interface a
  {
    public abstract void K(String paramString1, String paramString2, int paramInt);
    
    public abstract void a(boolean paramBoolean, um paramum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */