package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.y;

public final class m
{
  public static void run()
  {
    int i = g.AA().getInt("EnableFlockMultiProcSPProb", 0);
    au.Hx();
    int j = h.aT(c.CK(), 101);
    if ((b.cqk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      ap.a.setValue(ap.a.ugL, bool);
      y.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.m
 * JD-Core Version:    0.7.0.1
 */