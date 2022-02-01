package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> qjT;
  boolean qjU;
  ArrayList<b> qjV;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.qjT = new ArrayList();
    this.qjU = false;
    this.qjV = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d YF(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.qjT.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.dke.dkb.equals(paramString))
      {
        AppMethodBeat.o(107393);
        return locald;
      }
    }
    AppMethodBeat.o(107393);
    return null;
  }
  
  public final void cjP()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.qjV.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cjR();
    }
    AppMethodBeat.o(107395);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(107394);
    ad.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.qjT.clear();
    Iterator localIterator = this.qjV.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  static final class a
  {
    private static final e qjW;
    
    static
    {
      AppMethodBeat.i(107391);
      qjW = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cjR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */