package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.y;

final class j$1
  extends m
{
  j$1(j paramj) {}
  
  protected final boolean WH()
  {
    boolean bool = true;
    if ((j.a(this.lsQ) == null) || (j.a(this.lsQ).csp())) {
      if (j.a(this.lsQ) != null) {
        break label59;
      }
    }
    label59:
    for (Object localObject = "null";; localObject = Boolean.valueOf(j.a(this.lsQ).csp()))
    {
      y.w("MicroMsg.IPCallPopularCountryStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.j.1
 * JD-Core Version:    0.7.0.1
 */