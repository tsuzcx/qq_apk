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
  private static c mxL;
  private a mxM;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.mxs == null) {
      a.mxs = new a();
    }
    this.mxM = a.mxs;
    AppMethodBeat.o(150086);
  }
  
  private static c aYn()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (mxL == null)
      {
        localc = new c();
        mxL = localc;
        localc.mxM.init();
      }
      c localc = mxL;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a aYo()
  {
    AppMethodBeat.i(150090);
    h.baC().aZJ();
    a locala = aYn().mxM;
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
    this.mxM.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.mxM;
    locala.listeners.clear();
    b localb = locala.mxt;
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.mxB.clear();
    localb.mxD.clear();
    localb.mxC.clear();
    localb.mxE.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.aa.c
 * JD-Core Version:    0.7.0.1
 */