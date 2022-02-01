package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> Ann;
  boolean Ano;
  ArrayList<b> Anp;
  
  private e()
  {
    AppMethodBeat.i(107392);
    this.Ann = new ArrayList();
    this.Ano = false;
    this.Anp = new ArrayList();
    AppMethodBeat.o(107392);
  }
  
  public final d auG(String paramString)
  {
    AppMethodBeat.i(107393);
    Iterator localIterator = this.Ann.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.hIT.hIQ.equals(paramString))
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
    this.Ann.clear();
    Iterator localIterator = this.Anp.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(107394);
  }
  
  public final void dSK()
  {
    AppMethodBeat.i(107395);
    Iterator localIterator = this.Anp.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).dSM();
    }
    AppMethodBeat.o(107395);
  }
  
  static final class a
  {
    private static final e Anq;
    
    static
    {
      AppMethodBeat.i(107391);
      Anq = new e((byte)0);
      AppMethodBeat.o(107391);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dSM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */