package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class d
{
  public static boolean bbM()
  {
    if (au.DK())
    {
      if (g.AA().getInt("WCOEntranceSwitch", 0) > 0)
      {
        au.Hx();
        c.Dz().c(ac.a.uqp, Boolean.valueOf(true));
        return true;
      }
      au.Hx();
      c.Dz().c(ac.a.uqp, Boolean.valueOf(false));
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.d
 * JD-Core Version:    0.7.0.1
 */