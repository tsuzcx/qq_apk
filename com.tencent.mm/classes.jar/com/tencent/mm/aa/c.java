package com.tencent.mm.aa;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements be
{
  private static c jXR;
  private a jXS;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.jXy == null) {
      a.jXy = new a();
    }
    this.jXS = a.jXy;
    AppMethodBeat.o(150086);
  }
  
  private static c aFm()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (jXR == null)
      {
        localc = new c();
        jXR = localc;
        localc.jXS.init();
      }
      c localc = jXR;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a aFn()
  {
    AppMethodBeat.i(150090);
    h.aHE().aGH();
    a locala = aFm().jXS;
    AppMethodBeat.o(150090);
    return locala;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150089);
    this.jXS.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.jXS;
    locala.listeners.clear();
    b localb = locala.jXz;
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.jXH.clear();
    localb.jXJ.clear();
    localb.jXI.clear();
    localb.jXK.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.c
 * JD-Core Version:    0.7.0.1
 */