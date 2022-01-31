package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.plugin.fts.a.d.e;
import java.util.Iterator;
import java.util.List;

final class j$a
  implements Runnable
{
  private String bVk;
  private e kBH;
  
  j$a(j paramj, e parame, String paramString)
  {
    this.bVk = paramString;
    this.kBH = parame;
  }
  
  public final void run()
  {
    if ((!j.a(this.kBG)) && (((e)j.b(this.kBG).get(j.b(this.kBG).size() - 1)).getType() == this.kBH.getType())) {
      j.c(this.kBG);
    }
    Iterator localIterator = j.b(this.kBG).iterator();
    for (int i = 0; localIterator.hasNext(); i = ((e)localIterator.next()).rx(i)) {}
    this.kBG.setCount(i);
    this.kBG.notifyDataSetChanged();
    this.kBG.N(i, j.d(this.kBG));
    if (j.d(this.kBG)) {
      j.e(this.kBG).kDV = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j.a
 * JD-Core Version:    0.7.0.1
 */