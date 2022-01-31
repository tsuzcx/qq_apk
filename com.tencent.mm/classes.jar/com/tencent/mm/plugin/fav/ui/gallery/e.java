package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> mCl;
  boolean mCm;
  ArrayList<e.b> mCn;
  
  private e()
  {
    AppMethodBeat.i(74561);
    this.mCl = new ArrayList();
    this.mCm = false;
    this.mCn = new ArrayList();
    AppMethodBeat.o(74561);
  }
  
  public final d Oe(String paramString)
  {
    AppMethodBeat.i(74562);
    Iterator localIterator = this.mCl.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.cuZ.mBq.equals(paramString))
      {
        AppMethodBeat.o(74562);
        return locald;
      }
    }
    AppMethodBeat.o(74562);
    return null;
  }
  
  public final void byl()
  {
    AppMethodBeat.i(74564);
    Iterator localIterator = this.mCn.iterator();
    while (localIterator.hasNext()) {
      ((e.b)localIterator.next()).byn();
    }
    AppMethodBeat.o(74564);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(74563);
    ab.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.mCl.clear();
    Iterator localIterator = this.mCn.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(74563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */