package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
{
  ArrayList<d> khB = new ArrayList();
  boolean khC = false;
  ArrayList<e.b> khD = new ArrayList();
  
  public final d Dc(String paramString)
  {
    Iterator localIterator = this.khB.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.bNH.kgC.equals(paramString)) {
        return locald;
      }
    }
    return null;
  }
  
  public final void aRS()
  {
    Iterator localIterator = this.khD.iterator();
    while (localIterator.hasNext()) {
      ((e.b)localIterator.next()).aRU();
    }
  }
  
  public final void clear()
  {
    y.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.khB.clear();
    Iterator localIterator = this.khD.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.e
 * JD-Core Version:    0.7.0.1
 */