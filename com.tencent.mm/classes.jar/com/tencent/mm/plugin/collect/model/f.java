package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements i
{
  public static f qvI;
  private final String TAG;
  public Map<l, a> oPn;
  
  public f()
  {
    AppMethodBeat.i(63782);
    this.TAG = "MicroMsg.F2fGetPayUrlManager";
    this.oPn = new HashMap();
    AppMethodBeat.o(63782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63783);
    a locala;
    if ((paramq instanceof l))
    {
      paramString = (l)paramq;
      locala = (a)this.oPn.get(paramq);
      if (locala == null)
      {
        Log.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
        AppMethodBeat.o(63783);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label91;
      }
      locala.a(true, paramString.qwk);
    }
    for (;;)
    {
      this.oPn.remove(paramq);
      AppMethodBeat.o(63783);
      return;
      label91:
      Log.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, paramString.qwk);
    }
  }
  
  public static abstract interface a
  {
    public abstract void J(String paramString1, String paramString2, int paramInt);
    
    public abstract void a(boolean paramBoolean, vv paramvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.f
 * JD-Core Version:    0.7.0.1
 */