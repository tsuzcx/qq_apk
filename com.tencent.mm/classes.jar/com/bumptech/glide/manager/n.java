package com.bumptech.glide.manager;

import com.bumptech.glide.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class n
{
  public final Set<c> aMG;
  public final List<c> aMH;
  public boolean isPaused;
  
  public n()
  {
    AppMethodBeat.i(77577);
    this.aMG = Collections.newSetFromMap(new WeakHashMap());
    this.aMH = new ArrayList();
    AppMethodBeat.o(77577);
  }
  
  public final boolean a(c paramc, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(77578);
    if (paramc == null)
    {
      AppMethodBeat.o(77578);
      return true;
    }
    boolean bool3 = this.aMG.remove(paramc);
    boolean bool1 = bool2;
    if (!this.aMH.remove(paramc)) {
      if (!bool3) {
        break label82;
      }
    }
    label82:
    for (bool1 = bool2;; bool1 = false)
    {
      if (bool1)
      {
        paramc.clear();
        if (paramBoolean) {
          paramc.recycle();
        }
      }
      AppMethodBeat.o(77578);
      return bool1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77579);
    String str = super.toString() + "{numRequests=" + this.aMG.size() + ", isPaused=" + this.isPaused + "}";
    AppMethodBeat.o(77579);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.n
 * JD-Core Version:    0.7.0.1
 */