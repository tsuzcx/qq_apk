package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> tkt;
  boolean tku;
  ArrayList<b> tkv;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.tkt = new ArrayList();
    this.tku = false;
    this.tkv = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d asv(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.tkt.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.dLo.dLl.equals(paramString))
      {
        AppMethodBeat.o(107393);
        return locald;
      }
    }
    AppMethodBeat.o(107393);
    return null;
  }
  
  public final void cWM()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.tkv.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cWO();
    }
    AppMethodBeat.o(107395);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(107394);
    Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.tkt.clear();
    Iterator localIterator = this.tkv.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  static final class a
  {
    private static final e tkw;
    
    static
    {
      AppMethodBeat.i(107391);
      tkw = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cWO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */