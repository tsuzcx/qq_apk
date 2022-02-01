package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> wQK;
  boolean wQL;
  ArrayList<b> wQM;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.wQK = new ArrayList();
    this.wQL = false;
    this.wQM = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d aAy(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.wQK.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.fEd.fEa.equals(paramString))
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
    Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.wQK.clear();
    Iterator localIterator = this.wQM.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  public final void dlU()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.wQM.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).dlW();
    }
    AppMethodBeat.o(107395);
  }
  
  static final class a
  {
    private static final e wQN;
    
    static
    {
      AppMethodBeat.i(107391);
      wQN = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dlW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */