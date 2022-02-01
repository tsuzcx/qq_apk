package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> rKI;
  boolean rKJ;
  ArrayList<b> rKK;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.rKI = new ArrayList();
    this.rKJ = false;
    this.rKK = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d ahN(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.rKI.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.dud.dua.equals(paramString))
      {
        AppMethodBeat.o(107393);
        return locald;
      }
    }
    AppMethodBeat.o(107393);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(107394);
    ae.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.rKI.clear();
    Iterator localIterator = this.rKK.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  public final void cyJ()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.rKK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cyL();
    }
    AppMethodBeat.o(107395);
  }
  
  static final class a
  {
    private static final e rKL;
    
    static
    {
      AppMethodBeat.i(107391);
      rKL = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cyL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */