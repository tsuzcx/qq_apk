package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b
  implements at
{
  private a jys;
  
  public b()
  {
    AppMethodBeat.i(17106);
    this.jys = new a();
    AppMethodBeat.o(17106);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(17107);
    ab.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
    a locala = this.jys;
    com.tencent.mm.sdk.b.a.ymk.c(locala.jyq);
    AppMethodBeat.o(17107);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(17108);
    ab.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
    a locala = this.jys;
    com.tencent.mm.sdk.b.a.ymk.d(locala.jyq);
    AppMethodBeat.o(17108);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */