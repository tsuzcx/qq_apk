package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements g
{
  public static f owy;
  private final String TAG;
  public Map<l, a> mYy;
  
  public f()
  {
    AppMethodBeat.i(63782);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.mYy = new HashMap();
    AppMethodBeat.o(63782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63783);
    a locala;
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      locala = (a)this.mYy.get(paramn);
      if (locala == null)
      {
        ac.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(63783);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.oxc);
    }
    for (;;)
    {
      this.mYy.remove(paramn);
      AppMethodBeat.o(63783);
      return;
      label91:
      ac.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.oxc);
    }
  }
  
  public static abstract interface a
  {
    public abstract void J(String paramString1, String paramString2, int paramInt);
    
    public abstract void a(boolean paramBoolean, sr paramsr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */