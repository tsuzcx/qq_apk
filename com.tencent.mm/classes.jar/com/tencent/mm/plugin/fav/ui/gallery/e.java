package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> qSv;
  boolean qSw;
  ArrayList<b> qSx;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.qSv = new ArrayList();
    this.qSw = false;
    this.qSx = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d adb(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.qSv.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.dhz.dhw.equals(paramString))
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
    ac.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.qSv.clear();
    Iterator localIterator = this.qSx.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  public final void crw()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.qSx.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cry();
    }
    AppMethodBeat.o(107395);
  }
  
  static final class a
  {
    private static final e qSy;
    
    static
    {
      AppMethodBeat.i(107391);
      qSy = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cry();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */