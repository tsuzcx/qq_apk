package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> rCx;
  boolean rCy;
  ArrayList<b> rCz;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.rCx = new ArrayList();
    this.rCy = false;
    this.rCz = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d agQ(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.rCx.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.dsX.dsU.equals(paramString))
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
    ad.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.rCx.clear();
    Iterator localIterator = this.rCz.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  public final void cxi()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.rCz.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cxk();
    }
    AppMethodBeat.o(107395);
  }
  
  static final class a
  {
    private static final e rCA;
    
    static
    {
      AppMethodBeat.i(107391);
      rCA = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cxk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */