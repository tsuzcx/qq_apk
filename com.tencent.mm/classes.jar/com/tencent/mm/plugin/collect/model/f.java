package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements com.tencent.mm.ai.f
{
  public static f kMS;
  private final String TAG;
  public Map<l, f.a> jFd;
  
  public f()
  {
    AppMethodBeat.i(40932);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.jFd = new HashMap();
    AppMethodBeat.o(40932);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40933);
    f.a locala;
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      locala = (f.a)this.jFd.get(paramm);
      if (locala == null)
      {
        ab.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(40933);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.kNu);
    }
    for (;;)
    {
      this.jFd.remove(paramm);
      AppMethodBeat.o(40933);
      return;
      label91:
      ab.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.kNu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */