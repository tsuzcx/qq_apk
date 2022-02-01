package com.tencent.mm.plugin.datareport.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
{
  public c xgV;
  public c xgW;
  public Map<String, c> xgX;
  public int xgY;
  
  public d()
  {
    AppMethodBeat.i(262871);
    this.xgX = new HashMap();
    this.xgY = 0;
    AppMethodBeat.o(262871);
  }
  
  public final List<c> dtu()
  {
    AppMethodBeat.i(262878);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xgX.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((c)localIterator.next());
    }
    AppMethodBeat.o(262878);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.c.d
 * JD-Core Version:    0.7.0.1
 */